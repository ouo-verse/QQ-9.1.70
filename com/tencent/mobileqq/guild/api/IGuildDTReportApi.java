package com.tencent.mobileqq.guild.api;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqmini.v8rt.anno.NotNull;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildDTReportApi extends QRouteApi {
    void doReportEvent(String str, Map<String, Object> map);

    @Nullable
    PageInfo getNearestPageInfoWithPgId(View view);

    @NotNull
    Map<String, Object> getPageInfoParams(PageInfo pageInfo);

    void reportDtEventManual(View view, String str, String str2, String str3, String str4, Map<String, Object> map, Map<String, Object> map2);

    void reportDtEventManual(View view, String str, String str2, String str3, Map<String, Object> map);

    void reportDtEventManual(View view, String str, String str2, Map<String, Object> map);

    void setChannelPageParams(View view, @NonNull IGProChannelInfo iGProChannelInfo, Map<String, Object> map);

    void setChannelPageParams(View view, @NonNull String str, @NonNull String str2, Map<String, Object> map);

    void setElementClickParams(View view, String str, Map<String, Object> map);

    void setElementExposureAllAndClickParams(View view, String str, Map<String, Object> map);

    void setElementExposureAllAndClickPolicy(View view, String str);

    void setElementExposureAllPolicy(View view, String str);

    void setElementExposureAndClickDynamicParams(View view, String str, IDynamicParams iDynamicParams);

    void setElementExposureAndClickParams(View view, String str, Map<String, Object> map);

    void setElementParams(View view, Map<String, Object> map);

    void setElementReport(View view, String str, ClickPolicy clickPolicy, ExposurePolicy exposurePolicy);

    void setGuildBasePageParams(String str, Map<String, Object> map);

    void setGuildPageParams(View view, String str, Map<String, Object> map);

    void setListItemElementExposureAndClickParams(View view, String str, String str2, Map<String, Object> map);

    void setLogicParent(View view, View view2);

    void setOpenGuildSourceParams(Bundle bundle, Map<String, Object> map);
}
