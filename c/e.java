package c;

import android.text.TextUtils;
import c.d;
import com.tencent.mobileqq.qqbattery.feature.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<byte[]> f29459a = new ThreadLocal<>();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a {
        static {
            new InheritableThreadLocal();
        }

        public static long a(d dVar) {
            long j3 = 1;
            long j16 = 0;
            boolean z16 = true;
            while (true) {
                if (!dVar.e()) {
                    break;
                }
                dVar.f();
                if (Character.isDigit(dVar.f29455f)) {
                    j16 = (j16 * 10) + (dVar.f29455f - '0');
                } else if (z16) {
                    if (dVar.f29455f == '-') {
                        j3 = -1;
                    } else {
                        throw new d.a("Couldn't read number!");
                    }
                } else {
                    dVar.h();
                    break;
                }
                z16 = false;
            }
            if (!z16) {
                long j17 = j3 * j16;
                dVar.c(TokenParser.SP);
                return j17;
            }
            throw new d.a("Couldn't read number because the file ended!");
        }

        public static c b(String str, byte[] bArr) {
            d dVar = new d(str, bArr);
            try {
                try {
                    dVar.g();
                    dVar.c('(');
                    CharBuffer a16 = dVar.a(CharBuffer.allocate(16));
                    dVar.c(TokenParser.SP);
                    CharBuffer d16 = dVar.d(CharBuffer.allocate(1));
                    for (int i3 = 0; i3 < 11; i3++) {
                        dVar.c(TokenParser.SP);
                    }
                    c cVar = new c();
                    cVar.f29460a = String.valueOf(a16);
                    cVar.f29461b = String.valueOf(d16);
                    cVar.f29462c = a(dVar);
                    cVar.f29463d = a(dVar);
                    cVar.f29464e = a(dVar);
                    cVar.f29465f = a(dVar);
                    try {
                        dVar.b();
                    } catch (Exception unused) {
                    }
                    return cVar;
                } catch (Throwable th5) {
                    try {
                        dVar.b();
                    } catch (Exception unused2) {
                    }
                    throw th5;
                }
            } catch (Exception e16) {
                if (e16 instanceof b) {
                    throw e16;
                }
                throw new b("ProcStatReader error: " + e16.getClass().getName() + ", " + e16.getMessage());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class b extends Exception {
        public b(String str) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f29460a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f29461b = "_";

        /* renamed from: c, reason: collision with root package name */
        public long f29462c = -1;

        /* renamed from: d, reason: collision with root package name */
        public long f29463d = -1;

        /* renamed from: e, reason: collision with root package name */
        public long f29464e = -1;

        /* renamed from: f, reason: collision with root package name */
        public long f29465f = -1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:42:0x0052. Please report as an issue. */
    public static c a(String str, byte[] bArr) {
        int i3;
        int i16;
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                i3 = fileInputStream.read(bArr);
                fileInputStream.close();
            } finally {
            }
        } catch (IOException e16) {
            com.tencent.mobileqq.qqbattery.utils.a.d("QQBattery_ProcStatUtil", e16, "read buffer from file fail", new Object[0]);
            i3 = -1;
        }
        if (i3 <= 0) {
            return null;
        }
        c cVar = new c();
        int length = bArr.length;
        int i17 = 0;
        int i18 = 0;
        while (i17 < length) {
            if (Character.isSpaceChar(bArr[i17])) {
                i18++;
            } else if (i18 != 1) {
                if (i18 != 3) {
                    switch (i18) {
                        case 14:
                            int i19 = 0;
                            i16 = i17;
                            while (i16 < length && !Character.isSpaceChar(bArr[i16])) {
                                i16++;
                                i19++;
                            }
                            String b16 = b(bArr, i17, i19);
                            if (c(b16)) {
                                cVar.f29462c = i.d.c(b16);
                                break;
                            } else {
                                throw new b(b(bArr, 0, bArr.length) + "\nutime: " + b16);
                            }
                        case 15:
                            int i26 = 0;
                            i16 = i17;
                            while (i16 < length && !Character.isSpaceChar(bArr[i16])) {
                                i16++;
                                i26++;
                            }
                            String b17 = b(bArr, i17, i26);
                            if (c(b17)) {
                                cVar.f29463d = i.d.c(b17);
                                break;
                            } else {
                                throw new b(b(bArr, 0, bArr.length) + "\nstime: " + b17);
                            }
                        case 16:
                            int i27 = 0;
                            i16 = i17;
                            while (i16 < length && !Character.isSpaceChar(bArr[i16])) {
                                i16++;
                                i27++;
                            }
                            String b18 = b(bArr, i17, i27);
                            if (c(b18)) {
                                cVar.f29464e = i.d.c(b18);
                                break;
                            } else {
                                throw new b(b(bArr, 0, bArr.length) + "\ncutime: " + b18);
                            }
                        case 17:
                            int i28 = 0;
                            i16 = i17;
                            while (i16 < length && !Character.isSpaceChar(bArr[i16])) {
                                i16++;
                                i28++;
                            }
                            String b19 = b(bArr, i17, i28);
                            if (c(b19)) {
                                cVar.f29465f = i.d.c(b19);
                                break;
                            } else {
                                throw new b(b(bArr, 0, bArr.length) + "\ncstime: " + b19);
                            }
                    }
                } else {
                    int i29 = 0;
                    i16 = i17;
                    while (i16 < length && !Character.isSpaceChar(bArr[i16])) {
                        i16++;
                        i29++;
                    }
                    cVar.f29461b = b(bArr, i17, i29);
                }
                i17 = i16;
            } else {
                int i36 = 0;
                int i37 = i17;
                while (i37 < length && 41 != bArr[i37]) {
                    i37++;
                    i36++;
                }
                if (40 == bArr[i17]) {
                    i17++;
                    i36--;
                }
                if (41 == bArr[(i17 + i36) - 1]) {
                    i36--;
                }
                if (i36 > 0) {
                    cVar.f29460a = b(bArr, i17, i36);
                }
                int i38 = i37;
                i18 = 2;
                i17 = i38;
            }
            i17++;
        }
        return cVar;
    }

    public static String b(byte[] bArr, int i3, int i16) {
        try {
            CharBuffer decode = StandardCharsets.UTF_8.decode(ByteBuffer.wrap(bArr, i3, i16));
            return String.valueOf(decode.array(), 0, decode.limit());
        } catch (IndexOutOfBoundsException e16) {
            StringBuilder a16 = g.a("#safeBytesToString failed: ");
            a16.append(e16.getMessage());
            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_ProcStatUtil", a16.toString(), new Object[0]);
            return "";
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("-")) {
            return TextUtils.isDigitsOnly(str.substring(1));
        }
        return TextUtils.isDigitsOnly(str);
    }

    public static c d(String str) {
        c cVar;
        try {
            try {
                try {
                    ThreadLocal<byte[]> threadLocal = f29459a;
                    if (threadLocal.get() == null) {
                        threadLocal.set(new byte[128]);
                    }
                    cVar = a.b(str, threadLocal.get());
                } catch (Throwable th5) {
                    StringBuilder a16 = g.a("#parseJiffies fail: ");
                    a16.append(th5.getMessage());
                    com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_ProcStatUtil", a16.toString(), new Object[0]);
                    return null;
                }
            } catch (b unused) {
                ThreadLocal<byte[]> threadLocal2 = f29459a;
                if (threadLocal2.get() == null) {
                    threadLocal2.set(new byte[128]);
                }
                cVar = a(str, threadLocal2.get());
            }
        } catch (b unused2) {
            cVar = null;
        }
        if (cVar == null || cVar.f29460a == null) {
            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_ProcStatUtil", "#parseJiffies read with buffer fail, fallback with spilts", new Object[0]);
            try {
                cVar = e(i.d.b(str));
            } catch (b unused3) {
            }
            if (cVar != null) {
                if (cVar.f29460a == null) {
                }
            }
            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_ProcStatUtil", "#parseJiffies read with splits fail", new Object[0]);
            return null;
        }
        return cVar;
    }

    public static c e(String str) {
        c cVar = new c();
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(")");
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                cVar.f29460a = substring.substring(substring.indexOf("(") + 1, indexOf);
                String[] split = str.substring(indexOf + 1).split(" ");
                if (c(split[12])) {
                    if (c(split[13])) {
                        if (c(split[14])) {
                            if (c(split[15])) {
                                cVar.f29461b = split[1];
                                cVar.f29462c = i.d.c(split[12]);
                                cVar.f29463d = i.d.c(split[13]);
                                cVar.f29464e = i.d.c(split[14]);
                                cVar.f29465f = i.d.c(split[15]);
                            } else {
                                throw new b(str + "\ncstime: " + split[15]);
                            }
                        } else {
                            throw new b(str + "\ncutime: " + split[14]);
                        }
                    } else {
                        throw new b(str + "\nstime: " + split[13]);
                    }
                } else {
                    throw new b(str + "\nutime: " + split[12]);
                }
            } else {
                throw new IllegalStateException(str + " has not ')'");
            }
        }
        return cVar;
    }
}
