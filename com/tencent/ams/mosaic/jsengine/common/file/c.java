package com.tencent.ams.mosaic.jsengine.common.file;

import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c implements IWriter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final FileOutputStream f70890d;

    /* renamed from: e, reason: collision with root package name */
    private final a f70891e;

    public c(a aVar, File file, boolean z16) throws IOException, NullPointerException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, file, Boolean.valueOf(z16));
            return;
        }
        if (file != null) {
            if (!file.exists()) {
                file.createNewFile();
            }
            if (!file.isDirectory()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file, z16);
                this.f70890d = fileOutputStream;
                this.f70891e = aVar;
                if (aVar != null) {
                    aVar.a(fileOutputStream);
                    return;
                }
                return;
            }
            throw new IOException("can't write to directory");
        }
        throw new NullPointerException("file is null.");
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        FileOutputStream fileOutputStream = this.f70890d;
        if (fileOutputStream != null) {
            a aVar = this.f70891e;
            if (aVar != null) {
                aVar.c(fileOutputStream);
            }
            try {
                this.f70890d.close();
            } catch (IOException e16) {
                f.c("MosaicWriter", "close writer error.", e16);
            }
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IWriter
    public boolean writeText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        FileOutputStream fileOutputStream = this.f70890d;
        if (fileOutputStream != null && str != null) {
            try {
                fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
                return true;
            } catch (IOException e16) {
                f.c("MosaicWriter", "write text error. text: " + str, e16);
            }
        }
        return false;
    }
}
