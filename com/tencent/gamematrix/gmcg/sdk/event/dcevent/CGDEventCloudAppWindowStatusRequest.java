package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGDEventCloudAppWindowStatusRequest implements GmCgDcEventRequest {
    private static final String TAG = "CGDEventCloudAppWindowStatusRequest";
    private boolean isOpenWindowStatus = false;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static class AndroidEvent {

        @SerializedName("androidEvent")
        public String androidEvent;

        @SerializedName("cmd")
        public String cmd;

        AndroidEvent() {
            this.cmd = GmCgDcEventDefine.CMD_ANDROID_EVENT;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static class WindowStatus {
        String cmd;
        public String data;

        WindowStatus() {
            this.cmd = "CG_GAME_EVENT_NATIVEAPP_WINDOW_STATUS";
        }
    }

    public static CGDEventCloudAppWindowStatusRequest CloseWindowStatusRequest() {
        CGDEventCloudAppWindowStatusRequest cGDEventCloudAppWindowStatusRequest = new CGDEventCloudAppWindowStatusRequest();
        cGDEventCloudAppWindowStatusRequest.isOpenWindowStatus = false;
        return cGDEventCloudAppWindowStatusRequest;
    }

    public static CGDEventCloudAppWindowStatusRequest OpenWindowStatusRequest() {
        CGDEventCloudAppWindowStatusRequest cGDEventCloudAppWindowStatusRequest = new CGDEventCloudAppWindowStatusRequest();
        cGDEventCloudAppWindowStatusRequest.isOpenWindowStatus = true;
        return cGDEventCloudAppWindowStatusRequest;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String generateDcEventDataToSend() {
        WindowStatus windowStatus = new WindowStatus();
        windowStatus.data = String.valueOf(this.isOpenWindowStatus);
        AndroidEvent androidEvent = new AndroidEvent();
        androidEvent.androidEvent = new Gson().toJson(windowStatus);
        return new Gson().toJson(androidEvent);
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String provideDcEventCmd() {
        return "CG_GAME_EVENT_NATIVEAPP_WINDOW_STATUS";
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public /* synthetic */ int provideDcEventSeq() {
        return com.tencent.gamematrix.gmcg.api.a.a(this);
    }
}
