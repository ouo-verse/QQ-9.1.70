package ls3;

import com.tencent.gamecenter.wadl.api.IQQGameDLService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.manager.MiniBoxDownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.app.api.ProcessConstant;
import nl0.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import us3.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u001cB\u0007\u00a2\u0006\u0004\b-\u0010.J@\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J@\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J1\u0010\u0019\u001a\u00020\u000f2'\u0010\u0018\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f0\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J+\u0010\u001c\u001a\u00020\u000f2!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\u0012\u0010\"\u001a\u00020\u000f2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010%\u001a\u00020\u000f2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010#H\u0016R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010'R0\u0010+\u001a\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00120)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010*R,\u0010,\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u00120)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010*\u00a8\u0006/"}, d2 = {"Lls3/c;", "Lls3/b;", "Lnl0/d;", "", "appId", "packageName", "apkUrl", "", "versionCode", "appName", "iconUrl", "Lls3/a;", "downloadFromExt", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlParams;", "f", "", "b", "c", "Lkotlin/Function1;", "", "Lcom/tencent/qq/minibox/manager/MiniBoxDownloadTask;", "Lkotlin/ParameterName;", "name", "taskList", "callback", h.F, "g", "task", "a", "d", "destroy", "e", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlResult;", "wadlResult", "onWadlStatusChanged", "Ljava/util/ArrayList;", "wadlResults", "onQueryCallback", "Lcom/tencent/gamecenter/wadl/api/IQQGameDLService;", "Lcom/tencent/gamecenter/wadl/api/IQQGameDLService;", "mDownloadService", "", "Ljava/util/List;", "queryCallBackList", "downloadStatusCallBackList", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public class c implements b, d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private IQQGameDLService mDownloadService;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Function1<List<MiniBoxDownloadTask>, Unit>> queryCallBackList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Function1<MiniBoxDownloadTask, Unit>> downloadStatusCallBackList;

    public c() {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI);
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026ocessConstant.MULTI\n    )");
        this.mDownloadService = (IQQGameDLService) runtimeService;
        this.queryCallBackList = new ArrayList();
        this.downloadStatusCallBackList = new ArrayList();
    }

    private final WadlParams f(String appId, String packageName, String apkUrl, int versionCode, String appName, String iconUrl, DownloadFromExt downloadFromExt) {
        WadlParams wadlParams = new WadlParams(appId, packageName);
        wadlParams.setFlagDisable(1);
        wadlParams.setFlagDisable(16384);
        wadlParams.packageName = packageName;
        wadlParams.appName = appName;
        wadlParams.iconUrl = iconUrl;
        wadlParams.apkUrl = apkUrl;
        wadlParams.versionCode = versionCode;
        wadlParams.via = "MiniBox";
        wadlParams.scene = downloadFromExt.getScene();
        wadlParams.launchVia = downloadFromExt.getVia();
        wadlParams.reportData = downloadFromExt.getReportData();
        return wadlParams;
    }

    @Override // ls3.b
    public void a(@NotNull Function1<? super MiniBoxDownloadTask, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.downloadStatusCallBackList.add(callback);
        this.mDownloadService.registerDownloadCallBack(this);
    }

    @Override // ls3.b
    public void b(@NotNull String appId, @NotNull String packageName, @NotNull String apkUrl, int versionCode, @NotNull String appName, @NotNull String iconUrl, @NotNull DownloadFromExt downloadFromExt) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(apkUrl, "apkUrl");
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(downloadFromExt, "downloadFromExt");
        QLog.d("WadlDownloadAction", 1, "startDownload packageName=" + packageName);
        this.mDownloadService.doDownloadAction(e(), f(appId, packageName, apkUrl, versionCode, appName, iconUrl, downloadFromExt));
    }

    @Override // ls3.b
    public void c(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.mDownloadService.doResumeAction(e(), packageName);
    }

    public void d(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.mDownloadService.deleteDownload(e(), packageName);
    }

    @Override // ls3.b
    public void destroy() {
        this.downloadStatusCallBackList.clear();
        this.queryCallBackList.clear();
        this.mDownloadService.unRegisterDownloadCallBack(this);
    }

    public int e() {
        return 3;
    }

    public void g() {
        this.mDownloadService.doQueryAllTask(e());
    }

    public void h(@NotNull Function1<? super List<MiniBoxDownloadTask>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.queryCallBackList.add(callback);
    }

    @Override // nl0.d
    public void onQueryCallback(@Nullable ArrayList<WadlResult> wadlResults) {
        if (wadlResults == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = wadlResults.iterator();
        while (it.hasNext()) {
            arrayList.add(i.f439988a.c((WadlResult) it.next()));
        }
        Iterator<T> it5 = this.queryCallBackList.iterator();
        while (it5.hasNext()) {
            ((Function1) it5.next()).invoke(arrayList);
        }
    }

    @Override // nl0.d
    public void onWadlStatusChanged(@Nullable WadlResult wadlResult) {
        if (wadlResult != null) {
            MiniBoxDownloadTask c16 = i.f439988a.c(wadlResult);
            Iterator<T> it = this.downloadStatusCallBackList.iterator();
            while (it.hasNext()) {
                Function1 function1 = (Function1) it.next();
                if (function1 != null) {
                }
            }
        }
    }
}
