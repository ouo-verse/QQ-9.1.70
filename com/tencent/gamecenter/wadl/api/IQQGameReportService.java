package com.tencent.gamecenter.wadl.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.d;
import com.tencent.gamecenter.wadl.biz.entity.h;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IQQGameReportService extends QRouteApi {
    public static final String QQGAME_PAGE_NAME = "qflutter_qqgame";

    void report(JSONObject jSONObject, int i3);

    void report157(WadlReportBuilder wadlReportBuilder);

    void reportDC(WadlReportBuilder wadlReportBuilder);

    void reportDC(String str, String str2, h hVar, String str3);

    void reportDC(AppRuntime appRuntime, String str);

    void reportToAtta(String str, String str2, String str3);

    void reportToAtta78603(d dVar);

    void reportToAttaForException(String str, String str2, String str3, String str4);

    void reportToAttaForFps(String str, int i3);
}
