package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class LikeUser {
    public final String nickname;
    public final String userId;

    public LikeUser(String str, String str2) {
        this.userId = str;
        this.nickname = str2;
    }

    public final int hashCode() {
        return this.nickname.hashCode() + (this.userId.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("LikeUser(userId=");
        m3.append(this.userId);
        m3.append(", nickname=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.nickname, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LikeUser)) {
            return false;
        }
        LikeUser likeUser = (LikeUser) obj;
        return Intrinsics.areEqual(this.userId, likeUser.userId) && Intrinsics.areEqual(this.nickname, likeUser.nickname);
    }
}
