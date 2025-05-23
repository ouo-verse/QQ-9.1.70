package com.tencent.qqnt.chats.api.impl;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.api.INotifyServiceSettingApi;
import com.tencent.qqnt.kernel.nativeinterface.IGetServiceAssistantSwitchCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a2\u0006\u0002\u0010\fJa\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2&\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00122\u0006\u0010\n\u001a\u00020\u0013H\u0016\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/NotifyServiceSettingApiImpl;", "Lcom/tencent/qqnt/chats/api/INotifyServiceSettingApi;", "()V", "requestGetSwitch", "", QQBrowserActivity.KEY_MSG_TYPE, "", "appType", "appId", "", "callback", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetServiceAssistantSwitchCallback;", "(ILjava/lang/Integer;Ljava/lang/Long;Lcom/tencent/qqnt/kernel/nativeinterface/IGetServiceAssistantSwitchCallback;)V", "requestSetSwitch", "msgSwitch", "templateMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "(IILjava/lang/Integer;Ljava/lang/Long;Ljava/util/HashMap;Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;)V", "chats_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class NotifyServiceSettingApiImpl implements INotifyServiceSettingApi {
    static IPatchRedirector $redirector_;

    public NotifyServiceSettingApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.api.INotifyServiceSettingApi
    public void requestGetSwitch(int msgType, @Nullable Integer appType, @Nullable Long appId, @NotNull IGetServiceAssistantSwitchCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(msgType), appType, appId, callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            com.tencent.qqnt.chats.biz.publicaccount.notifyservice.repo.c.f354378a.a(msgType, appType, appId, callback);
        }
    }

    @Override // com.tencent.qqnt.chats.api.INotifyServiceSettingApi
    public void requestSetSwitch(int msgSwitch, int msgType, @Nullable Integer appType, @Nullable Long appId, @Nullable HashMap<String, Integer> templateMap, @NotNull IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(msgSwitch), Integer.valueOf(msgType), appType, appId, templateMap, callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            com.tencent.qqnt.chats.biz.publicaccount.notifyservice.repo.c.f354378a.b(msgSwitch, msgType, appType, appId, templateMap, callback);
        }
    }
}
