package com.tencent.superplayer.player;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qqlive.superplayer.vinfo.TVKPlayerVideoInfo;
import com.tencent.qqlive.superplayer.vinfo.TVKUserInfo;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

/* loaded from: classes26.dex */
class SuperPlayerMgrCommons {

    /* loaded from: classes26.dex */
    static class LoopbackParams {
        boolean isLoopback;
        long loopEndPositionMs;
        long loopStartPositionMs;
        int seekMode;
    }

    /* loaded from: classes26.dex */
    static class OpenMediaParams {
        Context context;
        String fileId;
        String localSaveUrl;
        SuperPlayerOption playerOption;
        long startPositionMilsec;
        String[] urls;
        SuperPlayerVideoInfo videoInfo;
    }

    /* loaded from: classes26.dex */
    static class SwitchDefnForUrlParams {
        int mode;
        String url;
    }

    /* loaded from: classes26.dex */
    static class SwitchDefnParams {
        String defn;
        int mode;
    }

    /* loaded from: classes26.dex */
    static class TVKOnTouchEventParams {
        MotionEvent event;
        View view;

        TVKOnTouchEventParams() {
        }
    }

    /* loaded from: classes26.dex */
    static class TVKSetNextLoopVideoInfoParams {
        String lastDefinition;
        TVKPlayerVideoInfo videoInfo;

        TVKSetNextLoopVideoInfoParams() {
        }
    }

    /* loaded from: classes26.dex */
    static class TVKSwitchAudioTrackParams {
        TVKUserInfo userInfo;
        TVKPlayerVideoInfo videoInfo;

        TVKSwitchAudioTrackParams() {
        }
    }

    /* loaded from: classes26.dex */
    static class TVKSwitchDefinitionParams {
        String definition;
        TVKUserInfo userInfo;
        TVKPlayerVideoInfo videoInfo;

        TVKSwitchDefinitionParams() {
        }
    }

    SuperPlayerMgrCommons() {
    }
}
