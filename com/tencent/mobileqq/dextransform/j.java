package com.tencent.mobileqq.dextransform;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.IOUtils;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.dexlib2.iface.instruction.formats.Instruction35c;
import org.jf.dexlib2.iface.instruction.formats.Instruction3rc;
import org.jf.dexlib2.iface.reference.MethodReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f203561a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11990);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[Opcode.values().length];
            f203561a = iArr;
            try {
                iArr[Opcode.INVOKE_VIRTUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f203561a[Opcode.INVOKE_SUPER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f203561a[Opcode.INVOKE_DIRECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f203561a[Opcode.INVOKE_STATIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f203561a[Opcode.INVOKE_INTERFACE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f203561a[Opcode.INVOKE_VIRTUAL_RANGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f203561a[Opcode.INVOKE_SUPER_RANGE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f203561a[Opcode.INVOKE_DIRECT_RANGE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f203561a[Opcode.INVOKE_STATIC_RANGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f203561a[Opcode.INVOKE_INTERFACE_RANGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f203561a[Opcode.IGET.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f203561a[Opcode.IGET_WIDE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f203561a[Opcode.IGET_OBJECT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f203561a[Opcode.IGET_BOOLEAN.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f203561a[Opcode.IGET_BYTE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f203561a[Opcode.IGET_CHAR.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f203561a[Opcode.IGET_SHORT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f203561a[Opcode.SGET.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f203561a[Opcode.SGET_WIDE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f203561a[Opcode.SGET_OBJECT.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f203561a[Opcode.SGET_BOOLEAN.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f203561a[Opcode.SGET_BYTE.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f203561a[Opcode.SGET_CHAR.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f203561a[Opcode.SGET_SHORT.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f203561a[Opcode.IPUT.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f203561a[Opcode.IPUT_WIDE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f203561a[Opcode.IPUT_OBJECT.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f203561a[Opcode.IPUT_BOOLEAN.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f203561a[Opcode.IPUT_BYTE.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f203561a[Opcode.IPUT_CHAR.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f203561a[Opcode.IPUT_SHORT.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f203561a[Opcode.SPUT.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f203561a[Opcode.SPUT_WIDE.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f203561a[Opcode.SPUT_OBJECT.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f203561a[Opcode.SPUT_BOOLEAN.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f203561a[Opcode.SPUT_BYTE.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f203561a[Opcode.SPUT_CHAR.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                f203561a[Opcode.SPUT_SHORT.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
        }
    }

    public static String a(int i3) {
        if (i3 > 0) {
            if (i3 == 1) {
                return "classes.dex";
            }
            return String.format(Locale.getDefault(), "classes%d.dex", Integer.valueOf(i3));
        }
        throw new IllegalArgumentException("illegal dex index: " + i3);
    }

    public static String b(MethodReference methodReference) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append('(');
        Iterator<? extends CharSequence> it = methodReference.getParameterTypes().iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
        }
        sb5.append(')');
        sb5.append(methodReference.getReturnType());
        return sb5.toString();
    }

    public static int[] c(Instruction35c instruction35c) {
        int registerCount = instruction35c.getRegisterCount();
        int[] iArr = new int[registerCount];
        if (registerCount != 1) {
            if (registerCount != 2) {
                if (registerCount != 3) {
                    if (registerCount != 4) {
                        if (registerCount == 5) {
                            iArr[4] = instruction35c.getRegisterG();
                        }
                        return iArr;
                    }
                    iArr[3] = instruction35c.getRegisterF();
                }
                iArr[2] = instruction35c.getRegisterE();
            }
            iArr[1] = instruction35c.getRegisterD();
        }
        iArr[0] = instruction35c.getRegisterC();
        return iArr;
    }

    public static boolean d(Instruction instruction) {
        if (!e(instruction) && !h(instruction)) {
            return false;
        }
        return true;
    }

    public static boolean e(Instruction instruction) {
        switch (a.f203561a[instruction.getOpcode().ordinal()]) {
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                return true;
            default:
                return false;
        }
    }

    public static boolean f(Instruction instruction) {
        switch (a.f203561a[instruction.getOpcode().ordinal()]) {
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
                return true;
            default:
                return false;
        }
    }

    public static boolean g(Instruction instruction) {
        if (!f(instruction) && !i(instruction)) {
            return false;
        }
        return true;
    }

    public static boolean h(Instruction instruction) {
        switch (a.f203561a[instruction.getOpcode().ordinal()]) {
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                return true;
            default:
                return false;
        }
    }

    public static boolean i(Instruction instruction) {
        switch (a.f203561a[instruction.getOpcode().ordinal()]) {
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
                return true;
            default:
                return false;
        }
    }

    public static boolean j(File file) {
        try {
            new ZipFile(file).close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static BuilderInstruction k(BuilderInstruction builderInstruction, MethodReference methodReference) {
        switch (a.f203561a[builderInstruction.getOpcode().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return com.tencent.mobileqq.dexasm.g.b(methodReference, c((Instruction35c) builderInstruction), Opcode.INVOKE_STATIC);
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return com.tencent.mobileqq.dexasm.g.e(methodReference, ((Instruction3rc) builderInstruction).getStartRegister());
            default:
                return null;
        }
    }

    private static void l(ZipOutputStream zipOutputStream, File file, int i3) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                l(zipOutputStream, file2, i3);
            }
            return;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            byte[] bArr = new byte[4096];
            String path = file.getPath();
            String substring = path.substring(i3);
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(path), 4096);
            try {
                ZipEntry zipEntry = new ZipEntry(substring);
                zipEntry.setTime(file.lastModified());
                zipOutputStream.putNextEntry(zipEntry);
                while (true) {
                    int read = bufferedInputStream2.read(bArr, 0, 4096);
                    if (read != -1) {
                        zipOutputStream.write(bArr, 0, read);
                    } else {
                        IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                        return;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedInputStream = bufferedInputStream2;
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static boolean m(String str, String str2) {
        File file = new File(str);
        ZipOutputStream zipOutputStream = null;
        try {
            try {
                ZipOutputStream zipOutputStream2 = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str2)));
                try {
                    if (!file.isDirectory()) {
                        str = file.getParent();
                    }
                    l(zipOutputStream2, file, str.length() + 1);
                    IOUtils.closeQuietly((OutputStream) zipOutputStream2);
                    return true;
                } catch (IOException e16) {
                    e = e16;
                    zipOutputStream = zipOutputStream2;
                    com.tencent.mobileqq.nlog.c.b("Utils", "", e);
                    IOUtils.closeQuietly((OutputStream) zipOutputStream);
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    zipOutputStream = zipOutputStream2;
                    IOUtils.closeQuietly((OutputStream) zipOutputStream);
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
