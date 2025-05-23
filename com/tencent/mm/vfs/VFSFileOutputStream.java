package com.tencent.mm.vfs;

import java.io.FileNotFoundException;
import java.io.FilterOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes9.dex */
public class VFSFileOutputStream extends FilterOutputStream {
    public VFSFileOutputStream(String str) throws FileNotFoundException {
        super(VFSFileOp.openWrite(str, false));
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i3, i16);
    }

    public VFSFileOutputStream(String str, boolean z16) throws FileNotFoundException {
        super(VFSFileOp.openWrite(str, z16));
    }

    public VFSFileOutputStream(VFSFile vFSFile) throws FileNotFoundException {
        super(VFSFileOp.openWrite(vFSFile.getUri(), vFSFile.resolve(), false));
    }

    public VFSFileOutputStream(VFSFile vFSFile, boolean z16) throws FileNotFoundException {
        super(VFSFileOp.openWrite(vFSFile.getUri(), vFSFile.resolve(), z16));
    }
}
