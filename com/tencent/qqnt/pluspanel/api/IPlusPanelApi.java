package com.tencent.qqnt.pluspanel.api;

import com.tencent.aio.base.mvvm.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.pluspanel.config.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J(\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000bj\b\u0012\u0004\u0012\u00020\b`\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H&J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H&J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u0011H&J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H&J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\bH&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/pluspanel/api/IPlusPanelApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "panelId", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "getPanelVB", "", "id", "type", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getRedDotList", "chatType", "", "loadAppInfoConfigAsync", "", "Lcom/tencent/qqnt/pluspanel/config/b;", "getAppConfigDatas", "", "getC2CRedDotIdList", "appId", "getAppConfigDataById", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IPlusPanelApi extends QRouteApi {
    @Nullable
    b getAppConfigDataById(@NotNull String appId);

    @NotNull
    Map<String, b> getAppConfigDatas();

    @NotNull
    List<Integer> getC2CRedDotIdList();

    @NotNull
    a<ol3.b, MviUIState> getPanelVB(int panelId);

    @NotNull
    ArrayList<String> getRedDotList(@NotNull String id5, int type);

    void loadAppInfoConfigAsync(int chatType);
}
