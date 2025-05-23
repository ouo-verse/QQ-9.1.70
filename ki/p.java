package ki;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceReportViewQunFeedCallback;
import com.tencent.qqnt.kernel.nativeinterface.NTReportViewQunFeedReq;
import com.tencent.qqnt.kernel.nativeinterface.NTReportViewQunFeedRsp;
import com.tencent.qqnt.kernel.nativeinterface.RequestTimelineInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0004j\b\u0012\u0004\u0012\u00020\u0002`\u0005H\u0002J&\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0004j\b\u0012\u0004\u0012\u00020\u0002`\u0005J2\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\r2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0004j\b\u0012\u0004\u0012\u00020\u0002`\u00052\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0011"}, d2 = {"Lki/p;", "", "", "groupId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "feedId", "", "c", "b", "arrayList", "", "chunkSize", "", "e", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final p f412499a = new p();

    p() {
    }

    private final void c(String groupId, ArrayList<String> feedId) {
        NTReportViewQunFeedReq nTReportViewQunFeedReq = new NTReportViewQunFeedReq(0, new RequestTimelineInfo(), groupId, feedId);
        com.tencent.qqnt.kernel.api.g b16 = fj.r.b();
        if (b16 != null) {
            b16.reportViewQunFeed(nTReportViewQunFeedReq, new IAlbumServiceReportViewQunFeedCallback() { // from class: ki.o
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceReportViewQunFeedCallback
                public final void onReportViewQunFeed(NTReportViewQunFeedRsp nTReportViewQunFeedRsp) {
                    p.d(nTReportViewQunFeedRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(NTReportViewQunFeedRsp nTReportViewQunFeedRsp) {
        RFWLog.e("GroupAlbumFeedExposureRepo", RFWLog.USR, "reportViewQunFeed ret\uff1a" + nTReportViewQunFeedRsp.result);
    }

    public final void b(String groupId, ArrayList<String> feedId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Iterator<List<String>> it = e(feedId, 20).iterator();
        while (it.hasNext()) {
            c(groupId, new ArrayList<>(it.next()));
        }
    }

    public final List<List<String>> e(ArrayList<String> arrayList, int chunkSize) {
        List<List<String>> chunked;
        Intrinsics.checkNotNullParameter(arrayList, "arrayList");
        chunked = CollectionsKt___CollectionsKt.chunked(arrayList, chunkSize);
        return chunked;
    }
}
