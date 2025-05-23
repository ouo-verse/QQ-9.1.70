package com.tencent.biz.qqstory.takevideo.slideshow;

import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.utils.k;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class j {

    /* renamed from: f, reason: collision with root package name */
    public static String f94410f = "Video2Video";

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.videocodec.mediacodec.a f94411a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f94412b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private boolean f94413c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f94414d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f94415e = false;

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

    private boolean f() {
        if (this.f94415e || !this.f94413c) {
            return false;
        }
        return true;
    }

    public int e(LocalMediaInfo localMediaInfo) {
        if (g(localMediaInfo)) {
            return localMediaInfo.rotation + 90;
        }
        return localMediaInfo.rotation;
    }

    public boolean g(LocalMediaInfo localMediaInfo) {
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

    public boolean h(SlideItemInfo slideItemInfo) {
        int i3;
        int i16;
        if (slideItemInfo != null && slideItemInfo.f94287d != null) {
            this.f94411a = new com.tencent.mobileqq.videocodec.mediacodec.a();
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
            com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = new com.tencent.mobileqq.videocodec.mediacodec.encoder.c(str2, 720, 1280, CodecParam.mMaxrate, 1, false, slideItemInfo.f94287d.rotation);
            cVar.f312559d = 720;
            cVar.f312560e = 1280;
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
                cVar.f312574s = true;
            }
            DecodeConfig decodeConfig = new DecodeConfig(slideItemInfo.f94287d.path, 0, false, true, slideItemInfo.D, slideItemInfo.E);
            d(decodeConfig, cVar, e17);
            decodeConfig.isLocal = true;
            LocalMediaInfo localMediaInfo3 = slideItemInfo.f94287d;
            decodeConfig.adjustRotation = localMediaInfo3.rotation;
            decodeConfig.isLandscape = g(localMediaInfo3);
            if (QLog.isColorLevel()) {
                QLog.d(f94410f, 2, "startMergeVideoTask, srcPath= " + str + " videoOutputPath=" + str2 + " startTime=" + j3 + " endTime=" + j16 + " rotation= " + slideItemInfo.f94287d.rotation + " adjustRotation = " + cVar.f312569n + " isLandscape = " + decodeConfig.isLandscape);
            }
            this.f94411a.g(decodeConfig, cVar, new a(), null);
            synchronized (this.f94412b) {
                while (!this.f94415e && !this.f94413c && !this.f94414d) {
                    try {
                        LockMethodProxy.wait(this.f94412b);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            boolean f16 = f();
            if (QLog.isColorLevel()) {
                QLog.d(f94410f, 2, "finishEncode, = " + f16);
            }
            return f16;
        }
        if (QLog.isColorLevel()) {
            QLog.e(f94410f, 2, "startMergeVideoTask, slideItemInfo=null return ");
            return false;
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements com.tencent.mobileqq.videocodec.mediacodec.recorder.c {
        a() {
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeError(int i3, Throwable th5) {
            synchronized (j.this.f94412b) {
                j.this.f94414d = true;
                if (QLog.isColorLevel()) {
                    QLog.d(j.f94410f, 2, "onEncodeError, errorCode= " + i3);
                }
                j.this.f94412b.notifyAll();
            }
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeFinish(String str) {
            synchronized (j.this.f94412b) {
                j.this.f94413c = true;
                if (QLog.isColorLevel()) {
                    QLog.d(j.f94410f, 2, "onEncodeFinish, filePath= " + str);
                }
                j.this.f94412b.notifyAll();
            }
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeFrame() {
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeStart() {
        }
    }
}
