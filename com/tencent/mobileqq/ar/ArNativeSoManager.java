package com.tencent.mobileqq.ar;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.arengine.ae;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArNativeSoManager {

    /* renamed from: a, reason: collision with root package name */
    ae f197394a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<ae.d> f197395b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<ae.d> f197396c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<ae.d> f197397d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements ae.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ae.e f197404a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f197405b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ae.d f197406c;

        a(ae.e eVar, String str, ae.d dVar) {
            this.f197404a = eVar;
            this.f197405b = str;
            this.f197406c = dVar;
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void a(long j3, long j16) {
            ae.d dVar = this.f197406c;
            if (dVar != null) {
                dVar.a(j3, j16);
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void b() {
            ae.d dVar = this.f197406c;
            if (dVar != null) {
                dVar.b();
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void c(boolean z16, @Nullable ae.e eVar) {
            QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + z16 + ", name = " + this.f197404a.f198110e + ", filename = " + this.f197404a.f198109d + ", url = " + this.f197404a.f198107b);
            if (z16) {
                ArNativeSoManager arNativeSoManager = ArNativeSoManager.this;
                ae.e eVar2 = this.f197404a;
                if (!arNativeSoManager.f(eVar2.f198109d, eVar2.f198108c)) {
                    ArNativeSoManager.this.h(this.f197404a.f198109d);
                    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
                    return;
                } else if (this.f197404a.f198110e.equalsIgnoreCase(this.f197405b)) {
                    ArNativeSoManager arNativeSoManager2 = ArNativeSoManager.this;
                    ae.e eVar3 = this.f197404a;
                    arNativeSoManager2.i(eVar3.f198110e, eVar3.f198109d, eVar3.f198108c);
                }
            }
            ae.d dVar = this.f197406c;
            if (dVar != null) {
                dVar.c(z16, this.f197404a);
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void d() {
            ae.d dVar = this.f197406c;
            if (dVar != null) {
                dVar.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements ae.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ARCommonConfigInfo.NativeSoRes f197408a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ae.e f197409b;

        b(ARCommonConfigInfo.NativeSoRes nativeSoRes, ae.e eVar) {
            this.f197408a = nativeSoRes;
            this.f197409b = eVar;
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void a(long j3, long j16) {
            ae.d o16 = ArNativeSoManager.this.o(this.f197408a.f197685d);
            if (o16 != null) {
                o16.a(j3, j16);
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void b() {
            ae.d o16 = ArNativeSoManager.this.o(this.f197408a.f197685d);
            if (o16 != null) {
                o16.b();
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void c(boolean z16, @Nullable ae.e eVar) {
            QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + z16 + ", name = " + this.f197408a.f197685d + ", filename = " + this.f197409b.f198109d + ", url = " + this.f197409b.f198107b);
            if (z16) {
                ArNativeSoManager arNativeSoManager = ArNativeSoManager.this;
                ae.e eVar2 = this.f197409b;
                if (!arNativeSoManager.f(eVar2.f198109d, eVar2.f198108c)) {
                    ArNativeSoManager.this.h(this.f197409b.f198109d);
                    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
                    return;
                } else {
                    ArNativeSoManager arNativeSoManager2 = ArNativeSoManager.this;
                    ae.e eVar3 = this.f197409b;
                    arNativeSoManager2.i(eVar3.f198110e, eVar3.f198109d, eVar3.f198108c);
                }
            }
            ae.d o16 = ArNativeSoManager.this.o(this.f197408a.f197685d);
            if (o16 != null) {
                o16.c(z16, this.f197409b);
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void d() {
            ae.d o16 = ArNativeSoManager.this.o(this.f197408a.f197685d);
            if (o16 != null) {
                o16.d();
            }
        }
    }

    public ArNativeSoManager(QQAppInterface qQAppInterface) {
        this.f197394a = new ae(qQAppInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(String str, String str2) {
        if (new File(str).exists()) {
            if (str2.equalsIgnoreCase(com.tencent.mobileqq.portal.o.e(str))) {
                return true;
            }
            QLog.i("AREngine_ArNativeSoManager", 1, "checkFileValid failed. check md5 failed. filename = " + str + ", md5FromConfig = " + str2);
            return false;
        }
        QLog.i("AREngine_ArNativeSoManager", 1, "checkFileValid failed. file is not exist. filename = " + str + ", md5FromConfig = " + str2);
        return false;
    }

    private boolean g(String str, String str2) {
        QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. dir = " + str + ", excludeSubDirOrFile = " + str2);
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null) {
            return false;
        }
        boolean z16 = false;
        for (File file : listFiles) {
            if (!file.getAbsolutePath().equalsIgnoreCase(str2)) {
                if (file.isDirectory()) {
                    z16 = g(file.getAbsolutePath(), str2);
                    if (z16) {
                        QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. do not delete excludeSubDirOrFile. curSubDirOrFile  = " + file.getAbsolutePath());
                    } else {
                        QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. delete dir or file = " + file.getAbsolutePath());
                        file.delete();
                    }
                } else {
                    QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. delete dir or file = " + file.getAbsolutePath());
                    file.delete();
                }
            } else {
                QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. do not delete excludeSubDirOrFile. curSubDirOrFile  = " + file.getAbsolutePath());
            }
            z16 = true;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ArrayList<ARCommonConfigInfo.NativeSoRes> arrayList, String str, ae.d dVar) {
        boolean z16;
        boolean z17 = true;
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadArNativeSo. resName = " + str);
        String p16 = p(str);
        s(str, dVar);
        ARCommonConfigInfo.NativeSoRes nativeSoRes = new ARCommonConfigInfo.NativeSoRes();
        int i3 = 0;
        while (true) {
            if (i3 < arrayList.size()) {
                ARCommonConfigInfo.NativeSoRes nativeSoRes2 = arrayList.get(i3);
                if (nativeSoRes2.f197685d.equalsIgnoreCase(str) && nativeSoRes2.f197686e.equalsIgnoreCase(p16)) {
                    z16 = true;
                    nativeSoRes = nativeSoRes2;
                    break;
                }
                i3++;
            } else {
                z16 = false;
                break;
            }
        }
        if (z16 && this.f197394a != null) {
            String str2 = l.b(nativeSoRes.f197685d, nativeSoRes.f197686e, nativeSoRes.f197688h) + File.separator + nativeSoRes.f197688h + ".zip";
            if (!f(str2, nativeSoRes.f197688h)) {
                h(str2);
                if (!TextUtils.isEmpty(nativeSoRes.f197687f) && !TextUtils.isEmpty(nativeSoRes.f197688h)) {
                    ae.e eVar = new ae.e();
                    eVar.f198106a = 5;
                    eVar.f198107b = nativeSoRes.f197687f;
                    eVar.f198108c = nativeSoRes.f197688h;
                    eVar.f198110e = nativeSoRes.f197685d;
                    eVar.f198109d = str2;
                    eVar.f198111f = true;
                    this.f197394a.e(eVar, new a(eVar, str, dVar));
                    return;
                }
                QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. TextUtils.isEmpty(nativeSoRes.url) || TextUtils.isEmpty(nativeSoRes.md5), not need to download. soZipFilename = " + str2);
                if (dVar != null) {
                    dVar.c(false, null);
                    return;
                }
                return;
            }
            if (!q(str)) {
                int i16 = i(str, str2, nativeSoRes.f197688h);
                if (dVar != null) {
                    if (i16 != 0) {
                        z17 = false;
                    }
                    dVar.c(z17, null);
                    return;
                }
                return;
            }
            if (dVar != null) {
                dVar.c(true, null);
                return;
            }
            return;
        }
        if (dVar != null) {
            dVar.c(false, null);
        }
    }

    private void l(ARCommonConfigInfo.NativeSoRes nativeSoRes, ae.e eVar) {
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes. fileName = " + eVar.f198109d + ", url = " + eVar.f198107b);
        ae aeVar = this.f197394a;
        if (aeVar == null) {
            return;
        }
        aeVar.e(eVar, new b(nativeSoRes, eVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(ArrayList<ARCommonConfigInfo.NativeSoRes> arrayList, ArrayList<ARCommonConfigInfo.NativeSoRes> arrayList2, String str) {
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. resName = " + str);
        String p16 = p(str);
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            ARCommonConfigInfo.NativeSoRes nativeSoRes = arrayList2.get(i3);
            if (nativeSoRes.f197685d.equalsIgnoreCase(str)) {
                if (nativeSoRes.f197686e.equalsIgnoreCase(p16)) {
                    String str2 = l.b(nativeSoRes.f197685d, nativeSoRes.f197686e, nativeSoRes.f197688h) + File.separator + nativeSoRes.f197688h + ".zip";
                    if (!f(str2, nativeSoRes.f197688h)) {
                        h(str2);
                        if (!TextUtils.isEmpty(nativeSoRes.f197687f) && !TextUtils.isEmpty(nativeSoRes.f197688h)) {
                            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                                ARCommonConfigInfo.NativeSoRes nativeSoRes2 = arrayList.get(i16);
                                if (nativeSoRes2.f197685d.equalsIgnoreCase(str) && nativeSoRes2.f197686e.equalsIgnoreCase(p16)) {
                                    g(l.a(nativeSoRes2.f197685d), l.b(nativeSoRes2.f197685d, nativeSoRes2.f197686e, nativeSoRes2.f197688h));
                                }
                            }
                            ae.e eVar = new ae.e();
                            eVar.f198106a = 5;
                            eVar.f198107b = nativeSoRes.f197687f;
                            eVar.f198108c = nativeSoRes.f197688h;
                            eVar.f198110e = nativeSoRes.f197685d;
                            eVar.f198109d = str2;
                            eVar.f198111f = true;
                            l(nativeSoRes, eVar);
                        } else {
                            QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. TextUtils.isEmpty(nativeSoRes.url) || TextUtils.isEmpty(nativeSoRes.md5), not need to download. soZipFilename = " + str2);
                        }
                    } else {
                        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. soRes exists, not need to download. soZipFilename = " + str2);
                        i(str, str2, nativeSoRes.f197688h);
                    }
                } else {
                    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. soResVersion is not need to download. soResName = " + nativeSoRes.f197685d + ", soResVersionFromConfig = " + nativeSoRes.f197686e + ", soResVersionFromLocal = " + p16);
                }
            } else {
                QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. soResName is not need to download. soResName = " + nativeSoRes.f197685d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ae.d o(String str) {
        if (str.equalsIgnoreCase("arsdk2")) {
            WeakReference<ae.d> weakReference = this.f197395b;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }
        if (str.equalsIgnoreCase("arcloud")) {
            WeakReference<ae.d> weakReference2 = this.f197396c;
            if (weakReference2 == null) {
                return null;
            }
            return weakReference2.get();
        }
        if (str.equalsIgnoreCase("arfeature")) {
            WeakReference<ae.d> weakReference3 = this.f197397d;
            if (weakReference3 == null) {
                return null;
            }
            return weakReference3.get();
        }
        w81.b.a();
        return null;
    }

    private String p(String str) {
        if (str.equalsIgnoreCase("arsdk2")) {
            return n.b();
        }
        if (str.equalsIgnoreCase("arcloud")) {
            return "v8.4.1.1";
        }
        if (str.equalsIgnoreCase("arfeature")) {
            return "v8.0.0";
        }
        w81.b.a();
        return "";
    }

    private boolean q(String str) {
        if (str.equalsIgnoreCase("arsdk2")) {
            return n.c();
        }
        if (str.equalsIgnoreCase("arcloud")) {
            return h.c();
        }
        if (str.equalsIgnoreCase("arfeature")) {
            return k.b();
        }
        w81.b.a();
        return true;
    }

    private void s(String str, ae.d dVar) {
        if (str.equalsIgnoreCase("arsdk2")) {
            this.f197395b = new WeakReference<>(dVar);
            return;
        }
        if (str.equalsIgnoreCase("arcloud")) {
            this.f197396c = new WeakReference<>(dVar);
        } else if (str.equalsIgnoreCase("arfeature")) {
            this.f197397d = new WeakReference<>(dVar);
        } else {
            w81.b.a();
        }
    }

    public synchronized int i(String str, String str2, String str3) {
        if (str.equalsIgnoreCase("arsdk2")) {
            return n.a(str2, str3);
        }
        if (str.equalsIgnoreCase("arcloud")) {
            return h.a(str2, str3);
        }
        if (str.equalsIgnoreCase("arfeature")) {
            return k.a(str2, str3);
        }
        w81.b.a();
        return -1;
    }

    public void j(final ArrayList<ARCommonConfigInfo.NativeSoRes> arrayList, final String str, final ae.d dVar) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArNativeSoManager.1
            @Override // java.lang.Runnable
            public void run() {
                ArNativeSoManager.this.k(arrayList, str, dVar);
            }
        });
    }

    public void m(final ArrayList<ARCommonConfigInfo.NativeSoRes> arrayList, final ArrayList<ARCommonConfigInfo.NativeSoRes> arrayList2, final String str) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArNativeSoManager.3
            @Override // java.lang.Runnable
            public void run() {
                ArNativeSoManager.this.n(arrayList, arrayList2, str);
            }
        });
    }

    public boolean r(ArrayList<ARCommonConfigInfo.NativeSoRes> arrayList, String str) {
        QLog.i("AREngine_ArNativeSoManager", 1, "isArNativeSoDownload. resName = " + str);
        String p16 = p(str);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            ARCommonConfigInfo.NativeSoRes nativeSoRes = arrayList.get(i3);
            if (nativeSoRes.f197685d.equalsIgnoreCase(str) && nativeSoRes.f197686e.equalsIgnoreCase(p16)) {
                String str2 = l.b(nativeSoRes.f197685d, nativeSoRes.f197686e, nativeSoRes.f197688h) + File.separator + nativeSoRes.f197688h + ".zip";
                if (!f(str2, nativeSoRes.f197688h)) {
                    h(str2);
                    return false;
                }
                return q(str);
            }
        }
        return false;
    }
}
