package com.tencent.gamematrix.gmcg.api;

import android.content.Intent;
import android.util.Pair;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameShareInfo;
import java.util.List;

/* loaded from: classes6.dex */
public interface GmCgPlayDcEventListener {
    void onGmCgDcEventDownloadGame(String str, String str2);

    @MainThread
    void onGmCgDcEventOpenAssistScreen(String str, String str2, String str3);

    @MainThread
    void onGmCgDcEventOpenOuterScreen(String str, String str2);

    @MainThread
    void onGmCgDcEventPlayerConnect(int i3, int i16);

    @MainThread
    void onGmCgDcEventPowerSaveModeStatusChange(boolean z16);

    @MainThread
    void onGmCgDcEventShopInject(String str);

    @MainThread
    void onGmCgPlayDcConnectionLost();

    @MainThread
    void onGmCgPlayDcConnectionReady();

    void onGmCgPlayDcEventAck(GmCgDcEventRequestAck gmCgDcEventRequestAck);

    @MainThread
    void onGmCgPlayDcEventAllAndroidEvent(String str);

    @MainThread
    void onGmCgPlayDcEventAppLaunch();

    @MainThread
    void onGmCgPlayDcEventAppStatus(String str);

    @MainThread
    void onGmCgPlayDcEventCommonNotify(String str, String str2);

    @MainThread
    void onGmCgPlayDcEventLoginRequest(int i3);

    @MainThread
    void onGmCgPlayDcEventLoginResult(String str, int i3, boolean z16);

    @MainThread
    void onGmCgPlayDcEventQQIntentForward(Intent intent);

    @MainThread
    void onGmCgPlayDcEventSceneCheck(boolean z16, int i3, long j3);

    @MainThread
    void onGmCgPlayDcEventScreenRotate(int i3);

    @MainThread
    void onGmCgPlayDcEventShareInfoEvent(@GmCgEventShareInfoType int i3, GmCgGameShareInfo gmCgGameShareInfo);

    @MainThread
    void onGmCgPlayDcEventTGPAAction(String str, String str2);

    @MainThread
    void onGmCgPlayDcEventTGPAScene(String str, String str2);

    @MainThread
    void onGmCgPlayDcEventUnknown(String str);

    @MainThread
    void onGmCgPlayDcEventUnknownAndroidEvent(String str);

    @MainThread
    void onGmCgPlayDcEventWXFaceIdentify(String str);

    @MainThread
    void onGmCgPlayEventGameChapter(@Nullable Integer num);

    @MainThread
    void onGmCgPlayEventKingsHonorMidGameAbnormal(@Nullable @GmCgKingsHonorMidGameErrorCode Integer num);

    void onGmCgPlayEventKingsHonorMidGameBeginNormal();

    @MainThread
    void onGmCgPlayEventKingsHonorMidGameEnd(boolean z16, @Nullable @GmCgKingsHonorMidGameMissionCode Integer num, @Nullable String str, List<Pair<String, Boolean>> list, @Nullable String str2, @Nullable Integer num2);

    @MainThread
    void onGmCgSendTouchEvent(int i3);

    void onGmcgSDKScene(int i3, boolean z16);
}
