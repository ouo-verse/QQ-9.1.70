package de;

import com.qzone.reborn.base.n;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J6\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&\u00a8\u0006\u0010"}, d2 = {"Lde/d;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "comment", "", "oldStatus", "Lcom/qzone/reborn/base/n$a;", "", "dataCallBack", "", "R3", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "reply", "F4", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public interface d {
    void F4(CommonFeed feedData, CommonComment comment, CommonReply reply, int oldStatus, n.a<Boolean> dataCallBack);

    void R3(CommonFeed feedData, CommonComment comment, int oldStatus, n.a<Boolean> dataCallBack);
}
