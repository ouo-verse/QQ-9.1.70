package com.tencent.biz.pubaccount.weishi.home.guide;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.weishi.home.WSTopBarHolder;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.ai;
import com.tencent.biz.pubaccount.weishi.util.o;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 )2\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001a\u0010\u001a\u001a\u00020\u00042\u0010\u0010\u0019\u001a\f\u0012\u0004\u0012\u00020\u00040\u0017j\u0002`\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010 R$\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017j\u0004\u0018\u0001`\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/home/guide/WSMonoTabGuideController;", "Lcom/tencent/biz/pubaccount/weishi/home/guide/a;", "", "k", "", DomainData.DOMAIN_NAME, "Landroid/view/View;", "anchorView", "l", "i", "Lcom/tencent/biz/pubaccount/weishi/home/guide/g;", "popupWindowGuideInfo", tl.h.F, "", "j", "", "position", "Lcom/tencent/biz/pubaccount/weishi/home/WSTopBarHolder;", "barHolder", "b", "index", "totalCount", "a", "Lkotlin/Function0;", "Lcom/tencent/biz/pubaccount/weishi/home/guide/WSTopBarGuideClickListener;", "listener", "c", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/biz/pubaccount/weishi/home/guide/d;", "Lcom/tencent/biz/pubaccount/weishi/home/guide/d;", "popupWindowGuide", "Landroid/os/Handler;", "Landroid/os/Handler;", "guideHandler", "Lkotlin/jvm/functions/Function0;", "guideClickListener", "d", "Lcom/tencent/biz/pubaccount/weishi/home/WSTopBarHolder;", "topBarHolder", "<init>", "()V", "e", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSMonoTabGuideController implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private d popupWindowGuide;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Handler guideHandler = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> guideClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WSTopBarHolder topBarHolder;

    private final boolean h(WSMonoTabPopupWindowGuideInfo popupWindowGuideInfo) {
        x.j("WSMonoTabGuideController", "[checkShowPopupWindowGuide] popupWindowGuideInfo:" + popupWindowGuideInfo);
        if (popupWindowGuideInfo.getIsShow()) {
            if (!(popupWindowGuideInfo.getDesc().length() == 0)) {
                int d16 = ai.d("key_show_pop_guide_max_count", 0);
                x.j("WSMonoTabGuideController", "[checkShowPopupWindowGuide] showedTimes:" + d16);
                if (d16 >= popupWindowGuideInfo.getMaxTimes()) {
                    return false;
                }
                long g16 = ai.g("key_last_show_pop_guide_time", 0L);
                long intervalDays = popupWindowGuideInfo.getIntervalDays() * 86400000;
                long currentTimeMillis = System.currentTimeMillis();
                x.j("WSMonoTabGuideController", "[checkShowPopupWindowGuide] currentTimeMs:" + o.e(currentTimeMillis) + ", lastShowPopGuideTimeMs:" + o.e(g16));
                if (currentTimeMillis - g16 < intervalDays) {
                    x.j("WSMonoTabGuideController", "[checkShowPopupWindowGuide] in interval days, not show guide!");
                    return false;
                }
                ai.m("key_show_pop_guide_max_count", d16 + 1);
                ai.o("key_last_show_pop_guide_time", System.currentTimeMillis());
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        d dVar = this.popupWindowGuide;
        if (dVar != null) {
            dVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String j() {
        String n3;
        WSTopBarHolder wSTopBarHolder = this.topBarHolder;
        return (wSTopBarHolder == null || (n3 = wSTopBarHolder.n()) == null) ? "" : n3;
    }

    private final boolean k() {
        WSMonoTabRedDotGuideInfo redDotGuideInfo = com.tencent.biz.pubaccount.weishi.home.c.f80807a.d().getRedDotGuideInfo();
        x.j("WSMonoTabGuideController", "[isShowRedDotGuide] redDotGuideInfo:" + redDotGuideInfo);
        if (!redDotGuideInfo.getIsShow()) {
            return false;
        }
        long g16 = ai.g("key_last_dismiss_red_dot_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        boolean z16 = currentTimeMillis - g16 > redDotGuideInfo.getIntervalDurationSec() * 1000;
        x.j("WSMonoTabGuideController", "[isShowRedDotGuide] currentTime:" + o.e(currentTimeMillis) + ", lastDismissTime:" + o.e(g16) + ", isShowRedDot:" + z16);
        return z16;
    }

    private final void l(View anchorView) {
        WSMonoTabPopupWindowGuideInfo popupWindowGuideInfo = com.tencent.biz.pubaccount.weishi.home.c.f80807a.d().getPopupWindowGuideInfo();
        Boolean valueOf = Boolean.valueOf(h(popupWindowGuideInfo));
        boolean booleanValue = valueOf.booleanValue();
        x.j("WSMonoTabGuideController", "[showPopupWindowGuide] isShowPopupWindowGuide:" + booleanValue);
        if (!booleanValue) {
            valueOf = null;
        }
        if (valueOf != null) {
            valueOf.booleanValue();
            if (this.popupWindowGuide == null) {
                this.popupWindowGuide = new d();
            }
            d dVar = this.popupWindowGuide;
            if (dVar != null) {
                dVar.f(anchorView, popupWindowGuideInfo, new Function0<Unit>() { // from class: com.tencent.biz.pubaccount.weishi.home.guide.WSMonoTabGuideController$showPopupWindowGuide$2$1
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
                        String j3;
                        Function0 function0;
                        x.j("WSMonoTabGuideController", "[showPopupWindowGuide] onGuideClick!");
                        WSPublicAccReport wSPublicAccReport = WSPublicAccReport.getInstance();
                        j3 = WSMonoTabGuideController.this.j();
                        wSPublicAccReport.reportMonoTabGuideClick(j3);
                        WSMonoTabGuideController.this.i();
                        function0 = WSMonoTabGuideController.this.guideClickListener;
                        if (function0 != null) {
                            function0.invoke();
                        }
                    }
                });
            }
            WSPublicAccReport.getInstance().reportMonoTabGuideExposure(j());
            this.guideHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.home.guide.b
                @Override // java.lang.Runnable
                public final void run() {
                    WSMonoTabGuideController.m(WSMonoTabGuideController.this);
                }
            }, popupWindowGuideInfo.getShowDurationSec() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(WSMonoTabGuideController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i();
    }

    private final void n() {
        ai.o("key_last_dismiss_red_dot_time", System.currentTimeMillis());
    }

    @Override // com.tencent.biz.pubaccount.weishi.home.guide.a
    public void a(int index, int totalCount, WSTopBarHolder barHolder) {
        Intrinsics.checkNotNullParameter(barHolder, "barHolder");
        i();
        n();
    }

    @Override // com.tencent.biz.pubaccount.weishi.home.guide.a
    public void b(int position, WSTopBarHolder barHolder) {
        Intrinsics.checkNotNullParameter(barHolder, "barHolder");
        this.topBarHolder = barHolder;
        boolean k3 = k();
        barHolder.m().j(k3);
        l(barHolder.getBarView());
        if (k3) {
            WSPublicAccReport.getInstance().reportMonoTabRedDotExposure(j());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.home.guide.a
    public void c(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.guideClickListener = listener;
    }

    @Override // com.tencent.biz.pubaccount.weishi.home.guide.a
    public void onDestroy() {
        x.j("WSMonoTabGuideController", "[onDestroy]");
        this.guideHandler.removeCallbacksAndMessages(null);
    }
}
