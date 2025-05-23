package com.tencent.hippykotlin.demo.pages.nearby.base.data;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n35.v;

/* loaded from: classes31.dex */
public final class NearbyFeedPosterData implements PosterDataHolder<NearbyFeedPosterData> {
    public static final Companion Companion = new Companion();
    public final int appId;
    public final AddressInfo feedAddress;
    public final String feedFallbackImage;
    public final String feedId;
    public final v feedImage;
    public final String feedTitle;
    public NearbyFeedPosterData posterData;
    public final String themeId;
    public final String userAvatar;
    public final String userId;
    public final String userNickname;

    /* loaded from: classes31.dex */
    public static final class AddressInfo {
        public final String city;
        public final String displayName;
        public final String district;

        public AddressInfo() {
            this(null, null, null, 7, null);
        }

        public final int hashCode() {
            return this.displayName.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.district, this.city.hashCode() * 31, 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("AddressInfo(city=");
            m3.append(this.city);
            m3.append(", district=");
            m3.append(this.district);
            m3.append(", displayName=");
            return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.displayName, ')');
        }

        public AddressInfo(String str, String str2, String str3) {
            this.city = str;
            this.district = str2;
            this.displayName = str3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AddressInfo)) {
                return false;
            }
            AddressInfo addressInfo = (AddressInfo) obj;
            return Intrinsics.areEqual(this.city, addressInfo.city) && Intrinsics.areEqual(this.district, addressInfo.district) && Intrinsics.areEqual(this.displayName, addressInfo.displayName);
        }

        public /* synthetic */ AddressInfo(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this("", "", "");
        }
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    public NearbyFeedPosterData() {
        this(0, (String) null, (String) null, (v) null, (AddressInfo) null, (String) null, (String) null, (String) null, (String) null, 1023);
    }

    public final Object getPosterData() {
        return this.posterData;
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.feedId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.userId, this.appId * 31, 31), 31);
        v vVar = this.feedImage;
        int m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.feedFallbackImage, (m3 + (vVar == null ? 0 : vVar.hashCode())) * 31, 31);
        AddressInfo addressInfo = this.feedAddress;
        return this.themeId.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.userNickname, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.userAvatar, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.feedTitle, (m16 + (addressInfo != null ? addressInfo.hashCode() : 0)) * 31, 31), 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NearbyFeedPosterData(appId=");
        m3.append(this.appId);
        m3.append(", userId=");
        m3.append(this.userId);
        m3.append(", feedId=");
        m3.append(this.feedId);
        m3.append(", feedImage=");
        m3.append(this.feedImage);
        m3.append(", feedFallbackImage=");
        m3.append(this.feedFallbackImage);
        m3.append(", feedAddress=");
        m3.append(this.feedAddress);
        m3.append(", feedTitle=");
        m3.append(this.feedTitle);
        m3.append(", userAvatar=");
        m3.append(this.userAvatar);
        m3.append(", userNickname=");
        m3.append(this.userNickname);
        m3.append(", themeId=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.themeId, ')');
    }

    public NearbyFeedPosterData(int i3, String str, String str2, v vVar, String str3, AddressInfo addressInfo, String str4, String str5, String str6, String str7) {
        this.appId = i3;
        this.userId = str;
        this.feedId = str2;
        this.feedImage = vVar;
        this.feedFallbackImage = str3;
        this.feedAddress = addressInfo;
        this.feedTitle = str4;
        this.userAvatar = str5;
        this.userNickname = str6;
        this.themeId = str7;
        this.posterData = this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyFeedPosterData)) {
            return false;
        }
        NearbyFeedPosterData nearbyFeedPosterData = (NearbyFeedPosterData) obj;
        return this.appId == nearbyFeedPosterData.appId && Intrinsics.areEqual(this.userId, nearbyFeedPosterData.userId) && Intrinsics.areEqual(this.feedId, nearbyFeedPosterData.feedId) && Intrinsics.areEqual(this.feedImage, nearbyFeedPosterData.feedImage) && Intrinsics.areEqual(this.feedFallbackImage, nearbyFeedPosterData.feedFallbackImage) && Intrinsics.areEqual(this.feedAddress, nearbyFeedPosterData.feedAddress) && Intrinsics.areEqual(this.feedTitle, nearbyFeedPosterData.feedTitle) && Intrinsics.areEqual(this.userAvatar, nearbyFeedPosterData.userAvatar) && Intrinsics.areEqual(this.userNickname, nearbyFeedPosterData.userNickname) && Intrinsics.areEqual(this.themeId, nearbyFeedPosterData.themeId);
    }

    public /* synthetic */ NearbyFeedPosterData(int i3, String str, String str2, v vVar, AddressInfo addressInfo, String str3, String str4, String str5, String str6, int i16) {
        this((i16 & 1) != 0 ? 2 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? null : vVar, (i16 & 16) != 0 ? "" : null, (i16 & 32) != 0 ? null : addressInfo, (i16 & 64) != 0 ? "" : str3, (i16 & 128) != 0 ? "" : str4, (i16 & 256) != 0 ? "" : str5, (i16 & 512) != 0 ? "" : str6);
    }
}
