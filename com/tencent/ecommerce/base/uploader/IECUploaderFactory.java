package com.tencent.ecommerce.base.uploader;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\tJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/base/uploader/IECUploaderFactory;", "", "createUploaderByType", "Lcom/tencent/ecommerce/base/uploader/ECBaseUploader;", "filePath", "", "type", "Lcom/tencent/ecommerce/base/uploader/IECUploaderFactory$UploaderType;", "scene", "UploaderType", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECUploaderFactory {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/base/uploader/IECUploaderFactory$UploaderType;", "", "(Ljava/lang/String;I)V", "IMAGE", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public enum UploaderType {
        IMAGE
    }

    @NotNull
    ECBaseUploader createUploaderByType(@NotNull String filePath, @NotNull UploaderType type, @NotNull String scene);
}
