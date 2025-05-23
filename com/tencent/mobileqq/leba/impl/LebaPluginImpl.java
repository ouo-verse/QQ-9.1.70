package com.tencent.mobileqq.leba.impl;

import com.tencent.mobileqq.leba.ILebaPlugin;
import com.tencent.mobileqq.leba.business.j;
import com.tencent.mobileqq.leba.business.k;
import com.tencent.mobileqq.leba.entity.DefaultClickProcessor;
import com.tencent.mobileqq.leba.entity.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/leba/impl/LebaPluginImpl;", "Lcom/tencent/mobileqq/leba/ILebaPlugin;", "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "buildDefaultClickProcessor", "", "", "hostList", MQPSecJsPlugin.KEY_FROM, "", "perParseDns", "Lcom/tencent/mobileqq/redtouch/RedTypeInfo;", "getTabRedTypeInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;", "getNewTabRedTypeInfo", "", "redTouchContainerNewGuide", "hiddeNewGuide", "accountChange", "<init>", "()V", "Companion", "a", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginImpl implements ILebaPlugin {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "LebaPluginImpl";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/leba/impl/LebaPluginImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.impl.LebaPluginImpl$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18318);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LebaPluginImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaPlugin
    public void accountChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            j.f240113a.a();
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaPlugin
    @NotNull
    public DefaultClickProcessor buildDefaultClickProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DefaultClickProcessor) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new c();
    }

    @Override // com.tencent.mobileqq.leba.ILebaPlugin
    @Nullable
    public BusinessInfoCheckUpdate.RedTypeInfo getNewTabRedTypeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BusinessInfoCheckUpdate.RedTypeInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return k.f240118a.a();
    }

    @Override // com.tencent.mobileqq.leba.ILebaPlugin
    @Nullable
    public RedTypeInfo getTabRedTypeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RedTypeInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return k.f240118a.b();
    }

    @Override // com.tencent.mobileqq.leba.ILebaPlugin
    public void hiddeNewGuide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            j.f240113a.d();
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaPlugin
    public void perParseDns(@NotNull List<String> hostList, @NotNull String keyFrom) {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) hostList, (Object) keyFrom);
            return;
        }
        Intrinsics.checkNotNullParameter(hostList, "hostList");
        Intrinsics.checkNotNullParameter(keyFrom, "keyFrom");
        if (hostList.isEmpty()) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        QRouteApi api = QRoute.api(IWebProcessPreload.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(\n            IWebPro\u2026oad::class.java\n        )");
        IWebProcessPreload iWebProcessPreload = (IWebProcessPreload) api;
        if (System.currentTimeMillis() - iWebProcessPreload.getBusinessClickTimeMills(str, keyFrom) < 604800000) {
            iWebProcessPreload.preParseDns(hostList, keyFrom);
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaPlugin
    public boolean redTouchContainerNewGuide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return j.f240113a.f();
    }
}
