package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.model;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta$RecomReasonV2;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StLiteBanner;
import feedcloud.FeedCloudMeta$StRecomInfo;
import feedcloud.FeedCloudMeta$StUser;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\t\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/model/b;", "", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", h.F, "c", "f", "b", "", "a", "type", "d", "e", "g", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f86876a = new b();

    b() {
    }

    private final boolean b(FeedCloudMeta$StFeed feed) {
        int i3;
        FeedCloudMeta$RecomReasonV2 feedCloudMeta$RecomReasonV2;
        PBRepeatMessageField<FeedCloudMeta$StUser> pBRepeatMessageField;
        FeedCloudMeta$StRecomInfo feedCloudMeta$StRecomInfo = feed.recomInfo;
        if (feedCloudMeta$StRecomInfo != null && (feedCloudMeta$RecomReasonV2 = feedCloudMeta$StRecomInfo.recomReasonV2) != null && (pBRepeatMessageField = feedCloudMeta$RecomReasonV2.recomUserInfo) != null) {
            i3 = pBRepeatMessageField.size();
        } else {
            i3 = 0;
        }
        if (i3 <= 0) {
            return false;
        }
        return true;
    }

    private final boolean c(FeedCloudMeta$StFeed feed) {
        String str;
        boolean z16;
        boolean z17;
        PBStringField pBStringField;
        FeedCloudMeta$StImage feedCloudMeta$StImage;
        PBStringField pBStringField2;
        FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner = feed.liteBanner;
        String str2 = null;
        if (feedCloudMeta$StLiteBanner != null && (feedCloudMeta$StImage = feedCloudMeta$StLiteBanner.icon) != null && (pBStringField2 = feedCloudMeta$StImage.picUrl) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner2 = feed.liteBanner;
        if (feedCloudMeta$StLiteBanner2 != null && (pBStringField = feedCloudMeta$StLiteBanner2.title) != null) {
            str2 = pBStringField.get();
        }
        if (str2 != null) {
            str3 = str2;
        }
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        if (str3.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        return false;
    }

    private final boolean f(FeedCloudMeta$StFeed feed) {
        FeedCloudMeta$RecomReasonV2 feedCloudMeta$RecomReasonV2;
        PBStringField pBStringField;
        String str;
        boolean z16;
        FeedCloudMeta$StRecomInfo feedCloudMeta$StRecomInfo = feed.recomInfo;
        if (feedCloudMeta$StRecomInfo == null || (feedCloudMeta$RecomReasonV2 = feedCloudMeta$StRecomInfo.recomReasonV2) == null || (pBStringField = feedCloudMeta$RecomReasonV2.recomReason) == null || (str = pBStringField.get()) == null) {
            return false;
        }
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    private final boolean h(FeedCloudMeta$StFeed feed) {
        Integer num;
        PBInt32Field pBInt32Field;
        FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner = feed.liteBanner;
        if (feedCloudMeta$StLiteBanner != null && (pBInt32Field = feedCloudMeta$StLiteBanner.business_type) != null) {
            num = Integer.valueOf(pBInt32Field.get());
        } else {
            num = null;
        }
        if ((num == null || num.intValue() != 7) && ((num == null || num.intValue() != 8) && (num == null || num.intValue() != 6))) {
            return false;
        }
        return true;
    }

    public final int a(@Nullable FeedCloudMeta$StFeed feed) {
        if (feed == null) {
            return 0;
        }
        if (h(feed) && c(feed)) {
            return 1;
        }
        if (!f(feed)) {
            return 0;
        }
        if (b(feed)) {
            return 2;
        }
        return 3;
    }

    public final boolean d(int type) {
        if (type == 1) {
            return true;
        }
        return false;
    }

    public final boolean e(int type) {
        if (type == 2) {
            return true;
        }
        return false;
    }

    public final boolean g(int type) {
        if (type == 3) {
            return true;
        }
        return false;
    }
}
