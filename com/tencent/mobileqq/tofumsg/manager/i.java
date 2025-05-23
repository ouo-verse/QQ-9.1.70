package com.tencent.mobileqq.tofumsg.manager;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.BeancurdHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.NewBeancurdMsg;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tofumsg.NewTofuManager;
import com.tencent.mobileqq.tofumsg.TofuLimitMsg;
import com.tencent.mobileqq.tofumsg.TofuLimitMsgForSogou;
import com.tencent.mobileqq.tofumsg.o;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/tofumsg/manager/i;", "Lcom/tencent/mobileqq/tofumsg/manager/f;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "e", "Lcom/tencent/mobileqq/data/NewBeancurdMsg;", "newBeancurdMsg", "f", "Lcom/tencent/mobileqq/app/QQAppInterface;", "appInterface", "friendUin", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/tofumsg/TofuLimitMsg;", "a", "", "g", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class i extends f {
    static IPatchRedirector $redirector_;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.tofumsg.manager.f
    @NotNull
    public String A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "SogouTofuManager";
    }

    @Override // sr2.a
    @NotNull
    public CopyOnWriteArrayList<TofuLimitMsg> a(@NotNull QQAppInterface appInterface, @NotNull String friendUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 5, (Object) this, (Object) appInterface, (Object) friendUin);
        }
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        CopyOnWriteArrayList<TofuLimitMsg> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.addAll(o.b().f(appInterface, friendUin));
        return copyOnWriteArrayList;
    }

    @Override // com.tencent.mobileqq.tofumsg.manager.f, sr2.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.e();
        if (TextUtils.isEmpty(B())) {
            QLog.d(C(), 1, "triggerToRequestTofu:: mCurFriendUin is empty, return!!!");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            QLog.i(C(), 1, "triggerToRequestTofu:: appRuntime is not AppInterface, return!!!");
            return;
        }
        String account = ((AppInterface) peekAppRuntime).getAccount();
        if (TextUtils.isEmpty(account)) {
            QLog.i(C(), 1, "triggerToRequestTofu:: selfUin is empty, return!!!");
            return;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.NEW_TOFU_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.tofumsg.NewTofuManager");
        NewTofuManager newTofuManager = (NewTofuManager) manager;
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        BusinessHandler businessHandler = appInterface.getBusinessHandler(BeancurdHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.BeancurdHandler");
        BeancurdHandler beancurdHandler = (BeancurdHandler) businessHandler;
        beancurdHandler.b3(newTofuManager);
        beancurdHandler.a3(newTofuManager.u().f293263i);
        beancurdHandler.Y2(appInterface.getApplicationContext(), account, B(), "sogou");
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
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            QLog.i(C(), 1, "receiveTofu:: appRuntime is null, return!!!" + newBeancurdMsg);
            return;
        }
        TofuLimitMsgForSogou tofuLimitMsg = TofuLimitMsgForSogou.create(newBeancurdMsg);
        Intrinsics.checkNotNullExpressionValue(tofuLimitMsg, "tofuLimitMsg");
        if (s(tofuLimitMsg)) {
            QLog.i(C(), 1, "receiveTofu:: tofu is repeat in tofuDb\uff1a" + newBeancurdMsg);
            return;
        }
        E(newBeancurdMsg, tofuLimitMsg);
    }

    @Override // sr2.a
    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 1;
    }
}
