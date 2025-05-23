package com.tencent.aelight.camera.ae.flashshow.ui.multicamera;

import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.flashshow.ax;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0006\u0010%\u001a\u00020!\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0016J4\u0010\u0013\u001a\u00020\u00022*\u0010\u0012\u001a&\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fj\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u0001`\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010%\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010-\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010=\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u00108\u00a8\u0006@"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/multicamera/i;", "Lcom/tencent/aelight/camera/ae/flashshow/ui/multicamera/AECameraMultiCameraBasePart;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "I", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/aelight/camera/ae/camera/ui/topbar/AEVideoStoryTopBarViewModel$Ratio;", "ratio", "", "cameraHeight", "cameraWith", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, IPrefRecorder.MILESTONE_ON_SLEECT_CAMERA_IN_FS, HippyTKDListViewAdapter.X, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "map", "y", "B", "Landroid/app/Activity;", "G", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", "H", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Llq/b;", "Llq/b;", "getPartManger", "()Llq/b;", "partManger", "Lcom/tencent/aelight/camera/ae/view/AECompoundButton;", "J", "Lcom/tencent/aelight/camera/ae/view/AECompoundButton;", "closeCameraBtn", "K", "switchCameraBtn", "L", "cancelBtn", "Landroid/widget/TextView;", "M", "Landroid/widget/TextView;", "nextBtn", "Landroid/widget/ImageView;", "N", "Landroid/widget/ImageView;", "cameraCaptureBtn", "Landroid/widget/RelativeLayout;", "P", "Landroid/widget/RelativeLayout;", "captureBottomView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "countingDownBottomView", BdhLogUtil.LogTag.Tag_Req, "previewBottomView", "<init>", "(Landroid/app/Activity;Landroid/view/View;Llq/b;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class i extends AECameraMultiCameraBasePart {

    /* renamed from: G, reason: from kotlin metadata */
    private final Activity activity;

    /* renamed from: H, reason: from kotlin metadata */
    private final View rootView;

    /* renamed from: I, reason: from kotlin metadata */
    private final lq.b partManger;

    /* renamed from: J, reason: from kotlin metadata */
    private AECompoundButton closeCameraBtn;

    /* renamed from: K, reason: from kotlin metadata */
    private AECompoundButton switchCameraBtn;

    /* renamed from: L, reason: from kotlin metadata */
    private AECompoundButton cancelBtn;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView nextBtn;

    /* renamed from: N, reason: from kotlin metadata */
    private ImageView cameraCaptureBtn;

    /* renamed from: P, reason: from kotlin metadata */
    private RelativeLayout captureBottomView;

    /* renamed from: Q, reason: from kotlin metadata */
    private RelativeLayout countingDownBottomView;

    /* renamed from: R, reason: from kotlin metadata */
    private RelativeLayout previewBottomView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Activity activity, View rootView, lq.b partManger) {
        super(activity, rootView, partManger);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(partManger, "partManger");
        this.activity = activity;
        this.rootView = rootView;
        this.partManger = partManger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q().N1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q().M1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ax q16 = this$0.q();
        AECompoundButton aECompoundButton = this$0.switchCameraBtn;
        if (aECompoundButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchCameraBtn");
            aECompoundButton = null;
        }
        q16.h2(false, aECompoundButton);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.cameraCaptureBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraCaptureBtn");
            imageView = null;
        }
        imageView.setClickable(false);
        this$0.q().f2();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q().c2();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void A() {
        View findViewById = this.rootView.findViewById(R.id.s16);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026_multi_camera_bottom_bar)");
        ((ViewStub) findViewById).inflate();
        View findViewById2 = this.rootView.findViewById(R.id.rqm);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.capture_bottom_view)");
        this.captureBottomView = (RelativeLayout) findViewById2;
        View findViewById3 = this.rootView.findViewById(R.id.rqo);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026ounting_down_bottom_view)");
        this.countingDownBottomView = (RelativeLayout) findViewById3;
        View findViewById4 = this.rootView.findViewById(R.id.rqr);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026ture_preview_bottom_view)");
        this.previewBottomView = (RelativeLayout) findViewById4;
        View findViewById5 = this.rootView.findViewById(R.id.rp7);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.btn_close_camera)");
        this.closeCameraBtn = (AECompoundButton) findViewById5;
        View findViewById6 = this.rootView.findViewById(R.id.rpr);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.btn_switch_camera)");
        this.switchCameraBtn = (AECompoundButton) findViewById6;
        View findViewById7 = this.rootView.findViewById(R.id.rxe);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.multi_capture_btn)");
        this.cameraCaptureBtn = (ImageView) findViewById7;
        View findViewById8 = this.rootView.findViewById(R.id.rp6);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.btn_cancle)");
        this.cancelBtn = (AECompoundButton) findViewById8;
        View findViewById9 = this.rootView.findViewById(R.id.rpc);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.id.btn_next)");
        this.nextBtn = (TextView) findViewById9;
        AECompoundButton aECompoundButton = this.closeCameraBtn;
        TextView textView = null;
        if (aECompoundButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeCameraBtn");
            aECompoundButton = null;
        }
        aECompoundButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.J(i.this, view);
            }
        });
        AECompoundButton aECompoundButton2 = this.cancelBtn;
        if (aECompoundButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelBtn");
            aECompoundButton2 = null;
        }
        aECompoundButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.K(i.this, view);
            }
        });
        I();
        AECompoundButton aECompoundButton3 = this.switchCameraBtn;
        if (aECompoundButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchCameraBtn");
            aECompoundButton3 = null;
        }
        aECompoundButton3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.L(i.this, view);
            }
        });
        ImageView imageView = this.cameraCaptureBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraCaptureBtn");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.M(i.this, view);
            }
        });
        TextView textView2 = this.nextBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.N(i.this, view);
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void C(AEVideoStoryTopBarViewModel.Ratio ratio, int cameraHeight, int cameraWith) {
        Intrinsics.checkNotNullParameter(ratio, "ratio");
    }

    public final void I() {
        char c16 = q().getSelectedCamera() == 1 ? (char) 2 : (char) 1;
        AECompoundButton aECompoundButton = this.switchCameraBtn;
        if (aECompoundButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchCameraBtn");
            aECompoundButton = null;
        }
        if (c16 != 1) {
            AccessibilityUtil.p(aECompoundButton, HardCodeUtil.qqStr(R.string.f169905y83));
        } else {
            AccessibilityUtil.p(aECompoundButton, HardCodeUtil.qqStr(R.string.f169906y84));
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void s() {
        ImageView imageView = this.cameraCaptureBtn;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraCaptureBtn");
            imageView = null;
        }
        com.tencent.aelight.camera.aebase.c.a(imageView, "em_bas_capture_button");
        AECompoundButton aECompoundButton = this.closeCameraBtn;
        if (aECompoundButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeCameraBtn");
            aECompoundButton = null;
        }
        com.tencent.aelight.camera.aebase.c.a(aECompoundButton, "em_bas_close_button");
        AECompoundButton aECompoundButton2 = this.switchCameraBtn;
        if (aECompoundButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchCameraBtn");
            aECompoundButton2 = null;
        }
        com.tencent.aelight.camera.aebase.c.a(aECompoundButton2, "em_bas_flip_shot");
        TextView textView2 = this.nextBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
        } else {
            textView = textView2;
        }
        com.tencent.aelight.camera.aebase.c.a(textView, "em_bas_next_button");
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void x(int selectCamera) {
        RelativeLayout relativeLayout = this.captureBottomView;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureBottomView");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
        RelativeLayout relativeLayout3 = this.countingDownBottomView;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countingDownBottomView");
            relativeLayout3 = null;
        }
        relativeLayout3.setVisibility(0);
        RelativeLayout relativeLayout4 = this.previewBottomView;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewBottomView");
        } else {
            relativeLayout2 = relativeLayout4;
        }
        relativeLayout2.setVisibility(8);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void y(HashMap<String, String> map) {
        RelativeLayout relativeLayout = this.captureBottomView;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureBottomView");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
        RelativeLayout relativeLayout3 = this.countingDownBottomView;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countingDownBottomView");
            relativeLayout3 = null;
        }
        relativeLayout3.setVisibility(8);
        RelativeLayout relativeLayout4 = this.previewBottomView;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewBottomView");
        } else {
            relativeLayout2 = relativeLayout4;
        }
        relativeLayout2.setVisibility(0);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void z() {
        ImageView imageView = this.cameraCaptureBtn;
        RelativeLayout relativeLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraCaptureBtn");
            imageView = null;
        }
        imageView.setClickable(true);
        RelativeLayout relativeLayout2 = this.captureBottomView;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureBottomView");
            relativeLayout2 = null;
        }
        relativeLayout2.setVisibility(0);
        RelativeLayout relativeLayout3 = this.countingDownBottomView;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countingDownBottomView");
            relativeLayout3 = null;
        }
        relativeLayout3.setVisibility(8);
        RelativeLayout relativeLayout4 = this.previewBottomView;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewBottomView");
        } else {
            relativeLayout = relativeLayout4;
        }
        relativeLayout.setVisibility(8);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void B() {
    }
}
