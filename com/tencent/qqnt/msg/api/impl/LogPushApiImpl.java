package com.tencent.qqnt.msg.api.impl;

import android.os.Build;
import android.text.TextUtils;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.inject.l;
import com.tencent.mobileqq.injector.t;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.log.report.LogReport;
import com.tencent.qphone.base.util.log.report.ReportLogInfoContext;
import com.tencent.qqnt.msg.api.ILogPushApi;
import com.tencent.qqnt.msg.api.ILogPushExternalApi;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.data.h;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.tencent.trpcprotocol.qqlog.qqlog_manage.QqlogManage$MsgBody;
import com.tencent.trpcprotocol.qqlog.qqlog_manage.QqlogManage$Param;
import com.tencent.trpcprotocol.qqlog.qqlog_server.QqlogServer$ClientDevice;
import com.tencent.trpcprotocol.qqlog.qqlog_server.QqlogServer$LogFile;
import com.tencent.trpcprotocol.qqlog.qqlog_server.QqlogServer$Process;
import com.tencent.trpcprotocol.qqlog.qqlog_server.QqlogServer$SsoReportReq;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.DelicateCoroutinesApi;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.nt_im_msg_body$MsgBody;
import tencent.im.msg.nt_sys_msg_common$Msg;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0002KN\u0018\u0000 S2\u00020\u0001:\u0001TB\u0007\u00a2\u0006\u0004\bQ\u0010RJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J0\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J,\u0010\u001d\u001a\u00020\u00042\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u00192\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fH\u0002J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0011H\u0002J4\u0010(\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\"\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140%j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014`&H\u0002J>\u0010+\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010#2\"\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140%j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014`&H\u0002J\u0010\u0010,\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0014H\u0002J\b\u0010/\u001a\u00020\u0004H\u0007J\b\u00100\u001a\u00020\u0004H\u0017J(\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fH\u0016R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b<\u0010;R\u0014\u0010=\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010;R\u0016\u0010B\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010;R\"\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010F\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006U"}, d2 = {"Lcom/tencent/qqnt/msg/api/impl/LogPushApiImpl;", "Lcom/tencent/qqnt/msg/api/ILogPushApi;", "Lcom/tencent/qqnt/msg/data/h;", "it", "", "handleKernelMsg", "Lcom/tencent/trpcprotocol/qqlog/qqlog_manage/QqlogManage$MsgBody;", "qlogMsgBody", "", "isLastLogUploadNotOver", "filterRepeatSeq", "filterIllegalSeq", "", "seq", "checkSeqExist", "clearSeqs", "qlogPushSeq", "", AdMetricTag.Report.TYPE, "processStatus", "", "processStatusDes", "", "processUploadNum", "qlogUploadStatusReportProcess", "", "params", "startTime", "endTime", "handleExtraParams", "Ljava/io/File;", "zipLogFile", "handleUploadLogZipFile", "stats", "handleReportLogState", "", "respData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", CacheTable.TABLE_NAME, "transactionSuccess", "retCode", "arg1", "transactionFailed", "isOverMaxFileUpload", "reason", "overLimitReport", "initInject", "register", "uin", "handleTxcActiveReportLog", "Lcom/tencent/trpcprotocol/qqlog/qqlog_server/QqlogServer$LogFile;", "mLogFile", "Lcom/tencent/trpcprotocol/qqlog/qqlog_server/QqlogServer$LogFile;", "mQlogPushSeq", "J", "mLogUploading", "Z", "mLogFileLimit", "I", "mWifiFileLimit", "mMobileFileLimit", "Lkotlinx/coroutines/Job;", "receiveSysMsgNotificationJob", "Lkotlinx/coroutines/Job;", "mCurrentTypeReportDevice", "mCurrentTypeReportProcess", "mExtraParamsMap", "Ljava/util/Map;", "Lcom/tencent/mobileqq/inject/l;", "logOpenTelemetry", "Lcom/tencent/mobileqq/inject/l;", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "com/tencent/qqnt/msg/api/impl/LogPushApiImpl$b", "transactionCallback", "Lcom/tencent/qqnt/msg/api/impl/LogPushApiImpl$b;", "com/tencent/qqnt/msg/api/impl/LogPushApiImpl$c", "uploadLogListener", "Lcom/tencent/qqnt/msg/api/impl/LogPushApiImpl$c;", "<init>", "()V", "Companion", "a", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class LogPushApiImpl implements ILogPushApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String LOG_UPLOAD_SEQ_KEY = "log_file_upload_seq_mmkv_key";

    @NotNull
    private static final String LOG_UPLOAD_TIMEOUT_KEY = "log_file_upload_time_out_mmkv_key";

    @NotNull
    private static final String PUBLISH_KEY = "1e8eec1d829649d24d1abc31f12acc6a8f0e92092b6a5ead027fd4bbfe169841ca681925e01bca187364fe0e0d8e2ef6b482fc7dc619b6b0a24260ea7c5b05b4";

    @NotNull
    private static final String TAG = "LogPush.ILogPushApiImpl";
    private static ArrayList logOpenTelemetry_AutoGenClazzList_QAutoInjectTransform;

    @NotNull
    private final MMKVOptionEntity entity;

    @QAutoInject(configPath = "AutoInjectYml/Business/Log/Inject_LogPushUpload.yml", version = 1)
    @Nullable
    private l logOpenTelemetry;
    private int mCurrentTypeReportDevice;
    private int mCurrentTypeReportProcess;

    @NotNull
    private Map<String, String> mExtraParamsMap;

    @NotNull
    private QqlogServer$LogFile mLogFile;
    private int mLogFileLimit;
    private boolean mLogUploading;
    private final int mMobileFileLimit;
    private long mQlogPushSeq;
    private final int mWifiFileLimit;

    @Nullable
    private Job receiveSysMsgNotificationJob;

    @NotNull
    private final b transactionCallback;

    @NotNull
    private final c uploadLogListener;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/msg/api/impl/LogPushApiImpl$a;", "", "", "LOG_UPLOAD_SEQ_KEY", "Ljava/lang/String;", "LOG_UPLOAD_TIMEOUT_KEY", "PUBLISH_KEY", "TAG", "<init>", "()V", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.msg.api.impl.LogPushApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J4\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bH\u0016J>\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/qqnt/msg/api/impl/LogPushApiImpl$b", "Lcom/tencent/mobileqq/highway/api/ITransactionCallback;", "", "transferedSize", "", "onUpdateProgress", "onSwitch2BackupChannel", "", "respData", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", CacheTable.TABLE_NAME, "onSuccess", "retCode", "arg1", "onFailed", "onTransStart", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements ITransactionCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LogPushApiImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onFailed(int retCode, @Nullable byte[] arg1, @NotNull HashMap<String, String> reportInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(retCode), arg1, reportInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
            LogPushApiImpl.this.transactionFailed(retCode, arg1, reportInfo);
            LogPushApiImpl.this.mLogUploading = false;
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onSuccess(@NotNull byte[] respData, @NotNull HashMap<String, String> reportInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) respData, (Object) reportInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(respData, "respData");
            Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
            LogPushApiImpl.this.transactionSuccess(respData, reportInfo);
            LogPushApiImpl.this.mLogUploading = false;
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onSwitch2BackupChannel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onTransStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            QLog.i(LogPushApiImpl.TAG, 1, "[onTransStart]");
            LogPushApiImpl logPushApiImpl = LogPushApiImpl.this;
            logPushApiImpl.qlogUploadStatusReportProcess(logPushApiImpl.mQlogPushSeq, LogPushApiImpl.this.mCurrentTypeReportProcess, 7, "\u5ba2\u6237\u7aef\u538b\u7f29\u5b8c\u6210\uff0c\u5f00\u59cb\u4e0a\u4f20\u65e5\u5fd7", 50.0d);
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onUpdateProgress(int transferedSize) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, transferedSize);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/msg/api/impl/LogPushApiImpl$c", "Lcom/tencent/qphone/base/util/log/report/ReportLogInfoContext$UploadLogListener;", "Ljava/io/File;", "zipLogFile", "", "uploadLogZipFile", "", "stats", "reportUploadLogState", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c implements ReportLogInfoContext.UploadLogListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LogPushApiImpl.this);
            }
        }

        @Override // com.tencent.qphone.base.util.log.report.ReportLogInfoContext.UploadLogListener
        public void reportUploadLogState(int stats) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                LogPushApiImpl.this.handleReportLogState(stats);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, stats);
            }
        }

        @Override // com.tencent.qphone.base.util.log.report.ReportLogInfoContext.UploadLogListener
        public void uploadLogZipFile(@Nullable File zipLogFile) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                LogPushApiImpl.this.handleUploadLogZipFile(zipLogFile);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) zipLogFile);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39848);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        ArrayList arrayList = new ArrayList();
        logOpenTelemetry_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(t.class);
        INSTANCE = new Companion(null);
    }

    public LogPushApiImpl() {
        Map<String, String> emptyMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mLogFile = new QqlogServer$LogFile();
        this.mQlogPushSeq = -1L;
        this.mWifiFileLimit = 500;
        this.mMobileFileLimit = 200;
        this.mCurrentTypeReportDevice = 1;
        this.mCurrentTypeReportProcess = 2;
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.mExtraParamsMap = emptyMap;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        this.entity = from;
        initInject();
        this.transactionCallback = new b();
        this.uploadLogListener = new c();
    }

    private final boolean checkSeqExist(long seq) {
        boolean contains$default;
        String valueOf = String.valueOf(seq);
        String existSeqs = this.entity.decodeString(LOG_UPLOAD_SEQ_KEY, "");
        QLog.i(TAG, 1, "checkSeqExist, seq=" + seq + ", seqStr=" + valueOf + ", existSeqs=" + existSeqs);
        if (!TextUtils.isEmpty(existSeqs)) {
            Intrinsics.checkNotNullExpressionValue(existSeqs, "existSeqs");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) existSeqs, (CharSequence) valueOf, false, 2, (Object) null);
            if (contains$default) {
                QLog.i(TAG, 1, "seqStr=" + valueOf + ", exist, do nothing!");
                return true;
            }
        }
        this.entity.encodeString(LOG_UPLOAD_SEQ_KEY, existSeqs + "," + valueOf + ",");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("seqStr=");
        sb5.append(valueOf);
        sb5.append(", normal, need upload log");
        QLog.i(TAG, 1, sb5.toString());
        return false;
    }

    private final void clearSeqs() {
        String decodeString = this.entity.decodeString(LOG_UPLOAD_SEQ_KEY, "");
        if (!TextUtils.isEmpty(decodeString) && decodeString.length() > 512) {
            this.entity.encodeString(LOG_UPLOAD_SEQ_KEY, ",");
            QLog.i(TAG, 1, "clear existSeqs!");
        }
    }

    private final boolean filterIllegalSeq(QqlogManage$MsgBody qlogMsgBody) {
        if (qlogMsgBody.seq.get() <= 10) {
            QLog.i(TAG, 1, "illegal seq !!!");
            qlogUploadStatusReportProcess(qlogMsgBody.seq.get(), this.mCurrentTypeReportProcess, 4, "\u5ba2\u6237\u7aef\u6536\u5230\u975e\u6cd5 seq", 0.0d);
            return true;
        }
        return false;
    }

    private final boolean filterRepeatSeq(QqlogManage$MsgBody qlogMsgBody) {
        if (checkSeqExist(qlogMsgBody.seq.get())) {
            QLog.i(TAG, 1, "checkSeqExist over, repeat seq!!!");
            qlogUploadStatusReportProcess(qlogMsgBody.seq.get(), this.mCurrentTypeReportProcess, 2, "\u5ba2\u6237\u7aef\u6536\u5230\u91cd\u590dPush\u547d\u4ee4\uff0cseq \u91cd\u590d", 0.0d);
            return true;
        }
        return false;
    }

    private final void handleExtraParams(Map<String, String> params, long startTime, long endTime) {
        try {
            ((ILogPushExternalApi) QRoute.api(ILogPushExternalApi.class)).handleLogReportExtraParams(params, startTime, endTime);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleExtraParams error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleKernelMsg(h it) {
        Map emptyMap;
        HashMap<String, String> hashMapOf;
        HashMap<String, String> hashMapOf2;
        List<QqlogManage$Param> list;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        QLog.i(TAG, 1, "log push data=" + it);
        QqlogManage$MsgBody qqlogManage$MsgBody = new QqlogManage$MsgBody();
        nt_sys_msg_common$Msg a16 = it.a();
        if (a16 != null) {
            nt_im_msg_body$MsgBody nt_im_msg_body_msgbody = a16.body;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (nt_im_msg_body_msgbody != null && nt_im_msg_body_msgbody.msg_content.get() != null) {
                qqlogManage$MsgBody.mergeFrom(nt_im_msg_body_msgbody.msg_content.get().toByteArray());
                QLog.i(TAG, 1, "seq=" + qqlogManage$MsgBody.seq.get() + ", cmd=" + qqlogManage$MsgBody.cmd.get() + ", log_tag=" + qqlogManage$MsgBody.log_tag.get() + ", start_time=" + qqlogManage$MsgBody.start_time.get() + ", end_time=" + qqlogManage$MsgBody.end_time.get() + ", log_size=" + qqlogManage$MsgBody.log_size.get() + ", platform=" + qqlogManage$MsgBody.platform.get() + ", product=" + qqlogManage$MsgBody.product.get() + ", log_field=" + qqlogManage$MsgBody.log_field.get() + ", log_level=" + qqlogManage$MsgBody.log_level.get() + ",");
                if (qqlogManage$MsgBody.cmd.get() == 1) {
                    if (filterIllegalSeq(qqlogManage$MsgBody) || filterRepeatSeq(qqlogManage$MsgBody) || isLastLogUploadNotOver(qqlogManage$MsgBody)) {
                        return;
                    }
                    this.mLogUploading = true;
                    this.entity.encodeLong(LOG_UPLOAD_TIMEOUT_KEY, System.currentTimeMillis());
                    this.mQlogPushSeq = qqlogManage$MsgBody.seq.get();
                    this.mLogFileLimit = qqlogManage$MsgBody.log_size.get();
                    this.mCurrentTypeReportDevice = 1;
                    this.mCurrentTypeReportProcess = 2;
                    PBRepeatMessageField<QqlogManage$Param> pBRepeatMessageField = qqlogManage$MsgBody.params;
                    if (pBRepeatMessageField == null || (list = pBRepeatMessageField.get()) == null) {
                        emptyMap = MapsKt__MapsKt.emptyMap();
                    } else {
                        List<QqlogManage$Param> list2 = list;
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                        emptyMap = new LinkedHashMap(coerceAtLeast);
                        for (QqlogManage$Param qqlogManage$Param : list2) {
                            Pair pair = TuplesKt.to(qqlogManage$Param.key.get(), qqlogManage$Param.value.get());
                            emptyMap.put(pair.getFirst(), pair.getSecond());
                        }
                    }
                    this.mExtraParamsMap = emptyMap;
                    handleExtraParams(this.mExtraParamsMap, qqlogManage$MsgBody.start_time.get(), qqlogManage$MsgBody.end_time.get());
                    qlogUploadStatusReportProcess(qqlogManage$MsgBody.seq.get(), this.mCurrentTypeReportDevice, 1, "\u5ba2\u6237\u7aef\u6536\u5230Push\u547d\u4ee4", 0.0d);
                    l lVar = this.logOpenTelemetry;
                    if (lVar != null) {
                        lVar.f();
                        lVar.g();
                        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("log_seq", String.valueOf(this.mQlogPushSeq)));
                        lVar.e(hashMapOf);
                        hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("log_trace_suceess", "-1"));
                        lVar.i("Log_upload_record", hashMapOf2);
                    }
                    LogReport.getInstance().onLogPushBy0x210_0x14f(this.uploadLogListener, qqlogManage$MsgBody, peekAppRuntime.getCurrentAccountUin());
                    return;
                }
                if (qqlogManage$MsgBody.cmd.get() == 2) {
                    if (qqlogManage$MsgBody.log_level.get() >= 1 && qqlogManage$MsgBody.log_level.get() <= 4) {
                        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ.getApplicationContext(), com.tencent.trpcprotocol.qqlog.qqlog_server.a.class);
                        newIntent.putExtra("action", 199);
                        newIntent.putExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_COLOR_LEVEL, qqlogManage$MsgBody.log_level.get());
                        newIntent.runNow = true;
                        peekAppRuntime.startServlet(newIntent);
                        return;
                    }
                    QLog.e(TAG, 1, "illegal log_level:" + qqlogManage$MsgBody.log_level.get());
                    return;
                }
                return;
            }
            QLog.i(TAG, 1, "body == null || body.msg_content.get() == null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleReportLogState(int stats) {
        HashMap<String, String> hashMapOf;
        HashMap<String, String> hashMapOf2;
        QLog.i(TAG, 1, "reportUploadLogState, stats=" + stats);
        if (stats != 20) {
            if (stats == 30) {
                qlogUploadStatusReportProcess(this.mQlogPushSeq, this.mCurrentTypeReportProcess, 7, "\u5ba2\u6237\u7aef\u538b\u7f29\u5b8c\u6210\uff0c\u5f00\u59cb\u4e0a\u4f20\u65e5\u5fd7", 0.0d);
                l lVar = this.logOpenTelemetry;
                if (lVar != null) {
                    hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("log_seq", String.valueOf(this.mQlogPushSeq)));
                    lVar.d(0, hashMapOf2);
                    return;
                }
                return;
            }
            return;
        }
        qlogUploadStatusReportProcess(this.mQlogPushSeq, this.mCurrentTypeReportProcess, 5, "\u5ba2\u6237\u7aef\u68c0\u7d22\u5b8c\u6210\uff0c\u6b63\u5728\u538b\u7f29\u65e5\u5fd7\u6587\u4ef6", 0.0d);
        l lVar2 = this.logOpenTelemetry;
        if (lVar2 != null) {
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("log_seq", String.valueOf(this.mQlogPushSeq)));
            lVar2.c(hashMapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleUploadLogZipFile(File zipLogFile) {
        String replace$default;
        String replace$default2;
        HashMap<String, String> hashMapOf;
        QLog.i(TAG, 1, "uploadLogZipFile, zipLogFile=" + zipLogFile);
        if (zipLogFile != null && zipLogFile.exists()) {
            if (isOverMaxFileUpload(zipLogFile)) {
                this.mLogUploading = false;
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
            BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
            HwEngine hwEngine = baseQQAppInterface.getHwEngine();
            byte[] fileMd5 = MD5.getFileMd5(zipLogFile.getAbsolutePath());
            com.tencent.qqnt.util.b bVar = com.tencent.qqnt.util.b.f362976b;
            replace$default = StringsKt__StringsJVMKt.replace$default("qqlog/Android_" + bVar.getVersion() + "_" + bVar.f() + "_" + baseQQAppInterface.getCurrentAccountUin() + "_" + this.mQlogPushSeq + "_" + zipLogFile.getName(), " ", "_", false, 4, (Object) null);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("uploadLogZipFile, uuid=");
            sb5.append((Object) replace$default);
            QLog.i(TAG, 1, sb5.toString());
            Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
            commFileExtReq.uint32_action_type.set(0);
            commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(replace$default));
            Transaction transaction = new Transaction(baseQQAppInterface.getCurrentAccountUin(), 2016, zipLogFile.getAbsolutePath(), 0, fileMd5, (ITransactionCallback) this.transactionCallback, commFileExtReq.toByteArray(), false);
            PBStringField pBStringField = this.mLogFile.log_file_name;
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "qqlog/", "", false, 4, (Object) null);
            pBStringField.set(replace$default2);
            this.mLogFile.log_size.set((int) zipLogFile.length());
            this.mLogFile.zip_log_size.set((int) zipLogFile.length());
            this.mLogFile.log_line_num.set(-1);
            this.mLogFile.file_uri.set(replace$default);
            this.mLogFile.public_key.set(PUBLISH_KEY);
            l lVar = this.logOpenTelemetry;
            if (lVar != null) {
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("log_seq", String.valueOf(this.mQlogPushSeq)), TuplesKt.to("log_file_path", replace$default));
                lVar.a(hashMapOf);
            }
            hwEngine.submitTransactionTask(transaction);
            return;
        }
        this.mLogUploading = false;
    }

    private final boolean isLastLogUploadNotOver(QqlogManage$MsgBody qlogMsgBody) {
        boolean z16;
        long decodeLong = this.entity.decodeLong(LOG_UPLOAD_TIMEOUT_KEY, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (decodeLong != 0 && currentTimeMillis - decodeLong < 600000) {
            QLog.i(TAG, 1, "mQlogPushSeq=" + this.mQlogPushSeq + ", mLogUploading=" + this.mLogUploading + ", isLastLogUploadTimeout=false");
            z16 = false;
        } else {
            z16 = true;
        }
        if (!this.mLogUploading || z16) {
            return false;
        }
        QLog.i(TAG, 1, "mQlogPushSeq=" + this.mQlogPushSeq + ", isLastLogUploadNotOver=true !!!");
        qlogUploadStatusReportProcess(qlogMsgBody.seq.get(), this.mCurrentTypeReportProcess, 4, "\u5ba2\u6237\u7aef\u4e0a\u4e00\u6b21 seq:" + this.mQlogPushSeq + ", \u635e\u65e5\u5fd7\u672a\u7ed3\u675f\uff0c\u660e\u786e\u4e0d\u652f\u6301\u5e76\u53d1\u635e\u65e5\u5fd7", 0.0d);
        return true;
    }

    private final boolean isOverMaxFileUpload(File zipLogFile) {
        if (this.mLogFileLimit > 0) {
            if (zipLogFile.length() / 1048576 > this.mLogFileLimit) {
                QLog.e(TAG, 1, "zipLogFile.length()=" + zipLogFile.length() + ", mLogFileLimit=" + this.mLogFileLimit + ", over limit!");
                overLimitReport("\u65e5\u5fd7\u5927\u5c0f\u8d85\u8fc7\u81ea\u5b9a\u4e49\u7684\u6700\u5927\u9650\u5236");
                return true;
            }
            return false;
        }
        if (AppNetConnInfo.isWifiConn()) {
            if (zipLogFile.length() / 1048576 > this.mWifiFileLimit) {
                QLog.e(TAG, 1, "zipLogFile.length()=" + zipLogFile.length() + ", wifi, over 500M limit!");
                overLimitReport("\u65e5\u5fd7\u5927\u5c0f\u8d85\u8fc7\u4e86\u9ed8\u8ba4 wifi 500M \u9650\u5236");
                return true;
            }
            return false;
        }
        if (zipLogFile.length() / 1048576 > this.mMobileFileLimit) {
            QLog.e(TAG, 1, "zipLogFile.length()=" + zipLogFile.length() + ", mobile, over 200M limit!");
            overLimitReport("\u65e5\u5fd7\u5927\u5c0f\u8d85\u8fc7\u4e86\u9ed8\u8ba4\u6d41\u91cf\u7684 200M \u9650\u5236");
            return true;
        }
        return false;
    }

    private final void overLimitReport(String reason) {
        HashMap<String, String> hashMapOf;
        qlogUploadStatusReportProcess(this.mQlogPushSeq, this.mCurrentTypeReportProcess, 8, "\u5ba2\u6237\u7aef\u4e0a\u4f20\u65e5\u5fd7\u6587\u4ef6\u5931\u8d25\uff0c\u539f\u56e0\u4e3a\uff1a" + reason, 0.0d);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("log_seq", String.valueOf(this.mQlogPushSeq)), TuplesKt.to("log_file_path", this.mLogFile.file_uri.get().toString()), TuplesKt.to("log_trace_suceess", "0"), TuplesKt.to(VRReportDefine$ReportParam.FAIL_REASON, reason));
        l lVar = this.logOpenTelemetry;
        if (lVar != null) {
            lVar.h(-1, hashMapOf);
            lVar.i("Log_upload_record", hashMapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qlogUploadStatusReportProcess(long qlogPushSeq, int reportType, int processStatus, String processStatusDes, double processUploadNum) {
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, com.tencent.trpcprotocol.qqlog.qqlog_server.b.class);
        newIntent.putExtra(AdMetricTag.Report.TYPE, reportType);
        newIntent.putExtra("processStatus", processStatus);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QqlogServer$SsoReportReq qqlogServer$SsoReportReq = new QqlogServer$SsoReportReq();
        int i3 = (int) qlogPushSeq;
        qqlogServer$SsoReportReq.seq.set(i3);
        qqlogServer$SsoReportReq.sub_seq.set(3);
        qqlogServer$SsoReportReq.uin.set(peekAppRuntime.getLongAccountUin());
        qqlogServer$SsoReportReq.report_type.set(reportType);
        PBStringField pBStringField = qqlogServer$SsoReportReq.imei;
        com.tencent.qqnt.util.b bVar = com.tencent.qqnt.util.b.f362976b;
        pBStringField.set(bVar.getQimei36());
        qqlogServer$SsoReportReq.f381601os.set("Android" + Build.VERSION.SDK_INT);
        qqlogServer$SsoReportReq.model.set(DeviceInfoMonitor.getModel());
        QqlogServer$Process qqlogServer$Process = new QqlogServer$Process();
        qqlogServer$Process.status.set(processStatus);
        qqlogServer$Process.status_info.set(processStatusDes);
        qqlogServer$Process.upload_progress.set(processUploadNum);
        qqlogServer$SsoReportReq.process.set(qqlogServer$Process);
        QqlogServer$ClientDevice qqlogServer$ClientDevice = new QqlogServer$ClientDevice();
        qqlogServer$ClientDevice.appid.set(String.valueOf(bVar.getAppId()));
        qqlogServer$ClientDevice.client_uins.set(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin());
        qqlogServer$ClientDevice.net_type.set(AppNetConnInfo.isWifiConn() ? "wifi" : DeviceType.DeviceCategory.MOBILE);
        qqlogServer$ClientDevice.version.set(bVar.getVersion());
        qqlogServer$ClientDevice.qq_version.set(bVar.b(MobileQQ.sMobileQQ.peekAppRuntime().getApplicationContext()));
        qqlogServer$SsoReportReq.client_device.set(qqlogServer$ClientDevice);
        if (!TextUtils.isEmpty(this.mLogFile.file_uri.get())) {
            QqlogServer$LogFile qqlogServer$LogFile = new QqlogServer$LogFile();
            qqlogServer$LogFile.log_file_name.set(this.mLogFile.log_file_name.get());
            qqlogServer$LogFile.log_size.set(this.mLogFile.log_size.get());
            qqlogServer$LogFile.zip_log_size.set(this.mLogFile.zip_log_size.get());
            qqlogServer$LogFile.log_line_num.set(this.mLogFile.log_line_num.get());
            qqlogServer$LogFile.file_uri.set(this.mLogFile.file_uri.get());
            qqlogServer$LogFile.public_key.set(PUBLISH_KEY);
            qqlogServer$SsoReportReq.log_file.set(qqlogServer$LogFile);
        }
        QLog.i(TAG, 1, "qlogUploadStatusReportProcess, qlogPushSeq=" + qlogPushSeq + ", qlogPushSeq.toInt=" + i3 + ", reportType=" + reportType + ", processStatus=" + processStatus);
        newIntent.putExtra("data", fh.b(qqlogServer$SsoReportReq.toByteArray()));
        peekAppRuntime.startServlet(newIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void transactionFailed(int retCode, byte[] arg1, HashMap<String, String> reportInfo) {
        HashMap<String, String> hashMapOf;
        QLog.i(TAG, 1, "[onFailed] retCode=" + retCode + ", arg1=" + arg1 + ", reportInfo=" + reportInfo + ", mQlogPushSeq=" + this.mQlogPushSeq);
        long j3 = this.mQlogPushSeq;
        int i3 = this.mCurrentTypeReportProcess;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u5ba2\u6237\u7aef\u4e0a\u4f20\u65e5\u5fd7\u6587\u4ef6\u5931\u8d25\uff0c\u539f\u56e0\u4e3a\uff1aretCode=");
        sb5.append(retCode);
        qlogUploadStatusReportProcess(j3, i3, 8, sb5.toString(), 0.0d);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("log_seq", String.valueOf(this.mQlogPushSeq)), TuplesKt.to("log_file_path", this.mLogFile.file_uri.get().toString()), TuplesKt.to("log_trace_suceess", "0"), TuplesKt.to(VRReportDefine$ReportParam.FAIL_REASON, String.valueOf(retCode)));
        hashMapOf.putAll(reportInfo);
        l lVar = this.logOpenTelemetry;
        if (lVar != null) {
            lVar.b(-1, hashMapOf);
            lVar.h(-1, hashMapOf);
            lVar.i("Log_upload_record", hashMapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void transactionSuccess(byte[] respData, HashMap<String, String> reportInfo) {
        HashMap<String, String> hashMapOf;
        QLog.i(TAG, 1, "[onSuccess] respData=" + respData + ", reportInfo=" + reportInfo + ", mQlogPushSeq=" + this.mQlogPushSeq);
        qlogUploadStatusReportProcess(this.mQlogPushSeq, this.mCurrentTypeReportProcess, 9, "\u5ba2\u6237\u7aef\u4e0a\u4f20\u65e5\u5fd7\u6587\u4ef6\u6210\u529f", 100.0d);
        Bdh_extinfo.UploadPicExtInfo uploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
        try {
            uploadPicExtInfo.mergeFrom(respData, 0, respData.length);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.i(TAG, 1, "UploadPicExtInfo error", e16);
        }
        QLog.i(TAG, 1, "onSuccess, bytes_download_url=" + uploadPicExtInfo.bytes_download_url.get().toStringUtf8());
        clearSeqs();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("log_seq", String.valueOf(this.mQlogPushSeq)), TuplesKt.to("log_file_path", this.mLogFile.file_uri.get().toString()), TuplesKt.to("log_trace_suceess", "1"));
        l lVar = this.logOpenTelemetry;
        if (lVar != null) {
            lVar.b(0, hashMapOf);
            lVar.h(0, hashMapOf);
            lVar.i("Log_upload_record", hashMapOf);
        }
    }

    @Override // com.tencent.qqnt.msg.api.ILogPushApi
    public void handleTxcActiveReportLog(@NotNull String uin, long seq, long startTime, long endTime) {
        Map<String, String> emptyMap;
        HashMap<String, String> hashMapOf;
        HashMap<String, String> hashMapOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, uin, Long.valueOf(seq), Long.valueOf(startTime), Long.valueOf(endTime));
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.i(TAG, 1, "handleTxcActiveReportLog, uin=" + uin + ", seq=" + seq + ", startTime=" + startTime + ", endTime=" + endTime);
        QqlogManage$MsgBody qqlogManage$MsgBody = new QqlogManage$MsgBody();
        qqlogManage$MsgBody.seq.set(seq, true);
        if (filterIllegalSeq(qqlogManage$MsgBody) || filterRepeatSeq(qqlogManage$MsgBody) || isLastLogUploadNotOver(qqlogManage$MsgBody)) {
            return;
        }
        this.mLogUploading = true;
        this.entity.encodeLong(LOG_UPLOAD_TIMEOUT_KEY, System.currentTimeMillis());
        this.mQlogPushSeq = qqlogManage$MsgBody.seq.get();
        this.mCurrentTypeReportDevice = 3;
        this.mCurrentTypeReportProcess = 4;
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.mExtraParamsMap = emptyMap;
        qlogUploadStatusReportProcess(qqlogManage$MsgBody.seq.get(), this.mCurrentTypeReportDevice, 1, "\u5ba2\u6237\u7aef\u6536\u5230Push\u547d\u4ee4\uff0c(\u5154\u5c0f\u5de2\u4e3b\u52a8\u4e0a\u62a5)", 0.0d);
        l lVar = this.logOpenTelemetry;
        if (lVar != null) {
            lVar.f();
            lVar.g();
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("log_seq", String.valueOf(this.mQlogPushSeq)));
            lVar.e(hashMapOf);
            hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("log_trace_suceess", "-1"));
            lVar.i("Log_upload_record", hashMapOf2);
        }
        LogReport.getInstance().txcActiveReportLog(uin, seq, startTime, endTime, this.uploadLogListener);
    }

    @QAutoInitMethod
    public final void initInject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        l lVar = (l) com.tencent.mobileqq.qroute.utils.b.a(logOpenTelemetry_AutoGenClazzList_QAutoInjectTransform);
        this.logOpenTelemetry = lVar;
        if (lVar == null) {
            QLog.e(TAG, 1, "logOpenTelemetry == null!!!");
        } else {
            QLog.e(TAG, 1, "logOpenTelemetry inject.");
        }
    }

    @Override // com.tencent.qqnt.msg.api.ILogPushApi
    @DelicateCoroutinesApi
    public void register() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Job job = this.receiveSysMsgNotificationJob;
        if (job != null) {
            QLog.i(TAG, 1, "receiveSysMsgNotificationJob need cancel first");
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        QLog.i(TAG, 1, "register, receiveSysMsgNotificationFlow");
        this.receiveSysMsgNotificationJob = FlowKt.launchIn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).receiveSysMsgNotificationFlow(), new LogPushApiImpl$register$2(this, null)), GlobalScope.INSTANCE);
    }
}
