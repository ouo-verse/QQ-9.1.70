package com.tencent.mobileqq.qmmkv.v2;

import android.content.SharedPreferences;
import android.os.Parcelable;
import com.tencent.mmkv.MMKV;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010]\u001a\u00020\u0006\u0012\u0006\u0010a\u001a\u00020^\u00a2\u0006\u0004\bb\u0010cJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\"\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001a\u0010\u0011\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u001c\u0010\u0013\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u0013\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0016\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0016\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J=\u0010\u001a\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0017*\u00020\u00152\b\u0010\t\u001a\u0004\u0018\u00010\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\b\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ$\u0010\u001c\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u001d\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u001e\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0017\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fH\u0016\u00a2\u0006\u0004\b \u0010!J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\"H\u0016J\u0012\u0010&\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u001f\u0010(\u001a\u00020\f2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fH\u0016\u00a2\u0006\u0004\b(\u0010)J\b\u0010+\u001a\u00020*H\u0016J\u0012\u0010-\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030,H\u0016J\u001e\u0010/\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010.\u001a\u0004\u0018\u00010\u0006H\u0016J*\u00102\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001002\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u000100H\u0016J\u001a\u00103\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010.\u001a\u00020\u000eH\u0016J\u001a\u00104\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010.\u001a\u00020\"H\u0016J\u001a\u00106\u001a\u0002052\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010.\u001a\u000205H\u0016J\u001a\u00107\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010.\u001a\u00020\u0003H\u0016J\u0013\u00108\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u00109\u001a\u00020\fH\u0016J\u0012\u0010<\u001a\u00020*2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016J\u0012\u0010=\u001a\u00020*2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016J\u001c\u0010>\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u001c\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010@\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001002\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\"\u0010@\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u000100H\u0016J\"\u0010A\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001a\u0010A\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u000eH\u0016J\"\u0010B\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001a\u0010B\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\"H\u0016J\"\u0010C\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u0002052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001a\u0010C\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u000205H\u0016J\"\u0010D\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001a\u0010D\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0012\u0010E\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010F\u001a\u00020\fH\u0016J\b\u0010G\u001a\u00020\u0003H\u0016J\b\u0010H\u001a\u00020*H\u0016R\u001b\u0010N\u001a\u00020I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR#\u0010S\u001a\n P*\u0004\u0018\u00010O0O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u0010K\u001a\u0004\bQ\u0010RR#\u0010W\u001a\n P*\u0004\u0018\u00010T0T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bL\u0010K\u001a\u0004\bU\u0010VR\u0016\u0010Z\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010]\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010a\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/v2/CloseableMMKV;", "Lcom/tencent/mobileqq/qmmkv/v2/e;", "Lcom/tencent/mobileqq/qmmkv/v2/c;", "", "a", "isClosed", "", "mmapID", "mmapKey", "key", "", "value", "Landroid/content/SharedPreferences$Editor;", "putDouble", "", "expireDurationInSecond", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getDouble", "", "putBytes", "getBytes", "Landroid/os/Parcelable;", "putParcelable", "T", "Ljava/lang/Class;", "tClass", "getParcelable", "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Parcelable;)Landroid/os/Parcelable;", "putString", "getValueSize", "getValueActualSize", "", "allKeys", "()[Ljava/lang/String;", "", "count", "totalSize", "actualSize", "removeValueForKey", "keys", "removeValuesForKeys", "([Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;", "", "trim", "", "getAll", "defValue", "getString", "", "defValues", "getStringSet", "getInt", "getLong", "", "getFloat", "getBoolean", "contains", "edit", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "listener", "registerOnSharedPreferenceChangeListener", "unregisterOnSharedPreferenceChangeListener", "putStringR", "values", "putStringSet", "putInt", "putLong", "putFloat", "putBoolean", "remove", QCircleLpReportDc05507.KEY_CLEAR, "commit", "apply", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "d", "Lkotlin/Lazy;", "f", "()Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "rwlock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;", "kotlin.jvm.PlatformType", "e", "()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;", "rlock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;", "g", "()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;", "wlock", tl.h.F, "Z", AudioContext.State.CLOSED, "i", "Ljava/lang/String;", "mmapId", "Lcom/tencent/mmkv/MMKV;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mmkv/MMKV;", "kv", "<init>", "(Ljava/lang/String;Lcom/tencent/mmkv/MMKV;)V", "library_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class CloseableMMKV implements e, c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy rwlock;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy rlock;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy wlock;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile boolean closed;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String mmapId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MMKV kv;

    public CloseableMMKV(@NotNull String mmapId, @NotNull MMKV kv5) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(mmapId, "mmapId");
        Intrinsics.checkNotNullParameter(kv5, "kv");
        this.mmapId = mmapId;
        this.kv = kv5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ReentrantReadWriteLock>() { // from class: com.tencent.mobileqq.qmmkv.v2.CloseableMMKV$rwlock$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ReentrantReadWriteLock invoke() {
                return new ReentrantReadWriteLock();
            }
        });
        this.rwlock = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ReentrantReadWriteLock.ReadLock>() { // from class: com.tencent.mobileqq.qmmkv.v2.CloseableMMKV$rlock$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ReentrantReadWriteLock.ReadLock invoke() {
                ReentrantReadWriteLock f16;
                f16 = CloseableMMKV.this.f();
                return f16.readLock();
            }
        });
        this.rlock = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ReentrantReadWriteLock.WriteLock>() { // from class: com.tencent.mobileqq.qmmkv.v2.CloseableMMKV$wlock$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ReentrantReadWriteLock.WriteLock invoke() {
                ReentrantReadWriteLock f16;
                f16 = CloseableMMKV.this.f();
                return f16.writeLock();
            }
        });
        this.wlock = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReentrantReadWriteLock.ReadLock e() {
        return (ReentrantReadWriteLock.ReadLock) this.rlock.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReentrantReadWriteLock f() {
        return (ReentrantReadWriteLock) this.rwlock.getValue();
    }

    private final ReentrantReadWriteLock.WriteLock g() {
        return (ReentrantReadWriteLock.WriteLock) this.wlock.getValue();
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.c
    public boolean a() {
        if (g().tryLock()) {
            this.kv.close();
            this.closed = true;
            QMMKV.logInfo("close [" + this.kv.hashCode() + ']');
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    public long actualSize() {
        if (e().tryLock()) {
            try {
                return this.kv.actualSize();
            } finally {
                e().unlock();
            }
        }
        QMMKV.logError("rRun failed [" + this.kv.hashCode() + ']');
        return 0L;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @Nullable
    public String[] allKeys() {
        if (e().tryLock()) {
            try {
                return this.kv.allKeys();
            } finally {
                e().unlock();
            }
        }
        QMMKV.logError("rRun failed [" + this.kv.hashCode() + ']');
        return null;
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        if (e().tryLock()) {
            try {
                this.kv.a();
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
    }

    @Override // android.content.SharedPreferences.Editor
    @NotNull
    public SharedPreferences.Editor clear() {
        if (e().tryLock()) {
            try {
                this.kv.clearAll();
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        if (e().tryLock()) {
            try {
                this.kv.i0();
                e().unlock();
                return true;
            } catch (Throwable th5) {
                e().unlock();
                throw th5;
            }
        }
        QMMKV.logError("rRun failed [" + this.kv.hashCode() + ']');
        return false;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(@Nullable String key) {
        if (e().tryLock()) {
            try {
                return this.kv.contains(key);
            } finally {
                e().unlock();
            }
        }
        QMMKV.logError("rRun failed [" + this.kv.hashCode() + ']');
        return false;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    public long count() {
        if (e().tryLock()) {
            try {
                return this.kv.count();
            } finally {
                e().unlock();
            }
        }
        QMMKV.logError("rRun failed [" + this.kv.hashCode() + ']');
        return 0L;
    }

    @Override // android.content.SharedPreferences
    @NotNull
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException("Intentionally Not Supported. Use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(@Nullable String key, boolean defValue) {
        if (e().tryLock()) {
            try {
                defValue = this.kv.getBoolean(key, defValue);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("rRun failed [" + this.kv.hashCode() + ']');
        }
        return defValue;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @Nullable
    public byte[] getBytes(@Nullable String key, @Nullable byte[] defaultValue) {
        if (e().tryLock()) {
            try {
                defaultValue = this.kv.getBytes(key, defaultValue);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("rRun failed [" + this.kv.hashCode() + ']');
        }
        return defaultValue;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    public double getDouble(@Nullable String key, double defaultValue) {
        if (e().tryLock()) {
            try {
                defaultValue = this.kv.h(key, defaultValue);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("rRun failed [" + this.kv.hashCode() + ']');
        }
        return defaultValue;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(@Nullable String key, float defValue) {
        if (e().tryLock()) {
            try {
                defValue = this.kv.getFloat(key, defValue);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("rRun failed [" + this.kv.hashCode() + ']');
        }
        return defValue;
    }

    @Override // android.content.SharedPreferences
    public int getInt(@Nullable String key, int defValue) {
        if (e().tryLock()) {
            try {
                defValue = this.kv.getInt(key, defValue);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("rRun failed [" + this.kv.hashCode() + ']');
        }
        return defValue;
    }

    @Override // android.content.SharedPreferences
    public long getLong(@Nullable String key, long defValue) {
        if (e().tryLock()) {
            try {
                defValue = this.kv.getLong(key, defValue);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("rRun failed [" + this.kv.hashCode() + ']');
        }
        return defValue;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @Nullable
    public <T extends Parcelable> T getParcelable(@Nullable String key, @NotNull Class<T> tClass, @Nullable T defaultValue) {
        Intrinsics.checkNotNullParameter(tClass, "tClass");
        if (e().tryLock()) {
            try {
                defaultValue = (T) this.kv.o(key, tClass, defaultValue);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("rRun failed [" + this.kv.hashCode() + ']');
        }
        return defaultValue;
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(@Nullable String key, @Nullable String defValue) {
        if (e().tryLock()) {
            try {
                defValue = this.kv.getString(key, defValue);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("rRun failed [" + this.kv.hashCode() + ']');
        }
        return defValue;
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(@Nullable String key, @Nullable Set<String> defValues) {
        if (e().tryLock()) {
            try {
                defValues = this.kv.getStringSet(key, defValues);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("rRun failed [" + this.kv.hashCode() + ']');
        }
        return defValues;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    public int getValueActualSize(@Nullable String key) {
        if (e().tryLock()) {
            try {
                return this.kv.getValueActualSize(key);
            } finally {
                e().unlock();
            }
        }
        QMMKV.logError("rRun failed [" + this.kv.hashCode() + ']');
        return 0;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    public int getValueSize(@Nullable String key) {
        if (e().tryLock()) {
            try {
                return this.kv.getValueSize(key);
            } finally {
                e().unlock();
            }
        }
        QMMKV.logError("rRun failed [" + this.kv.hashCode() + ']');
        return 0;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.c
    /* renamed from: isClosed, reason: from getter */
    public boolean getClosed() {
        return this.closed;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    /* renamed from: mmapID, reason: from getter */
    public String getMmapId() {
        return this.mmapId;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @Nullable
    public String mmapKey() {
        if (e().tryLock()) {
            try {
                return this.kv.mmapID();
            } finally {
                e().unlock();
            }
        }
        QMMKV.logError("rRun failed [" + this.kv.hashCode() + ']');
        return null;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putBoolean(@Nullable String key, boolean value, int expireDurationInSecond) {
        if (e().tryLock()) {
            try {
                this.kv.O(key, value, expireDurationInSecond);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putBytes(@Nullable String key, @Nullable byte[] value) {
        if (e().tryLock()) {
            try {
                this.kv.P(key, value);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putDouble(@Nullable String key, double value) {
        if (e().tryLock()) {
            try {
                this.kv.z(key, value);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putFloat(@Nullable String key, float value, int expireDurationInSecond) {
        if (e().tryLock()) {
            try {
                this.kv.C(key, value, expireDurationInSecond);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putInt(@Nullable String key, int value, int expireDurationInSecond) {
        if (e().tryLock()) {
            try {
                this.kv.E(key, value, expireDurationInSecond);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putLong(@Nullable String key, long value, int expireDurationInSecond) {
        if (e().tryLock()) {
            try {
                this.kv.G(key, value, expireDurationInSecond);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putParcelable(@Nullable String key, @Nullable Parcelable value) {
        if (e().tryLock()) {
            try {
                this.kv.H(key, value);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putString(@Nullable String key, @Nullable String value, int expireDurationInSecond) {
        if (e().tryLock()) {
            try {
                this.kv.K(key, value, expireDurationInSecond);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    public boolean putStringR(@Nullable String key, @Nullable String value) {
        if (e().tryLock()) {
            try {
                return this.kv.J(key, value);
            } finally {
                e().unlock();
            }
        }
        QMMKV.logError("rRun failed [" + this.kv.hashCode() + ']');
        return false;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putStringSet(@Nullable String key, @Nullable Set<String> values, int expireDurationInSecond) {
        if (e().tryLock()) {
            try {
                this.kv.M(key, values, expireDurationInSecond);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener listener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    @Override // android.content.SharedPreferences.Editor
    @NotNull
    public SharedPreferences.Editor remove(@Nullable String key) {
        if (e().tryLock()) {
            try {
                this.kv.remove(key);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor removeValueForKey(@Nullable String key) {
        if (e().tryLock()) {
            try {
                this.kv.f0(key);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor removeValuesForKeys(@Nullable String[] keys) {
        if (e().tryLock()) {
            try {
                this.kv.removeValuesForKeys(keys);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    public long totalSize() {
        if (e().tryLock()) {
            try {
                return this.kv.totalSize();
            } finally {
                e().unlock();
            }
        }
        QMMKV.logError("rRun failed [" + this.kv.hashCode() + ']');
        return 0L;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    public void trim() {
        if (e().tryLock()) {
            try {
                this.kv.trim();
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener listener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    @Override // android.content.SharedPreferences.Editor
    @NotNull
    public SharedPreferences.Editor putBoolean(@Nullable String key, boolean value) {
        if (e().tryLock()) {
            try {
                this.kv.N(key, value);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putBytes(@Nullable String key, @Nullable byte[] value, int expireDurationInSecond) {
        if (e().tryLock()) {
            try {
                this.kv.Q(key, value, expireDurationInSecond);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putDouble(@Nullable String key, double value, int expireDurationInSecond) {
        if (e().tryLock()) {
            try {
                this.kv.A(key, value, expireDurationInSecond);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    @NotNull
    public SharedPreferences.Editor putFloat(@Nullable String key, float value) {
        if (e().tryLock()) {
            try {
                this.kv.B(key, value);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    @NotNull
    public SharedPreferences.Editor putInt(@Nullable String key, int value) {
        if (e().tryLock()) {
            try {
                this.kv.D(key, value);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    @NotNull
    public SharedPreferences.Editor putLong(@Nullable String key, long value) {
        if (e().tryLock()) {
            try {
                this.kv.F(key, value);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putParcelable(@Nullable String key, @Nullable Parcelable value, int expireDurationInSecond) {
        if (e().tryLock()) {
            try {
                this.kv.I(key, value, expireDurationInSecond);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    @NotNull
    public SharedPreferences.Editor putString(@Nullable String key, @Nullable String value) {
        if (e().tryLock()) {
            try {
                this.kv.J(key, value);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    @NotNull
    public SharedPreferences.Editor putStringSet(@Nullable String key, @Nullable Set<String> values) {
        if (e().tryLock()) {
            try {
                this.kv.L(key, values);
            } finally {
                e().unlock();
            }
        } else {
            QMMKV.logError("wRun failed [" + this.kv.hashCode() + ']');
        }
        return this;
    }

    @Override // android.content.SharedPreferences
    @NotNull
    public SharedPreferences.Editor edit() {
        return this;
    }
}
