package com.tencent.hippykotlin.demo.pages.nearby.base.utils;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.ProcessConstant;

/* loaded from: classes31.dex */
public final class PublicAccountConfig {
    public static final Companion Companion = new Companion();
    public static final Map<Integer, String> appIdToConfigKey;
    public final int appId;
    public final FollowBarConfig followBar;
    public final FollowModalConfig followModal;
    public final String name;
    public final String uin;

    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    static {
        Map<Integer, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, "jieban"), TuplesKt.to(2, ProcessConstant.NEARBY));
        appIdToConfigKey = mapOf;
    }

    public PublicAccountConfig(int i3, String str, String str2, FollowModalConfig followModalConfig, FollowBarConfig followBarConfig) {
        this.appId = i3;
        this.uin = str;
        this.name = str2;
        this.followModal = followModalConfig;
        this.followBar = followBarConfig;
    }

    public final int hashCode() {
        return this.followBar.hashCode() + ((this.followModal.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.name, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.uin, this.appId * 31, 31), 31)) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("PublicAccountConfig(appId=");
        m3.append(this.appId);
        m3.append(", uin=");
        m3.append(this.uin);
        m3.append(", name=");
        m3.append(this.name);
        m3.append(", followModal=");
        m3.append(this.followModal);
        m3.append(", followBar=");
        m3.append(this.followBar);
        m3.append(')');
        return m3.toString();
    }

    /* loaded from: classes31.dex */
    public static final class FollowBarConfig {
        public final boolean enable;
        public final Map<Integer, Integer> showIntervalS;

        public FollowBarConfig(boolean z16, Map<Integer, Integer> map) {
            this.enable = z16;
            this.showIntervalS = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        public final int hashCode() {
            boolean z16 = this.enable;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return this.showIntervalS.hashCode() + (r06 * 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("FollowBarConfig(enable=");
            m3.append(this.enable);
            m3.append(", showIntervalS=");
            m3.append(this.showIntervalS);
            m3.append(')');
            return m3.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FollowBarConfig)) {
                return false;
            }
            FollowBarConfig followBarConfig = (FollowBarConfig) obj;
            return this.enable == followBarConfig.enable && Intrinsics.areEqual(this.showIntervalS, followBarConfig.showIntervalS);
        }
    }

    /* loaded from: classes31.dex */
    public static final class FollowModalConfig {
        public final boolean enable;
        public final String posterUrl;
        public final long showIntervalS;
        public final String title;

        public FollowModalConfig(boolean z16, String str, String str2, long j3) {
            this.enable = z16;
            this.title = str;
            this.posterUrl = str2;
            this.showIntervalS = j3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6 */
        public final int hashCode() {
            boolean z16 = this.enable;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return d.a(this.showIntervalS) + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.posterUrl, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.title, r06 * 31, 31), 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("FollowModalConfig(enable=");
            m3.append(this.enable);
            m3.append(", title=");
            m3.append(this.title);
            m3.append(", posterUrl=");
            m3.append(this.posterUrl);
            m3.append(", showIntervalS=");
            return GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(m3, this.showIntervalS, ')');
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FollowModalConfig)) {
                return false;
            }
            FollowModalConfig followModalConfig = (FollowModalConfig) obj;
            return this.enable == followModalConfig.enable && Intrinsics.areEqual(this.title, followModalConfig.title) && Intrinsics.areEqual(this.posterUrl, followModalConfig.posterUrl) && this.showIntervalS == followModalConfig.showIntervalS;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublicAccountConfig)) {
            return false;
        }
        PublicAccountConfig publicAccountConfig = (PublicAccountConfig) obj;
        return this.appId == publicAccountConfig.appId && Intrinsics.areEqual(this.uin, publicAccountConfig.uin) && Intrinsics.areEqual(this.name, publicAccountConfig.name) && Intrinsics.areEqual(this.followModal, publicAccountConfig.followModal) && Intrinsics.areEqual(this.followBar, publicAccountConfig.followBar);
    }
}
