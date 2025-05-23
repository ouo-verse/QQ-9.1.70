package com.huawei.hms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.common.sqlite.HMSCursorWrapper;
import com.huawei.hms.support.log.HMSLog;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    private static final String TAG = "DataHolder";
    public static final String TYPE_BOOLEAN = "type_boolean";
    public static final String TYPE_BYTE_ARRAY = "type_byte_array";
    public static final String TYPE_DOUBLE = "type_double";
    public static final String TYPE_FLOAT = "type_float";
    public static final String TYPE_INT = "type_int";
    public static final String TYPE_LONG = "type_long";
    public static final String TYPE_STRING = "type_string";
    private String[] columns;
    private Bundle columnsBundle;
    private CursorWindow[] cursorWindows;
    private int dataCount;
    private boolean isInstance;
    private boolean mClosed;
    private Bundle metadata;
    private int[] perCursorCounts;
    private int statusCode;
    private int version;
    public static final Parcelable.Creator<DataHolder> CREATOR = new DataHolderCreator();
    private static final Builder BUILDER = new DataHolderBuilderCreator(new String[0], null);

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String[] f36824a;

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList<HashMap<String, Object>> f36825b;

        /* renamed from: c, reason: collision with root package name */
        private final String f36826c;

        /* renamed from: d, reason: collision with root package name */
        private final HashMap<Object, Integer> f36827d;

        public DataHolder build(int i3) {
            return new DataHolder(this, i3, (Bundle) null);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder setDataForContentValuesHashMap(HashMap<String, Object> hashMap) {
            int i3;
            boolean z16;
            Object obj;
            Preconditions.checkNotNull(hashMap, "contentValuesHashMap cannot be null");
            String str = this.f36826c;
            if (str != null && (obj = hashMap.get(str)) != null) {
                Integer num = this.f36827d.get(obj);
                if (num != null) {
                    i3 = num.intValue();
                    z16 = true;
                    if (!z16) {
                        this.f36825b.remove(i3);
                        this.f36825b.add(i3, hashMap);
                    } else {
                        this.f36825b.add(hashMap);
                    }
                    return this;
                }
                this.f36827d.put(obj, Integer.valueOf(this.f36825b.size()));
            }
            i3 = 0;
            z16 = false;
            if (!z16) {
            }
            return this;
        }

        public Builder withRow(ContentValues contentValues) {
            Preconditions.checkNotNull(contentValues, "contentValues cannot be null");
            HashMap<String, Object> hashMap = new HashMap<>(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return setDataForContentValuesHashMap(hashMap);
        }

        Builder(String[] strArr, String str) {
            Preconditions.checkNotNull(strArr, "builderColumnsP cannot be null");
            this.f36824a = strArr;
            this.f36825b = new ArrayList<>();
            this.f36826c = str;
            this.f36827d = new HashMap<>();
        }

        public DataHolder build(int i3, Bundle bundle) {
            return new DataHolder(this, i3, bundle, -1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(String[] strArr, String str, DataHolderBuilderCreator dataHolderBuilderCreator) {
            this(strArr, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class DataHolderException extends RuntimeException {
        public DataHolderException(String str) {
            super(str);
        }
    }

    public static Builder builder(String[] strArr) {
        return new Builder(strArr, (String) null);
    }

    private void checkAvailable(String str, int i3) {
        String str2;
        Bundle bundle = this.columnsBundle;
        if (bundle != null && bundle.containsKey(str)) {
            if (isClosed()) {
                str2 = "buffer has been closed";
            } else if (i3 >= 0 && i3 < this.dataCount) {
                str2 = "";
            } else {
                str2 = "row is out of index:" + i3;
            }
        } else {
            str2 = "cannot find column: " + str;
        }
        Preconditions.checkArgument(str2.isEmpty(), str2);
    }

    public static DataHolder empty(int i3) {
        return new DataHolder(BUILDER, i3, (Bundle) null);
    }

    private static CursorWindow[] getCursorWindows(HMSCursorWrapper hMSCursorWrapper) {
        int i3;
        ArrayList arrayList = new ArrayList();
        try {
            int count = hMSCursorWrapper.getCount();
            CursorWindow window = hMSCursorWrapper.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                i3 = 0;
            } else {
                window.acquireReference();
                hMSCursorWrapper.setWindow(null);
                arrayList.add(window);
                i3 = window.getNumRows();
            }
            arrayList.addAll(iterCursorWrapper(hMSCursorWrapper, i3, count));
            return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
        } catch (Throwable th5) {
            try {
                HMSLog.e(TAG, "fail to getCursorWindows: " + th5.getMessage());
                return new CursorWindow[0];
            } finally {
                hMSCursorWrapper.close();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b4, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ArrayList<CursorWindow> iterCursorWindow(Builder builder, int i3, List list) {
        ArrayList<CursorWindow> arrayList = new ArrayList<>();
        CursorWindow cursorWindow = new CursorWindow((String) null);
        cursorWindow.setNumColumns(builder.f36824a.length);
        arrayList.add(cursorWindow);
        int i16 = 0;
        while (true) {
            if (i16 >= i3) {
                break;
            }
            try {
                if (!cursorWindow.allocRow()) {
                    HMSLog.d(TAG, "Failed to allocate a row");
                    cursorWindow = new CursorWindow((String) null);
                    cursorWindow.setStartPosition(i16);
                    cursorWindow.setNumColumns(builder.f36824a.length);
                    if (!cursorWindow.allocRow()) {
                        HMSLog.e(TAG, "Failed to retry to allocate a row");
                        return arrayList;
                    }
                    arrayList.add(cursorWindow);
                }
                HashMap hashMap = (HashMap) list.get(i16);
                boolean z16 = true;
                for (int i17 = 0; i17 < builder.f36824a.length && (z16 = putValue(cursorWindow, hashMap.get(builder.f36824a[i17]), i16, i17)); i17++) {
                }
                if (!z16) {
                    HMSLog.d(TAG, "fail to put data for row " + i16);
                    cursorWindow.freeLastRow();
                    CursorWindow cursorWindow2 = new CursorWindow((String) null);
                    cursorWindow2.setStartPosition(i16);
                    cursorWindow2.setNumColumns(builder.f36824a.length);
                    arrayList.add(cursorWindow2);
                    break;
                }
                i16++;
            } catch (RuntimeException e16) {
                Iterator<CursorWindow> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().close();
                }
                throw e16;
            }
        }
    }

    private static ArrayList<CursorWindow> iterCursorWrapper(HMSCursorWrapper hMSCursorWrapper, int i3, int i16) {
        ArrayList<CursorWindow> arrayList = new ArrayList<>();
        while (i3 < i16 && hMSCursorWrapper.moveToPosition(i3)) {
            CursorWindow window = hMSCursorWrapper.getWindow();
            if (window == null) {
                window = new CursorWindow((String) null);
                window.setStartPosition(i3);
                hMSCursorWrapper.fillWindow(i3, window);
            } else {
                window.acquireReference();
                hMSCursorWrapper.setWindow(null);
            }
            if (window.getNumRows() == 0) {
                break;
            }
            arrayList.add(window);
            i3 = window.getNumRows() + window.getStartPosition();
        }
        return arrayList;
    }

    private static boolean putValue(CursorWindow cursorWindow, Object obj, int i3, int i16) throws IllegalArgumentException {
        long j3;
        if (obj == null) {
            return cursorWindow.putNull(i3, i16);
        }
        if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                j3 = 1;
            } else {
                j3 = 0;
            }
            return cursorWindow.putLong(j3, i3, i16);
        }
        if (obj instanceof Integer) {
            return cursorWindow.putLong(((Integer) obj).intValue(), i3, i16);
        }
        if (obj instanceof Long) {
            return cursorWindow.putLong(((Long) obj).longValue(), i3, i16);
        }
        if (obj instanceof Float) {
            return cursorWindow.putDouble(((Float) obj).floatValue(), i3, i16);
        }
        if (obj instanceof Double) {
            return cursorWindow.putDouble(((Double) obj).doubleValue(), i3, i16);
        }
        if (obj instanceof String) {
            return cursorWindow.putString((String) obj, i3, i16);
        }
        if (obj instanceof byte[]) {
            return cursorWindow.putBlob((byte[]) obj, i3, i16);
        }
        throw new IllegalArgumentException("unsupported type for column: " + obj);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (!this.mClosed) {
            for (CursorWindow cursorWindow : this.cursorWindows) {
                cursorWindow.close();
            }
            this.mClosed = true;
        }
    }

    public final void collectColumsAndCount() {
        this.columnsBundle = new Bundle();
        String[] strArr = this.columns;
        int i3 = 0;
        if (strArr != null && strArr.length != 0) {
            int i16 = 0;
            while (true) {
                String[] strArr2 = this.columns;
                if (i16 >= strArr2.length) {
                    break;
                }
                this.columnsBundle.putInt(strArr2[i16], i16);
                i16++;
            }
            CursorWindow[] cursorWindowArr = this.cursorWindows;
            if (cursorWindowArr != null && cursorWindowArr.length != 0) {
                this.perCursorCounts = new int[cursorWindowArr.length];
                int i17 = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr2 = this.cursorWindows;
                    if (i3 < cursorWindowArr2.length) {
                        this.perCursorCounts[i3] = i17;
                        i17 = cursorWindowArr2[i3].getStartPosition() + this.cursorWindows[i3].getNumRows();
                        i3++;
                    } else {
                        this.dataCount = i17;
                        return;
                    }
                }
            } else {
                this.dataCount = 0;
            }
        } else {
            this.dataCount = 0;
        }
    }

    public final void copyToBuffer(String str, int i3, int i16, CharArrayBuffer charArrayBuffer) {
        checkAvailable(str, i3);
        this.cursorWindows[i16].copyStringToBuffer(i3, this.columnsBundle.getInt(str), charArrayBuffer);
    }

    protected final void finalize() throws Throwable {
        if (this.isInstance && this.cursorWindows.length > 0 && !isClosed()) {
            close();
        }
        super.finalize();
    }

    public final int getCount() {
        return this.dataCount;
    }

    public final Bundle getMetadata() {
        return this.metadata;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final Object getValue(String str, int i3, int i16, String str2) {
        str2.hashCode();
        boolean z16 = true;
        char c16 = '\uffff';
        switch (str2.hashCode()) {
            case -1092271849:
                if (str2.equals(TYPE_FLOAT)) {
                    c16 = 0;
                    break;
                }
                break;
            case -870070237:
                if (str2.equals(TYPE_BOOLEAN)) {
                    c16 = 1;
                    break;
                }
                break;
            case -675993238:
                if (str2.equals(TYPE_INT)) {
                    c16 = 2;
                    break;
                }
                break;
            case 445002870:
                if (str2.equals(TYPE_DOUBLE)) {
                    c16 = 3;
                    break;
                }
                break;
            case 519136353:
                if (str2.equals(TYPE_LONG)) {
                    c16 = 4;
                    break;
                }
                break;
            case 878975158:
                if (str2.equals(TYPE_STRING)) {
                    c16 = 5;
                    break;
                }
                break;
            case 1300508295:
                if (str2.equals(TYPE_BYTE_ARRAY)) {
                    c16 = 6;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                checkAvailable(str, i3);
                return Float.valueOf(this.cursorWindows[i16].getFloat(i3, this.columnsBundle.getInt(str)));
            case 1:
                checkAvailable(str, i3);
                if (this.cursorWindows[i16].getLong(i3, this.columnsBundle.getInt(str)) != 1) {
                    z16 = false;
                }
                return Boolean.valueOf(z16);
            case 2:
                checkAvailable(str, i3);
                return Integer.valueOf(this.cursorWindows[i16].getInt(i3, this.columnsBundle.getInt(str)));
            case 3:
                checkAvailable(str, i3);
                return Double.valueOf(this.cursorWindows[i16].getDouble(i3, this.columnsBundle.getInt(str)));
            case 4:
                checkAvailable(str, i3);
                return Long.valueOf(this.cursorWindows[i16].getLong(i3, this.columnsBundle.getInt(str)));
            case 5:
                checkAvailable(str, i3);
                return this.cursorWindows[i16].getString(i3, this.columnsBundle.getInt(str));
            case 6:
                checkAvailable(str, i3);
                return this.cursorWindows[i16].getBlob(i3, this.columnsBundle.getInt(str));
            default:
                return null;
        }
    }

    public final int getWindowIndex(int i3) {
        boolean z16;
        int[] iArr;
        int i16 = 0;
        if (i3 < 0 && i3 >= this.dataCount) {
            z16 = false;
        } else {
            z16 = true;
        }
        Preconditions.checkArgument(z16, "rowIndex is out of index:" + i3);
        while (true) {
            iArr = this.perCursorCounts;
            if (i16 >= iArr.length) {
                break;
            }
            if (i3 < iArr[i16]) {
                i16--;
                break;
            }
            i16++;
        }
        if (i16 == iArr.length) {
            return i16 - 1;
        }
        return i16;
    }

    public final boolean hasColumn(String str) {
        return this.columnsBundle.containsKey(str);
    }

    public final boolean hasNull(String str, int i3, int i16) {
        checkAvailable(str, i3);
        if (this.cursorWindows[i16].getType(i3, this.columnsBundle.getInt(str)) == 0) {
            return true;
        }
        return false;
    }

    public final synchronized boolean isClosed() {
        return this.mClosed;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.columns, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.cursorWindows, i3, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.version);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i3 & 1) != 0) {
            close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataHolder(int i3, String[] strArr, CursorWindow[] cursorWindowArr, int i16, Bundle bundle) {
        this.mClosed = false;
        this.isInstance = true;
        this.version = i3;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i16;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i3, Bundle bundle) {
        Preconditions.checkNotNull(strArr, "columnsP cannot be null");
        Preconditions.checkNotNull(cursorWindowArr, "cursorWindowP cannot be null");
        this.mClosed = false;
        this.isInstance = true;
        this.version = 1;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i3;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    private static CursorWindow[] getCursorWindows(Builder builder, int i3) {
        if (builder.f36824a.length == 0) {
            return new CursorWindow[0];
        }
        if (i3 < 0 || i3 >= builder.f36825b.size()) {
            i3 = builder.f36825b.size();
        }
        ArrayList<CursorWindow> iterCursorWindow = iterCursorWindow(builder, i3, builder.f36825b.subList(0, i3));
        return (CursorWindow[]) iterCursorWindow.toArray(new CursorWindow[iterCursorWindow.size()]);
    }

    DataHolder(HMSCursorWrapper hMSCursorWrapper, int i3, Bundle bundle) {
        this(hMSCursorWrapper.getColumnNames(), getCursorWindows(hMSCursorWrapper), i3, bundle);
    }

    public DataHolder(Cursor cursor, int i3, Bundle bundle) {
        this(new HMSCursorWrapper(cursor), i3, bundle);
    }

    DataHolder(Builder builder, int i3, Bundle bundle) {
        this(builder.f36824a, getCursorWindows(builder, -1), i3, (Bundle) null);
    }

    DataHolder(Builder builder, int i3, Bundle bundle, int i16) {
        this(builder.f36824a, getCursorWindows(builder, -1), i3, bundle);
    }
}
