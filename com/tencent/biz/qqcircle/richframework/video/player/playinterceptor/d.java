package com.tencent.biz.qqcircle.richframework.video.player.playinterceptor;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.video.rfw.RFWPCDNRecorderManager;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerP2PParams;
import com.tencent.biz.richframework.video.rfw.player.events.RFWPlayerActiveEvent;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWFastCostExp9095;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWPlayerPreRenderExp9095;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWVideoFluencyExp9095;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.biz.richframework.video.rfw.player.strategy.RFWVideoConfigHelper;
import com.tencent.biz.richframework.video.rfw.player.strategy.RFWWeakNetworkPCDNStrategy;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.util.Pair;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d extends RFWPlayerBaseInterceptor implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private RFWPlayerP2PParams f92019d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f92020e;

    /* renamed from: f, reason: collision with root package name */
    private ISuperPlayer f92021f;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f92022h;

    /* renamed from: i, reason: collision with root package name */
    private SuperPlayerOption f92023i;

    private void a() {
        if (RFWVideoFluencyExp9095.hitExpC() && com.tencent.mobileqq.qcircle.api.utils.c.i() && !this.f92022h) {
            this.f92022h = true;
            if (this.mPlayer.getPlayableDurationMs() > RFWVideoFluencyExp9095.getActiveTimeMs()) {
                SimpleEventBus.getInstance().dispatchEvent(new RFWPlayerActiveEvent(this.mPlayerOptions.getFileId()));
            }
        }
    }

    private Pair<Integer, Integer> c(RFWPlayerOptions rFWPlayerOptions) {
        int emergencyTimeForPrePlay = this.f92019d.getEmergencyTimeForPrePlay();
        int safePlayTimeForPrePlay = this.f92019d.getSafePlayTimeForPrePlay();
        if (rFWPlayerOptions.getFromType() == 10002 && this.mPlayerOptions.getIOC() != null) {
            FeedCloudMeta$StFeed b16 = b();
            if (b16 != null) {
                emergencyTimeForPrePlay = RFWVideoConfigHelper.getPreloadFeedPreloadVideoTime(b16) / 1000;
                RFWLog.d(getTag(), RFWLog.USR, "FeedLine_ load preTime from preload feed config");
                safePlayTimeForPrePlay = emergencyTimeForPrePlay;
            }
        } else {
            emergencyTimeForPrePlay = RFWPlayerPreRenderExp9095.getPreRenderTimeS(emergencyTimeForPrePlay);
            safePlayTimeForPrePlay = RFWPlayerPreRenderExp9095.getPreRenderTimeS(safePlayTimeForPrePlay);
        }
        return new Pair<>(Integer.valueOf(emergencyTimeForPrePlay), Integer.valueOf(safePlayTimeForPrePlay));
    }

    private int d() {
        RFWPlayerP2PParams rFWPlayerP2PParams = this.f92019d;
        if (rFWPlayerP2PParams == null) {
            return 3000;
        }
        return rFWPlayerP2PParams.getInitiativeResetTime();
    }

    private int e() {
        RFWPlayerP2PParams rFWPlayerP2PParams = this.f92019d;
        if (rFWPlayerP2PParams == null) {
            return 3000;
        }
        return rFWPlayerP2PParams.getPassivityResetTime();
    }

    private void f(boolean z16) {
        SuperPlayerDownOption superPlayerDownOption;
        if (this.f92020e && z16 && this.f92021f != null) {
            SuperPlayerOption superPlayerOption = this.f92023i;
            if (superPlayerOption == null) {
                superPlayerDownOption = null;
            } else {
                superPlayerDownOption = superPlayerOption.superPlayerDownOption;
            }
            RFWWeakNetworkPCDNStrategy.WeakNetworkPCDNStrategyResult processWeakNetworkPCDNParam = new RFWWeakNetworkPCDNStrategy().processWeakNetworkPCDNParam(this.f92019d, this.mPlayerOptions, superPlayerDownOption, false);
            int emergencyTime = processWeakNetworkPCDNParam.getEmergencyTime();
            int safePlayTime = processWeakNetworkPCDNParam.getSafePlayTime();
            Pair<Integer, Integer> c16 = c(this.mPlayerOptions);
            this.f92021f.setBusinessDownloadStrategy(emergencyTime, safePlayTime, c16.first.intValue(), c16.second.intValue());
            RFWLog.d(getTag(), RFWLog.USR, "[onUpdateProgress] reset strategy, emergencyTime: " + emergencyTime + " | safePlayTime: " + safePlayTime + " | emergencyTimeForPrePlay: " + c16.first + " | safePlayTimeForPrePlay: " + c16.second + " | wnsParams:" + this.f92019d);
            this.f92021f = null;
        }
    }

    private void g(SuperPlayerOption superPlayerOption) {
        if (superPlayerOption == null) {
            return;
        }
        if (!this.mPlayerOptions.isPreloadPlayer()) {
            RFWLog.d(getTag(), RFWLog.USR, "beforeOpenMedia is preloadPlayer:false");
            return;
        }
        if (!this.mPlayerOptions.forceActive()) {
            superPlayerOption.isPrePlay = true;
        }
        RFWLog.d(getTag(), RFWLog.USR, "beforeOpenMedia is forceActive:" + this.mPlayerOptions.forceActive());
        if (this.mPlayerOptions.getFromType() == 10002 && uq3.c.q5()) {
            superPlayerOption.quickStopPlayerInBackground = true;
        }
        RFWLog.d(getTag(), RFWLog.USR, "beforeOpenMedia is preloadPlayer:true");
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void afterOpenMedia(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
        super.afterOpenMedia(superPlayerOption, iSuperPlayer);
    }

    public FeedCloudMeta$StFeed b() {
        RFWPlayerReportInfo businessReportInfo;
        RFWPlayerOptions rFWPlayerOptions = this.mPlayerOptions;
        if (rFWPlayerOptions == null || (businessReportInfo = rFWPlayerOptions.getIOC().getBusinessReportInfo()) == null) {
            return null;
        }
        return ((e30.b) businessReportInfo.getOriginBusinessData()).g();
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void beforeOpenMedia(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
        boolean z16;
        boolean z17;
        super.beforeOpenMedia(superPlayerOption, iSuperPlayer);
        RFWPlayer rFWPlayer = this.mPlayer;
        if (rFWPlayer != null && rFWPlayer.getRFWPlayerOptions() != null && superPlayerOption != null && iSuperPlayer != null && this.mPlayer.getCurrentSuperVideoInfo() != null) {
            SimpleEventBus.getInstance().registerReceiver(this);
            this.f92021f = iSuperPlayer;
            g(superPlayerOption);
            RFWPlayerP2PParams rFWPlayerP2PParams = new RFWPlayerP2PParams();
            this.f92019d = rFWPlayerP2PParams;
            superPlayerOption.superPlayerDownOption.enableP2P = rFWPlayerP2PParams.isEnableP2P();
            SuperPlayerDownOption superPlayerDownOption = superPlayerOption.superPlayerDownOption;
            boolean z18 = true;
            if (this.f92019d.isEnablePCDN(this.mPlayerOptions.getHost()) && RFWPCDNRecorderManager.g().enablePCDN(this.mPlayer.getCurrentSuperVideoInfo().getFileId())) {
                z16 = true;
            } else {
                z16 = false;
            }
            superPlayerDownOption.enablePcdn = z16;
            RFWPlayerOptions rFWPlayerOptions = this.mPlayer.getRFWPlayerOptions();
            Pair<Integer, Integer> c16 = c(rFWPlayerOptions);
            String fastPlayExpName = this.f92019d.getFastPlayExpName();
            if (!TextUtils.isEmpty(fastPlayExpName) && rFWPlayerOptions.getStartOffset() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f92020e = z17;
            if (z17) {
                QQVideoPlaySDKManager.addSuperGlobalReportData("param_bucket5", fastPlayExpName);
            }
            RFWWeakNetworkPCDNStrategy.WeakNetworkPCDNStrategyResult processWeakNetworkPCDNParam = new RFWWeakNetworkPCDNStrategy().processWeakNetworkPCDNParam(this.f92019d, this.mPlayerOptions, superPlayerOption.superPlayerDownOption, this.f92020e);
            int emergencyTime = processWeakNetworkPCDNParam.getEmergencyTime();
            int safePlayTime = processWeakNetworkPCDNParam.getSafePlayTime();
            if (RFWFastCostExp9095.hitExpBCDE() && this.f92020e) {
                SuperPlayerDownOption superPlayerDownOption2 = superPlayerOption.superPlayerDownOption;
                superPlayerDownOption2.enableDownStrategyOnlyEffectSelf = true;
                superPlayerDownOption2.emergencyTimeS = emergencyTime;
                superPlayerDownOption2.safeTimeS = safePlayTime;
                superPlayerDownOption2.emergencyTimSForPrePlayer = c16.first.intValue();
                superPlayerOption.superPlayerDownOption.safeTimeSForPrePlayer = c16.second.intValue();
            }
            iSuperPlayer.setBusinessDownloadStrategy(emergencyTime, safePlayTime, c16.first.intValue(), c16.second.intValue());
            String tag = getTag();
            int i3 = RFWLog.USR;
            Object[] objArr = new Object[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[beforeOpenMedia] emergencyTime: ");
            sb5.append(emergencyTime);
            sb5.append(" | safePlayTime: ");
            sb5.append(safePlayTime);
            sb5.append(" | emergencyTimeForPrePlay: ");
            sb5.append(c16.first);
            sb5.append(" | safePlayTimeForPrePlay: ");
            sb5.append(c16.second);
            sb5.append(" | hit fastPlayBCDE:");
            if (!RFWFastCostExp9095.hitExpBCDE() || !this.f92020e) {
                z18 = false;
            }
            sb5.append(z18);
            sb5.append(" | wnsParams:");
            sb5.append(this.f92019d);
            objArr[0] = sb5.toString();
            RFWLog.d(tag, i3, objArr);
            this.f92023i = superPlayerOption;
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(RFWPlayerActiveEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof RFWPlayerActiveEvent) && !TextUtils.equals(((RFWPlayerActiveEvent) simpleBaseEvent).mFileId, this.mPlayerOptions.getFileId())) {
            this.mPlayer.getRealPlayer().setPlayerActive();
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onRelease(int i3) {
        super.onRelease(i3);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onStopTrackingTouch(int i3, int i16) {
        boolean z16;
        super.onStopTrackingTouch(i3, i16);
        if (i3 >= d()) {
            z16 = true;
        } else {
            z16 = false;
        }
        f(z16);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onUpdateProgress(int i3, int i16) {
        boolean z16;
        super.onUpdateProgress(i3, i16);
        if (i16 >= e()) {
            z16 = true;
        } else {
            z16 = false;
        }
        f(z16);
        a();
    }
}
