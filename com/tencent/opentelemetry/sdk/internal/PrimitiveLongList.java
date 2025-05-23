package com.tencent.opentelemetry.sdk.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes22.dex */
public class PrimitiveLongList {
    static IPatchRedirector $redirector_;

    /* loaded from: classes22.dex */
    private static class LongListImpl extends AbstractList<Long> {
        static IPatchRedirector $redirector_;
        private final long[] values;

        LongListImpl(long[] jArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) jArr);
            } else {
                this.values = jArr;
            }
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@Nullable Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
            }
            if (!(obj instanceof LongListImpl)) {
                return super.equals(obj);
            }
            return Arrays.equals(this.values, ((LongListImpl) obj).values);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return Arrays.hashCode(this.values);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.values.length;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long get(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? Long.valueOf(this.values[i3]) : (Long) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }

    PrimitiveLongList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static long[] toArray(List<Long> list) {
        if (list instanceof LongListImpl) {
            return ((LongListImpl) list).values;
        }
        int size = list.size();
        long[] jArr = new long[size];
        for (int i3 = 0; i3 < size; i3++) {
            jArr[i3] = list.get(i3).longValue();
        }
        return jArr;
    }

    public static List<Long> wrap(long[] jArr) {
        return new LongListImpl(jArr);
    }
}
