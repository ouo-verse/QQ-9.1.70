package com.tencent.mobileqq.qmmkv;

import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
@Deprecated
/* loaded from: classes16.dex */
public class MMKVOptionEntity {

    @Nullable
    private final String mmapId;
    private final MMKVHandlerBase mmkvHandler;
    private final int mode;
    private final com.tencent.mobileqq.qmmkv.v2.j retriever;
    private final AtomicInteger mmkvThreshold = new AtomicInteger(0);
    private volatile boolean closed = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public MMKVOptionEntity(@Nullable String str, int i3, MMKVHandlerBase mMKVHandlerBase, com.tencent.mobileqq.qmmkv.v2.j jVar) {
        this.mmapId = str;
        this.mode = i3;
        this.mmkvHandler = mMKVHandlerBase;
        this.retriever = jVar;
    }

    private boolean isWriteBackEnable() {
        if (this.mmkvThreshold.get() <= 640) {
            return false;
        }
        this.mmkvThreshold.set(0);
        return true;
    }

    @Deprecated
    public long actualSize() {
        if (!isAccessible()) {
            QMMKV.logError("actualSize not accessible");
            return 0L;
        }
        return this.retriever.c(this.mmapId, this.mode, false).actualSize();
    }

    @Deprecated
    public String[] allKeyArr() {
        if (!isAccessible()) {
            QMMKV.logError("allKeyArr not accessible");
            return null;
        }
        return this.retriever.c(this.mmapId, this.mode, false).allKeys();
    }

    @Deprecated
    public void async(boolean z16) {
        if (!isAccessible()) {
            QMMKV.logError("async not accessible");
        } else if (checkSync(z16)) {
            this.retriever.c(this.mmapId, this.mode, false).apply();
        }
    }

    final boolean checkSync(boolean z16) {
        if (z16) {
            this.mmkvThreshold.set(0);
        } else {
            this.mmkvThreshold.incrementAndGet();
        }
        if (!z16 && !isWriteBackEnable()) {
            return false;
        }
        return true;
    }

    @Deprecated
    public MMKVOptionEntity clearAll() {
        if (!isAccessible()) {
            QMMKV.logError("clearAll not accessible");
            return this;
        }
        this.retriever.c(this.mmapId, this.mode, false).clear();
        return this;
    }

    @Deprecated
    public boolean closeEntity() {
        if (!isAccessible()) {
            QMMKV.logError("closeEntity not accessible");
            return false;
        }
        if (this.retriever.e(this.mmapId, false)) {
            this.closed = true;
        }
        return this.closed;
    }

    @Deprecated
    public void commitAsync() {
        async(false);
    }

    @Deprecated
    public void commitSync() {
        sync(false);
    }

    @Deprecated
    public boolean containsKey(String str) {
        if (!isAccessible()) {
            QMMKV.logError("containsKey not accessible");
            return false;
        }
        return this.retriever.c(this.mmapId, this.mode, false).contains(str);
    }

    @Deprecated
    public long count() {
        if (!isAccessible()) {
            QMMKV.logError("count not accessible");
            return 0L;
        }
        return this.retriever.c(this.mmapId, this.mode, false).count();
    }

    @Deprecated
    public boolean decodeBool(String str, boolean z16) {
        if (!isAccessible()) {
            QMMKV.logError("decodeBool not accessible");
            return z16;
        }
        if (QMMKV.decodeMonitorOn) {
            this.mmkvHandler.onDecode(this.mmapId, str);
        }
        return this.retriever.c(this.mmapId, this.mode, false).getBoolean(str, z16);
    }

    @Deprecated
    public byte[] decodeBytes(String str, byte[] bArr) {
        if (!isAccessible()) {
            QMMKV.logError("decodeBytes not accessible");
            return bArr;
        }
        if (QMMKV.decodeMonitorOn) {
            this.mmkvHandler.onDecode(this.mmapId, str);
        }
        return this.retriever.c(this.mmapId, this.mode, false).getBytes(str, bArr);
    }

