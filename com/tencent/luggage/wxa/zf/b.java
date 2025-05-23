package com.tencent.luggage.wxa.zf;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.luggage.wxa.tn.u;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.zl.c;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePickerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b extends e {

    /* renamed from: i, reason: collision with root package name */
    public volatile c f146565i;

    /* renamed from: j, reason: collision with root package name */
    public volatile Long f146566j = null;

    /* renamed from: k, reason: collision with root package name */
    public volatile Long f146567k = null;

    /* renamed from: l, reason: collision with root package name */
    public volatile int f146568l = -1;

    /* renamed from: m, reason: collision with root package name */
    public volatile int f146569m = -1;
    public volatile int C = -1;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.e();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.zf.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C6983b implements c.i {
        public C6983b() {
        }

        @Override // com.tencent.luggage.wxa.zl.c.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(boolean z16, String str) {
            b.this.a(z16, str);
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'b' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c {

        /* renamed from: b, reason: collision with root package name */
        public static final c f146572b;

        /* renamed from: c, reason: collision with root package name */
        public static final c f146573c;

        /* renamed from: d, reason: collision with root package name */
        public static final c f146574d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ c[] f146575e;

        /* renamed from: a, reason: collision with root package name */
        public final DateFormat f146576a;

        static {
            Locale locale = Locale.US;
            f146572b = new c("YEAR", 0, new SimpleDateFormat(DateUtil.DATE_FORMAT_YEAR, locale));
            f146573c = new c("MONTH", 1, new SimpleDateFormat("yyyy-MM", locale));
            f146574d = new c("DAY", 2, new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, locale));
            f146575e = a();
        }

        public c(String str, int i3, DateFormat dateFormat) {
            this.f146576a = dateFormat;
        }

        public static /* synthetic */ c[] a() {
            return new c[]{f146572b, f146573c, f146574d};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f146575e.clone();
        }

        public Date b(String str) {
            try {
                return this.f146576a.parse(str);
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
        
            if (r3.equals("day") == false) goto L4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static c a(String str) {
            char c16 = 0;
            String lowerCase = str.substring(0, Math.max(0, Math.min(str.length(), 5))).toLowerCase();
            lowerCase.hashCode();
            switch (lowerCase.hashCode()) {
                case 99228:
                    break;
                case 3704893:
                    if (lowerCase.equals("year")) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 104080000:
                    if (lowerCase.equals("month")) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            switch (c16) {
                case 0:
                    return f146574d;
                case 1:
                    return f146572b;
                case 2:
                    return f146573c;
                default:
                    return f146573c;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.zf.e
    public void b(JSONObject jSONObject) {
        this.f146565i = c.a(jSONObject.optString("fields"));
        JSONObject optJSONObject = jSONObject.optJSONObject(DownloaderConstant.KEY_RANGE);
        if (optJSONObject != null) {
            Date b16 = this.f146565i.b(optJSONObject.optString("start", ""));
            Date b17 = this.f146565i.b(optJSONObject.optString("end", ""));
            if (b16 != null) {
                this.f146566j = Long.valueOf(b16.getTime());
            }
            if (b17 != null) {
                this.f146567k = Long.valueOf(b17.getTime());
            }
        }
        if (this.f146566j == null) {
            Calendar calendar = Calendar.getInstance(u.f141717a);
            calendar.set(1900, 0, 1);
            this.f146566j = Long.valueOf(calendar.getTimeInMillis());
        }
        if (this.f146567k == null) {
            Calendar calendar2 = Calendar.getInstance(u.f141717a);
            calendar2.set(2100, 11, 31);
            this.f146567k = Long.valueOf(calendar2.getTimeInMillis());
        }
        Date b18 = this.f146565i.b(jSONObject.optString("current", ""));
        if (b18 == null) {
            b18 = new Date(System.currentTimeMillis());
            Date date = new Date(this.f146567k.longValue());
            Date date2 = new Date(this.f146566j.longValue());
            if (b18.after(date)) {
                b18 = date;
            } else if (b18.before(date2)) {
                b18 = date2;
            }
        }
        this.f146568l = b18.getYear() + 1900;
        this.f146569m = b18.getMonth() + 1;
        this.C = b18.getDate();
        a(new a());
    }

    public final void e() {
        boolean z16;
        boolean z17;
        AppBrandDatePickerV2 appBrandDatePickerV2 = (AppBrandDatePickerV2) b(AppBrandDatePickerV2.class);
        if (appBrandDatePickerV2 == null) {
            a("fail cant init view");
            return;
        }
        com.tencent.luggage.wxa.zl.a b16 = b();
        b16.setOnResultListener(new C6983b());
        if (this.f146566j != null) {
            appBrandDatePickerV2.b(this.f146566j);
        }
        if (this.f146567k != null) {
            appBrandDatePickerV2.a(this.f146567k);
        }
        int i3 = this.f146568l;
        int i16 = this.f146569m;
        int i17 = this.C;
        boolean z18 = true;
        if (this.f146565i.ordinal() >= c.f146572b.ordinal()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f146565i.ordinal() >= c.f146573c.ordinal()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (this.f146565i.ordinal() < c.f146574d.ordinal()) {
            z18 = false;
        }
        appBrandDatePickerV2.a(i3, i16, i17, z16, z17, z18);
        b16.setHeader(this.f146583g);
        b16.j();
    }

    @Override // com.tencent.luggage.wxa.zf.e
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
    }

    public final void a(boolean z16, String str) {
        if (b() == null) {
            return;
        }
        if (!z16) {
            a("fail cancel", (Map) null);
        }
        if (w0.c(str)) {
            a("fail", (Map) null);
        } else {
            HashMap hashMap = new HashMap(1);
            hashMap.put("value", str);
            a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap);
        }
        b().d();
    }
}
