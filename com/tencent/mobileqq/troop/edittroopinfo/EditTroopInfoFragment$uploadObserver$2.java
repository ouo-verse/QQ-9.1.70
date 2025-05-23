package com.tencent.mobileqq.troop.edittroopinfo;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread;
import com.tencent.mobileqq.troop.avatar.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.TroopOperationRepo;
import java.util.Observable;
import java.util.Observer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/util/Observer;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
final class EditTroopInfoFragment$uploadObserver$2 extends Lambda implements Function0<Observer> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ EditTroopInfoFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditTroopInfoFragment$uploadObserver$2(EditTroopInfoFragment editTroopInfoFragment) {
        super(0);
        this.this$0 = editTroopInfoFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) editTroopInfoFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final EditTroopInfoFragment this$0, Observable observable, Object obj) {
        boolean z16;
        e Ch;
        TroopEditInfoViewModel troopEditInfoViewModel;
        TroopEditInfoViewModel troopEditInfoViewModel2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null && activity.isFinishing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && (obj instanceof TroopUploadingThread.b)) {
            TroopUploadingThread.b bVar = (TroopUploadingThread.b) obj;
            if (bVar.f294520a == 1) {
                if (QLog.isColorLevel()) {
                    QLog.i("EditTroopInfoFragment", 2, "[uploadObserver] type:" + bVar.f294524e);
                }
                int i3 = bVar.f294524e;
                TroopEditInfoViewModel troopEditInfoViewModel3 = null;
                if (i3 == 1) {
                    troopEditInfoViewModel2 = this$0.viewModel;
                    if (troopEditInfoViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        troopEditInfoViewModel3 = troopEditInfoViewModel2;
                    }
                    TroopInfo g26 = troopEditInfoViewModel3.g2();
                    if (g26 != null) {
                        g26.hasSetNewTroopHead = true;
                        if (g26.isUseClassAvatar()) {
                            TroopOperationRepo.INSTANCE.updateUseClassAvatar(g26.troopuin, false);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i3 == 0) {
                    Ch = this$0.Ch();
                    troopEditInfoViewModel = this$0.viewModel;
                    if (troopEditInfoViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        troopEditInfoViewModel3 = troopEditInfoViewModel;
                    }
                    Ch.g(troopEditInfoViewModel3.m2());
                    com.tencent.qqnt.e.i(new Runnable() { // from class: com.tencent.mobileqq.troop.edittroopinfo.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            EditTroopInfoFragment$uploadObserver$2.d(EditTroopInfoFragment.this);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(EditTroopInfoFragment this$0) {
        TroopEditInfoViewModel troopEditInfoViewModel;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        troopEditInfoViewModel = this$0.viewModel;
        if (troopEditInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopEditInfoViewModel = null;
        }
        TroopEditInfoViewModel.F2(troopEditInfoViewModel, null, 1, null);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Observer invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Observer) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        final EditTroopInfoFragment editTroopInfoFragment = this.this$0;
        return new Observer() { // from class: com.tencent.mobileqq.troop.edittroopinfo.a
            @Override // java.util.Observer
            public final void update(Observable observable, Object obj) {
                EditTroopInfoFragment$uploadObserver$2.c(EditTroopInfoFragment.this, observable, obj);
            }
        };
    }
}
