package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor;
import com.tencent.biz.qqstory.utils.d;
import com.tencent.biz.qqstory.utils.k;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends b {

    /* renamed from: e, reason: collision with root package name */
    long f94386e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.videocodec.mediacodec.a f94387f;

    /* renamed from: g, reason: collision with root package name */
    private final Object f94388g = new Object();

    private void d(DecodeConfig decodeConfig, com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar, int i3) {
        if (i3 != 0) {
            cVar.f312569n = i3;
            cVar.f312568m = 0;
        }
        int min = Math.min(cVar.f312559d, cVar.f312560e);
        int max = Math.max(cVar.f312559d, cVar.f312560e);
        cVar.f312559d = min;
        cVar.f312560e = max;
        decodeConfig.width = min;
        decodeConfig.height = max;
    }

    private boolean g(SlideShowProcessor.c cVar) {
        if (cVar.f94350k || !cVar.f94351l) {
            return false;
        }
        return true;
    }

    public int e(LocalMediaInfo localMediaInfo) {
        if (h(localMediaInfo)) {
            return localMediaInfo.rotation + 90;
        }
        return localMediaInfo.rotation;
    }

    public void f(SlideShowProcessor.c cVar) {
        com.tencent.mobileqq.videocodec.mediacodec.a aVar = this.f94387f;
        if (aVar != null) {
            aVar.a();
        }
        synchronized (this.f94388g) {
            cVar.f94350k = true;
            this.f94388g.notifyAll();
        }
    }

    public boolean h(LocalMediaInfo localMediaInfo) {
        if (localMediaInfo.mediaWidth > localMediaInfo.mediaHeight) {
            if (localMediaInfo.rotation % 180 == 0) {
                return true;
            }
        } else {
            int i3 = localMediaInfo.rotation;
            if (i3 == 90 || i3 == 270) {
                return true;
            }
        }
        return false;
    }

    public void i(SlideShowProcessor.c cVar) {
        String str;
        String str2;
        if (cVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoToVideo", 2, "error currContext is null");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VideoToVideo", 2, "[runLocalVideo2Video]run begin, taskid:" + cVar.f94354b + " run:" + cVar.f94353a);
        }
        if (a(cVar)) {
            id0.a.i("actVideo2VideoResult", "9");
            b(9, cVar.f94343d, null, null, cVar.f94347h, cVar);
            return;
        }
        String str3 = Image2Video.f94286b;
        File file = new File(str3);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (QLog.isColorLevel()) {
                QLog.d("VideoToVideo", 2, "runLocalVideo2Video, createDir:" + mkdirs);
            }
        }
        String name = new File(cVar.f94343d).getName();
        if (!TextUtils.isEmpty(name)) {
            name = name.replace(".", "_") + ".mp4";
        }
        String str4 = str3 + name;
        this.f94384c = str4;
        d.y(str4);
        String str5 = this.f94384c + ".dat";
        if (!d.j(str5)) {
            str = "VideoToVideo";
            com.tencent.biz.qqstory.utils.c cVar2 = new com.tencent.biz.qqstory.utils.c();
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            localMediaInfo.path = cVar.f94343d;
            localMediaInfo.mDuration = cVar.f94347h.C;
            long currentTimeMillis = System.currentTimeMillis();
            SlideItemInfo slideItemInfo = cVar.f94347h;
            str2 = " run:";
            boolean d16 = cVar2.d(localMediaInfo, 0, (int) slideItemInfo.C, str5, slideItemInfo);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d(str, 2, "run,getPCMFromFile:  " + cVar.f94354b + " cost=" + (currentTimeMillis2 - currentTimeMillis) + " ms audioTrack: " + cVar.f94347h.H);
            }
            if (cVar.f94347h.H) {
                if (!d16 || !d.j(str5)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(str, 2, "run,getPCMFromFile: failed " + cVar.f94354b + " path=" + str5 + " success=" + d16);
                    }
                    d.y(str5);
                    id0.a.i("actVideo2VideoResult", "8");
                    b(8, cVar.f94343d, null, null, cVar.f94347h, cVar);
                    return;
                }
            } else {
                d.y(str5);
                com.tencent.biz.qqstory.utils.c.a(str5, (int) cVar.f94347h.C);
                if (!d.j(str5)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(str, 2, "run[video convert],createSilentPCMFile: failed " + cVar.f94354b + " path=" + str5);
                    }
                    id0.a.i("actVideo2VideoResult", "8");
                    b(8, cVar.f94343d, null, null, cVar.f94347h, cVar);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(str, 2, "After,getPCMFromFile: hasAudioTrack= " + cVar.f94347h.H + " path=" + str5 + " success=" + d16 + " audioFileSize=" + q.m(str5));
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("VideoToVideo", 2, "before,getPCMFromFile[Have audio File]:  " + cVar.f94354b + " audioPath: " + str5 + " audioFileSize=" + q.m(str5));
            }
            com.tencent.biz.qqstory.utils.c cVar3 = new com.tencent.biz.qqstory.utils.c();
            long currentTimeMillis3 = System.currentTimeMillis();
            cVar3.c(cVar.f94343d, cVar.f94347h);
            long currentTimeMillis4 = System.currentTimeMillis();
            if (!QLog.isColorLevel()) {
                str = "VideoToVideo";
            } else {
                str = "VideoToVideo";
                QLog.d(str, 2, "run,getMetaDataFromFile:  " + cVar.f94354b + " cost=" + (currentTimeMillis4 - currentTimeMillis3) + " ms audioTrack: " + cVar.f94347h.H + " mSampleRate: " + cVar.f94347h.I);
            }
            str2 = " run:";
        }
        this.f94385d = str5;
        if (a(cVar)) {
            id0.a.i("actVideo2VideoResult", "9");
            b(9, cVar.f94343d, null, null, cVar.f94347h, cVar);
            return;
        }
        cVar.f94347h.F = this.f94384c;
        if (a(cVar)) {
            id0.a.i("actVideo2VideoResult", "9");
            b(9, cVar.f94343d, null, null, cVar.f94347h, cVar);
            return;
        }
        long currentTimeMillis5 = System.currentTimeMillis();
        boolean j3 = j(cVar.f94347h, cVar);
        long currentTimeMillis6 = System.currentTimeMillis();
        if (a(cVar)) {
            id0.a.i("actVideo2VideoResult", "9");
            b(9, cVar.f94343d, null, null, cVar.f94347h, cVar);
            return;
        }
        id0.a.i("actVideo2VideoTime", (System.currentTimeMillis() - this.f94386e) + "");
        if (j3 && q.p(this.f94384c)) {
            long m3 = q.m(this.f94384c);
            if (QLog.isColorLevel()) {
                QLog.d(str, 2, "runLocalVideo2Video, file exist, size:" + m3 + " file:" + this.f94384c);
            }
            this.f94382a = 0;
            id0.a.i("actVideo2VideoResult", "0");
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(str, 2, "runLocalVideo2Video, [failed]file not exist:" + cVar.f94354b + " file:" + this.f94384c);
            }
            this.f94382a = 7;
            id0.a.i("actVideo2VideoResult", "7");
            d.y(this.f94384c);
        }
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, "runLocalVideo2Video, taskid:" + cVar.f94354b + str2 + cVar.f94353a + " cost:" + (currentTimeMillis6 - currentTimeMillis5) + " ms successVideo:" + j3);
        }
        if (cVar.f94353a) {
            b(this.f94382a, cVar.f94343d, this.f94384c, null, cVar.f94347h, cVar);
        }
    }

    public boolean j(SlideItemInfo slideItemInfo, SlideShowProcessor.c cVar) {
        int i3;
        int i16;
        if (slideItemInfo != null && slideItemInfo.f94287d != null) {
            this.f94387f = new com.tencent.mobileqq.videocodec.mediacodec.a();
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(slideItemInfo.f94287d.path);
                    slideItemInfo.f94287d.mediaHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                    slideItemInfo.f94287d.mediaWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                    slideItemInfo.f94287d.rotation = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                } catch (Throwable th5) {
                    mediaMetadataRetriever.release();
                    throw th5;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    e16.printStackTrace();
                }
            }
            mediaMetadataRetriever.release();
            long j3 = slideItemInfo.D;
            long j16 = slideItemInfo.E;
            String str = slideItemInfo.f94291i;
            String str2 = slideItemInfo.F;
            LocalMediaInfo localMediaInfo = slideItemInfo.f94287d;
            int i17 = localMediaInfo.mediaWidth;
            int i18 = localMediaInfo.mediaHeight;
            int e17 = e(localMediaInfo);
            com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar2 = new com.tencent.mobileqq.videocodec.mediacodec.encoder.c(str2, 720, 1280, CodecParam.mMaxrate, 1, false, slideItemInfo.f94287d.rotation);
            cVar2.f312559d = 720;
            cVar2.f312560e = 1280;
            LocalMediaInfo localMediaInfo2 = slideItemInfo.f94287d;
            int i19 = localMediaInfo2.rotation;
            if (i19 != 90 && i19 != 270) {
                i3 = localMediaInfo2.mediaWidth;
            } else {
                i3 = localMediaInfo2.mediaHeight;
            }
            if (i19 != 90 && i19 != 270) {
                i16 = localMediaInfo2.mediaHeight;
            } else {
                i16 = localMediaInfo2.mediaWidth;
            }
            if (i3 / i16 >= 0.5625f && k.g(i3, i16, 720, 1280)) {
                cVar2.f312574s = true;
            }
            DecodeConfig decodeConfig = new DecodeConfig(slideItemInfo.f94287d.path, 0, false, true, slideItemInfo.D, slideItemInfo.E);
            d(decodeConfig, cVar2, e17);
            decodeConfig.isLocal = true;
            LocalMediaInfo localMediaInfo3 = slideItemInfo.f94287d;
            decodeConfig.adjustRotation = localMediaInfo3.rotation;
            decodeConfig.isLandscape = h(localMediaInfo3);
            if (QLog.isColorLevel()) {
                QLog.d("VideoToVideo", 2, "startMergeVideoTask, srcPath= " + str + " videoOutputPath=" + str2 + " startTime=" + j3 + " endTime=" + j16 + " rotation= " + slideItemInfo.f94287d.rotation + " adjustRotation = " + cVar2.f312569n + " isLandscape = " + decodeConfig.isLandscape);
            }
            this.f94387f.g(decodeConfig, cVar2, new a(cVar), null);
            synchronized (this.f94388g) {
                if (QLog.isColorLevel()) {
                    QLog.d("VideoToVideo", 2, "before lock : mCancel : " + cVar.f94350k + " mFinished : " + cVar.f94351l + " mError : " + cVar.f94349j);
                }
                while (!cVar.f94350k && !cVar.f94351l && !cVar.f94349j) {
                    try {
                        LockMethodProxy.wait(this.f94388g);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            boolean g16 = g(cVar);
            if (QLog.isColorLevel()) {
                QLog.d("VideoToVideo", 2, "finishEncode, = " + g16);
            }
            return g16;
        }
        if (QLog.isColorLevel()) {
            QLog.e("VideoToVideo", 2, "startMergeVideoTask, slideItemInfo=null return ");
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements com.tencent.mobileqq.videocodec.mediacodec.recorder.c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SlideShowProcessor.c f94389d;

        a(SlideShowProcessor.c cVar) {
            this.f94389d = cVar;
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeError(int i3, Throwable th5) {
            synchronized (c.this.f94388g) {
                this.f94389d.f94349j = true;
                if (QLog.isColorLevel()) {
                    QLog.d("VideoToVideo", 2, "onEncodeError, errorCode= " + i3);
                }
                c.this.f94388g.notifyAll();
            }
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeFinish(String str) {
            synchronized (c.this.f94388g) {
                this.f94389d.f94351l = true;
                if (QLog.isColorLevel()) {
                    QLog.d("VideoToVideo", 2, "onEncodeFinish, filePath= " + str);
                }
                c.this.f94388g.notifyAll();
            }
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeFrame() {
            SlideShowProcessor.c cVar = this.f94389d;
            if (cVar != null && !cVar.f94353a && !cVar.f94350k) {
                if (QLog.isColorLevel()) {
                    QLog.d("VideoToVideo", 2, "cancel mergeVideoTask path : " + this.f94389d.f94347h.f94291i + " currContext id : " + this.f94389d + "  mCanceled : " + this.f94389d.f94350k);
                }
                c.this.f(this.f94389d);
                if (QLog.isColorLevel()) {
                    QLog.d("VideoToVideo", 2, "after cancel : " + this.f94389d.f94350k);
                }
            }
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeStart() {
        }
    }
}
