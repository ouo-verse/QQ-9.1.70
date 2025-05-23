package dd2;

import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.perf.rmonitor.QQRMonitorSDKManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.util.AppSetting;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MainService;
import mqq.app.MobileQQ;
import mqq.util.IServiceCmdCallback;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\b\u0007*\u0001\u0015\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0014J\b\u0010\b\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0014R\u001a\u0010\u0011\u001a\u00020\u00038\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u00038\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Ldd2/a;", "Led2/a;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "list", "", "t", "u", "v", "msg", "count", ReportConstant.COSTREPORT_PREFIX, "o", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "KEY_YESTERDAY_REPORT_TIME", "p", "k", "KEY_RPT_COUNT", "dd2/a$a", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ldd2/a$a;", "cmdCallBack", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a extends ed2.a {

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public static final a f393635n = new a();

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String KEY_YESTERDAY_REPORT_TIME = "perf_high_frequency_cmd_yesterday_time";

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String KEY_RPT_COUNT = "perf_high_frequency_cmd_report_count";

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final C10171a cmdCallBack = new C10171a();

    a() {
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
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance("", "perf_high_frequency_cmd_alert", true, 0L, 0L, hashMap, "");
    }

    @Override // ed2.a
    protected void t(@NotNull ArrayList<String> list) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(list, "list");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("MessageSvc.PbDeleteMsg", "OidbSvc.0x787_1", BaseConstants.CMD_REPORTSTAT, BaseConstants.CMD_RESPPUSH, FaceConstant.AvatarHandlerCmd.CMD_GETQQHEAD, FaceConstant.AvatarHandlerCmd.CMD_GETQQHEAD_NEW, "OidbSvc.0x58b_0");
        list.addAll(arrayListOf);
    }

    @Override // ed2.a
    protected void u() {
        MainService.setServiceCmdCallback(cmdCallBack);
    }

    @Override // ed2.a
    protected void v() {
        MainService.setServiceCmdCallback(null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"dd2/a$a", "Lmqq/util/IServiceCmdCallback;", "", "cmd", "", "onCmdRequest", "onCmdResponse", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: dd2.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C10171a implements IServiceCmdCallback {
        C10171a() {
        }

        @Override // mqq.util.IServiceCmdCallback
        public void onCmdRequest(@NotNull String cmd) {
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            a.f393635n.q(cmd);
        }

        @Override // mqq.util.IServiceCmdCallback
        public void onCmdResponse(@Nullable String cmd) {
        }
    }
}
