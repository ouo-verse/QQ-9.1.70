package com.tencent.luggage.wxa.nc;

import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.mc.a0;
import java.io.Closeable;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface a extends Closeable {
    InputStream a(a0.a aVar);

    Map a(FileChannel fileChannel, v vVar);

    boolean a(FileChannel fileChannel);

    boolean b(a0.a aVar);

    int i();

    int n();
}
