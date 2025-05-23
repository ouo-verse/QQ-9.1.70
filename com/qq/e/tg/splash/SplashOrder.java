package com.qq.e.tg.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Pair;
import android.view.View;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.a;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.SOI;
import com.qq.e.comm.pi.SOIV2;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.tg.splash.TGSplashAD;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SplashOrder {

    /* renamed from: a, reason: collision with root package name */
    private volatile SOIV2 f40733a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Object f40734b;

    public SplashOrder(final Context context, final String str) {
        if (StringUtil.isEmpty(str)) {
            GDTLogger.e("initSplashOrder fail with error params");
        } else if (GDTADManager.getInstance().isInitialized()) {
            GDTLogger.e("GDTADManager isInitialized");
            a();
        } else {
            GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.tg.splash.SplashOrder.1
                @Override // java.lang.Runnable
                public void run() {
                    if (GDTADManager.getInstance().initWith(context, str)) {
                        SplashOrder.this.a();
                    } else {
                        GDTLogger.e("SDK is not ready!");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        String str;
        try {
            this.f40733a = (SOIV2) GDTADManager.getInstance().getPM().getPOFactory(PM.SPLASH_AD).getSplashOrderDelegate();
        } catch (a unused) {
            str = "SplashOrder created by factory return null";
            GDTLogger.e(str);
        } catch (Throwable unused2) {
            str = "factory init fail!";
            GDTLogger.e(str);
        }
    }

    public void cacheResult(Object obj) {
        this.f40734b = obj;
    }

    public void clickFollowUAd(View view) {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                this.f40733a.clickFollowUAd(view, this.f40734b);
            } else {
                this.f40733a.clickFollowUAd(view);
            }
        }
    }

    public void clickJoinAd(View view) {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                this.f40733a.clickJoinAd(view, this.f40734b);
            } else {
                this.f40733a.clickJoinAd(view);
            }
        }
    }

    public void exposureFollowUAd() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                this.f40733a.exposureFollowUAd(this.f40734b);
            } else {
                this.f40733a.exposureFollowUAd();
            }
        }
    }

    public void exposureJoinAd(View view, long j3) {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                this.f40733a.exposureJoinAd(view, j3, this.f40734b);
            } else {
                this.f40733a.exposureJoinAd(view, j3);
            }
        }
    }

    public String getAdIconText() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getAdIconText(this.f40734b);
            }
            return this.f40733a.getAdIconText();
        }
        return null;
    }

    public String getAdJson() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getAdJson(this.f40734b);
            }
            return this.f40733a.getAdJson();
        }
        return null;
    }

    public String getBarVideoFile() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getBarVideoFile(this.f40734b);
            }
            return this.f40733a.getBarVideoFile();
        }
        return null;
    }

    public String getBarVideoUrl() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getBarVideoUrl(this.f40734b);
            }
            return this.f40733a.getBarVideoUrl();
        }
        return null;
    }

    public String getButtonTxt() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getButtonTxt(this.f40734b);
            }
            return this.f40733a.getButtonTxt();
        }
        return null;
    }

    public String getCl() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getCl(this.f40734b);
            }
            return this.f40733a.getCl();
        }
        return null;
    }

    public String getCorporateImg() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getCorporateImg(this.f40734b);
            }
            return this.f40733a.getCorporateImg();
        }
        return null;
    }

    public String getCorporateName() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getCorporateName(this.f40734b);
            }
            return this.f40733a.getCorporateName();
        }
        return null;
    }

    public String getDesc() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getDesc(this.f40734b);
            }
            return this.f40733a.getDesc();
        }
        return null;
    }

    public int getExposureDelay() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getExposureDelay(this.f40734b);
            }
            return this.f40733a.getExposureDelay();
        }
        return 5000;
    }

    public int getFollowUAdShowTime() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getFollowUAdShowTime(this.f40734b);
            }
            return this.f40733a.getFollowUAdShowTime();
        }
        return 0;
    }

    public String getIconFile() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getIconFile(this.f40734b);
            }
            return this.f40733a.getIconFile();
        }
        return null;
    }

    public String getIconUrl() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getIconUrl(this.f40734b);
            }
            return this.f40733a.getIconUrl();
        }
        return null;
    }

    public int getInteractiveAdType() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getInteractiveAdType(this.f40734b);
            }
            return this.f40733a.getInteractiveAdType();
        }
        return -1;
    }

    public Bitmap getJoinAdImage(BitmapFactory.Options options) {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getJoinAdImage(options, this.f40734b);
            }
            return this.f40733a.getJoinAdImage(options);
        }
        return null;
    }

    public int getJoinAdType() {
        if (this.f40733a != null) {
            return this.f40733a.getJoinAdType(this.f40734b);
        }
        return 0;
    }

    public JSONObject getOneShotWindowAnimationInfo() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getOneShotWindowAnimationInfo(this.f40734b);
            }
            return this.f40733a.getOneShotWindowAnimationInfo();
        }
        return null;
    }

    public List<Pair<String, String>> getOneShotWindowImageList() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getOneShotWindowImageList(this.f40734b);
            }
            return this.f40733a.getOneShotWindowImageList();
        }
        return null;
    }

    public Bitmap getOneshotCoverImage(BitmapFactory.Options options) {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getOneshotCoverImage(options, this.f40734b);
            }
            return this.f40733a.getOneshotCoverImage(options);
        }
        return null;
    }

    public String getOneshotCoverImagePath() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getOneshotCoverImagePath(this.f40734b);
            }
            return this.f40733a.getOneshotCoverImagePath();
        }
        return null;
    }

    public String getOneshotCoverImageUrl() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getOneshotCoverImageUrl(this.f40734b);
            }
            return this.f40733a.getOneshotCoverImageUrl();
        }
        return null;
    }

    public String getOneshotSubOrderImagePath() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getOneshotSubOrderImagePath(this.f40734b);
            }
            return this.f40733a.getOneshotSubOrderImagePath();
        }
        return null;
    }

    public String getOneshotSubOrderImageUrl() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getOneshotSubOrderImageUrl(this.f40734b);
            }
            return this.f40733a.getOneshotSubOrderImageUrl();
        }
        return null;
    }

    public String getOneshotSubOrderVideoPath() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getOneshotSubOrderVideoPath(this.f40734b);
            }
            return this.f40733a.getOneshotSubOrderVideoPath();
        }
        return null;
    }

    public String getOneshotSubOrderVideoUrl() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getOneshotSubOrderVideoUrl(this.f40734b);
            }
            return this.f40733a.getOneshotSubOrderVideoUrl();
        }
        return null;
    }

    public JSONObject getPassThroughData() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getPassThroughData(this.f40734b);
            }
            return this.f40733a.getPassThroughData();
        }
        return null;
    }

    public SOI.AdProductType getSplashProductType() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getSplashProductType(this.f40734b);
            }
            return this.f40733a.getSplashProductType();
        }
        return SOI.AdProductType.UNKNOWN;
    }

    public String getSubOrderIconFile() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getSubOrderIconFile(this.f40734b);
            }
            return this.f40733a.getSubOrderIconFile();
        }
        return null;
    }

    public String getSubOrderIconUrl() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getSubOrderIconUrl(this.f40734b);
            }
            return this.f40733a.getSubOrderIconUrl();
        }
        return null;
    }

    public String getSubOrderJson() {
        if (this.f40733a != null && this.f40734b != null) {
            return this.f40733a.getSubOrderAdJson(this.f40734b);
        }
        return null;
    }

    public String getSubOrderTransparentVideoFile() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getSubOrderTransparentVideoFile(this.f40734b);
            }
            return this.f40733a.getSubOrderTransparentVideoFile();
        }
        return null;
    }

    public String getSubOrderTransparentVideoUrl() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getSubOrderTransparentVideoUrl(this.f40734b);
            }
            return this.f40733a.getSubOrderTransparentVideoUrl();
        }
        return null;
    }

    public SOI.AdSubType getSubType() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getSubType(this.f40734b);
            }
            return this.f40733a.getSubType();
        }
        return SOI.AdSubType.UNKNOWN;
    }

    public String getTitle() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getTitle(this.f40734b);
            }
            return this.f40733a.getTitle();
        }
        return null;
    }

    public String getVideoPath() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.getVideoPath(this.f40734b);
            }
            return this.f40733a.getVideoPath();
        }
        return null;
    }

    public boolean isAlphaVideoAd() {
        if (this.f40733a != null && this.f40734b != null) {
            return this.f40733a.isAlphaVideoAd(this.f40734b);
        }
        return false;
    }

    public boolean isContractAd() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.isContractAd(this.f40734b);
            }
            return this.f40733a.isContractAd();
        }
        return false;
    }

    public boolean isExtendAd() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.isExtendAd(this.f40734b);
            }
            return this.f40733a.isExtendAd();
        }
        return false;
    }

    public boolean isFollowUAd() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.isFollowUAd(this.f40734b);
            }
            return this.f40733a.isFollowUAd();
        }
        return false;
    }

    public boolean isHideAdIcon() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.isHideAdIcon(this.f40734b);
            }
            return this.f40733a.isHideAdIcon();
        }
        return false;
    }

    public boolean isInEffectPlayTime() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.isInEffectPlayTime(this.f40734b);
            }
            return this.f40733a.isInEffectPlayTime();
        }
        return false;
    }

    public boolean isInteractive() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.isInteractive(this.f40734b);
            }
            return this.f40733a.isInteractive();
        }
        return false;
    }

    public boolean isJoinAd() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.isJoinAd(this.f40734b);
            }
            return this.f40733a.isJoinAd();
        }
        return false;
    }

    public boolean isOlympicGallery() {
        SOIV2 soiv2;
        Object obj;
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                soiv2 = this.f40733a;
                obj = this.f40734b;
            } else {
                soiv2 = this.f40733a;
                obj = null;
            }
            return soiv2.isOlympicGallery(obj);
        }
        return false;
    }

    public boolean isRealPreViewOrder() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.isRealPreViewOrder(this.f40734b);
            }
            return this.f40733a.isRealPreViewOrder();
        }
        return false;
    }

    public boolean isSplashMute() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.isSplashMute(this.f40734b);
            }
            return this.f40733a.isSplashMute();
        }
        return true;
    }

    public boolean isSplashOrderMute() {
        try {
            if (GDTADManager.getInstance().getPM() == null || GDTADManager.getInstance().getPM().getPluginVersion() < 2900 || this.f40733a == null) {
                return true;
            }
            if (this.f40733a.isSplashOrderMute(this.f40734b)) {
                return true;
            }
            return false;
        } catch (Throwable th5) {
            GDTLogger.e("can't find isSplashOrderMute", th5);
        }
        return true;
    }

    @Deprecated
    public boolean isTopView() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.isTopView(this.f40734b);
            }
            return this.f40733a.isTopView();
        }
        return false;
    }

    public boolean isVideoAd() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.isVideoAd(this.f40734b);
            }
            return this.f40733a.isVideoAd();
        }
        return false;
    }

    public boolean needDoFloatViewAnimation() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.needDoFloatViewAnimation(this.f40734b);
            }
            return this.f40733a.needDoFloatViewAnimation();
        }
        return false;
    }

    public boolean needHideLogo() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                return this.f40733a.needHideLogo(this.f40734b);
            }
            return this.f40733a.needHideLogo();
        }
        return false;
    }

    public void reportCost(int i3, int i16, boolean z16, Map map) {
        if (this.f40733a != null) {
            this.f40733a.reportCost(i3, i16, z16, map, this.f40734b);
        }
    }

    public void reportJoinAdCost(int i3) {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                this.f40733a.reportJoinAdCost(i3, this.f40734b);
            } else {
                this.f40733a.reportJoinAdCost(i3);
            }
        }
    }

    public void reportLinkEvent(TGSplashAD.ReportParams reportParams) {
        if (this.f40733a != null) {
            this.f40733a.reportLinkEvent(reportParams);
        }
    }

    public void reportNegativeFeedback() {
        if (this.f40733a != null) {
            if (this.f40734b != null) {
                this.f40733a.reportNegativeFeedback(this.f40734b);
            } else {
                this.f40733a.reportNegativeFeedback();
            }
        }
    }

    public void reportNoUseSplashReason(int i3, boolean z16) {
        if (this.f40733a != null) {
            this.f40733a.reportNoUseSplashReason(i3, z16, this.f40734b);
        }
    }
}
