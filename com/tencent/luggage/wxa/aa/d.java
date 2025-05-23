package com.tencent.luggage.wxa.aa;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.io.Closeable;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public double G = -1.0d;
    public double H = -1.0d;
    public double I = 0.0d;

    /* renamed from: a, reason: collision with root package name */
    public ExifInterface f120977a;

    /* renamed from: b, reason: collision with root package name */
    public String f120978b;

    /* renamed from: c, reason: collision with root package name */
    public String f120979c;

    /* renamed from: d, reason: collision with root package name */
    public String f120980d;

    /* renamed from: e, reason: collision with root package name */
    public short f120981e;

    /* renamed from: f, reason: collision with root package name */
    public short f120982f;

    /* renamed from: g, reason: collision with root package name */
    public String f120983g;

    /* renamed from: h, reason: collision with root package name */
    public String f120984h;

    /* renamed from: i, reason: collision with root package name */
    public String f120985i;

    /* renamed from: j, reason: collision with root package name */
    public String f120986j;

    /* renamed from: k, reason: collision with root package name */
    public String f120987k;

    /* renamed from: l, reason: collision with root package name */
    public String f120988l;

    /* renamed from: m, reason: collision with root package name */
    public double f120989m;

    /* renamed from: n, reason: collision with root package name */
    public double f120990n;

    /* renamed from: o, reason: collision with root package name */
    public short f120991o;

    /* renamed from: p, reason: collision with root package name */
    public double f120992p;

    /* renamed from: q, reason: collision with root package name */
    public double f120993q;

    /* renamed from: r, reason: collision with root package name */
    public double f120994r;

    /* renamed from: s, reason: collision with root package name */
    public double f120995s;

    /* renamed from: t, reason: collision with root package name */
    public double f120996t;

    /* renamed from: u, reason: collision with root package name */
    public double f120997u;

    /* renamed from: v, reason: collision with root package name */
    public double f120998v;

    /* renamed from: w, reason: collision with root package name */
    public byte f120999w;

    /* renamed from: x, reason: collision with root package name */
    public short f121000x;

    /* renamed from: y, reason: collision with root package name */
    public int f121001y;

    /* renamed from: z, reason: collision with root package name */
    public String f121002z;

    public int a() {
        ExifInterface exifInterface = this.f120977a;
        if (exifInterface != null) {
            return exifInterface.getRotationDegrees();
        }
        short s16 = this.f120981e;
        if (s16 == 3) {
            return 180;
        }
        if (s16 != 6) {
            return s16 != 8 ? 0 : 270;
        }
        return 90;
    }

    public int b(String str) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = x.n(str);
                this.f120977a = new ExifInterface(inputStream);
                b();
                return 0;
            } catch (OutOfMemoryError e16) {
                w.a("MicroMsg.Exif", e16, "parseFromFile", new Object[0]);
                return 0;
            } catch (Throwable th5) {
                w.h("MicroMsg.Exif", "Cannot read EXIF from file '%s': %s", str, th5.getMessage());
                w0.a((Closeable) inputStream);
                return -1;
            }
        } finally {
            w0.a((Closeable) null);
        }
    }

    public static d a(String str) {
        d dVar = new d();
        dVar.b(str);
        return dVar;
    }

    public final void b() {
        ExifInterface exifInterface = this.f120977a;
        if (exifInterface == null) {
            return;
        }
        this.f120978b = exifInterface.getAttribute("ImageDescription");
        this.f120979c = this.f120977a.getAttribute("Make");
        this.f120980d = this.f120977a.getAttribute("Model");
        this.f120981e = (short) this.f120977a.getAttributeInt("Orientation", 0);
        this.f120982f = (short) this.f120977a.getAttributeInt("BitsPerSample", 0);
        this.f120983g = this.f120977a.getAttribute("Software");
        this.f120984h = this.f120977a.getAttribute("DateTime");
        this.f120985i = this.f120977a.getAttribute("DateTimeOriginal");
        this.f120986j = this.f120977a.getAttribute("DateTimeDigitized");
        this.f120987k = this.f120977a.getAttribute("SubSecTimeOriginal");
        this.f120988l = this.f120977a.getAttribute("Copyright");
        this.f120989m = this.f120977a.getAttributeDouble("ExposureTime", 0.0d);
        this.f120990n = this.f120977a.getAttributeDouble("FNumber", 0.0d);
        this.f120991o = (short) this.f120977a.getAttributeInt("ISOSpeedRatings", 0);
        this.f120992p = this.f120977a.getAttributeDouble("BrightnessValue", 0.0d);
        this.f120993q = this.f120977a.getAttributeDouble("ApertureValue", 0.0d);
        this.f120994r = this.f120977a.getAttributeDouble("MaxApertureValue", 0.0d);
        this.f120996t = this.f120977a.getAttributeDouble("ExposureBiasValue", 0.0d);
        this.f120997u = this.f120977a.getAttributeDouble("SubjectDistance", 0.0d);
        this.f120995s = this.f120977a.getAttributeDouble("ShutterSpeedValue", 0.0d);
        this.f120998v = this.f120977a.getAttributeDouble("FocalLength", 0.0d);
        this.f121000x = (short) this.f120977a.getAttributeInt("MeteringMode", 0);
        this.f121001y = this.f120977a.getAttributeInt("WhiteBalance", 0);
        this.f121002z = this.f120977a.getAttribute(ExifInterface.TAG_LENS_MODEL);
        this.f120991o = (short) this.f120977a.getAttributeInt("ISOSpeedRatings", 0);
        this.f120999w = (byte) this.f120977a.getAttributeInt("Flash", 0);
        this.C = this.f120977a.getAttributeInt("ImageWidth", 0);
        this.D = this.f120977a.getAttributeInt("ImageLength", 0);
        this.A = this.f120977a.getAttributeInt("XResolution", 72);
        this.B = this.f120977a.getAttributeInt("YResolution", 72);
        this.E = this.f120977a.getAttributeInt("FileSource", 0);
        this.F = this.f120977a.getAttributeInt("SceneType", 0);
        double[] latLong = this.f120977a.getLatLong();
        if (latLong != null) {
            this.G = latLong[0];
            this.H = latLong[1];
        }
        this.I = this.f120977a.getAltitude(0.0d);
    }
}
