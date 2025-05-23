package dd2;

import com.tencent.mobileqq.perf.rmonitor.QQRMonitorSDKManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.LogWriterManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\b\u0007*\u0001\u0017\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0014J\b\u0010\b\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0014R\u001a\u0010\u0013\u001a\u00020\u00038\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u00038\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Ldd2/b;", "Led2/a;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "list", "", "t", "u", "v", "", "j", "msg", "count", ReportConstant.COSTREPORT_PREFIX, "o", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "KEY_YESTERDAY_REPORT_TIME", "p", "k", "KEY_RPT_COUNT", "dd2/b$a", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ldd2/b$a;", "logCallback", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b extends ed2.a {

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public static final b f393639n = new b();

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String KEY_YESTERDAY_REPORT_TIME = "perf_high_frequency_log_yesterday_time";

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String KEY_RPT_COUNT = "perf_high_frequency_log_report_count";

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a logCallback = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\b"}, d2 = {"dd2/b$a", "Lcom/tencent/qphone/base/util/QLog$ILogCallback;", "", "tag", "msg", "", "onWriteLog", "", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements QLog.ILogCallback {
        a() {
        }

        @Override // com.tencent.qphone.base.util.QLog.ILogCallback
        public void onWriteLog(@Nullable String tag, @Nullable String msg2) {
            if (tag == null || msg2 == null) {
                return;
            }
            b.f393639n.r(tag, msg2);
        }

        @Override // com.tencent.qphone.base.util.QLog.ILogCallback
        public void onWriteLog(@Nullable String tag, @Nullable byte[] msg2) {
            if (tag == null || msg2 == null) {
                return;
            }
            b.f393639n.r(tag, msg2.toString());
        }
    }

    b() {
    }

    @Override // ed2.a
    public long j() {
        long j3 = super.j();
        QLog.d("HighLogMonitor", 1, "this turn, log count is " + j3);
        return j3;
    }

    @Override // ed2.a
    @NotNull
    protected String k() {
        return KEY_RPT_COUNT;
    }

    @Override // ed2.a
    @NotNull
    protected String l() {
        return KEY_YESTERDAY_REPORT_TIME;
    }

    @Override // ed2.a
    protected void s(@NotNull String msg2, @NotNull String count) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(count, "count");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("realUin", String.valueOf(QQRMonitorSDKManager.uin));
        hashMap.put("content", msg2);
        hashMap.put("count", count);
        String processName = MobileQQ.processName;
        Intrinsics.checkNotNullExpressionValue(processName, "processName");
        hashMap.put("processName", processName);
        hashMap.put("branchName", AppSetting.getBranchName());
        if (QLog.isDevelopLevel()) {
            QLog.d("HighLogMonitor", 4, "report " + msg2 + TokenParser.SP + count);
        }
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance("", "perf_high_frequency_log_alert", true, 0L, 0L, hashMap, "");
    }

    @Override // ed2.a
    protected void t(@NotNull ArrayList<String> list) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(list, "list");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("MSF.D", "MSF.C", "Q.msg.MsgProxy|addMsgQueue", "Q.db.Cache|writeRunable", "Q.msg.MsgProxy|writeRunable", "Q.db.Cache|addMsgQueue", "SQLiteOpenHelper| getWritableDatabase", "SQLiteOpenHelper| getReadableDatabase", "MSF.C.NetConnTag.DualConnContext.true|tryDualConn");
        list.addAll(arrayListOf);
    }

    @Override // ed2.a
    protected void u() {
        if (QLog.isDevelopLevel()) {
            QLog.d("HighLogMonitor", 4, "start");
        }
        LogWriterManager.setLogCallback(logCallback);
    }

    @Override // ed2.a
    protected void v() {
        if (QLog.isDevelopLevel()) {
            QLog.d("HighLogMonitor", 4, "stop");
        }
        LogWriterManager.removeLogCallback(logCallback);
    }
}
