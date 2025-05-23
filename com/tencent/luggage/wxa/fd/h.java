package com.tencent.luggage.wxa.fd;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.LongSparseArray;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.y0;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem;
import com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter;
import common.config.service.QzoneConfig;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h implements Parcelable {
    public static final Parcelable.Creator<h> CREATOR;

    /* renamed from: n0, reason: collision with root package name */
    public static volatile h f125725n0;

    /* renamed from: o0, reason: collision with root package name */
    public static final h f125726o0;
    public int[] C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public String[] O;
    public double P;
    public int Q;
    public int R;
    public int S;
    public long T;
    public long U;
    public C6208h V;
    public f W;
    public long X;
    public String[] Y;
    public int Z;

    /* renamed from: a, reason: collision with root package name */
    public int f125727a;

    /* renamed from: a0, reason: collision with root package name */
    public int f125728a0;

    /* renamed from: b, reason: collision with root package name */
    public int f125729b;

    /* renamed from: b0, reason: collision with root package name */
    public int f125730b0;

    /* renamed from: c, reason: collision with root package name */
    public int f125731c;

    /* renamed from: c0, reason: collision with root package name */
    public String[] f125732c0;

    /* renamed from: d, reason: collision with root package name */
    public int f125733d;

    /* renamed from: d0, reason: collision with root package name */
    public long f125734d0;

    /* renamed from: e, reason: collision with root package name */
    public int f125735e;

    /* renamed from: e0, reason: collision with root package name */
    public int f125736e0;

    /* renamed from: f, reason: collision with root package name */
    public int f125737f;

    /* renamed from: f0, reason: collision with root package name */
    public int f125738f0;

    /* renamed from: g, reason: collision with root package name */
    public int f125739g;

    /* renamed from: g0, reason: collision with root package name */
    public String f125740g0;

    /* renamed from: h, reason: collision with root package name */
    public int f125741h;

    /* renamed from: h0, reason: collision with root package name */
    public g f125742h0;

    /* renamed from: i, reason: collision with root package name */
    public int f125743i;

    /* renamed from: i0, reason: collision with root package name */
    public d f125744i0;

    /* renamed from: j, reason: collision with root package name */
    public int f125745j;

    /* renamed from: j0, reason: collision with root package name */
    public double f125746j0;

    /* renamed from: k, reason: collision with root package name */
    public String f125747k;

    /* renamed from: k0, reason: collision with root package name */
    public String f125748k0;

    /* renamed from: l, reason: collision with root package name */
    public String f125749l;

    /* renamed from: l0, reason: collision with root package name */
    public String[] f125750l0;

    /* renamed from: m, reason: collision with root package name */
    public e f125751m;

    /* renamed from: m0, reason: collision with root package name */
    public String f125752m0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Function1 {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.fd.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6207a implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LinkedList f125754a;

            public C6207a(LinkedList linkedList) {
                this.f125754a = linkedList;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(String str) {
                this.f125754a.add(str);
                return Unit.INSTANCE;
            }
        }

        public a() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(JSONObject jSONObject) {
            try {
                LinkedList linkedList = new LinkedList();
                com.tencent.luggage.wxa.e5.f.a(jSONObject.getJSONArray("list"), new C6207a(linkedList));
                h.this.V.f125794e.put(jSONObject.getLong("UsedTime"), linkedList);
            } catch (JSONException unused) {
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public h createFromParcel(Parcel parcel) {
            return new h(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public h[] newArray(int i3) {
            return new h[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {

        /* renamed from: a, reason: collision with root package name */
        public static final String f125756a = "https://" + y0.a(R.string.f159101re) + "";

        /* renamed from: b, reason: collision with root package name */
        public static final int[] f125757b = new int[0];

        /* renamed from: c, reason: collision with root package name */
        public static final String[] f125758c = {"https://wx.qlogo.cn/"};

        /* renamed from: d, reason: collision with root package name */
        public static final String[] f125759d = new String[0];

        /* renamed from: e, reason: collision with root package name */
        public static final String[] f125760e = new String[0];

        /* renamed from: f, reason: collision with root package name */
        public static final String f125761f = null;

        /* renamed from: g, reason: collision with root package name */
        public static final String[] f125762g = new String[0];
    }

    static {
        h hVar = new h();
        f125726o0 = hVar;
        hVar.f125729b = 5;
        hVar.f125731c = 1;
        hVar.f125733d = 300;
        hVar.f125735e = 50;
        hVar.f125737f = 1048576;
        hVar.f125739g = 1048576;
        hVar.f125741h = 20971520;
        hVar.f125743i = 200;
        hVar.f125745j = MiniAppRealTimeLogReporter.MAX_CONTENT_SIZE;
        hVar.C = c.f125757b;
        hVar.D = 50;
        hVar.E = 11;
        hVar.F = 12;
        hVar.H = TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC;
        hVar.I = 307200;
        hVar.J = 25;
        hVar.K = 104857600;
        hVar.L = QzoneConfig.DefaultValue.DEFAUL_VIDEO_TRIM_ULTRAFAST_AVAIL_RAM;
        hVar.M = 1;
        hVar.N = 50;
        hVar.O = c.f125758c;
        hVar.P = 0.0d;
        hVar.Q = 60;
        hVar.R = 60;
        hVar.S = 6;
        hVar.V = new C6208h();
        hVar.W = new f();
        hVar.X = 30L;
        hVar.Y = c.f125759d;
        hVar.Z = 10;
        hVar.f125730b0 = 86400;
        hVar.f125732c0 = c.f125760e;
        hVar.f125734d0 = 60L;
        hVar.f125736e0 = 1;
        hVar.f125738f0 = 1;
        hVar.f125748k0 = c.f125761f;
        CREATOR = new b();
    }

    public h() {
        this.f125727a = Integer.MAX_VALUE;
        this.f125751m = new e();
        this.f125742h0 = new g();
        this.f125744i0 = new d();
    }

    public static String a() {
        com.tencent.luggage.wxa.cp.v vVar = new com.tencent.luggage.wxa.cp.v(com.tencent.luggage.wxa.db.a.b(), "wxaapp/res/");
        if (!vVar.e()) {
            vVar.w();
        }
        return new com.tencent.luggage.wxa.cp.v(vVar, "AppService.conf").g();
    }

    public static h b() {
        h c16 = c();
        if (c16 == null) {
            return f125726o0;
        }
        return c16;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004a A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c A[Catch: all -> 0x0056, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0003, B:8:0x000a, B:9:0x0044, B:14:0x004c, B:24:0x0014, B:17:0x0023, B:19:0x002e, B:21:0x0036, B:25:0x0052), top: B:3:0x0003, inners: #3, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized h c() {
        String str;
        synchronized (h.class) {
            if (f125725n0 == null) {
                try {
                    str = com.tencent.luggage.wxa.cp.x.p(a());
                } catch (FileNotFoundException e16) {
                    ((com.tencent.luggage.wxa.k4.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class)).t();
                    try {
                        str = com.tencent.luggage.wxa.tk.c.b("wxa_library/AppService.conf");
                    } catch (Exception unused) {
                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandGlobalSystemConfig", "read config file from assets, get exception:%s", e16);
                        str = null;
                        if (w0.c(str)) {
                        }
                    }
                } catch (IOException e17) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandGlobalSystemConfig", "read config file, exp = %s", e17);
                    str = null;
                    if (w0.c(str)) {
                    }
                }
                if (w0.c(str)) {
                    return null;
                }
                f125725n0 = a(str);
            }
            return f125725n0;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f125727a);
        parcel.writeInt(this.f125729b);
        parcel.writeInt(this.f125731c);
        parcel.writeInt(this.f125733d);
        parcel.writeInt(this.f125735e);
        parcel.writeInt(this.f125737f);
        parcel.writeInt(this.f125739g);
        parcel.writeInt(this.f125741h);
        parcel.writeInt(this.f125743i);
        parcel.writeInt(this.f125745j);
        parcel.writeString(this.f125747k);
        parcel.writeString(this.f125749l);
        parcel.writeParcelable(this.f125751m, i3);
        parcel.writeIntArray(this.C);
        parcel.writeInt(this.D);
        parcel.writeInt(this.E);
        parcel.writeInt(this.H);
        parcel.writeInt(this.I);
        parcel.writeInt(this.J);
        parcel.writeInt(this.K);
        parcel.writeInt(this.L);
        parcel.writeInt(this.M);
        parcel.writeInt(this.N);
        parcel.writeStringArray(this.O);
        parcel.writeDouble(this.P);
        parcel.writeInt(this.Q);
        parcel.writeLong(this.T);
        parcel.writeLong(this.U);
        parcel.writeParcelable(this.V, i3);
        parcel.writeParcelable(this.W, i3);
        parcel.writeLong(this.X);
        parcel.writeStringArray(this.Y);
        parcel.writeInt(this.Z);
        parcel.writeInt(this.f125730b0);
        parcel.writeInt(this.f125728a0);
        parcel.writeInt(this.R);
        parcel.writeStringArray(this.f125732c0);
        parcel.writeLong(this.f125734d0);
        parcel.writeInt(this.f125736e0);
        parcel.writeInt(this.f125738f0);
        parcel.writeString(this.f125740g0);
        parcel.writeParcelable(this.f125742h0, i3);
        parcel.writeParcelable(this.f125744i0, i3);
        parcel.writeDouble(this.f125746j0);
        parcel.writeString(this.f125748k0);
        parcel.writeString(this.f125752m0);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f125769a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList f125770b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList f125771c;

        /* renamed from: d, reason: collision with root package name */
        public int f125772d;

        /* renamed from: e, reason: collision with root package name */
        public int f125773e;

        /* renamed from: f, reason: collision with root package name */
        public int f125774f;

        /* renamed from: g, reason: collision with root package name */
        public int f125775g;

        /* renamed from: h, reason: collision with root package name */
        public String f125776h;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i3) {
                return new e[i3];
            }
        }

        public e() {
            this.f125769a = 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f125769a);
            parcel.writeStringList(this.f125770b);
            parcel.writeStringList(this.f125771c);
            parcel.writeInt(this.f125772d);
            parcel.writeInt(this.f125773e);
            parcel.writeInt(this.f125774f);
            parcel.writeInt(this.f125775g);
            parcel.writeString(this.f125776h);
        }

        public e(Parcel parcel) {
            this.f125769a = 0;
            this.f125769a = parcel.readInt();
            this.f125770b = parcel.createStringArrayList();
            this.f125771c = parcel.createStringArrayList();
            this.f125772d = parcel.readInt();
            this.f125773e = parcel.readInt();
            this.f125774f = parcel.readInt();
            this.f125775g = parcel.readInt();
            this.f125776h = parcel.readString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements Parcelable {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public long f125777a;

        /* renamed from: b, reason: collision with root package name */
        public long f125778b;

        /* renamed from: c, reason: collision with root package name */
        public long f125779c;

        /* renamed from: d, reason: collision with root package name */
        public int f125780d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i3) {
                return new f[i3];
            }
        }

        public f() {
            this.f125777a = 86400L;
            this.f125778b = 864000L;
            this.f125779c = 256L;
            this.f125780d = 5;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeLong(this.f125777a);
            parcel.writeLong(this.f125778b);
            parcel.writeLong(this.f125779c);
            parcel.writeInt(this.f125780d);
        }

        public f(Parcel parcel) {
            this.f125777a = 86400L;
            this.f125778b = 864000L;
            this.f125779c = 256L;
            this.f125780d = 5;
            this.f125777a = parcel.readLong();
            this.f125778b = parcel.readLong();
            this.f125779c = parcel.readLong();
            this.f125780d = parcel.readInt();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.fd.h$h, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6208h implements Parcelable {
        public static final Parcelable.Creator<C6208h> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public long f125790a;

        /* renamed from: b, reason: collision with root package name */
        public long f125791b;

        /* renamed from: c, reason: collision with root package name */
        public int f125792c;

        /* renamed from: d, reason: collision with root package name */
        public int f125793d;

        /* renamed from: e, reason: collision with root package name */
        public LongSparseArray f125794e;

        /* renamed from: f, reason: collision with root package name */
        public long f125795f;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.fd.h$h$a */
        /* loaded from: classes8.dex */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C6208h createFromParcel(Parcel parcel) {
                return new C6208h(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C6208h[] newArray(int i3) {
                return new C6208h[i3];
            }
        }

        public C6208h() {
            this.f125790a = JoinTimeType.SIX_HOUR;
            this.f125791b = JoinTimeType.SEVEN_DAY;
            this.f125792c = 1000;
            this.f125793d = 100;
            this.f125795f = 30L;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeLong(this.f125790a);
            parcel.writeLong(this.f125791b);
            parcel.writeInt(this.f125792c);
            parcel.writeInt(this.f125793d);
            LongSparseArray longSparseArray = this.f125794e;
            if (longSparseArray != null && longSparseArray.size() != 0) {
                parcel.writeInt(this.f125794e.size());
                for (int i16 = 0; i16 < this.f125794e.size(); i16++) {
                    parcel.writeLong(this.f125794e.keyAt(i16));
                    parcel.writeStringList((List) this.f125794e.valueAt(i16));
                }
            } else {
                parcel.writeInt(-1);
            }
            parcel.writeLong(this.f125795f);
        }

        public C6208h(Parcel parcel) {
            this.f125790a = JoinTimeType.SIX_HOUR;
            this.f125791b = JoinTimeType.SEVEN_DAY;
            this.f125792c = 1000;
            this.f125793d = 100;
            this.f125795f = 30L;
            this.f125790a = parcel.readLong();
            this.f125791b = parcel.readLong();
            this.f125792c = parcel.readInt();
            this.f125793d = parcel.readInt();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                this.f125794e = new LongSparseArray(readInt);
                for (int i3 = 0; i3 < readInt; i3++) {
                    long readLong = parcel.readLong();
                    LinkedList linkedList = new LinkedList();
                    parcel.readStringList(linkedList);
                    this.f125794e.put(readLong, linkedList);
                }
            }
            this.f125795f = parcel.readLong();
        }
    }

    public h(Parcel parcel) {
        this.f125727a = Integer.MAX_VALUE;
        this.f125751m = new e();
        this.f125742h0 = new g();
        this.f125744i0 = new d();
        this.f125727a = parcel.readInt();
        this.f125729b = parcel.readInt();
        this.f125731c = parcel.readInt();
        this.f125733d = parcel.readInt();
        this.f125735e = parcel.readInt();
        this.f125737f = parcel.readInt();
        this.f125739g = parcel.readInt();
        this.f125741h = parcel.readInt();
        this.f125743i = parcel.readInt();
        this.f125745j = parcel.readInt();
        this.f125747k = parcel.readString();
        this.f125749l = parcel.readString();
        this.f125751m = (e) parcel.readParcelable(e.class.getClassLoader());
        this.C = parcel.createIntArray();
        this.D = parcel.readInt();
        this.E = parcel.readInt();
        this.H = parcel.readInt();
        this.I = parcel.readInt();
        this.J = parcel.readInt();
        this.K = parcel.readInt();
        this.L = parcel.readInt();
        this.M = parcel.readInt();
        this.N = parcel.readInt();
        this.O = parcel.createStringArray();
        this.P = parcel.readDouble();
        this.Q = parcel.readInt();
        this.T = parcel.readLong();
        this.U = parcel.readLong();
        this.V = (C6208h) parcel.readParcelable(C6208h.class.getClassLoader());
        this.W = (f) parcel.readParcelable(f.class.getClassLoader());
        this.X = parcel.readLong();
        this.Y = parcel.createStringArray();
        this.Z = parcel.readInt();
        this.f125730b0 = parcel.readInt();
        this.f125728a0 = parcel.readInt();
        this.R = parcel.readInt();
        this.f125732c0 = parcel.createStringArray();
        this.f125734d0 = parcel.readLong();
        this.f125736e0 = parcel.readInt();
        this.f125738f0 = parcel.readInt();
        this.f125740g0 = parcel.readString();
        this.f125742h0 = (g) parcel.readParcelable(g.class.getClassLoader());
        this.f125744i0 = (d) parcel.readParcelable(d.class.getClassLoader());
        this.f125746j0 = parcel.readDouble();
        this.f125748k0 = parcel.readString();
        this.f125752m0 = parcel.readString();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0461 A[Catch: Exception -> 0x04f7, TryCatch #0 {Exception -> 0x04f7, blocks: (B:3:0x0017, B:6:0x002d, B:8:0x003d, B:9:0x0050, B:11:0x0059, B:12:0x0063, B:14:0x0069, B:16:0x0077, B:18:0x0080, B:19:0x008a, B:21:0x0090, B:23:0x009e, B:24:0x0042, B:26:0x004b, B:27:0x00d6, B:29:0x00e7, B:30:0x00e9, B:32:0x00f6, B:33:0x00f8, B:35:0x010a, B:37:0x0144, B:38:0x0159, B:40:0x016c, B:41:0x016e, B:43:0x017e, B:44:0x01b2, B:46:0x024f, B:47:0x0258, B:49:0x025e, B:51:0x026a, B:53:0x026e, B:54:0x0272, B:56:0x02d9, B:59:0x02e0, B:60:0x02e9, B:62:0x02ef, B:64:0x02ff, B:66:0x033a, B:69:0x0341, B:70:0x034a, B:72:0x0350, B:74:0x0360, B:76:0x037f, B:79:0x0386, B:80:0x038f, B:82:0x0395, B:84:0x03a5, B:86:0x03c8, B:87:0x03d2, B:90:0x03eb, B:92:0x03f4, B:93:0x040d, B:95:0x0416, B:96:0x042f, B:98:0x0438, B:99:0x0451, B:101:0x0461, B:103:0x046a, B:104:0x0483, B:106:0x048c, B:107:0x04a5, B:109:0x04d0, B:112:0x04d7, B:113:0x04e0, B:115:0x04e6, B:119:0x04f2, B:120:0x03a1, B:121:0x035c, B:122:0x02fb), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x04d0 A[Catch: Exception -> 0x04f7, TryCatch #0 {Exception -> 0x04f7, blocks: (B:3:0x0017, B:6:0x002d, B:8:0x003d, B:9:0x0050, B:11:0x0059, B:12:0x0063, B:14:0x0069, B:16:0x0077, B:18:0x0080, B:19:0x008a, B:21:0x0090, B:23:0x009e, B:24:0x0042, B:26:0x004b, B:27:0x00d6, B:29:0x00e7, B:30:0x00e9, B:32:0x00f6, B:33:0x00f8, B:35:0x010a, B:37:0x0144, B:38:0x0159, B:40:0x016c, B:41:0x016e, B:43:0x017e, B:44:0x01b2, B:46:0x024f, B:47:0x0258, B:49:0x025e, B:51:0x026a, B:53:0x026e, B:54:0x0272, B:56:0x02d9, B:59:0x02e0, B:60:0x02e9, B:62:0x02ef, B:64:0x02ff, B:66:0x033a, B:69:0x0341, B:70:0x034a, B:72:0x0350, B:74:0x0360, B:76:0x037f, B:79:0x0386, B:80:0x038f, B:82:0x0395, B:84:0x03a5, B:86:0x03c8, B:87:0x03d2, B:90:0x03eb, B:92:0x03f4, B:93:0x040d, B:95:0x0416, B:96:0x042f, B:98:0x0438, B:99:0x0451, B:101:0x0461, B:103:0x046a, B:104:0x0483, B:106:0x048c, B:107:0x04a5, B:109:0x04d0, B:112:0x04d7, B:113:0x04e0, B:115:0x04e6, B:119:0x04f2, B:120:0x03a1, B:121:0x035c, B:122:0x02fb), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x04e6 A[Catch: Exception -> 0x04f7, LOOP:6: B:113:0x04e0->B:115:0x04e6, LOOP_END, TryCatch #0 {Exception -> 0x04f7, blocks: (B:3:0x0017, B:6:0x002d, B:8:0x003d, B:9:0x0050, B:11:0x0059, B:12:0x0063, B:14:0x0069, B:16:0x0077, B:18:0x0080, B:19:0x008a, B:21:0x0090, B:23:0x009e, B:24:0x0042, B:26:0x004b, B:27:0x00d6, B:29:0x00e7, B:30:0x00e9, B:32:0x00f6, B:33:0x00f8, B:35:0x010a, B:37:0x0144, B:38:0x0159, B:40:0x016c, B:41:0x016e, B:43:0x017e, B:44:0x01b2, B:46:0x024f, B:47:0x0258, B:49:0x025e, B:51:0x026a, B:53:0x026e, B:54:0x0272, B:56:0x02d9, B:59:0x02e0, B:60:0x02e9, B:62:0x02ef, B:64:0x02ff, B:66:0x033a, B:69:0x0341, B:70:0x034a, B:72:0x0350, B:74:0x0360, B:76:0x037f, B:79:0x0386, B:80:0x038f, B:82:0x0395, B:84:0x03a5, B:86:0x03c8, B:87:0x03d2, B:90:0x03eb, B:92:0x03f4, B:93:0x040d, B:95:0x0416, B:96:0x042f, B:98:0x0438, B:99:0x0451, B:101:0x0461, B:103:0x046a, B:104:0x0483, B:106:0x048c, B:107:0x04a5, B:109:0x04d0, B:112:0x04d7, B:113:0x04e0, B:115:0x04e6, B:119:0x04f2, B:120:0x03a1, B:121:0x035c, B:122:0x02fb), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0350 A[Catch: Exception -> 0x04f7, LOOP:4: B:70:0x034a->B:72:0x0350, LOOP_END, TryCatch #0 {Exception -> 0x04f7, blocks: (B:3:0x0017, B:6:0x002d, B:8:0x003d, B:9:0x0050, B:11:0x0059, B:12:0x0063, B:14:0x0069, B:16:0x0077, B:18:0x0080, B:19:0x008a, B:21:0x0090, B:23:0x009e, B:24:0x0042, B:26:0x004b, B:27:0x00d6, B:29:0x00e7, B:30:0x00e9, B:32:0x00f6, B:33:0x00f8, B:35:0x010a, B:37:0x0144, B:38:0x0159, B:40:0x016c, B:41:0x016e, B:43:0x017e, B:44:0x01b2, B:46:0x024f, B:47:0x0258, B:49:0x025e, B:51:0x026a, B:53:0x026e, B:54:0x0272, B:56:0x02d9, B:59:0x02e0, B:60:0x02e9, B:62:0x02ef, B:64:0x02ff, B:66:0x033a, B:69:0x0341, B:70:0x034a, B:72:0x0350, B:74:0x0360, B:76:0x037f, B:79:0x0386, B:80:0x038f, B:82:0x0395, B:84:0x03a5, B:86:0x03c8, B:87:0x03d2, B:90:0x03eb, B:92:0x03f4, B:93:0x040d, B:95:0x0416, B:96:0x042f, B:98:0x0438, B:99:0x0451, B:101:0x0461, B:103:0x046a, B:104:0x0483, B:106:0x048c, B:107:0x04a5, B:109:0x04d0, B:112:0x04d7, B:113:0x04e0, B:115:0x04e6, B:119:0x04f2, B:120:0x03a1, B:121:0x035c, B:122:0x02fb), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x037f A[Catch: Exception -> 0x04f7, TryCatch #0 {Exception -> 0x04f7, blocks: (B:3:0x0017, B:6:0x002d, B:8:0x003d, B:9:0x0050, B:11:0x0059, B:12:0x0063, B:14:0x0069, B:16:0x0077, B:18:0x0080, B:19:0x008a, B:21:0x0090, B:23:0x009e, B:24:0x0042, B:26:0x004b, B:27:0x00d6, B:29:0x00e7, B:30:0x00e9, B:32:0x00f6, B:33:0x00f8, B:35:0x010a, B:37:0x0144, B:38:0x0159, B:40:0x016c, B:41:0x016e, B:43:0x017e, B:44:0x01b2, B:46:0x024f, B:47:0x0258, B:49:0x025e, B:51:0x026a, B:53:0x026e, B:54:0x0272, B:56:0x02d9, B:59:0x02e0, B:60:0x02e9, B:62:0x02ef, B:64:0x02ff, B:66:0x033a, B:69:0x0341, B:70:0x034a, B:72:0x0350, B:74:0x0360, B:76:0x037f, B:79:0x0386, B:80:0x038f, B:82:0x0395, B:84:0x03a5, B:86:0x03c8, B:87:0x03d2, B:90:0x03eb, B:92:0x03f4, B:93:0x040d, B:95:0x0416, B:96:0x042f, B:98:0x0438, B:99:0x0451, B:101:0x0461, B:103:0x046a, B:104:0x0483, B:106:0x048c, B:107:0x04a5, B:109:0x04d0, B:112:0x04d7, B:113:0x04e0, B:115:0x04e6, B:119:0x04f2, B:120:0x03a1, B:121:0x035c, B:122:0x02fb), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0395 A[Catch: Exception -> 0x04f7, LOOP:5: B:80:0x038f->B:82:0x0395, LOOP_END, TryCatch #0 {Exception -> 0x04f7, blocks: (B:3:0x0017, B:6:0x002d, B:8:0x003d, B:9:0x0050, B:11:0x0059, B:12:0x0063, B:14:0x0069, B:16:0x0077, B:18:0x0080, B:19:0x008a, B:21:0x0090, B:23:0x009e, B:24:0x0042, B:26:0x004b, B:27:0x00d6, B:29:0x00e7, B:30:0x00e9, B:32:0x00f6, B:33:0x00f8, B:35:0x010a, B:37:0x0144, B:38:0x0159, B:40:0x016c, B:41:0x016e, B:43:0x017e, B:44:0x01b2, B:46:0x024f, B:47:0x0258, B:49:0x025e, B:51:0x026a, B:53:0x026e, B:54:0x0272, B:56:0x02d9, B:59:0x02e0, B:60:0x02e9, B:62:0x02ef, B:64:0x02ff, B:66:0x033a, B:69:0x0341, B:70:0x034a, B:72:0x0350, B:74:0x0360, B:76:0x037f, B:79:0x0386, B:80:0x038f, B:82:0x0395, B:84:0x03a5, B:86:0x03c8, B:87:0x03d2, B:90:0x03eb, B:92:0x03f4, B:93:0x040d, B:95:0x0416, B:96:0x042f, B:98:0x0438, B:99:0x0451, B:101:0x0461, B:103:0x046a, B:104:0x0483, B:106:0x048c, B:107:0x04a5, B:109:0x04d0, B:112:0x04d7, B:113:0x04e0, B:115:0x04e6, B:119:0x04f2, B:120:0x03a1, B:121:0x035c, B:122:0x02fb), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03c8 A[Catch: Exception -> 0x04f7, TryCatch #0 {Exception -> 0x04f7, blocks: (B:3:0x0017, B:6:0x002d, B:8:0x003d, B:9:0x0050, B:11:0x0059, B:12:0x0063, B:14:0x0069, B:16:0x0077, B:18:0x0080, B:19:0x008a, B:21:0x0090, B:23:0x009e, B:24:0x0042, B:26:0x004b, B:27:0x00d6, B:29:0x00e7, B:30:0x00e9, B:32:0x00f6, B:33:0x00f8, B:35:0x010a, B:37:0x0144, B:38:0x0159, B:40:0x016c, B:41:0x016e, B:43:0x017e, B:44:0x01b2, B:46:0x024f, B:47:0x0258, B:49:0x025e, B:51:0x026a, B:53:0x026e, B:54:0x0272, B:56:0x02d9, B:59:0x02e0, B:60:0x02e9, B:62:0x02ef, B:64:0x02ff, B:66:0x033a, B:69:0x0341, B:70:0x034a, B:72:0x0350, B:74:0x0360, B:76:0x037f, B:79:0x0386, B:80:0x038f, B:82:0x0395, B:84:0x03a5, B:86:0x03c8, B:87:0x03d2, B:90:0x03eb, B:92:0x03f4, B:93:0x040d, B:95:0x0416, B:96:0x042f, B:98:0x0438, B:99:0x0451, B:101:0x0461, B:103:0x046a, B:104:0x0483, B:106:0x048c, B:107:0x04a5, B:109:0x04d0, B:112:0x04d7, B:113:0x04e0, B:115:0x04e6, B:119:0x04f2, B:120:0x03a1, B:121:0x035c, B:122:0x02fb), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x03eb A[Catch: Exception -> 0x04f7, TRY_ENTER, TryCatch #0 {Exception -> 0x04f7, blocks: (B:3:0x0017, B:6:0x002d, B:8:0x003d, B:9:0x0050, B:11:0x0059, B:12:0x0063, B:14:0x0069, B:16:0x0077, B:18:0x0080, B:19:0x008a, B:21:0x0090, B:23:0x009e, B:24:0x0042, B:26:0x004b, B:27:0x00d6, B:29:0x00e7, B:30:0x00e9, B:32:0x00f6, B:33:0x00f8, B:35:0x010a, B:37:0x0144, B:38:0x0159, B:40:0x016c, B:41:0x016e, B:43:0x017e, B:44:0x01b2, B:46:0x024f, B:47:0x0258, B:49:0x025e, B:51:0x026a, B:53:0x026e, B:54:0x0272, B:56:0x02d9, B:59:0x02e0, B:60:0x02e9, B:62:0x02ef, B:64:0x02ff, B:66:0x033a, B:69:0x0341, B:70:0x034a, B:72:0x0350, B:74:0x0360, B:76:0x037f, B:79:0x0386, B:80:0x038f, B:82:0x0395, B:84:0x03a5, B:86:0x03c8, B:87:0x03d2, B:90:0x03eb, B:92:0x03f4, B:93:0x040d, B:95:0x0416, B:96:0x042f, B:98:0x0438, B:99:0x0451, B:101:0x0461, B:103:0x046a, B:104:0x0483, B:106:0x048c, B:107:0x04a5, B:109:0x04d0, B:112:0x04d7, B:113:0x04e0, B:115:0x04e6, B:119:0x04f2, B:120:0x03a1, B:121:0x035c, B:122:0x02fb), top: B:2:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static h a(String str) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONArray optJSONArray3;
        int i3;
        int i16;
        int i17;
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandGlobalSystemConfig", "parse json = %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            h hVar = new h();
            JSONObject optJSONObject3 = jSONObject.optJSONObject("HTTPSetting");
            if (optJSONObject3 != null) {
                String optString = optJSONObject3.optString("HTTPHeaderMode", "");
                if (optString.equals("BlackList")) {
                    hVar.f125751m.f125769a = 1;
                } else if (optString.equals("WhiteList")) {
                    hVar.f125751m.f125769a = 2;
                }
                JSONArray optJSONArray4 = optJSONObject3.optJSONArray("HeaderBlackList");
                if (optJSONArray4 != null) {
                    hVar.f125751m.f125770b = new ArrayList();
                    for (int i18 = 0; i18 < optJSONArray4.length(); i18++) {
                        hVar.f125751m.f125770b.add(optJSONArray4.getString(i18));
                    }
                }
                JSONArray optJSONArray5 = optJSONObject3.optJSONArray("HeaderWhiteList");
                if (optJSONArray5 != null) {
                    hVar.f125751m.f125771c = new ArrayList();
                    for (int i19 = 0; i19 < optJSONArray5.length(); i19++) {
                        hVar.f125751m.f125771c.add(optJSONArray5.getString(i19));
                    }
                }
                hVar.f125751m.f125772d = optJSONObject3.optInt("WebsocketMaxTimeoutMS", -1);
                hVar.f125751m.f125773e = optJSONObject3.optInt("UploadMaxTimeoutMS", -1);
                hVar.f125751m.f125774f = optJSONObject3.optInt("DownloadMaxTimeoutMS", -1);
                hVar.f125751m.f125775g = optJSONObject3.optInt("RequestMaxTimeoutMS", -1);
                hVar.f125751m.f125776h = optJSONObject3.optString("HTTPHeaderReferer");
            }
            long optLong = jSONObject.optLong("WxaAttrSyncFreqPeriodSeconds", 300L);
            hVar.T = optLong;
            if (optLong <= 0) {
                hVar.T = 300L;
            }
            long optLong2 = jSONObject.optLong("BatchWxaAttrSyncFreqPeriodSeconds", 300L);
            hVar.U = optLong2;
            if (optLong2 <= 0) {
                hVar.U = 300L;
            }
            hVar.V = new C6208h();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("SyncVersionSetting");
            if (optJSONObject4 != null) {
                C6208h c6208h = hVar.V;
                c6208h.f125790a = optJSONObject4.optLong("PullVersionInterval", c6208h.f125790a);
                C6208h c6208h2 = hVar.V;
                c6208h2.f125791b = optJSONObject4.optLong("PullVersionWxaUsageLastInterval", c6208h2.f125791b);
                C6208h c6208h3 = hVar.V;
                c6208h3.f125792c = optJSONObject4.optInt("PullVersionMaxCount", c6208h3.f125792c);
                C6208h c6208h4 = hVar.V;
                c6208h4.f125793d = optJSONObject4.optInt("PullVersionMaxCountPerRequest", c6208h4.f125793d);
                if (optJSONObject4.has("PreDownloadList")) {
                    hVar.V.f125794e = new LongSparseArray();
                    com.tencent.luggage.wxa.e5.f.a(optJSONObject4.getJSONArray("PreDownloadList"), new a());
                }
                hVar.V.f125795f = optJSONObject4.optLong("InvalidContactFreqBlockSeconds", 30L);
                C6208h c6208h5 = hVar.V;
                if (c6208h5.f125795f <= 0) {
                    c6208h5.f125795f = 30L;
                }
            }
            hVar.W = new f();
            JSONObject optJSONObject5 = jSONObject.optJSONObject("PackageManager");
            if (optJSONObject5 != null) {
                f fVar = hVar.W;
                fVar.f125777a = optJSONObject5.optLong("CheckInterval", fVar.f125777a);
                f fVar2 = hVar.W;
                fVar2.f125778b = optJSONObject5.optLong("WithoutContactClearSeconds", fVar2.f125778b);
                f fVar3 = hVar.W;
                fVar3.f125779c = optJSONObject5.optLong("ClientStorageMinMB", fVar3.f125779c);
                f fVar4 = hVar.W;
                fVar4.f125780d = optJSONObject5.optInt("WholeClientStoragePercent", fVar4.f125780d);
            }
            hVar.f125747k = jSONObject.optString("CDNBaseURL");
            hVar.f125749l = jSONObject.optString("CDNPreConnectURL", c.f125756a);
            hVar.f125729b = jSONObject.optInt("AppMaxRunningCount", 5);
            hVar.f125731c = jSONObject.optInt("AppSharedResourceBackgroundRunningCount", 1);
            hVar.f125733d = jSONObject.optInt("TempFileSizeLimitTotal", 300);
            hVar.f125735e = jSONObject.optInt("DownloadFileSizeLimit", 50);
            hVar.f125737f = jSONObject.optInt("MaxLocalStorageItemSize", 1048576);
            hVar.f125739g = jSONObject.optInt("MaxGlobalStorageItemSize", 1048576);
            hVar.f125741h = jSONObject.optInt("MaxGlobalStorageSize", 20971520);
            hVar.f125743i = jSONObject.optInt("SingleWxaFileStorageCleanMbThreshold", 200);
            hVar.f125745j = jSONObject.optInt("GlobalWxaFileStorageCleanMbThreshold", MiniAppRealTimeLogReporter.MAX_CONTENT_SIZE);
            hVar.K = jSONObject.optInt("NativeBufferSizeLimitByte", 104857600);
            hVar.L = jSONObject.optInt("NativeBufferQueueLimitByte", QzoneConfig.DefaultValue.DEFAUL_VIDEO_TRIM_ULTRAFAST_AVAIL_RAM);
            hVar.f125730b0 = jSONObject.optInt("WeUseRecallInterval", 86400);
            JSONArray optJSONArray6 = jSONObject.optJSONArray("SyncLaunchSceneList");
            if (optJSONArray6 != null) {
                hVar.C = new int[optJSONArray6.length()];
                for (int i26 = 0; i26 < optJSONArray6.length(); i26++) {
                    hVar.C[i26] = optJSONArray6.optInt(i26, 0);
                }
            }
            if (hVar.C == null) {
                hVar.C = c.f125757b;
            }
            hVar.D = jSONObject.optInt("StarNumberLimitation", 50);
            hVar.E = jSONObject.optInt("TaskBarItemCountLimitation", 11);
            hVar.F = jSONObject.optInt("NewTaskBarRecentsItemCountLimitation", 12);
            hVar.G = jSONObject.optInt("TaskBarSyncUsageRecordIntervalMinute", 20);
            hVar.H = jSONObject.optInt("WidgetImageFlowLimitDuration", TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC);
            hVar.I = jSONObject.optInt("WidgetImageFlowLimitMaxSize", 307200);
            hVar.J = jSONObject.optInt("WidgetDrawMinInterval", 25);
            hVar.M = jSONObject.optInt("GameMaxRunningCount", 1);
            hVar.N = jSONObject.optInt("GameDownloadFileSizeLimit", 50);
            JSONArray optJSONArray7 = jSONObject.optJSONArray("SubContextImgDomain");
            if (optJSONArray7 != null && optJSONArray7.length() != 0) {
                hVar.O = new String[optJSONArray7.length()];
                for (int i27 = 0; i27 < optJSONArray7.length(); i27++) {
                    hVar.O[i27] = optJSONArray7.optString(i27, null);
                }
                hVar.P = jSONObject.optDouble("GamePerfCollectSamplePercentage", 0.0d);
                hVar.Q = jSONObject.optInt("GamePerfCollectInterval", 60);
                hVar.R = jSONObject.optInt("PerformIndexReportGapInSeconds", 60);
                hVar.S = jSONObject.optInt("LoadingWeakNetDelayDurationInSecondsAndroid", 6);
                hVar.X = jSONObject.optLong("OpendataMaxFileStorageSize", 30L);
                optJSONArray = jSONObject.optJSONArray("PreDownloadUserNameBlackList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    hVar.Y = new String[optJSONArray.length()];
                    for (i17 = 0; i17 < optJSONArray.length(); i17++) {
                        hVar.Y[i17] = optJSONArray.optString(i17, null);
                    }
                    hVar.Z = jSONObject.optInt("WXDataMaxRequestConcurrent", 10);
                    hVar.f125728a0 = jSONObject.optInt("WxaWebRenderingCacheMaxStorageSizeMB", 100);
                    optJSONArray2 = jSONObject.optJSONArray("UsePackageConfirmSubDescScopeList");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        hVar.f125732c0 = new String[optJSONArray2.length()];
                        for (i16 = 0; i16 < optJSONArray2.length(); i16++) {
                            hVar.f125732c0[i16] = optJSONArray2.optString(i16, null);
                        }
                        hVar.f125734d0 = jSONObject.optLong("BluetoothBackgroundTimeoutWithoutConnectionInSeconds", 60L);
                        hVar.f125736e0 = jSONObject.optInt("AppMaxBackgroundBluetoothCount", 1);
                        hVar.f125738f0 = jSONObject.optInt("AppMaxBackgroundLaunchBluetoothCount", 1);
                        if (jSONObject.optJSONObject("AgeAppropriateIcon") != null) {
                            hVar.f125740g0 = jSONObject.optJSONObject("AgeAppropriateIcon").toString();
                        }
                        optJSONObject = jSONObject.optJSONObject("RelievedBuySetting");
                        hVar.f125742h0 = new g();
                        if (optJSONObject != null) {
                            JSONObject optJSONObject6 = optJSONObject.optJSONObject("icon_green");
                            if (optJSONObject6 != null) {
                                hVar.f125742h0.f125781a = optJSONObject6.optString("url");
                                hVar.f125742h0.f125782b = optJSONObject6.optInt("width", 0);
                                hVar.f125742h0.f125783c = optJSONObject6.optInt("height", 0);
                            }
                            JSONObject optJSONObject7 = optJSONObject.optJSONObject("icon_gray");
                            if (optJSONObject7 != null) {
                                hVar.f125742h0.f125784d = optJSONObject7.optString("url");
                                hVar.f125742h0.f125785e = optJSONObject7.optInt("width", 0);
                                hVar.f125742h0.f125786f = optJSONObject7.optInt("height", 0);
                            }
                            JSONObject optJSONObject8 = optJSONObject.optJSONObject("icon_big");
                            if (optJSONObject8 != null) {
                                hVar.f125742h0.f125787g = optJSONObject8.optString("url");
                                hVar.f125742h0.f125788h = optJSONObject8.optInt("width", 0);
                                hVar.f125742h0.f125789i = optJSONObject8.optInt("height", 0);
                            }
                        }
                        optJSONObject2 = jSONObject.optJSONObject("FlagshipSetting");
                        hVar.f125744i0 = new d();
                        if (optJSONObject2 != null) {
                            JSONObject optJSONObject9 = optJSONObject2.optJSONObject("icon_dark");
                            if (optJSONObject9 != null) {
                                hVar.f125744i0.f125763a = optJSONObject9.optString("url");
                                hVar.f125744i0.f125764b = optJSONObject9.optInt("width", 0);
                                hVar.f125744i0.f125765c = optJSONObject9.optInt("height", 0);
                            }
                            JSONObject optJSONObject10 = optJSONObject2.optJSONObject("icon_light");
                            if (optJSONObject10 != null) {
                                hVar.f125744i0.f125766d = optJSONObject10.optString("url");
                                hVar.f125744i0.f125767e = optJSONObject10.optInt("width", 0);
                                hVar.f125744i0.f125768f = optJSONObject10.optInt("height", 0);
                            }
                        }
                        hVar.f125746j0 = jSONObject.optDouble("WhiteScreenDetectThresholdFloatNew", 0.949999988079071d);
                        hVar.f125748k0 = jSONObject.optString("TradeGuaranteeMenuSetting", c.f125761f);
                        hVar.f125752m0 = jSONObject.optString("WxaCommUseSetting", "");
                        optJSONArray3 = jSONObject.optJSONArray("to do");
                        if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                            hVar.f125750l0 = new String[optJSONArray3.length()];
                            for (i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                hVar.f125750l0[i3] = optJSONArray3.optString(i3, null);
                            }
                            return hVar;
                        }
                        hVar.f125750l0 = c.f125762g;
                        return hVar;
                    }
                    hVar.f125732c0 = c.f125760e;
                    hVar.f125734d0 = jSONObject.optLong("BluetoothBackgroundTimeoutWithoutConnectionInSeconds", 60L);
                    hVar.f125736e0 = jSONObject.optInt("AppMaxBackgroundBluetoothCount", 1);
                    hVar.f125738f0 = jSONObject.optInt("AppMaxBackgroundLaunchBluetoothCount", 1);
                    if (jSONObject.optJSONObject("AgeAppropriateIcon") != null) {
                    }
                    optJSONObject = jSONObject.optJSONObject("RelievedBuySetting");
                    hVar.f125742h0 = new g();
                    if (optJSONObject != null) {
                    }
                    optJSONObject2 = jSONObject.optJSONObject("FlagshipSetting");
                    hVar.f125744i0 = new d();
                    if (optJSONObject2 != null) {
                    }
                    hVar.f125746j0 = jSONObject.optDouble("WhiteScreenDetectThresholdFloatNew", 0.949999988079071d);
                    hVar.f125748k0 = jSONObject.optString("TradeGuaranteeMenuSetting", c.f125761f);
                    hVar.f125752m0 = jSONObject.optString("WxaCommUseSetting", "");
                    optJSONArray3 = jSONObject.optJSONArray("to do");
                    if (optJSONArray3 != null) {
                        hVar.f125750l0 = new String[optJSONArray3.length()];
                        while (i3 < optJSONArray3.length()) {
                        }
                        return hVar;
                    }
                    hVar.f125750l0 = c.f125762g;
                    return hVar;
                }
                hVar.Y = c.f125759d;
                hVar.Z = jSONObject.optInt("WXDataMaxRequestConcurrent", 10);
                hVar.f125728a0 = jSONObject.optInt("WxaWebRenderingCacheMaxStorageSizeMB", 100);
                optJSONArray2 = jSONObject.optJSONArray("UsePackageConfirmSubDescScopeList");
                if (optJSONArray2 != null) {
                    hVar.f125732c0 = new String[optJSONArray2.length()];
                    while (i16 < optJSONArray2.length()) {
                    }
                    hVar.f125734d0 = jSONObject.optLong("BluetoothBackgroundTimeoutWithoutConnectionInSeconds", 60L);
                    hVar.f125736e0 = jSONObject.optInt("AppMaxBackgroundBluetoothCount", 1);
                    hVar.f125738f0 = jSONObject.optInt("AppMaxBackgroundLaunchBluetoothCount", 1);
                    if (jSONObject.optJSONObject("AgeAppropriateIcon") != null) {
                    }
                    optJSONObject = jSONObject.optJSONObject("RelievedBuySetting");
                    hVar.f125742h0 = new g();
                    if (optJSONObject != null) {
                    }
                    optJSONObject2 = jSONObject.optJSONObject("FlagshipSetting");
                    hVar.f125744i0 = new d();
                    if (optJSONObject2 != null) {
                    }
                    hVar.f125746j0 = jSONObject.optDouble("WhiteScreenDetectThresholdFloatNew", 0.949999988079071d);
                    hVar.f125748k0 = jSONObject.optString("TradeGuaranteeMenuSetting", c.f125761f);
                    hVar.f125752m0 = jSONObject.optString("WxaCommUseSetting", "");
                    optJSONArray3 = jSONObject.optJSONArray("to do");
                    if (optJSONArray3 != null) {
                    }
                    hVar.f125750l0 = c.f125762g;
                    return hVar;
                }
                hVar.f125732c0 = c.f125760e;
                hVar.f125734d0 = jSONObject.optLong("BluetoothBackgroundTimeoutWithoutConnectionInSeconds", 60L);
                hVar.f125736e0 = jSONObject.optInt("AppMaxBackgroundBluetoothCount", 1);
                hVar.f125738f0 = jSONObject.optInt("AppMaxBackgroundLaunchBluetoothCount", 1);
                if (jSONObject.optJSONObject("AgeAppropriateIcon") != null) {
                }
                optJSONObject = jSONObject.optJSONObject("RelievedBuySetting");
                hVar.f125742h0 = new g();
                if (optJSONObject != null) {
                }
                optJSONObject2 = jSONObject.optJSONObject("FlagshipSetting");
                hVar.f125744i0 = new d();
                if (optJSONObject2 != null) {
                }
                hVar.f125746j0 = jSONObject.optDouble("WhiteScreenDetectThresholdFloatNew", 0.949999988079071d);
                hVar.f125748k0 = jSONObject.optString("TradeGuaranteeMenuSetting", c.f125761f);
                hVar.f125752m0 = jSONObject.optString("WxaCommUseSetting", "");
                optJSONArray3 = jSONObject.optJSONArray("to do");
                if (optJSONArray3 != null) {
                }
                hVar.f125750l0 = c.f125762g;
                return hVar;
            }
            hVar.O = c.f125758c;
            hVar.P = jSONObject.optDouble("GamePerfCollectSamplePercentage", 0.0d);
            hVar.Q = jSONObject.optInt("GamePerfCollectInterval", 60);
            hVar.R = jSONObject.optInt("PerformIndexReportGapInSeconds", 60);
            hVar.S = jSONObject.optInt("LoadingWeakNetDelayDurationInSecondsAndroid", 6);
            hVar.X = jSONObject.optLong("OpendataMaxFileStorageSize", 30L);
            optJSONArray = jSONObject.optJSONArray("PreDownloadUserNameBlackList");
            if (optJSONArray != null) {
                hVar.Y = new String[optJSONArray.length()];
                while (i17 < optJSONArray.length()) {
                }
                hVar.Z = jSONObject.optInt("WXDataMaxRequestConcurrent", 10);
                hVar.f125728a0 = jSONObject.optInt("WxaWebRenderingCacheMaxStorageSizeMB", 100);
                optJSONArray2 = jSONObject.optJSONArray("UsePackageConfirmSubDescScopeList");
                if (optJSONArray2 != null) {
                }
                hVar.f125732c0 = c.f125760e;
                hVar.f125734d0 = jSONObject.optLong("BluetoothBackgroundTimeoutWithoutConnectionInSeconds", 60L);
                hVar.f125736e0 = jSONObject.optInt("AppMaxBackgroundBluetoothCount", 1);
                hVar.f125738f0 = jSONObject.optInt("AppMaxBackgroundLaunchBluetoothCount", 1);
                if (jSONObject.optJSONObject("AgeAppropriateIcon") != null) {
                }
                optJSONObject = jSONObject.optJSONObject("RelievedBuySetting");
                hVar.f125742h0 = new g();
                if (optJSONObject != null) {
                }
                optJSONObject2 = jSONObject.optJSONObject("FlagshipSetting");
                hVar.f125744i0 = new d();
                if (optJSONObject2 != null) {
                }
                hVar.f125746j0 = jSONObject.optDouble("WhiteScreenDetectThresholdFloatNew", 0.949999988079071d);
                hVar.f125748k0 = jSONObject.optString("TradeGuaranteeMenuSetting", c.f125761f);
                hVar.f125752m0 = jSONObject.optString("WxaCommUseSetting", "");
                optJSONArray3 = jSONObject.optJSONArray("to do");
                if (optJSONArray3 != null) {
                }
                hVar.f125750l0 = c.f125762g;
                return hVar;
            }
            hVar.Y = c.f125759d;
            hVar.Z = jSONObject.optInt("WXDataMaxRequestConcurrent", 10);
            hVar.f125728a0 = jSONObject.optInt("WxaWebRenderingCacheMaxStorageSizeMB", 100);
            optJSONArray2 = jSONObject.optJSONArray("UsePackageConfirmSubDescScopeList");
            if (optJSONArray2 != null) {
            }
            hVar.f125732c0 = c.f125760e;
            hVar.f125734d0 = jSONObject.optLong("BluetoothBackgroundTimeoutWithoutConnectionInSeconds", 60L);
            hVar.f125736e0 = jSONObject.optInt("AppMaxBackgroundBluetoothCount", 1);
            hVar.f125738f0 = jSONObject.optInt("AppMaxBackgroundLaunchBluetoothCount", 1);
            if (jSONObject.optJSONObject("AgeAppropriateIcon") != null) {
            }
            optJSONObject = jSONObject.optJSONObject("RelievedBuySetting");
            hVar.f125742h0 = new g();
            if (optJSONObject != null) {
            }
            optJSONObject2 = jSONObject.optJSONObject("FlagshipSetting");
            hVar.f125744i0 = new d();
            if (optJSONObject2 != null) {
            }
            hVar.f125746j0 = jSONObject.optDouble("WhiteScreenDetectThresholdFloatNew", 0.949999988079071d);
            hVar.f125748k0 = jSONObject.optString("TradeGuaranteeMenuSetting", c.f125761f);
            hVar.f125752m0 = jSONObject.optString("WxaCommUseSetting", "");
            optJSONArray3 = jSONObject.optJSONArray("to do");
            if (optJSONArray3 != null) {
            }
            hVar.f125750l0 = c.f125762g;
            return hVar;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandGlobalSystemConfig", "parse exception = %s", w0.a((Throwable) e16));
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public String f125763a;

        /* renamed from: b, reason: collision with root package name */
        public int f125764b;

        /* renamed from: c, reason: collision with root package name */
        public int f125765c;

        /* renamed from: d, reason: collision with root package name */
        public String f125766d;

        /* renamed from: e, reason: collision with root package name */
        public int f125767e;

        /* renamed from: f, reason: collision with root package name */
        public int f125768f;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i3) {
                return new d[i3];
            }
        }

        public d() {
            this.f125763a = "";
            this.f125764b = 0;
            this.f125765c = 0;
            this.f125766d = "";
            this.f125767e = 0;
            this.f125768f = 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            String str = this.f125763a;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            parcel.writeString(str);
            parcel.writeInt(this.f125764b);
            parcel.writeInt(this.f125765c);
            String str3 = this.f125766d;
            if (str3 != null) {
                str2 = str3;
            }
            parcel.writeString(str2);
            parcel.writeInt(this.f125767e);
            parcel.writeInt(this.f125768f);
        }

        public d(Parcel parcel) {
            this.f125763a = "";
            this.f125764b = 0;
            this.f125765c = 0;
            this.f125766d = "";
            this.f125767e = 0;
            this.f125768f = 0;
            this.f125763a = parcel.readString();
            this.f125764b = parcel.readInt();
            this.f125765c = parcel.readInt();
            this.f125766d = parcel.readString();
            this.f125767e = parcel.readInt();
            this.f125768f = parcel.readInt();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements Parcelable {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public String f125781a;

        /* renamed from: b, reason: collision with root package name */
        public int f125782b;

        /* renamed from: c, reason: collision with root package name */
        public int f125783c;

        /* renamed from: d, reason: collision with root package name */
        public String f125784d;

        /* renamed from: e, reason: collision with root package name */
        public int f125785e;

        /* renamed from: f, reason: collision with root package name */
        public int f125786f;

        /* renamed from: g, reason: collision with root package name */
        public String f125787g;

        /* renamed from: h, reason: collision with root package name */
        public int f125788h;

        /* renamed from: i, reason: collision with root package name */
        public int f125789i;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i3) {
                return new g[i3];
            }
        }

        public g() {
            this.f125781a = "";
            this.f125782b = 0;
            this.f125783c = 0;
            this.f125784d = "";
            this.f125785e = 0;
            this.f125786f = 0;
            this.f125787g = "";
            this.f125788h = 0;
            this.f125789i = 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            String str = this.f125781a;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            parcel.writeString(str);
            parcel.writeInt(this.f125782b);
            parcel.writeInt(this.f125783c);
            String str3 = this.f125784d;
            if (str3 == null) {
                str3 = "";
            }
            parcel.writeString(str3);
            parcel.writeInt(this.f125785e);
            parcel.writeInt(this.f125786f);
            String str4 = this.f125787g;
            if (str4 != null) {
                str2 = str4;
            }
            parcel.writeString(str2);
            parcel.writeInt(this.f125788h);
            parcel.writeInt(this.f125789i);
        }

        public g(Parcel parcel) {
            this.f125781a = "";
            this.f125782b = 0;
            this.f125783c = 0;
            this.f125784d = "";
            this.f125785e = 0;
            this.f125786f = 0;
            this.f125787g = "";
            this.f125788h = 0;
            this.f125789i = 0;
            this.f125781a = parcel.readString();
            this.f125782b = parcel.readInt();
            this.f125783c = parcel.readInt();
            this.f125784d = parcel.readString();
            this.f125785e = parcel.readInt();
            this.f125786f = parcel.readInt();
            this.f125787g = parcel.readString();
            this.f125788h = parcel.readInt();
            this.f125789i = parcel.readInt();
        }
    }
}
