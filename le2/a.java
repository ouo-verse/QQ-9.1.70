package le2;

import com.tencent.ecommerce.base.compress.IECCompressOperator;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lle2/a;", "Lcom/tencent/ecommerce/base/compress/IECCompressOperator;", "", "srcFilePath", "Lcom/tencent/ecommerce/base/compress/IECCompressOperator$ImageQualityType;", "type", "compressImageQuality", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements IECCompressOperator {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: le2.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public /* synthetic */ class C10720a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f414423a;

        static {
            int[] iArr = new int[IECCompressOperator.ImageQualityType.values().length];
            try {
                iArr[IECCompressOperator.ImageQualityType.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IECCompressOperator.ImageQualityType.HIGH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f414423a = iArr;
        }
    }

    @Override // com.tencent.ecommerce.base.compress.IECCompressOperator
    public String compressImageQuality(String srcFilePath, IECCompressOperator.ImageQualityType type) {
        int i3;
        Intrinsics.checkNotNullParameter(srcFilePath, "srcFilePath");
        Intrinsics.checkNotNullParameter(type, "type");
        int i16 = C10720a.f414423a[type.ordinal()];
        if (i16 == 1) {
            i3 = 0;
        } else {
            if (i16 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i3 = 1;
        }
        CompressInfo compressInfo = new CompressInfo(srcFilePath, i3, 0);
        ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
        String str = compressInfo.H;
        if (str == null || str.length() == 0) {
            return srcFilePath;
        }
        String str2 = compressInfo.H;
        Intrinsics.checkNotNullExpressionValue(str2, "coverCompressInfo.destPath");
        return str2;
    }
}
