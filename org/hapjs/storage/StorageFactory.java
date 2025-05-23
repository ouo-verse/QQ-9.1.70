package org.hapjs.storage;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lorg/hapjs/storage/StorageFactory;", "", "()V", "mStorageMap", "Ljava/util/HashMap;", "", "Lorg/hapjs/storage/IStorage;", "Lkotlin/collections/HashMap;", OperateCustomButton.OPERATE_CREATE, "target", "Companion", "Holder", "storage-sdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes29.dex */
public final class StorageFactory {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final HashMap<String, IStorage> mStorageMap = new HashMap<>();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lorg/hapjs/storage/StorageFactory$Companion;", "", "()V", "getInstance", "Lorg/hapjs/storage/StorageFactory;", "storage-sdk_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes29.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final StorageFactory getInstance() {
            return Holder.INSTANCE.getInstance();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lorg/hapjs/storage/StorageFactory$Holder;", "", "()V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lorg/hapjs/storage/StorageFactory;", "getInstance", "()Lorg/hapjs/storage/StorageFactory;", "storage-sdk_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes29.dex */
    private static final class Holder {

        @NotNull
        public static final Holder INSTANCE = new Holder();

        @NotNull
        private static final StorageFactory instance = new StorageFactory();

        Holder() {
        }

        @NotNull
        public final StorageFactory getInstance() {
            return instance;
        }
    }

    @Nullable
    public final IStorage create(@NotNull String target) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (this.mStorageMap.containsKey(target) && this.mStorageMap.get(target) != null) {
            return this.mStorageMap.get(target);
        }
        this.mStorageMap.put(target, new StorageImpl(target));
        return this.mStorageMap.get(target);
    }
}
