package org.jf.dexlib2.util;

import com.google.common.base.k;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.AccessFlags;
import org.jf.dexlib2.iface.Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FieldUtil {
    public static k<Field> FIELD_IS_STATIC = new k<Field>() { // from class: org.jf.dexlib2.util.FieldUtil.1
        @Override // com.google.common.base.k
        public boolean apply(@Nullable Field field) {
            return field != null && FieldUtil.isStatic(field);
        }
    };
    public static k<Field> FIELD_IS_INSTANCE = new k<Field>() { // from class: org.jf.dexlib2.util.FieldUtil.2
        @Override // com.google.common.base.k
        public boolean apply(@Nullable Field field) {
            return (field == null || FieldUtil.isStatic(field)) ? false : true;
        }
    };

    FieldUtil() {
    }

    public static boolean isStatic(@Nonnull Field field) {
        return AccessFlags.STATIC.isSet(field.getAccessFlags());
    }
}
