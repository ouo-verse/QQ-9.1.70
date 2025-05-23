package com.tencent.mobileqq.qqlive.config;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f271179a;

    /* renamed from: b, reason: collision with root package name */
    public String f271180b;

    /* renamed from: c, reason: collision with root package name */
    public String f271181c;

    /* renamed from: d, reason: collision with root package name */
    public String f271182d;

    /* renamed from: e, reason: collision with root package name */
    public String f271183e;

    /* renamed from: f, reason: collision with root package name */
    public String f271184f;

    /* renamed from: g, reason: collision with root package name */
    public String f271185g;

    /* renamed from: h, reason: collision with root package name */
    public int f271186h;

    /* renamed from: i, reason: collision with root package name */
    public float f271187i;

    /* renamed from: j, reason: collision with root package name */
    public long f271188j;

    /* renamed from: k, reason: collision with root package name */
    public f f271189k;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f271179a = "https://h5.qzone.qq.com/v2/vip/live/profile?puin={pUin}&openid={anchorOpenId}&anchorUid={anchorUid}&_wv=16777217";
        this.f271180b = "https://sola.gtimg.cn/aoi/sola/20201215180203_9wAPjFrkcp.png";
        this.f271181c = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/PK/PK/prize/kjdh.png?nowebp&nosharpp";
        this.f271182d = "https://h5.qzone.qq.com/v2/vip/live/qlive-h5/pages/plat-lottery.html?lotteryId={lotteryId}&roomId={roomId}&programId={programId}&busId={busId}";
        this.f271183e = "https://qlive.qq.com/pages/name-auth.html";
        this.f271184f = "https://h5.qzone.qq.com/v2/vip/live/qlive-h5/pages/portal.html?_wv=16777216";
        this.f271185g = "https://h5.qzone.qq.com/v2/vip/live/qlive-h5/pages/rank.html?_wv=16777216";
        this.f271186h = 0;
        this.f271187i = 1.0f;
        this.f271188j = 6000L;
        this.f271189k = new f();
    }

    @Nullable
    public static d a(ai[] aiVarArr) {
        d dVar = new d();
        if (aiVarArr != null && aiVarArr.length != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveConfigBean", 2, "parse");
            }
            for (ai aiVar : aiVarArr) {
                c(dVar, aiVar);
            }
            QLog.d("QQLiveConfigBean", 1, "parse, config=", dVar);
        }
        return dVar;
    }

    private static void b(JSONObject jSONObject, d dVar) {
        JSONObject optJSONObject = jSONObject.optJSONObject("player");
        if (optJSONObject != null) {
            dVar.f271189k.f271191a = optJSONObject.optInt("playerPoolMaxSize", 3);
            dVar.f271189k.f271192b = optJSONObject.optBoolean("enableMaxSize", false);
        }
    }

    private static void c(d dVar, ai aiVar) {
        try {
            if (!TextUtils.isEmpty(aiVar.f202268b)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQLiveConfigBean", 2, "parse, content=", aiVar.f202268b);
                }
                JSONObject jSONObject = new JSONObject(aiVar.f202268b);
                dVar.f271179a = jSONObject.optString("livePersonalPageUrl", "https://h5.qzone.qq.com/v2/vip/live/profile?puin={pUin}&openid={anchorOpenId}&anchorUid={anchorUid}&_wv=16777217");
                dVar.f271180b = jSONObject.optString("lotteryPic", "https://sola.gtimg.cn/aoi/sola/20201215180203_9wAPjFrkcp.png");
                dVar.f271181c = jSONObject.optString("lotteryEffectPic", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/PK/PK/prize/kjdh.png?nowebp&nosharpp");
                dVar.f271182d = jSONObject.optString("lotteryPageUrl", "https://h5.qzone.qq.com/v2/vip/live/qlive-h5/pages/plat-lottery.html?lotteryId={lotteryId}&roomId={roomId}&programId={programId}&busId={busId}");
                dVar.f271183e = jSONObject.optString("liveVerifyUrl", "https://qlive.qq.com/pages/name-auth.html");
                dVar.f271184f = jSONObject.optString("liveMorePageUrl", "https://h5.qzone.qq.com/v2/vip/live/qlive-h5/pages/portal.html?_wv=16777216");
                dVar.f271186h = jSONObject.optInt("reduceLiveLatencyAction8823", 0);
                dVar.f271188j = jSONObject.optLong("minBufferDuration", 6000L);
                dVar.f271187i = (float) jSONObject.optDouble("speedUpRate", 1.0d);
                dVar.f271185g = jSONObject.optString("liveOnlineRankUrl", "https://h5.qzone.qq.com/v2/vip/live/qlive-h5/pages/rank.html?_wv=16777216");
                b(jSONObject, dVar);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQLiveConfigBean", 1, "parse e:", e16.getMessage());
            }
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QQLiveConfigBean{livePersonalPageUrl='" + this.f271179a + "', lotteryPic='" + this.f271180b + "', lotteryEffectPic='" + this.f271181c + "', lotteryPageUrl='" + this.f271182d + "', liveVerifyUrl='" + this.f271183e + "', livePortalUrl='" + this.f271184f + "', liveOnlineRankUrl='" + this.f271185g + "'}";
    }
}
