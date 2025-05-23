package com.tencent.mobileqq.richmediabrowser.subtitle.api.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmediabrowser.h;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.presenter.f;
import com.tencent.mobileqq.richmediabrowser.subtitle.api.IDisplayVideoSubtitle;
import com.tencent.mobileqq.richmediabrowser.subtitle.api.impl.DisplayVideoSubtitleImpl;
import com.tencent.mobileqq.richmediabrowser.utils.RichMediaBrowserUtils;
import com.tencent.mobileqq.stt.sub.api.IVideoSubtitleManager;
import com.tencent.mobileqq.stt.sub.api.a;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.common.TPSubtitleText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import vm2.SubtitleDisplayData;
import vm2.c;
import vm2.k;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/richmediabrowser/subtitle/api/impl/DisplayVideoSubtitleImpl;", "Lcom/tencent/mobileqq/richmediabrowser/subtitle/api/IDisplayVideoSubtitle;", "Lvm2/a;", "data", "", "startSubtitleLoading", "controlSubtitleTimeout", "requestGetVideoSubtitle", "", "errorCode", "", "subtitlePath", "responseGetVideoSubtitle", "displayVideoSubtitle", "", "lastTime", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "timeout", "", "inSubtitleTimeoutSeries", "subtitleIdentifyOverFrequency", "start", "<init>", "()V", "qq-richmediabrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class DisplayVideoSubtitleImpl implements IDisplayVideoSubtitle {
    private final void controlSubtitleTimeout(SubtitleDisplayData data) {
        ThreadManager.getUIHandler().postDelayed(data.getShowSubtitleTimeoutRunnable(), data.getTimeout());
    }

    private final void displayVideoSubtitle(final String subtitlePath, final SubtitleDisplayData data) {
        data.getVideoView().mVideoView.postDelayed(new Runnable() { // from class: wm2.b
            @Override // java.lang.Runnable
            public final void run() {
                DisplayVideoSubtitleImpl.displayVideoSubtitle$lambda$3(SubtitleDisplayData.this, subtitlePath);
            }
        }, 400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayVideoSubtitle$lambda$3(final SubtitleDisplayData data, String str) {
        Intrinsics.checkNotNullParameter(data, "$data");
        data.getVideoView().mVideoView.setOnSubtitleDataListener(new ISuperPlayer.OnSubtitleDataListener() { // from class: wm2.a
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnSubtitleDataListener
            public final void onSubtitleData(ISuperPlayer iSuperPlayer, TPSubtitleData tPSubtitleData) {
                DisplayVideoSubtitleImpl.displayVideoSubtitle$lambda$3$lambda$2(SubtitleDisplayData.this, iSuperPlayer, tPSubtitleData);
            }
        });
        QLog.i(IDisplayVideoSubtitle.TAG, 1, "aioVideoViewSubtitle, set and display video subtitle. ");
        c.f441865a.e();
        data.getVideoPresenter().h(true);
        data.getVideoView().mVideoView.addSubtitleSource(str, "", "str");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayVideoSubtitle$lambda$3$lambda$2(SubtitleDisplayData data, ISuperPlayer iSuperPlayer, TPSubtitleData tPSubtitleData) {
        Intrinsics.checkNotNullParameter(data, "$data");
        f videoPresenter = data.getVideoPresenter();
        Intrinsics.checkNotNull(tPSubtitleData, "null cannot be cast to non-null type com.tencent.thumbplayer.api.common.TPSubtitleText");
        String text = ((TPSubtitleText) tPSubtitleData).getText();
        Intrinsics.checkNotNullExpressionValue(text, "tpSubtitleData as TPSubtitleText).text");
        videoPresenter.c(text);
    }

    private final boolean inSubtitleTimeoutSeries(long lastTime, long currentTime, int timeout) {
        return currentTime - lastTime < ((long) timeout) && currentTime > lastTime;
    }

    private final void requestGetVideoSubtitle(final SubtitleDisplayData data) {
        IVideoSubtitleManager iVideoSubtitleManager;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iVideoSubtitleManager = (IVideoSubtitleManager) peekAppRuntime.getRuntimeService(IVideoSubtitleManager.class, "peak")) != null) {
            iVideoSubtitleManager.getVideoSubtitle(h.a().i(), data.getVideoData().istroop, data.getVideoData().E, data.getPlayUrl(), "", data.getTimeout(), new a() { // from class: wm2.c
                @Override // com.tencent.mobileqq.stt.sub.api.a
                public final void a(int i3, String str) {
                    DisplayVideoSubtitleImpl.requestGetVideoSubtitle$lambda$1(DisplayVideoSubtitleImpl.this, data, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestGetVideoSubtitle$lambda$1(DisplayVideoSubtitleImpl this$0, SubtitleDisplayData data, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        QLog.i(IDisplayVideoSubtitle.TAG, 1, "aioVideoViewSubtitle, onGetVideoSubtitleerrorCode: " + i3 + ", subtitlePath: " + str);
        this$0.responseGetVideoSubtitle(i3, str, data);
    }

    private final void responseGetVideoSubtitle(int errorCode, String subtitlePath, SubtitleDisplayData data) {
        AIOVideoData e16 = RichMediaBrowserUtils.e(data.getVideoPresenter());
        Intrinsics.checkNotNullExpressionValue(e16, "getCurAIOVideoData(data.videoPresenter)");
        if (inSubtitleTimeoutSeries(e16.R, data.getTimeout()) && data.getVideoData().E == e16.E) {
            k.f441884a.j(data.getVideoView(), data.getVideoPresenter(), data.getShowSubtitleTimeoutRunnable());
            if (errorCode == 0 && subtitlePath != null) {
                displayVideoSubtitle(subtitlePath, data);
            } else {
                xm2.c.f448170a.a(data.getContext(), errorCode);
            }
        }
    }

    private final void startSubtitleLoading(final SubtitleDisplayData data) {
        data.getVideoView().mVideoView.postDelayed(new Runnable() { // from class: wm2.d
            @Override // java.lang.Runnable
            public final void run() {
                DisplayVideoSubtitleImpl.startSubtitleLoading$lambda$0(SubtitleDisplayData.this);
            }
        }, 350L);
        QLog.i(IDisplayVideoSubtitle.TAG, 1, "aioVideoViewSubtitle, displaySubtitleLoading, subtitleStartLoading. ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startSubtitleLoading$lambda$0(SubtitleDisplayData data) {
        Intrinsics.checkNotNullParameter(data, "$data");
        data.getVideoPresenter().f();
    }

    private final boolean subtitleIdentifyOverFrequency(SubtitleDisplayData data) {
        long currentTimeMillis = System.currentTimeMillis();
        if (inSubtitleTimeoutSeries(data.getVideoData().R, currentTimeMillis, data.getTimeout())) {
            QLog.i("VideoSubtitleUtils", 1, "aioVideoViewSubtitle, subtitleIdentifyOverFrequency, please try again later!");
            return true;
        }
        data.getVideoData().R = currentTimeMillis;
        return false;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.subtitle.api.IDisplayVideoSubtitle
    public void start(@NotNull SubtitleDisplayData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!k.f441884a.i(data.getVideoData().f281846h)) {
            data.getVideoPresenter().h(false);
            QLog.i(IDisplayVideoSubtitle.TAG, 1, "aioVideoViewSubtitle, startIdentifyVideoSubtitle, showVideoSubtitle is false. ");
            return;
        }
        if (subtitleIdentifyOverFrequency(data)) {
            return;
        }
        data.getVideoPresenter().i();
        startSubtitleLoading(data);
        controlSubtitleTimeout(data);
        if (RichMediaBrowserUtils.h(data.getVideoData())) {
            QLog.i(IDisplayVideoSubtitle.TAG, 1, "aioVideoViewSubtitle, file exist, file path: " + data.getPlayUrl());
            requestGetVideoSubtitle(data);
        }
    }

    private final boolean inSubtitleTimeoutSeries(long lastTime, int timeout) {
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis - lastTime < ((long) timeout) && currentTimeMillis > lastTime;
    }
}
