package i6;

import TianShuJce.AdItem;
import TianShuJce.AdPlacementInfo;
import android.text.TextUtils;
import com.qzone.component.banner.BusinessADBannerData;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    public static String F = "1";
    private String A;
    private VideoInfo B;
    private String C;
    private String D;
    private String E;

    /* renamed from: a, reason: collision with root package name */
    private AdItem f407265a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f407266b;

    /* renamed from: c, reason: collision with root package name */
    private String f407267c;

    /* renamed from: d, reason: collision with root package name */
    private String f407268d;

    /* renamed from: e, reason: collision with root package name */
    private String f407269e;

    /* renamed from: f, reason: collision with root package name */
    private String f407270f;

    /* renamed from: g, reason: collision with root package name */
    private String f407271g;

    /* renamed from: h, reason: collision with root package name */
    private String f407272h;

    /* renamed from: i, reason: collision with root package name */
    private String f407273i;

    /* renamed from: j, reason: collision with root package name */
    private String f407274j;

    /* renamed from: k, reason: collision with root package name */
    private String f407275k;

    /* renamed from: l, reason: collision with root package name */
    private String f407276l;

    /* renamed from: m, reason: collision with root package name */
    private String f407277m;

    /* renamed from: n, reason: collision with root package name */
    private String f407278n;

    /* renamed from: o, reason: collision with root package name */
    private String f407279o;

    /* renamed from: p, reason: collision with root package name */
    private String f407280p;

    /* renamed from: q, reason: collision with root package name */
    private String f407281q;

    /* renamed from: r, reason: collision with root package name */
    private String f407282r;

    /* renamed from: s, reason: collision with root package name */
    private String f407283s;

    /* renamed from: t, reason: collision with root package name */
    private String f407284t;

    /* renamed from: u, reason: collision with root package name */
    private String f407285u;

    /* renamed from: v, reason: collision with root package name */
    private String f407286v;

    /* renamed from: w, reason: collision with root package name */
    private String f407287w;

    /* renamed from: x, reason: collision with root package name */
    private String f407288x;

    /* renamed from: y, reason: collision with root package name */
    private String f407289y;

    /* renamed from: z, reason: collision with root package name */
    private String f407290z;

    public a(com.qzone.feed.business.model.a aVar) {
        BusinessADBannerData businessADBannerData;
        AdPlacementInfo adPlacementInfo;
        if (aVar != null && (businessADBannerData = aVar.f47123g) != null && (adPlacementInfo = businessADBannerData.tianshuAdPlacementInfo) != null && !bl.b(adPlacementInfo.lst)) {
            AdItem adItem = aVar.f47123g.tianshuAdPlacementInfo.lst.get(0);
            this.f407265a = adItem;
            Map<String, String> map = adItem.argList;
            if (map == null) {
                QLog.e("GeneralModelBannerData", 1, "adItem.argList == null");
                return;
            }
            this.f407266b = map;
            this.f407267c = map.get(QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID);
            this.f407268d = this.f407266b.get(WinkDaTongReportConstant.ElementParamKey.MODEL_ID);
            this.f407270f = this.f407266b.get("appid");
            this.f407271g = this.f407266b.get(ReportDataBuilder.KEY_PRODUCT_ID);
            this.f407269e = this.f407266b.get("ad_type");
            this.f407272h = this.f407266b.get("app_name");
            this.f407273i = this.f407266b.get("avatar");
            this.f407274j = this.f407266b.get("nick");
            this.f407275k = this.f407266b.get("title");
            this.f407276l = this.f407266b.get("subtitle1");
            this.f407277m = this.f407266b.get("subtitle2");
            this.f407278n = this.f407266b.get("video_type");
            this.f407279o = this.f407266b.get("video_url");
            this.f407280p = this.f407266b.get("vid");
            this.f407281q = this.f407266b.get("video_cover");
            this.f407282r = this.f407266b.get("animation");
            this.f407283s = this.f407266b.get("jump_url");
            this.f407284t = this.f407266b.get("disable_jump");
            this.f407285u = this.f407266b.get(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT);
            this.f407286v = this.f407266b.get("button_jump");
            this.f407287w = this.f407266b.get("extra_info_1");
            this.f407288x = this.f407266b.get("extra_info_2");
            this.f407289y = this.f407266b.get("extra_info_3");
            this.f407290z = this.f407266b.get("material_type");
            this.A = this.f407266b.get("picture");
            this.C = this.f407266b.get("background");
            this.D = this.f407266b.get("subtitle3");
            this.E = this.f407266b.get("subtitle3_jump_url");
            b();
            QLog.d("GeneralModelBannerData", 1, "GeneralModelBannerData{AdId=" + c() + ", BizId=" + this.f407267c + ", ModelId=" + this.f407268d + ", AdType=" + this.f407269e + ", AppId=" + this.f407270f + ", ProductId=" + this.f407271g + ", AppName=" + this.f407272h + "}");
            return;
        }
        QLog.e("GeneralModelBannerData", 1, "GeneralModelBannerData  data is empty");
    }

    private void b() {
        if (TextUtils.isEmpty(this.f407281q)) {
            return;
        }
        if (TextUtils.isEmpty(this.f407279o) && TextUtils.isEmpty(this.f407280p)) {
            return;
        }
        VideoInfo videoInfo = new VideoInfo();
        this.B = videoInfo;
        videoInfo.playType = (byte) 1;
        PictureUrl pictureUrl = new PictureUrl();
        pictureUrl.url = this.f407281q;
        VideoUrl videoUrl = new VideoUrl();
        videoUrl.url = this.f407279o;
        String str = this.f407278n;
        if (str != null && str.equals("2")) {
            VideoInfo videoInfo2 = this.B;
            videoInfo2.width = 174;
            videoInfo2.height = 309;
        }
        VideoInfo videoInfo3 = this.B;
        videoInfo3.coverUrl = pictureUrl;
        videoInfo3.videoUrl = videoUrl;
        videoInfo3.videoId = this.f407280p;
    }

    public VideoInfo A() {
        return this.B;
    }

    public boolean a() {
        return !F.equals(this.f407284t);
    }

    public long c() {
        AdItem adItem = this.f407265a;
        if (adItem != null) {
            return adItem.iAdId;
        }
        return 0L;
    }

    public AdItem d() {
        return this.f407265a;
    }

    public String e() {
        return this.f407269e;
    }

    public String f() {
        return this.f407282r;
    }

    public String g() {
        return this.f407270f;
    }

    public String h() {
        return this.f407273i;
    }

    public String i() {
        return this.C;
    }

    public String j() {
        return this.f407286v;
    }

    public String k() {
        return this.f407285u;
    }

    public String l() {
        return this.f407287w;
    }

    public String m() {
        return this.f407288x;
    }

    public String n() {
        return this.f407283s;
    }

    public String o() {
        return this.f407290z;
    }

    public String p() {
        return this.f407268d;
    }

    public String q() {
        return this.f407274j;
    }

    public String r() {
        return this.A;
    }

    public String s() {
        return this.f407271g;
    }

    public String t() {
        return this.f407276l;
    }

    public String toString() {
        return "GeneralModelBannerData{, adId=" + c() + ", mTransDataMap=" + this.f407266b + ", mBizId='" + this.f407267c + "', mModelId='" + this.f407268d + "', mAdType='" + this.f407269e + "', mAppId='" + this.f407270f + "', mProductId='" + this.f407271g + "', mAppName='" + this.f407272h + "', mAvatar='" + this.f407273i + "', mNick='" + this.f407274j + "', mTitle='" + this.f407275k + "', mSubTitle1='" + this.f407276l + "', mSubTitle2='" + this.f407277m + "', mVideoType='" + this.f407278n + "', mVideoUrl='" + this.f407279o + "', mVideoId='" + this.f407280p + "', mVideoCover='" + this.f407281q + "', mAnimation='" + this.f407282r + "', mJumpUrl='" + this.f407283s + "', mDisableJump='" + this.f407284t + "', mButtonText='" + this.f407285u + "', mButtonJump='" + this.f407286v + "', mExtraInfo1='" + this.f407287w + "', mExtraInfo2='" + this.f407288x + "', mExtraInfo3='" + this.f407289y + "', mMaterialType='" + this.f407290z + "', mPicture='" + this.A + "', mVideoInfo=" + this.B + ", mBackground='" + this.C + "', mSubTitle3='" + this.D + "', mSubTitle3JumpUrl='" + this.E + "'}";
    }

    public String u() {
        return this.f407277m;
    }

    public String v() {
        return this.D;
    }

    public String w() {
        return this.E;
    }

    public String x() {
        return this.f407275k;
    }

    public Map<String, String> y() {
        return this.f407266b;
    }

    public String z() {
        return this.f407281q;
    }
}
