package com.tencent.wcdb;

import android.database.Cursor;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface e extends Cursor {
    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    void close();

    @Override // android.database.Cursor
    String getString(int i3);

    @Override // android.database.Cursor
    boolean moveToNext();
}
