package com.tencent.could.component.common.ai.log;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f99950a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f99951b;

    public a(b bVar, String str) {
        this.f99951b = bVar;
        this.f99950a = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) str);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        b bVar = this.f99951b;
        if (bVar.f99955d == null) {
            return;
        }
        if (bVar.f99952a.isUseExternalFile() && !com.tencent.could.component.common.ai.utils.a.a(this.f99951b.f99955d.get())) {
            Log.e("FilePrinter", "Do not have permission to check local file!");
            return;
        }
        String str = this.f99950a;
        if (TextUtils.isEmpty(str)) {
            Log.e("FilePrinter", "logFolderPath is empty!");
            return;
        }
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file : listFiles) {
                if (!file.isDirectory()) {
                    try {
                        b bVar2 = this.f99951b;
                        bVar2.getClass();
                        if (file.lastModified() < System.currentTimeMillis() - bVar2.f99952a.getFileOutTime() && !file.delete()) {
                            Log.e("FilePrinter", "delete file error : path " + file.getCanonicalPath());
                        }
                    } catch (IOException e16) {
                        Log.e("FilePrinter", "readAnCheckLocalFile error : " + e16.getMessage());
                    }
                }
            }
        }
    }
}
