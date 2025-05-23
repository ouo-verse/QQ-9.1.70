package com.tencent.mobileqq.editor.composite.step;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.ffmpeg.Argument;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegFileUtils;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes6.dex */
public class HwVideoMerge {
    static IPatchRedirector $redirector_ = null;
    private static final boolean MERGE_SYS = false;
    private static final String TAG = "HwVideoMerge";
    private static Process mMergeProcess;
    private static Process mRecodeProcess;
    private MediaExtractor mAudioExtractor;
    private String mAudioFilePath;
    private int mHeight;
    private MediaMuxer mMuxerEngine;
    private SampaleData mSampler;
    private MediaExtractor mVideoExtractor;
    private String mVideoFilePath;
    private int mWidth;

    public HwVideoMerge(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.mSampler = new SampaleData(null);
        this.mVideoFilePath = str;
        this.mAudioFilePath = str2;
    }

    private int checkNeedCreateMuxer() {
        this.mSampler.inputBuffer.position(0);
        if (this.mVideoExtractor.readSampleData(this.mSampler.inputBuffer, 0) <= 0) {
            releaseExtractor();
            return -5;
        }
        this.mSampler.inputBuffer.position(0);
        if (this.mAudioExtractor.readSampleData(this.mSampler.inputBuffer, 0) > 0) {
            return 0;
        }
        releaseExtractor();
        return -6;
    }

    private boolean checkPath(String str) {
        if (str != null && !"".equals(str)) {
            return true;
        }
        return false;
    }

    private final MediaExtractor createExtractor(String str) {
        MediaExtractor mediaExtractor;
        IOException e16;
        if (!checkPath(str)) {
            return null;
        }
        MediaExtractor mediaExtractor2 = new MediaExtractor();
        try {
            mediaExtractor2.setDataSource(str);
            int trackCount = mediaExtractor2.getTrackCount();
            if (trackCount != 1) {
                mediaExtractor2.release();
                try {
                    printQLog("createExtractor:invalid media file:numTracks=" + trackCount + " path=" + str, null);
                    return null;
                } catch (IOException e17) {
                    e16 = e17;
                    mediaExtractor = null;
                    printQLog("createExtractor path:" + str, e16);
                    mediaExtractor.release();
                    return null;
                }
            }
            return mediaExtractor2;
        } catch (IOException e18) {
            mediaExtractor = mediaExtractor2;
            e16 = e18;
        }
    }

    public static boolean destroyRunningProcess() {
        boolean z16;
        boolean z17;
        printQLog("[@]  ffmpegProcess try destroy!", null);
        Process process = mMergeProcess;
        if (process != null && !FFmpegUtils.isProcessCompleted(process)) {
            mMergeProcess.destroy();
            mMergeProcess = null;
            printQLog("[@]  ffmpegProcess, destroyMergeProcess!", null);
            z16 = true;
        } else {
            z16 = false;
        }
        Process process2 = mRecodeProcess;
        if (process2 != null && !FFmpegUtils.isProcessCompleted(process2)) {
            mRecodeProcess.destroy();
            mRecodeProcess = null;
            printQLog("[@]  ffmpegProcess, destroyRecodeProcess!", null);
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 || z17) {
            return true;
        }
        return false;
    }

