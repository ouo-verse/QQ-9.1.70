package lo2;

import com.tencent.qqnt.kernel.nativeinterface.UfsResultItem;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class z extends m {
    /* JADX INFO: Access modifiers changed from: package-private */
    public z(String str, long j3, List<String> list, UfsResultItem ufsResultItem, int i3) {
        super(str, j3, list, ufsResultItem, i3);
    }

    @Override // lo2.m
    protected boolean G() {
        return false;
    }

    public abstract List<FeedCloudMeta$StFeed> W();

    /* renamed from: X */
    public abstract String getTitleSpans();
}
