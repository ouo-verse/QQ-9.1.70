package org.jf.dexlib2;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.g;
import javax.annotation.Nonnull;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MethodHandleType {
    public static final int INSTANCE_GET = 3;
    public static final int INSTANCE_PUT = 2;
    public static final int INVOKE_CONSTRUCTOR = 6;
    public static final int INVOKE_DIRECT = 7;
    public static final int INVOKE_INSTANCE = 5;
    public static final int INVOKE_INTERFACE = 8;
    public static final int INVOKE_STATIC = 4;
    public static final int STATIC_GET = 1;
    public static final int STATIC_PUT = 0;
    private static final g<Integer, String> methodHandleTypeNames = new ImmutableBiMap.a().c(0, "static-put").c(1, "static-get").c(2, "instance-put").c(3, "instance-get").c(4, "invoke-static").c(5, "invoke-instance").c(6, "invoke-constructor").c(7, "invoke-direct").c(8, "invoke-interface").a();

    public static int getMethodHandleType(String str) {
        Integer num = methodHandleTypeNames.inverse().get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new ExceptionWithContext("Invalid method handle type: %s", str);
    }

    @Nonnull
    public static String toString(int i3) {
        String str = methodHandleTypeNames.get(Integer.valueOf(i3));
        if (str != null) {
            return str;
        }
        throw new InvalidMethodHandleTypeException(i3);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class InvalidMethodHandleTypeException extends ExceptionWithContext {
        private final int methodHandleType;

        public InvalidMethodHandleTypeException(int i3) {
            super("Invalid method handle type: %d", Integer.valueOf(i3));
            this.methodHandleType = i3;
        }

        public int getMethodHandleType() {
            return this.methodHandleType;
        }

        public InvalidMethodHandleTypeException(int i3, String str, Object... objArr) {
            super(str, objArr);
            this.methodHandleType = i3;
        }
    }
}
