package com.tencent.qqnt.chats.biz.publicaccount.notifyservice.repo;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.GetServiceAssistantSwitchReq;
import com.tencent.qqnt.kernel.nativeinterface.IGetServiceAssistantSwitchCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.SetServiceAssistantSwitchReq;
import com.tencent.qqnt.msg.f;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J1\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJa\u0010\u0012\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052&\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u000f2\u0006\u0010\b\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/chats/biz/publicaccount/notifyservice/repo/c;", "", "", QQBrowserActivity.KEY_MSG_TYPE, "appType", "", "appId", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetServiceAssistantSwitchCallback;", "callback", "", "a", "(ILjava/lang/Integer;Ljava/lang/Long;Lcom/tencent/qqnt/kernel/nativeinterface/IGetServiceAssistantSwitchCallback;)V", "msgSwitch", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "templateMap", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "b", "(IILjava/lang/Integer;Ljava/lang/Long;Ljava/util/HashMap;Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;)V", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f354378a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40955);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f354378a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(int msgType, @Nullable Integer appType, @Nullable Long appId, @NotNull IGetServiceAssistantSwitchCallback callback) {
        IKernelMsgService msgService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(msgType), appType, appId, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        GetServiceAssistantSwitchReq getServiceAssistantSwitchReq = new GetServiceAssistantSwitchReq(msgType, appType, appId);
        IQQNTWrapperSession k3 = f.k();
        if (k3 != null && (msgService = k3.getMsgService()) != null) {
            msgService.getServiceAssistantSwitch(getServiceAssistantSwitchReq, callback);
        }
    }

    public final void b(int msgSwitch, int msgType, @Nullable Integer appType, @Nullable Long appId, @Nullable HashMap<String, Integer> templateMap, @NotNull IOperateCallback callback) {
        IKernelMsgService msgService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(msgSwitch), Integer.valueOf(msgType), appType, appId, templateMap, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        SetServiceAssistantSwitchReq setServiceAssistantSwitchReq = new SetServiceAssistantSwitchReq(msgSwitch, msgType, appType, appId, templateMap);
        IQQNTWrapperSession k3 = f.k();
        if (k3 != null && (msgService = k3.getMsgService()) != null) {
            msgService.setServiceAssistantSwitch(setServiceAssistantSwitchReq, callback);
        }
    }
}
