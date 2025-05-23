package com.tencent.open.appcommon.now.download;

import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.intervideo.now.api.INowUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static a f340705d;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<com.tencent.open.appcommon.now.download.b> f340706a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private INetEventHandler f340707b = new C9272a();

    /* renamed from: c, reason: collision with root package name */
    private DownloadListener f340708c = new b();

    /* compiled from: P */
    /* renamed from: com.tencent.open.appcommon.now.download.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    class C9272a implements INetEventHandler {
        C9272a() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
        public void onNetChangeEvent(boolean z16) {
            int netWorkType = HttpUtil.getNetWorkType();
            Iterator it = a.this.f340706a.iterator();
            while (it.hasNext()) {
                ((com.tencent.open.appcommon.now.download.b) it.next()).a(netWorkType);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b implements DownloadListener {
        b() {
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void installSucceed(String str, String str2) {
            Iterator it = a.this.f340706a.iterator();
            while (it.hasNext()) {
                ((com.tencent.open.appcommon.now.download.b) it.next()).installSucceed(str, str2);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadCancel(DownloadInfo downloadInfo) {
            Iterator it = a.this.f340706a.iterator();
            while (it.hasNext()) {
                ((com.tencent.open.appcommon.now.download.b) it.next()).onDownloadCancel(downloadInfo);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadError(DownloadInfo downloadInfo, int i3, String str, int i16) {
            Iterator it = a.this.f340706a.iterator();
            while (it.hasNext()) {
                ((com.tencent.open.appcommon.now.download.b) it.next()).onDownloadError(downloadInfo, i3, str, i16);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadFinish(DownloadInfo downloadInfo) {
            if (((INowUtil) QRoute.api(INowUtil.class)).copyNowApkToCommonDir(downloadInfo.L, downloadInfo.f341184e, downloadInfo.f341189h)) {
                if (!((INowUtil) QRoute.api(INowUtil.class)).getCommonNowPath().equals(downloadInfo.L)) {
                    ((INowUtil) QRoute.api(INowUtil.class)).delete(downloadInfo.L);
                    downloadInfo.L = ((INowUtil) QRoute.api(INowUtil.class)).getCommonNowPath();
                }
                DownloadManager.C().e(downloadInfo);
            }
            Iterator it = a.this.f340706a.iterator();
            while (it.hasNext()) {
                ((com.tencent.open.appcommon.now.download.b) it.next()).onDownloadFinish(downloadInfo);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadPause(DownloadInfo downloadInfo) {
            Iterator it = a.this.f340706a.iterator();
            while (it.hasNext()) {
                ((com.tencent.open.appcommon.now.download.b) it.next()).onDownloadPause(downloadInfo);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadUpdate(List<DownloadInfo> list) {
            Iterator it = a.this.f340706a.iterator();
            while (it.hasNext()) {
                ((com.tencent.open.appcommon.now.download.b) it.next()).onDownloadUpdate(list);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadWait(DownloadInfo downloadInfo) {
            Iterator it = a.this.f340706a.iterator();
            while (it.hasNext()) {
                ((com.tencent.open.appcommon.now.download.b) it.next()).onDownloadWait(downloadInfo);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void packageReplaced(String str, String str2) {
            Iterator it = a.this.f340706a.iterator();
            while (it.hasNext()) {
                ((com.tencent.open.appcommon.now.download.b) it.next()).packageReplaced(str, str2);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void uninstallSucceed(String str, String str2) {
            Iterator it = a.this.f340706a.iterator();
            while (it.hasNext()) {
                ((com.tencent.open.appcommon.now.download.b) it.next()).uninstallSucceed(str, str2);
            }
        }
    }

    public a() {
        DownloadManager.C().Y(this.f340708c);
        AppNetConnInfo.registerNetChangeReceiver(com.tencent.open.adapter.a.f().e(), this.f340707b);
    }

    public static a e() {
        if (f340705d == null) {
            f340705d = new a();
        }
        return f340705d;
    }

    public void b(com.tencent.open.appcommon.now.download.b bVar) {
        ArrayList<com.tencent.open.appcommon.now.download.b> arrayList;
        if (bVar != null && (arrayList = this.f340706a) != null && !arrayList.contains(bVar)) {
            this.f340706a.add(bVar);
        }
    }

    public void c(String str) {
        DownloadInfo w3 = DownloadManager.C().w(str);
        DownloadManager.C().m(str, true);
        DownloadManager.C().K(10, w3);
    }

    public DownloadInfo d(String str) {
        return DownloadManager.C().w(str);
    }

    public void f(String str, String str2) {
        DownloadInfo w3 = DownloadManager.C().w(str);
        if (w3 == null) {
            w3 = DownloadManager.C().x(str2);
        }
        if (w3 != null) {
            w3.S = 5;
            w3.J = 0;
            w3.K = 0;
            DownloadManager.C().I(w3);
        }
    }

    public void g(String str) {
        DownloadManager.C().Q(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x01fc, code lost:
    
        if (((com.tencent.mobileqq.intervideo.now.api.INowUtil) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.mobileqq.intervideo.now.api.INowUtil.class)).isExists(r10) != false) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0210 A[LOOP:1: B:28:0x020a->B:30:0x0210, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int h(DownloadInfo downloadInfo) {
        String str;
        Iterator<com.tencent.open.appcommon.now.download.b> it;
        int h16;
        int i3 = 1;
        int i16 = 0;
        if (com.tencent.open.business.base.a.a(downloadInfo.f341189h)) {
            int i17 = downloadInfo.I;
            if (i17 != 0 && i17 > com.tencent.open.business.base.a.g(INowUtil.Now_PKG_NAME)) {
                i3 = 0;
            }
            downloadInfo.k(13);
            Iterator<com.tencent.open.appcommon.now.download.b> it5 = this.f340706a.iterator();
            while (it5.hasNext()) {
                it5.next().b(downloadInfo, i3);
            }
            return i3;
        }
        DownloadInfo w3 = DownloadManager.C().w(downloadInfo.f341184e);
        if (INowUtil.Now_PKG_NAME.equals(downloadInfo.f341189h)) {
            boolean checkNowApkExist = ((INowUtil) QRoute.api(INowUtil.class)).checkNowApkExist(downloadInfo.f341184e, downloadInfo.f341189h);
            if (w3 == null) {
                if (checkNowApkExist) {
                    int h17 = com.tencent.open.business.base.a.h(((INowUtil) QRoute.api(INowUtil.class)).getCommonNowPath());
                    int i18 = downloadInfo.I;
                    if (i18 != 0 && i18 > h17) {
                        ((INowUtil) QRoute.api(INowUtil.class)).delete(((INowUtil) QRoute.api(INowUtil.class)).getCommonNowPath());
                        i3 = 0;
                        i16 = i3;
                    } else {
                        DownloadInfo downloadInfo2 = new DownloadInfo(downloadInfo.f341184e, downloadInfo.f341186f, downloadInfo.f341189h, downloadInfo.f341191i, downloadInfo.C, null, downloadInfo.M, downloadInfo.X);
                        downloadInfo2.k(4);
                        downloadInfo2.L = ((INowUtil) QRoute.api(INowUtil.class)).getCommonNowPath();
                        downloadInfo2.U = downloadInfo.U;
                        DownloadManager.C().e(downloadInfo2);
                        i16 = i3;
                    }
                }
                downloadInfo.k(13);
                it = this.f340706a.iterator();
                while (it.hasNext()) {
                    it.next().b(downloadInfo, i16);
                }
                return i16;
            }
            String str2 = w3.L;
            if (!((INowUtil) QRoute.api(INowUtil.class)).isExists(str2) && !checkNowApkExist) {
                if (w3.f() == 4) {
                    DownloadManager.C().m(w3.f341184e, true);
                }
                downloadInfo.k(13);
                it = this.f340706a.iterator();
                while (it.hasNext()) {
                }
                return i16;
            }
            if (checkNowApkExist) {
                h16 = com.tencent.open.business.base.a.h(((INowUtil) QRoute.api(INowUtil.class)).getCommonNowPath());
            } else {
                h16 = com.tencent.open.business.base.a.h(str2);
            }
            int i19 = downloadInfo.I;
            if (i19 != 0 && i19 > h16) {
                DownloadManager.C().m(w3.f341184e, true);
                ((INowUtil) QRoute.api(INowUtil.class)).delete(((INowUtil) QRoute.api(INowUtil.class)).getCommonNowPath());
                ((INowUtil) QRoute.api(INowUtil.class)).delete(str2);
                i3 = 0;
                i16 = i3;
                downloadInfo.k(13);
                it = this.f340706a.iterator();
                while (it.hasNext()) {
                }
                return i16;
            }
            if (!checkNowApkExist) {
                if (((INowUtil) QRoute.api(INowUtil.class)).copyNowApkToCommonDir(str2, downloadInfo.f341184e, downloadInfo.f341189h)) {
                    ((INowUtil) QRoute.api(INowUtil.class)).delete(str2);
                    w3.L = ((INowUtil) QRoute.api(INowUtil.class)).getCommonNowPath();
                }
            } else if (!((INowUtil) QRoute.api(INowUtil.class)).getCommonNowPath().equals(str2)) {
                ((INowUtil) QRoute.api(INowUtil.class)).delete(str2);
                w3.L = ((INowUtil) QRoute.api(INowUtil.class)).getCommonNowPath();
            }
            w3.k(4);
            DownloadManager.C().e(w3);
            i16 = i3;
            downloadInfo.k(13);
            it = this.f340706a.iterator();
            while (it.hasNext()) {
            }
            return i16;
        }
        if (w3 != null) {
            if (TextUtils.isEmpty(w3.L)) {
                TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = null;
                str = "";
                if (w3.J == 0) {
                    TMAssistantDownloadTaskInfo F = DownloadManager.C().F(w3.f341186f);
                    if (F != null && F.mState == 4) {
                        str = F.mSavePath;
                    }
                    if (TextUtils.isEmpty(str)) {
                        tMAssistantDownloadTaskInfo = DownloadManager.C().E(w3);
                    }
                } else {
                    TMAssistantDownloadTaskInfo E = DownloadManager.C().E(w3);
                    if (E != null && E.mState == 4) {
                        str = E.mSavePath;
                    }
                    if (TextUtils.isEmpty(str)) {
                        tMAssistantDownloadTaskInfo = DownloadManager.C().F(w3.f341186f);
                    }
                }
                if (tMAssistantDownloadTaskInfo != null && tMAssistantDownloadTaskInfo.mState == 4) {
                    str = tMAssistantDownloadTaskInfo.mSavePath;
                }
                if (!TextUtils.isEmpty(str)) {
                    w3.L = str;
                    w3.k(4);
                    DownloadManager.C().e(w3);
                }
            } else {
                str = w3.L;
            }
            if (!StringUtil.isEmpty(str)) {
            }
            i3 = 0;
            i16 = i3;
        }
        downloadInfo.k(13);
        it = this.f340706a.iterator();
        while (it.hasNext()) {
        }
        return i16;
    }

    public void i(com.tencent.open.appcommon.now.download.b bVar) {
        ArrayList<com.tencent.open.appcommon.now.download.b> arrayList = this.f340706a;
        if (arrayList != null) {
            arrayList.remove(bVar);
        }
    }

    public void j(DownloadInfo downloadInfo) {
        if (((INowUtil) QRoute.api(INowUtil.class)).checkNowApkExist(downloadInfo.f341184e, downloadInfo.f341189h)) {
            downloadInfo.k(4);
            downloadInfo.L = ((INowUtil) QRoute.api(INowUtil.class)).getCommonNowPath();
            DownloadManager.C().e(downloadInfo);
            this.f340708c.onDownloadFinish(downloadInfo);
            return;
        }
        DownloadManager.C().d0(downloadInfo);
    }

    public void k(DownloadInfo downloadInfo, ApkUpdateDetail apkUpdateDetail) {
        DownloadManager.C().f0(downloadInfo, apkUpdateDetail);
    }
}
