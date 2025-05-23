package com.tencent.bugly.proguard;

import com.tencent.bugly.common.looper.MsgScheduleRecorder;
import com.tencent.bugly.common.reporter.link.LinkData;
import com.tencent.bugly.common.reporter.link.PluginLinkData;
import com.tencent.bugly.library.BuglyMonitorName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class bp {

    /* renamed from: a, reason: collision with root package name */
    private final MsgScheduleRecorder f98323a;

    /* renamed from: b, reason: collision with root package name */
    private final PluginLinkData f98324b;

    public bp(MsgScheduleRecorder msgScheduleRecorder, PluginLinkData pluginLinkData) {
        this.f98323a = msgScheduleRecorder;
        this.f98324b = pluginLinkData;
    }

    public final String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            List<MsgScheduleRecorder.ExecutedMessage> executedMessages = this.f98323a.getExecutedMessages();
            JSONArray jSONArray = new JSONArray();
            for (MsgScheduleRecorder.ExecutedMessage executedMessage : executedMessages) {
                if (executedMessage.wallTime != 0 && executedMessage.cpuTime != 0) {
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(executedMessage.wallTime);
                    jSONArray2.put(executedMessage.cpuTime);
                    jSONArray2.mo162put(executedMessage.msgDetail);
                    jSONArray2.put(executedMessage.type);
                    jSONArray2.put(executedMessage.count);
                    jSONArray2.mo162put(executedMessage.isLongMsg() ? a(executedMessage.msgEndTimeInMs, 200L) : "");
                    jSONArray.mo162put(jSONArray2);
                }
            }
            jSONObject.put("excuted_queue", jSONArray);
            MsgScheduleRecorder.ExecutedMessage currentMessage = this.f98323a.getCurrentMessage();
            JSONArray jSONArray3 = new JSONArray();
            jSONArray3.put(currentMessage.wallTime);
            jSONArray3.put(currentMessage.cpuTime);
            jSONArray3.mo162put(currentMessage.msgDetail);
            jSONArray3.mo162put(a(System.currentTimeMillis(), currentMessage.wallTime));
            jSONObject.put("current_item", jSONArray3);
            ArrayList<MsgScheduleRecorder.ExecutingMessage> executingMessages = this.f98323a.getExecutingMessages();
            JSONArray jSONArray4 = new JSONArray();
            Iterator<MsgScheduleRecorder.ExecutingMessage> it = executingMessages.iterator();
            while (it.hasNext()) {
                MsgScheduleRecorder.ExecutingMessage next = it.next();
                JSONArray jSONArray5 = new JSONArray();
                jSONArray5.put(next.arg1);
                jSONArray5.put(next.arg2);
                jSONArray5.put(next.what);
                jSONArray5.put(next.when);
                jSONArray5.mo162put(next.callback);
                jSONArray5.mo162put(next.target);
                jSONArray4.mo162put(jSONArray5);
            }
            jSONObject.put("excuting_queue", jSONArray4);
        } catch (Throwable th5) {
            av.b(th5);
        }
        return jSONObject.toString();
    }

    private String a(long j3, long j16) {
        LinkData recentLinkDataFromCurrentLaunch = this.f98324b.getRecentLinkDataFromCurrentLaunch("looper", BuglyMonitorName.LOOPER_STACK, j3);
        return (recentLinkDataFromCurrentLaunch == null || Math.abs(j3 - recentLinkDataFromCurrentLaunch.eventTimeInMS) > j16) ? "" : recentLinkDataFromCurrentLaunch.clientIdentify;
    }
}
