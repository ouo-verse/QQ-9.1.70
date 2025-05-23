package a70;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.mobileqq.pb.PBRepeatField;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private long f25620a = 0;

    private long c() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_comment_guide_long_video_time", 20000L);
    }

    private boolean g(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed.poster) != null && feedCloudMeta$StUser.followState.get() == 1) {
            return true;
        }
        return false;
    }

    @Override // a70.a
    public String a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        this.f25620a = c();
        return "[" + getClass().getSimpleName() + "-" + hashCode() + " duration limit:" + this.f25620a + "]";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && g(feedCloudMeta$StFeed)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.commentCount.get() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        PBRepeatField<Integer> pBRepeatField;
        if (feedCloudMeta$StFeed != null && (pBRepeatField = feedCloudMeta$StFeed.opMask2) != null && pBRepeatField.get().contains(21)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h(long j3) {
        if (j3 >= this.f25620a) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        String str = null;
        if (feedCloudMeta$StFeed == null) {
            feedCloudMeta$StUser = null;
        } else {
            feedCloudMeta$StUser = feedCloudMeta$StFeed.poster;
        }
        if (feedCloudMeta$StUser != null) {
            str = feedCloudMeta$StUser.f398463id.get();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(HostDataTransUtils.getAccount(), str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j(long j3, long j16, int i3, float f16) {
        if (j3 <= 0 || j16 <= 0 || (i3 * j16) + j3 < f16 * ((float) j16)) {
            return false;
        }
        return true;
    }
}
