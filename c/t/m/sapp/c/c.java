package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.patch.QZonePatchService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public static int f30138a;

    /* renamed from: d, reason: collision with root package name */
    public Context f30141d;

    /* renamed from: f, reason: collision with root package name */
    public String f30143f;

    /* renamed from: b, reason: collision with root package name */
    public final int f30139b = 30000;

    /* renamed from: c, reason: collision with root package name */
    public final int f30140c = 20000;

    /* renamed from: e, reason: collision with root package name */
    public List<a> f30142e = null;

    /* renamed from: g, reason: collision with root package name */
    public boolean f30144g = false;

    public c(Context context) {
        this.f30143f = null;
        this.f30141d = context;
        this.f30143f = this.f30141d.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation_sapp/UpCp";
        File file = new File(this.f30141d.getFilesDir().getAbsolutePath(), "TencentLocation_sapp/UpCp");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public final synchronized void a() {
        boolean z16;
        List<a> list = this.f30142e;
        if (list != null && list.size() > 0) {
            f30138a = 1;
            q.i(this.f30141d);
            if (q.d() < 10485760) {
                f30138a = 2;
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<a> it = this.f30142e.iterator();
            boolean z17 = true;
            while (true) {
                z16 = false;
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (a(next)) {
                    arrayList.add(next);
                } else {
                    z17 = false;
                }
            }
            if (!z17) {
                f30138a = 2;
                a(arrayList);
                return;
            }
            if (arrayList.size() == this.f30142e.size()) {
                q.c(this.f30141d, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
                if (q.a(this.f30141d, this.f30142e)) {
                    q.d(this.f30141d, "__SP_UPDATE_TencentLoc_COMP_SDK_VER__sapp_", g.f30163a);
                    for (a aVar : arrayList) {
                        if (!aVar.f30130c.contains(QZonePatchService.PATCH_SUFFIX_DEX)) {
                            aVar.f30130c += QZonePatchService.PATCH_SUFFIX_DEX;
                        }
                        File file = new File(this.f30143f, aVar.f30130c);
                        boolean delete = file.exists() ? file.delete() : true;
                        File file2 = new File(this.f30143f, aVar.f30130c);
                        boolean renameTo = new File(this.f30143f, "tmp__sapp" + aVar.f30130c).renameTo(file2);
                        boolean a16 = a(aVar, file2);
                        if (delete && renameTo && a16) {
                            z16 = true;
                        }
                    }
                    if (!z16) {
                        q.d(this.f30141d, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
                        q.a(this.f30143f);
                        f30138a = 2;
                        return;
                    }
                    f30138a = 1;
                    e.a(this.f30141d).a(PreDownloadConstants.RPORT_KEY_CPU, "down suc");
                } else {
                    a(arrayList);
                    f30138a = 2;
                }
            } else {
                i.a("down load failed");
                e.a(this.f30141d).a(PreDownloadConstants.RPORT_KEY_CPU, "down failed");
                a(arrayList);
                f30138a = 2;
            }
        }
    }

    public void b(List<a> list) {
        this.f30142e = list;
        if (f30138a != 1) {
            new BaseThread(this).start();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        d.a(this.f30141d).b("updatelock_sapp");
        a();
        e.a(this.f30141d).d();
        d.a(this.f30141d).c("updatelock_sapp");
    }

    public final void a(List<a> list) {
        for (a aVar : list) {
            File file = new File(this.f30143f, "tmp__sapp" + aVar.f30130c);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    public final boolean a(a aVar) {
        byte[] b16;
        BufferedOutputStream bufferedOutputStream;
        Exception e16;
        try {
            String str = "https://maplbs-40171.sh.gfp.tencent-cloud.com/Index/" + aVar.f30132e;
            i.a("start down load:" + aVar.f30132e);
            BufferedOutputStream bufferedOutputStream2 = null;
            int i3 = 0;
            while (true) {
                int i16 = i3 + 1;
                if (i3 >= 3) {
                    break;
                }
                byte[] a16 = o.a(str);
                if (a16 != null && (b16 = q.b(l.a(a16, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q"))) != null) {
                    File file = new File(this.f30143f, "tmp__sapp" + aVar.f30130c);
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, false), 1024);
                    } catch (Exception e17) {
                        bufferedOutputStream = bufferedOutputStream2;
                        e16 = e17;
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            bufferedOutputStream2.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                    try {
                        bufferedOutputStream.write(b16);
                        if (a(aVar, file)) {
                            i.a("down load available:" + aVar.f30132e);
                            e.a(this.f30141d).a(PreDownloadConstants.RPORT_KEY_CPU, "sud:" + aVar.f30132e);
                            try {
                                bufferedOutputStream.close();
                                return true;
                            } catch (Exception unused2) {
                                return true;
                            }
                        }
                        i.a("down load unavailable:" + aVar.f30132e);
                        e.a(this.f30141d).a(PreDownloadConstants.RPORT_KEY_CPU, "failed:" + aVar.f30132e);
                        if (file.exists() && file.isFile()) {
                            file.delete();
                        }
                        bufferedOutputStream.close();
                    } catch (Exception e18) {
                        e16 = e18;
                        try {
                            e16.printStackTrace();
                            if (file.exists() && file.isFile()) {
                                file.delete();
                            }
                            e.a(this.f30141d).a(PreDownloadConstants.RPORT_KEY_CPU, "failed:" + e16.toString());
                            try {
                                bufferedOutputStream.close();
                            } catch (Exception unused3) {
                            }
                            bufferedOutputStream2 = bufferedOutputStream;
                            q.a(5000L);
                            i3 = i16;
                        } catch (Throwable th6) {
                            th = th6;
                            bufferedOutputStream2 = bufferedOutputStream;
                            bufferedOutputStream2.close();
                            throw th;
                        }
                    }
                }
                q.a(5000L);
                i3 = i16;
            }
        } catch (Throwable unused4) {
        }
        return false;
    }

    public final boolean a(a aVar, File file) {
        if (file != null && file.exists()) {
            int length = (int) file.length();
            String a16 = q.a(file);
            if (aVar.f30131d == length && aVar.f30132e.equals(a16)) {
                return true;
            }
        }
        return false;
    }
}
