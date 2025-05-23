package com.tencent.ams.mosaic.jsengine.common.file;

import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements IReader {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final LineNumberReader f70886d;

    /* renamed from: e, reason: collision with root package name */
    private final a f70887e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f70888f;

    /* renamed from: h, reason: collision with root package name */
    private volatile String f70889h;

    public b(a aVar, File file) throws FileNotFoundException, IOException, NullPointerException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) file);
            return;
        }
        this.f70888f = false;
        this.f70889h = null;
        if (file != null) {
            if (!file.isDirectory()) {
                LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));
                this.f70886d = lineNumberReader;
                this.f70887e = aVar;
                if (aVar != null) {
                    aVar.a(lineNumberReader);
                    return;
                }
                return;
            }
            throw new IOException("can't read directory.");
        }
        throw new NullPointerException("file is null");
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        LineNumberReader lineNumberReader = this.f70886d;
        if (lineNumberReader != null) {
            a aVar = this.f70887e;
            if (aVar != null) {
                aVar.c(lineNumberReader);
            }
            try {
                this.f70886d.close();
            } catch (IOException e16) {
                f.c("MosaicReader", "close reader error.", e16);
            }
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IReader
    public boolean hasNext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f70886d == null) {
            return false;
        }
        if (this.f70889h == null && !this.f70888f) {
            try {
                this.f70889h = this.f70886d.readLine();
                if (this.f70889h == null) {
                    this.f70888f = true;
                }
            } catch (Throwable th5) {
                f.c("MosaicReader", "read line error.", th5);
            }
        }
        if (this.f70889h == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IReader
    public String readLine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (!hasNext()) {
            return null;
        }
        String str = this.f70889h;
        this.f70889h = null;
        return str;
    }
}
