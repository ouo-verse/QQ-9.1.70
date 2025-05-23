package com.tencent.wcdb;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.wcdb.support.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class a implements e {
    static IPatchRedirector $redirector_;
    private Uri C;
    private final Object D;
    private ContentObserver E;
    private boolean F;
    private final DataSetObservable G;
    private final ContentObservable H;
    private Bundle I;

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    protected HashMap<Long, Map<String, Object>> f384299d;

    /* renamed from: e, reason: collision with root package name */
    protected int f384300e;

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    protected int f384301f;

    /* renamed from: h, reason: collision with root package name */
    @Deprecated
    protected Long f384302h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f384303i;

    /* renamed from: m, reason: collision with root package name */
    protected ContentResolver f384304m;

    /* compiled from: P */
    /* renamed from: com.tencent.wcdb.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    protected static class C10043a extends ContentObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<a> f384305a;

        public C10043a(a aVar) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            } else {
                this.f384305a = new WeakReference<>(aVar);
            }
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            a aVar = this.f384305a.get();
            if (aVar != null) {
                aVar.b(false);
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.D = new Object();
        this.G = new DataSetObservable();
        this.H = new ContentObservable();
        this.I = Bundle.EMPTY;
        this.f384300e = -1;
        this.f384301f = -1;
        this.f384302h = null;
        this.f384299d = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
        } else if (-1 != this.f384300e && getCount() != this.f384300e) {
        } else {
            throw new CursorIndexOutOfBoundsException(this.f384300e, getCount());
        }
    }

    protected void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, z16);
            return;
        }
        synchronized (this.D) {
            this.H.dispatchChange(z16);
            Uri uri = this.C;
            if (uri != null && z16) {
                this.f384304m.notifyChange(uri, this.E);
            }
        }
    }

    @Override // com.tencent.wcdb.e, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.f384303i = true;
        this.H.unregisterAll();
        d();
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int i3, CharArrayBuffer charArrayBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) charArrayBuffer);
            return;
        }
        String string = getString(i3);
        if (string != null) {
            char[] cArr = charArrayBuffer.data;
            if (cArr != null && cArr.length >= string.length()) {
                string.getChars(0, string.length(), cArr, 0);
            } else {
                charArrayBuffer.data = string.toCharArray();
            }
            charArrayBuffer.sizeCopied = string.length();
            return;
        }
        charArrayBuffer.sizeCopied = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ContentObserver contentObserver = this.E;
        if (contentObserver != null) {
            this.f384304m.unregisterContentObserver(contentObserver);
            this.F = false;
        }
        this.G.notifyInvalidated();
    }

    @Override // android.database.Cursor
    public void deactivate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finalize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        ContentObserver contentObserver = this.E;
        if (contentObserver != null && this.F) {
            this.f384304m.unregisterContentObserver(contentObserver);
        }
        try {
            if (!this.f384303i) {
                close();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        throw new UnsupportedOperationException("getBlob is not supported");
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return getColumnNames().length;
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this, (Object) str)).intValue();
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            Log.b("Cursor", "requesting column name with table name -- " + str, new Exception());
            str = str.substring(lastIndexOf + 1);
        }
        String[] columnNames = getColumnNames();
        int length = columnNames.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (columnNames[i3].equalsIgnoreCase(str)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this, (Object) str)).intValue();
        }
        int columnIndex = getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist");
    }

    @Override // android.database.Cursor
    public String getColumnName(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this, i3);
        }
        return getColumnNames()[i3];
    }

    @Override // android.database.Cursor
    public abstract String[] getColumnNames();

    @Override // android.database.Cursor
    public abstract int getCount();

    @Override // android.database.Cursor
    public Bundle getExtras() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (Bundle) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.I;
    }

    @Override // android.database.Cursor
    public abstract long getLong(int i3);

    @Override // android.database.Cursor
    public Uri getNotificationUri() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (Uri) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return this.C;
    }

    @Override // android.database.Cursor
    public final int getPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.f384300e;
    }

    @Override // com.tencent.wcdb.e, android.database.Cursor
    public abstract String getString(int i3);

    @Override // android.database.Cursor
    public int getType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this, i3)).intValue();
        }
        return 3;
    }

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.database.Cursor
    public final boolean isAfterLast() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        if (getCount() == 0 || this.f384300e == getCount()) {
            return true;
        }
        return false;
    }

    @Override // android.database.Cursor
    public final boolean isBeforeFirst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        if (getCount() == 0 || this.f384300e == -1) {
            return true;
        }
        return false;
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f384303i;
    }

    @Override // android.database.Cursor
    public final boolean isFirst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        if (this.f384300e == 0 && getCount() != 0) {
            return true;
        }
        return false;
    }

    @Override // android.database.Cursor
    public final boolean isLast() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        int count = getCount();
        if (this.f384300e == count - 1 && count != 0) {
            return true;
        }
        return false;
    }

    @Override // android.database.Cursor
    public final boolean move(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, i3)).booleanValue();
        }
        return moveToPosition(this.f384300e + i3);
    }

    @Override // android.database.Cursor
    public final boolean moveToFirst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return moveToPosition(0);
    }

    @Override // android.database.Cursor
    public final boolean moveToLast() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return moveToPosition(getCount() - 1);
    }

    @Override // com.tencent.wcdb.e, android.database.Cursor
    public final boolean moveToNext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return moveToPosition(this.f384300e + 1);
    }

    @Override // android.database.Cursor
    public boolean moveToPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, i3)).booleanValue();
        }
        int count = getCount();
        if (i3 >= count) {
            this.f384300e = count;
            return false;
        }
        if (i3 < 0) {
            this.f384300e = -1;
            return false;
        }
        int i16 = this.f384300e;
        if (i3 == i16) {
            return true;
        }
        boolean onMove = onMove(i16, i3);
        if (!onMove) {
            this.f384300e = -1;
        } else {
            this.f384300e = i3;
            int i17 = this.f384301f;
            if (i17 != -1) {
                this.f384302h = Long.valueOf(getLong(i17));
            }
        }
        return onMove;
    }

    @Override // android.database.Cursor
    public final boolean moveToPrevious() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return moveToPosition(this.f384300e - 1);
    }

    public boolean onMove(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) contentObserver);
        } else {
            this.H.registerObserver(contentObserver);
        }
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) dataSetObserver);
        } else {
            this.G.registerObserver(dataSetObserver);
        }
    }

    @Override // android.database.Cursor
    public boolean requery() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        ContentObserver contentObserver = this.E;
        if (contentObserver != null && !this.F) {
            this.f384304m.registerContentObserver(this.C, true, contentObserver);
            this.F = true;
        }
        this.G.notifyChanged();
        return true;
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (Bundle) iPatchRedirector.redirect((short) 38, (Object) this, (Object) bundle);
        }
        return Bundle.EMPTY;
    }

    @Override // android.database.Cursor
    public void setExtras(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) bundle);
            return;
        }
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        this.I = bundle;
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) contentResolver, (Object) uri);
            return;
        }
        synchronized (this.D) {
            this.C = uri;
            this.f384304m = contentResolver;
            ContentObserver contentObserver = this.E;
            if (contentObserver != null) {
                contentResolver.unregisterContentObserver(contentObserver);
            }
            C10043a c10043a = new C10043a(this);
            this.E = c10043a;
            this.f384304m.registerContentObserver(this.C, true, c10043a);
            this.F = true;
        }
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) contentObserver);
        } else if (!this.f384303i) {
            this.H.unregisterObserver(contentObserver);
        }
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) dataSetObserver);
        } else {
            this.G.unregisterObserver(dataSetObserver);
        }
    }
}
