package ku3;

import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f413053a;

    /* renamed from: b, reason: collision with root package name */
    public int f413054b;

    /* renamed from: c, reason: collision with root package name */
    public int f413055c;

    /* renamed from: d, reason: collision with root package name */
    public String f413056d;

    /* renamed from: e, reason: collision with root package name */
    public String f413057e;

    /* renamed from: f, reason: collision with root package name */
    public int f413058f;

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("display", this.f413053a);
            jSONObject.put("adId", this.f413054b);
            jSONObject.put("adPosId", this.f413055c);
            jSONObject.put(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, this.f413056d);
            jSONObject.put("ext", this.f413057e);
            jSONObject.put("source", this.f413058f);
        } catch (JSONException e16) {
            QMLog.e("GameBoxRedDot", e16.toString());
        }
        return jSONObject.toString();
    }
}
