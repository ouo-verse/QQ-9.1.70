package com.tencent.aelight.camera.ae.flashshow.ui.multicamera;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.flashshow.ax;
import com.tencent.aelight.camera.ae.flashshow.ui.multicamera.o;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.view.RoundCornerImageView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u0010'\u001a\u00020\"\u00a2\u0006\u0004\bB\u0010CJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J4\u0010\u0014\u001a\u00020\u00042*\u0010\u0013\u001a&\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010j\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u0001`\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0006\u0010\u0016\u001a\u00020\u0004R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010/\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010*R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010>\u00a8\u0006D"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/multicamera/AECameraMultiCameraPreviewPart;", "Lcom/tencent/aelight/camera/ae/flashshow/ui/multicamera/AECameraMultiCameraBasePart;", "", NodeProps.VISIBLE, "", "G", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/aelight/camera/ae/camera/ui/topbar/AEVideoStoryTopBarViewModel$Ratio;", "ratio", "cameraHeight", "cameraWith", BdhLogUtil.LogTag.Tag_Conn, ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, IPrefRecorder.MILESTONE_ON_SLEECT_CAMERA_IN_FS, HippyTKDListViewAdapter.X, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "map", "y", "B", UserInfo.SEX_FEMALE, "Landroid/app/Activity;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", "H", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Llq/b;", "I", "Llq/b;", "getPartManger", "()Llq/b;", "partManger", "Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "J", "Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "smallPreviewFromImage", "K", "smallPreviewToImage", "L", "bigPreviewImage", "Landroid/widget/RelativeLayout;", "M", "Landroid/widget/RelativeLayout;", ParseCommon.CONTAINER, "Landroid/view/animation/Animation;", "N", "Landroid/view/animation/Animation;", "scaleAnimation", "", "P", "Z", "swapStatus", "Landroid/graphics/Bitmap;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/graphics/Bitmap;", "bigPreviewBitmap", BdhLogUtil.LogTag.Tag_Req, "smallPreviewBitmap", "<init>", "(Landroid/app/Activity;Landroid/view/View;Llq/b;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AECameraMultiCameraPreviewPart extends AECameraMultiCameraBasePart {

    /* renamed from: G, reason: from kotlin metadata */
    private final Activity activity;

    /* renamed from: H, reason: from kotlin metadata */
    private final View rootView;

    /* renamed from: I, reason: from kotlin metadata */
    private final lq.b partManger;

    /* renamed from: J, reason: from kotlin metadata */
    private RoundCornerImageView smallPreviewFromImage;

    /* renamed from: K, reason: from kotlin metadata */
    private RoundCornerImageView smallPreviewToImage;

    /* renamed from: L, reason: from kotlin metadata */
    private RoundCornerImageView bigPreviewImage;

    /* renamed from: M, reason: from kotlin metadata */
    private RelativeLayout container;

    /* renamed from: N, reason: from kotlin metadata */
    private Animation scaleAnimation;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean swapStatus;

    /* renamed from: Q, reason: from kotlin metadata */
    private Bitmap bigPreviewBitmap;

    /* renamed from: R, reason: from kotlin metadata */
    private Bitmap smallPreviewBitmap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AECameraMultiCameraPreviewPart(Activity activity, View rootView, lq.b partManger) {
        super(activity, rootView, partManger);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(partManger, "partManger");
        this.activity = activity;
        this.rootView = rootView;
        this.partManger = partManger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(AECameraMultiCameraPreviewPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void A() {
        ViewStub viewStub = (ViewStub) this.rootView.findViewById(R.id.s17);
        if (viewStub != null) {
            viewStub.inflate();
        }
        View findViewById = this.rootView.findViewById(R.id.s0v);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026small_preview_scale_from)");
        this.smallPreviewFromImage = (RoundCornerImageView) findViewById;
        View findViewById2 = this.rootView.findViewById(R.id.s0w);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.small_preview_scale_to)");
        this.smallPreviewToImage = (RoundCornerImageView) findViewById2;
        View findViewById3 = this.rootView.findViewById(R.id.rot);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.big_preview)");
        this.bigPreviewImage = (RoundCornerImageView) findViewById3;
        View findViewById4 = this.rootView.findViewById(R.id.ryj);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.pre_rl_container)");
        this.container = (RelativeLayout) findViewById4;
        RoundCornerImageView roundCornerImageView = this.smallPreviewToImage;
        RoundCornerImageView roundCornerImageView2 = null;
        if (roundCornerImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallPreviewToImage");
            roundCornerImageView = null;
        }
        roundCornerImageView.setBorder(true);
        RoundCornerImageView roundCornerImageView3 = this.smallPreviewToImage;
        if (roundCornerImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallPreviewToImage");
            roundCornerImageView3 = null;
        }
        roundCornerImageView3.setBorderWidth(ImmersiveUtils.dpToPx(3.0f));
        RoundCornerImageView roundCornerImageView4 = this.smallPreviewToImage;
        if (roundCornerImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallPreviewToImage");
            roundCornerImageView4 = null;
        }
        roundCornerImageView4.setColor(this.activity.getResources().getColor(R.color.f156600ag1));
        RoundCornerImageView roundCornerImageView5 = this.smallPreviewToImage;
        if (roundCornerImageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallPreviewToImage");
            roundCornerImageView5 = null;
        }
        roundCornerImageView5.setCorner(ImmersiveUtils.dpToPx(12.0f));
        RoundCornerImageView roundCornerImageView6 = this.smallPreviewFromImage;
        if (roundCornerImageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallPreviewFromImage");
            roundCornerImageView6 = null;
        }
        roundCornerImageView6.setCorner(ImmersiveUtils.dpToPx(20.0f));
        RoundCornerImageView roundCornerImageView7 = this.smallPreviewToImage;
        if (roundCornerImageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallPreviewToImage");
        } else {
            roundCornerImageView2 = roundCornerImageView7;
        }
        roundCornerImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AECameraMultiCameraPreviewPart.E(AECameraMultiCameraPreviewPart.this, view);
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void C(AEVideoStoryTopBarViewModel.Ratio ratio, int cameraHeight, int cameraWith) {
        Intrinsics.checkNotNullParameter(ratio, "ratio");
        RelativeLayout relativeLayout = this.container;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            relativeLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        layoutParams.height = cameraHeight;
        RelativeLayout relativeLayout3 = this.container;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        } else {
            relativeLayout2 = relativeLayout3;
        }
        relativeLayout2.setLayoutParams(layoutParams);
    }

    public final void F() {
        boolean z16 = !this.swapStatus;
        this.swapStatus = z16;
        RoundCornerImageView roundCornerImageView = null;
        if (z16) {
            RoundCornerImageView roundCornerImageView2 = this.bigPreviewImage;
            if (roundCornerImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bigPreviewImage");
                roundCornerImageView2 = null;
            }
            roundCornerImageView2.setImageBitmap(this.bigPreviewBitmap);
            RoundCornerImageView roundCornerImageView3 = this.smallPreviewToImage;
            if (roundCornerImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("smallPreviewToImage");
            } else {
                roundCornerImageView = roundCornerImageView3;
            }
            roundCornerImageView.setImageBitmap(this.smallPreviewBitmap);
            return;
        }
        RoundCornerImageView roundCornerImageView4 = this.bigPreviewImage;
        if (roundCornerImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bigPreviewImage");
            roundCornerImageView4 = null;
        }
        roundCornerImageView4.setImageBitmap(this.smallPreviewBitmap);
        RoundCornerImageView roundCornerImageView5 = this.smallPreviewToImage;
        if (roundCornerImageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallPreviewToImage");
        } else {
            roundCornerImageView = roundCornerImageView5;
        }
        roundCornerImageView.setImageBitmap(this.bigPreviewBitmap);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void y(HashMap<String, String> map) {
        String str;
        String str2;
        this.swapStatus = true;
        RoundCornerImageView roundCornerImageView = null;
        if (map != null && (str2 = map.get(AECameraConstants.AE_MULTI_CAMERA_BIG_PATH)) != null) {
            this.bigPreviewBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), str2, 1);
            RoundCornerImageView roundCornerImageView2 = this.bigPreviewImage;
            if (roundCornerImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bigPreviewImage");
                roundCornerImageView2 = null;
            }
            roundCornerImageView2.setImageBitmap(this.bigPreviewBitmap);
        }
        if (map == null || (str = map.get(AECameraConstants.AE_MULTI_CAMERA_SMALL_PATH)) == null) {
            return;
        }
        this.smallPreviewBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), str, 1);
        RoundCornerImageView roundCornerImageView3 = this.smallPreviewToImage;
        if (roundCornerImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallPreviewToImage");
            roundCornerImageView3 = null;
        }
        roundCornerImageView3.setImageBitmap(this.smallPreviewBitmap);
        RoundCornerImageView roundCornerImageView4 = this.smallPreviewFromImage;
        if (roundCornerImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallPreviewFromImage");
            roundCornerImageView4 = null;
        }
        roundCornerImageView4.setImageBitmap(this.smallPreviewBitmap);
        RoundCornerImageView roundCornerImageView5 = this.smallPreviewToImage;
        if (roundCornerImageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallPreviewToImage");
            roundCornerImageView5 = null;
        }
        roundCornerImageView5.setVisibility(4);
        G(0);
        ax lsMultiCameraViewModel = q();
        Intrinsics.checkNotNullExpressionValue(lsMultiCameraViewModel, "lsMultiCameraViewModel");
        ax.i2(lsMultiCameraViewModel, true, null, 2, null);
        o.Companion companion = o.INSTANCE;
        RoundCornerImageView roundCornerImageView6 = this.smallPreviewFromImage;
        if (roundCornerImageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallPreviewFromImage");
            roundCornerImageView6 = null;
        }
        RoundCornerImageView roundCornerImageView7 = this.smallPreviewToImage;
        if (roundCornerImageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallPreviewToImage");
        } else {
            roundCornerImageView = roundCornerImageView7;
        }
        this.scaleAnimation = companion.e(roundCornerImageView6, roundCornerImageView, new Function0<Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraPreviewPart$onCameraPreviewUIShow$2$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VideoReport.traverseExposure();
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void z() {
        G(4);
        Bitmap bitmap = this.bigPreviewBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        Bitmap bitmap2 = this.smallPreviewBitmap;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        RoundCornerImageView roundCornerImageView = this.bigPreviewImage;
        RoundCornerImageView roundCornerImageView2 = null;
        if (roundCornerImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bigPreviewImage");
            roundCornerImageView = null;
        }
        roundCornerImageView.setVisibility(4);
        RoundCornerImageView roundCornerImageView3 = this.smallPreviewToImage;
        if (roundCornerImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallPreviewToImage");
        } else {
            roundCornerImageView2 = roundCornerImageView3;
        }
        roundCornerImageView2.setVisibility(4);
    }

    private final void G(int visible) {
        RoundCornerImageView roundCornerImageView = null;
        if (visible != 0) {
            Animation animation = this.scaleAnimation;
            if (animation != null) {
                animation.cancel();
            }
            this.scaleAnimation = null;
        }
        RelativeLayout relativeLayout = this.container;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            relativeLayout = null;
        }
        relativeLayout.setVisibility(visible);
        RoundCornerImageView roundCornerImageView2 = this.smallPreviewFromImage;
        if (roundCornerImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallPreviewFromImage");
            roundCornerImageView2 = null;
        }
        roundCornerImageView2.setVisibility(visible);
        RoundCornerImageView roundCornerImageView3 = this.bigPreviewImage;
        if (roundCornerImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bigPreviewImage");
        } else {
            roundCornerImageView = roundCornerImageView3;
        }
        roundCornerImageView.setVisibility(visible);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void x(int selectCamera) {
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void B() {
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void s() {
    }
}
