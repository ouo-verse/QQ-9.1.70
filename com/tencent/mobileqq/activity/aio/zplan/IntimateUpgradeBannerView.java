package com.tencent.mobileqq.activity.aio.zplan;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.widgets.RoundImageView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/zplan/IntimateUpgradeBannerView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "d", "Lcom/tencent/mobileqq/activity/aio/zplan/d;", "c", "", "url", "Lcom/tencent/biz/qqcircle/widgets/RoundImageView;", "imageView", "g", "Lcom/tencent/mobileqq/activity/aio/zplan/a;", "callback", IECSearchBar.METHOD_SET_CALLBACK, "Lcom/tencent/mobileqq/activity/aio/zplan/a;", "e", "Lcom/tencent/mobileqq/activity/aio/zplan/d;", DownloadInfo.spKey_Config, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class IntimateUpgradeBannerView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a callback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IntimateBannerConfig config;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public IntimateUpgradeBannerView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final IntimateBannerConfig c() {
        IntimateBannerConfig intimateBannerConfig = (IntimateBannerConfig) ((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).getConfig("super_qq_show_intimate_guide_upgrade_configs", IntimateBannerConfig.class, "");
        if (intimateBannerConfig == null) {
            return new IntimateBannerConfig(null, null, null, null, 15, null);
        }
        return intimateBannerConfig;
    }

    private final void d(View rootView) {
        IntimateBannerConfig intimateBannerConfig = this.config;
        if (intimateBannerConfig == null || rootView == null) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.yw6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.mainTitle)");
        ((TextView) findViewById).setText(intimateBannerConfig.getIntimateMainTitle());
        View findViewById2 = rootView.findViewById(R.id.j5r);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.subTitle)");
        ((TextView) findViewById2).setText(intimateBannerConfig.getIntimateSubTitle());
        View findViewById3 = rootView.findViewById(R.id.zyl);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.openNow)");
        QUIButton qUIButton = (QUIButton) findViewById3;
        qUIButton.setText(intimateBannerConfig.getIntimateButtonTitle());
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.aio.zplan.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntimateUpgradeBannerView.e(IntimateUpgradeBannerView.this, view);
            }
        });
        View findViewById4 = rootView.findViewById(R.id.xpq);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.intimateGuidViewBkg)");
        RoundImageView roundImageView = (RoundImageView) findViewById4;
        roundImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.aio.zplan.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntimateUpgradeBannerView.f(IntimateUpgradeBannerView.this, view);
            }
        });
        g(intimateBannerConfig.getIntimateBackground(), roundImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(IntimateUpgradeBannerView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.callback;
        if (aVar != null) {
            aVar.a();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(IntimateUpgradeBannerView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.callback;
        if (aVar != null) {
            aVar.a();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void g(String url, RoundImageView imageView) {
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(imageView).setUrl(url));
    }

    public static /* synthetic */ void setCallback$default(IntimateUpgradeBannerView intimateUpgradeBannerView, a aVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            aVar = null;
        }
        intimateUpgradeBannerView.setCallback(aVar);
    }

    public final void setCallback(@Nullable a callback) {
        this.callback = callback;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public IntimateUpgradeBannerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ IntimateUpgradeBannerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public IntimateUpgradeBannerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.fd6, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026pgrade_banner_view, this)");
        this.config = c();
        d(inflate);
    }
}
