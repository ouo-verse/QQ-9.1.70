package com.tencent.ecommerce.biz.orders.buyerorders.snapshot;

import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u001e\u0010\u0005\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/ISnapshotClickListener;", "", "enterShopDetailPage", "", "showLatestProductDetail", "showPhotoInBrowser", "photoUrls", "", "", "curIndex", "", "showPropertyDialog", "showSpecDialog", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface ISnapshotClickListener {
    void enterShopDetailPage();

    void showLatestProductDetail();

    void showPhotoInBrowser(List<String> photoUrls, int curIndex);

    void showPropertyDialog();

    void showSpecDialog();
}
