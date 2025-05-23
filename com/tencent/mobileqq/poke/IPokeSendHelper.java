package com.tencent.mobileqq.poke;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J{\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2K\u0010\u0012\u001aG\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\u000bH&J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J*\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\fH&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/poke/IPokeSendHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lkotlin/Function0;", "", "update", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "resId", "", "minVersion", "successCallback", "Lcom/tencent/mobileqq/app/BusinessObserver;", "vasPokeAuth", "sendPokeMsg", "Lcom/tencent/common/app/AppInterface;", "app", "curFriendUin", "type", "status", "getStrengthStatus", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPokeSendHelper extends QRouteApi {
    int getStrengthStatus(@NotNull AppInterface app, @Nullable String curFriendUin, int type, int status);

    void sendPokeMsg(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull AIOElementType.b item);

    @NotNull
    BusinessObserver vasPokeAuth(@NotNull Context context, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull AIOElementType.b item, @NotNull Function0<Unit> update, @NotNull Function3<? super Integer, ? super String, ? super String, Unit> successCallback);
}
