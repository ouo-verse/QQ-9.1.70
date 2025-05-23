package com.tencent.ecommerce.base.compress;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u0007\bJ\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/base/compress/IECCompressOperator;", "", "", "srcFilePath", "Lcom/tencent/ecommerce/base/compress/IECCompressOperator$ImageQualityType;", "type", "compressImageQuality", "a", "ImageQualityType", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECCompressOperator {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/ecommerce/base/compress/IECCompressOperator$ImageQualityType;", "", "(Ljava/lang/String;I)V", "STANDARD", "HIGH", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public enum ImageQualityType {
        STANDARD,
        HIGH
    }

    @NotNull
    String compressImageQuality(@NotNull String srcFilePath, @NotNull ImageQualityType type);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/base/compress/IECCompressOperator$a;", "Lcom/tencent/ecommerce/base/compress/IECCompressOperator;", "", "srcFilePath", "Lcom/tencent/ecommerce/base/compress/IECCompressOperator$ImageQualityType;", "type", "compressImageQuality", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class a implements IECCompressOperator {
        @Override // com.tencent.ecommerce.base.compress.IECCompressOperator
        @NotNull
        public String compressImageQuality(@NotNull String srcFilePath, @NotNull ImageQualityType type) {
            return srcFilePath;
        }
    }
}
