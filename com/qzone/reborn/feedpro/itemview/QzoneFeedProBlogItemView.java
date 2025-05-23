package com.qzone.reborn.feedpro.itemview;

import android.content.Context;
import com.qzone.reborn.feedpro.section.QzoneFeedProHeadSection;
import com.qzone.reborn.feedpro.section.QzoneFeedProSmallTailSection;
import com.qzone.reborn.feedpro.section.am;
import com.qzone.reborn.feedpro.section.at;
import com.qzone.reborn.feedpro.section.bc;
import com.qzone.reborn.feedpro.section.d;
import com.qzone.reborn.feedpro.section.g;
import com.qzone.reborn.feedpro.section.u;
import com.qzone.reborn.feedpro.utils.ap;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0016\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0006H\u0014\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/feedpro/itemview/QzoneFeedProBlogItemView;", "Lcom/qzone/reborn/feedpro/itemview/QzoneBaseFeedProItemView;", "", "getLayoutId", "", "getLogTag", "", "Ljava/lang/Class;", "Lne/a;", "r0", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProBlogItemView extends QzoneBaseFeedProItemView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProBlogItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f129987j;
    }

    @Override // com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QzoneFeedProBlogItemView";
    }

    @Override // com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView
    protected List<Class<? extends ne.a>> r0() {
        List<Class<? extends ne.a>> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(QzoneFeedProHeadSection.class, g.class, d.class, QzoneFeedProSmallTailSection.class, at.class, bc.class, am.class, u.class);
        mutableListOf.addAll(ap.f54313a.a(q0()));
        return mutableListOf;
    }
}
