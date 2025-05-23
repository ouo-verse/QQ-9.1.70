package com.qzone.reborn.feedx.itemview.ad.tianshu;

import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import og.d;
import vg.a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0016\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0004H\u0014\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/feedx/itemview/ad/tianshu/QZoneAdTianshuPicFeedItemView;", "Lcom/qzone/reborn/feedx/itemview/ad/tianshu/QZoneAdTianshuBaseFeedItemView;", "", "getLogTag", "", "Ljava/lang/Class;", "Lvg/a;", "s0", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAdTianshuPicFeedItemView extends QZoneAdTianshuBaseFeedItemView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAdTianshuPicFeedItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected String getLogTag() {
        return "QZoneAdTianshuPicFeedItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.itemview.ad.tianshu.QZoneAdTianshuBaseFeedItemView, com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    public List<Class<? extends a>> s0() {
        List<Class<? extends a>> s06 = super.s0();
        s06.add(d.class);
        return s06;
    }
}
