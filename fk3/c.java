package fk3;

import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.ds;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadReq;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadUrlRsp;
import com.tencent.mobileqq.zootopia.download.ah;
import com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadUtil;
import com.tencent.mobileqq.zootopia.download.proxy.ZPlanResProxyDownloader;
import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.mobileqq.zplan.resource.api.data.ZPlanResHubIdInfo;
import com.tencent.mobileqq.zplan.resource.api.data.ZPlanResourceBatchDownloadResult;
import com.tencent.mobileqq.zplan.resource.api.data.ZPlanResourceDownloadTask;
import com.tencent.mobileqq.zplan.resource.api.data.ZPlanResourceItemDownloadResult;
import com.tencent.mobileqq.zplan.resource.api.data.ZPlanResourceType;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import com.tencent.zplan.resource.api.a;
import cy4.ZPlanResourceBusinessData;
import fk3.c;
import hv4.g;
import hv4.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nx4.a;
import tl.h;
import wj3.ZPlanResHubLoadData;
import wj3.ZPlanResHubPathParam;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J,\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J,\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J(\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\u0014\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J(\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J0\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tR\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lfk3/c;", "", "", "srcLogTag", "", "Lcom/tencent/mobileqq/zplan/resource/api/data/c;", "taskList", "Lcom/tencent/zplan/resource/api/a;", "resourceCallback", "Lvj3/b;", "mobileDownloadHandler", "", "i", "downloadTask", "batchResultUniqueId", h.F, "f", "", "callbackImmediately", "g", "e", "Lcom/tencent/mobileqq/zplan/resource/api/data/d;", "itemDownloadResult", "isProgressUpdate", "j", "d", "b", "Ljava/lang/String;", "rootFolderPath", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/zplan/resource/api/data/b;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "batchResultMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String rootFolderPath;

    /* renamed from: a, reason: collision with root package name */
    public static final c f399733a = new c();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, ZPlanResourceBatchDownloadResult> batchResultMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes38.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f399736a;

        static {
            int[] iArr = new int[ZPlanResourceType.values().length];
            try {
                iArr[ZPlanResourceType.ResHubId.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ZPlanResourceType.DirectUrl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f399736a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"fk3/c$b", "Lvj3/d;", "", "appId", com.heytap.mcssdk.a.a.f36102l, MosaicConstants$JsProperty.PROP_ENV, "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements vj3.d {
        b() {
        }

        @Override // vj3.d
        public void a(String appId, String appKey, String env) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(appKey, "appKey");
            Intrinsics.checkNotNullParameter(env, "env");
            QLog.i("ZPLanSceneResource_DownloadHandler", 1, "batchDownloadResources, resHub fullLoadCallback");
        }
    }

    static {
        BaseApplication context = BaseApplication.getContext();
        File externalFilesDir = context.getExternalFilesDir(null);
        String path = externalFilesDir != null ? externalFilesDir.getPath() : null;
        if (path == null) {
            path = context.getFilesDir().getPath();
            Intrinsics.checkNotNullExpressionValue(path, "context.filesDir.path");
        }
        rootFolderPath = path;
        QLog.i("ZPLanSceneResource_DownloadHandler", 1, "init, rootFolderPath= " + path);
    }

    c() {
    }

    private final void g(boolean callbackImmediately, ZPlanResourceDownloadTask downloadTask, String batchResultUniqueId, com.tencent.zplan.resource.api.a resourceCallback) {
        g resHubInfoDetail;
        g resHubInfoDetail2;
        g resHubInfoDetail3;
        g resHubInfoDetail4;
        g resHubInfoDetail5;
        g resHubInfoDetail6;
        ZPlanResHubIdInfo resHubIdInfo = downloadTask.getResHubIdInfo();
        String str = null;
        String str2 = (resHubIdInfo == null || (resHubInfoDetail6 = resHubIdInfo.getResHubInfoDetail()) == null) ? null : resHubInfoDetail6.f406425f;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str2;
        ZPlanResHubIdInfo resHubIdInfo2 = downloadTask.getResHubIdInfo();
        String str4 = (resHubIdInfo2 == null || (resHubInfoDetail5 = resHubIdInfo2.getResHubInfoDetail()) == null) ? null : resHubInfoDetail5.f406421b;
        if (str4 == null) {
            String str5 = File.separator;
            ZPlanResHubIdInfo resHubIdInfo3 = downloadTask.getResHubIdInfo();
            String str6 = (resHubIdInfo3 == null || (resHubInfoDetail4 = resHubIdInfo3.getResHubInfoDetail()) == null) ? null : resHubInfoDetail4.f406420a;
            if (str6 == null) {
                str6 = "Default";
            }
            str4 = "ZRes" + str5 + str6 + str5 + "Res";
        }
        ZPlanResHubIdInfo resHubIdInfo4 = downloadTask.getResHubIdInfo();
        String str7 = (resHubIdInfo4 == null || (resHubInfoDetail3 = resHubIdInfo4.getResHubInfoDetail()) == null) ? null : resHubInfoDetail3.f406423d;
        if (str7 == null) {
            String str8 = File.separator;
            ZPlanResHubIdInfo resHubIdInfo5 = downloadTask.getResHubIdInfo();
            String str9 = (resHubIdInfo5 == null || (resHubInfoDetail2 = resHubIdInfo5.getResHubInfoDetail()) == null) ? null : resHubInfoDetail2.f406420a;
            str7 = "ZRes" + str8 + (str9 != null ? str9 : "Default") + str8 + "UnZip";
        }
        String str10 = rootFolderPath;
        String str11 = File.separator;
        String str12 = str10 + str11 + str4;
        String str13 = str10 + str11 + str7;
        ZPlanResHubIdInfo resHubIdInfo6 = downloadTask.getResHubIdInfo();
        if (resHubIdInfo6 != null && (resHubInfoDetail = resHubIdInfo6.getResHubInfoDetail()) != null) {
            str = resHubInfoDetail.f406420a;
        }
        String str14 = str + "_full_" + str3.hashCode() + ".zip";
        long currentTimeMillis = System.currentTimeMillis();
        String str15 = "DirectResHub_downloadWithUrl# " + str3;
        QLog.i("ZPLanSceneResource_DownloadHandler", 1, "START - " + str15 + ", fixedFilePath= " + str12 + ", fileName=" + str14 + ", fixedUnZipPath= " + str13);
        ZPlanFileDownloadUtil.f328039a.f(ZPlanFileCategory.RES_HUB.getValue(), str3, (r21 & 4) != 0 ? "" : str12, (r21 & 8) != 0 ? "" : str14, (r21 & 16) != 0 ? "" : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? Boolean.FALSE : Boolean.TRUE, (r21 & 128) != 0 ? null : new e(callbackImmediately, downloadTask, batchResultUniqueId, resourceCallback, str15, currentTimeMillis, str13));
    }

    private final void h(ZPlanResourceDownloadTask downloadTask, String batchResultUniqueId, com.tencent.zplan.resource.api.a resourceCallback, vj3.b mobileDownloadHandler) {
        int i3 = a.f399736a[downloadTask.getDownloadType().ordinal()];
        if (i3 == 1) {
            f(downloadTask, batchResultUniqueId, resourceCallback, mobileDownloadHandler);
        } else {
            if (i3 != 2) {
                return;
            }
            e(downloadTask, batchResultUniqueId, resourceCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(final ZPlanResourceItemDownloadResult itemDownloadResult, final boolean isProgressUpdate, final String batchResultUniqueId, final com.tencent.zplan.resource.api.a resourceCallback) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: fk3.b
            @Override // java.lang.Runnable
            public final void run() {
                c.k(batchResultUniqueId, itemDownloadResult, isProgressUpdate, resourceCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(String batchResultUniqueId, ZPlanResourceItemDownloadResult itemDownloadResult, boolean z16, com.tencent.zplan.resource.api.a resourceCallback) {
        Object obj;
        Intrinsics.checkNotNullParameter(batchResultUniqueId, "$batchResultUniqueId");
        Intrinsics.checkNotNullParameter(itemDownloadResult, "$itemDownloadResult");
        Intrinsics.checkNotNullParameter(resourceCallback, "$resourceCallback");
        ZPlanResourceBatchDownloadResult zPlanResourceBatchDownloadResult = batchResultMap.get(batchResultUniqueId);
        if (zPlanResourceBatchDownloadResult == null) {
            zPlanResourceBatchDownloadResult = new ZPlanResourceBatchDownloadResult(batchResultUniqueId, new ArrayList(), null, 4, null);
            QLog.e("ZPLanSceneResource_DownloadHandler", 1, batchResultUniqueId + " - updateAndCheckBatchDownloadResult, batchDownloadResult is null!!!, isProgressUpdate= " + z16 + ", itemDownloadResult= " + itemDownloadResult);
        }
        CopyOnWriteArrayList<ZPlanResourceItemDownloadResult> d16 = zPlanResourceBatchDownloadResult.d();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : d16) {
            if (((ZPlanResourceItemDownloadResult) obj2).getIsFinished()) {
                arrayList.add(obj2);
            }
        }
        int size = arrayList.size();
        zPlanResourceBatchDownloadResult.e(itemDownloadResult);
        CopyOnWriteArrayList<ZPlanResourceItemDownloadResult> d17 = zPlanResourceBatchDownloadResult.d();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : d17) {
            if (((ZPlanResourceItemDownloadResult) obj3).getIsSuccess()) {
                arrayList2.add(obj3);
            }
        }
        int size2 = arrayList2.size();
        CopyOnWriteArrayList<ZPlanResourceItemDownloadResult> d18 = zPlanResourceBatchDownloadResult.d();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj4 : d18) {
            if (((ZPlanResourceItemDownloadResult) obj4).getIsFinished()) {
                arrayList3.add(obj4);
            }
        }
        int size3 = arrayList3.size();
        if (z16) {
            Float downloadProgress = itemDownloadResult.getDownloadProgress();
            resourceCallback.f(downloadProgress != null ? downloadProgress.floatValue() : 0.0f, zPlanResourceBatchDownloadResult.a().size(), size2);
            return;
        }
        QLog.i("ZPLanSceneResource_DownloadHandler", 1, batchResultUniqueId + " - updateAndCheckBatchDownloadResult, totalTaskCount= " + zPlanResourceBatchDownloadResult.a().size() + ", finishedTaskCountBefore= " + size + ", finishedTaskCount= " + size3 + ", successTaskCount= " + size2 + ", curTaskCount= " + zPlanResourceBatchDownloadResult.d().size());
        if (zPlanResourceBatchDownloadResult.a().size() == zPlanResourceBatchDownloadResult.d().size() && zPlanResourceBatchDownloadResult.a().size() == size3) {
            Iterator<T> it = zPlanResourceBatchDownloadResult.d().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (!((ZPlanResourceItemDownloadResult) obj).getIsSuccess()) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            ZPlanResourceItemDownloadResult zPlanResourceItemDownloadResult = (ZPlanResourceItemDownloadResult) obj;
            if (zPlanResourceItemDownloadResult == null) {
                a.C10071a.b(resourceCallback, new ZPlanResourceBusinessData(0, true, null, null, zPlanResourceBatchDownloadResult.b(), zPlanResourceBatchDownloadResult.c()), null, 2, null);
            } else {
                CopyOnWriteArrayList<ZPlanResourceItemDownloadResult> d19 = zPlanResourceBatchDownloadResult.d();
                ArrayList arrayList4 = new ArrayList();
                for (Object obj5 : d19) {
                    if (!((ZPlanResourceItemDownloadResult) obj5).getIsSuccess()) {
                        arrayList4.add(obj5);
                    }
                }
                int size4 = arrayList4.size();
                ZPlanSceneResourceErrType zPlanSceneResourceErrType = ZPlanSceneResourceErrType.DownloadError;
                Integer errCode = zPlanResourceItemDownloadResult.getErrCode();
                resourceCallback.d(zPlanSceneResourceErrType, errCode != null ? errCode.intValue() : 0, zPlanResourceItemDownloadResult.getErrMsg(), zPlanResourceBatchDownloadResult.a().size(), size4);
            }
            batchResultMap.remove(batchResultUniqueId);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[LOOP:0: B:7:0x004f->B:42:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(String srcLogTag, List<ZPlanResourceDownloadTask> taskList, com.tencent.zplan.resource.api.a resourceCallback, vj3.b mobileDownloadHandler) {
        String str;
        String str2;
        String env;
        boolean z16;
        Intrinsics.checkNotNullParameter(srcLogTag, "srcLogTag");
        Intrinsics.checkNotNullParameter(taskList, "taskList");
        Intrinsics.checkNotNullParameter(resourceCallback, "resourceCallback");
        QLog.i("ZPLanSceneResource_DownloadHandler", 1, "batchDownloadResources, size = " + taskList.size() + ", START");
        Object obj = null;
        if (taskList.isEmpty()) {
            a.C10071a.b(resourceCallback, ZPlanResourceBusinessData.INSTANCE.a(), null, 2, null);
            return;
        }
        Iterator<T> it = taskList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ZPlanResourceDownloadTask zPlanResourceDownloadTask = (ZPlanResourceDownloadTask) next;
            if (zPlanResourceDownloadTask.getDownloadType() == ZPlanResourceType.ResHubId) {
                ZPlanResHubIdInfo resHubIdInfo = zPlanResourceDownloadTask.getResHubIdInfo();
                if ((resHubIdInfo == null || resHubIdInfo.getUseDirectDownloadUrl()) ? false : true) {
                    z16 = true;
                    if (!z16) {
                        obj = next;
                        break;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        ZPlanResourceDownloadTask zPlanResourceDownloadTask2 = (ZPlanResourceDownloadTask) obj;
        if (zPlanResourceDownloadTask2 != null) {
            ZPlanResHubIdInfo resHubIdInfo2 = zPlanResourceDownloadTask2.getResHubIdInfo();
            String str3 = "";
            if (resHubIdInfo2 == null || (str = resHubIdInfo2.getAppId()) == null) {
                str = "";
            }
            ZPlanResHubIdInfo resHubIdInfo3 = zPlanResourceDownloadTask2.getResHubIdInfo();
            if (resHubIdInfo3 == null || (str2 = resHubIdInfo3.getAppKey()) == null) {
                str2 = "";
            }
            ZPlanResHubIdInfo resHubIdInfo4 = zPlanResourceDownloadTask2.getResHubIdInfo();
            if (resHubIdInfo4 != null && (env = resHubIdInfo4.getEnv()) != null) {
                str3 = env;
            }
            vb3.a aVar = vb3.a.f441346a;
            ((vj3.a) aVar.a(vj3.a.class)).f(false);
            ((vj3.a) aVar.a(vj3.a.class)).M(str, str2, str3);
            ((vj3.a) aVar.a(vj3.a.class)).i0(str, str2, str3, new b());
        }
        i(srcLogTag, taskList, resourceCallback, mobileDownloadHandler);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u001a\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0016"}, d2 = {"fk3/c$c", "Lqb3/b;", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "filePath", "Lnx4/a$b;", "result", "Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadUrlRsp;", "urlRspInfo", "", "b", "", "progress", "", "writtenBytes", "totalBytes", "onDownloadProgress", "errorCode", "errorMessage", "onDownloadFailed", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fk3.c$c, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10324c implements qb3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f399737a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f399738b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f399739c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f399740d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZPlanResourceDownloadTask f399741e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.zplan.resource.api.a f399742f;

        C10324c(String str, String str2, long j3, boolean z16, ZPlanResourceDownloadTask zPlanResourceDownloadTask, com.tencent.zplan.resource.api.a aVar) {
            this.f399737a = str;
            this.f399738b = str2;
            this.f399739c = j3;
            this.f399740d = z16;
            this.f399741e = zPlanResourceDownloadTask;
            this.f399742f = aVar;
        }

        @Override // qb3.b
        public void a(int errorCode, String errorMessage) {
            QLog.e("ZPLanSceneResource_DownloadHandler", 1, this.f399737a + " - onGetDownloadUrlError!!! - " + this.f399738b + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", totalCallbackTime=" + (System.currentTimeMillis() - this.f399739c) + "ms");
            if (this.f399740d) {
                return;
            }
            c.f399733a.j(new ZPlanResourceItemDownloadResult(this.f399741e, null, null, true, false, Integer.valueOf(errorCode), errorMessage, null, null, null, null, null, null, 8064, null), false, this.f399737a, this.f399742f);
        }

        @Override // qb3.b
        public void b(int statusCode, String filePath, a.b result, ZPlanResDownloadUrlRsp urlRspInfo) {
            Intrinsics.checkNotNullParameter(urlRspInfo, "urlRspInfo");
            QLog.i("ZPLanSceneResource_DownloadHandler", 1, this.f399737a + " - onDownloadSucceed!!! - " + this.f399738b + ", statusCode=" + statusCode + ",  totalCallbackTime=" + (System.currentTimeMillis() - this.f399739c) + "ms, filePath=" + filePath);
            if (this.f399740d) {
                return;
            }
            c.f399733a.j(new ZPlanResourceItemDownloadResult(this.f399741e, filePath, urlRspInfo, true, true, Integer.valueOf(statusCode), "", Float.valueOf(100.0f), null, null, null, null, null, 7936, null), false, this.f399737a, this.f399742f);
        }

        @Override // qb3.b
        public void onDownloadFailed(int errorCode, String errorMessage) {
            QLog.e("ZPLanSceneResource_DownloadHandler", 1, this.f399737a + " - onDownloadFailed!!! - " + this.f399738b + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", totalCallbackTime=" + (System.currentTimeMillis() - this.f399739c) + "ms");
            if (this.f399740d) {
                return;
            }
            c.f399733a.j(new ZPlanResourceItemDownloadResult(this.f399741e, null, null, true, false, Integer.valueOf(errorCode), errorMessage, null, null, null, null, null, null, 8064, null), false, this.f399737a, this.f399742f);
        }

        @Override // qb3.b
        public void onDownloadProgress(float progress, long writtenBytes, long totalBytes) {
            if (this.f399740d) {
                return;
            }
            c.f399733a.j(new ZPlanResourceItemDownloadResult(this.f399741e, null, null, false, false, null, null, Float.valueOf(progress), Long.valueOf(writtenBytes), Long.valueOf(totalBytes), null, null, null, 7264, null), true, this.f399737a, this.f399742f);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"fk3/c$d", "Lvj3/e;", "", "isSuccess", "Lwj3/a;", "result", "", "a", "", "progress", "onProgress", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class d implements vj3.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f399743a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZPlanResourceDownloadTask f399744b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f399745c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.zplan.resource.api.a f399746d;

        d(boolean z16, ZPlanResourceDownloadTask zPlanResourceDownloadTask, String str, com.tencent.zplan.resource.api.a aVar) {
            this.f399743a = z16;
            this.f399744b = zPlanResourceDownloadTask;
            this.f399745c = str;
            this.f399746d = aVar;
        }

        @Override // vj3.e
        public void a(boolean isSuccess, ZPlanResHubLoadData result) {
            String str;
            g resHubInfoDetail;
            g resHubInfoDetail2;
            Intrinsics.checkNotNullParameter(result, "result");
            if (this.f399743a) {
                return;
            }
            c cVar = c.f399733a;
            ZPlanResourceDownloadTask zPlanResourceDownloadTask = this.f399744b;
            Integer code = result.getCode();
            String message = result.getMessage();
            Float valueOf = Float.valueOf(100.0f);
            String extraDesc = result.getExtraDesc();
            String localPath = result.getLocalPath();
            ZPlanResHubIdInfo resHubIdInfo = this.f399744b.getResHubIdInfo();
            if (!TextUtils.isEmpty((resHubIdInfo == null || (resHubInfoDetail2 = resHubIdInfo.getResHubInfoDetail()) == null) ? null : resHubInfoDetail2.f406421b)) {
                String str2 = c.rootFolderPath;
                String str3 = File.separator;
                ZPlanResHubIdInfo resHubIdInfo2 = this.f399744b.getResHubIdInfo();
                str = str2 + str3 + ((resHubIdInfo2 == null || (resHubInfoDetail = resHubIdInfo2.getResHubInfoDetail()) == null) ? null : resHubInfoDetail.f406421b);
            } else {
                str = "";
            }
            cVar.j(new ZPlanResourceItemDownloadResult(zPlanResourceDownloadTask, null, null, true, isSuccess, code, message, valueOf, null, null, extraDesc, localPath, str, 768, null), false, this.f399745c, this.f399746d);
        }

        @Override // vj3.e
        public void onProgress(float progress) {
            if (this.f399743a) {
                return;
            }
            c.f399733a.j(new ZPlanResourceItemDownloadResult(this.f399744b, null, null, false, false, null, null, Float.valueOf(progress), null, null, null, null, null, MessageHandlerConstants.NOTIFY_TYPE_MOVIE_TICKET_SEND_ERROR_RSP, null), true, this.f399745c, this.f399746d);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"fk3/c$e", "Lcom/tencent/mobileqq/zootopia/download/ah;", "", "progress", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", "", "f", "c", "", "code", h.F, "e", "d", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class e extends ah {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f399747b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ZPlanResourceDownloadTask f399748c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f399749d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.zplan.resource.api.a f399750e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f399751f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f399752g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f399753h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(boolean z16, ZPlanResourceDownloadTask zPlanResourceDownloadTask, String str, com.tencent.zplan.resource.api.a aVar, String str2, long j3, String str3) {
            super(null, 1, null);
            this.f399747b = z16;
            this.f399748c = zPlanResourceDownloadTask;
            this.f399749d = str;
            this.f399750e = aVar;
            this.f399751f = str2;
            this.f399752g = j3;
            this.f399753h = str3;
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void b(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            QLog.i("ZPLanSceneResource_DownloadHandler", 1, "onStartDownload - " + this.f399751f);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void c(final x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            QLog.i("ZPLanSceneResource_DownloadHandler", 1, "onComplete!!! - " + this.f399751f + ", code=" + task.getDownloadFailCode() + ", averSpeed=" + t74.a.a(task.getCurAverageSpeed()) + ", totalCallbackTime=" + (System.currentTimeMillis() - this.f399752g) + "ms, " + task.m());
            final String str = this.f399753h;
            final boolean z16 = this.f399747b;
            final ZPlanResourceDownloadTask zPlanResourceDownloadTask = this.f399748c;
            final String str2 = this.f399749d;
            final com.tencent.zplan.resource.api.a aVar = this.f399750e;
            ThreadManagerV2.excute(new Runnable() { // from class: fk3.d
                @Override // java.lang.Runnable
                public final void run() {
                    c.e.l(x.this, str, z16, zPlanResourceDownloadTask, str2, aVar);
                }
            }, 64, null, false);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void d(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            QLog.i("ZPLanSceneResource_DownloadHandler", 1, "onWaitingDownload - " + this.f399751f);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void e(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            QLog.e("ZPLanSceneResource_DownloadHandler", 1, "onPause - " + this.f399751f);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void f(float progress, x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            if (this.f399747b) {
                return;
            }
            c.f399733a.j(new ZPlanResourceItemDownloadResult(this.f399748c, null, null, false, false, null, null, Float.valueOf(progress), Long.valueOf(task.getCurReceivedLength()), Long.valueOf(task.getCurTotalLength()), null, null, null, 7264, null), true, this.f399749d, this.f399750e);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void h(int code, x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            QLog.e("ZPLanSceneResource_DownloadHandler", 1, "onFailed!!! - " + this.f399751f + " --  code=" + code + ", FailCode=" + task.getDownloadFailCode() + ", FailInfo=" + task.getDownloadFailInfo() + ", totalCallbackTime=" + (System.currentTimeMillis() - this.f399752g) + "ms");
            if (this.f399747b) {
                return;
            }
            c.f399733a.j(new ZPlanResourceItemDownloadResult(this.f399748c, null, null, true, false, Integer.valueOf(task.getDownloadFailCode()), task.getDownloadFailInfo(), null, null, null, null, null, null, 8064, null), false, this.f399749d, this.f399750e);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(x task, String fixedUnZipPath, boolean z16, ZPlanResourceDownloadTask downloadTask, String batchResultUniqueId, com.tencent.zplan.resource.api.a resourceCallback) {
            String str;
            g resHubInfoDetail;
            Intrinsics.checkNotNullParameter(task, "$task");
            Intrinsics.checkNotNullParameter(fixedUnZipPath, "$fixedUnZipPath");
            Intrinsics.checkNotNullParameter(downloadTask, "$downloadTask");
            Intrinsics.checkNotNullParameter(batchResultUniqueId, "$batchResultUniqueId");
            Intrinsics.checkNotNullParameter(resourceCallback, "$resourceCallback");
            boolean c16 = com.tencent.rdelivery.reshub.util.zip.c.c(task.m(), fixedUnZipPath);
            QLog.e("ZPLanSceneResource_DownloadHandler", 1, "onComplete!!! - unzipRet = " + c16 + "}");
            if (z16) {
                return;
            }
            c cVar = c.f399733a;
            if (c16) {
                str = "";
            } else {
                str = "unzip error";
            }
            String str2 = str;
            Float valueOf = Float.valueOf(100.0f);
            ZPlanResHubIdInfo resHubIdInfo = downloadTask.getResHubIdInfo();
            cVar.j(new ZPlanResourceItemDownloadResult(downloadTask, null, null, true, c16, 0, str2, valueOf, null, null, (resHubIdInfo == null || (resHubInfoDetail = resHubIdInfo.getResHubInfoDetail()) == null) ? null : resHubInfoDetail.f406427h, fixedUnZipPath, task.m(), 768, null), false, batchResultUniqueId, resourceCallback);
        }
    }

    private final void e(ZPlanResourceDownloadTask downloadTask, String batchResultUniqueId, com.tencent.zplan.resource.api.a resourceCallback) {
        boolean z16 = !downloadTask.getIsStrongDepend();
        long currentTimeMillis = System.currentTimeMillis();
        s directUrlResource = downloadTask.getDirectUrlResource();
        String str = "directDownloadUrl# " + (directUrlResource != null ? directUrlResource.f406493a : null);
        s directUrlResource2 = downloadTask.getDirectUrlResource();
        QLog.i("ZPLanSceneResource_DownloadHandler", 1, "START - " + str + ", path = " + (directUrlResource2 != null ? directUrlResource2.f406494b : null));
        ZPlanResProxyDownloader zPlanResProxyDownloader = ZPlanResProxyDownloader.f328186a;
        s directUrlResource3 = downloadTask.getDirectUrlResource();
        String str2 = directUrlResource3 != null ? directUrlResource3.f406494b : null;
        if (str2 == null) {
            str2 = "";
        }
        s directUrlResource4 = downloadTask.getDirectUrlResource();
        String str3 = directUrlResource4 != null ? directUrlResource4.f406493a : null;
        if (str3 == null) {
            str3 = "";
        }
        s directUrlResource5 = downloadTask.getDirectUrlResource();
        String str4 = directUrlResource5 != null ? directUrlResource5.f406495c : null;
        zPlanResProxyDownloader.i(new ZPlanResDownloadReq(str2, str3, str4 != null ? str4 : ""), new C10324c(batchResultUniqueId, str, currentTimeMillis, z16, downloadTask, resourceCallback), true);
        if (z16) {
            QLog.i("ZPLanSceneResource_DownloadHandler", 1, batchResultUniqueId + " - directDownloadUrl callbackImmediately");
            j(new ZPlanResourceItemDownloadResult(downloadTask, null, null, true, true, 0, "", Float.valueOf(100.0f), null, null, null, null, null, 7936, null), false, batchResultUniqueId, resourceCallback);
        }
    }

    private final void i(String srcLogTag, List<ZPlanResourceDownloadTask> taskList, com.tencent.zplan.resource.api.a resourceCallback, vj3.b mobileDownloadHandler) {
        String str = srcLogTag + "_" + ds.d(1, 1000);
        ZPlanResourceBatchDownloadResult zPlanResourceBatchDownloadResult = new ZPlanResourceBatchDownloadResult(str, taskList, null, 4, null);
        ConcurrentHashMap<String, ZPlanResourceBatchDownloadResult> concurrentHashMap = batchResultMap;
        concurrentHashMap.put(str, zPlanResourceBatchDownloadResult);
        QLog.i("ZPLanSceneResource_DownloadHandler", 1, "realStartBatchDownload - " + str + ", cacheMapSize: " + concurrentHashMap.size());
        Iterator<T> it = taskList.iterator();
        while (it.hasNext()) {
            f399733a.h((ZPlanResourceDownloadTask) it.next(), str, resourceCallback, mobileDownloadHandler);
        }
    }

    private final void f(ZPlanResourceDownloadTask downloadTask, String batchResultUniqueId, com.tencent.zplan.resource.api.a resourceCallback, vj3.b mobileDownloadHandler) {
        g resHubInfoDetail;
        g resHubInfoDetail2;
        g resHubInfoDetail3;
        g resHubInfoDetail4;
        g resHubInfoDetail5;
        String env;
        String appKey;
        String appId;
        boolean z16 = !downloadTask.getIsStrongDepend();
        ZPlanResHubIdInfo resHubIdInfo = downloadTask.getResHubIdInfo();
        if (resHubIdInfo != null && resHubIdInfo.getUseDirectDownloadUrl()) {
            QLog.e("ZPLanSceneResource_DownloadHandler", 1, "downloadResHub useDirectDownloadUrl - " + downloadTask.getResHubIdInfo().getResHubInfoDetail().f406425f);
            g(z16, downloadTask, batchResultUniqueId, resourceCallback);
        } else {
            vj3.a aVar = (vj3.a) vb3.a.f441346a.a(vj3.a.class);
            ZPlanResHubIdInfo resHubIdInfo2 = downloadTask.getResHubIdInfo();
            String str = (resHubIdInfo2 == null || (appId = resHubIdInfo2.getAppId()) == null) ? "" : appId;
            ZPlanResHubIdInfo resHubIdInfo3 = downloadTask.getResHubIdInfo();
            String str2 = (resHubIdInfo3 == null || (appKey = resHubIdInfo3.getAppKey()) == null) ? "" : appKey;
            ZPlanResHubIdInfo resHubIdInfo4 = downloadTask.getResHubIdInfo();
            String str3 = (resHubIdInfo4 == null || (env = resHubIdInfo4.getEnv()) == null) ? "" : env;
            ZPlanResHubIdInfo resHubIdInfo5 = downloadTask.getResHubIdInfo();
            String str4 = null;
            String str5 = (resHubIdInfo5 == null || (resHubInfoDetail5 = resHubIdInfo5.getResHubInfoDetail()) == null) ? null : resHubInfoDetail5.f406420a;
            String str6 = str5 == null ? "" : str5;
            ZPlanResHubIdInfo resHubIdInfo6 = downloadTask.getResHubIdInfo();
            String str7 = (resHubIdInfo6 == null || (resHubInfoDetail4 = resHubIdInfo6.getResHubInfoDetail()) == null) ? null : resHubInfoDetail4.f406420a;
            if (str7 == null) {
                str7 = "";
            }
            ZPlanResHubIdInfo resHubIdInfo7 = downloadTask.getResHubIdInfo();
            String str8 = (resHubIdInfo7 == null || (resHubInfoDetail3 = resHubIdInfo7.getResHubInfoDetail()) == null) ? null : resHubInfoDetail3.f406421b;
            if (str8 == null) {
                str8 = "";
            }
            ZPlanResHubIdInfo resHubIdInfo8 = downloadTask.getResHubIdInfo();
            String str9 = (resHubIdInfo8 == null || (resHubInfoDetail2 = resHubIdInfo8.getResHubInfoDetail()) == null) ? null : resHubInfoDetail2.f406422c;
            if (str9 == null) {
                str9 = "";
            }
            ZPlanResHubIdInfo resHubIdInfo9 = downloadTask.getResHubIdInfo();
            if (resHubIdInfo9 != null && (resHubInfoDetail = resHubIdInfo9.getResHubInfoDetail()) != null) {
                str4 = resHubInfoDetail.f406423d;
            }
            aVar.t0(str, str2, str3, str6, new ZPlanResHubPathParam(str7, str8, str9, str4 != null ? str4 : ""), new d(z16, downloadTask, batchResultUniqueId, resourceCallback), true, mobileDownloadHandler);
        }
        if (z16) {
            QLog.i("ZPLanSceneResource_DownloadHandler", 1, "downloadResHub callbackImmediately");
            j(new ZPlanResourceItemDownloadResult(downloadTask, null, null, true, true, 0, "", Float.valueOf(100.0f), null, null, null, null, null, 7936, null), false, batchResultUniqueId, resourceCallback);
        }
    }
}
