package bp2;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.config.ai;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private int f28842d = 1;

    /* renamed from: e, reason: collision with root package name */
    private int f28843e = 1;

    /* renamed from: f, reason: collision with root package name */
    private int f28844f = 1;

    /* renamed from: h, reason: collision with root package name */
    private int f28845h = 1;

    /* renamed from: i, reason: collision with root package name */
    boolean f28846i;

    private static void a(a aVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.k(jSONObject.optInt("business_switch_message", 1));
            aVar.h(jSONObject.optInt("business_switch_contact", 1));
            aVar.i(jSONObject.optInt("business_switch_dongtai", 1));
            aVar.j(jSONObject.optInt("business_switch_guild", 1));
            aVar.f28846i = true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SearchBusinessConfBean", 2, "parse error->" + e16.toString());
            }
        }
    }

    public static a f(ai aiVar) {
        a aVar = new a();
        if (aiVar != null) {
            if (QLog.isColorLevel()) {
                QLog.d("SearchBusinessConfBean", 2, "parse taskid->" + aiVar.f202267a + " content->" + aiVar.f202268b);
            }
            a(aVar, aiVar.f202268b);
        }
        return aVar;
    }

    public static a g(String str) {
        a aVar = new a();
        a(aVar, str);
        return aVar;
    }

    public boolean b() {
        if (this.f28843e == 1) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f28844f == 1) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f28842d == 1) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f28846i;
    }

    void h(int i3) {
        this.f28843e = i3;
    }

    void i(int i3) {
        this.f28844f = i3;
    }

    void j(int i3) {
        this.f28845h = i3;
    }

    void k(int i3) {
        this.f28842d = i3;
    }

    public String toString() {
        return String.format("mBusinessSwitchTabMessage:%d, mBusinessSwitchTabContact:%d, mBusinessSwitchTabDongtai:%d", Integer.valueOf(this.f28842d), Integer.valueOf(this.f28843e), Integer.valueOf(this.f28844f));
    }
}
