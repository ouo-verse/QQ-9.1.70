package com.tencent.mobileqq.troop.homework.coursemgr.fragment;

import android.content.Intent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.util.InputMethodUtil;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007R\u001a\u0010\u0010\u001a\u00020\u000b8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u00020\u00118DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/coursemgr/fragment/TroopHwCourseBasePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "A9", "F9", "", "dpFloat", "", "B9", "dimeId", "C9", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$l;", "d", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$l;", "D9", "()Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$l;", "disMissListener", "Lcom/tencent/mobileqq/troop/homework/coursemgr/vm/a;", "e", "Lkotlin/Lazy;", "E9", "()Lcom/tencent/mobileqq/troop/homework/coursemgr/vm/a;", "viewModel", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class TroopHwCourseBasePart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUSBaseHalfScreenFloatingView.l disMissListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public TroopHwCourseBasePart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.disMissListener = new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.d
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                TroopHwCourseBasePart.z9(TroopHwCourseBasePart.this);
            }
        };
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.troop.homework.coursemgr.vm.a>() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.TroopHwCourseBasePart$viewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopHwCourseBasePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.troop.homework.coursemgr.vm.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.troop.homework.coursemgr.vm.a) TroopHwCourseBasePart.this.getViewModel(com.tencent.mobileqq.troop.homework.coursemgr.vm.a.class) : (com.tencent.mobileqq.troop.homework.coursemgr.vm.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.viewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z9(TroopHwCourseBasePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A9();
    }

    public final void A9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (E9().U1() != null) {
            Intent intent = new Intent();
            intent.putExtra("result_params_key_course_json", E9().Q1());
            intent.putExtra("result_params_key_select_course", E9().U1());
            getActivity().setResult(-1, intent);
        }
        F9();
        getActivity().finish();
    }

    public final int B9(float dpFloat) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, Float.valueOf(dpFloat))).intValue();
        }
        return Utils.n(dpFloat, getContext().getResources());
    }

    public final int C9(int dimeId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, dimeId)).intValue();
        }
        return (int) getContext().getResources().getDimension(dimeId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final QUSBaseHalfScreenFloatingView.l D9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QUSBaseHalfScreenFloatingView.l) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.disMissListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.mobileqq.troop.homework.coursemgr.vm.a E9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.troop.homework.coursemgr.vm.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (com.tencent.mobileqq.troop.homework.coursemgr.vm.a) value;
    }

    public final void F9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            InputMethodUtil.hide(getActivity());
        }
    }
}
