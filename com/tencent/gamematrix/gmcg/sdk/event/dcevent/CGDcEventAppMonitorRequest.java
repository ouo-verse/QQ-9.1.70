package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import com.google.gson.Gson;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGDcEventAppMonitorRequest implements GmCgDcEventRequest {
    private int mLevel;
    private String mPackageName;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static class BodyMonitorAppReq {
        String cmd = GmCgDcEventDefine.CMD_APP_LIVE_MONITOR_REQ;
        MonitorAppReq monitorAppReq;

        /* compiled from: P */
        /* loaded from: classes6.dex */
        static class MonitorAppReq {
            int level;
            String packageName;

            MonitorAppReq() {
            }
        }

        BodyMonitorAppReq(String str, int i3) {
            MonitorAppReq monitorAppReq = new MonitorAppReq();
            this.monitorAppReq = monitorAppReq;
            monitorAppReq.packageName = str;
            monitorAppReq.level = i3;
        }

        static String toJsonString(String str, int i3) {
            return new Gson().toJson(new BodyMonitorAppReq(str, i3));
        }
    }

    public CGDcEventAppMonitorRequest(String str, int i3) {
        this.mPackageName = str;
        this.mLevel = i3;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String generateDcEventDataToSend() {
        return BodyMonitorAppReq.toJsonString(this.mPackageName, this.mLevel);
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_APP_LIVE_MONITOR_REQ;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public /* synthetic */ int provideDcEventSeq() {
        return com.tencent.gamematrix.gmcg.api.a.a(this);
    }
}
