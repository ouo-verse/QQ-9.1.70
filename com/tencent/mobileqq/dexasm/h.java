package com.tencent.mobileqq.dexasm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction35c;
import org.jf.dexlib2.iface.instruction.formats.Instruction3rc;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Character, Integer> f203507a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16508);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap hashMap = new HashMap();
        f203507a = hashMap;
        hashMap.put('I', 1);
        hashMap.put('Z', 1);
        hashMap.put('B', 1);
        hashMap.put('S', 1);
        hashMap.put('C', 1);
        hashMap.put('F', 1);
        hashMap.put('L', 1);
        hashMap.put('[', 1);
        hashMap.put('D', 2);
        hashMap.put('J', 2);
        hashMap.put('V', 0);
    }

    public static int a(List<? extends CharSequence> list) {
        Iterator<? extends CharSequence> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += d(it.next());
        }
        return i3;
    }

    public static int[] b(Instruction35c instruction35c) {
        int registerCount = instruction35c.getRegisterCount();
        int[] iArr = new int[registerCount];
        if (registerCount != 0) {
            if (registerCount != 1) {
                if (registerCount != 2) {
                    if (registerCount != 3) {
                        if (registerCount != 4) {
                            if (registerCount == 5) {
                                iArr[4] = instruction35c.getRegisterG();
                            } else {
                                throw new IllegalArgumentException("illegal register count " + registerCount);
                            }
                        }
                        iArr[3] = instruction35c.getRegisterF();
                    }
                    iArr[2] = instruction35c.getRegisterE();
                }
                iArr[1] = instruction35c.getRegisterD();
            }
            iArr[0] = instruction35c.getRegisterC();
        }
        return iArr;
    }

    public static int[] c(Instruction3rc instruction3rc) {
        int registerCount = instruction3rc.getRegisterCount();
        int[] iArr = new int[registerCount];
        for (int i3 = 0; i3 < registerCount; i3++) {
            iArr[i3] = instruction3rc.getStartRegister() + i3;
        }
        return iArr;
    }

    public static int d(CharSequence charSequence) {
        Map<Character, Integer> map = f203507a;
        if (map.containsKey(Character.valueOf(charSequence.charAt(0)))) {
            return map.get(Character.valueOf(charSequence.charAt(0))).intValue();
        }
        throw new IllegalArgumentException("unknown type: " + ((Object) charSequence));
    }

    public static boolean e(Opcode opcode) {
        if (opcode != Opcode.INVOKE_DIRECT && opcode != Opcode.INVOKE_DIRECT_RANGE) {
            return false;
        }
        return true;
    }

    public static boolean f(String str) {
        if (str.charAt(0) != 'L' && str.charAt(0) != '[') {
            return false;
        }
        return true;
    }

    public static boolean g(String str) {
        if (str.charAt(0) != 'J' && str.charAt(0) != 'D') {
            return false;
        }
        return true;
    }
}
