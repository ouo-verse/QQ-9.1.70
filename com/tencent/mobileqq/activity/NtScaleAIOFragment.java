package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import com.tencent.qqnt.aio.activity.AIODelegate;
import com.tencent.qqnt.aio.e;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ts.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\t*\u0001%\u0018\u0000 +2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\n \u0012*\u0004\u0018\u00010\u00160\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u0016\u0010\u001e\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/activity/NtScaleAIOFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/qqnt/aio/e;", "Lts/e$a;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Landroid/content/Context;", "context", "", "onAttach", "attachViewTree", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getIntent", "Landroid/app/Activity;", "rh", "Landroid/view/Window;", "getWindow", "Landroidx/fragment/app/FragmentManager;", "getSupportFragmentManager", "Lcom/tencent/aio/data/AIOContact;", "getAIOContact", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Activity;", "mActivity", "Lcom/tencent/qqnt/aio/activity/AIODelegate;", "D", "Lkotlin/Lazy;", "sh", "()Lcom/tencent/qqnt/aio/activity/AIODelegate;", "mDelegate", "com/tencent/mobileqq/activity/NtScaleAIOFragment$b", "E", "Lcom/tencent/mobileqq/activity/NtScaleAIOFragment$b;", "closeAIOAction", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class NtScaleAIOFragment extends ReportAndroidXFragment implements com.tencent.qqnt.aio.e, e.a {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private Activity mActivity;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDelegate;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final b closeAIOAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/NtScaleAIOFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.NtScaleAIOFragment$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/activity/NtScaleAIOFragment$b", "Lcom/tencent/aio/runtime/message/b;", "Landroid/os/Bundle;", "data", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class b implements com.tencent.aio.runtime.message.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NtScaleAIOFragment.this);
            }
        }

        @Override // com.tencent.aio.runtime.message.b
        public void a(@NotNull Bundle data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.d("NtScaleAIOFragment", 1, "receive closeAction");
            if (!NtScaleAIOFragment.this.sh().c()) {
                Activity activity = NtScaleAIOFragment.this.mActivity;
                if (activity == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                    activity = null;
                }
                activity.finish();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29951);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NtScaleAIOFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIODelegate>() { // from class: com.tencent.mobileqq.activity.NtScaleAIOFragment$mDelegate$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtScaleAIOFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AIODelegate invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (AIODelegate) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    AIODelegate aIODelegate = new AIODelegate(NtScaleAIOFragment.this, "NtScaleAIOFragment");
                    aIODelegate.e0(NtScaleAIOFragment.this);
                    return aIODelegate;
                }
            });
            this.mDelegate = lazy;
            this.closeAIOAction = new b();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIODelegate sh() {
        return (AIODelegate) this.mDelegate.getValue();
    }

    @Override // ts.e.a
    public void attachViewTree() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            sh().c0("close_aio", this.closeAIOAction);
        }
    }

    @Override // com.tencent.qqnt.aio.e
    @NotNull
    public AIOContact getAIOContact() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AIOContact) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return sh().getAIOContact();
    }

    @Override // com.tencent.qqnt.aio.e
    public Intent getIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Intent) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Activity activity = this.mActivity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity = null;
        }
        return activity.getIntent();
    }

    @Override // com.tencent.qqnt.aio.e
    @NotNull
    public FragmentManager getSupportFragmentManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (FragmentManager) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        return childFragmentManager;
    }

    @Override // com.tencent.qqnt.aio.e
    public Window getWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Window) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        Activity activity = this.mActivity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity = null;
        }
        return activity.getWindow();
    }

    @Override // com.tencent.qqnt.aio.e
    public boolean isAttach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return e.a.a(this);
    }

    @Override // com.tencent.qqnt.aio.e
    public boolean isScale() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return e.a.b(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View K;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            K = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            K = sh().K(true);
            sh().show();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, K);
        return K;
    }

    @Override // androidx.fragment.app.Fragment, com.tencent.qqnt.aio.e
    @NotNull
    /* renamed from: rh, reason: merged with bridge method [inline-methods] */
    public Activity getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Activity) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        Activity activity = this.mActivity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            return null;
        }
        return activity;
    }

    @Override // com.tencent.qqnt.aio.e
    public void sendMessage(@NotNull MsgIntent msgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) msgIntent);
        } else {
            e.a.c(this, msgIntent);
        }
    }
}
