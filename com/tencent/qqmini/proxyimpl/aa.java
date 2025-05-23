package com.tencent.qqmini.proxyimpl;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.qqmini.sdk.core.utils.ImageItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/aa;", "Lcom/tencent/cache/api/f;", "", "getByteSize", "", "d", "Ljava/lang/String;", "getMimeType", "()Ljava/lang/String;", "mimeType", "Lcom/tencent/qqmini/sdk/core/utils/ImageItem;", "e", "Lcom/tencent/qqmini/sdk/core/utils/ImageItem;", "a", "()Lcom/tencent/qqmini/sdk/core/utils/ImageItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "<init>", "(Ljava/lang/String;Lcom/tencent/qqmini/sdk/core/utils/ImageItem;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class aa implements com.tencent.cache.api.f {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String mimeType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ImageItem item;

    public aa(String mimeType, ImageItem item) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(item, "item");
        this.mimeType = mimeType;
        this.item = item;
    }

    /* renamed from: a, reason: from getter */
    public final ImageItem getItem() {
        return this.item;
    }

    @Override // com.tencent.cache.api.f
    public int getByteSize() {
        if (this.item.d() == null) {
            return 0;
        }
        return this.item.d().length;
    }
}
