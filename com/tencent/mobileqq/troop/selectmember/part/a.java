package com.tencent.mobileqq.troop.selectmember.part;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig;
import com.tencent.mobileqq.troop.selectmember.vm.TroopSelectMemberVM;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0006\u0010\t\u001a\u00020\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/part/a;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Landroidx/fragment/app/FragmentActivity;", "A9", "Lcom/tencent/mobileqq/troop/selectmember/vm/TroopSelectMemberVM;", "d", "Lcom/tencent/mobileqq/troop/selectmember/vm/TroopSelectMemberVM;", "z9", "()Lcom/tencent/mobileqq/troop/selectmember/vm/TroopSelectMemberVM;", "C9", "(Lcom/tencent/mobileqq/troop/selectmember/vm/TroopSelectMemberVM;)V", "viewModel", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "e", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "x9", "()Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "B9", "(Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;)V", "launchConfig", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class a extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public TroopSelectMemberVM viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public TroopSelectMemberConfig launchConfig;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final FragmentActivity A9() {
        FragmentActivity fragmentActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (FragmentActivity) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        Activity activity = getActivity();
        if (activity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) activity;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        throw new IllegalStateException("fragmentActivity is null");
    }

    public final void B9(@NotNull TroopSelectMemberConfig troopSelectMemberConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopSelectMemberConfig);
        } else {
            Intrinsics.checkNotNullParameter(troopSelectMemberConfig, "<set-?>");
            this.launchConfig = troopSelectMemberConfig;
        }
    }

    public final void C9(@NotNull TroopSelectMemberVM troopSelectMemberVM) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopSelectMemberVM);
        } else {
            Intrinsics.checkNotNullParameter(troopSelectMemberVM, "<set-?>");
            this.viewModel = troopSelectMemberVM;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        ViewModel viewModel = getViewModel(TroopSelectMemberVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopSelectMemberVM::class.java)");
        C9((TroopSelectMemberVM) viewModel);
        B9(z9().G1());
    }

    @NotNull
    public final TroopSelectMemberConfig x9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopSelectMemberConfig) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        TroopSelectMemberConfig troopSelectMemberConfig = this.launchConfig;
        if (troopSelectMemberConfig != null) {
            return troopSelectMemberConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("launchConfig");
        return null;
    }

    @NotNull
    public final TroopSelectMemberVM z9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TroopSelectMemberVM) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        TroopSelectMemberVM troopSelectMemberVM = this.viewModel;
        if (troopSelectMemberVM != null) {
            return troopSelectMemberVM;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
