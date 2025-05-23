package com.tencent.robot.aio.helper.tts.task;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.luggage.wxa.ig.k;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOPttApi;
import com.tencent.qqnt.aio.api.IAIOTtsApi;
import com.tencent.qqnt.aio.tts.TtsMsgIntent;
import com.tencent.qqnt.audio.tts.ui.e;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.robot.aio.helper.tts.task.RobotTtsSimpleEvent;
import com.tencent.robot.aio.tts.api.IRobotTtsApi;
import com.tencent.robot.api.IRobotDebugApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001JB\u000f\u0012\u0006\u0010Q\u001a\u00020M\u00a2\u0006\u0004\bi\u0010jJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\u001f\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u0016H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000fH\u0002J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\u0018\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\bH\u0002J\b\u0010#\u001a\u00020\nH\u0002J\b\u0010$\u001a\u00020\bH\u0002J\b\u0010%\u001a\u00020\bH\u0016J\b\u0010&\u001a\u00020\bH\u0016J\u0014\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040(0'H\u0016J\u0012\u0010+\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010\u0004H\u0016J\u0016\u0010/\u001a\u00020\b2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,H\u0016J\u0018\u00103\u001a\u00020\b2\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\u001cH\u0016J\u0010\u00104\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u00106\u001a\u00020\b2\u0006\u00105\u001a\u00020\nH\u0016J \u0010:\u001a\u00020\b2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\nH\u0016J\u0010\u0010<\u001a\u00020\b2\u0006\u0010;\u001a\u000200H\u0016J\u0010\u0010=\u001a\u00020\b2\u0006\u0010;\u001a\u000200H\u0016J\u0018\u0010?\u001a\u00020\b2\u0006\u0010;\u001a\u0002002\u0006\u0010>\u001a\u00020\nH\u0016J\b\u0010@\u001a\u00020\bH\u0016J\u0010\u0010C\u001a\u00020\b2\u0006\u0010B\u001a\u00020AH\u0016J\u0010\u0010D\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J\u0010\u0010E\u001a\u00020\b2\u0006\u0010;\u001a\u000200H\u0016J\b\u0010F\u001a\u00020\bH\u0016J\b\u0010G\u001a\u00020\bH\u0016J\u0010\u0010I\u001a\u00020\b2\u0006\u0010H\u001a\u00020\u000fH\u0016J\u0010\u0010J\u001a\u00020\b2\u0006\u0010H\u001a\u00020\u000fH\u0016J\u0010\u0010K\u001a\u00020\b2\u0006\u0010H\u001a\u00020\u000fH\u0016J\u0010\u0010L\u001a\u00020\b2\u0006\u0010H\u001a\u00020\u000fH\u0016R\u0017\u0010Q\u001a\u00020M8\u0006\u00a2\u0006\f\n\u0004\bE\u0010N\u001a\u0004\bO\u0010PR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\u000f0R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010SR0\u0010X\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0Uj\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f`V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010WR\u0016\u0010Z\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010YR\u0016\u0010[\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010YR\u0016\u0010\\\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010YR\u0016\u0010]\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010YR\u0016\u0010^\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010YR\u0016\u0010`\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010_R\u0016\u0010a\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010YR\u0016\u0010c\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010\u0012R7\u0010h\u001a\u001e\u0012\u0004\u0012\u00020d\u0012\u0004\u0012\u00020e0Uj\u000e\u0012\u0004\u0012\u00020d\u0012\u0004\u0012\u00020e`V8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010f\u001a\u0004\bb\u0010g\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006k"}, d2 = {"Lcom/tencent/robot/aio/helper/tts/task/TtsPlayTaskCenter;", "Lcom/tencent/robot/aio/helper/tts/task/b;", "Lcom/tencent/qqnt/audio/tts/ui/e$c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "robotUin", "ttsId", "", "H", "", "B", "Lcom/tencent/robot/aio/helper/tts/task/h;", "taskItem", "I", "", "msgId", "L", "J", "V", "E", "M", "Lkotlin/Pair;", "T", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "U", "msgID", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "stringResId", "iconType", "N", "content", "O", "D", ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, "K", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "event", "onReceiveEvent", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "p", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "newMsgItem", "oldStreamStatus", "f", "c", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, tl.h.F, "isSupportTts", "isSupportAutoTts", "isAutoTtsSwitchOpened", "o", "msgItem", "e", "g", "needPlay", "b", "l", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "j", "k", "d", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "sessionId", DomainData.DOMAIN_NAME, "a", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", UserInfo.SEX_FEMALE, "()Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "mTtsPlayTaskIdQueue", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mTtsPlayTaskItemMap", "Z", "mIsSupportTts", "mIsSupportAutoTts", "mIsAutoTtsSwitchOpened", "mIsTtsAbilityInitCompleted", "mHasInitWelcomeMsg", "Ljava/lang/String;", "mCurrentTtsId", "mNeedFetchRobotTtsId", "G", "mTtsTaskBeginTime", "Lcom/tencent/robot/aio/helper/tts/task/TtsPlayTaskType;", "Lcom/tencent/robot/aio/helper/tts/task/a;", "Lkotlin/Lazy;", "()Ljava/util/HashMap;", "mTtsPlayTaskProcessMap", "<init>", "(Lcom/tencent/aio/api/runtime/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TtsPlayTaskCenter implements b, e.c, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsTtsAbilityInitCompleted;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mHasInitWelcomeMsg;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String mCurrentTtsId;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mNeedFetchRobotTtsId;

    /* renamed from: G, reason: from kotlin metadata */
    private long mTtsTaskBeginTime;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy mTtsPlayTaskProcessMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<Long> mTtsPlayTaskIdQueue;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Long, TtsPlayTaskItem> mTtsPlayTaskItemMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSupportTts;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSupportAutoTts;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsAutoTtsSwitchOpened;

    public TtsPlayTaskCenter(@NotNull com.tencent.aio.api.runtime.a mAIOContext) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mAIOContext, "mAIOContext");
        this.mAIOContext = mAIOContext;
        this.mTtsPlayTaskIdQueue = new LinkedList<>();
        this.mTtsPlayTaskItemMap = new HashMap<>();
        this.mCurrentTtsId = "";
        this.mNeedFetchRobotTtsId = true;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<HashMap<TtsPlayTaskType, a>>() { // from class: com.tencent.robot.aio.helper.tts.task.TtsPlayTaskCenter$mTtsPlayTaskProcessMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<TtsPlayTaskType, a> invoke() {
                HashMap<TtsPlayTaskType, a> hashMap = new HashMap<>();
                hashMap.put(TtsPlayTaskType.TYPE_TTS_PLAY_TEXT, new d());
                hashMap.put(TtsPlayTaskType.TYPE_TTS_PLAY_MSG, new c());
                return hashMap;
            }
        });
        this.mTtsPlayTaskProcessMap = lazy;
    }

    private final void A(long msgID) {
        if (I(this.mTtsPlayTaskItemMap.get(Long.valueOf(msgID)))) {
            m();
            QLog.i("TtsPlayTaskCenter", 1, "cancelMsgPlayTask clearAndStopCurTts " + msgID);
            return;
        }
        QLog.i("TtsPlayTaskCenter", 1, "cancelMsgPlayTask removeTask " + msgID);
        L(msgID);
    }

    private final boolean B() {
        if (this.mIsSupportTts && this.mIsSupportAutoTts && this.mIsAutoTtsSwitchOpened) {
            return true;
        }
        return false;
    }

    private final void D() {
        C();
        com.tencent.qqnt.audio.tts.ui.e.INSTANCE.b().u();
    }

    private final TtsPlayTaskItem E() {
        Long peek = this.mTtsPlayTaskIdQueue.peek();
        if (peek != null) {
            return this.mTtsPlayTaskItemMap.get(Long.valueOf(peek.longValue()));
        }
        return null;
    }

    private final HashMap<TtsPlayTaskType, a> G() {
        return (HashMap) this.mTtsPlayTaskProcessMap.getValue();
    }

    private final void H(String robotUin, String ttsId) {
        AIOParam g16 = this.mAIOContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        if (Intrinsics.areEqual(su3.c.b(g16), robotUin)) {
            this.mNeedFetchRobotTtsId = false;
            this.mCurrentTtsId = ttsId;
        }
    }

    private final boolean I(TtsPlayTaskItem taskItem) {
        if (taskItem != null) {
            long msgId = taskItem.getMsgItem().getMsgId();
            Long peek = this.mTtsPlayTaskIdQueue.peek();
            if (peek != null && msgId == peek.longValue() && (taskItem.getIsStarted() || taskItem.getIsWaiting())) {
                return true;
            }
        }
        return false;
    }

    private final void J(long msgId) {
        V();
        com.tencent.qqnt.audio.tts.ui.e.INSTANCE.b().w(msgId);
        QLog.i("TtsPlayTaskCenter", 1, "markActiveWaitingMsg msgId= " + msgId);
        this.mAIOContext.e().h(new TtsMsgIntent.OnTtsPlayStateChanged(msgId));
    }

    private final void L(long msgId) {
        if (!this.mTtsPlayTaskItemMap.containsKey(Long.valueOf(msgId))) {
            return;
        }
        Iterator<Long> it = this.mTtsPlayTaskIdQueue.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "mTtsPlayTaskIdQueue.iterator()");
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Long next = it.next();
            if (next != null && next.longValue() == msgId) {
                it.remove();
                break;
            }
        }
        if (!this.mTtsPlayTaskIdQueue.contains(Long.valueOf(msgId))) {
            this.mTtsPlayTaskItemMap.remove(Long.valueOf(msgId));
        }
        if (msgId == com.tencent.qqnt.audio.tts.ui.e.INSTANCE.b().j()) {
            V();
        }
    }

    private final void M() {
        TtsPlayTaskItem E = E();
        if (E != null && !I(E)) {
            E.n(true);
            this.mTtsTaskBeginTime = NetConnInfoCenter.getServerTimeMillis();
            LifecycleOwner d16 = this.mAIOContext.d();
            Intrinsics.checkNotNullExpressionValue(d16, "mAIOContext.lifecycleOwner");
            CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(d16), "TtsPlayTaskCenterrunNextTtsTask", Boolean.TRUE, null, null, new TtsPlayTaskCenter$runNextTtsTask$1(this, E, null), 12, null);
            return;
        }
        QLog.d("TtsPlayTaskCenter", 1, "[runNextTtsTask] fail, item=" + E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(final int stringResId, final int iconType) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.robot.aio.helper.tts.task.f
            @Override // java.lang.Runnable
            public final void run() {
                TtsPlayTaskCenter.P(iconType, stringResId);
            }
        });
    }

    private final void O(final String content, final int iconType) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.robot.aio.helper.tts.task.g
            @Override // java.lang.Runnable
            public final void run() {
                TtsPlayTaskCenter.Q(iconType, content);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(int i3, int i16) {
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            QQToast.makeText(context, i3, context.getResources().getString(i16), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(int i3, String content) {
        Intrinsics.checkNotNullParameter(content, "$content");
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            QQToast.makeText(context, i3, content, 0).show();
        }
    }

    private final void R() {
        if (!S()) {
            M();
        }
    }

    private final boolean S() {
        e.Companion companion = com.tencent.qqnt.audio.tts.ui.e.INSTANCE;
        if (companion.b().k()) {
            companion.b().t();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object T(Continuation<? super Pair<Boolean, String>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (!this.mNeedFetchRobotTtsId) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(new Pair(Boxing.boxBoolean(true), this.mCurrentTtsId)));
        } else if (!AppNetConnInfo.isNetSupport()) {
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(new Pair(Boxing.boxBoolean(false), "")));
        } else {
            AIOParam g16 = getMAIOContext().g();
            Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
            ((IRobotTtsApi) QRoute.api(IRobotTtsApi.class)).getLatestRobotTtsId(su3.c.b(g16), new Function2<Integer, String, Unit>() { // from class: com.tencent.robot.aio.helper.tts.task.TtsPlayTaskCenter$tryToFetchRobotTtsId$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                    invoke(num.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @NotNull String ttsId) {
                    Intrinsics.checkNotNullParameter(ttsId, "ttsId");
                    CancellableContinuation<Pair<Boolean, String>> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion3 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(new Pair(Boolean.valueOf(i3 == 0), ttsId)));
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(TtsPlayTaskItem taskItem) {
        boolean z16;
        long longValue;
        boolean z17;
        boolean z18 = false;
        if (this.mCurrentTtsId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("TtsPlayTaskCenter", 1, "tryToRunTtsTask break ttsId = " + taskItem.getTtsId());
            C();
            return;
        }
        Long peek = this.mTtsPlayTaskIdQueue.peek();
        if (peek == null) {
            longValue = 0;
        } else {
            longValue = peek.longValue();
        }
        if (taskItem.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String() == longValue) {
            TtsPlayTaskItem ttsPlayTaskItem = this.mTtsPlayTaskItemMap.get(Long.valueOf(longValue));
            if (ttsPlayTaskItem != null && taskItem.getTaskKey() == ttsPlayTaskItem.getTaskKey()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                taskItem.p(this.mCurrentTtsId);
                a aVar = G().get(taskItem.getTaskType());
                if (aVar != null) {
                    z18 = aVar.a(new TtsPlayProcessArgs(taskItem.getMsgItem(), taskItem.getTtsId(), taskItem.getIsAutoTrigger(), this));
                }
                if (!z18) {
                    L(taskItem.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String());
                    M();
                    return;
                } else {
                    taskItem.m(true);
                    return;
                }
            }
        }
        QLog.i("TtsPlayTaskCenter", 1, "tryToRunTtsTask task judge break " + taskItem.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String());
        M();
    }

    private final void V() {
        e.Companion companion = com.tencent.qqnt.audio.tts.ui.e.INSTANCE;
        long j3 = companion.b().j();
        if (j3 != 0) {
            QLog.i("TtsPlayTaskCenter", 1, "unMarkActiveWaitingMsg msgId= " + j3);
            companion.b().w(0L);
            this.mAIOContext.e().h(new TtsMsgIntent.OnTtsPlayStateChanged(j3));
        }
    }

    public void C() {
        this.mTtsPlayTaskIdQueue.clear();
        this.mTtsPlayTaskItemMap.clear();
        V();
    }

    @NotNull
    /* renamed from: F, reason: from getter */
    public final com.tencent.aio.api.runtime.a getMAIOContext() {
        return this.mAIOContext;
    }

    public void K() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.qqnt.audio.tts.ui.e.c
    public void a(long sessionId) {
        QLog.i("TtsPlayTaskCenter", 1, "onPlayStart sessionId = " + sessionId + " hashCode = " + this.mAIOContext.hashCode());
        ((IAIOPttApi) QRoute.api(IAIOPttApi.class)).stopAll();
        this.mAIOContext.e().h(new TtsMsgIntent.OnTtsPlayStateChanged(sessionId));
    }

    @Override // com.tencent.robot.aio.helper.tts.task.b
    public void b(@NotNull AIOMsgItem msgItem, boolean needPlay) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (this.mHasInitWelcomeMsg) {
            return;
        }
        this.mHasInitWelcomeMsg = true;
        if (msgItem.I()) {
            if ((!this.mIsTtsAbilityInitCompleted || B()) && !(true ^ this.mTtsPlayTaskIdQueue.isEmpty()) && !this.mTtsPlayTaskItemMap.containsKey(Long.valueOf(msgItem.getMsgId()))) {
                TtsPlayTaskItem ttsPlayTaskItem = new TtsPlayTaskItem(0L, TtsPlayTaskType.TYPE_TTS_PLAY_TEXT, true, msgItem, false, false, false, true, null, 369, null);
                this.mTtsPlayTaskIdQueue.add(Long.valueOf(msgItem.getMsgId()));
                this.mTtsPlayTaskItemMap.put(Long.valueOf(msgItem.getMsgId()), ttsPlayTaskItem);
                if (needPlay && this.mIsTtsAbilityInitCompleted && B()) {
                    ttsPlayTaskItem.q(false);
                    M();
                }
            }
        }
    }

    @Override // com.tencent.robot.aio.helper.tts.task.b
    public void c(long msgId) {
        if (!this.mTtsPlayTaskItemMap.containsKey(Long.valueOf(msgId))) {
            return;
        }
        boolean z16 = true;
        QLog.i("TtsPlayTaskCenter", 1, "onMsgRevoked msgId = " + msgId + " size = " + this.mTtsPlayTaskIdQueue.size());
        TtsPlayTaskItem E = E();
        if (E == null || E.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String() != msgId) {
            z16 = false;
        }
        if (z16) {
            R();
        } else {
            L(msgId);
        }
    }

    @Override // com.tencent.robot.aio.helper.tts.task.b
    public void d(@NotNull AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!B()) {
            QLog.i("TtsPlayTaskCenter", 1, "onStreamMsgMaxGroupIdChanged return.");
            return;
        }
        TtsPlayTaskItem ttsPlayTaskItem = this.mTtsPlayTaskItemMap.get(Long.valueOf(msgItem.getMsgId()));
        if (ttsPlayTaskItem == null) {
            this.mTtsPlayTaskIdQueue.add(Long.valueOf(msgItem.getMsgId()));
            this.mTtsPlayTaskItemMap.put(Long.valueOf(msgItem.getMsgId()), new TtsPlayTaskItem(0L, TtsPlayTaskType.TYPE_TTS_PLAY_MSG, true, msgItem, false, false, false, false, null, k.CTRL_INDEX, null));
            QLog.i("TtsPlayTaskCenter", 1, "onStreamMsgMaxGroupIdChanged runNextTtsTask. " + msgItem.getMsgId());
            M();
            return;
        }
        ttsPlayTaskItem.k(msgItem);
        ttsPlayTaskItem.o(TtsPlayTaskType.TYPE_TTS_PLAY_MSG);
        TtsPlayTaskItem E = E();
        boolean z16 = false;
        if (E != null && E.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String() == msgItem.getMsgId()) {
            z16 = true;
        }
        if (z16) {
            ttsPlayTaskItem.l(true);
            QLog.i("TtsPlayTaskCenter", 1, "onStreamMsgMaxGroupIdChanged stopCurTts. " + msgItem.getMsgId());
            R();
        }
    }

    @Override // com.tencent.robot.aio.helper.tts.task.b
    public void e(@NotNull AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        D();
        TtsPlayTaskItem ttsPlayTaskItem = new TtsPlayTaskItem(0L, TtsPlayTaskType.TYPE_TTS_PLAY_TEXT, false, msgItem, false, false, false, false, null, k.CTRL_INDEX, null);
        this.mTtsPlayTaskIdQueue.add(Long.valueOf(msgItem.getMsgId()));
        this.mTtsPlayTaskItemMap.put(Long.valueOf(msgItem.getMsgId()), ttsPlayTaskItem);
        if (com.tencent.qqnt.aio.msg.d.g(msgItem) == 1) {
            ttsPlayTaskItem.q(true);
            J(msgItem.getMsgId());
        } else {
            M();
        }
    }

    @Override // com.tencent.robot.aio.helper.tts.task.b
    public void f(@NotNull AIOMsgItem newMsgItem, int oldStreamStatus) {
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        TtsPlayTaskItem ttsPlayTaskItem = this.mTtsPlayTaskItemMap.get(Long.valueOf(newMsgItem.getMsgId()));
        if (ttsPlayTaskItem != null && com.tencent.qqnt.aio.msg.d.g(ttsPlayTaskItem.getMsgItem()) == 1 && ttsPlayTaskItem.getIsWaiting() && com.tencent.qqnt.aio.msg.d.g(newMsgItem) > 1) {
            ttsPlayTaskItem.q(false);
            ttsPlayTaskItem.k(newMsgItem);
            Long peek = this.mTtsPlayTaskIdQueue.peek();
            long msgId = ttsPlayTaskItem.getMsgItem().getMsgId();
            if (peek != null && peek.longValue() == msgId && !ttsPlayTaskItem.getIsStarted()) {
                QLog.i("TtsPlayTaskCenter", 1, "onMsgStreamStatusChanged msgId = " + newMsgItem.getMsgId());
                M();
            }
        }
    }

    @Override // com.tencent.robot.aio.helper.tts.task.b
    public void g(@NotNull AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        TtsPlayTaskItem ttsPlayTaskItem = this.mTtsPlayTaskItemMap.get(Long.valueOf(msgItem.getMsgId()));
        if (ttsPlayTaskItem != null) {
            if (!ttsPlayTaskItem.getIsAutoTrigger()) {
                ttsPlayTaskItem = null;
            }
            if (ttsPlayTaskItem != null) {
                this.mAIOContext.e().h(new TtsMsgIntent.ChangeAutoTtsSwitchState(false));
            }
        }
        D();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(RobotTtsSimpleEvent.StopAllRobotTtsSimpleEvent.class, RobotTtsSimpleEvent.OnPickedTtsIdChangedEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.robot.aio.helper.tts.task.b
    public void h(boolean isOpen) {
        QLog.i("TtsPlayTaskCenter", 1, "onAutoTtsSwitchStateChanged isOpen = " + isOpen);
        this.mIsAutoTtsSwitchOpened = isOpen;
        if (this.mIsTtsAbilityInitCompleted && !B()) {
            m();
        }
    }

    @Override // com.tencent.qqnt.audio.tts.ui.e.c
    public void i(long sessionId) {
        QLog.i("TtsPlayTaskCenter", 1, "onPlayStop sessionId = " + sessionId + " hashCode = " + this.mAIOContext.hashCode());
        this.mAIOContext.e().h(new TtsMsgIntent.OnTtsPlayStateChanged(sessionId));
        TtsPlayTaskItem E = E();
        if (E != null && E.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String() == sessionId && E.getIsRunning() && B()) {
            if (E.getNeedReExecute()) {
                E.l(false);
                E.n(false);
            } else {
                L(sessionId);
            }
            M();
            return;
        }
        C();
    }

    @Override // com.tencent.robot.aio.helper.tts.task.b
    public void j(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        A(msgRecord.getMsgId());
    }

    @Override // com.tencent.robot.aio.helper.tts.task.b
    public void k(long msgID) {
        A(msgID);
    }

    @Override // com.tencent.robot.aio.helper.tts.task.b
    public void l() {
        Long peek = this.mTtsPlayTaskIdQueue.peek();
        if (peek == null) {
            return;
        }
        long longValue = peek.longValue();
        TtsPlayTaskItem ttsPlayTaskItem = this.mTtsPlayTaskItemMap.get(Long.valueOf(longValue));
        if (ttsPlayTaskItem != null && com.tencent.qqnt.aio.msg.d.i(ttsPlayTaskItem.getMsgItem()) && ttsPlayTaskItem.getIsWaiting()) {
            QLog.i("TtsPlayTaskCenter", 1, "tryToPlayWelcomeMsg msgId = " + longValue);
            ttsPlayTaskItem.q(false);
            M();
        }
    }

    @Override // com.tencent.robot.aio.helper.tts.task.b
    public void m() {
        C();
        S();
    }

    @Override // com.tencent.qqnt.audio.tts.ui.e.c
    public void n(long sessionId) {
        QLog.i("TtsPlayTaskCenter", 1, "onPlayLoading sessionId = " + sessionId + " hashCode = " + this.mAIOContext.hashCode());
        this.mAIOContext.e().h(new TtsMsgIntent.OnTtsPlayStateChanged(sessionId));
    }

    @Override // com.tencent.robot.aio.helper.tts.task.b
    public void o(boolean isSupportTts, boolean isSupportAutoTts, boolean isAutoTtsSwitchOpened) {
        this.mIsSupportTts = isSupportTts;
        this.mIsSupportAutoTts = isSupportAutoTts;
        this.mIsAutoTtsSwitchOpened = isAutoTtsSwitchOpened;
        this.mIsTtsAbilityInitCompleted = true;
        if (!B()) {
            m();
        }
    }

    @Override // com.tencent.robot.aio.helper.tts.task.b
    public void onDestroy() {
        D();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.mIsSupportTts = false;
        this.mIsSupportAutoTts = false;
        this.mIsAutoTtsSwitchOpened = false;
        this.mIsTtsAbilityInitCompleted = false;
        this.mHasInitWelcomeMsg = false;
        this.mCurrentTtsId = "";
        this.mNeedFetchRobotTtsId = true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof RobotTtsSimpleEvent.StopAllRobotTtsSimpleEvent) {
            m();
        } else if (event instanceof RobotTtsSimpleEvent.OnPickedTtsIdChangedEvent) {
            RobotTtsSimpleEvent.OnPickedTtsIdChangedEvent onPickedTtsIdChangedEvent = (RobotTtsSimpleEvent.OnPickedTtsIdChangedEvent) event;
            H(onPickedTtsIdChangedEvent.getRobotUin(), onPickedTtsIdChangedEvent.getTtsId());
        }
    }

    @Override // com.tencent.robot.aio.helper.tts.task.b
    public void p(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList) {
        AIOMsgItem aIOMsgItem;
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        int i3 = 1;
        if (!B()) {
            QLog.i("TtsPlayTaskCenter", 1, "onReceiveMsgList checkAutoTtsAbility false");
            return;
        }
        if (!this.mAIOContext.d().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
            QLog.i("TtsPlayTaskCenter", 1, "onReceiveMsgList check currentState false");
            return;
        }
        for (com.tencent.aio.data.msglist.a aVar : msgList) {
            if (aVar instanceof AIOMsgItem) {
                aIOMsgItem = (AIOMsgItem) aVar;
            } else {
                aIOMsgItem = null;
            }
            AIOMsgItem aIOMsgItem2 = aIOMsgItem;
            if (aIOMsgItem2 != null) {
                if (((IAIOTtsApi) QRoute.api(IAIOTtsApi.class)).isMsgSupportTts(aIOMsgItem2) && !this.mTtsPlayTaskItemMap.containsKey(Long.valueOf(aVar.getMsgId()))) {
                    AIOMsgItem aIOMsgItem3 = (AIOMsgItem) aVar;
                    if (!com.tencent.qqnt.aio.msg.d.i(aIOMsgItem3) && !com.tencent.qqnt.aio.msg.d.j(aIOMsgItem3)) {
                        TtsPlayTaskItem E = E();
                        if (!I(E)) {
                            this.mTtsPlayTaskIdQueue.add(Long.valueOf(aVar.getMsgId()));
                            this.mTtsPlayTaskItemMap.put(Long.valueOf(aVar.getMsgId()), new TtsPlayTaskItem(0L, TtsPlayTaskType.TYPE_TTS_PLAY_MSG, true, aIOMsgItem2, false, false, false, false, null, k.CTRL_INDEX, null));
                            i3 = 1;
                            QLog.i("TtsPlayTaskCenter", 1, "onReceiveMsgList add to run msgId=" + aVar.getMsgId() + " size=" + this.mTtsPlayTaskIdQueue.size());
                            if (this.mTtsPlayTaskIdQueue.size() == 1) {
                                M();
                            }
                        } else {
                            boolean z16 = false;
                            if (E != null && E.getIsAutoTrigger() == i3) {
                                z16 = true;
                            }
                            if (z16) {
                                QLog.i("TtsPlayTaskCenter", 1, "onReceiveMsgList add to queue msgId = " + aVar.getMsgId());
                                this.mTtsPlayTaskIdQueue.add(Long.valueOf(aIOMsgItem2.getMsgId()));
                                this.mTtsPlayTaskItemMap.put(Long.valueOf(aIOMsgItem2.getMsgId()), new TtsPlayTaskItem(0L, TtsPlayTaskType.TYPE_TTS_PLAY_MSG, true, aIOMsgItem2, false, false, false, false, null, k.CTRL_INDEX, null));
                            }
                            i3 = 1;
                        }
                    } else {
                        i3 = 1;
                        QLog.i("TtsPlayTaskCenter", 1, "onReceiveMsgList filter memoryMsg msgId = " + aVar.getMsgId());
                    }
                } else {
                    QLog.i("TtsPlayTaskCenter", i3, "onReceiveMsgList filter msgId = " + aVar.getMsgId());
                }
            }
        }
    }

    @Override // com.tencent.qqnt.audio.tts.ui.e.c
    public void q(long sessionId) {
        QLog.i("TtsPlayTaskCenter", 1, "onFirstTtsPlay sessionId = " + sessionId);
        if (((IRobotDebugApi) QRoute.api(IRobotDebugApi.class)).isSupportCalculateTtsCostTime()) {
            O("tts cost millisTime: " + (NetConnInfoCenter.getServerTimeMillis() - this.mTtsTaskBeginTime), 0);
        }
    }
}
