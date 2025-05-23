package com.tencent.mobileqq.persistence;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class CursorOpt implements Cursor {
    private Cursor mCursor;
    private HashMap<String, Integer> mMap = null;

    public CursorOpt(Cursor cursor) {
        this.mCursor = cursor;
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mCursor.close();
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int i3, CharArrayBuffer charArrayBuffer) {
        this.mCursor.copyStringToBuffer(i3, charArrayBuffer);
    }

    @Override // android.database.Cursor
    public void deactivate() {
        this.mCursor.deactivate();
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int i3) {
        return this.mCursor.getBlob(i3);
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        return this.mCursor.getColumnCount();
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String str) {
        if (this.mMap == null) {
            String[] columnNames = getColumnNames();
            HashMap<String, Integer> hashMap = new HashMap<>(columnNames.length);
            int length = columnNames.length;
            for (int i3 = 0; i3 < length; i3++) {
                hashMap.put(columnNames[i3], Integer.valueOf(i3));
            }
            this.mMap = hashMap;
        }
        Integer num = this.mMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
        return this.mCursor.getColumnIndexOrThrow(str);
    }

    @Override // android.database.Cursor
    public String getColumnName(int i3) {
        return this.mCursor.getColumnName(i3);
    }

    @Override // android.database.Cursor
    public String[] getColumnNames() {
        return this.mCursor.getColumnNames();
    }

    @Override // android.database.Cursor
    public int getCount() {
        return this.mCursor.getCount();
    }

    @Override // android.database.Cursor
    public double getDouble(int i3) {
        return this.mCursor.getDouble(i3);
    }

    @Override // android.database.Cursor
    public Bundle getExtras() {
        return this.mCursor.getExtras();
    }

    @Override // android.database.Cursor
    public float getFloat(int i3) {
        return this.mCursor.getFloat(i3);
    }

    @Override // android.database.Cursor
    public int getInt(int i3) {
        return this.mCursor.getInt(i3);
    }

    @Override // android.database.Cursor
    public long getLong(int i3) {
        return this.mCursor.getLong(i3);
    }

    @Override // android.database.Cursor
    public Uri getNotificationUri() {
        return null;
    }

    @Override // android.database.Cursor
    public int getPosition() {
        return this.mCursor.getPosition();
    }

    @Override // android.database.Cursor
    public short getShort(int i3) {
        return this.mCursor.getShort(i3);
    }

    @Override // android.database.Cursor
    public String getString(int i3) {
        return this.mCursor.getString(i3);
    }

    @Override // android.database.Cursor
    @TargetApi(11)
    public int getType(int i3) {
        return this.mCursor.getType(i3);
    }

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        return this.mCursor.getWantsAllOnMoveCalls();
    }

    @Override // android.database.Cursor
    public boolean isAfterLast() {
        return this.mCursor.isAfterLast();
    }

    @Override // android.database.Cursor
    public boolean isBeforeFirst() {
        return this.mCursor.isBeforeFirst();
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        return this.mCursor.isClosed();
    }

    @Override // android.database.Cursor
    public boolean isFirst() {
        return this.mCursor.isFirst();
    }

    @Override // android.database.Cursor
    public boolean isLast() {
        return this.mCursor.isLast();
    }

    @Override // android.database.Cursor
    public boolean isNull(int i3) {
        return this.mCursor.isNull(i3);
    }

    @Override // android.database.Cursor
    public boolean move(int i3) {
        return this.mCursor.move(i3);
    }

    @Override // android.database.Cursor
    public boolean moveToFirst() {
        return this.mCursor.moveToFirst();
    }

    @Override // android.database.Cursor
    public boolean moveToLast() {
        return this.mCursor.moveToLast();
    }

    @Override // android.database.Cursor
    public boolean moveToNext() {
        return this.mCursor.moveToNext();
    }

    @Override // android.database.Cursor
    public boolean moveToPosition(int i3) {
        return this.mCursor.moveToPosition(i3);
    }

    @Override // android.database.Cursor
    public boolean moveToPrevious() {
        return this.mCursor.moveToPrevious();
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        this.mCursor.registerContentObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mCursor.registerDataSetObserver(dataSetObserver);
    }

    @Override // android.database.Cursor
    @Deprecated
    public boolean requery() {
        return this.mCursor.requery();
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle bundle) {
        return this.mCursor.respond(bundle);
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        this.mCursor.setNotificationUri(contentResolver, uri);
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
        this.mCursor.unregisterContentObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mCursor.unregisterDataSetObserver(dataSetObserver);
    }

    @Override // android.database.Cursor
    public void setExtras(Bundle bundle) {
    }
}
