package com.tencent.mobileqq.qqvideoedit.editor.crop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqvideoedit.editor.crop.VideoEditorCropFragment;
import com.tencent.mobileqq.qqvideoedit.editor.crop.VideoEditorCropMaskView;
import com.tencent.mobileqq.qqvideoedit.editor.crop.VideoEditorTransformTextureView;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ResourceModel;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vj2.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u000b*\u0004\u008f\u0001\u0095\u0001\u0018\u0000 \u009b\u00012\u00020\u0001:\u0006\u009c\u0001\u009d\u0001\u009e\u0001B\t\u00a2\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0003J\b\u0010\t\u001a\u00020\u0002H\u0002J$\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J$\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0002J\u0014\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020%0$H\u0002J\b\u0010(\u001a\u00020'H\u0014J\b\u0010)\u001a\u00020'H\u0014J\b\u0010*\u001a\u00020\fH\u0014J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\b\u0010.\u001a\u00020\u001fH\u0014J\u001a\u00102\u001a\u00020\u00022\u0006\u0010/\u001a\u00020!2\b\u00101\u001a\u0004\u0018\u000100H\u0016J\b\u00103\u001a\u00020\u0002H\u0016R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010>R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010KR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010KR\u0016\u0010V\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010KR\u0016\u0010X\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010AR\u0016\u0010Z\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010AR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u001b\u0010l\u001a\u00020g8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u001d\u0010q\u001a\u0004\u0018\u00010m8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bn\u0010i\u001a\u0004\bo\u0010pR\u001b\u0010v\u001a\u00020r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bs\u0010i\u001a\u0004\bt\u0010uR\u001b\u0010{\u001a\u00020w8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bx\u0010i\u001a\u0004\by\u0010zR%\u0010\u0081\u0001\u001a\n }*\u0004\u0018\u00010|0|8BX\u0082\u0084\u0002\u00a2\u0006\r\n\u0004\b~\u0010i\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0019\u0010\u0084\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0019\u0010\u0085\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0083\u0001R\u0019\u0010\u0087\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0083\u0001R\u001c\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0019\u0010\u008e\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0018\u0010\u0092\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0018\u0010\u0098\u0001\u001a\u00030\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u00a8\u0006\u009f\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "", "Yh", "Landroid/view/Surface;", "playerSurface", "ei", "initData", "Zh", "ci", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$RatioType;", "newType", "", "opposite", "isManual", "gi", "ratioType", "ni", "Xh", "di", "type", "reverse", "oi", "Oh", "reset", "Ph", "Landroid/graphics/Matrix;", "matrix1", "matrix2", "fi", "Wh", "", "getPageId", "Landroid/view/View;", "contentView", "registerDaTongReportPageId", "", "", "Rh", "", "getStatusBarColor", "getContentLayoutId", "needAdjustImmersive", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getLogTag", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropView;", "mCropView", "Landroid/widget/LinearLayout;", "D", "Landroid/widget/LinearLayout;", "mCropRatioView", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "mRotateBtn", UserInfo.SEX_FEMALE, "Landroid/view/View;", "mRatioMenu", "G", "mRatioMenuBtn", "Landroid/widget/FrameLayout;", "H", "Landroid/widget/FrameLayout;", "mCropMenu", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "mResetBtn", "J", "mCropSize", "Landroid/widget/SeekBar;", "K", "Landroid/widget/SeekBar;", "seekBarVideoProgress", "L", "tvScaleTips", "M", "tvPastTime", "N", "btnCancel", "P", "btnConfirm", "Landroid/view/GestureDetector;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/GestureDetector;", "mGestureDetector", "Lcom/tencent/tavcut/render/player/IPlayer;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/tavcut/render/player/IPlayer;", "iPlayer", "Lcom/tencent/tavcut/session/a;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/tavcut/session/a;", "iCutSession", "Ljava/text/SimpleDateFormat;", "T", "Lkotlin/Lazy;", "Vh", "()Ljava/text/SimpleDateFormat;", "timeFormat", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "U", "Sh", "()Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "mediaClip", "Lvj2/a;", "V", "Qh", "()Lvj2/a;", "cropViewModel", "", "W", "Uh", "()J", "startTimeOffset", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "kotlin.jvm.PlatformType", "X", "Th", "()Lcom/tencent/mobileqq/utils/QQCustomDialog;", "quitDialog", "Y", "Z", "isDirty", "isOriginReverse", "a0", "isRotate90", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$b;", "b0", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$b;", "cropRatioChangeListener", "c0", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$RatioType;", "selectRatioType", "com/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$j", "d0", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$j;", "playerListener", "e0", "Landroid/view/Surface;", "com/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$k", "f0", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$k;", "surfaceTextureListener", "<init>", "()V", "g0", "a", "b", "RatioType", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class VideoEditorCropFragment extends ImmersivePartFragment {

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h0, reason: collision with root package name */
    private static final int f275624h0 = com.tencent.videocut.utils.e.f384236a.a(20.0f);

    /* renamed from: i0, reason: collision with root package name */
    @NotNull
    private static final RatioType f275625i0 = RatioType.FreeRatio;

    /* renamed from: C, reason: from kotlin metadata */
    private VideoEditorCropView mCropView;

    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayout mCropRatioView;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView mRotateBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private View mRatioMenu;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView mRatioMenuBtn;

    /* renamed from: H, reason: from kotlin metadata */
    private FrameLayout mCropMenu;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView mResetBtn;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView mCropSize;

    /* renamed from: K, reason: from kotlin metadata */
    private SeekBar seekBarVideoProgress;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView tvScaleTips;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView tvPastTime;

    /* renamed from: N, reason: from kotlin metadata */
    private View btnCancel;

    /* renamed from: P, reason: from kotlin metadata */
    private View btnConfirm;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final GestureDetector mGestureDetector = new GestureDetector(getContext(), new i());

    /* renamed from: R, reason: from kotlin metadata */
    private IPlayer iPlayer;

    /* renamed from: S, reason: from kotlin metadata */
    private com.tencent.tavcut.session.a iCutSession;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy timeFormat;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy mediaClip;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy cropViewModel;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Lazy startTimeOffset;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Lazy quitDialog;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean isDirty;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean isOriginReverse;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean isRotate90;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b cropRatioChangeListener;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RatioType selectRatioType;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j playerListener;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Surface playerSurface;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k surfaceTextureListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0000j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$RatioType;", "", "(Ljava/lang/String;I)V", "getOppositeRatioType", "Origin", "FreeRatio", "Ratio1to1", "Ratio9to16", "Ratio16to9", "Ratio3to4", "Ratio4to3", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public enum RatioType {
        Origin,
        FreeRatio,
        Ratio1to1,
        Ratio9to16,
        Ratio16to9,
        Ratio3to4,
        Ratio4to3;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes17.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f275632a;

            static {
                int[] iArr = new int[RatioType.values().length];
                try {
                    iArr[RatioType.Origin.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RatioType.Ratio1to1.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RatioType.Ratio9to16.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[RatioType.Ratio16to9.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[RatioType.Ratio3to4.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[RatioType.Ratio4to3.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[RatioType.FreeRatio.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f275632a = iArr;
            }
        }

        @NotNull
        public final RatioType getOppositeRatioType() {
            switch (a.f275632a[ordinal()]) {
                case 1:
                    return Origin;
                case 2:
                    return Ratio1to1;
                case 3:
                    return Ratio16to9;
                case 4:
                    return Ratio9to16;
                case 5:
                    return Ratio4to3;
                case 6:
                    return Ratio3to4;
                case 7:
                    return FreeRatio;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$a;", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "mediaClip", "", "startTimeOffset", "", "isFromEditor", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment;", "a", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$RatioType;", "DEFAULT_RATIO_TYPE", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$RatioType;", "", "DEFAULT_SCALE", UserInfo.SEX_FEMALE, "", "DRAG_DOWN_THRESHOLD", "I", "", "KEY_IS_FROM_EDITOR", "Ljava/lang/String;", "KEY_MEDIA_CLIP", "KEY_START_TIME", "SEEK_BAR_THRESHOLD", "J", "TAG", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqvideoedit.editor.crop.VideoEditorCropFragment$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VideoEditorCropFragment a(@NotNull MediaClip mediaClip, long startTimeOffset, boolean isFromEditor) {
            Intrinsics.checkNotNullParameter(mediaClip, "mediaClip");
            VideoEditorCropFragment videoEditorCropFragment = new VideoEditorCropFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_media_clip", mediaClip);
            bundle.putBoolean("key_is_from_editor", isFromEditor);
            bundle.putLong("key_start_time", startTimeOffset);
            videoEditorCropFragment.setArguments(bundle);
            return videoEditorCropFragment;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$b;", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$RatioType;", "type", "", "opposite", "isManual", "", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        void a(@NotNull RatioType type, boolean opposite, boolean isManual);
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f275633a;

        static {
            int[] iArr = new int[RatioType.values().length];
            try {
                iArr[RatioType.FreeRatio.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RatioType.Ratio1to1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RatioType.Ratio9to16.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RatioType.Ratio16to9.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RatioType.Ratio3to4.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RatioType.Ratio4to3.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f275633a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$d", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropMaskView$b;", "Landroid/graphics/RectF;", CanvasView.ACTION_RECT, "", "a", "", NodeProps.VISIBLE, "b", "", "Ljava/lang/String;", "getSizeTemplate", "()Ljava/lang/String;", "sizeTemplate", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements VideoEditorCropMaskView.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String sizeTemplate;

        d() {
            String string = VideoEditorCropFragment.this.getString(R.string.f237947if);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.video\u2026itor_crop_width_x_height)");
            this.sizeTemplate = string;
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.crop.VideoEditorCropMaskView.b
        public void a(@NotNull RectF rect) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            TextView textView = VideoEditorCropFragment.this.mCropSize;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCropSize");
                textView = null;
            }
            String str = this.sizeTemplate;
            com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
            String format = String.format(str, Arrays.copyOf(new Object[]{String.valueOf((int) eVar.b(rect.width())), String.valueOf((int) eVar.b(rect.height()))}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            textView.setText(format);
            TextView textView3 = VideoEditorCropFragment.this.mCropSize;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCropSize");
                textView3 = null;
            }
            ViewGroup.LayoutParams layoutParams = textView3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            VideoEditorCropFragment videoEditorCropFragment = VideoEditorCropFragment.this;
            int i3 = ((int) rect.left) + ((int) rect.right);
            TextView textView4 = videoEditorCropFragment.mCropSize;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCropSize");
                textView4 = null;
            }
            marginLayoutParams.leftMargin = (i3 - textView4.getWidth()) / 2;
            int i16 = ((int) rect.top) + ((int) rect.bottom);
            TextView textView5 = videoEditorCropFragment.mCropSize;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCropSize");
            } else {
                textView2 = textView5;
            }
            marginLayoutParams.topMargin = (i16 - textView2.getHeight()) / 2;
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.crop.VideoEditorCropMaskView.b
        public void b(boolean visible) {
            TextView textView = null;
            if (visible) {
                TextView textView2 = VideoEditorCropFragment.this.mCropSize;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCropSize");
                    textView2 = null;
                }
                if (textView2.getVisibility() != 0) {
                    TextView textView3 = VideoEditorCropFragment.this.mCropSize;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCropSize");
                    } else {
                        textView = textView3;
                    }
                    textView.setVisibility(0);
                    return;
                }
                return;
            }
            TextView textView4 = VideoEditorCropFragment.this.mCropSize;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCropSize");
                textView4 = null;
            }
            if (textView4.getVisibility() != 8) {
                TextView textView5 = VideoEditorCropFragment.this.mCropSize;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCropSize");
                } else {
                    textView = textView5;
                }
                textView.setVisibility(8);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$e", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorTransformTextureView$b;", "Landroid/graphics/Matrix;", "matrix", "", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class e implements VideoEditorTransformTextureView.b {
        e() {
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.crop.VideoEditorTransformTextureView.b
        public void a(@NotNull Matrix matrix) {
            Intrinsics.checkNotNullParameter(matrix, "matrix");
            VideoEditorCropFragment.this.Ph();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$f", "Lkotlin/Function0;", "", "a", "()Ljava/lang/Boolean;", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class f implements Function0<Boolean> {
        f() {
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke() {
            View view = VideoEditorCropFragment.this.mRatioMenu;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRatioMenu");
                view = null;
            }
            if (view.getVisibility() == 0) {
                VideoEditorCropFragment.this.Xh();
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$g", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$b;", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$RatioType;", "type", "", "opposite", "isManual", "", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class g implements b {
        g() {
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.crop.VideoEditorCropFragment.b
        public void a(@NotNull RatioType type, boolean opposite, boolean isManual) {
            Intrinsics.checkNotNullParameter(type, "type");
            VideoEditorCropFragment.this.oi(type, opposite, true);
            if (isManual) {
                VideoEditorCropView videoEditorCropView = VideoEditorCropFragment.this.mCropView;
                if (videoEditorCropView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCropView");
                    videoEditorCropView = null;
                }
                videoEditorCropView.getEditorGestureTextureView().H(1.0f);
            }
            VideoEditorCropFragment.this.Ph();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0016\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$h", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "", "onProgressChanged", "seekbar", "onStartTrackingTouch", "onStopTrackingTouch", "d", "Z", "isTouching", "", "e", "J", "lastSeekPos", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class h implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isTouching;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long lastSeekPos = -1;

        h() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@NotNull SeekBar seekBar, int progress, boolean fromUser) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            long j3 = progress;
            if (!this.isTouching) {
                return;
            }
            long j16 = this.lastSeekPos;
            if (j16 >= 0 && Math.abs(j3 - j16) < 33000) {
                return;
            }
            this.lastSeekPos = j3;
            IPlayer iPlayer = VideoEditorCropFragment.this.iPlayer;
            TextView textView = null;
            if (iPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("iPlayer");
                iPlayer = null;
            }
            iPlayer.seek(j3);
            TextView textView2 = VideoEditorCropFragment.this.tvPastTime;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvPastTime");
                textView2 = null;
            }
            float max = (progress / seekBar.getMax()) * seekBar.getWidth();
            TextView textView3 = VideoEditorCropFragment.this.tvPastTime;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvPastTime");
            } else {
                textView = textView3;
            }
            textView2.setX((max - (textView.getWidth() / 2)) + seekBar.getLeft());
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@NotNull SeekBar seekbar) {
            Intrinsics.checkNotNullParameter(seekbar, "seekbar");
            this.isTouching = true;
            TextView textView = VideoEditorCropFragment.this.tvPastTime;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvPastTime");
                textView = null;
            }
            textView.setVisibility(0);
            seekbar.setThumb(ResourcesCompat.getDrawable(VideoEditorCropFragment.this.getResources(), R.drawable.kvu, null));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@NotNull SeekBar seekbar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekbar);
            Intrinsics.checkNotNullParameter(seekbar, "seekbar");
            this.isTouching = false;
            TextView textView = VideoEditorCropFragment.this.tvPastTime;
            SeekBar seekBar = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvPastTime");
                textView = null;
            }
            textView.setVisibility(8);
            this.lastSeekPos = -1L;
            seekbar.setThumb(ResourcesCompat.getDrawable(VideoEditorCropFragment.this.getResources(), R.drawable.kvt, null));
            SeekBar seekBar2 = VideoEditorCropFragment.this.seekBarVideoProgress;
            if (seekBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("seekBarVideoProgress");
            } else {
                seekBar = seekBar2;
            }
            com.tencent.mobileqq.qqvideoedit.editor.c.d(seekBar);
            EventCollector.getInstance().onStopTrackingTouch(seekbar);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$i", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e1", "e2", "", "distanceX", "distanceY", "", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class i extends GestureDetector.SimpleOnGestureListener {
        i() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@NotNull MotionEvent e16, @NotNull MotionEvent e26, float distanceX, float distanceY) {
            Intrinsics.checkNotNullParameter(e16, "e1");
            Intrinsics.checkNotNullParameter(e26, "e2");
            if (e26.getY() - e16.getY() > VideoEditorCropFragment.f275624h0) {
                VideoEditorCropFragment.this.Xh();
                return true;
            }
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$j", "Lcom/tencent/tavcut/render/player/IPlayer$a;", "Lcom/tencent/tavcut/render/player/IPlayer;", "iPlayer", "", "b", "", "currentDurationUs", "playerDurationUs", "onPositionChanged", "Lcom/tencent/tavcut/render/player/IPlayer$PlayerStatus;", "status", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class j implements IPlayer.a {
        j() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(VideoEditorCropFragment this$0, long j3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            TextView textView = this$0.tvPastTime;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvPastTime");
                textView = null;
            }
            textView.setText(this$0.Vh().format(Long.valueOf(j3 / 1000)));
        }

        @Override // com.tencent.tavcut.render.player.IPlayer.a
        public void a(@Nullable IPlayer.PlayerStatus status, @NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            IPlayer.a.C9881a.c(this, status, iPlayer);
            if (status == IPlayer.PlayerStatus.PLAYING) {
                iPlayer.pause();
                iPlayer.seek(VideoEditorCropFragment.this.Uh());
            }
        }

        @Override // com.tencent.tavcut.render.player.IPlayer.a
        public void b(@NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            IPlayer.a.C9881a.a(this, iPlayer);
            long durationUs = iPlayer.getDurationUs();
            SeekBar seekBar = VideoEditorCropFragment.this.seekBarVideoProgress;
            SeekBar seekBar2 = null;
            if (seekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("seekBarVideoProgress");
                seekBar = null;
            }
            seekBar.setMax((int) durationUs);
            SeekBar seekBar3 = VideoEditorCropFragment.this.seekBarVideoProgress;
            if (seekBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("seekBarVideoProgress");
            } else {
                seekBar2 = seekBar3;
            }
            seekBar2.setProgress((int) VideoEditorCropFragment.this.Uh());
        }

        @Override // com.tencent.tavcut.render.player.IPlayer.a
        public void onPositionChanged(final long currentDurationUs, long playerDurationUs) {
            IPlayer.a.C9881a.b(this, currentDurationUs, playerDurationUs);
            SeekBar seekBar = VideoEditorCropFragment.this.seekBarVideoProgress;
            TextView textView = null;
            if (seekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("seekBarVideoProgress");
                seekBar = null;
            }
            seekBar.setProgress((int) currentDurationUs);
            TextView textView2 = VideoEditorCropFragment.this.tvPastTime;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvPastTime");
            } else {
                textView = textView2;
            }
            final VideoEditorCropFragment videoEditorCropFragment = VideoEditorCropFragment.this;
            textView.post(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.crop.i
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEditorCropFragment.j.d(VideoEditorCropFragment.this, currentDurationUs);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$k", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/graphics/SurfaceTexture;", "surface", "", "width", "height", "", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class k implements TextureView.SurfaceTextureListener {
        k() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            VideoEditorCropFragment.this.playerSurface = new Surface(surface);
            try {
                VideoEditorCropFragment videoEditorCropFragment = VideoEditorCropFragment.this;
                Surface surface2 = videoEditorCropFragment.playerSurface;
                Intrinsics.checkNotNull(surface2);
                videoEditorCropFragment.ei(surface2);
                VideoEditorCropFragment.this.initData();
            } catch (Exception e16) {
                ms.a.c("VideoEditorCropFragment", e16.toString());
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            surface.release();
            Surface surface2 = VideoEditorCropFragment.this.playerSurface;
            if (surface2 != null) {
                surface2.release();
            }
            IPlayer iPlayer = null;
            VideoEditorCropFragment.this.playerSurface = null;
            IPlayer iPlayer2 = VideoEditorCropFragment.this.iPlayer;
            if (iPlayer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("iPlayer");
                iPlayer2 = null;
            }
            iPlayer2.destroySurface();
            IPlayer iPlayer3 = VideoEditorCropFragment.this.iPlayer;
            if (iPlayer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("iPlayer");
            } else {
                iPlayer = iPlayer3;
            }
            iPlayer.release();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }
    }

    public VideoEditorCropFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SimpleDateFormat>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.crop.VideoEditorCropFragment$timeFormat$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SimpleDateFormat invoke() {
                return new SimpleDateFormat("mm:ss", Locale.getDefault());
            }
        });
        this.timeFormat = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MediaClip>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.crop.VideoEditorCropFragment$mediaClip$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final MediaClip invoke() {
                List emptyList;
                Bundle arguments = VideoEditorCropFragment.this.getArguments();
                MediaClip mediaClip = arguments != null ? (MediaClip) arguments.getParcelable("key_media_clip") : null;
                if (mediaClip == null) {
                    return null;
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                ResourceModel resourceModel = mediaClip.resource;
                return MediaClip.copy$default(mediaClip, resourceModel != null ? ResourceModel.copy$default(resourceModel, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 63487, null) : null, null, null, null, null, emptyList, null, 94, null);
            }
        });
        this.mediaClip = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<vj2.a>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.crop.VideoEditorCropFragment$cropViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final vj2.a invoke() {
                return (vj2.a) new ViewModelProvider(VideoEditorCropFragment.this.requireActivity()).get(vj2.a.class);
            }
        });
        this.cropViewModel = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.crop.VideoEditorCropFragment$startTimeOffset$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                Bundle arguments = VideoEditorCropFragment.this.getArguments();
                return Long.valueOf(arguments != null ? arguments.getLong("key_start_time", 0L) : 0L);
            }
        });
        this.startTimeOffset = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new VideoEditorCropFragment$quitDialog$2(this));
        this.quitDialog = lazy5;
        this.selectRatioType = f275625i0;
        this.playerListener = new j();
        this.surfaceTextureListener = new k();
    }

    private final void Oh() {
        vj2.a Qh = Qh();
        MediaClip Sh = Sh();
        if (Sh == null) {
            return;
        }
        VideoEditorCropView videoEditorCropView = this.mCropView;
        VideoEditorCropView videoEditorCropView2 = null;
        if (videoEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
            videoEditorCropView = null;
        }
        float b16 = videoEditorCropView.getEditorGestureTextureView().b();
        RatioType ratioType = this.selectRatioType;
        VideoEditorCropView videoEditorCropView3 = this.mCropView;
        if (videoEditorCropView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
            videoEditorCropView3 = null;
        }
        RectF e16 = videoEditorCropView3.e();
        VideoEditorCropView videoEditorCropView4 = this.mCropView;
        if (videoEditorCropView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
            videoEditorCropView4 = null;
        }
        Matrix d16 = videoEditorCropView4.getEditorGestureTextureView().d();
        VideoEditorCropView videoEditorCropView5 = this.mCropView;
        if (videoEditorCropView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
        } else {
            videoEditorCropView2 = videoEditorCropView5;
        }
        Qh.U1(Sh, b16, ratioType, e16, d16, videoEditorCropView2.getMaskView().f(), this.isRotate90);
        Wh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph() {
        boolean z16;
        VideoEditorCropView videoEditorCropView = this.mCropView;
        TextView textView = null;
        if (videoEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
            videoEditorCropView = null;
        }
        boolean z17 = true;
        boolean z18 = !fi(videoEditorCropView.getEditorGestureTextureView().d(), new Matrix());
        RatioType ratioType = this.selectRatioType;
        int i3 = 0;
        if (ratioType != f275625i0 && ratioType != RatioType.Origin) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z18 && !z16) {
            z17 = false;
        }
        this.isDirty = z17;
        TextView textView2 = this.mResetBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mResetBtn");
        } else {
            textView = textView2;
        }
        if (!this.isDirty) {
            i3 = 8;
        }
        textView.setVisibility(i3);
    }

    private final vj2.a Qh() {
        return (vj2.a) this.cropViewModel.getValue();
    }

    private final Map<String, Object> Rh() {
        Intent intent;
        HashMap hashMap = new HashMap();
        FragmentActivity activity = getActivity();
        int i3 = 5;
        if (activity != null && (intent = activity.getIntent()) != null) {
            i3 = intent.getIntExtra("uintype", 5);
        }
        hashMap.put("type_aio_pg", Integer.valueOf(i3));
        return hashMap;
    }

    private final MediaClip Sh() {
        return (MediaClip) this.mediaClip.getValue();
    }

    private final QQCustomDialog Th() {
        return (QQCustomDialog) this.quitDialog.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long Uh() {
        return ((Number) this.startTimeOffset.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SimpleDateFormat Vh() {
        return (SimpleDateFormat) this.timeFormat.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh() {
        com.tencent.mobileqq.qqvideoedit.editor.a aVar;
        Bundle arguments;
        getParentFragmentManager().beginTransaction().remove(this).commit();
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (arguments = parentFragment.getArguments()) != null) {
            arguments.putBoolean(QQWinkConstants.IS_FROM_CROP, true);
        }
        ActivityResultCaller parentFragment2 = getParentFragment();
        if (parentFragment2 instanceof com.tencent.mobileqq.qqvideoedit.editor.a) {
            aVar = (com.tencent.mobileqq.qqvideoedit.editor.a) parentFragment2;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.g1(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xh() {
        View view = this.mRatioMenu;
        FrameLayout frameLayout = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRatioMenu");
            view = null;
        }
        view.setVisibility(8);
        RatioType ratioType = RatioType.FreeRatio;
        pi(this, ratioType, false, false, 6, null);
        ni(ratioType);
        this.selectRatioType = ratioType;
        FrameLayout frameLayout2 = this.mCropMenu;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropMenu");
        } else {
            frameLayout = frameLayout2;
        }
        frameLayout.setVisibility(0);
    }

    private final void Yh() {
        VideoEditorCropView videoEditorCropView = this.mCropView;
        VideoEditorCropView videoEditorCropView2 = null;
        if (videoEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
            videoEditorCropView = null;
        }
        videoEditorCropView.setEnableAutoAdjust(false);
        VideoEditorCropView videoEditorCropView3 = this.mCropView;
        if (videoEditorCropView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
            videoEditorCropView3 = null;
        }
        videoEditorCropView3.getEditorGestureTextureView().setSurfaceTextureListener(this.surfaceTextureListener);
        VideoEditorCropView videoEditorCropView4 = this.mCropView;
        if (videoEditorCropView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
            videoEditorCropView4 = null;
        }
        videoEditorCropView4.getMaskView().setCropSizeChangeListener(new d());
        MediaClip Sh = Sh();
        if (Sh != null) {
            VideoEditorCropView videoEditorCropView5 = this.mCropView;
            if (videoEditorCropView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCropView");
                videoEditorCropView5 = null;
            }
            videoEditorCropView5.setResourceSize(gk2.d.b(Sh).width, gk2.d.b(Sh).height);
        }
        VideoEditorCropView videoEditorCropView6 = this.mCropView;
        if (videoEditorCropView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
            videoEditorCropView6 = null;
        }
        videoEditorCropView6.getEditorGestureTextureView().a(new e());
        VideoEditorCropView videoEditorCropView7 = this.mCropView;
        if (videoEditorCropView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
        } else {
            videoEditorCropView2 = videoEditorCropView7;
        }
        videoEditorCropView2.getEditorGestureTextureView().setSingleTapUpListener(new f());
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void Zh() {
        FrameLayout frameLayout = this.mCropMenu;
        View view = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropMenu");
            frameLayout = null;
        }
        frameLayout.setVisibility(8);
        RatioType[] values = RatioType.values();
        int length = values.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            final RatioType ratioType = values[i3];
            int i17 = i16 + 1;
            LinearLayout linearLayout = this.mCropRatioView;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCropRatioView");
                linearLayout = null;
            }
            View childAt = linearLayout.getChildAt(i16);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) childAt).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.crop.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    VideoEditorCropFragment.bi(VideoEditorCropFragment.this, ratioType, view2);
                }
            });
            i3++;
            i16 = i17;
        }
        View view2 = this.mRatioMenu;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRatioMenu");
            view2 = null;
        }
        view2.setVisibility(0);
        View view3 = this.mRatioMenu;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRatioMenu");
        } else {
            view = view3;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.crop.h
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view4, MotionEvent motionEvent) {
                boolean ai5;
                ai5 = VideoEditorCropFragment.ai(VideoEditorCropFragment.this, view4, motionEvent);
                return ai5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ai(VideoEditorCropFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(VideoEditorCropFragment this$0, RatioType type, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(type, "$type");
        hi(this$0, type, false, true, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ci() {
        this.cropRatioChangeListener = new g();
        RatioType ratioType = RatioType.FreeRatio;
        pi(this, ratioType, false, false, 6, null);
        ni(ratioType);
        this.selectRatioType = ratioType;
    }

    private final void di() {
        SeekBar seekBar = this.seekBarVideoProgress;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarVideoProgress");
            seekBar = null;
        }
        seekBar.setOnSeekBarChangeListener(new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ei(Surface playerSurface) {
        od4.b bVar = od4.b.f422509e;
        this.iCutSession = bVar.h();
        IPlayer iPlayer = null;
        RenderModel x16 = bVar.x(null);
        com.tencent.tavcut.session.a aVar = this.iCutSession;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iCutSession");
            aVar = null;
        }
        Intrinsics.checkNotNull(x16);
        aVar.g(x16);
        com.tencent.tavcut.session.a aVar2 = this.iCutSession;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iCutSession");
            aVar2 = null;
        }
        VideoEditorCropView videoEditorCropView = this.mCropView;
        if (videoEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
            videoEditorCropView = null;
        }
        Integer valueOf = Integer.valueOf(videoEditorCropView.getEditorGestureTextureView().getWidth());
        VideoEditorCropView videoEditorCropView2 = this.mCropView;
        if (videoEditorCropView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
            videoEditorCropView2 = null;
        }
        aVar2.q(new Size(valueOf, Integer.valueOf(videoEditorCropView2.getEditorGestureTextureView().getHeight()), null, 4, null));
        IPlayer g16 = bVar.g(null);
        this.iPlayer = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iPlayer");
            g16 = null;
        }
        VideoEditorCropView videoEditorCropView3 = this.mCropView;
        if (videoEditorCropView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
            videoEditorCropView3 = null;
        }
        int width = videoEditorCropView3.getEditorGestureTextureView().getWidth();
        VideoEditorCropView videoEditorCropView4 = this.mCropView;
        if (videoEditorCropView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
            videoEditorCropView4 = null;
        }
        g16.setUpSurface(playerSurface, width, videoEditorCropView4.getEditorGestureTextureView().getHeight());
        IPlayer iPlayer2 = this.iPlayer;
        if (iPlayer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iPlayer");
            iPlayer2 = null;
        }
        iPlayer2.setLoopPlay(false);
        IPlayer iPlayer3 = this.iPlayer;
        if (iPlayer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iPlayer");
            iPlayer3 = null;
        }
        iPlayer3.setAutoPlay(true);
        IPlayer iPlayer4 = this.iPlayer;
        if (iPlayer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iPlayer");
            iPlayer4 = null;
        }
        iPlayer4.a(this.playerListener);
        com.tencent.tavcut.session.a aVar3 = this.iCutSession;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iCutSession");
            aVar3 = null;
        }
        IPlayer iPlayer5 = this.iPlayer;
        if (iPlayer5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iPlayer");
            iPlayer5 = null;
        }
        aVar3.p(iPlayer5);
        vj2.a Qh = Qh();
        com.tencent.tavcut.session.a aVar4 = this.iCutSession;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iCutSession");
            aVar4 = null;
        }
        IPlayer iPlayer6 = this.iPlayer;
        if (iPlayer6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iPlayer");
        } else {
            iPlayer = iPlayer6;
        }
        Qh.M1(aVar4, iPlayer);
    }

    private final boolean fi(Matrix matrix1, Matrix matrix2) {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        matrix1.getValues(fArr);
        matrix2.getValues(fArr2);
        String arrays = Arrays.toString(fArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        String arrays2 = Arrays.toString(fArr2);
        Intrinsics.checkNotNullExpressionValue(arrays2, "toString(this)");
        ms.a.a("VideoEditorCropFragment", "matrixArr1: " + arrays + ", matrixArr2: " + arrays2);
        for (int i3 = 0; i3 < 9; i3++) {
            if (Math.abs(fArr[i3] - fArr2[i3]) > 0.3f) {
                return false;
            }
        }
        return true;
    }

    private final String getPageId() {
        return "pg_video_size_crop";
    }

    private final void gi(RatioType newType, boolean opposite, boolean isManual) {
        if (!opposite && newType == this.selectRatioType) {
            return;
        }
        this.selectRatioType = newType;
        if (opposite) {
            newType = newType.getOppositeRatioType();
        }
        ni(newType);
        b bVar = this.cropRatioChangeListener;
        if (bVar != null) {
            bVar.a(this.selectRatioType, opposite, isManual);
        }
    }

    static /* synthetic */ void hi(VideoEditorCropFragment videoEditorCropFragment, RatioType ratioType, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        videoEditorCropFragment.gi(ratioType, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(VideoEditorCropFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.reset();
        TextView textView = this$0.mResetBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mResetBtn");
            textView = null;
        }
        com.tencent.mobileqq.qqvideoedit.editor.c.g(textView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initData() {
        Qh().N1(Sh());
        a.CropInfo Q1 = Qh().Q1(Sh());
        VideoEditorCropView videoEditorCropView = null;
        if (Q1 != null) {
            VideoEditorCropView videoEditorCropView2 = this.mCropView;
            if (videoEditorCropView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCropView");
                videoEditorCropView2 = null;
            }
            videoEditorCropView2.getEditorGestureTextureView().setTransform(Q1.getMatrix());
            this.selectRatioType = Q1.getRatioType();
            VideoEditorCropView videoEditorCropView3 = this.mCropView;
            if (videoEditorCropView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCropView");
                videoEditorCropView3 = null;
            }
            videoEditorCropView3.getMaskView().setCropViewRect(Q1.getCropRect());
            this.isRotate90 = Q1.getIsRotate90();
        }
        VideoEditorCropView videoEditorCropView4 = this.mCropView;
        if (videoEditorCropView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
        } else {
            videoEditorCropView = videoEditorCropView4;
        }
        videoEditorCropView.setEnableAutoAdjust(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(VideoEditorCropFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoEditorCropView videoEditorCropView = this$0.mCropView;
        ImageView imageView = null;
        if (videoEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
            videoEditorCropView = null;
        }
        videoEditorCropView.i();
        this$0.Ph();
        ImageView imageView2 = this$0.mRotateBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRotateBtn");
        } else {
            imageView = imageView2;
        }
        com.tencent.mobileqq.qqvideoedit.editor.c.h(imageView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(VideoEditorCropFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Zh();
        ImageView imageView = this$0.mRatioMenuBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRatioMenuBtn");
            imageView = null;
        }
        com.tencent.mobileqq.qqvideoedit.editor.c.e(imageView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void li(VideoEditorCropFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoEditorCropView videoEditorCropView = this$0.mCropView;
        View view2 = null;
        if (videoEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
            videoEditorCropView = null;
        }
        if (videoEditorCropView.h()) {
            if (this$0.isDirty) {
                if (!this$0.Th().isShowing()) {
                    this$0.Th().show();
                }
            } else {
                View view3 = this$0.btnCancel;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
                } else {
                    view2 = view3;
                }
                com.tencent.mobileqq.qqvideoedit.editor.c.b(view2);
                this$0.Wh();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(VideoEditorCropFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoEditorCropView videoEditorCropView = this$0.mCropView;
        View view2 = null;
        if (videoEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
            videoEditorCropView = null;
        }
        if (videoEditorCropView.h()) {
            this$0.Oh();
            View view3 = this$0.btnConfirm;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
            } else {
                view2 = view3;
            }
            com.tencent.mobileqq.qqvideoedit.editor.c.c(view2);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ni(RatioType ratioType) {
        boolean z16;
        RatioType[] values = RatioType.values();
        int length = values.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            RatioType ratioType2 = values[i3];
            int i17 = i16 + 1;
            LinearLayout linearLayout = this.mCropRatioView;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCropRatioView");
                linearLayout = null;
            }
            View childAt = linearLayout.getChildAt(i16);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) childAt;
            if (ratioType2 == ratioType) {
                z16 = true;
            } else {
                z16 = false;
            }
            textView.setSelected(z16);
            i3++;
            i16 = i17;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oi(RatioType type, boolean reverse, boolean isManual) {
        float mTargetAspectRatio;
        float f16;
        float f17;
        VideoEditorCropView videoEditorCropView = this.mCropView;
        View view = null;
        if (videoEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
            videoEditorCropView = null;
        }
        VideoEditorCropMaskView maskView = videoEditorCropView.getMaskView();
        if (type != RatioType.Origin) {
            this.isOriginReverse = false;
        }
        switch (c.f275633a[type.ordinal()]) {
            case 1:
                MediaClip Sh = Sh();
                if (Sh != null) {
                    if (maskView.getMTargetAspectRatio() <= 0.0f) {
                        mTargetAspectRatio = gk2.d.b(Sh).width / gk2.d.b(Sh).height;
                    } else {
                        mTargetAspectRatio = maskView.getMTargetAspectRatio();
                    }
                    if (reverse) {
                        mTargetAspectRatio = 1.0f / mTargetAspectRatio;
                    }
                    maskView.setTargetAspectRatio(mTargetAspectRatio, 1);
                }
                if (isManual) {
                    View view2 = this.mRatioMenu;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRatioMenu");
                    } else {
                        view = view2;
                    }
                    com.tencent.mobileqq.qqvideoedit.editor.c.f(view, 3);
                    return;
                }
                return;
            case 2:
                maskView.setTargetAspectRatio(1.0f, 0);
                View view3 = this.mRatioMenu;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRatioMenu");
                } else {
                    view = view3;
                }
                com.tencent.mobileqq.qqvideoedit.editor.c.f(view, 3);
                return;
            case 3:
                maskView.setTargetAspectRatio(0.5625f, 0);
                View view4 = this.mRatioMenu;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRatioMenu");
                } else {
                    view = view4;
                }
                com.tencent.mobileqq.qqvideoedit.editor.c.f(view, 4);
                return;
            case 4:
                maskView.setTargetAspectRatio(1.7777778f, 0);
                View view5 = this.mRatioMenu;
                if (view5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRatioMenu");
                } else {
                    view = view5;
                }
                com.tencent.mobileqq.qqvideoedit.editor.c.f(view, 5);
                return;
            case 5:
                maskView.setTargetAspectRatio(0.75f, 0);
                View view6 = this.mRatioMenu;
                if (view6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRatioMenu");
                } else {
                    view = view6;
                }
                com.tencent.mobileqq.qqvideoedit.editor.c.f(view, 6);
                return;
            case 6:
                maskView.setTargetAspectRatio(1.3333334f, 0);
                View view7 = this.mRatioMenu;
                if (view7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRatioMenu");
                } else {
                    view = view7;
                }
                com.tencent.mobileqq.qqvideoedit.editor.c.f(view, 7);
                return;
            default:
                MediaClip Sh2 = Sh();
                if (Sh2 != null) {
                    if (reverse) {
                        this.isOriginReverse = !this.isOriginReverse;
                    }
                    if (this.isOriginReverse) {
                        f16 = gk2.d.b(Sh2).height;
                        f17 = gk2.d.b(Sh2).width;
                    } else {
                        f16 = gk2.d.b(Sh2).width;
                        f17 = gk2.d.b(Sh2).height;
                    }
                    maskView.setTargetAspectRatio(f16 / f17, 2);
                    return;
                }
                return;
        }
    }

    static /* synthetic */ void pi(VideoEditorCropFragment videoEditorCropFragment, RatioType ratioType, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        videoEditorCropFragment.oi(ratioType, z16, z17);
    }

    private final void registerDaTongReportPageId(View contentView) {
        VideoReport.addToDetectionWhitelist(getActivity());
        String pageId = getPageId();
        VideoReport.setPageId(contentView, pageId);
        VideoReport.setPageParams(contentView, ek2.a.b(Rh()));
        QLog.i("VideoEditorFragment", 1, "reportDaTongRegister subPage: " + getLogTag() + ", pageId: " + pageId);
    }

    private final void reset() {
        MediaClip Sh = Sh();
        VideoEditorCropView videoEditorCropView = null;
        if (Sh != null) {
            VideoEditorCropView videoEditorCropView2 = this.mCropView;
            if (videoEditorCropView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCropView");
                videoEditorCropView2 = null;
            }
            videoEditorCropView2.getMaskView().setTargetAspectRatio(gk2.d.b(Sh).width / gk2.d.b(Sh).height, 1);
        }
        RatioType ratioType = f275625i0;
        hi(this, ratioType, false, false, 6, null);
        this.selectRatioType = ratioType;
        VideoEditorCropView videoEditorCropView3 = this.mCropView;
        if (videoEditorCropView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCropView");
        } else {
            videoEditorCropView = videoEditorCropView3;
        }
        videoEditorCropView.getEditorGestureTextureView().t();
        this.isDirty = false;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VideoEditorCropMenuPart());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.h1k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    public String getLogTag() {
        String simpleName = VideoEditorCropFragment.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "VideoEditorCropFragment::class.java.simpleName");
        return simpleName;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needAdjustImmersive() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Qh().R1(false);
        com.tencent.tavcut.session.a aVar = this.iCutSession;
        IPlayer iPlayer = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iCutSession");
            aVar = null;
        }
        aVar.release();
        IPlayer iPlayer2 = this.iPlayer;
        if (iPlayer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iPlayer");
        } else {
            iPlayer = iPlayer2;
        }
        iPlayer.release();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        ConstraintLayout.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        registerDaTongReportPageId(view);
        View findViewById = view.findViewById(R.id.f1175371p);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.video_editor_crop_view)");
        this.mCropView = (VideoEditorCropView) findViewById;
        View findViewById2 = view.findViewById(R.id.f1175071m);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.v\u2026o_editor_crop_ratio_view)");
        this.mCropRatioView = (LinearLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.f1175271o);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.v\u2026o_editor_crop_rotate_btn)");
        this.mRotateBtn = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.f1174771j);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.v\u2026o_editor_crop_ratio_menu)");
        this.mRatioMenu = findViewById4;
        View findViewById5 = view.findViewById(R.id.f1174871k);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.v\u2026itor_crop_ratio_menu_btn)");
        this.mRatioMenuBtn = (ImageView) findViewById5;
        View findViewById6 = view.findViewById(R.id.f1175171n);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.video_editor_crop_resetbtn)");
        this.mResetBtn = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.f1174471g);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.video_editor_crop_menu)");
        this.mCropMenu = (FrameLayout) findViewById7;
        View findViewById8 = view.findViewById(R.id.f1174371f);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.video_editor_crop_cropsize)");
        this.mCropSize = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.f81814f7);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.seekBarVideoProgress)");
        this.seekBarVideoProgress = (SeekBar) findViewById9;
        View findViewById10 = view.findViewById(R.id.f1055466a);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.tvScaleTips)");
        this.tvScaleTips = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.f10546663);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.tvPastTime)");
        this.tvPastTime = (TextView) findViewById11;
        View findViewById12 = view.findViewById(R.id.f1174171d);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById(R.id.video_editor_crop_cancel)");
        this.btnCancel = findViewById12;
        View findViewById13 = view.findViewById(R.id.f1174271e);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "view.findViewById(R.id.video_editor_crop_confirm)");
        this.btnConfirm = findViewById13;
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext());
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        int a16 = statusBarHeight + eVar.a(16.0f);
        TextView textView = this.tvScaleTips;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvScaleTips");
            textView = null;
        }
        TextView textView3 = this.tvScaleTips;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvScaleTips");
            textView3 = null;
        }
        ViewGroup.LayoutParams layoutParams2 = textView3.getLayoutParams();
        if (layoutParams2 instanceof ConstraintLayout.LayoutParams) {
            layoutParams = (ConstraintLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = a16 + eVar.a(12.0f);
        } else {
            layoutParams = null;
        }
        textView.setLayoutParams(layoutParams);
        Yh();
        di();
        ci();
        Ph();
        TextView textView4 = this.mResetBtn;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mResetBtn");
            textView4 = null;
        }
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.crop.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VideoEditorCropFragment.ii(VideoEditorCropFragment.this, view2);
            }
        });
        ImageView imageView = this.mRotateBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRotateBtn");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.crop.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VideoEditorCropFragment.ji(VideoEditorCropFragment.this, view2);
            }
        });
        ImageView imageView2 = this.mRatioMenuBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRatioMenuBtn");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.crop.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VideoEditorCropFragment.ki(VideoEditorCropFragment.this, view2);
            }
        });
        View view2 = this.btnCancel;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
            view2 = null;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.crop.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                VideoEditorCropFragment.li(VideoEditorCropFragment.this, view3);
            }
        });
        View view3 = this.btnConfirm;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
            view3 = null;
        }
        view3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.crop.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                VideoEditorCropFragment.mi(VideoEditorCropFragment.this, view4);
            }
        });
        if (Qh().O1()) {
            TextView textView5 = this.tvScaleTips;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvScaleTips");
            } else {
                textView2 = textView5;
            }
            textView2.setVisibility(0);
        }
        Qh().S1(false);
        Qh().R1(true);
    }
}
