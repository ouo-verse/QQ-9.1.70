package com.tencent.biz.qqcircle.widgets;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.wink.QCirclePublishProgress;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.api.IQQWinkEditorDraftCleanAPI;
import com.tencent.mobileqq.wink.publish.api.IWinkDraft;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\"B\t\b\u0002\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J+\u0010\u0017\u001a\u00020\u00022!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00020\u0011H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u001a\u0010\u001b\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u000fJ\u0010\u0010\u001c\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R \u0010,\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00040(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R \u0010/\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020-0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010+R \u00101\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020-0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010+R \u00103\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020-0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010+R\u0018\u00106\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u00105R\u0016\u00108\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u00107R(\u0010>\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u0001098\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0006\u0010;\u001a\u0004\b<\u0010=R \u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120@0?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010AR\u0014\u0010E\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010D\u00a8\u0006H"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/QCirclePublishCallbackHelper;", "", "", "r", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "k", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ReportConstant.COSTREPORT_PREFIX, "y", HippyTKDListViewAdapter.X, "", "j", "Lkotlin/Function1;", "Lcom/tencent/biz/qqcircle/widgets/a;", "Lkotlin/ParameterName;", "name", "callback", "block", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", "notifyImmediately", "i", "v", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "b", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "mCallback", "Lcom/tencent/biz/qqcircle/widgets/QCirclePublishCallbackHelper$c;", "c", "Lcom/tencent/biz/qqcircle/widgets/QCirclePublishCallbackHelper$c;", "retryConfig", "d", "Z", "isApplicationBackground", "Ljava/util/concurrent/ConcurrentHashMap;", "", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "mCurrentTask", "", "f", "mTaskState", "g", "mUploadTaskProgress", tl.h.F, "mExportTaskProgress", "Lcom/tencent/mobileqq/winkpublish/model/params/WinkPublishParams;", "Lcom/tencent/mobileqq/winkpublish/model/params/WinkPublishParams;", "retryTaskParams", "J", "retryTaskId", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "<set-?>", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "getService", "()Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "service", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mPublishCallbackList", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "retryRunnable", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QCirclePublishCallbackHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QCirclePublishCallbackHelper f93064a = new QCirclePublishCallbackHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ITaskListener.Stub mCallback = new a();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static RetryConfig retryConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isApplicationBackground;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Long, TaskInfo> mCurrentTask;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Long, Integer> mTaskState;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Long, Integer> mUploadTaskProgress;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Long, Integer> mExportTaskProgress;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WinkPublishParams retryTaskParams;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static long retryTaskId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile WinkPublishServiceProxy2 service;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<WeakReference<com.tencent.biz.qqcircle.widgets.a>> mPublishCallbackList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Runnable retryRunnable;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/widgets/QCirclePublishCallbackHelper$a", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "", "onTaskChange", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class a extends ITaskListener.Stub {
        a() {
        }

        @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
        public void onTaskChange(@NotNull TaskInfo taskInfo) {
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
            QCirclePublishCallbackHelper.f93064a.k(taskInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\b\u0082\b\u0018\u0000 \u00102\u00020\u0001:\u0001\tB%\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/QCirclePublishCallbackHelper$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "enable", "", "J", "d", "()J", "retryDelayMs", "", "c", "Ljava/util/List;", "()Ljava/util/List;", "retryCodePrefix", "<init>", "(ZJLjava/util/List;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.widgets.QCirclePublishCallbackHelper$c, reason: from toString */
    /* loaded from: classes5.dex */
    public static final /* data */ class RetryConfig {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        private static final String f93078e = "{\n    \"enable\": true,\n    \"retryDelayMs\": 60000,\n    \"retryCodePrefix\": [\"12\"]\n}";

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean enable;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long retryDelayMs;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<String> retryCodePrefix;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/QCirclePublishCallbackHelper$c$a;", "", "Lcom/tencent/biz/qqcircle/widgets/QCirclePublishCallbackHelper$c;", "a", "", "DEFAULT_CONFIG_JSON", "Ljava/lang/String;", "", "DEFAULT_RETRY_DELAY_MS", "J", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.biz.qqcircle.widgets.QCirclePublishCallbackHelper$c$a, reason: from kotlin metadata */
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final RetryConfig a() {
                String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("102426", RetryConfig.f93078e);
                QLog.d("QCirclePublishCallbackHelper", 1, "[parse] configStr=" + loadAsString);
                try {
                    JSONObject jSONObject = new JSONObject(loadAsString);
                    RetryConfig retryConfig = new RetryConfig(jSONObject.optBoolean("enable", false), jSONObject.optLong("retryDelayMs", 60000L), com.tencent.mobileqq.perf.process.config.g.a(jSONObject, "retryCodePrefix"));
                    QLog.d("QCirclePublishCallbackHelper", 1, "[parse] config=" + retryConfig);
                    return retryConfig;
                } catch (Exception e16) {
                    QLog.e("QCirclePublishCallbackHelper", 1, "[parse] ", e16);
                    QLog.d("QCirclePublishCallbackHelper", 1, "[parse] no parse");
                    return new RetryConfig(false, 60000L, new ArrayList());
                }
            }

            Companion() {
            }
        }

        public RetryConfig(boolean z16, long j3, @NotNull List<String> retryCodePrefix) {
            Intrinsics.checkNotNullParameter(retryCodePrefix, "retryCodePrefix");
            this.enable = z16;
            this.retryDelayMs = j3;
            this.retryCodePrefix = retryCodePrefix;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getEnable() {
            return this.enable;
        }

        @NotNull
        public final List<String> c() {
            return this.retryCodePrefix;
        }

        /* renamed from: d, reason: from getter */
        public final long getRetryDelayMs() {
            return this.retryDelayMs;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RetryConfig)) {
                return false;
            }
            RetryConfig retryConfig = (RetryConfig) other;
            if (this.enable == retryConfig.enable && this.retryDelayMs == retryConfig.retryDelayMs && Intrinsics.areEqual(this.retryCodePrefix, retryConfig.retryCodePrefix)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z16 = this.enable;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((r06 * 31) + androidx.fragment.app.a.a(this.retryDelayMs)) * 31) + this.retryCodePrefix.hashCode();
        }

        @NotNull
        public String toString() {
            return "RetryConfig(enable=" + this.enable + ", retryDelayMs=" + this.retryDelayMs + ", retryCodePrefix=" + this.retryCodePrefix + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/widgets/QCirclePublishCallbackHelper$d", "Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2$Callback;", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "service", "", "onServiceConnected", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class d implements WinkPublishHelper2.Callback {
        d() {
        }

        @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
        public void onServiceConnected(@NotNull WinkPublishServiceProxy2 service) {
            Intrinsics.checkNotNullParameter(service, "service");
            QLog.d("QCirclePublishCallbackHelper", 1, "onServiceConnected, service: " + service);
            QCirclePublishCallbackHelper.service = service;
            if (!service.addTaskListener(QCirclePublishCallbackHelper.mCallback) && Intrinsics.areEqual("1", ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_wink_publish_qipc_open", "1"))) {
                WinkPublishHelper2.INSTANCE.addTaskListener(QCirclePublishCallbackHelper.mCallback, 1);
            }
        }
    }

    static {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.m
            @Override // java.lang.Runnable
            public final void run() {
                QCirclePublishCallbackHelper.d();
            }
        });
        GuardManagerCallbackDispatcher.registerCallBack(new b());
        mCurrentTask = new ConcurrentHashMap<>();
        mTaskState = new ConcurrentHashMap<>();
        mUploadTaskProgress = new ConcurrentHashMap<>();
        mExportTaskProgress = new ConcurrentHashMap<>();
        retryTaskId = -1L;
        mPublishCallbackList = new CopyOnWriteArrayList<>();
        retryRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.n
            @Override // java.lang.Runnable
            public final void run() {
                QCirclePublishCallbackHelper.w();
            }
        };
    }

    QCirclePublishCallbackHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        f93064a.r();
    }

    private final boolean j(TaskInfo taskInfo) {
        WinkPublishParams winkPublishParams;
        try {
        } catch (Exception e16) {
            QLog.e("QCirclePublishCallbackHelper", 1, "[checkTaskRetry] ", e16);
        }
        if (!isApplicationBackground) {
            QLog.i("QCirclePublishCallbackHelper", 1, "[checkTaskRetry] not in background");
            return false;
        }
        RetryConfig a16 = RetryConfig.INSTANCE.a();
        if (!a16.getEnable()) {
            QLog.i("QCirclePublishCallbackHelper", 1, "[checkTaskRetry] not enable retry");
            return false;
        }
        retryConfig = a16;
        if (!taskInfo.isTrueUpload()) {
            QLog.i("QCirclePublishCallbackHelper", 1, "[checkTaskRetry] not true upload");
            return false;
        }
        if (!taskInfo.isCancelled()) {
            QLog.i("QCirclePublishCallbackHelper", 1, "[checkTaskRetry] not canceled task");
            return false;
        }
        Bundle transParams = taskInfo.getTransParams();
        if (transParams != null) {
            transParams.setClassLoader(WinkPublishParams.class.getClassLoader());
        }
        Bundle transParams2 = taskInfo.getTransParams();
        if (transParams2 != null) {
            winkPublishParams = (WinkPublishParams) transParams2.getParcelable("qcircle_wink_task_launch_params");
        } else {
            winkPublishParams = null;
        }
        if (winkPublishParams == null) {
            QLog.i("QCirclePublishCallbackHelper", 1, "[checkTaskRetry] no launch params");
            return false;
        }
        String substring = String.valueOf(Math.abs(Long.parseLong(taskInfo.getErrCode()))).substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        if (a16.c().contains(substring)) {
            return true;
        }
        QLog.i("QCirclePublishCallbackHelper", 1, "[checkTaskRetry] not match error code, " + taskInfo.getErrCode() + ", " + substring);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(TaskInfo taskInfo) {
        QLog.d("QCirclePublishCallbackHelper", 1, "handleTaskChange, taskId: " + taskInfo.getTaskId() + ", state: " + taskInfo.getState() + ", isTrueUpload: " + taskInfo.isTrueUpload() + ", isSuccess: " + taskInfo.isSuccess() + ", errorCode=" + taskInfo.getErrCode() + ", errorMsg=" + taskInfo.getErrMsg() + ", progress: " + taskInfo.getUploadProgress() + ", doNotShowProgress:" + p.a(taskInfo));
        y(taskInfo);
        if (p.a(taskInfo) || !taskInfo.isTrueUpload()) {
            return;
        }
        q(taskInfo);
        p(taskInfo);
        o(taskInfo);
    }

    private final void l(com.tencent.biz.qqcircle.widgets.a callback) {
        Collection<TaskInfo> values = mCurrentTask.values();
        Intrinsics.checkNotNullExpressionValue(values, "mCurrentTask.values");
        for (TaskInfo it : values) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            callback.onTaskStateChanged(it);
        }
    }

    private final void m(final TaskInfo taskInfo) {
        t(new Function1<com.tencent.biz.qqcircle.widgets.a, Unit>() { // from class: com.tencent.biz.qqcircle.widgets.QCirclePublishCallbackHelper$onTaskProgressChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a callback) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                callback.onProgressChanged(TaskInfo.this);
            }
        });
        if (p.c(taskInfo)) {
            QCirclePublishProgress.f93922d.f(taskInfo);
        }
    }

    private final void n(final TaskInfo taskInfo) {
        t(new Function1<com.tencent.biz.qqcircle.widgets.a, Unit>() { // from class: com.tencent.biz.qqcircle.widgets.QCirclePublishCallbackHelper$onTaskStateChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a callback) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                callback.onTaskStateChanged(TaskInfo.this);
            }
        });
        if (p.d(taskInfo)) {
            s(taskInfo);
            x(taskInfo);
        }
        z(taskInfo);
        if (p.c(taskInfo)) {
            QCirclePublishProgress.f93922d.g(taskInfo);
        }
    }

    private final void o(TaskInfo taskInfo) {
        if (taskInfo.getUploadProgress() <= 0 && taskInfo.getExportProgress() <= 0) {
            return;
        }
        ConcurrentHashMap<Long, Integer> concurrentHashMap = mUploadTaskProgress;
        Integer num = concurrentHashMap.get(Long.valueOf(taskInfo.getTaskId()));
        ConcurrentHashMap<Long, Integer> concurrentHashMap2 = mExportTaskProgress;
        Integer num2 = concurrentHashMap2.get(Long.valueOf(taskInfo.getTaskId()));
        int uploadProgress = taskInfo.getUploadProgress();
        if (num != null && uploadProgress == num.intValue()) {
            int exportProgress = taskInfo.getExportProgress();
            if (num2 != null && exportProgress == num2.intValue()) {
                return;
            }
        }
        concurrentHashMap.put(Long.valueOf(taskInfo.getTaskId()), Integer.valueOf(taskInfo.getUploadProgress()));
        concurrentHashMap2.put(Long.valueOf(taskInfo.getTaskId()), Integer.valueOf(taskInfo.getExportProgress()));
        m(taskInfo);
    }

    private final void p(TaskInfo taskInfo) {
        ConcurrentHashMap<Long, Integer> concurrentHashMap = mTaskState;
        Integer num = concurrentHashMap.get(Long.valueOf(taskInfo.getTaskId()));
        int state = taskInfo.getState();
        if (num == null || state != num.intValue()) {
            concurrentHashMap.put(Long.valueOf(taskInfo.getTaskId()), Integer.valueOf(state));
            n(taskInfo);
        }
    }

    private final void q(TaskInfo taskInfo) {
        mCurrentTask.put(Long.valueOf(taskInfo.getTaskId()), taskInfo);
    }

    private final void r() {
        WinkPublishHelper2.INSTANCE.bindService(1, new d());
    }

    private final void s(TaskInfo taskInfo) {
        long taskId = taskInfo.getTaskId();
        mCurrentTask.remove(Long.valueOf(taskId));
        mTaskState.remove(Long.valueOf(taskId));
        mUploadTaskProgress.remove(Long.valueOf(taskId));
        mExportTaskProgress.remove(Long.valueOf(taskId));
    }

    private final void t(final Function1<? super com.tencent.biz.qqcircle.widgets.a, Unit> block) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = mPublishCallbackList.iterator();
        while (it.hasNext()) {
            WeakReference it5 = (WeakReference) it.next();
            final com.tencent.biz.qqcircle.widgets.a aVar = (com.tencent.biz.qqcircle.widgets.a) it5.get();
            if (aVar != null) {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        QCirclePublishCallbackHelper.u(Function1.this, aVar);
                    }
                });
            } else {
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                arrayList.add(it5);
            }
        }
        if (!arrayList.isEmpty()) {
            mPublishCallbackList.removeAll(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 block, com.tencent.biz.qqcircle.widgets.a callback) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        block.invoke(callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w() {
        Integer num;
        long j3;
        TaskInfo addTask;
        boolean z16 = isApplicationBackground;
        WinkPublishParams winkPublishParams = retryTaskParams;
        Unit unit = null;
        if (winkPublishParams != null) {
            num = Integer.valueOf(winkPublishParams.hashCode());
        } else {
            num = null;
        }
        QLog.i("QCirclePublishCallbackHelper", 1, "retry task, isBackground=" + z16 + ", params=" + num);
        if (!isApplicationBackground) {
            QLog.i("QCirclePublishCallbackHelper", 1, "retry task, app not in background");
            return;
        }
        if (!NetworkUtil.isWifiConnected(BaseApplication.context)) {
            QLog.i("QCirclePublishCallbackHelper", 1, "retry task, wifi not connected");
            return;
        }
        WinkPublishParams winkPublishParams2 = retryTaskParams;
        if (winkPublishParams2 != null) {
            WinkPublishServiceProxy2 winkPublishServiceProxy2 = service;
            if (winkPublishServiceProxy2 != null && (addTask = winkPublishServiceProxy2.addTask(winkPublishParams2)) != null) {
                j3 = addTask.getTaskId();
            } else {
                j3 = -1;
            }
            retryTaskId = j3;
            QLog.i("QCirclePublishCallbackHelper", 1, "retry task, add task id=" + j3);
            WinkPublishReportQueue.INSTANCE.report(new WinkPublishQualityReportData("E_QCIRCLE_WINK_TASK_RETRY", winkPublishParams2.getTraceId(), null, String.valueOf(retryTaskId), null, null, null, null, null, null, null, null, null, null, 0L, 32756, null), winkPublishParams2.getBusinessType());
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.i("QCirclePublishCallbackHelper", 1, "retry task, invalid publish params");
        }
    }

    private final void x(TaskInfo taskInfo) {
        long j3;
        if (j(taskInfo)) {
            QLog.i("QCirclePublishCallbackHelper", 1, "[tryAddRetryTask] can add retry task");
            Bundle transParams = taskInfo.getTransParams();
            if (transParams != null) {
                transParams.setClassLoader(WinkPublishParams.class.getClassLoader());
                WinkPublishParams winkPublishParams = (WinkPublishParams) transParams.getParcelable("qcircle_wink_task_launch_params");
                if (winkPublishParams != null) {
                    QLog.i("QCirclePublishCallbackHelper", 1, "[tryAddRetryTask] pending retry task");
                    Bundle transParams2 = winkPublishParams.getTransParams();
                    if (transParams2 != null) {
                        transParams2.remove("qcircle_wink_task_launch_params");
                    }
                    retryTaskParams = winkPublishParams;
                    RetryConfig retryConfig2 = retryConfig;
                    if (retryConfig2 != null) {
                        j3 = retryConfig2.getRetryDelayMs();
                    } else {
                        j3 = 60000;
                    }
                    RFWThreadManager.getUIHandler().postDelayed(retryRunnable, j3);
                }
            }
        }
    }

    private final void y(TaskInfo taskInfo) {
        if (retryTaskParams != null && retryTaskId != taskInfo.getTaskId()) {
            QLog.i("QCirclePublishCallbackHelper", 1, "[cancelRetryTask] taskId=" + retryTaskId);
            retryTaskParams = null;
            retryTaskId = -1L;
            RFWThreadManager.getUIHandler().removeCallbacks(retryRunnable);
        }
    }

    private final void z(TaskInfo taskInfo) {
        int i3;
        String b16 = p.b(taskInfo);
        QLog.d("QCirclePublishCallbackHelper", 1, "updateDraftUploadStatus, missionId: " + b16);
        if (TextUtils.isEmpty(b16)) {
            return;
        }
        if (taskInfo.isSuccess()) {
            ((IWinkDraft) QRoute.api(IWinkDraft.class)).delete(HostDataTransUtils.getLongAccountUin(), b16);
            ((IQQWinkEditorDraftCleanAPI) QRoute.api(IQQWinkEditorDraftCleanAPI.class)).deleteQCircleDraft(b16);
            return;
        }
        if (taskInfo.isActive()) {
            ((IWinkDraft) QRoute.api(IWinkDraft.class)).updateUploadStatus(HostDataTransUtils.getLongAccountUin(), b16, 2);
            return;
        }
        if (p.d(taskInfo)) {
            IWinkDraft iWinkDraft = (IWinkDraft) QRoute.api(IWinkDraft.class);
            long longAccountUin = HostDataTransUtils.getLongAccountUin();
            if (taskInfo.isSuccess()) {
                i3 = 4;
            } else {
                i3 = 3;
            }
            iWinkDraft.updateUploadStatus(longAccountUin, b16, i3);
        }
    }

    public final void i(@Nullable com.tencent.biz.qqcircle.widgets.a callback, boolean notifyImmediately) {
        boolean z16;
        if (callback == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = mPublishCallbackList.iterator();
        while (true) {
            if (it.hasNext()) {
                WeakReference it5 = (WeakReference) it.next();
                com.tencent.biz.qqcircle.widgets.a aVar = (com.tencent.biz.qqcircle.widgets.a) it5.get();
                if (aVar != null) {
                    if (Intrinsics.areEqual(aVar, callback)) {
                        z16 = true;
                        break;
                    }
                } else {
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    arrayList.add(it5);
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            mPublishCallbackList.add(new WeakReference<>(callback));
            if (notifyImmediately) {
                l(callback);
            }
        }
        if (!arrayList.isEmpty()) {
            mPublishCallbackList.removeAll(arrayList);
        }
    }

    public final void v(@Nullable com.tencent.biz.qqcircle.widgets.a callback) {
        if (callback == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = mPublishCallbackList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WeakReference it5 = (WeakReference) it.next();
            com.tencent.biz.qqcircle.widgets.a aVar = (com.tencent.biz.qqcircle.widgets.a) it5.get();
            if (aVar != null) {
                if (Intrinsics.areEqual(aVar, callback)) {
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    arrayList.add(it5);
                    break;
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                arrayList.add(it5);
            }
        }
        if (!arrayList.isEmpty()) {
            mPublishCallbackList.removeAll(arrayList);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/biz/qqcircle/widgets/QCirclePublishCallbackHelper$b", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b implements IGuardInterface {
        b() {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            QLog.i("QCirclePublishCallbackHelper", 1, "[onApplicationBackground]");
            QCirclePublishCallbackHelper.isApplicationBackground = true;
            QCirclePublishProgress.f93922d.h();
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            QLog.i("QCirclePublishCallbackHelper", 1, "[onApplicationForeground]");
            QCirclePublishCallbackHelper.isApplicationBackground = false;
            QCirclePublishProgress.f93922d.i();
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean isEnabled) {
        }
    }
}
