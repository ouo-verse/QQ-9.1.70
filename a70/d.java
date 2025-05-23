package a70;

import androidx.annotation.NonNull;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends b {

    /* renamed from: b, reason: collision with root package name */
    private float f25623b;

    /* renamed from: c, reason: collision with root package name */
    private float f25624c;

    private float k() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_comment_guide_common_interact_long_play_count", 0.5f);
    }

    private float l() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_comment_guide_common_interact_short_num", 1.0f);
    }

    private boolean m(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null || !e(feedCloudMeta$StFeed) || d(feedCloudMeta$StFeed) || f(feedCloudMeta$StFeed) || i(feedCloudMeta$StFeed)) {
            return false;
        }
        return true;
    }

    private boolean n(@NonNull z60.a aVar) {
        float f16;
        int b16 = aVar.b();
        long c16 = aVar.c();
        long d16 = aVar.d();
        if (h(c16)) {
            f16 = this.f25623b;
        } else {
            f16 = this.f25624c;
        }
        return j(d16, c16, b16, f16);
    }

    @Override // a70.b, a70.a
    public String a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.a(feedCloudMeta$StFeed, i3);
        this.f25623b = k();
        this.f25624c = l();
        return "[" + getClass().getSimpleName() + "-" + hashCode() + " long count:" + this.f25623b + " | short count: " + this.f25624c + "]";
    }

    @Override // a70.a
    public boolean b(@NonNull z60.a aVar) {
        if (!m(aVar.a())) {
            return false;
        }
        if (!aVar.f() && !n(aVar)) {
            return false;
        }
        return true;
    }
}
