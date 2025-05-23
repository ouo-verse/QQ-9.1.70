package com.tencent.mobileqq.ar;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
/* loaded from: classes11.dex */
public class FaceScanDownloadManager {

    /* renamed from: a, reason: collision with root package name */
    public static Handler f197445a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList<a> f197446b = new ArrayList<>(2);

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void a(int i3, boolean z16);

        void onProgress(int i3, int i16);
    }

    public static synchronized void a(a aVar) {
        synchronized (FaceScanDownloadManager.class) {
            if (aVar != null) {
                if (!f197446b.contains(aVar)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("FaceScanDownloadManager", 2, "addDownloadCallback");
                    }
                    f197446b.add(aVar);
                }
            }
        }
    }

    public static void b() {
        ArrayList<a> arrayList = f197446b;
        if (arrayList != null) {
            arrayList.clear();
        }
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanDownloadManager", 2, "clearCallback");
        }
    }

    public static void c(QQAppInterface qQAppInterface) {
        o(qQAppInterface, 0);
        n(qQAppInterface, false);
    }

    public static void d(int i3, QQAppInterface qQAppInterface) {
        com.tencent.mobileqq.earlydownload.handler.b earlyHandler;
        boolean e16;
        if (qQAppInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.d("FaceScanDownloadManager", 2, "downloadFaceRes app is null");
                return;
            }
            return;
        }
        IEarlyDownloadService iEarlyDownloadService = (IEarlyDownloadService) qQAppInterface.getRuntimeService(IEarlyDownloadService.class, "");
        if (i3 != 0) {
            e16 = false;
            if (i3 != 1) {
                earlyHandler = null;
            } else {
                earlyHandler = iEarlyDownloadService.getEarlyHandler("qq.android.ar.face.so_v8.5.2_64");
                boolean h16 = p.h();
                if (earlyHandler != null) {
                    BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit().putInt("ar_native_so_version", earlyHandler.v()).commit();
                }
                e16 = h16;
            }
        } else {
            earlyHandler = iEarlyDownloadService.getEarlyHandler("qq.android.ar.face.models_v8.2.0");
            e16 = o.e();
        }
        if (earlyHandler != null) {
            int v3 = earlyHandler.v();
            if (QLog.isColorLevel()) {
                QLog.d("FaceScanDownloadManager", 2, "initAr version=" + earlyHandler.v());
            }
            if (!e16 || !earlyHandler.A() || v3 <= 1) {
                earlyHandler.I(true);
            }
        }
    }

    public static boolean e(QQAppInterface qQAppInterface) {
        return PreferenceManager.getDefaultSharedPreferences(qQAppInterface.getApp()).getBoolean("key_download_cfg_enable" + qQAppInterface.getLongAccountUin(), false);
    }

    public static int f(QQAppInterface qQAppInterface) {
        return PreferenceManager.getDefaultSharedPreferences(qQAppInterface.getApp()).getInt("key_download_cfg_version" + qQAppInterface.getLongAccountUin(), 0);
    }

    private static boolean g(com.tencent.mobileqq.earlydownload.handler.b bVar) {
        XmlData o16;
        if (bVar == null || (o16 = bVar.o()) == null) {
            return false;
        }
        if (!TextUtils.isEmpty(o16.strPkgName) && !TextUtils.isEmpty(o16.strResURL_big)) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanDownloadManager", 2, "strPkgName is empty:" + TextUtils.isEmpty(o16.strPkgName) + " strResURL_big is empty:" + TextUtils.isEmpty(o16.strResURL_big) + " loadState :" + o16.loadState);
        }
        return false;
    }

    public static boolean h(QQAppInterface qQAppInterface) {
        IEarlyDownloadService iEarlyDownloadService;
        if (qQAppInterface == null || (iEarlyDownloadService = (IEarlyDownloadService) qQAppInterface.getRuntimeService(IEarlyDownloadService.class, "")) == null) {
            return false;
        }
        com.tencent.mobileqq.earlydownload.handler.d dVar = (com.tencent.mobileqq.earlydownload.handler.d) iEarlyDownloadService.getEarlyHandler("qq.android.ar.face.so_v8.5.2_64");
        boolean g16 = g(dVar);
        if (!g16 && dVar != null && dVar.A() && p.h()) {
            g16 = true;
        }
        if (g16 && dVar != null) {
            dVar.N();
        }
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanDownloadManager", 2, "native so config is exist :" + g16);
        }
        com.tencent.mobileqq.earlydownload.handler.c cVar = (com.tencent.mobileqq.earlydownload.handler.c) iEarlyDownloadService.getEarlyHandler("qq.android.ar.face.models_v8.2.0");
        boolean g17 = g(cVar);
        if (!g17 && cVar != null && cVar.A() && o.e()) {
            g17 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanDownloadManager", 2, "models config is exist :" + g17);
        }
        if (!g16 || !g17) {
            return false;
        }
        return true;
    }

    public static boolean i() {
        if (p.h() && o.e()) {
            return true;
        }
        return false;
    }

    public static void j(final int i3, final int i16) {
        Object[] array;
        synchronized (FaceScanDownloadManager.class) {
            array = f197446b.toArray();
        }
        if (array != null && array.length > 0) {
            for (Object obj : array) {
                final a aVar = (a) obj;
                f197445a.post(new Runnable() { // from class: com.tencent.mobileqq.ar.FaceScanDownloadManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a aVar2 = a.this;
                        if (aVar2 != null) {
                            aVar2.onProgress(i3, i16);
                        }
                    }
                });
            }
        }
    }

    public static void k(final int i3, final boolean z16) {
        Object[] array;
        synchronized (FaceScanDownloadManager.class) {
            array = f197446b.toArray();
        }
        if (array != null && array.length > 0) {
            for (Object obj : array) {
                final a aVar = (a) obj;
                f197445a.post(new Runnable() { // from class: com.tencent.mobileqq.ar.FaceScanDownloadManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a aVar2 = a.this;
                        if (aVar2 != null) {
                            aVar2.a(i3, z16);
                        }
                    }
                });
            }
        }
    }

    public static void l(QQAppInterface qQAppInterface, String str, int i3) {
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            boolean z16 = false;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2 && newPullParser.getName().equalsIgnoreCase("PreDownload") && Integer.valueOf(newPullParser.nextText()).intValue() == 1) {
                    z16 = true;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("FaceScanDownloadManager", 2, "handleResp_GetArScanFacePreDownConfig success\uff1aisPreDownload|version=" + z16 + "|" + i3);
            }
            o(qQAppInterface, i3);
            n(qQAppInterface, z16);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("FaceScanDownloadManager", 2, str, e16);
            }
        }
    }

    public static void m(QQAppInterface qQAppInterface) {
        IEarlyDownloadService iEarlyDownloadService;
        if (qQAppInterface == null || (iEarlyDownloadService = (IEarlyDownloadService) qQAppInterface.getRuntimeService(IEarlyDownloadService.class, "")) == null) {
            return;
        }
        com.tencent.mobileqq.earlydownload.handler.d dVar = (com.tencent.mobileqq.earlydownload.handler.d) iEarlyDownloadService.getEarlyHandler("qq.android.ar.face.so_v8.5.2_64");
        if (dVar != null && dVar.A() && !p.h()) {
            dVar.M();
            if (QLog.isColorLevel()) {
                QLog.d("FaceScanDownloadManager", 2, "reset native so download state");
            }
        }
        com.tencent.mobileqq.earlydownload.handler.c cVar = (com.tencent.mobileqq.earlydownload.handler.c) iEarlyDownloadService.getEarlyHandler("qq.android.ar.face.models_v8.2.0");
        if (cVar != null && cVar.A() && !o.e()) {
            cVar.M();
            if (QLog.isColorLevel()) {
                QLog.d("FaceScanDownloadManager", 2, "reset modules so download state");
            }
        }
    }

    public static void n(QQAppInterface qQAppInterface, boolean z16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(qQAppInterface.getApp()).edit();
        edit.putBoolean("key_download_cfg_enable" + qQAppInterface.getLongAccountUin(), z16);
        edit.commit();
    }

    public static void o(QQAppInterface qQAppInterface, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(qQAppInterface.getApp()).edit();
        edit.putInt("key_download_cfg_version" + qQAppInterface.getLongAccountUin(), i3);
        edit.commit();
    }
}
