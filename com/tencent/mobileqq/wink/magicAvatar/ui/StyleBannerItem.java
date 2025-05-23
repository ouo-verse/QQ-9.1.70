package com.tencent.mobileqq.wink.magicAvatar.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarStyleBanner;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J1\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\tR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/ui/StyleBannerItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/wink/magicAvatar/model/d;", WadlProxyConsts.KEY_MATERIAL, "", DomainData.DOMAIN_NAME, "info", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "adapterPos", "onItemClicked", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "E", "Landroid/view/View;", "view", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "p", "()Landroid/widget/TextView;", "title", "Landroid/widget/ImageView;", "G", "o", "()Landroid/widget/ImageView;", "banner", "<init>", "(Landroid/view/View;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class StyleBannerItem extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View view;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy title;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy banner;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StyleBannerItem(@NotNull View view) {
        super(view);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.StyleBannerItem$title$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View view2;
                view2 = StyleBannerItem.this.view;
                return (TextView) view2.findViewById(R.id.title);
            }
        });
        this.title = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.StyleBannerItem$banner$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view2;
                view2 = StyleBannerItem.this.view;
                return (ImageView) view2.findViewById(R.id.a58);
            }
        });
        this.banner = lazy2;
    }

    private final void n(View v3, MagicAvatarStyleBanner material) {
        VideoReport.setElementId(v3, "em_xsj_template_item");
        Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
        reportMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_STYLE, material.getId());
        VideoReport.setElementClickPolicy(v3, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", v3, reportMap);
    }

    private final ImageView o() {
        Object value = this.banner.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-banner>(...)");
        return (ImageView) value;
    }

    private final TextView p() {
        Object value = this.title.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-title>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(StyleBannerItem this$0, MagicAvatarStyleBanner info, Function1 onItemClicked, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(onItemClicked, "$onItemClicked");
        this$0.n(this$0.view, info);
        onItemClicked.invoke(info);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void q(@NotNull final MagicAvatarStyleBanner info, @NotNull final Function1<? super MagicAvatarStyleBanner, Unit> onItemClicked) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StyleBannerItem.r(StyleBannerItem.this, info, onItemClicked, view);
            }
        });
        p().setText(info.getName());
        o().setImageDrawable(URLDrawable.getDrawable(info.getPic(), URLDrawable.URLDrawableOptions.obtain()));
    }
}
