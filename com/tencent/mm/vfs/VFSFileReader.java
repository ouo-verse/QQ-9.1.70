package com.tencent.mm.vfs;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes9.dex */
public class VFSFileReader extends InputStreamReader {
    public VFSFileReader(String str) throws FileNotFoundException {
        super(VFSFileOp.openRead(str));
    }

    public VFSFileReader(VFSFile vFSFile) throws FileNotFoundException {
        super(VFSFileOp.openRead(vFSFile.getUri(), vFSFile.resolve()));
    }
}
