package com.qzone.reborn.feedpro.banner.topbanner.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.qzone.reborn.event.QZoneFeedxRefreshEvent;
import com.qzone.reborn.feedpro.banner.topbanner.constant.FeedProTopBannerType;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.QZoneHelper;
import ef.d;
import ho.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u001c\u0018\u0000 ?2\u00020\u0001:\u0001@B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b=\u0010>J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u0010\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u001a\u0010\u0017\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00152\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\u0002JQ\u0010\u001d\u001a\u00020\u001c2\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u00182\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u00182\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u0018H\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\"\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u0013H\u0014J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020\u0013H\u0016J\u0012\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J\u001a\u0010*\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010)\u001a\u00020\u0013H\u0014R\u0018\u0010-\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006A"}, d2 = {"Lcom/qzone/reborn/feedpro/banner/topbanner/item/FeedProTopMsgBanner;", "Lcom/qzone/reborn/feedpro/banner/topbanner/item/FeedProBaseTopBanner;", "Landroid/view/View;", "view", "", "z0", "Lqd/a;", "bannerData", "", "A0", "D0", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatarIv", "isVisible", "", "uin", "C0", "E0", "B0", "", "resId", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "w0", "Lkotlin/Function1;", "onStart", "onEnd", "onRepeat", "com/qzone/reborn/feedpro/banner/topbanner/item/FeedProTopMsgBanner$b", "x0", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lcom/qzone/reborn/feedpro/banner/topbanner/item/FeedProTopMsgBanner$b;", "Landroid/content/Context;", "context", "viewType", "initView", "Lcom/qzone/reborn/feedpro/banner/topbanner/constant/FeedProTopBannerType;", "o0", "n0", "v", "p0", "getLayoutId", c.G, "v0", "f", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatarIv1", h.F, "avatarIv2", "i", "avatarIv3", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "bannerTv", BdhLogUtil.LogTag.Tag_Conn, "Lqd/a;", "data", "Ljava/lang/Runnable;", "D", "Ljava/lang/Runnable;", "hideAnimationRunnable", "<init>", "(Landroid/content/Context;)V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class FeedProTopMsgBanner extends FeedProBaseTopBanner {

    /* renamed from: C, reason: from kotlin metadata */
    private qd.a data;

    /* renamed from: D, reason: from kotlin metadata */
    private Runnable hideAnimationRunnable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarIv1;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarIv2;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarIv3;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView bannerTv;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedpro/banner/topbanner/item/FeedProTopMsgBanner$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "anim", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Animation, Unit> f53860d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1<Animation, Unit> f53861e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1<Animation, Unit> f53862f;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Animation, Unit> function1, Function1<? super Animation, Unit> function12, Function1<? super Animation, Unit> function13) {
            this.f53860d = function1;
            this.f53861e = function12;
            this.f53862f = function13;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation anim) {
            Intrinsics.checkNotNullParameter(anim, "anim");
            this.f53861e.invoke(anim);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation anim) {
            Intrinsics.checkNotNullParameter(anim, "anim");
            this.f53862f.invoke(anim);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation anim) {
            Intrinsics.checkNotNullParameter(anim, "anim");
            this.f53860d.invoke(anim);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedProTopMsgBanner(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void D0(qd.a bannerData) {
        List<ld.a> d16 = bannerData.d();
        if (ArrayUtils.isOutOfArrayIndex(0, d16)) {
            QLog.e("BaseWidgetView", 1, "user list is empty");
            return;
        }
        Intrinsics.checkNotNull(d16);
        int size = d16.size();
        if (size == 1) {
            C0(this.avatarIv1, true, d.k(d16.get(0).getUin()));
            C0(this.avatarIv2, false, 0L);
            C0(this.avatarIv3, false, 0L);
        } else if (size != 2) {
            C0(this.avatarIv1, true, d.k(d16.get(0).getUin()));
            C0(this.avatarIv2, true, d.k(d16.get(1).getUin()));
            C0(this.avatarIv3, true, d.k(d16.get(2).getUin()));
        } else {
            C0(this.avatarIv1, true, d.k(d16.get(0).getUin()));
            C0(this.avatarIv2, true, d.k(d16.get(1).getUin()));
            C0(this.avatarIv3, false, 0L);
        }
    }

    private final void E0(qd.a bannerData) {
        TextView textView = this.bannerTv;
        if (textView == null) {
            return;
        }
        textView.setText(bannerData.getBannerText());
    }

    private final Animation w0(int resId) {
        return AnimationUtils.loadAnimation(getContext(), resId);
    }

    private final b x0(Function1<? super Animation, Unit> onStart, Function1<? super Animation, Unit> onEnd, Function1<? super Animation, Unit> onRepeat) {
        return new b(onStart, onEnd, onRepeat);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f130398n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void initView(Context context, int viewType) {
        super.initView(context, viewType);
        this.avatarIv1 = (QZoneUserAvatarView) findViewById(R.id.f206892);
        this.avatarIv2 = (QZoneUserAvatarView) findViewById(R.id.f206993);
        this.avatarIv3 = (QZoneUserAvatarView) findViewById(R.id.f207094);
        this.bannerTv = (TextView) findViewById(R.id.b0w);
        z0(this);
    }

    @Override // com.qzone.reborn.feedpro.banner.topbanner.item.FeedProBaseTopBanner
    public int n0() {
        return 2;
    }

    @Override // com.qzone.reborn.feedpro.banner.topbanner.item.FeedProBaseTopBanner
    public FeedProTopBannerType o0() {
        return FeedProTopBannerType.TYPE_TOP_MSG_BANNER;
    }

    @Override // com.qzone.reborn.feedpro.banner.topbanner.item.FeedProBaseTopBanner
    public void p0(View v3) {
        qd.a aVar = this.data;
        if (aVar != null) {
            if (ud.a.b(aVar)) {
                fl.a u16 = i.u();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                u16.a(context, QZoneHelper.QZoneAppConstants.REFER_PUSH_BANNER, 1);
            } else if (ud.a.a(aVar)) {
                QZoneFeedxRefreshEvent qZoneFeedxRefreshEvent = new QZoneFeedxRefreshEvent();
                qZoneFeedxRefreshEvent.setContext(getContext());
                qZoneFeedxRefreshEvent.setScrollToTop(true);
                SimpleEventBus.getInstance().dispatchEvent(qZoneFeedxRefreshEvent);
            } else {
                QLog.e("FeedProTopMsgBanner", 1, "show error, banner type is " + aVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.BANNER_TYPE java.lang.String());
            }
        }
        clearAnimation();
        Runnable runnable = this.hideAnimationRunnable;
        if (runnable != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(runnable);
        }
        q0();
    }

    private final void z0(View view) {
        if (view != null) {
            fo.c.o(view, "em_qz_friends_update_bubble", new fo.b());
        }
    }

    private final boolean A0(qd.a bannerData) {
        if (TextUtils.isEmpty(bannerData != null ? bannerData.getBannerText() : null)) {
            return false;
        }
        return !ArrayUtils.isOutOfArrayIndex(0, bannerData != null ? bannerData.d() : null);
    }

    private final void B0() {
        Animation w06 = w0(R.anim.f154776cg);
        w06.setAnimationListener(y0(this, null, new Function1<Animation, Unit>() { // from class: com.qzone.reborn.feedpro.banner.topbanner.item.FeedProTopMsgBanner$loadAnimation$hideAnim$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Animation animation) {
                invoke2(animation);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Animation it) {
                Intrinsics.checkNotNullParameter(it, "it");
                FeedProTopMsgBanner.this.q0();
            }
        }, null, 5, null));
        Animation w07 = w0(R.anim.f154775cf);
        w07.setAnimationListener(y0(this, new FeedProTopMsgBanner$loadAnimation$showAnim$1$1(this, w06), new Function1<Animation, Unit>() { // from class: com.qzone.reborn.feedpro.banner.topbanner.item.FeedProTopMsgBanner$loadAnimation$showAnim$1$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Animation it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Animation animation) {
                invoke2(animation);
                return Unit.INSTANCE;
            }
        }, null, 4, null));
        setVisibility(0);
        startAnimation(w07);
    }

    private final void C0(QZoneUserAvatarView avatarIv, boolean isVisible, long uin) {
        if (avatarIv != null) {
            avatarIv.setIsShieldJumpToMainPage(true);
        }
        if (!isVisible) {
            if (avatarIv == null) {
                return;
            }
            avatarIv.setVisibility(8);
        } else {
            if (avatarIv != null) {
                avatarIv.setUser(uin);
            }
            if (avatarIv == null) {
                return;
            }
            avatarIv.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ b y0(FeedProTopMsgBanner feedProTopMsgBanner, Function1 function1, Function1 function12, Function1 function13, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = new Function1<Animation, Unit>() { // from class: com.qzone.reborn.feedpro.banner.topbanner.item.FeedProTopMsgBanner$createAnimationListener$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Animation it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Animation animation) {
                    invoke2(animation);
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i3 & 2) != 0) {
            function12 = new Function1<Animation, Unit>() { // from class: com.qzone.reborn.feedpro.banner.topbanner.item.FeedProTopMsgBanner$createAnimationListener$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Animation it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Animation animation) {
                    invoke2(animation);
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i3 & 4) != 0) {
            function13 = new Function1<Animation, Unit>() { // from class: com.qzone.reborn.feedpro.banner.topbanner.item.FeedProTopMsgBanner$createAnimationListener$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Animation it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Animation animation) {
                    invoke2(animation);
                    return Unit.INSTANCE;
                }
            };
        }
        return feedProTopMsgBanner.x0(function1, function12, function13);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public void bindData(qd.a bannerData, int pos) {
        if (bannerData != null) {
            setVisibility(8);
            if (A0(bannerData)) {
                this.data = bannerData;
                D0(bannerData);
                E0(bannerData);
                B0();
            }
        }
    }
}
