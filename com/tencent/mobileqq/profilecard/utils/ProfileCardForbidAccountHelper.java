package com.tencent.mobileqq.profilecard.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileCardForbidAccountHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/profilecard/utils/ProfileCardForbidAccountHelper;", "", "()V", "dialog", "Landroid/app/Dialog;", "hasShowDialog", "", "doOnDestroy", "", "showDialog", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Context;", "Companion", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ProfileCardForbidAccountHelper {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "ProfileCardForbidAccountHelper";

    @Nullable
    private Dialog dialog;
    private boolean hasShowDialog;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J*\u0010\t\u001a\u00020\u00062\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u001a\u0010\u0018\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/profilecard/utils/ProfileCardForbidAccountHelper$Companion;", "", "()V", "TAG", "", "isForbidByAnyType", "", "profileCardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "isForbidBySpecifyTypes", "forbidCodes", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", IndividuationUrlHelper.UrlId.CARD_HOME, "Lcom/tencent/mobileqq/data/Card;", "runOnUi", "", "block", "Lkotlin/Function0;", "setChildViewEnabled", "viewGroup", "Landroid/view/ViewGroup;", NodeProps.ENABLED, "updateViewGroupEnableState", "enable", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void runOnUi$lambda$0(Function0 tmp0) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke();
        }

        private final void setChildViewEnabled(ViewGroup viewGroup, boolean enabled) {
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                childAt.setEnabled(enabled);
                if (childAt instanceof ViewGroup) {
                    setChildViewEnabled((ViewGroup) childAt, enabled);
                }
            }
        }

        @JvmStatic
        public final boolean isForbidByAnyType(@Nullable ProfileCardInfo profileCardInfo) {
            Card card;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) profileCardInfo)).booleanValue();
            }
            if (profileCardInfo != null) {
                card = profileCardInfo.card;
            } else {
                card = null;
            }
            if (card != null) {
                return card.isForbidAccount;
            }
            return false;
        }

        @JvmStatic
        public final boolean isForbidBySpecifyTypes(@NotNull ArrayList<Integer> forbidCodes, @Nullable Card card) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) forbidCodes, (Object) card)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(forbidCodes, "forbidCodes");
            if (card != null && card.isForbidAccount && forbidCodes.contains(Integer.valueOf(card.forbidCode))) {
                return true;
            }
            return false;
        }

        public final void runOnUi(@NotNull final Function0<Unit> block) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) block);
                return;
            }
            Intrinsics.checkNotNullParameter(block, "block");
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                block.invoke();
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.utils.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProfileCardForbidAccountHelper.Companion.runOnUi$lambda$0(Function0.this);
                    }
                });
            }
        }

        @JvmStatic
        public final void updateViewGroupEnableState(@Nullable ViewGroup viewGroup, boolean enable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, viewGroup, Boolean.valueOf(enable));
            } else {
                if (viewGroup == null) {
                    return;
                }
                try {
                    setChildViewEnabled(viewGroup, enable);
                } catch (Exception e16) {
                    QLog.e(ProfileCardForbidAccountHelper.TAG, 1, "updateViewGroupEnableState exception", e16);
                }
            }
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18758);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ProfileCardForbidAccountHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean isForbidByAnyType(@Nullable ProfileCardInfo profileCardInfo) {
        return INSTANCE.isForbidByAnyType(profileCardInfo);
    }

    @JvmStatic
    public static final boolean isForbidBySpecifyTypes(@NotNull ArrayList<Integer> arrayList, @Nullable Card card) {
        return INSTANCE.isForbidBySpecifyTypes(arrayList, card);
    }

    @JvmStatic
    public static final void updateViewGroupEnableState(@Nullable ViewGroup viewGroup, boolean z16) {
        INSTANCE.updateViewGroupEnableState(viewGroup, z16);
    }

    public final void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            Dialog dialog = this.dialog;
            if (dialog != null) {
                dialog.dismiss();
            }
            this.dialog = null;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "dismissDialog exception:", e16);
        }
    }

    public final void showDialog(@Nullable Context activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            if (activity == null) {
                return;
            }
            INSTANCE.runOnUi(new ProfileCardForbidAccountHelper$showDialog$1(this, activity));
        }
    }
}
