package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import g25.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BannerDelegateData extends AbsDelegateData {
    public AdelieHomePageBannerConfig bannerConfig;
    public g robotGuideInfo;

    public BannerDelegateData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final int hashCode() {
        AdelieHomePageBannerConfig adelieHomePageBannerConfig = this.bannerConfig;
        int hashCode = (adelieHomePageBannerConfig == null ? 0 : adelieHomePageBannerConfig.hashCode()) * 31;
        g gVar = this.robotGuideInfo;
        return hashCode + (gVar != null ? gVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("BannerDelegateData(bannerConfig=");
        m3.append(this.bannerConfig);
        m3.append(", robotGuideInfo=");
        m3.append(this.robotGuideInfo);
        m3.append(')');
        return m3.toString();
    }

    public /* synthetic */ BannerDelegateData(AdelieHomePageBannerConfig adelieHomePageBannerConfig, g gVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }

    public BannerDelegateData(AdelieHomePageBannerConfig adelieHomePageBannerConfig, g gVar) {
        super(1);
        this.bannerConfig = adelieHomePageBannerConfig;
        this.robotGuideInfo = gVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BannerDelegateData)) {
            return false;
        }
        BannerDelegateData bannerDelegateData = (BannerDelegateData) obj;
        return Intrinsics.areEqual(this.bannerConfig, bannerDelegateData.bannerConfig) && Intrinsics.areEqual(this.robotGuideInfo, bannerDelegateData.robotGuideInfo);
    }
}
