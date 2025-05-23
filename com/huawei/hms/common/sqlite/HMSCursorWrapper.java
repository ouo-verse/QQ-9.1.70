package com.huawei.hms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HMSCursorWrapper extends CursorWrapper implements CrossProcessCursor {

    /* renamed from: a, reason: collision with root package name */
    private AbstractWindowedCursor f36895a;

    public HMSCursorWrapper(Cursor cursor) {
        super(cursor);
        if (cursor != null) {
            if (cursor instanceof CursorWrapper) {
                Cursor wrappedCursor = ((CursorWrapper) cursor).getWrappedCursor();
                if (wrappedCursor != null) {
                    if (wrappedCursor instanceof AbstractWindowedCursor) {
                        this.f36895a = (AbstractWindowedCursor) wrappedCursor;
                        return;
                    }
                    throw new IllegalArgumentException("getWrappedCursor:" + wrappedCursor + " is not a subclass for CursorWrapper");
                }
                throw new IllegalArgumentException("getWrappedCursor cannot be null");
            }
            throw new IllegalArgumentException("cursor:" + cursor + " is not a subclass for CursorWrapper");
        }
        throw new IllegalArgumentException("cursor cannot be null");
    }

    @Override // android.database.CrossProcessCursor
    public void fillWindow(int i3, CursorWindow cursorWindow) {
        this.f36895a.fillWindow(i3, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    public CursorWindow getWindow() {
        return this.f36895a.getWindow();
    }

    @Override // android.database.CursorWrapper
    public Cursor getWrappedCursor() {
        return this.f36895a;
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int i3, int i16) {
        return this.f36895a.onMove(i3, i16);
    }

    public void setWindow(CursorWindow cursorWindow) {
        this.f36895a.setWindow(cursorWindow);
    }
}
