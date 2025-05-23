package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd;

import androidx.annotation.Nullable;
import com.tencent.tvideo.protocol.pb.AdActionButton;
import com.tencent.tvideo.protocol.pb.AdFeedHeaderInfo;
import com.tencent.tvideo.protocol.pb.AdFeedInfo;
import com.tencent.tvideo.protocol.pb.AdFloatCardInfo;
import com.tencent.tvideo.protocol.pb.AdImmersivePoster;
import com.tencent.tvideo.protocol.pb.AdImmersiveType;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import com.tencent.tvideo.protocol.pb.AdPlayFinishMaskInfo;
import com.tencent.tvideo.protocol.pb.AdPoster;
import java.util.List;
import pw2.p;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d extends a {

    /* renamed from: b, reason: collision with root package name */
    private AdImmersivePoster f304138b;

    public d(AdFeedInfo adFeedInfo) {
        super(adFeedInfo);
    }

    private AdImmersivePoster t(AdFeedInfo adFeedInfo) {
        AdImmersivePoster adImmersivePoster = this.f304138b;
        if (adImmersivePoster != null) {
            return adImmersivePoster;
        }
        if (adFeedInfo != null) {
            AdImmersivePoster adImmersivePoster2 = (AdImmersivePoster) p.c(AdImmersivePoster.class, adFeedInfo.data);
            this.f304138b = adImmersivePoster2;
            return adImmersivePoster2;
        }
        return null;
    }

    private int u(AdImmersivePoster adImmersivePoster) {
        if (adImmersivePoster == null) {
            return 0;
        }
        AdImmersiveType adImmersiveType = adImmersivePoster.immersive_type;
        if (adImmersiveType == AdImmersiveType.AD_IMMERSIVE_TYPE_HORIZONTAL) {
            return 3;
        }
        if (adImmersiveType != AdImmersiveType.AD_IMMERSIVE_TYPE_VERTICAL) {
            return 0;
        }
        return 4;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.a
    public AdActionButton c() {
        AdImmersivePoster t16 = t(this.f304128a);
        if (t16 != null) {
            return t16.action_button;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.a
    public AdOrderItem d() {
        AdFeedInfo adFeedInfo = this.f304128a;
        if (adFeedInfo != null) {
            return adFeedInfo.order_item;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.a
    public int e() {
        return 0;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.a
    @Nullable
    public List<String> f() {
        return null;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.a
    public AdPlayFinishMaskInfo g() {
        AdImmersivePoster t16 = t(this.f304128a);
        if (t16 != null) {
            return t16.mask_info;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.a
    public AdFloatCardInfo h() {
        AdImmersivePoster t16 = t(this.f304128a);
        if (t16 != null) {
            return t16.float_card_info;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.a
    public int i() {
        if (h() == null) {
            return super.i();
        }
        return super.i();
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.a
    public AdFeedHeaderInfo j() {
        AdImmersivePoster t16 = t(this.f304128a);
        if (t16 != null) {
            return t16.image_header_info;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.a
    public int k() {
        return u(t(this.f304128a));
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.a
    public String l() {
        AdPoster adPoster;
        AdImmersivePoster t16 = t(this.f304128a);
        if (t16 != null && (adPoster = t16.poster) != null) {
            return adPoster.image_url;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.a
    public String m() {
        AdPoster adPoster;
        String str;
        AdImmersivePoster t16 = t(this.f304128a);
        if (t16 == null || (adPoster = t16.poster) == null || (str = adPoster.title) == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.a
    public String n() {
        return "";
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.a
    public String o() {
        AdFeedHeaderInfo adFeedHeaderInfo;
        AdImmersivePoster t16 = t(this.f304128a);
        if (t16 != null && (adFeedHeaderInfo = t16.image_header_info) != null) {
            return adFeedHeaderInfo.icon_url;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.a
    public String p() {
        AdPoster adPoster;
        AdImmersivePoster t16 = t(this.f304128a);
        if (t16 != null && (adPoster = t16.poster) != null) {
            return adPoster.sub_title;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.a
    public boolean q() {
        return false;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.a
    public boolean r() {
        return true;
    }
}