    @Deprecated
    public double decodeDouble(String str, double d16) {
        if (!isAccessible()) {
            QMMKV.logError("decodeDouble not accessible");
            return d16;
        }
        if (QMMKV.decodeMonitorOn) {
            this.mmkvHandler.onDecode(this.mmapId, str);
        }
        return this.retriever.c(this.mmapId, this.mode, false).getDouble(str, d16);
    }

    @Deprecated
    public float decodeFloat(String str, float f16) {
        if (!isAccessible()) {
            QMMKV.logError("decodeFloat not accessible");
            return f16;
        }
        if (QMMKV.decodeMonitorOn) {
            this.mmkvHandler.onDecode(this.mmapId, str);
        }
        return this.retriever.c(this.mmapId, this.mode, false).getFloat(str, f16);
    }

    @Deprecated
    public int decodeInt(String str, int i3) {
        if (!isAccessible()) {
            QMMKV.logError("decodeInt not accessible");
            return i3;
        }
        if (QMMKV.decodeMonitorOn) {
            this.mmkvHandler.onDecode(this.mmapId, str);
        }
        return this.retriever.c(this.mmapId, this.mode, false).getInt(str, i3);
    }

    @Deprecated
    public long decodeLong(String str, long j3) {
        if (!isAccessible()) {
            QMMKV.logError("decodeLong not accessible");
            return j3;
        }
        if (QMMKV.decodeMonitorOn) {
            this.mmkvHandler.onDecode(this.mmapId, str);
        }
        return this.retriever.c(this.mmapId, this.mode, false).getLong(str, j3);
    }

    @Deprecated
    public <T extends Parcelable> T decodeParcelable(String str, Class<T> cls, T t16) {
        if (!isAccessible()) {
            QMMKV.logError("decodeParcelable not accessible");
            return t16;
        }
        if (QMMKV.decodeMonitorOn) {
            this.mmkvHandler.onDecode(this.mmapId, str);
        }
        return (T) this.retriever.c(this.mmapId, this.mode, false).getParcelable(str, cls, t16);
    }

    @Deprecated
    public String decodeString(String str, String str2) {
        if (!isAccessible()) {
            QMMKV.logError("decodeString not accessible");
            return str2;
        }
        if (QMMKV.decodeMonitorOn) {
            this.mmkvHandler.onDecode(this.mmapId, str);
        }
        return this.retriever.c(this.mmapId, this.mode, false).getString(str, str2);
    }

    @Deprecated
    public Set<String> decodeStringSet(String str, Set<String> set) {
        if (!isAccessible()) {
            QMMKV.logError("decodeStringSet not accessible");
            return set;
        }
        if (QMMKV.decodeMonitorOn) {
            this.mmkvHandler.onDecode(this.mmapId, str);
        }
        return this.retriever.c(this.mmapId, this.mode, false).getStringSet(str, set);
    }

