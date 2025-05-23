package com.tencent.ecommerce.biz.detail.repo.shop.data;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/e;", "", "Lcom/tencent/ecommerce/base/eventbus/EVENT;", "", "a", "Ljava/lang/String;", "shopId", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/f;", "b", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/f;", "()Lcom/tencent/ecommerce/biz/detail/repo/shop/data/f;", "info", "<init>", "(Ljava/lang/String;Lcom/tencent/ecommerce/biz/detail/repo/shop/data/f;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String shopId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final f info;

    public e(String str, f fVar) {
        this.shopId = str;
        this.info = fVar;
    }

    /* renamed from: a, reason: from getter */
    public final f getInfo() {
        return this.info;
    }
}
