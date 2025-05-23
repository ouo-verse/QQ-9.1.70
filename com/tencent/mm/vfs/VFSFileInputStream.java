package com.tencent.mm.vfs;

import java.io.FileNotFoundException;
import java.io.FilterInputStream;

/* compiled from: P */
/* loaded from: classes9.dex */
public class VFSFileInputStream extends FilterInputStream {
    public VFSFileInputStream(String str) throws FileNotFoundException {
        super(VFSFileOp.openRead(str));
    }

    public VFSFileInputStream(VFSFile vFSFile) throws FileNotFoundException {
        super(VFSFileOp.openRead(vFSFile.getUri(), vFSFile.resolve()));
    }
}
