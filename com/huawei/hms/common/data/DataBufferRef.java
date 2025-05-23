package com.huawei.hms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DataBufferRef {

    /* renamed from: a, reason: collision with root package name */
    private int f36823a;
    protected final DataHolder mDataHolder;
    protected int mDataRow;

    public DataBufferRef(DataHolder dataHolder, int i3) {
        Preconditions.checkNotNull(dataHolder, "dataHolder cannot be null");
        this.mDataHolder = dataHolder;
        getWindowIndex(i3);
    }

    protected void copyToBuffer(String str, CharArrayBuffer charArrayBuffer) {
        this.mDataHolder.copyToBuffer(str, this.mDataRow, this.f36823a, charArrayBuffer);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DataBufferRef)) {
            return false;
        }
        DataBufferRef dataBufferRef = (DataBufferRef) obj;
        if (dataBufferRef.mDataRow != this.mDataRow || dataBufferRef.f36823a != this.f36823a || dataBufferRef.mDataHolder != this.mDataHolder) {
            return false;
        }
        return true;
    }

    protected boolean getBoolean(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f36823a, DataHolder.TYPE_BOOLEAN);
        if (value != null) {
            return ((Boolean) value).booleanValue();
        }
        return false;
    }

    protected byte[] getByteArray(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f36823a, DataHolder.TYPE_BYTE_ARRAY);
        if (value != null) {
            return (byte[]) value;
        }
        return null;
    }

    protected int getDataRow() {
        return this.mDataRow;
    }

    protected double getDouble(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f36823a, DataHolder.TYPE_DOUBLE);
        if (value != null) {
            return ((Double) value).doubleValue();
        }
        return -1.0d;
    }

    protected float getFloat(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f36823a, DataHolder.TYPE_FLOAT);
        if (value != null) {
            return ((Float) value).floatValue();
        }
        return -1.0f;
    }

    protected int getInteger(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f36823a, DataHolder.TYPE_INT);
        if (value != null) {
            return ((Integer) value).intValue();
        }
        return -1;
    }

    protected long getLong(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f36823a, DataHolder.TYPE_LONG);
        if (value != null) {
            return ((Long) value).longValue();
        }
        return -1L;
    }

    protected String getString(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f36823a, DataHolder.TYPE_STRING);
        if (value != null) {
            return (String) value;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getWindowIndex(int i3) {
        boolean z16;
        if (i3 >= 0 && i3 < this.mDataHolder.getCount()) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkArgument(z16, "rowNum is out of index");
        this.mDataRow = i3;
        this.f36823a = this.mDataHolder.getWindowIndex(i3);
    }

    public boolean hasColumn(String str) {
        return this.mDataHolder.hasColumn(str);
    }

    protected boolean hasNull(String str) {
        return this.mDataHolder.hasNull(str, this.mDataRow, this.f36823a);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.mDataRow), Integer.valueOf(this.f36823a), this.mDataHolder);
    }

    public boolean isDataValid() {
        return !this.mDataHolder.isClosed();
    }

    protected Uri parseUri(String str) {
        String str2 = (String) this.mDataHolder.getValue(str, this.mDataRow, this.f36823a, DataHolder.TYPE_STRING);
        if (str2 == null) {
            return null;
        }
        return Uri.parse(str2);
    }
}
