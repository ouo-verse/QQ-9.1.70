package com.qq.e.comm.plugin.tangramsplash;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Pair;
import android.view.View;
import com.qq.e.comm.pi.SOI;
import com.qq.e.comm.pi.SOIV2;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.tangramsplash.report.SplashLinkReporter;
import com.qq.e.tg.splash.TGSplashAD;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements SOIV2 {
    private SOI.AdProductType a(int i3) {
        if (i3 == 0) {
            return SOI.AdProductType.APP;
        }
        if (i3 == 1) {
            return SOI.AdProductType.LINK_WEB;
        }
        if (i3 != 2) {
            return SOI.AdProductType.UNKNOWN;
        }
        return SOI.AdProductType.MINI_PROGRAM;
    }

    private SOI.AdSubType b(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return SOI.AdSubType.UNKNOWN;
            }
            return SOI.AdSubType.VIDEO;
        }
        return SOI.AdSubType.IMG;
    }

    @Override // com.qq.e.comm.pi.SOI
    public void clickFollowUAd(View view) {
        a.a().b(view, (r) null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public void clickJoinAd(View view) {
        a.a().a(view, (r) null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public void exposureFollowUAd() {
        a.a().O(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public void exposureJoinAd(View view, long j3) {
        a.a().a(view, j3, (r) null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getAdIconText() {
        return a.a().Q(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getAdJson() {
        return a.a().p(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getBarVideoFile() {
        return a.a().M(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getBarVideoUrl() {
        return a.a().N(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getButtonTxt() {
        return a.a().s(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getCl() {
        return a.a().y(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getCorporateImg() {
        return a.a().o(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getCorporateName() {
        return a.a().n(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getDesc() {
        return a.a().u(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public int getExposureDelay() {
        return a.a().v(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public int getFollowUAdShowTime() {
        return a.a().P(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getIconFile() {
        return a.a().K(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getIconUrl() {
        return a.a().L(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public int getInteractiveAdType() {
        return a.a().H(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public Bitmap getJoinAdImage(BitmapFactory.Options options) {
        return a.a().a(options, (r) null);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public int getJoinAdType(Object obj) {
        r rVar;
        if (obj instanceof r) {
            rVar = (r) obj;
        } else {
            rVar = null;
        }
        return a.a().aa(rVar);
    }

    @Override // com.qq.e.comm.pi.SOI
    public JSONObject getOneShotWindowAnimationInfo() {
        return a.a().U(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public List<Pair<String, String>> getOneShotWindowImageList() {
        return a.a().T(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public Bitmap getOneshotCoverImage(BitmapFactory.Options options) {
        return a.a().b(options, (r) null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getOneshotCoverImagePath() {
        return a.a().g(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getOneshotCoverImageUrl() {
        return a.a().f(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getOneshotSubOrderImagePath() {
        return a.a().i(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getOneshotSubOrderImageUrl() {
        return a.a().h(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getOneshotSubOrderVideoPath() {
        return a.a().k(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getOneshotSubOrderVideoUrl() {
        return a.a().j(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public JSONObject getPassThroughData() {
        return a.a().R(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public SOI.AdProductType getSplashProductType() {
        return a(a.a().m(null));
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getSubOrderAdJson(Object obj) {
        return a.a().q((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getSubOrderIconFile() {
        return a.a().V(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getSubOrderIconUrl() {
        return a.a().W(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getSubOrderTransparentVideoFile() {
        return a.a().X(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getSubOrderTransparentVideoUrl() {
        return a.a().Y(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public SOI.AdSubType getSubType() {
        return b(a.a().x(null));
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getTitle() {
        return a.a().t(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public String getVideoPath() {
        return a.a().l(null);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public boolean isAlphaVideoAd(Object obj) {
        return a.a().E((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOI
    public boolean isContractAd() {
        return a.a().F(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public boolean isExtendAd() {
        return a.a().B(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public boolean isFollowUAd() {
        return a.a().J(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public boolean isHideAdIcon() {
        return a.a().I(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public boolean isInEffectPlayTime() {
        return a.a().z(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public boolean isInteractive() {
        return a.a().G(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public boolean isJoinAd() {
        return a.a().b(null);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public boolean isOlympicGallery(Object obj) {
        if (obj instanceof r) {
            return a.a().Z((r) obj);
        }
        return a.a().Z(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public boolean isRealPreViewOrder() {
        return a.a().S(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public boolean isSplashMute() {
        return a.a().w(null);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public boolean isSplashOrderMute(Object obj) {
        return a.a().ab((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOI
    public boolean isTopView() {
        return a.a().c(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public boolean isVideoAd() {
        return a.a().D(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public boolean needDoFloatViewAnimation() {
        return a.a().C(null);
    }

    @Override // com.qq.e.comm.pi.SOI
    public boolean needHideLogo() {
        return a.a().A(null);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public void reportCost(int i3, int i16, boolean z16, Map map, Object obj) {
        com.qq.e.comm.plugin.tangramsplash.report.c.a(a((r) obj), z16, i3, i16, map);
    }

    @Override // com.qq.e.comm.pi.SOI
    public void reportJoinAdCost(int i3) {
        a.a().a(i3, (r) null);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public void reportLinkEvent(TGSplashAD.ReportParams reportParams) {
        if (reportParams != null) {
            SplashLinkReporter.a(reportParams.eventId, reportParams.posId, reportParams.adJson);
        }
    }

    @Override // com.qq.e.comm.pi.SOI
    public void reportNegativeFeedback() {
        a.a().r(null);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public void reportNoUseSplashReason(int i3, boolean z16, Object obj) {
        String str;
        r a16 = a((r) obj);
        if (a16 != null) {
            str = a16.s();
        } else {
            str = null;
        }
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310298, str, a16, i3, z16);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public void clickFollowUAd(View view, Object obj) {
        a.a().b(view, (r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public void clickJoinAd(View view, Object obj) {
        if (obj instanceof r) {
            a.a().a(view, (r) obj);
        }
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public void exposureFollowUAd(Object obj) {
        a.a().O((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public void exposureJoinAd(View view, long j3, Object obj) {
        if (obj instanceof r) {
            a.a().a(view, j3, (r) obj);
        }
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getAdIconText(Object obj) {
        return a.a().Q((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getAdJson(Object obj) {
        return a.a().p((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getBarVideoFile(Object obj) {
        return a.a().M((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getBarVideoUrl(Object obj) {
        return a.a().N((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getButtonTxt(Object obj) {
        return a.a().s((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getCl(Object obj) {
        return a.a().y((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getCorporateImg(Object obj) {
        return a.a().o((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getCorporateName(Object obj) {
        return a.a().n((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getDesc(Object obj) {
        return a.a().u((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public int getExposureDelay(Object obj) {
        return a.a().v((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public int getFollowUAdShowTime(Object obj) {
        return a.a().P((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getIconFile(Object obj) {
        return a.a().K((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getIconUrl(Object obj) {
        return a.a().L((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public int getInteractiveAdType(Object obj) {
        return a.a().H((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public Bitmap getJoinAdImage(BitmapFactory.Options options, Object obj) {
        return a.a().a(options, (r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public JSONObject getOneShotWindowAnimationInfo(Object obj) {
        return a.a().U((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public List<Pair<String, String>> getOneShotWindowImageList(Object obj) {
        return a.a().T((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public Bitmap getOneshotCoverImage(BitmapFactory.Options options, Object obj) {
        return a.a().b(options, (r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getOneshotCoverImagePath(Object obj) {
        return a.a().g((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getOneshotCoverImageUrl(Object obj) {
        return a.a().f((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getOneshotSubOrderImagePath(Object obj) {
        return a.a().i((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getOneshotSubOrderImageUrl(Object obj) {
        return a.a().h((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getOneshotSubOrderVideoPath(Object obj) {
        return a.a().k((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getOneshotSubOrderVideoUrl(Object obj) {
        return a.a().j((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public JSONObject getPassThroughData(Object obj) {
        return a.a().R((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public SOI.AdProductType getSplashProductType(Object obj) {
        return a(a.a().m((r) obj));
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getSubOrderIconFile(Object obj) {
        return a.a().V((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getSubOrderIconUrl(Object obj) {
        return a.a().W((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getSubOrderTransparentVideoFile(Object obj) {
        return a.a().X((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getSubOrderTransparentVideoUrl(Object obj) {
        return a.a().Y((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public SOI.AdSubType getSubType(Object obj) {
        return b(a.a().x((r) obj));
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getTitle(Object obj) {
        return a.a().t((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public String getVideoPath(Object obj) {
        return a.a().l((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public boolean isContractAd(Object obj) {
        return a.a().F((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public boolean isExtendAd(Object obj) {
        return a.a().B((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public boolean isFollowUAd(Object obj) {
        return a.a().J((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public boolean isHideAdIcon(Object obj) {
        return a.a().I((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public boolean isInEffectPlayTime(Object obj) {
        return a.a().z((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public boolean isInteractive(Object obj) {
        return a.a().G((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public boolean isJoinAd(Object obj) {
        if (obj instanceof r) {
            return a.a().b((r) obj);
        }
        return false;
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public boolean isRealPreViewOrder(Object obj) {
        return a.a().S((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public boolean isSplashMute(Object obj) {
        return a.a().w((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public boolean isTopView(Object obj) {
        return a.a().c((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public boolean isVideoAd(Object obj) {
        return a.a().D((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public boolean needDoFloatViewAnimation(Object obj) {
        return a.a().C((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public boolean needHideLogo(Object obj) {
        return a.a().A((r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public void reportJoinAdCost(int i3, Object obj) {
        a.a().a(i3, (r) obj);
    }

    @Override // com.qq.e.comm.pi.SOIV2
    public void reportNegativeFeedback(Object obj) {
        a.a().r((r) obj);
    }

    private r a(r rVar) {
        return rVar != null ? rVar : a.a().b();
    }
}
