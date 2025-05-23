package l24;

import android.util.ArrayMap;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.inject.v;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0006R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Ll24/e;", "", "", "nodeName", "", "msgId", "", "o", "curr", "d", "type", "k", "", "f", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "g", h.F, "Ljava/util/LinkedList;", "Ll24/e$a;", "b", "Ljava/util/LinkedList;", "costQueue", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f413735a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LinkedList<a> costQueue = new LinkedList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\n\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\b2\u0006\u0010\u0006\u001a\u00020\u0002R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0010\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000f\u0010\rR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Ll24/e$a;", "", "", "nodeName", "", "d", "type", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "c", "", "a", "J", "()J", "mMsgId", "b", "mStart", "Landroid/util/ArrayMap;", "Landroid/util/ArrayMap;", "mCostMap", "<init>", "(JJ)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long mMsgId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long mStart;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayMap<String, Long> mCostMap = new ArrayMap<>();

        public a(long j3, long j16) {
            this.mMsgId = j3;
            this.mStart = j16;
        }

        /* renamed from: a, reason: from getter */
        public final long getMMsgId() {
            return this.mMsgId;
        }

        /* renamed from: b, reason: from getter */
        public final long getMStart() {
            return this.mStart;
        }

        @NotNull
        public final LinkedHashMap<String, String> c(@NotNull String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("kernel_msg_send", String.valueOf(this.mCostMap.get("kernel_msg_send")));
            linkedHashMap.put("kernel_msg_resp", String.valueOf(this.mCostMap.get("kernel_msg_resp")));
            linkedHashMap.put("robot_msg_receive", String.valueOf(this.mCostMap.get("robot_msg_receive")));
            linkedHashMap.put("robot_msg_type", type);
            linkedHashMap.put("kernel_msg_id", String.valueOf(this.mMsgId));
            return linkedHashMap;
        }

        public final void d(@NotNull String nodeName) {
            Intrinsics.checkNotNullParameter(nodeName, "nodeName");
            this.mCostMap.put(nodeName, Long.valueOf(System.currentTimeMillis() - this.mStart));
        }
    }

    e() {
    }

    private final void d(long curr) {
        a peek;
        while (true) {
            LinkedList<a> linkedList = costQueue;
            if (!linkedList.isEmpty() && (peek = linkedList.peek()) != null && peek.getMStart() + 120000 < curr) {
                QLog.d("RobotMsgReporter", 1, "tagStartNode ignore " + (curr - peek.getMStart()));
                linkedList.poll();
            } else {
                return;
            }
        }
    }

    private final boolean e() {
        l24.a aVar = (l24.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("102278");
        if (aVar == null) {
            aVar = new l24.a();
            aVar.b();
        }
        if (Random.INSTANCE.nextInt(0, aVar.getSimpleUpperLimitCount()) != 0) {
            return false;
        }
        return true;
    }

    private final boolean f() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102278", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(String nodeName, String type) {
        Intrinsics.checkNotNullParameter(nodeName, "$nodeName");
        Intrinsics.checkNotNullParameter(type, "$type");
        f413735a.k(nodeName, type);
    }

    private final void k(String nodeName, String type) {
        LinkedList<a> linkedList = costQueue;
        a poll = linkedList.poll();
        if (poll == null) {
            return;
        }
        poll.d(nodeName);
        final LinkedHashMap<String, String> c16 = poll.c(type);
        if (!linkedList.isEmpty()) {
            QLog.d("RobotMsgReporter", 1, "tagEndNode ignore " + c16);
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: l24.d
            @Override // java.lang.Runnable
            public final void run() {
                e.l(c16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(LinkedHashMap reportMap) {
        Intrinsics.checkNotNullParameter(reportMap, "$reportMap");
        if (f413735a.e()) {
            QLog.d("RobotMsgReporter", 1, "report " + reportMap);
            v.c(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "adelie_aio_msg_interval", reportMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(String nodeName, long j3) {
        Intrinsics.checkNotNullParameter(nodeName, "$nodeName");
        f413735a.o(nodeName, j3);
    }

    private final void o(String nodeName, long msgId) {
        if (Intrinsics.areEqual("send_btn_click", nodeName)) {
            long currentTimeMillis = System.currentTimeMillis();
            d(currentTimeMillis);
            costQueue.offer(new a(msgId, currentTimeMillis));
        } else {
            for (a aVar : costQueue) {
                if (aVar.getMMsgId() == msgId) {
                    aVar.d(nodeName);
                }
            }
        }
    }

    public final void g() {
        QLog.d("RobotMsgReporter", 1, "onCreate");
        costQueue.clear();
    }

    public final void h() {
        QLog.d("RobotMsgReporter", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        costQueue.clear();
    }

    public final void i(@NotNull final String nodeName, @NotNull final String type) {
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        Intrinsics.checkNotNullParameter(type, "type");
        if (!f()) {
            return;
        }
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: l24.c
            @Override // java.lang.Runnable
            public final void run() {
                e.j(nodeName, type);
            }
        });
    }

    public final void m(@NotNull final String nodeName, final long msgId) {
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        if (!f()) {
            return;
        }
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: l24.b
            @Override // java.lang.Runnable
            public final void run() {
                e.n(nodeName, msgId);
            }
        });
    }
}
