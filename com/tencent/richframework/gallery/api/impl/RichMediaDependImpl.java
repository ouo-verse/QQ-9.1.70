package com.tencent.richframework.gallery.api.impl;

import android.content.Context;
import com.tencent.qqnt.aio.gallery.share.r;
import com.tencent.richframework.gallery.api.IRichMediaDepend;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/richframework/gallery/api/impl/RichMediaDependImpl;", "Lcom/tencent/richframework/gallery/api/IRichMediaDepend;", "()V", "saveToAlbum", "", "context", "Landroid/content/Context;", "itemInfo", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class RichMediaDependImpl implements IRichMediaDepend {
    @Override // com.tencent.richframework.gallery.api.IRichMediaDepend
    public void saveToAlbum(Context context, RFWLayerItemMediaInfo itemInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        r.INSTANCE.f(context, itemInfo);
    }
}
