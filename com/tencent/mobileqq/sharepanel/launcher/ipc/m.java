package com.tencent.mobileqq.sharepanel.launcher.ipc;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sharepanel.launcher.ShareActionDynamicModifier;
import com.tencent.mobileqq.sharepanel.launcher.SharePanelParam;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/launcher/ipc/m;", "Lcom/tencent/mobileqq/sharepanel/launcher/a;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCClientFragment;", "c", "", "d", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "param", "a", "dismiss", "Lcom/tencent/mobileqq/sharepanel/launcher/ShareActionDynamicModifier;", "modifier", "b", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "activityRef", "clientFragmentRef", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class m implements com.tencent.mobileqq.sharepanel.launcher.a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<FragmentActivity> activityRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<SharePanelIPCClientFragment> clientFragmentRef;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/launcher/ipc/m$a;", "", "", "CLIENT_FRAGMENT_TAG", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.launcher.ipc.m$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37743);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final SharePanelIPCClientFragment c(FragmentActivity activity) {
        try {
            Fragment findFragmentByTag = activity.getSupportFragmentManager().findFragmentByTag("SharePanelIPCClientFragment");
            if (findFragmentByTag instanceof SharePanelIPCClientFragment) {
                return (SharePanelIPCClientFragment) findFragmentByTag;
            }
            FragmentTransaction beginTransaction = activity.getSupportFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "activity.supportFragmentManager.beginTransaction()");
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
            SharePanelIPCClientFragment sharePanelIPCClientFragment = new SharePanelIPCClientFragment();
            beginTransaction.add(sharePanelIPCClientFragment, "SharePanelIPCClientFragment");
            beginTransaction.commitAllowingStateLoss();
            return sharePanelIPCClientFragment;
        } catch (Exception e16) {
            QLog.e("SharePanelIPCLauncher", 1, "addClientFragment: ", e16);
            return null;
        }
    }

    private final void d(FragmentActivity activity) {
        try {
            Fragment findFragmentByTag = activity.getSupportFragmentManager().findFragmentByTag("SharePanelIPCClientFragment");
            if (findFragmentByTag == null) {
                return;
            }
            activity.getSupportFragmentManager().beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        } catch (Exception e16) {
            QLog.e("SharePanelIPCLauncher", 1, "removeClientFragment: ", e16);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.launcher.a
    public void a(@NotNull FragmentActivity activity, @NotNull SharePanelParam param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(param, "param");
        SharePanelIPCClientFragment c16 = c(activity);
        if (c16 != null) {
            c16.Qh(param);
            this.clientFragmentRef = new WeakReference<>(c16);
            this.activityRef = new WeakReference<>(activity);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.launcher.a
    public void b(@NotNull ShareActionDynamicModifier modifier) {
        SharePanelIPCClientFragment sharePanelIPCClientFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) modifier);
            return;
        }
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        WeakReference<SharePanelIPCClientFragment> weakReference = this.clientFragmentRef;
        if (weakReference != null && (sharePanelIPCClientFragment = weakReference.get()) != null) {
            sharePanelIPCClientFragment.Dh(modifier);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.launcher.a
    public void dismiss() {
        FragmentActivity fragmentActivity;
        SharePanelIPCClientFragment sharePanelIPCClientFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        WeakReference<SharePanelIPCClientFragment> weakReference = this.clientFragmentRef;
        if (weakReference != null && (sharePanelIPCClientFragment = weakReference.get()) != null) {
            sharePanelIPCClientFragment.dismiss();
        }
        this.clientFragmentRef = null;
        WeakReference<FragmentActivity> weakReference2 = this.activityRef;
        if (weakReference2 != null && (fragmentActivity = weakReference2.get()) != null && !fragmentActivity.isFinishing() && !fragmentActivity.isDestroyed()) {
            d(fragmentActivity);
        }
        this.activityRef = null;
    }
}
