package com.tencent.qqnt.troop;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsgType;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH&J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH&Jy\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142O\u0010\u001e\u001aK\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000b0\u0016j\u0002`\u001dH&\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/troop/ITroopNotificationRepoApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "getNotificationUnreadCount", "getNotificationUnhandledCount", "getNotificationUnreadUnhandledCount", "getNotificationUnreadExitCount", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/qqnt/troop/g;", "observer", "", "registerNotificationChangedObserver", "unregisterNotificationChangeObserver", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyOperateType;", "operateType", "", "seq", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyMsgType;", QQBrowserActivity.KEY_MSG_TYPE, "", "groupCode", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "errCode", "errMsg", "Lcom/tencent/qqnt/troop/OperateNotificationCallback;", "callback", "operateNotification", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface ITroopNotificationRepoApi extends QRouteApi {
    int getNotificationUnhandledCount();

    int getNotificationUnreadCount();

    int getNotificationUnreadExitCount();

    int getNotificationUnreadUnhandledCount();

    void operateNotification(@NotNull GroupNotifyOperateType operateType, long seq, @NotNull GroupNotifyMsgType msgType, @NotNull String groupCode, @NotNull Function3<? super Boolean, ? super Integer, ? super String, Unit> callback);

    void registerNotificationChangedObserver(@Nullable LifecycleOwner lifecycleOwner, @NotNull g observer);

    void unregisterNotificationChangeObserver(@Nullable g observer);
}
