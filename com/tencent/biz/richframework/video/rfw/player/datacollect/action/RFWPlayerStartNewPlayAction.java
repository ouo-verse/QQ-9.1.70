package com.tencent.biz.richframework.video.rfw.player.datacollect.action;

import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerCollectParams;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideoUrl;
import java.util.HashMap;
import qe0.a;

/* loaded from: classes5.dex */
public class RFWPlayerStartNewPlayAction implements RFWPlayerCollectBaseAction {
    private static void addAttachInfo(RFWPlayerCollectParams rFWPlayerCollectParams, Object[] objArr) {
        HashMap hashMap = (HashMap) objArr[1];
        if (hashMap.containsKey("ATTACH_INFO_KEY_POI")) {
            rFWPlayerCollectParams.setPlayPoi(((Integer) hashMap.get("ATTACH_INFO_KEY_POI")).intValue());
        }
        if (hashMap.containsKey("ATTACH_INFO_KEY_SCROLL_NEXT")) {
            rFWPlayerCollectParams.setIsScrollNext(((Boolean) hashMap.get("ATTACH_INFO_KEY_SCROLL_NEXT")).booleanValue());
        }
        if (hashMap.containsKey("ATTACH_INFO_KEY_IS_FLOATING")) {
            rFWPlayerCollectParams.setIsFloating(((Boolean) hashMap.get("ATTACH_INFO_KEY_IS_FLOATING")).booleanValue());
        }
        if (hashMap.containsKey("ATTACH_INFO_KEY_SELECTED_TYPE")) {
            rFWPlayerCollectParams.setPlayByOnResume(Lifecycle.Event.ON_RESUME.name().equals(hashMap.get("ATTACH_INFO_KEY_SELECTED_TYPE")));
        }
    }

    public static float getVideoRate(int i3) {
        if (i3 == 0) {
            return 0.0f;
        }
        return i3 / 1024.0f;
    }

    public /* synthetic */ String a(String str) {
        return a.b(this, str);
    }

    public /* synthetic */ void b(String str, String str2, String str3) {
        a.d(this, str, str2, str3);
    }

    public void onAction(String str, RFWPlayerCollectParams rFWPlayerCollectParams, Object... objArr) {
        if (!TextUtils.isEmpty(str) && objArr.length >= 2 && (objArr[0] instanceof RFWStVideo) && (objArr[1] instanceof HashMap)) {
            addAttachInfo(rFWPlayerCollectParams, objArr);
            RFWStVideo rFWStVideo = (RFWStVideo) objArr[0];
            float computeCacheTimeS = RFWVideoUtils.computeCacheTimeS(rFWPlayerCollectParams.getSceneId(), rFWStVideo.getPlayUrl(), rFWStVideo.getFileId(), (int) getVideoRate(rFWStVideo.getVideoRate()));
            if (computeCacheTimeS != 0.0f) {
                rFWPlayerCollectParams.setCanPlayTimeS(computeCacheTimeS);
                b(a(str), "onFeedSelectedTrigger", rFWPlayerCollectParams.toString());
                return;
            }
            for (RFWStVideoUrl rFWStVideoUrl : rFWStVideo.getVecVideoUrl()) {
                computeCacheTimeS = RFWVideoUtils.computeCacheTimeS(rFWPlayerCollectParams.getSceneId(), rFWStVideoUrl.getPlayUrl(), rFWStVideo.getFileId(), (int) getVideoRate(rFWStVideoUrl.getVideoRate()));
                if (computeCacheTimeS > 0.0f) {
                    break;
                }
            }
            rFWPlayerCollectParams.setCanPlayTimeS(computeCacheTimeS);
            b(a(str), "onFeedSelectedTrigger", rFWPlayerCollectParams.toString());
        }
    }
}
