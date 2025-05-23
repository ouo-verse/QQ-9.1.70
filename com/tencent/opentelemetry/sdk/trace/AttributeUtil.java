package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class AttributeUtil {
    static IPatchRedirector $redirector_;

    AttributeUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static <T> boolean allMatch(Iterable<T> iterable, Predicate<T> predicate) {
        boolean test;
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            test = predicate.test(it.next());
            if (!test) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object applyAttributeLengthLimit(Object obj, int i3) {
        if (i3 == Integer.MAX_VALUE) {
            return obj;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(applyAttributeLengthLimit(it.next(), i3));
            }
            return arrayList;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() >= i3) {
                return str.substring(0, i3);
            }
            return obj;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Attributes applyAttributesLimit(Attributes attributes, int i3, final int i16) {
        if (attributes.isEmpty() || attributes.size() <= i3) {
            if (i16 == Integer.MAX_VALUE) {
                return attributes;
            }
            if (allMatch(attributes.asMap().values(), new Predicate() { // from class: com.tencent.opentelemetry.sdk.trace.a
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean lambda$applyAttributesLimit$0;
                    lambda$applyAttributesLimit$0 = AttributeUtil.lambda$applyAttributesLimit$0(i16, obj);
                    return lambda$applyAttributesLimit$0;
                }
            })) {
                return attributes;
            }
        }
        AttributesBuilder a16 = com.tencent.opentelemetry.api.common.f.a();
        int i17 = 0;
        for (Map.Entry<AttributeKey<?>, Object> entry : attributes.asMap().entrySet()) {
            if (i17 >= i3) {
                break;
            }
            a16.put((AttributeKey<AttributeKey<?>>) entry.getKey(), (AttributeKey<?>) applyAttributeLengthLimit(entry.getValue(), i16));
            i17++;
        }
        return a16.build();
    }

    private static boolean isValidLength(Object obj, final int i3) {
        if (obj instanceof List) {
            return allMatch((List) obj, new Predicate() { // from class: com.tencent.opentelemetry.sdk.trace.b
                @Override // java.util.function.Predicate
                public final boolean test(Object obj2) {
                    boolean lambda$isValidLength$1;
                    lambda$isValidLength$1 = AttributeUtil.lambda$isValidLength$1(i3, obj2);
                    return lambda$isValidLength$1;
                }
            });
        }
        if (!(obj instanceof String) || ((String) obj).length() < i3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$applyAttributesLimit$0(int i3, Object obj) {
        return isValidLength(obj, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isValidLength$1(int i3, Object obj) {
        return isValidLength(obj, i3);
    }
}
