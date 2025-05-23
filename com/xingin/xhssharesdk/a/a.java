package com.xingin.xhssharesdk.a;

import com.xingin.xhssharesdk.a.a;
import com.xingin.xhssharesdk.a.a.AbstractC10092a;
import com.xingin.xhssharesdk.a.g;
import com.xingin.xhssharesdk.a.l;
import java.io.IOException;
import java.util.logging.Logger;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC10092a<MessageType, BuilderType>> implements l {

    /* renamed from: d, reason: collision with root package name */
    public int f389875d = 0;

    /* compiled from: P */
    /* renamed from: com.xingin.xhssharesdk.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static abstract class AbstractC10092a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC10092a<MessageType, BuilderType>> implements l.a {
    }

    @Override // com.xingin.xhssharesdk.a.l
    public final byte[] a() {
        try {
            int b16 = b();
            byte[] bArr = new byte[b16];
            Logger logger = g.f389913a;
            g.b bVar = new g.b(bArr, b16);
            a(bVar);
            if (bVar.f389920e - bVar.f389921f == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e16) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e16);
        }
    }
}
