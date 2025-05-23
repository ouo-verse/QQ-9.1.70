package com.tencent.ttpic.openapi.initializer.so;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class MinElf {
    public static final int DT_NEEDED = 1;
    public static final int DT_NULL = 0;
    public static final int DT_STRTAB = 5;
    public static final int ELF_MAGIC = 1179403647;
    public static final int PN_XNUM = 65535;
    public static final int PT_DYNAMIC = 2;
    public static final int PT_LOAD = 1;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ElfError extends RuntimeException {
        ElfError(String str) {
            super(str);
        }
    }

    public static String[] extract_DT_NEEDED(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return extract_DT_NEEDED(fileInputStream.getChannel());
        } finally {
            fileInputStream.close();
        }
    }

    private static long get64(FileChannel fileChannel, ByteBuffer byteBuffer, long j3) throws IOException {
        read(fileChannel, byteBuffer, 8, j3);
        return byteBuffer.getLong();
    }

    private static String getSz(FileChannel fileChannel, ByteBuffer byteBuffer, long j3) throws IOException {
        StringBuilder sb5 = new StringBuilder();
        while (true) {
            long j16 = 1 + j3;
            short u8Var = getu8(fileChannel, byteBuffer, j3);
            if (u8Var != 0) {
                sb5.append((char) u8Var);
                j3 = j16;
            } else {
                return sb5.toString();
            }
        }
    }

    private static int getu16(FileChannel fileChannel, ByteBuffer byteBuffer, long j3) throws IOException {
        read(fileChannel, byteBuffer, 2, j3);
        return byteBuffer.getShort() & 65535;
    }

    private static long getu32(FileChannel fileChannel, ByteBuffer byteBuffer, long j3) throws IOException {
        read(fileChannel, byteBuffer, 4, j3);
        return byteBuffer.getInt() & 4294967295L;
    }

    private static short getu8(FileChannel fileChannel, ByteBuffer byteBuffer, long j3) throws IOException {
        read(fileChannel, byteBuffer, 1, j3);
        return (short) (byteBuffer.get() & 255);
    }

    private static void read(FileChannel fileChannel, ByteBuffer byteBuffer, int i3, long j3) throws IOException {
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

    public static String[] extract_DT_NEEDED(FileChannel fileChannel) throws IOException {
        long j3;
        long j16;
        int i3;
        long j17;
        boolean z16;
        long j18;
        long j19;
        long j26;
        String str;
        long j27;
        long j28;
        String str2;
        long j29;
        long j36;
        long j37;
        long j38;
        long j39;
        long j46;
        long j47;
        long j48;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (getu32(fileChannel, allocate, 0L) == 1179403647) {
            boolean z17 = getu8(fileChannel, allocate, 4L) == 1;
            if (getu8(fileChannel, allocate, 5L) == 2) {
                allocate.order(ByteOrder.BIG_ENDIAN);
            }
            if (z17) {
                j3 = getu32(fileChannel, allocate, 28L);
            } else {
                j3 = get64(fileChannel, allocate, 32L);
            }
            if (z17) {
                j16 = getu16(fileChannel, allocate, 44L);
            } else {
                j16 = getu16(fileChannel, allocate, 56L);
            }
            if (z17) {
                i3 = getu16(fileChannel, allocate, 42L);
            } else {
                i3 = getu16(fileChannel, allocate, 54L);
            }
            if (j16 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                if (z17) {
                    j47 = getu32(fileChannel, allocate, 32L);
                } else {
                    j47 = get64(fileChannel, allocate, 40L);
                }
                if (z17) {
                    j48 = getu32(fileChannel, allocate, j47 + 28);
                } else {
                    j48 = getu32(fileChannel, allocate, j47 + 44);
                }
                j16 = j48;
            }
            long j49 = j3;
            long j56 = 0;
            while (true) {
                if (j56 >= j16) {
                    j17 = 0;
                    break;
                }
                if (z17) {
                    j46 = getu32(fileChannel, allocate, j49 + 0);
                } else {
                    j46 = getu32(fileChannel, allocate, j49 + 0);
                }
                if (j46 != 2) {
                    j49 += i3;
                    j56++;
                } else if (z17) {
                    j17 = getu32(fileChannel, allocate, j49 + 4);
                } else {
                    j17 = get64(fileChannel, allocate, j49 + 8);
                }
            }
            long j57 = 0;
            if (j17 == 0) {
                throw new ElfError("ELF file does not contain dynamic linking information");
            }
            long j58 = j17;
            long j59 = 0;
            int i16 = 0;
            while (true) {
                if (z17) {
                    z16 = z17;
                    j18 = getu32(fileChannel, allocate, j58 + j57);
                } else {
                    z16 = z17;
                    j18 = get64(fileChannel, allocate, j58 + j57);
                }
                long j65 = j17;
                String str3 = "malformed DT_NEEDED section";
                if (j18 == 1) {
                    if (i16 == Integer.MAX_VALUE) {
                        throw new ElfError("malformed DT_NEEDED section");
                    }
                    i16++;
                    j19 = j18;
                } else if (j18 == 5) {
                    if (z16) {
                        j19 = j18;
                        j26 = getu32(fileChannel, allocate, j58 + 4);
                    } else {
                        j19 = j18;
                        j26 = get64(fileChannel, allocate, j58 + 8);
                    }
                    j59 = j26;
                } else {
                    j19 = j18;
                }
                long j66 = 16;
                j58 += z16 ? 8L : 16L;
                j57 = 0;
                if (j19 != 0) {
                    z17 = z16;
                    j17 = j65;
                } else {
                    if (j59 == 0) {
                        throw new ElfError("Dynamic section string-table not found");
                    }
                    int i17 = 0;
                    while (true) {
                        if (i17 >= j16) {
                            str = str3;
                            j27 = 0;
                            break;
                        }
                        if (z16) {
                            j36 = getu32(fileChannel, allocate, j3 + j57);
                        } else {
                            j36 = getu32(fileChannel, allocate, j3 + j57);
                        }
                        if (j36 == 1) {
                            if (z16) {
                                j37 = getu32(fileChannel, allocate, j3 + 8);
                            } else {
                                j37 = get64(fileChannel, allocate, j3 + j66);
                            }
                            if (z16) {
                                str = str3;
                                j38 = getu32(fileChannel, allocate, j3 + 20);
                            } else {
                                str = str3;
                                j38 = get64(fileChannel, allocate, j3 + 40);
                            }
                            if (j37 <= j59 && j59 < j38 + j37) {
                                if (z16) {
                                    j39 = getu32(fileChannel, allocate, j3 + 4);
                                } else {
                                    j39 = get64(fileChannel, allocate, j3 + 8);
                                }
                                j27 = j39 + (j59 - j37);
                            }
                        } else {
                            str = str3;
                        }
                        j3 += i3;
                        i17++;
                        str3 = str;
                        j66 = 16;
                        j57 = 0;
                    }
                    long j67 = 0;
                    if (j27 != 0) {
                        String[] strArr = new String[i16];
                        long j68 = j65;
                        int i18 = 0;
                        while (true) {
                            if (z16) {
                                j28 = getu32(fileChannel, allocate, j68 + j67);
                            } else {
                                j28 = get64(fileChannel, allocate, j68 + j67);
                            }
                            if (j28 == 1) {
                                if (z16) {
                                    j29 = getu32(fileChannel, allocate, j68 + 4);
                                } else {
                                    j29 = get64(fileChannel, allocate, j68 + 8);
                                }
                                strArr[i18] = getSz(fileChannel, allocate, j29 + j27);
                                if (i18 == Integer.MAX_VALUE) {
                                    throw new ElfError(str);
                                }
                                i18++;
                                str2 = str;
                            } else {
                                str2 = str;
                            }
                            j68 += z16 ? 8L : 16L;
                            if (j28 == 0) {
                                if (i18 == i16) {
                                    return strArr;
                                }
                                throw new ElfError(str2);
                            }
                            str = str2;
                            j67 = 0;
                        }
                    } else {
                        throw new ElfError("did not find file offset of DT_STRTAB table");
                    }
                }
            }
        } else {
            throw new ElfError("file is not ELF");
        }
    }
}
