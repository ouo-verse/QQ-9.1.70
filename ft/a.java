package ft;

import com.tencent.aio.data.AIOParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/aio/data/AIOParam;", "", "c", "e", "g", "d", "b", "a", "f", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a {
    public static final boolean a(@NotNull AIOParam buildVMWithCONCURRENT) {
        Intrinsics.checkNotNullParameter(buildVMWithCONCURRENT, "$this$buildVMWithCONCURRENT");
        return buildVMWithCONCURRENT.l().getBoolean("key_toggle_opt_concurrent_build_vm", false);
    }

    public static final boolean b(@NotNull AIOParam buildVMWithIterative) {
        Intrinsics.checkNotNullParameter(buildVMWithIterative, "$this$buildVMWithIterative");
        return buildVMWithIterative.l().getBoolean("key_toggle_opt_iterative_build_vm", false);
    }

    public static final boolean c(@NotNull AIOParam messengerToggle) {
        Intrinsics.checkNotNullParameter(messengerToggle, "$this$messengerToggle");
        return messengerToggle.l().getBoolean("key_toggle_opt_messenger", false);
    }

    public static final boolean d(@NotNull AIOParam optConcurrentInit) {
        Intrinsics.checkNotNullParameter(optConcurrentInit, "$this$optConcurrentInit");
        return optConcurrentInit.l().getBoolean("key_toggle_opt_concurrent_initialization", false);
    }

    public static final boolean e(@NotNull AIOParam optLiveDataToggle) {
        Intrinsics.checkNotNullParameter(optLiveDataToggle, "$this$optLiveDataToggle");
        return optLiveDataToggle.l().getBoolean("Key_toggle_opt_live_data", false);
    }

    public static final boolean f(@NotNull AIOParam optRecycleHelperToggle) {
        Intrinsics.checkNotNullParameter(optRecycleHelperToggle, "$this$optRecycleHelperToggle");
        return optRecycleHelperToggle.l().getBoolean("Key_tootle_opt_recycle_helper", false);
    }

    public static final boolean g(@NotNull AIOParam optUseDispatcher) {
        Intrinsics.checkNotNullParameter(optUseDispatcher, "$this$optUseDispatcher");
        return optUseDispatcher.l().getBoolean("Key_toggle_opt_dispatcher", false);
    }
}
