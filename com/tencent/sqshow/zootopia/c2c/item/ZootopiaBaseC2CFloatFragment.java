package com.tencent.sqshow.zootopia.c2c.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import com.tencent.sqshow.zootopia.c2c.a;
import com.tencent.sqshow.zootopia.c2c.item.ZootopiaC2CAvatarRecyclerView;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import n74.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 R2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001SB\u0007\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J&\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0015H&J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0015H\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0015H\u0016R$\u0010)\u001a\u0004\u0018\u00010\"8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00107\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R$\u0010?\u001a\u0004\u0018\u0001088\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010G\u001a\u0004\u0018\u00010@8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010O\u001a\u0004\u0018\u00010H8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N\u00a8\u0006T"}, d2 = {"Lcom/tencent/sqshow/zootopia/c2c/item/ZootopiaBaseC2CFloatFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "Landroid/view/animation/Animation$AnimationListener;", "Lcom/tencent/widget/pull2refresh/LoadingMoreHelper$OnLoadMoreListener;", "Lcom/tencent/sqshow/zootopia/c2c/a;", "Lcom/tencent/sqshow/zootopia/c2c/item/ZootopiaC2CAvatarRecyclerView$d;", "", "Mh", "Landroid/view/View;", "view", "Jh", "Ih", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "initView", "", "onBackPressedEvent", "isFolded", "Hh", "Landroid/view/animation/Animation;", "animation", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "isManual", "onLoadMore", "isExpanded", "W0", "Ln74/d;", "N", "Ln74/d;", "Lh", "()Ln74/d;", "setViewBinding", "(Ln74/d;)V", "viewBinding", "", "P", "I", "getCurrentFoldType", "()I", "setCurrentFoldType", "(I)V", "currentFoldType", "Landroid/view/animation/AlphaAnimation;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/animation/AlphaAnimation;", "hideAnimation", BdhLogUtil.LogTag.Tag_Req, "showAnimation", "Landroid/support/v7/widget/LinearLayoutManager;", ExifInterface.LATITUDE_SOUTH, "Landroid/support/v7/widget/LinearLayoutManager;", "getFoldedLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "setFoldedLayoutManager", "(Landroid/support/v7/widget/LinearLayoutManager;)V", "foldedLayoutManager", "Landroid/support/v7/widget/GridLayoutManager;", "T", "Landroid/support/v7/widget/GridLayoutManager;", "getUnfoldedLayoutManager", "()Landroid/support/v7/widget/GridLayoutManager;", "setUnfoldedLayoutManager", "(Landroid/support/v7/widget/GridLayoutManager;)V", "unfoldedLayoutManager", "Lcom/tencent/sqshow/zootopia/c2c/item/ZootopiaAvatarLoadMoreView;", "U", "Lcom/tencent/sqshow/zootopia/c2c/item/ZootopiaAvatarLoadMoreView;", "Kh", "()Lcom/tencent/sqshow/zootopia/c2c/item/ZootopiaAvatarLoadMoreView;", "setFooterView", "(Lcom/tencent/sqshow/zootopia/c2c/item/ZootopiaAvatarLoadMoreView;)V", "footerView", "<init>", "()V", "V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class ZootopiaBaseC2CFloatFragment extends ZootopiaBaseFragment implements Animation.AnimationListener, LoadingMoreHelper.OnLoadMoreListener, a, ZootopiaC2CAvatarRecyclerView.d {

    /* renamed from: N, reason: from kotlin metadata */
    private d viewBinding;

    /* renamed from: P, reason: from kotlin metadata */
    private int currentFoldType;

    /* renamed from: Q, reason: from kotlin metadata */
    private AlphaAnimation hideAnimation;

    /* renamed from: R, reason: from kotlin metadata */
    private AlphaAnimation showAnimation;

    /* renamed from: S, reason: from kotlin metadata */
    private LinearLayoutManager foldedLayoutManager;

    /* renamed from: T, reason: from kotlin metadata */
    private GridLayoutManager unfoldedLayoutManager;

    /* renamed from: U, reason: from kotlin metadata */
    private ZootopiaAvatarLoadMoreView footerView;

    private final void Mh() {
        this.foldedLayoutManager = new LinearLayoutManager(requireContext(), 0, false);
        this.unfoldedLayoutManager = new GridLayoutManager(getContext(), 2);
    }

    public abstract void Hh(boolean isFolded);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Kh, reason: from getter */
    public final ZootopiaAvatarLoadMoreView getFooterView() {
        return this.footerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Lh, reason: from getter */
    public final d getViewBinding() {
        return this.viewBinding;
    }

    @Override // com.tencent.sqshow.zootopia.c2c.a
    public void W0(boolean isExpanded) {
        ZootopiaC2CAvatarRecyclerView zootopiaC2CAvatarRecyclerView;
        int findFirstCompletelyVisibleItemPosition;
        ImageView imageView;
        d dVar = this.viewBinding;
        if (dVar == null || (zootopiaC2CAvatarRecyclerView = dVar.f419194d) == null) {
            return;
        }
        zootopiaC2CAvatarRecyclerView.buildDrawingCache();
        zootopiaC2CAvatarRecyclerView.setDrawingCacheEnabled(true);
        zootopiaC2CAvatarRecyclerView.buildDrawingCache(true);
        Bitmap drawingCache = zootopiaC2CAvatarRecyclerView.getDrawingCache();
        if (drawingCache == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(drawingCache, "it.drawingCache ?: return");
        d dVar2 = this.viewBinding;
        if (dVar2 != null && (imageView = dVar2.f419195e) != null) {
            imageView.setImageBitmap(Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight()));
            if (imageView.getVisibility() != 0) {
                imageView.setVisibility(0);
            }
        }
        if (isExpanded) {
            LinearLayoutManager linearLayoutManager = this.foldedLayoutManager;
            if (linearLayoutManager != null) {
                findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            }
            findFirstCompletelyVisibleItemPosition = 0;
        } else {
            GridLayoutManager gridLayoutManager = this.unfoldedLayoutManager;
            if (gridLayoutManager != null) {
                findFirstCompletelyVisibleItemPosition = gridLayoutManager.findFirstCompletelyVisibleItemPosition();
            }
            findFirstCompletelyVisibleItemPosition = 0;
        }
        zootopiaC2CAvatarRecyclerView.setVisibility(4);
        zootopiaC2CAvatarRecyclerView.destroyDrawingCache();
        Jh(zootopiaC2CAvatarRecyclerView);
        d dVar3 = this.viewBinding;
        Ih(dVar3 != null ? dVar3.f419195e : null);
        Hh(!isExpanded);
        if (!isExpanded) {
            zootopiaC2CAvatarRecyclerView.setLayoutManager(this.foldedLayoutManager);
            zootopiaC2CAvatarRecyclerView.scrollToPosition(findFirstCompletelyVisibleItemPosition);
            this.currentFoldType = 0;
        } else {
            zootopiaC2CAvatarRecyclerView.setLayoutManager(this.unfoldedLayoutManager);
            zootopiaC2CAvatarRecyclerView.scrollToPosition(findFirstCompletelyVisibleItemPosition);
            this.currentFoldType = 1;
        }
        ZootopiaAvatarLoadMoreView zootopiaAvatarLoadMoreView = this.footerView;
        if (zootopiaAvatarLoadMoreView == null) {
            return;
        }
        zootopiaAvatarLoadMoreView.setHorizontal(!isExpanded);
    }

    public abstract void initView(View view);

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ImageView imageView;
        d dVar = this.viewBinding;
        ImageView imageView2 = dVar != null ? dVar.f419195e : null;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        d dVar2 = this.viewBinding;
        if (dVar2 == null || (imageView = dVar2.f419195e) == null) {
            return;
        }
        imageView.setImageResource(0);
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        d g16 = d.g(inflater, container, false);
        this.viewBinding = g16;
        if (g16 != null) {
            return g16.getRoot();
        }
        return null;
    }

    @Override // com.tencent.widget.pull2refresh.LoadingMoreHelper.OnLoadMoreListener
    public boolean onLoadMore(boolean isManual) {
        doLoadMore();
        return true;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this.footerView = new ZootopiaAvatarLoadMoreView(requireContext, null, 0, 6, null);
        Mh();
        d dVar = this.viewBinding;
        if (dVar != null) {
            ZootopiaC2CAvatarRecyclerView zootopiaC2CAvatarRecyclerView = dVar.f419194d;
            zootopiaC2CAvatarRecyclerView.setLayoutManager(this.foldedLayoutManager);
            zootopiaC2CAvatarRecyclerView.addItemDecoration(new j84.d());
            zootopiaC2CAvatarRecyclerView.setLoadMoreListener(this);
            ZootopiaAvatarLoadMoreView zootopiaAvatarLoadMoreView = this.footerView;
            if (zootopiaAvatarLoadMoreView != null) {
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                zootopiaC2CAvatarRecyclerView.setLoadMoreHelper(new com.tencent.sqshow.zootopia.view.pull2refresh.a(zootopiaAvatarLoadMoreView, requireContext2));
            }
            dVar.f419193c.c();
            dVar.f419192b.getBtnNetworkError().setVisibility(8);
            ((TextView) dVar.f419192b.findViewById(R.id.qtx)).setText(getResources().getString(R.string.f169737xb2));
        }
        initView(view);
    }

    private final void Ih(View view) {
        if (view == null) {
            return;
        }
        if (this.hideAnimation == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            alphaAnimation.setAnimationListener(this);
            this.hideAnimation = alphaAnimation;
        }
        AlphaAnimation alphaAnimation2 = this.hideAnimation;
        if (alphaAnimation2 != null) {
            view.startAnimation(alphaAnimation2);
        }
    }

    private final void Jh(View view) {
        if (view == null) {
            return;
        }
        if (this.showAnimation == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            alphaAnimation.setAnimationListener(this);
            this.showAnimation = alphaAnimation;
        }
        AlphaAnimation alphaAnimation2 = this.showAnimation;
        if (alphaAnimation2 != null) {
            view.startAnimation(alphaAnimation2);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
