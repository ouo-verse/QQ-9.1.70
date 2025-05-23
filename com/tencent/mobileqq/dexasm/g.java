package com.tencent.mobileqq.dexasm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.builder.instruction.BuilderInstruction11x;
import org.jf.dexlib2.builder.instruction.BuilderInstruction35c;
import org.jf.dexlib2.builder.instruction.BuilderInstruction3rc;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.iface.reference.Reference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Character, Opcode> f203505a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Character, Opcode> f203506b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16482);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap hashMap = new HashMap();
        f203505a = hashMap;
        Opcode opcode = Opcode.MOVE_RESULT;
        hashMap.put('I', opcode);
        hashMap.put('Z', opcode);
        hashMap.put('B', opcode);
        hashMap.put('S', opcode);
        hashMap.put('C', opcode);
        hashMap.put('F', opcode);
        Opcode opcode2 = Opcode.MOVE_RESULT_OBJECT;
        hashMap.put('L', opcode2);
        hashMap.put('[', opcode2);
        Opcode opcode3 = Opcode.MOVE_RESULT_WIDE;
        hashMap.put('D', opcode3);
        hashMap.put('J', opcode3);
        hashMap.put('V', null);
        HashMap hashMap2 = new HashMap();
        f203506b = hashMap2;
        Opcode opcode4 = Opcode.RETURN;
        hashMap2.put('I', opcode4);
        hashMap2.put('Z', opcode4);
        hashMap2.put('B', opcode4);
        hashMap2.put('S', opcode4);
        hashMap2.put('C', opcode4);
        hashMap2.put('F', opcode4);
        Opcode opcode5 = Opcode.RETURN_OBJECT;
        hashMap2.put('L', opcode5);
        hashMap2.put('[', opcode5);
        Opcode opcode6 = Opcode.RETURN_WIDE;
        hashMap2.put('D', opcode6);
        hashMap2.put('J', opcode6);
    }

    private static int[] a(int i3, int i16) {
        int[] iArr = new int[i16];
        for (int i17 = 0; i17 < i16; i17++) {
            iArr[i17] = i3 + i17;
        }
        return iArr;
    }

    @Nonnull
    public static BuilderInstruction35c b(Reference reference, int[] iArr, Opcode opcode) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int length = iArr.length;
        if (length > 0) {
            i3 = iArr[0];
        } else {
            i3 = 0;
        }
        if (length > 1) {
            i16 = iArr[1];
        } else {
            i16 = 0;
        }
        if (length > 2) {
            i17 = iArr[2];
        } else {
            i17 = 0;
        }
        if (length > 3) {
            i18 = iArr[3];
        } else {
            i18 = 0;
        }
        if (length > 4) {
            i19 = iArr[4];
        } else {
            i19 = 0;
        }
        return new BuilderInstruction35c(opcode, length, i3, i16, i17, i18, i19, reference);
    }

    @Nonnull
    public static BuilderInstruction c(Opcode opcode, MethodReference methodReference, int... iArr) {
        Format format = opcode.format;
        if (format == Format.Format35c) {
            return b(methodReference, iArr, opcode);
        }
        if (format == Format.Format3rc) {
            return new BuilderInstruction3rc(opcode, iArr[0], iArr.length, methodReference);
        }
        throw new IllegalArgumentException("opcode " + opcode.name + " is not a method instruction");
    }

    @Nullable
    public static BuilderInstruction11x d(String str, int i3) {
        Map<Character, Opcode> map = f203505a;
        if (map.containsKey(Character.valueOf(str.charAt(0)))) {
            Opcode opcode = map.get(Character.valueOf(str.charAt(0)));
            if (opcode == null) {
                return null;
            }
            return new BuilderInstruction11x(opcode, i3);
        }
        throw new IllegalArgumentException("not supported type: " + str);
    }

    @Nonnull
    public static BuilderInstruction e(MethodReference methodReference, int i3) {
        int a16 = h.a(methodReference.getParameterTypes());
        int[] a17 = a(i3, a16);
        if (a16 != 0 && (!o.a(i3) || !o.b(a16))) {
            return c(Opcode.INVOKE_STATIC_RANGE, methodReference, a17);
        }
        return c(Opcode.INVOKE_STATIC, methodReference, a17);
    }
}
