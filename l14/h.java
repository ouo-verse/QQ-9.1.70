package l14;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.rmonitor.common.logger.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final String f413687a;

    /* renamed from: b, reason: collision with root package name */
    private final g f413688b;

    /* renamed from: c, reason: collision with root package name */
    private final g f413689c;

    /* renamed from: d, reason: collision with root package name */
    private final g f413690d;

    /* renamed from: e, reason: collision with root package name */
    private String f413691e;

    /* renamed from: f, reason: collision with root package name */
    private String f413692f;

    /* renamed from: g, reason: collision with root package name */
    private String f413693g;

    /* renamed from: h, reason: collision with root package name */
    private String f413694h;

    /* renamed from: i, reason: collision with root package name */
    private String f413695i;

    /* renamed from: j, reason: collision with root package name */
    private String f413696j;

    public h(String str) {
        this.f413691e = "";
        this.f413692f = "";
        this.f413693g = "";
        this.f413694h = "";
        this.f413695i = "";
        this.f413696j = "";
        this.f413687a = str;
        this.f413688b = new g("", str);
        this.f413689c = new g("fg_", str);
        this.f413690d = new g("bg_", str);
        this.f413695i = TraceGenerator.getProcessLaunchId();
        this.f413696j = TraceGenerator.getLaunchId(ContextUtil.getGlobalContext());
    }

    private String d() {
        return "launch_id_" + this.f413687a;
    }

    private String g() {
        return "process_launch_id_" + this.f413687a;
    }

    private String h(String str) {
        return str + "stage_" + this.f413687a;
    }

    private String i() {
        return "user_custom_" + this.f413687a;
    }

    public g a() {
        return this.f413690d;
    }

    public g b() {
        return this.f413689c;
    }

    public String c() {
        return this.f413696j;
    }

    public g e() {
        return this.f413688b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (!this.f413688b.equals(hVar.f413688b) || !this.f413689c.equals(hVar.f413689c) || !this.f413690d.equals(hVar.f413690d) || !TextUtils.equals(this.f413691e, hVar.f413691e) || !TextUtils.equals(this.f413692f, hVar.f413692f) || !TextUtils.equals(this.f413693g, hVar.f413693g)) {
            return false;
        }
        return TextUtils.equals(this.f413694h, hVar.f413694h);
    }

    public String f() {
        return this.f413695i;
    }

    public void j(long j3, long j16, long j17, String str, String str2) {
        this.f413688b.g(j3, j16, j17);
        this.f413689c.g(j3, j16, j17);
        this.f413690d.g(0L, 0L, 0L);
        this.f413691e = str;
        this.f413692f = str;
        this.f413693g = str;
        this.f413694h = str2;
    }

    public boolean k() {
        return this.f413688b.h();
    }

    public void l(SharedPreferences sharedPreferences) {
        this.f413688b.i(sharedPreferences);
        this.f413689c.i(sharedPreferences);
        this.f413690d.i(sharedPreferences);
        this.f413691e = sharedPreferences.getString(h("java_"), "");
        this.f413692f = sharedPreferences.getString(h("pss_"), "");
        this.f413693g = sharedPreferences.getString(h("vss_"), "");
        this.f413694h = sharedPreferences.getString(i(), "");
        this.f413696j = sharedPreferences.getString(d(), "");
        this.f413695i = sharedPreferences.getString(g(), "");
    }

    public void m(JSONObject jSONObject) throws JSONException {
        this.f413688b.j(jSONObject);
        this.f413689c.j(jSONObject);
        this.f413690d.j(jSONObject);
        if (!TextUtils.isEmpty(this.f413691e)) {
            jSONObject.put("java_stage", this.f413691e);
        }
        if (!TextUtils.isEmpty(this.f413692f)) {
            jSONObject.put("pss_stage", this.f413692f);
        }
        if (!TextUtils.isEmpty(this.f413693g)) {
            jSONObject.put("vss_stage", this.f413693g);
        }
        if (!TextUtils.isEmpty(this.f413694h)) {
            try {
                jSONObject.put(ReportDataBuilder.KEY_USER_CUSTOM, new JSONObject(this.f413694h));
            } catch (Throwable th5) {
                Logger.f365497g.b("RMonitor_MemoryQuantile", "packJson", th5);
            }
        }
    }

    public void n(SharedPreferences.Editor editor) {
        this.f413688b.k(editor);
        this.f413689c.k(editor);
        this.f413690d.k(editor);
        editor.putString(h("java_"), this.f413691e);
        editor.putString(h("pss_"), this.f413692f);
        editor.putString(h("vss_"), this.f413693g);
        editor.putString(i(), this.f413694h);
        editor.putString(g(), this.f413695i);
        editor.putString(d(), this.f413696j);
        editor.commit();
    }

    public void o(SharedPreferences.Editor editor, String str, String str2, boolean z16, boolean z17, boolean z18) {
        if (z16) {
            this.f413691e = str;
            editor.putString(h("java_"), str);
        }
        if (z17) {
            this.f413692f = str;
            editor.putString(h("pss_"), str);
        }
        if (z18) {
            this.f413693g = str;
            editor.putString(h("vss_"), str);
        }
        if (!TextUtils.equals(this.f413694h, str2)) {
            this.f413694h = str2;
            editor.putString(i(), str2);
        }
    }

    public h(h hVar) {
        this.f413691e = "";
        this.f413692f = "";
        this.f413693g = "";
        this.f413694h = "";
        this.f413695i = "";
        this.f413696j = "";
        this.f413687a = hVar.f413687a;
        this.f413688b = new g(hVar.f413688b);
        this.f413689c = new g(hVar.f413689c);
        this.f413690d = new g(hVar.f413690d);
        this.f413691e = hVar.f413691e;
        this.f413692f = hVar.f413692f;
        this.f413693g = hVar.f413693g;
        this.f413694h = hVar.f413694h;
        this.f413695i = hVar.f413695i;
        this.f413696j = hVar.f413696j;
    }
}
