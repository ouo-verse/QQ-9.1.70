package com.tencent.sqshow.zootopia.publish.tab;

import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.sqshow.zootopia.widget.tab.BaseZPlanTabTitleData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/publish/tab/SelectPublishContentTitleData;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;", "Lcom/tencent/sqshow/zootopia/publish/tab/SelectPublishContentPageType;", "type", QQBrowserActivity.APP_PARAM, "Landroid/os/Bundle;", "(Lcom/tencent/sqshow/zootopia/publish/tab/SelectPublishContentPageType;Landroid/os/Bundle;)V", "getExtraParams", "()Landroid/os/Bundle;", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class SelectPublishContentTitleData extends BaseZPlanTabTitleData<SelectPublishContentPageType> {
    private final Bundle extraParams;

    public /* synthetic */ SelectPublishContentTitleData(SelectPublishContentPageType selectPublishContentPageType, Bundle bundle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(selectPublishContentPageType, (i3 & 2) != 0 ? null : bundle);
    }

    public final Bundle getExtraParams() {
        return this.extraParams;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectPublishContentTitleData(SelectPublishContentPageType type, Bundle bundle) {
        super(type, type.getPageName());
        Intrinsics.checkNotNullParameter(type, "type");
        this.extraParams = bundle;
    }
}
