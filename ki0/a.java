package ki0;

import com.tencent.ecommerce.biz.orders.sellerorders.container.ECSellerOrderTab;
import com.tencent.ecommerce.repo.sampleorder.ECApplySampleQueryType;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f412526a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f412527b;

    static {
        int[] iArr = new int[ECSellerOrderTab.values().length];
        f412526a = iArr;
        iArr[ECSellerOrderTab.SAAS.ordinal()] = 1;
        iArr[ECSellerOrderTab.SAMPLE.ordinal()] = 2;
        int[] iArr2 = new int[ECApplySampleQueryType.values().length];
        f412527b = iArr2;
        iArr2[ECApplySampleQueryType.ALL.ordinal()] = 1;
        iArr2[ECApplySampleQueryType.AUDITING.ordinal()] = 2;
        iArr2[ECApplySampleQueryType.SIGNING.ordinal()] = 3;
        iArr2[ECApplySampleQueryType.FULFILLING.ordinal()] = 4;
        iArr2[ECApplySampleQueryType.FULFILLED.ordinal()] = 5;
        iArr2[ECApplySampleQueryType.CANCELLED.ordinal()] = 6;
        iArr2[ECApplySampleQueryType.UNFULFILLED.ordinal()] = 7;
    }
}
