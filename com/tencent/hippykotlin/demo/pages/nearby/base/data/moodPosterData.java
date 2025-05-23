package com.tencent.hippykotlin.demo.pages.nearby.base.data;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class moodPosterData {
    public final String mainPosterBgUrl;
    public final int mid;
    public final String moodFallbackImage;
    public final String moodName;
    public final NBPSsoLocation moodPoi;
    public final String moodShareImage;
    public final String tinyId;
    public final String userAvatar;
    public final String userNickname;

    public moodPosterData() {
        this(0, null, null, null, null, null, 511);
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.moodFallbackImage, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.moodShareImage, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.tinyId, this.mid * 31, 31), 31), 31);
        NBPSsoLocation nBPSsoLocation = this.moodPoi;
        return this.mainPosterBgUrl.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.userNickname, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.userAvatar, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.moodName, (m3 + (nBPSsoLocation == null ? 0 : nBPSsoLocation.hashCode())) * 31, 31), 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("moodPosterData(mid=");
        m3.append(this.mid);
        m3.append(", tinyId=");
        m3.append(this.tinyId);
        m3.append(", moodShareImage=");
        m3.append(this.moodShareImage);
        m3.append(", moodFallbackImage=");
        m3.append(this.moodFallbackImage);
        m3.append(", moodPoi=");
        m3.append(this.moodPoi);
        m3.append(", moodName=");
        m3.append(this.moodName);
        m3.append(", userAvatar=");
        m3.append(this.userAvatar);
        m3.append(", userNickname=");
        m3.append(this.userNickname);
        m3.append(", mainPosterBgUrl=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.mainPosterBgUrl, ')');
    }

    public moodPosterData(int i3, String str, String str2, String str3, NBPSsoLocation nBPSsoLocation, String str4, String str5, String str6, String str7) {
        this.mid = i3;
        this.tinyId = str;
        this.moodShareImage = str2;
        this.moodFallbackImage = str3;
        this.moodPoi = nBPSsoLocation;
        this.moodName = str4;
        this.userAvatar = str5;
        this.userNickname = str6;
        this.mainPosterBgUrl = str7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof moodPosterData)) {
            return false;
        }
        moodPosterData moodposterdata = (moodPosterData) obj;
        return this.mid == moodposterdata.mid && Intrinsics.areEqual(this.tinyId, moodposterdata.tinyId) && Intrinsics.areEqual(this.moodShareImage, moodposterdata.moodShareImage) && Intrinsics.areEqual(this.moodFallbackImage, moodposterdata.moodFallbackImage) && Intrinsics.areEqual(this.moodPoi, moodposterdata.moodPoi) && Intrinsics.areEqual(this.moodName, moodposterdata.moodName) && Intrinsics.areEqual(this.userAvatar, moodposterdata.userAvatar) && Intrinsics.areEqual(this.userNickname, moodposterdata.userNickname) && Intrinsics.areEqual(this.mainPosterBgUrl, moodposterdata.mainPosterBgUrl);
    }

    public /* synthetic */ moodPosterData(int i3, String str, NBPSsoLocation nBPSsoLocation, String str2, String str3, String str4, int i16) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : null, (i16 & 8) != 0 ? "" : null, (i16 & 16) != 0 ? null : nBPSsoLocation, (i16 & 32) != 0 ? "" : null, (i16 & 64) != 0 ? "" : str2, (i16 & 128) != 0 ? "" : str3, (i16 & 256) != 0 ? "" : str4);
    }
}
