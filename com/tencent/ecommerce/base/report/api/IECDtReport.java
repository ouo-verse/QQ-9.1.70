package com.tencent.ecommerce.base.report.api;

import android.view.View;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017JL\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005H&JB\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005H&J:\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005H&JD\u0010\u0012\u001a\u00020\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005H&J(\u0010\u0013\u001a\u00020\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005H&J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0001H&J\u001a\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030\u00052\u0006\u0010\u0002\u001a\u00020\u0001H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/base/report/api/IECDtReport;", "", "target", "", "pageId", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "", "autoReport", "extAction", "", "attachDtReport", "Landroid/view/View;", "elementId", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "bindDtReportInfo", "updateDtReportInfo", "eventId", "reportCustomDtEvent", "invokeDtExtAction", "resetDtReportInfo", "getElementParams", "Companion", "a", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECDtReport {

    @NotNull
    public static final String ACTION_CLICK_POLICY = "clickPolicy";

    @NotNull
    public static final String ACTION_DATA_READY = "dataReady";

    @NotNull
    public static final String ACTION_EXPOSE_END_POLICY = "exposeEndPolicy";

    @NotNull
    public static final String ACTION_EXPOSE_POLICY = "exposePolicy";

    @NotNull
    public static final String ACTION_IDENTIFIER = "identifier";

    @NotNull
    public static final String ACTION_MULTI_SCENE = "multiScene";

    @NotNull
    public static final String ACTION_NEED_TRAVERSE_EXPOSURE = "needTraverseExposure";

    @NotNull
    public static final String ACTION_TRAVERSE_PAGE = "traversePage";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f100910e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\r\u0010\bR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/base/report/api/IECDtReport$a;", "", "", "a", "I", "c", "()I", "setREPORT_NONE", "(I)V", "REPORT_NONE", "b", "setREPORT_ALL", "REPORT_ALL", "setREPORT_FIRST", "REPORT_FIRST", "", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "setSCENE_QQ_LIVE", "(Ljava/lang/String;)V", "SCENE_QQ_LIVE", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.report.api.IECDtReport$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private static int REPORT_NONE;

        /* renamed from: e, reason: collision with root package name */
        static final /* synthetic */ Companion f100910e = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static int REPORT_ALL = 1;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private static int REPORT_FIRST = 2;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static String SCENE_QQ_LIVE = "qqlive";

        Companion() {
        }

        public final int a() {
            return REPORT_ALL;
        }

        public final int b() {
            return REPORT_FIRST;
        }

        public final int c() {
            return REPORT_NONE;
        }

        @NotNull
        public final String d() {
            return SCENE_QQ_LIVE;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class b {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(IECDtReport iECDtReport, Object obj, String str, Map map, Map map2, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 8) != 0) {
                    map2 = new HashMap();
                }
                iECDtReport.reportCustomDtEvent(obj, str, map, map2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportCustomDtEvent");
        }
    }

    void attachDtReport(@NotNull Object target, @NotNull String pageId, @NotNull Map<String, String> pageParams, boolean autoReport, @NotNull Map<String, ? extends Object> extAction);

    void bindDtReportInfo(@NotNull View target, @NotNull String elementId, @NotNull Map<String, String> reportParams, @NotNull Map<String, ? extends Object> extAction);

    @NotNull
    Map<String, ?> getElementParams(@NotNull Object target);

    void invokeDtExtAction(@Nullable Object target, @NotNull Map<String, ? extends Object> extAction);

    void reportCustomDtEvent(@Nullable Object target, @NotNull String eventId, @NotNull Map<String, String> reportParams, @NotNull Map<String, ? extends Object> extAction);

    void resetDtReportInfo(@NotNull Object target);

    void updateDtReportInfo(@NotNull Object target, @NotNull Map<String, String> reportParams, @NotNull Map<String, ? extends Object> extAction);
}
