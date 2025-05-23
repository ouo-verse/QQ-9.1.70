package com.tencent.mobileqq.config.struct;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c implements Manager {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f202977d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements Comparator<File> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            if (file2.lastModified() > file.lastModified()) {
                return 1;
            }
            if (file2.lastModified() < file.lastModified()) {
                return -1;
            }
            return 0;
        }
    }

    public c(QQAppInterface qQAppInterface) {
        this.f202977d = qQAppInterface;
    }

    private void a() {
        try {
            File file = new File(this.f202977d.getApp().getFilesDir().getAbsolutePath() + "/NearbyBannerPic");
            if (file.exists() && file.isDirectory()) {
                List asList = Arrays.asList(file.listFiles());
                if (asList.size() > 10) {
                    Collections.sort(asList, new a());
                    for (int i3 = 10; i3 < asList.size(); i3++) {
                        b((File) asList.get(i3));
                    }
                    return;
                }
                return;
            }
            if (file.isFile()) {
                b(file);
            }
        } catch (Exception unused) {
        }
    }

    private void b(File file) {
        File[] listFiles;
        try {
            if (file.exists()) {
                if (file.isFile()) {
                    file.delete();
                    return;
                }
                if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    return;
                }
                for (File file2 : listFiles) {
                    b(file2);
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("NearbyBannerManager", 2, "", e16);
            }
        }
    }

    public int c() {
        return ((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(this.f202977d.getCurrentAccountUin(), INearbySPUtil.KEY_CONFIG_VERSION, (Object) 0)).intValue();
    }

    public Set<String> d() {
        return new HashSet(Arrays.asList(((String) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(this.f202977d.getCurrentAccountUin(), INearbySPUtil.KEY_EXPIRED_BANNER, "")).split("\\|")));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(PicAndAdConf picAndAdConf, int i3) {
        DataOutputStream dataOutputStream;
        boolean z16;
        Exception e16;
        BufferedOutputStream bufferedOutputStream;
        if (QLog.isColorLevel()) {
            QLog.d("NearbyBannerManager", 2, "onReceiveNewConfig | enter");
        }
        String str = this.f202977d.getApp().getFilesDir().getAbsolutePath() + "/" + this.f202977d.getCurrentAccountUin();
        File file = new File(str + "/nearby_banner");
        b(file);
        a();
        File file2 = new File(str);
        try {
            if (!file2.exists()) {
                file2.mkdirs();
            }
            file.createNewFile();
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d("NearbyBannerManager", 2, "", e17);
            }
        }
        if (file.exists()) {
            BufferedOutputStream bufferedOutputStream2 = null;
            boolean z17 = false;
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    dataOutputStream = new DataOutputStream(bufferedOutputStream);
                } catch (Exception e18) {
                    dataOutputStream = null;
                    e16 = e18;
                } catch (Throwable th5) {
                    th = th5;
                    dataOutputStream = null;
                }
            } catch (Exception e19) {
                dataOutputStream = null;
                e16 = e19;
                bufferedOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                dataOutputStream = null;
                z16 = false;
            }
            try {
                picAndAdConf.i(dataOutputStream);
                try {
                    bufferedOutputStream.close();
                } catch (Exception unused) {
                }
                try {
                    dataOutputStream.close();
                } catch (Exception unused2) {
                }
                picAndAdConf.y();
                f(i3);
                i.c();
            } catch (Exception e26) {
                e16 = e26;
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("NearbyBannerManager", 2, "onReceiveNewConfig exception", e16);
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    b(file);
                    f(0);
                    z17 = true;
                    if (!QLog.isColorLevel()) {
                    }
                } catch (Throwable th7) {
                    bufferedOutputStream2 = bufferedOutputStream;
                    z16 = true;
                    th = th7;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (Exception unused5) {
                        }
                    }
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception unused6) {
                        }
                    }
                    if (!z16) {
                        b(file);
                        f(0);
                        throw th;
                    }
                    picAndAdConf.y();
                    f(i3);
                    i.c();
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
                z16 = false;
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedOutputStream2 != null) {
                }
                if (dataOutputStream != null) {
                }
                if (!z16) {
                }
            }
            if (!QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onReceiveNewConfig | configFile saved = ");
                sb5.append(!z17);
                QLog.d("NearbyBannerManager", 2, sb5.toString());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NearbyBannerManager", 2, "onReceiveNewConfig | configFile create failed");
        }
    }

    public void f(int i3) {
        ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(this.f202977d.getCurrentAccountUin(), INearbySPUtil.KEY_CONFIG_VERSION, Integer.valueOf(i3));
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
