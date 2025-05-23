package com.huawei.hms.common.internal;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Objects {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class ToStringHelper {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f36870a;

        /* renamed from: b, reason: collision with root package name */
        private final Object f36871b;

        public final ToStringHelper add(String str, Object obj) {
            String str2 = (String) Preconditions.checkNotNull(str);
            String valueOf = String.valueOf(obj);
            StringBuilder sb5 = new StringBuilder(str2.length() + valueOf.length() + 1);
            sb5.append(str2);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(valueOf);
            this.f36870a.add(sb5.toString());
            return this;
        }

        public final String toString() {
            String simpleName = this.f36871b.getClass().getSimpleName();
            StringBuilder sb5 = new StringBuilder(100);
            sb5.append(simpleName);
            sb5.append('{');
            int size = this.f36870a.size();
            for (int i3 = 0; i3 < size; i3++) {
                sb5.append(this.f36870a.get(i3));
                if (i3 < size - 1) {
                    sb5.append(", ");
                }
            }
            sb5.append('}');
            return sb5.toString();
        }

        ToStringHelper(Object obj) {
            this.f36871b = Preconditions.checkNotNull(obj);
            this.f36870a = new ArrayList();
        }
    }

    Objects() {
        throw new AssertionError("Uninstantiable");
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj);
    }
}
