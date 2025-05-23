package com.tencent.mobileqq.zootopia.download;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.halley.downloader.DownloaderTask;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadResult;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\b\b*\u0001z\b\u0016\u0018\u0000 \u0080\u00012\u00020\u0001:\u0001AB?\u0012\u0006\u0010C\u001a\u00020\u0006\u0012\u0006\u0010D\u001a\u00020\u0006\u0012\u0006\u0010E\u001a\u00020\u0006\u0012\u0006\u0010F\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010L\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010:\u00a2\u0006\u0004\b~\u0010\u007fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J&\u0010\u0010\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0004J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020\u0013H\u0016J\b\u0010'\u001a\u00020#H\u0016J\n\u0010)\u001a\u0004\u0018\u00010(H\u0016J\b\u0010*\u001a\u00020\u001aH\u0016J\b\u0010+\u001a\u00020\u001aH\u0016J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H\u0016J\u0010\u00100\u001a\u00020!2\u0006\u0010/\u001a\u00020!H\u0016J\u0016\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u000101H\u0016J\b\u00103\u001a\u00020\u0006H\u0016J\b\u00104\u001a\u00020\u0006H\u0016J\b\u00105\u001a\u00020\u0013H\u0016J\b\u00106\u001a\u00020\u0013H\u0016J\b\u00107\u001a\u00020\u0013H\u0016J\b\u00108\u001a\u00020\u0013H\u0016J\b\u00109\u001a\u00020\u0013H\u0016J\u001c\u0010<\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060;\u0018\u00010:H\u0016J\b\u0010=\u001a\u00020\u0013H\u0016J\b\u0010>\u001a\u00020\u0004H\u0014J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020,0?H\u0004R\u0014\u0010C\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010BR\u0016\u0010E\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010BR\u0016\u0010F\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010BR0\u0010L\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010BR \u0010R\u001a\b\u0012\u0004\u0012\u00020,0N8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b8\u0010O\u001a\u0004\bP\u0010QR\u0014\u0010U\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010TR\"\u0010Z\u001a\u00020\u001a8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b9\u00103\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010[R\"\u0010a\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010B\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010d\u001a\u00020\u001a8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b=\u00103\u001a\u0004\bb\u0010W\"\u0004\bc\u0010YR\u0016\u0010e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010BR\u0016\u0010f\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010PR\u0016\u0010h\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010&R\u0016\u0010j\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010&R\u0016\u0010l\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u00103R\u0016\u0010n\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u00103R*\u0010p\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060;\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010GR$\u0010w\u001a\u0004\u0018\u00010(8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0016\u0010y\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010&R\u0014\u0010}\u001a\u00020z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b{\u0010|\u00a8\u0006\u0081\u0001"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/BaseDownloadTask;", "Lcom/tencent/mobileqq/zootopia/download/x;", "Lcom/tencent/halley/downloader/DownloaderTask;", "task", "", "T", "", "msg", "L", "taskType", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "downloadUrl", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "newUrl", "newFilePath", "newFileName", "U", "d", "startDownload", "", "c", "canPause", "pause", "f", "delete", "K", "", "getDownloadStatus", "getFailCode", "getFailInfo", "getTaskId", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", HippyQQPagView.FunctionName.GET_PROGRESS, "", "getReceivedLength", "getTotalLength", "J", "B", "Lcom/tencent/mobileqq/zootopia/download/file/ZPlanFileDownloadResult;", "j", "getRealTimeSpeed", "getAverageSpeed", "Lcom/tencent/mobileqq/zootopia/download/y;", "listener", tl.h.F, "singleProgress", "k", "Lkotlin/Pair;", "getIndex", "I", "H", DomainData.DOMAIN_NAME, "e", "V", "g", "i", "", "", "getHttpRspHeaderMap", "l", "M", "", "E", "a", "Ljava/lang/String;", "id", "url", "filePath", WadlProxyConsts.PARAM_FILENAME, "Ljava/util/Map;", "D", "()Ljava/util/Map;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Ljava/util/Map;)V", "header", "taskUniqueTraceKey", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", UserInfo.SEX_FEMALE, "()Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "Lec3/a;", "Lec3/a;", "reporter", "G", "()I", BdhLogUtil.LogTag.Tag_Req, "(I)V", "taskStatus", "Z", "isResumeStart", BdhLogUtil.LogTag.Tag_Conn, "()Ljava/lang/String;", "P", "(Ljava/lang/String;)V", "finalSavePath", "getDownloadFailCode", "N", "downloadFailCode", "downloadFailInfo", "curProgress", "o", "curReceivedLength", "p", "curTotalLength", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "curRealTimeSpeed", "r", "curAverageSpeed", ReportConstant.COSTREPORT_PREFIX, "httpRspHeader", "t", "Lcom/tencent/mobileqq/zootopia/download/file/ZPlanFileDownloadResult;", "getDownloadResultInfo", "()Lcom/tencent/mobileqq/zootopia/download/file/ZPlanFileDownloadResult;", "O", "(Lcom/tencent/mobileqq/zootopia/download/file/ZPlanFileDownloadResult;)V", "downloadResultInfo", "u", "downloadCost", "com/tencent/mobileqq/zootopia/download/BaseDownloadTask$halleyDownloadListener$1", "v", "Lcom/tencent/mobileqq/zootopia/download/BaseDownloadTask$halleyDownloadListener$1;", "halleyDownloadListener", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "w", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class BaseDownloadTask implements x {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String url;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String filePath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String fileName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Map<String, String> header;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String taskUniqueTraceKey;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<y> listeners;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ec3.a reporter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private volatile int taskStatus;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isResumeStart;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String finalSavePath;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int downloadFailCode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String downloadFailInfo;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private float curProgress;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private long curReceivedLength;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private long curTotalLength;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int curRealTimeSpeed;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private int curAverageSpeed;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private Map<String, ? extends List<String>> httpRspHeader;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private ZPlanFileDownloadResult downloadResultInfo;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private long downloadCost;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final BaseDownloadTask$halleyDownloadListener$1 halleyDownloadListener;

    public BaseDownloadTask(String id5, String url, String filePath, String fileName, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.id = id5;
        this.url = url;
        this.filePath = filePath;
        this.fileName = fileName;
        this.header = map;
        this.taskUniqueTraceKey = "";
        this.listeners = new CopyOnWriteArrayList<>();
        this.reporter = new ec3.a();
        this.taskStatus = 1;
        this.finalSavePath = "";
        this.downloadFailInfo = "";
        this.halleyDownloadListener = new BaseDownloadTask$halleyDownloadListener$1(this);
    }

    private final String A(String taskType, String taskId, String downloadUrl) {
        String str = taskType + "_" + taskId + "_" + MD5.toMD5(downloadUrl) + "_" + System.currentTimeMillis() + "_" + new Random().nextInt(Integer.MAX_VALUE);
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder()\n        \u2026nt.MAX_VALUE)).toString()");
        QLog.i("Zootopia_DownloadTask", 1, "createTaskTraceKey = " + str + ", url= " + downloadUrl);
        return str;
    }

    private final void L(String msg2) {
        QLog.i("Zootopia_DownloadTask", 1, this.id + " -- " + msg2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(long j3, BaseDownloadTask this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HalleyDownloader.f327980a.e(this$0.V(), this$0.url, this$0.filePath, this$0.fileName, this$0.header, this$0.halleyDownloadListener, System.currentTimeMillis() - j3);
    }

    /* renamed from: B, reason: from getter */
    public long getDownloadCost() {
        return this.downloadCost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C, reason: from getter */
    public final String getFinalSavePath() {
        return this.finalSavePath;
    }

    public final Map<String, String> D() {
        return this.header;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Collection<y> E() {
        return new ArrayList(this.listeners);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final CopyOnWriteArrayList<y> F() {
        return this.listeners;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: G, reason: from getter */
    public final int getTaskStatus() {
        return this.taskStatus;
    }

    /* renamed from: H, reason: from getter */
    public String getTaskUniqueTraceKey() {
        return this.taskUniqueTraceKey;
    }

    /* renamed from: I */
    public String getCategory() {
        return "";
    }

    /* renamed from: J, reason: from getter */
    public boolean getIsResumeStart() {
        return this.isResumeStart;
    }

    /* renamed from: K */
    public boolean getIsUpdate() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void N(int i3) {
        this.downloadFailCode = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void O(ZPlanFileDownloadResult zPlanFileDownloadResult) {
        this.downloadResultInfo = zPlanFileDownloadResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.finalSavePath = str;
    }

    public final void Q(Map<String, String> map) {
        this.header = map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void R(int i3) {
        this.taskStatus = i3;
    }

    public boolean V() {
        return false;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    /* renamed from: b, reason: from getter */
    public String getUrl() {
        return this.url;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    public boolean c() {
        return this.taskStatus == 1 || this.taskStatus == 6 || this.taskStatus == 4;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    public boolean canPause() {
        return this.taskStatus == 2 || this.taskStatus == 1;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    public void d() {
        if (TextUtils.isEmpty(this.taskUniqueTraceKey)) {
            L("first create");
            this.taskUniqueTraceKey = A(getCategory(), this.id, this.url);
            this.reporter.j(this.url, this.id, getCategory(), getTaskUniqueTraceKey(), getIsUpdate());
        } else {
            L("already created - " + this.taskUniqueTraceKey);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    public void delete() {
        QLog.i("Zootopia_DownloadTask", 1, this.id + " delete");
        HalleyDownloader.f327980a.d(this.url, true);
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    public boolean e() {
        return false;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    /* renamed from: g */
    public boolean getIsSilentDownload() {
        return false;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    /* renamed from: getAverageSpeed, reason: from getter */
    public int getCurAverageSpeed() {
        return this.curAverageSpeed;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    public int getDownloadStatus() {
        return this.taskStatus;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    /* renamed from: getFailCode, reason: from getter */
    public int getDownloadFailCode() {
        return this.downloadFailCode;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    /* renamed from: getFailInfo, reason: from getter */
    public String getDownloadFailInfo() {
        return this.downloadFailInfo;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    public Map<String, List<String>> getHttpRspHeaderMap() {
        return this.httpRspHeader;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    public Pair<Integer, Integer> getIndex() {
        return null;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    /* renamed from: getProgress, reason: from getter */
    public float getCurProgress() {
        return this.curProgress;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    /* renamed from: getRealTimeSpeed, reason: from getter */
    public int getCurRealTimeSpeed() {
        return this.curRealTimeSpeed;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    /* renamed from: getReceivedLength, reason: from getter */
    public long getCurReceivedLength() {
        return this.curReceivedLength;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    /* renamed from: getTaskId, reason: from getter */
    public String getId() {
        return this.id;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    /* renamed from: getTotalLength, reason: from getter */
    public long getCurTotalLength() {
        return this.curTotalLength;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    public void h(y listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.listeners.contains(listener)) {
            return;
        }
        this.listeners.add(listener);
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    /* renamed from: i */
    public boolean getNeedNotification() {
        return false;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    /* renamed from: j, reason: from getter */
    public ZPlanFileDownloadResult getDownloadResultInfo() {
        return this.downloadResultInfo;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    /* renamed from: l */
    public boolean getIsPlayDownloadTogether() {
        return false;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    public String m() {
        return this.finalSavePath;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    public boolean n() {
        return false;
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    public void pause() {
        QLog.i("Zootopia_DownloadTask", 1, this.id + " pause status " + this.taskStatus);
        if (!canPause()) {
            QLog.e("Zootopia_DownloadTask", 1, this.id + " cant pause");
            return;
        }
        if (this.taskStatus == 2) {
            HalleyDownloader.f327980a.l(this.url);
        }
        this.taskStatus = 4;
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((y) it.next()).e(this);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    public void startDownload() {
        QLog.i("Zootopia_DownloadTask", 1, this.id + " startDownload status " + this.taskStatus);
        if (!c()) {
            QLog.w("Zootopia_DownloadTask", 1, this.id + " cant startDownload");
            return;
        }
        this.isResumeStart = 4 == this.taskStatus;
        this.taskStatus = 2;
        final long currentTimeMillis = System.currentTimeMillis();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseDownloadTask.S(currentTimeMillis, this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M() {
        this.taskStatus = 5;
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((y) it.next()).c(this);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    public void f() {
        this.taskStatus = 1;
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((y) it.next()).d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(DownloaderTask task) {
        if (task != null) {
            this.curRealTimeSpeed = task.getCurRealTimeSpeed();
            this.curAverageSpeed = task.getCurAverageSpeed();
            this.curReceivedLength = task.getReceivedLen();
            this.curTotalLength = task.getTotalLen();
            String fullSavePath = task.getFullSavePath();
            Intrinsics.checkNotNullExpressionValue(fullSavePath, "it.savePath");
            this.finalSavePath = fullSavePath;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void U(String newUrl, String newFilePath, String newFileName) {
        if (newUrl != null) {
            this.url = newUrl;
        }
        if (newFilePath != null) {
            this.filePath = newFilePath;
        }
        if (newFileName != null) {
            this.fileName = newFileName;
        }
    }

    public /* synthetic */ BaseDownloadTask(String str, String str2, String str3, String str4, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i3 & 16) != 0 ? null : map);
    }

    @Override // com.tencent.mobileqq.zootopia.download.x
    public float k(float singleProgress) {
        return singleProgress;
    }
}
