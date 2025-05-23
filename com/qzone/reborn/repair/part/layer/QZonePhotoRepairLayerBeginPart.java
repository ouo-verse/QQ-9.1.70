package com.qzone.reborn.repair.part.layer;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.repair.part.layer.QZonePhotoRepairLayerBeginPart;
import com.qzone.reborn.repair.viewmodel.QZonePhotoRepairLayerViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasYellowDiamondPay;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qzone.SuperResolution$QueryPermissionsRsp;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 72\u00020\u0001:\u00018B\u0007\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010#R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/qzone/reborn/repair/part/layer/QZonePhotoRepairLayerBeginPart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "I9", "N9", "initViewModel", "", "isRepairFail", "J9", "", "status", "V9", "(Ljava/lang/Integer;)V", "S9", "K9", "Q9", "R9", "onInitView", "d", "Landroid/view/View;", "mBeginView", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "mBeginContainer", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "f", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mBeginRepairBtn", tl.h.F, "mRepairFailView", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mTvSurplusTimesView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mTvYellowDiamondView", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "mIvYellowDiamondIcon", "D", "mTvPayGuideBlackText", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "E", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "mPhotoRepairViewModel", "Lqzone/SuperResolution$QueryPermissionsRsp;", UserInfo.SEX_FEMALE, "Lqzone/SuperResolution$QueryPermissionsRsp;", "mPermissionsRsp", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePhotoRepairLayerBeginPart extends RFWLayerBasePart {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView mIvYellowDiamondIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mTvPayGuideBlackText;

    /* renamed from: E, reason: from kotlin metadata */
    private QZonePhotoRepairLayerViewModel mPhotoRepairViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private SuperResolution$QueryPermissionsRsp mPermissionsRsp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mBeginView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mBeginContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUIButton mBeginRepairBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mRepairFailView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mTvSurplusTimesView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mTvYellowDiamondView;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/repair/part/layer/QZonePhotoRepairLayerBeginPart$b", "Lcom/tencent/mobileqq/vas/api/IVasYellowDiamondPay$a;", "", "isSuccess", "", "code", "", "msg", "", "onResult", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements IVasYellowDiamondPay.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(QZonePhotoRepairLayerBeginPart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel = this$0.mPhotoRepairViewModel;
            if (qZonePhotoRepairLayerViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
                qZonePhotoRepairLayerViewModel = null;
            }
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            qZonePhotoRepairLayerViewModel.z2(context);
        }

        @Override // com.tencent.mobileqq.vas.api.IVasYellowDiamondPay.a
        public void onResult(boolean isSuccess, int code, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.d("QZonePhotoRepairLayerBeginPart", 1, "onResult isSuccess=" + isSuccess + ", code=" + code + ", msg=" + msg2);
            if (isSuccess) {
                Handler uIHandler = RFWThreadManager.getUIHandler();
                final QZonePhotoRepairLayerBeginPart qZonePhotoRepairLayerBeginPart = QZonePhotoRepairLayerBeginPart.this;
                uIHandler.postDelayed(new Runnable() { // from class: com.qzone.reborn.repair.part.layer.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZonePhotoRepairLayerBeginPart.b.b(QZonePhotoRepairLayerBeginPart.this);
                    }
                }, 1000L);
            }
        }
    }

    private final void I9(View rootView) {
        View view = null;
        View inflate = LayoutInflater.from(rootView.getContext()).inflate(R.layout.cmy, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(rootView.context)\n \u2026layer_begin_layout, null)");
        this.mBeginView = inflate;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) rootView;
        View view2 = this.mBeginView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeginView");
        } else {
            view = view2;
        }
        viewGroup.addView(view, layoutParams);
    }

    private final void J9(boolean isRepairFail) {
        String str;
        fo.b j3 = new fo.b().k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE);
        QUIButton qUIButton = this.mBeginRepairBtn;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeginRepairBtn");
            qUIButton = null;
        }
        if (isRepairFail) {
            str = "em_qz_repair_again";
        } else {
            str = "em_qz_pic_repair_start";
        }
        fo.c.o(qUIButton, str, j3);
    }

    private final void K9() {
        Map<String, Object> mutableMapOf;
        SuperResolution$QueryPermissionsRsp superResolution$QueryPermissionsRsp = this.mPermissionsRsp;
        if (superResolution$QueryPermissionsRsp == null) {
            return;
        }
        Intrinsics.checkNotNull(superResolution$QueryPermissionsRsp);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.FUNCTION_STATE, Integer.valueOf(superResolution$QueryPermissionsRsp.rp_pay_type.get())));
        fo.b j3 = new fo.b().l(mutableMapOf).k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE);
        TextView textView = this.mTvYellowDiamondView;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvYellowDiamondView");
            textView = null;
        }
        fo.c.o(textView, WinkDaTongReportConstant.ElementId.EM_QZ_OPEN_YELLOW_DIAMOND, j3);
        ImageView imageView2 = this.mIvYellowDiamondIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvYellowDiamondIcon");
        } else {
            imageView = imageView2;
        }
        fo.c.o(imageView, WinkDaTongReportConstant.ElementId.EM_QZ_OPEN_YELLOW_DIAMOND, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(QZonePhotoRepairLayerBeginPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(QZonePhotoRepairLayerBeginPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void R9() {
        SuperResolution$QueryPermissionsRsp superResolution$QueryPermissionsRsp = this.mPermissionsRsp;
        if ((superResolution$QueryPermissionsRsp != null ? superResolution$QueryPermissionsRsp.rp_pay_type : null) == null) {
            QLog.e("QZonePhotoRepairLayerBeginPart", 1, "[onHandleClickYellowDiamond] permissions:" + superResolution$QueryPermissionsRsp);
            return;
        }
        IVasYellowDiamondPay iVasYellowDiamondPay = (IVasYellowDiamondPay) QRoute.api(IVasYellowDiamondPay.class);
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        SuperResolution$QueryPermissionsRsp superResolution$QueryPermissionsRsp2 = this.mPermissionsRsp;
        Intrinsics.checkNotNull(superResolution$QueryPermissionsRsp2);
        PBEnumField pBEnumField = superResolution$QueryPermissionsRsp2.rp_pay_type;
        Intrinsics.checkNotNull(pBEnumField);
        iVasYellowDiamondPay.payFromQzonePhotoRepair(activity, pBEnumField.get(), new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewGroup] */
    public final void S9() {
        Integer status;
        SuperResolution$QueryPermissionsRsp superResolution$QueryPermissionsRsp = this.mPermissionsRsp;
        if (superResolution$QueryPermissionsRsp == null) {
            QLog.e("QZonePhotoRepairLayerBeginPart", 1, "[repair_photo] permission rsp is null");
            return;
        }
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel = this.mPhotoRepairViewModel;
        TextView textView = null;
        if (qZonePhotoRepairLayerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
            qZonePhotoRepairLayerViewModel = null;
        }
        if (!QZonePhotoRepairLayerViewModel.u2(qZonePhotoRepairLayerViewModel, null, 1, null)) {
            QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel2 = this.mPhotoRepairViewModel;
            if (qZonePhotoRepairLayerViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
                qZonePhotoRepairLayerViewModel2 = null;
            }
            QZonePhotoRepairLayerViewModel.Companion.RepairStatusData value = qZonePhotoRepairLayerViewModel2.n2().getValue();
            if (!((value == null || (status = value.getStatus()) == null || status.intValue() != 0) ? false : true)) {
                boolean z16 = superResolution$QueryPermissionsRsp.enable_sr.get();
                QLog.i("QZonePhotoRepairLayerBeginPart", 1, "[repair_photo] repair permission enableSr:" + z16);
                if (z16) {
                    QUIButton qUIButton = this.mBeginRepairBtn;
                    if (qUIButton == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBeginRepairBtn");
                        qUIButton = null;
                    }
                    qUIButton.o();
                    QUIButton qUIButton2 = this.mBeginRepairBtn;
                    if (qUIButton2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBeginRepairBtn");
                        qUIButton2 = null;
                    }
                    qUIButton2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.repair.part.layer.e
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            QZonePhotoRepairLayerBeginPart.T9(QZonePhotoRepairLayerBeginPart.this, view);
                        }
                    });
                } else {
                    QUIButton qUIButton3 = this.mBeginRepairBtn;
                    if (qUIButton3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBeginRepairBtn");
                        qUIButton3 = null;
                    }
                    qUIButton3.setBackgroundDisabled();
                    QUIButton qUIButton4 = this.mBeginRepairBtn;
                    if (qUIButton4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBeginRepairBtn");
                        qUIButton4 = null;
                    }
                    qUIButton4.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.repair.part.layer.f
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            QZonePhotoRepairLayerBeginPart.U9(QZonePhotoRepairLayerBeginPart.this, view);
                        }
                    });
                }
                ViewGroup viewGroup = this.mBeginContainer;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBeginContainer");
                    viewGroup = null;
                }
                viewGroup.setVisibility(0);
                QUIButton qUIButton5 = this.mBeginRepairBtn;
                if (qUIButton5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBeginRepairBtn");
                    qUIButton5 = null;
                }
                qUIButton5.setText(superResolution$QueryPermissionsRsp.pp_button_hint.get());
                TextView textView2 = this.mTvSurplusTimesView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvSurplusTimesView");
                    textView2 = null;
                }
                textView2.setText(superResolution$QueryPermissionsRsp.rp_middle_hint.get());
                TextView textView3 = this.mTvYellowDiamondView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvYellowDiamondView");
                    textView3 = null;
                }
                textView3.setText(superResolution$QueryPermissionsRsp.rp_pay_guide_hint1.get());
                TextView textView4 = this.mTvPayGuideBlackText;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvPayGuideBlackText");
                } else {
                    textView = textView4;
                }
                textView.setText(superResolution$QueryPermissionsRsp.rp_pay_guide_hint2.get());
                K9();
                return;
            }
        }
        ?? r06 = this.mBeginContainer;
        if (r06 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeginContainer");
        } else {
            textView = r06;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(QZonePhotoRepairLayerBeginPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(QZonePhotoRepairLayerBeginPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(QZonePhotoRepairLayerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZonePhotoR\u2026yerViewModel::class.java)");
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel = (QZonePhotoRepairLayerViewModel) viewModel;
        this.mPhotoRepairViewModel = qZonePhotoRepairLayerViewModel;
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel2 = null;
        if (qZonePhotoRepairLayerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
            qZonePhotoRepairLayerViewModel = null;
        }
        MutableLiveData<QZonePhotoRepairLayerViewModel.Companion.RepairStatusData> n26 = qZonePhotoRepairLayerViewModel.n2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<QZonePhotoRepairLayerViewModel.Companion.RepairStatusData, Unit> function1 = new Function1<QZonePhotoRepairLayerViewModel.Companion.RepairStatusData, Unit>() { // from class: com.qzone.reborn.repair.part.layer.QZonePhotoRepairLayerBeginPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QZonePhotoRepairLayerViewModel.Companion.RepairStatusData repairStatusData) {
                invoke2(repairStatusData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QZonePhotoRepairLayerViewModel.Companion.RepairStatusData repairStatusData) {
                QZonePhotoRepairLayerBeginPart.this.V9(repairStatusData.getStatus());
            }
        };
        n26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.repair.part.layer.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZonePhotoRepairLayerBeginPart.L9(Function1.this, obj);
            }
        });
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel3 = this.mPhotoRepairViewModel;
        if (qZonePhotoRepairLayerViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
            qZonePhotoRepairLayerViewModel3 = null;
        }
        MutableLiveData<SuperResolution$QueryPermissionsRsp> m26 = qZonePhotoRepairLayerViewModel3.m2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<SuperResolution$QueryPermissionsRsp, Unit> function12 = new Function1<SuperResolution$QueryPermissionsRsp, Unit>() { // from class: com.qzone.reborn.repair.part.layer.QZonePhotoRepairLayerBeginPart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SuperResolution$QueryPermissionsRsp superResolution$QueryPermissionsRsp) {
                invoke2(superResolution$QueryPermissionsRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SuperResolution$QueryPermissionsRsp superResolution$QueryPermissionsRsp) {
                QZonePhotoRepairLayerBeginPart.this.mPermissionsRsp = superResolution$QueryPermissionsRsp;
                QZonePhotoRepairLayerBeginPart.this.S9();
            }
        };
        m26.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.repair.part.layer.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZonePhotoRepairLayerBeginPart.M9(Function1.this, obj);
            }
        });
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel4 = this.mPhotoRepairViewModel;
        if (qZonePhotoRepairLayerViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
        } else {
            qZonePhotoRepairLayerViewModel2 = qZonePhotoRepairLayerViewModel4;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        qZonePhotoRepairLayerViewModel2.i2(context);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        I9(rootView);
        N9(rootView);
        initViewModel();
    }

    private final void Q9() {
        QLog.d("QZonePhotoRepairLayerBeginPart", 1, "[repair_photo] begin repair");
        ViewGroup viewGroup = this.mRepairFailView;
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRepairFailView");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
        ViewGroup viewGroup2 = this.mBeginContainer;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeginContainer");
            viewGroup2 = null;
        }
        viewGroup2.setVisibility(8);
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel2 = this.mPhotoRepairViewModel;
        if (qZonePhotoRepairLayerViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
        } else {
            qZonePhotoRepairLayerViewModel = qZonePhotoRepairLayerViewModel2;
        }
        qZonePhotoRepairLayerViewModel.E2();
    }

    private final void N9(View rootView) {
        View findViewById = rootView.findViewById(R.id.n_w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026ir_layer_begin_container)");
        this.mBeginContainer = (ViewGroup) findViewById;
        View findViewById2 = rootView.findViewById(R.id.n_x);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026_repair_layer_begin_task)");
        this.mBeginRepairBtn = (QUIButton) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.nab);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026repair_layer_repair_fail)");
        this.mRepairFailView = (ViewGroup) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.njk);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.tv_pay_guide_yellow)");
        this.mTvYellowDiamondView = (TextView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.lwn);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.iv_yellow_diamond_icon)");
        this.mIvYellowDiamondIcon = (ImageView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.njj);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.tv_pay_guide_black)");
        this.mTvPayGuideBlackText = (TextView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.njv);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.tv_repair_num)");
        this.mTvSurplusTimesView = (TextView) findViewById7;
        TextView textView = this.mTvYellowDiamondView;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvYellowDiamondView");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.repair.part.layer.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZonePhotoRepairLayerBeginPart.O9(QZonePhotoRepairLayerBeginPart.this, view);
            }
        });
        ImageView imageView2 = this.mIvYellowDiamondIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvYellowDiamondIcon");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.repair.part.layer.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZonePhotoRepairLayerBeginPart.P9(QZonePhotoRepairLayerBeginPart.this, view);
            }
        });
        J9(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(Integer status) {
        if (status != null && status.intValue() == 3) {
            S9();
            QUIButton qUIButton = this.mBeginRepairBtn;
            ViewGroup viewGroup = null;
            if (qUIButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBeginRepairBtn");
                qUIButton = null;
            }
            qUIButton.setText(com.qzone.util.l.a(R.string.wad));
            ViewGroup viewGroup2 = this.mRepairFailView;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRepairFailView");
            } else {
                viewGroup = viewGroup2;
            }
            viewGroup.setVisibility(0);
            J9(true);
        }
    }
}
