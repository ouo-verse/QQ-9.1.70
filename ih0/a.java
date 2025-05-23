package ih0;

import com.tencent.ecommerce.repo.aftersale.apply.ApplyType;
import com.tencent.ecommerce.repo.aftersale.apply.PageType;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f407638a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f407639b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f407640c;

    static {
        int[] iArr = new int[PageType.values().length];
        f407638a = iArr;
        iArr[PageType.PAGE_TYPE_UNINIT.ordinal()] = 1;
        iArr[PageType.PAGE_TYPE_APPLY.ordinal()] = 2;
        PageType pageType = PageType.PAGE_TYPE_RETURN_REFUND;
        iArr[pageType.ordinal()] = 3;
        PageType pageType2 = PageType.PAGE_TYPE_REFUND_ONLY;
        iArr[pageType2.ordinal()] = 4;
        PageType pageType3 = PageType.PAGE_TYPE_JUDGEMENT;
        iArr[pageType3.ordinal()] = 5;
        int[] iArr2 = new int[ApplyType.values().length];
        f407639b = iArr2;
        iArr2[ApplyType.APPLY_TYPE_RETURN_REFUND.ordinal()] = 1;
        iArr2[ApplyType.APPLY_TYPE_REFUND_ONLY.ordinal()] = 2;
        int[] iArr3 = new int[PageType.values().length];
        f407640c = iArr3;
        iArr3[pageType.ordinal()] = 1;
        iArr3[pageType2.ordinal()] = 2;
        iArr3[pageType3.ordinal()] = 3;
    }
}
