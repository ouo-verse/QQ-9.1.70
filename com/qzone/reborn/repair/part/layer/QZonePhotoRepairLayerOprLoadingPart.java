package com.qzone.reborn.repair.part.layer;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.repair.utils.QZonePhotoRepairQNESingletonVM;
import com.qzone.reborn.repair.viewmodel.QZonePhotoRepairLayerViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.util.LoadingUtil;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR#\u0010\u0016\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/repair/part/layer/QZonePhotoRepairLayerOprLoadingPart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "", "initViewModel", "H9", "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "d", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "photoRepairViewModel", "Landroid/app/Dialog;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "D9", "()Landroid/app/Dialog;", "repairDialog", "", "f", "G9", "()Z", "isSupportOpr", "<init>", "()V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePhotoRepairLayerOprLoadingPart extends RFWLayerBasePart {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZonePhotoRepairLayerViewModel photoRepairViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy repairDialog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy isSupportOpr;

    public QZonePhotoRepairLayerOprLoadingPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Dialog>() { // from class: com.qzone.reborn.repair.part.layer.QZonePhotoRepairLayerOprLoadingPart$repairDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Dialog invoke() {
                return LoadingUtil.showLoadingDialog(QZonePhotoRepairLayerOprLoadingPart.this.getActivity(), "\u52a0\u8f7d\u4e2d", false);
            }
        });
        this.repairDialog = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.qzone.reborn.repair.part.layer.QZonePhotoRepairLayerOprLoadingPart$isSupportOpr$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(QZonePhotoRepairQNESingletonVM.f59266a.k());
            }
        });
        this.isSupportOpr = lazy2;
    }

    private final Dialog D9() {
        return (Dialog) this.repairDialog.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E9() {
        try {
            Dialog D9 = D9();
            if (D9 != null) {
                D9.dismiss();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean G9() {
        return ((Boolean) this.isSupportOpr.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9() {
        Dialog D9 = D9();
        if (D9 != null) {
            ef.d.f(D9, getActivity());
        }
    }

    private final void initViewModel() {
        MutableLiveData<QZonePhotoRepairLayerViewModel.Companion.RepairStatusData> n26;
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel = (QZonePhotoRepairLayerViewModel) getViewModel(QZonePhotoRepairLayerViewModel.class);
        this.photoRepairViewModel = qZonePhotoRepairLayerViewModel;
        if (qZonePhotoRepairLayerViewModel == null || (n26 = qZonePhotoRepairLayerViewModel.n2()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<QZonePhotoRepairLayerViewModel.Companion.RepairStatusData, Unit> function1 = new Function1<QZonePhotoRepairLayerViewModel.Companion.RepairStatusData, Unit>() { // from class: com.qzone.reborn.repair.part.layer.QZonePhotoRepairLayerOprLoadingPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QZonePhotoRepairLayerViewModel.Companion.RepairStatusData repairStatusData) {
                invoke2(repairStatusData);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
            
                r0 = r3.this$0.photoRepairViewModel;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(QZonePhotoRepairLayerViewModel.Companion.RepairStatusData repairStatusData) {
                boolean G9;
                Integer status;
                QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel2;
                G9 = QZonePhotoRepairLayerOprLoadingPart.this.G9();
                if (G9 && (status = repairStatusData.getStatus()) != null && status.intValue() == 1 && qZonePhotoRepairLayerViewModel2 != null) {
                    Context context = QZonePhotoRepairLayerOprLoadingPart.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    qZonePhotoRepairLayerViewModel2.z2(context);
                }
                if (repairStatusData.getIsSilentRepair()) {
                    Integer status2 = repairStatusData.getStatus();
                    if (status2 != null && status2.intValue() == 0) {
                        QZonePhotoRepairLayerOprLoadingPart.this.H9();
                    } else {
                        QZonePhotoRepairLayerOprLoadingPart.this.E9();
                    }
                }
            }
        };
        n26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.repair.part.layer.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZonePhotoRepairLayerOprLoadingPart.F9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
    }
}
