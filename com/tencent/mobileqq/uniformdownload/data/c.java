package com.tencent.mobileqq.uniformdownload.data;

import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f305884a;

    /* renamed from: b, reason: collision with root package name */
    private List<com.tencent.mobileqq.uniformdownload.util.e> f305885b;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f305884a = false;
            this.f305885b = new ArrayList();
        }
    }

    private void e() {
        MMKVOptionEntity b16 = b();
        if (!b16.decodeBool("SucDownloadInfoMgr_migrate_flag", false)) {
            QLog.d("SucDownloadInfoMgr", 1, "migrateSpToMmkv, need to migrate sp data, start!");
            Map<String, ?> all = BaseApplication.getContext().getSharedPreferences("download_suc_info", 0).getAll();
            if (all != null && all.size() > 0) {
                QLog.d("SucDownloadInfoMgr", 1, "migrateSpToMmkv, data size: " + all.size());
                b16.encodeStringSet("download_suc_info", all.keySet());
            }
            QLog.d("SucDownloadInfoMgr", 1, "migrateSpToMmkv, complete to migrate");
            b16.encodeBool("SucDownloadInfoMgr_migrate_flag", true);
            return;
        }
        QLog.d("SucDownloadInfoMgr", 1, "migrateSpToMmkv, has already migrated data");
    }

    private com.tencent.mobileqq.uniformdownload.util.e i(String str) {
        if (str == null) {
            QLog.e("SucDownloadInfoMgr", 1, "[UniformDL] sucInfoOfString err, str=null");
            return null;
        }
        String[] split = str.split("\\^");
        if (split.length < 2) {
            QLog.e("SucDownloadInfoMgr", 1, "[UniformDL] sucInfoOfString err,l=" + split.length + " str=" + str);
            return null;
        }
        return new com.tencent.mobileqq.uniformdownload.util.e(split[0], Integer.parseInt(split[1]));
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        synchronized (this.f305885b) {
            int size = this.f305885b.size();
            this.f305885b.clear();
            QLog.i("SucDownloadInfoMgr", 1, "[UniformDL] clearSucDownloadInfo...size:" + size);
        }
        try {
            b().removeKey("download_suc_info");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public MMKVOptionEntity b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MMKVOptionEntity) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQ_FILE);
    }

    public List<com.tencent.mobileqq.uniformdownload.util.e> c(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16));
        }
        if (str == null) {
            return null;
        }
        if (!this.f305884a) {
            d();
            this.f305884a = true;
        }
        ArrayList<com.tencent.mobileqq.uniformdownload.util.e> arrayList = new ArrayList();
        synchronized (this.f305885b) {
            for (com.tencent.mobileqq.uniformdownload.util.e eVar : this.f305885b) {
                if (eVar != null) {
                    if (str.equalsIgnoreCase("package:" + eVar.f306005a)) {
                        arrayList.add(eVar);
                    }
                }
            }
            if (arrayList.size() > 0 && z16) {
                QLog.i("SucDownloadInfoMgr", 1, "[UniformDL] getSucDownloadInfoOfPkg. remove before size:" + this.f305885b.size());
                try {
                    MMKVOptionEntity b16 = b();
                    Set<String> decodeStringSet = b16.decodeStringSet("download_suc_info", new HashSet());
                    for (com.tencent.mobileqq.uniformdownload.util.e eVar2 : arrayList) {
                        this.f305885b.remove(eVar2);
                        decodeStringSet.remove(h(eVar2));
                    }
                    b16.encodeStringSet("download_suc_info", decodeStringSet);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                QLog.i("SucDownloadInfoMgr", 1, "[UniformDL] getSucDownloadInfoOfPkg. remove after size:" + this.f305885b.size());
            }
        }
        return arrayList;
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            e();
            QLog.i("SucDownloadInfoMgr", 1, "[UniformDL] initSucDownloadInfo...");
            Set<String> decodeStringSet = b().decodeStringSet("download_suc_info", new HashSet());
            if (decodeStringSet != null) {
                QLog.i("SucDownloadInfoMgr", 1, "[UniformDL] initSucDownloadInfo, size:[" + decodeStringSet.size() + "]");
            }
            if (decodeStringSet != null && decodeStringSet.size() > 0) {
                Iterator<String> it = decodeStringSet.iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.uniformdownload.util.e i3 = i(it.next());
                    if (i3 != null) {
                        QLog.i("SucDownloadInfoMgr", 1, "[UniformDL] initSucDownloadInfo, pkgName:[" + i3.f306005a + "]] nId:[" + i3.f306006b + "] ");
                        synchronized (this.f305885b) {
                            this.f305885b.add(i3);
                        }
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void f(String str, int i3) {
        com.tencent.mobileqq.uniformdownload.util.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
            return;
        }
        if (str == null) {
            return;
        }
        QLog.i("SucDownloadInfoMgr", 1, "[UniformDL] removeSucDownloadInfo. pkgName:" + str + " notificationId:" + i3);
        synchronized (this.f305885b) {
            Iterator<com.tencent.mobileqq.uniformdownload.util.e> it = this.f305885b.iterator();
            while (true) {
                if (it.hasNext()) {
                    eVar = it.next();
                    if (eVar != null && str.equalsIgnoreCase(eVar.f306005a) && i3 == eVar.f306006b) {
                        break;
                    }
                } else {
                    eVar = null;
                    break;
                }
            }
            if (eVar != null) {
                this.f305885b.remove(eVar);
                QLog.i("SucDownloadInfoMgr", 1, "[UniformDL] removeSucDownloadInfo done. pkgName:" + str + " notificationId:" + i3 + " size:" + this.f305885b.size());
            }
        }
        try {
            MMKVOptionEntity b16 = b();
            Set<String> decodeStringSet = b16.decodeStringSet("download_suc_info", new HashSet());
            decodeStringSet.remove(new com.tencent.mobileqq.uniformdownload.util.e(str, i3));
            b16.encodeStringSet("download_suc_info", decodeStringSet);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void g(com.tencent.mobileqq.uniformdownload.util.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) eVar);
            return;
        }
        if (eVar == null) {
            return;
        }
        if (!this.f305884a) {
            d();
            this.f305884a = true;
        }
        synchronized (this.f305885b) {
            this.f305885b.add(eVar);
            QLog.i("SucDownloadInfoMgr", 1, "[UniformDL] saveSucDownloadInfo. pkgName:" + eVar.f306005a + " notificationId:" + eVar.f306006b + " size:" + this.f305885b.size());
        }
        try {
            MMKVOptionEntity b16 = b();
            Set<String> decodeStringSet = b16.decodeStringSet("download_suc_info", new HashSet());
            decodeStringSet.add(h(eVar));
            b16.encodeStringSet("download_suc_info", decodeStringSet);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public String h(com.tencent.mobileqq.uniformdownload.util.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) eVar);
        }
        if (eVar == null) {
            QLog.e("SucDownloadInfoMgr", 1, "[UniformDL] stringOfSucInfo err, obj=null");
            return null;
        }
        return String.valueOf(eVar.f306005a) + AECameraConstants.WIDGETINFO_SEPARATE + String.valueOf(eVar.f306006b);
    }
}
