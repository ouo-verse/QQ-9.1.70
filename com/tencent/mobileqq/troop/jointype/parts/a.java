package com.tencent.mobileqq.troop.jointype.parts;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.jointype.TroopJoinTypeFragment;
import com.tencent.mobileqq.troop.jointype.TroopJoinTypeVM;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/jointype/parts/a;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Lcom/tencent/mobileqq/troop/jointype/TroopJoinTypeFragment;", "z9", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "x9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "C9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Lcom/tencent/mobileqq/troop/jointype/TroopJoinTypeVM;", "d", "Lcom/tencent/mobileqq/troop/jointype/TroopJoinTypeVM;", "A9", "()Lcom/tencent/mobileqq/troop/jointype/TroopJoinTypeVM;", "B9", "(Lcom/tencent/mobileqq/troop/jointype/TroopJoinTypeVM;)V", "vm", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class a extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public TroopJoinTypeVM vm;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final TroopJoinTypeVM A9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TroopJoinTypeVM) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        TroopJoinTypeVM troopJoinTypeVM = this.vm;
        if (troopJoinTypeVM != null) {
            return troopJoinTypeVM;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vm");
        return null;
    }

    public final void B9(@NotNull TroopJoinTypeVM troopJoinTypeVM) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopJoinTypeVM);
        } else {
            Intrinsics.checkNotNullParameter(troopJoinTypeVM, "<set-?>");
            this.vm = troopJoinTypeVM;
        }
    }

    @NotNull
    public Group[] C9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Group[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new Group[0];
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        ViewModel viewModel = getViewModel(TroopJoinTypeVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopJoinTypeVM::class.java)");
        B9((TroopJoinTypeVM) viewModel);
    }

    @Nullable
    public final QUIListItemAdapter x9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QUIListItemAdapter) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return getPartHost().Dh().getAdapter();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: z9, reason: merged with bridge method [inline-methods] */
    public TroopJoinTypeFragment getPartHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopJoinTypeFragment) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        IPartHost partHost = super.getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.troop.jointype.TroopJoinTypeFragment");
        return (TroopJoinTypeFragment) partHost;
    }
}
