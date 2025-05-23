package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.minigame.jsplugin.QQWidgetJsPlugin;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\u00020\u00032:\u0010\u0004\u001a6\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00030\u0005j\u0002`\fH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0006H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/IMetaFarmWidgetApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", QQWidgetJsPlugin.EVENT_ADD_WIDGET, "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "errCode", "", "errMsg", "Lcom/tencent/mobileqq/minigame/api/AddWidgetCallback;", "clearImgCache", "hasWidget", "", "reportWidgetAdd", "reportWidgetRemove", "updateWidgetData", "source", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMetaFarmWidgetApi extends QRouteApi {
    void addWidget(@NotNull Function2<? super Integer, ? super String, Unit> callback);

    void clearImgCache();

    boolean hasWidget();

    void reportWidgetAdd();

    void reportWidgetRemove();

    void updateWidgetData(int source);
}
