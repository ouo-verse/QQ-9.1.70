package com.tencent.mtt.hippy.c.e;

import androidx.annotation.NonNull;
import com.tencent.mtt.hippy.c.f;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements c {
    @Override // com.tencent.mtt.hippy.c.e.c
    public String a(ByteBuffer byteBuffer, @NonNull String str, f fVar, Object obj) throws UnsupportedEncodingException {
        if (fVar == f.VOID) {
            return "";
        }
        return new String(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.arrayOffset() + byteBuffer.limit(), str);
    }

    @Override // com.tencent.mtt.hippy.c.e.c
    public void a() {
    }
}
