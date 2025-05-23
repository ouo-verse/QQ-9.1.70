package com.tencent.state.common.push;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.state.PageType;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 62\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00016B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u0018\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0010H\u0002J\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0010H\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\u0016\u0010'\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u0010J\u001a\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u0003H\u0016J\u0010\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u0019H\u0016J\u0010\u00101\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u00102\u001a\u00020\u001eH\u0016J\b\u00103\u001a\u00020\u001eH\u0016J\u0010\u00104\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u0019H\u0016J\b\u00105\u001a\u00020\u001eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/tencent/state/common/push/BasePushManager;", "Lcom/tencent/state/common/push/IPushManager;", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/common/push/PullMsgResponse;", "pageType", "Lcom/tencent/state/PageType;", "appId", "", "(Lcom/tencent/state/PageType;I)V", "interceptor", "Lcom/tencent/state/common/push/IPushInterceptor;", "isInitialized", "", "isStarted", "lastInterval", "lastOffset", "", "lastStartTime", "", "lastTask", "Ljava/lang/Runnable;", "listenerMap", "", "Lcom/tencent/state/common/push/RegisterKey;", "", "Lcom/tencent/state/common/push/IPushListener;", "roomId", "service", "Lcom/tencent/state/common/push/IVasPushService;", "dispatchMessage", "", "messages", "", "Lcom/tencent/state/common/push/PushMessage;", "dispatchNextPullMsg", WidgetCacheConstellationData.INTERVAL, "offset", "doPullMessage", "doStop", "initialize", "initialOffset", "onResultFailure", "error", "message", "", "onResultSuccess", "result", "register", "listener", "setPushInterceptor", "start", "stop", "unregister", "unregisterAll", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class BasePushManager implements IPushManager, ResultCallback<PullMsgResponse> {
    private static final String TAG = "BasePushManager";
    private final int appId;
    private IPushInterceptor interceptor;
    private boolean isInitialized;
    private boolean isStarted;
    private int lastInterval;
    private byte[] lastOffset;
    private long lastStartTime;
    private Runnable lastTask;
    private final Map<RegisterKey, Set<IPushListener>> listenerMap;
    private final PageType pageType;
    private long roomId;
    private IVasPushService service;

    public BasePushManager(PageType pageType, int i3) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        this.pageType = pageType;
        this.appId = i3;
        this.listenerMap = new LinkedHashMap();
        this.lastInterval = 5000;
        this.lastOffset = new byte[0];
        this.service = PushServiceFactory.INSTANCE.get(pageType, i3);
    }

    private final void dispatchNextPullMsg(int interval, final byte[] offset) {
        long currentTimeMillis = System.currentTimeMillis() - this.lastStartTime;
        long j3 = interval;
        if (currentTimeMillis >= j3) {
            SquareBaseKt.getSquareThread().postOnSubThread(new Function0<Unit>() { // from class: com.tencent.state.common.push.BasePushManager$dispatchNextPullMsg$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    BasePushManager.this.doPullMessage(offset);
                }
            });
        } else {
            this.lastTask = SquareBaseKt.getSquareThread().postOnSubThreadDelay(new Function0<Unit>() { // from class: com.tencent.state.common.push.BasePushManager$dispatchNextPullMsg$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    BasePushManager.this.doPullMessage(offset);
                }
            }, j3 - currentTimeMillis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doPullMessage(byte[] offset) {
        if (this.isStarted) {
            IPushInterceptor iPushInterceptor = this.interceptor;
            if (iPushInterceptor != null && iPushInterceptor.onInterceptPullMessage()) {
                SquareBaseKt.getSquareLog().w(TAG, "doPullMessage, but intercepted.");
                return;
            }
            this.lastStartTime = System.currentTimeMillis();
            IVasPushService iVasPushService = this.service;
            if (iVasPushService != null) {
                iVasPushService.pullMessage(this.roomId, offset, this);
                return;
            }
            return;
        }
        SquareBaseKt.getSquareLog().w(TAG, "doPullMessage, but isStarted=" + this.isStarted);
    }

    public final void initialize(long roomId, byte[] initialOffset) {
        Intrinsics.checkNotNullParameter(initialOffset, "initialOffset");
        this.roomId = roomId;
        this.lastOffset = initialOffset;
        doStop();
        this.isInitialized = true;
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int i3, String str, String str2) {
        ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
    }

    @Override // com.tencent.state.common.push.IPushManager
    public void register(IPushListener listener) {
        RegisterKey registerKey;
        Intrinsics.checkNotNullParameter(listener, "listener");
        IVasPushService iVasPushService = PushServiceFactory.INSTANCE.get(this.pageType, this.appId);
        if (iVasPushService == null || (registerKey = iVasPushService.getRegisterKey()) == null) {
            return;
        }
        Set<IPushListener> set = this.listenerMap.get(registerKey);
        if (set == null) {
            set = new LinkedHashSet<>();
            this.listenerMap.put(registerKey, set);
        }
        set.add(listener);
    }

    @Override // com.tencent.state.common.push.IPushManager
    public void setPushInterceptor(IPushInterceptor interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        this.interceptor = interceptor;
    }

    @Override // com.tencent.state.common.push.IPushManager
    public void start() {
        if (!this.isStarted && this.isInitialized) {
            SquareBaseKt.getSquareLog().i(TAG, "start push manager appId=" + this.appId);
            this.isStarted = true;
            doPullMessage(this.lastOffset);
            return;
        }
        SquareBaseKt.getSquareLog().w(TAG, "PushManager start failed: appId=" + this.appId + " isStarted=" + this.isStarted + ", isInitialized=" + this.isInitialized);
    }

    @Override // com.tencent.state.common.push.IPushManager
    public void stop() {
        SquareBaseKt.getSquareLog().i(TAG, "stop push manager appId=" + this.appId);
        doStop();
    }

    @Override // com.tencent.state.common.push.IPushManager
    public void unregister(IPushListener listener) {
        RegisterKey registerKey;
        Set<IPushListener> set;
        Intrinsics.checkNotNullParameter(listener, "listener");
        IVasPushService iVasPushService = PushServiceFactory.INSTANCE.get(this.pageType, this.appId);
        if (iVasPushService == null || (registerKey = iVasPushService.getRegisterKey()) == null || (set = this.listenerMap.get(registerKey)) == null) {
            return;
        }
        set.remove(listener);
    }

    @Override // com.tencent.state.common.push.IPushManager
    public void unregisterAll() {
        this.listenerMap.clear();
    }

    private final void dispatchMessage(List<? extends PushMessage> messages) {
        String joinToString$default;
        if (!messages.isEmpty()) {
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("dispatchMessage: appId=");
            sb5.append(this.appId);
            sb5.append(" size=");
            sb5.append(messages.size());
            sb5.append(", messages=");
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(messages, "\n", null, null, 0, null, null, 62, null);
            sb5.append(joinToString$default);
            squareLog.i(TAG, sb5.toString());
        }
        for (Map.Entry<RegisterKey, Set<IPushListener>> entry : this.listenerMap.entrySet()) {
            RegisterKey key = entry.getKey();
            for (IPushListener iPushListener : entry.getValue()) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : messages) {
                    if (key.getMessageTypes().contains(Integer.valueOf(((PushMessage) obj).getType()))) {
                        arrayList.add(obj);
                    }
                }
                iPushListener.onReceive(arrayList);
            }
        }
    }

    private final void doStop() {
        this.isStarted = false;
        Runnable runnable = this.lastTask;
        if (runnable != null) {
            SquareBaseKt.getSquareThread().removeTask(runnable);
        }
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int error, String message) {
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "pull message failed: appId=" + this.appId + " error=" + error + ", message=" + message, null, 4, null);
        dispatchNextPullMsg(this.lastInterval, this.lastOffset);
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultSuccess(PullMsgResponse result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.lastInterval = result.getInterval();
        this.lastOffset = result.getOffset();
        if (Square.INSTANCE.getConfig().isDebug()) {
            SquareBaseKt.getSquareLog().i(TAG, "pull message success: appId=" + this.appId + " pageType=" + this.pageType + " interval=" + result.getInterval() + ", message size=" + result.getMessages().size());
        }
        dispatchNextPullMsg(result.getInterval(), result.getOffset());
        IPushInterceptor iPushInterceptor = this.interceptor;
        if (iPushInterceptor == null || !iPushInterceptor.onInterceptDispatchMessage()) {
            dispatchMessage(result.getMessages());
        }
    }

    public /* synthetic */ BasePushManager(PageType pageType, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(pageType, (i16 & 2) != 0 ? 0 : i3);
    }
}
