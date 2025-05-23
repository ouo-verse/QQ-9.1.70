package com.tencent.mobileqq.persistence;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010?\u001a\u00020\u0001\u00a2\u0006\u0004\b@\u0010AJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\t\u0010\t\u001a\u00020\u0007H\u0097\u0001J\u0019\u0010\u000b\u001a\n \u0005*\u0004\u0018\u00010\n0\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\t\u0010\f\u001a\u00020\u0002H\u0096\u0001J\u0019\u0010\u000e\u001a\u00020\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\r0\rH\u0096\u0001J\u0019\u0010\u000f\u001a\u00020\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\r0\rH\u0096\u0001J\u0019\u0010\u0010\u001a\n \u0005*\u0004\u0018\u00010\r0\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J6\u0010\u0012\u001a(\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\r0\r \u0005*\u0014\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00010\r0\r\u0018\u00010\u00110\u0011H\u0096\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\u0018\u001a\n \u0005*\u0004\u0018\u00010\u00170\u0017H\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\u001f\u001a\n \u0005*\u0004\u0018\u00010\u001e0\u001eH\u0096\u0001J\t\u0010 \u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\"\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0019\u0010#\u001a\n \u0005*\u0004\u0018\u00010\r0\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010$\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\t\u0010&\u001a\u00020%H\u0096\u0001J\t\u0010'\u001a\u00020%H\u0096\u0001J\t\u0010(\u001a\u00020%H\u0096\u0001J\t\u0010)\u001a\u00020%H\u0096\u0001J\t\u0010*\u001a\u00020%H\u0096\u0001J\t\u0010+\u001a\u00020%H\u0096\u0001J\u0011\u0010,\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010-\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\t\u0010.\u001a\u00020%H\u0096\u0001J\t\u0010/\u001a\u00020%H\u0096\u0001J\t\u00100\u001a\u00020%H\u0096\u0001J\u0011\u00101\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\t\u00102\u001a\u00020%H\u0096\u0001J\u0019\u00104\u001a\u00020\u00072\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010303H\u0096\u0001J\u0019\u00106\u001a\u00020\u00072\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010505H\u0096\u0001J\t\u00107\u001a\u00020%H\u0097\u0001J!\u00108\u001a\n \u0005*\u0004\u0018\u00010\u00170\u00172\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00170\u0017H\u0096\u0001J\u0019\u00109\u001a\u00020\u00072\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00170\u0017H\u0096\u0001J)\u0010;\u001a\u00020\u00072\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010:0:2\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u001e0\u001eH\u0096\u0001J\u0019\u0010<\u001a\u00020\u00072\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010303H\u0096\u0001J\u0019\u0010=\u001a\u00020\u00072\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010505H\u0096\u0001J\b\u0010>\u001a\u00020\u0007H\u0016\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/persistence/a;", "Landroid/database/Cursor;", "", "p0", "Landroid/database/CharArrayBuffer;", "kotlin.jvm.PlatformType", "p1", "", "copyStringToBuffer", "deactivate", "", "getBlob", "getColumnCount", "", "getColumnIndex", "getColumnIndexOrThrow", "getColumnName", "", "getColumnNames", "()[Ljava/lang/String;", "getCount", "", "getDouble", "Landroid/os/Bundle;", "getExtras", "", "getFloat", "getInt", "", "getLong", "Landroid/net/Uri;", "getNotificationUri", "getPosition", "", "getShort", "getString", "getType", "", "getWantsAllOnMoveCalls", "isAfterLast", "isBeforeFirst", "isClosed", "isFirst", "isLast", "isNull", "move", "moveToFirst", "moveToLast", "moveToNext", "moveToPosition", "moveToPrevious", "Landroid/database/ContentObserver;", "registerContentObserver", "Landroid/database/DataSetObserver;", "registerDataSetObserver", "requery", "respond", "setExtras", "Landroid/content/ContentResolver;", "setNotificationUri", "unregisterContentObserver", "unregisterDataSetObserver", "close", "real", "<init>", "(Landroid/database/Cursor;)V", "mqq_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
final class a implements Cursor {

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ Cursor f258307d;

    public a(@NotNull Cursor real) {
        Intrinsics.checkNotNullParameter(real, "real");
        this.f258307d = real;
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("do not need close!!");
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int p06, CharArrayBuffer p16) {
        this.f258307d.copyStringToBuffer(p06, p16);
    }

    @Override // android.database.Cursor
    @Deprecated(message = "Deprecated in Java")
    public void deactivate() {
        this.f258307d.deactivate();
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int p06) {
        return this.f258307d.getBlob(p06);
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        return this.f258307d.getColumnCount();
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String p06) {
        return this.f258307d.getColumnIndex(p06);
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String p06) {
        return this.f258307d.getColumnIndexOrThrow(p06);
    }

    @Override // android.database.Cursor
    public String getColumnName(int p06) {
        return this.f258307d.getColumnName(p06);
    }

    @Override // android.database.Cursor
    public String[] getColumnNames() {
        return this.f258307d.getColumnNames();
    }

    @Override // android.database.Cursor
    public int getCount() {
        return this.f258307d.getCount();
    }

    @Override // android.database.Cursor
    public double getDouble(int p06) {
        return this.f258307d.getDouble(p06);
    }

    @Override // android.database.Cursor
    public Bundle getExtras() {
        return this.f258307d.getExtras();
    }

    @Override // android.database.Cursor
    public float getFloat(int p06) {
        return this.f258307d.getFloat(p06);
    }

    @Override // android.database.Cursor
    public int getInt(int p06) {
        return this.f258307d.getInt(p06);
    }

    @Override // android.database.Cursor
    public long getLong(int p06) {
        return this.f258307d.getLong(p06);
    }

    @Override // android.database.Cursor
    public Uri getNotificationUri() {
        return this.f258307d.getNotificationUri();
    }

    @Override // android.database.Cursor
    public int getPosition() {
        return this.f258307d.getPosition();
    }

    @Override // android.database.Cursor
    public short getShort(int p06) {
        return this.f258307d.getShort(p06);
    }

    @Override // android.database.Cursor
    public String getString(int p06) {
        return this.f258307d.getString(p06);
    }

    @Override // android.database.Cursor
    public int getType(int p06) {
        return this.f258307d.getType(p06);
    }

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        return this.f258307d.getWantsAllOnMoveCalls();
    }

    @Override // android.database.Cursor
    public boolean isAfterLast() {
        return this.f258307d.isAfterLast();
    }

    @Override // android.database.Cursor
    public boolean isBeforeFirst() {
        return this.f258307d.isBeforeFirst();
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        return this.f258307d.isClosed();
    }

    @Override // android.database.Cursor
    public boolean isFirst() {
        return this.f258307d.isFirst();
    }

    @Override // android.database.Cursor
    public boolean isLast() {
        return this.f258307d.isLast();
    }

    @Override // android.database.Cursor
    public boolean isNull(int p06) {
        return this.f258307d.isNull(p06);
    }

    @Override // android.database.Cursor
    public boolean move(int p06) {
        return this.f258307d.move(p06);
    }

    @Override // android.database.Cursor
    public boolean moveToFirst() {
        return this.f258307d.moveToFirst();
    }

    @Override // android.database.Cursor
    public boolean moveToLast() {
        return this.f258307d.moveToLast();
    }

    @Override // android.database.Cursor
    public boolean moveToNext() {
        return this.f258307d.moveToNext();
    }

    @Override // android.database.Cursor
    public boolean moveToPosition(int p06) {
        return this.f258307d.moveToPosition(p06);
    }

    @Override // android.database.Cursor
    public boolean moveToPrevious() {
        return this.f258307d.moveToPrevious();
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver p06) {
        this.f258307d.registerContentObserver(p06);
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver p06) {
        this.f258307d.registerDataSetObserver(p06);
    }

    @Override // android.database.Cursor
    @Deprecated(message = "Deprecated in Java")
    public boolean requery() {
        return this.f258307d.requery();
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle p06) {
        return this.f258307d.respond(p06);
    }

    @Override // android.database.Cursor
    public void setExtras(Bundle p06) {
        this.f258307d.setExtras(p06);
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver p06, Uri p16) {
        this.f258307d.setNotificationUri(p06, p16);
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver p06) {
        this.f258307d.unregisterContentObserver(p06);
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver p06) {
        this.f258307d.unregisterDataSetObserver(p06);
    }
}
