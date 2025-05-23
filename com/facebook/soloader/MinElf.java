package com.facebook.soloader;

import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class MinElf {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class ElfError extends RuntimeException {
        ElfError(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum ISA {
        NOT_SO("not_so"),
        X86(ResourceAttributes.HostArchValues.X86),
        ARM("armeabi-v7a"),
        X86_64("x86_64"),
        AARCH64("arm64-v8a"),
        OTHERS("others");

        private final String value;

        ISA(String str) {
            this.value = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:13|14|15) */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0015, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0018, code lost:
    
        if (r0 <= 3) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:
    
        java.lang.Thread.interrupted();
        android.util.Log.e("MinElf", "retrying extract_DT_NEEDED due to ClosedByInterruptException", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0012, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002b, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        throw r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] a(File file) throws IOException {
        int i3 = 0;
        while (true) {
            FileInputStream fileInputStream = new FileInputStream(file);
            return b(fileInputStream.getChannel());
        }
    }

    public static String[] b(FileChannel fileChannel) throws IOException {
        long c16;
        long e16;
        long j3;
        long j16;
        long c17;
        long j17;
        long c18;
        long j18;
        String str;
        long j19;
        long c19;
        String str2;
        long j26;
        long c26;
        long f16;
        long c27;
        long c28;
        long c29;
        long f17;
        long c36;
        long f18;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        long f19 = f(fileChannel, allocate, 0L);
        if (f19 == 1179403647) {
            boolean z16 = true;
            if (g(fileChannel, allocate, 4L) != 1) {
                z16 = false;
            }
            if (g(fileChannel, allocate, 5L) == 2) {
                allocate.order(ByteOrder.BIG_ENDIAN);
            }
            if (z16) {
                c16 = f(fileChannel, allocate, 28L);
            } else {
                c16 = c(fileChannel, allocate, 32L);
            }
            if (z16) {
                e16 = e(fileChannel, allocate, 44L);
            } else {
                e16 = e(fileChannel, allocate, 56L);
            }
            if (z16) {
                j3 = 42;
            } else {
                j3 = 54;
            }
            int e17 = e(fileChannel, allocate, j3);
            if (e16 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                if (z16) {
                    c36 = f(fileChannel, allocate, 32L);
                } else {
                    c36 = c(fileChannel, allocate, 40L);
                }
                if (z16) {
                    f18 = f(fileChannel, allocate, c36 + 28);
                } else {
                    f18 = f(fileChannel, allocate, c36 + 44);
                }
                e16 = f18;
            }
            long j27 = c16;
            long j28 = 0;
            while (true) {
                if (j28 < e16) {
                    if (z16) {
                        f17 = f(fileChannel, allocate, j27 + 0);
                    } else {
                        f17 = f(fileChannel, allocate, j27 + 0);
                    }
                    if (f17 == 2) {
                        if (z16) {
                            j16 = f(fileChannel, allocate, j27 + 4);
                        } else {
                            j16 = c(fileChannel, allocate, j27 + 8);
                        }
                    } else {
                        j27 += e17;
                        j28++;
                    }
                } else {
                    j16 = 0;
                    break;
                }
            }
            long j29 = 0;
            if (j16 != 0) {
                long j36 = j16;
                long j37 = 0;
                int i3 = 0;
                while (true) {
                    boolean z17 = z16;
                    if (z16) {
                        c17 = f(fileChannel, allocate, j36 + j29);
                    } else {
                        c17 = c(fileChannel, allocate, j36 + j29);
                    }
                    long j38 = j16;
                    String str3 = "malformed DT_NEEDED section";
                    if (c17 == 1) {
                        if (i3 != Integer.MAX_VALUE) {
                            i3++;
                            j17 = c17;
                        } else {
                            throw new ElfError("malformed DT_NEEDED section");
                        }
                    } else if (c17 == 5) {
                        if (z17) {
                            j17 = c17;
                            c18 = f(fileChannel, allocate, j36 + 4);
                        } else {
                            j17 = c17;
                            c18 = c(fileChannel, allocate, j36 + 8);
                        }
                        j37 = c18;
                    } else {
                        j17 = c17;
                    }
                    long j39 = 16;
                    if (z17) {
                        j18 = 8;
                    } else {
                        j18 = 16;
                    }
                    j36 += j18;
                    j29 = 0;
                    if (j17 == 0) {
                        if (j37 != 0) {
                            int i16 = 0;
                            while (true) {
                                if (i16 < e16) {
                                    if (z17) {
                                        f16 = f(fileChannel, allocate, c16 + j29);
                                    } else {
                                        f16 = f(fileChannel, allocate, c16 + j29);
                                    }
                                    if (f16 == 1) {
                                        if (z17) {
                                            c27 = f(fileChannel, allocate, c16 + 8);
                                        } else {
                                            c27 = c(fileChannel, allocate, c16 + j39);
                                        }
                                        if (z17) {
                                            str = str3;
                                            c28 = f(fileChannel, allocate, c16 + 20);
                                        } else {
                                            str = str3;
                                            c28 = c(fileChannel, allocate, c16 + 40);
                                        }
                                        if (c27 <= j37 && j37 < c28 + c27) {
                                            if (z17) {
                                                c29 = f(fileChannel, allocate, c16 + 4);
                                            } else {
                                                c29 = c(fileChannel, allocate, c16 + 8);
                                            }
                                            j19 = c29 + (j37 - c27);
                                        }
                                    } else {
                                        str = str3;
                                    }
                                    c16 += e17;
                                    i16++;
                                    str3 = str;
                                    j39 = 16;
                                    j29 = 0;
                                } else {
                                    str = str3;
                                    j19 = 0;
                                    break;
                                }
                            }
                            long j46 = 0;
                            if (j19 != 0) {
                                String[] strArr = new String[i3];
                                long j47 = j38;
                                int i17 = 0;
                                while (true) {
                                    long j48 = j47 + j46;
                                    if (z17) {
                                        c19 = f(fileChannel, allocate, j48);
                                    } else {
                                        c19 = c(fileChannel, allocate, j48);
                                    }
                                    if (c19 == 1) {
                                        if (z17) {
                                            c26 = f(fileChannel, allocate, j47 + 4);
                                        } else {
                                            c26 = c(fileChannel, allocate, j47 + 8);
                                        }
                                        strArr[i17] = d(fileChannel, allocate, c26 + j19);
                                        if (i17 != Integer.MAX_VALUE) {
                                            i17++;
                                            str2 = str;
                                        } else {
                                            throw new ElfError(str);
                                        }
                                    } else {
                                        str2 = str;
                                    }
                                    if (z17) {
                                        j26 = 8;
                                    } else {
                                        j26 = 16;
                                    }
                                    j47 += j26;
                                    if (c19 == 0) {
                                        if (i17 == i3) {
                                            return strArr;
                                        }
                                        throw new ElfError(str2);
                                    }
                                    str = str2;
                                    j46 = 0;
                                }
                            } else {
                                throw new ElfError("did not find file offset of DT_STRTAB table");
                            }
                        } else {
                            throw new ElfError("Dynamic section string-table not found");
                        }
                    } else {
                        z16 = z17;
                        j16 = j38;
                    }
                }
            } else {
                throw new ElfError("ELF file does not contain dynamic linking information");
            }
        } else {
            throw new ElfError("file is not ELF: 0x" + Long.toHexString(f19));
        }
    }

    private static long c(FileChannel fileChannel, ByteBuffer byteBuffer, long j3) throws IOException {
        h(fileChannel, byteBuffer, 8, j3);
        return byteBuffer.getLong();
    }

    private static String d(FileChannel fileChannel, ByteBuffer byteBuffer, long j3) throws IOException {
        StringBuilder sb5 = new StringBuilder();
        while (true) {
            long j16 = 1 + j3;
            short g16 = g(fileChannel, byteBuffer, j3);
            if (g16 != 0) {
                sb5.append((char) g16);
                j3 = j16;
            } else {
                return sb5.toString();
            }
        }
    }

    private static int e(FileChannel fileChannel, ByteBuffer byteBuffer, long j3) throws IOException {
        h(fileChannel, byteBuffer, 2, j3);
        return byteBuffer.getShort() & 65535;
    }

    private static long f(FileChannel fileChannel, ByteBuffer byteBuffer, long j3) throws IOException {
        h(fileChannel, byteBuffer, 4, j3);
        return byteBuffer.getInt() & 4294967295L;
    }

    private static short g(FileChannel fileChannel, ByteBuffer byteBuffer, long j3) throws IOException {
        h(fileChannel, byteBuffer, 1, j3);
        return (short) (byteBuffer.get() & 255);
    }

    private static void h(FileChannel fileChannel, ByteBuffer byteBuffer, int i3, long j3) throws IOException {
        int read;
        byteBuffer.position(0);
        byteBuffer.limit(i3);
        while (byteBuffer.remaining() > 0 && (read = fileChannel.read(byteBuffer, j3)) != -1) {
            j3 += read;
        }
        if (byteBuffer.remaining() <= 0) {
            byteBuffer.position(0);
            return;
        }
        throw new ElfError("ELF file truncated");
    }
}
