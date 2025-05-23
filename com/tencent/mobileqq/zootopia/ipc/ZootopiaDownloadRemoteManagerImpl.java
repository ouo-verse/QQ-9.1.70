package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.z1.download.FileDownloadParams;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadReq;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadUrlRsp;
import com.tencent.mobileqq.z1.download.data.ZootopiaDownloadParams;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadUtil;
import com.tencent.mobileqq.zootopia.download.normal.BaseDownloadQueue;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadData;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager;
import com.tencent.mobileqq.zootopia.download.proxy.ZPlanResProxyDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import nx4.a;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ZootopiaDownloadRemoteManagerImpl implements n {
    private static final String TAG = "ZootopiaDownloadRemoteManagerImpl";

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends com.tencent.mobileqq.zootopia.download.z {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f328324a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ah f328325b;

        a(String str, ah ahVar) {
            this.f328324a = str;
            this.f328325b = ahVar;
        }

        @Override // com.tencent.mobileqq.zootopia.download.w
        public void b(String str) {
            QLog.i(ZootopiaDownloadRemoteManagerImpl.TAG, 1, this.f328324a + ", onTaskStartSuccess - " + str);
            this.f328325b.onSuccess("");
        }

        @Override // com.tencent.mobileqq.zootopia.download.w
        public void d(String str, int i3, String str2) {
            QLog.e(ZootopiaDownloadRemoteManagerImpl.TAG, 1, this.f328324a + ", onTaskStartError - " + str + ", code= " + i3 + ", errMsg= " + str2);
            this.f328325b.onFailed(i3, str2);
        }

        @Override // com.tencent.mobileqq.zootopia.download.w
        public void f(String str, int i3, String str2, com.tencent.mobileqq.zootopia.download.x xVar) {
            QLog.e(ZootopiaDownloadRemoteManagerImpl.TAG, 1, this.f328324a + ", onFailed - " + str + ", code= " + i3 + ", errMsg= " + str2);
        }

        @Override // com.tencent.mobileqq.zootopia.download.w
        public void g(String str, com.tencent.mobileqq.zootopia.download.x xVar) {
            QLog.i(ZootopiaDownloadRemoteManagerImpl.TAG, 1, this.f328324a + ", onComplete - " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$getDressDownloadInfo$6(com.tencent.mobileqq.zootopia.ipc.b bVar, FileDownloadData fileDownloadData) {
        bVar.a(fileDownloadData);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$pauseFileDownload$3(ah ahVar) {
        ahVar.onSuccess("");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$queryDownloadData$2(m mVar, ZootopiaDownloadData zootopiaDownloadData) {
        mVar.a(zootopiaDownloadData);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$queryDownloadResInfo$0(p pVar, ZootopiaResData zootopiaResData) {
        pVar.a(zootopiaResData);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$queryDownloadResInfo$1(ArrayList arrayList, o oVar, List list) {
        ArrayList<ZootopiaResData> arrayList2 = new ArrayList<>();
        for (int i3 = 0; i3 < list.size(); i3++) {
            ZootopiaResData zootopiaResData = (ZootopiaResData) list.get(i3);
            if (arrayList.contains(Integer.valueOf(zootopiaResData.getId()))) {
                arrayList2.add(zootopiaResData);
            }
        }
        oVar.a(arrayList2);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$queryFileDownloadInfo$4(com.tencent.mobileqq.zootopia.ipc.b bVar, FileDownloadData fileDownloadData) {
        bVar.a(fileDownloadData);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$queryFileDownloadInfo$5(com.tencent.mobileqq.zootopia.ipc.a aVar, ArrayList arrayList) {
        aVar.a(arrayList);
        return null;
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.n
    public void cancelMapDownload(String str) {
        ZootopiaDownloadManager.f327992a.N(str);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.n
    public void deleteOldTaskDataWhenClearCache(final List<String> list) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ipc.ZootopiaDownloadRemoteManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                FileDownloadManager.f328148a.k(list);
            }
        }, 64, null, false);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.n
    public void downloadResByPath(ZPlanResDownloadReq zPlanResDownloadReq, e eVar) {
        ZPlanResProxyDownloader.f328186a.i(zPlanResDownloadReq, new b(eVar), false);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.n
    public void getDressDownloadInfo(final com.tencent.mobileqq.zootopia.ipc.b bVar) {
        FileDownloadManager.f328148a.q(new Function1() { // from class: com.tencent.mobileqq.zootopia.ipc.ap
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$getDressDownloadInfo$6;
                lambda$getDressDownloadInfo$6 = ZootopiaDownloadRemoteManagerImpl.lambda$getDressDownloadInfo$6(b.this, (FileDownloadData) obj);
                return lambda$getDressDownloadInfo$6;
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.n
    public void handleDownloadedFileBroken(int i3, String str, String str2) {
        ZootopiaDownloadManager.f327992a.d0(i3, str, str2);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.n
    public boolean needCheckNet() {
        return ZootopiaDownloadManager.f327992a.b0();
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.n
    public void pauseFileDownload(int i3, String str, final ah ahVar) {
        ZPlanFileDownloadUtil.f328039a.p(i3, str, new Function0() { // from class: com.tencent.mobileqq.zootopia.ipc.ao
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit lambda$pauseFileDownload$3;
                lambda$pauseFileDownload$3 = ZootopiaDownloadRemoteManagerImpl.lambda$pauseFileDownload$3(ah.this);
                return lambda$pauseFileDownload$3;
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.n
    public void pauseMapDownload(String str, ah ahVar) {
        ZootopiaDownloadManager.f327992a.x0(str, true);
        ahVar.onSuccess("");
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.n
    public void queryDownloadData(int i3, final m mVar) {
        ZootopiaDownloadManager.f327992a.Y(String.valueOf(i3), new Function1() { // from class: com.tencent.mobileqq.zootopia.ipc.au
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$queryDownloadData$2;
                lambda$queryDownloadData$2 = ZootopiaDownloadRemoteManagerImpl.lambda$queryDownloadData$2(m.this, (ZootopiaDownloadData) obj);
                return lambda$queryDownloadData$2;
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.n
    public void queryDownloadResInfo(int i3, final p pVar) {
        ZootopiaDownloadManager.f327992a.c0(String.valueOf(i3), new Function1() { // from class: com.tencent.mobileqq.zootopia.ipc.as
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$queryDownloadResInfo$0;
                lambda$queryDownloadResInfo$0 = ZootopiaDownloadRemoteManagerImpl.lambda$queryDownloadResInfo$0(p.this, (ZootopiaResData) obj);
                return lambda$queryDownloadResInfo$0;
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.n
    public void queryFileDownloadInfo(int i3, String str, final com.tencent.mobileqq.zootopia.ipc.b bVar) {
        FileDownloadManager.f328148a.o(i3, str, new Function1() { // from class: com.tencent.mobileqq.zootopia.ipc.aq
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$queryFileDownloadInfo$4;
                lambda$queryFileDownloadInfo$4 = ZootopiaDownloadRemoteManagerImpl.lambda$queryFileDownloadInfo$4(b.this, (FileDownloadData) obj);
                return lambda$queryFileDownloadInfo$4;
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.n
    public void setLuaDownloadMaxLimit(String str, int i3) {
        BaseDownloadQueue.INSTANCE.b(str, i3);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.n
    public void setNeedCheckNet(boolean z16) {
        ZootopiaDownloadManager.f327992a.K0(z16);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.n
    public void startDownload(ZootopiaDownloadParams zootopiaDownloadParams, boolean z16) {
        ZootopiaDownloadManager.f327992a.L0(zootopiaDownloadParams, z16, null, true);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.n
    public void startFileDownload(int i3, String str, String str2, String str3, String str4) {
        FileDownloadManager.f328148a.y(new FileDownloadParams(i3, str, null, str2, str3, str4, "", 0, "", false));
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.n
    public void startMapDownload(String str, ah ahVar) {
        String str2 = "startMapDownload_" + str + " - " + System.currentTimeMillis();
        QLog.i(TAG, 1, str2);
        ZootopiaDownloadManager.f327992a.N0(str, false, new a(str2, ahVar), true);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.n
    public void updateDownloadDataFilePath(int i3, String str, String str2) {
        FileDownloadManager.f328148a.G(i3, str, str2);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.n
    public void queryDownloadResInfo(final ArrayList<Integer> arrayList, final o oVar) {
        ZootopiaDownloadManager.f327992a.W(new Function1() { // from class: com.tencent.mobileqq.zootopia.ipc.at
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$queryDownloadResInfo$1;
                lambda$queryDownloadResInfo$1 = ZootopiaDownloadRemoteManagerImpl.lambda$queryDownloadResInfo$1(arrayList, oVar, (List) obj);
                return lambda$queryDownloadResInfo$1;
            }
        });
    }

    public void queryFileDownloadInfo(int i3, ArrayList<String> arrayList, final com.tencent.mobileqq.zootopia.ipc.a aVar) {
        FileDownloadManager.f328148a.p(i3, arrayList, new Function1(aVar) { // from class: com.tencent.mobileqq.zootopia.ipc.ar
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$queryFileDownloadInfo$5;
                lambda$queryFileDownloadInfo$5 = ZootopiaDownloadRemoteManagerImpl.lambda$queryFileDownloadInfo$5(null, (ArrayList) obj);
                return lambda$queryFileDownloadInfo$5;
            }
        });
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements qb3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f328327a;

        b(e eVar) {
            this.f328327a = eVar;
        }

        @Override // qb3.b
        public void a(int i3, String str) {
            e eVar = this.f328327a;
            if (eVar != null) {
                eVar.a(i3, str);
            }
        }

        @Override // qb3.b
        public void b(int i3, String str, a.b bVar, ZPlanResDownloadUrlRsp zPlanResDownloadUrlRsp) {
            e eVar = this.f328327a;
            if (eVar != null) {
                eVar.b(i3, str, bVar, zPlanResDownloadUrlRsp);
            }
        }

        @Override // qb3.b
        public void onDownloadFailed(int i3, String str) {
            e eVar = this.f328327a;
            if (eVar != null) {
                eVar.onDownloadFailed(i3, str);
            }
        }

        @Override // qb3.b
        public void onDownloadProgress(float f16, long j3, long j16) {
        }
    }
}
