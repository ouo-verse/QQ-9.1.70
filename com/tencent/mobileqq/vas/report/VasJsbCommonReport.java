package com.tencent.mobileqq.vas.report;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.api.INtVipStatus;
import com.tencent.mobileqq.vas.report.VasJsbCommonReport;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v23.Node;
import v23.Status;
import v23.StatusNode;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0004RSTUB\t\b\u0002\u00a2\u0006\u0004\bP\u0010QJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J(\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002JH\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J<\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004H\u0007J;\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0004H\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJA\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0004H\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0002J\u000e\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004J&\u0010#\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007J6\u0010&\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0004J\u001e\u0010'\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J&\u0010(\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fJ&\u0010)\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fJ&\u0010*\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010+\u001a\u00020\u000eJ&\u0010,\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\fJ.\u0010-\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010.\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010/\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b3\u00102R\u0014\u00104\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0014\u00105\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b5\u00102R\u0014\u00106\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b6\u00102R\u0014\u00107\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b7\u00102R\u0014\u00108\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b8\u00102R\u0014\u00109\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b9\u00102R\u0014\u0010:\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b:\u00102R\u0014\u0010;\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b;\u00102R\u0014\u0010<\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b>\u00102R\u0014\u0010?\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b?\u00102R \u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020A0@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR#\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020@8\u0006\u00a2\u0006\f\n\u0004\bD\u0010C\u001a\u0004\bE\u0010FR \u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020G0@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010CR0\u0010L\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020J0Ij\b\u0012\u0004\u0012\u00020J`K0@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010CR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport;", "", "Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport$TimeRecord;", "timeRecord", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "itemId", "", "costTime", "", "checkIsDressUpOk", "checkReportDownloadTimeOut", "", "errorCode", "", "reportSetEndTimePageDestroy", "stage", "fileSize", "hasDownload", "bid", "addReportData", "reportAllData", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "business", "downloadState", "isFirstQuery", "from", "reportPreDownload", "cachePreDownloadTime", "(Ljava/lang/Long;Ljava/lang/Integer;IJLjava/lang/String;)V", "reportPreDownloadInfo", "(JLjava/lang/Integer;Ljava/lang/String;IJLjava/lang/String;)V", QQPermissionConstants.Permission.AUIDO_GROUP, "reportFirstQuery", "setStartDownload", "reportDownloadSuccess", "httpCode", "errorMessage", "reportDownloadFail", "reportSetEndSetSuccess", "reportSetEndDownloadFail", "reportSetEndSetFail", "reportSetEndTimeOut", "reportAllPageDestroyTask", "reportSingleStepSuccess", "reportSingleStepFail", "removeTimeoutDelayTask", "TAG", "Ljava/lang/String;", "STAGE_FIRST_QUERY", "I", "STAGE_DOWNLOAD_COST_TIME", "STAGE_SETUP_COST_TIME", "STAGE_TOTAL_COST_TIME_SUCCESS", "STAGE_TOTAL_COST_TIME_DOWNLOAD_FAIL", "STAGE_TOTAL_COST_TIME_SET_FAIL", "STAGE_TOTAL_COST_TIME_OUT", "STAGE_TOTAL_COST_TIME_PAGE_DESTROY", "SIAGE_TOTAL_COST_DOWNLOAD_TIME_OUT", "SIAGE_TOTAL_COST_SET_BY_PUSH", "TIME_OUT_DELAY", "J", "PAGE_DESTROY", "DOWNLOAD_TIME_OUT", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport$a;", "cacheItemIdPreload", "Ljava/util/concurrent/ConcurrentHashMap;", "mSetKeyToStartTime", "getMSetKeyToStartTime", "()Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport$ReportTimeOutSetup;", "timeOutSetupTasks", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport$ReportData;", "Lkotlin/collections/ArrayList;", "needReportData", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/lang/Object;", "<init>", "()V", "a", "ReportData", "ReportTimeOutSetup", "TimeRecord", "vas-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasJsbCommonReport {
    public static final int DOWNLOAD_TIME_OUT = -9003;
    public static final int PAGE_DESTROY = -9002;
    public static final int SIAGE_TOTAL_COST_DOWNLOAD_TIME_OUT = 8;
    public static final int SIAGE_TOTAL_COST_SET_BY_PUSH = 9;
    public static final int STAGE_DOWNLOAD_COST_TIME = 1;
    public static final int STAGE_FIRST_QUERY = 0;
    public static final int STAGE_SETUP_COST_TIME = 2;
    public static final int STAGE_TOTAL_COST_TIME_DOWNLOAD_FAIL = 4;
    public static final int STAGE_TOTAL_COST_TIME_OUT = 6;
    public static final int STAGE_TOTAL_COST_TIME_PAGE_DESTROY = 7;
    public static final int STAGE_TOTAL_COST_TIME_SET_FAIL = 5;
    public static final int STAGE_TOTAL_COST_TIME_SUCCESS = 3;

    @NotNull
    public static final String TAG = "VasJsbReport";
    private static final long TIME_OUT_DELAY = 10000;

    @NotNull
    public static final VasJsbCommonReport INSTANCE = new VasJsbCommonReport();

    @NotNull
    private static final ConcurrentHashMap<String, PreDownload> cacheItemIdPreload = new ConcurrentHashMap<>();

    @NotNull
    private static final ConcurrentHashMap<String, TimeRecord> mSetKeyToStartTime = new ConcurrentHashMap<>();

    @NotNull
    private static final ConcurrentHashMap<String, ReportTimeOutSetup> timeOutSetupTasks = new ConcurrentHashMap<>();

    @NotNull
    private static final ConcurrentHashMap<String, ArrayList<ReportData>> needReportData = new ConcurrentHashMap<>();

    @NotNull
    private static final Object lock = new Object();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0007H\u00c6\u0003J\t\u0010!\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\"\u001a\u00020\rH\u00c6\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001J\u0013\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020\u000bH\u00d6\u0001J\t\u0010'\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport$ReportData;", "", "stage", "", "fileSize", "costTime", VasCommonJsbProxy.JSON_KEY_SET_KEY, "", "bid", "itemId", "errorCode", "", "hasDownload", "", "(JJJLjava/lang/String;JLjava/lang/String;IZ)V", "getBid", "()J", "getCostTime", "getErrorCode", "()I", "getFileSize", "getHasDownload", "()Z", "getItemId", "()Ljava/lang/String;", "getSetKey", "getStage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "vas-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final /* data */ class ReportData {
        private final long bid;
        private final long costTime;
        private final int errorCode;
        private final long fileSize;
        private final boolean hasDownload;

        @NotNull
        private final String itemId;

        @NotNull
        private final String setKey;
        private final long stage;

        public ReportData(long j3, long j16, long j17, @NotNull String setKey, long j18, @NotNull String itemId, int i3, boolean z16) {
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            this.stage = j3;
            this.fileSize = j16;
            this.costTime = j17;
            this.setKey = setKey;
            this.bid = j18;
            this.itemId = itemId;
            this.errorCode = i3;
            this.hasDownload = z16;
        }

        public static /* synthetic */ ReportData copy$default(ReportData reportData, long j3, long j16, long j17, String str, long j18, String str2, int i3, boolean z16, int i16, Object obj) {
            long j19;
            long j26;
            long j27;
            String str3;
            long j28;
            String str4;
            int i17;
            boolean z17;
            if ((i16 & 1) != 0) {
                j19 = reportData.stage;
            } else {
                j19 = j3;
            }
            if ((i16 & 2) != 0) {
                j26 = reportData.fileSize;
            } else {
                j26 = j16;
            }
            if ((i16 & 4) != 0) {
                j27 = reportData.costTime;
            } else {
                j27 = j17;
            }
            if ((i16 & 8) != 0) {
                str3 = reportData.setKey;
            } else {
                str3 = str;
            }
            if ((i16 & 16) != 0) {
                j28 = reportData.bid;
            } else {
                j28 = j18;
            }
            if ((i16 & 32) != 0) {
                str4 = reportData.itemId;
            } else {
                str4 = str2;
            }
            if ((i16 & 64) != 0) {
                i17 = reportData.errorCode;
            } else {
                i17 = i3;
            }
            if ((i16 & 128) != 0) {
                z17 = reportData.hasDownload;
            } else {
                z17 = z16;
            }
            return reportData.copy(j19, j26, j27, str3, j28, str4, i17, z17);
        }

        /* renamed from: component1, reason: from getter */
        public final long getStage() {
            return this.stage;
        }

        /* renamed from: component2, reason: from getter */
        public final long getFileSize() {
            return this.fileSize;
        }

        /* renamed from: component3, reason: from getter */
        public final long getCostTime() {
            return this.costTime;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final String getSetKey() {
            return this.setKey;
        }

        /* renamed from: component5, reason: from getter */
        public final long getBid() {
            return this.bid;
        }

        @NotNull
        /* renamed from: component6, reason: from getter */
        public final String getItemId() {
            return this.itemId;
        }

        /* renamed from: component7, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getHasDownload() {
            return this.hasDownload;
        }

        @NotNull
        public final ReportData copy(long stage, long fileSize, long costTime, @NotNull String setKey, long bid, @NotNull String itemId, int errorCode, boolean hasDownload) {
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            return new ReportData(stage, fileSize, costTime, setKey, bid, itemId, errorCode, hasDownload);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReportData)) {
                return false;
            }
            ReportData reportData = (ReportData) other;
            if (this.stage == reportData.stage && this.fileSize == reportData.fileSize && this.costTime == reportData.costTime && Intrinsics.areEqual(this.setKey, reportData.setKey) && this.bid == reportData.bid && Intrinsics.areEqual(this.itemId, reportData.itemId) && this.errorCode == reportData.errorCode && this.hasDownload == reportData.hasDownload) {
                return true;
            }
            return false;
        }

        public final long getBid() {
            return this.bid;
        }

        public final long getCostTime() {
            return this.costTime;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final long getFileSize() {
            return this.fileSize;
        }

        public final boolean getHasDownload() {
            return this.hasDownload;
        }

        @NotNull
        public final String getItemId() {
            return this.itemId;
        }

        @NotNull
        public final String getSetKey() {
            return this.setKey;
        }

        public final long getStage() {
            return this.stage;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a16 = ((((((((((((androidx.fragment.app.a.a(this.stage) * 31) + androidx.fragment.app.a.a(this.fileSize)) * 31) + androidx.fragment.app.a.a(this.costTime)) * 31) + this.setKey.hashCode()) * 31) + androidx.fragment.app.a.a(this.bid)) * 31) + this.itemId.hashCode()) * 31) + this.errorCode) * 31;
            boolean z16 = this.hasDownload;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return a16 + i3;
        }

        @NotNull
        public String toString() {
            return "ReportData(stage=" + this.stage + ", fileSize=" + this.fileSize + ", costTime=" + this.costTime + ", setKey=" + this.setKey + ", bid=" + this.bid + ", itemId=" + this.itemId + ", errorCode=" + this.errorCode + ", hasDownload=" + this.hasDownload + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport$ReportTimeOutSetup;", "Ljava/lang/Runnable;", QQPermissionConstants.Permission.AUIDO_GROUP, "Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport$TimeRecord;", "(Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport$TimeRecord;)V", "delayTask", "getDelayTask", "()Ljava/lang/Runnable;", "setDelayTask", "(Ljava/lang/Runnable;)V", "getRecord", "()Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport$TimeRecord;", TencentLocation.RUN_MODE, "", "vas-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class ReportTimeOutSetup implements Runnable {

        @Nullable
        private Runnable delayTask;

        @NotNull
        private final TimeRecord record;

        public ReportTimeOutSetup(@NotNull TimeRecord record) {
            Intrinsics.checkNotNullParameter(record, "record");
            this.record = record;
        }

        @Nullable
        public final Runnable getDelayTask() {
            return this.delayTask;
        }

        @NotNull
        public final TimeRecord getRecord() {
            return this.record;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.record.getHasReportDelayTimeOut()) {
                return;
            }
            VasJsbCommonReport.INSTANCE.reportSetEndTimeOut(this.record.getSetKey(), this.record.getSetupId(), System.currentTimeMillis() - this.record.getFirstQueryTime(), -9001);
            VasJsbCommonReport.timeOutSetupTasks.remove(this.record.getSetKey());
        }

        public final void setDelayTask(@Nullable Runnable runnable) {
            this.delayTask = runnable;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bJ\b\u0010-\u001a\u00020\u0003H\u0016R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\nR\u001a\u0010\u001e\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010%\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u001a\u0010)\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\n\"\u0004\b+\u0010,\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport$TimeRecord;", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "", "firstQueryTime", "", "setupId", "bid", "(Ljava/lang/String;JLjava/lang/String;J)V", "getBid", "()J", "checkDressUpIsOk", "Lkotlin/Function0;", "", "getCheckDressUpIsOk", "()Lkotlin/jvm/functions/Function0;", "setCheckDressUpIsOk", "(Lkotlin/jvm/functions/Function0;)V", "errorCode", "", "getErrorCode", "()I", "setErrorCode", "(I)V", "errorMessage", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "getFirstQueryTime", "hadDownload", "getHadDownload", "()Z", "setHadDownload", "(Z)V", "isReportComplete", "setReportComplete", "isStartDownload", "setStartDownload", "getSetKey", "getSetupId", "setupTime", "getSetupTime", "setSetupTime", "(J)V", "toString", "vas-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class TimeRecord {
        private final long bid;

        @Nullable
        private Function0<Boolean> checkDressUpIsOk;
        private int errorCode;

        @NotNull
        private String errorMessage;
        private final long firstQueryTime;
        private volatile boolean hadDownload;

        /* renamed from: isReportComplete, reason: from kotlin metadata and from toString */
        private volatile boolean hasReportDelayTimeOut;
        private boolean isStartDownload;

        @NotNull
        private final String setKey;

        @NotNull
        private final String setupId;
        private long setupTime;

        public TimeRecord(@NotNull String setKey, long j3, @NotNull String setupId, long j16) {
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(setupId, "setupId");
            this.setKey = setKey;
            this.firstQueryTime = j3;
            this.setupId = setupId;
            this.bid = j16;
            this.errorMessage = "";
        }

        public final long getBid() {
            return this.bid;
        }

        @Nullable
        public final Function0<Boolean> getCheckDressUpIsOk() {
            if (this.bid == 3) {
                return new Function0<Boolean>() { // from class: com.tencent.mobileqq.vas.report.VasJsbCommonReport$TimeRecord$checkDressUpIsOk$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Boolean invoke() {
                        return Boolean.valueOf(Intrinsics.areEqual(QQTheme.getCurrentThemeId(), VasJsbCommonReport.TimeRecord.this.getSetupId()));
                    }
                };
            }
            return new Function0<Boolean>() { // from class: com.tencent.mobileqq.vas.report.VasJsbCommonReport$TimeRecord$checkDressUpIsOk$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Boolean invoke() {
                    return Boolean.FALSE;
                }
            };
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        @NotNull
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final long getFirstQueryTime() {
            return this.firstQueryTime;
        }

        public final boolean getHadDownload() {
            return this.hadDownload;
        }

        @NotNull
        public final String getSetKey() {
            return this.setKey;
        }

        @NotNull
        public final String getSetupId() {
            return this.setupId;
        }

        public final long getSetupTime() {
            return this.setupTime;
        }

        /* renamed from: isReportComplete, reason: from getter */
        public final boolean getHasReportDelayTimeOut() {
            return this.hasReportDelayTimeOut;
        }

        /* renamed from: isStartDownload, reason: from getter */
        public final boolean getIsStartDownload() {
            return this.isStartDownload;
        }

        public final void setCheckDressUpIsOk(@Nullable Function0<Boolean> function0) {
            this.checkDressUpIsOk = function0;
        }

        public final void setErrorCode(int i3) {
            this.errorCode = i3;
        }

        public final void setErrorMessage(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.errorMessage = str;
        }

        public final void setHadDownload(boolean z16) {
            this.hadDownload = z16;
        }

        public final void setReportComplete(boolean z16) {
            this.hasReportDelayTimeOut = z16;
        }

        public final void setSetupTime(long j3) {
            this.setupTime = j3;
        }

        public final void setStartDownload(boolean z16) {
            this.isStartDownload = z16;
        }

        @NotNull
        public String toString() {
            return "TimeRecord{setKey='" + this.setKey + "', firstQueryTime=" + this.firstQueryTime + ", setupId='" + this.setupId + "', setupTime=" + this.setupTime + ", hadDownload=" + this.hadDownload + ", hasReportDelayTimeOut=" + this.hasReportDelayTimeOut + "}";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "setPreDownloadTime", "(J)V", "preDownloadTime", "<init>", "vas-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.report.VasJsbCommonReport$a, reason: from toString */
    /* loaded from: classes20.dex */
    public static final /* data */ class PreDownload {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private long preDownloadTime;

        public PreDownload() {
            this(0L, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final long getPreDownloadTime() {
            return this.preDownloadTime;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof PreDownload) && this.preDownloadTime == ((PreDownload) other).preDownloadTime) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.preDownloadTime);
        }

        @NotNull
        public String toString() {
            return "PreDownload(preDownloadTime=" + this.preDownloadTime + ")";
        }

        public PreDownload(long j3) {
            this.preDownloadTime = j3;
        }

        public /* synthetic */ PreDownload(long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0L : j3);
        }
    }

    VasJsbCommonReport() {
    }

    private final void addReportData(String setKey, String itemId, int stage, int errorCode, long fileSize, long costTime, boolean hasDownload, long bid) {
        boolean z16;
        ArrayList<ReportData> arrayList;
        int i3;
        int i16;
        Node statusNode;
        int i17 = 0;
        if (setKey.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.w(TAG, 1, "setKey is empty,please check js arguments, id: " + itemId);
            return;
        }
        ReportData reportData = new ReportData(stage, fileSize, costTime, setKey, bid, itemId, errorCode, hasDownload);
        synchronized (lock) {
            ConcurrentHashMap<String, ArrayList<ReportData>> concurrentHashMap = needReportData;
            if (!concurrentHashMap.containsKey(setKey)) {
                arrayList = new ArrayList<>();
            } else {
                arrayList = concurrentHashMap.get(setKey);
            }
            if (arrayList != null) {
                arrayList.add(reportData);
                concurrentHashMap.put(setKey, arrayList);
                Unit unit = Unit.INSTANCE;
                a aVar = a.f310626a;
                x23.c b16 = aVar.b(setKey);
                if (b16 == null) {
                    b16 = aVar.a(new w23.c("gxh_common_set_json", setKey, 6, false, 0L, 16, null));
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(bid);
                    b16.a("bid", sb5.toString());
                    b16.a("itemId", itemId);
                }
                x23.c cVar = b16;
                switch (stage) {
                    case 1:
                        i3 = 1;
                        i16 = i17;
                        break;
                    case 2:
                        i3 = 1;
                        if (cVar.b(1) != 0) {
                            i17 = 1;
                        }
                        i16 = i17;
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        i16 = 0;
                        i3 = 1;
                        break;
                    default:
                        i3 = 1;
                        i16 = -10000;
                        break;
                }
                if (stage != i3 && stage != 4 && stage != 5) {
                    statusNode = new Node(stage, 0L, null, reportData, i16, 6, null);
                } else {
                    statusNode = new StatusNode(stage, 0L, null, reportData, i16, new Status(errorCode, "", 0, 4, null), 6, null);
                }
                cVar.c(statusNode);
            }
        }
    }

    @JvmStatic
    public static final void cachePreDownloadTime(@Nullable Long bid, @Nullable Integer itemId, int downloadState, long fileSize, @NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        cacheItemIdPreload.put(bid + "_itemId." + itemId, new PreDownload(SystemClock.currentThreadTimeMillis()));
        int privilegeFlags = ((INtVipStatus) QRoute.api(INtVipStatus.class)).getPrivilegeFlags(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
        ReportInfo value2 = VasCommonReporter.getJsSetPreDownload().setValue1("start_preload").setValue2(bid + "_itemId." + itemId);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(privilegeFlags);
        value2.setValue3(sb5.toString()).setValue4(from).setNum1((long) downloadState).setNum2(fileSize).report(false);
    }

    private final boolean checkIsDressUpOk(TimeRecord timeRecord, String setKey, String itemId, long costTime) {
        boolean z16;
        Function0<Boolean> checkDressUpIsOk = timeRecord.getCheckDressUpIsOk();
        if (checkDressUpIsOk != null && checkDressUpIsOk.invoke().booleanValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        timeRecord.setReportComplete(true);
        addReportData(setKey, itemId, 9, 0, 0L, costTime, timeRecord.getHadDownload(), timeRecord.getBid());
        reportAllData(setKey);
        removeTimeoutDelayTask(setKey);
        return true;
    }

    private final boolean checkReportDownloadTimeOut(TimeRecord timeRecord, String setKey, String itemId, long costTime) {
        if (timeRecord.getIsStartDownload() && !timeRecord.getHadDownload()) {
            timeRecord.setReportComplete(true);
            addReportData(setKey, itemId, 8, -9003, 0L, costTime, timeRecord.getHadDownload(), timeRecord.getBid());
            reportAllData(setKey);
            removeTimeoutDelayTask(setKey);
            return true;
        }
        return false;
    }

    private final void reportAllData(String setKey) {
        boolean z16;
        String str;
        synchronized (lock) {
            ArrayList<ReportData> arrayList = needReportData.get(setKey);
            if (arrayList != null) {
                Intrinsics.checkNotNullExpressionValue(arrayList, "needReportData[setKey]");
                for (ReportData reportData : arrayList) {
                    if (reportData.getSetKey().length() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        QLog.w(TAG, 1, "setKey is empty,please check js arguments, bid: " + reportData.getBid() + ", id: " + reportData.getItemId());
                        return;
                    }
                    ReportInfo value2 = VasCommonReporter.getJsSet().setNum1(reportData.getStage()).setNum2(reportData.getFileSize()).setNum3(reportData.getCostTime()).setValue1(reportData.getSetKey()).setValue2(reportData.getBid() + "_itemId." + reportData.getItemId());
                    int errorCode = reportData.getErrorCode();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(errorCode);
                    ReportInfo value3 = value2.setValue3(sb5.toString());
                    if (reportData.getHasDownload()) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    value3.setValue4(str).report(false);
                }
            }
            needReportData.remove(setKey);
            x23.c b16 = a.f310626a.b(setKey);
            if (b16 != null) {
                b16.end();
            }
        }
    }

    @JvmStatic
    public static final void reportPreDownload(@NotNull String setKey, @NotNull QQVasUpdateBusiness<?> business, int itemId, int downloadState, boolean isFirstQuery, @NotNull String from) {
        long j3;
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(from, "from");
        try {
            long bid = business.getBid();
            if (downloadState == 3) {
                j3 = business.getDownloadFileSize(itemId);
            } else {
                j3 = 0;
            }
            long j16 = j3;
            if (TextUtils.isEmpty(setKey)) {
                cachePreDownloadTime(Long.valueOf(bid), Integer.valueOf(itemId), downloadState, j16, from);
            } else if (isFirstQuery) {
                reportPreDownloadInfo(bid, Integer.valueOf(itemId), setKey, downloadState, j16, from);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "report Pre Download Failed", e16);
        }
    }

    @JvmStatic
    public static final void reportPreDownloadInfo(long bid, @Nullable Integer itemId, @NotNull String setKey, int downloadState, long fileSize, @NotNull String from) {
        long j3;
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(from, "from");
        PreDownload preDownload = cacheItemIdPreload.get(bid + "_itemId." + itemId);
        if (preDownload != null) {
            j3 = SystemClock.currentThreadTimeMillis() - preDownload.getPreDownloadTime();
        } else {
            j3 = 0;
        }
        int privilegeFlags = ((INtVipStatus) QRoute.api(INtVipStatus.class)).getPrivilegeFlags(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
        ReportInfo value2 = VasCommonReporter.getJsSetPreDownload().setValue1(setKey).setValue2(bid + "_itemId." + itemId);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(privilegeFlags);
        value2.setValue3(sb5.toString()).setValue4(from).setNum1((long) downloadState).setNum2(fileSize).setNum3(j3).report(false);
    }

    private final void reportSetEndTimePageDestroy(String setKey, String itemId, long costTime, int errorCode) {
        TimeRecord timeRecord = mSetKeyToStartTime.get(setKey);
        if (timeRecord == null) {
            return;
        }
        if (timeRecord.getHasReportDelayTimeOut()) {
            QLog.w(TAG, 1, "reportSetEndSetFail \u5df2\u4e0a\u62a5\u8d85\u65f6\u62a5\u9519, record:" + timeRecord);
            return;
        }
        timeRecord.setReportComplete(true);
        addReportData(setKey, itemId, 7, errorCode, 0L, costTime, timeRecord.getHadDownload(), timeRecord.getBid());
        reportAllData(setKey);
        removeTimeoutDelayTask(setKey);
    }

    @NotNull
    public final ConcurrentHashMap<String, TimeRecord> getMSetKeyToStartTime() {
        return mSetKeyToStartTime;
    }

    public final void removeTimeoutDelayTask(@NotNull String setKey) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        ConcurrentHashMap<String, ReportTimeOutSetup> concurrentHashMap = timeOutSetupTasks;
        ReportTimeOutSetup reportTimeOutSetup = concurrentHashMap.get(setKey);
        if (reportTimeOutSetup != null) {
            Runnable delayTask = reportTimeOutSetup.getDelayTask();
            if (delayTask != null) {
                ThreadManagerV2.removeJob(delayTask, 16);
            }
            concurrentHashMap.remove(setKey);
        }
    }

    public final void reportAllPageDestroyTask() {
        Iterator it;
        Enumeration<String> keys = timeOutSetupTasks.keys();
        if (keys != null) {
            it = CollectionsKt__IteratorsJVMKt.iterator(keys);
            while (it.hasNext()) {
                ReportTimeOutSetup reportTimeOutSetup = timeOutSetupTasks.get((String) it.next());
                if (reportTimeOutSetup != null) {
                    INSTANCE.reportSetEndTimePageDestroy(reportTimeOutSetup.getRecord().getSetKey(), reportTimeOutSetup.getRecord().getSetupId(), System.currentTimeMillis() - reportTimeOutSetup.getRecord().getFirstQueryTime(), -9002);
                }
            }
        }
    }

    public final void reportDownloadFail(@NotNull String setKey, @NotNull String itemId, long costTime, int errorCode, int httpCode, @NotNull String errorMessage) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        TimeRecord timeRecord = mSetKeyToStartTime.get(setKey);
        if (timeRecord == null) {
            return;
        }
        timeRecord.setHadDownload(true);
        timeRecord.setErrorCode(errorCode);
        timeRecord.setErrorMessage(errorMessage);
        addReportData(setKey, itemId, 1, errorCode, 0L, costTime, timeRecord.getHadDownload(), timeRecord.getBid());
        VasCommonReporter.getGxhJsbSetDownload().setNum2(0L).setNum3(costTime).setValue1(itemId).setValue2(timeRecord.getBid() + "_itemId." + itemId).setValue3(String.valueOf(errorCode)).setValue4(String.valueOf(httpCode)).report(false);
    }

    public final void reportDownloadSuccess(@NotNull String setKey, @NotNull String itemId, long costTime, long fileSize) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        TimeRecord timeRecord = mSetKeyToStartTime.get(setKey);
        if (timeRecord == null) {
            return;
        }
        timeRecord.setHadDownload(true);
        addReportData(setKey, itemId, 1, 0, fileSize, costTime, timeRecord.getHadDownload(), timeRecord.getBid());
        VasCommonReporter.getGxhJsbSetDownload().setNum2(fileSize).setNum3(costTime).setValue1(setKey).setValue2(timeRecord.getBid() + "_itemId." + itemId).setValue3("0").setValue4("0").report(false);
    }

    public final void reportFirstQuery(@NotNull TimeRecord record) {
        Intrinsics.checkNotNullParameter(record, "record");
        ReportTimeOutSetup reportTimeOutSetup = new ReportTimeOutSetup(record);
        reportTimeOutSetup.setDelayTask(ThreadManagerV2.executeDelay(reportTimeOutSetup, 16, null, false, 10000L));
        timeOutSetupTasks.put(record.getSetKey(), reportTimeOutSetup);
        addReportData(record.getSetKey(), record.getSetupId(), 0, 0, 0L, 0L, false, record.getBid());
    }

    public final void reportSetEndDownloadFail(@NotNull String setKey, @NotNull String itemId, long costTime, int errorCode) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        TimeRecord timeRecord = mSetKeyToStartTime.get(setKey);
        if (timeRecord == null) {
            return;
        }
        if (timeRecord.getHasReportDelayTimeOut()) {
            QLog.w(TAG, 1, "reportSetFailDownloadFail \u5df2\u4e0a\u62a5\u8d85\u65f6\u62a5\u9519, record:" + timeRecord);
            return;
        }
        timeRecord.setReportComplete(true);
        addReportData(setKey, itemId, 4, errorCode, 0L, costTime, timeRecord.getHadDownload(), timeRecord.getBid());
        reportAllData(setKey);
        removeTimeoutDelayTask(setKey);
    }

    public final void reportSetEndSetFail(@NotNull String setKey, @NotNull String itemId, long costTime, int errorCode) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        TimeRecord timeRecord = mSetKeyToStartTime.get(setKey);
        if (timeRecord == null) {
            return;
        }
        if (timeRecord.getHasReportDelayTimeOut()) {
            QLog.w(TAG, 1, "reportSetEndSetFail \u5df2\u4e0a\u62a5\u8d85\u65f6\u62a5\u9519, record:" + timeRecord);
            return;
        }
        timeRecord.setReportComplete(true);
        addReportData(setKey, itemId, 5, errorCode, 0L, costTime, timeRecord.getHadDownload(), timeRecord.getBid());
        reportAllData(setKey);
        removeTimeoutDelayTask(setKey);
    }

    public final void reportSetEndSetSuccess(@NotNull String setKey, @NotNull String itemId, long costTime) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        TimeRecord timeRecord = mSetKeyToStartTime.get(setKey);
        if (timeRecord == null) {
            return;
        }
        if (timeRecord.getHasReportDelayTimeOut()) {
            QLog.w(TAG, 1, "reportSetComplete \u5df2\u4e0a\u62a5\u8d85\u65f6\u62a5\u9519, record:" + timeRecord);
            return;
        }
        timeRecord.setReportComplete(true);
        addReportData(setKey, itemId, 3, 0, 0L, costTime, timeRecord.getHadDownload(), timeRecord.getBid());
        reportAllData(setKey);
        removeTimeoutDelayTask(setKey);
    }

    public final void reportSetEndTimeOut(@NotNull String setKey, @NotNull String itemId, long costTime, int errorCode) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        TimeRecord timeRecord = mSetKeyToStartTime.get(setKey);
        if (timeRecord == null) {
            return;
        }
        if (timeRecord.getHasReportDelayTimeOut()) {
            QLog.w(TAG, 1, "reportSetEndSetFail \u5df2\u4e0a\u62a5\u8d85\u65f6\u62a5\u9519, record:" + timeRecord);
            return;
        }
        if (checkIsDressUpOk(timeRecord, setKey, itemId, costTime) || checkReportDownloadTimeOut(timeRecord, setKey, itemId, costTime)) {
            return;
        }
        timeRecord.setReportComplete(true);
        addReportData(setKey, itemId, 6, errorCode, 0L, costTime, timeRecord.getHadDownload(), timeRecord.getBid());
        reportAllData(setKey);
        removeTimeoutDelayTask(setKey);
    }

    public final void reportSingleStepFail(@NotNull String setKey, @NotNull String itemId, long costTime, int stage, int errorCode) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        TimeRecord timeRecord = mSetKeyToStartTime.get(setKey);
        if (timeRecord == null) {
            return;
        }
        addReportData(setKey, itemId, stage, errorCode, 0L, costTime, timeRecord.getHadDownload(), 3L);
    }

    public final void reportSingleStepSuccess(@NotNull String setKey, @NotNull String itemId, long costTime, int stage) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        TimeRecord timeRecord = mSetKeyToStartTime.get(setKey);
        if (timeRecord == null) {
            return;
        }
        addReportData(setKey, itemId, stage, 0, 0L, costTime, timeRecord.getHadDownload(), 3L);
    }

    public final void setStartDownload(@NotNull String setKey) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        TimeRecord timeRecord = mSetKeyToStartTime.get(setKey);
        if (timeRecord != null) {
            timeRecord.setStartDownload(true);
        }
    }
}
