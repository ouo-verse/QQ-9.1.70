package mz3;

import android.content.SharedPreferences;
import com.tencent.raft.standard.storage.IRStorage;
import com.tencent.rdelivery.reshub.core.g;
import jz3.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0019\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u001a\u0010\u0012\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0013\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016R\u0014\u0010\u0019\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lmz3/a;", "Lcom/tencent/raft/standard/storage/IRStorage;", "Landroid/content/SharedPreferences;", "a", "", "", "allKeys", "()[Ljava/lang/String;", "key", "", "defValue", "getLong", "getString", "", "getByteArray", "value", "", "putLong", "putString", "putByteArray", "remove", "trim", JoinPoint.SYNCHRONIZATION_LOCK, JoinPoint.SYNCHRONIZATION_UNLOCK, "Ljava/lang/String;", "spName", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a implements IRStorage {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String spName = "ResHubSp";

    private final SharedPreferences a() {
        try {
            return g.d().getSharedPreferences(this.spName, 0);
        } catch (Exception e16) {
            d.d("DefaultConfigStorageDelegateImpl", "getSp Exception: " + e16.getMessage(), e16);
            return null;
        }
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    @Nullable
    public String[] allKeys() {
        return null;
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public /* synthetic */ void clear() {
        hz3.a.a(this);
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    @Nullable
    public byte[] getByteArray(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return null;
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public long getLong(@NotNull String key, long defValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        try {
            SharedPreferences a16 = a();
            if (a16 != null) {
                return a16.getLong(key, defValue);
            }
            return defValue;
        } catch (Exception e16) {
            d.d("DefaultConfigStorageDelegateImpl", "getLong(" + key + ") Exception: " + e16.getMessage(), e16);
            return defValue;
        }
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    @Nullable
    public String getString(@NotNull String key, @Nullable String defValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        try {
            SharedPreferences a16 = a();
            if (a16 != null) {
                String string = a16.getString(key, defValue);
                if (string != null) {
                    return string;
                }
                return defValue;
            }
            return defValue;
        } catch (Exception e16) {
            d.d("DefaultConfigStorageDelegateImpl", "getString(" + key + ") Exception: " + e16.getMessage(), e16);
            return defValue;
        }
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public void putByteArray(@NotNull String key, @Nullable byte[] value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public void putLong(@NotNull String key, long value) {
        SharedPreferences.Editor edit;
        Intrinsics.checkParameterIsNotNull(key, "key");
        try {
            SharedPreferences a16 = a();
            if (a16 != null && (edit = a16.edit()) != null) {
                edit.putLong(key, value);
                edit.apply();
            }
        } catch (Exception e16) {
            d.d("DefaultConfigStorageDelegateImpl", "putLong(" + key + ", " + value + ") Exception: " + e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public void putString(@NotNull String key, @Nullable String value) {
        SharedPreferences.Editor edit;
        Intrinsics.checkParameterIsNotNull(key, "key");
        try {
            SharedPreferences a16 = a();
            if (a16 != null && (edit = a16.edit()) != null) {
                edit.putString(key, value);
                edit.apply();
            }
        } catch (Exception e16) {
            d.d("DefaultConfigStorageDelegateImpl", "putString(" + key + ", " + value + ") Exception: " + e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public void remove(@NotNull String key) {
        SharedPreferences.Editor edit;
        Intrinsics.checkParameterIsNotNull(key, "key");
        try {
            SharedPreferences a16 = a();
            if (a16 != null && (edit = a16.edit()) != null) {
                edit.remove(key);
                edit.apply();
            }
        } catch (Exception e16) {
            d.d("DefaultConfigStorageDelegateImpl", "remove(" + key + ") Exception: " + e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public void lock() {
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public void trim() {
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public void unlock() {
    }
}
