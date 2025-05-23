package com.tencent.mobileqq.dexasm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.AccessFlags;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.builder.instruction.BuilderInstruction35c;
import org.jf.dexlib2.builder.instruction.BuilderInstruction3rc;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.iface.instruction.ReferenceInstruction;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.iface.reference.TypeReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f203530a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16593);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f203530a = Pattern.compile("^L([a-zA-Z_$-][a-zA-Z\\d_$-]*/)*[a-zA-Z_$-][a-zA-Z\\d_$-]*;$");
        }
    }

    private static boolean a(Opcode opcode, String str) {
        if (opcode != Opcode.RETURN) {
            return false;
        }
        if (!h.f(str) && str.charAt(0) != 'V' && !h.g(str)) {
            return false;
        }
        return true;
    }

    private static boolean b(Opcode opcode, String str) {
        if (opcode == Opcode.RETURN_OBJECT && !h.f(str)) {
            return true;
        }
        return false;
    }

    private static boolean c(Opcode opcode, String str, Opcode opcode2) {
        if (opcode2 != Opcode.THROW && opcode == Opcode.RETURN_VOID && !"V".equals(str)) {
            return true;
        }
        return false;
    }

    private static boolean d(Opcode opcode, String str) {
        if (opcode == Opcode.RETURN_WIDE && !h.g(str)) {
            return true;
        }
        return false;
    }

    private static boolean e(char c16) {
        if (c16 == 'F' || c16 == 'L' || c16 == 'S' || c16 == 'Z' || c16 == 'I' || c16 == 'J') {
            return false;
        }
        switch (c16) {
            case 'B':
            case 'C':
            case 'D':
                return false;
            default:
                return true;
        }
    }

    private static boolean f(String str) {
        if (!"<init>".equals(str) && !"<clinit>".equals(str)) {
            return false;
        }
        return true;
    }

    public static void g(String str, int i3) {
        if (f(str) && (AccessFlags.CONSTRUCTOR.getValue() & i3) == 0) {
            throw new IllegalArgumentException("constructor's access flag is not marked");
        }
        if (!f(str) && (i3 & AccessFlags.CONSTRUCTOR.getValue()) != 0) {
            throw new IllegalArgumentException(str + " is marked constructor, but doesn't match name");
        }
    }

    public static void h(@Nonnull String str, @Nonnull Field field) {
        if (str.equals(field.getDefiningClass())) {
            return;
        }
        throw new IllegalArgumentException("filed " + field.getType() + " " + field.getName() + " defining class " + field.getDefiningClass() + " is not matching " + str);
    }

    public static void i(BuilderInstruction35c builderInstruction35c) {
        MethodReference methodReference = (MethodReference) builderInstruction35c.getReference();
        int registerCount = builderInstruction35c.getRegisterCount();
        int a16 = h.a(methodReference.getParameterTypes());
        if (builderInstruction35c.getOpcode() != Opcode.INVOKE_STATIC) {
            a16++;
        }
        if (registerCount == a16) {
            return;
        }
        throw new IllegalArgumentException(builderInstruction35c.getOpcode().name + " has " + registerCount + " register(s) but expect for " + a16);
    }

    public static void j(BuilderInstruction3rc builderInstruction3rc) {
        MethodReference methodReference = (MethodReference) builderInstruction3rc.getReference();
        int registerCount = builderInstruction3rc.getRegisterCount();
        int a16 = h.a(methodReference.getParameterTypes());
        if (builderInstruction3rc.getOpcode() != Opcode.INVOKE_STATIC_RANGE) {
            a16++;
        }
        if (registerCount == a16) {
            return;
        }
        throw new IllegalArgumentException(builderInstruction3rc.getOpcode().name + " has " + registerCount + " register(s) but expect for " + a16);
    }

    public static void k(BuilderInstruction builderInstruction) {
        if (builderInstruction instanceof BuilderInstruction35c) {
            BuilderInstruction35c builderInstruction35c = (BuilderInstruction35c) builderInstruction;
            if (builderInstruction35c.getReferenceType() != 3) {
                return;
            }
            i(builderInstruction35c);
            o(builderInstruction);
            return;
        }
        if (builderInstruction instanceof BuilderInstruction3rc) {
            BuilderInstruction3rc builderInstruction3rc = (BuilderInstruction3rc) builderInstruction;
            if (builderInstruction3rc.getReferenceType() != 3) {
                return;
            }
            j(builderInstruction3rc);
            o(builderInstruction);
        }
    }

    public static void l(String str) {
        if (str.length() == 1 && str.charAt(0) == 'V') {
            return;
        }
        n(str);
    }

    public static void m(Opcode opcode, String str, @Nullable Opcode opcode2) {
        if (!c(opcode, str, opcode2) && !b(opcode, str) && !a(opcode, str) && !d(opcode, str)) {
            return;
        }
        throw new IllegalArgumentException("opcode " + opcode.name + " not match type " + str);
    }

    public static void n(String str) {
        int i3 = 0;
        while (i3 < str.length() && str.charAt(i3) == '[') {
            i3++;
        }
        String substring = str.substring(i3);
        if (substring.length() == 1) {
            if (!e(substring.charAt(0))) {
                return;
            }
            throw new IllegalArgumentException("Illegal type descriptor: " + str);
        }
        if (f203530a.matcher(substring).matches()) {
            return;
        }
        throw new IllegalArgumentException("Illegal type descriptor: " + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void o(BuilderInstruction builderInstruction) {
        if (builderInstruction instanceof ReferenceInstruction) {
            ReferenceInstruction referenceInstruction = (ReferenceInstruction) builderInstruction;
            if (referenceInstruction.getReferenceType() == 1) {
                p((TypeReference) referenceInstruction.getReference());
            }
        }
    }

    public static void p(TypeReference typeReference) {
        n(typeReference.getType());
    }
}
