package com.tencent.icgame.game.liveroom.impl.room.like;

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
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.icgame.game.liveroom.impl.room.like.c;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.heart.FreeLove;
import com.tencent.mobileqq.qqlive.data.heart.QLBroadCastFreeLove;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
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
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010s\u001a\u00020r\u0012\n\b\u0002\u0010u\u001a\u0004\u0018\u00010t\u0012\b\b\u0002\u0010v\u001a\u00020\u0017\u00a2\u0006\u0004\bw\u0010xJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014J(\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0006\u0010\u001d\u001a\u00020\u0004J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014J\u0012\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!H\u0014J\b\u0010$\u001a\u00020\u0004H\u0014R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010.\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010*R\u0016\u00100\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010*R\u0016\u00101\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010*R\u0016\u00103\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010*R\u0016\u00105\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010*R\u0016\u00107\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010*R\u0014\u0010:\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010<\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00109R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020>0=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010KR\u0016\u0010Q\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u00108R\u0016\u0010S\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010FR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010FR\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020\t0=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010@R\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010`\u001a\u00020[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010]R\u0016\u0010c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010e\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u00109R\u0016\u0010g\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u00109R\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\"\u0010q\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bl\u0010b\u001a\u0004\bm\u0010n\"\u0004\bo\u0010p\u00a8\u0006y"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/like/LiveLikeView;", "Landroid/widget/FrameLayout;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", ReportConstant.COSTREPORT_PREFIX, "v", "t", "l", "Lcom/tencent/mobileqq/qqlive/data/heart/FreeLove;", "freeLove", DomainData.DOMAIN_NAME, "", "k", "Lfw0/a;", "j", "r", "roomId", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/icgame/game/liveroom/impl/room/roomconfig/b;", "event", "o", "", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "u", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/view/animation/LinearInterpolator;", "d", "Landroid/view/animation/LinearInterpolator;", "interpolator", "e", "Lfw0/a;", "pathProvider", "f", "path0Provider", "path1Provider", "i", "path2Provider", "path3Provider", BdhLogUtil.LogTag.Tag_Conn, "path4Provider", "D", "path5Provider", "E", "path6Provider", UserInfo.SEX_FEMALE, "I", "likeIconSize", "G", "avatarSize", "", "Lew0/a;", "H", "Ljava/util/List;", "likeAnimateData", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "rectDest", "Landroid/graphics/Paint;", "J", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/PointF;", "K", "Landroid/graphics/PointF;", "pointStart", "L", "pointEnd", "", "M", "currentOffsetX", "N", "likeRefreshFrequency", "Lji2/a;", "P", "Lji2/a;", "roomLikeInfoListener", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "freeLoveDatas", "Ljava/lang/Runnable;", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/Runnable;", "likeTrigger", "T", "fakeLikeRunnable", "U", "Z", "triggering", "V", "fakeLikeNum", "W", "curFakeNum", "Lep4/b;", "a0", "Lep4/b;", "loveConfig", "b0", "getLimitFrequency", "()Z", "setLimitFrequency", "(Z)V", "limitFrequency", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class LiveLikeView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private fw0.a path4Provider;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private fw0.a path5Provider;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private fw0.a path6Provider;

    /* renamed from: F, reason: from kotlin metadata */
    private final int likeIconSize;

    /* renamed from: G, reason: from kotlin metadata */
    private final int avatarSize;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private List<ew0.a> likeAnimateData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final RectF rectDest;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private Paint paint;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private PointF pointStart;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private PointF pointEnd;

    /* renamed from: M, reason: from kotlin metadata */
    private float currentOffsetX;

    /* renamed from: N, reason: from kotlin metadata */
    private long likeRefreshFrequency;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private ji2.a roomLikeInfoListener;

    /* renamed from: Q, reason: from kotlin metadata */
    private long roomId;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private List<FreeLove> freeLoveDatas;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private Runnable likeTrigger;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private Runnable fakeLikeRunnable;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean triggering;

    /* renamed from: V, reason: from kotlin metadata */
    private final int fakeLikeNum;

    /* renamed from: W, reason: from kotlin metadata */
    private int curFakeNum;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ep4.b loveConfig;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean limitFrequency;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearInterpolator interpolator;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private fw0.a pathProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private fw0.a path0Provider;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private fw0.a path1Provider;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private fw0.a path2Provider;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private fw0.a path3Provider;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveLikeView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final fw0.a j() {
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

    private final long k() {
        return 2350 - Random.INSTANCE.nextInt(0, 700);
    }

    private final void l() {
        this.pointStart.x = getWidth() * 0.5f;
        this.pointStart.y = getHeight();
        PointF pointF = this.pointEnd;
        pointF.y = 0.0f;
        pointF.x = getWidth() * 0.5f;
    }

    private final boolean m() {
        ep4.b bVar = this.loveConfig;
        if (bVar != null && bVar.f396942a) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(FreeLove freeLove) {
        Integer intOrNull;
        int B;
        if (!m()) {
            return;
        }
        List<ew0.a> list = this.likeAnimateData;
        String str = freeLove.loveType;
        Intrinsics.checkNotNullExpressionValue(str, "freeLove.loveType");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
        if (intOrNull != null) {
            B = intOrNull.intValue();
        } else {
            B = c.INSTANCE.a().B();
        }
        ew0.a aVar = new ew0.a(B, this.likeIconSize, this.pointStart, this.pointEnd, k(), j(), this.interpolator);
        aVar.a();
        list.add(aVar);
        r();
    }

    private final void r() {
        if (!this.limitFrequency) {
            postInvalidateOnAnimation();
        } else {
            postInvalidateDelayed(this.likeRefreshFrequency);
        }
    }

    private final void s() {
        ILiveRoomMessage k3 = ((fu0.c) qx0.a.b(fu0.c.class)).k(this.roomId);
        if (k3 != null) {
            k3.registerOnReceiveFloatHeartListener(this.roomLikeInfoListener);
        }
    }

    private final void t() {
        removeCallbacks(this.likeTrigger);
        removeCallbacks(this.fakeLikeRunnable);
    }

    private final void v() {
        ILiveRoomMessage k3 = ((fu0.c) qx0.a.b(fu0.c.class)).k(this.roomId);
        if (k3 != null) {
            k3.unRegisterOnReceiveFloatHeartListener(this.roomLikeInfoListener);
        }
    }

    public final void o(@NotNull com.tencent.icgame.game.liveroom.impl.room.roomconfig.b event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.loveConfig = event.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
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
        v();
        t();
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        ListIterator<ew0.a> listIterator = this.likeAnimateData.listIterator();
        boolean z16 = false;
        while (listIterator.hasNext()) {
            ew0.a next = listIterator.next();
            if (next.getAlive()) {
                Bitmap bitmap = next.getCom.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP java.lang.String();
                if (bitmap != null) {
                    this.rectDest.set(0.0f, 0.0f, next.getSize(), next.getSize());
                    this.rectDest.offset(next.getCurX() - (this.rectDest.width() * 0.5f), next.getCurY() - (this.rectDest.width() * 0.5f));
                    this.paint.setAlpha((int) (next.getCurrentAlpha() * 255 * 0.7f));
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
            r();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        l();
    }

    public final void p(long roomId) {
        this.roomId = roomId;
        v();
        s();
        postDelayed(this.fakeLikeRunnable, 5000L);
    }

    public final void q() {
        v();
        t();
    }

    public final void setLimitFrequency(boolean z16) {
        this.limitFrequency = z16;
    }

    public final void u() {
        Integer intOrNull;
        int B;
        if (!m()) {
            return;
        }
        LiveUserInfo selfUserInfo = ((fu0.c) qx0.a.b(fu0.c.class)).getSelfUserInfo();
        if (selfUserInfo != null) {
            c.INSTANCE.a().y(selfUserInfo.headUrl);
        }
        List<ew0.a> list = this.likeAnimateData;
        c.Companion companion = c.INSTANCE;
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(String.valueOf(companion.a().getAvatarMaterialId()));
        if (intOrNull != null) {
            B = intOrNull.intValue();
        } else {
            B = companion.a().B();
        }
        ew0.a aVar = new ew0.a(B, this.avatarSize, this.pointStart, this.pointEnd, k(), j(), this.interpolator);
        aVar.a();
        list.add(aVar);
        r();
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
        this.pathProvider = new fw0.a(uu0.a.d(136), uu0.a.d(40), false);
        this.path0Provider = new fw0.a(uu0.a.d(136), uu0.a.d(40), true);
        this.path1Provider = new fw0.a(uu0.a.d(146), uu0.a.d(30), false);
        this.path2Provider = new fw0.a(uu0.a.d(156), uu0.a.d(35), true);
        this.path3Provider = new fw0.a(uu0.a.d(176), uu0.a.d(32), false);
        this.path4Provider = new fw0.a(uu0.a.d(186), uu0.a.d(30), true);
        this.path5Provider = new fw0.a(uu0.a.d(196), uu0.a.d(31), false);
        this.path6Provider = new fw0.a(uu0.a.d(206), uu0.a.d(35), true);
        int b16 = uu0.a.b(28);
        this.likeIconSize = b16;
        this.avatarSize = uu0.a.b(38);
        this.likeAnimateData = new ArrayList();
        this.rectDest = new RectF(0.0f, 0.0f, b16, b16);
        this.paint = new Paint();
        this.pointStart = new PointF();
        this.pointEnd = new PointF();
        this.likeRefreshFrequency = 32L;
        this.freeLoveDatas = new ArrayList();
        this.fakeLikeNum = Random.INSTANCE.nextInt(4, 7);
        setWillNotDraw(false);
        this.fakeLikeRunnable = new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.like.LiveLikeView.1
            @Override // java.lang.Runnable
            public void run() {
                if (LiveLikeView.this.curFakeNum < LiveLikeView.this.fakeLikeNum) {
                    LiveLikeView.this.curFakeNum++;
                    LiveLikeView.this.n(new FreeLove(String.valueOf(c.INSTANCE.a().B()), 1));
                    LiveLikeView.this.removeCallbacks(this);
                    LiveLikeView.this.postDelayed(this, 2000 / r0.fakeLikeNum);
                }
            }
        };
        this.likeTrigger = new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.like.LiveLikeView.2
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
                liveLikeView.n((FreeLove) liveLikeView.freeLoveDatas.remove(0));
                LiveLikeView.this.removeCallbacks(this);
                LiveLikeView.this.postDelayed(this, 84L);
            }
        };
        this.roomLikeInfoListener = new a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J1\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/like/LiveLikeView$a", "Lji2/a;", "Lcom/tencent/mobileqq/qqlive/data/heart/QLBroadCastFreeLove;", "broadCastFreeLove", "", "onReceiveRoomLikePush", "", "uid", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqlive/data/heart/FreeLove;", "freeLoves", "", "fromBroadCast", "onReceiveFreeLove", "(JLjava/util/ArrayList;Ljava/lang/Boolean;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements ji2.a {
        a() {
        }

        @Override // ji2.a
        public void onReceiveFreeLove(long uid, @Nullable ArrayList<FreeLove> freeLoves, @Nullable Boolean fromBroadCast) {
            boolean z16;
            if (!LiveLikeView.this.isAttachedToWindow()) {
                return;
            }
            boolean z17 = false;
            if (freeLoves != null && !freeLoves.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return;
            }
            if (Intrinsics.areEqual(fromBroadCast, Boolean.FALSE)) {
                LiveLikeView.this.freeLoveDatas.addAll(freeLoves);
            } else {
                LiveUserInfo selfUserInfo = ((fu0.c) qx0.a.b(fu0.c.class)).getSelfUserInfo();
                if (selfUserInfo != null && uid == selfUserInfo.uid) {
                    z17 = true;
                }
                if (!z17) {
                    LiveLikeView.this.freeLoveDatas.addAll(freeLoves);
                }
            }
            if (!LiveLikeView.this.triggering && (!LiveLikeView.this.freeLoveDatas.isEmpty())) {
                LiveLikeView.this.triggering = true;
                LiveLikeView liveLikeView = LiveLikeView.this;
                liveLikeView.removeCallbacks(liveLikeView.likeTrigger);
                LiveLikeView liveLikeView2 = LiveLikeView.this;
                liveLikeView2.removeCallbacks(liveLikeView2.fakeLikeRunnable);
                LiveLikeView liveLikeView3 = LiveLikeView.this;
                liveLikeView3.postDelayed(liveLikeView3.likeTrigger, 84L);
            }
        }

        @Override // ji2.a
        public void onReceiveRoomLikePush(@Nullable QLBroadCastFreeLove broadCastFreeLove) {
        }
    }
}
