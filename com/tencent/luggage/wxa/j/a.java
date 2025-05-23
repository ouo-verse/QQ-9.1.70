package com.tencent.luggage.wxa.j;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static ByteBuffer a(InputStream inputStream, boolean z16) {
        if (!z16 && !inputStream.markSupported()) {
            inputStream = e.a(inputStream);
            e.b(inputStream);
        }
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[10000];
        int i3 = 100000;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(100000);
        allocateDirect.order(ByteOrder.nativeOrder());
        int i16 = 0;
        int i17 = 0;
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr);
                    i16 += read;
                    if (i16 > i3) {
                        allocateDirect = a(allocateDirect);
                        i3 = allocateDirect.capacity();
                    }
                    if (read < 0) {
                        break;
                    }
                    allocateDirect.position(i17);
                    allocateDirect.put(bArr, 0, read);
                    i17 += read;
                } catch (IOException e16) {
                    com.tencent.luggage.wxa.h.b.a("Ni.ByteBufferUtil", e16, "hy: allocateByteBufferFromStream IOException", new Object[0]);
                    try {
                        if (z16) {
                            inputStream.close();
                        } else {
                            inputStream.reset();
                        }
                    } catch (Exception e17) {
                        com.tencent.luggage.wxa.h.b.a("Ni.ByteBufferUtil", e17, "hy: exception in finally!", new Object[0]);
                    }
                    return null;
                } catch (BufferOverflowException e18) {
                    com.tencent.luggage.wxa.h.b.a("Ni.ByteBufferUtil", e18, "hy: allocateByteBufferFromStream BufferOverflowException", new Object[0]);
                    try {
                        if (z16) {
                            inputStream.close();
                        } else {
                            inputStream.reset();
                        }
                    } catch (Exception e19) {
                        com.tencent.luggage.wxa.h.b.a("Ni.ByteBufferUtil", e19, "hy: exception in finally!", new Object[0]);
                    }
                }
            } catch (Throwable th5) {
                try {
                    if (z16) {
                        inputStream.close();
                    } else {
                        inputStream.reset();
                    }
                } catch (Exception e26) {
                    com.tencent.luggage.wxa.h.b.a("Ni.ByteBufferUtil", e26, "hy: exception in finally!", new Object[0]);
                }
                throw th5;
            }
        }
        allocateDirect.position(0);
        try {
            if (z16) {
                inputStream.close();
            } else {
                inputStream.reset();
            }
        } catch (Exception e27) {
            com.tencent.luggage.wxa.h.b.a("Ni.ByteBufferUtil", e27, "hy: exception in finally!", new Object[0]);
        }
        return allocateDirect;
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteBuffer.capacity() + 100000);
        allocateDirect.order(ByteOrder.nativeOrder());
        byteBuffer.position(0);
        allocateDirect.put(byteBuffer);
        return allocateDirect;
    }
}
