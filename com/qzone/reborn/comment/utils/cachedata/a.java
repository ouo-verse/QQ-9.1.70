package com.qzone.reborn.comment.utils.cachedata;

import com.qzone.reborn.comment.bean.QZoneCommentCacheData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/comment/utils/cachedata/a;", "", "", "b", "Lcom/qzone/reborn/comment/bean/QZoneCommentCacheData;", "cacheData", "c", "", v4.b.UNIKEY, "query", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public interface a {
    void a(String unikey);

    void b();

    void c(QZoneCommentCacheData cacheData);

    QZoneCommentCacheData query(String unikey);
}
