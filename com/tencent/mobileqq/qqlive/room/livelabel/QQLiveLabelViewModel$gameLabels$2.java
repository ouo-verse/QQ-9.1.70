package com.tencent.mobileqq.qqlive.room.livelabel;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00010\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/lifecycle/LiveData;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "Lcom/tencent/mobileqq/qqlive/room/livelabel/j;", "kotlin.jvm.PlatformType", "invoke", "()Landroidx/lifecycle/LiveData;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes17.dex */
final class QQLiveLabelViewModel$gameLabels$2 extends Lambda implements Function0<LiveData<QQLiveResponse<j>>> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ QQLiveLabelViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveLabelViewModel$gameLabels$2(QQLiveLabelViewModel qQLiveLabelViewModel) {
        super(0);
        this.this$0 = qQLiveLabelViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQLiveLabelViewModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveData b(QQLiveLabelViewModel this$0, QQLiveResponse it) {
        j U1;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AegisLogger.INSTANCE.i("Open_Live|QQLiveLabelViewModel", "gameLabels", "isSuccess=" + it.isSuccess() + ", retCode=" + it.getRetCode() + ", errMsg=" + it.getErrMsg());
        Intrinsics.checkNotNullExpressionValue(it, "it");
        U1 = this$0.U1(it);
        return new MutableLiveData(new QQLiveResponse(it.getRequest(), it.isSuccess(), it.getRetCode(), it.getErrMsg(), U1));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final LiveData<QQLiveResponse<j>> invoke() {
        LiveData T1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        T1 = this.this$0.T1();
        final QQLiveLabelViewModel qQLiveLabelViewModel = this.this$0;
        return Transformations.switchMap(T1, new Function() { // from class: com.tencent.mobileqq.qqlive.room.livelabel.i
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                LiveData b16;
                b16 = QQLiveLabelViewModel$gameLabels$2.b(QQLiveLabelViewModel.this, (QQLiveResponse) obj);
                return b16;
            }
        });
    }
}