    private static int ffmpegProcess(String str, String str2, String str3, int i3) {
        String fFmpeg = FFmpegFileUtils.getFFmpeg(VideoEnvironment.getContext());
        File file = new File(fFmpeg);
        if (file.exists()) {
            printQLog("[@] ffmpegProcess [setExecutable] code=" + file.setExecutable(true, true) + ", len:" + file.length(), null);
            getRotationDegree(str, i3);
            ArrayList arrayList = new ArrayList();
            arrayList.add(fFmpeg);
            arrayList.add(LogCmdOptions.DUMP);
            arrayList.add("-y");
            arrayList.add("-loglevel");
            arrayList.add("quiet");
            arrayList.add(Argument.FILE_INPUT);
            arrayList.add(str);
            arrayList.add(Argument.FILE_INPUT);
            arrayList.add(str2);
            arrayList.add(Argument.VIDEO_CODEC);
            arrayList.add("copy");
            arrayList.add(Argument.AUDIO_CODEC);
            arrayList.add("copy");
            arrayList.add(str3);
            arrayList.add(FFmpegFileUtils.getAVCodecSoFilePath(VideoEnvironment.getContext()));
            printQLog("[@] ffmpegProcess " + arrayList, null);
            LogStream logStream = new LogStream(null);
            ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
            processBuilder.redirectErrorStream(true);
            processBuilder.command(arrayList);
            try {
                Process start = processBuilder.start();
                mMergeProcess = start;
                logStream.mProcess = start;
                logStream.initStream();
                try {
                    start.waitFor();
                } catch (InterruptedException e16) {
                    printQLog("[@] IOException log:", e16);
                }
                int exitValue = start.exitValue();
                if (exitValue != 0) {
                    File file2 = new File(str3);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    printQLog("[@] process.exitValue:errcode=" + exitValue, null);
                }
                printQLog("[@]  ffmpegProcess, outfile exists, " + new File(str3).exists(), null);
                logStream.printStream();
                start.destroy();
                if (mMergeProcess != null) {
                    mMergeProcess = null;
                }
                return exitValue;
            } catch (IOException e17) {
                printQLog("[@] IOException log:", e17);
                return -11;
            }
        }
        return -12;
    }

    public static int ffmpegReCodec(String str, String str2, int i3) {
        String fFmpeg = FFmpegFileUtils.getFFmpeg(VideoEnvironment.getContext());
        File file = new File(fFmpeg);
        if (file.exists()) {
            AnonymousClass1 anonymousClass1 = null;
            printQLog("[@] ffmpegProcess [setExecutable] code=" + file.setExecutable(true, true), null);
            getRotationDegree(str, i3);
            ArrayList arrayList = new ArrayList();
            arrayList.add(fFmpeg);
            arrayList.add(LogCmdOptions.DUMP);
            arrayList.add("-y");
            arrayList.add("-loglevel");
            arrayList.add("quiet");
            arrayList.add(Argument.FILE_INPUT);
            arrayList.add(str);
            if (VideoEnvironment.isAvcodecNewVersion()) {
                arrayList.add("-c:v");
                arrayList.add("libo264rt");
            } else {
                arrayList.add("-profile:v");
                arrayList.add("baseline");
            }
            arrayList.add("-video_track_timescale");
            arrayList.add("90000");
            arrayList.add(str2);
            arrayList.add(FFmpegFileUtils.getAVCodecSoFilePath(VideoEnvironment.getContext()));
            LogStream logStream = new LogStream(anonymousClass1);
            ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
            processBuilder.redirectErrorStream(true);
            processBuilder.command(arrayList);
            try {
                Process start = processBuilder.start();
                mRecodeProcess = start;
                logStream.mProcess = start;
                logStream.initStream();
                try {
                    start.waitFor();
                } catch (InterruptedException e16) {
                    printQLog("[@] IOException log:", e16);
                }
                int exitValue = start.exitValue();
                if (exitValue != 0) {
                    File file2 = new File(str2);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    printQLog("[@] process.exitValue:errcode=" + exitValue, null);
                }
                logStream.printStream();
                start.destroy();
                if (mRecodeProcess != null) {
                    mRecodeProcess = null;
                }
                return exitValue;
            } catch (IOException e17) {
                printQLog("[@] IOException log:", e17);
                return -11;
            }
        }
        return -12;
    }

    private boolean getAudioInputBuffer() {
        int readSampleData;
        this.mSampler.inputBuffer.position(0);
        MediaExtractor mediaExtractor = this.mAudioExtractor;
        if (mediaExtractor == null || (readSampleData = mediaExtractor.readSampleData(this.mSampler.inputBuffer, 0)) <= 0) {
            return true;
        }
        this.mSampler.bufferInfo.presentationTimeUs = this.mAudioExtractor.getSampleTime();
        MediaCodec.BufferInfo bufferInfo = this.mSampler.bufferInfo;
        bufferInfo.size = readSampleData;
        bufferInfo.offset = 0;
        bufferInfo.flags = this.mAudioExtractor.getSampleFlags();
        this.mAudioExtractor.advance();
        return false;
    }

