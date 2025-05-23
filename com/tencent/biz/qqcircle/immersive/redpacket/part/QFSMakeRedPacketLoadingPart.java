package com.tencent.biz.qqcircle.immersive.redpacket.part;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.DialogState;
import com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.QFSMakeRedPacketViewModel;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R#\u0010\u0018\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR#\u0010\"\u001a\n \u0013*\u0004\u0018\u00010\u001e0\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010!R#\u0010%\u001a\n \u0013*\u0004\u0018\u00010\u001e0\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010!\u00a8\u0006*"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketLoadingPart;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "", "P9", "R9", "I9", "S9", "N9", "Landroid/app/Dialog;", "tipDialog", "T9", "O9", "", "msg", "U9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/QFSMakeRedPacketViewModel;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "M9", "()Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/QFSMakeRedPacketViewModel;", "viewModel", "Lcom/tencent/biz/qqcircle/widgets/dialog/QCircleLoadingDialog;", "e", "K9", "()Lcom/tencent/biz/qqcircle/widgets/dialog/QCircleLoadingDialog;", "loadingDialog", "Lcom/tencent/biz/qqcircle/widgets/QCircleCustomDialog;", "f", "J9", "()Lcom/tencent/biz/qqcircle/widgets/QCircleCustomDialog;", "loadFailedTipDialog", tl.h.F, "L9", "upperLimitTipDialog", "<init>", "()V", "i", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSMakeRedPacketLoadingPart extends com.tencent.biz.qqcircle.bizparts.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadingDialog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadFailedTipDialog;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy upperLimitTipDialog;

    public QFSMakeRedPacketLoadingPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QFSMakeRedPacketViewModel>() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.QFSMakeRedPacketLoadingPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QFSMakeRedPacketViewModel invoke() {
                return (QFSMakeRedPacketViewModel) QFSMakeRedPacketLoadingPart.this.getViewModel(QFSMakeRedPacketViewModel.class);
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QCircleLoadingDialog>() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.QFSMakeRedPacketLoadingPart$loadingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QCircleLoadingDialog invoke() {
                QCircleLoadingDialog qCircleLoadingDialog = new QCircleLoadingDialog(QFSMakeRedPacketLoadingPart.this.getContext());
                qCircleLoadingDialog.S(qCircleLoadingDialog.getContext().getString(R.string.f183703jw));
                return qCircleLoadingDialog;
            }
        });
        this.loadingDialog = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new QFSMakeRedPacketLoadingPart$loadFailedTipDialog$2(this));
        this.loadFailedTipDialog = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new QFSMakeRedPacketLoadingPart$upperLimitTipDialog$2(this));
        this.upperLimitTipDialog = lazy4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9() {
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QCircleCustomDialog J9() {
        return (QCircleCustomDialog) this.loadFailedTipDialog.getValue();
    }

    private final QCircleLoadingDialog K9() {
        return (QCircleLoadingDialog) this.loadingDialog.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QCircleCustomDialog L9() {
        return (QCircleCustomDialog) this.upperLimitTipDialog.getValue();
    }

    private final QFSMakeRedPacketViewModel M9() {
        return (QFSMakeRedPacketViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9() {
        K9().dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(Dialog tipDialog) {
        tipDialog.dismiss();
    }

    private final void P9() {
        LiveData<DialogState> W1 = M9().W1();
        Fragment hostFragment = getHostFragment();
        final Function1<DialogState, Unit> function1 = new Function1<DialogState, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.QFSMakeRedPacketLoadingPart$observeData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DialogState dialogState) {
                invoke2(dialogState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DialogState dialogState) {
                QCircleCustomDialog loadFailedTipDialog;
                QCircleCustomDialog loadFailedTipDialog2;
                QCircleCustomDialog upperLimitTipDialog;
                QCircleCustomDialog upperLimitTipDialog2;
                QLog.d("QFSMakeRedPacketLoadingPart", 1, "observeData, dialogState, cmd:" + dialogState.getCmd());
                switch (dialogState.getCmd()) {
                    case 1:
                        QFSMakeRedPacketLoadingPart.this.S9();
                        return;
                    case 2:
                        QFSMakeRedPacketLoadingPart.this.N9();
                        return;
                    case 3:
                        QFSMakeRedPacketLoadingPart qFSMakeRedPacketLoadingPart = QFSMakeRedPacketLoadingPart.this;
                        loadFailedTipDialog = qFSMakeRedPacketLoadingPart.J9();
                        Intrinsics.checkNotNullExpressionValue(loadFailedTipDialog, "loadFailedTipDialog");
                        qFSMakeRedPacketLoadingPart.T9(loadFailedTipDialog);
                        return;
                    case 4:
                        QFSMakeRedPacketLoadingPart qFSMakeRedPacketLoadingPart2 = QFSMakeRedPacketLoadingPart.this;
                        loadFailedTipDialog2 = qFSMakeRedPacketLoadingPart2.J9();
                        Intrinsics.checkNotNullExpressionValue(loadFailedTipDialog2, "loadFailedTipDialog");
                        qFSMakeRedPacketLoadingPart2.O9(loadFailedTipDialog2);
                        return;
                    case 5:
                        QFSMakeRedPacketLoadingPart qFSMakeRedPacketLoadingPart3 = QFSMakeRedPacketLoadingPart.this;
                        upperLimitTipDialog = qFSMakeRedPacketLoadingPart3.L9();
                        Intrinsics.checkNotNullExpressionValue(upperLimitTipDialog, "upperLimitTipDialog");
                        qFSMakeRedPacketLoadingPart3.T9(upperLimitTipDialog);
                        return;
                    case 6:
                        QFSMakeRedPacketLoadingPart qFSMakeRedPacketLoadingPart4 = QFSMakeRedPacketLoadingPart.this;
                        upperLimitTipDialog2 = qFSMakeRedPacketLoadingPart4.L9();
                        Intrinsics.checkNotNullExpressionValue(upperLimitTipDialog2, "upperLimitTipDialog");
                        qFSMakeRedPacketLoadingPart4.O9(upperLimitTipDialog2);
                        return;
                    case 7:
                        QFSMakeRedPacketLoadingPart.this.U9(dialogState.getToastMsg());
                        return;
                    default:
                        return;
                }
            }
        };
        W1.observe(hostFragment, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSMakeRedPacketLoadingPart.Q9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9() {
        M9().e2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9() {
        K9().showDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(Dialog tipDialog) {
        tipDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9(String msg2) {
        QCircleToast.p(msg2, 0, true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        P9();
    }
}
