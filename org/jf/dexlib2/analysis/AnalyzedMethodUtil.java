package org.jf.dexlib2.analysis;

import javax.annotation.Nonnull;
import org.jf.dexlib2.AccessFlags;
import org.jf.dexlib2.analysis.util.TypeProtoUtils;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.util.MethodUtil;
import org.jf.dexlib2.util.TypeUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AnalyzedMethodUtil {
    public static boolean canAccess(@Nonnull TypeProto typeProto, @Nonnull Method method, boolean z16, boolean z17, boolean z18) {
        if (z16 && MethodUtil.isPackagePrivate(method) && !TypeUtils.getPackage(method.getDefiningClass()).equals(TypeUtils.getPackage(typeProto.getType()))) {
            return false;
        }
        if (z17 && (method.getAccessFlags() & AccessFlags.PROTECTED.getValue()) != 0 && !TypeProtoUtils.extendsFrom(typeProto, method.getDefiningClass())) {
            return false;
        }
        if (z18) {
            if (!TypeUtils.canAccessClass(typeProto.getType(), typeProto.getClassPath().getClassDef(method.getDefiningClass()))) {
                return false;
            }
            return true;
        }
        return true;
    }
}
