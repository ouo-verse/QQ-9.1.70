package com.tencent.ecommerce.biz.bulletin;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/biz/bulletin/BulletinScene;", "", "scene", "", "(Ljava/lang/String;II)V", "SHOP_MAIN_PAGE", "GOOD_DETAIL_PAGE", "ORDER_SUBMIT_PAGE", "ORDER_DETAIL_PAGE", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum BulletinScene {
    SHOP_MAIN_PAGE(1),
    GOOD_DETAIL_PAGE(2),
    ORDER_SUBMIT_PAGE(3),
    ORDER_DETAIL_PAGE(4);

    public final int scene;

    BulletinScene(int i3) {
        this.scene = i3;
    }
}
