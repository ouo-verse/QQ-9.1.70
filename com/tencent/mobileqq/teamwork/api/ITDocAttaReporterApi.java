package com.tencent.mobileqq.teamwork.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\bg\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019J6\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006H&J\u001c\u0010\n\u001a\u00020\t2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u000bH&Jj\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u0002H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/teamwork/api/ITDocAttaReporterApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "opername", "module", "action", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "report", "", "", "ver6", "", "ver7", "ver8", "ver9", "ver10", "ver11", "ver12", "obj2", "obj3", "fileBrowserReport", "Companion", "a", "tencentdoc-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ITDocAttaReporterApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f291661a;
    public static final int OPEN_STATE_FAIL = 2;
    public static final int OPEN_STATE_FALLBACK = 4;
    public static final int OPEN_STATE_SUC = 1;
    public static final int OPEN_STATE_TIMEOUT = 3;

    @NotNull
    public static final String REPORT_ACTION_PERFORMANCE = "performance";

    @NotNull
    public static final String REPORT_ACTION_SHOW = "show";

    @NotNull
    public static final String REPORT_OPEN_RECORD = "open_record";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/teamwork/api/ITDocAttaReporterApi$a;", "", "<init>", "()V", "tencentdoc-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f291661a = new Companion();

        Companion() {
        }
    }

    void fileBrowserReport(@NotNull String action, int ver6, long ver7, @NotNull String ver8, long ver9, int ver10, @NotNull String ver11, int ver12, @NotNull String obj2, @NotNull String obj3);

    void report(@NotNull String opername, @NotNull String module, @NotNull String action, @NotNull Map<String, Object> reportParams);

    void report(@NotNull Map<String, ? extends Object> reportParams);
}
