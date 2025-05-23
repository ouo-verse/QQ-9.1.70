package com.qzone.reborn.albumx.qzonex.section.albumdetail;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.albumx.common.convert.bean.CommonBatchInfoBanner;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.BannerMaterial;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J*\u0010\u0016\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00032\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/section/albumdetail/a;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "", WadlProxyConsts.KEY_MATERIAL, "", HippyTKDListViewAdapter.X, "", "v", "", "u", "getLogTag", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "position", "", "", "payload", "w", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "picView", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "textView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a extends com.qzone.reborn.base.l<CommonGridItemData> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout container;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView picView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView textView;

    private final String u(int material) {
        if (material == BannerMaterial.KBANNERMATERIALFAMILYNORMAL.ordinal()) {
            return "https://qzonestyle.gtimg.cn/qzone/client/photo_album/qinzi_time_background.png";
        }
        if (material == BannerMaterial.KBANNERMATERIALFAMILYANNIVERSARY.ordinal()) {
            if (QQTheme.isNowThemeIsNightForQzone()) {
                return "https://qzonestyle.gtimg.cn/qzone/client/photo_album/qinzi_shengri_night.png";
            }
            return "https://qzonestyle.gtimg.cn/qzone/client/photo_album/qinzi_shengri_day.png";
        }
        if (material == BannerMaterial.KBANNERMATERIALFAMILYPREGNANCY.ordinal()) {
            if (QQTheme.isNowThemeIsNightForQzone()) {
                return "https://qzonestyle.gtimg.cn/qzone/client/photo_album/qinzi_yunqi_night.png";
            }
            return "https://qzonestyle.gtimg.cn/qzone/client/photo_album/qinzi_yunqi_day.png";
        }
        if (material == BannerMaterial.KBANNERMATERIALLOVERSNORMAL.ordinal()) {
            return "https://qzonestyle.gtimg.cn/qzone/client/photo_album/qinglv_time_background.png";
        }
        if (material == BannerMaterial.KBANNERMATERIALLOVERSANNIVERSARY.ordinal()) {
            if (QQTheme.isNowThemeIsNightForQzone()) {
                return "https://qzonestyle.gtimg.cn/qzone/client/photo_album/qinglv_jinianri_night.png";
            }
            return "https://qzonestyle.gtimg.cn/qzone/client/photo_album/qinglv_jinianri_day.png";
        }
        if (material == BannerMaterial.KBANNERMATERIALTRAVELNORMAL.ordinal()) {
            return "https://qzonestyle.gtimg.cn/qzone/client/photo_album/lvxing_time_background.png";
        }
        return "";
    }

    private final boolean v(int material) {
        if (material == BannerMaterial.KBANNERMATERIALFAMILYNORMAL.ordinal()) {
            return true;
        }
        if (material != BannerMaterial.KBANNERMATERIALFAMILYANNIVERSARY.ordinal() && material != BannerMaterial.KBANNERMATERIALFAMILYPREGNANCY.ordinal()) {
            if (material == BannerMaterial.KBANNERMATERIALLOVERSNORMAL.ordinal()) {
                return true;
            }
            if (material != BannerMaterial.KBANNERMATERIALLOVERSANNIVERSARY.ordinal()) {
                BannerMaterial.KBANNERMATERIALTRAVELNORMAL.ordinal();
                return true;
            }
        }
        return false;
    }

    private final void x(int material) {
        TextView textView = null;
        if (v(material)) {
            ImageView imageView = this.picView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picView");
                imageView = null;
            }
            imageView.getLayoutParams().height = ViewUtils.dip2px(40.0f);
            TextView textView2 = this.textView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
                textView2 = null;
            }
            ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
            TextView textView3 = this.textView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
            } else {
                textView = textView3;
            }
            ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = ViewUtils.dip2px(0.0f);
            return;
        }
        ImageView imageView2 = this.picView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picView");
            imageView2 = null;
        }
        imageView2.getLayoutParams().height = ViewUtils.dip2px(98.0f);
        TextView textView4 = this.textView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView4 = null;
        }
        ViewGroup.LayoutParams layoutParams3 = textView4.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams3).gravity = 49;
        TextView textView5 = this.textView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        } else {
            textView = textView5;
        }
        ViewGroup.LayoutParams layoutParams4 = textView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = ViewUtils.dip2px(40.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumDetailSinglePicSection";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.fno);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026R.id.fl_banner_container)");
        this.container = (FrameLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.kub);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.iv_banner_bg)");
        this.picView = (ImageView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f162953ni3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.tv_banner_content)");
        this.textView = (TextView) findViewById3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mn_};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonGridItemData data, int position, List<Object> payload) {
        CommonBatchInfoBanner a16;
        if (data == null || (a16 = data.a()) == null) {
            return;
        }
        TextView textView = null;
        if (a16.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String() > 0) {
            ImageView imageView = this.picView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picView");
                imageView = null;
            }
            imageView.setVisibility(0);
            TextView textView2 = this.textView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
                textView2 = null;
            }
            textView2.setVisibility(0);
            x(a16.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String());
            com.tencent.mobileqq.qzone.picload.c a17 = com.tencent.mobileqq.qzone.picload.c.a();
            Option url = Option.obtain().setUrl(u(a16.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String()));
            ImageView imageView2 = this.picView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picView");
                imageView2 = null;
            }
            a17.h(url.setTargetView(imageView2).setLoadingDrawableColor(0).setFailedDrawableColor(0));
            TextView textView3 = this.textView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
            } else {
                textView = textView3;
            }
            textView.setText(a16.getContent());
            return;
        }
        ImageView imageView3 = this.picView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picView");
            imageView3 = null;
        }
        imageView3.setVisibility(8);
        TextView textView4 = this.textView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        } else {
            textView = textView4;
        }
        textView.setVisibility(8);
    }
}
