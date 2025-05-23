package l83;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioHistoryImageModel;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioUtils;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.smtt.utils.Md5Utils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 p2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001qB\u0091\u0001\u0012\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b06\u0012\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b06\u0012\u0018\u0010@\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u000b0<\u0012\u001e\u0010D\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0A\u0012\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b06\u0012\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b06\u00a2\u0006\u0004\bn\u0010oJ\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J1\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00028\u00002\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\bH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J$\u0010\u001d\u001a\u00020\u000b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001a\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0018\u0010%\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\u0018\u0010&\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010'\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010(\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010,\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u0004H\u0016J\b\u0010-\u001a\u00020\u0004H\u0016J\u0010\u0010.\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0004J\b\u0010/\u001a\u0004\u0018\u00010\u000fJ\u0006\u00100\u001a\u00020\u000bJ\u0018\u00102\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J&\u00104\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001b0\bH\u0016J\u000e\u00105\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0002R \u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00108R&\u0010@\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u000b0<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R,\u0010D\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR \u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u00108R \u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u00108R(\u0010P\u001a\b\u0012\u0004\u0012\u00020\u000f0I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR(\u0010T\u001a\b\u0012\u0004\u0012\u00020=0\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010K\u001a\u0004\bR\u0010M\"\u0004\bS\u0010OR\"\u0010Z\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010Q\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR*\u0010_\u001a\u00020\u00042\u0006\u0010[\u001a\u00020\u00048\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010Q\u001a\u0004\b]\u0010W\"\u0004\b^\u0010YR$\u0010g\u001a\u0004\u0018\u00010`8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR \u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bi\u0010KR \u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020k0\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010K\u00a8\u0006r"}, d2 = {"Ll83/e;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ln83/b;", "Lkotlin/Pair;", "", "B0", "T", "view", "", "Ljava/lang/ref/WeakReference;", "weakRefList", "", "n0", "(Ljava/lang/Object;Ljava/util/List;)V", "viewHolder", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "itemInfo", "position", "t0", "Landroid/view/View;", "btn", "K0", "M0", "L0", "J0", "", "", "", "paramMap", "m0", "url", "o0", "Q0", "Lcom/tencent/mobileqq/videoplatform/api/VideoPlayParam;", "A0", "F0", "H0", "I0", "r0", "p0", "v0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "E0", "getItemCount", "y0", "w0", "release", "holder", "C0", "payloads", "D0", "N0", "Lkotlin/Function1;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "onItemSelected", BdhLogUtil.LogTag.Tag_Conn, "onItemClick", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioHistoryImageModel;", "D", "Lkotlin/jvm/functions/Function2;", "onHistoryItemClick", "Lkotlin/Function3;", "E", "Lkotlin/jvm/functions/Function3;", "onHistoryItemDeleteClick", UserInfo.SEX_FEMALE, "onHistoryItemLongClick", "G", "onShareClick", "", "H", "Ljava/util/List;", "z0", "()Ljava/util/List;", "V0", "(Ljava/util/List;)V", "picStyleList", "I", "getPicHistoryList", "U0", "picHistoryList", "J", "getCurrentInDeletingPosition", "()I", "S0", "(I)V", "currentInDeletingPosition", "value", "K", "x0", "T0", "currentSelectedPosition", "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "L", "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "getAgiButtonInfo", "()Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "O0", "(Lcom/tencent/mobileqq/wink/magicstudio/model/e;)V", "agiButtonInfo", "Lcom/tencent/mobileqq/videoplatform/view/BaseVideoView;", "M", "videoViewsRefList", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "N", "blurViewsRefList", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "P", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e extends RecyclerView.Adapter<n83.b> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function1<Integer, Unit> onItemClick;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Function2<Integer, MagicStudioHistoryImageModel, Unit> onHistoryItemClick;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Function3<Integer, MagicStudioHistoryImageModel, Integer, Unit> onHistoryItemDeleteClick;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Function1<Integer, Unit> onHistoryItemLongClick;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Function1<MagicStudioPicStyle, Unit> onShareClick;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private List<MagicStudioPicStyle> picStyleList;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private List<MagicStudioHistoryImageModel> picHistoryList;

    /* renamed from: J, reason: from kotlin metadata */
    private int currentInDeletingPosition;

    /* renamed from: K, reason: from kotlin metadata */
    private int currentSelectedPosition;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private MagicStudioButtonInfo agiButtonInfo;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final List<WeakReference<BaseVideoView>> videoViewsRefList;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final List<WeakReference<QQBlurViewWrapper>> blurViewsRefList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Integer, Unit> onItemSelected;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ n83.b f413990d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f413991e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f413992f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ n83.b f413993h;

        public b(n83.b bVar, boolean z16, boolean z17, n83.b bVar2) {
            this.f413990d = bVar;
            this.f413991e = z16;
            this.f413992f = z17;
            this.f413993h = bVar2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            int i3;
            Intrinsics.checkNotNullParameter(animator, "animator");
            View shareBtn = this.f413990d.getShareBtn();
            if (this.f413991e) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            shareBtn.setVisibility(i3);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            if (this.f413992f) {
                this.f413993h.getShareBtn().setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f413994d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f413995e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f413996f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f413997h;

        public c(View view, boolean z16, boolean z17, View view2) {
            this.f413994d = view;
            this.f413995e = z16;
            this.f413996f = z17;
            this.f413997h = view2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            int i3;
            Intrinsics.checkNotNullParameter(animator, "animator");
            View view = this.f413994d;
            if (this.f413995e) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            view.setVisibility(i3);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            if (!this.f413996f) {
                this.f413997h.setVisibility(0);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull Function1<? super Integer, Unit> onItemSelected, @NotNull Function1<? super Integer, Unit> onItemClick, @NotNull Function2<? super Integer, ? super MagicStudioHistoryImageModel, Unit> onHistoryItemClick, @NotNull Function3<? super Integer, ? super MagicStudioHistoryImageModel, ? super Integer, Unit> onHistoryItemDeleteClick, @NotNull Function1<? super Integer, Unit> onHistoryItemLongClick, @NotNull Function1<? super MagicStudioPicStyle, Unit> onShareClick) {
        List<MagicStudioPicStyle> emptyList;
        Intrinsics.checkNotNullParameter(onItemSelected, "onItemSelected");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(onHistoryItemClick, "onHistoryItemClick");
        Intrinsics.checkNotNullParameter(onHistoryItemDeleteClick, "onHistoryItemDeleteClick");
        Intrinsics.checkNotNullParameter(onHistoryItemLongClick, "onHistoryItemLongClick");
        Intrinsics.checkNotNullParameter(onShareClick, "onShareClick");
        this.onItemSelected = onItemSelected;
        this.onItemClick = onItemClick;
        this.onHistoryItemClick = onHistoryItemClick;
        this.onHistoryItemDeleteClick = onHistoryItemDeleteClick;
        this.onHistoryItemLongClick = onHistoryItemLongClick;
        this.onShareClick = onShareClick;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.picStyleList = emptyList;
        this.picHistoryList = new ArrayList();
        this.currentInDeletingPosition = -1;
        this.currentSelectedPosition = -1;
        this.videoViewsRefList = new ArrayList();
        this.blurViewsRefList = new ArrayList();
    }

    private final VideoPlayParam A0(String url) {
        VideoPlayParam videoPlayParam = new VideoPlayParam();
        videoPlayParam.mUrls = new String[]{url};
        videoPlayParam.mVideoFormat = 101;
        videoPlayParam.mIsLocal = false;
        videoPlayParam.mIsLoop = true;
        videoPlayParam.mNeedPlayProgress = true;
        videoPlayParam.mIsMute = true;
        videoPlayParam.mSceneId = 163;
        return videoPlayParam;
    }

    private final Pair<Integer, Integer> B0() {
        int screenHeight = (int) (ViewUtils.getScreenHeight() * 0.7f);
        int screenWidth = ViewUtils.getScreenWidth() - ViewUtils.dpToPx(44.0f);
        int i3 = (int) (screenHeight / 1.5f);
        if (i3 > screenWidth) {
            screenHeight = (int) (screenWidth * 1.5f);
        } else {
            screenWidth = i3;
        }
        return new Pair<>(Integer.valueOf(screenWidth), Integer.valueOf(screenHeight));
    }

    private final void F0(n83.b viewHolder) {
        viewHolder.getMagicStudioItemBaseVideoView().pause();
    }

    private final void H0(n83.b viewHolder) {
        viewHolder.getMagicStudioItemBaseVideoView().play();
    }

    private final void I0(n83.b viewHolder, String url) {
        viewHolder.getMagicStudioItemBaseVideoView().setVideoParam(A0(url));
        viewHolder.getMagicStudioItemBaseVideoView().play();
    }

    private final void J0(View btn, MagicStudioPicStyle itemInfo) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        m0(linkedHashMap, itemInfo);
        com.tencent.mobileqq.wink.report.e.f326265a.l(btn, WinkDaTongReportConstant.ElementId.EM_QZ_START_MAKING_BUTTONS, linkedHashMap, itemInfo.getStyleId());
    }

    private final void K0(View btn, MagicStudioPicStyle itemInfo) {
        Map<String, ?> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        m0(params, itemInfo);
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_QZ_MAGIC_STUDIO_DETAIL);
        params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_QZ_START_MAKING_BUTTONS);
        com.tencent.mobileqq.wink.report.e.f326265a.e(btn, WinkDaTongReportConstant.ElementId.EM_QZ_START_MAKING_BUTTONS, params, itemInfo.getStyleId());
    }

    private final void L0(View btn, MagicStudioPicStyle itemInfo) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        m0(linkedHashMap, itemInfo);
        com.tencent.mobileqq.wink.report.e.f326265a.l(btn, WinkDaTongReportConstant.ElementId.EM_QZ_SHARE, linkedHashMap, itemInfo.getStyleId());
    }

    private final void M0(View btn, MagicStudioPicStyle itemInfo) {
        Map<String, ?> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        m0(params, itemInfo);
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_QZ_MAGIC_STUDIO_DETAIL);
        params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_QZ_SHARE);
        com.tencent.mobileqq.wink.report.e.f326265a.e(btn, WinkDaTongReportConstant.ElementId.EM_QZ_SHARE, params, itemInfo.getStyleId());
        VideoReport.setElementEndExposePolicy(btn, EndExposurePolicy.REPORT_ALL);
    }

    private final void Q0(final n83.b viewHolder) {
        viewHolder.getCardView().setOnClickListener(new View.OnClickListener() { // from class: l83.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.R0(n83.b.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(n83.b viewHolder, e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (viewHolder.getMagicStudioItemBaseVideoView().isPlaying()) {
            this$0.F0(viewHolder);
        } else {
            this$0.H0(viewHolder);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void m0(Map<String, Object> paramMap, MagicStudioPicStyle itemInfo) {
        paramMap.put("material_id", itemInfo.getStyleId());
        String categoryName = itemInfo.getCategoryName();
        if (categoryName == null) {
            categoryName = "";
        }
        paramMap.put(WinkDaTongReportConstant.ElementParamKey.CONTENT_TAG, categoryName);
        m83.b.f416442a.a(this.agiButtonInfo, paramMap);
    }

    private final <T> void n0(T view, List<WeakReference<T>> weakRefList) {
        Iterator<WeakReference<T>> it = weakRefList.iterator();
        while (it.hasNext()) {
            if (it.next().get() == view) {
                return;
            }
        }
        weakRefList.add(new WeakReference<>(view));
    }

    private final void o0(n83.b viewHolder, String url) {
        w53.b.a("WinkQZonePic2PicAdapter", "bindCover");
        try {
            viewHolder.getMagicStudioItemBaseVideoView().setCoverDrawable(URLDrawable.getDrawable(url, ViewUtilsKt.d()));
        } catch (Exception e16) {
            w53.b.h("WinkQZonePic2PicAdapter", "[bindCover] exception", e16);
        }
    }

    private final void p0(n83.b viewHolder, final int position) {
        boolean z16;
        if (this.picHistoryList.isEmpty()) {
            viewHolder.getMagicStudioItemHistoryContainer().setVisibility(8);
        } else {
            v0(viewHolder.getMagicStudioItemHistoryContainer(), position);
            RecyclerView.Adapter adapter = viewHolder.getMagicStudioItemHistoryRecyclerView().getAdapter();
            if (adapter == null) {
                adapter = new i(this.onHistoryItemClick, this.onHistoryItemDeleteClick, this.onHistoryItemLongClick);
            }
            viewHolder.getMagicStudioItemHistoryRecyclerView().setAdapter(adapter);
            if (adapter instanceof i) {
                i iVar = (i) adapter;
                if (position == this.currentInDeletingPosition) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                iVar.t0(z16);
                iVar.s0(this.picHistoryList);
                iVar.v0(y0(position));
                iVar.u0(position);
                iVar.notifyDataSetChanged();
            }
        }
        if (this.currentInDeletingPosition >= 0) {
            viewHolder.getMagicStudioItemTopClickView().setVisibility(0);
            viewHolder.getMagicStudioItemTopClickView().setOnClickListener(new View.OnClickListener() { // from class: l83.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.q0(e.this, position, view);
                }
            });
        } else {
            viewHolder.getMagicStudioItemTopClickView().setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(e this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.currentInDeletingPosition >= 0) {
            this$0.currentInDeletingPosition = -1;
            this$0.notifyItemChanged(i3, "payload_history");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void r0(final n83.b viewHolder, final int position) {
        boolean z16;
        float f16;
        if (!com.tencent.mobileqq.wink.editor.util.h.f322638a.g()) {
            viewHolder.getShareBtn().setVisibility(8);
            return;
        }
        M0(viewHolder.getShareBtn(), this.picStyleList.get(position));
        if (position == this.currentSelectedPosition) {
            z16 = true;
        } else {
            z16 = false;
        }
        View shareBtn = viewHolder.getShareBtn();
        float[] fArr = new float[1];
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        fArr[0] = f16;
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(shareBtn, com.tencent.luggage.wxa.c8.c.f123400v, fArr);
        objectAnimator.setDuration(250L);
        Intrinsics.checkNotNullExpressionValue(objectAnimator, "objectAnimator");
        objectAnimator.addListener(new b(viewHolder, z16, z16, viewHolder));
        objectAnimator.start();
        viewHolder.getShareBtn().setOnClickListener(new View.OnClickListener() { // from class: l83.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.s0(e.this, position, viewHolder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(e this$0, int i3, n83.b viewHolder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        this$0.onShareClick.invoke(this$0.picStyleList.get(i3));
        this$0.L0(viewHolder.getShareBtn(), this$0.picStyleList.get(i3));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void t0(n83.b viewHolder, final MagicStudioPicStyle itemInfo, final int position) {
        int i3;
        w53.b.a("WinkQZonePic2PicAdapter", "bind");
        viewHolder.getMagicStudioItemStyleNameView().setText(itemInfo.getName());
        TextView magicStudioItemUseCountView = viewHolder.getMagicStudioItemUseCountView();
        com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c cVar = com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c.f326233a;
        magicStudioItemUseCountView.setText(cVar.i(itemInfo.getUsageCnt()));
        TextView magicStudioItemNextBtnTextView = viewHolder.getMagicStudioItemNextBtnTextView();
        WinkMagicStudioUtils winkMagicStudioUtils = WinkMagicStudioUtils.f323888a;
        magicStudioItemNextBtnTextView.setText(winkMagicStudioUtils.e(this.agiButtonInfo, itemInfo));
        if (winkMagicStudioUtils.i(this.agiButtonInfo)) {
            viewHolder.getMagicStudioItemNextBtnTextView().setBackgroundResource(R.drawable.m5i);
            viewHolder.getMagicStudioItemNextBtnTextView().setTextColor(viewHolder.itemView.getResources().getColor(R.color.black));
        } else {
            viewHolder.getMagicStudioItemNextBtnTextView().setBackgroundResource(R.drawable.m5h);
            viewHolder.getMagicStudioItemNextBtnTextView().setTextColor(viewHolder.itemView.getResources().getColor(R.color.by));
        }
        r0(viewHolder, position);
        o0(viewHolder, itemInfo.getStaticMotionCoverUrl());
        viewHolder.getMagicStudioItemLottieAnimationView().setAnimationFromUrl("https://downv6.qq.com/shadow_qqcamera/magicstudio/qzone_magicstudio_btn_lottie_animation.zip", Md5Utils.getMD5("https://downv6.qq.com/shadow_qqcamera/magicstudio/qzone_magicstudio_btn_lottie_animation.zip"));
        w53.b.a("WinkQZonePic2PicAdapter", "selectedPosition: " + this.currentSelectedPosition + ", position: " + position);
        boolean isValidUrl = HttpUtil.isValidUrl(itemInfo.getVideoUrl());
        v0(viewHolder.getMagicStudioItemNextBtnClickArea(), position);
        LottieAnimationView magicStudioItemLottieAnimationView = viewHolder.getMagicStudioItemLottieAnimationView();
        if (cVar.b()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        magicStudioItemLottieAnimationView.setVisibility(i3);
        if (this.currentSelectedPosition == position) {
            if (isValidUrl) {
                String videoUrl = itemInfo.getVideoUrl();
                Intrinsics.checkNotNull(videoUrl);
                I0(viewHolder, videoUrl);
            } else {
                N0(viewHolder);
            }
            if (cVar.b()) {
                viewHolder.getMagicStudioItemLottieAnimationView().playAnimation();
            }
        } else {
            N0(viewHolder);
            if (cVar.b()) {
                viewHolder.getMagicStudioItemLottieAnimationView().pauseAnimation();
            }
        }
        Q0(viewHolder);
        viewHolder.getMagicStudioItemNextBtnClickArea().setOnClickListener(new View.OnClickListener() { // from class: l83.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.u0(e.this, position, itemInfo, view);
            }
        });
        K0(viewHolder.getMagicStudioItemNextBtnClickArea(), itemInfo);
        p0(viewHolder, position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(e this$0, int i3, MagicStudioPicStyle itemInfo, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemInfo, "$itemInfo");
        this$0.onItemClick.invoke(Integer.valueOf(i3));
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.J0(it, itemInfo);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void v0(View view, int position) {
        boolean z16;
        float f16;
        if (this.currentSelectedPosition != position) {
            z16 = true;
        } else {
            z16 = false;
        }
        float[] fArr = new float[1];
        if (z16) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f;
        }
        fArr[0] = f16;
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, fArr).setDuration(250L);
        Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(\n            vie\u2026HA_ANIMATION_DURATION_MS)");
        duration.addListener(new c(view, z16, z16, view));
        duration.start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull n83.b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        w53.b.a("WinkQZonePic2PicAdapter", "onBindViewHolder\uff0cposition = " + position);
        MagicStudioPicStyle y06 = y0(position);
        if (y06 != null) {
            t0(holder, y06, position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull n83.b holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        w53.b.a("WinkQZonePic2PicAdapter", "onBindViewHolder payloads\uff0cposition = " + position);
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
            return;
        }
        Iterator<Object> it = payloads.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next(), "payload_history")) {
                p0(holder, position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public n83.b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        w53.b.a("WinkQZonePic2PicAdapter", "onCreateViewHolder");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.i7b, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        n83.b bVar = new n83.b(itemView);
        ViewGroup.LayoutParams layoutParams = bVar.getCardView().getLayoutParams();
        Pair<Integer, Integer> B0 = B0();
        layoutParams.width = B0.getFirst().intValue();
        layoutParams.height = B0.getSecond().intValue();
        w53.b.a("WinkQZonePic2PicAdapter", "cardview size " + B0);
        n0(bVar.getMagicStudioItemBaseVideoView(), this.videoViewsRefList);
        n0(bVar.getNextBtnBlurView(), this.blurViewsRefList);
        n0(bVar.getHistoryBgBlurView(), this.blurViewsRefList);
        return bVar;
    }

    public final void N0(@NotNull n83.b viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        viewHolder.getMagicStudioItemBaseVideoView().seekTo(0);
        viewHolder.getMagicStudioItemBaseVideoView().pause();
    }

    public final void O0(@Nullable MagicStudioButtonInfo magicStudioButtonInfo) {
        this.agiButtonInfo = magicStudioButtonInfo;
    }

    public final void S0(int i3) {
        this.currentInDeletingPosition = i3;
    }

    public final void T0(int i3) {
        this.currentSelectedPosition = i3;
        this.onItemSelected.invoke(Integer.valueOf(i3));
    }

    public final void U0(@NotNull List<MagicStudioHistoryImageModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.picHistoryList = list;
    }

    public final void V0(@NotNull List<MagicStudioPicStyle> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.picStyleList = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.picStyleList.size();
    }

    public final void release() {
        Iterator<WeakReference<BaseVideoView>> it = this.videoViewsRefList.iterator();
        int i3 = 0;
        int i16 = 0;
        while (it.hasNext()) {
            BaseVideoView baseVideoView = it.next().get();
            if (baseVideoView != null) {
                baseVideoView.releasePlayer(false);
                i16++;
            }
        }
        this.videoViewsRefList.clear();
        Iterator<WeakReference<QQBlurViewWrapper>> it5 = this.blurViewsRefList.iterator();
        while (it5.hasNext()) {
            QQBlurViewWrapper qQBlurViewWrapper = it5.next().get();
            if (qQBlurViewWrapper != null) {
                qQBlurViewWrapper.onDestroy();
                i3++;
            }
        }
        this.blurViewsRefList.clear();
        w53.b.a("WinkQZonePic2PicAdapter", "[release] videoViewCount = " + i16 + ", blurViewCount = " + i3);
    }

    @Nullable
    public final MagicStudioPicStyle w0() {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.picStyleList, this.currentSelectedPosition);
        return (MagicStudioPicStyle) orNull;
    }

    /* renamed from: x0, reason: from getter */
    public final int getCurrentSelectedPosition() {
        return this.currentSelectedPosition;
    }

    @Nullable
    public final MagicStudioPicStyle y0(int position) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.picStyleList, position);
        return (MagicStudioPicStyle) orNull;
    }

    @NotNull
    public final List<MagicStudioPicStyle> z0() {
        return this.picStyleList;
    }
}
