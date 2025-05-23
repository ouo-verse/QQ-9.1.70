package com.qzone.reborn.intimate.part.albumDetail;

import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.google.android.material.appbar.AppBarLayout;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.feedx.widget.refresh.QZoneOnlyProgressRefreshHeader;
import com.qzone.reborn.intimate.part.QZoneIntimateSpaceCoverPart;
import com.qzone.reborn.intimate.widget.QZoneIntimateAlbumDetailHeadView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.scroll.HippyHeaderScrollViewController;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.bl;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshHeader;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import nk.w;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;
import qzone.QZoneBaseMeta$StMedia;
import qzone.QZoneBaseMeta$StPicUrl;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/qzone/reborn/intimate/part/albumDetail/i;", "Lcom/qzone/reborn/base/k;", "", "M9", "", "L9", "J9", "initData", "Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "albumInfo", "O9", "Lqzone/QZoneBaseMeta$StMedia;", QAdVrReportParams.ParamKey.MEDIA, "", "K9", "", "isBatchListEmpty", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "d", "I", "curVerticalOffset", "Lcom/qzone/reborn/intimate/widget/QZoneIntimateAlbumDetailHeadView;", "e", "Lcom/qzone/reborn/intimate/widget/QZoneIntimateAlbumDetailHeadView;", "headView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "ivCoverBg", "Lcom/google/android/material/appbar/AppBarLayout;", tl.h.F, "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "i", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "Lcom/qzone/reborn/feedx/widget/refresh/QZoneOnlyProgressRefreshHeader;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/widget/refresh/QZoneOnlyProgressRefreshHeader;", "refreshHeader", "Lnk/w;", BdhLogUtil.LogTag.Tag_Conn, "Lnk/w;", "albumViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class i extends com.qzone.reborn.base.k {

    /* renamed from: C, reason: from kotlin metadata */
    private w albumViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int curVerticalOffset;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneIntimateAlbumDetailHeadView headView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView ivCoverBg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AppBarLayout appBarLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneOnlyProgressRefreshHeader refreshHeader;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/intimate/part/albumDetail/i$a", "Lcom/google/android/material/appbar/AppBarLayout$g;", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "", "verticalOffset", "", "onOffsetChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements AppBarLayout.g {
        a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
            Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
            if (i.this.curVerticalOffset == verticalOffset) {
                return;
            }
            i.this.curVerticalOffset = verticalOffset;
            SmartRefreshLayout smartRefreshLayout = i.this.refreshLayout;
            ImageView imageView = null;
            if (smartRefreshLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout = null;
            }
            smartRefreshLayout.setEnabled(verticalOffset >= 0);
            ImageView imageView2 = i.this.ivCoverBg;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivCoverBg");
            } else {
                imageView = imageView2;
            }
            imageView.setTranslationY(verticalOffset);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/intimate/part/albumDetail/i$b", "Lth/a;", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshHeader;", "header", "", "isDragging", "", "percent", "", "offset", HippyHeaderScrollViewController.HEADER_HEIGHT, "maxDragHeight", "", "onHeaderMoving", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends th.a {
        b() {
        }

        @Override // com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener
        public void onHeaderMoving(IRefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
            float coerceAtLeast;
            float coerceAtMost;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((offset - QZoneIntimateSpaceCoverPart.INSTANCE.a()) * 1.5f, 0.0f);
            ImageView imageView = i.this.ivCoverBg;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivCoverBg");
                imageView = null;
            }
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, i.this.J9());
            imageView.setTranslationY(coerceAtMost);
        }
    }

    private final void I9(boolean isBatchListEmpty) {
        View findViewById = getPartRootView().findViewById(R.id.nl8);
        View findViewById2 = getPartRootView().findViewById(R.id.nl_);
        View findViewById3 = getPartRootView().findViewById(R.id.nl9);
        View findViewById4 = getPartRootView().findViewById(R.id.nl7);
        if (isBatchListEmpty) {
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
            if (findViewById3 != null) {
                findViewById3.setVisibility(8);
            }
            if (findViewById4 == null) {
                return;
            }
            findViewById4.setVisibility(8);
            return;
        }
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        if (findViewById2 != null) {
            findViewById2.setVisibility(0);
        }
        if (findViewById3 != null) {
            findViewById3.setVisibility(0);
        }
        if (findViewById4 == null) {
            return;
        }
        findViewById4.setVisibility(0);
    }

    private final String K9(QZoneBaseMeta$StMedia media) {
        QZoneBaseMeta$StPicUrl e16;
        if (media == null) {
            return "";
        }
        mk.c cVar = mk.c.f416874a;
        if (cVar.g(media)) {
            e16 = cVar.e(media.video.cover.photo_url.get(), 0);
        } else {
            e16 = cVar.e(media.image.photo_url.get(), 0);
        }
        if (e16 == null) {
            return "";
        }
        String str = e16.url.get();
        Intrinsics.checkNotNullExpressionValue(str, "stPicUrl.let { it.url.get() }");
        return str;
    }

    private final void M9() {
        AppBarLayout appBarLayout = this.appBarLayout;
        QZoneOnlyProgressRefreshHeader qZoneOnlyProgressRefreshHeader = null;
        if (appBarLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
            appBarLayout = null;
        }
        appBarLayout.e(new a());
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setOnMultiListener(new b());
        View findViewById = getPartRootView().findViewById(R.id.n5c);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026_intimate_refresh_header)");
        QZoneOnlyProgressRefreshHeader qZoneOnlyProgressRefreshHeader2 = (QZoneOnlyProgressRefreshHeader) findViewById;
        this.refreshHeader = qZoneOnlyProgressRefreshHeader2;
        if (qZoneOnlyProgressRefreshHeader2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshHeader");
            qZoneOnlyProgressRefreshHeader2 = null;
        }
        qZoneOnlyProgressRefreshHeader2.getLayoutParams().height = ImmersiveUtils.getStatusBarHeight(getContext()) + L9();
        QZoneOnlyProgressRefreshHeader qZoneOnlyProgressRefreshHeader3 = this.refreshHeader;
        if (qZoneOnlyProgressRefreshHeader3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshHeader");
        } else {
            qZoneOnlyProgressRefreshHeader = qZoneOnlyProgressRefreshHeader3;
        }
        qZoneOnlyProgressRefreshHeader.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(i this$0, CommonAlbumInfo commonAlbumInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w wVar = this$0.albumViewModel;
        QZoneIntimateAlbumDetailHeadView qZoneIntimateAlbumDetailHeadView = null;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            wVar = null;
        }
        UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> value = wVar.O1().getValue();
        if (value != null) {
            QZoneIntimateAlbumDetailHeadView qZoneIntimateAlbumDetailHeadView2 = this$0.headView;
            if (qZoneIntimateAlbumDetailHeadView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headView");
                qZoneIntimateAlbumDetailHeadView2 = null;
            }
            qZoneIntimateAlbumDetailHeadView2.setIsBatchListEmpty(bl.b(value.getData()));
            this$0.I9(bl.b(value.getData()));
        }
        QZoneIntimateAlbumDetailHeadView qZoneIntimateAlbumDetailHeadView3 = this$0.headView;
        if (qZoneIntimateAlbumDetailHeadView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headView");
            qZoneIntimateAlbumDetailHeadView3 = null;
        }
        qZoneIntimateAlbumDetailHeadView3.setHostActivity(this$0.getActivity());
        QZoneIntimateAlbumDetailHeadView qZoneIntimateAlbumDetailHeadView4 = this$0.headView;
        if (qZoneIntimateAlbumDetailHeadView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headView");
            qZoneIntimateAlbumDetailHeadView4 = null;
        }
        w wVar2 = this$0.albumViewModel;
        if (wVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            wVar2 = null;
        }
        qZoneIntimateAlbumDetailHeadView4.setCommonExt(wVar2.getCommonExt());
        QZoneIntimateAlbumDetailHeadView qZoneIntimateAlbumDetailHeadView5 = this$0.headView;
        if (qZoneIntimateAlbumDetailHeadView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headView");
        } else {
            qZoneIntimateAlbumDetailHeadView = qZoneIntimateAlbumDetailHeadView5;
        }
        qZoneIntimateAlbumDetailHeadView.setData(commonAlbumInfo, 0);
        this$0.O9(xh.e.f(commonAlbumInfo));
    }

    private final void O9(QZoneBaseAlbumMeta$AlbumInfo albumInfo) {
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(K9(albumInfo.cover));
        ImageView imageView = this.ivCoverBg;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCoverBg");
            imageView = null;
        }
        e16.setTargetView(imageView);
        ImageView imageView3 = this.ivCoverBg;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCoverBg");
            imageView3 = null;
        }
        if (imageView3.getLayoutParams() != null) {
            ImageView imageView4 = this.ivCoverBg;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivCoverBg");
                imageView4 = null;
            }
            e16.setRequestWidth(imageView4.getLayoutParams().width);
            ImageView imageView5 = this.ivCoverBg;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivCoverBg");
            } else {
                imageView2 = imageView5;
            }
            e16.setRequestHeight(imageView2.getLayoutParams().height);
        }
        com.qzone.reborn.util.m mVar = com.qzone.reborn.util.m.f59551a;
        e16.setLoadingDrawable(mVar.b(getContext()));
        e16.setFailedDrawable(mVar.a(getContext()));
        com.tencent.mobileqq.qzone.picload.c.a().h(e16);
    }

    private final void initData() {
        ViewModel viewModel = getViewModel(w.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026ailViewModel::class.java)");
        w wVar = (w) viewModel;
        this.albumViewModel = wVar;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            wVar = null;
        }
        wVar.M1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.intimate.part.albumDetail.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                i.N9(i.this, (CommonAlbumInfo) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        Intrinsics.checkNotNull(rootView);
        View findViewById = rootView.findViewById(R.id.f18553a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView!!.findViewById(\u2026d.ablum_detail_head_view)");
        this.headView = (QZoneIntimateAlbumDetailHeadView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.n4l);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView!!.findViewById(\u2026.qzone_intimate_cover_bg)");
        this.ivCoverBg = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f162941ng1);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView!!.findViewById(R.id.smart_refresh_layout)");
        this.refreshLayout = (SmartRefreshLayout) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.n5k);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026ate_space_app_bar_layout)");
        this.appBarLayout = (AppBarLayout) findViewById4;
        initData();
        M9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int J9() {
        return ef.d.b(178);
    }

    private final int L9() {
        return ef.d.b(40);
    }
}
