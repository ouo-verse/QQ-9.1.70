package lg;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u000b\u001a\u00020\tR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\f\u00a8\u0006\u0010"}, d2 = {"Llg/r;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "d", "b", "", "feedKey", "", "c", "a", "Ljava/lang/String;", "cacheTopFeedKey", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f414520a = new r();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String cacheTopFeedKey = "";

    r() {
    }

    public final void a() {
        cacheTopFeedKey = "";
    }

    public final void c(String feedKey) {
        cacheTopFeedKey = feedKey;
    }

    public final boolean b(BusinessFeedData feedData) {
        if (feedData == null || feedData.cellFeedCommInfo == null) {
            return false;
        }
        String str = cacheTopFeedKey;
        if (!(str == null || str.length() == 0) && (Intrinsics.areEqual(cacheTopFeedKey, feedData.cellFeedCommInfo.feedskey) || Intrinsics.areEqual(cacheTopFeedKey, feedData.cellFeedCommInfo.feedsid))) {
            return true;
        }
        CellFeedCommInfo cellFeedCommInfo = feedData.cellFeedCommInfo;
        if (cellFeedCommInfo != null) {
            return cellFeedCommInfo.isTopFeed();
        }
        return false;
    }

    public final boolean d(BusinessFeedData feedData) {
        CellFeedCommInfo cellFeedCommInfo;
        Integer valueOf = (feedData == null || (cellFeedCommInfo = feedData.cellFeedCommInfo) == null) ? null : Integer.valueOf(cellFeedCommInfo.appid);
        Integer valueOf2 = feedData != null ? Integer.valueOf(feedData.feedType) : null;
        return feedData != null && ef.b.h(feedData) && ((valueOf != null && valueOf.intValue() == 311) || ((valueOf != null && valueOf.intValue() == 2) || (valueOf != null && valueOf.intValue() == 4))) && !(((valueOf2 == null || valueOf2.intValue() != 4097) && ((valueOf2 == null || valueOf2.intValue() != 3) && (valueOf2 == null || valueOf2.intValue() != 2))) || feedData.isDeleteOnTimeFeed() || feedData.isFunctionGuideFeed() || feedData.isFriendAnniversaryFeed() || feedData.isEventTagFeed || feedData.isFakeFeed());
    }
}
