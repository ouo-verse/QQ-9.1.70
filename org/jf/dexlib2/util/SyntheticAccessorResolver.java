package org.jf.dexlib2.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.AccessFlags;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.instruction.ReferenceInstruction;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.iface.reference.Reference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SyntheticAccessorResolver {
    public static final int ADD_ASSIGNMENT = 7;
    public static final int AND_ASSIGNMENT = 12;
    public static final int DIV_ASSIGNMENT = 10;
    public static final int GETTER = 1;
    public static final int METHOD = 0;
    public static final int MUL_ASSIGNMENT = 9;
    public static final int OR_ASSIGNMENT = 13;
    public static final int POSTFIX_DECREMENT = 5;
    public static final int POSTFIX_INCREMENT = 3;
    public static final int PREFIX_DECREMENT = 6;
    public static final int PREFIX_INCREMENT = 4;
    public static final int REM_ASSIGNMENT = 11;
    public static final int SETTER = 2;
    public static final int SHL_ASSIGNMENT = 15;
    public static final int SHR_ASSIGNMENT = 16;
    public static final int SUB_ASSIGNMENT = 8;
    public static final int USHR_ASSIGNMENT = 17;
    public static final int XOR_ASSIGNMENT = 14;
    private final Map<String, ClassDef> classDefMap;
    private final Map<MethodReference, AccessedMember> resolvedAccessors = Maps.i();
    private final SyntheticAccessorFSM syntheticAccessorFSM;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class AccessedMember {

        @Nonnull
        public final Reference accessedMember;
        public final int accessedMemberType;

        public AccessedMember(int i3, @Nonnull Reference reference) {
            this.accessedMemberType = i3;
            this.accessedMember = reference;
        }
    }

    public SyntheticAccessorResolver(@Nonnull Opcodes opcodes, @Nonnull Iterable<? extends ClassDef> iterable) {
        this.syntheticAccessorFSM = new SyntheticAccessorFSM(opcodes);
        ImmutableMap.b builder = ImmutableMap.builder();
        for (ClassDef classDef : iterable) {
            builder.c(classDef.getType(), classDef);
        }
        this.classDefMap = builder.a();
    }

    public static boolean looksLikeSyntheticAccessor(String str) {
        return str.startsWith("access$");
    }

    private static boolean methodReferenceEquals(@Nonnull MethodReference methodReference, @Nonnull MethodReference methodReference2) {
        if (methodReference.getName().equals(methodReference2.getName()) && methodReference.getReturnType().equals(methodReference2.getReturnType()) && methodReference.getParameterTypes().equals(methodReference2.getParameterTypes())) {
            return true;
        }
        return false;
    }

    @Nullable
    public AccessedMember getAccessedMember(@Nonnull MethodReference methodReference) {
        Method method;
        MethodImplementation methodImplementation;
        ImmutableList copyOf;
        int test;
        AccessedMember accessedMember = this.resolvedAccessors.get(methodReference);
        if (accessedMember != null) {
            return accessedMember;
        }
        ClassDef classDef = this.classDefMap.get(methodReference.getDefiningClass());
        if (classDef == null) {
            return null;
        }
        Iterator<? extends Method> it = classDef.getMethods().iterator();
        while (true) {
            if (it.hasNext()) {
                method = it.next();
                methodImplementation = method.getImplementation();
                if (methodImplementation != null && methodReferenceEquals(method, methodReference)) {
                    break;
                }
            } else {
                method = null;
                methodImplementation = null;
                break;
            }
        }
        if (method == null || !AccessFlags.SYNTHETIC.isSet(method.getAccessFlags()) || (test = this.syntheticAccessorFSM.test((copyOf = ImmutableList.copyOf(methodImplementation.getInstructions())))) < 0) {
            return null;
        }
        AccessedMember accessedMember2 = new AccessedMember(test, ((ReferenceInstruction) copyOf.get(0)).getReference());
        this.resolvedAccessors.put(methodReference, accessedMember2);
        return accessedMember2;
    }
}
