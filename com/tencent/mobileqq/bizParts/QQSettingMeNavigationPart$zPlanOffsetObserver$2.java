package com.tencent.mobileqq.bizParts;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/Observer;", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class QQSettingMeNavigationPart$zPlanOffsetObserver$2 extends Lambda implements Function0<Observer<Float>> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ QQSettingMeNavigationPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQSettingMeNavigationPart$zPlanOffsetObserver$2(QQSettingMeNavigationPart qQSettingMeNavigationPart) {
        super(0);
        this.this$0 = qQSettingMeNavigationPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQSettingMeNavigationPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQSettingMeNavigationPart this$0, Float y16) {
        View view;
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.da((int) y16.floatValue());
        view = this$0.topContainerBg;
        if (view != null) {
            i3 = view.getHeight();
        } else {
            i3 = 0;
        }
        float b16 = (com.tencent.mobileqq.activity.qqsettingme.utils.b.b() + i3) * 0.5f;
        MutableLiveData<Boolean> R1 = ((QQSettingMeViewModel) this$0.getViewModel(QQSettingMeViewModel.class)).R1();
        float f16 = i3;
        Intrinsics.checkNotNullExpressionValue(y16, "y");
        if (f16 >= y16.floatValue() || (i3 == 0 && !Intrinsics.areEqual(Boolean.TRUE, ((QQSettingMeViewModel) this$0.getViewModel(QQSettingMeViewModel.class)).S1().getValue()))) {
            this$0.X9(255);
            if (Intrinsics.areEqual(R1.getValue(), Boolean.TRUE)) {
                R1.postValue(Boolean.FALSE);
                return;
            }
            return;
        }
        if (f16 >= y16.floatValue() || y16.floatValue() >= b16) {
            this$0.X9(0);
            if (Intrinsics.areEqual(R1.getValue(), Boolean.FALSE)) {
                R1.postValue(Boolean.TRUE);
                return;
            }
            return;
        }
        this$0.X9((int) (((b16 - y16.floatValue()) / (b16 - f16)) * 255));
        if (Intrinsics.areEqual(R1.getValue(), Boolean.FALSE)) {
            R1.postValue(Boolean.TRUE);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Observer<Float> invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Observer) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        final QQSettingMeNavigationPart qQSettingMeNavigationPart = this.this$0;
        return new Observer() { // from class: com.tencent.mobileqq.bizParts.aj
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeNavigationPart$zPlanOffsetObserver$2.b(QQSettingMeNavigationPart.this, (Float) obj);
            }
        };
    }
}
