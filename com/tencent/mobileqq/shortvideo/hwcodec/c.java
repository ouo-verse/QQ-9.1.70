package com.tencent.mobileqq.shortvideo.hwcodec;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes18.dex */
public class c {

    /* renamed from: g, reason: collision with root package name */
    public static int f288005g = 1;

    /* renamed from: h, reason: collision with root package name */
    public static int f288006h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static String f288007i = "video/avc";

    /* renamed from: j, reason: collision with root package name */
    public static String f288008j = "AndroidCodec";

    /* renamed from: k, reason: collision with root package name */
    protected static Method f288009k = null;

    /* renamed from: l, reason: collision with root package name */
    protected static Method f288010l = null;

    /* renamed from: m, reason: collision with root package name */
    protected static Method f288011m = null;

    /* renamed from: n, reason: collision with root package name */
    protected static Method f288012n = null;

    /* renamed from: o, reason: collision with root package name */
    protected static boolean f288013o = true;

    /* renamed from: a, reason: collision with root package name */
    protected MediaFormat f288014a;

    /* renamed from: b, reason: collision with root package name */
    protected MediaFormat f288015b;

    /* renamed from: c, reason: collision with root package name */
    protected MediaCodec f288016c;

    /* renamed from: d, reason: collision with root package name */
    protected ByteBuffer[] f288017d;

    /* renamed from: e, reason: collision with root package name */
    protected ByteBuffer[] f288018e;

    /* renamed from: f, reason: collision with root package name */
    protected int f288019f = f288006h;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public ByteBuffer f288020a;

        /* renamed from: b, reason: collision with root package name */
        public MediaFormat f288021b;

        /* renamed from: c, reason: collision with root package name */
        public int f288022c;

        /* renamed from: d, reason: collision with root package name */
        public MediaCodec.BufferInfo f288023d = new MediaCodec.BufferInfo();

        /* renamed from: e, reason: collision with root package name */
        public boolean f288024e = true;

