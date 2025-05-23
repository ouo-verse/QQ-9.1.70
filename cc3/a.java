package cc3;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.halley.downloader.DownloaderTask;
import com.tencent.halley.downloader.DownloaderTaskCategory;
import com.tencent.halley.downloader.DownloaderTaskListener;
import com.tencent.halley.downloader.DownloaderTaskPriority;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.multidownloader.MDDownloadResInfo;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bU\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010Q\u001a\u00020\u0002\u0012\u0006\u0010S\u001a\u00020\u0002\u0012\u0006\u0010U\u001a\u00020\u0002\u0012\u0006\u0010W\u001a\u00020\u0002\u0012\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\f\u00a2\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ \u0010\u000f\u001a\u00020\u00042\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\fJ&\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tJ\u0010\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u001a\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\fH\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u0002H\u0016J\b\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020\tH\u0016J\b\u0010&\u001a\u00020\tH\u0016J\b\u0010'\u001a\u00020\u0018H\u0016J\b\u0010)\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020(H\u0016J\b\u0010,\u001a\u00020(H\u0016J\b\u0010-\u001a\u00020\u0018H\u0016J\b\u0010.\u001a\u00020\u0002H\u0016J\b\u0010/\u001a\u00020\tH\u0016J\b\u00100\u001a\u00020\u0018H\u0016J\b\u00101\u001a\u00020\u0018H\u0016J\b\u00102\u001a\u00020\tH\u0016J\b\u00103\u001a\u00020\u0018H\u0016J\b\u00104\u001a\u00020\u0002H\u0016J\u001c\u00107\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u00010\u00022\b\u00106\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u00109\u001a\u000208H\u0016J\u0012\u0010;\u001a\u00020\u00042\b\u0010:\u001a\u0004\u0018\u000108H\u0016J\b\u0010=\u001a\u00020<H\u0016J\u0012\u0010@\u001a\u00020\u00042\b\u0010?\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010A\u001a\u00020\u00042\b\u0010?\u001a\u0004\u0018\u00010>H\u0016J\b\u0010B\u001a\u00020\u0004H\u0016J\b\u0010C\u001a\u00020\u0004H\u0016J\b\u0010D\u001a\u00020(H\u0016J\u001a\u0010G\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00182\b\u0010F\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010H\u001a\u00020\tH\u0016J\u0010\u0010J\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u0018H\u0016J\u0010\u0010L\u001a\u00020\u00042\u0006\u0010K\u001a\u00020(H\u0016J\b\u0010M\u001a\u00020(H\u0016R\u0017\u0010Q\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010N\u001a\u0004\bO\u0010PR\u0017\u0010S\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010N\u001a\u0004\bR\u0010PR\u0017\u0010U\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010N\u001a\u0004\bT\u0010PR\u0017\u0010W\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010N\u001a\u0004\bV\u0010PR#\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010X\u001a\u0004\bY\u0010ZR\"\u0010`\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010N\u001a\u0004\b]\u0010P\"\u0004\b^\u0010_R4\u0010e\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010X\u001a\u0004\bb\u0010Z\"\u0004\bc\u0010dR$\u0010l\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010s\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\"\u0010w\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bt\u0010N\u001a\u0004\bu\u0010P\"\u0004\bv\u0010_R\"\u0010~\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R%\u0010\u0082\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b\u007f\u0010y\u001a\u0005\b\u0080\u0001\u0010{\"\u0005\b\u0081\u0001\u0010}R%\u0010\u0085\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bn\u0010y\u001a\u0005\b\u0083\u0001\u0010{\"\u0005\b\u0084\u0001\u0010}R%\u0010\u0088\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\by\u0010y\u001a\u0005\b\u0086\u0001\u0010{\"\u0005\b\u0087\u0001\u0010}R&\u0010\u008c\u0001\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0089\u0001\u0010n\u001a\u0005\b\u008a\u0001\u0010p\"\u0005\b\u008b\u0001\u0010rR&\u0010\u0090\u0001\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u008d\u0001\u0010n\u001a\u0005\b\u008e\u0001\u0010p\"\u0005\b\u008f\u0001\u0010r\u00a8\u0006\u0093\u0001"}, d2 = {"Lcc3/a;", "Lcom/tencent/halley/downloader/DownloaderTask;", "", "a", "", "g", "i", "f", "b", "", "totalSize", "c", "", "", "headerMap", "j", "received", "total", "realTimeSpeed", "averageSpeed", h.F, "Lcom/tencent/multidownloader/MDDownloadResInfo;", "mdDownloadResInfo", "e", "", "errCode", "errMsg", "d", "getHttpRspHeaderMap", "getUniqueKey", "getUrl", "getSaveDir", "getInitSaveName", "getRealSaveName", "getSavePath", "Lcom/tencent/halley/downloader/DownloaderTaskStatus;", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "getTotalLength", "getReceivedLength", "getPercentage", "", "isRunning", "isDeleted", "isPaused", "isFailed", "getFailCode", "getFailInfo", "getCostTime", "getRealTimeSpeed", "getAverageSpeed", "getStartTime", "getType", "getId", "header", "headerValue", "addHeader", "Lcom/tencent/halley/downloader/DownloaderTaskCategory;", "getCategory", "category", "setCategory", "Lcom/tencent/halley/downloader/DownloaderTaskPriority;", "getPriority", "Lcom/tencent/halley/downloader/DownloaderTaskListener;", "listener", "addListener", "removeListener", "removeAllListeners", "pause", "resume", ImageTaskConst.FAIL_CODE, "failInfo", "manualSetFailInfo", "getKnownSize", "taskSpeedLimit", "setTaskSpeedLimit", "enable", "setEnableCrcCheck", "isPausedOnMobile", "Ljava/lang/String;", "getFileUrl", "()Ljava/lang/String;", "fileUrl", "getFileDir", "fileDir", "getFileName", WadlProxyConsts.PARAM_FILENAME, "getFullSavePath", "fullSavePath", "Ljava/util/Map;", "getReqHeader", "()Ljava/util/Map;", "reqHeader", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getTaskUniqueKey", "setTaskUniqueKey", "(Ljava/lang/String;)V", "taskUniqueKey", BdhLogUtil.LogTag.Tag_Conn, "getHttpRspHeader", "setHttpRspHeader", "(Ljava/util/Map;)V", "httpRspHeader", "D", "Lcom/tencent/halley/downloader/DownloaderTaskStatus;", "getDownloadStatus", "()Lcom/tencent/halley/downloader/DownloaderTaskStatus;", "setDownloadStatus", "(Lcom/tencent/halley/downloader/DownloaderTaskStatus;)V", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "E", "I", "getRet", "()I", "setRet", "(I)V", "ret", UserInfo.SEX_FEMALE, "getFailInfoMsg", "setFailInfoMsg", "failInfoMsg", "G", "J", "getTaskStartTime", "()J", "setTaskStartTime", "(J)V", "taskStartTime", "H", "getTotalCostTime", "setTotalCostTime", "totalCostTime", "getReceivedLen", "setReceivedLen", "receivedLen", "getTotalLen", "setTotalLen", "totalLen", "K", "getCurRealTimeSpeed", "setCurRealTimeSpeed", "curRealTimeSpeed", "L", "getCurAverageSpeed", "setCurAverageSpeed", "curAverageSpeed", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a implements DownloaderTask {

    /* renamed from: C, reason: from kotlin metadata */
    private Map<String, ? extends List<String>> httpRspHeader;

    /* renamed from: D, reason: from kotlin metadata */
    private volatile DownloaderTaskStatus downloadStatus;

    /* renamed from: E, reason: from kotlin metadata */
    private volatile int ret;

    /* renamed from: F, reason: from kotlin metadata */
    private String failInfoMsg;

    /* renamed from: G, reason: from kotlin metadata */
    private long taskStartTime;

    /* renamed from: H, reason: from kotlin metadata */
    private long totalCostTime;

    /* renamed from: I, reason: from kotlin metadata */
    private volatile long receivedLen;

    /* renamed from: J, reason: from kotlin metadata */
    private volatile long totalLen;

    /* renamed from: K, reason: from kotlin metadata */
    private volatile int curRealTimeSpeed;

    /* renamed from: L, reason: from kotlin metadata */
    private volatile int curAverageSpeed;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String fileUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String fileDir;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String fileName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String fullSavePath;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Map<String, String> reqHeader;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String taskUniqueKey;

    public a(String fileUrl, String fileDir, String fileName, String fullSavePath, Map<String, String> reqHeader) {
        Intrinsics.checkNotNullParameter(fileUrl, "fileUrl");
        Intrinsics.checkNotNullParameter(fileDir, "fileDir");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(fullSavePath, "fullSavePath");
        Intrinsics.checkNotNullParameter(reqHeader, "reqHeader");
        this.fileUrl = fileUrl;
        this.fileDir = fileDir;
        this.fileName = fileName;
        this.fullSavePath = fullSavePath;
        this.reqHeader = reqHeader;
        this.taskUniqueKey = "";
        this.httpRspHeader = new HashMap();
        this.failInfoMsg = "";
        this.taskUniqueKey = a();
    }

    private final String a() {
        String str = MD5.toMD5(this.fileUrl) + "_" + MD5.toMD5(this.reqHeader.toString()) + "_" + System.currentTimeMillis() + "_" + new Random().nextInt(Integer.MAX_VALUE);
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder()\n        \u2026nt.MAX_VALUE)).toString()");
        return str;
    }

    public final void b() {
        this.downloadStatus = DownloaderTaskStatus.DELETED;
    }

    public final void c(long totalSize) {
        this.totalLen = totalSize;
    }

    public final void d(int errCode, String errMsg, MDDownloadResInfo mdDownloadResInfo) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this.downloadStatus = DownloaderTaskStatus.FAILED;
        this.ret = errCode;
        this.failInfoMsg = errMsg;
        if (mdDownloadResInfo != null) {
            this.totalCostTime = mdDownloadResInfo.consume_time;
            this.curAverageSpeed = (int) mdDownloadResInfo.average_speed;
        }
    }

    public final void e(MDDownloadResInfo mdDownloadResInfo) {
        this.downloadStatus = DownloaderTaskStatus.COMPLETE;
        this.ret = 0;
        this.receivedLen = this.totalLen;
        if (mdDownloadResInfo != null) {
            this.totalCostTime = mdDownloadResInfo.consume_time;
            this.curAverageSpeed = (int) (mdDownloadResInfo.average_speed * 1000);
        }
    }

    public final void f() {
        this.downloadStatus = DownloaderTaskStatus.PAUSED;
    }

    public final void g() {
        this.downloadStatus = DownloaderTaskStatus.PENDING;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getAverageSpeed, reason: from getter */
    public int getCurAverageSpeed() {
        return this.curAverageSpeed;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public DownloaderTaskCategory getCategory() {
        return DownloaderTaskCategory.Cate_DefaultMass;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getCostTime, reason: from getter */
    public long getTotalCostTime() {
        return this.totalCostTime;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getFailCode, reason: from getter */
    public int getRet() {
        return this.ret;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getFailInfo, reason: from getter */
    public String getFailInfoMsg() {
        return this.failInfoMsg;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public Map<String, List<String>> getHttpRspHeaderMap() {
        return this.httpRspHeader;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public String getId() {
        return "";
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getInitSaveName, reason: from getter */
    public String getFileName() {
        return this.fileName;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public long getKnownSize() {
        return 0L;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public int getPercentage() {
        if (this.totalLen <= 0) {
            return 0;
        }
        return Math.min(100, (int) Math.max(0L, (this.receivedLen * 100) / this.totalLen));
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public DownloaderTaskPriority getPriority() {
        return DownloaderTaskPriority.NORMAL;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public String getRealSaveName() {
        return this.fileName;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getRealTimeSpeed, reason: from getter */
    public int getCurRealTimeSpeed() {
        return this.curRealTimeSpeed;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getReceivedLength, reason: from getter */
    public long getReceivedLen() {
        return this.receivedLen;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getSaveDir, reason: from getter */
    public String getFileDir() {
        return this.fileDir;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getSavePath, reason: from getter */
    public String getFullSavePath() {
        return this.fullSavePath;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getStartTime, reason: from getter */
    public long getTaskStartTime() {
        return this.taskStartTime;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public DownloaderTaskStatus getStatus() {
        DownloaderTaskStatus downloaderTaskStatus = this.downloadStatus;
        return downloaderTaskStatus == null ? DownloaderTaskStatus.PENDING : downloaderTaskStatus;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getTotalLength, reason: from getter */
    public long getTotalLen() {
        return this.totalLen;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public int getType() {
        return 0;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getUniqueKey, reason: from getter */
    public String getTaskUniqueKey() {
        return this.taskUniqueKey;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    /* renamed from: getUrl, reason: from getter */
    public String getFileUrl() {
        return this.fileUrl;
    }

    public final void h(long received, long total, long realTimeSpeed, long averageSpeed) {
        this.downloadStatus = DownloaderTaskStatus.DOWNLOADING;
        this.receivedLen = received;
        this.totalLen = total;
        int i3 = (int) (averageSpeed * 1000);
        this.curRealTimeSpeed = i3;
        this.curAverageSpeed = i3;
    }

    public final void i() {
        this.downloadStatus = DownloaderTaskStatus.STARTED;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public boolean isDeleted() {
        return this.downloadStatus == DownloaderTaskStatus.DELETED;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public boolean isFailed() {
        return this.downloadStatus == DownloaderTaskStatus.FAILED;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public boolean isPaused() {
        return this.downloadStatus == DownloaderTaskStatus.PAUSED;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public boolean isPausedOnMobile() {
        return false;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public boolean isRunning() {
        return this.downloadStatus == DownloaderTaskStatus.STARTED || this.downloadStatus == DownloaderTaskStatus.DOWNLOADING;
    }

    public final void j(Map<String, ? extends List<String>> headerMap) {
        Intrinsics.checkNotNullParameter(headerMap, "headerMap");
        this.httpRspHeader = headerMap;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public boolean resume() {
        return true;
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public void pause() {
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public void removeAllListeners() {
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public void addListener(DownloaderTaskListener listener) {
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public void removeListener(DownloaderTaskListener listener) {
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public void setCategory(DownloaderTaskCategory category) {
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public void setEnableCrcCheck(boolean enable) {
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public void setTaskSpeedLimit(int taskSpeedLimit) {
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public void addHeader(String header, String headerValue) {
    }

    @Override // com.tencent.halley.downloader.DownloaderTask
    public void manualSetFailInfo(int failCode, String failInfo) {
    }
}
