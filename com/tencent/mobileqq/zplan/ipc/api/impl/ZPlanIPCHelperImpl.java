package com.tencent.mobileqq.zplan.ipc.api.impl;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.z1.base.openId.ZootopiaOpenIdResult;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadReq;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.ipc.ab;
import com.tencent.mobileqq.zootopia.ipc.ac;
import com.tencent.mobileqq.zootopia.ipc.ai;
import com.tencent.mobileqq.zootopia.ipc.f;
import com.tencent.mobileqq.zootopia.ipc.n;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.mobileqq.zplan.ipc.api.impl.ZPlanIPCHelperImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.report.ExtItem;
import com.tencent.sqshow.zootopia.report.MsgBodyContent;
import com.tencent.sqshow.zootopia.report.ReportMsgBean;
import com.tencent.sqshow.zootopia.report.ReportMsgInfo;
import com.tencent.sqshow.zootopia.utils.w;
import java.util.ArrayList;
import k74.i;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zu4.t;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 82\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J8\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u0016\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J(\u0010\u001a\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u0018\u0010#\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0016J \u0010(\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u000bH\u0016J\b\u0010)\u001a\u00020\u0010H\u0016J\u0018\u0010,\u001a\u00020\u00102\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0*H\u0016J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u000bH\u0016J\u0010\u00100\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u0017H\u0016J\u0018\u00101\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u00102\u001a\u00020\u0010H\u0016J\u0010\u00105\u001a\u00020\u00102\u0006\u00104\u001a\u000203H\u0016\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/zplan/ipc/api/impl/ZPlanIPCHelperImpl;", "Lcom/tencent/mobileqq/zplan/ipc/api/IZPlanIPCHelper;", "Lzu4/t;", "data", "", "bubbleIndex", "Lcom/tencent/sqshow/zootopia/report/ReportMsgBean;", "buildReportMsg", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getIPCModule", "category", "", "url", "filePath", WadlProxyConsts.PARAM_FILENAME, "subCategoryName", "", "downloadRemoteManagerStartFileDownload", "Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadReq;", "reqParam", "Lcom/tencent/mobileqq/zootopia/ipc/e;", "callback", "downloadRemoteManagerDownloadResByPath", "", "needProgressCallback", "Lgc3/c;", "downloadProgressHelperBindFileDownloadProgress", "zootopiaServiceManagerStartZPlanService", "shouldCheckFloat", "zootopiaServiceManagerStopZPlanService", "from", "previewEngineHelperStartEngine", "cmdId", "", "buf", "oidbPushForMainProcessOnReceive", "gender", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "avatarCharacter", "openFilamentFaceCamera", "nativeUiIPCAvatarCharacterChanged", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "openIdRemoteManagerGetOpenIdInfoSilent", "scene", "dressInfoIpcRefreshDressInfo", "isInAvatar", "smallHomeSetIsInAvatarScene", "reportSmallHomeBubbleExpose", "eventAndMsgReportApiInitRegisterDatabaseModelClass", "", "msgBean", "eventAndMsgReportApiReportMsg", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanIPCHelperImpl implements IZPlanIPCHelper {
    private static final a Companion = new a(null);

    @Deprecated
    public static final String TAG = "ZPlanIPCHelperImpl";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zplan/ipc/api/impl/ZPlanIPCHelperImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/ipc/api/impl/ZPlanIPCHelperImpl$b", "Lrh3/b;", "", "onSuccess", "", "errorCode", "", "msg", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements rh3.b {
        b() {
        }

        @Override // rh3.b
        public void onFailed(int errorCode, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.e(ZPlanIPCHelperImpl.TAG, 1, "report fail " + errorCode + ", " + msg2);
        }

        @Override // rh3.b
        public void onSuccess() {
            QLog.i(ZPlanIPCHelperImpl.TAG, 1, "report success");
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/ipc/api/impl/ZPlanIPCHelperImpl$c", "Lcom/tencent/mobileqq/zootopia/ipc/ab;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "", "errCode", "", "errMsg", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements ab {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e<ZootopiaOpenIdResult> f333749a;

        c(e<ZootopiaOpenIdResult> eVar) {
            this.f333749a = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void a(ZootopiaOpenIdResult result) {
            this.f333749a.onResultSuccess(result);
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void b(int errCode, String errMsg) {
            this.f333749a.onResultFailure(errCode, errMsg);
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void c() {
            QLog.e("ZPlanUtil", 1, "onReAuthorization");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/ipc/api/impl/ZPlanIPCHelperImpl$d", "Lrh3/b;", "", "onSuccess", "", "errorCode", "", "msg", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements rh3.b {
        d() {
        }

        @Override // rh3.b
        public void onFailed(int errorCode, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.e(ZPlanIPCHelperImpl.TAG, 1, "reportSmallHomeBubbleExpose fail " + errorCode + ", " + msg2);
        }

        @Override // rh3.b
        public void onSuccess() {
            QLog.d(ZPlanIPCHelperImpl.TAG, 1, "reportSmallHomeBubbleExpose success");
        }
    }

    private final ReportMsgBean buildReportMsg(t data, int bubbleIndex) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new ExtItem("type", String.valueOf(data.f453480a)));
        arrayList2.add(new ExtItem("bubble_index", String.valueOf(bubbleIndex)));
        arrayList.add(new ReportMsgInfo(System.nanoTime(), 6001, new MsgBodyContent(w.f373306a.b(), NetConnInfoCenter.getServerTimeMillis(), arrayList2)));
        return new ReportMsgBean(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openIdRemoteManagerGetOpenIdInfoSilent$lambda$0(e callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ((ac) i.INSTANCE.a(ac.class)).getOpenIdInfoSilent(new c(callback));
    }

    @Override // com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper
    public void downloadProgressHelperBindFileDownloadProgress(int category, String url, boolean needProgressCallback, gc3.c callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.zootopia.download.file.b.f328050a.d(category, url, needProgressCallback, callback);
    }

    @Override // com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper
    public void downloadRemoteManagerDownloadResByPath(ZPlanResDownloadReq reqParam, com.tencent.mobileqq.zootopia.ipc.e callback) {
        ((n) i.INSTANCE.a(n.class)).downloadResByPath(reqParam, callback);
    }

    @Override // com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper
    public void downloadRemoteManagerStartFileDownload(int category, String url, String filePath, String fileName, String subCategoryName) {
        ((n) i.INSTANCE.a(n.class)).startFileDownload(category, url, filePath, fileName, subCategoryName);
    }

    @Override // com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper
    public void dressInfoIpcRefreshDressInfo(String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        ((eh3.a) i.INSTANCE.a(eh3.a.class)).refreshDressInfo(scene);
    }

    @Override // com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper
    public void eventAndMsgReportApiInitRegisterDatabaseModelClass() {
        ((rh3.a) i.INSTANCE.a(rh3.a.class)).initRegisterDatabaseModelClass();
    }

    @Override // com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper
    public void eventAndMsgReportApiReportMsg(Object msgBean) {
        Intrinsics.checkNotNullParameter(msgBean, "msgBean");
        ((rh3.a) i.INSTANCE.a(rh3.a.class)).reportMsg((ReportMsgBean) msgBean, new b());
    }

    @Override // com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper
    public QIPCModule getIPCModule() {
        return i.INSTANCE.b();
    }

    @Override // com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper
    public void nativeUiIPCAvatarCharacterChanged() {
        ((cj3.a) i.INSTANCE.a(cj3.a.class)).avatarCharacterChanged();
    }

    @Override // com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper
    public void oidbPushForMainProcessOnReceive(int cmdId, byte[] buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        ((com.tencent.mobileqq.zplan.push.c) i.INSTANCE.a(com.tencent.mobileqq.zplan.push.c.class)).onReceive(cmdId, buf);
    }

    @Override // com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper
    public void openFilamentFaceCamera(int gender, ZootopiaSource source, String avatarCharacter) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(avatarCharacter, "avatarCharacter");
        ((com.tencent.mobileqq.zplan.ipc.business.b) i.INSTANCE.a(com.tencent.mobileqq.zplan.ipc.business.b.class)).openFilamentFaceCamera(gender, source, avatarCharacter);
    }

    @Override // com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper
    public void openIdRemoteManagerGetOpenIdInfoSilent(final e<ZootopiaOpenIdResult> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: ii3.a
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanIPCHelperImpl.openIdRemoteManagerGetOpenIdInfoSilent$lambda$0(e.this);
            }
        }, 128, null, false);
    }

    @Override // com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper
    public void previewEngineHelperStartEngine(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        ((we3.a) i.INSTANCE.a(we3.a.class)).startEngine(from);
    }

    @Override // com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper
    public void reportSmallHomeBubbleExpose(t data, int bubbleIndex) {
        Intrinsics.checkNotNullParameter(data, "data");
        ((rh3.a) i.INSTANCE.a(rh3.a.class)).reportMsg(buildReportMsg(data, bubbleIndex), new d());
    }

    @Override // com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper
    public void smallHomeSetIsInAvatarScene(boolean isInAvatar) {
        ((f) i.INSTANCE.a(f.class)).setIsInAvatarScene(isInAvatar);
    }

    @Override // com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper
    public void zootopiaServiceManagerStartZPlanService() {
        ((ai) i.INSTANCE.a(ai.class)).startZPlanService();
    }

    @Override // com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper
    public void zootopiaServiceManagerStopZPlanService(boolean shouldCheckFloat) {
        ((ai) i.INSTANCE.a(ai.class)).stopZPlanService(shouldCheckFloat);
    }
}
