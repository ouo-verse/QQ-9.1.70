package nu1;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.guild.message.registerproxy.manage.GuildRegisterProxyConfigProcessor;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f421289a = 1000;

    /* renamed from: b, reason: collision with root package name */
    public int f421290b = 5;

    /* renamed from: c, reason: collision with root package name */
    public int f421291c = 100;

    /* renamed from: d, reason: collision with root package name */
    public int f421292d = 20000;

    /* renamed from: e, reason: collision with root package name */
    public int f421293e = 15;

    /* renamed from: f, reason: collision with root package name */
    public int f421294f = 15;

    /* renamed from: g, reason: collision with root package name */
    public int f421295g = 1;

    /* renamed from: h, reason: collision with root package name */
    public int f421296h = 500;

    /* renamed from: i, reason: collision with root package name */
    public int f421297i = 500;

    /* renamed from: j, reason: collision with root package name */
    public int f421298j = 3;

    public static a a(ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            QLog.d("RP_improve_tag", 2, "GuildRegisterProxyConfigBean#parse, ", aiVarArr[0].f202268b);
            try {
                a aVar = new a();
                JSONObject jSONObject = new JSONObject(aiVarArr[0].f202268b);
                aVar.f421289a = jSONObject.optInt("pullInterval", 1000);
                aVar.f421290b = jSONObject.optInt("oncePullCount", 5);
                aVar.f421291c = jSONObject.optInt("RPMaxPullCount", 100);
                aVar.f421292d = jSONObject.optInt("RPMinTriggerInterval", 20000);
                aVar.f421293e = jSONObject.optInt("pullMsgCountForNormal", 15);
                aVar.f421294f = jSONObject.optInt("pullMsgCountForHuge", 15);
                aVar.f421295g = jSONObject.optInt("pullMsgCountForHugeNotifyOff", 1);
                aVar.f421296h = jSONObject.optInt("pullHighPriorityGuildDelayMs", 500);
                aVar.f421297i = jSONObject.optInt("switchGuildIntervalMs", 500);
                aVar.f421298j = jSONObject.optInt("frequentlySwitchGuildMaxCount", 3);
                return aVar;
            } catch (Exception e16) {
                QLog.e(GuildRegisterProxyConfigProcessor.f230788a, 1, e16, new Object[0]);
                return null;
            }
        }
        QLog.e(GuildRegisterProxyConfigProcessor.f230788a, 1, "onParsed error: confFiles is empty");
        return null;
    }

    @NonNull
    public String toString() {
        return "mPullInterval=" + this.f421289a + ", mOncePullCount=" + this.f421290b + ", mRPMaxPullCount=" + this.f421291c + ", mRPMinTriggerInterval=" + this.f421292d + ", mPullMsgCountForNormal=" + this.f421293e + ", mPullMsgCountForHuge=" + this.f421294f + ", mPullMsgCountForHugeNotifyOff=" + this.f421295g + ", mPullHighPriorityGuildDelayMs=" + this.f421296h + ", mSwitchGuildIntervalMs=" + this.f421297i + ", mFrequentlySwitchGuildMaxCount=" + this.f421298j;
    }
}
