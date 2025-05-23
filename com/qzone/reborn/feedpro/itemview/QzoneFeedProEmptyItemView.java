package com.qzone.reborn.feedpro.itemview;

import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0018\u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u00050\u0004H\u0014J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/feedpro/itemview/QzoneFeedProEmptyItemView;", "Lcom/qzone/reborn/feedpro/itemview/QzoneBaseFeedProItemView;", "", "getLogTag", "", "Ljava/lang/Class;", "Lne/a;", "r0", "", "getLayoutId", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProEmptyItemView extends QzoneBaseFeedProItemView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProEmptyItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    @Override // com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QzoneFeedProEmptyItemView";
    }

    @Override // com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView
    protected List<Class<? extends ne.a>> r0() {
        List<Class<? extends ne.a>> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }
}
