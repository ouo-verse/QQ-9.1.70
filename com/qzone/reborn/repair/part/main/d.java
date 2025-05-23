package com.qzone.reborn.repair.part.main;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.qzone.reborn.base.k;
import com.qzone.reborn.repair.bean.QZonePhotoRepairTaskInitBean;
import com.qzone.reborn.repair.bean.QZoneRepairTaskStateBean;
import com.qzone.reborn.repair.utils.QZonePhotoRepairTaskQueueManger;
import com.qzone.reborn.util.i;
import com.qzone.util.l;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/repair/part/main/d;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "Lxn/d;", "", "D9", "E9", "F9", "G9", "I9", "J9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "Lcom/qzone/reborn/repair/bean/QZoneRepairTaskStateBean;", "taskBean", "B3", "Lcom/airbnb/lottie/LottieAnimationView;", "d", "Lcom/airbnb/lottie/LottieAnimationView;", "repairingLottieView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvTaskIcon", "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d extends k implements View.OnClickListener, xn.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LottieAnimationView repairingLottieView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvTaskIcon;

    private final void D9() {
        fo.b j3 = new fo.b().k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE);
        TextView textView = this.tvTaskIcon;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTaskIcon");
            textView = null;
        }
        fo.c.o(textView, "em_qz_task", j3);
    }

    private final void E9() {
        if (QZonePhotoRepairTaskQueueManger.INSTANCE.a().D()) {
            G9();
        }
    }

    private final void F9() {
        if (QZonePhotoRepairTaskQueueManger.INSTANCE.a().D()) {
            return;
        }
        I9();
    }

    private final void G9() {
        QLog.d("QZonePhotoRepairMainTitlePart", 1, hashCode() + " startRepairingAnimLoading");
        LottieAnimationView lottieAnimationView = this.repairingLottieView;
        LottieAnimationView lottieAnimationView2 = null;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repairingLottieView");
            lottieAnimationView = null;
        }
        lottieAnimationView.setVisibility(0);
        J9();
        Option url = Option.obtain().setPreferDecoder(com.tencent.libra.extension.a.class).setNeedShowLoadingDrawable(false).setUrl("https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/taskloading48.zip");
        LottieAnimationView lottieAnimationView3 = this.repairingLottieView;
        if (lottieAnimationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repairingLottieView");
        } else {
            lottieAnimationView2 = lottieAnimationView3;
        }
        Option option = url.setTargetView(lottieAnimationView2);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, new IPicLoadStateListener() { // from class: com.qzone.reborn.repair.part.main.c
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option2) {
                d.H9(d.this, loadState, option2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(d this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = false;
        if (loadState != null && loadState.isFinishSuccess()) {
            z16 = true;
        }
        if (z16) {
            if ((option != null ? option.getAnimatable() : null) instanceof r01.c) {
                QLog.d("QZonePhotoRepairMainTitlePart", 1, this$0.hashCode() + " anim load success");
                Animatable animatable = option.getAnimatable();
                Intrinsics.checkNotNull(animatable, "null cannot be cast to non-null type com.tencent.libra.base.LibraAnimatable");
                r01.c cVar = (r01.c) animatable;
                cVar.setLoopCount(10000);
                cVar.start();
                return;
            }
        }
        QLog.d("QZonePhotoRepairMainTitlePart", 1, this$0.hashCode() + " anim load error");
    }

    private final void I9() {
        QLog.d("QZonePhotoRepairMainTitlePart", 1, hashCode() + " stopRepairingAnimLoading");
        LottieAnimationView lottieAnimationView = this.repairingLottieView;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repairingLottieView");
            lottieAnimationView = null;
        }
        lottieAnimationView.setVisibility(8);
    }

    private final void J9() {
        if (i.b().d("show_repair_task_guide_popup", false)) {
            QLog.d("QZonePhotoRepairMainTitlePart", 1, "[tryShowGuidePop] have show guide");
            return;
        }
        com.tencent.mobileqq.widget.tip.a r16 = QUIDefaultBubbleTip.r(getContext());
        LottieAnimationView lottieAnimationView = this.repairingLottieView;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repairingLottieView");
            lottieAnimationView = null;
        }
        r16.S(lottieAnimationView).m0(3).o0(l.a(R.string.waw)).R(0).k0(2).s0();
        i.b().l("show_repair_task_guide_popup", true);
    }

    @Override // xn.d
    public void B3(QZoneRepairTaskStateBean taskBean) {
        Integer srStatus;
        Intrinsics.checkNotNullParameter(taskBean, "taskBean");
        Integer srStatus2 = taskBean.getSrStatus();
        if (srStatus2 != null && srStatus2.intValue() == 0) {
            G9();
            return;
        }
        Integer srStatus3 = taskBean.getSrStatus();
        if ((srStatus3 != null && srStatus3.intValue() == 1) || ((srStatus = taskBean.getSrStatus()) != null && srStatus.intValue() == 3)) {
            F9();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.kua) {
            Activity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        } else {
            boolean z16 = true;
            if ((valueOf == null || valueOf.intValue() != R.id.nk9) && (valueOf == null || valueOf.intValue() != R.id.nat)) {
                z16 = false;
            }
            if (z16) {
                ho.i.v().c(getContext(), new QZonePhotoRepairTaskInitBean());
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.kua);
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        View findViewById = rootView.findViewById(R.id.nk9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tv_task_icon)");
        TextView textView = (TextView) findViewById;
        this.tvTaskIcon = textView;
        LottieAnimationView lottieAnimationView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTaskIcon");
            textView = null;
        }
        textView.setOnClickListener(this);
        View findViewById2 = rootView.findViewById(R.id.nat);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ir_repairing_lottie_view)");
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) findViewById2;
        this.repairingLottieView = lottieAnimationView2;
        if (lottieAnimationView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repairingLottieView");
        } else {
            lottieAnimationView = lottieAnimationView2;
        }
        lottieAnimationView.setOnClickListener(this);
        E9();
        D9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        QZonePhotoRepairTaskQueueManger.INSTANCE.a().I(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QZonePhotoRepairTaskQueueManger.INSTANCE.a().P(this);
        LottieAnimationView lottieAnimationView = this.repairingLottieView;
        LottieAnimationView lottieAnimationView2 = null;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repairingLottieView");
            lottieAnimationView = null;
        }
        lottieAnimationView.cancelAnimation();
        LottieAnimationView lottieAnimationView3 = this.repairingLottieView;
        if (lottieAnimationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repairingLottieView");
        } else {
            lottieAnimationView2 = lottieAnimationView3;
        }
        lottieAnimationView2.clearAnimation();
    }
}
