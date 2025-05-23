package com.tencent.mobileqq.qwallet.home.tips;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewGroupKt;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.utils.QWalletUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.pay.PayChannelUtils;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.fakeurl.QWalletFakeUrlHandler;
import com.tenpay.sdk.fakeurl.utils.FakeUrlUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 42\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010$\u001a\u00020!\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J$\u0010\u0010\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R&\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00040%j\b\u0012\u0004\u0012\u00020\u0004`&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/tips/q;", "", "", "o", "Lcom/qwallet/data/d;", "tips", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "", "actionName", "D", "G", "Landroid/view/View;", "oldTipsView", "Lkotlin/Function0;", "completeCallback", "r", "homeBelt", "w", "j", "Landroid/content/Context;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "view", BdhLogUtil.LogTag.Tag_Conn, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "E", UserInfo.SEX_FEMALE, "p", "tenpayBelt", DomainData.DOMAIN_NAME, "a", "Landroid/content/Context;", "Lcom/tencent/mobileqq/qwallet/home/tips/TopTipsV2Layout;", "b", "Lcom/tencent/mobileqq/qwallet/home/tips/TopTipsV2Layout;", "topTipsLayout", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "waitList", "d", "Lcom/qwallet/data/d;", "currentBelt", "e", "Landroid/view/View$OnClickListener;", "f", "Landroid/view/View$OnClickListener;", "mTipsClickListener", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/qwallet/home/tips/TopTipsV2Layout;)V", "g", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TopTipsV2Layout topTipsLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<com.qwallet.data.d> waitList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.qwallet.data.d currentBelt;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.qwallet.data.d tenpayBelt;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener mTipsClickListener;

    public q(@NotNull Context context, @NotNull TopTipsV2Layout topTipsLayout) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(topTipsLayout, "topTipsLayout");
        this.context = context;
        this.topTipsLayout = topTipsLayout;
        this.waitList = new ArrayList<>();
        this.mTipsClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.home.tips.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.z(q.this, view);
            }
        };
    }

    private final void A(com.qwallet.data.d tips) {
        if (tips == null) {
            return;
        }
        D("tuijian.belt.click", tips);
    }

    private final void B(com.qwallet.data.d tips) {
        D("tuijian.belt.show", tips);
    }

    private final void C(View view, com.qwallet.data.d tips) {
        ((MarqueeTextView2) view.findViewById(R.id.t65)).setText(tips.getName());
        QWalletUtils.x(view, tips.getName());
    }

    private final void D(String actionName, com.qwallet.data.d tips) {
        com.tencent.mobileqq.qwallet.c.f(actionName, tips.getName(), null, null, null, 28, null);
    }

    private final void E(View rootView) {
        ViewGroup viewGroup;
        MarqueeTextView2 marqueeTextView2;
        if (rootView instanceof ViewGroup) {
            viewGroup = (ViewGroup) rootView;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            marqueeTextView2 = (MarqueeTextView2) viewGroup.findViewById(R.id.t65);
        } else {
            marqueeTextView2 = null;
        }
        if (marqueeTextView2 != null) {
            MarqueeTextView2.h(marqueeTextView2, 0, 1, null);
        }
    }

    private final void F(View rootView) {
        ViewGroup viewGroup;
        MarqueeTextView2 marqueeTextView2 = null;
        if (rootView instanceof ViewGroup) {
            viewGroup = (ViewGroup) rootView;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            marqueeTextView2 = (MarqueeTextView2) viewGroup.findViewById(R.id.t65);
        }
        if (marqueeTextView2 != null) {
            marqueeTextView2.j();
        }
    }

    private final void G() {
        View view;
        Object removeFirstOrNull;
        QLog.d("QWalletBlueTipsManagerV2", 2, "updateBlueTipsView: mWaitList=" + this.waitList.size());
        if (this.topTipsLayout.getChildCount() > 0) {
            view = ViewGroupKt.getChildren(this.topTipsLayout).iterator().next();
        } else {
            view = null;
        }
        removeFirstOrNull = CollectionsKt__MutableCollectionsKt.removeFirstOrNull(this.waitList);
        com.qwallet.data.d dVar = (com.qwallet.data.d) removeFirstOrNull;
        if (dVar == null) {
            s(this, view, null, 2, null);
            return;
        }
        if (view == null) {
            this.currentBelt = dVar;
            w(dVar);
            B(dVar);
        } else {
            if (!Intrinsics.areEqual(this.currentBelt, dVar)) {
                this.currentBelt = dVar;
                j(view, dVar);
                B(dVar);
                return;
            }
            QLog.d("QWalletBlueTipsManagerV2", 2, "nothing change with same belt");
        }
    }

    private final void j(final View oldTipsView, final com.qwallet.data.d homeBelt) {
        QLog.d("QWalletBlueTipsManagerV2", 2, "changeBelt");
        F(oldTipsView);
        final MarqueeTextView2 marqueeTextView2 = (MarqueeTextView2) oldTipsView.findViewById(R.id.t65);
        marqueeTextView2.animate().alpha(0.0f).translationY(-oldTipsView.getHeight()).setDuration(300L).withEndAction(new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.tips.k
            @Override // java.lang.Runnable
            public final void run() {
                q.k(q.this, oldTipsView, homeBelt, marqueeTextView2);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final q this$0, final View oldTipsView, com.qwallet.data.d homeBelt, final MarqueeTextView2 marqueeTextView2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(oldTipsView, "$oldTipsView");
        Intrinsics.checkNotNullParameter(homeBelt, "$homeBelt");
        this$0.C(oldTipsView, homeBelt);
        marqueeTextView2.setAlpha(0.0f);
        marqueeTextView2.setTranslationY(2 * oldTipsView.getHeight());
        marqueeTextView2.animate().alpha(1.0f).translationY(0.0f).setDuration(300L).withEndAction(new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.tips.m
            @Override // java.lang.Runnable
            public final void run() {
                q.l(MarqueeTextView2.this, this$0, oldTipsView);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(MarqueeTextView2 marqueeTextView2, final q this$0, final View oldTipsView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(oldTipsView, "$oldTipsView");
        marqueeTextView2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.tips.p
            @Override // java.lang.Runnable
            public final void run() {
                q.m(q.this, oldTipsView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(q this$0, View oldTipsView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(oldTipsView, "$oldTipsView");
        this$0.E(oldTipsView);
    }

    private final void o() {
        ArrayList arrayList = new ArrayList();
        com.qwallet.data.d dVar = this.tenpayBelt;
        if (dVar != null) {
            arrayList.add(dVar);
        }
        this.waitList.clear();
        this.waitList.addAll(arrayList);
        G();
    }

    private final View p() {
        ViewGroup viewGroup;
        ViewParent parent = this.topTipsLayout.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return null;
        }
        return viewGroup.findViewById(R.id.stp);
    }

    private final View q(Context context, com.qwallet.data.d tips) {
        long j3;
        View tipsView = View.inflate(context, R.layout.hjd, null);
        ViewGroup container = (ViewGroup) tipsView.findViewById(R.id.f164594t61);
        MarqueeTextView2 centerTxt = (MarqueeTextView2) tipsView.findViewById(R.id.t65);
        QWalletHomeBeltConfig qWalletHomeBeltConfig = (QWalletHomeBeltConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_HOME_9170_BELT_CONFIG, QWalletHomeBeltConfig.INSTANCE.a());
        ol2.b.f(centerTxt, 20, false, 4, null);
        Long startStayMS = qWalletHomeBeltConfig.getStartStayMS();
        long j16 = 1000;
        if (startStayMS != null) {
            j3 = startStayMS.longValue();
        } else {
            j3 = 1000;
        }
        Long stopStayMs = qWalletHomeBeltConfig.getStopStayMs();
        if (stopStayMs != null) {
            j16 = stopStayMs.longValue();
        }
        Intrinsics.checkNotNullExpressionValue(centerTxt, "centerTxt");
        MarqueeTextView2.setMarqueeParams$default(centerTxt, 0L, j16, j3, 1, null);
        tipsView.setOnClickListener(this.mTipsClickListener);
        if (QQTheme.isNowThemeIsNight()) {
            container.setBackgroundColor(Color.parseColor("#0F1113"));
        } else {
            container.setBackgroundColor(Color.parseColor("#F5F5F5"));
        }
        Intrinsics.checkNotNullExpressionValue(container, "container");
        PayChannelUtils.updateBgRound(container, PayChannelUtils.BgRadiusEnum.BothRound, x.c(context, 5.0f));
        Intrinsics.checkNotNullExpressionValue(tipsView, "tipsView");
        C(tipsView, tips);
        return tipsView;
    }

    private final void r(final View oldTipsView, final Function0<Unit> completeCallback) {
        if (oldTipsView == null) {
            return;
        }
        QLog.d("QWalletBlueTipsManagerV2", 2, "hideBelt");
        F(oldTipsView);
        final float measuredHeight = oldTipsView.getMeasuredHeight();
        oldTipsView.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.tips.i
            @Override // java.lang.Runnable
            public final void run() {
                q.t(oldTipsView, measuredHeight, this, completeCallback);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void s(q qVar, View view, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function0 = null;
        }
        qVar.r(view, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(final View view, float f16, final q this$0, final Function0 function0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        float f17 = -f16;
        view.animate().alpha(0.0f).translationY(f17).setDuration(300L).withEndAction(new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.tips.n
            @Override // java.lang.Runnable
            public final void run() {
                q.u(view, this$0, function0);
            }
        }).start();
        final View p16 = this$0.p();
        if (p16 == null) {
            return;
        }
        QLog.d("QWalletBlueTipsManagerV2", 2, "hideBelt, appsLayoutV2 tipsHeight=" + f16);
        p16.animate().translationY(f17).setDuration(300L).withEndAction(new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.tips.o
            @Override // java.lang.Runnable
            public final void run() {
                q.v(p16);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(View view, q this$0, Function0 function0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.setVisibility(8);
        this$0.topTipsLayout.removeAllViews();
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(View appsLayoutV2) {
        Intrinsics.checkNotNullParameter(appsLayoutV2, "$appsLayoutV2");
        appsLayoutV2.setTranslationY(0.0f);
    }

    private final void w(com.qwallet.data.d homeBelt) {
        boolean z16;
        float dimension;
        final View q16 = q(this.context, homeBelt);
        this.topTipsLayout.addView(q16);
        QLog.d("QWalletBlueTipsManagerV2", 2, "insertBelt");
        q16.setAlpha(0.0f);
        Float valueOf = Float.valueOf(q16.getMeasuredHeight());
        if (valueOf.floatValue() == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!(!z16)) {
            valueOf = null;
        }
        if (valueOf != null) {
            dimension = valueOf.floatValue();
        } else {
            dimension = q16.getResources().getDimension(R.dimen.day);
        }
        float f16 = -dimension;
        q16.setTranslationY(f16);
        q16.animate().alpha(1.0f).translationY(0.0f).setDuration(300L).withEndAction(new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.tips.j
            @Override // java.lang.Runnable
            public final void run() {
                q.x(q16, this);
            }
        }).start();
        View p16 = p();
        if (p16 == null) {
            return;
        }
        QLog.d("QWalletBlueTipsManagerV2", 2, "insertBelt, appsLayoutV2 tipsHeight=" + dimension);
        p16.setTranslationY(f16);
        p16.animate().translationY(0.0f).setDuration(300L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(final View blueTipsView, final q this$0) {
        Intrinsics.checkNotNullParameter(blueTipsView, "$blueTipsView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        blueTipsView.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.tips.l
            @Override // java.lang.Runnable
            public final void run() {
                q.y(q.this, blueTipsView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(q this$0, View blueTipsView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(blueTipsView, "$blueTipsView");
        this$0.E(blueTipsView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(q this$0, View view) {
        String str;
        boolean z16;
        boolean gotoFakeUrl;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.qwallet.data.d dVar = this$0.currentBelt;
        if (dVar != null) {
            str = dVar.getUrl();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            String c16 = com.tencent.mobileqq.base.a.c();
            if (FakeUrlUtils.isUseNewFakeUrl()) {
                gotoFakeUrl = new QWalletFakeUrlHandler(this$0.context, c16).dispatch(str);
            } else {
                gotoFakeUrl = new QWalletFakeUrl(this$0.context, c16).gotoFakeUrl(str);
            }
            if (!gotoFakeUrl) {
                com.tencent.mobileqq.qwallet.utils.k.h(this$0.context, str);
            }
            com.tencent.mobileqq.qwallet.c.f("qpayindex.yellowtips.click", null, "1", null, null, 26, null);
        }
        this$0.A(this$0.currentBelt);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void n(@Nullable com.qwallet.data.d tenpayBelt) {
        this.tenpayBelt = tenpayBelt;
        o();
    }
}
