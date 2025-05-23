package bp1;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.scroll.HippyHeaderScrollViewController;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u00014B\u000f\u0012\u0006\u0010y\u001a\u00020x\u00a2\u0006\u0004\bz\u0010{J\b\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\u0006\u0010\u0017\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0002J6\u0010!\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0006J\u001e\u0010(\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004J\u001e\u0010)\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004J.\u0010-\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+2\u0006\u0010'\u001a\u00020\u0004J\u0016\u0010.\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020\u0004J\u000e\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020/J\u000e\u00102\u001a\u00020\u00062\u0006\u00100\u001a\u00020/R*\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R*\u0010>\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u00105\u001a\u0004\b<\u00107\"\u0004\b=\u00109R\"\u0010E\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010\u0018\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bG\u0010@\u001a\u0004\bH\u0010BR$\u0010N\u001a\u00020I2\u0006\u0010F\u001a\u00020I8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\"\u0010V\u001a\u00020O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010[\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010\u000e\u001a\u0004\b@\u0010X\"\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010\u000eR\"\u0010g\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010\u000e\u001a\u0004\be\u0010X\"\u0004\bf\u0010ZR\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010\u000eR\u0016\u0010j\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010\u000eR\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010\u000eR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010\u000eR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010\u000eR$\u0010\u001e\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bn\u0010\u000e\u001a\u0004\bo\u0010XR\u0014\u0010q\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bp\u0010XR\u0014\u0010s\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\br\u0010XR\u0011\u0010u\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\bt\u0010BR\u0011\u0010w\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\bv\u0010B\u00a8\u0006|"}, d2 = {"Lbp1/l;", "", "", "L", "", "dy", "", "isTouch", "", "source", "canScrollVertically", "", "g0", "Lbp1/aa;", "I", "direction", "e0", "Y", "a0", "v", "c0", ReportConstant.COSTREPORT_PREFIX, "r", ExifInterface.LATITUDE_SOUTH, "offset", "H", "u", "totalHeight", HippyHeaderScrollViewController.HEADER_HEIGHT, "headerTitleBarLayoutHeight", "floatHeaderHeight", "contentHeight", "extraStageHeight", "X", "enable", "t", "Landroid/view/View;", "target", "axes", "type", "O", "P", "dx", "", "consumed", "N", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/MotionEvent;", "ev", BdhLogUtil.LogTag.Tag_Req, "M", "Lkotlin/Function0;", "a", "Lkotlin/jvm/functions/Function0;", "E", "()Lkotlin/jvm/functions/Function0;", "U", "(Lkotlin/jvm/functions/Function0;)V", "offsetUpdateCallback", "b", "getRetrieveSavedExtraOffsetCallback", "W", "retrieveSavedExtraOffsetCallback", "c", UserInfo.SEX_FEMALE, "getPreviousOffset", "()F", "setPreviousOffset", "(F)V", "previousOffset", "<set-?>", "d", "D", "Lbp1/a;", "e", "Lbp1/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lbp1/a;", "currentState", "Lbp1/b;", "f", "Lbp1/b;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lbp1/b;", "setCurrentState2", "(Lbp1/b;)V", "currentState2", "g", "()I", "V", "(I)V", "pullRefreshThreshold", tl.h.F, "Lbp1/aa;", "touchStatus", "i", "Z", "hasPreScrollCalled", "j", "refreshExtraOffset", "k", "getDiffBetweenInfoHeaderImageTopAndTitleBottom", "T", "diffBetweenInfoHeaderImageTopAndTitleBottom", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "headerNormalHeight", DomainData.DOMAIN_NAME, "o", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, BdhLogUtil.LogTag.Tag_Conn, "G", "slideUpDistance", HippyTKDListViewAdapter.X, "autoCollapseHeight", "B", "extraStageOffset", "y", "contentOffset", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l {

    /* renamed from: s, reason: collision with root package name */
    private static final int f28784s = (int) cw.d(60);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> offsetUpdateCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Float> retrieveSavedExtraOffsetCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float previousOffset;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float offset;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a currentState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SimpleBehaviorState currentState2;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int pullRefreshThreshold;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private aa touchStatus;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean hasPreScrollCalled;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int refreshExtraOffset;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int diffBetweenInfoHeaderImageTopAndTitleBottom;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int totalHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int headerNormalHeight;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int headerTitleBarLayoutHeight;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int contentHeight;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int extraStageHeight;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int floatHeaderHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            l.this.offset = 0.0f;
            l lVar = l.this;
            boolean z16 = true;
            if (!(lVar.getCurrentState() instanceof NormalState)) {
                lVar.currentState = new NormalState(null, 0.0f, 1, null);
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switch to " + lVar.getCurrentState());
                }
            }
            lVar.getCurrentState().h(lVar.getOffset());
            SimpleBehaviorState currentState2 = lVar.getCurrentState2();
            currentState2.i(bp1.c.a(lVar.getCurrentState()));
            currentState2.h(lVar.getOffset());
            if (currentState2.getOffset() != (-lVar.G()) - lVar.extraStageHeight) {
                z16 = false;
            }
            currentState2.f(z16);
            currentState2.d(lVar.getOffset() + lVar.x());
            if (lVar.G() != 0) {
                currentState2.c((lVar.x() - currentState2.getCollapsingRemainDistance()) / lVar.x());
            } else {
                currentState2.c(0.0f);
            }
            a currentState = lVar.getCurrentState();
            if (currentState != null) {
                Function0<Unit> E = l.this.E();
                if (E != null) {
                    E.invoke();
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.home.subhome.misc.NormalState");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "startCollapseAnimation onEnd offset:" + l.this.getOffset());
            }
            boolean z16 = true;
            if (l.this.getOffset() <= (-l.this.G())) {
                l lVar = l.this;
                if (!(lVar.getCurrentState() instanceof HeaderCollapsedState)) {
                    lVar.currentState = new HeaderCollapsedState(null, l.this.getOffset(), false, 5, null);
                    if (QLog.isDevelopLevel()) {
                        Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switch to " + lVar.getCurrentState());
                    }
                }
                lVar.getCurrentState().h(lVar.getOffset());
                SimpleBehaviorState currentState2 = lVar.getCurrentState2();
                currentState2.i(bp1.c.a(lVar.getCurrentState()));
                currentState2.h(lVar.getOffset());
                if (currentState2.getOffset() != (-lVar.G()) - lVar.extraStageHeight) {
                    z16 = false;
                }
                currentState2.f(z16);
                currentState2.d(lVar.getOffset() + lVar.x());
                if (lVar.G() != 0) {
                    currentState2.c((lVar.x() - currentState2.getCollapsingRemainDistance()) / lVar.x());
                } else {
                    currentState2.c(0.0f);
                }
                a currentState = lVar.getCurrentState();
                if (currentState != null) {
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.home.subhome.misc.HeaderCollapsedState");
                }
            } else {
                l lVar2 = l.this;
                if (!(lVar2.getCurrentState() instanceof HeaderCollapsingState)) {
                    lVar2.currentState = new HeaderCollapsingState(null, l.this.getOffset(), 0.0f, 0.0f, 0.0f, 29, null);
                    if (QLog.isDevelopLevel()) {
                        Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switch to " + lVar2.getCurrentState());
                    }
                }
                lVar2.getCurrentState().h(lVar2.getOffset());
                SimpleBehaviorState currentState22 = lVar2.getCurrentState2();
                currentState22.i(bp1.c.a(lVar2.getCurrentState()));
                currentState22.h(lVar2.getOffset());
                if (currentState22.getOffset() != (-lVar2.G()) - lVar2.extraStageHeight) {
                    z16 = false;
                }
                currentState22.f(z16);
                currentState22.d(lVar2.getOffset() + lVar2.x());
                if (lVar2.G() != 0) {
                    currentState22.c((lVar2.x() - currentState22.getCollapsingRemainDistance()) / lVar2.x());
                } else {
                    currentState22.c(0.0f);
                }
                a currentState3 = lVar2.getCurrentState();
                if (currentState3 != null) {
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.home.subhome.misc.HeaderCollapsingState");
                }
            }
            Function0<Unit> E = l.this.E();
            if (E != null) {
                E.invoke();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements Animator.AnimatorListener {
        public d(l lVar) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            l.this.offset = r6.refreshExtraOffset;
            l lVar = l.this;
            boolean z16 = true;
            if (!(lVar.getCurrentState() instanceof NormalState)) {
                lVar.currentState = new NormalState(null, l.this.refreshExtraOffset, 1, null);
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switch to " + lVar.getCurrentState());
                }
            }
            lVar.getCurrentState().h(lVar.getOffset());
            SimpleBehaviorState currentState2 = lVar.getCurrentState2();
            currentState2.i(bp1.c.a(lVar.getCurrentState()));
            currentState2.h(lVar.getOffset());
            if (currentState2.getOffset() != (-lVar.G()) - lVar.extraStageHeight) {
                z16 = false;
            }
            currentState2.f(z16);
            currentState2.d(lVar.getOffset() + lVar.x());
            if (lVar.G() != 0) {
                currentState2.c((lVar.x() - currentState2.getCollapsingRemainDistance()) / lVar.x());
            } else {
                currentState2.c(0.0f);
            }
            a currentState = lVar.getCurrentState();
            if (currentState != null) {
                Function0<Unit> E = l.this.E();
                if (E != null) {
                    E.invoke();
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.home.subhome.misc.NormalState");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            boolean z16;
            boolean z17;
            Intrinsics.checkNotNullParameter(animator, "animator");
            l lVar = l.this;
            if (!(lVar.getCurrentState() instanceof StartRefreshAnimateState)) {
                lVar.currentState = new StartRefreshAnimateState(null, 0.0f, false, 0, 15, null);
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switch to " + lVar.getCurrentState());
                }
            }
            lVar.getCurrentState().h(lVar.getOffset());
            SimpleBehaviorState currentState2 = lVar.getCurrentState2();
            currentState2.i(bp1.c.a(lVar.getCurrentState()));
            currentState2.h(lVar.getOffset());
            boolean z18 = true;
            if (currentState2.getOffset() == (-lVar.G()) - lVar.extraStageHeight) {
                z16 = true;
            } else {
                z16 = false;
            }
            currentState2.f(z16);
            currentState2.d(lVar.getOffset() + lVar.x());
            if (lVar.G() != 0) {
                currentState2.c((lVar.x() - currentState2.getCollapsingRemainDistance()) / lVar.x());
            } else {
                currentState2.c(0.0f);
            }
            a currentState = lVar.getCurrentState();
            if (currentState != null) {
                StartRefreshAnimateState startRefreshAnimateState = (StartRefreshAnimateState) currentState;
                startRefreshAnimateState.h(lVar.getOffset());
                startRefreshAnimateState.c(lVar.getPullRefreshThreshold());
                if (lVar.getOffset() >= lVar.getPullRefreshThreshold()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                startRefreshAnimateState.a(z17);
                SimpleBehaviorState currentState22 = lVar.getCurrentState2();
                currentState22.g(lVar.getPullRefreshThreshold());
                if (currentState22.getOffset() < lVar.getPullRefreshThreshold()) {
                    z18 = false;
                }
                currentState22.e(z18);
                Function0<Unit> E = l.this.E();
                if (E != null) {
                    E.invoke();
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.home.subhome.misc.StartRefreshAnimateState");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements Animator.AnimatorListener {
        public e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            l lVar = l.this;
            boolean z16 = true;
            if (!(lVar.getCurrentState() instanceof NormalState)) {
                lVar.currentState = new NormalState(null, 0.0f, 1, null);
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switch to " + lVar.getCurrentState());
                }
            }
            lVar.getCurrentState().h(lVar.getOffset());
            SimpleBehaviorState currentState2 = lVar.getCurrentState2();
            currentState2.i(bp1.c.a(lVar.getCurrentState()));
            currentState2.h(lVar.getOffset());
            if (currentState2.getOffset() != (-lVar.G()) - lVar.extraStageHeight) {
                z16 = false;
            }
            currentState2.f(z16);
            currentState2.d(lVar.getOffset() + lVar.x());
            if (lVar.G() != 0) {
                currentState2.c((lVar.x() - currentState2.getCollapsingRemainDistance()) / lVar.x());
            } else {
                currentState2.c(0.0f);
            }
            a currentState = lVar.getCurrentState();
            if (currentState != null) {
                l.this.offset = 0.0f;
                Function0<Unit> E = l.this.E();
                if (E != null) {
                    E.invoke();
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.home.subhome.misc.NormalState");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }
    }

    public l(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.currentState = new NormalState(null, 0.0f, 3, null);
        this.currentState2 = new SimpleBehaviorState(0, 0.0f, 0.0f, 0.0f, false, false, 0, 127, null);
        this.pullRefreshThreshold = f28784s;
        aa I = I();
        this.touchStatus = I;
        I.e(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int G() {
        return this.headerNormalHeight - this.floatHeaderHeight;
    }

    private final aa I() {
        return new aa(new q() { // from class: bp1.g
            @Override // bp1.q
            public final float getOffset() {
                float J;
                J = l.J(l.this);
                return J;
            }
        }, null, new p() { // from class: bp1.h
            @Override // bp1.p
            public final float update(int i3, boolean z16) {
                float K;
                K = l.K(l.this, i3, z16);
                return K;
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float J(l this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.offset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float K(l this$0, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bp1.c.b(this$0.currentState)) {
            return 0.0f;
        }
        float h06 = h0(this$0, i3, z16, "HandleTouch", false, 8, null);
        if (!z16) {
            f0(this$0, 0.0f, 1, null);
        }
        return h06;
    }

    private final void L() {
        float f16;
        Function0<Float> function0 = this.retrieveSavedExtraOffsetCallback;
        if (function0 != null) {
            f16 = function0.invoke().floatValue();
        } else {
            f16 = 0.0f;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "onHeightsChanged(): offset = " + getOffset() + " + " + f16);
        }
        this.offset += f16;
        h0(this, 0, false, "onHeightChanged", false, 8, null);
    }

    private final void Y() {
        boolean z16;
        if (!(getCurrentState() instanceof CollapsingAnimateState)) {
            this.currentState = new CollapsingAnimateState(null, getOffset(), 1, null);
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switch to " + getCurrentState());
            }
        }
        getCurrentState().h(getOffset());
        SimpleBehaviorState currentState2 = getCurrentState2();
        currentState2.i(bp1.c.a(getCurrentState()));
        currentState2.h(getOffset());
        if (currentState2.getOffset() == (-G()) - this.extraStageHeight) {
            z16 = true;
        } else {
            z16 = false;
        }
        currentState2.f(z16);
        currentState2.d(getOffset() + x());
        if (G() != 0) {
            currentState2.c((x() - currentState2.getCollapsingRemainDistance()) / x());
        } else {
            currentState2.c(0.0f);
        }
        a currentState = getCurrentState();
        if (currentState != null) {
            ValueAnimator animator = ValueAnimator.ofFloat(this.offset, -x());
            Logger logger2 = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "startCollapseAnimation offset:" + getOffset() + " autoCollapseHeight:" + x());
            }
            animator.setInterpolator(new DecelerateInterpolator(3.0f));
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: bp1.j
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    l.Z(l.this, valueAnimator);
                }
            });
            Intrinsics.checkNotNullExpressionValue(animator, "animator");
            animator.addListener(new c());
            animator.start();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.home.subhome.misc.CollapsingAnimateState");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(l this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.offset = floatValue;
        boolean z16 = true;
        if (!(this$0.getCurrentState() instanceof CollapsingAnimateState)) {
            this$0.currentState = new CollapsingAnimateState(null, this$0.getOffset(), 1, null);
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switch to " + this$0.getCurrentState());
            }
        }
        this$0.getCurrentState().h(this$0.getOffset());
        SimpleBehaviorState currentState2 = this$0.getCurrentState2();
        currentState2.i(bp1.c.a(this$0.getCurrentState()));
        currentState2.h(this$0.getOffset());
        if (currentState2.getOffset() != (-this$0.G()) - this$0.extraStageHeight) {
            z16 = false;
        }
        currentState2.f(z16);
        currentState2.d(this$0.getOffset() + this$0.x());
        if (this$0.G() != 0) {
            currentState2.c((this$0.x() - currentState2.getCollapsingRemainDistance()) / this$0.x());
        } else {
            currentState2.c(0.0f);
        }
        a currentState = this$0.getCurrentState();
        if (currentState != null) {
            this$0.previousOffset = floatValue;
            Function0<Unit> function0 = this$0.offsetUpdateCallback;
            if (function0 != null) {
                function0.invoke();
            }
            Logger logger2 = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "startCollapseAnimation update offset:" + this$0.getOffset());
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.home.subhome.misc.CollapsingAnimateState");
    }

    private final void a0() {
        ValueAnimator animator = ValueAnimator.ofFloat(this.offset, this.refreshExtraOffset);
        animator.setInterpolator(new DecelerateInterpolator(3.0f));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: bp1.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                l.b0(l.this, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        animator.addListener(new d(this));
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(l this$0, ValueAnimator valueAnimator) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.offset = floatValue;
        this$0.previousOffset = floatValue;
        if (!(this$0.getCurrentState() instanceof RefreshAnimateState)) {
            this$0.currentState = new RefreshAnimateState(null, 0.0f, false, 0, 15, null);
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switch to " + this$0.getCurrentState());
            }
        }
        this$0.getCurrentState().h(this$0.getOffset());
        SimpleBehaviorState currentState2 = this$0.getCurrentState2();
        currentState2.i(bp1.c.a(this$0.getCurrentState()));
        currentState2.h(this$0.getOffset());
        boolean z18 = true;
        if (currentState2.getOffset() == (-this$0.G()) - this$0.extraStageHeight) {
            z16 = true;
        } else {
            z16 = false;
        }
        currentState2.f(z16);
        currentState2.d(this$0.getOffset() + this$0.x());
        if (this$0.G() != 0) {
            currentState2.c((this$0.x() - currentState2.getCollapsingRemainDistance()) / this$0.x());
        } else {
            currentState2.c(0.0f);
        }
        a currentState = this$0.getCurrentState();
        if (currentState != null) {
            RefreshAnimateState refreshAnimateState = (RefreshAnimateState) currentState;
            refreshAnimateState.h(this$0.getOffset());
            refreshAnimateState.c(this$0.getPullRefreshThreshold());
            if (this$0.getOffset() >= this$0.getPullRefreshThreshold()) {
                z17 = true;
            } else {
                z17 = false;
            }
            refreshAnimateState.a(z17);
            SimpleBehaviorState currentState22 = this$0.getCurrentState2();
            currentState22.g(this$0.getPullRefreshThreshold());
            if (currentState22.getOffset() < this$0.getPullRefreshThreshold()) {
                z18 = false;
            }
            currentState22.e(z18);
            Function0<Unit> function0 = this$0.offsetUpdateCallback;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.home.subhome.misc.RefreshAnimateState");
    }

    private final void c0() {
        boolean z16;
        boolean z17;
        boolean z18;
        if (!(getCurrentState() instanceof RestorePullRefreshAnimateState)) {
            this.currentState = new RestorePullRefreshAnimateState(null, 0.0f, false, 0, 15, null);
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switch to " + getCurrentState());
            }
        }
        getCurrentState().h(getOffset());
        SimpleBehaviorState currentState2 = getCurrentState2();
        currentState2.i(bp1.c.a(getCurrentState()));
        currentState2.h(getOffset());
        if (currentState2.getOffset() == (-G()) - this.extraStageHeight) {
            z16 = true;
        } else {
            z16 = false;
        }
        currentState2.f(z16);
        currentState2.d(getOffset() + x());
        if (G() != 0) {
            currentState2.c((x() - currentState2.getCollapsingRemainDistance()) / x());
        } else {
            currentState2.c(0.0f);
        }
        a currentState = getCurrentState();
        if (currentState != null) {
            RestorePullRefreshAnimateState restorePullRefreshAnimateState = (RestorePullRefreshAnimateState) currentState;
            restorePullRefreshAnimateState.h(getOffset());
            restorePullRefreshAnimateState.c(getPullRefreshThreshold());
            if (getOffset() >= getPullRefreshThreshold()) {
                z17 = true;
            } else {
                z17 = false;
            }
            restorePullRefreshAnimateState.a(z17);
            SimpleBehaviorState currentState22 = getCurrentState2();
            currentState22.g(getPullRefreshThreshold());
            if (currentState22.getOffset() >= getPullRefreshThreshold()) {
                z18 = true;
            } else {
                z18 = false;
            }
            currentState22.e(z18);
            ValueAnimator animator = ValueAnimator.ofFloat(this.offset, 0.0f);
            animator.setInterpolator(new DecelerateInterpolator(3.0f));
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: bp1.i
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    l.d0(l.this, valueAnimator);
                }
            });
            Intrinsics.checkNotNullExpressionValue(animator, "animator");
            animator.addListener(new e());
            animator.start();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.home.subhome.misc.RestorePullRefreshAnimateState");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(l this$0, ValueAnimator valueAnimator) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.offset = floatValue;
        this$0.previousOffset = floatValue;
        if (!(this$0.getCurrentState() instanceof RestorePullRefreshAnimateState)) {
            this$0.currentState = new RestorePullRefreshAnimateState(null, 0.0f, false, 0, 15, null);
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switch to " + this$0.getCurrentState());
            }
        }
        this$0.getCurrentState().h(this$0.getOffset());
        SimpleBehaviorState currentState2 = this$0.getCurrentState2();
        currentState2.i(bp1.c.a(this$0.getCurrentState()));
        currentState2.h(this$0.getOffset());
        boolean z18 = true;
        if (currentState2.getOffset() == (-this$0.G()) - this$0.extraStageHeight) {
            z16 = true;
        } else {
            z16 = false;
        }
        currentState2.f(z16);
        currentState2.d(this$0.getOffset() + this$0.x());
        if (this$0.G() != 0) {
            currentState2.c((this$0.x() - currentState2.getCollapsingRemainDistance()) / this$0.x());
        } else {
            currentState2.c(0.0f);
        }
        a currentState = this$0.getCurrentState();
        if (currentState != null) {
            RestorePullRefreshAnimateState restorePullRefreshAnimateState = (RestorePullRefreshAnimateState) currentState;
            restorePullRefreshAnimateState.h(this$0.getOffset());
            restorePullRefreshAnimateState.c(this$0.getPullRefreshThreshold());
            if (this$0.getOffset() >= this$0.getPullRefreshThreshold()) {
                z17 = true;
            } else {
                z17 = false;
            }
            restorePullRefreshAnimateState.a(z17);
            SimpleBehaviorState currentState22 = this$0.getCurrentState2();
            currentState22.g(this$0.getPullRefreshThreshold());
            if (currentState22.getOffset() < this$0.getPullRefreshThreshold()) {
                z18 = false;
            }
            currentState22.e(z18);
            Function0<Unit> function0 = this$0.offsetUpdateCallback;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.home.subhome.misc.RestorePullRefreshAnimateState");
    }

    private final void e0(float direction) {
        a aVar = this.currentState;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switchToAnimateStateIfNeeded() state:" + aVar + " direction=" + direction);
        }
        this.touchStatus.d(true);
        if (bp1.c.d(aVar)) {
            Y();
        } else if (aVar instanceof PullDownRefreshingState) {
            if (((PullDownRefreshingState) aVar).getIsDisplayLoadingView()) {
                a0();
            } else {
                c0();
            }
        }
    }

    static /* synthetic */ void f0(l lVar, float f16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 0.0f;
        }
        lVar.e0(f16);
    }

    private final float g0(int dy5, boolean isTouch, String source, boolean canScrollVertically) {
        boolean z16;
        boolean z17;
        float f16;
        float f17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        Function0<Unit> function0;
        boolean z36;
        boolean z37;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "updateOffsetByDy dy:" + dy5 + " isTouch:" + isTouch + " source(" + source + ") slideUpDistance:" + G() + " offset:" + getOffset());
        }
        float f18 = this.offset;
        this.previousOffset = f18;
        float f19 = dy5;
        float f26 = f18 - f19;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "updateOffsetByDy pendingOffset:" + f26 + " slideUpDistance:" + G() + " ");
        }
        boolean z38 = false;
        if (f26 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && f26 <= (-G())) {
            if (!bp1.c.c(this.currentState) || !canScrollVertically) {
                this.offset = Math.max((-G()) - this.extraStageHeight, f26);
                if (!(getCurrentState() instanceof HeaderCollapsedState)) {
                    this.currentState = new HeaderCollapsedState(null, 0.0f, false, 7, null);
                    if (QLog.isDevelopLevel()) {
                        Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switch to " + getCurrentState());
                    }
                }
                getCurrentState().h(getOffset());
                SimpleBehaviorState currentState2 = getCurrentState2();
                currentState2.i(bp1.c.a(getCurrentState()));
                currentState2.h(getOffset());
                if (currentState2.getOffset() == (-G()) - this.extraStageHeight) {
                    z36 = true;
                } else {
                    z36 = false;
                }
                currentState2.f(z36);
                currentState2.d(getOffset() + x());
                if (G() != 0) {
                    currentState2.c((x() - currentState2.getCollapsingRemainDistance()) / x());
                } else {
                    currentState2.c(0.0f);
                }
                a currentState = getCurrentState();
                if (currentState != null) {
                    HeaderCollapsedState headerCollapsedState = (HeaderCollapsedState) currentState;
                    if (this.offset == (-G()) - this.extraStageHeight) {
                        z37 = true;
                    } else {
                        z37 = false;
                    }
                    headerCollapsedState.k(z37);
                    f16 = this.previousOffset;
                    f17 = this.offset;
                    f19 = f16 - f17;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.home.subhome.misc.HeaderCollapsedState");
                }
            }
            f19 = 0.0f;
        } else if (f26 >= (-G()) && f26 < 0.0f) {
            if (!bp1.c.c(this.currentState) || !canScrollVertically) {
                this.offset = f26;
                if (!(getCurrentState() instanceof HeaderCollapsingState)) {
                    this.currentState = new HeaderCollapsingState(null, 0.0f, 0.0f, 0.0f, 0.0f, 31, null);
                    if (QLog.isDevelopLevel()) {
                        Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switch to " + getCurrentState());
                    }
                }
                getCurrentState().h(getOffset());
                SimpleBehaviorState currentState22 = getCurrentState2();
                currentState22.i(bp1.c.a(getCurrentState()));
                currentState22.h(getOffset());
                if (currentState22.getOffset() == (-G()) - this.extraStageHeight) {
                    z29 = true;
                } else {
                    z29 = false;
                }
                currentState22.f(z29);
                currentState22.d(getOffset() + x());
                if (G() != 0) {
                    currentState22.c((x() - currentState22.getCollapsingRemainDistance()) / x());
                } else {
                    currentState22.c(0.0f);
                }
                a currentState3 = getCurrentState();
                if (currentState3 != null) {
                    HeaderCollapsingState headerCollapsingState = (HeaderCollapsingState) currentState3;
                    headerCollapsingState.n(this.offset + x());
                    headerCollapsingState.o(this.diffBetweenInfoHeaderImageTopAndTitleBottom);
                    if (x() != 0) {
                        headerCollapsingState.m((x() - headerCollapsingState.getRemainDistance()) / x());
                    }
                    f16 = this.previousOffset;
                    f17 = this.offset;
                    f19 = f16 - f17;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.home.subhome.misc.HeaderCollapsingState");
                }
            }
            f19 = 0.0f;
        } else {
            if (f26 > 0.0f) {
                if (isTouch && canScrollVertically && !(this.currentState instanceof PullDownRefreshingState)) {
                    this.offset = 0.0f;
                    if (!(getCurrentState() instanceof NormalState)) {
                        this.currentState = new NormalState(null, 0.0f, 1, null);
                        if (QLog.isDevelopLevel()) {
                            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switch to " + getCurrentState());
                        }
                    }
                    getCurrentState().h(getOffset());
                    SimpleBehaviorState currentState23 = getCurrentState2();
                    currentState23.i(bp1.c.a(getCurrentState()));
                    currentState23.h(getOffset());
                    if (currentState23.getOffset() == (-G()) - this.extraStageHeight) {
                        z28 = true;
                    } else {
                        z28 = false;
                    }
                    currentState23.f(z28);
                    currentState23.d(getOffset() + x());
                    if (G() != 0) {
                        currentState23.c((x() - currentState23.getCollapsingRemainDistance()) / x());
                    } else {
                        currentState23.c(0.0f);
                    }
                    a currentState4 = getCurrentState();
                    if (currentState4 != null) {
                        f16 = this.previousOffset;
                        f17 = this.offset;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.home.subhome.misc.NormalState");
                    }
                } else if (isTouch) {
                    this.offset = Math.max(this.previousOffset - (f19 / 3.0f), 0.1f);
                    if (!(getCurrentState() instanceof PullDownRefreshingState)) {
                        this.currentState = new PullDownRefreshingState(null, 0.0f, false, 0, 15, null);
                        if (QLog.isDevelopLevel()) {
                            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switch to " + getCurrentState());
                        }
                    }
                    getCurrentState().h(getOffset());
                    SimpleBehaviorState currentState24 = getCurrentState2();
                    currentState24.i(bp1.c.a(getCurrentState()));
                    currentState24.h(getOffset());
                    if (currentState24.getOffset() == (-G()) - this.extraStageHeight) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    currentState24.f(z19);
                    currentState24.d(getOffset() + x());
                    if (G() != 0) {
                        currentState24.c((x() - currentState24.getCollapsingRemainDistance()) / x());
                    } else {
                        currentState24.c(0.0f);
                    }
                    a currentState5 = getCurrentState();
                    if (currentState5 != null) {
                        PullDownRefreshingState pullDownRefreshingState = (PullDownRefreshingState) currentState5;
                        pullDownRefreshingState.h(getOffset());
                        pullDownRefreshingState.c(getPullRefreshThreshold());
                        if (getOffset() >= getPullRefreshThreshold()) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                        pullDownRefreshingState.a(z26);
                        SimpleBehaviorState currentState25 = getCurrentState2();
                        currentState25.g(getPullRefreshThreshold());
                        if (currentState25.getOffset() >= getPullRefreshThreshold()) {
                            z27 = true;
                        } else {
                            z27 = false;
                        }
                        currentState25.e(z27);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.home.subhome.misc.PullDownRefreshingState");
                    }
                } else {
                    a aVar = this.currentState;
                    if (!(aVar instanceof PullDownRefreshingState) && dy5 < 0) {
                        this.offset = 0.0f;
                        if (!(getCurrentState() instanceof NormalState)) {
                            this.currentState = new NormalState(null, 0.0f, 1, null);
                            if (QLog.isDevelopLevel()) {
                                Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switch to " + getCurrentState());
                            }
                        }
                        getCurrentState().h(getOffset());
                        SimpleBehaviorState currentState26 = getCurrentState2();
                        currentState26.i(bp1.c.a(getCurrentState()));
                        currentState26.h(getOffset());
                        if (currentState26.getOffset() == (-G()) - this.extraStageHeight) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        currentState26.f(z18);
                        currentState26.d(getOffset() + x());
                        if (G() != 0) {
                            currentState26.c((x() - currentState26.getCollapsingRemainDistance()) / x());
                        } else {
                            currentState26.c(0.0f);
                        }
                        a currentState6 = getCurrentState();
                        if (currentState6 != null) {
                            f16 = this.previousOffset;
                            f17 = this.offset;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.home.subhome.misc.NormalState");
                        }
                    } else {
                        if (aVar instanceof PullDownRefreshingState) {
                            e0(this.offset - this.previousOffset);
                        }
                        f19 = 0.0f;
                    }
                }
            } else {
                this.offset = f26;
                if (!(getCurrentState() instanceof NormalState)) {
                    this.currentState = new NormalState(null, 0.0f, 3, null);
                    if (QLog.isDevelopLevel()) {
                        Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switch to " + getCurrentState());
                    }
                }
                getCurrentState().h(getOffset());
                SimpleBehaviorState currentState27 = getCurrentState2();
                currentState27.i(bp1.c.a(getCurrentState()));
                currentState27.h(getOffset());
                if (currentState27.getOffset() == (-G()) - this.extraStageHeight) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                currentState27.f(z17);
                currentState27.d(getOffset() + x());
                if (G() != 0) {
                    currentState27.c((x() - currentState27.getCollapsingRemainDistance()) / x());
                } else {
                    currentState27.c(0.0f);
                }
                a currentState7 = getCurrentState();
                if (currentState7 != null) {
                    f16 = this.previousOffset;
                    f17 = this.offset;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.home.subhome.misc.NormalState");
                }
            }
            f19 = f16 - f17;
        }
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "updateOffsetByDy finish currentState:" + getCurrentState() + " isTouch:" + isTouch + " consumedDy:" + f19 + " offset:" + getOffset());
        }
        if (this.previousOffset == this.offset) {
            z38 = true;
        }
        if ((!z38 || Intrinsics.areEqual(source, "onHeightChanged")) && (function0 = this.offsetUpdateCallback) != null) {
            function0.invoke();
        }
        return f19;
    }

    static /* synthetic */ float h0(l lVar, int i3, boolean z16, String str, boolean z17, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            str = "Undefined";
        }
        if ((i16 & 8) != 0) {
            z17 = false;
        }
        return lVar.g0(i3, z16, str, z17);
    }

    private final float r() {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "calculateContentOffset() / offset:" + getOffset() + " / -slideUpDistance:" + (-G()) + " / " + this.refreshExtraOffset);
        }
        return Math.max(this.offset, -G());
    }

    private final float s() {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "9020_scroll calculateExtraStageOffset extraStageHeight:" + this.extraStageHeight + " offset:" + getOffset() + " slideUpDistance:" + G());
        }
        if (this.extraStageHeight == 0 || this.offset + G() > 0.0f) {
            return 0.0f;
        }
        return Math.max(Math.min(this.offset + G(), 0.0f), -(G() + this.extraStageHeight));
    }

    private final void v() {
        float f16 = this.offset;
        if (f16 <= 0.0f) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", 1, "finishRefreshAnimation, skip animation restore");
                return;
            }
            return;
        }
        ValueAnimator animator = ValueAnimator.ofFloat(f16, 0.0f);
        animator.setInterpolator(new DecelerateInterpolator(3.0f));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: bp1.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                l.w(l.this, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        animator.addListener(new b());
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(l this$0, ValueAnimator valueAnimator) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.offset = floatValue;
        this$0.previousOffset = floatValue;
        if (!(this$0.getCurrentState() instanceof FinishRefreshAnimateState)) {
            this$0.currentState = new FinishRefreshAnimateState(null, 0.0f, false, 0, 15, null);
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switch to " + this$0.getCurrentState());
            }
        }
        this$0.getCurrentState().h(this$0.getOffset());
        SimpleBehaviorState currentState2 = this$0.getCurrentState2();
        currentState2.i(bp1.c.a(this$0.getCurrentState()));
        currentState2.h(this$0.getOffset());
        boolean z18 = true;
        if (currentState2.getOffset() == (-this$0.G()) - this$0.extraStageHeight) {
            z16 = true;
        } else {
            z16 = false;
        }
        currentState2.f(z16);
        currentState2.d(this$0.getOffset() + this$0.x());
        if (this$0.G() != 0) {
            currentState2.c((this$0.x() - currentState2.getCollapsingRemainDistance()) / this$0.x());
        } else {
            currentState2.c(0.0f);
        }
        a currentState = this$0.getCurrentState();
        if (currentState != null) {
            FinishRefreshAnimateState finishRefreshAnimateState = (FinishRefreshAnimateState) currentState;
            finishRefreshAnimateState.h(this$0.getOffset());
            finishRefreshAnimateState.c(this$0.getPullRefreshThreshold());
            if (this$0.getOffset() >= this$0.getPullRefreshThreshold()) {
                z17 = true;
            } else {
                z17 = false;
            }
            finishRefreshAnimateState.a(z17);
            SimpleBehaviorState currentState22 = this$0.getCurrentState2();
            currentState22.g(this$0.getPullRefreshThreshold());
            if (currentState22.getOffset() < this$0.getPullRefreshThreshold()) {
                z18 = false;
            }
            currentState22.e(z18);
            Function0<Unit> function0 = this$0.offsetUpdateCallback;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.home.subhome.misc.FinishRefreshAnimateState");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int x() {
        return this.headerTitleBarLayoutHeight - this.floatHeaderHeight;
    }

    @NotNull
    /* renamed from: A, reason: from getter */
    public final SimpleBehaviorState getCurrentState2() {
        return this.currentState2;
    }

    public final float B() {
        return s();
    }

    /* renamed from: C, reason: from getter */
    public final int getFloatHeaderHeight() {
        return this.floatHeaderHeight;
    }

    /* renamed from: D, reason: from getter */
    public final float getOffset() {
        return this.offset;
    }

    @Nullable
    public final Function0<Unit> E() {
        return this.offsetUpdateCallback;
    }

    /* renamed from: F, reason: from getter */
    public final int getPullRefreshThreshold() {
        return this.pullRefreshThreshold;
    }

    public final void H(int offset) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "markRefreshExtraOffset(" + offset + ")");
        }
        this.refreshExtraOffset = offset;
    }

    public final boolean M(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        return this.touchStatus.a(ev5);
    }

    public final void N(@NotNull View target, int dx5, int dy5, @NotNull int[] consumed, int type) {
        int sign;
        int roundToInt;
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        sign = MathKt__MathJVMKt.getSign(dy5);
        boolean canScrollVertically = target.canScrollVertically(sign);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "onNestedPreScroll(" + type + ") " + getCurrentState() + " " + dx5 + " " + dy5 + " " + canScrollVertically + " " + target);
        }
        this.touchStatus.d(type != 0);
        this.hasPreScrollCalled = true;
        if (bp1.c.b(this.currentState)) {
            consumed[1] = dy5;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "onNestedPreScroll, animateState handled after " + getCurrentState() + " " + consumed);
                return;
            }
            return;
        }
        if (this.touchStatus.getIsTouch() && type != 0) {
            consumed[1] = dy5;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "onNestedPreScroll, touchStatus handled after " + getCurrentState() + " " + consumed);
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "onNestedPreScroll consume!! " + getCurrentState() + " " + dx5 + " " + dy5 + " " + type + " " + canScrollVertically + " " + target);
        }
        roundToInt = MathKt__MathJVMKt.roundToInt(g0(dy5, type == 0, "onNestedPreScroll", canScrollVertically));
        consumed[1] = roundToInt;
        if (target instanceof RecyclerView) {
            if (QLog.isDevelopLevel()) {
                a currentState = getCurrentState();
                String arrays = Arrays.toString(consumed);
                Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "onNestedPreScroll after " + currentState + " " + arrays + ", scrollState=" + ((RecyclerView) target).getScrollState() + " " + canScrollVertically);
            }
            if (canScrollVertically || consumed[1] != 0 || dy5 == 0) {
                return;
            }
            RecyclerView recyclerView = (RecyclerView) target;
            if (recyclerView.getScrollState() == 2) {
                target.stopNestedScroll();
                recyclerView.stopScroll();
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            a currentState2 = getCurrentState();
            String arrays2 = Arrays.toString(consumed);
            Intrinsics.checkNotNullExpressionValue(arrays2, "toString(this)");
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "onNestedPreScroll after " + currentState2 + " " + arrays2);
        }
    }

    public final void O(@NotNull View target, int axes, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "onNestedScrollAccepted " + getCurrentState() + " " + axes + " " + type + " " + target);
        }
        this.previousOffset = this.offset;
    }

    public final boolean P(@NotNull View target, int axes, int type) {
        boolean z16;
        Intrinsics.checkNotNullParameter(target, "target");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "onStartNestedScroll " + getCurrentState() + " " + axes + " " + type + " " + target);
        }
        aa aaVar = this.touchStatus;
        if ((axes & 2) != 0 && type == 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        aaVar.d(z16);
        this.hasPreScrollCalled = false;
        this.previousOffset = this.offset;
        return true;
    }

    public final void Q(@NotNull View target, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "onStopNestedScroll(" + type + ") currentState:" + getCurrentState() + " target:" + target + ", hasPreScrolledCalled=" + this.hasPreScrollCalled);
        }
        float f16 = this.offset;
        float f17 = f16 - this.previousOffset;
        this.previousOffset = f16;
        if (this.hasPreScrollCalled || ((this.currentState instanceof PullDownRefreshingState) && type == 1)) {
            e0(f17);
        }
    }

    public final void R(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        this.touchStatus.b(ev5);
    }

    public final void S() {
        this.offset = 0.0f;
        boolean z16 = true;
        if (!(getCurrentState() instanceof NormalState)) {
            this.currentState = new NormalState(null, 0.0f, 1, null);
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "switch to " + getCurrentState());
            }
        }
        getCurrentState().h(getOffset());
        SimpleBehaviorState currentState2 = getCurrentState2();
        currentState2.i(bp1.c.a(getCurrentState()));
        currentState2.h(getOffset());
        if (currentState2.getOffset() != (-G()) - this.extraStageHeight) {
            z16 = false;
        }
        currentState2.f(z16);
        currentState2.d(getOffset() + x());
        if (G() != 0) {
            currentState2.c((x() - currentState2.getCollapsingRemainDistance()) / x());
        } else {
            currentState2.c(0.0f);
        }
        a currentState = getCurrentState();
        if (currentState != null) {
            Function0<Unit> function0 = this.offsetUpdateCallback;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.guild.home.subhome.misc.NormalState");
    }

    public final void T(int i3) {
        this.diffBetweenInfoHeaderImageTopAndTitleBottom = i3;
    }

    public final void U(@Nullable Function0<Unit> function0) {
        this.offsetUpdateCallback = function0;
    }

    public final void V(int i3) {
        this.pullRefreshThreshold = i3;
    }

    public final void W(@Nullable Function0<Float> function0) {
        this.retrieveSavedExtraOffsetCallback = function0;
    }

    public final boolean X(int totalHeight, int headerHeight, int headerTitleBarLayoutHeight, int floatHeaderHeight, int contentHeight, int extraStageHeight) {
        int i3;
        if (this.totalHeight == totalHeight && this.headerNormalHeight == headerHeight && this.headerTitleBarLayoutHeight == headerTitleBarLayoutHeight && this.floatHeaderHeight == floatHeaderHeight && this.contentHeight == contentHeight && this.extraStageHeight == extraStageHeight) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", "setupHeights nothing changed totalHeight:" + totalHeight + " headerBarsHeight:" + headerHeight + " coverTitleHeight:" + headerTitleBarLayoutHeight + " floatHeaderHeight:" + floatHeaderHeight + "contentHeight:" + contentHeight + " extraStageHeight:" + extraStageHeight);
                return false;
            }
            return false;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            int i16 = totalHeight - this.totalHeight;
            int i17 = headerHeight - this.headerNormalHeight;
            int i18 = headerTitleBarLayoutHeight - this.headerTitleBarLayoutHeight;
            int floatHeaderHeight2 = floatHeaderHeight - getFloatHeaderHeight();
            int i19 = contentHeight - this.contentHeight;
            int i26 = extraStageHeight - this.extraStageHeight;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setupHeights totalHeight:");
            sb5.append(totalHeight);
            sb5.append(" ");
            sb5.append(i16);
            sb5.append(" headerBarsHeight:");
            sb5.append(headerHeight);
            sb5.append(" ");
            sb5.append(i17);
            sb5.append(" coverTitleHeight:");
            sb5.append(headerTitleBarLayoutHeight);
            sb5.append(" ");
            sb5.append(i18);
            sb5.append(" floatHeaderHeight:");
            sb5.append(floatHeaderHeight);
            sb5.append(" ");
            sb5.append(floatHeaderHeight2);
            sb5.append(" contentHeight:");
            sb5.append(contentHeight);
            sb5.append(" ");
            sb5.append(i19);
            sb5.append(" extraStageHeight:");
            i3 = extraStageHeight;
            sb5.append(i3);
            sb5.append(" ");
            sb5.append(i26);
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", sb5.toString());
        } else {
            i3 = extraStageHeight;
        }
        this.totalHeight = totalHeight;
        this.headerNormalHeight = headerHeight;
        this.floatHeaderHeight = floatHeaderHeight;
        this.headerTitleBarLayoutHeight = headerTitleBarLayoutHeight;
        this.contentHeight = contentHeight;
        this.extraStageHeight = i3;
        L();
        return true;
    }

    public final void t(boolean enable) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehaviorHelper", 1, "enableGesture enable:" + enable);
        }
        this.touchStatus.d(enable);
    }

    public final void u() {
        v();
    }

    public final float y() {
        return r();
    }

    @NotNull
    /* renamed from: z, reason: from getter */
    public final a getCurrentState() {
        return this.currentState;
    }
}
