package com.qzone.reborn.feedx.itemview.memoryseal;

import android.content.Context;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.presenter.ap;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vg.a;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0004H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/feedx/itemview/memoryseal/QZoneMemorySealFeedItemView;", "Lcom/qzone/reborn/feedx/itemview/QZoneBaseFeedItemView;", "", "getLayoutId", "", "Ljava/lang/Class;", "Lvg/a;", "s0", "", "getLogTag", "", "v0", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneMemorySealFeedItemView extends QZoneBaseFeedItemView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneMemorySealFeedItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cfw;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QZoneMemorySealFeedItemView";
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    public boolean v0() {
        return false;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected List<Class<? extends a>> s0() {
        List<Class<? extends a>> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(ap.class);
        return mutableListOf;
    }
}
