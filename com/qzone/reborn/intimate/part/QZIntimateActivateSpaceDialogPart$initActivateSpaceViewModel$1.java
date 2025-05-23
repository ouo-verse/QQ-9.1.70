package com.qzone.reborn.intimate.part;

import android.os.Handler;
import com.qzone.reborn.intimate.bean.QZoneIntimateActivateResultBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateActivateSpaceBean;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenImmersiveFloatingView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateActivateResultBean;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZIntimateActivateSpaceDialogPart$initActivateSpaceViewModel$1 extends Lambda implements Function1<QZoneIntimateActivateResultBean, Unit> {
    final /* synthetic */ QZIntimateActivateSpaceDialogPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZIntimateActivateSpaceDialogPart$initActivateSpaceViewModel$1(QZIntimateActivateSpaceDialogPart qZIntimateActivateSpaceDialogPart) {
        super(1);
        this.this$0 = qZIntimateActivateSpaceDialogPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QZIntimateActivateSpaceDialogPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.getActivity(), 1, "\u5f00\u901a\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(QZoneIntimateActivateResultBean qZoneIntimateActivateResultBean) {
        invoke2(qZoneIntimateActivateResultBean);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x008a, code lost:
    
        r5 = r4.this$0.guideDialog;
     */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke2(QZoneIntimateActivateResultBean it) {
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView;
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView2;
        QZoneIntimateActivateSpaceBean qZoneIntimateActivateSpaceBean;
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView3;
        nk.u uVar;
        nk.u uVar2;
        nk.u uVar3;
        if (it.getActivateStatus()) {
            this.this$0.activateResultBean = it;
            mk.d dVar = mk.d.f416875a;
            qZoneIntimateActivateSpaceBean = this.this$0.activateSpaceBean;
            if (dVar.y(qZoneIntimateActivateSpaceBean != null ? Integer.valueOf(qZoneIntimateActivateSpaceBean.getSpaceType()) : null)) {
                uVar = this.this$0.activateSpaceViewModel;
                if (uVar != null) {
                    uVar2 = this.this$0.activateSpaceViewModel;
                    Intrinsics.checkNotNull(uVar2);
                    if (uVar2.getAnniversary() > 0) {
                        QZIntimateActivateSpaceDialogPart qZIntimateActivateSpaceDialogPart = this.this$0;
                        uVar3 = qZIntimateActivateSpaceDialogPart.activateSpaceViewModel;
                        Intrinsics.checkNotNull(uVar3);
                        qZIntimateActivateSpaceDialogPart.Z9(uVar3.getAnniversary());
                        return;
                    }
                }
            }
            qUSHalfScreenImmersiveFloatingView3 = this.this$0.guideDialog;
            if (qUSHalfScreenImmersiveFloatingView3 != null) {
                qUSHalfScreenImmersiveFloatingView3.t();
            }
            QZIntimateActivateSpaceDialogPart qZIntimateActivateSpaceDialogPart2 = this.this$0;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            qZIntimateActivateSpaceDialogPart2.ma(it);
            return;
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final QZIntimateActivateSpaceDialogPart qZIntimateActivateSpaceDialogPart3 = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.qzone.reborn.intimate.part.h
            @Override // java.lang.Runnable
            public final void run() {
                QZIntimateActivateSpaceDialogPart$initActivateSpaceViewModel$1.b(QZIntimateActivateSpaceDialogPart.this);
            }
        });
        qUSHalfScreenImmersiveFloatingView = this.this$0.guideDialog;
        if ((qUSHalfScreenImmersiveFloatingView != null && qUSHalfScreenImmersiveFloatingView.getVisibility() == 0) || qUSHalfScreenImmersiveFloatingView2 == null) {
            return;
        }
        qUSHalfScreenImmersiveFloatingView2.P(0);
    }
}
