package com.tencent.mobileqq.vfs;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mm.vfs.FileSchemeResolver;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mm.vfs.MigrationFileSystem;
import com.tencent.mm.vfs.NativeFileSystem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.io.File;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f312446a;

    /* renamed from: b, reason: collision with root package name */
    private String f312447b;

    /* renamed from: c, reason: collision with root package name */
    private String f312448c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private c f312449d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final b f312450a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42082);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f312450a = new b();
            }
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a() {
        boolean z16 = false;
        if (BaseApplication.getContext().getSharedPreferences("StepUpdate", 4).getInt("vfs_version", 0) < 10) {
            z16 = true;
        }
        QLog.d("VFSRegisterProxy", 1, "initConfig checkSP is called, return val = " + z16);
        return z16;
    }

    private void c() {
        try {
            File[] listFiles = new File(AppConstants.SDCARD_PATH).listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file : listFiles) {
                String trim = file.getName().trim();
                int length = trim.length();
                if (length >= 5 && length <= 15) {
                    try {
                        Long.parseLong(trim);
                        File file2 = new File(file, FileReaderHelper.PPT_EXT);
                        if (file2.exists()) {
                            j(file2.getAbsolutePath());
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void g(Context context, c cVar, boolean z16, boolean z17) {
        String str;
        l(context, cVar, z16, z17);
        FileSystemManager.Editor edit = FileSystemManager.instance().edit();
        edit.scheme("", FileSchemeResolver.instance());
        edit.scheme("file", FileSchemeResolver.instance());
        edit.scheme(null, FileSchemeResolver.instance());
        Iterator<String> it = d.f312451a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                if (!next.startsWith("/") && next.indexOf(":") <= 0) {
                    str = f() + File.separator + next;
                } else {
                    str = next;
                }
                String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(next);
                File parentFile = new File(sDKPrivatePath).getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                MigrationFileSystem migrationFileSystem = new MigrationFileSystem(true, (FileSystem) new NativeFileSystem(sDKPrivatePath, false), new NativeFileSystem(str, false));
                if (QLog.isColorLevel()) {
                    QLog.d("VFSRegisterProxy", 2, "initConfig filesystem key is " + next);
                }
                edit.install(next, migrationFileSystem).mount(sDKPrivatePath, next).mount(str, next);
            }
        }
        edit.commit();
    }

    public static b i() {
        return a.f312450a;
    }

    private void j(String str) {
        File file = new File(str);
        if (file.isDirectory()) {
            File file2 = new File(VFSAssistantUtils.getSDKPrivatePath(str));
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (file.renameTo(file2) && QLog.isColorLevel()) {
                QLog.i("VFSRegisterProxy", 2, "executeLightMigrate Fast moved '" + file + "' -> '" + file2 + "'");
            }
        }
    }

    private void k(boolean z16, boolean z17) {
        if (z17) {
            QLog.d("VFSRegisterProxy", 1, "publishOnEditorCommit() is called. isMainProcess = " + z16);
            FileSystemManager.instance().publishOnEditorCommit(z16);
        }
    }

    private void m() {
        BaseApplication.getContext().getSharedPreferences("StepUpdate", 4).edit().putInt("vfs_version", 10).apply();
        QLog.d("VFSRegisterProxy", 1, "initConfig updateSP is called, version = 10");
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Iterator<String> it = d.f312452b.iterator();
        while (it.hasNext()) {
            j(it.next());
        }
    }

    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.f312448c == null) {
            this.f312448c = BaseApplication.getContext().getCacheDir().getParent();
        }
        return this.f312448c;
    }

    @Nullable
    public final String e() {
        File externalCacheDir;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f312446a == null && (externalCacheDir = BaseApplication.getContext().getExternalCacheDir()) != null) {
            this.f312446a = externalCacheDir.getParent();
        }
        return this.f312446a;
    }

    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.f312447b == null) {
            this.f312447b = Environment.getExternalStorageDirectory().getPath();
        }
        return this.f312447b;
    }

    public void h(Context context, c cVar, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, cVar, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        l(context, cVar, z16, z17);
        QLog.d("VFSRegisterProxy", 1, "initConfig start!");
        try {
            if (a()) {
                g(context, cVar, z16, z17);
                if (!FileSystemManager.instance().isValidConfigFile(context)) {
                    g(context, cVar, z16, z17);
                }
                if (FileSystemManager.instance().isValidConfigFile(context)) {
                    m();
                }
                b();
                c();
            }
        } catch (Throwable th5) {
            c cVar2 = this.f312449d;
            if (cVar2 != null) {
                cVar2.reportError(new Throwable("FileSystemManager proxy", th5));
            }
            QLog.e("VFSRegisterProxy", 1, th5, new Object[0]);
        }
        QLog.d("VFSRegisterProxy", 1, "initConfig end!");
    }

    public void l(Context context, c cVar, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, cVar, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.f312449d = cVar;
        FileSystemManager.setContext(context);
        if (z16) {
            FileSystemManager.setStatisticsCallback(this.f312449d);
        }
        k(z16, z17);
    }
}
