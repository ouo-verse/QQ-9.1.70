package com.tencent.timi.game.liveroom.impl.room.paylevel.bubble.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Size;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.timi.game.liveroom.impl.room.event.PayLevelFloatingBannerChangedEvent;
import com.tencent.timi.game.liveroom.impl.room.medal.c;
import com.tencent.timi.game.liveroom.impl.room.medal.data.UserLevelInfo;
import com.tencent.timi.game.liveroom.impl.room.medal.data.d;
import com.tencent.timi.game.liveroom.impl.room.medal.g;
import com.tencent.timi.game.liveroom.impl.room.medal.render.e;
import com.tencent.timi.game.liveroom.impl.room.paylevel.bubble.view.PayLevelEnterRoomBubbleView;
import com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserLevelToggle;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import ek4.PayLevelEnterRoomInfo;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001GB'\b\u0007\u0012\u0006\u0010@\u001a\u00020?\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A\u0012\b\b\u0002\u0010C\u001a\u00020\u0010\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J3\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00040\tH\u0002J;\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00040\tH\u0002J5\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142#\u0010\u000e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0016\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\tH\u0002J\u0016\u0010\u001b\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006H"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/paylevel/bubble/view/PayLevelEnterRoomBubbleView;", "Landroid/widget/LinearLayout;", "Lek4/a;", "info", "", "o", "y", "Landroid/view/animation/AnimationSet;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "callback", "p", "", "succeedCount", "failedCount", "r", "", "url", "Landroid/graphics/drawable/Drawable;", "drawable", ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Function0;", "block", "w", NodeProps.VISIBLE, "u", "v", DomainData.DOMAIN_NAME, "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "d", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLogger", "Landroid/graphics/drawable/GradientDrawable;", "e", "Lkotlin/Lazy;", "t", "()Landroid/graphics/drawable/GradientDrawable;", "defaultBgDrawable", "f", "I", "maxCapacity", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "ivIcon", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "tvTip", "Ljava/util/LinkedList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/LinkedList;", "waitingShowInfoList", BdhLogUtil.LogTag.Tag_Conn, "Z", "isAnimationPlaying", "D", "Landroid/view/animation/AnimationSet;", "animationSet", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "E", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class PayLevelEnterRoomBubbleView extends LinearLayout {
    private static final Interpolator F = PathInterpolatorCompat.create(0.65f, 0.0f, 0.35f, 1.0f);
    private static final Interpolator G = PathInterpolatorCompat.create(0.3f, 0.0f, 0.6f, 1.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isAnimationPlaying;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private AnimationSet animationSet;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLogger;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy defaultBgDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int maxCapacity;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView ivIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView tvTip;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<PayLevelEnterRoomInfo> waitingShowInfoList;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/paylevel/bubble/view/PayLevelEnterRoomBubbleView$c", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c extends QCirclePicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f378171e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1<Drawable, Unit> f378172f;

        /* JADX WARN: Multi-variable type inference failed */
        c(String str, Function1<? super Drawable, Unit> function1) {
            this.f378171e = str;
            this.f378172f = function1;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            PayLevelEnterRoomBubbleView.this.aegisLogger.d("Float_Banner|PayLevelEnterRoomBubbleView", "downloadDrawable, state:" + state + ", url:" + this.f378171e);
            if (state == LoadState.STATE_SUCCESS) {
                Function1<Drawable, Unit> function1 = this.f378172f;
                fk4.a aVar = fk4.a.f399760a;
                Context context = PayLevelEnterRoomBubbleView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                function1.invoke(aVar.a(context, option.getResultBitMap()));
                return;
            }
            this.f378172f.invoke(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PayLevelEnterRoomBubbleView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(PayLevelEnterRoomInfo info) {
        if (info.getIsSelf()) {
            this.aegisLogger.d("Float_Banner|PayLevelEnterRoomBubbleView", "addEnterRoomInfoInner, self come ");
            this.waitingShowInfoList.addFirst(info);
            return;
        }
        if (this.waitingShowInfoList.isEmpty()) {
            this.waitingShowInfoList.add(info);
            return;
        }
        boolean z16 = false;
        int i3 = -1;
        long j3 = Long.MAX_VALUE;
        int i16 = 0;
        for (Object obj : this.waitingShowInfoList) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            PayLevelEnterRoomInfo payLevelEnterRoomInfo = (PayLevelEnterRoomInfo) obj;
            if (payLevelEnterRoomInfo.getUid() == info.getUid()) {
                this.aegisLogger.d("Float_Banner|PayLevelEnterRoomBubbleView", "addEnterRoomInfoInner, uid:" + info.getUid() + " is in queue ");
                return;
            }
            if (payLevelEnterRoomInfo.getPayLevel() <= j3) {
                j3 = payLevelEnterRoomInfo.getPayLevel();
                i3 = i16;
            }
            i16 = i17;
        }
        int size = this.waitingShowInfoList.size();
        this.aegisLogger.d("Float_Banner|PayLevelEnterRoomBubbleView", "addEnterRoomInfoInner, lowestLevelIndex:" + i3 + ", lowestLevel:" + j3 + ", size:" + size);
        if (size < this.maxCapacity) {
            this.waitingShowInfoList.add(info);
            return;
        }
        if (info.getPayLevel() <= j3 && info.getPayLevel() > -1) {
            this.aegisLogger.d("Float_Banner|PayLevelEnterRoomBubbleView", "addEnterRoomInfoInner, new comer level:" + info.getPayLevel() + " is lowest ");
            return;
        }
        if (i3 >= 0 && i3 < size) {
            z16 = true;
        }
        if (z16) {
            this.waitingShowInfoList.remove(i3);
            this.waitingShowInfoList.add(info);
        }
    }

    private final void p(PayLevelEnterRoomInfo info, final Function1<? super Boolean, Unit> callback) {
        boolean z16;
        String payLevelIcon = info.getPayLevelIcon();
        boolean z17 = false;
        if (payLevelIcon.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.aegisLogger.w("Float_Banner|PayLevelEnterRoomBubbleView", "bindData, levelIconUrl is empty ");
            callback.invoke(Boolean.FALSE);
            return;
        }
        String payLevelBgImg = info.getPayLevelBgImg();
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.IntRef intRef2 = new Ref.IntRef();
        if (payLevelBgImg.length() > 0) {
            z17 = true;
        }
        if (z17 && UserLevelToggle.INSTANCE.g()) {
            s(payLevelBgImg, new Function1<Drawable, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.paylevel.bubble.view.PayLevelEnterRoomBubbleView$bindData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                    invoke2(drawable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable final Drawable drawable) {
                    PayLevelEnterRoomBubbleView.this.aegisLogger.d("Float_Banner|PayLevelEnterRoomBubbleView", "bindData, downloadDrawable, result:" + drawable);
                    final PayLevelEnterRoomBubbleView payLevelEnterRoomBubbleView = PayLevelEnterRoomBubbleView.this;
                    final Ref.IntRef intRef3 = intRef;
                    final Ref.IntRef intRef4 = intRef2;
                    final Function1<Boolean, Unit> function1 = callback;
                    payLevelEnterRoomBubbleView.w(new Function0<Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.paylevel.bubble.view.PayLevelEnterRoomBubbleView$bindData$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
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
                            Ref.IntRef.this.element++;
                            PayLevelEnterRoomBubbleView payLevelEnterRoomBubbleView2 = payLevelEnterRoomBubbleView;
                            Drawable drawable2 = drawable;
                            if (drawable2 == null) {
                                drawable2 = payLevelEnterRoomBubbleView2.t();
                            }
                            payLevelEnterRoomBubbleView2.setBackground(drawable2);
                            payLevelEnterRoomBubbleView.r(Ref.IntRef.this.element, intRef4.element, function1);
                        }
                    });
                }
            });
        } else {
            setBackground(t());
            intRef.element++;
        }
        this.tvTip.setText(info.getEnterRoomTips());
        this.tvTip.setTextColor(info.getTxtColor());
        ViewGroup.LayoutParams layoutParams = this.ivIcon.getLayoutParams();
        layoutParams.width = fh4.b.a(info.getIconWidth());
        layoutParams.height = fh4.b.a(info.getIconHeight());
        this.ivIcon.setLayoutParams(layoutParams);
        new e().k(new Size(fh4.b.a(info.getIconWidth()), fh4.b.a(info.getIconHeight()))).a(new d(new UserLevelInfo((int) info.getPayLevel(), payLevelIcon)), new c.a<UserLevelInfo, Drawable>() { // from class: com.tencent.timi.game.liveroom.impl.room.paylevel.bubble.view.PayLevelEnterRoomBubbleView$bindData$2
            @Override // com.tencent.timi.game.liveroom.impl.room.medal.c.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(@NotNull g<?> data, @Nullable final Drawable renderResult) {
                Intrinsics.checkNotNullParameter(data, "data");
                PayLevelEnterRoomBubbleView.this.aegisLogger.d("Float_Banner|PayLevelEnterRoomBubbleView", "bindData, onRenderComplete, result:" + renderResult);
                final PayLevelEnterRoomBubbleView payLevelEnterRoomBubbleView = PayLevelEnterRoomBubbleView.this;
                final Ref.IntRef intRef3 = intRef;
                final Ref.IntRef intRef4 = intRef2;
                final Function1<Boolean, Unit> function1 = callback;
                payLevelEnterRoomBubbleView.w(new Function0<Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.paylevel.bubble.view.PayLevelEnterRoomBubbleView$bindData$2$onRenderComplete$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        ImageView imageView;
                        if (renderResult != null) {
                            intRef3.element++;
                            imageView = payLevelEnterRoomBubbleView.ivIcon;
                            imageView.setImageDrawable(renderResult);
                        } else {
                            intRef4.element++;
                        }
                        payLevelEnterRoomBubbleView.r(intRef3.element, intRef4.element, function1);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AnimationSet q(PayLevelEnterRoomInfo info) {
        AnimationSet animationSet = this.animationSet;
        if (animationSet == null) {
            AnimationSet animationSet2 = new AnimationSet(true);
            TranslateAnimation translateAnimation = new TranslateAnimation(2, -1.0f, 2, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(info.getInDuration());
            translateAnimation.setInterpolator(com.tencent.timi.game.liveroom.impl.room.message.stack.a.INSTANCE.a());
            translateAnimation.setFillAfter(true);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(info.getOutDuration());
            alphaAnimation.setStartOffset(info.getInDuration() + info.getStayDuration());
            animationSet2.addAnimation(translateAnimation);
            animationSet2.addAnimation(alphaAnimation);
            animationSet2.setAnimationListener(new b());
            this.animationSet = animationSet2;
            return animationSet2;
        }
        return animationSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(int succeedCount, int failedCount, Function1<? super Boolean, Unit> callback) {
        if (succeedCount + failedCount == 2) {
            if (failedCount == 0) {
                callback.invoke(Boolean.TRUE);
            } else {
                callback.invoke(Boolean.FALSE);
            }
        }
    }

    private final void s(String url, Function1<? super Drawable, Unit> callback) {
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(url), new c(url, callback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GradientDrawable t() {
        return (GradientDrawable) this.defaultBgDrawable.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(boolean visible) {
        SimpleEventBus.getInstance().dispatchEvent(new PayLevelFloatingBannerChangedEvent(visible));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(final Function0<Unit> block) {
        if (RFWThreadManager.isMainThread()) {
            block.invoke();
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.paylevel.bubble.view.a
                @Override // java.lang.Runnable
                public final void run() {
                    PayLevelEnterRoomBubbleView.x(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        if (!this.isAnimationPlaying && !this.waitingShowInfoList.isEmpty()) {
            final PayLevelEnterRoomInfo pollFirst = this.waitingShowInfoList.pollFirst();
            if (pollFirst == null) {
                this.aegisLogger.d("Float_Banner|PayLevelEnterRoomBubbleView", "show, info is null ");
                return;
            } else {
                this.isAnimationPlaying = true;
                p(pollFirst, new Function1<Boolean, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.paylevel.bubble.view.PayLevelEnterRoomBubbleView$show$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        AnimationSet q16;
                        if (!z16) {
                            PayLevelEnterRoomBubbleView.this.isAnimationPlaying = false;
                            PayLevelEnterRoomBubbleView.this.y();
                            return;
                        }
                        PayLevelEnterRoomBubbleView payLevelEnterRoomBubbleView = PayLevelEnterRoomBubbleView.this;
                        PayLevelEnterRoomInfo info = pollFirst;
                        Intrinsics.checkNotNullExpressionValue(info, "info");
                        q16 = payLevelEnterRoomBubbleView.q(info);
                        payLevelEnterRoomBubbleView.startAnimation(q16);
                    }
                });
                return;
            }
        }
        this.aegisLogger.d("Float_Banner|PayLevelEnterRoomBubbleView", "show, is playing or empty list, isAnimationPlaying:" + this.isAnimationPlaying);
    }

    public final void n(@NotNull final PayLevelEnterRoomInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        int i3 = this.maxCapacity;
        if (i3 <= 0) {
            this.aegisLogger.w("Float_Banner|PayLevelEnterRoomBubbleView", "addEnterRoomInfo, maxCapacity:" + i3);
            return;
        }
        if (ScreenUtils.isLandscape()) {
            this.aegisLogger.d("Float_Banner|PayLevelEnterRoomBubbleView", "addEnterRoomInfo, landscape ");
            return;
        }
        if (info.getIsSelf()) {
            com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
            if (com.tencent.mobileqq.qqlive.sail.c.K(cVar, cVar.p(), 0, 2, null)) {
                this.aegisLogger.i("Float_Banner|PayLevelEnterRoomBubbleView", "\u4e3b\u64ad\u5f00\u64ad\uff0c\u8fc7\u6ee4\u81ea\u5df1\u7684\u4ed8\u8d39\u7b49\u7ea7\u98d8\u6761\u6570\u636e\u3002");
                return;
            }
        }
        w(new Function0<Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.paylevel.bubble.view.PayLevelEnterRoomBubbleView$addEnterRoomInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                PayLevelEnterRoomBubbleView.this.o(info);
                PayLevelEnterRoomBubbleView.this.y();
            }
        });
    }

    public final void v() {
        w(new Function0<Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.paylevel.bubble.view.PayLevelEnterRoomBubbleView$onExitRoom$1
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
                LinkedList linkedList;
                AnimationSet animationSet;
                linkedList = PayLevelEnterRoomBubbleView.this.waitingShowInfoList;
                linkedList.clear();
                animationSet = PayLevelEnterRoomBubbleView.this.animationSet;
                if (animationSet != null) {
                    animationSet.cancel();
                }
                PayLevelEnterRoomBubbleView.this.isAnimationPlaying = false;
                PayLevelEnterRoomBubbleView.this.setVisibility(8);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PayLevelEnterRoomBubbleView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ PayLevelEnterRoomBubbleView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PayLevelEnterRoomBubbleView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLogger = (IAegisLogApi) api;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GradientDrawable>() { // from class: com.tencent.timi.game.liveroom.impl.room.paylevel.bubble.view.PayLevelEnterRoomBubbleView$defaultBgDrawable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GradientDrawable invoke() {
                GradientDrawable e16 = fh4.g.e(new GradientDrawable(), fh4.b.d(20), fh4.b.d(20), fh4.b.d(20), fh4.b.d(20));
                e16.setColor(ContextCompat.getColor(PayLevelEnterRoomBubbleView.this.getContext(), R.color.bbd));
                return e16;
            }
        });
        this.defaultBgDrawable = lazy;
        this.maxCapacity = UserLevelToggle.INSTANCE.a();
        this.waitingShowInfoList = new LinkedList<>();
        setLayoutParams(new FrameLayout.LayoutParams(-2, fh4.b.a(24.0f)));
        setOrientation(0);
        setPadding(fh4.b.a(4.0f), fh4.b.a(3.0f), fh4.b.a(12.0f), fh4.b.a(3.0f));
        setGravity(16);
        ImageView imageView = new ImageView(getContext());
        this.ivIcon = imageView;
        imageView.setLayoutParams(new LinearLayout.LayoutParams(fh4.b.a(32.0f), fh4.b.a(16.0f)));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        addView(imageView);
        TextView textView = new TextView(getContext());
        this.tvTip = textView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = fh4.b.a(4.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.f158017al3));
        textView.setTextSize(14.0f);
        textView.setIncludeFontPadding(false);
        addView(textView);
        setVisibility(8);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/paylevel/bubble/view/PayLevelEnterRoomBubbleView$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements Animation.AnimationListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(PayLevelEnterRoomBubbleView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.isAnimationPlaying = false;
            this$0.y();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            AegisLogger.INSTANCE.i("Float_Banner|PayLevelEnterRoomBubbleView", "PayLevelBanner onAnimationEnd");
            PayLevelEnterRoomBubbleView.this.setVisibility(8);
            PayLevelEnterRoomBubbleView.this.u(false);
            final PayLevelEnterRoomBubbleView payLevelEnterRoomBubbleView = PayLevelEnterRoomBubbleView.this;
            payLevelEnterRoomBubbleView.postDelayed(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.paylevel.bubble.view.b
                @Override // java.lang.Runnable
                public final void run() {
                    PayLevelEnterRoomBubbleView.b.b(PayLevelEnterRoomBubbleView.this);
                }
            }, 100L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            AegisLogger.INSTANCE.i("Float_Banner|PayLevelEnterRoomBubbleView", "PayLevelBanner onAnimationStart");
            PayLevelEnterRoomBubbleView.this.setVisibility(0);
            PayLevelEnterRoomBubbleView.this.u(true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }
    }
}
