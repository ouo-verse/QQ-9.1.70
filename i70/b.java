package i70;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {
    public static boolean a(@NonNull m70.a aVar) {
        String str;
        FeedCloudMeta$StBarrage a16 = aVar.a();
        if (a16 == null) {
            str = null;
        } else {
            str = a16.f398446id.get();
        }
        if (!TextUtils.isEmpty(str) && str.contains("fakeId_")) {
            return true;
        }
        return false;
    }

    public static boolean b(@NonNull m70.a aVar) {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        FeedCloudMeta$StBarrage a16 = aVar.a();
        if (a16 == null) {
            feedCloudMeta$StUser = null;
        } else {
            feedCloudMeta$StUser = a16.postUser;
        }
        if (feedCloudMeta$StUser != null && TextUtils.equals(HostDataTransUtils.getAccount(), feedCloudMeta$StUser.f398463id.get())) {
            return true;
        }
        return false;
    }
}
