package com.tencent.mobileqq.multishare.api.impl;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.multishare.action.b;
import com.tencent.mobileqq.multishare.api.IMultiShareApi;
import com.tencent.mobileqq.multishare.fragment.MultiShareBottomDialogFragment;
import com.tencent.mobileqq.multishare.util.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import j92.c;
import j92.d;
import j92.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u001e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u001a\u0010\u001f\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/multishare/api/impl/MultiShareApiImpl;", "Lcom/tencent/mobileqq/multishare/api/IMultiShareApi;", "Lcom/tencent/mobileqq/multishare/config/a;", DownloadInfo.spKey_Config, "", "createPanel", "Landroid/content/Context;", "context", "showPanel", "", "isShowing", "dismissPanel", "Landroid/content/Intent;", "forwardIntent", "setForwardIntent", "Lj92/c;", "previewCreator", "setPreviewInterface", "Lj92/d;", "titleCreator", "setCustomTitleInterface", "", "index", "", "Lcom/tencent/mobileqq/multishare/action/b;", "actions", "updateActionSheet", "Lj92/e;", "sorter", "Lcom/tencent/relation/common/nt/listener/RecentContactListener;", "recentContactListener", "getRecentUserList", "Lcom/tencent/mobileqq/multishare/fragment/MultiShareBottomDialogFragment;", "shareFragment", "Lcom/tencent/mobileqq/multishare/fragment/MultiShareBottomDialogFragment;", "Z", "<init>", "()V", "Companion", "a", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class MultiShareApiImpl implements IMultiShareApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "MultiShareApiImpl";
    private boolean isShowing;

    @Nullable
    private MultiShareBottomDialogFragment shareFragment;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/multishare/api/impl/MultiShareApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.multishare.api.impl.MultiShareApiImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39766);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MultiShareApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isShowing = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPanel$lambda$1(MultiShareApiImpl this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isShowing = false;
    }

    @Override // com.tencent.mobileqq.multishare.api.IMultiShareApi
    public void createPanel(@NotNull com.tencent.mobileqq.multishare.config.a config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) config);
        } else {
            Intrinsics.checkNotNullParameter(config, "config");
            this.shareFragment = new MultiShareBottomDialogFragment(config);
        }
    }

    @Override // com.tencent.mobileqq.multishare.api.IMultiShareApi
    public void dismissPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        MultiShareBottomDialogFragment multiShareBottomDialogFragment = this.shareFragment;
        if (multiShareBottomDialogFragment == null) {
            QLog.d(TAG, 1, "shareFragment is null.");
            return;
        }
        if (multiShareBottomDialogFragment != null) {
            multiShareBottomDialogFragment.dismiss();
        }
        QLog.d(TAG, 1, "dismiss Panel.");
    }

    @Override // com.tencent.mobileqq.multishare.api.IMultiShareApi
    public void getRecentUserList(@Nullable e sorter, @NotNull RecentContactListener recentContactListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) sorter, (Object) recentContactListener);
        } else {
            Intrinsics.checkNotNullParameter(recentContactListener, "recentContactListener");
            f.f251809a.g(sorter, recentContactListener);
        }
    }

    @Override // com.tencent.mobileqq.multishare.api.IMultiShareApi
    public boolean isShowing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isShowing;
    }

    @Override // com.tencent.mobileqq.multishare.api.IMultiShareApi
    public void setCustomTitleInterface(@NotNull d titleCreator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) titleCreator);
            return;
        }
        Intrinsics.checkNotNullParameter(titleCreator, "titleCreator");
        MultiShareBottomDialogFragment multiShareBottomDialogFragment = this.shareFragment;
        if (multiShareBottomDialogFragment != null) {
            multiShareBottomDialogFragment.Ch(titleCreator);
        }
    }

    @Override // com.tencent.mobileqq.multishare.api.IMultiShareApi
    public void setForwardIntent(@NotNull Intent forwardIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) forwardIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(forwardIntent, "forwardIntent");
        MultiShareBottomDialogFragment multiShareBottomDialogFragment = this.shareFragment;
        if (multiShareBottomDialogFragment != null) {
            multiShareBottomDialogFragment.Eh(forwardIntent);
        }
    }

    @Override // com.tencent.mobileqq.multishare.api.IMultiShareApi
    public void setPreviewInterface(@NotNull c previewCreator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) previewCreator);
            return;
        }
        Intrinsics.checkNotNullParameter(previewCreator, "previewCreator");
        MultiShareBottomDialogFragment multiShareBottomDialogFragment = this.shareFragment;
        if (multiShareBottomDialogFragment != null) {
            multiShareBottomDialogFragment.Bh(previewCreator);
        }
    }

    @Override // com.tencent.mobileqq.multishare.api.IMultiShareApi
    public void showPanel(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(context instanceof FragmentActivity)) {
            QLog.d(TAG, 1, "no FragmentActivity.");
            return;
        }
        this.isShowing = true;
        MultiShareBottomDialogFragment multiShareBottomDialogFragment = this.shareFragment;
        if (multiShareBottomDialogFragment != null) {
            ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().add(multiShareBottomDialogFragment, "MultiShareBottomDialogFragment").commitAllowingStateLoss();
        }
        MultiShareBottomDialogFragment multiShareBottomDialogFragment2 = this.shareFragment;
        if (multiShareBottomDialogFragment2 != null) {
            multiShareBottomDialogFragment2.Ah(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.multishare.api.impl.a
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    MultiShareApiImpl.showPanel$lambda$1(MultiShareApiImpl.this, dialogInterface);
                }
            });
        }
        QLog.d(TAG, 1, "show Panel.");
    }

    @Override // com.tencent.mobileqq.multishare.api.IMultiShareApi
    public void updateActionSheet(int index, @NotNull List<? extends b> actions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, index, (Object) actions);
            return;
        }
        Intrinsics.checkNotNullParameter(actions, "actions");
        MultiShareBottomDialogFragment multiShareBottomDialogFragment = this.shareFragment;
        if (multiShareBottomDialogFragment != null) {
            multiShareBottomDialogFragment.Dh(index, actions);
        }
    }
}
