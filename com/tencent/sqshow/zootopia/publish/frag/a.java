package com.tencent.sqshow.zootopia.publish.frag;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.sqshow.zootopia.publish.page.b;
import com.tencent.sqshow.zootopia.publish.tab.SelectPublishContentPageType;
import com.tencent.sqshow.zootopia.publish.tab.SelectPublishContentTitleData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vc4.i;
import vc4.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J0\u0010\u0010\u001a\u00020\u00042\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eR$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011j\b\u0012\u0004\u0012\u00020\t`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/sqshow/zootopia/publish/frag/a;", "", "Landroid/os/Bundle;", QQBrowserActivity.APP_PARAM, "", "c", "b", "Lvc4/i;", "Lcom/tencent/sqshow/zootopia/publish/tab/SelectPublishContentPageType;", "Lcom/tencent/sqshow/zootopia/publish/tab/SelectPublishContentTitleData;", "Lvc4/l;", "title", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "Lcom/tencent/sqshow/zootopia/publish/page/b;", "adapter", "a", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mPageDataList", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<SelectPublishContentTitleData> mPageDataList = new ArrayList<>();

    private final void c(Bundle extraParams) {
        this.mPageDataList.add(new SelectPublishContentTitleData(SelectPublishContentPageType.SAME_STYLE, extraParams));
    }

    public final void a(i<SelectPublishContentPageType, SelectPublishContentTitleData, l> title, ViewPager viewPager, b adapter) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        if (this.mPageDataList.size() <= 1) {
            title.getView().setVisibility(8);
        } else {
            title.getView().setVisibility(0);
        }
        i.a.a(title, this.mPageDataList, 0, 2, null);
        title.b(viewPager);
        viewPager.setAdapter(adapter);
        adapter.f(this.mPageDataList);
        title.a(0);
    }

    public final void b(Bundle extraParams) {
        c(extraParams);
    }
}
