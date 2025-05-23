package fe;

import com.qzone.reborn.feedpro.itemview.QzoneFeedProForwardMixPicVideoItemView;
import com.qzone.reborn.feedpro.itemview.QzoneFeedProType;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"Lfe/f;", "Lfe/a;", "Lcom/qzone/reborn/feedpro/itemview/QzoneFeedProForwardMixPicVideoItemView;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "", "c", "Ljava/lang/Class;", "a", "Lcom/qzone/reborn/feedpro/itemview/QzoneFeedProType;", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f extends a<QzoneFeedProForwardMixPicVideoItemView> {
    @Override // fe.a
    public Class<QzoneFeedProForwardMixPicVideoItemView> a() {
        return QzoneFeedProForwardMixPicVideoItemView.class;
    }

    @Override // fe.a
    public QzoneFeedProType b() {
        return QzoneFeedProType.UNIQUE_TYPE_FORWARD_MIX_PIC_VIDEO_FEED;
    }

    @Override // fe.a
    public boolean c(CommonFeed commonFeed) {
        Intrinsics.checkNotNullParameter(commonFeed, "commonFeed");
        return CommonFeedExtKt.isForwardAlbumFeed(commonFeed);
    }
}
