package com.tencent.zplan.meme.recorder;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.common.utils.g;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.Scheduler;
import com.tencent.zplan.meme.action.ActionStatus;
import com.tencent.zplan.meme.action.COMPLETE;
import com.tencent.zplan.meme.action.ERROR_APPEARANCEKEY_CHANGE;
import com.tencent.zplan.meme.action.ERROR_ENGINE_RECORD_FAIL;
import com.tencent.zplan.meme.action.INTERRUPT;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.action.RECORD_COMPLETE;
import com.tencent.zplan.meme.action.START;
import com.tencent.zplan.meme.action.SUB_COMPLETE;
import com.tencent.zplan.meme.model.MemeFrame;
import com.tencent.zplan.meme.model.MemeResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
import lx4.f;
import org.apache.httpcore.message.TokenParser;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 a2\u00020\u0001:\u0002.2B\u000f\u0012\u0006\u0010^\u001a\u00020[\u00a2\u0006\u0004\b_\u0010`J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J(\u0010\u0011\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\tH\u0002J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0016\u0010\u0015\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J,\u0010\u001a\u001a\u00020\u00052\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J&\u0010\u001b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J,\u0010\u001c\u001a\u00020\u00052\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\tH\u0002J\u001e\u0010%\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#J\u000e\u0010&\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0003J\u0016\u0010'\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!J\u0016\u0010(\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bJ\u0006\u0010)\u001a\u00020\u0005R\u0014\u0010,\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000e078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00109R&\u0010@\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R&\u0010B\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020#070=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010?R \u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u00109R&\u0010F\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010?R \u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR+\u0010Z\u001a\u00020\t2\u0006\u0010S\u001a\u00020\t8@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]\u00a8\u0006b"}, d2 = {"Lcom/tencent/zplan/meme/recorder/MemeRecordQueue;", "", "Lcom/tencent/zplan/meme/recorder/MemeRecordQueue$c;", "Lcom/tencent/zplan/meme/action/MemeAction;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "J", "D", BdhLogUtil.LogTag.Tag_Conn, "", "B", "", "key", "v", "Lcom/tencent/zplan/meme/recorder/a;", "recorder", "addListener", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "K", "M", "r", "", VideoTemplateParser.ITEM_LIST, "uin", "appearanceKey", "u", "L", "t", HippyTKDListViewAdapter.X, "y", "E", "action", "Lcom/tencent/zplan/meme/Priority;", "priority", "Lcom/tencent/zplan/meme/a;", "listener", "G", ReportConstant.COSTREPORT_PREFIX, "O", UserInfo.SEX_FEMALE, "w", "a", "Ljava/lang/String;", "TAG", "Ljava/util/concurrent/locks/ReentrantLock;", "b", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "Llx4/f;", "c", "Lkotlin/Lazy;", "getThreadPool", "()Llx4/f;", "threadPool", "", "d", "Ljava/util/List;", "idleRecorders", "e", "activeRecorders", "", "f", "Ljava/util/Map;", "recorderActionMap", "g", "recorderKeyListenerMap", h.F, "waitingDoneRecords", "i", "waitingResourceDownload", "Ljava/util/PriorityQueue;", "j", "Ljava/util/PriorityQueue;", "recordActionQueue", "Ljava/util/concurrent/atomic/AtomicInteger;", "k", "Ljava/util/concurrent/atomic/AtomicInteger;", "prioritySequenceGenerator", "Lcom/tencent/zplan/meme/Scheduler;", "l", "Lcom/tencent/zplan/meme/Scheduler;", "queueStateScheduler", "<set-?>", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/properties/ReadWriteProperty;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Z", "N", "(Z)V", "pauseQueue", "Lcom/tencent/zplan/meme/Meme$Type;", DomainData.DOMAIN_NAME, "Lcom/tencent/zplan/meme/Meme$Type;", "type", "<init>", "(Lcom/tencent/zplan/meme/Meme$Type;)V", "p", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class MemeRecordQueue {

    /* renamed from: o, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f385924o = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(MemeRecordQueue.class, "pauseQueue", "getPauseQueue$record_debug()Z", 0))};

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private static final b f385925p = new b(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ReentrantLock lock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy threadPool;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<com.tencent.zplan.meme.recorder.a> idleRecorders;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List<com.tencent.zplan.meme.recorder.a> activeRecorders;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Map<com.tencent.zplan.meme.recorder.a, c<MemeAction>> recorderActionMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Map<String, List<com.tencent.zplan.meme.a>> recorderKeyListenerMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final List<c<MemeAction>> waitingDoneRecords;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Map<String, c<MemeAction>> waitingResourceDownload;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final PriorityQueue<c<MemeAction>> recordActionQueue;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger prioritySequenceGenerator;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final Scheduler queueStateScheduler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReadWriteProperty pauseQueue;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final Meme.Type type;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a extends ObservableProperty<Boolean> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f385940b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MemeRecordQueue f385941c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, Object obj2, MemeRecordQueue memeRecordQueue) {
            super(obj2);
            this.f385940b = obj;
            this.f385941c = memeRecordQueue;
        }

        @Override // kotlin.properties.ObservableProperty
        protected void afterChange(@NotNull KProperty<?> property, Boolean oldValue, Boolean newValue) {
            lx4.d a16;
            Intrinsics.checkNotNullParameter(property, "property");
            boolean booleanValue = newValue.booleanValue();
            boolean booleanValue2 = oldValue.booleanValue();
            if (booleanValue != booleanValue2 && (a16 = LogUtil.f385285b.a()) != null) {
                d.a.c(a16, this.f385941c.TAG, 1, "pauseQueue from:" + booleanValue2 + " to:" + booleanValue, null, 8, null);
            }
            if (!booleanValue) {
                this.f385941c.M();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/zplan/meme/recorder/MemeRecordQueue$b;", "", "", "CHECK_RESOURCE_MAX_COUNT", "I", "", "PROGRESS_WITH_CACHE", UserInfo.SEX_FEMALE, "RECORDER_NUM_THRESHOLD", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b {
        b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a8\u0006\u0017"}, d2 = {"com/tencent/zplan/meme/recorder/MemeRecordQueue$d", "Lcom/tencent/zplan/meme/d;", "Lcom/tencent/zplan/meme/action/MemeAction;", "action", "", "recordKey", "Lcom/tencent/zplan/meme/action/ActionStatus;", "status", "", "kg", "", "success", "Lcom/tencent/zplan/meme/model/MemeResult;", "result", "l9", "cover", "ad", "Lcom/tencent/zplan/meme/model/c;", AIInput.KEY_FRAME, "Z1", "", "currProgress", "d3", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class d implements com.tencent.zplan.meme.d {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f385953e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.zplan.meme.recorder.a f385954f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f385955h;

        d(c cVar, com.tencent.zplan.meme.recorder.a aVar, String str) {
            this.f385953e = cVar;
            this.f385954f = aVar;
            this.f385955h = str;
        }

        @Override // com.tencent.zplan.meme.b
        public void Z1(@NotNull MemeFrame frame) {
            List<com.tencent.zplan.meme.a> list;
            Intrinsics.checkNotNullParameter(frame, "frame");
            if (!this.f385953e.o() && (list = (List) MemeRecordQueue.this.recorderKeyListenerMap.get(this.f385955h)) != null) {
                for (com.tencent.zplan.meme.a aVar : list) {
                    if (aVar instanceof com.tencent.zplan.meme.b) {
                        ((com.tencent.zplan.meme.b) aVar).Z1(frame);
                    }
                }
            }
        }

        @Override // com.tencent.zplan.meme.b
        public void ad(boolean success, @NotNull MemeResult cover) {
            List<com.tencent.zplan.meme.a> list;
            Intrinsics.checkNotNullParameter(cover, "cover");
            Pair<Boolean, MemeResult> saveCoverCacheFiles = cover.getAction().saveCoverCacheFiles(cover);
            boolean booleanValue = saveCoverCacheFiles.component1().booleanValue();
            MemeResult component2 = saveCoverCacheFiles.component2();
            if (!this.f385953e.o() && (list = (List) MemeRecordQueue.this.recorderKeyListenerMap.get(this.f385955h)) != null) {
                for (com.tencent.zplan.meme.a aVar : list) {
                    if (aVar instanceof com.tencent.zplan.meme.b) {
                        ((com.tencent.zplan.meme.b) aVar).ad(booleanValue, component2);
                    }
                }
            }
        }

        @Override // com.tencent.zplan.meme.a
        public void d3(@NotNull MemeAction action, float currProgress) {
            List list;
            Intrinsics.checkNotNullParameter(action, "action");
            if (!this.f385953e.o() && (list = (List) MemeRecordQueue.this.recorderKeyListenerMap.get(this.f385955h)) != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((com.tencent.zplan.meme.a) it.next()).d3(action, currProgress);
                }
            }
        }

        @Override // com.tencent.zplan.meme.d
        public void kg(@NotNull MemeAction action, @NotNull String recordKey, @NotNull ActionStatus status) {
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(recordKey, "recordKey");
            Intrinsics.checkNotNullParameter(status, "status");
            if (Intrinsics.areEqual(status, START.INSTANCE)) {
                lx4.d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.d(a16, MemeRecordQueue.this.TAG, 1, "onActionStatusChange " + action.getDesc() + " state change to " + status, null, 8, null);
                    return;
                }
                return;
            }
            if (status.isEndState()) {
                LogUtil logUtil = LogUtil.f385285b;
                lx4.d a17 = logUtil.a();
                if (a17 != null) {
                    d.a.d(a17, MemeRecordQueue.this.TAG, 1, "recordAction " + action.getDesc() + " state change to " + status, null, 8, null);
                }
                if ((Intrinsics.areEqual(status, INTERRUPT.INSTANCE) || Intrinsics.areEqual(status, COMPLETE.INSTANCE)) && !action.isBatch()) {
                    ReentrantLock reentrantLock = MemeRecordQueue.this.lock;
                    reentrantLock.lock();
                    try {
                        if (!MemeRecordQueue.this.waitingDoneRecords.contains(this.f385953e)) {
                            MemeRecordQueue.this.waitingDoneRecords.add(this.f385953e);
                        }
                        Unit unit = Unit.INSTANCE;
                    } finally {
                        reentrantLock.unlock();
                    }
                }
                com.tencent.zplan.meme.recorder.a recorder = action.getRecorder();
                if (action.allDoneForOneTry$record_debug() && recorder != null) {
                    lx4.d a18 = logUtil.a();
                    if (a18 != null) {
                        d.a.d(a18, MemeRecordQueue.this.TAG, 1, "onActionStatusChange " + action.getDesc() + " all done and release recorder:" + recorder, null, 8, null);
                    }
                    MemeRecordQueue.this.K(recorder);
                    action.setRecorder(null);
                }
            }
        }

        @Override // com.tencent.zplan.meme.a
        public void l9(boolean success, @NotNull MemeResult result) {
            Pair<Boolean, MemeResult> saveCacheFiles;
            List list;
            Integer num;
            int reportErrorCode;
            Intrinsics.checkNotNullParameter(result, "result");
            ReentrantLock reentrantLock = MemeRecordQueue.this.lock;
            reentrantLock.lock();
            try {
                MemeAction action = result.getAction();
                ActionStatus actionStatus = action.getActionStatus();
                boolean cancel = this.f385953e.getCancel();
                if (this.f385953e.getAbortForAppearanceKeyChange()) {
                    com.tencent.zplan.common.utils.c.f385288a.g(result.getRecordPath());
                    result.a();
                    action.setActionStatus(ERROR_APPEARANCEKEY_CHANGE.INSTANCE);
                    saveCacheFiles = new Pair<>(Boolean.FALSE, result);
                } else {
                    saveCacheFiles = action.saveCacheFiles(result);
                }
                boolean booleanValue = saveCacheFiles.component1().booleanValue();
                MemeResult component2 = saveCacheFiles.component2();
                action.markOneRecordDone(result.d(), booleanValue);
                MemeRecordQueue.this.waitingDoneRecords.remove(this.f385953e);
                Pair<Boolean, Boolean> shouldTryAgain$record_debug = action.shouldTryAgain$record_debug();
                boolean booleanValue2 = shouldTryAgain$record_debug.component1().booleanValue();
                boolean booleanValue3 = shouldTryAgain$record_debug.component2().booleanValue();
                if (!cancel && booleanValue2) {
                    if (booleanValue3) {
                        lx4.d a16 = LogUtil.f385285b.a();
                        if (a16 != null) {
                            d.a.d(a16, MemeRecordQueue.this.TAG, 1, "try again for " + this.f385953e.i().getDesc() + " on " + actionStatus + " fail reason", null, 8, null);
                        }
                        MemeRecordQueue.this.H(this.f385953e, this.f385954f, false);
                    } else {
                        lx4.d a17 = LogUtil.f385285b.a();
                        if (a17 != null) {
                            d.a.d(a17, MemeRecordQueue.this.TAG, 1, "waiting again for " + this.f385953e.i().getDesc() + " on " + actionStatus + " fail reason", null, 8, null);
                        }
                    }
                    return;
                }
                boolean allDoneForOneTry$record_debug = action.allDoneForOneTry$record_debug();
                if (allDoneForOneTry$record_debug) {
                    list = (List) MemeRecordQueue.this.recorderKeyListenerMap.remove(this.f385955h);
                } else {
                    list = (List) MemeRecordQueue.this.recorderKeyListenerMap.get(this.f385955h);
                }
                wx4.d i3 = component2.i();
                if (i3 != null) {
                    if (Intrinsics.areEqual(action.getActionStatus(), ERROR_ENGINE_RECORD_FAIL.INSTANCE)) {
                        reportErrorCode = i3.getScriptErrorCode();
                    } else {
                        reportErrorCode = action.getActionStatus().toReportErrorCode();
                    }
                    i3.t(reportErrorCode);
                }
                String str = this.f385955h;
                if (action.isBatch() && allDoneForOneTry$record_debug) {
                    actionStatus = COMPLETE.INSTANCE;
                }
                kg(action, str, actionStatus);
                lx4.d a18 = LogUtil.f385285b.a();
                if (a18 != null) {
                    String str2 = MemeRecordQueue.this.TAG;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("recordAction recordDone ");
                    sb5.append(this.f385953e);
                    sb5.append(", currentId:");
                    sb5.append(result.d());
                    sb5.append(" success:");
                    sb5.append(booleanValue);
                    sb5.append(", allDone:");
                    sb5.append(allDoneForOneTry$record_debug);
                    sb5.append(", ");
                    sb5.append("path:");
                    sb5.append(component2.getRecordPath());
                    sb5.append(", frame size:");
                    sb5.append(component2.f().size());
                    sb5.append(", listeners size:");
                    if (list != null) {
                        num = Integer.valueOf(list.size());
                    } else {
                        num = null;
                    }
                    sb5.append(num);
                    sb5.append(", canceled: ");
                    sb5.append(cancel);
                    d.a.d(a18, str2, 1, sb5.toString(), null, 8, null);
                }
                this.f385953e.p(booleanValue, component2);
                if (cancel) {
                    return;
                }
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((com.tencent.zplan.meme.a) it.next()).l9(booleanValue, component2);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public MemeRecordQueue(@NotNull Meme.Type type) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        String str = "[zplan][MemePlayer-SDK][MemeRecordQueue-" + type + ']';
        this.TAG = str;
        this.lock = new ReentrantLock();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<f>() { // from class: com.tencent.zplan.meme.recorder.MemeRecordQueue$threadPool$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final f invoke() {
                Object a16 = mx4.a.f417748a.a(f.class);
                Intrinsics.checkNotNull(a16);
                return (f) a16;
            }
        });
        this.threadPool = lazy;
        this.idleRecorders = new ArrayList();
        this.activeRecorders = new ArrayList();
        this.recorderActionMap = new LinkedHashMap();
        this.recorderKeyListenerMap = new LinkedHashMap();
        this.waitingDoneRecords = new ArrayList();
        this.waitingResourceDownload = new LinkedHashMap();
        this.recordActionQueue = new PriorityQueue<>();
        this.prioritySequenceGenerator = new AtomicInteger(0);
        this.queueStateScheduler = new Scheduler(10000L, new Function0<Boolean>() { // from class: com.tencent.zplan.meme.recorder.MemeRecordQueue$queueStateScheduler$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                boolean E;
                List list;
                List list2;
                String y16;
                E = MemeRecordQueue.this.E();
                if (!E) {
                    String str2 = MemeRecordQueue.this.A() ? "Paused \u23f8\ufe0f" : "Running \u23e9";
                    d a16 = LogUtil.f385285b.a();
                    if (a16 != null) {
                        String str3 = MemeRecordQueue.this.TAG;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("MemeQueueState[");
                        sb5.append(str2);
                        sb5.append("]\n ");
                        y16 = MemeRecordQueue.this.y();
                        sb5.append(y16);
                        d.a.b(a16, str3, 1, sb5.toString(), null, 8, null);
                    }
                }
                if (E) {
                    d a17 = LogUtil.f385285b.a();
                    if (a17 != null) {
                        d.a.d(a17, MemeRecordQueue.this.TAG, 1, "try destroy on everything done", null, 8, null);
                    }
                    MemeRecordQueue.this.x();
                    list = MemeRecordQueue.this.idleRecorders;
                    list.clear();
                    list2 = MemeRecordQueue.this.activeRecorders;
                    list2.clear();
                }
                return !E;
            }
        });
        Delegates delegates = Delegates.INSTANCE;
        Boolean bool = Boolean.FALSE;
        this.pauseQueue = new a(bool, bool, this);
        lx4.d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.d(a16, str, 1, "create new MemeRecordQueue", null, 8, null);
        }
    }

    private final boolean B(c<? extends MemeAction> item) {
        boolean z16;
        ActionStatus actionStatus;
        MemeAction i3 = item.i();
        List<MemeAction.Cache> cachedFiles = i3.getCachedFiles();
        List<MemeAction.Cache> list = cachedFiles;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        for (MemeAction.Cache cache : cachedFiles) {
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.d(a16, this.TAG, 1, "recordAction " + item.i().getDesc() + " success from cache:" + cache, null, 8, null);
            }
            i3.markOneRecordDone(cache.getResult().d(), true);
            if (i3.isBatch()) {
                if (i3.recordDoneCount() == i3.batchCount()) {
                    actionStatus = RECORD_COMPLETE.INSTANCE;
                } else {
                    actionStatus = SUB_COMPLETE.INSTANCE;
                }
            } else {
                actionStatus = RECORD_COMPLETE.INSTANCE;
            }
            i3.setActionStatus(actionStatus);
            wx4.d i16 = cache.getResult().i();
            if (i16 != null) {
                i16.x(true);
            }
            item.getListener().d3(cache.getResult().getAction(), 100.0f);
            item.getListener().l9(true, cache.getResult());
        }
        if (i3.recordDoneCount() != i3.batchCount()) {
            return false;
        }
        return true;
    }

    private final void C(c<? extends MemeAction> item) {
        if (B(item)) {
            return;
        }
        lx4.d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.d(a16, this.TAG, 1, "add batch action to record queue, " + item.i().getDesc() + ", priority:" + item.getPriority(), null, 8, null);
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.recordActionQueue.offer(item);
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void D(c<? extends MemeAction> item) {
        Object obj;
        Map.Entry<com.tencent.zplan.meme.recorder.a, c<MemeAction>> next;
        if (B(item)) {
            return;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            String key = item.i().getKey();
            Iterator<Map.Entry<com.tencent.zplan.meme.recorder.a, c<MemeAction>>> it = this.recorderActionMap.entrySet().iterator();
            do {
                if (it.hasNext()) {
                    next = it.next();
                } else {
                    for (c<MemeAction> cVar : this.waitingDoneRecords) {
                        if (Intrinsics.areEqual(cVar.i().getKey(), key)) {
                            lx4.d a16 = LogUtil.f385285b.a();
                            if (a16 != null) {
                                d.a.d(a16, this.TAG, 1, "recordAction " + cVar.i().getDesc() + ", already in waiting encode", null, 8, null);
                            }
                            cVar.r(false);
                            r(cVar);
                            return;
                        }
                    }
                    Iterator<T> it5 = this.recordActionQueue.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            obj = it5.next();
                            if (Intrinsics.areEqual(((c) obj).i().getKey(), key)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    c<MemeAction> cVar2 = (c) obj;
                    if (cVar2 != null) {
                        lx4.d a17 = LogUtil.f385285b.a();
                        if (a17 != null) {
                            d.a.c(a17, this.TAG, 1, "recordAction " + item.i().getDesc() + ", already in record queue", null, 8, null);
                        }
                        r(item);
                        if (item.getPriority().compareTo(cVar2.getPriority()) > 0) {
                            this.recordActionQueue.remove(cVar2);
                            cVar2.u(item.getPriority());
                            this.recordActionQueue.offer(cVar2);
                        } else {
                            this.recordActionQueue.remove(cVar2);
                            this.recordActionQueue.offer(cVar2);
                        }
                        return;
                    }
                    if (item.getNeedCheckResource() && (this.waitingResourceDownload.containsKey(key) || !v(key, item))) {
                        if (!this.waitingResourceDownload.containsKey(key)) {
                            this.waitingResourceDownload.put(key, item);
                        }
                        r(item);
                        return;
                    }
                    lx4.d a18 = LogUtil.f385285b.a();
                    if (a18 != null) {
                        d.a.d(a18, this.TAG, 1, "add action to record queue, " + item.i().getDesc() + ", priority:" + item.getPriority(), null, 8, null);
                    }
                    this.recordActionQueue.offer(item);
                    return;
                }
            } while (!Intrinsics.areEqual(next.getValue().i().getKey(), key));
            lx4.d a19 = LogUtil.f385285b.a();
            if (a19 != null) {
                d.a.d(a19, this.TAG, 1, "recordAction " + item.i().getDesc() + ", already in recording", null, 8, null);
            }
            next.getValue().r(false);
            r(item);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean E() {
        boolean z16;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.recorderActionMap.isEmpty() && this.waitingDoneRecords.isEmpty() && this.recordActionQueue.isEmpty()) {
                if (this.waitingResourceDownload.isEmpty()) {
                    z16 = true;
                    return z16;
                }
            }
            z16 = false;
            return z16;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(final c<? extends MemeAction> item, final com.tencent.zplan.meme.recorder.a recorder, boolean addListener) {
        final String key = item.i().getKey();
        final d dVar = new d(item, recorder, key);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.recorderActionMap.put(recorder, item);
            if (addListener) {
                r(item);
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            final MemeAction i3 = item.i();
            i3.markTryOnce$record_debug();
            wx4.d statistic = i3.getStatistic();
            Meme meme = Meme.f385754h;
            statistic.E(meme.i());
            i3.setRecorder(recorder);
            meme.B(new Function0<Unit>() { // from class: com.tencent.zplan.meme.recorder.MemeRecordQueue$recordActionByRecorder$2
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
                    d a16 = LogUtil.f385285b.a();
                    if (a16 != null) {
                        d.a.d(a16, MemeRecordQueue.this.TAG, 1, "recordActionByRecorder, " + item + ", tryCount:" + i3.getTryCount() + ", player:" + recorder, null, 8, null);
                    }
                    a aVar = recorder;
                    Object a17 = mx4.a.f417748a.a(lx4.a.class);
                    Intrinsics.checkNotNull(a17);
                    aVar.recordAction(((lx4.a) a17).getContext(), i3, key, dVar);
                }
            });
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    static /* synthetic */ void I(MemeRecordQueue memeRecordQueue, c cVar, com.tencent.zplan.meme.recorder.a aVar, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        memeRecordQueue.H(cVar, aVar, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(c<? extends MemeAction> item) {
        if (item.i().isBatch()) {
            C(item);
        } else {
            D(item);
        }
        M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(com.tencent.zplan.meme.recorder.a recorder) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.recorderActionMap.remove(recorder);
            this.idleRecorders.add(recorder);
            this.activeRecorders.remove(recorder);
            M();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void L(c<? extends MemeAction> item, String uin, String appearanceKey) {
        MemeAction i3 = item.i();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            String key = i3.getKey();
            if (this.waitingResourceDownload.containsKey(key)) {
                this.waitingResourceDownload.remove(key);
                lx4.d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.d(a16, this.TAG, 1, "checkAndResetAppearanceKey waitingResourceDownload remove " + key + TokenParser.SP, null, 8, null);
                }
            }
            if (this.recordActionQueue.contains(item)) {
                this.recordActionQueue.remove(item);
                lx4.d a17 = LogUtil.f385285b.a();
                if (a17 != null) {
                    d.a.d(a17, this.TAG, 1, "checkAndResetAppearanceKey recordActionQueue remove " + item.i().getDesc() + TokenParser.SP, null, 8, null);
                }
            }
            i3.resetRecordKey$record_debug(uin, appearanceKey);
            item.t(true);
            String key2 = i3.getKey();
            if (!this.waitingResourceDownload.containsKey(key2) && v(key2, item)) {
                Unit unit = Unit.INSTANCE;
                return;
            }
            if (!this.waitingResourceDownload.containsKey(key2)) {
                this.waitingResourceDownload.put(key2, item);
                lx4.d a18 = LogUtil.f385285b.a();
                if (a18 != null) {
                    d.a.d(a18, this.TAG, 1, "checkAndResetAppearanceKey waitingResourceDownload add " + item.i().getDesc() + TokenParser.SP, null, 8, null);
                }
            }
            r(item);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        c<MemeAction> peek;
        if (A()) {
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.d(a16, this.TAG, 1, "scheduleNextByPriority, record queue paused!!", null, 8, null);
                return;
            }
            return;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            try {
                peek = this.recordActionQueue.peek();
            } finally {
                reentrantLock.unlock();
            }
        } catch (NoSuchElementException unused) {
        }
        if (peek != null) {
            if (B(peek)) {
                this.recordActionQueue.poll();
                M();
                return;
            }
            com.tencent.zplan.meme.recorder.a z16 = z(peek);
            if (z16 != null) {
                this.recordActionQueue.poll();
                I(this, peek, z16, false, 4, null);
                return;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void r(c<? extends MemeAction> item) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            String key = item.i().getKey();
            if (!this.recorderKeyListenerMap.containsKey(key)) {
                this.recorderKeyListenerMap.put(key, new ArrayList());
            }
            List<com.tencent.zplan.meme.a> list = this.recorderKeyListenerMap.get(key);
            Intrinsics.checkNotNull(list);
            List<com.tencent.zplan.meme.a> list2 = list;
            if (!list2.contains(item.getListener())) {
                list2.add(item.getListener());
            }
            List<com.tencent.zplan.meme.a> list3 = list;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void t(List<? extends c<? extends MemeAction>> itemList, String uin, String appearanceKey) {
        for (c<? extends MemeAction> cVar : itemList) {
            if (!cVar.i().isAppearanceKeyMatch(uin, appearanceKey)) {
                cVar.q(true);
            }
        }
    }

    private final void u(List<? extends c<? extends MemeAction>> itemList, String uin, String appearanceKey) {
        for (c<? extends MemeAction> cVar : itemList) {
            MemeAction i3 = cVar.i();
            if (!i3.isAppearanceKeyMatch(uin, appearanceKey)) {
                if (i3.isBatch()) {
                    lx4.d a16 = LogUtil.f385285b.a();
                    if (a16 != null) {
                        d.a.c(a16, this.TAG, 1, "checkAndResetAppearanceKey batch record resetRecordKey " + cVar.i().getDesc() + TokenParser.SP, null, 8, null);
                    }
                    i3.resetRecordKey$record_debug(uin, appearanceKey);
                } else {
                    lx4.d a17 = LogUtil.f385285b.a();
                    if (a17 != null) {
                        d.a.c(a17, this.TAG, 1, "checkAndResetAppearanceKey single record resetRecordKeyAndRedownload " + cVar.i().getDesc() + TokenParser.SP, null, 8, null);
                    }
                    L(cVar, uin, appearanceKey);
                }
            }
        }
    }

    private final boolean v(String key, c<? extends MemeAction> item) {
        MemeAction i3 = item.i();
        MemeRecordQueue$checkResources$listener$1 memeRecordQueue$checkResources$listener$1 = new MemeRecordQueue$checkResources$listener$1(this, i3, item, key);
        item.s(item.getDoCheckResourceCount() + 1);
        boolean checkResource = i3.checkResource(memeRecordQueue$checkResources$listener$1);
        if (!checkResource) {
            i3.getStatistic().D(Meme.f385754h.i());
        }
        return checkResource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Iterator<com.tencent.zplan.meme.recorder.a> it = this.idleRecorders.iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
            Iterator<com.tencent.zplan.meme.recorder.a> it5 = this.activeRecorders.iterator();
            while (it5.hasNext()) {
                it5.next().onDestroy();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String y() {
        SortedSet<c> sortedSet;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            StringBuilder sb5 = new StringBuilder();
            if (!this.recorderActionMap.isEmpty()) {
                sb5.append("\u6b63\u5728\u5f55\u5236\u4e2d\u1f680..(total:" + this.recorderActionMap.size() + "), detail:\n");
                for (Map.Entry<com.tencent.zplan.meme.recorder.a, c<MemeAction>> entry : this.recorderActionMap.entrySet()) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(entry);
                    sb6.append('\n');
                    sb5.append(sb6.toString());
                }
            }
            if (!this.waitingDoneRecords.isEmpty()) {
                sb5.append("\u7b49\u5f85\u5408\u6210\u7ed3\u675f..(total:" + this.waitingDoneRecords.size() + "), detail:\n");
                Iterator<T> it = this.waitingDoneRecords.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(cVar);
                    sb7.append('\n');
                    sb5.append(sb7.toString());
                }
            }
            if (!this.recordActionQueue.isEmpty()) {
                sortedSet = CollectionsKt___CollectionsJvmKt.toSortedSet(this.recordActionQueue);
                sb5.append("\u961f\u5217\u6392\u961f\u4e2d..(total:" + this.recordActionQueue.size() + "), detail:\n");
                for (c cVar2 : sortedSet) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(cVar2);
                    sb8.append('\n');
                    sb5.append(sb8.toString());
                }
            }
            if (!this.waitingResourceDownload.isEmpty()) {
                sb5.append("\u7b49\u5f85\u8d44\u6e90\u4e0b\u8f7d..(total:" + this.waitingResourceDownload.size() + "), detail:\n");
                for (Map.Entry<String, c<MemeAction>> entry2 : this.waitingResourceDownload.entrySet()) {
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(entry2);
                    sb9.append('\n');
                    sb5.append(sb9.toString());
                }
            }
            String sb10 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb10, "StringBuilder().apply(builderAction).toString()");
            return sb10;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final com.tencent.zplan.meme.recorder.a z(c<? extends MemeAction> item) {
        Object obj;
        Object removeLast;
        Class<com.tencent.zplan.meme.recorder.a> recorderClazz = item.i().getRecorderClazz();
        final com.tencent.zplan.meme.recorder.a aVar = null;
        if (recorderClazz == null) {
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, this.TAG, 1, "getIdleRecorder error \u274c, no class for " + item.i().getDesc(), null, 8, null);
            }
            return null;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.idleRecorders.isEmpty()) {
                Iterator<T> it = this.idleRecorders.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((com.tencent.zplan.meme.recorder.a) obj).getClass(), recorderClazz)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                com.tencent.zplan.meme.recorder.a aVar2 = (com.tencent.zplan.meme.recorder.a) obj;
                if (aVar2 == null) {
                    try {
                        removeLast = CollectionsKt__MutableCollectionsKt.removeLast(this.idleRecorders);
                        aVar = (com.tencent.zplan.meme.recorder.a) removeLast;
                    } catch (NoSuchElementException unused) {
                    }
                    Meme.f385754h.C(new Function0<Unit>() { // from class: com.tencent.zplan.meme.recorder.MemeRecordQueue$getIdleRecorder$1$player$1
                        /* JADX INFO: Access modifiers changed from: package-private */
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
                            a aVar3 = a.this;
                            if (aVar3 != null) {
                                aVar3.onDestroy();
                            }
                        }
                    }, 500L);
                    aVar = (com.tencent.zplan.meme.recorder.a) g.f385293a.c(recorderClazz);
                } else {
                    this.idleRecorders.remove(aVar2);
                    aVar = aVar2;
                }
            } else if (this.activeRecorders.size() < 1) {
                aVar = (com.tencent.zplan.meme.recorder.a) g.f385293a.c(recorderClazz);
            }
            if (aVar != null) {
                this.activeRecorders.add(aVar);
            }
            return aVar;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean A() {
        return ((Boolean) this.pauseQueue.getValue(this, f385924o[0])).booleanValue();
    }

    public final void F(@NotNull String uin, @NotNull String appearanceKey) {
        List<? extends c<? extends MemeAction>> list;
        List<? extends c<? extends MemeAction>> list2;
        List<? extends c<? extends MemeAction>> list3;
        List<? extends c<? extends MemeAction>> list4;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        lx4.d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.c(a16, this.TAG, 1, "notifyAppearanceKeyChange uin:" + uin + ", appearanceKey:" + appearanceKey, null, 8, null);
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            list = CollectionsKt___CollectionsKt.toList(this.recordActionQueue);
            u(list, uin, appearanceKey);
            list2 = CollectionsKt___CollectionsKt.toList(this.waitingResourceDownload.values());
            u(list2, uin, appearanceKey);
            list3 = CollectionsKt___CollectionsKt.toList(this.recorderActionMap.values());
            t(list3, uin, appearanceKey);
            list4 = CollectionsKt___CollectionsKt.toList(this.waitingDoneRecords);
            t(list4, uin, appearanceKey);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void G(@NotNull MemeAction action, @NotNull Priority priority, @NotNull com.tencent.zplan.meme.a listener) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(listener, "listener");
        J(new c<>(action, priority, this.prioritySequenceGenerator.getAndIncrement(), false, 0, listener, 24, null));
        this.queueStateScheduler.g();
    }

    public final void N(boolean z16) {
        this.pauseQueue.setValue(this, f385924o[0], Boolean.valueOf(z16));
    }

    public final void O(@NotNull MemeAction action, @NotNull Priority priority) {
        c<MemeAction> cVar;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(priority, "priority");
        String key = action.getKey();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Iterator<c<MemeAction>> it = this.recordActionQueue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c<MemeAction> next = it.next();
                if (Intrinsics.areEqual(next.i().getKey(), key)) {
                    this.recordActionQueue.remove(next);
                    next.u(priority);
                    this.recordActionQueue.offer(next);
                    break;
                }
            }
            if (this.waitingResourceDownload.containsKey(key) && (cVar = this.waitingResourceDownload.get(key)) != null) {
                cVar.u(priority);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void s(@NotNull MemeAction action) {
        c<MemeAction> cVar;
        Intrinsics.checkNotNullParameter(action, "action");
        String key = action.getKey();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Iterator<c<MemeAction>> it = this.recordActionQueue.iterator();
            while (true) {
                if (it.hasNext()) {
                    cVar = it.next();
                    if (Intrinsics.areEqual(cVar.i().getKey(), key)) {
                        break;
                    }
                } else {
                    cVar = null;
                    break;
                }
            }
            if (cVar != null) {
                this.recordActionQueue.remove(cVar);
            }
            Iterator<Map.Entry<com.tencent.zplan.meme.recorder.a, c<MemeAction>>> it5 = this.recorderActionMap.entrySet().iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Map.Entry<com.tencent.zplan.meme.recorder.a, c<MemeAction>> next = it5.next();
                if (Intrinsics.areEqual(next.getValue().i().getKey(), key)) {
                    next.getValue().r(true);
                    break;
                }
            }
            Iterator<c<MemeAction>> it6 = this.waitingDoneRecords.iterator();
            while (true) {
                if (!it6.hasNext()) {
                    break;
                }
                c<MemeAction> next2 = it6.next();
                if (Intrinsics.areEqual(next2.i().getKey(), key)) {
                    next2.r(true);
                    break;
                }
            }
            this.waitingResourceDownload.remove(key);
            this.recorderKeyListenerMap.remove(key);
            reentrantLock.unlock();
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, this.TAG, 1, "cancelAction " + action.getDesc() + " \n currentActionStatus: " + y(), null, 8, null);
            }
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    public final void w() {
        lx4.d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.d(a16, this.TAG, 1, "clear!!", null, 8, null);
        }
        Meme.f385754h.B(new Function0<Unit>() { // from class: com.tencent.zplan.meme.recorder.MemeRecordQueue$clear$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                PriorityQueue priorityQueue;
                Map map;
                Map map2;
                ReentrantLock reentrantLock = MemeRecordQueue.this.lock;
                reentrantLock.lock();
                try {
                    priorityQueue = MemeRecordQueue.this.recordActionQueue;
                    priorityQueue.clear();
                    map = MemeRecordQueue.this.recorderActionMap;
                    map.clear();
                    MemeRecordQueue.this.recorderKeyListenerMap.clear();
                    MemeRecordQueue.this.waitingDoneRecords.clear();
                    map2 = MemeRecordQueue.this.waitingResourceDownload;
                    map2.clear();
                    Unit unit = Unit.INSTANCE;
                    reentrantLock.unlock();
                    MemeRecordQueue.this.x();
                } catch (Throwable th5) {
                    reentrantLock.unlock();
                    throw th5;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\b\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00000\u0003B;\u0012\u0006\u0010'\u001a\u00028\u0000\u0012\u0006\u0010.\u001a\u00020(\u0012\u0006\u00105\u001a\u00020\u0007\u0012\b\b\u0002\u00108\u001a\u00020\u0004\u0012\b\b\u0002\u0010<\u001a\u00020\u0007\u0012\u0006\u0010B\u001a\u00020=\u00a2\u0006\u0004\bC\u0010DJ\u0006\u0010\u0005\u001a\u00020\u0004J\u0017\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0096\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\t\u0010\u0010\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010'\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010$\u001a\u0004\b%\u0010&R\"\u0010.\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00105\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00108\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u0014\u001a\u0004\b/\u0010\u0016\"\u0004\b7\u0010\u0018R\"\u0010<\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u00100\u001a\u0004\b:\u00102\"\u0004\b;\u00104R\u0017\u0010B\u001a\u00020=8\u0006\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\u00a8\u0006E"}, d2 = {"Lcom/tencent/zplan/meme/recorder/MemeRecordQueue$c;", "Lcom/tencent/zplan/meme/action/MemeAction;", "T", "", "", "o", "other", "", "c", "", "toString", "success", "Lcom/tencent/zplan/meme/model/MemeResult;", "result", "", "p", "hashCode", "", "equals", "d", "Z", "j", "()Z", "r", "(Z)V", "cancel", "e", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "abortForAppearanceKeyChange", "Ljava/util/concurrent/atomic/AtomicBoolean;", "f", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getHasReport", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "hasReport", "Lcom/tencent/zplan/meme/action/MemeAction;", "i", "()Lcom/tencent/zplan/meme/action/MemeAction;", "action", "Lcom/tencent/zplan/meme/Priority;", "Lcom/tencent/zplan/meme/Priority;", DomainData.DOMAIN_NAME, "()Lcom/tencent/zplan/meme/Priority;", "u", "(Lcom/tencent/zplan/meme/Priority;)V", "priority", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "getSequence", "()I", "setSequence", "(I)V", "sequence", BdhLogUtil.LogTag.Tag_Conn, "t", "needCheckResource", "D", "k", ReportConstant.COSTREPORT_PREFIX, "doCheckResourceCount", "Lcom/tencent/zplan/meme/a;", "E", "Lcom/tencent/zplan/meme/a;", "l", "()Lcom/tencent/zplan/meme/a;", "listener", "<init>", "(Lcom/tencent/zplan/meme/action/MemeAction;Lcom/tencent/zplan/meme/Priority;IZILcom/tencent/zplan/meme/a;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final /* data */ class c<T extends MemeAction> implements Comparable<c<? extends MemeAction>> {

        /* renamed from: C, reason: from kotlin metadata */
        private boolean needCheckResource;

        /* renamed from: D, reason: from kotlin metadata */
        private int doCheckResourceCount;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final com.tencent.zplan.meme.a listener;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private volatile boolean cancel;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private volatile boolean abortForAppearanceKeyChange;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AtomicBoolean hasReport;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final T action;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Priority priority;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private int sequence;

        public c(@NotNull T action, @NotNull Priority priority, int i3, boolean z16, int i16, @NotNull com.tencent.zplan.meme.a listener) {
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(priority, "priority");
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.action = action;
            this.priority = priority;
            this.sequence = i3;
            this.needCheckResource = z16;
            this.doCheckResourceCount = i16;
            this.listener = listener;
            this.hasReport = new AtomicBoolean(false);
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NotNull c<? extends MemeAction> other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (this.priority.compareTo(other.priority) > 0) {
                return -1;
            }
            if (this.priority == other.priority && this.sequence <= other.sequence) {
                return -1;
            }
            return 1;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof c) {
                    c cVar = (c) other;
                    if (!Intrinsics.areEqual(this.action, cVar.action) || !Intrinsics.areEqual(this.priority, cVar.priority) || this.sequence != cVar.sequence || this.needCheckResource != cVar.needCheckResource || this.doCheckResourceCount != cVar.doCheckResourceCount || !Intrinsics.areEqual(this.listener, cVar.listener)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        /* renamed from: h, reason: from getter */
        public final boolean getAbortForAppearanceKeyChange() {
            return this.abortForAppearanceKeyChange;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3;
            int i16;
            T t16 = this.action;
            int i17 = 0;
            if (t16 != null) {
                i3 = t16.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = i3 * 31;
            Priority priority = this.priority;
            if (priority != null) {
                i16 = priority.hashCode();
            } else {
                i16 = 0;
            }
            int i19 = (((i18 + i16) * 31) + this.sequence) * 31;
            boolean z16 = this.needCheckResource;
            int i26 = z16;
            if (z16 != 0) {
                i26 = 1;
            }
            int i27 = (((i19 + i26) * 31) + this.doCheckResourceCount) * 31;
            com.tencent.zplan.meme.a aVar = this.listener;
            if (aVar != null) {
                i17 = aVar.hashCode();
            }
            return i27 + i17;
        }

        @NotNull
        public final T i() {
            return this.action;
        }

        /* renamed from: j, reason: from getter */
        public final boolean getCancel() {
            return this.cancel;
        }

        /* renamed from: k, reason: from getter */
        public final int getDoCheckResourceCount() {
            return this.doCheckResourceCount;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final com.tencent.zplan.meme.a getListener() {
            return this.listener;
        }

        /* renamed from: m, reason: from getter */
        public final boolean getNeedCheckResource() {
            return this.needCheckResource;
        }

        @NotNull
        /* renamed from: n, reason: from getter */
        public final Priority getPriority() {
            return this.priority;
        }

        public final boolean o() {
            if (!this.cancel && !this.abortForAppearanceKeyChange) {
                return false;
            }
            return true;
        }

        public final void p(boolean success, @NotNull MemeResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (this.hasReport.get()) {
                return;
            }
            this.hasReport.set(true);
            Meme.f385754h.p().n(success, result);
        }

        public final void q(boolean z16) {
            this.abortForAppearanceKeyChange = z16;
        }

        public final void r(boolean z16) {
            this.cancel = z16;
        }

        public final void s(int i3) {
            this.doCheckResourceCount = i3;
        }

        public final void t(boolean z16) {
            this.needCheckResource = z16;
        }

        @NotNull
        public String toString() {
            return this.action.getDesc() + " -> " + this.priority + ':' + this.sequence;
        }

        public final void u(@NotNull Priority priority) {
            Intrinsics.checkNotNullParameter(priority, "<set-?>");
            this.priority = priority;
        }

        public /* synthetic */ c(MemeAction memeAction, Priority priority, int i3, boolean z16, int i16, com.tencent.zplan.meme.a aVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(memeAction, priority, i3, (i17 & 8) != 0 ? true : z16, (i17 & 16) != 0 ? 0 : i16, aVar);
        }
    }
}
