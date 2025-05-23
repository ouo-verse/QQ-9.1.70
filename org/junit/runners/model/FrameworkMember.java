package org.junit.runners.model;

import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import org.junit.runners.model.FrameworkMember;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class FrameworkMember<T extends FrameworkMember<T>> implements Annotatable {
    public abstract Class<?> getDeclaringClass();

    protected abstract int getModifiers();

    public abstract String getName();

    public abstract Class<?> getType();

    public boolean isPublic() {
        return Modifier.isPublic(getModifiers());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isShadowedBy(List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (isShadowedBy((FrameworkMember<T>) it.next())) {
                return true;
            }
        }
        return false;
    }

    abstract boolean isShadowedBy(T t16);

    public boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }
}
