package cooperation.ad;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.gdtad.IAdConfigApi;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.event.MiniAppAdOpenLandingEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.widget.HongBaoSmartRefreshLayout;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001AB\u000f\u0012\u0006\u0010%\u001a\u00020 \u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J5\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0002J5\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u0005J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001d0\u001cj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001d`\u001eH\u0016R\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u0004\u0018\u00010,8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u00103\u001a\u0004\u0018\u0001008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00106\u001a\u0002048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u00105R\u0016\u0010:\u001a\u0004\u0018\u0001078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00109R\u0016\u0010>\u001a\u0004\u0018\u00010;8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010=\u00a8\u0006B"}, d2 = {"Lcooperation/ad/AmsAdTabGuideModule;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/gdtad/event/MiniAppAdOpenLandingEvent;", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "", "v", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "cb", "p", "", "k", "from", "l", "", "url", DomainData.DOMAIN_NAME, ReportConstant.COSTREPORT_PREFIX, "height", "u", "r", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/activity/home/a;", "d", "Lcom/tencent/mobileqq/activity/home/a;", "getAmsConversationApi", "()Lcom/tencent/mobileqq/activity/home/a;", "amsConversationApi", "e", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", "f", "I", "curHongBaoTitleBarHeight", "Landroid/view/ViewGroup;", "j", "()Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/ImageView;", tl.h.F, "()Landroid/widget/ImageView;", "entranceGuideImageView", "", "()Z", "canShowGuide", "Lcom/tencent/widget/HongBaoSmartRefreshLayout;", "i", "()Lcom/tencent/widget/HongBaoSmartRefreshLayout;", "hbListView", "Landroid/view/View;", "g", "()Landroid/view/View;", "chatListView", "<init>", "(Lcom/tencent/mobileqq/activity/home/a;)V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class AmsAdTabGuideModule implements SimpleEventReceiver<MiniAppAdOpenLandingEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.activity.home.a amsConversationApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtAd mAd;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int curHongBaoTitleBarHeight;

    public AmsAdTabGuideModule(@NotNull com.tencent.mobileqq.activity.home.a amsConversationApi) {
        Intrinsics.checkNotNullParameter(amsConversationApi, "amsConversationApi");
        this.amsConversationApi = amsConversationApi;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final boolean f() {
        if (this.amsConversationApi.j() || this.amsConversationApi.i()) {
            return false;
        }
        return true;
    }

    private final View g() {
        HongBaoSmartRefreshLayout i3 = i();
        if (i3 != null) {
            return i3.findViewById(R.id.tug);
        }
        return null;
    }

    private final ImageView h() {
        View view;
        Conversation conversation = this.amsConversationApi.h().get();
        if (conversation != null) {
            view = conversation.findViewById(R.id.xaq);
        } else {
            view = null;
        }
        if (!(view instanceof ImageView)) {
            return null;
        }
        return (ImageView) view;
    }

    private final HongBaoSmartRefreshLayout i() {
        HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout;
        ViewGroup j3 = j();
        if (j3 != null) {
            hongBaoSmartRefreshLayout = (HongBaoSmartRefreshLayout) j3.findViewById(R.id.f71863pa);
        } else {
            hongBaoSmartRefreshLayout = null;
        }
        if (!(hongBaoSmartRefreshLayout instanceof HongBaoSmartRefreshLayout)) {
            return null;
        }
        return hongBaoSmartRefreshLayout;
    }

    private final ViewGroup j() {
        return this.amsConversationApi.d();
    }

    private final int k() {
        int i3;
        int i16;
        int i17 = this.curHongBaoTitleBarHeight;
        if (i17 > 0) {
            QLog.i("SpringHb_AmsAdTabGuideModule", 1, "getStatusTitleHeight curHongBaoTitleBarHeight:" + i17);
            i16 = this.curHongBaoTitleBarHeight;
        } else {
            View g16 = g();
            if (g16 != null) {
                i3 = g16.getPaddingTop();
            } else {
                i3 = 0;
            }
            if (g16 != null && i3 > 0) {
                QLog.i("SpringHb_AmsAdTabGuideModule", 1, "getStatusTitleHeight listView.paddingTop:" + i3);
                i16 = i3;
            } else {
                View f16 = this.amsConversationApi.f();
                if (f16 != null) {
                    i16 = f16.getHeight();
                } else {
                    i16 = 0;
                }
                QLog.i("SpringHb_AmsAdTabGuideModule", 1, "getStatusTitleHeight titleHeight:" + i16);
            }
        }
        if (i16 <= 0) {
            i16 = ViewUtils.dpToPx(78.0f);
            QLog.i("SpringHb_AmsAdTabGuideModule", 1, "getStatusTitleHeight default:" + i16);
        }
        int dpToPx = i16 + ViewUtils.dpToPx(0.0f);
        QLog.i("SpringHb_AmsAdTabGuideModule", 1, "getStatusTitleHeight:" + dpToPx);
        return dpToPx;
    }

    private final void l(int from) {
        ViewGroup j3;
        QLog.i("SpringHb_AmsAdTabGuideModule", 1, "hideGuide from:" + from);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ImageView h16 = h();
            if (h16 != null && (j3 = j()) != null) {
                j3.removeView(h16);
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cooperation.ad.r
            @Override // java.lang.Runnable
            public final void run() {
                AmsAdTabGuideModule.m(AmsAdTabGuideModule.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(AmsAdTabGuideModule this$0) {
        ViewGroup j3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView h16 = this$0.h();
        if (h16 != null && (j3 = this$0.j()) != null) {
            j3.removeView(h16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String url, Function1<? super Drawable, Unit> cb5) {
        FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(VasDynamicDrawableCache.INSTANCE).k(url).g(new a.c() { // from class: cooperation.ad.u
            @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
            public final void a(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
                AmsAdTabGuideModule.o(kVar);
            }
        }).a();
        a16.c0(new AmsAdTabGuideModule$loadApng$1(a16, url, this, cb5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.y(5);
        it.I(true);
    }

    private final void p(final GdtAd gdtAd, final Function1<? super Drawable, Unit> cb5) {
        ThreadManagerV2.excute(new Runnable() { // from class: cooperation.ad.t
            @Override // java.lang.Runnable
            public final void run() {
                AmsAdTabGuideModule.q(GdtAd.this, this, cb5);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(GdtAd gdtAd, AmsAdTabGuideModule this$0, Function1 cb5) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(gdtAd, "$gdtAd");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        String amsBannerGuideUrl = gdtAd.getAmsBannerGuideUrl();
        Intrinsics.checkNotNullExpressionValue(amsBannerGuideUrl, "gdtAd.amsBannerGuideUrl");
        if (amsBannerGuideUrl.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = gdtAd.getAmsBannerGuideUrl();
            Intrinsics.checkNotNullExpressionValue(str, "gdtAd.amsBannerGuideUrl");
        } else {
            str = "https://amsweb-cdn-gz-1258344696.file.myqcloud.com/PACD_PM/QQmobile/%E5%B0%8F%E6%89%8B_%E6%8F%90%E7%A4%BA%E5%BC%95%E5%AF%BC.png";
        }
        this$0.n(str, cb5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(AmsAdTabGuideModule this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l(4);
    }

    private final void v(GdtAd gdtAd) {
        Context context;
        if (h() != null) {
            QLog.i("SpringHb_AmsAdTabGuideModule", 1, "showGuideImageView hasGuideImageView");
            return;
        }
        ViewGroup j3 = j();
        if (j3 != null) {
            context = j3.getContext();
        } else {
            context = null;
        }
        ViewGroup j16 = j();
        if (j16 != null) {
            ImageView imageView = new ImageView(context);
            imageView.setId(R.id.xaq);
            imageView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(80.0f), ViewUtils.dpToPx(80.0f));
            layoutParams.setMargins(0, k(), 0, 0);
            layoutParams.addRule(14);
            Unit unit = Unit.INSTANCE;
            j16.addView(imageView, layoutParams);
        }
        final ImageView h16 = h();
        if (h16 != null) {
            p(gdtAd, new Function1<Drawable, Unit>() { // from class: cooperation.ad.AmsAdTabGuideModule$showGuideImageView$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                    invoke2(drawable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Drawable drawable) {
                    ((IChatsUtil) QRoute.api(IChatsUtil.class)).sendEventToChat(a.o.f355022a);
                    h16.setImageDrawable(drawable);
                    h16.setVisibility(0);
                    QLog.i("SpringHb_AmsAdTabGuideModule", 1, "showGuideImageView setImageDrawable");
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<MiniAppAdOpenLandingEvent>> getEventClass() {
        ArrayList<Class<MiniAppAdOpenLandingEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(MiniAppAdOpenLandingEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof MiniAppAdOpenLandingEvent) {
            l(3);
            this.amsConversationApi.e().s();
            GdtAd gdtAd = this.mAd;
            if (gdtAd != null) {
                this.amsConversationApi.e().o(gdtAd, 10093);
            }
        }
    }

    public final void r() {
        QLog.i("SpringHb_AmsAdTabGuideModule", 1, "onGuideHide");
        l(4);
    }

    public final void s(@NotNull GdtAd gdtAd) {
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        if (!f()) {
            QLog.i("SpringHb_AmsAdTabGuideModule", 1, "onGuideShow return: is not DefaultTheme or study or elder");
            l(4);
            return;
        }
        if (!((IAdConfigApi) QRoute.api(IAdConfigApi.class)).getCanShowTabAdBannerGuide()) {
            QLog.i("SpringHb_AmsAdTabGuideModule", 1, "onGuideShow return: switch close");
            l(4);
            return;
        }
        QLog.i("SpringHb_AmsAdTabGuideModule", 1, "onGuideShow, data = " + gdtAd);
        this.mAd = gdtAd;
        v(gdtAd);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: cooperation.ad.s
            @Override // java.lang.Runnable
            public final void run() {
                AmsAdTabGuideModule.t(AmsAdTabGuideModule.this);
            }
        }, 2000L);
    }

    public final void u(int height) {
        RelativeLayout.LayoutParams layoutParams;
        this.curHongBaoTitleBarHeight = height;
        QLog.i("SpringHb_AmsAdTabGuideModule", 1, "setHongBaoTitleBarHeight:" + height);
        ImageView h16 = h();
        if (h16 != null) {
            ViewGroup.LayoutParams layoutParams2 = h16.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.setMargins(0, k(), 0, 0);
            }
        }
    }
}
