package com.tencent.mm.vfs;

import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;

/* compiled from: P */
/* loaded from: classes9.dex */
public class VFSFileWriter extends OutputStreamWriter {
    public VFSFileWriter(String str) throws FileNotFoundException {
        super(VFSFileOp.openWrite(str, false));
    }

    public VFSFileWriter(String str, boolean z16) throws FileNotFoundException {
        super(VFSFileOp.openWrite(str, z16));
    }

    public VFSFileWriter(VFSFile vFSFile) throws FileNotFoundException {
        super(VFSFileOp.openWrite(vFSFile.getUri(), vFSFile.resolve(), false));
    }

    public VFSFileWriter(VFSFile vFSFile, boolean z16) throws FileNotFoundException {
        super(VFSFileOp.openWrite(vFSFile.getUri(), vFSFile.resolve(), z16));
    }
}
