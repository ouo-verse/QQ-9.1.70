package com.tencent.qqlive.module.videoreport.storage.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MethodMember implements Member {
    private Method method;

    public MethodMember(Method method) {
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        this.method = method;
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.annotation.Member
    public Object getValue(Object obj) {
        try {
            return this.method.invoke(obj, new Object[0]);
        } catch (IllegalAccessException e16) {
            throw new RuntimeException(e16);
        } catch (IllegalArgumentException e17) {
            throw new RuntimeException(e17);
        } catch (InvocationTargetException e18) {
            throw new RuntimeException(e18);
        }
    }
}
