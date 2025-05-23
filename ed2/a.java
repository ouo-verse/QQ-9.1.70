package ed2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.perf.config.plugin.d;
import com.tencent.mobileqq.perf.tool.QQPerfHandlerThreadManager;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import com.tenpay.proxy.dlg.location.QbAddrData;
import fd2.c;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u0001@\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u001e\u0010\u000b\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\tH\u0002J \u0010\u0010\u001a\u00020\u00062\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH$J\b\u0010\u0011\u001a\u00020\u0006H$J\b\u0010\u0012\u001a\u00020\u0006H$J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH$J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\rH\u0004J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J&\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u001c\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00010\u001bJ\b\u0010\u001f\u001a\u00020\u001eH\u0016R\u0014\u0010\"\u001a\u00020\r8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020#8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0014\u0010+\u001a\u00020\u001e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00100\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010*R$\u00103\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R(\u00106\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010=\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010<R\u0016\u0010?\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010*R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u001a\u0010H\u001a\u00020D8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010E\u001a\u0004\bF\u0010GR\u0014\u0010J\u001a\u00020\r8$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\bA\u0010IR\u0014\u0010K\u001a\u00020\r8$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010I\u00a8\u0006N"}, d2 = {"Led2/a;", "", "", "p", "Lcom/tencent/mobileqq/perf/config/plugin/d;", "highStringMonitorConfig", "", HippyTKDListViewAdapter.X, "o", "", "map", "w", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "list", "t", "u", "v", "msg", "count", ReportConstant.COSTREPORT_PREFIX, "str", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "tag", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lfd2/a;", "highFrequencyDetectable", DomainData.DOMAIN_NAME, "", "j", "a", "Ljava/lang/String;", "TAG", "", "b", "I", "START_MONITOR", "c", "DETECT_HIGH_LOG", "d", "J", "ONE_DAY_MILLISECONDS", "e", "Lcom/tencent/mobileqq/perf/config/plugin/d;", "cfg", "f", "DETECT_INTERVEL_MS", "g", "Ljava/util/ArrayList;", "whiteList", h.F, "Lfd2/a;", "detector", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "i", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isStart", "k", "startDetectTime", "ed2/a$a", "l", "Led2/a$a;", "handler", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "getSceneChangedCallback", "()Lcom/tencent/mobileqq/perf/tracker/callback/a;", "sceneChangedCallback", "()Ljava/lang/String;", "KEY_YESTERDAY_REPORT_TIME", "KEY_RPT_COUNT", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "BaseHighStringMonitor";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int START_MONITOR = 1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int DETECT_HIGH_LOG = 2;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long ONE_DAY_MILLISECONDS = 86400000;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d cfg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long DETECT_INTERVEL_MS;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<String> whiteList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private fd2.a<? extends Object, ? extends Object> detector;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MMKVOptionEntity entity;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isStart;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long startDetectTime;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HandlerC10231a handler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.perf.tracker.callback.a sceneChangedCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ed2/a$a", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ed2.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class HandlerC10231a extends Handler {
        HandlerC10231a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            Map map;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (!a.this.o()) {
                return;
            }
            int i3 = msg2.what;
            if (i3 == a.this.START_MONITOR) {
                if (Math.random() < a.this.cfg.eventSampleRatio) {
                    a.this.u();
                    a.this.startDetectTime = System.currentTimeMillis();
                    sendEmptyMessageDelayed(a.this.DETECT_HIGH_LOG, a.this.cfg.monitorInterval);
                }
                sendEmptyMessageDelayed(a.this.START_MONITOR, a.this.DETECT_INTERVEL_MS);
                return;
            }
            if (i3 == a.this.DETECT_HIGH_LOG) {
                fd2.a aVar = a.this.detector;
                if (aVar != null) {
                    map = aVar.a();
                } else {
                    map = null;
                }
                a.this.j();
                if (map != null) {
                    a.this.w(map);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"ed2/a$b", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "", "onProcessForeground", "onProcessBackground", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends com.tencent.mobileqq.perf.tracker.callback.a {
        b() {
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, mqq.app.QActivityLifecycleCallbacks
        public void onProcessBackground() {
            if (a.this.isStart.get()) {
                a.this.v();
                a.this.j();
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            if (a.this.isStart.get()) {
                a.this.u();
            }
        }
    }

    public a() {
        d dVar = new d(new JSONObject());
        this.cfg = dVar;
        this.DETECT_INTERVEL_MS = dVar.loopInterval;
        this.whiteList = new ArrayList<>();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        this.entity = from;
        this.isStart = new AtomicBoolean(false);
        this.handler = new HandlerC10231a(QQPerfHandlerThreadManager.INSTANCE.d().getLooper());
        this.sceneChangedCallback = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o() {
        if (this.entity.decodeInt(k(), this.cfg.dailyReportLimit) >= this.cfg.dailyReportLimit) {
            v();
            j();
            this.handler.removeMessages(this.START_MONITOR);
            return false;
        }
        return true;
    }

    private final boolean p() {
        if (AppSetting.isDebugVersion() && !Intrinsics.areEqual(AppSetting.getBranchName(), "master")) {
            QLog.d(this.TAG, 1, "\u975e master \u5f00\u53d1\u7248\u4e0d\u68c0\u6d4b");
            return false;
        }
        if (Math.random() > this.cfg.sampleRatio) {
            return false;
        }
        long decodeLong = this.entity.decodeLong(l(), 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - decodeLong > this.ONE_DAY_MILLISECONDS) {
            this.entity.encodeInt(k(), 0);
            this.entity.encodeLong(l(), currentTimeMillis);
        }
        return o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(Map<? extends Object, ? extends Object> map) {
        if ((!map.isEmpty()) && o()) {
            for (Map.Entry<? extends Object, ? extends Object> entry : map.entrySet()) {
                s(entry.getKey().toString(), entry.getValue().toString());
            }
            this.entity.encodeInt(k(), this.entity.decodeInt(k(), 0) + map.size());
        }
    }

    private final void x(d highStringMonitorConfig) {
        this.cfg = highStringMonitorConfig;
    }

    public long j() {
        fd2.a<? extends Object, ? extends Object> aVar = this.detector;
        if (aVar != null) {
            return aVar.clear();
        }
        return 0L;
    }

    @NotNull
    protected abstract String k();

    @NotNull
    protected abstract String l();

    public final void m(@NotNull d highStringMonitorConfig) {
        Intrinsics.checkNotNullParameter(highStringMonitorConfig, "highStringMonitorConfig");
        n(highStringMonitorConfig, new c(this.whiteList, highStringMonitorConfig.maintainCount, highStringMonitorConfig.threshold));
    }

    public final void n(@NotNull d highStringMonitorConfig, @NotNull fd2.a<? extends Object, ? extends Object> highFrequencyDetectable) {
        Intrinsics.checkNotNullParameter(highStringMonitorConfig, "highStringMonitorConfig");
        Intrinsics.checkNotNullParameter(highFrequencyDetectable, "highFrequencyDetectable");
        x(highStringMonitorConfig);
        t(this.whiteList);
        this.detector = highFrequencyDetectable;
        if (p() && this.isStart.compareAndSet(false, true)) {
            this.handler.sendEmptyMessage(this.START_MONITOR);
            SceneTracker.f258213d.l(this.sceneChangedCallback);
            QLog.d(this.TAG, 1, "start success, with " + highStringMonitorConfig);
            return;
        }
        this.isStart.set(false);
        QLog.d(this.TAG, 1, "start failed");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        if (System.currentTimeMillis() - this.startDetectTime < this.cfg.monitorInterval) {
            fd2.a<? extends Object, ? extends Object> aVar = this.detector;
            if (aVar != null) {
                aVar.b(str);
                return;
            }
            return;
        }
        v();
    }

    public void r(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (System.currentTimeMillis() - this.startDetectTime < this.cfg.monitorInterval) {
            if (AppSetting.isDebugVersion()) {
                fd2.a<? extends Object, ? extends Object> aVar = this.detector;
                if (aVar != null) {
                    aVar.putString(tag, msg2);
                    return;
                }
                return;
            }
            fd2.a<? extends Object, ? extends Object> aVar2 = this.detector;
            if (aVar2 != null) {
                aVar2.b(tag + QbAddrData.DATA_SPLITER + msg2);
                return;
            }
            return;
        }
        v();
    }

    protected abstract void s(@NotNull String msg2, @NotNull String count);

    protected abstract void t(@NotNull ArrayList<String> list);

    protected abstract void u();

    protected abstract void v();
}
