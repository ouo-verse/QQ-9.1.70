package com.tencent.richframework.tracer;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\r\b\u0016\u0018\u0000 D2\u00020\u0001:\u0002DEB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\rH\u0002J\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u0003J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0001J\u0010\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0013H\u0002J\u0018\u0010'\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u0003J\u000e\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0010J\u0010\u0010-\u001a\u00020.2\u0006\u0010!\u001a\u00020\u0003H\u0002J\b\u0010/\u001a\u00020\u0000H\u0004J\u0006\u00100\u001a\u00020$J\u000e\u00101\u001a\u00020$2\u0006\u0010)\u001a\u00020\u0003J\b\u00102\u001a\u00020\u0003H\u0016J\b\u00103\u001a\u00020\u0003H\u0016J\b\u00104\u001a\u00020.H\u0002J\u0006\u00105\u001a\u00020.J\u000e\u00106\u001a\u00020$2\u0006\u00107\u001a\u00020\u0003J\u000e\u00108\u001a\u0002092\u0006\u0010!\u001a\u00020\u0003J\u0010\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u000209H\u0002J\b\u0010<\u001a\u00020$H\u0002J\u0006\u0010=\u001a\u00020$J\u001f\u0010>\u001a\u00020\u00002\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\n\"\u00020\u0003\u00a2\u0006\u0002\u0010?J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u001aJ\b\u0010A\u001a\u00020\u0006H\u0004J\u000e\u0010B\u001a\u00020$2\u0006\u0010)\u001a\u00020\u0003J\u000e\u0010C\u001a\u00020$2\u0006\u0010!\u001a\u00020\u0003J\u0016\u0010C\u001a\u00020$2\u0006\u0010!\u001a\u00020\u00032\u0006\u00108\u001a\u000209R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\nX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0004R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006F"}, d2 = {"Lcom/tencent/richframework/tracer/RFWTraceStream;", "", "streamName", "", "(Ljava/lang/String;)V", DownloadInfo.spKey_Config, "Lcom/tencent/richframework/tracer/RFWTraceConfig;", "extraParam", "", "lastNodeArr", "", "[Ljava/lang/String;", "nodeMap", "Lcom/tencent/richframework/tracer/RFWTraceNode;", "resultHandlerList", "", "Lcom/tencent/richframework/tracer/RFWTraceStream$IStreamResultHandler;", "sessionId", "stepMap", "Lcom/tencent/richframework/tracer/RFWTraceStep;", "getStreamName", "()Ljava/lang/String;", "setStreamName", "streamResult", "Lcom/tencent/richframework/tracer/RFWTraceStreamResult;", "streamType", "", "getStreamType", "()I", "setStreamType", "(I)V", "addNode", "node", "nodeName", "nodeDesc", "addParam", "", "paramKey", "paramValue", "addStep", "step", "stepName", "stepDesc", "addStreamResultHandler", "resultHandler", "checkStreamEnd", "", QCircleLpReportDc05507.KEY_CLEAR, "end", "endStep", "generateSessionId", "getSessionLog", "isStreamEnd", "isStreamRunning", "log", "msg", "nodeTime", "", "onStreamEnd", QCircleWeakNetReporter.KEY_COST, "onStreamStart", "reset", "setLastNode", "([Ljava/lang/String;)Lcom/tencent/richframework/tracer/RFWTraceStream;", "type", "startConfig", "startStep", "tagNode", "Companion", "IStreamResultHandler", "trace_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public class RFWTraceStream {
    private static final String TAG_PREFIX = "rfw_stream_";
    private final RFWTraceConfig config;
    private Map<String, Object> extraParam;
    private String[] lastNodeArr;
    private Map<String, RFWTraceNode> nodeMap;
    private final List<IStreamResultHandler> resultHandlerList;
    private String sessionId;
    private Map<String, RFWTraceStep> stepMap;

    @NotNull
    private String streamName;
    private RFWTraceStreamResult streamResult;
    private int streamType;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/richframework/tracer/RFWTraceStream$IStreamResultHandler;", "", "onStreamFinish", "", "streamResult", "Lcom/tencent/richframework/tracer/RFWTraceStreamResult;", "trace_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public interface IStreamResultHandler {
        void onStreamFinish(@NotNull RFWTraceStreamResult streamResult);
    }

    public RFWTraceStream(@NotNull String streamName) {
        Intrinsics.checkNotNullParameter(streamName, "streamName");
        this.streamName = streamName;
        this.sessionId = "";
        this.streamResult = new RFWTraceStreamResult();
        this.resultHandlerList = new CopyOnWriteArrayList();
        this.config = new RFWTraceConfig();
        this.nodeMap = new LinkedHashMap();
        this.stepMap = new LinkedHashMap();
        this.lastNodeArr = new String[0];
        this.extraParam = new ConcurrentHashMap();
        this.streamType = Integer.MIN_VALUE;
    }

    private final RFWTraceStream addNode(RFWTraceNode node) {
        synchronized (this) {
            if (this.nodeMap.containsKey(node.getNodeName())) {
                log("addNode error, node exist");
                return this;
            }
            this.nodeMap.put(node.getNodeName(), node);
            return this;
        }
    }

    public static /* synthetic */ RFWTraceStream addNode$default(RFWTraceStream rFWTraceStream, String str, String str2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                str2 = "";
            }
            return rFWTraceStream.addNode(str, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addNode");
    }

    public static /* synthetic */ RFWTraceStream addStep$default(RFWTraceStream rFWTraceStream, String str, String str2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                str2 = "";
            }
            return rFWTraceStream.addStep(str, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addStep");
    }

    private final boolean checkStreamEnd(String nodeName) {
        boolean z16;
        boolean contains;
        Object last;
        String[] strArr = this.lastNodeArr;
        if (strArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            last = CollectionsKt___CollectionsKt.last(this.nodeMap.keySet());
            return Intrinsics.areEqual(nodeName, (String) last);
        }
        contains = ArraysKt___ArraysKt.contains(strArr, nodeName);
        if (!contains) {
            return false;
        }
        for (String str : this.lastNodeArr) {
            RFWTraceNode rFWTraceNode = this.nodeMap.get(str);
            if (rFWTraceNode != null && rFWTraceNode.getNodeTime() <= 0) {
                return false;
            }
        }
        return true;
    }

    private final boolean isStreamEnd() {
        if (this.sessionId.length() == 0) {
            return true;
        }
        return false;
    }

    private final void onStreamEnd(long cost) {
        synchronized (this) {
            Iterator<T> it = this.nodeMap.values().iterator();
            while (it.hasNext()) {
                ((RFWTraceNode) it.next()).reset();
            }
            Iterator<T> it5 = this.stepMap.values().iterator();
            while (it5.hasNext()) {
                ((RFWTraceStep) it5.next()).reset();
            }
            this.streamResult.setTotalCost(cost);
            this.streamResult.setSessionId(this.sessionId);
            this.streamResult.setStreamName(this.streamName);
            this.streamResult.setExtraParam(this.extraParam);
            log("stream end streamResult:" + this.streamResult);
            Iterator<T> it6 = this.resultHandlerList.iterator();
            while (it6.hasNext()) {
                ((IStreamResultHandler) it6.next()).onStreamFinish(this.streamResult);
            }
            this.sessionId = "";
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void onStreamStart() {
        this.sessionId = generateSessionId();
        this.streamResult = new RFWTraceStreamResult();
        log("stream start extraParam:" + this.extraParam);
    }

    public final void addParam(@NotNull String paramKey, @NotNull Object paramValue) {
        Intrinsics.checkNotNullParameter(paramKey, "paramKey");
        Intrinsics.checkNotNullParameter(paramValue, "paramValue");
        this.extraParam.put(paramKey, paramValue);
    }

    @NotNull
    public final RFWTraceStream addStep(@NotNull String stepName, @NotNull String stepDesc) {
        Intrinsics.checkNotNullParameter(stepName, "stepName");
        Intrinsics.checkNotNullParameter(stepDesc, "stepDesc");
        addStep(new RFWTraceStep(stepName, stepDesc));
        return this;
    }

    public final void addStreamResultHandler(@NotNull IStreamResultHandler resultHandler) {
        Intrinsics.checkNotNullParameter(resultHandler, "resultHandler");
        this.resultHandlerList.add(resultHandler);
    }

    @NotNull
    protected final RFWTraceStream clear() {
        synchronized (this) {
            this.nodeMap.clear();
            this.stepMap.clear();
        }
        return this;
    }

    public final void end() {
        if (!isStreamEnd()) {
            onStreamEnd(0L);
        }
    }

    public final void endStep(@NotNull String stepName) {
        Intrinsics.checkNotNullParameter(stepName, "stepName");
        RFWTraceStep rFWTraceStep = this.stepMap.get(stepName);
        if (rFWTraceStep != null) {
            if (rFWTraceStep.getStart() <= 0) {
                log(stepName + ", " + rFWTraceStep.getStepDesc() + " have not call start method");
                return;
            }
            rFWTraceStep.setEnd(System.currentTimeMillis());
            rFWTraceStep.setCost(rFWTraceStep.getEnd() - rFWTraceStep.getStart());
            log(stepName + ", " + rFWTraceStep.getStepDesc() + " cost " + rFWTraceStep.getCost() + " ms");
        }
    }

    @NotNull
    public String generateSessionId() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(System.currentTimeMillis());
        sb5.append(util.base64_pad_url);
        sb5.append(hashCode());
        return sb5.toString();
    }

    @NotNull
    public String getSessionLog() {
        return "session: " + this.sessionId;
    }

    @NotNull
    public final String getStreamName() {
        return this.streamName;
    }

    public final int getStreamType() {
        return this.streamType;
    }

    public final boolean isStreamRunning() {
        if (this.sessionId.length() > 0) {
            return true;
        }
        return false;
    }

    public final void log(@NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (this.config.getMLogEnable()) {
            RFWLog.d(TAG_PREFIX + this.streamName, RFWLog.USR, getSessionLog() + ", " + msg2);
        }
    }

    public final long nodeTime(@NotNull String nodeName) {
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        RFWTraceNode rFWTraceNode = this.nodeMap.get(nodeName);
        if (rFWTraceNode != null) {
            return rFWTraceNode.getNodeTime();
        }
        return 0L;
    }

    public final void reset() {
        synchronized (this) {
            this.sessionId = "";
            Iterator<T> it = this.nodeMap.values().iterator();
            while (it.hasNext()) {
                ((RFWTraceNode) it.next()).reset();
            }
            Iterator<T> it5 = this.stepMap.values().iterator();
            while (it5.hasNext()) {
                ((RFWTraceStep) it5.next()).reset();
            }
            this.extraParam.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @NotNull
    public final RFWTraceStream setLastNode(@NotNull String... lastNodeArr) {
        Intrinsics.checkNotNullParameter(lastNodeArr, "lastNodeArr");
        this.lastNodeArr = lastNodeArr;
        return this;
    }

    public final void setStreamName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.streamName = str;
    }

    /* renamed from: setStreamType, reason: collision with other method in class */
    public final void m251setStreamType(int i3) {
        this.streamType = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: startConfig, reason: from getter */
    public final RFWTraceConfig getConfig() {
        return this.config;
    }

    public final void startStep(@NotNull String stepName) {
        Intrinsics.checkNotNullParameter(stepName, "stepName");
        RFWTraceStep rFWTraceStep = this.stepMap.get(stepName);
        if (rFWTraceStep != null) {
            rFWTraceStep.setStart(System.currentTimeMillis());
            log(stepName + ", " + rFWTraceStep.getStepDesc() + " start");
        }
    }

    public final void tagNode(@NotNull String nodeName) {
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        tagNode(nodeName, System.currentTimeMillis());
    }

    private final RFWTraceStream addStep(RFWTraceStep step) {
        this.stepMap.put(step.getStepName(), step);
        return this;
    }

    @NotNull
    public final RFWTraceStream setStreamType(int type) {
        this.streamType = type;
        return this;
    }

    public final void tagNode(@NotNull String nodeName, long nodeTime) {
        Object first;
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        synchronized (this) {
            first = CollectionsKt___CollectionsKt.first(this.nodeMap.keySet());
            String str = (String) first;
            boolean areEqual = Intrinsics.areEqual(nodeName, str);
            if (!areEqual && isStreamEnd()) {
                log("tag node: " + nodeName + " error, stream has finish");
                return;
            }
            if (this.nodeMap.isEmpty()) {
                log("tag node: " + nodeName + " error, you have not define any node");
                return;
            }
            if (!this.nodeMap.containsKey(nodeName)) {
                log("tag node: " + nodeName + " error, have you define this node?");
                return;
            }
            RFWTraceNode rFWTraceNode = this.nodeMap.get(nodeName);
            RFWTraceNode rFWTraceNode2 = this.nodeMap.get(str);
            if (rFWTraceNode != null && rFWTraceNode2 != null) {
                RFWTraceNode rFWTraceNode3 = rFWTraceNode2;
                RFWTraceNode rFWTraceNode4 = rFWTraceNode;
                rFWTraceNode4.setNodeTime(nodeTime);
                if (!areEqual) {
                    rFWTraceNode4.setCost(rFWTraceNode4.getNodeTime() - rFWTraceNode3.getNodeTime());
                    this.streamResult.getCostMap().put(rFWTraceNode4.getNodeName(), Long.valueOf(rFWTraceNode4.getCost()));
                }
                if (areEqual) {
                    onStreamStart();
                } else {
                    log("tag node: " + nodeName + ", " + rFWTraceNode4.getNodeDesc() + " cost " + rFWTraceNode4.getCost() + " ms");
                }
                if (checkStreamEnd(nodeName)) {
                    onStreamEnd(rFWTraceNode4.getCost());
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @NotNull
    public final RFWTraceStream addNode(@NotNull String nodeName, @NotNull String nodeDesc) {
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        Intrinsics.checkNotNullParameter(nodeDesc, "nodeDesc");
        addNode(new RFWTraceNode(nodeName, nodeDesc));
        return this;
    }
}
