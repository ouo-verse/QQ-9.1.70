package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class LazyScopeAdapter extends AbstractScopeAdapter {

    @NotNull
    private final NotNullLazyValue<MemberScope> lazyScope;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LazyScopeAdapter(@NotNull Function0<? extends MemberScope> getScope) {
        this(null, getScope, 1, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(getScope, "getScope");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter
    @NotNull
    protected MemberScope getWorkerScope() {
        return this.lazyScope.invoke();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LazyScopeAdapter(StorageManager NO_LOCKS, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(NO_LOCKS, function0);
        if ((i3 & 1) != 0) {
            NO_LOCKS = LockBasedStorageManager.NO_LOCKS;
            Intrinsics.checkNotNullExpressionValue(NO_LOCKS, "NO_LOCKS");
        }
    }

    @JvmOverloads
    public LazyScopeAdapter(@NotNull StorageManager storageManager, @NotNull final Function0<? extends MemberScope> getScope) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(getScope, "getScope");
        this.lazyScope = storageManager.createLazyValue(new Function0<MemberScope>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter$lazyScope$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MemberScope invoke() {
                MemberScope invoke = getScope.invoke();
                return invoke instanceof AbstractScopeAdapter ? ((AbstractScopeAdapter) invoke).getActualScope() : invoke;
            }
        });
    }
}
