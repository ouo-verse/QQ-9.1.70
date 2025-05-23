package my3;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a implements IConfigData {
    private MMKVOptionEntity H;
    private int G = 0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f417800d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f417801e = 100;

    /* renamed from: f, reason: collision with root package name */
    private Set<String> f417802f = new HashSet();

    /* renamed from: h, reason: collision with root package name */
    private boolean f417803h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f417804i = true;

    /* renamed from: m, reason: collision with root package name */
    private boolean f417805m = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public static a a(JSONObject jSONObject) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        a aVar = new a();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("errorConfig");
            String string = jSONObject2.getString("dumpAllThread");
            if (!TextUtils.isEmpty(string) && Boolean.parseBoolean(string)) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.f417800d = z16;
            aVar.f417801e = jSONObject2.getInt(GameCenterUtil.CONF_KEY_REPORT_RATE);
            JSONArray jSONArray = jSONObject2.getJSONArray("dumpThreadWhitelist");
            HashSet hashSet = new HashSet();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                hashSet.add(jSONArray.getString(i3));
            }
            aVar.f417802f = new HashSet(hashSet);
            JSONObject jSONObject3 = jSONObject.getJSONObject("crashConfig");
            String string2 = jSONObject3.getString("crashMergeSwitch");
            if (!TextUtils.isEmpty(string2) && Boolean.parseBoolean(string2)) {
                z17 = true;
            } else {
                z17 = false;
            }
            aVar.f417803h = z17;
            if (jSONObject3.has("nativeSubProcessSwitch")) {
                String string3 = jSONObject3.getString("nativeSubProcessSwitch");
                if (!TextUtils.isEmpty(string3) && Boolean.parseBoolean(string3)) {
                    z29 = true;
                } else {
                    z29 = false;
                }
                aVar.f417804i = z29;
            }
            JSONObject jSONObject4 = jSONObject.getJSONObject("anrConfig");
            String string4 = jSONObject4.getString("mainThreadStackTraceSwitch");
            if (!TextUtils.isEmpty(string4) && Boolean.parseBoolean(string4)) {
                z18 = true;
            } else {
                z18 = false;
            }
            aVar.f417805m = z18;
            String string5 = jSONObject4.getString("sysTraceSwtich");
            if (!TextUtils.isEmpty(string5) && Boolean.parseBoolean(string5)) {
                z19 = true;
            } else {
                z19 = false;
            }
            aVar.C = z19;
            if (jSONObject.has("issueDebugConfig")) {
                JSONObject jSONObject5 = jSONObject.getJSONObject("issueDebugConfig");
                if (jSONObject5.has("activityResumeWithDestoryMsgCheckSwitch")) {
                    String string6 = jSONObject5.getString("activityResumeWithDestoryMsgCheckSwitch");
                    if (!TextUtils.isEmpty(string6) && Boolean.parseBoolean(string6)) {
                        z28 = true;
                    } else {
                        z28 = false;
                    }
                    aVar.D = z28;
                }
                if (jSONObject5.has("badTokenActivityFinishSwitch")) {
                    String string7 = jSONObject5.getString("badTokenActivityFinishSwitch");
                    if (!TextUtils.isEmpty(string7) && Boolean.parseBoolean(string7)) {
                        z27 = true;
                    } else {
                        z27 = false;
                    }
                    aVar.E = z27;
                }
                if (jSONObject5.has("activityRecordIssueHookFixSwitch")) {
                    String string8 = jSONObject5.getString("activityRecordIssueHookFixSwitch");
                    if (!TextUtils.isEmpty(string8) && Boolean.parseBoolean(string8)) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    aVar.F = z26;
                }
                if (jSONObject5.has("anrRecordMessageQueueNum")) {
                    aVar.G = jSONObject5.optInt("anrRecordMessageQueueNum", 0);
                }
            }
        } catch (JSONException e16) {
            QLog.e("CrashConfig", 1, "[fromJson] error: " + e16.toString());
        }
        return aVar;
    }

    private MMKVOptionEntity d() {
        if (this.H == null) {
            this.H = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        }
        return this.H;
    }

    public int b() {
        return this.G;
    }

    public Set<String> c() {
        return this.f417802f;
    }

    public int e() {
        return this.f417801e;
    }

    public boolean f() {
        return this.F;
    }

    public boolean g() {
        return this.D;
    }

    public boolean h() {
        return this.E;
    }

    public boolean i() {
        return this.f417803h;
    }

    public boolean j() {
        return this.f417800d;
    }

    public boolean k() {
        return this.f417805m;
    }

    public boolean l() {
        return this.f417804i;
    }

    public boolean m() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        MMKVOptionEntity d16 = d();
        this.f417800d = d16.decodeBool("dumpAllThread", false);
        this.f417801e = d16.decodeInt(GameCenterUtil.CONF_KEY_REPORT_RATE, 100);
        this.f417802f = new HashSet(d16.decodeStringSet("dumpThreadWhitelist", new HashSet()));
        this.f417803h = d16.decodeBool("crashMergeSwitch", true);
        this.f417804i = d16.decodeBool("nativeSubProcessSwitch", true);
        this.f417805m = d16.decodeBool("mainThreadStackTraceSwitch", false);
        this.C = d16.decodeBool("sysTraceSwtich", false);
        this.D = d16.decodeBool("activityResumeWithDestoryMsgCheckSwitch", false);
        this.E = d16.decodeBool("badTokenActivityFinishSwitch", false);
        this.F = d16.decodeBool("activityRecordIssueHookFixSwitch", false);
        this.G = d16.decodeInt("anrRecordMessageQueueNum", 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(a aVar) {
        MMKVOptionEntity d16 = d();
        d16.encodeBool("dumpAllThread", aVar.j());
        d16.encodeInt(GameCenterUtil.CONF_KEY_REPORT_RATE, aVar.e());
        d16.encodeStringSet("dumpThreadWhitelist", aVar.c());
        d16.encodeBool("crashMergeSwitch", aVar.i());
        d16.encodeBool("nativeSubProcessSwitch", aVar.l());
        d16.encodeBool("mainThreadStackTraceSwitch", aVar.k());
        d16.encodeBool("sysTraceSwtich", aVar.m());
        d16.encodeBool("activityResumeWithDestoryMsgCheckSwitch", aVar.g());
        d16.encodeBool("badTokenActivityFinishSwitch", aVar.h());
        d16.encodeBool("activityRecordIssueHookFixSwitch", aVar.f());
        d16.encodeInt("anrRecordMessageQueueNum", aVar.b());
        d16.commitAsync();
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(super.toString());
        sb5.append(" |dumpAllThread = " + this.f417800d);
        sb5.append(" |reportSampleRate = " + this.f417801e);
        sb5.append(" |dumpThreadWhitelist = " + this.f417802f);
        sb5.append(" |crashMergeSwitch = " + this.f417803h);
        sb5.append(" |nativeSubProcessSwitch = " + this.f417804i);
        sb5.append(" |mainThreadStackTraceSwitch = " + this.f417805m);
        sb5.append(" |sysTraceSwtich = " + this.C);
        sb5.append(" |activityResumeWithDestoryMsgCheckSwitch = " + this.D);
        sb5.append(" |badTokenActivityFinishSwitch = " + this.E);
        sb5.append(" |activityRecordIssueHookFixSwitch = " + this.F);
        sb5.append(" |anrRecordMessageQueueNum = " + this.G);
        return sb5.toString();
    }
}
