package org.jf.util;

import com.google.common.base.Functions;
import com.google.common.base.d;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CharSequenceUtils {
    private static final d<Object, String> TO_STRING = Functions.a();

    public static boolean listEquals(List<? extends CharSequence> list, List<? extends CharSequence> list2) {
        d<Object, String> dVar = TO_STRING;
        return Lists.n(list, dVar).equals(Lists.n(list2, dVar));
    }

    public static int listHashCode(List<? extends CharSequence> list) {
        return Lists.n(list, TO_STRING).hashCode();
    }
}
