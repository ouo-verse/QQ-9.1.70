package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.tencent.biz.pubaccount.weishi.combo.home.rightpager.WSComboVerticalVideoProgressManager;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSPlayerControlBar;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalItemVideoProgressController;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u00017B\u0011\u0012\b\u00104\u001a\u0004\u0018\u000103\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000e\u001a\u00020\u0002H\u0014J\b\u0010\u000f\u001a\u00020\fH\u0014J\b\u0010\u0010\u001a\u00020\u0002H\u0014J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u001a\u0010\u001a\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0012\u0010\u001b\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010\u001f\u001a\u00020\u0013R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00068"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/presenter/j;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/presenter/WSVerticalForHomePresenter;", "", "N2", "x1", "t0", "isFirst", "d2", "", "k0", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "L2", "", "z2", "K2", "x2", "l2", "Landroid/os/Bundle;", "bundle", "", "handleIntent", "g", "destroy", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "viewHolder", "currentPosition", "T0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "f0", "isSelectedVideo", "M2", "O2", "Lwy/a;", "a0", "Lwy/a;", "comboProfilePageChangeEvent", "Lwy/b;", "b0", "Lwy/b;", "comboScrollChangeReceiver", "Lwy/c;", "c0", "Lwy/c;", "comboTabChangeReceiver", "Lwy/d;", "d0", "Lwy/d;", "openFloatWindowReceiver", "e0", "Ljava/lang/String;", "mContextFeedId", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/h;", "view", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/h;)V", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class j extends WSVerticalForHomePresenter {

    /* renamed from: g0, reason: collision with root package name */
    private static final int f82263g0 = ScreenUtil.dip2px(52.0f);

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final wy.a comboProfilePageChangeEvent;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final wy.b comboScrollChangeReceiver;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final wy.c comboTabChangeReceiver;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final wy.d openFloatWindowReceiver;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private String mContextFeedId;

    public j(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super(hVar);
        this.comboProfilePageChangeEvent = new wy.a(this);
        this.comboScrollChangeReceiver = new wy.b(this);
        this.comboTabChangeReceiver = new wy.c(this);
        this.openFloatWindowReceiver = new wy.d(this);
        this.mContextFeedId = "";
    }

    private final boolean N2() {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(this.mContextFeedId);
        return !isBlank;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForHomePresenter
    protected boolean K2() {
        if (N2()) {
            return false;
        }
        return uy.a.f440578a.d();
    }

    public final com.tencent.biz.pubaccount.weishi.verticalvideo.data.j L2() {
        return D0();
    }

    public final void M2(boolean isSelectedVideo) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        Intrinsics.checkNotNull(O0, "null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi.ui.OnTabSelectedListener");
        com.tencent.biz.pubaccount.weishi.ui.a aVar = (com.tencent.biz.pubaccount.weishi.ui.a) O0;
        if (isSelectedVideo) {
            aVar.Cb();
        } else {
            aVar.Y0();
        }
    }

    public final void O2() {
        au L0 = L0();
        if (L0 != null) {
            Object obj = L0.f82127d;
            if (obj instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi.verticalvideo.holder.AbsWSVideoItemView");
                com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> k3 = ((com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) obj).k();
                if (k3 instanceof WSVerticalItemVideoProgressController) {
                    WSComboVerticalVideoProgressManager a16 = WSComboVerticalVideoProgressManager.INSTANCE.a();
                    WSPlayerControlBar D = ((WSVerticalItemVideoProgressController) k3).D();
                    Intrinsics.checkNotNullExpressionValue(D, "videoProgressController.playControlBar");
                    a16.c(D);
                    return;
                }
                return;
            }
        }
        WSComboVerticalVideoProgressManager.INSTANCE.a().b();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void Q(RecyclerView.ViewHolder viewHolder) {
        super.Q(viewHolder);
        x.i("WSComboVerticalVideoProgressManager", "[WSVerticalForEssencePresenter][onPageScrollChangeStart]");
        WSComboVerticalVideoProgressManager.INSTANCE.a().h();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForHomePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForRecommendPresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void T0(RecyclerView.ViewHolder viewHolder, int currentPosition) {
        super.T0(viewHolder, currentPosition);
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        boolean D = O0 != null ? O0.D() : false;
        if (currentPosition == 0 && D) {
            Q(viewHolder);
            f0(viewHolder);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForHomePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForRecommendPresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.d
    public void destroy() {
        super.destroy();
        wz.b.b().f(this.comboProfilePageChangeEvent);
        wz.b.b().f(this.comboScrollChangeReceiver);
        wz.b.b().f(this.comboTabChangeReceiver);
        wz.b.b().f(this.openFloatWindowReceiver);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void f0(RecyclerView.ViewHolder viewHolder) {
        super.f0(viewHolder);
        x.i("WSComboVerticalVideoProgressManager", "[WSVerticalForEssencePresenter][onPageScrollChangeEnd]");
        if (viewHolder instanceof au) {
            Object obj = ((au) viewHolder).f82127d;
            if (obj instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi.verticalvideo.holder.AbsWSVideoItemView");
                com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> k3 = ((com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) obj).k();
                if (k3 instanceof WSVerticalItemVideoProgressController) {
                    WSComboVerticalVideoProgressManager a16 = WSComboVerticalVideoProgressManager.INSTANCE.a();
                    WSPlayerControlBar D = ((WSVerticalItemVideoProgressController) k3).D();
                    Intrinsics.checkNotNullExpressionValue(D, "videoProgressController.playControlBar");
                    a16.c(D);
                }
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void g() {
        super.g();
        wz.b.b().d(this.comboProfilePageChangeEvent);
        wz.b.b().d(this.comboScrollChangeReceiver);
        wz.b.b().d(this.comboTabChangeReceiver);
        wz.b.b().d(this.openFloatWindowReceiver);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForHomePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForRecommendPresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void handleIntent(Bundle bundle) {
        super.handleIntent(bundle);
        String string = bundle != null ? bundle.getString("key_home_to_context_feed_id", "") : null;
        this.mContextFeedId = string != null ? string : "";
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public int k0() {
        return f82263g0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForRecommendPresenter
    protected boolean l2() {
        return !Intrinsics.areEqual(uy.b.f440579a.a(), "monofeed_tab");
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public boolean t0() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    protected boolean x1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForHomePresenter
    public String x2() {
        boolean isBlank;
        String str;
        if (uy.a.f440578a.d()) {
            isBlank = StringsKt__StringsJVMKt.isBlank(this.mContextFeedId);
            if (isBlank) {
                str = super.x2();
            } else {
                str = this.mContextFeedId;
            }
            Intrinsics.checkNotNullExpressionValue(str, "{\n            if (mConte\u2026d\n            }\n        }");
            return str;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForHomePresenter
    public String z2() {
        if (uy.a.f440578a.d()) {
            String z26 = super.z2();
            Intrinsics.checkNotNullExpressionValue(z26, "{\n            super.getPushInfo()\n        }");
            return z26;
        }
        return "";
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForHomePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b
    protected boolean d2(boolean isFirst) {
        return isFirst && com.tencent.biz.pubaccount.weishi.config.experiment.b.h().J();
    }
}
