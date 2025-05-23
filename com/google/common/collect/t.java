package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class t {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(s<?, ?> sVar, @NullableDecl Object obj) {
        if (obj == sVar) {
            return true;
        }
        if (obj instanceof s) {
            return sVar.asMap().equals(((s) obj).asMap());
        }
        return false;
    }
}
