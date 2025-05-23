package hu2;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.event.QFSTVideoPageWebViewShowEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.playerinterface.QAdVideoItem;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010/\u001a\u00020+\u00a2\u0006\u0004\b0\u00101J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0016J*\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J*\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J0\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u001c\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016J \u0010\u001e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u001f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010&\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010*\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010(H\u0016R\u0017\u0010/\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010,\u001a\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lhu2/a;", "Lkt3/d;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, "", "allDuration", "", "Lcom/tencent/qqlive/playerinterface/QAdVideoItem;", "qAdVideoItemList", "", "e", "a", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_TIME, tl.h.F, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errCode", "Lkt3/h;", "adErrorInfo", "l", "c", "", "skipDirect", "isCopyRightForWarner", "skipType", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "onWarnerTipClick", "duration", "i", "countDown", "onAdCountDownStart", "onAdCountDown", "f", "b", "", "type", "", "param", "g", "needShowAd", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/MediaAd/data/g;", "rewardItemWrapper", "j", "Lhu2/b;", "Lhu2/b;", "getMidAdController", "()Lhu2/b;", "midAdController", "<init>", "(Lhu2/b;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a implements kt3.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b midAdController;

    public a(@NotNull b midAdController) {
        Intrinsics.checkNotNullParameter(midAdController, "midAdController");
        this.midAdController = midAdController;
    }

    @Override // kt3.d
    public void a(int adType, long allDuration) {
        QLog.i("AdManagerListener", 1, "onAdPrepared  adType:" + adType + ", duration:" + allDuration);
        if (adType == 3) {
            this.midAdController.s();
        }
    }

    @Override // kt3.d
    public void b(int adType) {
        QLog.i("AdManagerListener", 1, "onFinishAd  adType:" + adType);
    }

    @Override // kt3.d
    public void c(int adType, int errorType, int errCode, @Nullable kt3.h adErrorInfo) {
        QLog.i("AdManagerListener", 1, "onAdError  adType:" + adType + ", errorType:" + errorType + ", errorCode=" + errCode);
        if (adType == 3) {
            this.midAdController.y();
        }
    }

    @Override // kt3.d
    public void e(int adType, long allDuration, @Nullable List<QAdVideoItem> qAdVideoItemList) {
        Integer num;
        if (qAdVideoItemList != null) {
            num = Integer.valueOf(qAdVideoItemList.size());
        } else {
            num = null;
        }
        QLog.i("AdManagerListener", 1, "onAdReceive duration:" + allDuration + ", adList:" + num);
    }

    @Override // kt3.d
    public void f(int adType) {
        QLog.i("AdManagerListener", 1, "onAdCountDownCompletion  adType:" + adType);
    }

    @Override // kt3.d
    @NotNull
    public Object g(int adType, @Nullable String type, @Nullable Object param) {
        return 0;
    }

    @Override // kt3.d
    public void h(int adType, long playTime) {
        QLog.i("AdManagerListener", 1, "onAdCompletion  adType:" + adType + ", playTime:" + playTime);
        if (adType == 3) {
            this.midAdController.y();
        }
    }

    @Override // kt3.d
    public void j(boolean needShowAd, @Nullable com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.g rewardItemWrapper) {
        QLog.i("AdManagerListener", 1, "onRewardAdPanelShow  needShowAd:" + needShowAd + " ; rewardItemWrapper:" + rewardItemWrapper);
        this.midAdController.n(needShowAd, rewardItemWrapper);
    }

    @Override // kt3.d
    public void l(int adType, int errorType, int errCode, @Nullable kt3.h adErrorInfo) {
        QLog.i("AdManagerListener", 1, "onAdError  adType:" + adType + ", errorType:" + errorType + ", errorCode=" + errCode);
        if (adType == 3) {
            this.midAdController.y();
        }
    }

    @Override // kt3.d
    public void onAdCountDown(int adType, long countDown, long allDuration) {
        QLog.i("AdManagerListener", 1, "onAdCountDown  adType:" + adType);
    }

    @Override // kt3.d
    public void onAdCountDownStart(int adType, long countDown, long allDuration) {
        QLog.i("AdManagerListener", 1, "onAdCountDownStart  adType:" + adType);
        if (adType == 3 || adType == 23) {
            this.midAdController.j(adType);
        }
    }

    @Override // kt3.d
    public void onWarnerTipClick(int adType) {
        QLog.d("AdManagerListener", 1, "onWarnerTipClick  adType:" + adType);
        HashMap hashMap = new HashMap();
        hashMap.put("url", qx2.a.c().f430271c);
        hashMap.put("style", 1);
        QFSTVideoPageWebViewShowEvent qFSTVideoPageWebViewShowEvent = new QFSTVideoPageWebViewShowEvent();
        qFSTVideoPageWebViewShowEvent.setFromAuthPay(true);
        qFSTVideoPageWebViewShowEvent.setNeedInterceptVideo(true);
        qFSTVideoPageWebViewShowEvent.setParamsMap(hashMap);
        SimpleEventBus.getInstance().dispatchEvent(qFSTVideoPageWebViewShowEvent);
        this.midAdController.r(adType);
    }

    @Override // kt3.d
    public void m(int adType, long playTime) {
    }

    @Override // kt3.d
    public void i(int adType, long duration, long playTime) {
    }

    @Override // kt3.d
    public void d(int adType, long playTime, boolean skipDirect, boolean isCopyRightForWarner, int skipType) {
    }
}
