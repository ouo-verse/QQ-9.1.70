package com.vivo.push.sdk;

import android.content.Context;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.model.UnvarnishedMessage;
import java.util.List;

/* loaded from: classes15.dex */
public abstract class OpenClientPushMessageReceiver extends BasePushMessageReceiver {
    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final boolean isAllowNet(Context context) {
        return super.isAllowNet(context);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onBind(Context context, int i3, String str) {
        super.onBind(context, i3, str);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onListTags(Context context, int i3, List<String> list, String str) {
        super.onListTags(context, i3, list, str);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onLog(Context context, String str, int i3, boolean z16) {
        super.onLog(context, str, i3, z16);
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public final NotifyArriveCallbackByUser onNotificationMessageArrived(Context context, UPSNotificationMessage uPSNotificationMessage) {
        return new NotifyArriveCallbackByUser(null, false);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onPublish(Context context, int i3, String str) {
        super.onPublish(context, i3, str);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onUnBind(Context context, int i3, String str) {
        super.onUnBind(context, i3, str);
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onNotificationMessageClicked(Context context, UPSNotificationMessage uPSNotificationMessage) {
    }

    public void onReceiveRegId(Context context, String str) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onTransmissionMessage(Context context, UnvarnishedMessage unvarnishedMessage) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onDelAlias(Context context, int i3, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onDelTags(Context context, int i3, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onSetAlias(Context context, int i3, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onSetTags(Context context, int i3, List<String> list, List<String> list2, String str) {
    }
}
