package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class DefaultBuiltIns extends KotlinBuiltIns {

    @NotNull
    public static final Companion Companion;

    @NotNull
    private static final DefaultBuiltIns Instance;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DefaultBuiltIns getInstance() {
            return DefaultBuiltIns.Instance;
        }

        Companion() {
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        Companion = new Companion(defaultConstructorMarker);
        Instance = new DefaultBuiltIns(false, 1, defaultConstructorMarker);
    }

    public DefaultBuiltIns() {
        this(false, 1, null);
    }

    public DefaultBuiltIns(boolean z16) {
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (z16) {
            createBuiltInsModule(false);
        }
    }

    public /* synthetic */ DefaultBuiltIns(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16);
    }
}
