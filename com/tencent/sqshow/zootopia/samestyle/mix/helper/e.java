package com.tencent.sqshow.zootopia.samestyle.mix.helper;

import android.app.Activity;
import android.content.Intent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplatePreviewFragment;
import com.tencent.sqshow.zootopia.samestyle.res.ZPlanSameStyleResHelper;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f*\u0001)\b\u0000\u0018\u0000 62\u00020\u0001:\u00017B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0019\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010*R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/e;", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/d;", "", ReportConstant.COSTREPORT_PREFIX, "", "path", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", "", "progress", "u", "(Ljava/lang/Integer;)V", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$c;", "pakCheckResult", "w", "(Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$c;)V", "bsResCheckResult", "v", DomainData.DOMAIN_NAME, "()V", "p", "r", "o", "Lsb4/a;", "D", "Lsb4/a;", "previewPage", "E", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$c;", UserInfo.SEX_FEMALE, "", "G", "J", "startTime", "", "H", "Z", "mIsFileExist", "I", "CATEGORY_SAME_STYLE_PAK", "com/tencent/sqshow/zootopia/samestyle/mix/helper/e$c", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/e$c;", "ueResListener", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/u;", "K", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/u;", "getDownloadListener", "()Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/u;", HippyTKDListViewAdapter.X, "(Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/u;)V", "downloadListener", "<init>", "(Lsb4/a;)V", "L", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e extends d {

    /* renamed from: D, reason: from kotlin metadata */
    private final sb4.a previewPage;

    /* renamed from: E, reason: from kotlin metadata */
    private ZPlanTemplatePreviewFragment.ResCheckResult pakCheckResult;

    /* renamed from: F, reason: from kotlin metadata */
    private ZPlanTemplatePreviewFragment.ResCheckResult bsResCheckResult;

    /* renamed from: G, reason: from kotlin metadata */
    private long startTime;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mIsFileExist;

    /* renamed from: I, reason: from kotlin metadata */
    private final int CATEGORY_SAME_STYLE_PAK;

    /* renamed from: J, reason: from kotlin metadata */
    private final c ueResListener;

    /* renamed from: K, reason: from kotlin metadata */
    private u downloadListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/sqshow/zootopia/samestyle/mix/helper/e$b", "Lgc3/c;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "errorCode", "", "onFinalCallback", "", "progress", "", "receivedBytes", "totalBytes", "onProgress", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements gc3.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f372944b;

        b(File file) {
            this.f372944b = file;
        }

        @Override // gc3.c
        public void onFinalCallback(String taskId, int downloadStatus, int errorCode) {
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            QLog.i("NormalTemplateDownloadHelper_", 1, "downloadPakResource onFinalCallback -- downloadStatus = " + downloadStatus + " , errorCode = " + errorCode);
            if (downloadStatus == 5) {
                e.this.w(new ZPlanTemplatePreviewFragment.ResCheckResult(true, 0, "", this.f372944b.getAbsolutePath()));
            } else {
                if (downloadStatus != 6) {
                    return;
                }
                e.this.w(new ZPlanTemplatePreviewFragment.ResCheckResult(false, -1, "pak download fail", null));
            }
        }

        @Override // gc3.c
        public void onProgress(String taskId, float progress, long receivedBytes, long totalBytes) {
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            QLog.i("NormalTemplateDownloadHelper_", 1, "taskId:" + taskId + ", progress:" + progress + ", receivedBytes:" + receivedBytes + ", totalBytes:" + totalBytes);
            e.this.u(Integer.valueOf((int) (((double) progress) * 100.0d)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/samestyle/mix/helper/e$c", "Lji3/n;", "", "a", "", "errorCode", "onDownloadFail", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements ji3.n {
        c() {
        }

        @Override // ji3.n
        public void a() {
            QLog.i("NormalTemplateDownloadHelper_", 1, "checkSameStyleRes onAllReady");
            e.this.v(new ZPlanTemplatePreviewFragment.ResCheckResult(true, 0, "", null));
        }

        @Override // ji3.n
        public void onDownloadFail(int errorCode) {
            QLog.e("NormalTemplateDownloadHelper_", 1, "checkSameStyleRes onDownloadFail - " + errorCode);
            e.this.v(new ZPlanTemplatePreviewFragment.ResCheckResult(false, errorCode, "download res fail", null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(sb4.a previewPage) {
        super(previewPage.getF372926a(), previewPage.getF372927b(), previewPage.getF372928c(), previewPage.getF372929d(), previewPage.b(), previewPage.getLifecycleOwner(), previewPage.getSource());
        Intrinsics.checkNotNullParameter(previewPage, "previewPage");
        this.previewPage = previewPage;
        this.CATEGORY_SAME_STYLE_PAK = ZPlanFileCategory.SAME_STYLE_PAK.getValue();
        this.ueResListener = new c();
    }

    private final void q() {
        boolean startsWith$default;
        Intent intent;
        this.startTime = System.currentTimeMillis();
        String downloadUrl = getMTemplate().getDownloadUrl();
        if (!(downloadUrl.length() == 0)) {
            String str = null;
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(downloadUrl, "http", false, 2, null);
            if (!startsWith$default) {
                Activity activity = this.previewPage.getActivity();
                if (activity != null && (intent = activity.getIntent()) != null) {
                    str = intent.getStringExtra("pak_download_url_prefix");
                }
                QLog.i("NormalTemplateDownloadHelper_", 1, "download prefix = " + str);
                if (!(str == null || str.length() == 0)) {
                    downloadUrl = str + downloadUrl;
                }
            }
            QLog.i("NormalTemplateDownloadHelper_", 1, "start download pak file, raw url = " + downloadUrl);
            byte[] bytes = getMTemplate().getDownloadUrl().getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            String fileMd5 = SecUtil.getFileMd5(new ByteArrayInputStream(bytes));
            File file = new File(getMContext().getCacheDir(), "cmshow/samestyle/asset/" + fileMd5 + "/");
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "template_" + getMTemplate().getTimestamp() + ".pak";
            File file2 = new File(file, str2);
            this.mIsFileExist = false;
            QLog.i("NormalTemplateDownloadHelper_", 1, "template pak save name = " + file2.getAbsolutePath());
            if (file2.exists()) {
                QLog.i("NormalTemplateDownloadHelper_", 1, "cache pak exist, use it directly");
                this.mIsFileExist = true;
                w(new ZPlanTemplatePreviewFragment.ResCheckResult(true, 0, "", file2.getAbsolutePath()));
                return;
            } else {
                if (!NetworkUtil.isNetworkAvailable(getMContext())) {
                    QLog.e("NormalTemplateDownloadHelper_", 1, "start download pak file, but network not available");
                    return;
                }
                String absolutePath = file.getAbsolutePath();
                FileUtils.deleteFilesInDirectory(absolutePath);
                QLog.i("NormalTemplateDownloadHelper_", 1, "downloadPakResource BEGIN  delete old pak");
                int i3 = this.CATEGORY_SAME_STYLE_PAK;
                ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).downloadRemoteManagerStartFileDownload(i3, downloadUrl, absolutePath, str2, "");
                ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).downloadProgressHelperBindFileDownloadProgress(i3, downloadUrl, true, new b(file2));
                return;
            }
        }
        QLog.e("NormalTemplateDownloadHelper_", 1, "url is empty");
    }

    @Override // com.tencent.sqshow.zootopia.samestyle.mix.helper.d
    public void i() {
        super.i();
        this.downloadListener = null;
    }

    public final void n() {
        ZPlanTemplatePreviewFragment.ResCheckResult resCheckResult = this.pakCheckResult;
        boolean z16 = false;
        if (resCheckResult != null && resCheckResult.getIsSuccess()) {
            ZPlanTemplatePreviewFragment.ResCheckResult resCheckResult2 = this.bsResCheckResult;
            if (resCheckResult2 != null && resCheckResult2.getIsSuccess()) {
                z16 = true;
            }
            if (z16) {
                ZPlanTemplatePreviewFragment.ResCheckResult resCheckResult3 = this.pakCheckResult;
                Object successData = resCheckResult3 != null ? resCheckResult3.getSuccessData() : null;
                t(successData instanceof String ? (String) successData : null);
                return;
            }
        }
        QLog.i("NormalTemplateDownloadHelper_", 1, "checkAllResResult has not ready");
    }

    public final void o() {
        ZPlanSameStyleResHelper.f372974a.k("NormalTemplateDownloadHelper_", this.ueResListener);
    }

    public final void r() {
        try {
            q();
        } catch (Exception e16) {
            QLog.e("NormalTemplateDownloadHelper_", 1, "downloadPakResource error", e16);
        }
    }

    public final void v(ZPlanTemplatePreviewFragment.ResCheckResult bsResCheckResult) {
        Intrinsics.checkNotNullParameter(bsResCheckResult, "bsResCheckResult");
        QLog.i("NormalTemplateDownloadHelper_", 1, "handleTmpResultForBsRes - " + bsResCheckResult.getIsSuccess());
        this.bsResCheckResult = bsResCheckResult;
        if (bsResCheckResult.getIsSuccess()) {
            n();
            return;
        }
        ZPlanTemplatePreviewFragment.ResCheckResult resCheckResult = this.pakCheckResult;
        if ((resCheckResult == null || resCheckResult.getIsSuccess()) ? false : true) {
            return;
        }
        s();
    }

    public final void w(ZPlanTemplatePreviewFragment.ResCheckResult pakCheckResult) {
        Intrinsics.checkNotNullParameter(pakCheckResult, "pakCheckResult");
        QLog.i("NormalTemplateDownloadHelper_", 1, "handleTmpResultForPak - " + pakCheckResult);
        this.pakCheckResult = pakCheckResult;
        if (pakCheckResult.getIsSuccess()) {
            n();
            return;
        }
        ZPlanTemplatePreviewFragment.ResCheckResult resCheckResult = this.bsResCheckResult;
        if ((resCheckResult == null || resCheckResult.getIsSuccess()) ? false : true) {
            return;
        }
        s();
    }

    public final void x(u uVar) {
        this.downloadListener = uVar;
    }

    private final void s() {
        QLog.i("NormalTemplateDownloadHelper_", 1, "finalHandleResDownloadFail");
        u uVar = this.downloadListener;
        if (uVar != null) {
            uVar.I5();
        }
    }

    private final void t(String path) {
        if (path == null) {
            QLog.e("NormalTemplateDownloadHelper_", 1, "finalHandleResDownloadSuccess, but path is null");
            return;
        }
        QLog.i("NormalTemplateDownloadHelper_", 1, "finalHandleResDownloadSuccess, path = " + path);
        u uVar = this.downloadListener;
        if (uVar != null) {
            uVar.sf(path);
        }
        id3.d mReporter = getMReporter();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(getMSource()));
        linkedHashMap.put(QCircleScheme.AttrQQPublish.ZPLAN_SAMESTYLE_ID, Integer.valueOf(getMTemplate().getId()));
        linkedHashMap.put("zplan_samestyle_type", Integer.valueOf(getMTemplate().getContentType()));
        linkedHashMap.put("zplan_loading_lvtm", Long.valueOf(System.currentTimeMillis() - this.startTime));
        Unit unit = Unit.INSTANCE;
        mReporter.d("ev_zplan_samestyle_loading_success", linkedHashMap);
    }

    public final void p() {
        this.bsResCheckResult = null;
        this.pakCheckResult = null;
    }

    public final void u(Integer progress) {
        if (progress != null) {
            progress.intValue();
            QLog.i("NormalTemplateDownloadHelper_", 1, "download pak file progress: " + progress);
            u uVar = this.downloadListener;
            if (uVar != null) {
                uVar.Fg(progress.intValue());
            }
        }
    }
}
