package com.tencent.mobileqq.search.api;

import android.content.Context;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.search.model.PublicAccountInfoForSearch;
import com.tencent.mobileqq.search.model.y;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISearchReportFetcher extends QRouteApi {
    PublicAccountInfoForSearch convertToPublicAccountEntity(Entity entity);

    void onActionContactSearchModel(y yVar, View view, String str, int i3, String str2);

    void onActionPublicAccountSearchResultModel(AppInterface appInterface, View view, Context context, PublicAccountInfoForSearch publicAccountInfoForSearch, int i3, String str, int i16);

    void onReportClick898(AppInterface appInterface, int i3, int i16, String str, int i17, int i18, String str2, String str3);

    void onReportRuntimeDC02528(AppInterface appInterface, long j3, String str, String str2, JSONObject jSONObject);
}
