package com.tencent.qqnt.chathistory.bridge;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&J+\u0010\u0010\u001a\u00020\u00062!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\nH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chathistory/bridge/IC2CChatHistoryVasApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "", "url", "", "jumpToH5", "Landroid/graphics/drawable/Drawable;", "getTipsDrawable", "Lkotlin/Function1;", "Lcom/tencent/qqnt/chathistory/bridge/a;", "Lkotlin/ParameterName;", "name", "data", "successCallback", "requestTipsData", "chathistory_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes23.dex */
public interface IC2CChatHistoryVasApi extends QRouteApi {
    @NotNull
    Drawable getTipsDrawable(@NotNull String url);

    void jumpToH5(@NotNull Context context, @NotNull String url);

    void requestTipsData(@NotNull Function1<? super a, Unit> successCallback);
}
