package com.tencent.qqlive.module.videoreport.storage.annotation;

import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public class FieldMember implements Member {
    private Field field;

    public FieldMember(Field field) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        this.field = field;
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.annotation.Member
    public Object getValue(Object obj) {
        try {
            return this.field.get(obj);
        } catch (IllegalAccessException e16) {
            throw new RuntimeException(e16);
        } catch (IllegalArgumentException e17) {
            throw new RuntimeException(e17);
        }
    }
}
