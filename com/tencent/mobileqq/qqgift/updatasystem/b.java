package com.tencent.mobileqq.qqgift.updatasystem;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftResDownloadReportHelper;
import com.tencent.mobileqq.qqgift.updatasystem.data.QQGiftResConfigInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vasgift.utils.m;
import com.tencent.mobileqq.vasgift.utils.n;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.listener.IUpdateListener;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import qh2.f;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f265013b;

    /* renamed from: c, reason: collision with root package name */
    private static final n f265014c;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Long> f265015a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements IDownLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f265016a;

        a(f fVar) {
            this.f265016a = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) fVar);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                b.this.m(updateListenerParams, this.f265016a);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                b.this.n(updateListenerParams, this.f265016a);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqgift.updatasystem.b$b, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C8340b implements IDownLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f265018a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ qh2.b f265019b;

        C8340b(boolean z16, qh2.b bVar) {
            this.f265018a = z16;
            this.f265019b = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, Boolean.valueOf(z16), bVar);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                b.this.m(updateListenerParams, this.f265019b);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                b.this.l(this.f265018a, updateListenerParams, this.f265019b);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c extends com.tencent.mobileqq.vip.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UpdateListenerParams f265021a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ qh2.b f265022b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f265023c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f265024d;

        c(UpdateListenerParams updateListenerParams, qh2.b bVar, String str, String str2) {
            this.f265021a = updateListenerParams;
            this.f265022b = bVar;
            this.f265023c = str;
            this.f265024d = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, updateListenerParams, bVar, str, str2);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
                return;
            }
            super.onDone(gVar);
            if (gVar.i() != 3) {
                QLog.d("QQGiftResUpdateManager", 1, "downloadCombZip Failed zip not Exist!");
                b.this.m(this.f265021a, this.f265022b);
                return;
            }
            try {
                FileUtils.uncompressZip(this.f265023c, this.f265024d, false);
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.d("QQGiftResUpdateManager", 1, "downloadCombZip uncompressZip failed" + e16);
            }
            b.this.n(this.f265021a, this.f265022b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d implements IUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ qh2.c f265026a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f265027b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f265028c;

        d(qh2.c cVar, int i3, String str) {
            this.f265026a = cVar;
            this.f265027b = i3;
            this.f265028c = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, cVar, Integer.valueOf(i3), str);
            }
        }

        @Override // com.tencent.vas.update.callback.listener.IUpdateListener
        public void onLoadFail(UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
            } else {
                this.f265026a.onLoadFail(0, 0, 0, "");
            }
        }

        @Override // com.tencent.vas.update.callback.listener.IUpdateListener
        public void onLoadSuccess(UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
            } else {
                this.f265026a.onLoadSuccess(this.f265027b, this.f265028c);
                VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.GET_RES_DOWNLOAD, "success");
            }
        }

        @Override // com.tencent.vas.update.callback.listener.IUpdateListener
        public void onProgress(UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) updateListenerParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class e implements FilenameFilter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f265030d;

        e(long j3) {
            this.f265030d = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, Long.valueOf(j3));
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) str)).booleanValue();
            }
            if (this.f265030d == com.tencent.mobileqq.qqgift.updatasystem.c.INSTANCE.b()) {
                return str.toLowerCase().startsWith("pagfile.");
            }
            return str.toLowerCase().startsWith("animation.");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30019);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f265014c = new n();
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f265015a = new HashMap();
        }
    }

    private boolean e(QQGiftPanelResource qQGiftPanelResource) {
        if (qQGiftPanelResource == null || TextUtils.isEmpty(qQGiftPanelResource.f265002b)) {
            return false;
        }
        return new File(qQGiftPanelResource.f265002b).exists();
    }

    private void f(String str, String str2, String str3, qh2.b bVar) {
        String str4 = str3 + ".zip";
        UpdateListenerParams updateListenerParams = new UpdateListenerParams();
        updateListenerParams.mBusinessUpdateParams = new BusinessUpdateParams(com.tencent.mobileqq.qqgift.updatasystem.c.INSTANCE.b(), str2, "others");
        try {
            h downloader = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(4);
            if (downloader == null) {
                return;
            }
            downloader.startDownload(new g(str, new File(str4)), new c(updateListenerParams, bVar, str4, str3), null);
        } catch (Exception e16) {
            m(updateListenerParams, bVar);
            QLog.d("QQGiftResUpdateManager", 1, "downloadCombZip failed" + e16);
        }
    }

    private boolean h(long j3, String str, int i3, String str2, boolean z16, qh2.b bVar) {
        QQGiftResDownloadReportHelper.a aVar = new QQGiftResDownloadReportHelper.a(str);
        aVar.f265008c = 1;
        QQGiftResDownloadReportHelper.a(aVar);
        if (QLog.isColorLevel()) {
            QLog.i("QQGiftResUpdateManager", 1, "[downloadAnimationRes] " + i3 + " local exist");
        }
        if (bVar == null) {
            QLog.d("QQGiftResUpdateManager", 1, "onPanelResLoadCallbackSuccess callback is null");
            return true;
        }
        if (z16) {
            bVar.onLoadSuccess(i3, str2);
            VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.GET_RES_LOCAL, "success");
        } else {
            String[] list = new File(str2).list(new e(j3));
            if (list != null && list.length > 0) {
                bVar.onLoadSuccess(i3, str2 + File.separator + list[0]);
                VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.GET_RES_LOCAL, "success");
            } else {
                bVar.onLoadFail(i3, -1, -1, "dir is exist but is empty");
                FileUtils.deleteDirectory(str2);
                QLog.e("QQGiftResUpdateManager", 1, "[downloadAnimationRes] file is exist but is empty, bid: " + j3 + " ,dir:" + str2);
            }
        }
        return false;
    }

    public static b k() {
        if (f265013b == null) {
            synchronized (b.class) {
                if (f265013b == null) {
                    f265013b = new b();
                }
            }
        }
        return f265013b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z16, UpdateListenerParams updateListenerParams, qh2.b bVar) {
        BusinessUpdateParams businessUpdateParams = updateListenerParams.mBusinessUpdateParams;
        if (businessUpdateParams == null) {
            QLog.e("QQGiftResUpdateManager", 1, "onLoadSuccess downloadCallback is null or mBusinessUpdateParams is null!");
            return;
        }
        final long j3 = businessUpdateParams.mBid;
        t(updateListenerParams);
        QQGiftResourceBusiness qQGiftResourceBusiness = (QQGiftResourceBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(Long.valueOf(j3));
        String str = updateListenerParams.mBusinessUpdateParams.mScid;
        int e16 = qQGiftResourceBusiness.e(str, 2);
        String savePath = qQGiftResourceBusiness.getSavePath(str);
        if (!z16) {
            String[] list = new File(savePath).list(new FilenameFilter() { // from class: com.tencent.mobileqq.qqgift.updatasystem.a
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str2) {
                    boolean p16;
                    p16 = b.p(j3, file, str2);
                    return p16;
                }
            });
            if (list != null && list.length > 0) {
                bVar.onLoadSuccess(e16, savePath + File.separator + list[0]);
                VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.GET_RES_DOWNLOAD, "success");
                return;
            }
            bVar.onLoadFail(e16, -1, -1, "dir is exist but is empty");
            FileUtils.deleteDirectory(savePath);
            QLog.e("QQGiftResUpdateManager", 1, "[downloadAnimationRes-onLoadSuccess] file is exist but is empty, dir:" + savePath);
            return;
        }
        bVar.onLoadSuccess(e16, savePath);
        VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.GET_RES_DOWNLOAD, "success");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(UpdateListenerParams updateListenerParams, qh2.g gVar) {
        if (updateListenerParams.mBusinessUpdateParams == null) {
            QLog.e("QQGiftResUpdateManager", 1, "onLoadFail downloadCallback is null or mBusinessUpdateParams is null!");
            return;
        }
        QQGiftResourceBusiness qQGiftResourceBusiness = (QQGiftResourceBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(Long.valueOf(updateListenerParams.mBusinessUpdateParams.mBid));
        t(updateListenerParams);
        String str = updateListenerParams.mBusinessUpdateParams.mScid;
        com.tencent.mobileqq.vasgift.utils.g.a(str);
        int e16 = qQGiftResourceBusiness.e(str, 1);
        gVar.onLoadFail(e16, updateListenerParams.mErrorCode, updateListenerParams.mHttpCode, updateListenerParams.mErrorMessage);
        if (QLog.isColorLevel()) {
            QLog.d("QQGiftResUpdateManager", 2, "[downloadSinglePanelRes] onLoadFail id:" + e16 + ", errorMessage:" + updateListenerParams.mErrorMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(UpdateListenerParams updateListenerParams, qh2.g gVar) {
        if (updateListenerParams.mBusinessUpdateParams == null) {
            QLog.e("QQGiftResUpdateManager", 1, "onLoadSuccess downloadCallback is null or mBusinessUpdateParams is null!");
            return;
        }
        t(updateListenerParams);
        QQGiftResourceBusiness qQGiftResourceBusiness = (QQGiftResourceBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(Long.valueOf(updateListenerParams.mBusinessUpdateParams.mBid));
        String str = updateListenerParams.mBusinessUpdateParams.mScid;
        int e16 = qQGiftResourceBusiness.e(str, 2);
        String savePath = qQGiftResourceBusiness.getSavePath(str);
        VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.GET_RES_DOWNLOAD, "success");
        if (gVar instanceof f) {
            s(e16, savePath, (f) gVar);
        } else if (gVar instanceof qh2.b) {
            ((qh2.b) gVar).onLoadSuccess(e16, savePath);
        }
    }

    private boolean o(String str) {
        return "png".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean p(long j3, File file, String str) {
        if (j3 == com.tencent.mobileqq.qqgift.updatasystem.c.INSTANCE.b()) {
            return str.toLowerCase().startsWith("pagfile.");
        }
        return str.toLowerCase().startsWith("animation.");
    }

    private String q(File file) {
        byte[] fileToBytes = FileUtils.fileToBytes(file);
        if (fileToBytes == null || fileToBytes.length <= 0) {
            return null;
        }
        try {
            return new String(fileToBytes, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            QLog.e("QQGiftResUpdateManager", 1, "loadFileContent error, ", e16);
            return null;
        }
    }

    @Nullable
    private QQGiftPanelResource r(String str) {
        String str2;
        String q16;
        QQGiftPanelResource qQGiftPanelResource = new QQGiftPanelResource();
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            str2 = File.separator;
            sb5.append(str2);
            sb5.append("config.json");
            String sb6 = sb5.toString();
            if (QLog.isColorLevel()) {
                QLog.d("QQGiftResUpdateManager", 4, "[mapResourceData] jsonFile:" + sb6);
            }
            q16 = q(new File(sb6));
            if (QLog.isColorLevel()) {
                QLog.d("QQGiftResUpdateManager", 4, "[mapResourceData] json:" + q16);
            }
            qQGiftPanelResource.f265003c = str + str2 + "gifticon.pag";
        } catch (Exception e16) {
            QLog.e("QQGiftResUpdateManager", 1, "mapResourceData throw exception:" + e16.getMessage());
        }
        if (TextUtils.isEmpty(q16)) {
            qQGiftPanelResource.f265002b = str + str2 + "staticPreviewImage.png";
            qQGiftPanelResource.f265005e = str + str2 + "dynamicPreviewImage.png";
            QLog.e("QQGiftResUpdateManager", 1, "[mapResourceData] resDir:" + str + ", json:" + q16);
            return qQGiftPanelResource;
        }
        QQGiftResConfigInfo qQGiftResConfigInfo = (QQGiftResConfigInfo) new Gson().fromJson(q16, QQGiftResConfigInfo.class);
        if (QLog.isColorLevel()) {
            QLog.d("QQGiftResUpdateManager", 4, "[mapResourceData] configInfo:" + qQGiftResConfigInfo);
        }
        if (qQGiftResConfigInfo == null) {
            QLog.e("QQGiftResUpdateManager", 1, "[mapResourceData] configInfo is null! resDir:" + str);
        } else {
            if (o(qQGiftResConfigInfo.thumb.type)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQGiftResUpdateManager", 4, "[mapResourceData] ValidType thumb.type");
                }
                qQGiftPanelResource.f265002b = str + str2 + qQGiftResConfigInfo.thumb.name;
            } else if (!TextUtils.isEmpty(qQGiftResConfigInfo.thumb.defaultName)) {
                qQGiftPanelResource.f265002b = str + str2 + qQGiftResConfigInfo.thumb.defaultName;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQGiftResUpdateManager", 4, "[mapResourceData] resource.thumbPath:" + qQGiftPanelResource.f265002b);
            }
            if (o(qQGiftResConfigInfo.f265036bg.type)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQGiftResUpdateManager", 4, "[mapResourceData] ValidType bg.type");
                }
                qQGiftPanelResource.f265005e = str + str2 + qQGiftResConfigInfo.f265036bg.name;
            } else if (!TextUtils.isEmpty(qQGiftResConfigInfo.f265036bg.defaultName)) {
                qQGiftPanelResource.f265005e = str + str2 + qQGiftResConfigInfo.f265036bg.defaultName;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQGiftResUpdateManager", 4, "[mapResourceData] resource.bgPath:" + qQGiftPanelResource.f265005e);
            }
        }
        return qQGiftPanelResource;
    }

    private void s(int i3, String str, f fVar) {
        if (fVar == null) {
            QLog.d("QQGiftResUpdateManager", 1, "onPanelResLoadCallbackSuccess callback is null");
            return;
        }
        QQGiftPanelResource r16 = r(str);
        if (e(r16)) {
            fVar.c(i3, r16);
            return;
        }
        fVar.onLoadFail(i3, -1, -1, "dir is exist path is invalid");
        FileUtils.deleteDirectory(str);
        QLog.e("QQGiftResUpdateManager", 1, "[downloadAnimationRes] dir is exist path is invalid, panelResource:" + r16);
    }

    private void t(@NonNull UpdateListenerParams updateListenerParams) {
        Long remove;
        String str = updateListenerParams.mBusinessUpdateParams.mScid;
        QQGiftResDownloadReportHelper.a aVar = new QQGiftResDownloadReportHelper.a(str, updateListenerParams.mErrorCode, updateListenerParams.mErrorMessage);
        if (this.f265015a.containsKey(str) && (remove = this.f265015a.remove(str)) != null) {
            aVar.f265007b = (System.nanoTime() - remove.longValue()) / 1000000;
        }
        QQGiftResDownloadReportHelper.a(aVar);
    }

    public void g(int i3, Long l3, boolean z16, String str, qh2.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), l3, Boolean.valueOf(z16), str, bVar);
            return;
        }
        QQGiftResourceBusiness qQGiftResourceBusiness = (QQGiftResourceBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(l3);
        String f16 = qQGiftResourceBusiness.f(i3, 2);
        String savePath = qQGiftResourceBusiness.getSavePath(f16);
        if (!qQGiftResourceBusiness.isFileExist(f16)) {
            QLog.i("QQGiftResUpdateManager", 1, "[downloadAnimationRes] " + i3 + " needDownload");
            VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.GET_RES_DOWNLOAD, VasPerfReportUtils.BEGAN);
            if (!f265014c.getIsEnable() && i3 == 25 && !TextUtils.isEmpty(m.c())) {
                f(m.c(), f16, savePath, bVar);
                return;
            }
            qQGiftResourceBusiness.addDownLoadListener(f16, new C8340b(z16, bVar));
            if (!this.f265015a.containsKey(f16)) {
                this.f265015a.put(f16, Long.valueOf(System.nanoTime()));
            }
            qQGiftResourceBusiness.g(str);
            qQGiftResourceBusiness.startDownload(f16);
            return;
        }
        VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.GET_RES_LOCAL, VasPerfReportUtils.BEGAN);
        h(l3.longValue(), f16, i3, savePath, z16, bVar);
    }

    public void i(int i3, String str, qh2.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, cVar);
            return;
        }
        com.tencent.mobileqq.qqgift.updatasystem.c cVar2 = (com.tencent.mobileqq.qqgift.updatasystem.c) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(com.tencent.mobileqq.qqgift.updatasystem.c.class);
        String f16 = cVar2.f(i3, 3);
        String savePath = cVar2.getSavePath(f16);
        if (com.tencent.mobileqq.vasgift.utils.g.c(f16, savePath)) {
            if (cVar != null) {
                cVar2.i(f16, new d(cVar, i3, savePath));
            }
            VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.GET_RES_DOWNLOAD, VasPerfReportUtils.BEGAN);
            cVar2.g(str);
            cVar2.startDownload(f16);
            return;
        }
        VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.GET_RES_LOCAL, VasPerfReportUtils.BEGAN);
        if (cVar != null) {
            cVar.onLoadSuccess(i3, savePath);
        }
        VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.GET_RES_LOCAL, "success");
    }

    public void j(int i3, String str, @NonNull f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, fVar);
            return;
        }
        QQGiftResourceBusiness qQGiftResourceBusiness = (QQGiftResourceBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(Long.valueOf(com.tencent.mobileqq.qqgift.updatasystem.c.INSTANCE.b()));
        String f16 = qQGiftResourceBusiness.f(i3, 1);
        String savePath = qQGiftResourceBusiness.getSavePath(f16);
        if (qQGiftResourceBusiness.isFileExist(f16)) {
            s(i3, savePath, fVar);
            QQGiftResDownloadReportHelper.a aVar = new QQGiftResDownloadReportHelper.a(f16);
            aVar.f265008c = 1;
            QQGiftResDownloadReportHelper.a(aVar);
            return;
        }
        qQGiftResourceBusiness.addDownLoadListener(f16, new a(fVar));
        if (!this.f265015a.containsKey(f16)) {
            this.f265015a.put(f16, Long.valueOf(System.nanoTime()));
        }
        qQGiftResourceBusiness.g(str);
        qQGiftResourceBusiness.startDownload(f16);
    }
}
