package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"SLOTS_PER_INT", "", "composableLambdaN", "Landroidx/compose/runtime/internal/ComposableLambdaN;", "composer", "Landroidx/compose/runtime/Composer;", "key", "tracked", "", "arity", "block", "", "composableLambdaNInstance", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class ComposableLambdaN_jvmKt {
    private static final int SLOTS_PER_INT = 10;

    @ComposeCompilerApi
    public static final ComposableLambdaN composableLambdaN(Composer composer, int i3, boolean z16, int i16, Object block) {
        ComposableLambdaNImpl composableLambdaNImpl;
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(block, "block");
        composer.startReplaceableGroup(i3);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            composableLambdaNImpl = new ComposableLambdaNImpl(i3, z16, i16);
            composer.updateRememberedValue(composableLambdaNImpl);
        } else if (rememberedValue != null) {
            composableLambdaNImpl = (ComposableLambdaNImpl) rememberedValue;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaNImpl");
        }
        composableLambdaNImpl.update(block);
        composer.endReplaceableGroup();
        return composableLambdaNImpl;
    }

    @ComposeCompilerApi
    public static final ComposableLambdaN composableLambdaNInstance(int i3, boolean z16, int i16, Object block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ComposableLambdaNImpl composableLambdaNImpl = new ComposableLambdaNImpl(i3, z16, i16);
        composableLambdaNImpl.update(block);
        return composableLambdaNImpl;
    }
}
