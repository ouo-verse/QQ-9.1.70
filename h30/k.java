package h30;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StShare;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class k extends c {

    /* renamed from: a, reason: collision with root package name */
    private static final FeedCloudMeta$StShare f404261a = new FeedCloudMeta$StShare();

    @Override // h30.c
    protected Object a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        List<FeedCloudMeta$StTagInfo> list;
        try {
            list = feedCloudMeta$StFeed.tagInfos.get();
        } catch (Exception e16) {
            RFWLog.d("QCircleTagInfoShareTransFormer", RFWLog.USR, "[doTransForm] ex: ", e16.getMessage());
        }
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                list.get(i3).shareInfo = f404261a;
            }
            return feedCloudMeta$StFeed;
        }
        return feedCloudMeta$StFeed;
    }

    @Override // h30.c
    protected ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("REPLACE_EMPTY_TAG_INFO_SHARE_INFO");
        return arrayList;
    }
}
