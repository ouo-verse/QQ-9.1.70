package com.tencent.timi.game.liveroom.impl.room.like;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.FloatRange;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.sail.SailAudienceRoomManager;
import com.tencent.mobileqq.qqlive.sail.report.QQLiveDaTongParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.initer.impl.LibraryInitManager;
import com.tencent.timi.game.liveroom.impl.room.like.LikeConfig;
import com.tencent.timi.game.liveroom.impl.room.like.LiveOwnerLikeView$pagLibLoadListener$2;
import com.tencent.timi.game.liveroom.impl.room.like.data.LikePathItem;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import com.tencent.timi.game.ui.pag.TimiGamePAGView;
import com.tencent.timi.game.utils.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a1\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001#\u0018\u0000 Z2\u00020\u0001:\u0002YZB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0012\u00104\u001a\u00020\u00122\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020+H\u0002J\n\u0010:\u001a\u0004\u0018\u00010;H\u0002J\b\u0010<\u001a\u00020+H\u0002J\b\u0010=\u001a\u000208H\u0002J\u0006\u0010>\u001a\u00020\u0012J\u0016\u0010?\u001a\u0002082\u0006\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u0018J\u001c\u0010B\u001a\u0004\u0018\u00010;2\b\u0010C\u001a\u0004\u0018\u00010;2\u0006\u0010D\u001a\u00020\u0007H\u0002J\u0018\u0010E\u001a\u0002082\u0006\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u0018H\u0002J\b\u0010F\u001a\u000208H\u0002J\b\u0010G\u001a\u000208H\u0014J\u0012\u0010H\u001a\u0002082\b\u0010I\u001a\u0004\u0018\u00010JH\u0014J\u0018\u0010K\u001a\u0002082\u0006\u00100\u001a\u0002012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0006\u0010L\u001a\u000208J(\u0010M\u001a\u0002082\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u0007H\u0014J\u0018\u0010R\u001a\u0002082\u0006\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u0018H\u0002J\b\u0010S\u001a\u000208H\u0002J\u0018\u0010T\u001a\u0002082\u0006\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u0018H\u0002J&\u0010U\u001a\u0002082\b\u0010V\u001a\u0004\u0018\u00010/2\b\b\u0001\u0010W\u001a\u00020\u00182\b\b\u0001\u0010X\u001a\u00020\u0018H\u0002R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u000e\u0010(\u001a\u00020)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006["}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/LiveOwnerLikeView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animateStatusListener", "Lcom/tencent/timi/game/liveroom/impl/room/like/LiveOwnerLikeView$AnimateStatusListener;", "getAnimateStatusListener", "()Lcom/tencent/timi/game/liveroom/impl/room/like/LiveOwnerLikeView$AnimateStatusListener;", "setAnimateStatusListener", "(Lcom/tencent/timi/game/liveroom/impl/room/like/LiveOwnerLikeView$AnimateStatusListener;)V", "comboEndRunnable", "Ljava/lang/Runnable;", "comboing", "", "curLikeNum", "extraInfo", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "lastDownPoint", "Lkotlin/Pair;", "", "likeAnimateData", "", "Lcom/tencent/timi/game/liveroom/impl/room/like/data/LikePathItem;", "likeNumView", "Lcom/tencent/timi/game/liveroom/impl/room/like/LikeNumView;", "likePagList", "Lcom/tencent/timi/game/ui/pag/TimiGamePAGView;", "likeSender", "Lcom/tencent/timi/game/liveroom/impl/room/like/FloatHeartSender;", "pagLibLoadListener", "com/tencent/timi/game/liveroom/impl/room/like/LiveOwnerLikeView$pagLibLoadListener$2$1", "getPagLibLoadListener", "()Lcom/tencent/timi/game/liveroom/impl/room/like/LiveOwnerLikeView$pagLibLoadListener$2$1;", "pagLibLoadListener$delegate", "Lkotlin/Lazy;", "paint", "Landroid/graphics/Paint;", "pointEndLeft", "Landroid/graphics/PointF;", "pointEndRight", "pointStart", "rectDest", "Landroid/graphics/RectF;", "roomId", "", "touchSlop", "useEndLeft", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "dtReport", "", "getEndPoint", "getLikePAGFile", "Lorg/libpag/PAGFile;", "getStartPoint", "initLikePag", "isComboing", "like", HippyTKDListViewAdapter.X, "y", "loadPag", "pagFile", "width", "moveComboToPos", "onAnimateEnd", NodeProps.ON_DETACHED_FROM_WINDOW, "onDraw", PM.CANVAS, "Landroid/graphics/Canvas;", "onEnterRoom", "onExitRoom", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "w", tl.h.F, "oldw", "oldh", "playPagAtPoint", "refresh", "resetLikePoint", "scale", CanvasView.ACTION_RECT, BasicAnimation.KeyPath.SCALE_X, BasicAnimation.KeyPath.SCALE_Y, "AnimateStatusListener", "Companion", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class LiveOwnerLikeView extends FrameLayout {
    private static final int LIKE_NUM_ANIMATION_SHOW_MIN_COUNT = 10;
    private static final long LIKE_REFRESH_FREQUENCY = 20;
    private static final long LOVE_ANIMATION_DURATION_MS = 1200;
    private static final int MAX_CACHE_SIZE = 4;

    @NotNull
    private static final String TAG = "Like_Biz|LiveOwnerLikeView";

    @Nullable
    private AnimateStatusListener animateStatusListener;

    @NotNull
    private Runnable comboEndRunnable;
    private boolean comboing;
    private int curLikeNum;

    @Nullable
    private LiveRoomExtraInfo extraInfo;

    @Nullable
    private Pair<Float, Float> lastDownPoint;

    @NotNull
    private List<LikePathItem> likeAnimateData;

    @NotNull
    private LikeNumView likeNumView;

    @NotNull
    private List<TimiGamePAGView> likePagList;

    @NotNull
    private final FloatHeartSender likeSender;

    /* renamed from: pagLibLoadListener$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy pagLibLoadListener;

    @NotNull
    private Paint paint;

    @NotNull
    private PointF pointEndLeft;

    @NotNull
    private PointF pointEndRight;

    @NotNull
    private PointF pointStart;

    @NotNull
    private final RectF rectDest;
    private long roomId;
    private final int touchSlop;
    private boolean useEndLeft;
    private static final int LIKE_ICON_SIZE = fh4.b.b(38);
    private static final int PAG_THUMB_WIDTH = fh4.b.b(80);
    private static final int PAG_THUMB_HEIGHT = fh4.b.b(118);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/LiveOwnerLikeView$AnimateStatusListener;", "", "onAnimateEnd", "", "onComboEnd", "onComboStart", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public interface AnimateStatusListener {
        void onAnimateEnd();

        void onComboEnd();

        void onComboStart();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveOwnerLikeView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void comboEndRunnable$lambda$0(LiveOwnerLikeView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dtReport();
        this$0.comboing = false;
        this$0.curLikeNum = 0;
        AnimateStatusListener animateStatusListener = this$0.animateStatusListener;
        if (animateStatusListener != null) {
            animateStatusListener.onComboEnd();
        }
        this$0.likeSender.sendFloatHeartEnd();
        this$0.lastDownPoint = null;
    }

    private final void dtReport() {
        if (SailAudienceRoomManager.t(com.tencent.mobileqq.qqlive.sail.c.f272176a.m(), this.roomId, 0, 2, null) != null) {
            com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
            QQLiveDaTongParams f16 = aVar.f(this.roomId);
            f16.m(String.valueOf(this.curLikeNum));
            aVar.i("ev_qqlive_like_combo", f16.a());
        }
    }

    private final PointF getEndPoint() {
        PointF pointF = new PointF();
        if (this.useEndLeft) {
            pointF.set(this.pointEndLeft);
        } else {
            pointF.set(this.pointEndRight);
        }
        this.useEndLeft = !this.useEndLeft;
        return pointF;
    }

    private final PAGFile getLikePAGFile() {
        LikeConfig.Companion companion = LikeConfig.INSTANCE;
        if (!TextUtils.isEmpty(companion.getConfig().getLikePagPath())) {
            return loadPag(PagViewMonitor.Load(companion.getConfig().getLikePagPath()), PAG_THUMB_WIDTH);
        }
        return loadPag(PagViewMonitor.Load(BaseApplication.getContext().getResources().getAssets(), companion.getConfig().getLikePageAssert()), PAG_THUMB_WIDTH);
    }

    private final LiveOwnerLikeView$pagLibLoadListener$2.AnonymousClass1 getPagLibLoadListener() {
        return (LiveOwnerLikeView$pagLibLoadListener$2.AnonymousClass1) this.pagLibLoadListener.getValue();
    }

    private final PointF getStartPoint() {
        PointF pointF = new PointF();
        pointF.set(this.pointStart);
        return pointF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [T, android.view.View, com.tencent.timi.game.ui.pag.TimiGamePAGView] */
    public final void initLikePag() {
        if (this.likePagList.size() > 0) {
            return;
        }
        if (!LibraryInitManager.f377186a.c()) {
            AegisLogger.INSTANCE.e(TAG, "initLikePag", "Pag so it not ready.");
            return;
        }
        for (int i3 = 0; i3 < 4; i3++) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ?? timiGamePAGView = new TimiGamePAGView(context, null, 0, 6, null);
            int i16 = PAG_THUMB_WIDTH;
            int i17 = PAG_THUMB_HEIGHT;
            timiGamePAGView.setLayoutParams(new ViewGroup.LayoutParams(i16, i17));
            objectRef.element = timiGamePAGView;
            addView((View) timiGamePAGView);
            this.likePagList.add(objectRef.element);
            PAGComposition Make = PAGComposition.Make(i16, i17);
            if (Make == null) {
                return;
            }
            PAGFile likePAGFile = getLikePAGFile();
            if (likePAGFile == null) {
                AegisLogger.INSTANCE.e(TAG, "initLikePag", "pagFile is null.");
                return;
            }
            Make.addLayer(likePAGFile);
            ((TimiGamePAGView) objectRef.element).setRepeatCount(1);
            ((TimiGamePAGView) objectRef.element).setComposition(Make);
            ((TimiGamePAGView) objectRef.element).setProgress(0.0d);
            ((TimiGamePAGView) objectRef.element).setVisibility(4);
            ((TimiGamePAGView) objectRef.element).b(new PAGView.PAGViewListener() { // from class: com.tencent.timi.game.liveroom.impl.room.like.LiveOwnerLikeView$initLikePag$1
                @Override // org.libpag.PAGView.PAGViewListener
                public void onAnimationCancel(@Nullable PAGView p06) {
                    objectRef.element.setVisibility(4);
                }

                @Override // org.libpag.PAGView.PAGViewListener
                public void onAnimationEnd(@Nullable PAGView p06) {
                    objectRef.element.setVisibility(4);
                    AegisLogger.INSTANCE.i("Like_Biz|LiveOwnerLikeView", "LikePage animation end");
                }

                @Override // org.libpag.PAGView.PAGViewListener
                public void onAnimationStart(@Nullable PAGView p06) {
                    objectRef.element.setVisibility(0);
                    AegisLogger.INSTANCE.i("Like_Biz|LiveOwnerLikeView", "LikePage animation start");
                }

                @Override // org.libpag.PAGView.PAGViewListener
                public void onAnimationRepeat(@Nullable PAGView p06) {
                }

                @Override // org.libpag.PAGView.PAGViewListener
                public void onAnimationUpdate(@Nullable PAGView p06) {
                }
            });
        }
        AegisLogger.INSTANCE.i(TAG, "initLikePag done, size:" + this.likePagList.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void like$lambda$3(Ref.IntRef num, LiveOwnerLikeView this$0) {
        Intrinsics.checkNotNullParameter(num, "$num");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num.element >= 10) {
            this$0.likeNumView.setVisibility(0);
        } else {
            this$0.likeNumView.setVisibility(4);
        }
    }

    private final PAGFile loadPag(PAGFile pagFile, int width) {
        if (pagFile == null) {
            return null;
        }
        Matrix totalMatrix = pagFile.getTotalMatrix();
        float width2 = width / pagFile.width();
        totalMatrix.setScale(width2, width2);
        pagFile.setMatrix(totalMatrix);
        return pagFile;
    }

    private final void moveComboToPos(float x16, float y16) {
        this.likeNumView.setTranslationY(y16 - fh4.b.b(175));
        this.likeNumView.setTranslationX(x16 - (r4.getWidth() * 0.5f));
    }

    private final void onAnimateEnd() {
        dtReport();
        AnimateStatusListener animateStatusListener = this.animateStatusListener;
        if (animateStatusListener != null) {
            animateStatusListener.onAnimateEnd();
        }
        this.curLikeNum = 0;
        this.likeNumView.setVisibility(4);
    }

    private final void playPagAtPoint(float x16, float y16) {
        Object obj;
        boolean z16;
        Iterator<T> it = this.likePagList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((TimiGamePAGView) obj).getVisibility() == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        TimiGamePAGView timiGamePAGView = (TimiGamePAGView) obj;
        if (timiGamePAGView != null) {
            timiGamePAGView.setTranslationX(x16 - (timiGamePAGView.getWidth() * 0.5f));
            timiGamePAGView.setTranslationY(y16 - (timiGamePAGView.getHeight() * 0.8f));
            timiGamePAGView.setProgress(0.0d);
            timiGamePAGView.g();
        }
    }

    private final void refresh() {
        postInvalidateOnAnimation();
    }

    private final void resetLikePoint(float x16, float y16) {
        PointF pointF = this.pointStart;
        pointF.x = x16;
        pointF.y = y16;
        this.pointEndLeft.y = y16 - fh4.b.b(120);
        this.pointEndLeft.x = this.pointStart.x - fh4.b.b(80);
        this.pointEndRight.y = this.pointStart.y - fh4.b.b(120);
        this.pointEndRight.x = this.pointStart.x + fh4.b.b(80);
    }

    private final void scale(RectF rect, @FloatRange(from = -1.0d, to = 1.0d) float scaleX, @FloatRange(from = -1.0d, to = 1.0d) float scaleY) {
        if (rect != null) {
            float width = rect.width() * scaleX;
            float height = rect.height() * scaleY;
            float width2 = rect.width() - width;
            float f16 = 2;
            float f17 = width2 / f16;
            float height2 = (rect.height() - height) / f16;
            rect.set(rect.left + f17, rect.top + height2, rect.right - f17, rect.bottom - height2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        boolean z16;
        if (ev5 != null && ev5.getAction() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        if (this.lastDownPoint == null) {
            this.lastDownPoint = new Pair<>(Float.valueOf(ev5.getX()), Float.valueOf(ev5.getY()));
        }
        if (this.comboing) {
            like(ev5.getX(), ev5.getY());
            this.lastDownPoint = null;
            return true;
        }
        Pair<Float, Float> pair = this.lastDownPoint;
        if (pair != null) {
            float abs = Math.abs(pair.getFirst().floatValue() - ev5.getX());
            float abs2 = Math.abs(pair.getSecond().floatValue() - ev5.getY());
            int i3 = this.touchSlop;
            if (abs > i3 || abs2 > i3) {
                this.lastDownPoint = null;
                return false;
            }
        }
        if (!o.e("live_like", BusConfigHelper.f378723a.e(this.roomId))) {
            return false;
        }
        like(ev5.getX(), ev5.getY());
        this.lastDownPoint = null;
        return true;
    }

    @Nullable
    public final AnimateStatusListener getAnimateStatusListener() {
        return this.animateStatusListener;
    }

    /* renamed from: isComboing, reason: from getter */
    public final boolean getComboing() {
        return this.comboing;
    }

    public final void like(float x16, float y16) {
        AnimateStatusListener animateStatusListener;
        playPagAtPoint(x16, y16);
        moveComboToPos(x16, y16);
        resetLikePoint(x16, y16);
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = this.curLikeNum + 1;
        int randomIconIdx = LikeConfig.INSTANCE.getConfig().randomIconIdx();
        String randomLikeResId = LikeResourceMgr.INSTANCE.getRandomLikeResId();
        List<LikePathItem> list = this.likeAnimateData;
        LikePathItem likePathItem = new LikePathItem(randomIconIdx, randomLikeResId, LIKE_ICON_SIZE, getStartPoint(), getEndPoint(), 1200L, null, null, 192, null);
        likePathItem.begin();
        list.add(likePathItem);
        refresh();
        this.likeNumView.setLikeNum(intRef.element);
        this.likeNumView.post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.like.h
            @Override // java.lang.Runnable
            public final void run() {
                LiveOwnerLikeView.like$lambda$3(Ref.IntRef.this, this);
            }
        });
        this.curLikeNum = intRef.element;
        removeCallbacks(this.comboEndRunnable);
        postDelayed(this.comboEndRunnable, BusConfigHelper.f378723a.c(this.roomId));
        if (!this.comboing && (animateStatusListener = this.animateStatusListener) != null) {
            animateStatusListener.onComboStart();
        }
        this.likeSender.sendFloatHeart(this.roomId, !this.comboing, String.valueOf(randomIconIdx), randomLikeResId);
        this.comboing = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.comboEndRunnable);
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        ListIterator<LikePathItem> listIterator = this.likeAnimateData.listIterator();
        boolean z16 = false;
        while (listIterator.hasNext()) {
            LikePathItem next = listIterator.next();
            if (next.getAlive()) {
                Bitmap bitmap = next.getBitmap();
                if (bitmap != null) {
                    RectF rectF = this.rectDest;
                    int i3 = LIKE_ICON_SIZE;
                    rectF.set(0.0f, 0.0f, i3, i3);
                    this.rectDest.offset(next.getCurX() - (this.rectDest.width() * 0.5f), next.getCurY() - (this.rectDest.width() * 0.5f));
                    scale(this.rectDest, next.getCurScale(), next.getCurScale());
                    this.paint.setAlpha((int) (next.getCurrentAlpha() * 255));
                    if (canvas != null) {
                        canvas.drawBitmap(bitmap, (Rect) null, this.rectDest, this.paint);
                    }
                }
                next.nextFrame();
            } else {
                listIterator.remove();
            }
            z16 = true;
        }
        if (z16) {
            refresh();
        } else {
            onAnimateEnd();
        }
    }

    public final void onEnterRoom(long roomId, @Nullable LiveRoomExtraInfo extraInfo) {
        this.roomId = roomId;
        this.extraInfo = extraInfo;
        LiveLoginInfo u16 = com.tencent.mobileqq.qqlive.sail.c.f272176a.u();
        if (u16 != null) {
            LikeConfig.INSTANCE.getConfig().loadAvatarBitmap(u16.j());
        }
        initLikePag();
    }

    public final void onExitRoom() {
        LibraryInitManager.f377186a.i(getPagLibLoadListener());
        this.likeAnimateData.clear();
        this.likePagList.clear();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        initLikePag();
    }

    public final void setAnimateStatusListener(@Nullable AnimateStatusListener animateStatusListener) {
        this.animateStatusListener = animateStatusListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveOwnerLikeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ LiveOwnerLikeView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveOwnerLikeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.likePagList = new ArrayList();
        this.likeAnimateData = new ArrayList();
        this.pointStart = new PointF();
        this.pointEndLeft = new PointF();
        this.pointEndRight = new PointF();
        int i16 = LIKE_ICON_SIZE;
        this.rectDest = new RectF(0.0f, 0.0f, i16, i16);
        this.paint = new Paint();
        this.likeSender = new FloatHeartSender();
        this.touchSlop = 150;
        this.comboEndRunnable = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.like.g
            @Override // java.lang.Runnable
            public final void run() {
                LiveOwnerLikeView.comboEndRunnable$lambda$0(LiveOwnerLikeView.this);
            }
        };
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LiveOwnerLikeView$pagLibLoadListener$2.AnonymousClass1>() { // from class: com.tencent.timi.game.liveroom.impl.room.like.LiveOwnerLikeView$pagLibLoadListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.timi.game.liveroom.impl.room.like.LiveOwnerLikeView$pagLibLoadListener$2$1] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AnonymousClass1 invoke() {
                final LiveOwnerLikeView liveOwnerLikeView = LiveOwnerLikeView.this;
                return new hi4.c() { // from class: com.tencent.timi.game.liveroom.impl.room.like.LiveOwnerLikeView$pagLibLoadListener$2.1
                    @Override // hi4.c
                    public void onLoaded() {
                        AegisLogger.INSTANCE.e("Like_Biz|LiveOwnerLikeView", "pagLibLoadListener", "Pag so load ready.");
                        LiveOwnerLikeView.this.initLikePag();
                    }
                };
            }
        });
        this.pagLibLoadListener = lazy;
        LayoutInflater.from(getContext()).inflate(R.layout.hud, this);
        View findViewById = findViewById(R.id.f166051yi3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.likeNumView)");
        this.likeNumView = (LikeNumView) findViewById;
        this.paint.setAntiAlias(true);
        LibraryInitManager.f377186a.h(getPagLibLoadListener());
        setWillNotDraw(false);
    }
}
