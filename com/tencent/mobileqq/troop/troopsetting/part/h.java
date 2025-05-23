package com.tencent.mobileqq.troop.troopsetting.part;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingFragmentV2;
import com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010\u0014\u001a\u00020\u00062\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u0012\u0010\u0015\u001a\u00020\u00062\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010J\u0006\u0010\u0016\u001a\u00020\u0012R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\"\u001a\u00020\u001f8F\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/h;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Lcom/tencent/mobileqq/troop/troopsetting/activity/TroopSettingFragmentV2;", "A9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "G9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "x9", "Lcom/tencent/mobileqq/widget/listitem/a;", DownloadInfo.spKey_Config, "", "isVisible", "E9", "D9", "C9", "Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", "d", "Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", "B9", "()Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", "F9", "(Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;)V", "viewModel", "Lcom/tencent/common/app/AppInterface;", "z9", "()Lcom/tencent/common/app/AppInterface;", "app", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class h extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public TroopSettingViewModel viewModel;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: A9, reason: merged with bridge method [inline-methods] */
    public TroopSettingFragmentV2 getPartHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TroopSettingFragmentV2) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        IPartHost partHost = super.getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingFragmentV2");
        return (TroopSettingFragmentV2) partHost;
    }

    @NotNull
    public final TroopSettingViewModel B9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TroopSettingViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        TroopSettingViewModel troopSettingViewModel = this.viewModel;
        if (troopSettingViewModel != null) {
            return troopSettingViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final boolean C9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (getActivity() != null && getContext() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
            return false;
        }
        return true;
    }

    public final void D9(@NotNull com.tencent.mobileqq.widget.listitem.a<?> config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) config);
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        QUIListItemAdapter adapter = getPartHost().th().getAdapter();
        if (adapter != null) {
            adapter.l0(config);
        }
    }

    public final void E9(@NotNull com.tencent.mobileqq.widget.listitem.a<?> config, boolean isVisible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, config, Boolean.valueOf(isVisible));
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        QUIListItemAdapter adapter = getPartHost().th().getAdapter();
        if (adapter != null) {
            adapter.m0(config, isVisible);
        }
    }

    public final void F9(@NotNull TroopSettingViewModel troopSettingViewModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopSettingViewModel);
        } else {
            Intrinsics.checkNotNullParameter(troopSettingViewModel, "<set-?>");
            this.viewModel = troopSettingViewModel;
        }
    }

    @NotNull
    public Group[] G9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Group[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new Group[0];
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        ViewModel viewModel = getViewModel(TroopSettingViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopSettingViewModel::class.java)");
        F9((TroopSettingViewModel) viewModel);
    }

    @Nullable
    public final QUIListItemAdapter x9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (QUIListItemAdapter) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return getPartHost().th().getAdapter();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        if (r1 == null) goto L15;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AppInterface z9() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AppInterface) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
        }
        com.tencent.mobileqq.troop.troopsetting.activity.a aVar = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        aVar.h(activity);
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        return (AppInterface) peekAppRuntime;
    }
}
