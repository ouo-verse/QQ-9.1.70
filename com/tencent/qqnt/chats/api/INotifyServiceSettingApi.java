package com.tencent.qqnt.chats.api;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.IGetServiceAssistantSwitchCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J1\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&\u00a2\u0006\u0002\u0010\u000bJa\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2&\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00112\u0006\u0010\t\u001a\u00020\u0012H&\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/chats/api/INotifyServiceSettingApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "requestGetSwitch", "", QQBrowserActivity.KEY_MSG_TYPE, "", "appType", "appId", "", "callback", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetServiceAssistantSwitchCallback;", "(ILjava/lang/Integer;Ljava/lang/Long;Lcom/tencent/qqnt/kernel/nativeinterface/IGetServiceAssistantSwitchCallback;)V", "requestSetSwitch", "msgSwitch", "templateMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "(IILjava/lang/Integer;Ljava/lang/Long;Ljava/util/HashMap;Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;)V", "chats_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes24.dex */
public interface INotifyServiceSettingApi extends QRouteApi {
    void requestGetSwitch(int msgType, @Nullable Integer appType, @Nullable Long appId, @NotNull IGetServiceAssistantSwitchCallback callback);

    void requestSetSwitch(int msgSwitch, int msgType, @Nullable Integer appType, @Nullable Long appId, @Nullable HashMap<String, Integer> templateMap, @NotNull IOperateCallback callback);
}
