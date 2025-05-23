package com.tencent.rdelivery.dependencyimpl;

import com.tencent.mmkv.MMKV;
import com.tencent.raft.standard.storage.IRStorage;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0018\u001aB\u001d\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b#\u0010$J\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u001a\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001dR\u0016\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/rdelivery/dependencyimpl/MmkvStorage;", "Lcom/tencent/raft/standard/storage/IRStorage;", "", "", "allKeys", "()[Ljava/lang/String;", "key", "", "defValue", "getLong", "getString", "", "getByteArray", "value", "", "putLong", "putString", "putByteArray", "remove", "trim", JoinPoint.SYNCHRONIZATION_LOCK, JoinPoint.SYNCHRONIZATION_UNLOCK, QCircleLpReportDc05507.KEY_CLEAR, "Lcom/tencent/mmkv/MMKV;", "a", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mmkv/MMKV;", "kv", "Ljava/lang/String;", "mmvkId", "Lcom/tencent/rdelivery/dependencyimpl/MmkvStorage$a;", "c", "Lcom/tencent/rdelivery/dependencyimpl/MmkvStorage$a;", "customLock", "<init>", "(Ljava/lang/String;Lcom/tencent/rdelivery/dependencyimpl/MmkvStorage$a;)V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class MmkvStorage implements IRStorage {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy kv;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String mmvkId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final a customLock;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rdelivery/dependencyimpl/MmkvStorage$a;", "", "", "storageId", "", "b", "a", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public interface a {
        void a(@NotNull String storageId);

        void b(@NotNull String storageId);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/rdelivery/dependencyimpl/MmkvStorage$b;", "Lcom/tencent/raft/standard/storage/IRStorage$IRStorageFactory;", "", "storageId", "Lcom/tencent/raft/standard/storage/IRStorage;", "createIRStorage", "Lcom/tencent/rdelivery/dependencyimpl/MmkvStorage$a;", "a", "Lcom/tencent/rdelivery/dependencyimpl/MmkvStorage$a;", "customLock", "<init>", "(Lcom/tencent/rdelivery/dependencyimpl/MmkvStorage$a;)V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class b implements IRStorage.IRStorageFactory {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final a customLock;

        @JvmOverloads
        public b() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.tencent.raft.standard.storage.IRStorage.IRStorageFactory
        @NotNull
        public IRStorage createIRStorage(@NotNull String storageId) {
            Intrinsics.checkParameterIsNotNull(storageId, "storageId");
            return new MmkvStorage(storageId, this.customLock);
        }

        @JvmOverloads
        public b(@Nullable a aVar) {
            this.customLock = aVar;
        }

        public /* synthetic */ b(a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : aVar);
        }
    }

    @JvmOverloads
    public MmkvStorage(@NotNull String mmvkId, @Nullable a aVar) {
        Lazy lazy;
        Intrinsics.checkParameterIsNotNull(mmvkId, "mmvkId");
        this.mmvkId = mmvkId;
        this.customLock = aVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MMKV>() { // from class: com.tencent.rdelivery.dependencyimpl.MmkvStorage$kv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MMKV invoke() {
                String str;
                str = MmkvStorage.this.mmvkId;
                return MMKV.a0(str, 2);
            }
        });
        this.kv = lazy;
    }

    private final MMKV b() {
        return (MMKV) this.kv.getValue();
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    @Nullable
    public synchronized String[] allKeys() {
        return b().allKeys();
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public synchronized void clear() {
        b().clearAll();
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    @Nullable
    public synchronized byte[] getByteArray(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return b().f(key);
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public synchronized long getLong(@NotNull String key, long defValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return b().m(key, defValue);
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    @Nullable
    public synchronized String getString(@NotNull String key, @Nullable String defValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return b().q(key, defValue);
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public synchronized void lock() {
        a aVar = this.customLock;
        if (aVar != null) {
            aVar.b(this.mmvkId);
        } else {
            b().lock();
        }
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public synchronized void putByteArray(@NotNull String key, @Nullable byte[] value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        b().P(key, value);
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public synchronized void putLong(@NotNull String key, long value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        b().F(key, value);
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public synchronized void putString(@NotNull String key, @Nullable String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        b().J(key, value);
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public synchronized void remove(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        b().remove(key);
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public synchronized void trim() {
        b().trim();
    }

    @Override // com.tencent.raft.standard.storage.IRStorage
    public synchronized void unlock() {
        a aVar = this.customLock;
        if (aVar != null) {
            aVar.a(this.mmvkId);
        } else {
            b().unlock();
        }
    }

    public /* synthetic */ MmkvStorage(String str, a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : aVar);
    }
}
