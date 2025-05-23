package com.qzone.reborn.comment.utils.cachedata;

import com.qzone.reborn.comment.bean.QZoneCommentCacheData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/comment/utils/cachedata/b;", "Lcom/qzone/reborn/comment/utils/cachedata/a;", "", "b", "Lcom/qzone/reborn/comment/bean/QZoneCommentCacheData;", "cacheData", "c", "", v4.b.UNIKEY, "query", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b implements a {
    @Override // com.qzone.reborn.comment.utils.cachedata.a
    public void a(String unikey) {
        Intrinsics.checkNotNullParameter(unikey, "unikey");
    }

    @Override // com.qzone.reborn.comment.utils.cachedata.a
    public void c(QZoneCommentCacheData cacheData) {
        Intrinsics.checkNotNullParameter(cacheData, "cacheData");
    }

    @Override // com.qzone.reborn.comment.utils.cachedata.a
    public QZoneCommentCacheData query(String unikey) {
        Intrinsics.checkNotNullParameter(unikey, "unikey");
        return null;
    }

    @Override // com.qzone.reborn.comment.utils.cachedata.a
    public void b() {
    }
}
