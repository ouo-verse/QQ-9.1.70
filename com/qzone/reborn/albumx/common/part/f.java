package com.qzone.reborn.albumx.common.part;

import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.google.android.material.appbar.AppBarLayout;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumPhotoSpec;
import com.qzone.reborn.albumx.common.widget.CommonAlbumDetailHeadView;
import com.qzone.reborn.feedx.widget.refresh.QZoneOnlyProgressRefreshHeader;
import com.qzone.reborn.intimate.part.QZoneIntimateSpaceCoverPart;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0014J\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0004R\u0014\u0010\u001e\u001a\u00020\u001a8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\"\u0010\u0011\u001a\u00020\u00108\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u00a8\u0006<"}, d2 = {"Lcom/qzone/reborn/albumx/common/part/f;", "Lcom/qzone/reborn/base/k;", "", "N9", "", "M9", "K9", "initData", "", "isBatchListEmpty", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/qzone/reborn/albumx/common/widget/CommonAlbumDetailHeadView;", "headView", "Lcom/qzone/reborn/albumx/common/viewmodel/b;", "albumViewModel", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "info", "R9", "Q9", "albumInfo", "S9", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", QAdVrReportParams.ParamKey.MEDIA, "", "L9", "d", "Ljava/lang/String;", "DEFAULT_HEAD_URL", "e", "I", "curVerticalOffset", "f", "Lcom/qzone/reborn/albumx/common/widget/CommonAlbumDetailHeadView;", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "ivCoverBg", "Lcom/google/android/material/appbar/AppBarLayout;", "i", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "Lcom/qzone/reborn/feedx/widget/refresh/QZoneOnlyProgressRefreshHeader;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedx/widget/refresh/QZoneOnlyProgressRefreshHeader;", "refreshHeader", "D", "Lcom/qzone/reborn/albumx/common/viewmodel/b;", "J9", "()Lcom/qzone/reborn/albumx/common/viewmodel/b;", "P9", "(Lcom/qzone/reborn/albumx/common/viewmodel/b;)V", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class f extends com.qzone.reborn.base.k {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneOnlyProgressRefreshHeader refreshHeader;

    /* renamed from: D, reason: from kotlin metadata */
    protected com.qzone.reborn.albumx.common.viewmodel.b albumViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String DEFAULT_HEAD_URL = "https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/groupphoto-cover.png";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int curVerticalOffset;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CommonAlbumDetailHeadView headView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView ivCoverBg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AppBarLayout appBarLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/albumx/common/part/f$a", "Lcom/google/android/material/appbar/AppBarLayout$g;", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "", "verticalOffset", "", "onOffsetChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements AppBarLayout.g {
        a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
            Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
            if (f.this.curVerticalOffset == verticalOffset) {
                return;
            }
            f.this.curVerticalOffset = verticalOffset;
            SmartRefreshLayout smartRefreshLayout = f.this.refreshLayout;
            ImageView imageView = null;
            if (smartRefreshLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout = null;
            }
            smartRefreshLayout.setEnabled(verticalOffset >= 0);
            ImageView imageView2 = f.this.ivCoverBg;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivCoverBg");
            } else {
                imageView = imageView2;
            }
            imageView.setTranslationY(verticalOffset);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/albumx/common/part/f$b", "Lth/a;", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshHeader;", "header", "", "isDragging", "", "percent", "", "offset", HippyHeaderScrollViewController.HEADER_HEIGHT, "maxDragHeight", "", "onHeaderMoving", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends th.a {
        b() {
        }

        @Override // com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener
        public void onHeaderMoving(IRefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
            float coerceAtLeast;
            float coerceAtMost;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((offset - QZoneIntimateSpaceCoverPart.INSTANCE.a()) * 1.5f, 0.0f);
            ImageView imageView = f.this.ivCoverBg;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivCoverBg");
                imageView = null;
            }
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, f.this.K9());
            imageView.setTranslationY(coerceAtMost);
        }
    }

    private final void I9(boolean isBatchListEmpty) {
        View findViewById = getPartRootView().findViewById(R.id.nl8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.view_mask_margin_top)");
        View findViewById2 = getPartRootView().findViewById(R.id.nl_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.view_mask_middle_top)");
        View findViewById3 = getPartRootView().findViewById(R.id.nl9);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026.view_mask_middle_bottom)");
        View findViewById4 = getPartRootView().findViewById(R.id.nl7);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026.view_mask_margin_bottom)");
        if (isBatchListEmpty) {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            findViewById3.setVisibility(8);
            findViewById4.setVisibility(8);
            return;
        }
        findViewById.setVisibility(0);
        findViewById2.setVisibility(0);
        findViewById3.setVisibility(0);
        findViewById4.setVisibility(0);
    }

    private final void N9() {
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
        qZoneOnlyProgressRefreshHeader2.getLayoutParams().height = ImmersiveUtils.getStatusBarHeight(getContext()) + M9();
        QZoneOnlyProgressRefreshHeader qZoneOnlyProgressRefreshHeader3 = this.refreshHeader;
        if (qZoneOnlyProgressRefreshHeader3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshHeader");
        } else {
            qZoneOnlyProgressRefreshHeader = qZoneOnlyProgressRefreshHeader3;
        }
        qZoneOnlyProgressRefreshHeader.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(f this$0, CommonAlbumInfo it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> value = this$0.J9().O1().getValue();
        if (value != null) {
            this$0.I9(bl.b(value.getData()));
        }
        CommonAlbumDetailHeadView commonAlbumDetailHeadView = this$0.headView;
        CommonAlbumDetailHeadView commonAlbumDetailHeadView2 = null;
        if (commonAlbumDetailHeadView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headView");
            commonAlbumDetailHeadView = null;
        }
        com.qzone.reborn.albumx.common.viewmodel.b J9 = this$0.J9();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.R9(commonAlbumDetailHeadView, J9, it);
        CommonAlbumDetailHeadView commonAlbumDetailHeadView3 = this$0.headView;
        if (commonAlbumDetailHeadView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headView");
        } else {
            commonAlbumDetailHeadView2 = commonAlbumDetailHeadView3;
        }
        this$0.Q9(commonAlbumDetailHeadView2, it);
        this$0.S9(it);
    }

    private final void initData() {
        l9.c cVar = (l9.c) RFWIocAbilityProvider.g().getIocInterface(l9.c.class, getPartRootView(), null);
        com.qzone.reborn.albumx.common.viewmodel.b Ne = cVar != null ? cVar.Ne() : null;
        Intrinsics.checkNotNull(Ne);
        P9(Ne);
        J9().M1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.albumx.common.part.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                f.O9(f.this, (CommonAlbumInfo) obj);
            }
        });
    }

    protected final com.qzone.reborn.albumx.common.viewmodel.b J9() {
        com.qzone.reborn.albumx.common.viewmodel.b bVar = this.albumViewModel;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String L9(CommonStMedia media) {
        CommonStPicUrl e16;
        if (media == null) {
            return "";
        }
        if (aa.e.f(media)) {
            e16 = aa.e.f25753a.e(media.getVideo().getCover().e(), CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN);
        } else {
            e16 = aa.e.f25753a.e(media.getImage().e(), CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN);
        }
        if (e16 == null) {
            return "";
        }
        return e16.getUrl();
    }

    protected final void P9(com.qzone.reborn.albumx.common.viewmodel.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.albumViewModel = bVar;
    }

    public void Q9(CommonAlbumDetailHeadView headView, CommonAlbumInfo info) {
        throw null;
    }

    public void R9(CommonAlbumDetailHeadView headView, com.qzone.reborn.albumx.common.viewmodel.b albumViewModel, CommonAlbumInfo info) {
        Intrinsics.checkNotNullParameter(headView, "headView");
        Intrinsics.checkNotNullParameter(albumViewModel, "albumViewModel");
        Intrinsics.checkNotNullParameter(info, "info");
        headView.setCommonExt(albumViewModel.getCommonExt());
        headView.setNormalUploadFlag(albumViewModel.Z1().getValue());
        headView.setData(info, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S9(CommonAlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        String L9 = L9(albumInfo.getCover());
        if (L9 == null || L9.length() == 0) {
            L9 = this.DEFAULT_HEAD_URL;
        }
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(L9);
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

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        Intrinsics.checkNotNull(rootView);
        View findViewById = rootView.findViewById(R.id.f18553a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView!!.findViewById(\u2026d.ablum_detail_head_view)");
        this.headView = (CommonAlbumDetailHeadView) findViewById;
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
        N9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int K9() {
        return ef.d.b(178);
    }

    private final int M9() {
        return ef.d.b(40);
    }
}
