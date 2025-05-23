package com.tencent.ams.mosaic.jsengine.common.file;

import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.annotation.JSMethod;
import java.io.Closeable;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
interface IReader extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    @JSMethod
    void close();

    boolean hasNext();

    String readLine();
}
