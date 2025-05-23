package com.qzone.reborn.feedpro.itemview;

import android.content.Context;
import com.qzone.reborn.feedpro.section.an;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0016\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0006H\u0014J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/feedpro/itemview/QzoneMemorySealFeedProItemView;", "Lcom/qzone/reborn/feedpro/itemview/QzoneBaseFeedProItemView;", "", "getLayoutId", "", "getLogTag", "", "Ljava/lang/Class;", "Lne/a;", "r0", "", "u0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "j", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneMemorySealFeedProItemView extends QzoneBaseFeedProItemView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneMemorySealFeedProItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView, de.c
    public boolean Q() {
        return false;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f130097u;
    }

    @Override // com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QzoneMemorySealFeedProItemView";
    }

    @Override // com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView, de.c
    public boolean j() {
        return true;
    }

    @Override // com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView
    public boolean u0() {
        return false;
    }

    @Override // com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView
    protected List<Class<? extends ne.a>> r0() {
        List<Class<? extends ne.a>> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(an.class);
        return mutableListOf;
    }
}
