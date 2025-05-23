package com.qzone.reborn.feedpro.banner.hotbanner.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.reborn.feedpro.banner.hotbanner.constant.FeedProHotBannerType;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ld.b;
import nd.a;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014B\u001b\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0013\u0010\u0017B#\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0018\u001a\u00020\b\u00a2\u0006\u0004\b\u0013\u0010\u0019J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\nH&J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\b\u0010\u0010\u001a\u00020\u0004H\u0004\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/feedpro/banner/hotbanner/item/FeedProBaseHotBanner;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lld/b;", "Landroid/view/View$OnClickListener;", "", "q0", "Lcom/qzone/reborn/feedpro/banner/hotbanner/constant/FeedProHotBannerType;", "n0", "", "m0", "", "r0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "o0", "p0", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class FeedProBaseHotBanner extends QZoneBaseWidgetView<b> implements View.OnClickListener {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedProBaseHotBanner(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        q0();
    }

    private final void q0() {
        setOnClickListener(this);
    }

    public abstract int m0();

    public abstract FeedProHotBannerType n0();

    public abstract void o0(View v3);

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        o0(v3);
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p0() {
        a aVar = (a) getIocInterface(a.class);
        if (aVar != null) {
            aVar.a(n0());
        }
    }

    public abstract boolean r0();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedProBaseHotBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        q0();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedProBaseHotBanner(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        q0();
    }
}
