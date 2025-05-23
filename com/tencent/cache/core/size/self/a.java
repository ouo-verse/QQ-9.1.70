package com.tencent.cache.core.size.self;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f98804a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14425);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98804a = new a();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.cache.core.size.self.b
    public long a(@NotNull Object obj) {
        int coerceAtLeast;
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, obj)).longValue();
        }
        Intrinsics.checkNotNullParameter(obj, "obj");
        Class<?> cls = obj.getClass();
        int i18 = 2;
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            int i19 = 16;
            if (length != 0) {
                Class<?> type = obj.getClass().getComponentType();
                if (type != null && type.isPrimitive()) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    if (type.isPrimitive()) {
                        if (Intrinsics.areEqual(type, Boolean.TYPE) || Intrinsics.areEqual(type, Byte.TYPE)) {
                            i18 = 1;
                        } else if (!Intrinsics.areEqual(type, Character.TYPE) && !Intrinsics.areEqual(type, Short.TYPE)) {
                            if (!Intrinsics.areEqual(type, Float.TYPE) && !Intrinsics.areEqual(type, Integer.TYPE)) {
                                if (Intrinsics.areEqual(type, Double.TYPE) || Intrinsics.areEqual(type, Long.TYPE)) {
                                    i18 = 8;
                                } else {
                                    throw new IllegalStateException();
                                }
                            }
                        }
                        i17 = length * i18;
                    }
                    i18 = 4;
                    i17 = length * i18;
                } else {
                    i17 = length * 4;
                }
                i19 = 16 + i17;
            }
            int i26 = i19 % 8;
            if (i26 != 0) {
                i19 = (i19 + 8) - i26;
            }
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i19, 8);
        } else {
            ArrayDeque arrayDeque = new ArrayDeque();
            while (cls != null) {
                arrayDeque.push(cls);
                cls = cls.getSuperclass();
            }
            int i27 = 12;
            while (!arrayDeque.isEmpty()) {
                Object pop = arrayDeque.pop();
                Intrinsics.checkNotNullExpressionValue(pop, "classStack.pop()");
                int i28 = 0;
                int i29 = 0;
                int i36 = 0;
                int i37 = 0;
                int i38 = 0;
                for (Field f16 : ((Class) pop).getDeclaredFields()) {
                    Intrinsics.checkNotNullExpressionValue(f16, "f");
                    if (!Modifier.isStatic(f16.getModifiers())) {
                        Class<?> type2 = f16.getType();
                        Intrinsics.checkNotNullExpressionValue(type2, "f.type");
                        if (!type2.isPrimitive()) {
                            i29++;
                        } else {
                            Class<?> type3 = f16.getType();
                            if (Intrinsics.areEqual(type3, Boolean.TYPE) || Intrinsics.areEqual(type3, Byte.TYPE)) {
                                i36++;
                            } else if (Intrinsics.areEqual(type3, Character.TYPE) || Intrinsics.areEqual(type3, Short.TYPE)) {
                                i38++;
                            } else if (Intrinsics.areEqual(type3, Float.TYPE) || Intrinsics.areEqual(type3, Integer.TYPE)) {
                                i37++;
                            } else if (Intrinsics.areEqual(type3, Double.TYPE) || Intrinsics.areEqual(type3, Long.TYPE)) {
                                i28++;
                            } else {
                                throw new AssertionError();
                            }
                        }
                    }
                }
                if (i28 > 0 && (i16 = i27 % 8) != 0) {
                    int i39 = 8 - i16;
                    i27 += i39;
                    while (i39 >= 4 && i37 > 0) {
                        i39 -= 4;
                        i37--;
                    }
                    while (i39 >= 2 && i38 > 0) {
                        i39 -= 2;
                        i38--;
                    }
                    while (i39 >= 1 && i36 > 0) {
                        i39--;
                        i36--;
                    }
                    while (i39 >= 4 && i29 > 0) {
                        i39 -= 4;
                        i29--;
                    }
                }
                i27 = (i36 * 1) + (i38 * 2) + (i37 * 4) + (i28 * 8) + i27;
                if (i29 > 0) {
                    int i46 = i27 % 4;
                    if (i46 != 0) {
                        i27 = (i27 + 4) - i46;
                    }
                    i27 = (i29 * 4) + i27;
                }
                if (i28 + i37 + i38 + i36 + i29 > 0 && (i3 = i27 % 4) != 0 && i3 != 0) {
                    i27 = (i27 + 4) - i3;
                }
            }
            int i47 = i27 % 8;
            if (i47 != 0) {
                i27 = (i27 + 8) - i47;
            }
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i27, 8);
        }
        return coerceAtLeast;
    }
}
