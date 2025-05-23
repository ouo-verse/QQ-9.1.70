package com.tencent.ams.mosaic.jsengine.common.file;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Closeable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements IFileManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Context f70884a;

    /* renamed from: b, reason: collision with root package name */
    private final List<WeakReference<Closeable>> f70885b;

    public a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f70885b = new ArrayList();
        if (context != null) {
            this.f70884a = context.getApplicationContext();
        } else {
            this.f70884a = null;
        }
    }

    public synchronized void a(Closeable closeable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) closeable);
        } else {
            this.f70885b.add(new WeakReference<>(closeable));
        }
    }

    public synchronized void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Iterator<WeakReference<Closeable>> it = this.f70885b.iterator();
        while (it.hasNext()) {
            WeakReference<Closeable> next = it.next();
            if (next != null) {
                Closeable closeable = next.get();
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (Throwable th5) {
                        f.c("FileManager", "close error.", th5);
                    }
                }
                it.remove();
            }
        }
    }

    public synchronized void c(Closeable closeable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) closeable);
            return;
        }
        if (closeable == null) {
            return;
        }
        Iterator<WeakReference<Closeable>> it = this.f70885b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WeakReference<Closeable> next = it.next();
            if (next != null && next.get() == closeable) {
                it.remove();
                break;
            }
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IFileManager
    public String getExternalPath() {
        File externalCacheDir;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Context context = this.f70884a;
        if (context != null && (externalCacheDir = context.getExternalCacheDir()) != null) {
            return externalCacheDir.getParent();
        }
        return null;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IFileManager
    public IFile getFile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IFile) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new MosaicFile(new File(str), this);
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IFileManager
    public String getSDKRootPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        String sandboxPath = getSandboxPath();
        if (!TextUtils.isEmpty(sandboxPath)) {
            return new File(sandboxPath, TagValue.MOSAIC).getAbsolutePath();
        }
        return null;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IFileManager
    public String getSandboxPath() {
        File filesDir;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Context context = this.f70884a;
        if (context != null && (filesDir = context.getFilesDir()) != null) {
            return filesDir.getPath();
        }
        return null;
    }
}
