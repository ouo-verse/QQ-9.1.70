package com.tencent.zplan.meme.action;

import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.hihealth.HiHealthActivities;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.c;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.meme.model.MemeResult;
import com.tencent.zplan.meme.recorder.a;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u0000 \u007f2\u00020\u0001:\u0003\u0080\u0001\u007fB\u000f\u0012\u0006\u0010o\u001a\u00020n\u00a2\u0006\u0004\b}\u0010~J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u001f\u0010\r\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0010\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u000e\u001a\u00020\bH&J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0002H&J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u001a\u001a\u00020\u0019H&J\u0010\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH&J\u001c\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001e0 2\u0006\u0010\u001f\u001a\u00020\u001eH&J\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001e0 2\u0006\u0010\u001f\u001a\u00020\u001eH&J\u0006\u0010#\u001a\u00020\u0016J!\u0010%\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020\bH&\u00a2\u0006\u0004\b%\u0010&J\b\u0010'\u001a\u00020\u0016H&J\u0010\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0016H&J\b\u0010*\u001a\u00020\bH&J\u000f\u0010-\u001a\u00020\nH\u0010\u00a2\u0006\u0004\b+\u0010,J\u000f\u00100\u001a\u00020\u0016H\u0000\u00a2\u0006\u0004\b.\u0010/J\u001b\u00103\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0 H\u0010\u00a2\u0006\u0004\b1\u00102J\u000f\u00106\u001a\u00020\bH\u0010\u00a2\u0006\u0004\b4\u00105J\u0010\u00108\u001a\u0002072\u0006\u0010(\u001a\u00020\u0016H\u0016R.\u0010:\u001a\u0004\u0018\u00010\u00022\b\u00109\u001a\u0004\u0018\u00010\u00028\u0004@DX\u0084\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001b\u0010C\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010=R\u0016\u0010D\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010;R\"\u0010F\u001a\u00020E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010M\u001a\u00020L8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR+\u0010[\u001a\u00020S2\u0006\u0010T\u001a\u00020S8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001b\u0010^\u001a\u00020\u00168FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\\\u0010A\u001a\u0004\b]\u0010/R\"\u0010#\u001a\u00020\u00168\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010_\u001a\u0004\b`\u0010/\"\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010_R\u001b\u0010g\u001a\u0002078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bd\u0010A\u001a\u0004\be\u0010fR$\u0010h\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001a\u0010o\u001a\u00020n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010rR\u0014\u0010t\u001a\u00020\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bs\u0010/R\u0014\u0010v\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bu\u0010=R\u0014\u0010x\u001a\u00020\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bw\u0010/R\u0014\u0010z\u001a\u00020\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\by\u0010/R\u0011\u0010|\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b{\u0010=\u00a8\u0006\u0081\u0001"}, d2 = {"Lcom/tencent/zplan/meme/action/MemeAction;", "", "", "getIdDesc", "getSenderUin", "getReceiverUin", "uin", "appearanceKey", "", "isAppearanceKeyMatch", "", "resetRecordKey$record_debug", "(Ljava/lang/String;Ljava/lang/String;)V", "resetRecordKey", "isDoubleSpriteTask", "Ljava/lang/Class;", "Lcom/tencent/zplan/meme/recorder/a;", "getRecorderClazz", "Lcom/tencent/zplan/meme/c;", "listener", "checkResource", "getKey", "", "portraitId", "getSingleActionKey", "Lcom/tencent/zplan/meme/Meme$Type;", "getType", "", "Lcom/tencent/zplan/meme/action/MemeAction$Cache;", "getCachedFiles", "Lcom/tencent/zplan/meme/model/MemeResult;", "result", "Lkotlin/Pair;", "saveCacheFiles", "saveCoverCacheFiles", "recordDoneCount", "success", "markOneRecordDone", "(Ljava/lang/Integer;Z)V", "batchCount", "id", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "isBatch", "markTryOnce$record_debug", "()V", "markTryOnce", "getTryCount$record_debug", "()I", "getTryCount", "shouldTryAgain$record_debug", "()Lkotlin/Pair;", "shouldTryAgain", "allDoneForOneTry$record_debug", "()Z", "allDoneForOneTry", "Lwx4/d;", "getStatisticById", "value", "_recordKey", "Ljava/lang/String;", "get_recordKey", "()Ljava/lang/String;", "set_recordKey", "(Ljava/lang/String;)V", "_descWithoutAppearanceKey$delegate", "Lkotlin/Lazy;", "get_descWithoutAppearanceKey", "_descWithoutAppearanceKey", "_descWithAppearanceKey", "Lcom/tencent/zplan/meme/model/BusinessConfig;", DownloadInfo.spKey_Config, "Lcom/tencent/zplan/meme/model/BusinessConfig;", "getConfig", "()Lcom/tencent/zplan/meme/model/BusinessConfig;", "setConfig", "(Lcom/tencent/zplan/meme/model/BusinessConfig;)V", "", "frameTime", UserInfo.SEX_FEMALE, "getFrameTime", "()F", "setFrameTime", "(F)V", "Lcom/tencent/zplan/meme/action/ActionStatus;", "<set-?>", "actionStatus$delegate", "Lkotlin/properties/ReadWriteProperty;", "getActionStatus", "()Lcom/tencent/zplan/meme/action/ActionStatus;", "setActionStatus", "(Lcom/tencent/zplan/meme/action/ActionStatus;)V", HiHealthActivities.EXTRA_ACTION_STATUS, "taskId$delegate", "getTaskId", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "I", "getRecordDoneCount", "setRecordDoneCount", "(I)V", "tryCount", "statistic$delegate", "getStatistic", "()Lwx4/d;", "statistic", "recorder", "Lcom/tencent/zplan/meme/recorder/a;", "getRecorder", "()Lcom/tencent/zplan/meme/recorder/a;", "setRecorder", "(Lcom/tencent/zplan/meme/recorder/a;)V", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "Lcom/tencent/zplan/meme/action/MODE;", "getMode", "()Lcom/tencent/zplan/meme/action/MODE;", "getActionId", "actionId", "getName", "name", "getWidth", "width", "getHeight", "height", "getDesc", "desc", "<init>", "(Lcom/tencent/zplan/meme/action/MODE;)V", "Companion", "Cache", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public abstract class MemeAction {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(MemeAction.class, HiHealthActivities.EXTRA_ACTION_STATUS, "getActionStatus()Lcom/tencent/zplan/meme/action/ActionStatus;", 0))};

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy MAX_TRY_COUNT$delegate;

    @NotNull
    public static final String TAG = "[zplan][MemePlayer-Action]";
    private static final int TASK_ID_START;

    @NotNull
    private static final AtomicInteger taskIdGenerator;
    private String _descWithAppearanceKey;

    /* renamed from: _descWithoutAppearanceKey$delegate, reason: from kotlin metadata */
    private final Lazy _descWithoutAppearanceKey;

    @Nullable
    private volatile String _recordKey;

    /* renamed from: actionStatus$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty actionStatus;

    @NotNull
    private BusinessConfig config;
    private float frameTime;

    @NotNull
    private final MODE mode;
    private volatile int recordDoneCount;

    @Nullable
    private volatile a recorder;

    /* renamed from: statistic$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy statistic;

    /* renamed from: taskId$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy taskId;
    private volatile int tryCount;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/zplan/meme/action/MemeAction$Cache;", "", "portraitId", "", "result", "Lcom/tencent/zplan/meme/model/MemeResult;", "(ILcom/tencent/zplan/meme/model/MemeResult;)V", "getPortraitId", "()I", "getResult", "()Lcom/tencent/zplan/meme/model/MemeResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final /* data */ class Cache {
        private final int portraitId;

        @NotNull
        private final MemeResult result;

        public Cache(int i3, @NotNull MemeResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.portraitId = i3;
            this.result = result;
        }

        public static /* synthetic */ Cache copy$default(Cache cache, int i3, MemeResult memeResult, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = cache.portraitId;
            }
            if ((i16 & 2) != 0) {
                memeResult = cache.result;
            }
            return cache.copy(i3, memeResult);
        }

        /* renamed from: component1, reason: from getter */
        public final int getPortraitId() {
            return this.portraitId;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final MemeResult getResult() {
            return this.result;
        }

        @NotNull
        public final Cache copy(int portraitId, @NotNull MemeResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            return new Cache(portraitId, result);
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof Cache) {
                    Cache cache = (Cache) other;
                    if (this.portraitId != cache.portraitId || !Intrinsics.areEqual(this.result, cache.result)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public final int getPortraitId() {
            return this.portraitId;
        }

        @NotNull
        public final MemeResult getResult() {
            return this.result;
        }

        public int hashCode() {
            int i3;
            int i16 = this.portraitId * 31;
            MemeResult memeResult = this.result;
            if (memeResult != null) {
                i3 = memeResult.hashCode();
            } else {
                i3 = 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "Cache(portraitId=" + this.portraitId + ", result=" + this.result + ")";
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/zplan/meme/action/MemeAction$Companion;", "", "()V", "MAX_TRY_COUNT", "", "getMAX_TRY_COUNT", "()I", "MAX_TRY_COUNT$delegate", "Lkotlin/Lazy;", "TAG", "", "TASK_ID_START", "getTASK_ID_START", "taskIdGenerator", "Ljava/util/concurrent/atomic/AtomicInteger;", "getTaskIdGenerator", "()Ljava/util/concurrent/atomic/AtomicInteger;", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        public final int getMAX_TRY_COUNT() {
            return ((Number) MemeAction.MAX_TRY_COUNT$delegate.getValue()).intValue();
        }

        public final int getTASK_ID_START() {
            return MemeAction.TASK_ID_START;
        }

        @NotNull
        public final AtomicInteger getTaskIdGenerator() {
            return MemeAction.taskIdGenerator;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int taskIdStartFrom = Meme.f385754h.k().getTaskIdStartFrom();
        TASK_ID_START = taskIdStartFrom;
        taskIdGenerator = new AtomicInteger(taskIdStartFrom);
        MAX_TRY_COUNT$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.tencent.zplan.meme.action.MemeAction$Companion$MAX_TRY_COUNT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return Meme.f385754h.k().getMaxRetryCount();
            }
        });
    }

    public MemeAction(@NotNull MODE mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.mode = mode;
        this._descWithoutAppearanceKey = LazyKt.lazy(new Function0<String>() { // from class: com.tencent.zplan.meme.action.MemeAction$_descWithoutAppearanceKey$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return '[' + MemeAction.this.getIdDesc() + ", name:" + MemeAction.this.getName() + ", key:**late init**, class:" + MemeAction.this.getClass().getSimpleName() + ", mode:" + MemeAction.this.getMode() + ']';
            }
        });
        this.config = new BusinessConfig(0, false, false, false, null, 0, null, null, null, null, null, null, null, false, null, 0, null, 131071, null);
        this.frameTime = (float) 0.1d;
        Delegates delegates = Delegates.INSTANCE;
        final INIT init = INIT.INSTANCE;
        this.actionStatus = new ObservableProperty<ActionStatus>(init) { // from class: com.tencent.zplan.meme.action.MemeAction$$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(@NotNull KProperty<?> property, ActionStatus oldValue, ActionStatus newValue) {
                d a16;
                Intrinsics.checkNotNullParameter(property, "property");
                ActionStatus actionStatus = newValue;
                ActionStatus actionStatus2 = oldValue;
                if ((!Intrinsics.areEqual(actionStatus, actionStatus2)) && (a16 = LogUtil.f385285b.a()) != null) {
                    d.a.c(a16, MemeAction.TAG, 1, this.getDesc() + " actionStatus change from:" + actionStatus2 + " to:" + actionStatus, null, 8, null);
                }
            }
        };
        this.taskId = LazyKt.lazy(new Function0<Integer>() { // from class: com.tencent.zplan.meme.action.MemeAction$taskId$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return MemeAction.INSTANCE.getTaskIdGenerator().getAndIncrement();
            }
        });
        this.statistic = LazyKt.lazy(new Function0<wx4.d>() { // from class: com.tencent.zplan.meme.action.MemeAction$statistic$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final wx4.d invoke() {
                return new wx4.d(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0, 0L, 0L, MemeAction.this.getWidth(), MemeAction.this.getHeight(), MemeAction.this.getMode(), MemeAction.this.isBatch(), null, false, 0, false, MemeAction.this.getConfig().getAaType(), MemeAction.this.getConfig().getAaLevel(), 0, MemeAction.this.getConfig().getTargetEngine(), 2590719, null);
            }
        });
    }

    private final String get_descWithoutAppearanceKey() {
        return (String) this._descWithoutAppearanceKey.getValue();
    }

    public boolean allDoneForOneTry$record_debug() {
        if (this.recordDoneCount == batchCount()) {
            return true;
        }
        return false;
    }

    public abstract int batchCount();

    public boolean checkResource(@NotNull c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return true;
    }

    public abstract boolean checkResource(@NotNull String uin, @NotNull c listener);

    public abstract boolean clearCache(int id5);

    public abstract int getActionId();

    @NotNull
    public final ActionStatus getActionStatus() {
        return (ActionStatus) this.actionStatus.getValue(this, $$delegatedProperties[0]);
    }

    @Nullable
    public abstract List<Cache> getCachedFiles();

    @NotNull
    public final BusinessConfig getConfig() {
        return this.config;
    }

    @NotNull
    public final String getDesc() {
        if (this._recordKey != null) {
            String str = this._descWithAppearanceKey;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("_descWithAppearanceKey");
                return str;
            }
            return str;
        }
        return get_descWithoutAppearanceKey();
    }

    public final float getFrameTime() {
        return this.frameTime;
    }

    public abstract int getHeight();

    @NotNull
    public abstract String getIdDesc();

    @NotNull
    public abstract String getKey();

    @NotNull
    public MODE getMode() {
        return this.mode;
    }

    @NotNull
    public abstract String getName();

    @Nullable
    public abstract String getReceiverUin();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getRecordDoneCount() {
        return this.recordDoneCount;
    }

    @Nullable
    public final a getRecorder() {
        return this.recorder;
    }

    @Nullable
    public Class<a> getRecorderClazz() {
        EngineType targetEngine = this.config.getTargetEngine();
        if (targetEngine != null) {
            return targetEngine.a();
        }
        return null;
    }

    @Nullable
    public abstract String getSenderUin();

    @NotNull
    public abstract String getSingleActionKey(int portraitId);

    @NotNull
    public final wx4.d getStatistic() {
        return (wx4.d) this.statistic.getValue();
    }

    @NotNull
    public wx4.d getStatisticById(int id5) {
        return getStatistic();
    }

    public final int getTaskId() {
        return ((Number) this.taskId.getValue()).intValue();
    }

    /* renamed from: getTryCount$record_debug, reason: from getter */
    public final int getTryCount() {
        return this.tryCount;
    }

    @NotNull
    public abstract Meme.Type getType();

    public abstract int getWidth();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final String get_recordKey() {
        return this._recordKey;
    }

    public boolean isAppearanceKeyMatch(@NotNull String uin, @NotNull String appearanceKey) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        return true;
    }

    public abstract boolean isBatch();

    public abstract boolean isDoubleSpriteTask();

    public abstract void markOneRecordDone(@Nullable Integer portraitId, boolean success);

    public void markTryOnce$record_debug() {
        this.tryCount++;
        this.recordDoneCount = 0;
    }

    public final int recordDoneCount() {
        return this.recordDoneCount;
    }

    public void resetRecordKey$record_debug(@NotNull String uin, @NotNull String appearanceKey) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
    }

    @NotNull
    public abstract Pair<Boolean, MemeResult> saveCacheFiles(@NotNull MemeResult result);

    @NotNull
    public abstract Pair<Boolean, MemeResult> saveCoverCacheFiles(@NotNull MemeResult result);

    public final void setActionStatus(@NotNull ActionStatus actionStatus) {
        Intrinsics.checkNotNullParameter(actionStatus, "<set-?>");
        this.actionStatus.setValue(this, $$delegatedProperties[0], actionStatus);
    }

    public final void setConfig(@NotNull BusinessConfig businessConfig) {
        Intrinsics.checkNotNullParameter(businessConfig, "<set-?>");
        this.config = businessConfig;
    }

    public final void setFrameTime(float f16) {
        this.frameTime = f16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setRecordDoneCount(int i3) {
        this.recordDoneCount = i3;
    }

    public final void setRecorder(@Nullable a aVar) {
        this.recorder = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void set_recordKey(@Nullable String str) {
        this._recordKey = str;
        this._descWithAppearanceKey = '[' + getIdDesc() + ", name:" + getName() + ", key:" + str + ", class:" + getClass().getSimpleName() + ", mode:" + getMode() + ']';
    }

    @NotNull
    public Pair<Boolean, Boolean> shouldTryAgain$record_debug() {
        boolean z16;
        if (getActionStatus().needRetry() && getTryCount() < INSTANCE.getMAX_TRY_COUNT()) {
            z16 = true;
        } else {
            z16 = false;
        }
        return new Pair<>(Boolean.valueOf(z16), Boolean.TRUE);
    }
}
