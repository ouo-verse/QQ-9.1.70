package com.tencent.mobileqq.editor.composite;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.api.IAEPath;
import com.tencent.aelight.camera.qqstory.api.IQimMusicPlayer;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.k;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dov.story.api.IAudioHelper;
import com.tencent.mobileqq.dov.story.api.IStoryConfigManager;
import com.tencent.mobileqq.dov.story.api.IStoryEntityManager;
import com.tencent.mobileqq.dov.story.api.IVSReporter;
import com.tencent.mobileqq.editor.composite.step.HwVideoMerge;
import com.tencent.mobileqq.editor.composite.step.VideoStoryPicToVideo;
import com.tencent.mobileqq.editor.composite.step.b;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes6.dex */
public class VideoCompositeHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static String f203963b;

    /* renamed from: a, reason: collision with root package name */
    private boolean f203964a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements VideoStoryPicToVideo.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VideoStoryPicToVideo.b f203970a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PublishVideoEntry f203971b;

        a(VideoStoryPicToVideo.b bVar, PublishVideoEntry publishVideoEntry) {
            this.f203970a = bVar;
            this.f203971b = publishVideoEntry;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, VideoCompositeHelper.this, bVar, publishVideoEntry);
            }
        }

        @Override // com.tencent.mobileqq.editor.composite.step.VideoStoryPicToVideo.a
        public void a(VideoStoryPicToVideo.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
                return;
            }
            this.f203970a.b(0);
            this.f203971b.videoRangeEnd = 60000;
            VideoCompositeHelper.this.p("convertImageToVideo ");
        }

        @Override // com.tencent.mobileqq.editor.composite.step.VideoStoryPicToVideo.a
        public void b(VideoStoryPicToVideo.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
            } else {
                this.f203970a.b(bVar.a());
                VideoCompositeHelper.this.p("convertImageToVideo ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b extends qs.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private long f203973a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PublishVideoEntry f203974b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f203975c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f203976d;

        b(PublishVideoEntry publishVideoEntry, e eVar, String str) {
            this.f203974b = publishVideoEntry;
            this.f203975c = eVar;
            this.f203976d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, VideoCompositeHelper.this, publishVideoEntry, eVar, str);
            } else {
                this.f203973a = 0L;
            }
        }

        @Override // qs.e
        public void b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
                return;
            }
            this.f203975c.c(-3);
            this.f203975c.d("task canceled");
            VideoCompositeHelper.this.p("needAndStartDownloadMusic");
        }

        @Override // qs.e
        public void c(String str, boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            hd0.c.k(VideoCompositeHelper.f203963b, "fakeId:" + this.f203974b.fakeVid + " music onStart download onFinish ");
            this.f203974b.backgroundMusicPath = str;
            long currentTimeMillis = System.currentTimeMillis() - this.f203973a;
            if (i3 != -104) {
                if (i3 != 0) {
                    this.f203975c.c(i3);
                    this.f203975c.d("unknown error the music download failed");
                } else {
                    this.f203975c.c(0);
                    this.f203975c.d("music downloadSuccess");
                }
            } else {
                this.f203975c.c(-2);
                this.f203975c.d("none network");
            }
            IVSReporter iVSReporter = (IVSReporter) QRoute.api(IVSReporter.class);
            iVSReporter.reportPerfEvent(IVSReporter.REPORT_SMART_MUSIC_DOWNLOAD, iVSReporter.newPerfEntries(this.f203975c.a(), currentTimeMillis, this.f203976d, com.tencent.biz.qqstory.utils.d.o(str)));
            VideoCompositeHelper.this.p("needAndStartDownloadMusic");
        }

        @Override // qs.e
        public void d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
        }

        @Override // qs.e
        public void e(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
            }
        }

        @Override // qs.e
        public void f(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
                return;
            }
            hd0.c.k(VideoCompositeHelper.f203963b, "fakeId:" + this.f203974b.fakeVid + " music onStart download");
            this.f203973a = System.currentTimeMillis();
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class c implements FFmpegExecuteResponseCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final Object f203978a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f203979b;

        /* renamed from: c, reason: collision with root package name */
        private final int f203980c;

        public c(Object obj, AtomicInteger atomicInteger, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, obj, atomicInteger, Integer.valueOf(i3));
                return;
            }
            this.f203978a = obj;
            this.f203979b = atomicInteger;
            this.f203980c = i3;
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onFailure(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
                return;
            }
            hd0.c.t(VideoCompositeHelper.f203963b, "FFMPEGResponseCallback onFailure() mTaskType = " + this.f203980c + " message = " + str);
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onFinish(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            hd0.c.t(VideoCompositeHelper.f203963b, "FFMPEGResponseCallback onFinish() mTaskType = " + this.f203980c + " isSuccess = " + z16);
            synchronized (this.f203978a) {
                this.f203978a.notify();
                int i3 = this.f203980c;
                int i16 = 0;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                AtomicInteger atomicInteger = this.f203979b;
                                if (!z16) {
                                    i16 = 944004;
                                }
                                atomicInteger.set(i16);
                            } else {
                                hd0.c.g(VideoCompositeHelper.f203963b, "Undefined task type mTaskType = " + this.f203980c);
                                throw new RuntimeException("Undefined task in FFMPEGResponseCallback");
                            }
                        } else {
                            AtomicInteger atomicInteger2 = this.f203979b;
                            if (!z16) {
                                i16 = 945001;
                            }
                            atomicInteger2.set(i16);
                        }
                    } else {
                        AtomicInteger atomicInteger3 = this.f203979b;
                        if (!z16) {
                            i16 = 942004;
                        }
                        atomicInteger3.set(i16);
                    }
                } else {
                    AtomicInteger atomicInteger4 = this.f203979b;
                    if (!z16) {
                        i16 = 943004;
                    }
                    atomicInteger4.set(i16);
                }
            }
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onProgress(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            hd0.c.k(VideoCompositeHelper.f203963b, "onStart() mTaskType = " + this.f203980c);
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onSuccess(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                return;
            }
            hd0.c.k(VideoCompositeHelper.f203963b, "FFMPEGResponseCallback onSuccess() mTaskType = " + this.f203980c + " message = " + str);
        }
    }

    /* compiled from: P */
    @TargetApi(14)
    /* loaded from: classes6.dex */
    public static class d extends ExecuteBinResponseCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private f f203981a;

        /* renamed from: b, reason: collision with root package name */
        private String f203982b;

        /* renamed from: c, reason: collision with root package name */
        private String f203983c;

        /* renamed from: d, reason: collision with root package name */
        private long f203984d;

        /* renamed from: e, reason: collision with root package name */
        private int f203985e;

        public d(String str, String str2, f fVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, fVar);
                return;
            }
            this.f203985e = 941000;
            this.f203984d = SystemClock.elapsedRealtime();
            this.f203982b = str;
            this.f203983c = str2;
            this.f203981a = fVar;
        }

        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                this.f203985e = i3;
            }
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onFailure(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            String valueOf = String.valueOf(941001);
            String valueOf2 = String.valueOf(941002);
            if (str.equals(valueOf)) {
                this.f203981a.a(941001, str, "");
            } else if (str.equals(valueOf2)) {
                this.f203981a.a(941002, str, "");
            } else {
                this.f203981a.a(this.f203985e, str, "");
            }
            hd0.c.v(VideoCompositeHelper.f203963b, "combine audio fail %s, %d", str, Integer.valueOf(this.f203985e));
            com.tencent.biz.qqstory.utils.d.y(this.f203982b);
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onSuccess(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            hd0.c.b(VideoCompositeHelper.f203963b, "combine music success take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - this.f203984d));
            this.f203981a.a(0, "", this.f203983c);
            com.tencent.biz.qqstory.utils.d.y(this.f203982b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f203986a;

        /* renamed from: b, reason: collision with root package name */
        String f203987b;

        public e(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
            } else {
                this.f203986a = i3;
                this.f203987b = str;
            }
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f203986a;
        }

        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.f203987b;
        }

        public void c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.f203986a = i3;
            }
        }

        public void d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            } else {
                this.f203987b = str;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface f {
        void a(int i3, String str, String str2);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42247);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f203963b = "VideoCompositeHelper";
        try {
            int loadAVCodecSo = VideoEnvironment.loadAVCodecSo();
            hd0.c.a(f203963b, "load AVCodec so, code = " + loadAVCodecSo);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public VideoCompositeHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void c(PublishVideoEntry publishVideoEntry, int i3, String str, String str2) {
        if (com.tencent.mobileqq.editor.composite.util.a.a(str, str2, publishVideoEntry) != 0) {
            hd0.c.t(f203963b, "adjustBitrate: errcode" + i3);
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
            com.tencent.biz.qqstory.utils.d.f(str, str2);
            publishVideoEntry.useSrcFile = true;
        }
    }

    private int d(String str, String str2, int i3) {
        int i16;
        hd0.c.t(f203963b, "fakeId:" + str + ", encode video file is too big, so need to compress to:" + i3);
        long currentTimeMillis = System.currentTimeMillis();
        Object obj = new Object();
        AtomicInteger atomicInteger = new AtomicInteger(-1);
        String str3 = str2 + ".temp.mp4";
        try {
            hd0.c.k(f203963b, "compressVideoWithBitrate!");
            FFmpegUtils.compressVideoWithBitrate(str2, str3, i3, new c(obj, atomicInteger, 1));
            synchronized (obj) {
                obj.wait(180000L);
                i16 = atomicInteger.get();
            }
            hd0.c.k(f203963b, "compressVideoWithBitrate end!");
        } catch (FFmpegCommandAlreadyRunningException e16) {
            hd0.c.t(f203963b, "Wait encode video exception:" + e16);
            i16 = 943002;
        } catch (IOException e17) {
            hd0.c.t(f203963b, "Wait encode video exception:" + e17);
            i16 = 943001;
        } catch (InterruptedException e18) {
            hd0.c.t(f203963b, "Wait encode video exception:" + e18);
            i16 = 943003;
        }
        if (i16 == 0) {
            FileUtils.deleteFile(str2);
            FileUtils.rename(str3, str2);
            long o16 = com.tencent.biz.qqstory.utils.d.o(str2);
            int c16 = k.c(str2);
            hd0.c.t(f203963b, "fakeId:" + str + ", ffmpeg compress encode video file size to:" + o16 + " video bitrate to:" + c16);
        } else {
            FileUtils.deleteFile(str3);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        hd0.c.t(f203963b, "fakeId:" + str + " compressVideoByFFMPEG end errorCode:" + i16 + " cost time=" + currentTimeMillis2);
        return i16;
    }

    private int e(PublishVideoEntry publishVideoEntry) {
        VideoStoryPicToVideo.b bVar = new VideoStoryPicToVideo.b(940006, "");
        String stringExtra = publishVideoEntry.getStringExtra("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", "");
        if (!stringExtra.isEmpty() && com.tencent.biz.qqstory.utils.d.k(stringExtra)) {
            com.tencent.biz.qqstory.utils.d.i(publishVideoEntry.mLocalRawVideoDir);
            String valueOf = String.valueOf(publishVideoEntry.backgroundMusicDuration / 1000);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            j.d(stringExtra, options);
            float f16 = options.outWidth / options.outHeight;
            int b16 = com.tencent.mobileqq.editor.composite.util.a.b(ScreenUtil.SCREEN_WIDTH);
            int b17 = com.tencent.mobileqq.editor.composite.util.a.b((int) (b16 / f16));
            int i3 = com.tencent.mobileqq.editor.composite.step.b.f204002c;
            if (b17 > i3) {
                b16 = com.tencent.mobileqq.editor.composite.util.a.b((int) ((b16 * i3) / b17));
                b17 = com.tencent.mobileqq.editor.composite.step.b.f204002c;
            }
            VideoStoryPicToVideo.d().e(stringExtra, publishVideoEntry.mLocalRawVideoDir, valueOf, b16, b17, false, 0, new a(bVar, publishVideoEntry));
            v("convertImageToVideo ");
            return bVar.a();
        }
        return bVar.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0036, code lost:
    
        r0.c(0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean f(String str) {
        e eVar = new e(-1, "none audio");
        hd0.c.k(f203963b, "detectHasAudioStream");
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            try {
                mediaExtractor.setDataSource(str);
                int i3 = 0;
                while (true) {
                    if (i3 >= mediaExtractor.getTrackCount()) {
                        break;
                    }
                    if (mediaExtractor.getTrackFormat(i3).getString("mime").startsWith("audio/")) {
                        break;
                    }
                    i3++;
                }
                mediaExtractor.release();
                if (eVar.a() == 0) {
                    return true;
                }
                return false;
            } catch (IOException e16) {
                e16.printStackTrace();
                mediaExtractor.release();
                return true;
            }
        } catch (Throwable th5) {
            mediaExtractor.release();
            throw th5;
        }
    }

    private int h(PublishVideoEntry publishVideoEntry, String str) {
        if (((Boolean) ((IStoryConfigManager) QRoute.api(IStoryConfigManager.class)).getStoryValue("boolean_enable_hw_encode_pic_to_video", Boolean.TRUE)).booleanValue()) {
            int b16 = new com.tencent.mobileqq.editor.composite.step.d().b(publishVideoEntry.mLocalRawVideoDir, str);
            if (b16 != 0 && b16 != 942014) {
                hd0.c.t(f203963b, "convert picture to video by mediaCodec error. use ffmepg to convert again.");
                return i(publishVideoEntry.mLocalRawVideoDir, str);
            }
            return b16;
        }
        return i(publishVideoEntry.mLocalRawVideoDir, str);
    }

    private int i(String str, String str2) {
        hd0.c.t(f203963b, "encodePicToVideoWithFFmpeg");
        if (!com.tencent.biz.qqstory.utils.d.k(str)) {
            return 940007;
        }
        Object obj = new Object();
        AtomicInteger atomicInteger = new AtomicInteger(942010);
        try {
            FFmpegUtils.convertPicToVideo(BaseApplication.getContext(), str, str2, new c(obj, atomicInteger, 2));
            synchronized (obj) {
                try {
                    obj.wait(MiniBoxNoticeInfo.MIN_5);
                } catch (Throwable th5) {
                    th = th5;
                    while (true) {
                        try {
                            try {
                                break;
                            } catch (FFmpegCommandAlreadyRunningException e16) {
                                e = e16;
                                hd0.c.t(f203963b, "Wait convert pic exception:" + e);
                                return 942002;
                            } catch (IOException e17) {
                                e = e17;
                                hd0.c.t(f203963b, "Wait convert pic exception:" + e);
                                return 942001;
                            } catch (InterruptedException e18) {
                                e = e18;
                                hd0.c.t(f203963b, "Wait convert pic exception:" + e);
                                return 942003;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    }
                    throw th;
                }
            }
            if (atomicInteger.get() == 0) {
                return 0;
            }
            hd0.c.v(f203963b, "Compress pic to video failed, trying to compress small pic. encodeRequest.get() = %d", Integer.valueOf(atomicInteger.get()));
            String str3 = str + ".small.jpeg";
            int r16 = r(str, str3);
            if (r16 != 0) {
                hd0.c.g(f203963b, "resizeToSmallBitmap failed. nRetCode = " + r16);
                return r16;
            }
            atomicInteger.set(942010);
            try {
                FFmpegUtils.convertPicToVideo(BaseApplication.getContext(), str3, str2, new c(obj, atomicInteger, 2));
                synchronized (obj) {
                    obj.wait(MiniBoxNoticeInfo.MIN_5);
                }
                hd0.c.t(f203963b, "convertPicToVideo end");
                return atomicInteger.get();
            } catch (FFmpegCommandAlreadyRunningException e19) {
                hd0.c.t(f203963b, "Wait convert pic exception:" + e19);
                return 942002;
            } catch (IOException e26) {
                hd0.c.t(f203963b, "Wait convert pic exception:" + e26);
                return 942001;
            } catch (InterruptedException e27) {
                hd0.c.t(f203963b, "Wait convert pic exception:" + e27);
                return 942003;
            }
        } catch (FFmpegCommandAlreadyRunningException e28) {
            e = e28;
        } catch (IOException e29) {
            e = e29;
        } catch (InterruptedException e36) {
            e = e36;
        }
    }

    public static long j(String str) {
        if (!com.tencent.biz.qqstory.utils.d.d(str)) {
            return 0L;
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            mediaMetadataRetriever.release();
            return Long.valueOf(extractMetadata).longValue();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @NonNull
    public static PublishVideoEntry k(String str) {
        EntityManager createEntityManager = ((IStoryEntityManager) QRoute.api(IStoryEntityManager.class)).createEntityManager();
        PublishVideoEntry publishVideoEntry = new PublishVideoEntry();
        List<? extends Entity> q16 = q(createEntityManager, PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getVidSelectionNoArgs(), new String[]{str});
        if (q16 != null && q16.size() > 0) {
            publishVideoEntry = (PublishVideoEntry) q16.get(0);
        }
        if (publishVideoEntry == null) {
            return new PublishVideoEntry();
        }
        return publishVideoEntry;
    }

    private int l(PublishVideoEntry publishVideoEntry, String str, boolean z16) {
        int i3;
        String str2 = publishVideoEntry.videoUploadTempDir + "hwtemp.mp4";
        int m3 = m(publishVideoEntry, str, z16);
        if (m3 != 0) {
            return m3;
        }
        if (publishVideoEntry.isCancel) {
            com.tencent.biz.qqstory.utils.d.y(str);
            return -19;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i16 = 0;
        if (publishVideoEntry.isLocalPublish && publishVideoEntry.businessId == 14 && publishVideoEntry.getBooleanExtra("KEY_VIDEO_STORY_CAMERA_TYPE", false)) {
            i3 = 0;
        } else {
            i3 = -1;
        }
        int t16 = t(str, str2, i3);
        if (com.tencent.mobileqq.monitor.a.f247270d) {
            com.tencent.mobileqq.monitor.a.f247272f.d(2, System.currentTimeMillis() - currentTimeMillis);
        }
        if (t16 == 0) {
            hd0.c.t(f203963b, "set moov in front of file success. targetMergedTempMp4 = " + str2);
            com.tencent.biz.qqstory.utils.d.u(str2, str);
            i16 = t16;
        } else {
            hd0.c.v(f203963b, "set moov in front of file fail %d", Integer.valueOf(t16));
            hd0.c.a(f203963b, "set moov in front of file failed targetFile = " + str);
        }
        if (((IAudioHelper) QRoute.api(IAudioHelper.class)).isHuaWeiGreen()) {
            long currentTimeMillis2 = System.currentTimeMillis();
            if (!publishVideoEntry.isCancel) {
                i16 = com.tencent.mobileqq.editor.composite.a.a(str);
            }
            if (publishVideoEntry.isCancel) {
                i16 = -22;
            }
            if (i16 == 0) {
                hd0.c.t(f203963b, "isHuaweiGreen: reEncodeVideoWithFFMpeg succeed. output path = " + str);
            } else {
                hd0.c.g(f203963b, "isHuaweiGreen: reEncodeVideoWithFFMpeg failed. errorCode = " + i16);
            }
            if (com.tencent.mobileqq.monitor.a.f247270d) {
                com.tencent.mobileqq.monitor.a.f247272f.d(3, System.currentTimeMillis() - currentTimeMillis2);
            }
        }
        return i16;
    }

    private int m(PublishVideoEntry publishVideoEntry, String str, boolean z16) {
        int i3;
        boolean z17;
        String str2 = publishVideoEntry.mLocalRawVideoDir;
        boolean booleanExtra = publishVideoEntry.getBooleanExtra("enable_flow_decode", true);
        if ((publishVideoEntry.businessId == 1 || !booleanExtra) && publishVideoEntry.saveMode == 5) {
            str2 = publishVideoEntry.mIFrameVideoPath;
        }
        publishVideoEntry.isMixOriginal = publishVideoEntry.getBooleanExtra(PublishVideoEntry.ENTRY_KEY_IS_MIX_ORIGINAL, false);
        if (!com.tencent.biz.qqstory.utils.d.k(str2)) {
            return 940007;
        }
        String str3 = publishVideoEntry.videoUploadTempDir + ShortVideoConstants.SV_MEDIACODEC_VIDEO_MERGE_SUFFIX;
        String str4 = publishVideoEntry.videoUploadTempDir + ShortVideoConstants.SV_MEDIACODEC_VIDEO_MERGED_SUFFIX;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!publishVideoEntry.isCancel) {
            i3 = u(str2, str3, publishVideoEntry, z16);
        } else {
            i3 = 0;
        }
        if (publishVideoEntry.isCancel) {
            i3 = -15;
        }
        if (i3 != 0) {
            if (i3 == -1) {
                File file = new File(str3);
                if (file.exists()) {
                    file.delete();
                }
                if (this.f203964a) {
                    c(publishVideoEntry, i3, str2, str3);
                } else {
                    com.tencent.biz.qqstory.utils.d.f(str2, str3);
                    publishVideoEntry.useSrcFile = true;
                }
                i3 = 0;
            } else {
                return i3;
            }
        }
        hd0.c.v(f203963b, "hwEncodeRecordVideo mediaCodec trim video cost=%s", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        long j3 = j(publishVideoEntry.mLocalRawVideoDir);
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        if (!TextUtils.isEmpty(publishVideoEntry.backgroundMusicPath) && com.tencent.biz.qqstory.utils.d.k(publishVideoEntry.backgroundMusicPath)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!publishVideoEntry.isMuteRecordVoice && ((!z17 || publishVideoEntry.isMixOriginal) && !TextUtils.isEmpty(publishVideoEntry.mAudioFilePath) && !publishVideoEntry.isLocalPublish)) {
            if (!com.tencent.biz.qqstory.utils.d.k(publishVideoEntry.mAudioFilePath)) {
                hd0.c.t(f203963b, "audio not exist");
                com.tencent.biz.qqstory.utils.d.u(str3, str);
                return 0;
            }
            hd0.c.t(f203963b, "trim audio");
            String str5 = publishVideoEntry.videoUploadTempDir + elapsedRealtime2 + "_segment_mc_audio";
            if (!publishVideoEntry.isCancel) {
                float f16 = (float) j3;
                i3 = com.tencent.mobileqq.editor.composite.step.a.b(publishVideoEntry.mAudioFilePath, str5, (publishVideoEntry.videoRangeStart * 1.0f) / f16, (publishVideoEntry.videoRangeEnd * 1.0f) / f16);
            }
            if (publishVideoEntry.isCancel) {
                return -17;
            }
            if (i3 != 0) {
                hd0.c.v(f203963b, "mediacodec AudioEncoder.clipAudioFile: errcode=%s, rangeStart=%s, rangeEnd=%s, duration=%s", Integer.valueOf(i3), Integer.valueOf(publishVideoEntry.videoRangeStart), Integer.valueOf(publishVideoEntry.videoRangeEnd), Long.valueOf(j3));
                com.tencent.biz.qqstory.utils.d.u(str3, str);
                return 0;
            }
            i3 = AudioEncoder.a(str5);
            if (i3 != 0) {
                hd0.c.v(f203963b, "checkSourceAudioIsOK: errorCode=%s, rangeStart=%s, rangeEnd=%s, duration=%s", Integer.valueOf(i3), Integer.valueOf(publishVideoEntry.videoRangeStart), Integer.valueOf(publishVideoEntry.videoRangeEnd), Long.valueOf(j3));
                com.tencent.biz.qqstory.utils.d.u(str3, str);
                return 0;
            }
            hd0.c.t(f203963b, "audio to mp4");
            String str6 = publishVideoEntry.videoUploadTempDir + ShortVideoConstants.SV_MEDIACODEC_ENCODE_AUDIO_MP4;
            int i16 = publishVideoEntry.saveMode;
            if (i16 > 5) {
                i16 = 0;
            }
            AudioEncoder.a c16 = AudioEncoder.c(null, null, i16);
            c16.f288227b = str6;
            c16.f288226a = str5;
            if (!publishVideoEntry.isCancel) {
                i3 = AudioEncoder.b(c16);
            }
            if (publishVideoEntry.isCancel) {
                i3 = -21;
            }
            if (i3 != 0) {
                com.tencent.biz.qqstory.utils.d.y(str6);
                hd0.c.v(f203963b, "mediacodec AudioEncoder.encodeSafely: errorCode=%s", Integer.valueOf(i3));
                return i3;
            }
            File file2 = new File(str5);
            if (file2.exists()) {
                file2.delete();
            }
            hd0.c.t(f203963b, "video audio mp4");
            long elapsedRealtime3 = SystemClock.elapsedRealtime();
            com.tencent.biz.qqstory.utils.d.y(str4);
            if (!publishVideoEntry.isCancel) {
                i3 = HwVideoMerge.merge(str3, str6, str4, 0);
            }
            if (publishVideoEntry.isCancel) {
                com.tencent.biz.qqstory.utils.d.y(str6);
                com.tencent.biz.qqstory.utils.d.y(str4);
                return -18;
            }
            hd0.c.v(f203963b, "[HwVideoMerge.merge]cost=%s", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime3));
            if (i3 != 0) {
                hd0.c.v(f203963b, "HwVideoMerge->merge: errorCode=%s", Integer.valueOf(i3));
                return i3;
            }
            long elapsedRealtime4 = SystemClock.elapsedRealtime() - elapsedRealtime2;
            hd0.c.b(f203963b, "mediacodec encode audio time cost=%s", Long.valueOf(elapsedRealtime4));
            if (com.tencent.mobileqq.monitor.a.f247270d) {
                com.tencent.mobileqq.monitor.a.f247272f.d(1, elapsedRealtime4);
            }
            str3 = str4;
        }
        com.tencent.biz.qqstory.utils.d.u(str3, str);
        return i3;
    }

    private e o(PublishVideoEntry publishVideoEntry) {
        e eVar = new e(-1, "");
        String stringExtra = publishVideoEntry.getStringExtra("vs_publish_entry_json_key_music_download_url", "");
        String stringExtra2 = publishVideoEntry.getStringExtra("vs_publish_entry_json_key_music_mid_id", "");
        if (StringUtil.isEmpty(stringExtra)) {
            eVar.c(0);
            eVar.d("don't need to download Music");
            return eVar;
        }
        String str = com.tencent.biz.qqstory.utils.d.q() + stringExtra2 + FFmpegUtils.getAuidoType(stringExtra);
        publishVideoEntry.backgroundMusicPath = str;
        if (FileUtil.checkFileExist(str)) {
            eVar.c(0);
            eVar.d("needDownloadMusic and the file exist");
            return eVar;
        }
        MusicItemInfo musicItemInfo = new MusicItemInfo();
        musicItemInfo.setPath(str);
        musicItemInfo.mUrl = stringExtra;
        musicItemInfo.mType = 5;
        musicItemInfo.mMusicName = publishVideoEntry.getStringExtra("vs_publish_entry_json_key_song_name", "unknown name");
        if (!((IQimMusicPlayer) QRoute.api(IQimMusicPlayer.class)).requestDownLoadMusicInfo(musicItemInfo, new b(publishVideoEntry, eVar, stringExtra))) {
            eVar.c(-1);
            eVar.d("needDownloadMusic cant startDownload maybe path is null or the music has downloaded");
            return eVar;
        }
        v("needAndStartDownloadMusic");
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str) {
        synchronized (this) {
            notifyAll();
            hd0.c.k(f203963b, str + " notifyAll() ");
        }
    }

    private static List<? extends Entity> q(EntityManager entityManager, Class<? extends Entity> cls, String str, String str2, String[] strArr) {
        return entityManager.query(cls, str, false, str2, strArr, null, null, null, null, null);
    }

    private int r(String str, String str2) {
        Bitmap c16 = j.c(str);
        if (c16 == null) {
            hd0.c.g(f203963b, "BitmapManager.decodeFile in resizeToSmallBitmap failed");
            return 942007;
        }
        int height = c16.getHeight();
        int width = c16.getWidth();
        int i3 = (height * 540) / width;
        if (i3 % 2 != 0) {
            i3++;
        }
        if (width <= 540) {
            hd0.c.g(f203963b, "No need resize. srcWidth < destWidth, srcWidth = " + width + " destWidth = 540");
            return 942006;
        }
        Bitmap p16 = com.tencent.biz.qqstory.utils.b.p(c16, 540, i3, false, false);
        if (p16 == null) {
            hd0.c.g(f203963b, "resizeAndFillBitmapEdge in resizeToSmallBitmap failed");
            return 942005;
        }
        if (!com.tencent.biz.qqstory.utils.b.b(p16, str2)) {
            hd0.c.g(f203963b, "compressToFile in resizeToSmallBitmap failed");
            return 942008;
        }
        if (!p16.isRecycled()) {
            p16.recycle();
        }
        if (!c16.isRecycled()) {
            c16.recycle();
        }
        return 0;
    }

    private static int t(String str, String str2, int i3) {
        int i16;
        Object obj = new Object();
        AtomicInteger atomicInteger = new AtomicInteger(953005);
        long currentTimeMillis = System.currentTimeMillis();
        hd0.c.a(f203963b, "setMoovAndTimeStamp start!");
        try {
            FFmpegUtils.setTimestamp(BaseApplication.getContext(), str, str2, i3, new c(obj, atomicInteger, 3));
            synchronized (obj) {
                obj.wait(180000L);
                hd0.c.b(f203963b, "setMoovAndTimeStamp end, take time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                i16 = atomicInteger.get();
            }
            return i16;
        } catch (FFmpegCommandAlreadyRunningException e16) {
            hd0.c.t(f203963b, "Wait encode video exception:" + e16);
            return 953003;
        } catch (IOException e17) {
            hd0.c.t(f203963b, "Wait encode video exception:" + e17);
            return 945002;
        } catch (InterruptedException e18) {
            hd0.c.t(f203963b, "Wait encode video exception:" + e18);
            return 953004;
        }
    }

    private int u(String str, String str2, PublishVideoEntry publishVideoEntry, boolean z16) {
        hd0.c.t(f203963b, "videoSynthesisForStory start");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        b.C7493b c7493b = new b.C7493b(publishVideoEntry.videoMaxrate, publishVideoEntry);
        c7493b.e(publishVideoEntry.hwBitrateMode);
        if (z16) {
            c7493b.a();
        }
        if (publishVideoEntry.isNeedHighProfile) {
            c7493b.f(8);
            hd0.c.a(f203963b, "codec high profile is enable when story video encode");
        }
        int d16 = new com.tencent.mobileqq.editor.composite.step.b().d(str, str2, c7493b, publishVideoEntry);
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        hd0.c.t(f203963b, "[videoSynthesis]generate files|first step cost:" + (elapsedRealtime2 / 1000.0d));
        if (com.tencent.mobileqq.monitor.a.f247270d) {
            com.tencent.mobileqq.monitor.a.f247272f.d(0, elapsedRealtime2);
        }
        return d16;
    }

    private void v(String str) {
        synchronized (this) {
            try {
                hd0.c.k(f203963b, str + " wait() ");
                wait(340000L);
            } catch (InterruptedException e16) {
                hd0.c.k(f203963b, str + " wait InterruptedException");
                e16.printStackTrace();
            }
        }
    }

    public void b(@NonNull PublishVideoEntry publishVideoEntry, @NonNull String str, boolean z16, boolean z17, @NonNull f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, publishVideoEntry, str, Boolean.valueOf(z16), Boolean.valueOf(z17), fVar);
            return;
        }
        AssertUtils.checkNotNull(publishVideoEntry);
        AssertUtils.checkNotNull(str);
        AssertUtils.checkNotNull(fVar);
        hd0.c.t(f203963b, "composite create thread");
        ThreadManagerV2.newFreeThread(new Runnable(publishVideoEntry, str, z16, z17, fVar) { // from class: com.tencent.mobileqq.editor.composite.VideoCompositeHelper.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ PublishVideoEntry f203965d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f203966e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f203967f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ boolean f203968h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ f f203969i;

            {
                this.f203965d = publishVideoEntry;
                this.f203966e = str;
                this.f203967f = z16;
                this.f203968h = z17;
                this.f203969i = fVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, VideoCompositeHelper.this, publishVideoEntry, str, Boolean.valueOf(z16), Boolean.valueOf(z17), fVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    hd0.c.t(VideoCompositeHelper.f203963b, "composite thread try get lock");
                    synchronized (VideoCompositeHelper.class) {
                        hd0.c.k(VideoCompositeHelper.f203963b, "composite thread get lock and start doComposite");
                        VideoCompositeHelper.this.g(this.f203965d, this.f203966e, this.f203967f, this.f203968h, this.f203969i);
                    }
                } catch (Exception e16) {
                    hd0.c.h(VideoCompositeHelper.f203963b, "do composite exception", e16);
                    this.f203969i.a(942012, e16.getMessage(), "");
                }
            }
        }, "StoryVideoComposite", 5).start();
    }

    public void g(PublishVideoEntry publishVideoEntry, String str, boolean z16, boolean z17, f fVar) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, publishVideoEntry, str, Boolean.valueOf(z16), Boolean.valueOf(z17), fVar);
            return;
        }
        hd0.c.k(f203963b, "doComposite from:" + publishVideoEntry.businessId + "| fakeId:" + publishVideoEntry.fakeVid + " doComposite start");
        File file = new File(((IAEPath) QRoute.api(IAEPath.class)).getTmpCache());
        file.mkdirs();
        String str3 = file + File.separator + com.tencent.biz.qqstory.utils.d.m(publishVideoEntry.mLocalRawVideoDir) + ".mp4";
        String str4 = "";
        if (publishVideoEntry.isPicture) {
            hd0.c.t(f203963b, "fakeId:" + publishVideoEntry.fakeVid + " not hwEncode and encodePicToVideo start");
            i3 = h(publishVideoEntry, str3);
            if (i3 == 942014 || i3 == 942007) {
                str4 = "outOfMemory file info:" + com.tencent.biz.qqstory.utils.b.h(publishVideoEntry.mLocalRawVideoDir);
            }
        } else if (publishVideoEntry.hwEncodeRecordVideo) {
            if (QLog.isColorLevel()) {
                hd0.c.e(f203963b, "record video, isLocal=%s , size=%s, bitrate=%s and need to encode to bitrate=%s", Boolean.valueOf(publishVideoEntry.isLocalPublish), Long.valueOf(com.tencent.biz.qqstory.utils.d.o(publishVideoEntry.mLocalRawVideoDir)), Integer.valueOf(k.c(publishVideoEntry.mLocalRawVideoDir)), Integer.valueOf(publishVideoEntry.videoMaxrate));
            }
            if (publishVideoEntry.isLocalPublish && publishVideoEntry.getBooleanExtra("KEY_FROM_PIC_TO_VIDEO", false) && !StringUtil.isEmpty(publishVideoEntry.backgroundMusicPath)) {
                long currentTimeMillis = System.currentTimeMillis();
                hd0.c.k(f203963b, "fakeId:" + publishVideoEntry.fakeVid + " convertImageToVideo start");
                i3 = e(publishVideoEntry);
                hd0.c.k(f203963b, "fakeId:" + publishVideoEntry.fakeVid + " convertImageToVideo end errorCode:" + i3 + " cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            }
            if (i3 == 0) {
                hd0.c.k(f203963b, "fakeId:" + publishVideoEntry.fakeVid + " hwEncodeRecordVideo start");
                long currentTimeMillis2 = System.currentTimeMillis();
                if (!publishVideoEntry.isCancel) {
                    i3 = l(publishVideoEntry, str3, z16);
                }
                if (publishVideoEntry.isCancel) {
                    com.tencent.biz.qqstory.utils.d.y(str3);
                    i3 = -14;
                }
                hd0.c.k(f203963b, "fakeId:" + publishVideoEntry.fakeVid + " hwEncodeRecordVideo end errorCode:" + i3 + " cost:" + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
            }
            IStoryConfigManager iStoryConfigManager = (IStoryConfigManager) QRoute.api(IStoryConfigManager.class);
            int maxUploadFileSize = iStoryConfigManager.getMaxUploadFileSize();
            int highBitrate = iStoryConfigManager.getHighBitrate();
            int c16 = k.c(str3);
            long o16 = com.tencent.biz.qqstory.utils.d.o(str3);
            hd0.c.k(f203963b, "fakeId:" + publishVideoEntry.fakeVid + " encode video info file size:" + o16 + " bitrate=" + c16 + " and upload limit=" + maxUploadFileSize);
            long currentTimeMillis3 = System.currentTimeMillis();
            if (i3 == 0) {
                long j3 = publishVideoEntry.videoDuration;
                if (j3 > 0) {
                    str2 = "";
                    if (o16 > (maxUploadFileSize / 10000) * j3) {
                        int d16 = d(publishVideoEntry.fakeVid, str3, highBitrate);
                        if (publishVideoEntry.isCancel) {
                            com.tencent.biz.qqstory.utils.d.y(str3);
                            d16 = -20;
                        }
                        i3 = d16;
                    }
                } else {
                    str2 = "";
                }
            } else {
                str2 = "";
            }
            if (com.tencent.mobileqq.monitor.a.f247270d) {
                com.tencent.mobileqq.monitor.a.f247272f.d(4, System.currentTimeMillis() - currentTimeMillis3);
            }
            str4 = str2;
        } else {
            QLog.d(f203963b, 1, "hwEncodeRecordVideo false, return");
        }
        if (i3 != 0) {
            hd0.c.g(f203963b, "fakeId:" + publishVideoEntry.fakeVid + ", mediaCodec encode video failed:" + i3);
            fVar.a(i3, str4, str);
            return;
        }
        n(publishVideoEntry, str3, str, z17, fVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r12v2, types: [int] */
    /* JADX WARN: Type inference failed for: r12v4, types: [int] */
    /* JADX WARN: Type inference failed for: r13v2, types: [int] */
    /* JADX WARN: Type inference failed for: r13v4, types: [int] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.tencent.mobileqq.editor.composite.VideoCompositeHelper$f] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v4, types: [com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.tencent.mobileqq.qfix.redirect.IPatchRedirector] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.tencent.mobileqq.editor.composite.VideoCompositeHelper$f] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [int] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.StringBuilder] */
    public void n(PublishVideoEntry publishVideoEntry, String str, String str2, boolean z16, f fVar) {
        String str3;
        String str4 = str;
        ?? r142 = fVar;
        ?? r26 = $redirector_;
        ?? r36 = 1;
        r36 = 1;
        if (r26 != 0 && r26.hasPatch((short) 4)) {
            r26.redirect((short) 4, new Object[]{this, publishVideoEntry, str4, str2, Boolean.valueOf(z16), r142});
            return;
        }
        String str5 = f203963b;
        StringBuilder sb5 = new StringBuilder();
        String str6 = "fakeId:";
        sb5.append("fakeId:");
        sb5.append(publishVideoEntry.fakeVid);
        ?? r65 = " start mergeMusic";
        sb5.append(" start mergeMusic");
        hd0.c.k(str5, sb5.toString());
        String str7 = "";
        if (TextUtils.isEmpty(publishVideoEntry.backgroundMusicPath) || com.tencent.mobileqq.editor.composite.step.b.f(publishVideoEntry) || !(!publishVideoEntry.useSrcFile || publishVideoEntry.isMuteRecordVoice || publishVideoEntry.isMixOriginal)) {
            FileUtils.quickMove(str, str2);
            hd0.c.k(f203963b, "fakeId:" + publishVideoEntry.fakeVid + " noMerge end");
            r142.a(0, "", str2);
            return;
        }
        e o16 = o(publishVideoEntry);
        ?? r112 = 941000;
        r112 = 941000;
        if (o16.a() == 0 && com.tencent.biz.qqstory.utils.d.d(publishVideoEntry.backgroundMusicPath)) {
            long j3 = j(str);
            if (j3 > 0) {
                String str8 = f203963b;
                str3 = "fakeId:" + publishVideoEntry.fakeVid + " duration > 0 need to modify video duration from %d to %d";
                hd0.c.m(str8, str3, Integer.valueOf(publishVideoEntry.backgroundMusicDuration), Long.valueOf(j3));
                publishVideoEntry.backgroundMusicDuration = (int) Math.min(publishVideoEntry.backgroundMusicDuration, j3);
            }
            if (publishVideoEntry.isLocalPublish && !f(str4)) {
                r36 = 0;
            }
            String str9 = f203963b;
            ?? r46 = "fakeId:" + publishVideoEntry.fakeVid + " detect mp4 whether has original Audio:" + r36;
            hd0.c.k(str9, r46);
            try {
                if (publishVideoEntry.isMixOriginal && r36 != 0) {
                    hd0.c.k(f203963b, "fakeId:" + publishVideoEntry.fakeVid + " mixOriginalAndBackgroundMusic start");
                    FFmpegUtils.mixOriginalAndBackgroundMusic(BaseApplication.getContext(), str, str2, publishVideoEntry, z16, new d(str4, str2, r142));
                } else {
                    try {
                        if (publishVideoEntry.isLocalPublish && publishVideoEntry.isPicture) {
                            BaseApplication context = BaseApplication.getContext();
                            String str10 = publishVideoEntry.backgroundMusicPath;
                            int i3 = publishVideoEntry.backgroundMusicOffset;
                            int i16 = publishVideoEntry.backgroundMusicDuration;
                            d dVar = new d(str4, str2, r142);
                            r65 = 941000;
                            String str11 = str10;
                            str3 = "";
                            ?? r122 = i3;
                            r36 = "fakeId:";
                            ?? r132 = i16;
                            r46 = r142;
                            String str12 = str2;
                            ?? r152 = dVar;
                            FFmpegUtils.combinBackgroundMusicWithVideCodecH264(context, str, str11, r122, r132, str12, r152);
                            r112 = str11;
                            str7 = r122;
                            str6 = r132;
                            r142 = str12;
                            str4 = r152;
                        } else {
                            r65 = 941000;
                            str3 = "";
                            String str13 = "fakeId:";
                            f fVar2 = r142;
                            hd0.c.k(f203963b, str13 + publishVideoEntry.fakeVid + "  recordVideo combinBackgroundMusic start");
                            BaseApplication context2 = BaseApplication.getContext();
                            String str14 = publishVideoEntry.backgroundMusicPath;
                            ?? r123 = publishVideoEntry.backgroundMusicOffset;
                            ?? r133 = publishVideoEntry.backgroundMusicDuration;
                            d dVar2 = new d(str4, str2, fVar2);
                            String str15 = str2;
                            ?? r153 = z16;
                            FFmpegUtils.combinBackgroundMusic(context2, str, str14, r123, r133, str15, r153, dVar2);
                            r36 = str13;
                            r46 = fVar2;
                            r112 = str14;
                            str7 = r123;
                            str6 = r133;
                            r142 = str15;
                            str4 = r153;
                        }
                    } catch (Exception e16) {
                        e = e16;
                        hd0.c.u(f203963b, r36 + publishVideoEntry.fakeVid + " combine audio throw exception:", e);
                        com.tencent.biz.qqstory.utils.d.y(str);
                        r46.a(r65, "combine audio exception", str3);
                    }
                }
            } catch (Exception e17) {
                e = e17;
                r65 = r112;
                str3 = str7;
                r36 = str6;
                r46 = r142;
            }
        } else {
            hd0.c.k(f203963b, "fakeId:" + publishVideoEntry.fakeVid + " needAndStartDownloadMusic failed code:" + o16.a() + ",msg:" + o16.b());
            r142.a(941000, o16.b(), "");
        }
    }

    public void s(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f203964a = z16;
        }
    }
}
