package com.tencent.biz.qqcircle.immersive.redpacket.part;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.RoundFrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b!\u0018\u0000 g2\u00020\u0001:\u0001hB\u0007\u00a2\u0006\u0004\be\u0010fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J \u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u001c\u0010\u001e\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010.\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010)R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00101R\u0016\u0010:\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u00105R\u0016\u0010<\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010%R\u0016\u0010?\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u001c\u0010C\u001a\n @*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u001c\u0010E\u001a\n @*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010BR\u001c\u0010G\u001a\n @*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010BR\u0016\u0010J\u001a\u00020H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010;R\u0016\u0010L\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010DR\u0016\u0010N\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010DR\u001c\u0010P\u001a\n @*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010BR\u001c\u0010R\u001a\n @*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010BR\u001c\u0010T\u001a\n @*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010BR\u001c\u0010V\u001a\n @*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010BR\u001c\u0010X\u001a\n @*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010BR\u001c\u0010Z\u001a\n @*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010BR\u001c\u0010\\\u001a\n @*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010BR\u001c\u0010^\u001a\n @*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010BR\u001c\u0010`\u001a\n @*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010BR\u001c\u0010b\u001a\n @*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010BR\u001c\u0010d\u001a\n @*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010B\u00a8\u0006i"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/part/aa;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "", "ra", "qa", "na", "", "Landroid/animation/ValueAnimator;", "animList", "", "reverse", "oa", "V9", "S9", "R9", "Q9", "Landroid/view/View;", "view", "", "newW", "newH", "T9", "W9", "U9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/biz/qqcircle/widgets/RoundFrameLayout;", "d", "Lcom/tencent/biz/qqcircle/widgets/RoundFrameLayout;", "redPacketContainer", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "videoContainer", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "ivRedPacketFgClose", tl.h.F, "ivRedPacketFgOpen", "i", "ivOpenIcon", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/LinearLayout;", "infoContainer", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "tvChangeVideo", "D", "clipActionContainer", "E", "tvClipAction", UserInfo.SEX_FEMALE, "changeStateContainer", "G", "Landroid/view/View;", "viewAnchor", "kotlin.jvm.PlatformType", "H", "Landroid/animation/ValueAnimator;", "openRedPacketContainerAlphaAnim", "I", "openOpenIconRotateAnim", "J", "openOpenIconAlphaAnim", "", "K", "redPacketContainerCurrentScale", "L", "redPacketContainerCurrentTransY", "M", "redPacketContainerCurrentAdditionHeight", "N", "openRedPacketContainerScaleAnim", "P", "openRedPacketContainerTranslateYAnim", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "openRedPacketContainerAdditionalHeightAnim", BdhLogUtil.LogTag.Tag_Req, "openRedPacketFgAlphaAnim", ExifInterface.LATITUDE_SOUTH, "openInfoContainerTranslateYAnim", "T", "openInfoContainerAlphaAnim", "U", "openTvChangeVideoTransYAnim", "V", "openTvChangeVideoAlphaAnim", "W", "openChangeStateContainerTransYAnim", "X", "openClipContainerTransYAnim", "Y", "openClipContainerAlphaAnim", "<init>", "()V", "Z", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class aa extends com.tencent.biz.qqcircle.bizparts.b {

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a0, reason: collision with root package name */
    private static final int f89441a0 = cx.a(262.0f);

    /* renamed from: b0, reason: collision with root package name */
    private static final int f89442b0 = cx.a(390.0f);

    /* renamed from: c0, reason: collision with root package name */
    private static final int f89443c0 = cx.a(324.0f);

    /* renamed from: d0, reason: collision with root package name */
    private static final int f89444d0 = cx.a(94.0f);

    /* renamed from: e0, reason: collision with root package name */
    private static final int f89445e0 = cx.a(110.0f);

    /* renamed from: f0, reason: collision with root package name */
    private static final int f89446f0 = cx.a(62.0f);

    /* renamed from: g0, reason: collision with root package name */
    private static final int f89447g0 = cx.a(55.0f);

    /* renamed from: h0, reason: collision with root package name */
    private static final int f89448h0 = cx.a(34.0f);

    /* renamed from: i0, reason: collision with root package name */
    private static final int f89449i0 = cx.a(80.0f);

    /* renamed from: j0, reason: collision with root package name */
    private static final int f89450j0 = cx.a(28.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private TextView tvChangeVideo;

    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayout clipActionContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView tvClipAction;

    /* renamed from: F, reason: from kotlin metadata */
    private FrameLayout changeStateContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private View viewAnchor;

    /* renamed from: H, reason: from kotlin metadata */
    private final ValueAnimator openRedPacketContainerAlphaAnim;

    /* renamed from: I, reason: from kotlin metadata */
    private final ValueAnimator openOpenIconRotateAnim;

    /* renamed from: J, reason: from kotlin metadata */
    private final ValueAnimator openOpenIconAlphaAnim;

    /* renamed from: K, reason: from kotlin metadata */
    private float redPacketContainerCurrentScale;

    /* renamed from: L, reason: from kotlin metadata */
    private int redPacketContainerCurrentTransY;

    /* renamed from: M, reason: from kotlin metadata */
    private int redPacketContainerCurrentAdditionHeight;

    /* renamed from: N, reason: from kotlin metadata */
    private final ValueAnimator openRedPacketContainerScaleAnim;

    /* renamed from: P, reason: from kotlin metadata */
    private final ValueAnimator openRedPacketContainerTranslateYAnim;

    /* renamed from: Q, reason: from kotlin metadata */
    private final ValueAnimator openRedPacketContainerAdditionalHeightAnim;

    /* renamed from: R, reason: from kotlin metadata */
    private final ValueAnimator openRedPacketFgAlphaAnim;

    /* renamed from: S, reason: from kotlin metadata */
    private final ValueAnimator openInfoContainerTranslateYAnim;

    /* renamed from: T, reason: from kotlin metadata */
    private final ValueAnimator openInfoContainerAlphaAnim;

    /* renamed from: U, reason: from kotlin metadata */
    private final ValueAnimator openTvChangeVideoTransYAnim;

    /* renamed from: V, reason: from kotlin metadata */
    private final ValueAnimator openTvChangeVideoAlphaAnim;

    /* renamed from: W, reason: from kotlin metadata */
    private final ValueAnimator openChangeStateContainerTransYAnim;

    /* renamed from: X, reason: from kotlin metadata */
    private final ValueAnimator openClipContainerTransYAnim;

    /* renamed from: Y, reason: from kotlin metadata */
    private final ValueAnimator openClipContainerAlphaAnim;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RoundFrameLayout redPacketContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout videoContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView ivRedPacketFgClose;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView ivRedPacketFgOpen;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView ivOpenIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LinearLayout infoContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\tR\u0014\u0010\u0012\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\tR\u0014\u0010\u0013\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\tR\u0014\u0010\u0015\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\tR\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\tR\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/part/aa$a;", "", "Landroid/view/animation/Interpolator;", "kotlin.jvm.PlatformType", "b", "()Landroid/view/animation/Interpolator;", "INTERCEPTOR", "", "CHANGE_STATE_CONTAINER_TRANSLATE_Y", "I", "CLIP_CONTAINER_TRANSLATE_Y", "", "DELAY_1280", "J", "DELAY_200", "INFO_CONTAINER_TRANSLATE_Y", "ORIGINAL_HEIGHT", "ORIGINAL_MARGIN_TOP", "ORIGINAL_RED_PACKET_HEIGHT", "ORIGINAL_VIDEO_CONTAINER_HEIGHT", "ORIGINAL_WIDTH", "RED_PACKET_CONTAINER_HEIGHT_ADDITIONAL", "", "RED_PACKET_CONTAINER_SCALE_FACTOR", UserInfo.SEX_FEMALE, "RED_PACKET_CONTAINER_TRANSLATE_Y", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.redpacket.part.aa$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Interpolator b() {
            return PathInterpolatorCompat.create(0.47f, 0.0f, 0.53f, 1.0f);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/redpacket/part/aa$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "", "isReverse", "onAnimationEnd", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation, boolean isReverse) {
            QLog.d("QFSRedPacketPreviewAnimPart", 1, "openClipContainerAlphaAnim, onAnimationEnd, isReverse:" + isReverse);
            TextView textView = aa.this.tvClipAction;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvClipAction");
                textView = null;
            }
            textView.setClickable(isReverse);
            if (isReverse) {
                View view = aa.this.viewAnchor;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewAnchor");
                    view = null;
                }
                View view2 = aa.this.viewAnchor;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewAnchor");
                    view2 = null;
                }
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                aa aaVar = aa.this;
                TextView textView3 = aaVar.tvClipAction;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvClipAction");
                    textView3 = null;
                }
                int y16 = (int) textView3.getY();
                TextView textView4 = aaVar.tvClipAction;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvClipAction");
                } else {
                    textView2 = textView4;
                }
                layoutParams.height = y16 + textView2.getMeasuredHeight();
                view.setLayoutParams(layoutParams);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            QLog.d("QFSRedPacketPreviewAnimPart", 1, "openClipContainerAlphaAnim, onAnimationStart ");
            TextView textView = aa.this.tvClipAction;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvClipAction");
                textView = null;
            }
            textView.setClickable(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/redpacket/part/aa$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "", "isReverse", "onAnimationEnd", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation, boolean isReverse) {
            QLog.d("QFSRedPacketPreviewAnimPart", 1, "openTvChangeVideoAlphaAnim, onAnimationEnd, isReverse:" + isReverse);
            TextView textView = aa.this.tvChangeVideo;
            RoundFrameLayout roundFrameLayout = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvChangeVideo");
                textView = null;
            }
            textView.setClickable(!isReverse);
            if (!isReverse) {
                View view = aa.this.viewAnchor;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewAnchor");
                    view = null;
                }
                View view2 = aa.this.viewAnchor;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewAnchor");
                    view2 = null;
                }
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                aa aaVar = aa.this;
                TextView textView2 = aaVar.tvChangeVideo;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvChangeVideo");
                    textView2 = null;
                }
                int y16 = (int) textView2.getY();
                TextView textView3 = aaVar.tvChangeVideo;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvChangeVideo");
                    textView3 = null;
                }
                int measuredHeight = y16 + textView3.getMeasuredHeight();
                RoundFrameLayout roundFrameLayout2 = aaVar.redPacketContainer;
                if (roundFrameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("redPacketContainer");
                } else {
                    roundFrameLayout = roundFrameLayout2;
                }
                layoutParams.height = measuredHeight + ((int) roundFrameLayout.getY());
                view.setLayoutParams(layoutParams);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            QLog.d("QFSRedPacketPreviewAnimPart", 1, "openTvChangeVideoAlphaAnim, onAnimationStart ");
            TextView textView = aa.this.tvChangeVideo;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvChangeVideo");
                textView = null;
            }
            textView.setClickable(false);
        }
    }

    public aa() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.m
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                aa.ga(aa.this, valueAnimator);
            }
        });
        this.openRedPacketContainerAlphaAnim = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, -360.0f);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.v
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                aa.da(aa.this, valueAnimator);
            }
        });
        this.openOpenIconRotateAnim = ofFloat2;
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(new LinearInterpolator());
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.w
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                aa.ca(aa.this, valueAnimator);
            }
        });
        this.openOpenIconAlphaAnim = ofFloat3;
        this.redPacketContainerCurrentScale = 1.0f;
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(1.0f, 1.15f);
        Companion companion = INSTANCE;
        ofFloat4.setInterpolator(companion.b());
        ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.x
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                aa.ha(aa.this, valueAnimator);
            }
        });
        this.openRedPacketContainerScaleAnim = ofFloat4;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, f89447g0);
        ofInt.setInterpolator(companion.b());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.y
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                aa.ia(aa.this, valueAnimator);
            }
        });
        this.openRedPacketContainerTranslateYAnim = ofInt;
        ValueAnimator ofInt2 = ValueAnimator.ofInt(0, f89446f0);
        ofInt2.setInterpolator(new LinearInterpolator());
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.z
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                aa.ea(aa.this, valueAnimator);
            }
        });
        this.openRedPacketContainerAdditionalHeightAnim = ofInt2;
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat5.setInterpolator(new LinearInterpolator());
        ofFloat5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.n
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                aa.ja(aa.this, valueAnimator);
            }
        });
        this.openRedPacketFgAlphaAnim = ofFloat5;
        ValueAnimator ofInt3 = ValueAnimator.ofInt(-f89448h0, 0);
        ofInt3.setInterpolator(companion.b());
        ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.o
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                aa.ba(aa.this, valueAnimator);
            }
        });
        this.openInfoContainerTranslateYAnim = ofInt3;
        ValueAnimator ofFloat6 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat6.setInterpolator(new LinearInterpolator());
        ofFloat6.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.p
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                aa.aa(aa.this, valueAnimator);
            }
        });
        this.openInfoContainerAlphaAnim = ofFloat6;
        int i3 = f89449i0;
        ValueAnimator ofInt4 = ValueAnimator.ofInt(i3, 0);
        ofInt4.setInterpolator(companion.b());
        ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.q
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                aa.ma(aa.this, valueAnimator);
            }
        });
        this.openTvChangeVideoTransYAnim = ofInt4;
        ValueAnimator ofFloat7 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat7.setInterpolator(new LinearInterpolator());
        ofFloat7.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.r
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                aa.la(aa.this, valueAnimator);
            }
        });
        ofFloat7.addListener(new c());
        this.openTvChangeVideoAlphaAnim = ofFloat7;
        ValueAnimator ofInt5 = ValueAnimator.ofInt(i3, 0);
        ofInt5.setInterpolator(companion.b());
        ofInt5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.s
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                aa.X9(aa.this, valueAnimator);
            }
        });
        this.openChangeStateContainerTransYAnim = ofInt5;
        ValueAnimator ofInt6 = ValueAnimator.ofInt(0, f89450j0);
        ofInt6.setInterpolator(companion.b());
        ofInt6.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.t
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                aa.Z9(aa.this, valueAnimator);
            }
        });
        this.openClipContainerTransYAnim = ofInt6;
        ValueAnimator ofFloat8 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat8.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.u
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                aa.Y9(aa.this, valueAnimator);
            }
        });
        ofFloat8.addListener(new b());
        this.openClipContainerAlphaAnim = ofFloat8;
    }

    private final void Q9() {
        ImageView imageView = this.ivRedPacketFgClose;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivRedPacketFgClose");
            imageView = null;
        }
        int i3 = f89441a0;
        float f16 = this.redPacketContainerCurrentScale;
        int i16 = f89445e0;
        T9(imageView, (int) (i3 * f16), ((int) (i16 * f16)) + this.redPacketContainerCurrentAdditionHeight);
        ImageView imageView3 = this.ivRedPacketFgOpen;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivRedPacketFgOpen");
        } else {
            imageView2 = imageView3;
        }
        float f17 = i3;
        float f18 = this.redPacketContainerCurrentScale;
        T9(imageView2, (int) (f17 * f18), ((int) (i16 * f18)) + this.redPacketContainerCurrentAdditionHeight);
    }

    private final void R9() {
        RoundFrameLayout roundFrameLayout = this.redPacketContainer;
        RoundFrameLayout roundFrameLayout2 = null;
        if (roundFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redPacketContainer");
            roundFrameLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = roundFrameLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        float f16 = f89441a0;
        float f17 = this.redPacketContainerCurrentScale;
        layoutParams2.width = (int) (f16 * f17);
        int i3 = f89442b0;
        layoutParams2.height = (int) ((i3 * f17) + this.redPacketContainerCurrentAdditionHeight);
        layoutParams2.topMargin = (int) ((f89444d0 - ((i3 * (f17 - 1)) / 2)) - this.redPacketContainerCurrentTransY);
        RoundFrameLayout roundFrameLayout3 = this.redPacketContainer;
        if (roundFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redPacketContainer");
        } else {
            roundFrameLayout2 = roundFrameLayout3;
        }
        roundFrameLayout2.setLayoutParams(layoutParams2);
    }

    private final void S9() {
        FrameLayout frameLayout = this.videoContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
            frameLayout = null;
        }
        float f16 = f89441a0;
        float f17 = this.redPacketContainerCurrentScale;
        T9(frameLayout, (int) (f16 * f17), (int) (f89443c0 * f17));
    }

    private final void T9(View view, int newW, int newH) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.width = newW;
        marginLayoutParams.height = newH;
        view.setLayoutParams(marginLayoutParams);
    }

    private final void U9() {
        R9();
        Q9();
    }

    private final void V9() {
        R9();
        S9();
        Q9();
    }

    private final void W9() {
        R9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(aa this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        FrameLayout frameLayout = this$0.changeStateContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeStateContainer");
            frameLayout = null;
        }
        frameLayout.setTranslationY(intValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(aa this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        LinearLayout linearLayout = this$0.clipActionContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clipActionContainer");
            linearLayout = null;
        }
        linearLayout.setAlpha(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(aa this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        LinearLayout linearLayout = this$0.clipActionContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clipActionContainer");
            linearLayout = null;
        }
        linearLayout.setTranslationY(intValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(aa this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        LinearLayout linearLayout = this$0.infoContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoContainer");
            linearLayout = null;
        }
        linearLayout.setAlpha(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(aa this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        LinearLayout linearLayout = this$0.infoContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoContainer");
            linearLayout = null;
        }
        linearLayout.setTranslationY(intValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(aa this$0, ValueAnimator valueAnimator) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        ImageView imageView2 = this$0.ivOpenIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivOpenIcon");
            imageView2 = null;
        }
        imageView2.setAlpha(floatValue);
        if (floatValue <= 0.0f) {
            QLog.d("QFSRedPacketPreviewAnimPart", 1, "openOpenIconAlphaAnim, show front icon ");
            com.tencent.biz.qqcircle.immersive.redpacket.util.a aVar = com.tencent.biz.qqcircle.immersive.redpacket.util.a.f89583a;
            ImageView imageView3 = this$0.ivOpenIcon;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivOpenIcon");
                imageView = null;
            } else {
                imageView = imageView3;
            }
            com.tencent.biz.qqcircle.immersive.redpacket.util.a.b(aVar, imageView, "qvideo_hongbao_icon_open_front", false, false, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(aa this$0, ValueAnimator valueAnimator) {
        Boolean bool;
        boolean z16;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        ImageView imageView2 = this$0.ivOpenIcon;
        ImageView imageView3 = null;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivOpenIcon");
            imageView2 = null;
        }
        Object tag = imageView2.getTag();
        if (tag instanceof Boolean) {
            bool = (Boolean) tag;
        } else {
            bool = null;
        }
        if (bool != null) {
            z16 = bool.booleanValue();
        } else {
            z16 = false;
        }
        if (!z16 && floatValue <= -90.0f) {
            QLog.d("QFSRedPacketPreviewAnimPart", 1, "openOpenIconRotateAnim, show back icon ");
            ImageView imageView4 = this$0.ivOpenIcon;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivOpenIcon");
                imageView4 = null;
            }
            imageView4.setTag(Boolean.TRUE);
            com.tencent.biz.qqcircle.immersive.redpacket.util.a aVar = com.tencent.biz.qqcircle.immersive.redpacket.util.a.f89583a;
            ImageView imageView5 = this$0.ivOpenIcon;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivOpenIcon");
                imageView = null;
            } else {
                imageView = imageView5;
            }
            com.tencent.biz.qqcircle.immersive.redpacket.util.a.b(aVar, imageView, "qvideo_hongbao_icon_open_back", false, false, 12, null);
        }
        ImageView imageView6 = this$0.ivOpenIcon;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivOpenIcon");
        } else {
            imageView3 = imageView6;
        }
        imageView3.setRotationY(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(aa this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.redPacketContainerCurrentAdditionHeight = ((Integer) animatedValue).intValue();
        this$0.U9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(aa this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        RoundFrameLayout roundFrameLayout = this$0.redPacketContainer;
        if (roundFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redPacketContainer");
            roundFrameLayout = null;
        }
        roundFrameLayout.setAlpha(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(aa this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.redPacketContainerCurrentScale = ((Float) animatedValue).floatValue();
        this$0.V9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(aa this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.redPacketContainerCurrentTransY = ((Integer) animatedValue).intValue();
        this$0.W9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(aa this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        ImageView imageView = this$0.ivRedPacketFgClose;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivRedPacketFgClose");
            imageView = null;
        }
        imageView.setAlpha(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(aa this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        TextView textView = this$0.tvChangeVideo;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvChangeVideo");
            textView = null;
        }
        textView.setAlpha(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(aa this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        TextView textView = this$0.tvChangeVideo;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvChangeVideo");
            textView = null;
        }
        textView.setTranslationY(intValue);
    }

    private final void na() {
        List listOf;
        ValueAnimator valueAnimator = this.openOpenIconAlphaAnim;
        valueAnimator.setDuration(0L);
        valueAnimator.setStartDelay(0L);
        Unit unit = Unit.INSTANCE;
        ValueAnimator valueAnimator2 = this.openRedPacketContainerScaleAnim;
        valueAnimator2.setDuration(0L);
        valueAnimator2.setStartDelay(0L);
        ValueAnimator valueAnimator3 = this.openRedPacketContainerTranslateYAnim;
        valueAnimator3.setDuration(0L);
        valueAnimator3.setStartDelay(0L);
        ValueAnimator valueAnimator4 = this.openRedPacketContainerAdditionalHeightAnim;
        valueAnimator4.setDuration(0L);
        valueAnimator4.setStartDelay(0L);
        ValueAnimator valueAnimator5 = this.openRedPacketFgAlphaAnim;
        valueAnimator5.setDuration(0L);
        valueAnimator5.setStartDelay(0L);
        ValueAnimator valueAnimator6 = this.openInfoContainerTranslateYAnim;
        valueAnimator6.setDuration(0L);
        valueAnimator6.setStartDelay(0L);
        ValueAnimator valueAnimator7 = this.openInfoContainerAlphaAnim;
        valueAnimator7.setDuration(0L);
        valueAnimator7.setStartDelay(0L);
        ValueAnimator valueAnimator8 = this.openTvChangeVideoAlphaAnim;
        valueAnimator8.setDuration(0L);
        valueAnimator8.setStartDelay(0L);
        ValueAnimator valueAnimator9 = this.openTvChangeVideoTransYAnim;
        valueAnimator9.setDuration(0L);
        valueAnimator9.setStartDelay(0L);
        ValueAnimator valueAnimator10 = this.openClipContainerTransYAnim;
        valueAnimator10.setDuration(0L);
        valueAnimator10.setStartDelay(0L);
        ValueAnimator valueAnimator11 = this.openClipContainerAlphaAnim;
        valueAnimator11.setDuration(0L);
        valueAnimator11.setStartDelay(0L);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ValueAnimator[]{valueAnimator, valueAnimator2, valueAnimator3, valueAnimator4, valueAnimator5, valueAnimator6, valueAnimator7, valueAnimator8, valueAnimator9, valueAnimator10, valueAnimator11});
        pa(this, listOf, false, 2, null);
    }

    private final void oa(List<? extends ValueAnimator> animList, boolean reverse) {
        for (ValueAnimator valueAnimator : animList) {
            if (reverse) {
                valueAnimator.reverse();
            } else {
                valueAnimator.start();
            }
        }
    }

    static /* synthetic */ void pa(aa aaVar, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        aaVar.oa(list, z16);
    }

    private final void qa() {
        List<? extends ValueAnimator> listOf;
        ValueAnimator valueAnimator = this.openOpenIconAlphaAnim;
        valueAnimator.setDuration(200L);
        valueAnimator.setStartDelay(480L);
        Unit unit = Unit.INSTANCE;
        ValueAnimator valueAnimator2 = this.openRedPacketContainerScaleAnim;
        valueAnimator2.setDuration(400L);
        valueAnimator2.setStartDelay(80L);
        ValueAnimator valueAnimator3 = this.openRedPacketContainerTranslateYAnim;
        valueAnimator3.setDuration(360L);
        valueAnimator3.setStartDelay(120L);
        ValueAnimator valueAnimator4 = this.openRedPacketContainerAdditionalHeightAnim;
        valueAnimator4.setDuration(240L);
        valueAnimator4.setStartDelay(80L);
        ValueAnimator valueAnimator5 = this.openRedPacketFgAlphaAnim;
        valueAnimator5.setDuration(360L);
        valueAnimator5.setStartDelay(120L);
        ValueAnimator valueAnimator6 = this.openInfoContainerTranslateYAnim;
        valueAnimator6.setDuration(400L);
        ValueAnimator valueAnimator7 = this.openInfoContainerAlphaAnim;
        valueAnimator7.setDuration(200L);
        valueAnimator7.setStartDelay(120L);
        ValueAnimator valueAnimator8 = this.openTvChangeVideoAlphaAnim;
        valueAnimator8.setDuration(0L);
        ValueAnimator valueAnimator9 = this.openTvChangeVideoTransYAnim;
        valueAnimator9.setDuration(0L);
        ValueAnimator valueAnimator10 = this.openClipContainerTransYAnim;
        valueAnimator10.setDuration(240L);
        valueAnimator10.setStartDelay(240L);
        ValueAnimator valueAnimator11 = this.openClipContainerAlphaAnim;
        valueAnimator11.setDuration(0L);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ValueAnimator[]{valueAnimator, valueAnimator2, valueAnimator3, valueAnimator4, valueAnimator5, valueAnimator6, valueAnimator7, valueAnimator8, valueAnimator9, valueAnimator10, valueAnimator11});
        oa(listOf, true);
    }

    private final void ra() {
        List listOf;
        ValueAnimator valueAnimator = this.openRedPacketContainerAlphaAnim;
        valueAnimator.setDuration(200L);
        Unit unit = Unit.INSTANCE;
        ValueAnimator valueAnimator2 = this.openOpenIconRotateAnim;
        valueAnimator2.setDuration(1080L);
        valueAnimator2.setStartDelay(200L);
        ValueAnimator valueAnimator3 = this.openOpenIconAlphaAnim;
        valueAnimator3.setDuration(200L);
        valueAnimator3.setStartDelay(1280L);
        ValueAnimator valueAnimator4 = this.openRedPacketContainerScaleAnim;
        valueAnimator4.setDuration(400L);
        valueAnimator4.setStartDelay(1400L);
        ValueAnimator valueAnimator5 = this.openRedPacketContainerTranslateYAnim;
        valueAnimator5.setDuration(360L);
        valueAnimator5.setStartDelay(1280L);
        ValueAnimator valueAnimator6 = this.openRedPacketContainerAdditionalHeightAnim;
        valueAnimator6.setDuration(240L);
        valueAnimator6.setStartDelay(1400L);
        ValueAnimator valueAnimator7 = this.openRedPacketFgAlphaAnim;
        valueAnimator7.setDuration(240L);
        valueAnimator7.setStartDelay(1400L);
        ValueAnimator valueAnimator8 = this.openInfoContainerTranslateYAnim;
        valueAnimator8.setDuration(360L);
        valueAnimator8.setStartDelay(1280L);
        ValueAnimator valueAnimator9 = this.openInfoContainerAlphaAnim;
        valueAnimator9.setDuration(200L);
        valueAnimator9.setStartDelay(1440L);
        ValueAnimator valueAnimator10 = this.openTvChangeVideoAlphaAnim;
        valueAnimator10.setDuration(240L);
        valueAnimator10.setStartDelay(1560L);
        ValueAnimator valueAnimator11 = this.openTvChangeVideoTransYAnim;
        valueAnimator11.setDuration(240L);
        valueAnimator11.setStartDelay(1560L);
        ValueAnimator valueAnimator12 = this.openChangeStateContainerTransYAnim;
        valueAnimator12.setDuration(240L);
        valueAnimator12.setStartDelay(1560L);
        ValueAnimator valueAnimator13 = this.openClipContainerTransYAnim;
        valueAnimator13.setDuration(0L);
        ValueAnimator valueAnimator14 = this.openClipContainerAlphaAnim;
        valueAnimator14.setDuration(0L);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ValueAnimator[]{valueAnimator, valueAnimator2, valueAnimator3, valueAnimator4, valueAnimator5, valueAnimator6, valueAnimator7, valueAnimator8, valueAnimator9, valueAnimator10, valueAnimator11, valueAnimator12, valueAnimator13, valueAnimator14});
        pa(this, listOf, false, 2, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -655798937) {
                if (hashCode != 340539159) {
                    if (hashCode == 1646589873 && action.equals("EVENT_START_CLOSE_RED_PACKET_ANIM")) {
                        qa();
                        return;
                    }
                    return;
                }
                if (action.equals("EVENT_REST_OPEN_RED_PACKET_STATE")) {
                    na();
                    return;
                }
                return;
            }
            if (action.equals("EVENT_START_OPEN_RED_PACKET_ANIM")) {
                ra();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.v8l);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.fl_red_packet_container)");
        this.redPacketContainer = (RoundFrameLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.li7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.fl_video_container)");
        this.videoContainer = (FrameLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.y7z);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.iv_red_packet_fg_close)");
        this.ivRedPacketFgClose = (ImageView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f165960y80);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.iv_red_packet_fg_open)");
        this.ivRedPacketFgOpen = (ImageView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.y6m);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.iv_open_icon)");
        this.ivOpenIcon = (ImageView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.yoq);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.ll_info_container)");
        this.infoContainer = (LinearLayout) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f10661697);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.tv_change_video_action)");
        this.tvChangeVideo = (TextView) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.v7n);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.fl_clip_action_container)");
        this.clipActionContainer = (LinearLayout) findViewById8;
        View findViewById9 = rootView.findViewById(R.id.f1068169q);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.tv_clip_action)");
        this.tvClipAction = (TextView) findViewById9;
        View findViewById10 = rootView.findViewById(R.id.v7m);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.fl_change_state_container)");
        this.changeStateContainer = (FrameLayout) findViewById10;
        View findViewById11 = rootView.findViewById(R.id.spf);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.anchor_view)");
        this.viewAnchor = findViewById11;
    }
}
