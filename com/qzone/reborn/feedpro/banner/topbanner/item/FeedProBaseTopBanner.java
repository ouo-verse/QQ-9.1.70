package com.qzone.reborn.feedpro.banner.topbanner.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.reborn.feedpro.banner.topbanner.constant.FeedProTopBannerType;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017B\u001b\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u0016\u0010\u001aB#\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001b\u001a\u00020\r\u00a2\u0006\u0004\b\u0016\u0010\u001cJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0004J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\rH&J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\b\u0010\u0010\u001a\u00020\u0004H\u0004R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/feedpro/banner/topbanner/item/FeedProBaseTopBanner;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lqd/a;", "Landroid/view/View$OnClickListener;", "", "r0", "Lsd/a;", "m0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/qzone/reborn/feedpro/banner/topbanner/constant/FeedProTopBannerType;", "o0", "", "n0", "p0", "q0", "e", "Lsd/a;", "bannerManageIoc", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class FeedProBaseTopBanner extends QZoneBaseWidgetView<qd.a> implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private sd.a bannerManageIoc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedProBaseTopBanner(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        r0();
    }

    private final void r0() {
        setOnClickListener(this);
    }

    protected final sd.a m0() {
        sd.a aVar = this.bannerManageIoc;
        if (aVar != null) {
            return aVar;
        }
        sd.a aVar2 = (sd.a) getIocInterface(sd.a.class);
        this.bannerManageIoc = aVar2;
        return aVar2;
    }

    public abstract int n0();

    public abstract FeedProTopBannerType o0();

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        p0(v3);
        EventCollector.getInstance().onViewClicked(v3);
    }

    public abstract void p0(View v3);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q0() {
        sd.a m06 = m0();
        if (m06 != null) {
            m06.a(o0());
        }
        setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedProBaseTopBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        r0();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedProBaseTopBanner(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        r0();
    }
}
