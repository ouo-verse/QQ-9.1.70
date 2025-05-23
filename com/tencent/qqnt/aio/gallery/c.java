package com.tencent.qqnt.aio.gallery;

import com.tencent.qqnt.aio.gallery.share.NTShareContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/c;", "Lcom/tencent/qqnt/aio/gallery/share/d;", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "", "g", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c extends com.tencent.qqnt.aio.gallery.share.d {
    @Override // com.tencent.qqnt.aio.gallery.share.d, com.tencent.qqnt.aio.gallery.share.a
    public boolean g(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return super.g(shareContext) && !shareContext.getLayerItemInfo().isVideo();
    }
}
