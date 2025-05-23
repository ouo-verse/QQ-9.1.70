package com.tencent.aelight.camera.ae.flashshow.ui.multicamera;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.flashshow.ui.multicamera.o;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0006\u0010&\u001a\u00020!\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0016J4\u0010\u0012\u001a\u00020\u00022*\u0010\u0011\u001a&\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000ej\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u0001`\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0006\u0010\u0014\u001a\u00020\u0002R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/multicamera/AECameraMultiCameraTipPart;", "Lcom/tencent/aelight/camera/ae/flashshow/ui/multicamera/AECameraMultiCameraBasePart;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/aelight/camera/ae/camera/ui/topbar/AEVideoStoryTopBarViewModel$Ratio;", "ratio", "", "cameraHeight", "cameraWith", BdhLogUtil.LogTag.Tag_Conn, ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, IPrefRecorder.MILESTONE_ON_SLEECT_CAMERA_IN_FS, HippyTKDListViewAdapter.X, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "map", "y", "B", "D", "Landroid/app/Activity;", "G", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", "H", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Llq/b;", "I", "Llq/b;", "getPartManger", "()Llq/b;", "partManger", "Landroid/widget/Button;", "J", "Landroid/widget/Button;", "countNum", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "countTip", "Landroid/widget/RelativeLayout;", "L", "Landroid/widget/RelativeLayout;", "tipContainer", "Landroid/view/animation/AnimationSet;", "M", "Landroid/view/animation/AnimationSet;", "scaleAnimation", "<init>", "(Landroid/app/Activity;Landroid/view/View;Llq/b;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AECameraMultiCameraTipPart extends AECameraMultiCameraBasePart {

    /* renamed from: G, reason: from kotlin metadata */
    private final Activity activity;

    /* renamed from: H, reason: from kotlin metadata */
    private final View rootView;

    /* renamed from: I, reason: from kotlin metadata */
    private final lq.b partManger;

    /* renamed from: J, reason: from kotlin metadata */
    private Button countNum;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView countTip;

    /* renamed from: L, reason: from kotlin metadata */
    private RelativeLayout tipContainer;

    /* renamed from: M, reason: from kotlin metadata */
    private AnimationSet scaleAnimation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AECameraMultiCameraTipPart(Activity activity, View rootView, lq.b partManger) {
        super(activity, rootView, partManger);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(partManger, "partManger");
        this.activity = activity;
        this.rootView = rootView;
        this.partManger = partManger;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void A() {
        ((ViewStub) this.rootView.findViewById(R.id.s18)).inflate();
        View findViewById = this.rootView.findViewById(R.id.s2n);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tip_rl_container)");
        this.tipContainer = (RelativeLayout) findViewById;
        View findViewById2 = this.rootView.findViewById(R.id.rrf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.count_num)");
        this.countNum = (Button) findViewById2;
        View findViewById3 = this.rootView.findViewById(R.id.rrg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.count_tip)");
        this.countTip = (TextView) findViewById3;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void C(AEVideoStoryTopBarViewModel.Ratio ratio, int cameraHeight, int cameraWith) {
        Intrinsics.checkNotNullParameter(ratio, "ratio");
        RelativeLayout relativeLayout = this.tipContainer;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipContainer");
            relativeLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.height = cameraHeight;
        RelativeLayout relativeLayout3 = this.tipContainer;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipContainer");
        } else {
            relativeLayout2 = relativeLayout3;
        }
        relativeLayout2.setLayoutParams(marginLayoutParams);
    }

    public final void D() {
        AnimationSet animationSet = this.scaleAnimation;
        if (animationSet != null) {
            animationSet.cancel();
        }
        RelativeLayout relativeLayout = null;
        this.scaleAnimation = null;
        RelativeLayout relativeLayout2 = this.tipContainer;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipContainer");
        } else {
            relativeLayout = relativeLayout2;
        }
        relativeLayout.setVisibility(8);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void y(HashMap<String, String> map) {
        D();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void z() {
        D();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void x(int selectCamera) {
        String str;
        if (selectCamera == 2) {
            str = "\u540e";
        } else {
            str = "\u524d";
        }
        TextView textView = this.countTip;
        Button button = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countTip");
            textView = null;
        }
        textView.setText(this.activity.getResources().getString(R.string.y5_, str));
        RelativeLayout relativeLayout = this.tipContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipContainer");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(0);
        o.Companion companion = o.INSTANCE;
        Button button2 = this.countNum;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countNum");
        } else {
            button = button2;
        }
        this.scaleAnimation = companion.a(button, 3, new Function0<Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraTipPart$onCameraCountingDownUIShow$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AECameraMultiCameraTipPart.this.q().f2();
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void B() {
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void s() {
    }
}
