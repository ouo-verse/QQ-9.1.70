package com.qzone.reborn.feedx.presenter.ad;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0014J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R$\u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/i;", "Lvg/a;", "", "K", "J", "Landroid/view/View;", "view", "I", "", "k", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "c", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onViewHolderAttachedToWindow", "Lcf/b;", "event", "t", UserInfo.SEX_FEMALE, "Landroid/view/View;", "getMAdFeedView", "()Landroid/view/View;", "setMAdFeedView", "(Landroid/view/View;)V", "mAdFeedView", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class i extends vg.a {

    /* renamed from: F, reason: from kotlin metadata */
    private View mAdFeedView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/i$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f55478d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ i f55479e;

        b(View view, i iVar) {
            this.f55478d = view;
            this.f55479e = iVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            View view = this.f55478d;
            if (view != null) {
                view.setVisibility(8);
            }
            BusinessFeedData businessFeedData = ((vg.a) this.f55479e).f441565h;
            QZoneAdFeedData adData = businessFeedData != null ? businessFeedData.getAdData() : null;
            if (adData == null) {
                return;
            }
            adData.setShowingRecommendAd(true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    private final void I(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(510L);
        alphaAnimation.setAnimationListener(new b(view, this));
        if (view != null) {
            view.startAnimation(alphaAnimation);
        }
    }

    private final void J() {
        I(this.mAdFeedView);
    }

    private final void K() {
        if (QZoneAdFeedDataExtKt.isShowingRecommendAd(this.f441565h)) {
            View view = this.mAdFeedView;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        View view2 = this.mAdFeedView;
        if (view2 == null) {
            return;
        }
        view2.setVisibility(0);
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        K();
    }

    @Override // vg.a
    protected void C(View containerView) {
        View view = this.f441563e;
        this.mAdFeedView = view != null ? view.findViewById(R.id.f162847my3) : null;
    }

    @Override // vg.a, vg.c
    public void c() {
        K();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneAdFeedRecommendAnimationPresenter";
    }

    @Override // vg.a, vg.c
    public void onViewHolderAttachedToWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        K();
    }

    @Override // vg.a
    protected int s() {
        return R.id.f162978nn3;
    }

    @Override // vg.a
    public void t(cf.b event) {
        if (event instanceof df.b) {
            J();
        }
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }
}
