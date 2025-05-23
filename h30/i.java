package h30;

import com.tencent.biz.qqcircle.immersive.feed.live.w;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i extends c {
    @Override // h30.c
    protected Object a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return w.j(feedCloudMeta$StFeed);
    }

    @Override // h30.c
    protected ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("DITTO_FEED_TRTC_INFO_DATA");
        return arrayList;
    }
}
