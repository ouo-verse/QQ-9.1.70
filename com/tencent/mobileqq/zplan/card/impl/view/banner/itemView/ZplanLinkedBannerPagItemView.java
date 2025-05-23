package com.tencent.mobileqq.zplan.card.impl.view.banner.itemView;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonBinder;
import com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanBannerPagView;
import com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView;
import com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagHolderView;
import com.tencent.mobileqq.zplan.widget.impl.button.ZplanCommonButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.widget.RoundFrameLayout;
import com.tencent.sqshow.widget.pag.ZPlanPAGLoader;
import com.tencent.sqshow.zootopia.portal.home.ParadiseLifecycleAdapter;
import com.tencent.sqshow.zootopia.utils.ZplanImageDownloader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import pu4.g;
import pu4.t;
import pv4.s;
import tl.h;

@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\b\u0007*\u0001P\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001bB\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010)\u001a\u00020\u001e\u0012\u0006\u0010/\u001a\u00020*\u00a2\u0006\u0004\bS\u0010TJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J9\u0010\u000e\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042%\u0010\r\u001a!\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\bH\u0002J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ3\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042#\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bJ\u0006\u0010\u0015\u001a\u00020\u0014J \u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J(\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\u0012\u0010 \u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010!\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\"\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010#\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010$\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016R\u0017\u0010)\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010/\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR5\u0010E\u001a!\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\"\u0010L\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010R\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010Q\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/itemView/ZplanLinkedBannerPagItemView;", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/itemView/ZplanBaseDownloadButtonItemView;", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$b;", "Lpa4/a;", "Lpv4/s;", "data", "", ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", c.G, "pagDelayReadyListener", "o", "Landroid/content/Context;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "pagReadyListener", "t", "", "r", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$Direct;", "direct", "", "duration", "progress", "a", "hideDownloadBut", "setPagProgress", "Landroidx/lifecycle/LifecycleOwner;", "owner", MosaicConstants$JsFunction.FUNC_ON_DESTROY, DKHippyEvent.EVENT_STOP, "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "f", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Loa4/a;", h.F, "Loa4/a;", "getMapResViewModel", "()Loa4/a;", "mapResViewModel", "Landroid/view/View;", "i", "Landroid/view/View;", "view", "Lcom/tencent/sqshow/widget/RoundFrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/widget/RoundFrameLayout;", "placeHolderView", "Landroid/view/ViewGroup;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagHolderView;", "D", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagHolderView;", "pagViewHolder", "E", "Lpv4/s;", "indexData", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function1;", "pagDelayReadyListsner", "G", "I", "p", "()I", "setBindPos", "(I)V", "bindPos", "H", "Z", "canShowBtn", "com/tencent/mobileqq/zplan/card/impl/view/banner/itemView/ZplanLinkedBannerPagItemView$b", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/itemView/ZplanLinkedBannerPagItemView$b;", "downloadListener", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;)V", "J", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanLinkedBannerPagItemView extends ZplanBaseDownloadButtonItemView implements ZplanPagFrameView.b, pa4.a {
    private static final int K = ViewUtils.dpToPx(16.0f);
    private static final float L = ViewUtils.dpToPx(20.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private ViewGroup container;

    /* renamed from: D, reason: from kotlin metadata */
    private ZplanPagHolderView pagViewHolder;

    /* renamed from: E, reason: from kotlin metadata */
    private s indexData;

    /* renamed from: F, reason: from kotlin metadata */
    private Function1<? super Integer, Unit> pagDelayReadyListsner;

    /* renamed from: G, reason: from kotlin metadata */
    private int bindPos;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean canShowBtn;

    /* renamed from: I, reason: from kotlin metadata */
    private final b downloadListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final oa4.a mapResViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View view;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RoundFrameLayout placeHolderView;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/banner/itemView/ZplanLinkedBannerPagItemView$b", "Lvk3/a;", "", "url", "path", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements vk3.a {
        b() {
        }

        @Override // vk3.a
        public void a(String url, String path) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(path, "path");
            QLog.i("BannerItemView", 1, "onPAGDownloaded :: url == " + url + " pos: " + ZplanLinkedBannerPagItemView.this.getBindPos());
            ZplanLinkedBannerPagItemView zplanLinkedBannerPagItemView = ZplanLinkedBannerPagItemView.this;
            zplanLinkedBannerPagItemView.o(zplanLinkedBannerPagItemView.indexData, ZplanLinkedBannerPagItemView.this.pagDelayReadyListsner);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanLinkedBannerPagItemView(Context context, LifecycleOwner lifecycleOwner, oa4.a mapResViewModel) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        this.lifecycleOwner = lifecycleOwner;
        this.mapResViewModel = mapResViewModel;
        this.bindPos = -1;
        this.canShowBtn = true;
        b bVar = new b();
        this.downloadListener = bVar;
        q(context);
        ZPlanPAGLoader.f369875a.c(bVar);
        lifecycleOwner.getLifecycle().addObserver(new ParadiseLifecycleAdapter(this, lifecycleOwner));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object, java.lang.String] */
    public final void o(s data, Function1<? super Integer, Unit> pagDelayReadyListener) {
        if (data == null) {
            QLog.e("BannerItemView", 1, "data is null !");
            return;
        }
        g gVar = data.f427681b;
        if ((gVar != null ? gVar.f427438e : null) == null) {
            QLog.e("BannerItemView", 1, "material pagInfo is null !");
            return;
        }
        if (r()) {
            QLog.d("BannerItemView", 1, "pag file is ready , not need load ");
            return;
        }
        t tVar = gVar.f427438e;
        ?? r65 = tVar.f427523a;
        if (r65 != 0 && r65.length >= 2) {
            ZPlanPAGLoader zPlanPAGLoader = ZPlanPAGLoader.f369875a;
            ?? r66 = r65[0];
            Intrinsics.checkNotNullExpressionValue(r66, "material.pagInfo.pagList[0]");
            String h16 = ZPlanPAGLoader.h(zPlanPAGLoader, r66, false, 2, null);
            if (h16 != null) {
                if (!(h16.length() == 0)) {
                    QLog.d("BannerItemView", 1, "load pag file ");
                    String str = gVar.f427438e.f427523a[1];
                    Intrinsics.checkNotNullExpressionValue(str, "material.pagInfo.pagList[1]");
                    String h17 = ZPlanPAGLoader.h(zPlanPAGLoader, str, false, 2, null);
                    if (h17 != null) {
                        if (!(h17.length() == 0)) {
                            RoundFrameLayout roundFrameLayout = this.placeHolderView;
                            if (roundFrameLayout == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("placeHolderView");
                            } else {
                                r3 = roundFrameLayout;
                            }
                            r3.setVisibility(0);
                            ZplanPagHolderView zplanPagHolderView = this.pagViewHolder;
                            if (zplanPagHolderView != null) {
                                zplanPagHolderView.n(new ZplanLinkedBannerPagItemView$bindPagFile$1(this, h16, h17, data, pagDelayReadyListener));
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e("BannerItemView", 1, "rightPagFile is null !");
                    return;
                }
            }
            QLog.e("BannerItemView", 1, "leftPagFile is null !");
            return;
        }
        QLog.e("BannerItemView", 1, "paglist is invalid " + (tVar != null ? r65 : null) + " !");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ZplanLinkedBannerPagItemView this$0, final float f16, final float f17, final ZplanPagFrameView.Direct direct) {
        final ZplanBannerPagView pagView;
        float f18;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(direct, "$direct");
        RoundFrameLayout roundFrameLayout = this$0.placeHolderView;
        if (roundFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("placeHolderView");
            roundFrameLayout = null;
        }
        roundFrameLayout.setVisibility(8);
        QLog.d("BannerItemView", 1, "show pag anim " + this$0.bindPos + " " + f16 + " " + f17);
        if (this$0.canShowBtn) {
            this$0.b().setVisibility(0);
            ZplanCommonButton b16 = this$0.b();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b16, c.f123400v, 0.0f, 1.0f);
            if (direct == ZplanPagFrameView.Direct.LEFT) {
                f18 = L;
            } else {
                f18 = -L;
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(b16, "translationX", f18, 0.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            ofFloat.setDuration(1500L);
            ofFloat2.setDuration(1500L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
        }
        ZplanPagHolderView zplanPagHolderView = this$0.pagViewHolder;
        if (zplanPagHolderView == null || (pagView = zplanPagHolderView.getPagView()) == null) {
            return;
        }
        pagView.z(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.itemView.ZplanLinkedBannerPagItemView$showPagAnim$runnable$1$2$1
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
                ZplanBannerPagView.this.setDuration(direct, f17);
                ZplanBannerPagView.this.setProgress(direct, f16);
                ZplanBannerPagView.this.A(direct);
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.b
    public void a(final ZplanPagFrameView.Direct direct, final float duration, final float progress) {
        Intrinsics.checkNotNullParameter(direct, "direct");
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.itemView.a
            @Override // java.lang.Runnable
            public final void run() {
                ZplanLinkedBannerPagItemView.u(ZplanLinkedBannerPagItemView.this, progress, duration, direct);
            }
        };
        if (!r()) {
            RoundFrameLayout roundFrameLayout = this.placeHolderView;
            if (roundFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeHolderView");
                roundFrameLayout = null;
            }
            roundFrameLayout.setVisibility(0);
            b().setVisibility(8);
            QLog.e("BannerItemView", 1, "pag file not ready " + this.bindPos);
        }
        ZplanPagHolderView zplanPagHolderView = this.pagViewHolder;
        if (zplanPagHolderView != null) {
            zplanPagHolderView.p(runnable);
        }
    }

    @Override // pa4.a
    public void onDestroy(LifecycleOwner owner) {
        ZPlanPAGLoader.f369875a.k(this.downloadListener);
    }

    @Override // pa4.a
    public void onResume(LifecycleOwner owner) {
        if (getVisibility() == 0) {
            ZplanPagHolderView zplanPagHolderView = this.pagViewHolder;
            ZplanBannerPagView pagView = zplanPagHolderView != null ? zplanPagHolderView.getPagView() : null;
            if (pagView != null) {
                pagView.setVisibility(4);
            }
            ZplanPagHolderView zplanPagHolderView2 = this.pagViewHolder;
            ZplanBannerPagView pagView2 = zplanPagHolderView2 != null ? zplanPagHolderView2.getPagView() : null;
            if (pagView2 != null) {
                pagView2.setVisibility(0);
            }
        }
        QLog.d("BannerItemView", 1, "onResume pos: " + this.bindPos + " visibility: " + getVisibility() + " ");
    }

    /* renamed from: p, reason: from getter */
    public final int getBindPos() {
        return this.bindPos;
    }

    public final void q(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.daf, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026er_item_view, this, true)");
        this.view = inflate;
        View view = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.r6q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.zplan_media_content)");
        RoundFrameLayout roundFrameLayout = (RoundFrameLayout) findViewById;
        this.placeHolderView = roundFrameLayout;
        if (roundFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("placeHolderView");
            roundFrameLayout = null;
        }
        int i3 = K;
        roundFrameLayout.setRadius(i3);
        View view2 = this.view;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view2 = null;
        }
        ZplanPagHolderView zplanPagHolderView = (ZplanPagHolderView) view2.findViewById(R.id.r6x);
        this.pagViewHolder = zplanPagHolderView;
        if (zplanPagHolderView != null) {
            zplanPagHolderView.setRadius(i3);
        }
        View view3 = this.view;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view3 = null;
        }
        View findViewById2 = view3.findViewById(R.id.r46);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.zplan_download_button)");
        g((ZplanCommonButton) findViewById2);
        View view4 = this.view;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
        } else {
            view = view4;
        }
        View findViewById3 = view.findViewById(R.id.r3_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.zplan_banner_container)");
        this.container = (ViewGroup) findViewById3;
        setDownloadButtonBinder(new ZootopiaDownloadButtonBinder(context, this.lifecycleOwner, this.mapResViewModel));
    }

    public final boolean r() {
        ZplanPagHolderView zplanPagHolderView = this.pagViewHolder;
        if (zplanPagHolderView != null) {
            return zplanPagHolderView.l();
        }
        return false;
    }

    public final void setBindPos(int i3) {
        this.bindPos = i3;
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.b
    public void setPagProgress(final ZplanPagFrameView.Direct direct, final float duration, final float progress, boolean hideDownloadBut) {
        final ZplanBannerPagView pagView;
        Intrinsics.checkNotNullParameter(direct, "direct");
        if (!r()) {
            RoundFrameLayout roundFrameLayout = this.placeHolderView;
            if (roundFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeHolderView");
                roundFrameLayout = null;
            }
            roundFrameLayout.setVisibility(0);
            b().setVisibility(8);
            QLog.e("BannerItemView", 1, "pag file not ready ");
            return;
        }
        QLog.d("BannerItemView", 1, "set pag progress: " + direct + " -> progress " + progress + " " + this.bindPos + " " + hideDownloadBut + " " + this.canShowBtn);
        b().setVisibility((hideDownloadBut || !this.canShowBtn) ? 8 : 0);
        ZplanPagHolderView zplanPagHolderView = this.pagViewHolder;
        if (zplanPagHolderView == null || (pagView = zplanPagHolderView.getPagView()) == null) {
            return;
        }
        pagView.z(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.itemView.ZplanLinkedBannerPagItemView$setPagProgress$1$1
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
                ZplanBannerPagView.this.setDuration(direct, duration);
                ZplanBannerPagView.this.setProgress(direct, progress);
                ZplanBannerPagView.this.stop();
            }
        });
    }

    public final void t(s data, Function1<? super Integer, Unit> pagReadyListener) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.pagDelayReadyListsner = pagReadyListener;
        this.indexData = data;
        QLog.d("BannerItemView", 1, "render material " + data.f427681b.f427434a);
        o(data, pagReadyListener);
        s(data);
    }

    private final void s(s data) {
        IntRange indices;
        g gVar;
        t tVar;
        String[] strArr = (data == null || (gVar = data.f427681b) == null || (tVar = gVar.f427438e) == null) ? null : tVar.f427524b;
        if (strArr == null) {
            return;
        }
        indices = ArraysKt___ArraysKt.getIndices(strArr);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            ZplanImageDownloader zplanImageDownloader = ZplanImageDownloader.f373239a;
            String str = strArr[nextInt];
            Intrinsics.checkNotNullExpressionValue(str, "picList[i]");
            zplanImageDownloader.g(str);
        }
    }

    @Override // pa4.a
    public void onPause(LifecycleOwner owner) {
    }

    @Override // pa4.a
    public void onStart(LifecycleOwner owner) {
    }

    @Override // pa4.a
    public void onStop(LifecycleOwner owner) {
    }
}
