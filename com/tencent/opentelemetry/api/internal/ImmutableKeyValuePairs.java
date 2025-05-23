package com.tencent.opentelemetry.api.internal;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableKeyValuePairs<K, V> {
    static IPatchRedirector $redirector_;
    private final Object[] data;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImmutableKeyValuePairs(Object[] objArr) {
        this(objArr, r0);
        Comparator naturalOrder;
        naturalOrder = Comparator.naturalOrder();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) objArr);
    }

    private static <K> int compareToNullSafe(@Nullable K k3, @Nullable K k16, Comparator<K> comparator) {
        if (k3 == null) {
            if (k16 == null) {
                return 0;
            }
            return -1;
        }
        if (k16 == null) {
            return 1;
        }
        return comparator.compare(k3, k16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <K> Object[] dedupe(Object[] objArr, Comparator<K> comparator) {
        Object obj = null;
        int i3 = 0;
        for (int i16 = 0; i16 < objArr.length; i16 += 2) {
            Object obj2 = objArr[i16];
            Object obj3 = objArr[i16 + 1];
            if (obj2 != null) {
                if (obj != null && comparator.compare(obj2, obj) == 0) {
                    i3 -= 2;
                }
                if (obj3 != null) {
                    int i17 = i3 + 1;
                    objArr[i3] = obj2;
                    i3 = i17 + 1;
                    objArr[i17] = obj3;
                    obj = obj2;
                }
            }
        }
        if (objArr.length != i3) {
            Object[] objArr2 = new Object[i3];
            System.arraycopy(objArr, 0, objArr2, 0, i3);
            return objArr2;
        }
        return objArr;
    }

    private static <K> void merge(Object[] objArr, int i3, int i16, int i17, Object[] objArr2, Comparator<K> comparator) {
        int i18 = i3;
        int i19 = i16;
        while (i3 < i17) {
            if (i18 < i16 - 1 && (i19 >= i17 - 1 || compareToNullSafe(objArr[i18], objArr[i19], comparator) <= 0)) {
                objArr2[i3] = objArr[i18];
                objArr2[i3 + 1] = objArr[i18 + 1];
                i18 += 2;
            } else {
                objArr2[i3] = objArr[i19];
                objArr2[i3 + 1] = objArr[i19 + 1];
                i19 += 2;
            }
            i3 += 2;
        }
    }

    private static void mergeSort(Object[] objArr, Comparator<?> comparator) {
        Object[] objArr2 = new Object[objArr.length];
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        splitAndMerge(objArr2, 0, objArr.length, objArr, comparator);
    }

    private static Object[] sortAndFilter(Object[] objArr, Comparator<?> comparator) {
        boolean z16;
        if (objArr.length % 2 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Utils.checkArgument(z16, "You must provide an even number of key/value pair arguments.");
        if (objArr.length == 0) {
            return objArr;
        }
        mergeSort(objArr, comparator);
        return dedupe(objArr, comparator);
    }

    private static void splitAndMerge(Object[] objArr, int i3, int i16, Object[] objArr2, Comparator<?> comparator) {
        if (i16 - i3 <= 2) {
            return;
        }
        int i17 = ((i16 + i3) / 4) * 2;
        splitAndMerge(objArr2, i3, i17, objArr, comparator);
        splitAndMerge(objArr2, i17, i16, objArr, comparator);
        merge(objArr, i3, i17, i16, objArr2, comparator);
    }

    public final Map<K, V> asMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return ReadOnlyArrayMap.wrap(data());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<Object> data() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return Arrays.asList(this.data);
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImmutableKeyValuePairs)) {
            return false;
        }
        return Arrays.equals(this.data, ((ImmutableKeyValuePairs) obj).data);
    }

    public final void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) biConsumer);
            return;
        }
        if (biConsumer == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            Object[] objArr = this.data;
            if (i3 < objArr.length) {
                biConsumer.accept(objArr[i3], objArr[i3 + 1]);
                i3 += 2;
            } else {
                return;
            }
        }
    }

    @Nullable
    public final V get(K k3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (V) iPatchRedirector.redirect((short) 7, (Object) this, (Object) k3);
        }
        if (k3 == null) {
            return null;
        }
        int i3 = 0;
        while (true) {
            Object[] objArr = this.data;
            if (i3 >= objArr.length) {
                return null;
            }
            if (k3.equals(objArr[i3])) {
                return (V) this.data[i3 + 1];
            }
            i3 += 2;
        }
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return Arrays.hashCode(this.data) ^ 1000003;
    }

    public final boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.data.length == 0) {
            return true;
        }
        return false;
    }

    public final int size() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.data.length / 2;
    }

    public String toString() {
        String obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder("{");
        int i3 = 0;
        while (true) {
            Object[] objArr = this.data;
            if (i3 >= objArr.length) {
                break;
            }
            Object obj2 = objArr[i3 + 1];
            if (obj2 instanceof String) {
                obj = '\"' + ((String) obj2) + '\"';
            } else {
                obj = obj2.toString();
            }
            sb5.append(this.data[i3]);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(obj);
            sb5.append(", ");
            i3 += 2;
        }
        if (sb5.length() > 1) {
            sb5.setLength(sb5.length() - 2);
        }
        sb5.append("}");
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImmutableKeyValuePairs(Object[] objArr, Comparator<?> comparator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.data = sortAndFilter(objArr, comparator);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) objArr, (Object) comparator);
        }
    }
}
