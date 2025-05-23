package bn0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import bn0.e;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdClickLocationParams;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a implements Ad {

    /* renamed from: d, reason: collision with root package name */
    private final e f28678d;

    /* renamed from: e, reason: collision with root package name */
    private final long f28679e = a();

    public a(e eVar) {
        this.f28678d = eVar;
    }

    private long a() {
        String str;
        e.a aVar;
        if (isValid() && (aVar = this.f28678d.basic_info) != null) {
            str = aVar.aid;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        try {
            return Long.parseLong(str);
        } catch (Throwable th5) {
            QLog.e("GdtWXMINIProgramAd", 1, "[getAIdImpl]", th5);
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean disableLaunchApp() {
        e.b bVar;
        if (isValid() && (bVar = this.f28678d.dest_info) != null && bVar.disable_jump_app_home) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public long getAId() {
        return this.f28679e;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppChannelAppName() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppChannelAuthorName() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppChannelFeatureListUrl() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppChannelICPNumber() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppChannelPermissionUrl() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppChannelPrivacyUrl() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppChannelSuitableAge() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppChannelVersionName() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppDeeplink(AdClickLocationParams adClickLocationParams) {
        e.b bVar;
        if (isValid() && (bVar = this.f28678d.dest_info) != null) {
            return bVar.deep_link;
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppDownloadUrlApi() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppIconUrl() {
        e.b bVar;
        e.b.a aVar;
        if (isAppProductType() && (bVar = this.f28678d.dest_info) != null && (aVar = bVar.download_info) != null) {
            return aVar.app_logo_url;
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppId() {
        e.b bVar;
        e.b.a aVar;
        if (isAppProductType() && (bVar = this.f28678d.dest_info) != null && (aVar = bVar.download_info) != null) {
            return aVar.app_id;
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppMarketDeeplink() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getAppMarketJumpType() {
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.ad.tangram.Ad
    public List<String> getAppMarketPackageName() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppName() {
        e.b bVar;
        e.b.a aVar;
        if (isAppProductType() && (bVar = this.f28678d.dest_info) != null && (aVar = bVar.download_info) != null) {
            return aVar.app_name;
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getAppPackageName() {
        e.b bVar;
        e.b.a aVar;
        if (isAppProductType() && (bVar = this.f28678d.dest_info) != null && (aVar = bVar.download_info) != null) {
            return aVar.app_package_name;
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getButtonText(int i3, int i16) {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getCarouselAdCount() {
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getCreativeSize() {
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getDestType() {
        e.b bVar;
        if (isValid() && (bVar = this.f28678d.dest_info) != null) {
            return bVar.dest_type;
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getExtJSON() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public List<?> getFeedbackItems() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getInnerShowType() {
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getMDPACount() {
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getPosId() {
        e.a aVar;
        if (isValid() && (aVar = this.f28678d.basic_info) != null) {
            return aVar.pos_id;
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getProductType() {
        e.a aVar;
        if (isValid() && (aVar = this.f28678d.basic_info) != null) {
            return aVar.product_type;
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getQuickAppDeeplink() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getRelationTarget() {
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getTencent_video_id() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getTraceId() {
        e.c cVar;
        if (isValid() && (cVar = this.f28678d.report_info) != null) {
            return cVar.trace_id;
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getUrlForAction() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getUrlForClick() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getUrlForEffect() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getUrlForFeedBack() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getUrlForImpression() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getUrlForLandingPage() {
        e.b bVar;
        if (!isValid() || (bVar = this.f28678d.dest_info) == null) {
            return null;
        }
        return bVar.dest_url;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getUrlForRewardLandingPage() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getVia() {
        e.c cVar;
        if (isValid() && (cVar = this.f28678d.report_info) != null) {
            return cVar.via;
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getVideoHeight() {
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getVideoUrl(AdClickLocationParams adClickLocationParams) {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getVideoWidth() {
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getViewId(AdClickLocationParams adClickLocationParams) {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getWXCanvasExtInfo(AdClickLocationParams adClickLocationParams) {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getWXChannelAppID() {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getWXMINIGameJumpType() {
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getWXMINIProgramAppID(AdClickLocationParams adClickLocationParams) {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public int getWXMINIProgramOpenType(AdClickLocationParams adClickLocationParams) {
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getWXMINIProgramPath(AdClickLocationParams adClickLocationParams) {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getWXMINIProgramTraceData(AdClickLocationParams adClickLocationParams) {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getWXMINIProgramUserName(AdClickLocationParams adClickLocationParams) {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getWXToken(AdClickLocationParams adClickLocationParams) {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isAppProductType() {
        if (getProductType() == 12) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isAppXiJing() {
        if (isAppProductType() && getDestType() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isAppXiJingDefault() {
        if (isAppProductType() && getDestType() == 10) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isAppXiJingFengling() {
        if (isAppProductType() && getDestType() == 4) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isDeeplinkFallbackToUrl() {
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isDownloadEnabled() {
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isEnableHalfScreenDownload() {
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isJDProductType() {
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isOlympicInterPageType() {
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isQQMINIProgram() {
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isQuickAppProductType() {
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isTripleLink() {
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isValid() {
        if (this.f28678d != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isVideoOnTopDisabled() {
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isWXCanvasAd() {
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isWXCustomerService() {
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isWXMINIGameProductType() {
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isWXMINIProgram() {
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isWXMINIProgramOrWXMINIGameProductType() {
        return false;
    }

    @Override // com.tencent.ad.tangram.Ad
    public boolean isXijingByExtensionType() {
        return false;
    }

    @NonNull
    public String toString() {
        return "";
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getUrlForClick(AdClickLocationParams adClickLocationParams) {
        return null;
    }

    @Override // com.tencent.ad.tangram.Ad
    public String getUrlForLandingPage(AdClickLocationParams adClickLocationParams) {
        return getUrlForLandingPage();
    }
}
