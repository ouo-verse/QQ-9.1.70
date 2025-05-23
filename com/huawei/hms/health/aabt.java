package com.huawei.hms.health;

import java.lang.reflect.Field;
import java.security.PrivilegedAction;

/* compiled from: P */
/* loaded from: classes2.dex */
final class aabt implements PrivilegedAction {
    final /* synthetic */ Field aab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aabt(Field field) {
        this.aab = field;
    }

    @Override // java.security.PrivilegedAction
    public Object run() {
        this.aab.setAccessible(true);
        return null;
    }
}