        public a() {
        }
    }

    public c() {
        i();
        if (f288012n == null) {
            try {
                f288012n = MediaCodec.class.getMethod("setParameters", Bundle.class);
            } catch (NoSuchMethodException unused) {
                f288012n = null;
            }
        }
    }

    public static MediaCodecInfo.CodecCapabilities b(MediaCodecInfo mediaCodecInfo, String str) {
        try {
            return mediaCodecInfo.getCapabilitiesForType(str);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(f288008j, 2, "getCodecCapabilities erro", e16);
                return null;
            }
            return null;
        }
    }

    public static MediaCodecInfo c(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i3 = 0; i3 < codecCount; i3++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
            if (codecInfoAt.getName().equalsIgnoreCase(str)) {
                return codecInfoAt;
            }
        }
        return null;
    }

    public static List<MediaCodecInfo> d(String str, boolean z16) {
        ArrayList arrayList = new ArrayList();
        int codecCount = MediaCodecList.getCodecCount();
        for (int i3 = 0; i3 < codecCount; i3++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
            if (codecInfoAt.isEncoder() && (!z16 || (!codecInfoAt.getName().contains(".sw.") && !codecInfoAt.getName().contains(".SW.") && !codecInfoAt.getName().contains("google") && !codecInfoAt.getName().contains("Google") && !codecInfoAt.getName().contains("GOOGLE")))) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        arrayList.add(codecInfoAt);
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<MediaCodecInfo> g(String str) {
        ArrayList arrayList = new ArrayList();
        int codecCount = MediaCodecList.getCodecCount();
        for (int i3 = 0; i3 < codecCount; i3++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
            if (codecInfoAt.isEncoder() && (codecInfoAt.getName().contains(".sw.") || codecInfoAt.getName().contains(".SW.") || codecInfoAt.getName().contains("google") || codecInfoAt.getName().contains("Google") || codecInfoAt.getName().contains("GOOGLE"))) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        arrayList.add(codecInfoAt);
                    }
                }
            }
        }
        return arrayList;
    }

    protected static void i() {
        try {
            if (f288009k == null) {
                f288009k = MediaCodec.class.getMethod("getInputBuffer", Integer.TYPE);
            }
            if (f288010l == null) {
                f288010l = MediaCodec.class.getMethod("getOutputBuffer", Integer.TYPE);
            }
            if (f288011m == null) {
                f288011m = MediaCodec.class.getMethod("getOutputFormat", Integer.TYPE);
            }
        } catch (Exception unused) {
            f288009k = null;
            f288010l = null;
            f288011m = null;
            f288013o = false;
        }
    }

    public synchronized a a(long j3) {
        if (this.f288016c == null) {
            return null;
        }
        a aVar = new a();
        int dequeueOutputBuffer = this.f288016c.dequeueOutputBuffer(aVar.f288023d, j3);
        if (dequeueOutputBuffer != -3) {
            if (dequeueOutputBuffer != -2) {
                if (dequeueOutputBuffer != -1) {
                    if (dequeueOutputBuffer < 0) {
                        return null;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f288008j, 2, "dequeueOutputBuffer ok,index = " + dequeueOutputBuffer + ",BufferInfo[flags = " + aVar.f288023d.flags + ",offset=" + aVar.f288023d.offset + ",size= " + aVar.f288023d.size + ",TimeUs=" + aVar.f288023d.presentationTimeUs + "]");
                    }
                    aVar.f288022c = dequeueOutputBuffer;
                    try {
                        try {
                            aVar.f288020a = (ByteBuffer) f288010l.invoke(this.f288016c, Integer.valueOf(dequeueOutputBuffer));
                            aVar.f288021b = (MediaFormat) f288011m.invoke(this.f288016c, Integer.valueOf(dequeueOutputBuffer));
                        } catch (IllegalAccessException e16) {
                            e16.printStackTrace();
                            aVar.f288024e = false;
                        } catch (InvocationTargetException e17) {
                            e17.printStackTrace();
                            aVar.f288024e = false;
                        }
                    } catch (IllegalArgumentException e18) {
                        e18.printStackTrace();
                        aVar.f288024e = false;
                    }
                    return aVar;
                }
                if (QLog.isColorLevel()) {
                    QLog.e(f288008j, 2, "dequeueOutputBuffer timed out!");
                }
                aVar.f288022c = -1;
                return aVar;
            }
            aVar.f288022c = -2;
            MediaFormat outputFormat = this.f288016c.getOutputFormat();
            this.f288015b = outputFormat;
            if (outputFormat != null) {
                if (this.f288019f == f288006h) {
                    try {
                        int integer = outputFormat.getInteger("color-format");
                        if (QLog.isColorLevel()) {
                            QLog.e(f288008j, 2, "New color format " + integer + "[0x" + Integer.toHexString(integer) + "]");
                        }
                    } catch (Exception unused) {
                        if (QLog.isColorLevel()) {
                            QLog.e(f288008j, 2, "Exception,INFO_OUTPUT_FORMAT_CHANGED");
                        }
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.e(f288008j, 2, "EncCodec,INFO_OUTPUT_FORMAT_CHANGED");
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e(f288008j, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
        }
        this.f288018e = this.f288016c.getOutputBuffers();
        aVar.f288022c = -3;
        return aVar;
    }

    public MediaCodec e() {
        return this.f288016c;
    }

    public a f(long j3) {
        if (this.f288016c == null) {
            return null;
        }
        a aVar = new a();
        int dequeueInputBuffer = this.f288016c.dequeueInputBuffer(j3);
        if (dequeueInputBuffer >= 0) {
            synchronized (this) {
                aVar.f288022c = dequeueInputBuffer;
                try {
                    try {
                        aVar.f288020a = (ByteBuffer) f288009k.invoke(this.f288016c, Integer.valueOf(dequeueInputBuffer));
                    } catch (IllegalAccessException e16) {
                        e16.printStackTrace();
                        aVar.f288024e = false;
                    } catch (IllegalArgumentException e17) {
                        e17.printStackTrace();
                        aVar.f288024e = false;
                    }
                } catch (InvocationTargetException e18) {
                    e18.printStackTrace();
                    aVar.f288024e = false;
                }
            }
            return aVar;
        }
        aVar.f288022c = dequeueInputBuffer;
        return aVar;
    }

    public boolean h(MediaFormat mediaFormat, String str) {
        int i3;
        this.f288014a = mediaFormat;
        MediaCodecInfo c16 = c(str);
        if (c16 != null && c16.isEncoder()) {
            this.f288019f = f288005g;
            i3 = 1;
        } else {
            i3 = 0;
        }
        try {
            MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
            this.f288016c = createByCodecName;
            if (createByCodecName != null) {
                try {
                    createByCodecName.configure(this.f288014a, (Surface) null, (MediaCrypto) null, i3);
                } catch (Exception e16) {
                    e16.printStackTrace();
                    this.f288016c.release();
                    this.f288016c = null;
                    return false;
                }
            }
            if (this.f288016c != null) {
                return true;
            }
            return false;
        } catch (Exception e17) {
            e17.printStackTrace();
            return false;
        }
    }

    public synchronized void j(a aVar, int i3, long j3, int i16) {
        MediaCodec mediaCodec = this.f288016c;
        if (mediaCodec != null) {
            mediaCodec.queueInputBuffer(aVar.f288022c, 0, i3, j3, i16);
        }
    }

    public synchronized void k() {
        this.f288017d = null;
        this.f288018e = null;
        MediaCodec mediaCodec = this.f288016c;
        if (mediaCodec != null) {
            mediaCodec.release();
            this.f288016c = null;
        }
    }

    public synchronized void l(a aVar) {
        MediaCodec mediaCodec = this.f288016c;
        if (mediaCodec != null) {
            mediaCodec.releaseOutputBuffer(aVar.f288022c, false);
            if (QLog.isColorLevel()) {
                QLog.d(f288008j, 2, "releaseOutputBuffer index = " + aVar.f288022c);
            }
        }
    }

    public boolean m() {
        try {
            MediaCodec mediaCodec = this.f288016c;
            if (mediaCodec != null) {
                mediaCodec.start();
                return true;
            }
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public void n() {
        MediaCodec mediaCodec = this.f288016c;
        if (mediaCodec != null) {
            mediaCodec.stop();
        }
    }
}
