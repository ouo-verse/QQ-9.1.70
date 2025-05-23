package com.tencent.could.huiyansdk.manager;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.tencent.could.component.common.ai.log.AiLog;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.base.HuiYanBaseApi;
import com.tencent.could.huiyansdk.entity.HuiYanSdkConfig;
import com.tencent.could.huiyansdk.exception.CallbackErrorCode;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.utils.CommonUtils;
import com.tencent.could.huiyansdk.utils.a;
import com.tencent.could.huiyansdk.utils.b;
import com.tencent.could.huiyansdk.utils.l;
import com.tencent.could.huiyansdk.utils.q;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes5.dex */
public class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public ArrayBlockingQueue<byte[]> f100198a;

    /* renamed from: b, reason: collision with root package name */
    public volatile int f100199b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f100200c;

    /* renamed from: d, reason: collision with root package name */
    public MediaCodec f100201d;

    /* renamed from: e, reason: collision with root package name */
    public MediaMuxer f100202e;

    /* renamed from: f, reason: collision with root package name */
    public int f100203f;

    /* renamed from: g, reason: collision with root package name */
    public String f100204g;

    /* renamed from: h, reason: collision with root package name */
    public String f100205h;

    /* renamed from: i, reason: collision with root package name */
    public Object f100206i;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f100207j;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f100208k;

    /* renamed from: l, reason: collision with root package name */
    public int f100209l;

    /* renamed from: m, reason: collision with root package name */
    public long f100210m;

    /* renamed from: n, reason: collision with root package name */
    public volatile boolean f100211n;

    /* renamed from: o, reason: collision with root package name */
    public int f100212o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f100213p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f100214q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f100215r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f100216s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f100217t;

    /* renamed from: u, reason: collision with root package name */
    public int f100218u;

    /* renamed from: v, reason: collision with root package name */
    public int f100219v;

    /* renamed from: w, reason: collision with root package name */
    public final CountDownLatch f100220w;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f100198a = new ArrayBlockingQueue<>(10);
        this.f100203f = -1;
        this.f100207j = false;
        this.f100208k = false;
        this.f100209l = 0;
        this.f100211n = true;
        this.f100212o = -1;
        this.f100213p = false;
        this.f100214q = true;
        this.f100215r = false;
        this.f100216s = true;
        this.f100217t = false;
        this.f100218u = 0;
        this.f100219v = 0;
        this.f100220w = new CountDownLatch(1);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        String sb5;
        HuiYanBaseApi huiYanBaseApi = HuiYanBaseApi.b.f100031a;
        Context a16 = huiYanBaseApi.a();
        if (a16 == null) {
            k.a.f100197a.a(2, "VideoRecorderManager", "Context is null");
            return;
        }
        if (huiYanBaseApi.f100030d) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(a16.getExternalFilesDir(null));
            String str = File.separator;
            sb6.append(str);
            sb6.append("cloud-huiyan");
            sb6.append(str);
            sb6.append("video");
            sb5 = sb6.toString();
        } else {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(a16.getFilesDir());
            String str2 = File.separator;
            sb7.append(str2);
            sb7.append("cloud-huiyan");
            sb7.append(str2);
            sb7.append("video");
            sb5 = sb7.toString();
        }
        File file = new File(sb5);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    file2.delete();
                }
            } else {
                return;
            }
        }
        if (file.exists()) {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x006b, code lost:
    
        if (a(19, r3.colorFormats) != false) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f() {
        int i3;
        if (!this.f100214q) {
            k.a.f100197a.a(2, "VideoRecorderManager", "do not need video");
        } else {
            this.f100209l = 0;
            int codecCount = MediaCodecList.getCodecCount();
            MediaCodecInfo mediaCodecInfo = null;
            for (int i16 = 0; i16 < codecCount && mediaCodecInfo == null; i16++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i16);
                if (codecInfoAt.isEncoder()) {
                    String[] supportedTypes = codecInfoAt.getSupportedTypes();
                    if (supportedTypes == null) {
                        break;
                    }
                    boolean z16 = false;
                    for (int i17 = 0; i17 < supportedTypes.length && !z16; i17++) {
                        if (supportedTypes[i17].equals("video/avc")) {
                            z16 = true;
                        }
                    }
                    if (z16) {
                        mediaCodecInfo = codecInfoAt;
                    }
                }
            }
            if (mediaCodecInfo != null) {
                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
                i3 = 21;
                if (!a(21, capabilitiesForType.colorFormats)) {
                    i3 = 19;
                }
                this.f100212o = i3;
                if (i3 != -1) {
                    this.f100211n = false;
                    k.a.f100197a.a(2, "VideoRecorderManager", "this phone not support video!");
                } else {
                    this.f100206i = new Object();
                    this.f100211n = true;
                    MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.f100199b, this.f100200c);
                    createVideoFormat.setInteger("color-format", this.f100212o);
                    createVideoFormat.setInteger("frame-rate", 30);
                    createVideoFormat.setInteger("bitrate", 1000000);
                    createVideoFormat.setInteger("i-frame-interval", 1);
                    createVideoFormat.setInteger("width", this.f100199b);
                    createVideoFormat.setInteger("height", this.f100200c);
                    try {
                        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
                        this.f100201d = createEncoderByType;
                        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                        this.f100201d.start();
                        this.f100204g = a("temp.mp4");
                        this.f100205h = a("HuiYanVideo_" + System.currentTimeMillis() + ".mp4");
                        MediaMuxer mediaMuxer = new MediaMuxer(this.f100204g, 0);
                        this.f100202e = mediaMuxer;
                        mediaMuxer.setOrientationHint(c());
                    } catch (Exception e16) {
                        k.a.f100197a.a(2, "VideoRecorderManager", "init error! e: " + e16.getMessage());
                        this.f100213p = true;
                        this.f100211n = false;
                    }
                }
            }
            i3 = -1;
            this.f100212o = i3;
            if (i3 != -1) {
            }
        }
        this.f100220w.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Object obj;
        byte[] bArr;
        Exception e16;
        com.tencent.could.huiyansdk.utils.p<byte[]> pVar;
        com.tencent.could.huiyansdk.utils.p<byte[]> pVar2;
        com.tencent.could.huiyansdk.utils.p<byte[]> pVar3;
        try {
            this.f100220w.await();
        } catch (InterruptedException e17) {
            k.a.f100197a.a(2, "VideoRecorderManager", "countDownLatch.wait(): " + e17.getLocalizedMessage());
        }
        while (true) {
            byte[] bArr2 = null;
            if (this.f100207j) {
                break;
            }
            long j3 = this.f100210m;
            if (this.f100198a.size() > 0) {
                byte[] poll = this.f100198a.poll();
                try {
                    bArr = a(poll);
                    b.a.f100299a.a(poll);
                    try {
                        try {
                            if (this.f100199b == 640) {
                                this.f100200c = TroopInfo.PAY_PRIVILEGE_ALL;
                            } else if (this.f100199b == 1280) {
                                this.f100200c = 704;
                            }
                            if (this.f100216s) {
                                b(bArr, this.f100199b, this.f100200c);
                            }
                            if (this.f100217t) {
                                bArr = c(bArr, this.f100199b, this.f100200c);
                            }
                            byte[] a16 = a(bArr, this.f100199b, this.f100200c);
                            if (a16 == null) {
                                try {
                                    b(bArr);
                                    if (a16 != null && (pVar3 = a.C1020a.f100297a.f100296a) != null) {
                                        pVar3.release(a16);
                                    }
                                    b(bArr);
                                } catch (Exception e18) {
                                    bArr2 = a16;
                                    e16 = e18;
                                    k.a.f100197a.a(2, "VideoRecorderManager", "record video has some error! " + e16.getLocalizedMessage());
                                    this.f100207j = true;
                                    if (bArr2 != null && (pVar2 = a.C1020a.f100297a.f100296a) != null) {
                                        pVar2.release(bArr2);
                                    }
                                    b(bArr);
                                } catch (Throwable th5) {
                                    th = th5;
                                    bArr2 = a16;
                                    poll = bArr;
                                    if (bArr2 != null && (pVar = a.C1020a.f100297a.f100296a) != null) {
                                        pVar.release(bArr2);
                                    }
                                    b(poll);
                                    throw th;
                                }
                            } else {
                                a(a16, j3);
                                com.tencent.could.huiyansdk.utils.p<byte[]> pVar4 = a.C1020a.f100297a.f100296a;
                                if (pVar4 != null) {
                                    pVar4.release(a16);
                                }
                                b(bArr);
                            }
                        } catch (Exception e19) {
                            e16 = e19;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Exception e26) {
                    bArr = poll;
                    e16 = e26;
                } catch (Throwable th7) {
                    th = th7;
                }
            }
        }
        synchronized (this.f100206i) {
            try {
                try {
                    MediaMuxer mediaMuxer = this.f100202e;
                    if (mediaMuxer != null) {
                        try {
                            mediaMuxer.stop();
                        } catch (IllegalStateException e27) {
                            k.a.f100197a.a(2, "VideoRecorderManager", "mediaMuxer.stop(): " + e27.getLocalizedMessage());
                        }
                        this.f100202e.release();
                        this.f100202e = null;
                    }
                    MediaCodec mediaCodec = this.f100201d;
                    if (mediaCodec != null) {
                        mediaCodec.stop();
                        this.f100201d.release();
                        this.f100201d = null;
                    }
                    obj = this.f100206i;
                } catch (Throwable th8) {
                    this.f100206i.notifyAll();
                    throw th8;
                }
            } catch (RuntimeException e28) {
                k.a.f100197a.a(2, "VideoRecorderManager", "release media state error! e: " + e28.getLocalizedMessage());
                obj = this.f100206i;
            }
            obj.notifyAll();
            if (this.f100208k) {
                Log.d("VideoRecorderManager", "delete All Temp video by temp!");
                a();
            }
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (d()) {
            k.a.f100197a.a(2, "VideoRecorderManager", "start thread not need video!");
        } else {
            this.f100210m = System.nanoTime();
            q.a.f100321a.a(new Runnable() { // from class: com.tencent.could.huiyansdk.manager.r
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.g();
                }
            });
        }
    }

    public final String a(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        HuiYanBaseApi huiYanBaseApi = HuiYanBaseApi.b.f100031a;
        Context a16 = huiYanBaseApi.a();
        if (a16 == null) {
            k.a.f100197a.a(2, "VideoRecorderManager", "Context is null");
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("cloud-huiyan");
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append("video");
        sb5.append(str3);
        sb5.append(str);
        String sb6 = sb5.toString();
        if (huiYanBaseApi.f100030d) {
            str2 = a16.getExternalFilesDir(null) + str3 + sb6;
        } else {
            str2 = a16.getFilesDir() + str3 + sb6;
        }
        File file = new File(str2);
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            k.a.f100197a.a(2, "VideoRecorderManager", "Create parent dir error!");
        }
        if (file.exists() && !file.delete()) {
            k.a.f100197a.a(2, "VideoRecorderManager", "delete last video error!");
        }
        return str2;
    }

    public final void b(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bArr);
            return;
        }
        com.tencent.could.huiyansdk.utils.p<byte[]> pVar = a.C1020a.f100297a.f100296a;
        if (pVar == null) {
            return;
        }
        pVar.release(bArr);
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        HuiYanSdkConfig sdkConfig = HuiYanSdkImp.getInstance().getSdkConfig();
        return (sdkConfig != null && sdkConfig.isLandMode()) ? 0 : 90;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) ? (this.f100214q && this.f100211n && !this.f100213p) ? false : true : ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
    }

    public void c(final com.tencent.could.huiyansdk.callback.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) hVar);
            return;
        }
        if (d()) {
            if (hVar != null) {
                hVar.a(false, "");
            }
        } else if (!this.f100207j) {
            q.a.f100321a.a(new Runnable() { // from class: com.tencent.could.huiyansdk.manager.p
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.b(hVar);
                }
            });
        } else if (hVar != null) {
            hVar.a(false, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.tencent.could.huiyansdk.callback.h hVar) {
        synchronized (this.f100206i) {
            try {
                this.f100207j = true;
                LockMethodProxy.wait(this.f100206i);
            } catch (InterruptedException unused) {
                k.a.f100197a.a(2, "VideoRecorderManager", "wait thread is interrupted!");
            }
            String a16 = a(hVar);
            if (!TextUtils.isEmpty(a16) && this.f100204g.equals(a16) && CommonUtils.copyFile(this.f100204g, this.f100205h)) {
                a16 = this.f100205h;
            }
            if (hVar != null) {
                hVar.a(true, a16);
            }
            a();
        }
    }

    public final byte[] c(byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (byte[]) iPatchRedirector.redirect((short) 13, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        byte[] a16 = a.C1020a.f100297a.a();
        if (a16 == null) {
            a16 = new byte[((i3 * i16) * 3) / 2];
        }
        int i18 = i3 * i16;
        for (int i19 = i18 - 1; i19 >= 0; i19--) {
            a16[i17] = bArr[i19];
            i17++;
        }
        for (int i26 = ((i18 * 3) / 2) - 1; i26 >= i18; i26 -= 2) {
            int i27 = i17 + 1;
            a16[i17] = bArr[i26 - 1];
            i17 = i27 + 1;
            a16[i27] = bArr[i26];
        }
        b(bArr);
        return a16;
    }

    public final void b(byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int i18 = 0;
        while (i18 < i16) {
            int i19 = i18 * i3;
            i18++;
            for (int i26 = (i18 * i3) - 1; i19 < i26; i26--) {
                byte b16 = bArr[i19];
                bArr[i19] = bArr[i26];
                bArr[i26] = b16;
                i19++;
            }
        }
        int i27 = i3 * i16;
        while (i17 < i16 / 2) {
            int i28 = i17 * i3;
            i17++;
            for (int i29 = (i17 * i3) - 2; i28 < i29; i29 -= 2) {
                int i36 = i28 + i27;
                byte b17 = bArr[i36];
                int i37 = i29 + i27;
                bArr[i36] = bArr[i37];
                bArr[i37] = b17;
                int i38 = i36 + 1;
                byte b18 = bArr[i38];
                int i39 = i37 + 1;
                bArr[i38] = bArr[i39];
                bArr[i39] = b18;
                i28 += 2;
            }
        }
    }

    public final boolean a(int i3, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) iArr)).booleanValue();
        }
        for (int i16 : iArr) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    public void a(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f100215r = false;
        this.f100199b = i3;
        this.f100200c = i16;
        if (HuiYanSdkImp.getInstance().isUsing720p()) {
            this.f100215r = true;
            this.f100200c = 704;
        } else {
            this.f100200c = TroopInfo.PAY_PRIVILEGE_ALL;
        }
        if (5 == i17) {
            this.f100217t = true;
        }
        HuiYanSdkConfig sdkConfig = HuiYanSdkImp.getInstance().getSdkConfig();
        if (sdkConfig != null && sdkConfig.isUseBackCamera()) {
            this.f100216s = false;
        }
        this.f100218u = i3;
        this.f100219v = i16;
        q.a.f100321a.a(new Runnable() { // from class: com.tencent.could.huiyansdk.manager.q
            @Override // java.lang.Runnable
            public final void run() {
                l.this.f();
            }
        });
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        HuiYanSdkConfig sdkConfig = HuiYanSdkImp.getInstance().getSdkConfig();
        if (sdkConfig == null) {
            return;
        }
        this.f100214q = sdkConfig.isRecordVideo();
        if (sdkConfig.isDeleteVideoCache()) {
            q.a.f100321a.a(new Runnable() { // from class: com.tencent.could.huiyansdk.manager.s
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.e();
                }
            });
        }
    }

    public final String a(com.tencent.could.huiyansdk.callback.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) hVar);
        }
        if (d()) {
            k.a.f100197a.a(2, "VideoRecorderManager", "cutVideoTheVideo do not need video");
            return "";
        }
        if (!HuiYanSdkImp.getInstance().isNeedCutRecordVideo()) {
            return this.f100204g;
        }
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(this.f100204g);
            int i3 = 0;
            try {
                while (i3 < mediaExtractor.getTrackCount()) {
                    if (!mediaExtractor.getTrackFormat(i3).getString("mime").startsWith("video/")) {
                        i3++;
                    }
                }
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
                mediaExtractor.selectTrack(i3);
                long j3 = trackFormat.getLong("durationUs") - (HuiYanSdkImp.getInstance().getCutVideoDuration() * 1000);
                if (j3 < 0) {
                    mediaExtractor.release();
                    k.a.f100197a.a(2, "VideoRecorderManager", "use order video!");
                    return this.f100204g;
                }
                mediaExtractor.seekTo(j3, 0);
                if (!trackFormat.containsKey("max-input-size")) {
                    int integer = trackFormat.getInteger("height");
                    if (trackFormat.containsKey("max-height")) {
                        integer = Math.max(integer, trackFormat.getInteger("max-height"));
                    }
                    int integer2 = trackFormat.getInteger("width");
                    if (trackFormat.containsKey("max-width")) {
                        integer2 = Math.max(integer, trackFormat.getInteger("max-width"));
                    }
                    trackFormat.setInteger("max-input-size", ((((((integer2 + 15) / 16) * ((integer + 15) / 16)) * 16) * 16) * 3) / 4);
                }
                ByteBuffer allocate = ByteBuffer.allocate(trackFormat.getInteger("max-input-size"));
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                MediaMuxer mediaMuxer = new MediaMuxer(this.f100205h, 0);
                int addTrack = mediaMuxer.addTrack(trackFormat);
                mediaMuxer.setOrientationHint(c());
                mediaMuxer.start();
                while (true) {
                    int readSampleData = mediaExtractor.readSampleData(allocate, 0);
                    if (readSampleData < 0) {
                        break;
                    }
                    int sampleFlags = mediaExtractor.getSampleFlags();
                    bufferInfo.offset = 0;
                    bufferInfo.size = readSampleData;
                    bufferInfo.flags = sampleFlags;
                    bufferInfo.presentationTimeUs = mediaExtractor.getSampleTime();
                    mediaMuxer.writeSampleData(addTrack, allocate, bufferInfo);
                    mediaExtractor.advance();
                }
                mediaExtractor.unselectTrack(i3);
                try {
                    mediaMuxer.stop();
                } catch (IllegalStateException e16) {
                    k.a.f100197a.a(2, "VideoRecorderManager", "cutMediaMuxer.stop(): " + e16.getLocalizedMessage());
                }
                mediaMuxer.release();
                mediaExtractor.release();
                return this.f100205h;
            } catch (IllegalArgumentException unused) {
                mediaExtractor.release();
                if (l.a.f100309a.f100307a) {
                    AiLog.error("VideoRecorderManager", "mediaExtractor.getTrackFormat(sourceVideoTrack) IllegalArgumentException ");
                }
                return this.f100204g;
            }
            i3 = 0;
        } catch (IOException unused2) {
            k.a.f100197a.a(2, "VideoRecorderManager", "Open Video Fail!");
            if (hVar != null) {
                hVar.a(true, "");
            }
            a();
            return null;
        }
    }

    public final void a(byte[] bArr, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, bArr, Long.valueOf(j3));
            return;
        }
        ByteBuffer[] inputBuffers = this.f100201d.getInputBuffers();
        ByteBuffer[] outputBuffers = this.f100201d.getOutputBuffers();
        int dequeueInputBuffer = this.f100201d.dequeueInputBuffer(0L);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
            byteBuffer.clear();
            byteBuffer.put(bArr);
            this.f100201d.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, (System.nanoTime() - j3) / 1000, 0);
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int dequeueOutputBuffer = this.f100201d.dequeueOutputBuffer(bufferInfo, 0L);
        if (dequeueOutputBuffer == -2) {
            int addTrack = this.f100202e.addTrack(this.f100201d.getOutputFormat());
            this.f100203f = addTrack;
            if (addTrack >= 0) {
                this.f100202e.start();
            }
        }
        while (dequeueOutputBuffer > 0) {
            ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
            int i3 = this.f100203f;
            if (i3 >= 0) {
                this.f100202e.writeSampleData(i3, byteBuffer2, bufferInfo);
            }
            this.f100201d.releaseOutputBuffer(dequeueOutputBuffer, false);
            dequeueOutputBuffer = this.f100201d.dequeueOutputBuffer(bufferInfo, 0L);
        }
    }

    public final byte[] a(byte[] bArr, int i3, int i16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (byte[]) iPatchRedirector.redirect((short) 11, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (bArr == null) {
            return null;
        }
        int i18 = this.f100212o;
        if (i18 == 19) {
            byte[] a16 = a.C1020a.f100297a.a();
            if (a16 == null) {
                a16 = new byte[((i3 * i16) * 3) / 2];
            }
            int i19 = i3 * i16;
            ByteBuffer wrap = ByteBuffer.wrap(a16, 0, i19);
            int i26 = i19 / 4;
            ByteBuffer wrap2 = ByteBuffer.wrap(a16, i19, i26);
            ByteBuffer wrap3 = ByteBuffer.wrap(a16, i19 + i26, i26);
            wrap.put(bArr, 0, i19);
            while (i19 < bArr.length) {
                wrap3.put(bArr[i19]);
                wrap2.put(bArr[i19 + 1]);
                i19 += 2;
            }
            return a16;
        }
        if (i18 != 21) {
            return null;
        }
        byte[] a17 = a.C1020a.f100297a.a();
        if (a17 == null) {
            a17 = new byte[((i3 * i16) * 3) / 2];
        }
        int i27 = i3 * i16;
        for (int i28 = 0; i28 < i27; i28++) {
            a17[i28] = bArr[i28];
        }
        int i29 = 0;
        while (true) {
            i17 = i27 / 2;
            if (i29 >= i17) {
                break;
            }
            int i36 = i27 + i29;
            a17[i36 - 1] = bArr[i36];
            i29 += 2;
        }
        for (int i37 = 0; i37 < i17; i37 += 2) {
            int i38 = i27 + i37;
            a17[i38] = bArr[i38 - 1];
        }
        return a17;
    }

    public final byte[] a(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (byte[]) iPatchRedirector.redirect((short) 12, (Object) this, (Object) bArr);
        }
        if (this.f100215r) {
            int i3 = this.f100218u;
            int i16 = this.f100219v;
            return CommonUtils.clipNV21(bArr, i3, i16, (i3 - 1280) / 2, (i16 + CallbackErrorCode.HY_INNER_CAMERA_VIEW_IS_NULL) / 2, 1280, 704);
        }
        int i17 = this.f100218u;
        int i18 = this.f100219v;
        return CommonUtils.clipNV21(bArr, i17, i18, (i17 - 640) / 2, (i18 - 448) / 2, 640, TroopInfo.PAY_PRIVILEGE_ALL);
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        String str = this.f100204g;
        File file = new File(str);
        if (file.exists() && !file.delete()) {
            Log.e("VideoRecorderManager", "delete temp video error path:" + str);
        }
    }
}
