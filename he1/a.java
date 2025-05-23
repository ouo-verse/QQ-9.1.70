package he1;

import androidx.annotation.NonNull;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f404787a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f404788b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f404789c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f404790d = "";

    /* renamed from: e, reason: collision with root package name */
    public int f404791e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f404792f = Integer.MAX_VALUE;

    /* renamed from: g, reason: collision with root package name */
    public d f404793g = new d(0, 0);

    /* renamed from: h, reason: collision with root package name */
    public int f404794h = 1;

    /* renamed from: i, reason: collision with root package name */
    public int f404795i = 0;

    /* renamed from: j, reason: collision with root package name */
    public String f404796j = "";

    /* renamed from: k, reason: collision with root package name */
    public String f404797k = "";

    public static long b(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            simpleDateFormat.setCalendar(new GregorianCalendar());
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
            Date parse = simpleDateFormat.parse(str);
            if (parse == null) {
                return 0L;
            }
            return parse.getTime();
        } catch (Exception e16) {
            QLog.e("SearchPopAnimData", 1, "parseTime exception: " + e16);
            return 0L;
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f404793g.f404802a = b(jSONObject.optString("BeginTime"));
        this.f404793g.f404803b = b(jSONObject.optString("EndTime"));
        this.f404794h = jSONObject.optInt("Priority", this.f404794h);
        this.f404795i = jSONObject.optInt("MatchMode", this.f404795i);
        this.f404787a = jSONObject.optInt("ID", this.f404787a);
        this.f404788b = jSONObject.optString("JumpURL", this.f404788b);
        this.f404796j = jSONObject.optString("ActId", this.f404796j);
        this.f404797k = jSONObject.optString("GameAppId", this.f404797k);
        this.f404789c = jSONObject.optString("Keyword", this.f404789c);
        this.f404790d = jSONObject.optString("LottieResUrl", this.f404790d);
        this.f404791e = jSONObject.optInt("LimitType", this.f404791e);
        this.f404792f = jSONObject.optInt("LimitCount", this.f404792f);
    }

    @NonNull
    public String toString() {
        return "SearchPopAnimData{ID=" + this.f404787a + ", jumpURL=" + this.f404788b + ", keyWord=" + this.f404789c + ", lottieResUrl=" + this.f404790d + ", triggerTimeLimit=" + this.f404792f + "}";
    }
}
