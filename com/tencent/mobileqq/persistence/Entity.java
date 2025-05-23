package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class Entity {
    public static final int DETACHED = 1002;
    public static final int MANAGED = 1001;
    public static final int NEW = 1000;
    public static final int REMOVED = 1003;

    @notColumn
    int _status = 1000;

    @notColumn
    long _id = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public ContentValues createContentValues() {
        return null;
    }

    public Entity deepCopyByReflect() {
        try {
            Entity entity = (Entity) getClass().newInstance();
            if (entity != null) {
                for (Field field : getClass().getFields()) {
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    field.set(entity, field.get(this));
                }
                entity._status = 1000;
                entity.postRead();
                return entity;
            }
            return entity;
        } catch (Exception e16) {
            QLog.d("Entity", 1, " deepCopyByReflect:failed" + getClass().getName() + " exception e: = " + e16.getMessage());
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean entityByCursor(Cursor cursor) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Class<? extends Entity> getClassForTable() {
        return getClass();
    }

    public long getId() {
        return this._id;
    }

    public int getStatus() {
        return this._status;
    }

    public String getTableName() {
        return getClass().getSimpleName();
    }

    public void setId(long j3) {
        this._id = j3;
    }

    public void setStatus(int i3) {
        this._status = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postRead() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postwrite() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void prewrite() {
    }
}
