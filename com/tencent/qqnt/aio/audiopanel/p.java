package com.tencent.qqnt.aio.audiopanel;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelUtils;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.voicechange.IVoiceChangeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsGROUPMASK;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes34.dex */
public class p implements com.tencent.mobileqq.voicechange.a {

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<ListenChangeVoicePanel> f349709d;

    public p(ListenChangeVoicePanel listenChangeVoicePanel) {
        this.f349709d = new WeakReference<>(listenChangeVoicePanel);
    }

    @Override // com.tencent.mobileqq.voicechange.a
    public void onError() {
        ListenChangeVoicePanel listenChangeVoicePanel = this.f349709d.get();
        if (listenChangeVoicePanel == null) {
            QLog.d("PanelVoiceChangeListen", 1, "onError panel is null");
            return;
        }
        Handler handler = listenChangeVoicePanel.P;
        handler.sendMessage(Message.obtain(handler, 105, null));
        ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).requestToPause(listenChangeVoicePanel.Q);
        if (listenChangeVoicePanel.L.decrementAndGet() == 0) {
            QQAudioUtils.i(BaseApplication.getContext(), false);
        }
    }

    @Override // com.tencent.mobileqq.voicechange.a
    public void onPlayEnd() {
        ListenChangeVoicePanel listenChangeVoicePanel = this.f349709d.get();
        if (listenChangeVoicePanel == null) {
            QLog.d("PanelVoiceChangeListen", 1, "onPlayEnd panel is null");
        } else {
            Handler handler = listenChangeVoicePanel.P;
            handler.sendMessage(Message.obtain(handler, 104, null));
        }
    }

    @Override // com.tencent.mobileqq.voicechange.a
    public void onPlayStop() {
        ListenChangeVoicePanel listenChangeVoicePanel = this.f349709d.get();
        if (listenChangeVoicePanel == null) {
            QLog.d("PanelVoiceChangeListen", 1, "onPlayStop panel is null");
            return;
        }
        Handler handler = listenChangeVoicePanel.P;
        handler.sendMessage(Message.obtain(handler, 102, null));
        if (listenChangeVoicePanel.L.decrementAndGet() == 0) {
            QQAudioUtils.i(BaseApplication.getContext(), false);
        }
    }

    @Override // com.tencent.mobileqq.voicechange.a
    public void onSlicePlayed(int i3, int i16, int i17) {
        ListenChangeVoicePanel listenChangeVoicePanel = this.f349709d.get();
        if (listenChangeVoicePanel == null) {
            QLog.d("PanelVoiceChangeListen", 1, "onSlicePlayed panel is null");
            return;
        }
        int volumeLevel = ((IAudioPanelUtils) QRoute.api(IAudioPanelUtils.class)).getVolumeLevel(i3) / UfsGROUPMASK.GROUP_MASK_PRECISE_RICH;
        Bundle bundle = new Bundle();
        bundle.putInt("progress", i16);
        bundle.putInt(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_TIME, i17);
        bundle.putInt("level", volumeLevel);
        Handler handler = listenChangeVoicePanel.P;
        handler.sendMessage(Message.obtain(handler, 103, bundle));
    }
}
