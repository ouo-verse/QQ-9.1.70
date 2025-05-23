package com.tencent.ecommerce.base.uploader;

import com.tencent.ecommerce.base.uploader.IECUploaderFactory;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/base/uploader/a;", "Lcom/tencent/ecommerce/base/uploader/IECUploaderFactory;", "", "filePath", "Lcom/tencent/ecommerce/base/uploader/IECUploaderFactory$UploaderType;", "type", "scene", "Lcom/tencent/ecommerce/base/uploader/ECBaseUploader;", "createUploaderByType", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a implements IECUploaderFactory {
    @Override // com.tencent.ecommerce.base.uploader.IECUploaderFactory
    @NotNull
    public ECBaseUploader createUploaderByType(@NotNull String filePath, @NotNull IECUploaderFactory.UploaderType type, @NotNull String scene) {
        throw new NotImplementedError("SDK \u4e0a\u4f20\u5668\u4e3a\u5fc5\u8981\u63a5\u53e3\uff0c\u8bf7\u7b2c\u4e09\u65b9\u5bbf\u4e3b\u5b9e\u73b0\uff0c\u5426\u5219\u65e0\u6cd5\u4f7f\u7528\u3002");
    }
}
