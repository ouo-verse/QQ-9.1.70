package com.tencent.ecommerce.biz.detail.ui;

import com.tencent.ecommerce.base.ui.tabbar.ECTabCoverInfo;
import com.tencent.ecommerce.base.ui.tabbar.ECTabLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0006B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0018\u0010\f\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/ui/a;", "", "", "b", "", "index", "a", "", "Lcom/tencent/ecommerce/base/ui/tabbar/a;", "Ljava/util/List;", "tabCoverInfoList", "Lcom/tencent/ecommerce/base/ui/tabbar/a;", "lastCoverInfo", "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout;", "c", "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout;", "tabLayout", "", "d", "Z", "isNeedShowRecommend", "<init>", "(Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout;Z)V", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<ECTabCoverInfo> tabCoverInfoList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ECTabCoverInfo lastCoverInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ECTabLayout tabLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isNeedShowRecommend;

    public final void a(int index) {
        this.tabLayout.t(index);
    }

    public final void b() {
        this.lastCoverInfo = this.tabCoverInfoList.get(0);
        this.tabLayout.x(this.tabCoverInfoList);
        a(0);
    }

    public a(ECTabLayout eCTabLayout, boolean z16) {
        this.tabLayout = eCTabLayout;
        this.isNeedShowRecommend = z16;
        ArrayList arrayList = new ArrayList();
        this.tabCoverInfoList = arrayList;
        arrayList.add(new ECTabCoverInfo(1, "\u5546\u54c1", "product_detail_mainpic", 0, 16.0f, 0, true, 0, 168, null));
        arrayList.add(new ECTabCoverInfo(2, "\u8bc4\u8bba", "qshop_detail_comment", 0, 16.0f, 0, false, 0, 232, null));
        arrayList.add(new ECTabCoverInfo(3, "\u8be6\u60c5", "qshop_product_detail_table_title", 0, 16.0f, 0, false, 0, 232, null));
        if (z16) {
            arrayList.add(new ECTabCoverInfo(4, "\u63a8\u8350", "qshop_detail_recommen_title_new", 0, 16.0f, 0, false, 0, 232, null));
        }
    }
}
