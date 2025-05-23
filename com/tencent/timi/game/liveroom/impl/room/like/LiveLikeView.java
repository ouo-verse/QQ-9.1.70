package com.tencent.timi.game.liveroom.impl.room.like;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qqlive.data.heart.FreeLove;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.timi.game.liveroom.impl.room.like.LikeConfig;
import com.tencent.timi.game.liveroom.impl.room.like.LikePushMgr;
import com.tencent.timi.game.liveroom.impl.room.like.data.BeLikePathItem;
import com.tencent.timi.game.liveroom.impl.room.like.path.CurvePathProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u00106\u001a\u00020%H\u0002J\b\u00107\u001a\u00020\u001aH\u0002J\b\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u0013H\u0002J\u0012\u0010<\u001a\u0002092\b\u0010=\u001a\u0004\u0018\u00010>H\u0014J\b\u0010?\u001a\u000209H\u0014J\u0012\u0010@\u001a\u0002092\b\u0010A\u001a\u0004\u0018\u00010BH\u0014J\u000e\u0010C\u001a\u0002092\u0006\u00104\u001a\u00020\u001aJ\u0006\u0010D\u001a\u000209J;\u0010E\u001a\u0002092\u0006\u0010F\u001a\u00020\u001a2\u001a\u0010G\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010Hj\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`I2\b\u0010J\u001a\u0004\u0018\u00010\u001dH\u0016\u00a2\u0006\u0002\u0010KJ(\u0010L\u001a\u0002092\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020\bH\u0014J\b\u0010Q\u001a\u000209H\u0002J\b\u0010R\u001a\u000209H\u0002J\b\u0010S\u001a\u000209H\u0002J\u0006\u0010T\u001a\u000209J\b\u0010U\u001a\u000209H\u0002J\b\u0010V\u001a\u000209H\u0002R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006W"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/LiveLikeView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/liveroom/impl/room/like/LikePushMgr$IPushReceiver;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarSize", "curFakeNum", "currentOffsetX", "", "fakeLikeNum", "fakeLikeRunnable", "Ljava/lang/Runnable;", "freeLoveDatas", "", "Lcom/tencent/mobileqq/qqlive/data/heart/FreeLove;", "interpolator", "Landroid/view/animation/LinearInterpolator;", "likeAnimateData", "Lcom/tencent/timi/game/liveroom/impl/room/like/data/BeLikePathItem;", "likeIconSize", "likeRefreshFrequency", "", "likeTrigger", "limitFrequency", "", "getLimitFrequency", "()Z", "setLimitFrequency", "(Z)V", "paint", "Landroid/graphics/Paint;", "path0Provider", "Lcom/tencent/timi/game/liveroom/impl/room/like/path/CurvePathProvider;", "path1Provider", "path2Provider", "path3Provider", "path4Provider", "path5Provider", "path6Provider", "pathProvider", "pointEnd", "Landroid/graphics/PointF;", "pointStart", "pushMgr", "Lcom/tencent/timi/game/liveroom/impl/room/like/LikePushMgr;", "rectDest", "Landroid/graphics/RectF;", "roomId", "triggering", "getCurvePathProvider", "getFloatHeartDuration", "initLikePoint", "", "like", "freeLove", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", NodeProps.ON_DETACHED_FROM_WINDOW, "onDraw", PM.CANVAS, "Landroid/graphics/Canvas;", "onEnterRoom", "onExitRoom", "onLikeReceive", "uid", "freeLoves", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "fromBroadCast", "(JLjava/util/ArrayList;Ljava/lang/Boolean;)V", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "w", tl.h.F, "oldw", "oldh", "refresh", "register", "removeAllCallbacks", "sendAvatarLike", "stopAnimate", "unregister", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class LiveLikeView extends FrameLayout implements LikePushMgr.IPushReceiver {
    private final int avatarSize;
    private int curFakeNum;
    private float currentOffsetX;
    private final int fakeLikeNum;

    @NotNull
    private Runnable fakeLikeRunnable;

    @NotNull
    private List<FreeLove> freeLoveDatas;

    @NotNull
    private LinearInterpolator interpolator;

    @NotNull
    private List<BeLikePathItem> likeAnimateData;
    private final int likeIconSize;
    private long likeRefreshFrequency;

    @NotNull
    private Runnable likeTrigger;
    private boolean limitFrequency;

    @NotNull
    private Paint paint;

    @NotNull
    private CurvePathProvider path0Provider;

    @NotNull
    private CurvePathProvider path1Provider;

    @NotNull
    private CurvePathProvider path2Provider;

    @NotNull
    private CurvePathProvider path3Provider;

    @NotNull
    private CurvePathProvider path4Provider;

    @NotNull
    private CurvePathProvider path5Provider;

    @NotNull
    private CurvePathProvider path6Provider;

    @NotNull
    private CurvePathProvider pathProvider;

    @NotNull
    private PointF pointEnd;

    @NotNull
    private PointF pointStart;

    @NotNull
    private final LikePushMgr pushMgr;

    @NotNull
    private final RectF rectDest;
    private long roomId;
    private boolean triggering;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveLikeView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final CurvePathProvider getCurvePathProvider() {
        switch (Random.INSTANCE.nextInt(0, 8)) {
            case 0:
                return this.pathProvider;
            case 1:
                return this.path1Provider;
            case 2:
                return this.path2Provider;
            case 3:
                return this.path3Provider;
            case 4:
                return this.path4Provider;
            case 5:
                return this.path5Provider;
            case 6:
                return this.path6Provider;
            case 7:
                return this.path0Provider;
            default:
                return this.pathProvider;
        }
    }

    private final long getFloatHeartDuration() {
        return 2350 - Random.INSTANCE.nextInt(0, 700);
    }

    private final void initLikePoint() {
        this.pointStart.x = getWidth() * 0.5f;
        this.pointStart.y = getHeight();
        PointF pointF = this.pointEnd;
        pointF.y = 0.0f;
        pointF.x = getWidth() * 0.5f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void like(FreeLove freeLove) {
        Integer intOrNull;
        int randomIconIdx;
        LikeTouchManager likeTouchManager = LikeTouchManager.INSTANCE;
        if (!likeTouchManager.enableLike(this.roomId) || !likeTouchManager.enableLikeBus(this.roomId)) {
            return;
        }
        List<BeLikePathItem> list = this.likeAnimateData;
        String str = freeLove.loveType;
        Intrinsics.checkNotNullExpressionValue(str, "freeLove.loveType");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
        if (intOrNull != null) {
            randomIconIdx = intOrNull.intValue();
        } else {
            randomIconIdx = LikeConfig.INSTANCE.getConfig().randomIconIdx();
        }
        String str2 = freeLove.likeResId;
        Intrinsics.checkNotNullExpressionValue(str2, "freeLove.likeResId");
        BeLikePathItem beLikePathItem = new BeLikePathItem(randomIconIdx, str2, this.likeIconSize, this.pointStart, this.pointEnd, getFloatHeartDuration(), getCurvePathProvider(), this.interpolator);
        beLikePathItem.begin();
        list.add(beLikePathItem);
        refresh();
    }

    private final void refresh() {
        if (!this.limitFrequency) {
            postInvalidateOnAnimation();
        } else {
            postInvalidateDelayed(this.likeRefreshFrequency);
        }
    }

    private final void register() {
        this.pushMgr.register(this.roomId, this);
    }

    private final void removeAllCallbacks() {
        removeCallbacks(this.likeTrigger);
        removeCallbacks(this.fakeLikeRunnable);
    }

    private final void stopAnimate() {
        this.likeAnimateData.clear();
        this.freeLoveDatas.clear();
    }

    private final void unregister() {
        this.pushMgr.unregister();
    }

    public final boolean getLimitFrequency() {
        return this.limitFrequency;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        boolean z16;
        super.onConfigurationChanged(newConfig);
        if (newConfig != null) {
            if (newConfig.orientation == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.currentOffsetX = getTranslationX();
                setTranslationX(0.0f);
            } else {
                setTranslationX(this.currentOffsetX);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        unregister();
        removeAllCallbacks();
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        ListIterator<BeLikePathItem> listIterator = this.likeAnimateData.listIterator();
        boolean z16 = false;
        while (listIterator.hasNext()) {
            BeLikePathItem next = listIterator.next();
            if (next.getAlive()) {
                Bitmap bitmap = next.getBitmap();
                if (bitmap != null) {
                    this.rectDest.set(0.0f, 0.0f, next.getSize(), next.getSize());
                    this.rectDest.offset(next.getCurX() - (this.rectDest.width() * 0.5f), next.getCurY() - (this.rectDest.width() * 0.5f));
                    this.paint.setAlpha((int) (next.getCurrentAlpha() * 255 * 0.7f));
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
        }
    }

    public final void onEnterRoom(long roomId) {
        this.roomId = roomId;
        unregister();
        register();
        postDelayed(this.fakeLikeRunnable, 5000L);
    }

    public final void onExitRoom() {
        unregister();
        removeAllCallbacks();
        stopAnimate();
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.like.LikePushMgr.IPushReceiver
    public void onLikeReceive(long uid, @Nullable ArrayList<FreeLove> freeLoves, @Nullable Boolean fromBroadCast) {
        boolean z16;
        if (!isAttachedToWindow()) {
            return;
        }
        if (freeLoves != null && !freeLoves.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        if (Intrinsics.areEqual(fromBroadCast, Boolean.FALSE)) {
            this.freeLoveDatas.addAll(freeLoves);
        } else if (uid != com.tencent.mobileqq.qqlive.sail.c.f272176a.G()) {
            this.freeLoveDatas.addAll(freeLoves);
        }
        if (!this.triggering && (!this.freeLoveDatas.isEmpty())) {
            this.triggering = true;
            removeCallbacks(this.likeTrigger);
            removeCallbacks(this.fakeLikeRunnable);
            postDelayed(this.likeTrigger, 84L);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        initLikePoint();
    }

    public final void sendAvatarLike() {
        Integer intOrNull;
        int randomIconIdx;
        LikeTouchManager likeTouchManager = LikeTouchManager.INSTANCE;
        if (!likeTouchManager.enableLike(this.roomId) || !likeTouchManager.enableLikeBus(this.roomId)) {
            return;
        }
        LiveLoginInfo u16 = com.tencent.mobileqq.qqlive.sail.c.f272176a.u();
        if (u16 != null) {
            LikeConfig.INSTANCE.getConfig().loadAvatarBitmap(u16.j());
        }
        List<BeLikePathItem> list = this.likeAnimateData;
        LikeConfig.Companion companion = LikeConfig.INSTANCE;
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(String.valueOf(companion.getConfig().getAvatarMaterialId()));
        if (intOrNull != null) {
            randomIconIdx = intOrNull.intValue();
        } else {
            randomIconIdx = companion.getConfig().randomIconIdx();
        }
        BeLikePathItem beLikePathItem = new BeLikePathItem(randomIconIdx, "", this.avatarSize, this.pointStart, this.pointEnd, getFloatHeartDuration(), getCurvePathProvider(), this.interpolator);
        beLikePathItem.begin();
        list.add(beLikePathItem);
        refresh();
    }

    public final void setLimitFrequency(boolean z16) {
        this.limitFrequency = z16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveLikeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ LiveLikeView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveLikeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.interpolator = new LinearInterpolator();
        this.pathProvider = new CurvePathProvider(fh4.b.d(136), fh4.b.d(40), false);
        this.path0Provider = new CurvePathProvider(fh4.b.d(136), fh4.b.d(40), true);
        this.path1Provider = new CurvePathProvider(fh4.b.d(146), fh4.b.d(30), false);
        this.path2Provider = new CurvePathProvider(fh4.b.d(156), fh4.b.d(35), true);
        this.path3Provider = new CurvePathProvider(fh4.b.d(176), fh4.b.d(32), false);
        this.path4Provider = new CurvePathProvider(fh4.b.d(186), fh4.b.d(30), true);
        this.path5Provider = new CurvePathProvider(fh4.b.d(196), fh4.b.d(31), false);
        this.path6Provider = new CurvePathProvider(fh4.b.d(206), fh4.b.d(35), true);
        int b16 = fh4.b.b(28);
        this.likeIconSize = b16;
        this.avatarSize = fh4.b.b(38);
        this.likeAnimateData = new ArrayList();
        this.rectDest = new RectF(0.0f, 0.0f, b16, b16);
        this.paint = new Paint();
        this.pointStart = new PointF();
        this.pointEnd = new PointF();
        this.likeRefreshFrequency = 32L;
        this.freeLoveDatas = new ArrayList();
        this.fakeLikeNum = Random.INSTANCE.nextInt(4, 7);
        this.pushMgr = new LikePushMgr();
        setWillNotDraw(false);
        this.fakeLikeRunnable = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.like.LiveLikeView.1
            @Override // java.lang.Runnable
            public void run() {
                if (LiveLikeView.this.curFakeNum < LiveLikeView.this.fakeLikeNum) {
                    LiveLikeView.this.curFakeNum++;
                    LiveLikeView.this.like(new FreeLove(String.valueOf(LikeConfig.INSTANCE.getConfig().randomIconIdx()), LikeResourceMgr.INSTANCE.getRandomLikeResId(), 1));
                    LiveLikeView.this.removeCallbacks(this);
                    LiveLikeView.this.postDelayed(this, 2000 / r0.fakeLikeNum);
                }
            }
        };
        this.likeTrigger = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.like.LiveLikeView.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                List list = LiveLikeView.this.freeLoveDatas;
                if (list != null && !list.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    LiveLikeView.this.triggering = false;
                    return;
                }
                LiveLikeView liveLikeView = LiveLikeView.this;
                liveLikeView.like((FreeLove) liveLikeView.freeLoveDatas.remove(0));
                LiveLikeView.this.removeCallbacks(this);
                LiveLikeView.this.postDelayed(this, 84L);
            }
        };
    }
}
