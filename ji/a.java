package ji;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.reborn.groupalbum.part.feed.j;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016\u00a8\u0006\f"}, d2 = {"Lji/a;", "Lcom/qzone/reborn/groupalbum/part/feed/j;", "Lgf/a;", "", "feedId", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "I9", "", "S9", "getDtPageId", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends j {
    @Override // com.qzone.reborn.groupalbum.part.feed.j
    public BusinessFeedData I9(String feedId) {
        boolean equals$default;
        CellFeedCommInfo feedCommInfo;
        BusinessFeedData J9 = J9();
        equals$default = StringsKt__StringsJVMKt.equals$default((J9 == null || (feedCommInfo = J9.getFeedCommInfo()) == null) ? null : feedCommInfo.feedsid, feedId, false, 2, null);
        if (equals$default) {
            return J9();
        }
        return null;
    }

    @Override // com.qzone.reborn.groupalbum.part.feed.j
    public boolean S9() {
        return true;
    }

    @Override // com.qzone.reborn.groupalbum.part.feed.j
    public String getDtPageId() {
        return "pg_qz_interactive_notification";
    }
}
