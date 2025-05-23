package com.tencent.tav.decoder;

import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.ExportRuntimeException;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.IDecoder;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.IVideoDecoder;
import com.tencent.tav.decoder.factory.AVDecoderFactory;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.ExtractorUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class VideoDecoderTrack implements IDecoderTrack {
    public static boolean DELAY_RELEASE_DECODER_ON_PLAY_FINISH = true;
    public static boolean PRE_READ = true;
    private static String TAG = "VDecoderTrack";
    private Surface _outputSurface;
    private float _speed;

    @Nullable
    private IVideoDecoder currentDecoder;
    private final Object currentDecoderLock;
    private CMSampleBuffer currentFrame;
    private CMTime currentSegmentStartTime;
    private DecoderCreateThread decoderCreateThread;
    private final DecoderThread decoderThread;
    private IVideoDecoder delayReleaseDecoder;
    private CMTime duration;
    private int index;
    private boolean isReleased;
    private CMSampleState lastSampleState;
    private DecoderWrapper nextDecoder;
    private final Object nextDecoderLock;
    private CMSampleBuffer nextFrame;
    private final Object nextFrameDecoderLock;
    private boolean started;
    private IDecoderTrack.SurfaceCreator surfaceCreator;
    private int trackId;
    private CMTime frameDuration = new CMTime(1, 44);
    private int frameRate = 44;
    private ArrayList<DecoderTrackSegment> segments = new ArrayList<>();
    private IDecoder.DecodeType decodeType = IDecoder.DecodeType.Video;
    private int segmentIndex = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class DecoderCreateThread extends BaseThread {
        private Surface outputSurface;
        private int segmentIndex;
        DecoderAssetTrack videoAsset;

        private void checkCreateDecoder() {
            if (VideoDecoderTrack.this.nextDecoder != null && ExtractorUtils.isSameExtractor(VideoDecoderTrack.this.nextDecoder.extractor, this.videoAsset)) {
                return;
            }
            if (VideoDecoderTrack.this.nextDecoder != null) {
                Logger.d(VideoDecoderTrack.TAG, "DecoderCreateThread create - " + this.videoAsset.assetPath);
                if (VideoDecoderTrack.this.nextDecoder.decoder != null && VideoDecoderTrack.this.nextDecoder.decoder != VideoDecoderTrack.this.currentDecoder) {
                    releaseNextDecoder();
                }
                createDecoder();
                return;
            }
            createDecoder();
        }

        private void createDecoder() {
            IVideoDecoder iVideoDecoder;
            Exception e16;
            if (VideoDecoderTrack.this.segments != null && this.segmentIndex < VideoDecoderTrack.this.segments.size()) {
                try {
                    Surface surface = this.outputSurface;
                    IVideoDecoder.Params newDecoderParams = VideoDecoderTrack.this.newDecoderParams(this.videoAsset, surface);
                    VideoDecoderTrack videoDecoderTrack = VideoDecoderTrack.this;
                    iVideoDecoder = videoDecoderTrack.createVideoDecoder(newDecoderParams, videoDecoderTrack.getSegment(this.segmentIndex));
                    try {
                        if (newDecoderParams.sourceType == 3) {
                            VideoDecoderTrack.this.free(surface);
                        }
                        if (iVideoDecoder != null) {
                            iVideoDecoder.start(VideoDecoderTrack.this.getSegment(this.segmentIndex).getTimeRange(), VideoDecoderTrack.this.getSegment(this.segmentIndex).getDecoderStartTime());
                            VideoDecoderTrack videoDecoderTrack2 = VideoDecoderTrack.this;
                            videoDecoderTrack2.nextDecoder = new DecoderWrapper();
                            VideoDecoderTrack.this.nextDecoder.outputSurface = surface;
                            VideoDecoderTrack.this.nextDecoder.decoder = iVideoDecoder;
                            VideoDecoderTrack.this.nextDecoder.extractor = this.videoAsset;
                            VideoDecoderTrack.this.nextDecoder.segmentIndex = this.segmentIndex;
                            Logger.d(VideoDecoderTrack.TAG, "DecoderCreateThread success - " + this.videoAsset.assetPath);
                        }
                    } catch (Exception e17) {
                        e16 = e17;
                        Logger.e(VideoDecoderTrack.TAG, "createDecoder: ", e16);
                        VideoDecoderTrack.this.tryReleaseDecoder(iVideoDecoder);
                    }
                } catch (Exception e18) {
                    iVideoDecoder = null;
                    e16 = e18;
                }
            }
        }

        private void releaseNextDecoder() {
            synchronized (VideoDecoderTrack.this.nextDecoderLock) {
                if (VideoDecoderTrack.this.nextDecoder != null) {
                    VideoDecoderTrack.this.nextDecoder.release();
                    VideoDecoderTrack.this.nextDecoder = null;
                }
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            boolean z16;
            String str = VideoDecoderTrack.TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("DecoderCreateThread start - ");
            sb5.append(this.videoAsset.assetPath);
            sb5.append(" - ");
            if (this.outputSurface != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            Logger.d(str, sb5.toString());
            synchronized (VideoDecoderTrack.this) {
                if (VideoDecoderTrack.this.isReleased) {
                    VideoDecoderTrack.this.decoderCreateThread = null;
                    releaseNextDecoder();
                    return;
                }
                Logger.d(VideoDecoderTrack.TAG, "DecoderCreateThread will checkCreateDecoder - " + this.videoAsset.assetPath);
                synchronized (VideoDecoderTrack.this.nextDecoderLock) {
                    checkCreateDecoder();
                }
                VideoDecoderTrack.this.decoderCreateThread = null;
                Logger.d(VideoDecoderTrack.TAG, "DecoderCreateThread finish - " + this.videoAsset.assetPath);
            }
        }

        DecoderCreateThread(DecoderAssetTrack decoderAssetTrack, Surface surface, int i3) {
            super("DecoderCreateThread " + decoderAssetTrack.assetPath);
            this.videoAsset = decoderAssetTrack;
            this.outputSurface = surface;
            this.segmentIndex = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class DecoderThread extends ReActionThread {
        private static final String NAME = "VideoAsyncDecoderThread";

        private void doActionInDecoderLock() {
            if (VideoDecoderTrack.this.nextFrame == null) {
                return;
            }
            if (VideoDecoderTrack.this.lastSampleState.isInvalid()) {
                VideoDecoderTrack.this.logVerbose("DecoderThread doAction: CMTime.CMTimeZero");
                VideoDecoderTrack videoDecoderTrack = VideoDecoderTrack.this;
                videoDecoderTrack.nextFrame = videoDecoderTrack.doReadSample(CMTime.CMTimeZero, true);
            } else if (VideoDecoderTrack.this.lastSampleState.getStateCode() >= 0) {
                VideoDecoderTrack.this.logVerbose("DecoderThread doAction: lastSampleTime.add(frameDuration) ");
                VideoDecoderTrack videoDecoderTrack2 = VideoDecoderTrack.this;
                videoDecoderTrack2.nextFrame = videoDecoderTrack2.doReadSample(videoDecoderTrack2.nextFrame.getTime(), true);
            }
        }

        @Override // com.tencent.tav.decoder.ReActionThread
        protected void doAction() {
            synchronized (VideoDecoderTrack.this.nextFrameDecoderLock) {
                doActionInDecoderLock();
            }
        }

        DecoderThread() {
            super(NAME);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class DecoderWrapper {
        IVideoDecoder decoder;
        DecoderAssetTrack extractor;
        Surface outputSurface;
        int segmentIndex;

        DecoderWrapper() {
            this.segmentIndex = -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void release() {
            Logger.d(VideoDecoderTrack.TAG, "Video DecoderWrapper release: ");
            VideoDecoderTrack.this.tryReleaseDecoder(this.decoder);
        }
    }

    public VideoDecoderTrack(AssetTrack assetTrack) {
        int nominalFrameRate;
        CMTime cMTime = CMTime.CMTimeZero;
        this.currentSegmentStartTime = cMTime;
        this.lastSampleState = new CMSampleState();
        this.decoderCreateThread = null;
        this.nextDecoderLock = new Object();
        this.currentDecoderLock = new Object();
        this.nextFrameDecoderLock = new Object();
        this.isReleased = false;
        this.nextFrame = null;
        this.currentFrame = null;
        this.duration = cMTime;
        this.decoderThread = new DecoderThread();
        this.surfaceCreator = null;
        this._speed = 1.0f;
        this.started = false;
        this.trackId = assetTrack.getTrackID();
        List segments = assetTrack.getSegments();
        ArrayList arrayList = new ArrayList();
        Iterator it = segments.iterator();
        while (it.hasNext()) {
            arrayList.add(new DecoderTrackSegment(assetTrack, (AssetTrackSegment) it.next()));
        }
        setTrackSegments(arrayList);
        if (getFrameRate() > 0) {
            nominalFrameRate = getFrameRate();
        } else {
            nominalFrameRate = (int) assetTrack.getNominalFrameRate();
        }
        setFrameRate(nominalFrameRate);
        setVolume(assetTrack.getPreferredVolume());
        setDecodeType(IDecoder.DecodeType.Video);
        if (assetTrack.getTimeRange() != null) {
            clipRangeAndClearRange(assetTrack.getTimeRange().m260clone());
        }
    }

    private void checkReleaseDelayDecoder() {
        if (!DELAY_RELEASE_DECODER_ON_PLAY_FINISH || this.delayReleaseDecoder == null) {
            return;
        }
        synchronized (this.currentDecoderLock) {
            final IVideoDecoder iVideoDecoder = this.delayReleaseDecoder;
            this.delayReleaseDecoder = null;
            if (iVideoDecoder instanceof ImageDecoder) {
                iVideoDecoder.release(true);
            } else {
                ThreadPool.execute(new Runnable() { // from class: com.tencent.tav.decoder.VideoDecoderTrack.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoDecoderTrack.this.free(iVideoDecoder.outputSurface());
                        iVideoDecoder.release(true);
                    }
                });
            }
        }
    }

    private void clipRangeAndRemoveRange(CMTimeRange cMTimeRange) {
        if (cMTimeRange != null && cMTimeRange.getDurationUs() > 0 && this.segments.size() != 0) {
            CMTime start = cMTimeRange.getStart();
            CMTime end = cMTimeRange.getEnd();
            int findSegmentIndexAt = findSegmentIndexAt(start, false);
            if (findSegmentIndexAt == -1) {
                return;
            }
            int findSegmentIndexAt2 = findSegmentIndexAt(end, false);
            if (findSegmentIndexAt2 == -1) {
                findSegmentIndexAt2 = this.segments.size() - 1;
            } else if (getSegmentStartTime(findSegmentIndexAt2) == end) {
                findSegmentIndexAt2--;
            }
            CMTime segmentStartTime = getSegmentStartTime(findSegmentIndexAt);
            CMTime segmentStartTime2 = getSegmentStartTime(findSegmentIndexAt2);
            DecoderTrackSegment segment = getSegment(findSegmentIndexAt);
            DecoderTrackSegment segment2 = getSegment(findSegmentIndexAt2);
            if (segment2.getTimeRange().getDurationUs() > 0 && !getSegmentStartTime(findSegmentIndexAt2 + 1).smallThan(cMTimeRange.getEnd())) {
                CMTime sub = cMTimeRange.getEnd().sub(segmentStartTime2);
                segment2.setTimeRange(new CMTimeRange(segment2.getTimeRange().getStart(), sub.divide((((float) segment2.getScaledDuration().getTimeUs()) * 1.0f) / ((float) segment2.getTimeRange().getDurationUs()))));
                segment2.setScaledDuration(sub);
            }
            if (segment.getTimeRange().getDurationUs() > 0) {
                float timeUs = (((float) segment.getScaledDuration().getTimeUs()) * 1.0f) / ((float) segment.getTimeRange().getDurationUs());
                CMTime sub2 = cMTimeRange.getStart().sub(segmentStartTime);
                CMTime divide = sub2.divide(timeUs);
                segment.setTimeRange(new CMTimeRange(segment.getTimeRange().getStart().add(divide), segment.getTimeRange().getDuration().sub(divide)));
                segment.setScaledDuration(segment.getScaledDuration().sub(sub2));
            }
            for (int size = this.segments.size() - 1; size >= 0; size--) {
                if (size > findSegmentIndexAt2 || size < findSegmentIndexAt) {
                    this.segments.remove(size);
                }
            }
            if (getSegmentStartTime(findSegmentIndexAt2 + 1).smallThan(cMTimeRange.getEnd())) {
                this.segments.add(new DecoderTrackSegment(new CMTimeRange(CMTime.CMTimeZero, end.sub(segment2.getScaledDuration().add(segmentStartTime2))), (DecoderAssetTrack) null));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0154 A[Catch: Exception -> 0x0195, all -> 0x01c2, TryCatch #1 {, blocks: (B:3:0x0001, B:9:0x000a, B:12:0x002b, B:15:0x003b, B:17:0x0041, B:19:0x004d, B:21:0x005b, B:22:0x0076, B:46:0x00cf, B:48:0x0150, B:50:0x0154, B:52:0x015a, B:54:0x0166, B:56:0x0170, B:58:0x0177, B:63:0x0196, B:65:0x01b0, B:66:0x01bf, B:72:0x01af, B:76:0x00d0, B:78:0x00ed, B:80:0x00f5, B:82:0x00fb, B:83:0x00fd, B:107:0x014f, B:85:0x00fe, B:87:0x0102, B:89:0x0106, B:92:0x010a, B:94:0x0112, B:95:0x011d, B:98:0x0131, B:99:0x0148, B:103:0x014b, B:24:0x0077, B:26:0x007b, B:28:0x0083, B:31:0x0089, B:33:0x0091, B:34:0x009c, B:37:0x00b0, B:38:0x00c7, B:42:0x00ca, B:68:0x01a3), top: B:2:0x0001, inners: #3, #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0170 A[Catch: Exception -> 0x0192, all -> 0x01c2, TryCatch #1 {, blocks: (B:3:0x0001, B:9:0x000a, B:12:0x002b, B:15:0x003b, B:17:0x0041, B:19:0x004d, B:21:0x005b, B:22:0x0076, B:46:0x00cf, B:48:0x0150, B:50:0x0154, B:52:0x015a, B:54:0x0166, B:56:0x0170, B:58:0x0177, B:63:0x0196, B:65:0x01b0, B:66:0x01bf, B:72:0x01af, B:76:0x00d0, B:78:0x00ed, B:80:0x00f5, B:82:0x00fb, B:83:0x00fd, B:107:0x014f, B:85:0x00fe, B:87:0x0102, B:89:0x0106, B:92:0x010a, B:94:0x0112, B:95:0x011d, B:98:0x0131, B:99:0x0148, B:103:0x014b, B:24:0x0077, B:26:0x007b, B:28:0x0083, B:31:0x0089, B:33:0x0091, B:34:0x009c, B:37:0x00b0, B:38:0x00c7, B:42:0x00ca, B:68:0x01a3), top: B:2:0x0001, inners: #3, #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0177 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized IVideoDecoder createDecoder(@NonNull DecoderTrackSegment decoderTrackSegment, CMTime cMTime) {
        IVideoDecoder iVideoDecoder;
        IDecoderTrack.SurfaceCreator surfaceCreator;
        Surface surface;
        DecoderWrapper decoderWrapper;
        IVideoDecoder iVideoDecoder2;
        DecoderAssetTrack videoAsset = decoderTrackSegment.getVideoAsset();
        Surface surface2 = null;
        if (videoAsset == null) {
            return null;
        }
        String str = TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("createDecoder - ");
        sb5.append(videoAsset.assetPath);
        sb5.append(" - ");
        sb5.append(this.surfaceCreator != null);
        Logger.i(str, sb5.toString());
        int i3 = 5;
        IVideoDecoder iVideoDecoder3 = null;
        while (iVideoDecoder3 == null && i3 > 0) {
            i3--;
            DecoderCreateThread decoderCreateThread = this.decoderCreateThread;
            if (decoderCreateThread != null) {
                int i16 = decoderCreateThread.segmentIndex;
                if (i16 < this.segments.size() && ExtractorUtils.isSameExtractor(getSegment(i16).getVideoAsset(), videoAsset)) {
                    Logger.d(TAG, "check  decoder 1 - " + videoAsset.assetPath);
                    synchronized (this.nextDecoderLock) {
                        DecoderWrapper decoderWrapper2 = this.nextDecoder;
                        if (decoderWrapper2 != null && ExtractorUtils.isSameExtractor(decoderWrapper2.extractor, videoAsset) && (iVideoDecoder2 = (decoderWrapper = this.nextDecoder).decoder) != null) {
                            if (getSegment(decoderWrapper.segmentIndex) != decoderTrackSegment) {
                                iVideoDecoder2.start(decoderTrackSegment.getTimeRange(), decoderTrackSegment.getDecoderStartTime());
                            }
                            this.nextDecoder = null;
                            String str2 = TAG;
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("hint decoder - ");
                            sb6.append(this.surfaceCreator == null);
                            sb6.append("  ");
                            sb6.append(iVideoDecoder2.getSourcePath());
                            Logger.d(str2, sb6.toString());
                            return iVideoDecoder2;
                        }
                    }
                }
                try {
                    surfaceCreator = this.surfaceCreator;
                    try {
                        if (surfaceCreator != null) {
                            CGSize cGSize = videoAsset.size;
                            int i17 = videoAsset.preferRotation;
                            if (cGSize != null) {
                                surface = surfaceCreator.createOutputSurface((int) cGSize.width, (int) cGSize.height, i17);
                                iVideoDecoder3 = createVideoDecoder(newDecoderParams(videoAsset, surface), decoderTrackSegment);
                                if (iVideoDecoder3 != null) {
                                    iVideoDecoder3.start(decoderTrackSegment.getTimeRange(), cMTime);
                                }
                                Logger.d(TAG, "createDecoder new Decoder success - " + videoAsset.assetPath);
                            }
                        }
                        iVideoDecoder3 = createVideoDecoder(newDecoderParams(videoAsset, surface), decoderTrackSegment);
                        if (iVideoDecoder3 != null) {
                        }
                        Logger.d(TAG, "createDecoder new Decoder success - " + videoAsset.assetPath);
                    } catch (Exception e16) {
                        e = e16;
                        surface2 = surface;
                        Logger.e(TAG, " createDecoder:", e);
                        free(surface2);
                        if (iVideoDecoder3 != null) {
                            try {
                                iVideoDecoder3.release(true);
                                free(iVideoDecoder3.outputSurface());
                            } catch (Exception unused) {
                            }
                        }
                        throw new ExportRuntimeException(new ExportErrorStatus(-1031, e, "createVideoDecoder error"));
                    }
                    surface = null;
                } catch (Exception e17) {
                    e = e17;
                }
            } else {
                Logger.d(TAG, "check  decoder - " + videoAsset.assetPath);
                DecoderWrapper decoderWrapper3 = this.nextDecoder;
                if (decoderWrapper3 != null && ExtractorUtils.isSameExtractor(decoderWrapper3.extractor, videoAsset) && this.nextDecoder.decoder != null) {
                    synchronized (this.nextDecoderLock) {
                        DecoderWrapper decoderWrapper4 = this.nextDecoder;
                        if (decoderWrapper4 != null && decoderWrapper4.extractor == videoAsset && (iVideoDecoder = decoderWrapper4.decoder) != null) {
                            if (getSegment(decoderWrapper4.segmentIndex) != decoderTrackSegment) {
                                iVideoDecoder.start(decoderTrackSegment.getTimeRange(), decoderTrackSegment.getDecoderStartTime());
                            }
                            this.nextDecoder = null;
                            String str3 = TAG;
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("hint decoder - ");
                            sb7.append(this.surfaceCreator == null);
                            sb7.append("  ");
                            sb7.append(iVideoDecoder.getSourcePath());
                            Logger.d(str3, sb7.toString());
                            return iVideoDecoder;
                        }
                    }
                }
                surfaceCreator = this.surfaceCreator;
                if (surfaceCreator != null) {
                }
                surface = null;
                iVideoDecoder3 = createVideoDecoder(newDecoderParams(videoAsset, surface), decoderTrackSegment);
                if (iVideoDecoder3 != null) {
                }
                Logger.d(TAG, "createDecoder new Decoder success - " + videoAsset.assetPath);
            }
        }
        return iVideoDecoder3;
    }

    private void createNextDecoder(int i3) {
        int i16;
        ArrayList<DecoderTrackSegment> arrayList = this.segments;
        if (arrayList != null && PRE_READ && (i16 = i3 + 1) < arrayList.size() && this.decoderCreateThread == null) {
            DecoderAssetTrack videoAsset = getSegment(i16).getVideoAsset();
            if (videoAsset != null) {
                DecoderWrapper decoderWrapper = this.nextDecoder;
                if (decoderWrapper == null || !ExtractorUtils.isSameExtractor(decoderWrapper.extractor, videoAsset)) {
                    createDecoder(videoAsset, i16);
                    return;
                }
                return;
            }
            DecoderWrapper decoderWrapper2 = this.nextDecoder;
            if (decoderWrapper2 != null && decoderWrapper2.segmentIndex != i3) {
                decoderWrapper2.decoder.start(getSegment(i3).getTimeRange());
                this.nextDecoder.segmentIndex = i3;
            }
        }
    }

    @NonNull
    private CMSampleBuffer createSampleBuffer(boolean z16) {
        CMSampleBuffer cMSampleBuffer = this.currentFrame;
        if (cMSampleBuffer != null) {
            return createSampleBuffer(this.lastSampleState, cMSampleBuffer.getTextureInfo(), z16);
        }
        CMSampleState cMSampleState = this.lastSampleState;
        IVideoDecoder iVideoDecoder = this.currentDecoder;
        return createSampleBuffer(cMSampleState, iVideoDecoder == null ? null : iVideoDecoder.getTextureInfo(), z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IVideoDecoder createVideoDecoder(IVideoDecoder.Params params, DecoderTrackSegment decoderTrackSegment) throws Exception {
        boolean z16;
        IVideoDecoder createVideoDecoder = AVDecoderFactory.getInstance().createVideoDecoder(params);
        if (SeekTimeStore.ENABLE && (createVideoDecoder instanceof VideoDecoder)) {
            if (this.index == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            ((VideoDecoder) createVideoDecoder).setVideoDecoderSeekHelper(new VideoDecoderQuickSeekHelper(z16, decoderTrackSegment, getSegmentStartTime(this.segmentIndex).getTimeUs()));
        }
        return createVideoDecoder;
    }

    private synchronized CMSampleBuffer doReadSample(@NonNull CMTime cMTime) {
        return doReadSample(cMTime, false);
    }

    private void doReleaseCurrentDecoder() {
        IVideoDecoder iVideoDecoder = this.currentDecoder;
        if (iVideoDecoder != null && iVideoDecoder.getSourcePath() != null) {
            final IVideoDecoder iVideoDecoder2 = this.currentDecoder;
            this.currentDecoder = null;
            if (iVideoDecoder2 instanceof ImageDecoder) {
                iVideoDecoder2.release(true);
            } else {
                ThreadPool.execute(new Runnable() { // from class: com.tencent.tav.decoder.VideoDecoderTrack.2
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoDecoderTrack.this.free(iVideoDecoder2.outputSurface());
                        iVideoDecoder2.release(true);
                    }
                });
            }
        }
    }

    private int findSegmentIndexAt(CMTime cMTime, boolean z16) {
        boolean z17;
        CMTime cMTime2 = CMTime.CMTimeZero;
        Iterator<DecoderTrackSegment> it = this.segments.iterator();
        boolean z18 = false;
        int i3 = 0;
        while (true) {
            z17 = true;
            if (!it.hasNext()) {
                break;
            }
            CMTime scaledDuration = it.next().getScaledDuration();
            if (cMTime.compare(cMTime2) >= 0 && cMTime.smallThan(cMTime2.add(scaledDuration))) {
                z18 = true;
                break;
            }
            cMTime2 = cMTime2.add(scaledDuration);
            i3++;
        }
        if (!z18 && cMTime.equalsTo(cMTime2) && i3 > 0 && z16) {
            i3--;
        } else {
            z17 = z18;
        }
        if (!z17) {
            return -1;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void free(Surface surface) {
        if (surface != null) {
            try {
                this.surfaceCreator.free(surface);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private void freeCurrentDecoder() {
        checkReleaseDelayDecoder();
        this.delayReleaseDecoder = this.currentDecoder;
        this.currentDecoder = null;
    }

    private DecoderTrackSegment getCurrentSegment() {
        return getSegment(this.segmentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DecoderTrackSegment getSegment(int i3) {
        return this.segments.get(i3);
    }

    private CMTime getSegmentStartTime(int i3) {
        CMTime cMTime = CMTime.CMTimeZero;
        for (int i16 = 0; i16 < i3 && i16 < this.segments.size(); i16++) {
            cMTime = CMTime.add(cMTime, getSegment(i16).getScaledDuration());
        }
        return cMTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logVerbose(String str) {
        Logger.v(TAG, str);
    }

    private boolean needSwitchNextFrame(@Nullable CMSampleBuffer cMSampleBuffer, CMSampleBuffer cMSampleBuffer2, @NonNull CMTime cMTime) {
        if (cMSampleBuffer == null || cMSampleBuffer.getTextureInfo() == null || cMSampleBuffer.getTextureInfo().isReleased() || cMSampleBuffer2 == null || cMSampleBuffer2.getTime().smallThan(CMTime.CMTimeZero)) {
            return true;
        }
        if (Math.abs(cMTime.getTimeUs()) >= Math.abs(cMSampleBuffer2.getTime().getTimeUs())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public IVideoDecoder.Params newDecoderParams(DecoderAssetTrack decoderAssetTrack, Surface surface) {
        IVideoDecoder.Params params = new IVideoDecoder.Params();
        params.sourceType = decoderAssetTrack.sourceType;
        params.filePath = decoderAssetTrack.assetPath;
        params.outputSize = ImageDecoder.IMAGE_DECODE_SIZE;
        params.outputSurface = surface;
        params.extraInfo = decoderAssetTrack.extraInfo;
        IDecoderTrack.SurfaceCreator surfaceCreator = this.surfaceCreator;
        if (surfaceCreator != null) {
            params.videoTexture = surfaceCreator.videoTextureForSurface(surface);
        }
        return params;
    }

    private boolean nextSegment(boolean z16) {
        CMTime cMTime;
        Logger.d(TAG, "nextSegment:" + z16);
        int i3 = this.segmentIndex + 1;
        this.segmentIndex = i3;
        this._outputSurface = null;
        boolean z17 = false;
        if (i3 >= this.segments.size()) {
            this.segmentIndex = -1;
            return false;
        }
        CMTime segmentStartTime = getSegmentStartTime(this.segmentIndex);
        this.currentSegmentStartTime = segmentStartTime;
        this.lastSampleState = new CMSampleState(segmentStartTime);
        DecoderTrackSegment currentSegment = getCurrentSegment();
        if (currentSegment.getVideoAsset() != null) {
            releaseCurrentDecoder();
            if (z16) {
                cMTime = getCurrentSegment().getDecoderStartTime();
            } else {
                cMTime = CMTime.CMTimeInvalid;
            }
            IVideoDecoder createDecoder = createDecoder(currentSegment, cMTime);
            synchronized (this.currentDecoderLock) {
                this.currentDecoder = createDecoder;
                if (createDecoder != null && createDecoder.hasTrack()) {
                    if (z16) {
                        this.currentDecoder.seekTo(currentSegment.getDecoderStartTime());
                    }
                    this._outputSurface = this.currentDecoder.outputSurface();
                }
            }
        } else {
            Logger.d(TAG, "nextSegment: videoAsset is null");
            releaseCurrentDecoder();
        }
        if (currentSegment.getScaledDuration().getTimeUs() > 0) {
            this._speed = (((float) currentSegment.getTimeRange().getDurationUs()) * 1.0f) / ((float) currentSegment.getScaledDuration().getTimeUs());
        }
        String str = TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("nextSegment:");
        if (this.currentDecoder == null) {
            z17 = true;
        }
        sb5.append(z17);
        sb5.append(" ");
        sb5.append(this._speed);
        Logger.d(str, sb5.toString());
        return true;
    }

    private void release(Surface surface) {
        if (surface != null) {
            try {
                surface.release();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private void releaseCurrentDecoder() {
        if (this.currentDecoder == null) {
            return;
        }
        synchronized (this.currentDecoderLock) {
            doReleaseCurrentDecoder();
        }
    }

    private CMTime segmentsDuration() {
        return getSegmentStartTime(this.segments.size());
    }

    @Nullable
    private CMSampleBuffer switchToNextFrame() {
        VideoTexture texture;
        CMSampleBuffer cMSampleBuffer = this.nextFrame;
        if (cMSampleBuffer == null) {
            return null;
        }
        this.currentFrame = createSampleBuffer(cMSampleBuffer.getState(), this.nextFrame.getTextureInfo(), this.nextFrame.isNewFrame());
        if (this.nextFrame.isNewFrame()) {
            CMSampleBuffer cMSampleBuffer2 = this.nextFrame;
            if ((cMSampleBuffer2 instanceof CacheSampleBuffer) && (texture = ((CacheSampleBuffer) cMSampleBuffer2).getTexture()) != null && !Thread.currentThread().getName().equals("VideoAsyncDecoderThread")) {
                logVerbose("readSample: awaitNewImage: " + this.nextFrame.getTime());
                try {
                    texture.awaitNewImage();
                } catch (Throwable th5) {
                    Logger.e(TAG, "readSample: videoTexture.awaitNewImage() error", th5);
                    return createSampleBuffer(CMSampleState.fromError(-3L, "DecoderThread.NAME:VideoAsyncDecoderThread", th5));
                }
            }
        }
        this.nextFrame = createSampleBuffer(new CMSampleState());
        if (!this.currentFrame.getTime().smallThan(CMTime.CMTimeZero)) {
            return null;
        }
        this.lastSampleState = this.currentFrame.getState();
        return createSampleBuffer(this.currentFrame.getState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryReleaseDecoder(IVideoDecoder iVideoDecoder) {
        if (iVideoDecoder != null) {
            try {
                iVideoDecoder.release(true);
                free(iVideoDecoder.outputSurface());
            } catch (Exception e16) {
                Log.e(TAG, "tryReleaseDecoder Exception, ignore", e16);
            }
        }
    }

    private boolean unNeedReDecoderNextFrame(CMTime cMTime) {
        boolean z16;
        boolean z17;
        CMSampleBuffer cMSampleBuffer = this.nextFrame;
        if (cMSampleBuffer != null && cMSampleBuffer.getTime().bigThan(cMTime)) {
            z16 = true;
        } else {
            z16 = false;
        }
        CMSampleBuffer cMSampleBuffer2 = this.nextFrame;
        if (cMSampleBuffer2 != null && this.currentFrame != null && cMSampleBuffer2.getTime().bigThan(this.currentFrame.getTime())) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 || z17) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public synchronized void asyncReadNextSample(CMTime cMTime) {
        if (unNeedReDecoderNextFrame(cMTime)) {
            return;
        }
        if (this.isReleased) {
            return;
        }
        this.nextFrame = new CMSampleBuffer(cMTime);
        synchronized (this.decoderThread) {
            this.decoderThread.action();
        }
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void clipRangeAndClearRange(CMTimeRange cMTimeRange) {
        if (cMTimeRange != null && cMTimeRange.getDurationUs() > 0 && this.segments.size() != 0) {
            CMTime start = cMTimeRange.getStart();
            CMTime end = cMTimeRange.getEnd();
            CMTime segmentsDuration = segmentsDuration();
            clipRangeAndRemoveRange(cMTimeRange);
            if (start.getValue() != 0) {
                this.segments.add(0, new DecoderTrackSegment(new CMTimeRange(CMTime.CMTimeZero, start), (DecoderAssetTrack) null));
            }
            if (end.getTimeUs() < segmentsDuration.getTimeUs()) {
                this.segments.add(new DecoderTrackSegment(new CMTimeRange(end, new CMTime(segmentsDuration.getTimeSeconds() - end.getTimeSeconds())), (DecoderAssetTrack) null));
            }
        }
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getCurrentSampleTime() {
        return this.lastSampleState.getTime();
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getDuration() {
        CMTime cMTime = this.duration;
        CMTime cMTime2 = CMTime.CMTimeZero;
        if (cMTime == cMTime2) {
            Iterator<DecoderTrackSegment> it = this.segments.iterator();
            while (it.hasNext()) {
                cMTime2 = cMTime2.add(it.next().getScaledDuration());
            }
            this.duration = cMTime2;
        }
        return this.duration;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getFrameDuration() {
        return this.frameDuration;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getFrameRate() {
        return this.frameRate;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getTrackId() {
        return this.trackId;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readCurrentSample() {
        return createSampleBuffer(false);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample() {
        if (this.lastSampleState.isInvalid()) {
            return readSample(CMTime.CMTimeZero);
        }
        return readSample(this.lastSampleState.getTime().add(this.frameDuration));
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer seekTo(CMTime cMTime, boolean z16, boolean z17) {
        CMSampleBuffer cMSampleBuffer;
        logVerbose("seekTo:[time " + cMTime + "] [needRead " + z16 + "] [quickSeek " + z17 + "]");
        synchronized (this.nextFrameDecoderLock) {
            this.currentFrame = null;
            this.nextFrame = null;
        }
        synchronized (this) {
            if (this.started && !this.isReleased) {
                int findSegmentIndexAt = findSegmentIndexAt(cMTime, true);
                if (findSegmentIndexAt == -1) {
                    this.segmentIndex = -1;
                    Logger.w(TAG, "seekTo: [failed] [index " + findSegmentIndexAt + "]");
                    return null;
                }
                CMTime segmentStartTime = getSegmentStartTime(findSegmentIndexAt);
                if (this.segmentIndex != findSegmentIndexAt || this.currentDecoder == null) {
                    this.segmentIndex = findSegmentIndexAt - 1;
                    nextSegment(false);
                }
                CMTime multi = cMTime.sub(segmentStartTime).multi(this._speed);
                DecoderTrackSegment currentSegment = getCurrentSegment();
                IVideoDecoder iVideoDecoder = this.currentDecoder;
                if (iVideoDecoder == null) {
                    this.lastSampleState = new CMSampleState(cMTime);
                    Logger.w(TAG, "seekTo: [failed] [currentDecoder == null]");
                    return null;
                }
                iVideoDecoder.seekTo(currentSegment.getDecoderStartTime().add(multi), z17);
                if (cMTime.bigThan(this.frameDuration)) {
                    this.lastSampleState = new CMSampleState(cMTime.sub(this.frameDuration));
                } else {
                    this.lastSampleState = new CMSampleState(cMTime);
                }
                if (z16) {
                    cMSampleBuffer = readSample();
                } else {
                    cMSampleBuffer = null;
                }
                this.currentFrame = null;
                this.nextFrame = null;
                logVerbose("seekTo: [success] [lastSampleState " + this.lastSampleState + "] [sampleBuffer " + cMSampleBuffer + "]");
                return cMSampleBuffer;
            }
            Logger.e(TAG, "seekTo: [failed] [started " + this.started + "] [isReleased " + this.isReleased + "]", new RuntimeException());
            return null;
        }
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setDecodeType(IDecoder.DecodeType decodeType) {
        this.decodeType = decodeType;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setFrameRate(int i3) {
        this.frameRate = i3;
        this.frameDuration = new CMTime(600 / i3, 600);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setTrackIndex(int i3) {
        this.index = i3;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setTrackSegments(List<DecoderTrackSegment> list) {
        if (this.segments == null) {
            this.segments = new ArrayList<>();
        }
        this.segments.clear();
        this.segments.addAll(list);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start() {
        start(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized CMSampleBuffer doReadSample(@NonNull CMTime cMTime, boolean z16) {
        IVideoDecoder iVideoDecoder;
        CMSampleBuffer createSampleBuffer;
        logVerbose("doReadSample: step 1 ");
        if (this.isReleased) {
            return createSampleBuffer(-100L);
        }
        if (cMTime == null) {
            return createSampleBuffer(-3L);
        }
        if (this.segmentIndex == -1) {
            if (this.lastSampleState.getStateCode() >= -1) {
                createSampleBuffer = createSampleBuffer(-1L);
            } else {
                createSampleBuffer = createSampleBuffer(-100L);
            }
            return createSampleBuffer;
        }
        DecoderTrackSegment currentSegment = getCurrentSegment();
        CMSampleState fromError = CMSampleState.fromError(-1L);
        boolean z17 = false;
        boolean z18 = false;
        while (true) {
            logVerbose("doReadSample: step 2 ");
            if (this.currentDecoder == null) {
                this.lastSampleState = new CMSampleState(this.lastSampleState.getTime().add(this.frameDuration));
                if (this.lastSampleState.getTime().smallThan(this.currentSegmentStartTime.add(currentSegment.getScaledDuration()))) {
                    IDecoderTrack.SurfaceCreator surfaceCreator = this.surfaceCreator;
                    if (surfaceCreator == null) {
                        return createSampleBuffer(this.lastSampleState);
                    }
                    return createSampleBuffer(this.lastSampleState, surfaceCreator.videoTextureForSurface(this._outputSurface), false);
                }
            } else {
                CMTime limitMin = cMTime.sub(this.currentSegmentStartTime).multi(this._speed).limitMin(CMTime.CMTimeZero);
                if (((float) limitMin.getTimeUs()) > ((float) currentSegment.getScaledDuration().getTimeUs()) * this._speed) {
                    fromError = CMSampleState.fromError(-1L);
                } else {
                    CMTime add = limitMin.add(currentSegment.getDecoderStartTime());
                    add.setFlag(cMTime.getFlag());
                    IVideoDecoder iVideoDecoder2 = this.currentDecoder;
                    if (iVideoDecoder2 == null) {
                        fromError = CMSampleState.fromError(-100L);
                    } else {
                        fromError = iVideoDecoder2.readSample(add);
                    }
                    z18 = true;
                }
            }
            if (!fromError.stateMatchingTo(-1) && !fromError.getTime().bigThan(currentSegment.getTimeRange().getDuration())) {
                if (fromError.getStateCode() >= 0) {
                    logVerbose("doReadSample: step 3 ");
                    CMTime sub = fromError.getTime().sub(currentSegment.getDecoderStartTime());
                    if (sub.bigThan(currentSegment.getTimeRange().getDuration())) {
                        sub = currentSegment.getTimeRange().getDuration();
                    }
                    CMSampleState cMSampleState = new CMSampleState(this.currentSegmentStartTime.add(sub.divide(this._speed)));
                    logVerbose("readSample: currentTime = " + cMTime + "  sampleState = " + cMSampleState);
                    return createSampleBuffer(cMSampleState, true);
                }
                if (!fromError.stateMatchingTo(-3)) {
                    return createSampleBuffer(this.lastSampleState);
                }
                return createSampleBuffer(fromError);
            }
            if (currentSegment.getScaledDuration().add(this.currentSegmentStartTime).sub(this.frameDuration).bigThan(cMTime)) {
                if (z18 && (iVideoDecoder = this.currentDecoder) != null && iVideoDecoder.isLastFrameValid()) {
                    z17 = true;
                }
                return createSampleBuffer(new CMSampleState(cMTime), z17);
            }
            if (z16) {
                Logger.d(TAG, "async read finish , skip it!");
                return null;
            }
            if (!nextSegment(true)) {
                if (DELAY_RELEASE_DECODER_ON_PLAY_FINISH) {
                    freeCurrentDecoder();
                }
                return createSampleBuffer(CMSampleState.fromError(-1L), false);
            }
            currentSegment = getCurrentSegment();
        }
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator) {
        start(surfaceCreator, null);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public synchronized void release() {
        this.decoderThread.release();
        Logger.d(TAG, "release: start " + this);
        this.isReleased = true;
        this.segments.clear();
        checkReleaseDelayDecoder();
        IVideoDecoder iVideoDecoder = this.currentDecoder;
        if (iVideoDecoder != null) {
            iVideoDecoder.release(true);
            release(this.currentDecoder.outputSurface());
            this.currentDecoder = null;
        }
        synchronized (this.nextDecoderLock) {
            DecoderWrapper decoderWrapper = this.nextDecoder;
            if (decoderWrapper != null) {
                decoderWrapper.release();
                this.nextDecoder = null;
            }
        }
        CMSampleBuffer cMSampleBuffer = this.currentFrame;
        if (cMSampleBuffer != null && cMSampleBuffer.getTextureInfo() != null) {
            this.currentFrame.getTextureInfo().release();
        }
        CMSampleBuffer cMSampleBuffer2 = this.nextFrame;
        if (cMSampleBuffer2 != null && (cMSampleBuffer2 instanceof CacheSampleBuffer) && ((CacheSampleBuffer) cMSampleBuffer2).getTexture() != null) {
            ((CacheSampleBuffer) this.nextFrame).getTexture().release();
        }
        Logger.d(TAG, "release: finish");
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator, CMTimeRange cMTimeRange) {
        Logger.d(TAG, "VideoDecoderTrack start:" + cMTimeRange);
        if (this.segments.size() == 0) {
            release();
            return;
        }
        this.isReleased = false;
        this.started = true;
        this.surfaceCreator = surfaceCreator;
        this.segmentIndex = -1;
        this.decoderThread.start();
        clipRangeAndRemoveRange(cMTimeRange);
        nextSegment(true);
        Logger.d(TAG, "VideoDecoderTrack start finish:");
    }

    private CMSampleBuffer createSampleBuffer(@NonNull CMSampleState cMSampleState, boolean z16) {
        IVideoDecoder iVideoDecoder = this.currentDecoder;
        if (iVideoDecoder instanceof VideoDecoder) {
            return createSampleBuffer(cMSampleState, this.surfaceCreator.videoTextureForSurface(this._outputSurface), z16);
        }
        return createSampleBuffer(cMSampleState, iVideoDecoder == null ? null : iVideoDecoder.getTextureInfo(), z16);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample(CMTime cMTime) {
        CMSampleBuffer switchToNextFrame;
        CMSampleBuffer cMSampleBuffer;
        logVerbose("readSample: start expectFrameTime = " + cMTime);
        if (this.isReleased) {
            releaseCurrentDecoder();
            return createSampleBuffer(CMSampleState.fromError(-100L));
        }
        if (cMTime.bigThan(getDuration())) {
            if (DELAY_RELEASE_DECODER_ON_PLAY_FINISH) {
                freeCurrentDecoder();
            } else {
                releaseCurrentDecoder();
            }
            return createSampleBuffer(CMSampleState.fromError(-1L));
        }
        CMSampleBuffer cMSampleBuffer2 = this.currentFrame;
        if (cMSampleBuffer2 != null && cMSampleBuffer2.getTime().getTimeUs() >= 0 && this.currentFrame.getTextureInfo() != null && !this.currentFrame.getTime().smallThan(cMTime)) {
            CMSampleState cMSampleState = new CMSampleState(cMTime);
            this.lastSampleState = cMSampleState;
            return createSampleBuffer(cMSampleState, this.currentFrame.getTextureInfo(), false);
        }
        logVerbose("readSample: step 1 ");
        CMTime add = cMTime.sub(this.frameDuration).add(new CMTime(1L, cMTime.timeScale));
        add.setFlag(cMTime.getFlag());
        if (findSegmentIndexAt(cMTime, false) == this.segmentIndex && (cMSampleBuffer = this.nextFrame) != null && cMSampleBuffer.getState().getStateCode() >= 0 && this.decodeType == IDecoder.DecodeType.Video) {
            synchronized (this.nextFrameDecoderLock) {
                CMSampleBuffer cMSampleBuffer3 = this.nextFrame;
                if (cMSampleBuffer3 == null || cMSampleBuffer3.getState().getStateCode() < -1 || (this.nextFrame.getTextureInfo() == null && this.nextFrame.getSampleByteBuffer() == null)) {
                    logVerbose("readSample:" + add + " nextFrame not hit time");
                    this.nextFrame = doReadSample(add);
                }
            }
        } else {
            logVerbose("readSample:" + add + " nextFrame not hit");
            if (findSegmentIndexAt(cMTime, false) != this.segmentIndex) {
                this.nextFrame = doReadSample(cMTime);
            } else {
                this.nextFrame = doReadSample(add);
            }
            cMTime = this.nextFrame.getTime();
        }
        createNextDecoder(this.segmentIndex);
        this.lastSampleState = new CMSampleState(cMTime);
        boolean needSwitchNextFrame = needSwitchNextFrame(this.currentFrame, this.nextFrame, cMTime);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("readSample: needSwitch: ");
        sb5.append(needSwitchNextFrame);
        sb5.append(" expectFrameTime = ");
        sb5.append(cMTime);
        sb5.append(" currentFrame = ");
        CMSampleBuffer cMSampleBuffer4 = this.currentFrame;
        sb5.append(cMSampleBuffer4 == null ? CMTime.CMTimeZero : cMSampleBuffer4.getTime());
        sb5.append("  nextFrame = ");
        sb5.append(this.nextFrame);
        logVerbose(sb5.toString());
        if (needSwitchNextFrame && (switchToNextFrame = switchToNextFrame()) != null) {
            return switchToNextFrame;
        }
        checkReleaseDelayDecoder();
        return createSampleBuffer(needSwitchNextFrame);
    }

    private CMSampleBuffer createSampleBuffer(long j3) {
        return createSampleBuffer(CMSampleState.fromError(j3));
    }

    private CMSampleBuffer createSampleBuffer(CMSampleState cMSampleState) {
        return new CMSampleBuffer(cMSampleState);
    }

    private CMSampleBuffer createSampleBuffer(CMSampleState cMSampleState, VideoTexture videoTexture, boolean z16) {
        CacheSampleBuffer cacheSampleBuffer = new CacheSampleBuffer(cMSampleState, videoTexture == null ? null : videoTexture.getTextureInfo(), z16);
        cacheSampleBuffer.setTexture(videoTexture);
        return cacheSampleBuffer;
    }

    private CMSampleBuffer createSampleBuffer(CMSampleState cMSampleState, TextureInfo textureInfo, boolean z16) {
        return new CMSampleBuffer(cMSampleState, textureInfo, z16);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setVolume(float f16) {
    }

    private void createDecoder(DecoderAssetTrack decoderAssetTrack, int i3) {
        CGSize cGSize;
        try {
            IDecoderTrack.SurfaceCreator surfaceCreator = this.surfaceCreator;
            if (surfaceCreator == null || (cGSize = decoderAssetTrack.size) == null) {
                return;
            }
            DecoderCreateThread decoderCreateThread = new DecoderCreateThread(decoderAssetTrack, surfaceCreator.createOutputSurface((int) cGSize.width, (int) cGSize.height, decoderAssetTrack.preferRotation), i3);
            this.decoderCreateThread = decoderCreateThread;
            decoderCreateThread.start();
        } catch (Exception e16) {
            Logger.e(TAG, "createNextDecoder: try start DecoderCreateThread", e16);
        }
    }
}
