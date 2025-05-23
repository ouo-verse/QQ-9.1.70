package com.tencent.mobileqq.aio.msglist.holder.component.template.template;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.ArkToMarkdownMsgTemplateInfo;
import com.tencent.qqnt.kernel.nativeinterface.GetArkToMarkdownMsgTemplateReqInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetArkToMarkdownMsgTemplateCallback;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006R0\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000fj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/template/TemplateMsgTemplateManager;", "", "", tl.h.F, "Lcom/tencent/qqnt/kernel/api/w;", "e", "", "appName", "viewName", "j", "key", "d", "f", "k", "g", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "templatesFromServer", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/j;", "c", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/j;", "loadingStatus", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class TemplateMsgTemplateManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TemplateMsgTemplateManager f191966a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, String> templatesFromServer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.aio.msglist.holder.component.template.common.j loadingStatus;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63546);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f191966a = new TemplateMsgTemplateManager();
        templatesFromServer = new HashMap<>();
        loadingStatus = new com.tencent.mobileqq.aio.msglist.holder.component.template.common.j();
    }

    TemplateMsgTemplateManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String d(String key) {
        return a.f191969a.a().get(key);
    }

    private final w e() {
        AppRuntime peekAppRuntime;
        IKernelService iKernelService;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            return iKernelService.getMsgService();
        }
        return null;
    }

    private final String f(String key) {
        return templatesFromServer.get(key);
    }

    private final void h() {
        if (!loadingStatus.b()) {
            return;
        }
        w e16 = e();
        if (e16 == null) {
            QLog.e("TemMsg.MsgTemplateManager", 1, "load fail for msgService got null !!!");
            return;
        }
        GetArkToMarkdownMsgTemplateReqInfo getArkToMarkdownMsgTemplateReqInfo = new GetArkToMarkdownMsgTemplateReqInfo();
        getArkToMarkdownMsgTemplateReqInfo.reqType = 1;
        QLog.d("TemMsg.MsgTemplateManager", 1, "getTemplateMsgTemplate start");
        e16.k0(getArkToMarkdownMsgTemplateReqInfo, new IGetArkToMarkdownMsgTemplateCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.template.template.i
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetArkToMarkdownMsgTemplateCallback
            public final void onResult(int i3, String str, ArkToMarkdownMsgTemplateInfo arkToMarkdownMsgTemplateInfo) {
                TemplateMsgTemplateManager.i(i3, str, arkToMarkdownMsgTemplateInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(int i3, String str, ArkToMarkdownMsgTemplateInfo arkToMarkdownMsgTemplateInfo) {
        if (i3 == 0 && arkToMarkdownMsgTemplateInfo != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new TemplateMsgTemplateManager$load$1$1(arkToMarkdownMsgTemplateInfo, null), 2, null);
            return;
        }
        QLog.e("TemMsg.MsgTemplateManager", 1, "getTemplateMsg failed, code:" + i3 + ", msg:" + str);
    }

    private final String j(String appName, String viewName) {
        return appName + ";" + viewName;
    }

    @NotNull
    public final String g(@NotNull String appName, @NotNull String viewName) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appName, (Object) viewName);
        }
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        String j3 = j(appName, viewName);
        String f16 = f(j3);
        if (f16 == null) {
            f16 = "";
        }
        if (f16.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.mobileqq.aio.msglist.holder.component.template.a.b(com.tencent.mobileqq.aio.msglist.holder.component.template.a.f191886a, "TemMsg.MsgTemplateManager", "use service template", null, 4, null);
            return f16;
        }
        if (loadingStatus.c()) {
            h();
        }
        String d16 = d(j3);
        if (d16 == null) {
            QLog.e("TemMsg.MsgTemplateManager", 1, "getTemplateString for: " + j3 + ", not found");
            return "";
        }
        return d16;
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            h();
        }
    }
}
