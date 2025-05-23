package com.tencent.mobileqq.qcircle.api.db;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.AssertUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c extends CursorWrapper {

    /* renamed from: d, reason: collision with root package name */
    private boolean f261657d;

    /* renamed from: e, reason: collision with root package name */
    private String f261658e;

    public c(Cursor cursor, String str) {
        super(cursor);
        boolean z16;
        this.f261658e = str;
        if (cursor != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        AssertUtils.assertTrue(z16);
    }

    private void a(Throwable th5) {
        DbCacheExceptionHandler.b().c(th5, this.f261658e);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
            this.f261657d = true;
        } catch (Throwable th5) {
            a(th5);
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public void copyStringToBuffer(int i3, CharArrayBuffer charArrayBuffer) {
        try {
            super.copyStringToBuffer(i3, charArrayBuffer);
        } catch (Throwable th5) {
            a(th5);
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public void deactivate() {
        try {
            super.deactivate();
        } catch (Throwable th5) {
            a(th5);
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public byte[] getBlob(int i3) {
        try {
            return super.getBlob(i3);
        } catch (Throwable th5) {
            a(th5);
            return null;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getColumnCount() {
        try {
            return super.getColumnCount();
        } catch (Throwable th5) {
            a(th5);
            return 0;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getColumnIndex(String str) {
        try {
            return super.getColumnIndex(str);
        } catch (Throwable th5) {
            a(th5);
            return -1;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
        try {
            return super.getColumnIndexOrThrow(str);
        } catch (Throwable th5) {
            a(th5);
            return -1;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public String getColumnName(int i3) {
        try {
            return super.getColumnName(i3);
        } catch (Throwable th5) {
            a(th5);
            return null;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public String[] getColumnNames() {
        try {
            return super.getColumnNames();
        } catch (Throwable th5) {
            a(th5);
            return null;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getCount() {
        try {
            return super.getCount();
        } catch (Throwable th5) {
            a(th5);
            return 0;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public double getDouble(int i3) {
        try {
            return Double.parseDouble(wd2.a.f(super.getString(i3)));
        } catch (Throwable th5) {
            a(th5);
            return 0.0d;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public Bundle getExtras() {
        try {
            return super.getExtras();
        } catch (Throwable th5) {
            a(th5);
            return null;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public float getFloat(int i3) {
        try {
            return Float.parseFloat(wd2.a.f(super.getString(i3)));
        } catch (Throwable th5) {
            a(th5);
            return 0.0f;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getInt(int i3) {
        try {
            String f16 = wd2.a.f(super.getString(i3));
            if (TextUtils.isEmpty(f16)) {
                return 0;
            }
            return Integer.parseInt(f16);
        } catch (Throwable th5) {
            a(th5);
            return 0;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public long getLong(int i3) {
        try {
            return Long.parseLong(wd2.a.f(super.getString(i3)));
        } catch (Throwable th5) {
            a(th5);
            return 0L;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getPosition() {
        try {
            return super.getPosition();
        } catch (Throwable th5) {
            a(th5);
            return -1;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public short getShort(int i3) {
        try {
            return super.getShort(i3);
        } catch (Throwable th5) {
            a(th5);
            return (short) 0;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public String getString(int i3) {
        try {
            return wd2.a.f(super.getString(i3));
        } catch (Throwable th5) {
            a(th5);
            return null;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    @SuppressLint({"NewApi"})
    public int getType(int i3) {
        try {
            return super.getType(i3);
        } catch (Throwable th5) {
            a(th5);
            return 0;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        try {
            return super.getWantsAllOnMoveCalls();
        } catch (Throwable th5) {
            a(th5);
            return false;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean isAfterLast() {
        try {
            return super.isAfterLast();
        } catch (Throwable th5) {
            a(th5);
            return false;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean isBeforeFirst() {
        try {
            return super.isBeforeFirst();
        } catch (Throwable th5) {
            a(th5);
            return false;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean isClosed() {
        try {
            return super.isClosed();
        } catch (Throwable th5) {
            a(th5);
            return this.f261657d;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean isFirst() {
        try {
            return super.isFirst();
        } catch (Throwable th5) {
            a(th5);
            return false;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean isLast() {
        try {
            return super.isLast();
        } catch (Throwable th5) {
            a(th5);
            return false;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean isNull(int i3) {
        try {
            return super.isNull(i3);
        } catch (Throwable th5) {
            a(th5);
            return true;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean move(int i3) {
        try {
            return super.move(i3);
        } catch (Throwable th5) {
            a(th5);
            return false;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean moveToFirst() {
        try {
            return super.moveToFirst();
        } catch (Throwable th5) {
            a(th5);
            return false;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean moveToLast() {
        try {
            return super.moveToLast();
        } catch (Throwable th5) {
            a(th5);
            return false;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean moveToNext() {
        try {
            return super.moveToNext();
        } catch (Throwable th5) {
            a(th5);
            return false;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean moveToPosition(int i3) {
        try {
            return super.moveToPosition(i3);
        } catch (Throwable th5) {
            a(th5);
            return false;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean moveToPrevious() {
        try {
            return super.moveToPrevious();
        } catch (Throwable th5) {
            a(th5);
            return false;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        try {
            super.registerContentObserver(contentObserver);
        } catch (Throwable th5) {
            a(th5);
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        try {
            super.registerDataSetObserver(dataSetObserver);
        } catch (Throwable th5) {
            a(th5);
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean requery() {
        try {
            return super.requery();
        } catch (Throwable th5) {
            a(th5);
            return false;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public Bundle respond(Bundle bundle) {
        try {
            return super.respond(bundle);
        } catch (Throwable th5) {
            a(th5);
            return null;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        try {
            super.setNotificationUri(contentResolver, uri);
        } catch (Throwable th5) {
            a(th5);
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
        try {
            super.unregisterContentObserver(contentObserver);
        } catch (Throwable th5) {
            a(th5);
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        try {
            super.unregisterDataSetObserver(dataSetObserver);
        } catch (Throwable th5) {
            a(th5);
        }
    }
}
