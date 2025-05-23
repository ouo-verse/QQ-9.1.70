package jh0;

import com.tencent.ecommerce.repo.aftersale.apply.item.ItemType;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f409930a;

    static {
        int[] iArr = new int[ItemType.values().length];
        f409930a = iArr;
        iArr[ItemType.TYPE_PRODUCT_ORDER.ordinal()] = 1;
        iArr[ItemType.TYPE_REFUND_AMOUNT.ordinal()] = 2;
        iArr[ItemType.TYPE_POST_METHOD.ordinal()] = 3;
        iArr[ItemType.TYPE_EXTRA_SUPPLEMENT.ordinal()] = 4;
        iArr[ItemType.TYPE_ENTRY_ITEM.ordinal()] = 5;
    }
}
