package defpackage;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.FileMsgItem;
import com.tencent.mobileqq.aio.msg.FoldMsgItem;
import com.tencent.mobileqq.aio.msg.GrayTipsMsgItem;
import com.tencent.mobileqq.aio.msg.MultiPicMsgItem;
import com.tencent.mobileqq.aio.msg.OnlineFileMsgItem;
import com.tencent.mobileqq.aio.msg.PttMsgItem;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.aio.msg.aj;
import com.tencent.mobileqq.aio.msg.m;
import com.tencent.mobileqq.aio.msg.n;
import com.tencent.mobileqq.aio.msg.p;
import com.tencent.mobileqq.aio.msg.u;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem;
import com.tencent.mobileqq.aio.utils.MixMsgUtils;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.factory.c;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import com.tencent.qqnt.msg.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import z71.a;
import zs.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b9\u0010:JN\u0010\r\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042#\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJQ\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f\"\u0004\b\u0000\u0010\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042#\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006H\u0002Jr\u0010\u0018\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042#\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J\b\u0010 \u001a\u00020\u000bH\u0002J1\u0010&\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000$\u00a2\u0006\u0004\b&\u0010'J9\u0010)\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010(\u001a\u00020\u001b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000$\u00a2\u0006\u0004\b)\u0010*JQ\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f\"\u0004\b\u0000\u0010\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042%\b\u0002\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006JK\u0010,\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042%\b\u0002\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006J\u0006\u0010-\u001a\u00020\u001bR\u001b\u00102\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00105\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010/\u001a\u0004\b4\u00101R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00107\u00a8\u0006;"}, d2 = {"LMsgListUtil;", "", "T", "msgRecord", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lkotlin/ParameterName;", "name", "msg", "", "msgProcessor", "t", "(Ljava/lang/Object;Landroid/content/Context;Lkotlin/jvm/functions/Function1;)Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "msgRecordList", "f", "", "msgItemList", "Ljava/util/concurrent/atomic/AtomicInteger;", "index", "Ljava/util/concurrent/CountDownLatch;", "countDownLatch", h.F, "(Ljava/util/List;[Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/CountDownLatch;Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "", "parseLottieAsYellowFace", "i", "j", "d", "o", "", "tag", "methodName", "Lkotlin/Function0;", "block", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "log", DomainData.DOMAIN_NAME, "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "p", "r", "u", "b", "Lkotlin/Lazy;", "k", "()Z", "filterMsgSwitch", "c", "l", "threadCheckSwitch", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "threadCheckRunnable", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class MsgListUtil {

    /* renamed from: a */
    @NotNull
    public static final MsgListUtil f24918a = new MsgListUtil();

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static final Lazy filterMsgSwitch;

    /* renamed from: c, reason: from kotlin metadata */
    @NotNull
    private static final Lazy threadCheckSwitch;

    /* renamed from: d, reason: from kotlin metadata */
    @Nullable
    private static Runnable threadCheckRunnable;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: MsgListUtil$filterMsgSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_msg_transform_failed_9060", false));
            }
        });
        filterMsgSwitch = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: MsgListUtil$threadCheckSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_display_check_9060", false));
            }
        });
        threadCheckSwitch = lazy2;
    }

    MsgListUtil() {
    }

    private final void d() {
        if (!l()) {
            return;
        }
        threadCheckRunnable = ThreadManagerV2.executeDelay(new Runnable() { // from class: e
            @Override // java.lang.Runnable
            public final void run() {
                MsgListUtil.e();
            }
        }, 16, null, true, 2000L);
    }

    public static final void e() {
        QLog.i("MsgListUtil", 1, "[checkDisplayThread]: displayThread overtime 2s, trace is " + b.a(Dispatchers.INSTANCE).e());
    }

    private final <T> List<AIOMsgItem> f(final List<? extends T> msgRecordList, final Context context, final Function1<? super AIOMsgItem, Unit> msgProcessor) {
        int coerceIn;
        List<AIOMsgItem> filterNotNull;
        int i3 = 1;
        if (msgRecordList.size() >= 5) {
            coerceIn = RangesKt___RangesKt.coerceIn(msgRecordList.size() / 3, 1, 5);
        } else {
            coerceIn = 0;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final CountDownLatch countDownLatch = new CountDownLatch(msgRecordList.size());
        final AIOMsgItem[] aIOMsgItemArr = new AIOMsgItem[msgRecordList.size()];
        if (1 <= coerceIn) {
            while (true) {
                ThreadManagerV2.excute(new Runnable() { // from class: f
                    @Override // java.lang.Runnable
                    public final void run() {
                        MsgListUtil.g(msgRecordList, aIOMsgItemArr, atomicInteger, countDownLatch, context, msgProcessor);
                    }
                }, 16, null, false);
                if (i3 == coerceIn) {
                    break;
                }
                i3++;
            }
        }
        h(msgRecordList, aIOMsgItemArr, atomicInteger, countDownLatch, context, msgProcessor);
        countDownLatch.await();
        filterNotNull = ArraysKt___ArraysKt.filterNotNull(aIOMsgItemArr);
        return filterNotNull;
    }

    public static final void g(List msgRecordList, AIOMsgItem[] msgItemList, AtomicInteger index, CountDownLatch countDownLatch, Context context, Function1 function1) {
        Intrinsics.checkNotNullParameter(msgRecordList, "$msgRecordList");
        Intrinsics.checkNotNullParameter(msgItemList, "$msgItemList");
        Intrinsics.checkNotNullParameter(index, "$index");
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        f24918a.h(msgRecordList, msgItemList, index, countDownLatch, context, function1);
    }

    private final <T> void h(List<? extends T> list, AIOMsgItem[] aIOMsgItemArr, AtomicInteger atomicInteger, CountDownLatch countDownLatch, Context context, Function1<? super AIOMsgItem, Unit> function1) {
        while (true) {
            int andIncrement = atomicInteger.getAndIncrement();
            if (andIncrement >= list.size()) {
                return;
            }
            AIOMsgItem t16 = t(list.get(andIncrement), context, function1);
            if (t16 != null) {
                aIOMsgItemArr[andIncrement] = t16;
            }
            countDownLatch.countDown();
        }
    }

    public final AIOMsgItem i(MsgRecord msgRecord, boolean parseLottieAsYellowFace) {
        AIOMsgItem a16 = FoldMsgItem.INSTANCE.a(msgRecord);
        if (a16 != null) {
            return a16;
        }
        try {
            int i3 = msgRecord.msgType;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 12) {
                        if (i3 != 17) {
                            if (i3 != 19) {
                                if (i3 != 21) {
                                    if (i3 != 23) {
                                        if (i3 != 31) {
                                            switch (i3) {
                                                case 5:
                                                    return new GrayTipsMsgItem(msgRecord);
                                                case 6:
                                                    return new PttMsgItem(msgRecord);
                                                case 7:
                                                    return new ShortVideoMsgItem(msgRecord);
                                                case 8:
                                                    return new p(msgRecord);
                                                case 9:
                                                    return new u(msgRecord);
                                                default:
                                                    AIOMsgItem j3 = j(msgRecord);
                                                    if (j3 == null) {
                                                        return new AIOMsgItem(msgRecord);
                                                    }
                                                    return j3;
                                            }
                                        }
                                        return new MarkdownMsgItem(msgRecord);
                                    }
                                    return new ah(msgRecord);
                                }
                                return new OnlineFileMsgItem(msgRecord);
                            }
                            return new aj(msgRecord);
                        }
                        return new n(msgRecord);
                    }
                    return new m(msgRecord);
                }
                if (!MsgExtKt.B(msgRecord)) {
                    return new FileMsgItem(msgRecord);
                }
                return new MultiPicMsgItem(msgRecord);
            }
            if (!MsgExtKt.O(msgRecord) && !MsgExtKt.b0(msgRecord)) {
                return MixMsgUtils.f194090a.b(msgRecord, parseLottieAsYellowFace);
            }
            AIOMsgItem j16 = j(msgRecord);
            if (j16 == null) {
                return new AIOMsgItem(msgRecord);
            }
            return j16;
        } catch (Throwable th5) {
            long j17 = msgRecord.msgId;
            QLog.d("MsgListUtil", 1, "[createMsgItemByType] err. msgType=" + j17 + ", msgId=" + j17 + ", throw=", th5);
            if (k()) {
                AIOMsgItem aIOMsgItem = new AIOMsgItem(msgRecord);
                aIOMsgItem.c2(true);
                return aIOMsgItem;
            }
            long j18 = msgRecord.msgId;
            throw new RuntimeException("msgType=" + j18 + ", msgId=" + j18 + ", throw= " + th5);
        }
    }

    private final AIOMsgItem j(MsgRecord msgRecord) {
        AIOMsgItem aIOMsgItem = null;
        try {
            Iterator<T> it = c.f349918a.a().iterator();
            while (it.hasNext()) {
                aIOMsgItem = ((a) it.next()).b(msgRecord);
                if (aIOMsgItem != null) {
                    return aIOMsgItem;
                }
            }
        } catch (Exception e16) {
            QLog.e("MsgListUtil", 1, "getExtMsgItem err " + e16);
        }
        return aIOMsgItem;
    }

    private final boolean k() {
        return ((Boolean) filterMsgSwitch.getValue()).booleanValue();
    }

    private final boolean l() {
        return ((Boolean) threadCheckSwitch.getValue()).booleanValue();
    }

    private final void o() {
        if (!l()) {
            return;
        }
        Runnable runnable = threadCheckRunnable;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
        }
        threadCheckRunnable = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List q(MsgListUtil msgListUtil, List list, Context context, Function1 function1, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        return msgListUtil.p(list, context, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIOMsgItem s(MsgListUtil msgListUtil, MsgRecord msgRecord, boolean z16, Context context, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            context = null;
        }
        if ((i3 & 8) != 0) {
            function1 = null;
        }
        return msgListUtil.r(msgRecord, z16, context, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> AIOMsgItem t(T msgRecord, Context context, Function1<? super AIOMsgItem, Unit> msgProcessor) {
        if (msgRecord instanceof MsgRecord) {
            return s(this, (MsgRecord) msgRecord, false, context, msgProcessor, 2, null);
        }
        if (msgRecord instanceof d) {
            return s(this, ((d) msgRecord).a(), false, context, msgProcessor, 2, null);
        }
        return null;
    }

    public final <T> T m(@NotNull String tag, @NotNull String methodName, @NotNull Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(block, "block");
        return (T) n(tag, methodName, true, block);
    }

    public final <T> T n(@NotNull String tag, @NotNull String methodName, boolean z16, @NotNull Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(block, "block");
        long currentTimeMillis = System.currentTimeMillis();
        T invoke = block.invoke();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (z16) {
            QLog.d(tag, 1, "method#" + methodName + ", cost: " + currentTimeMillis2);
        }
        return invoke;
    }

    @NotNull
    public final <T> List<AIOMsgItem> p(@NotNull List<? extends T> msgRecordList, @Nullable Context context, @Nullable Function1<? super AIOMsgItem, Unit> msgProcessor) {
        Intrinsics.checkNotNullParameter(msgRecordList, "msgRecordList");
        StopWatch i3 = new StopWatch("transform-msg:" + msgRecordList.size(), QLog.isDevelopLevel()).i();
        List<AIOMsgItem> f16 = f(msgRecordList, context, msgProcessor);
        i3.b("transform");
        if (k()) {
            ArrayList arrayList = new ArrayList();
            for (T t16 : f16) {
                if (!((AIOMsgItem) t16).B0()) {
                    arrayList.add(t16);
                }
            }
            return arrayList;
        }
        return f16;
    }

    @NotNull
    public final AIOMsgItem r(@NotNull final MsgRecord msgRecord, final boolean parseLottieAsYellowFace, @Nullable final Context context, @Nullable final Function1<? super AIOMsgItem, Unit> msgProcessor) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        d();
        AIOMsgItem aIOMsgItem = (AIOMsgItem) m("MsgListUtil", "transformMsgRecordWithType(" + (((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).msgTypeToString(msgRecord.msgType) + "-" + msgRecord.msgId) + ")", new Function0<AIOMsgItem>() { // from class: MsgListUtil$transformMsgRecordWithType$msgItem$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOMsgItem invoke() {
                AIOMsgItem i3;
                i3 = MsgListUtil.f24918a.i(MsgRecord.this, parseLottieAsYellowFace);
                Context context2 = context;
                Function1<AIOMsgItem, Unit> function1 = msgProcessor;
                i3.Y0(context2);
                if (function1 != null) {
                    function1.invoke(i3);
                }
                return i3;
            }
        });
        o();
        return aIOMsgItem;
    }

    public final boolean u() {
        return true;
    }
}
