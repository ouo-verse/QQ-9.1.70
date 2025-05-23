package com.tencent.mobileqq.config.business;

import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ay {

    /* renamed from: c, reason: collision with root package name */
    public boolean f202568c;

    /* renamed from: d, reason: collision with root package name */
    public int f202569d;

    /* renamed from: e, reason: collision with root package name */
    public String f202570e;

    /* renamed from: f, reason: collision with root package name */
    public String f202571f;

    /* renamed from: g, reason: collision with root package name */
    public String f202572g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f202573h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f202574i;

    /* renamed from: n, reason: collision with root package name */
    public ud1.g f202579n;

    /* renamed from: a, reason: collision with root package name */
    public List<String> f202566a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public Set<String> f202567b = new HashSet();

    /* renamed from: j, reason: collision with root package name */
    public int f202575j = 1;

    /* renamed from: k, reason: collision with root package name */
    public boolean f202576k = true;

    /* renamed from: l, reason: collision with root package name */
    public boolean f202577l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f202578m = false;

    public static ay a(com.tencent.mobileqq.config.ai[] aiVarArr) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        com.tencent.mobileqq.config.ai[] aiVarArr2 = aiVarArr;
        ay ayVar = new ay();
        try {
            int length = aiVarArr2.length;
            int i3 = 0;
            while (i3 < length) {
                com.tencent.mobileqq.config.ai aiVar = aiVarArr2[i3];
                JSONObject jSONObject = new JSONObject(aiVar.f202268b);
                int i16 = length;
                if (jSONObject.has("teamAppKeys")) {
                    ayVar.f202566a.clear();
                    JSONArray optJSONArray = jSONObject.optJSONArray("teamAppKeys");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i17 = 0; i17 < optJSONArray.length(); i17++) {
                            ayVar.f202566a.add(optJSONArray.optString(i17));
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QQGameTeamConfBean", 2, "onParsed teamKeys=" + optJSONArray);
                    }
                } else if (jSONObject.has("gameRobots")) {
                    ayVar.f202567b.clear();
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("gameRobots");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        for (int i18 = 0; i18 < optJSONArray2.length(); i18++) {
                            ayVar.f202567b.add(optJSONArray2.optString(i18));
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QQGameTeamConfBean", 2, "onParsed robotArray=", optJSONArray2);
                    }
                } else if (jSONObject.has("gameRankConfig")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("gameRankConfig");
                    if (optJSONObject.optInt("showGameRankEntrance") == 1) {
                        z27 = true;
                    } else {
                        z27 = false;
                    }
                    ayVar.f202568c = z27;
                    ayVar.f202569d = optJSONObject.optInt("pageType", 0);
                    ayVar.f202570e = optJSONObject.optString("h5Url");
                    ayVar.f202571f = optJSONObject.optString("hippyPageUrl");
                    ayVar.f202572g = optJSONObject.optString(OpenHippyInfo.EXTRA_KEY_ERROR_URL);
                    if (QLog.isColorLevel()) {
                        QLog.d("QQGameTeamConfBean", 2, "onParsed showGameRank=", Boolean.valueOf(ayVar.f202568c), ", gameRankPageType=", Integer.valueOf(ayVar.f202569d), ", gameRankH5Url=", ayVar.f202570e, ", gameRankHippyPageUrl=", ayVar.f202571f, ", gameRankHippyPageErrorUrl=", ayVar.f202572g);
                    }
                } else if (jSONObject.has("hippyHttpConfig")) {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("hippyHttpConfig");
                    if (optJSONObject2.optInt("enableHttp2") == 1) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    ayVar.f202573h = z19;
                    if (optJSONObject2.optInt("enableNewHttp2") == 1) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    ayVar.f202574i = z26;
                    QLog.i("QQGameTeamConfBean", 1, "onParsed enableNewHttp2=" + ayVar.f202574i);
                    GamePubAccountHelper.P(ayVar.f202573h);
                } else if (jSONObject.has("qaChannelConfig")) {
                    ayVar.f202575j = jSONObject.optJSONObject("qaChannelConfig").optInt("qaAskButtonTestShowMaxTimes", 1);
                    if (QLog.isColorLevel()) {
                        QLog.d("QQGameTeamConfBean", 2, "onParsed askButtonTestShowMaxTimes=", Integer.valueOf(ayVar.f202575j));
                    }
                } else if (jSONObject.has("gameCenterCalendarConfig")) {
                    JSONObject optJSONObject3 = jSONObject.optJSONObject("gameCenterCalendarConfig");
                    if (optJSONObject3 != null) {
                        if (optJSONObject3.optInt("enableJsBridge", 1) == 1) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        ayVar.f202576k = z18;
                    }
                    QLog.d("QQGameTeamConfBean", 1, "onParsed enableCalendarJsbridge=", Boolean.valueOf(ayVar.f202576k));
                    GamePubAccountHelper.S(ayVar.f202576k);
                } else if (jSONObject.has("qaArticleConfig")) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQGameTeamConfBean", 2, "onParsed qaArticleConfig=", aiVar.f202268b);
                    }
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("qaArticleConfig");
                    if (optJSONArray3 != null) {
                        ud1.g gVar = new ud1.g();
                        gVar.b(optJSONArray3);
                        ayVar.f202579n = gVar;
                    }
                } else if (jSONObject.has("gameListReportConfig")) {
                    JSONObject optJSONObject4 = jSONObject.optJSONObject("gameListReportConfig");
                    if (optJSONObject4 != null) {
                        if (optJSONObject4.optInt("enableGameListReport", 0) != 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        ayVar.f202577l = z17;
                    }
                    QLog.d("QQGameTeamConfBean", 1, "onParsed enableGameListReport=", Boolean.valueOf(ayVar.f202577l));
                } else if (jSONObject.has("selectGameInstallerConfig")) {
                    JSONObject optJSONObject5 = jSONObject.optJSONObject("selectGameInstallerConfig");
                    if (optJSONObject5 != null) {
                        if (optJSONObject5.optInt("enableSelectGameInstaller", 0) != 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        ayVar.f202578m = z16;
                    }
                    QLog.d("QQGameTeamConfBean", 1, "onParsed enableSelectGameInstaller=", Boolean.valueOf(ayVar.f202578m));
                    i3++;
                    aiVarArr2 = aiVarArr;
                    length = i16;
                }
                i3++;
                aiVarArr2 = aiVarArr;
                length = i16;
            }
        } catch (Throwable th5) {
            QLog.e("QQGameTeamConfBean", 1, "parse error e=" + th5);
        }
        return ayVar;
    }
}
