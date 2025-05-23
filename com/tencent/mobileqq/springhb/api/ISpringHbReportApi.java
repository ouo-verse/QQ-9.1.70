package com.tencent.mobileqq.springhb.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.io.Serializable;
import java.util.Map;
import kl2.a;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes18.dex */
public interface ISpringHbReportApi extends IRuntimeService {
    public static final int ACT_TYPE_ALL = 3;
    public static final int ACT_TYPE_GAME_CENTER = 1;
    public static final int ACT_TYPE_SPRING_HB = 2;
    public static final int ACT_TYPE_UNKNOWN = 0;

    void checkResCover(int i3);

    void configReport(int i3, int i16, int i17, int i18, int i19, boolean z16, String... strArr);

    void gameHBConfigReport(int i3, int i16, int i17, int i18, int i19, boolean z16, String... strArr);

    void report(Serializable serializable, int i3);

    void reportExCatch(int i3, Throwable th5, String... strArr);

    void reportForGameCenter(Map<String, String> map);

    void reportForSpringHb(Map<String, String> map);

    void reportGameHBConfigCoverage(int i3, int i16, int i17, int i18, int i19, boolean z16, String str);

    void reportPerformance(int i3, long j3, String str);

    void reportResPreload(a aVar, String str, String str2, int i3);

    void reportResRealTimeDownload(String str, String str2, int i3);

    void reportResourceConfigCover(int i3, int i16, int i17, int i18, int i19, boolean z16, String str, String str2, int i26);

    void reportSpringHBConfigCoverage(int i3, int i16, int i17, int i18, int i19, boolean z16, String str);

    void tryReportResState(boolean z16);

    void webReport(JSONObject jSONObject, int i3);
}
