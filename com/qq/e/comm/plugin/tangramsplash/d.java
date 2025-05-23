package com.qq.e.comm.plugin.tangramsplash;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.ITangramDecoderPlayer;
import com.qq.e.comm.pi.ITangramPlayer;
import com.qq.e.comm.pi.TGSPVI;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.splash.SplashOrder;
import com.qq.e.tg.splash.TGSplashAD;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d implements TGSPVI {

    /* renamed from: a, reason: collision with root package name */
    f f39865a;

    /* renamed from: b, reason: collision with root package name */
    com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c.d f39866b;

    public d(Context context, String str, String str2) {
        com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c.d a16 = com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c.d.a();
        this.f39866b = a16;
        a16.b();
        f fVar = new f(context, str, str2);
        this.f39865a = fVar;
        fVar.a(TGSPVI.ext);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void doRecycleBeforeSplashDismiss() {
        this.f39865a.v();
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void fetchAdOnly() {
        this.f39865a.c(0);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void fetchAndShowIn(ViewGroup viewGroup) {
        this.f39865a.a(viewGroup, 0);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public String getAdNetWorkName() {
        return this.f39865a.d();
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public SplashOrder getSelectResultImmediately(String str) {
        return this.f39865a.a(str);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void needUseCustomDynamicFloatView(boolean z16) {
        this.f39865a.a(z16);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void needUseCustomFloatViewPosition(boolean z16) {
        this.f39865a.b(z16);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void needUseSplashButtonGuideView(boolean z16) {
        this.f39865a.c(z16);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void preload() {
        this.f39865a.b();
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void reportCost(int i3, int i16, Map map) {
        this.f39865a.a(i3, i16, map);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void reportEmptyOrderIfNecessaryAndPreFetchAd(TGSplashAD.FetchAdParams fetchAdParams) {
        if (fetchAdParams == null) {
            return;
        }
        String str = fetchAdParams.emptyOrderApUrl;
        if (!TextUtils.isEmpty(str)) {
            this.f39865a.b(str);
        }
        if (fetchAdParams.needIncreasePlayRound) {
            this.f39865a.u();
        }
        if (fetchAdParams.needCallPreSelect && !this.f39865a.c()) {
            this.f39865a.c(2);
        }
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void reportLinkEvent(TGSplashAD.ReportParams reportParams) {
        this.f39865a.a(reportParams);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void reportNoUseSplashReason(int i3) {
        this.f39865a.b(i3);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void selectOrderByLocalRealtimeParallelism() {
        this.f39865a.c(5);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void setAdListener(ADListener aDListener) {
        this.f39865a.a(aDListener);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void setAdLogoView(View view) {
        this.f39865a.f(view);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void setBrokenWindowCloseView(View view) {
        this.f39865a.g(view);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void setCustomDecoderPlayer(ITangramDecoderPlayer iTangramDecoderPlayer) {
        this.f39865a.a(iTangramDecoderPlayer);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void setFetchDelay(int i3) {
        this.f39865a.d(i3);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void setFloatView(View view) {
        this.f39865a.d(view);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void setLimitAdView(View view) {
        this.f39865a.c(view);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f39865a.a(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void setOneShotFocusViewRect(Rect rect) {
        this.f39865a.a(rect);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void setPreloadView(View view) {
        this.f39865a.e(view);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void setPureSkipView(View view) {
        this.f39865a.b(view);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void setSkipView(View view) {
        this.f39865a.a(view);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void setSplashButtonGuideViewHeight(int i3) {
        this.f39865a.a(i3);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void setVideoView(ITangramPlayer iTangramPlayer, boolean z16) {
        if (iTangramPlayer != null) {
            com.qq.e.comm.plugin.tangramsplash.video.b bVar = new com.qq.e.comm.plugin.tangramsplash.video.b(iTangramPlayer, (WeakReference<f>) new WeakReference(this.f39865a));
            bVar.a(z16);
            this.f39865a.a(bVar);
            return;
        }
        this.f39865a.a((com.qq.e.comm.plugin.tangramsplash.video.b) null);
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void showAd(TGSplashAD.SplashDisplayParams splashDisplayParams) {
        if (splashDisplayParams != null) {
            if (splashDisplayParams.splashAd == null && splashDisplayParams.container != null) {
                GDTLogger.i("show ad from realtime select");
                this.f39865a.a(splashDisplayParams.container, splashDisplayParams.firstFrameTimeout);
            } else {
                GDTLogger.i("show ad from pre local select");
                this.f39865a.a(splashDisplayParams);
            }
        }
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void setEasterEggVolumeIcon(View view, View view2) {
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void setVolumeIcon(View view, View view2) {
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void setVolumeIconEasterEggMargin(int i3, int i16) {
    }

    @Override // com.qq.e.comm.pi.TGSPVI
    public void setVolumeIconMargin(int i3, int i16) {
    }
}
