package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.RFWPlayerListenerDispatchUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWFastCostExp9095;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWLowDeviceAv1Exp;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWLowDeviceRenderExp;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWPlayerBusinessStrategyExp9095;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWPlayerPreRenderExp9095;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWVideoFluencyExp9095;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWVideoSystemExp9065;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController;
import com.tencent.biz.richframework.video.rfw.player.report.RFWPlayerReportHelper;
import com.tencent.biz.richframework.video.rfw.player.report.RFWVideoReporter;
import com.tencent.biz.richframework.video.rfw.player.strategy.RFWPlayerAV1DecodeStrategyV2;
import com.tencent.biz.richframework.video.rfw.player.strategy.RFWServerABTestStrategy;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.richframework.engineer.test.api.RFWTestReport;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerOption;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon$Entry;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class RFWPlayerBaseInterceptor {
    private RFWBaseInterceptorController mController;
    protected boolean mIsSystemPlayer;
    protected RFWPlayer mPlayer;
    protected RFWPlayerOptions mPlayerOptions;
    private final Map<String, List<FeedCloudCommon$Entry>> mReportMap = new ConcurrentHashMap();
    private String mTargetExpName;

    public RFWPlayerBaseInterceptor() {
    }

    private void addDeviceLevel(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(APMidasPayAPI.ENV_DEV, QCircleVideoDeviceInfoUtils.getVideoDeviceLevel());
        } catch (JSONException e16) {
            RFWLog.e(getTag(), RFWLog.USR, e16);
        }
    }

    private void appendExpName(List<FeedCloudCommon$Entry> list) {
        String str;
        if (!uq3.c.g() || list == null) {
            return;
        }
        try {
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
                if (feedCloudCommon$Entry.key.get().equals("attach_info")) {
                    String str2 = feedCloudCommon$Entry.value.get();
                    if (str2.contains("|")) {
                        str = str2 + "|" + getTargetExpName();
                    } else {
                        str = str2 + "," + getTargetExpName();
                    }
                    feedCloudCommon$Entry.value.set(str);
                    RFWLog.d(getTag(), RFWLog.DEV, "last attachInfo:" + str);
                    return;
                }
            }
            String targetExpName = getTargetExpName();
            list.add(QCircleReportHelper.newEntry("attach_info", targetExpName));
            RFWLog.d(getTag(), RFWLog.DEV, "last attachInfo:" + targetExpName);
        } catch (Exception e16) {
            RFWLog.d(getTag(), RFWLog.DEV, e16);
        }
    }

    private String getExpJsoString() {
        try {
            JSONObject jSONObject = new JSONObject();
            RFWServerABTestStrategy.g().addToQFSPlayerReport(jSONObject);
            RFWLowDeviceRenderExp.addExpToQFSPlayerReport(jSONObject);
            RFWLowDeviceAv1Exp.addExpToQFSPlayerReport(jSONObject);
            RFWVideoSystemExp9065.addExpToQFSPlayerReport(jSONObject);
            RFWFastCostExp9095.addExpToQFSPlayerReport(jSONObject);
            RFWVideoFluencyExp9095.addExpToQFSPlayerReport(jSONObject);
            RFWPlayerPreRenderExp9095.addExpToQFSPlayerReport(jSONObject);
            RFWPlayerBusinessStrategyExp9095.addExpToQFSPlayerReport(jSONObject);
            RFWPlayerAV1DecodeStrategyV2.g().addExpToQFSPlayerReport(jSONObject);
            addDeviceLevel(jSONObject);
            return jSONObject.toString();
        } catch (Exception e16) {
            RFWLog.d(getTag(), RFWLog.DEV, e16);
            return "";
        }
    }

    @NotNull
    private String getTargetExpName() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_video_report_use_once_exp_name", true)) {
            return "expName=" + getExpJsoString();
        }
        if (!TextUtils.isEmpty(this.mTargetExpName)) {
            return this.mTargetExpName;
        }
        String str = "expName=" + getExpJsoString();
        this.mTargetExpName = str;
        return str;
    }

    public Surface beforeCreateView() {
        return null;
    }

    public final void bindController(RFWBaseInterceptorController rFWBaseInterceptorController) {
        this.mController = rFWBaseInterceptorController;
    }

    public void bindPlayer(@NonNull RFWPlayer rFWPlayer) {
        this.mPlayer = rFWPlayer;
        this.mPlayerOptions = rFWPlayer.getRFWPlayerOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RFWTestReport(id = "VIDEO_COMPLETE")
    public void flushDcReport() {
        RFWVideoReporter.getInstance().flush();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getDtCustomPageId() {
        RFWPlayerOptions rFWPlayerOptions = this.mPlayerOptions;
        if (rFWPlayerOptions != null && rFWPlayerOptions.getIOC() != null && this.mPlayerOptions.getIOC().getUpperData() != null) {
            return this.mPlayerOptions.getIOC().getUpperData().getDtCustomPgId();
        }
        return "";
    }

    public RFWPlayerOptions getOptions() {
        return this.mPlayerOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getTag() {
        if (this.mPlayerOptions == null) {
            return "";
        }
        return getClass().getSimpleName() + "_" + this.mPlayerOptions.tag();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T getTargetInterceptor(Class<T> cls) {
        return (T) this.mController.getTargetIntercept(cls);
    }

    public boolean isSysTemPlayer() {
        return this.mIsSystemPlayer;
    }

    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        return false;
    }

    public void onInfo(int i3, long j3, long j16, Object obj) {
        boolean z16;
        if (124 == i3) {
            if (j3 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsSystemPlayer = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void report(String str, List<FeedCloudCommon$Entry> list) {
        appendExpName(list);
        RFWPlayerListenerDispatchUtils.notifyReportFront(this.mPlayerOptions, this.mPlayer.getVideoPlayId(), str, list);
        RFWPlayerReportHelper.report(this.mPlayer, this.mPlayerOptions, str, list);
        if (list != null) {
            this.mReportMap.put(str, list);
        }
    }

    public RFWPlayerBaseInterceptor(RFWBaseInterceptorController rFWBaseInterceptorController) {
        this.mController = rFWBaseInterceptorController;
    }

    public void afterCreateView() {
    }

    public void downloadComplete() {
    }

    public void onPause() {
    }

    public void onPlayerCurrentLoopStart() {
    }

    public void onPlayerDeInit() {
    }

    public void onPlayerInfoBufferingEnd() {
    }

    public void onPlayerInfoBufferingStart() {
    }

    public void onPlayerInfoCurrentLoopEnd() {
    }

    public void onPlayerInfoFirstVideoFrameRendered() {
    }

    public void onPlayerParamsReset() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void onVideoPrepare() {
    }

    public void playerStartPlayState() {
    }

    public void onCompletion(ISuperPlayer iSuperPlayer) {
    }

    public void onNetVideoInfo(TVKNetVideoInfo tVKNetVideoInfo) {
    }

    public void onPermissionTimeout(ISuperPlayer iSuperPlayer) {
    }

    public void onPlayerActive(SuperPlayerOption superPlayerOption) {
    }

    public void onPlayerCDNInfoUpdate(Object obj) {
    }

    public void onPlayerQUICUpdate(Object obj) {
    }

    public void onRelease(int i3) {
    }

    public void onSeekComplete(ISuperPlayer iSuperPlayer) {
    }

    public void afterOpenMedia(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
    }

    public void beforeOpenMedia(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
    }

    public void onPlayerInfoDownloadProgressUpdate(ISuperPlayer iSuperPlayer, Object obj) {
    }

    public void onStartTrackingTouch(int i3, int i16) {
    }

    public void onStopTrackingTouch(int i3, int i16) {
    }

    public void onUpdateProgress(int i3, int i16) {
    }
}