    @Deprecated
    public MMKVOptionEntity encodeBool(String str, boolean z16) {
        if (!isAccessible()) {
            QMMKV.logError("encodeBool not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            this.mmkvHandler.onEncode(this.mmapId, str, Boolean.valueOf(z16));
        }
        this.retriever.c(this.mmapId, this.mode, false).putBoolean(str, z16);
        return this;
    }

    @Deprecated
    public boolean encodeBoolR(String str, boolean z16) {
        if (!isAccessible()) {
            QMMKV.logError("encodeBoolR not accessible");
            return false;
        }
        if (QMMKV.encodeMonitorOn) {
            this.mmkvHandler.onEncode(this.mmapId, str, Boolean.valueOf(z16));
        }
        this.retriever.c(this.mmapId, this.mode, false).putBoolean(str, z16);
        return true;
    }

    @Deprecated
    public MMKVOptionEntity encodeBytes(String str, byte[] bArr) {
        if (!isAccessible()) {
            QMMKV.logError("encodeBytes not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            this.mmkvHandler.onEncode(this.mmapId, str, bArr);
        }
        this.retriever.c(this.mmapId, this.mode, false).putBytes(str, bArr);
        return this;
    }

    @Deprecated
    public boolean encodeBytesR(String str, byte[] bArr) {
        if (!isAccessible()) {
            QMMKV.logError("encodeBytesR not accessible");
            return false;
        }
        if (QMMKV.encodeMonitorOn) {
            this.mmkvHandler.onEncode(this.mmapId, str, bArr);
        }
        this.retriever.c(this.mmapId, this.mode, false).putBytes(str, bArr);
        return true;
    }

    @Deprecated
    public MMKVOptionEntity encodeDouble(String str, double d16) {
        if (!isAccessible()) {
            QMMKV.logError("encodeDouble not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            this.mmkvHandler.onEncode(this.mmapId, str, Double.valueOf(d16));
        }
        this.retriever.c(this.mmapId, this.mode, false).putDouble(str, d16);
        return this;
    }

    @Deprecated
    public boolean encodeDoubleR(String str, double d16) {
        if (!isAccessible()) {
            QMMKV.logError("encodeDoubleWithReturn not accessible");
            return false;
        }
        if (QMMKV.encodeMonitorOn) {
            this.mmkvHandler.onEncode(this.mmapId, str, Double.valueOf(d16));
        }
        this.retriever.c(this.mmapId, this.mode, false).putDouble(str, d16);
        return true;
    }

    @Deprecated
    public MMKVOptionEntity encodeFloat(String str, float f16) {
        if (!isAccessible()) {
            QMMKV.logError("encodeFloat not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            this.mmkvHandler.onEncode(this.mmapId, str, Float.valueOf(f16));
        }
        this.retriever.c(this.mmapId, this.mode, false).putFloat(str, f16);
        return this;
    }

    @Deprecated
    public boolean encodeFloatR(String str, float f16) {
        if (!isAccessible()) {
            QMMKV.logError("encodeFloatWithReturn not accessible");
            return false;
        }
        if (QMMKV.encodeMonitorOn) {
            this.mmkvHandler.onEncode(this.mmapId, str, Float.valueOf(f16));
        }
        this.retriever.c(this.mmapId, this.mode, false).putFloat(str, f16);
        return true;
    }

    @Deprecated
    public MMKVOptionEntity encodeInt(String str, int i3) {
        if (!isAccessible()) {
            QMMKV.logError("encodeInt not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            this.mmkvHandler.onEncode(this.mmapId, str, Integer.valueOf(i3));
        }
        this.retriever.c(this.mmapId, this.mode, false).putInt(str, i3);
        return this;
    }

    @Deprecated
    public boolean encodeIntWithReturn(String str, int i3) {
        if (!isAccessible()) {
            QMMKV.logError("encodeIntWithReturn not accessible");
            return false;
        }
        if (QMMKV.encodeMonitorOn) {
            this.mmkvHandler.onEncode(this.mmapId, str, Integer.valueOf(i3));
        }
        this.retriever.c(this.mmapId, this.mode, false).putInt(str, i3);
        return true;
    }

    @Deprecated
    public MMKVOptionEntity encodeLong(String str, long j3) {
        if (!isAccessible()) {
            QMMKV.logError("encodeLong not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            this.mmkvHandler.onEncode(this.mmapId, str, Long.valueOf(j3));
        }
        this.retriever.c(this.mmapId, this.mode, false).putLong(str, j3);
        return this;
    }

    @Deprecated
    public boolean encodeLongR(String str, long j3) {
        if (!isAccessible()) {
            QMMKV.logError("encodeLongWithReturn not accessible");
            return false;
        }
        if (QMMKV.encodeMonitorOn) {
            this.mmkvHandler.onEncode(this.mmapId, str, Long.valueOf(j3));
        }
        this.retriever.c(this.mmapId, this.mode, false).putLong(str, j3);
        return true;
    }

    @Deprecated
    public MMKVOptionEntity encodeParcelable(String str, Parcelable parcelable) {
        if (!isAccessible()) {
            QMMKV.logError("encodeParcelable not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            this.mmkvHandler.onEncode(this.mmapId, str, parcelable);
        }
        this.retriever.c(this.mmapId, this.mode, false).putParcelable(str, parcelable);
        return this;
    }

    @Deprecated
    public boolean encodeParcelableR(String str, Parcelable parcelable) {
        if (!isAccessible()) {
            QMMKV.logError("encodeParcelableR not accessible");
            return false;
        }
        if (QMMKV.encodeMonitorOn) {
            this.mmkvHandler.onEncode(this.mmapId, str, parcelable);
        }
        this.retriever.c(this.mmapId, this.mode, false).putParcelable(str, parcelable);
        return true;
    }

    @Deprecated
    public MMKVOptionEntity encodeString(String str, String str2) {
        if (!isAccessible()) {
            QMMKV.logError("encodeString not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            this.mmkvHandler.onEncode(this.mmapId, str, str2);
        }
        this.retriever.c(this.mmapId, this.mode, false).putString(str, str2);
        return this;
    }

    @Deprecated
    public boolean encodeStringR(String str, String str2) {
        if (!isAccessible()) {
            QMMKV.logError("encodeStringR not accessible");
            return false;
        }
        if (QMMKV.encodeMonitorOn) {
            this.mmkvHandler.onEncode(this.mmapId, str, str2);
        }
        return this.retriever.c(this.mmapId, this.mode, false).putStringR(str, str2);
    }

    @Deprecated
    public MMKVOptionEntity encodeStringSet(String str, Set<String> set) {
        if (!isAccessible()) {
            QMMKV.logError("encodeStringSet not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            this.mmkvHandler.onEncode(this.mmapId, str, set);
        }
        this.retriever.c(this.mmapId, this.mode, false).putStringSet(str, set);
        return this;
    }

    @Deprecated
    public boolean encodeStringSetR(String str, Set<String> set) {
        if (!isAccessible()) {
            QMMKV.logError("encodeStringSetR not accessible");
            return false;
        }
        if (QMMKV.encodeMonitorOn) {
            this.mmkvHandler.onEncode(this.mmapId, str, set);
        }
        this.retriever.c(this.mmapId, this.mode, false).putStringSet(str, set);
        return true;
    }

    @Deprecated
    public boolean encodeStringWithReturn(String str, String str2) {
        return encodeStringR(str, str2);
    }

    public boolean isAccessible() {
        if (!TextUtils.isEmpty(this.mmapId) && !this.closed) {
            return true;
        }
        return false;
    }

    @Nullable
    @Deprecated
    public String mmapId() {
        return this.mmapId;
    }

    @Deprecated
    public MMKVOptionEntity removeKey(String str) {
        if (!isAccessible()) {
            QMMKV.logError("removeKey not accessible");
            return this;
        }
        this.retriever.c(this.mmapId, this.mode, false).removeValueForKey(str);
        return this;
    }

    @Deprecated
    public MMKVOptionEntity removeKeyList(List<String> list) {
        if (!isAccessible()) {
            QMMKV.logError("removeKeyList not accessible");
            return this;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        this.retriever.c(this.mmapId, this.mode, false).removeValuesForKeys(strArr);
        return this;
    }

    @WorkerThread
    @Deprecated
    public void sync(boolean z16) {
        if (!isAccessible()) {
            QMMKV.logError("sync not accessible");
        } else if (checkSync(z16)) {
            if (QMMKV.syncMonitorOn) {
                this.mmkvHandler.onSync(this.mmapId, z16);
            }
            this.retriever.c(this.mmapId, this.mode, false).commit();
        }
    }

    @Deprecated
    public long totalSize() {
        if (!isAccessible()) {
            QMMKV.logError("totalSize not accessible");
            return 0L;
        }
        return this.retriever.c(this.mmapId, this.mode, false).totalSize();
    }

    @Deprecated
    public void trim() {
        if (!isAccessible()) {
            QMMKV.logError("trim not accessible");
            return;
        }
        com.tencent.mobileqq.qmmkv.v2.e c16 = this.retriever.c(this.mmapId, this.mode, false);
        if (c16.totalSize() > 0) {
            c16.trim();
            return;
        }
        QMMKV.logInfo("no need to trim mmapId: " + this.mmapId);
    }
}
