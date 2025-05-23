package com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.media.MediaBrowserServiceCompat;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.guild.nt.misc.api.IUploadApi;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.search.util.n;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqnt.kernel.nativeinterface.ICheckAIAuthCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService;
import com.tencent.qqnt.kernel.nativeinterface.SearchListDetail;
import com.tencent.qqnt.kernel.nativeinterface.SearchModelInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchOpenSourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.UfsCheckAIAuthReq;
import com.tencent.qqnt.kernel.nativeinterface.UfsCheckAIAuthRsp;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import com.tencent.util.AppSetting;
import com.tencent.util.URLUtil;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0003.25B\u0007\u00a2\u0006\u0004\bH\u0010IJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J8\u0010\u0010\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001c\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001c2\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J\u001c\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001c2\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J \u0010 \u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J(\u0010!\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0006\u0010%\u001a\u00020\u0006J.\u0010&\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ&\u0010,\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/depositary/NetSearchHunYuanDepositary;", "", "", "errorCode", "", "errorMsg", "", "u", "prompt", "keyWord", "model", "psKey", "", "userSelected", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/depositary/NetSearchHunYuanDepositary$b;", "callback", "y", "uin", "pSKey", "k", "Lokio/BufferedSource;", "source", "t", "line", "Lorg/json/JSONObject;", "r", "jsonObject", "p", "Lkotlin/Pair;", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "lineContent", "o", ReportConstant.COSTREPORT_PREFIX, "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchListDetail;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", HippyTKDListViewAdapter.X, "query", "questionId", "robotUin", "Lcom/tencent/qqnt/kernel/nativeinterface/ICheckAIAuthCallback;", "result", "v", "Lokhttp3/OkHttpClient;", "a", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/Call;", "b", "Lokhttp3/Call;", "call", "c", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/depositary/NetSearchHunYuanDepositary$b;", "d", "Z", "isCanceled", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "e", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "firstContentReportTask", "f", "resultReportTask", "Landroid/os/Handler;", "g", "Landroid/os/Handler;", "handler", "Ljava/lang/Runnable;", h.F, "Ljava/lang/Runnable;", "timeoutCheckTask", "<init>", "()V", "i", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NetSearchHunYuanDepositary {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final OkHttpClient client;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Call call;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b callback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isCanceled;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPerformanceReportTask firstContentReportTask;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPerformanceReportTask resultReportTask;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable timeoutCheckTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J$\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u0002H&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002H&J\u0016\u0010\u0013\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&J\b\u0010\u0014\u001a\u00020\u0005H&J\b\u0010\u0015\u001a\u00020\u0005H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/depositary/NetSearchHunYuanDepositary$b;", "", "", "contentUUID", "str", "", "s0", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/depositary/NetSearchHunYuanDepositary$c;", "modelInfo", "V0", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "fallbackTips", "I1", "content", "M0", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchListDetail;", "searchItems", ExifInterface.LATITUDE_SOUTH, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "onComplete", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface b {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes18.dex */
        public static final class a {
            public static /* synthetic */ void a(b bVar, String str, String str2, String str3, int i3, Object obj) {
                if (obj == null) {
                    if ((i3 & 2) != 0) {
                        str2 = "";
                    }
                    if ((i3 & 4) != 0) {
                        str3 = "";
                    }
                    bVar.I1(str, str2, str3);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailed");
            }
        }

        void I1(@NotNull String errorType, @NotNull String errorCode, @NotNull String fallbackTips);

        void M0(@NotNull String content);

        void S(@NotNull List<SearchListDetail> searchItems);

        void V0(@NotNull ModelInfo modelInfo);

        void onComplete();

        void s0(@NotNull String contentUUID, @NotNull String str);

        void z();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/depositary/NetSearchHunYuanDepositary$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchModelInfo;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchModelInfo;", "b", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchModelInfo;", "d", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchModelInfo;)V", "searchModelInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchOpenSourceInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchOpenSourceInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchOpenSourceInfo;", "c", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchOpenSourceInfo;)V", "openSourceInfo", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchModelInfo;Lcom/tencent/qqnt/kernel/nativeinterface/SearchOpenSourceInfo;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary$c, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class ModelInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private SearchModelInfo searchModelInfo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private SearchOpenSourceInfo openSourceInfo;

        public ModelInfo(@NotNull SearchModelInfo searchModelInfo, @NotNull SearchOpenSourceInfo openSourceInfo) {
            Intrinsics.checkNotNullParameter(searchModelInfo, "searchModelInfo");
            Intrinsics.checkNotNullParameter(openSourceInfo, "openSourceInfo");
            this.searchModelInfo = searchModelInfo;
            this.openSourceInfo = openSourceInfo;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final SearchOpenSourceInfo getOpenSourceInfo() {
            return this.openSourceInfo;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final SearchModelInfo getSearchModelInfo() {
            return this.searchModelInfo;
        }

        public final void c(@NotNull SearchOpenSourceInfo searchOpenSourceInfo) {
            Intrinsics.checkNotNullParameter(searchOpenSourceInfo, "<set-?>");
            this.openSourceInfo = searchOpenSourceInfo;
        }

        public final void d(@NotNull SearchModelInfo searchModelInfo) {
            Intrinsics.checkNotNullParameter(searchModelInfo, "<set-?>");
            this.searchModelInfo = searchModelInfo;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModelInfo)) {
                return false;
            }
            ModelInfo modelInfo = (ModelInfo) other;
            if (Intrinsics.areEqual(this.searchModelInfo, modelInfo.searchModelInfo) && Intrinsics.areEqual(this.openSourceInfo, modelInfo.openSourceInfo)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.searchModelInfo.hashCode() * 31) + this.openSourceInfo.hashCode();
        }

        @NotNull
        public String toString() {
            return "ModelInfo(searchModelInfo=" + this.searchModelInfo + ", openSourceInfo=" + this.openSourceInfo + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/template/ai/depositary/NetSearchHunYuanDepositary$d", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f284115a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Call f284116b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ NetSearchHunYuanDepositary f284117c;

        d(b bVar, Call call, NetSearchHunYuanDepositary netSearchHunYuanDepositary) {
            this.f284115a = bVar;
            this.f284116b = call;
            this.f284117c = netSearchHunYuanDepositary;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException e16) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e16, "e");
            Logger.f235387a.d().w("QQSearch.NetDetail.NetSearchHunYuanDepositary", 1, "connectFailed " + e16);
            b.a.a(this.f284115a, "others", null, "connectFailed", 2, null);
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            BufferedSource bufferedSource;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            Logger logger = Logger.f235387a;
            logger.d().i("QQSearch.NetDetail.NetSearchHunYuanDepositary", 1, "onResponse " + response.code());
            if (!response.isSuccessful()) {
                logger.d().w("QQSearch.NetDetail.NetSearchHunYuanDepositary", 1, "onResponse\uff0cerror=" + response.code());
                b.a.a(this.f284115a, "others", null, String.valueOf(response.code()), 2, null);
                return;
            }
            ResponseBody body = response.body();
            if (body != null) {
                bufferedSource = body.getBodySource();
            } else {
                bufferedSource = null;
            }
            if (bufferedSource != null) {
                this.f284117c.t(bufferedSource, this.f284115a);
                return;
            }
            logger.d().w("QQSearch.NetDetail.NetSearchHunYuanDepositary", 1, "onResponse source is null");
            b.a.a(this.f284115a, "others", null, "source is null", 2, null);
            this.f284116b.cancel();
        }
    }

    public NetSearchHunYuanDepositary() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.client = builder.connectTimeout(120000L, timeUnit).readTimeout(120000L, timeUnit).build();
        this.handler = new Handler(Looper.getMainLooper());
        this.timeoutCheckTask = new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.a
            @Override // java.lang.Runnable
            public final void run() {
                NetSearchHunYuanDepositary.z(NetSearchHunYuanDepositary.this);
            }
        };
    }

    private final String k(String uin, String pSKey) {
        String str;
        if (pSKey.length() >= 10) {
            str = pSKey.substring(0, 10);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        } else {
            str = pSKey;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new IUploadApi.a("uin", uin));
        arrayList.add(new IUploadApi.a("skey", str));
        arrayList.add(new IUploadApi.a(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN, uin));
        arrayList.add(new IUploadApi.a("p_skey", pSKey));
        StringBuilder sb5 = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            IUploadApi.a aVar = (IUploadApi.a) it.next();
            String encodeUrl = URLUtil.encodeUrl(aVar.f230929a);
            String encodeUrl2 = URLUtil.encodeUrl(aVar.f230930b);
            sb5.append(" " + encodeUrl + ContainerUtils.KEY_VALUE_DELIMITER);
            StringBuilder sb6 = new StringBuilder();
            sb6.append(encodeUrl2);
            sb6.append(";");
            sb5.append(sb6.toString());
        }
        String sb7 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb7, "sb.toString()");
        return sb7;
    }

    private final Pair<String, String> m(JSONObject jsonObject) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str = "";
        String optString = jsonObject.optString("id", "");
        JSONArray optJSONArray = jsonObject.optJSONArray("choices");
        String str2 = null;
        if (optJSONArray != null) {
            jSONObject = optJSONArray.optJSONObject(0);
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            jSONObject2 = jSONObject.optJSONObject(EventListener.KEY_DELTA);
        } else {
            jSONObject2 = null;
        }
        if (jSONObject2 != null) {
            str2 = jSONObject2.optString("content", "");
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QQSearch.NetDetail.NetSearchHunYuanDepositary", "decodeContent succ " + str2);
        }
        if (str2 != null) {
            str = str2;
        }
        return new Pair<>(optString, str);
    }

    private final Pair<String, String> n(JSONObject jsonObject) {
        return new Pair<>(jsonObject.optString("error_code", ""), jsonObject.optString("error_msg", ""));
    }

    private final boolean o(JSONObject jsonObject, String lineContent, b callback) {
        String str;
        JSONObject jSONObject;
        String str2;
        JSONObject optJSONObject = jsonObject.optJSONObject("safe_rsp");
        if (optJSONObject != null) {
            str = optJSONObject.optString("safe_level");
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, "refuse_answer") && !Intrinsics.areEqual(str, "input_white_answer")) {
            JSONArray optJSONArray = jsonObject.optJSONArray("choices");
            if (optJSONArray != null) {
                jSONObject = optJSONArray.optJSONObject(0);
            } else {
                jSONObject = null;
            }
            if (jSONObject != null) {
                str2 = jSONObject.optString("finish_reason");
            } else {
                str2 = null;
            }
            if (!Intrinsics.areEqual(str2, "stop")) {
                return false;
            }
            af afVar = af.f284993a;
            QLog.w("QS.QQSearch.NetDetail.NetSearchHunYuanDepositary", 1, "finish with finishReason:" + str2, null);
            callback.onComplete();
            return true;
        }
        String fallback = optJSONObject.optString(AdMetricTag.FALLBACK);
        af afVar2 = af.f284993a;
        QLog.w("QS.QQSearch.NetDetail.NetSearchHunYuanDepositary", 1, "finish with safeLevel:" + str, null);
        Intrinsics.checkNotNullExpressionValue(fallback, "fallback");
        callback.M0(fallback);
        return true;
    }

    private final void p(JSONObject jsonObject, b callback) {
        boolean z16;
        String showName = jsonObject.optString("model_show_name", "");
        String optString = jsonObject.optString("model", "");
        String optString2 = jsonObject.optString("open_source_text", "");
        String optString3 = jsonObject.optString("open_source_url", "");
        Intrinsics.checkNotNullExpressionValue(showName, "showName");
        if (showName.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            SearchModelInfo searchModelInfo = new SearchModelInfo();
            searchModelInfo.modelRealName = optString;
            searchModelInfo.modelShowName = showName;
            SearchOpenSourceInfo searchOpenSourceInfo = new SearchOpenSourceInfo();
            searchOpenSourceInfo.text = optString2;
            searchOpenSourceInfo.url = optString3;
            Unit unit = Unit.INSTANCE;
            callback.V0(new ModelInfo(searchModelInfo, searchOpenSourceInfo));
            return;
        }
        af afVar = af.f284993a;
        QLog.w("QS.QQSearch.NetDetail.NetSearchHunYuanDepositary", 1, "decodeModeName empty find", null);
    }

    private final List<SearchListDetail> q(JSONObject jsonObject, b callback) {
        JSONArray jSONArray;
        ArrayList arrayList = new ArrayList();
        JSONObject optJSONObject = jsonObject.optJSONObject("search_info");
        if (optJSONObject != null) {
            jSONArray = optJSONObject.optJSONArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
        } else {
            jSONArray = null;
        }
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                SearchListDetail searchListDetail = new SearchListDetail();
                searchListDetail.title.text = jSONObject.optString("title");
                searchListDetail.jumpLink.jumpLink = jSONObject.optString("url");
                arrayList.add(searchListDetail);
            }
        }
        if (!arrayList.isEmpty()) {
            callback.S(arrayList);
        }
        return arrayList;
    }

    private final JSONObject r(String line) {
        boolean startsWith$default;
        String removePrefix;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(line, "data:data: ", false, 2, null);
        if (startsWith$default) {
            removePrefix = StringsKt__StringsKt.removePrefix(line, (CharSequence) "data:data: ");
            try {
                return new JSONObject(removePrefix);
            } catch (Exception e16) {
                Logger.f235387a.d().w("QQSearch.NetDetail.NetSearchHunYuanDepositary", 1, "getLineJsonObject error " + removePrefix + "; " + e16.getMessage());
                return null;
            }
        }
        return null;
    }

    private final String s(String prompt, String keyWord, String model, boolean userSelected) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String a16 = com.tencent.mobileqq.perf.upload.cos.a.f258277a.a(String.valueOf(currentTimeMillis), "Uv38ByGCZU8WP18PmmIdcg==");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Extra(QCircleAlphaUserReporter.KEY_USER, keyWord));
        return new ReqBody(true, arrayList, prompt, a16, model, currentTimeMillis, userSelected).toJson();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0062 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x005f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t(BufferedSource source, b callback) {
        boolean z16;
        boolean startsWith$default;
        boolean z17;
        boolean z18;
        boolean isBlank;
        callback.z();
        String str = "";
        boolean z19 = true;
        int i3 = 0;
        boolean z26 = false;
        while (!source.exhausted()) {
            if (this.isCanceled) {
                Logger.f235387a.d().w("QQSearch.NetDetail.NetSearchHunYuanDepositary", 1, "uuid=" + ((Object) str) + " canceled by user");
                b.a.a(callback, "canceled", null, null, 6, null);
                return;
            }
            String readUtf8Line = source.readUtf8Line();
            if (readUtf8Line != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(readUtf8Line);
                if (!isBlank) {
                    z16 = false;
                    if (z16) {
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(readUtf8Line, "data:{\"error\":", false, 2, null);
                        if (startsWith$default) {
                            Logger.f235387a.d().i("QQSearch.NetDetail.NetSearchHunYuanDepositary", 1, "onResponse uuid=" + ((Object) str) + " lineIndex=" + i3 + " error=" + readUtf8Line);
                            b.a.a(callback, "others", null, null, 6, null);
                            return;
                        }
                        if (Intrinsics.areEqual(readUtf8Line, "data:data: [DONE]")) {
                            Logger.f235387a.d().i("QQSearch.NetDetail.NetSearchHunYuanDepositary", 1, "uuid=" + ((Object) str) + " lineIndex=" + i3 + " succ end");
                            callback.onComplete();
                            return;
                        }
                        Logger logger = Logger.f235387a;
                        if (QLog.isDevelopLevel()) {
                            Log.d("QQSearch.NetDetail.NetSearchHunYuanDepositary", "receive uuid=" + ((Object) str) + " lineIndex=" + i3 + " content=" + readUtf8Line);
                        }
                        i3++;
                        JSONObject r16 = r(readUtf8Line);
                        if (r16 == null) {
                            continue;
                        } else {
                            if (z19) {
                                p(r16, callback);
                                Pair<String, String> n3 = n(r16);
                                if (n3.getFirst().length() > 0) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                if (z18) {
                                    Logger.f235387a.d().w("QQSearch.NetDetail.NetSearchHunYuanDepositary", 1, "receive error. uuid=" + ((Object) str) + " lineIndex=" + i3 + " error=" + n3 + " mode=" + af.b(readUtf8Line, 0, 2, null));
                                    callback.I1("backEndError", n3.getFirst(), n3.getSecond());
                                    return;
                                }
                                z19 = false;
                            }
                            if (!z26 && (!q(r16, callback).isEmpty())) {
                                z26 = true;
                            }
                            Pair<String, String> m3 = m(r16);
                            String first = m3.getFirst();
                            if (o(r16, m3.getSecond(), callback)) {
                                return;
                            }
                            if (m3.getSecond().length() > 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17) {
                                callback.s0(m3.getFirst(), m3.getSecond());
                            }
                            str = first;
                        }
                    } else {
                        i3++;
                    }
                }
            }
            z16 = true;
            if (z16) {
            }
        }
        Logger.f235387a.d().i("QQSearch.NetDetail.NetSearchHunYuanDepositary", 1, "complate uuid=" + ((Object) str) + " lineIndex=" + i3 + " findRef=" + z26);
        callback.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(long errorCode, String errorMsg) {
        IPerformanceReportTask iPerformanceReportTask = this.resultReportTask;
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setResultCode(errorCode);
        }
        IPerformanceReportTask iPerformanceReportTask2 = this.resultReportTask;
        if (iPerformanceReportTask2 != null) {
            iPerformanceReportTask2.setResultMsg(errorMsg);
        }
        IPerformanceReportTask iPerformanceReportTask3 = this.resultReportTask;
        if (iPerformanceReportTask3 != null) {
            iPerformanceReportTask3.report();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(ICheckAIAuthCallback result, long j3, String questionId, String query, int i3, String str, UfsCheckAIAuthRsp ufsCheckAIAuthRsp) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(questionId, "$questionId");
        Intrinsics.checkNotNullParameter(query, "$query");
        Logger.f235387a.d().i("QQSearch.NetDetail.NetSearchHunYuanDepositary", 1, "checkAIAuth result " + i3 + " robotUin=" + j3 + " questionId=" + questionId + " query=" + query + " " + str);
        result.onResult(i3, str, ufsCheckAIAuthRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(String prompt, String keyWord, String model, String psKey, boolean userSelected, b callback) {
        Call call = this.call;
        if (call != null) {
            call.cancel();
        }
        MediaType mediaType = MediaType.INSTANCE.get("application/json; charset=utf-8");
        String uin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        String s16 = s(prompt, keyWord, model, userSelected);
        Request.Builder addHeader = new Request.Builder().url("https://qun.qq.com/qunng/sse/qqsearch/ai/v1/getaicontent").addHeader("Content-Type", "application/json");
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        Request.Builder addHeader2 = addHeader.addHeader("Uin", uin).addHeader("Cookie", k(uin, psKey)).addHeader("client_plat_id", QAdVrReportParams.ClickAdActionTypeValue.ACTION_TYPE_NO_JUMP);
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "sMobileQQ.applicationContext");
        Request build = addHeader2.addHeader("client_version", AppSetting.getVersionCode(applicationContext)).post(RequestBody.INSTANCE.create(s16, mediaType)).build();
        if (!AppSetting.isPublicVersion()) {
            Logger.f235387a.d().i("QQSearch.NetDetail.NetSearchHunYuanDepositary", 1, "send requestBody=" + s16 + " ");
        }
        this.handler.removeCallbacks(this.timeoutCheckTask);
        this.handler.postDelayed(this.timeoutCheckTask, 120000L);
        Call newCall = this.client.newCall(build);
        newCall.enqueue(new d(callback, newCall, this));
        this.call = newCall;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(NetSearchHunYuanDepositary this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Call call = this$0.call;
        if (call != null && !call.getCanceled()) {
            b bVar = this$0.callback;
            if (bVar != null) {
                b.a.a(bVar, "timeout", null, null, 6, null);
            }
            call.cancel();
        }
    }

    public final void l() {
        this.isCanceled = true;
        Call call = this.call;
        if (call != null) {
            call.cancel();
        }
        this.handler.removeCallbacks(this.timeoutCheckTask);
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.NetSearchHunYuanDepositary", 1, "cancelRequest", null);
    }

    public final void v(@NotNull final String query, @NotNull final String questionId, final long robotUin, @NotNull final ICheckAIAuthCallback result) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(questionId, "questionId");
        Intrinsics.checkNotNullParameter(result, "result");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String a16 = com.tencent.mobileqq.perf.upload.cos.a.f258277a.a(String.valueOf(currentTimeMillis), "Uv38ByGCZU8WP18PmmIdcg==");
        UfsCheckAIAuthReq ufsCheckAIAuthReq = new UfsCheckAIAuthReq();
        ufsCheckAIAuthReq.query = query;
        ufsCheckAIAuthReq.questionId = questionId;
        ufsCheckAIAuthReq.sign = a16;
        ufsCheckAIAuthReq.timestamp = currentTimeMillis;
        ufsCheckAIAuthReq.robotUin = robotUin;
        IKernelUnifySearchService c16 = n.c();
        if (c16 != null) {
            c16.checkAIAuth(ufsCheckAIAuthReq, new ICheckAIAuthCallback() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.ICheckAIAuthCallback
                public final void onResult(int i3, String str, UfsCheckAIAuthRsp ufsCheckAIAuthRsp) {
                    NetSearchHunYuanDepositary.w(ICheckAIAuthCallback.this, robotUin, questionId, query, i3, str, ufsCheckAIAuthRsp);
                }
            });
        }
    }

    public final void x(@NotNull String prompt, @NotNull String keyWord, @NotNull String model, boolean userSelected, @NotNull b callback) {
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(keyWord, "keyWord");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        Reporters reporters = Reporters.f231995a;
        this.firstContentReportTask = reporters.c().a("search_ai_card_request_first_word");
        this.resultReportTask = reporters.c().a("search_ai_card_request_quality");
        IRuntimeService runtimeService = ((AppInterface) peekAppRuntime).getRuntimeService(IPskeyManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IP\u2026va, ProcessConstant.MAIN)");
        ((IPskeyManager) runtimeService).getPskey(new String[]{FlockBaseRequest.QUN_DOMAIN}, new NetSearchHunYuanDepositary$sendRequest$psKeyCallback$1(this, prompt, keyWord, model, userSelected, callback));
    }
}