    private static int getRotationDegree(String str, int i3) {
        String str2;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            try {
                str2 = mediaMetadataRetriever.extractMetadata(24);
            } catch (Exception e16) {
                QLog.e(TAG, 2, e16, new Object[0]);
                str2 = null;
            }
            mediaMetadataRetriever.release();
            if (str2 == null) {
                return i3;
            }
            return Integer.parseInt(str2);
        } catch (NumberFormatException | IllegalArgumentException unused) {
            return i3;
        }
    }

    private boolean getVideoInputBuffer() {
        int readSampleData;
        this.mSampler.inputBuffer.position(0);
        MediaExtractor mediaExtractor = this.mVideoExtractor;
        if (mediaExtractor == null || (readSampleData = mediaExtractor.readSampleData(this.mSampler.inputBuffer, 0)) <= 0) {
            return true;
        }
        this.mSampler.bufferInfo.presentationTimeUs = this.mVideoExtractor.getSampleTime();
        MediaCodec.BufferInfo bufferInfo = this.mSampler.bufferInfo;
        bufferInfo.size = readSampleData;
        bufferInfo.offset = 0;
        bufferInfo.flags = this.mVideoExtractor.getSampleFlags();
        this.mVideoExtractor.advance();
        return false;
    }

    public static final int merge(String str, String str2, String str3, int i3) {
        return mergeFFmpegMuxer(str, str2, str3, i3);
    }

    public static final int mergeFFmpegMuxer(String str, String str2, String str3, int i3) {
        int i16;
        int initExtractor = new HwVideoMerge(str, str2).initExtractor(null, i3);
        if (initExtractor != -2 && initExtractor != -4 && initExtractor != -6) {
            if (initExtractor == -9) {
                return ffmpegProcess(str, str2, str3, i3);
            }
            return initExtractor;
        }
        if (FileUtils.moveFile(new File(str).getAbsolutePath(), new File(str3).getAbsolutePath())) {
            i16 = 0;
        } else {
            i16 = -10;
        }
        return i16;
    }

    public static final int mergeSysMuxer(String str, String str2, String str3, int i3) {
        int i16;
        HwVideoMerge hwVideoMerge = new HwVideoMerge(str, str2);
        int initExtractor = hwVideoMerge.initExtractor(str3, i3);
        if (initExtractor != -2 && initExtractor != -4 && initExtractor != -6) {
            if (initExtractor == 0) {
                hwVideoMerge.doWork();
                return initExtractor;
            }
            return initExtractor;
        }
        if (new File(str).renameTo(new File(str3))) {
            i16 = 0;
        } else {
            i16 = -10;
        }
        return i16;
    }

    private void overlapCopyVideoFirst() {
        boolean z16 = false;
        boolean z17 = false;
        while (true) {
            if (z16 && z17) {
                return;
            }
            if (!z16 && !(z16 = getVideoInputBuffer())) {
                MediaMuxer mediaMuxer = this.mMuxerEngine;
                SampaleData sampaleData = this.mSampler;
                mediaMuxer.writeSampleData(sampaleData.videoTrack, sampaleData.inputBuffer, sampaleData.bufferInfo);
            }
            if (!z17 && !(z17 = getAudioInputBuffer())) {
                MediaMuxer mediaMuxer2 = this.mMuxerEngine;
                SampaleData sampaleData2 = this.mSampler;
                mediaMuxer2.writeSampleData(sampaleData2.audioTrack, sampaleData2.inputBuffer, sampaleData2.bufferInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printQLog(String str, Throwable th5) {
        if (QLog.isColorLevel()) {
            if (th5 != null) {
                QLog.d(TAG, 2, str, th5);
            } else {
                QLog.d(TAG, 2, str);
            }
        }
    }

    private void releaseExtractor() {
        MediaExtractor mediaExtractor = this.mVideoExtractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.mVideoExtractor = null;
        }
        MediaExtractor mediaExtractor2 = this.mAudioExtractor;
        if (mediaExtractor2 != null) {
            mediaExtractor2.release();
            this.mAudioExtractor = null;
        }
    }

    public void doWork() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.mMuxerEngine.start();
        overlapCopyVideoFirst();
        this.mMuxerEngine.stop();
        this.mMuxerEngine.release();
        this.mMuxerEngine = null;
        releaseExtractor();
    }

    public int initExtractor(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3)).intValue();
        }
        MediaExtractor createExtractor = createExtractor(this.mVideoFilePath);
        this.mVideoExtractor = createExtractor;
        if (createExtractor == null) {
            return -1;
        }
        MediaExtractor createExtractor2 = createExtractor(this.mAudioFilePath);
        this.mAudioExtractor = createExtractor2;
        if (createExtractor2 == null) {
            releaseExtractor();
            return -2;
        }
        MediaFormat trackFormat = this.mVideoExtractor.getTrackFormat(0);
        String string = trackFormat.getString("mime");
        this.mWidth = trackFormat.getInteger("width");
        this.mHeight = trackFormat.getInteger("height");
        if (string.startsWith("video/")) {
            this.mVideoExtractor.selectTrack(0);
            MediaFormat trackFormat2 = this.mAudioExtractor.getTrackFormat(0);
            if (trackFormat2.getString("mime").startsWith("audio/")) {
                this.mAudioExtractor.selectTrack(0);
                this.mSampler.init(this.mWidth, this.mHeight);
                int checkNeedCreateMuxer = checkNeedCreateMuxer();
                if (checkNeedCreateMuxer != 0) {
                    return checkNeedCreateMuxer;
                }
                if (!checkPath(str)) {
                    releaseExtractor();
                    return -9;
                }
                try {
                    if (new File(str).exists()) {
                        releaseExtractor();
                        return -8;
                    }
                    this.mMuxerEngine = new MediaMuxer(str, 0);
                    this.mMuxerEngine.setOrientationHint(getRotationDegree(this.mVideoFilePath, i3));
                    this.mSampler.videoTrack = this.mMuxerEngine.addTrack(trackFormat);
                    this.mSampler.audioTrack = this.mMuxerEngine.addTrack(trackFormat2);
                    return checkNeedCreateMuxer;
                } catch (IOException unused) {
                    this.mMuxerEngine = null;
                    releaseExtractor();
                    return -7;
                }
            }
            releaseExtractor();
            return -4;
        }
        releaseExtractor();
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class SampaleData {
        static IPatchRedirector $redirector_;
        public int audioTrack;
        public MediaCodec.BufferInfo bufferInfo;
        public ByteBuffer inputBuffer;
        public int videoTrack;

        SampaleData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.bufferInfo = new MediaCodec.BufferInfo();
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void init(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.inputBuffer = ByteBuffer.allocate(((i3 * i16) * 3) / 2);
            }
        }

        /* synthetic */ SampaleData(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) anonymousClass1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class LogStream {
        static IPatchRedirector $redirector_;

        /* renamed from: br, reason: collision with root package name */
        private BufferedReader f203988br;
        private InputStream inputStm;
        private InputStreamReader isr;
        public Process mProcess;

        LogStream() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.inputStm = null;
            this.isr = null;
            this.f203988br = null;
            this.mProcess = null;
        }

        public void initStream() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Process process = this.mProcess;
            if (process != null) {
                this.inputStm = process.getInputStream();
                this.isr = new InputStreamReader(this.inputStm);
                this.f203988br = new BufferedReader(this.isr);
            }
        }

        public void printStream() {
            BufferedReader bufferedReader;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (this.mProcess != null) {
                while (true) {
                    try {
                        try {
                            String readLine = this.f203988br.readLine();
                            if (readLine == null) {
                                break;
                            }
                            HwVideoMerge.printQLog("[@] compressVideo log:" + readLine, null);
                        } catch (IOException unused) {
                            InputStream inputStream = this.inputStm;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            InputStreamReader inputStreamReader = this.isr;
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            bufferedReader = this.f203988br;
                            if (bufferedReader == null) {
                                return;
                            }
                        } catch (Throwable th5) {
                            try {
                                InputStream inputStream2 = this.inputStm;
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                InputStreamReader inputStreamReader2 = this.isr;
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                }
                                BufferedReader bufferedReader2 = this.f203988br;
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                            } catch (IOException unused2) {
                            }
                            throw th5;
                        }
                    } catch (IOException unused3) {
                        return;
                    }
                }
                InputStream inputStream3 = this.inputStm;
                if (inputStream3 != null) {
                    inputStream3.close();
                }
                InputStreamReader inputStreamReader3 = this.isr;
                if (inputStreamReader3 != null) {
                    inputStreamReader3.close();
                }
                bufferedReader = this.f203988br;
                if (bufferedReader == null) {
                    return;
                }
                bufferedReader.close();
            }
        }

        /* synthetic */ LogStream(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) anonymousClass1);
        }
    }
}
