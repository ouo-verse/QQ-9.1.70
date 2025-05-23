package com.tencent.mobileqq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.qwallet.activity.QvipPayFullWindowActivity;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qwallet.home.QWalletHomeFragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0019B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0016\u0010\u0017J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/QWalletAppInterface;", "Lcom/tencent/common/app/business/BaseToolAppInterface;", "Lx05/a;", "Lcom/tencent/qphone/base/util/BaseApplication;", "getApp", "", "getModuleId", "getCurrentAccountUin", "", "getAppid", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "c", "Landroid/os/Bundle;", "b", "", "d0", "", "highPriorityWhenBackground", "Lmqq/app/MobileQQ;", "app", "processName", "<init>", "(Lmqq/app/MobileQQ;Ljava/lang/String;)V", "d", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class QWalletAppInterface extends BaseToolAppInterface implements x05.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/QWalletAppInterface$a;", "", "", "BZCODE_DEFAULT", "I", "BZCODE_FULL_WINDOW_WEBVIEW", "BZCODE_HOMEPAGE_FEEDS_WEBVIEW", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.QWalletAppInterface$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27141);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QWalletAppInterface(@NotNull MobileQQ app, @NotNull String processName) {
        super(app, processName);
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(processName, "processName");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app, (Object) processName);
        }
    }

    @Override // x05.a
    @Nullable
    public Bundle b(@Nullable Activity activity) {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bundle) iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
        }
        if (c(activity) == 0 || activity == null || (intent = activity.getIntent()) == null) {
            return null;
        }
        return intent.getExtras();
    }

    @Override // x05.a
    public int c(@Nullable Activity activity) {
        QPublicFragmentActivity qPublicFragmentActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity)).intValue();
        }
        QPublicBaseFragment qPublicBaseFragment = null;
        if (activity instanceof QPublicFragmentActivity) {
            qPublicFragmentActivity = (QPublicFragmentActivity) activity;
        } else {
            qPublicFragmentActivity = null;
        }
        if (qPublicFragmentActivity != null) {
            qPublicBaseFragment = qPublicFragmentActivity.getFragment();
        }
        if (qPublicBaseFragment == null) {
            return 0;
        }
        if (qPublicBaseFragment instanceof QvipPayFullWindowActivity) {
            return 1;
        }
        if (!(qPublicBaseFragment instanceof QWalletHomeFragment)) {
            return 0;
        }
        return 2;
    }

    @Override // x05.a
    @Nullable
    public Object d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    @Nullable
    public BaseApplication getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseApplication) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.app;
    }

    @Override // com.tencent.common.app.AppInterface
    public int getAppid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return AppSetting.f();
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    @Nullable
    public String getCurrentAccountUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return getAccount();
    }

    @Override // mqq.app.AppRuntime
    @NotNull
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "qwallet_plugin.apk";
    }

    @Override // mqq.app.AppRuntime
    public boolean highPriorityWhenBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (pk2.a.b() > 0) {
            return true;
        }
        return false;
    }
}
