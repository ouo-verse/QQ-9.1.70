package com.tencent.mobileqq.nt.msgpush.troop.processor.troopinfo;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.GVideoHandler;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.nt.msgpush.factory.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import tencent.im.msg.nt_im_msg_body$GeneralFlags;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/troop/processor/troopinfo/d;", "Lcom/tencent/mobileqq/nt/msgpush/factory/f;", "Lcom/tencent/mobileqq/nt/msgpush/troop/processor/a;", "troopBusinessData", "", "b", "Lcom/tencent/mobileqq/nt/msgpush/factory/a;", "convertResultData", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class d implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/troop/processor/troopinfo/d$a;", "", "", "TYPE_TROOP", "I", "VISITOR_FLAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nt.msgpush.troop.processor.troopinfo.d$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59457);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(com.tencent.mobileqq.nt.msgpush.troop.processor.a troopBusinessData) {
        AppInterface appInterface;
        TroopManager troopManager;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        GVideoHandler gVideoHandler = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        Manager manager = appInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (manager instanceof TroopManager) {
            troopManager = (TroopManager) manager;
        } else {
            troopManager = null;
        }
        if (troopManager != null && !troopManager.Q(troopBusinessData.e())) {
            BusinessHandler businessHandler = appInterface.getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
            if (businessHandler instanceof GVideoHandler) {
                gVideoHandler = (GVideoHandler) businessHandler;
            }
            if (gVideoHandler != null) {
                gVideoHandler.N2(troopBusinessData.e(), false);
            }
        }
    }

    @Override // com.tencent.mobileqq.nt.msgpush.factory.f
    public void a(@NotNull com.tencent.mobileqq.nt.msgpush.factory.a convertResultData) {
        nt_im_msg_body$GeneralFlags b16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) convertResultData);
            return;
        }
        Intrinsics.checkNotNullParameter(convertResultData, "convertResultData");
        com.tencent.mobileqq.nt.msgpush.troop.processor.a b17 = convertResultData.b();
        if (b17 != null && (b16 = b17.b()) != null) {
            if (b16.has() && b16.uint32_group_type.has()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                b16 = null;
            }
            if (b16 != null && b16.uint32_group_type.get() == 1 && b16.uint32_to_uin_flag.has() && b16.uint32_to_uin_flag.get() == 2) {
                b(b17);
            }
        }
    }
}
