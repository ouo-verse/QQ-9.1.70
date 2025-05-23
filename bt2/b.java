package bt2;

import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f29099a = 1;

    /* renamed from: b, reason: collision with root package name */
    private String f29100b = "";

    public static b b() {
        return (b) am.s().x(LocaleManager.MOBILE_COUNTRY_CODE_CN_INT);
    }

    public static b d(ai aiVar) {
        b bVar = new b();
        if (aiVar != null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopRobotConfBean", 2, "parse taskid->" + aiVar.f202267a + " content->" + aiVar.f202268b);
            }
            try {
                JSONObject jSONObject = new JSONObject(aiVar.f202268b);
                int optInt = jSONObject.optInt("robotswitch", 0);
                String optString = jSONObject.optString("c2cwarning", "");
                bVar.f(optInt);
                bVar.e(optString);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopRobotConfBean", 2, "parse error->" + e16.toString());
                }
            }
        }
        return bVar;
    }

    public String a() {
        return this.f29100b;
    }

    public boolean c() {
        if (this.f29099a == 1) {
            return true;
        }
        return false;
    }

    public void e(String str) {
        this.f29100b = str;
    }

    void f(int i3) {
        this.f29099a = i3;
    }

    public String toString() {
        return String.format("mTroopRobotSwitch:%d", Integer.valueOf(this.f29099a));
    }
}
