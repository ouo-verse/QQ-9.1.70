package com.tencent.mobileqq.tofumsg.manager;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.BeancurdHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.NewBeancurdMsg;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tofumsg.NewTofuManager;
import com.tencent.mobileqq.tofumsg.TofuLimitMsg;
import com.tencent.mobileqq.tofumsg.m;
import com.tencent.mobileqq.tofumsg.o;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u001b\u0010\u0019\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/tofumsg/manager/CommonTofuManager;", "Lcom/tencent/mobileqq/tofumsg/manager/f;", "", "selfUin", "", "N", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "e", "Lcom/tencent/mobileqq/data/NewBeancurdMsg;", "newBeancurdMsg", "f", "friendUin", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/app/QQAppInterface;", "appInterface", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/tofumsg/TofuLimitMsg;", "a", "", "g", "i", "Lkotlin/Lazy;", "O", "()Z", "tofuInsetSwitch", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class CommonTofuManager extends f {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy tofuInsetSwitch;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/tofumsg/manager/CommonTofuManager$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tofumsg.manager.CommonTofuManager$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/tofumsg/manager/CommonTofuManager$b", "Lcom/tencent/mobileqq/tofumsg/manager/factory/b;", "", "deleteSuc", "", "onResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.mobileqq.tofumsg.manager.factory.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NewBeancurdMsg f293269b;

        b(NewBeancurdMsg newBeancurdMsg) {
            this.f293269b = newBeancurdMsg;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CommonTofuManager.this, (Object) newBeancurdMsg);
            }
        }

        @Override // com.tencent.mobileqq.tofumsg.manager.factory.b
        public void onResult(boolean deleteSuc) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, deleteSuc);
                return;
            }
            QLog.i(CommonTofuManager.this.C(), 1, "moveCachePushTofuToMsgList:: delete specific tofu=" + this.f293269b + " in NT db suc=" + deleteSuc);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61946);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CommonTofuManager() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(CommonTofuManager$tofuInsetSwitch$2.INSTANCE);
            this.tofuInsetSwitch = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean N(String selfUin) {
        if (TextUtils.isEmpty(B())) {
            QLog.d(C(), 1, "triggerToRequestTofu:: mCurFriendUin is empty, return!!!");
            return false;
        }
        if (!TextUtils.isEmpty(selfUin)) {
            return true;
        }
        QLog.i(C(), 1, "triggerToRequestTofu:: selfUin is empty, return!!!");
        return false;
    }

    private final boolean O() {
        return ((Boolean) this.tofuInsetSwitch.getValue()).booleanValue();
    }

    @Override // com.tencent.mobileqq.tofumsg.manager.f
    @NotNull
    public String A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "CommonTofuManager";
    }

    @Override // sr2.a
    @NotNull
    public CopyOnWriteArrayList<TofuLimitMsg> a(@NotNull QQAppInterface appInterface, @NotNull String friendUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 6, (Object) this, (Object) appInterface, (Object) friendUin);
        }
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        CopyOnWriteArrayList<TofuLimitMsg> d16 = o.b().d(appInterface, friendUin);
        Intrinsics.checkNotNullExpressionValue(d16, "get().searchForCommonTofu(appInterface, friendUin)");
        return d16;
    }

    @Override // com.tencent.mobileqq.tofumsg.manager.f, sr2.a
    public void e() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.e();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        String selfUin = appInterface.getAccount();
        Intrinsics.checkNotNullExpressionValue(selfUin, "selfUin");
        if (!N(selfUin)) {
            m.d();
            return;
        }
        Manager manager = appInterface.getManager(QQManagerFactory.NEW_TOFU_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.tofumsg.NewTofuManager");
        NewTofuManager newTofuManager = (NewTofuManager) manager;
        BusinessHandler businessHandler = appInterface.getBusinessHandler(BeancurdHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.BeancurdHandler");
        BeancurdHandler beancurdHandler = (BeancurdHandler) businessHandler;
        beancurdHandler.b3(newTofuManager);
        beancurdHandler.a3(newTofuManager.u().f293263i);
        beancurdHandler.Y2(appInterface.getApplicationContext(), selfUin, B(), "common");
    }

    @Override // com.tencent.mobileqq.tofumsg.manager.f, sr2.a
    public void f(@NotNull NewBeancurdMsg newBeancurdMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) newBeancurdMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(newBeancurdMsg, "newBeancurdMsg");
        super.f(newBeancurdMsg);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i(C(), 1, "receiveTofu:: appRuntime is null, return!!!" + newBeancurdMsg);
            return;
        }
        TofuLimitMsg tofuLimitMsg = TofuLimitMsg.create(newBeancurdMsg);
        Intrinsics.checkNotNullExpressionValue(tofuLimitMsg, "tofuLimitMsg");
        if (s(tofuLimitMsg)) {
            QLog.i(C(), 1, "receiveTofu:: tofu is repeat in tofuDb\uff1a" + newBeancurdMsg);
            return;
        }
        if (t(tofuLimitMsg)) {
            QLog.i(C(), 1, "receiveTofu:: tofu is repeat in pendingTofuList\uff1a" + newBeancurdMsg);
            return;
        }
        if (!r(tofuLimitMsg)) {
            QLog.i(C(), 1, "receiveTofu:: tofu is forbid insert by limit-feq-login\uff1a" + newBeancurdMsg);
            return;
        }
        String str = newBeancurdMsg.frienduin;
        Intrinsics.checkNotNullExpressionValue(str, "newBeancurdMsg.frienduin");
        if (q(str)) {
            E(newBeancurdMsg, tofuLimitMsg);
            return;
        }
        if (!(peekAppRuntime instanceof AppInterface)) {
            QLog.i(C(), 1, "receiveTofu:: appRuntime is not AppInterface, add tofu to cache failed, return!!!" + newBeancurdMsg);
            return;
        }
        p((AppInterface) peekAppRuntime, newBeancurdMsg);
    }

    @Override // sr2.a
    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.tofumsg.manager.f, sr2.a
    public void i(@NotNull NewBeancurdMsg newBeancurdMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) newBeancurdMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(newBeancurdMsg, "newBeancurdMsg");
        super.i(newBeancurdMsg);
        NewBeancurdMsg.ExtraTofuInfo parseToGetPushInfo = NewBeancurdMsg.ExtraTofuInfo.parseToGetPushInfo(newBeancurdMsg.pushInfoString);
        if (!parseToGetPushInfo.checkIsCommonTofu()) {
            QLog.i(C(), 1, "moveCachePushTofuToMsgList:: the tofu is not commonTofu, return!!!" + newBeancurdMsg);
            return;
        }
        TofuLimitMsg create = TofuLimitMsg.create(newBeancurdMsg);
        if (parseToGetPushInfo.isDelete) {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(create.businessMsgId);
            String str = create.friendUin;
            Intrinsics.checkNotNullExpressionValue(str, "commonTofu.friendUin");
            d(str, copyOnWriteArrayList, new b(newBeancurdMsg));
            return;
        }
        E(newBeancurdMsg, create);
    }

    @Override // com.tencent.mobileqq.tofumsg.manager.f
    public boolean q(@NotNull String friendUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) friendUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        if (O()) {
            return true;
        }
        return super.q(friendUin);
    }
}
