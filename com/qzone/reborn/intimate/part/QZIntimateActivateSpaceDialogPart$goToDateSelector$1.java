package com.qzone.reborn.intimate.part;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.intimate.bean.QZoneIntimateActivateResultBean;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/intimate/part/QZIntimateActivateSpaceDialogPart$goToDateSelector$1", "Lcom/tencent/mobileqq/widget/selectorview/QActionSheet$f;", "", "onDismiss", "t", "onConfirm", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateActivateSpaceDialogPart$goToDateSelector$1 implements QActionSheet.f {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ QZIntimateActivateSpaceDialogPart f57180d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ com.qzone.reborn.widget.g f57181e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QZIntimateActivateSpaceDialogPart$goToDateSelector$1(QZIntimateActivateSpaceDialogPart qZIntimateActivateSpaceDialogPart, com.qzone.reborn.widget.g gVar) {
        this.f57180d = qZIntimateActivateSpaceDialogPart;
        this.f57181e = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
    public void onConfirm() {
        QZoneIntimateActivateResultBean qZoneIntimateActivateResultBean;
        nk.at atVar;
        QZoneIntimateActivateResultBean qZoneIntimateActivateResultBean2;
        MutableLiveData<Boolean> a26;
        final long K = this.f57181e.K() / 1000;
        qZoneIntimateActivateResultBean = this.f57180d.activateResultBean;
        if (qZoneIntimateActivateResultBean != null) {
            atVar = this.f57180d.mainTabViewModel;
            if (atVar != null && (a26 = atVar.a2()) != null) {
                Fragment hostFragment = this.f57180d.getHostFragment();
                final QZIntimateActivateSpaceDialogPart qZIntimateActivateSpaceDialogPart = this.f57180d;
                final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimateActivateSpaceDialogPart$goToDateSelector$1$onConfirm$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke2(bool);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
                    
                        r4 = r1.mainTabViewModel;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke2(Boolean bool) {
                        nk.at atVar2;
                        if (!Intrinsics.areEqual(bool, Boolean.TRUE) || atVar2 == null) {
                            return;
                        }
                        atVar2.c2(K, false);
                    }
                };
                a26.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.intimate.part.g
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        QZIntimateActivateSpaceDialogPart$goToDateSelector$1.b(Function1.this, obj);
                    }
                });
            }
            QZIntimateActivateSpaceDialogPart qZIntimateActivateSpaceDialogPart2 = this.f57180d;
            qZoneIntimateActivateResultBean2 = qZIntimateActivateSpaceDialogPart2.activateResultBean;
            Intrinsics.checkNotNull(qZoneIntimateActivateResultBean2);
            qZIntimateActivateSpaceDialogPart2.ma(qZoneIntimateActivateResultBean2);
        }
    }

    @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
    public void onDismiss() {
        QZoneIntimateActivateResultBean qZoneIntimateActivateResultBean;
        QZoneIntimateActivateResultBean qZoneIntimateActivateResultBean2;
        qZoneIntimateActivateResultBean = this.f57180d.activateResultBean;
        if (qZoneIntimateActivateResultBean != null) {
            QZIntimateActivateSpaceDialogPart qZIntimateActivateSpaceDialogPart = this.f57180d;
            qZoneIntimateActivateResultBean2 = qZIntimateActivateSpaceDialogPart.activateResultBean;
            Intrinsics.checkNotNull(qZoneIntimateActivateResultBean2);
            qZIntimateActivateSpaceDialogPart.ma(qZoneIntimateActivateResultBean2);
        }
    }

    @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
    public void t() {
    }
}
