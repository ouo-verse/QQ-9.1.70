package com.tencent.qqmini.sdk.launcher.core.action;

import com.tencent.qqmini.miniapp.plugin.EmbeddedVideoJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ServiceSubscribeEvent implements Action<String> {
    private static final List<String> HIGH_FREQUENCY_EVENT_LOG = Arrays.asList(SensorJsPlugin.EVENT_ACCELEROMETER_STATE_CHANGE, EmbeddedVideoJsPlugin.VIDEO_EVENT_TIME_UPDATE, "onPageNotFound");
    private String event;
    private String jsonParams;
    private int sourceId;
    private IJsService target;

    public static ServiceSubscribeEvent obtain(String str, String str2, int i3) {
        ServiceSubscribeEvent serviceSubscribeEvent = new ServiceSubscribeEvent();
        serviceSubscribeEvent.event = str;
        serviceSubscribeEvent.jsonParams = str2;
        serviceSubscribeEvent.sourceId = i3;
        return serviceSubscribeEvent;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public String perform(BaseRuntime baseRuntime) {
        StringBuilder sb5 = new StringBuilder("SubscribeEvent ");
        sb5.append("eventName = ");
        sb5.append(this.event);
        sb5.append("sourceWebViewId = ");
        sb5.append(this.sourceId);
        if (!HIGH_FREQUENCY_EVENT_LOG.contains(this.event)) {
            QMLog.d(Action.TAG, sb5.toString());
        } else if (FastClickUtils.isFastDoubleClick(Action.TAG, 200L)) {
            QMLog.d(Action.TAG, sb5.toString());
        }
        IJsService iJsService = this.target;
        if (iJsService == null) {
            iJsService = baseRuntime.getJsService();
        }
        if (iJsService == null) {
            return null;
        }
        iJsService.evaluateSubscribeJS(this.event, this.jsonParams, this.sourceId);
        return null;
    }

    public static ServiceSubscribeEvent obtain(String str, String str2, int i3, IJsService iJsService) {
        ServiceSubscribeEvent serviceSubscribeEvent = new ServiceSubscribeEvent();
        serviceSubscribeEvent.event = str;
        serviceSubscribeEvent.jsonParams = str2;
        serviceSubscribeEvent.sourceId = i3;
        serviceSubscribeEvent.target = iJsService;
        return serviceSubscribeEvent;
    }
}
