package com.tencent.sqshow.zootopia.publish.page;

import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.sqshow.zootopia.publish.tab.SelectPublishContentPageType;
import com.tencent.sqshow.zootopia.publish.tab.SelectPublishContentTitleData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0003H\u0016R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/publish/page/b;", "Luc4/a;", "Lcom/tencent/sqshow/zootopia/publish/tab/SelectPublishContentPageType;", "Lcom/tencent/sqshow/zootopia/publish/tab/SelectPublishContentTitleData;", "Lcom/tencent/sqshow/zootopia/publish/page/a;", "", "g", "data", h.F, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Landroidx/fragment/app/FragmentManager;", "fm", "<init>", "(Landroidx/fragment/app/FragmentManager;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "i", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b extends uc4.a<SelectPublishContentPageType, SelectPublishContentTitleData, a> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(FragmentManager fm5, ZootopiaSource source) {
        super(fm5);
        Intrinsics.checkNotNullParameter(fm5, "fm");
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
    }

    @Override // uc4.a
    public String g() {
        return "SelectPublishContentPageAdapter_";
    }

    @Override // uc4.a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public a d(SelectPublishContentTitleData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return c.f372402a.a(data, this.source);
    }
}
