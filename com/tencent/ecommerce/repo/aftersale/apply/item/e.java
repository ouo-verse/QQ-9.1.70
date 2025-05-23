package com.tencent.ecommerce.repo.aftersale.apply.item;

import com.tencent.ecommerce.repo.aftersale.apply.ECAfterSaleApplyOptionInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/item/e;", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/d;", "Lcom/tencent/ecommerce/repo/aftersale/apply/g;", "b", "Lcom/tencent/ecommerce/repo/aftersale/apply/g;", "()Lcom/tencent/ecommerce/repo/aftersale/apply/g;", "optionInfo", "<init>", "(Lcom/tencent/ecommerce/repo/aftersale/apply/g;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public class e extends d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ECAfterSaleApplyOptionInfo optionInfo;

    public e(ECAfterSaleApplyOptionInfo eCAfterSaleApplyOptionInfo) {
        super(ItemType.TYPE_OPTION_ITEM);
        this.optionInfo = eCAfterSaleApplyOptionInfo;
    }

    /* renamed from: b, reason: from getter */
    public ECAfterSaleApplyOptionInfo getOptionInfo() {
        return this.optionInfo;
    }
}
