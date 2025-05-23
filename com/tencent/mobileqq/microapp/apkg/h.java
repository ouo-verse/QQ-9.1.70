package com.tencent.mobileqq.microapp.apkg;

import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.microapp.apkg.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class h implements PreloadManager.OnGetPathListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.mobileqq.microapp.a.c f245860a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f245861b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ g.a f245862c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, com.tencent.mobileqq.microapp.a.c cVar, String str, g.a aVar) {
        this.f245860a = cVar;
        this.f245861b = str;
        this.f245862c = aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, gVar, cVar, str, aVar);
        }
    }

    public void onResult(int i3, PreloadManager.PathResult pathResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) pathResult);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ApkgManager", 1, "downloadSubPack | getResPath : resCode=" + i3 + "pathRes=" + pathResult);
        }
        if (i3 == 0) {
            String a16 = g.a(this.f245860a.f245825f.config);
            boolean a17 = com.tencent.mobileqq.microapp.a.c.a(new File(pathResult.filePath).getAbsolutePath(), a16, this.f245861b);
            if (QLog.isColorLevel()) {
                QLog.d("ApkgManager", 1, "downloadSubPack | getResPath :hasUnpack=" + a17 + "folderPath=" + a16 + "subRoot=" + this.f245861b);
            }
            if (a17) {
                g.a aVar = this.f245862c;
                if (aVar != null) {
                    aVar.onInitApkgInfo$76ec3a73(0, this.f245860a);
                    return;
                }
                return;
            }
            g.a aVar2 = this.f245862c;
            if (aVar2 != null) {
                aVar2.onInitApkgInfo$76ec3a73(1, null);
                return;
            }
            return;
        }
        g.a aVar3 = this.f245862c;
        if (aVar3 != null) {
            aVar3.onInitApkgInfo$76ec3a73(1, null);
        }
    }
}
