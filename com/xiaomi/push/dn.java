package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopMemberSpecialTitleInfo;
import com.xiaomi.push.ae;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class dn extends ae.a {

    /* renamed from: d, reason: collision with root package name */
    private Context f388614d;

    /* renamed from: e, reason: collision with root package name */
    private SharedPreferences f388615e;

    /* renamed from: f, reason: collision with root package name */
    private com.xiaomi.push.service.ah f388616f;

    public dn(Context context) {
        this.f388614d = context;
        this.f388615e = context.getSharedPreferences("mipush_extra", 0);
        this.f388616f = com.xiaomi.push.service.ah.d(context);
    }

    private void a() {
        SharedPreferences.Editor edit = this.f388615e.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    private boolean b() {
        if (!this.f388616f.m(gk.Upload3GSwitch.a(), true)) {
            return false;
        }
        if (Math.abs((System.currentTimeMillis() / 1000) - this.f388615e.getLong("last_upload_data_timestamp", -1L)) > Math.max(86400, this.f388616f.a(gk.Upload3GFrequency.a(), 432000))) {
            return true;
        }
        return false;
    }

    private boolean c() {
        if (!this.f388616f.m(gk.Upload4GSwitch.a(), true)) {
            return false;
        }
        if (Math.abs((System.currentTimeMillis() / 1000) - this.f388615e.getLong("last_upload_data_timestamp", -1L)) > Math.max(86400, this.f388616f.a(gk.Upload4GFrequency.a(), TroopMemberSpecialTitleInfo.SPECIAL_TITLE_EXPIRE_SOON_TIME))) {
            return true;
        }
        return false;
    }

    private List<gn> f(File file) {
        String a16;
        RandomAccessFile randomAccessFile;
        FileInputStream fileInputStream;
        ci a17 = cj.b().a();
        if (a17 == null) {
            a16 = "";
        } else {
            a16 = a17.a();
        }
        FileLock fileLock = null;
        if (TextUtils.isEmpty(a16)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (cm.f388415a) {
            try {
                File file2 = new File(this.f388614d.getFilesDir(), "push_cdata.lock");
                in.f(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    FileLock lock = randomAccessFile.getChannel().lock();
                    try {
                        fileInputStream = new FileInputStream(file);
                        while (fileInputStream.read(bArr) == 4) {
                            try {
                                int a18 = ip.a(bArr);
                                byte[] bArr2 = new byte[a18];
                                if (fileInputStream.read(bArr2) != a18) {
                                    break;
                                }
                                byte[] c16 = cl.c(a16, bArr2);
                                if (c16 != null && c16.length != 0) {
                                    gn gnVar = new gn();
                                    fv.d(gnVar, c16);
                                    arrayList.add(gnVar);
                                    g(gnVar);
                                }
                            } catch (Exception unused) {
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused2) {
                                    }
                                }
                                in.b(fileInputStream);
                                in.b(randomAccessFile);
                                return arrayList;
                            } catch (Throwable th5) {
                                th = th5;
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused3) {
                                    }
                                }
                                in.b(fileInputStream);
                                in.b(randomAccessFile);
                                throw th;
                            }
                        }
                        if (lock != null && lock.isValid()) {
                            try {
                                lock.release();
                            } catch (IOException unused4) {
                            }
                        }
                        in.b(fileInputStream);
                    } catch (Exception unused5) {
                        fileInputStream = null;
                    } catch (Throwable th6) {
                        th = th6;
                        fileInputStream = null;
                    }
                } catch (Exception unused6) {
                    fileInputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    fileInputStream = null;
                }
            } catch (Exception unused7) {
                randomAccessFile = null;
                fileInputStream = null;
            } catch (Throwable th8) {
                th = th8;
                randomAccessFile = null;
                fileInputStream = null;
            }
            in.b(randomAccessFile);
        }
        return arrayList;
    }

    private void g(gn gnVar) {
        if (gnVar.f24743a == gh.AppInstallList && !gnVar.f24744a.startsWith("same_")) {
            SharedPreferences.Editor edit = this.f388615e.edit();
            edit.putLong("dc_job_result_time_4", gnVar.f389110a);
            edit.putString("dc_job_result_4", ag.b(gnVar.f24744a));
            edit.commit();
        }
    }

    private boolean h() {
        if (au.x(this.f388614d)) {
            return false;
        }
        if ((au.z(this.f388614d) || au.y(this.f388614d)) && !c()) {
            return true;
        }
        if ((!au.A(this.f388614d) || b()) && !au.B(this.f388614d)) {
            return false;
        }
        return true;
    }

    @Override // com.xiaomi.push.ae.a
    public String e() {
        return "1";
    }

    @Override // java.lang.Runnable
    public void run() {
        File file = new File(this.f388614d.getFilesDir(), "push_cdata.data");
        if (!au.w(this.f388614d)) {
            if (file.length() > 1863680) {
                file.delete();
                return;
            }
            return;
        }
        if (h() || !file.exists()) {
            return;
        }
        List<gn> f16 = f(file);
        if (!iq.a(f16)) {
            int size = f16.size();
            if (size > 4000) {
                f16 = f16.subList(size - 4000, size);
            }
            gy gyVar = new gy();
            gyVar.a(f16);
            byte[] h16 = in.h(fv.e(gyVar));
            he heVar = new he("-1", false);
            heVar.c(gp.DataCollection.f24750a);
            heVar.a(h16);
            ci a16 = cj.b().a();
            if (a16 != null) {
                a16.a(heVar, gf.Notification, null);
            }
            a();
        }
        file.delete();
    }
}
