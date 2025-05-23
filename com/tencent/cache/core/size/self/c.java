package com.tencent.cache.core.size.self;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class c implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final c3.a f98805a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final c f98806b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14466);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98806b = new c();
            f98805a = new c3.a();
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.cache.core.size.self.b
    public long a(@NotNull Object obj) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int i3;
        int coerceAtLeast3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, obj)).longValue();
        }
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (obj.getClass().isArray()) {
            Class<?> cls = obj.getClass();
            c3.a aVar = f98805a;
            int length = (Array.getLength(obj) * aVar.b(cls)) + aVar.a(cls);
            int i16 = length % 8;
            if (i16 != 0) {
                length = (length + 8) - i16;
            }
            coerceAtLeast3 = RangesKt___RangesKt.coerceAtLeast(length, 8);
            return coerceAtLeast3;
        }
        for (Class<?> cls2 = obj.getClass(); cls2 != null; cls2 = cls2.getSuperclass()) {
            int i17 = -1;
            for (Field field : cls2.getDeclaredFields()) {
                Intrinsics.checkNotNullExpressionValue(field, "field");
                if (!Modifier.isStatic(field.getModifiers())) {
                    int c16 = (int) f98805a.c(field);
                    Class<?> type = field.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "field.type");
                    Intrinsics.checkNotNullParameter(type, "type");
                    if (type.isPrimitive()) {
                        if (Intrinsics.areEqual(type, Boolean.TYPE) || Intrinsics.areEqual(type, Byte.TYPE)) {
                            i3 = 1;
                        } else if (Intrinsics.areEqual(type, Character.TYPE) || Intrinsics.areEqual(type, Short.TYPE)) {
                            i3 = 2;
                        } else if (!Intrinsics.areEqual(type, Float.TYPE) && !Intrinsics.areEqual(type, Integer.TYPE)) {
                            if (Intrinsics.areEqual(type, Double.TYPE) || Intrinsics.areEqual(type, Long.TYPE)) {
                                i3 = 8;
                            } else {
                                throw new IllegalStateException();
                            }
                        }
                        i17 = RangesKt___RangesKt.coerceAtLeast(i17, c16 + i3);
                    }
                    i3 = 4;
                    i17 = RangesKt___RangesKt.coerceAtLeast(i17, c16 + i3);
                }
            }
            if (i17 > 0) {
                int i18 = i17 % 8;
                if (i18 != 0) {
                    i17 = (i17 + 8) - i18;
                }
                coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(i17, 8);
                return coerceAtLeast2;
            }
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(16, 8);
        return coerceAtLeast;
    }
}
