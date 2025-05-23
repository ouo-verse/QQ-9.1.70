package com.tencent.icgame.game.liveroom.impl.room.like;

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
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.FloatRange;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.liveroom.impl.room.like.LiveOwnerLikeView;
import com.tencent.icgame.game.liveroom.impl.room.like.c;
import com.tencent.icgame.game.ui.pag.TimiGamePAGView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.ILiveRoomOperation;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u007f2\u00020\u0001:\u0004\u0080\u0001\u0081\u0001B'\b\u0007\u0012\u0006\u0010y\u001a\u00020x\u0012\n\b\u0002\u0010{\u001a\u0004\u0018\u00010z\u0012\b\b\u0002\u0010|\u001a\u00020\u000e\u00a2\u0006\u0004\b}\u0010~J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J&\u0010\u0018\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0001\u0010\u0016\u001a\u00020\u00062\b\b\u0001\u0010\u0017\u001a\u00020\u0006H\u0002J\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cJ(\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eH\u0014J\u0016\u0010\"\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u0012\u0010%\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010(\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010&H\u0014J\u0006\u0010)\u001a\u00020\u001aJ\u0016\u0010-\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+J\b\u0010.\u001a\u00020\u0004H\u0014R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u00108R\u0016\u0010<\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010;R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020>0=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R$\u0010G\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010C\u001a\u0004\b?\u0010D\"\u0004\bE\u0010FR\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020H0=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010@R\u0016\u0010M\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010PR\u0016\u0010U\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010PR\u0014\u0010X\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010Z\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010`\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b_\u0010\\R\u0016\u0010b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010LR\u0016\u0010d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010LR\u0014\u0010f\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\be\u0010\\R\u0016\u0010h\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010WR\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010\\R\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\"\u0010w\u001a\u00020p8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010v\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/like/LiveOwnerLikeView;", "Landroid/widget/FrameLayout;", "", "f", "", "j", "", HippyTKDListViewAdapter.X, "y", "v", "p", "t", "Lorg/libpag/PAGFile;", "pagFile", "", "width", "o", "r", h.F, "u", "Landroid/graphics/RectF;", CanvasView.ACTION_RECT, BasicAnimation.KeyPath.SCALE_X, BasicAnimation.KeyPath.SCALE_Y, "w", "g", "", "l", "Lcom/tencent/icgame/game/liveroom/impl/room/roomconfig/b;", "event", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "k", "roomId", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "extraInfo", ReportConstant.COSTREPORT_PREFIX, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/icgame/common/api/IAegisLogApi;", "d", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "log", "Lcom/tencent/icgame/game/liveroom/impl/room/like/LikeNumView;", "e", "Lcom/tencent/icgame/game/liveroom/impl/room/like/LikeNumView;", "likeNumView", "Landroid/view/animation/AccelerateDecelerateInterpolator;", "Landroid/view/animation/AccelerateDecelerateInterpolator;", "interpolator", "Lfw0/d;", "Lfw0/d;", "pathProvider", "", "Lcom/tencent/icgame/game/ui/pag/TimiGamePAGView;", "i", "Ljava/util/List;", "likePagList", "Lcom/tencent/icgame/game/liveroom/impl/room/like/LiveOwnerLikeView$a;", "Lcom/tencent/icgame/game/liveroom/impl/room/like/LiveOwnerLikeView$a;", "()Lcom/tencent/icgame/game/liveroom/impl/room/like/LiveOwnerLikeView$a;", "setAnimateStatusListener", "(Lcom/tencent/icgame/game/liveroom/impl/room/like/LiveOwnerLikeView$a;)V", "animateStatusListener", "Lew0/b;", BdhLogUtil.LogTag.Tag_Conn, "likeAnimateData", "D", "Z", "pagInited", "Landroid/graphics/PointF;", "E", "Landroid/graphics/PointF;", "pointStart", UserInfo.SEX_FEMALE, "pointEndLeft", "G", "pointEndRight", "H", "I", "likeIconSize", "Landroid/graphics/RectF;", "rectDest", "Landroid/graphics/Paint;", "J", "Landroid/graphics/Paint;", "paint", "K", "loveAnimateDuration", "L", "comboing", "M", "useLeft", "N", "likeRefreshFrequence", "P", "curLikeNum", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lep4/b;", BdhLogUtil.LogTag.Tag_Req, "Lep4/b;", "loveConfig", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "Ljava/lang/Runnable;", "T", "Ljava/lang/Runnable;", "getComboEndRunnable", "()Ljava/lang/Runnable;", "setComboEndRunnable", "(Ljava/lang/Runnable;)V", "comboEndRunnable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "U", "a", "b", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class LiveOwnerLikeView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<ew0.b> likeAnimateData;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean pagInited;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private PointF pointStart;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private PointF pointEndLeft;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private PointF pointEndRight;

    /* renamed from: H, reason: from kotlin metadata */
    private final int likeIconSize;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final RectF rectDest;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private Paint paint;

    /* renamed from: K, reason: from kotlin metadata */
    private final long loveAnimateDuration;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean comboing;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean useLeft;

    /* renamed from: N, reason: from kotlin metadata */
    private final long likeRefreshFrequence;

    /* renamed from: P, reason: from kotlin metadata */
    private int curLikeNum;

    /* renamed from: Q, reason: from kotlin metadata */
    private long roomId;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private ep4.b loveConfig;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private LiveRoomExtraInfo extraInfo;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private Runnable comboEndRunnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi log;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LikeNumView likeNumView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AccelerateDecelerateInterpolator interpolator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private fw0.d pathProvider;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<TimiGamePAGView> likePagList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a animateStatusListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/like/LiveOwnerLikeView$a;", "", "", "onComboStart", "onComboEnd", "onAnimateEnd", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface a {
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

    private final long f() {
        boolean z16;
        ep4.b bVar = this.loveConfig;
        if (bVar == null) {
            return 700L;
        }
        if (bVar.f396945d == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 700L;
        }
        return r0 * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        LiveRoomExtraInfo liveRoomExtraInfo;
        long j3 = this.roomId;
        if (j3 > 0 && (liveRoomExtraInfo = this.extraInfo) != null && this.curLikeNum > 0) {
            ConcurrentHashMap<String, String> f16 = xw0.b.f448881a.f(j3, liveRoomExtraInfo);
            f16.put("qqlive_combo_real", String.valueOf(this.curLikeNum));
            ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("ev_qqlive_like_combo", f16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.tencent.icgame.game.ui.pag.TimiGamePAGView, T] */
    private final void j() {
        PAGFile o16;
        if (this.pagInited || !((ev0.b) qx0.a.b(ev0.b.class)).t()) {
            return;
        }
        for (int i3 = 0; i3 < 4; i3++) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            objectRef.element = new TimiGamePAGView(context, null, 0, 6, null);
            ((TimiGamePAGView) objectRef.element).setLayoutParams(new ViewGroup.LayoutParams(uu0.a.b(80), uu0.a.b(118)));
            addView((View) objectRef.element);
            this.likePagList.add(objectRef.element);
            PAGComposition Make = PAGComposition.Make(uu0.a.b(80), uu0.a.b(118));
            if (Make == null) {
                return;
            }
            c.Companion companion = com.tencent.icgame.game.liveroom.impl.room.like.c.INSTANCE;
            if (!TextUtils.isEmpty(companion.a().o())) {
                o16 = o(PagViewMonitor.Load(companion.a().o()), uu0.a.b(80));
            } else {
                o16 = o(PagViewMonitor.Load(BaseApplication.getContext().getResources().getAssets(), companion.a().p()), uu0.a.b(80));
            }
            if (o16 == null) {
                return;
            }
            Make.addLayer(o16);
            ((TimiGamePAGView) objectRef.element).setRepeatCount(1);
            ((TimiGamePAGView) objectRef.element).setComposition(Make);
            ((TimiGamePAGView) objectRef.element).setProgress(0.0d);
            ((TimiGamePAGView) objectRef.element).setVisibility(4);
            ((TimiGamePAGView) objectRef.element).b(new c(objectRef));
            this.pagInited = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Ref.IntRef num, LiveOwnerLikeView this$0) {
        Intrinsics.checkNotNullParameter(num, "$num");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num.element >= 10) {
            this$0.likeNumView.setVisibility(0);
        } else {
            this$0.likeNumView.setVisibility(4);
        }
    }

    private final PAGFile o(PAGFile pagFile, int width) {
        if (pagFile == null) {
            return null;
        }
        Matrix totalMatrix = pagFile.getTotalMatrix();
        float width2 = width / pagFile.width();
        totalMatrix.setScale(width2, width2);
        pagFile.setMatrix(totalMatrix);
        return pagFile;
    }

    private final void p(float x16, float y16) {
        this.likeNumView.setTranslationY(y16 - uu0.a.b(175));
        this.likeNumView.setTranslationX(x16 - (r4.getWidth() * 0.5f));
    }

    private final void r() {
        h();
        a aVar = this.animateStatusListener;
        if (aVar != null) {
            aVar.onAnimateEnd();
        }
        this.curLikeNum = 0;
        this.likeNumView.setVisibility(4);
    }

    private final void t(float x16, float y16) {
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
            timiGamePAGView.e();
        }
    }

    private final void u() {
        postInvalidateOnAnimation();
    }

    private final void v(float x16, float y16) {
        PointF pointF = this.pointStart;
        pointF.x = x16;
        pointF.y = y16;
        this.pointEndLeft.y = y16 - uu0.a.b(120);
        this.pointEndLeft.x = this.pointStart.x - uu0.a.b(80);
        this.pointEndRight.y = this.pointStart.y - uu0.a.b(120);
        this.pointEndRight.x = this.pointStart.x + uu0.a.b(80);
    }

    private final void w(RectF rect, @FloatRange(from = -1.0d, to = 1.0d) float scaleX, @FloatRange(from = -1.0d, to = 1.0d) float scaleY) {
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
        return super.dispatchTouchEvent(ev5);
    }

    public final long g() {
        if (this.loveConfig == null) {
            return 0L;
        }
        return r0.f396944c * 1000;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final a getAnimateStatusListener() {
        return this.animateStatusListener;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getComboing() {
        return this.comboing;
    }

    public final boolean l() {
        boolean z16;
        ep4.b bVar = this.loveConfig;
        if (bVar != null && bVar.f396942a) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            this.log.i("LiveOwnerLikeView", "free love disable, return");
        }
        return z16;
    }

    public final void m(float x16, float y16) {
        boolean z16;
        t(x16, y16);
        p(x16, y16);
        v(x16, y16);
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = this.curLikeNum + 1;
        int B = com.tencent.icgame.game.liveroom.impl.room.like.c.INSTANCE.a().B();
        List<ew0.b> list = this.likeAnimateData;
        int i3 = this.likeIconSize;
        PointF pointF = new PointF();
        pointF.set(this.pointStart);
        PointF pointF2 = new PointF();
        if (this.useLeft) {
            pointF2.set(this.pointEndLeft);
        } else {
            pointF2.set(this.pointEndRight);
        }
        ew0.b bVar = new ew0.b(B, i3, pointF, pointF2, this.loveAnimateDuration, this.pathProvider, this.interpolator);
        bVar.a();
        list.add(bVar);
        this.useLeft = !this.useLeft;
        u();
        this.likeNumView.setLikeNum(intRef.element);
        this.likeNumView.post(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.like.g
            @Override // java.lang.Runnable
            public final void run() {
                LiveOwnerLikeView.n(Ref.IntRef.this, this);
            }
        });
        this.curLikeNum = intRef.element;
        removeCallbacks(this.comboEndRunnable);
        postDelayed(this.comboEndRunnable, f());
        if (!this.comboing) {
            a aVar = this.animateStatusListener;
            if (aVar != null) {
                aVar.onComboStart();
            }
            z16 = true;
        } else {
            z16 = false;
        }
        this.comboing = true;
        ILiveRoomOperation A = ((fu0.c) qx0.a.b(fu0.c.class)).A(this.roomId);
        if (A != null) {
            A.sendFloatHeart(z16, String.valueOf(B));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.comboEndRunnable);
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        ListIterator<ew0.b> listIterator = this.likeAnimateData.listIterator();
        boolean z16 = false;
        while (listIterator.hasNext()) {
            ew0.b next = listIterator.next();
            if (next.getAlive()) {
                Bitmap bitmap = next.getCom.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP java.lang.String();
                if (bitmap != null) {
                    RectF rectF = this.rectDest;
                    int i3 = this.likeIconSize;
                    rectF.set(0.0f, 0.0f, i3, i3);
                    this.rectDest.offset(next.getCurX() - (this.rectDest.width() * 0.5f), next.getCurY() - (this.rectDest.width() * 0.5f));
                    w(this.rectDest, next.getCurScale(), next.getCurScale());
                    this.paint.setAlpha((int) (next.getCurrentAlpha() * 255));
                    if (canvas != null) {
                        canvas.drawBitmap(bitmap, (Rect) null, this.rectDest, this.paint);
                    }
                }
                next.g();
            } else {
                listIterator.remove();
            }
            z16 = true;
        }
        if (z16) {
            u();
        } else {
            r();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        j();
    }

    public final void q(@NotNull com.tencent.icgame.game.liveroom.impl.room.roomconfig.b event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ep4.b bVar = event.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
        this.loveConfig = bVar;
        this.log.i("LiveOwnerLikeView", "notifyFreeLoveChanged, config " + bVar);
    }

    public final void s(long roomId, @NotNull LiveRoomExtraInfo extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.roomId = roomId;
        this.extraInfo = extraInfo;
        LiveUserInfo selfUserInfo = ((fu0.c) qx0.a.b(fu0.c.class)).getSelfUserInfo();
        if (selfUserInfo != null) {
            com.tencent.icgame.game.liveroom.impl.room.like.c.INSTANCE.a().y(selfUserInfo.headUrl);
        }
    }

    public final void setAnimateStatusListener(@Nullable a aVar) {
        this.animateStatusListener = aVar;
    }

    public final void setComboEndRunnable(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "<set-?>");
        this.comboEndRunnable = runnable;
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
        Intrinsics.checkNotNullParameter(context, "context");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.log = (IAegisLogApi) api;
        this.interpolator = new AccelerateDecelerateInterpolator();
        this.pathProvider = new fw0.d();
        this.likePagList = new ArrayList();
        this.likeAnimateData = new ArrayList();
        this.pointStart = new PointF();
        this.pointEndLeft = new PointF();
        this.pointEndRight = new PointF();
        int b16 = uu0.a.b(38);
        this.likeIconSize = b16;
        this.rectDest = new RectF(0.0f, 0.0f, b16, b16);
        this.paint = new Paint();
        this.loveAnimateDuration = 1200L;
        this.likeRefreshFrequence = 20L;
        this.comboEndRunnable = new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.like.LiveOwnerLikeView$comboEndRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                long j3;
                LiveOwnerLikeView.this.h();
                LiveOwnerLikeView.this.comboing = false;
                LiveOwnerLikeView.this.curLikeNum = 0;
                LiveOwnerLikeView.a animateStatusListener = LiveOwnerLikeView.this.getAnimateStatusListener();
                if (animateStatusListener != null) {
                    animateStatusListener.onComboEnd();
                }
                fu0.c cVar = (fu0.c) qx0.a.b(fu0.c.class);
                j3 = LiveOwnerLikeView.this.roomId;
                ILiveRoomOperation A = cVar.A(j3);
                if (A != null) {
                    A.sendFloatHeartEnd();
                }
            }
        };
        LayoutInflater.from(getContext()).inflate(R.layout.fbn, this);
        View findViewById = findViewById(R.id.f166051yi3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.likeNumView)");
        this.likeNumView = (LikeNumView) findViewById;
        this.paint.setAntiAlias(true);
        j();
        setWillNotDraw(false);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/like/LiveOwnerLikeView$c", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements PAGView.PAGViewListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<TimiGamePAGView> f115378d;

        c(Ref.ObjectRef<TimiGamePAGView> objectRef) {
            this.f115378d = objectRef;
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(@Nullable PAGView p06) {
            this.f115378d.element.setVisibility(4);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(@Nullable PAGView p06) {
            this.f115378d.element.setVisibility(4);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(@Nullable PAGView p06) {
            this.f115378d.element.setVisibility(0);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(@Nullable PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(@Nullable PAGView p06) {
        }
    }
}
