package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005J\u000e\u00107\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u000eJ\u001c\u0010:\u001a\u0010\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u0010\u0018\u00010;2\u0006\u0010=\u001a\u00020\u000fJ\b\u0010>\u001a\u00020\u0010H\u0016J\u0010\u0010?\u001a\u00020@2\b\u0010\u0019\u001a\u0004\u0018\u00010/J\u0016\u0010A\u001a\u00020\u00122\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010CJ\u000e\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020/J\u0006\u0010F\u001a\u00020\u0010J\u0006\u0010G\u001a\u00020\u0010J\u0006\u0010H\u001a\u00020\u0010J\u000e\u0010I\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u000fJ\"\u0010J\u001a\u00020\u00102\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\rH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00128F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00128F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u001dR\u000e\u0010!\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\"\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u0014R$\u0010#\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00128F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u001dR$\u0010&\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00128B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u001dR$\u0010)\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00128@@BX\u0080\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u001dR\"\u0010,\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030.\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u00010-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u00102\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00128F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u0010\u001dR\u0011\u00105\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b6\u0010\u0014\u00a8\u0006K"}, d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/compose/runtime/ScopeUpdateScope;", "Landroidx/compose/runtime/RecomposeScope;", "composition", "Landroidx/compose/runtime/CompositionImpl;", "(Landroidx/compose/runtime/CompositionImpl;)V", "anchor", "Landroidx/compose/runtime/Anchor;", "getAnchor", "()Landroidx/compose/runtime/Anchor;", "setAnchor", "(Landroidx/compose/runtime/Anchor;)V", "block", "Lkotlin/Function2;", "Landroidx/compose/runtime/Composer;", "", "", "canRecompose", "", "getCanRecompose", "()Z", "<set-?>", "getComposition", "()Landroidx/compose/runtime/CompositionImpl;", "currentToken", "value", "defaultsInScope", "getDefaultsInScope", "setDefaultsInScope", "(Z)V", "defaultsInvalid", "getDefaultsInvalid", "setDefaultsInvalid", WadlProxyConsts.FLAGS, "isConditional", "requiresRecompose", "getRequiresRecompose", "setRequiresRecompose", "rereading", "getRereading", "setRereading", "skipped", "getSkipped$runtime_release", "setSkipped", "trackedDependencies", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/DerivedState;", "", "trackedInstances", "Landroidx/compose/runtime/collection/IdentityArrayIntMap;", "used", "getUsed", "setUsed", "valid", "getValid", "adoptedBy", "compose", "composer", "end", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "token", "invalidate", "invalidateForResult", "Landroidx/compose/runtime/InvalidationResult;", "isInvalidFor", "instances", "Landroidx/compose/runtime/collection/IdentityArraySet;", "recordRead", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "release", "rereadTrackedInstances", "scopeSkipped", "start", "updateScope", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class RecomposeScopeImpl implements ScopeUpdateScope, RecomposeScope {
    private Anchor anchor;
    private Function2<? super Composer, ? super Integer, Unit> block;
    private CompositionImpl composition;
    private int currentToken;
    private int flags;
    private IdentityArrayMap<DerivedState<?>, Object> trackedDependencies;
    private IdentityArrayIntMap trackedInstances;

    public RecomposeScopeImpl(CompositionImpl compositionImpl) {
        this.composition = compositionImpl;
    }

    private final boolean getRereading() {
        return (this.flags & 32) != 0;
    }

    public final void adoptedBy(CompositionImpl composition) {
        Intrinsics.checkNotNullParameter(composition, "composition");
        this.composition = composition;
    }

    public final void compose(Composer composer) {
        Unit unit;
        Intrinsics.checkNotNullParameter(composer, "composer");
        Function2<? super Composer, ? super Integer, Unit> function2 = this.block;
        if (function2 != null) {
            function2.invoke(composer, 1);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IllegalStateException("Invalid restart scope".toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
    
        if (r3 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
    
        return new androidx.compose.runtime.RecomposeScopeImpl$end$1$2(r7, r8, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Function1<Composition, Unit> end(final int token) {
        final IdentityArrayIntMap identityArrayIntMap = this.trackedInstances;
        if (identityArrayIntMap == null || getSkipped$runtime_release()) {
            return null;
        }
        int size = identityArrayIntMap.getSize();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            if (identityArrayIntMap.getKeys()[i3] != null) {
                if (identityArrayIntMap.getValues()[i3] != token) {
                    z16 = true;
                    break;
                }
                i3++;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
            }
        }
    }

    public final Anchor getAnchor() {
        return this.anchor;
    }

    public final boolean getCanRecompose() {
        return this.block != null;
    }

    public final CompositionImpl getComposition() {
        return this.composition;
    }

    public final boolean getDefaultsInScope() {
        return (this.flags & 2) != 0;
    }

    public final boolean getDefaultsInvalid() {
        return (this.flags & 4) != 0;
    }

    public final boolean getRequiresRecompose() {
        return (this.flags & 8) != 0;
    }

    public final boolean getSkipped$runtime_release() {
        return (this.flags & 16) != 0;
    }

    public final boolean getUsed() {
        return (this.flags & 1) != 0;
    }

    public final boolean getValid() {
        if (this.composition == null) {
            return false;
        }
        Anchor anchor = this.anchor;
        return anchor != null ? anchor.getValid() : false;
    }

    @Override // androidx.compose.runtime.RecomposeScope
    public void invalidate() {
        CompositionImpl compositionImpl = this.composition;
        if (compositionImpl != null) {
            compositionImpl.invalidate(this, null);
        }
    }

    public final InvalidationResult invalidateForResult(Object value) {
        InvalidationResult invalidate;
        CompositionImpl compositionImpl = this.composition;
        return (compositionImpl == null || (invalidate = compositionImpl.invalidate(this, value)) == null) ? InvalidationResult.IGNORED : invalidate;
    }

    public final boolean isConditional() {
        return this.trackedDependencies != null;
    }

    public final void recordRead(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (getRereading()) {
            return;
        }
        IdentityArrayIntMap identityArrayIntMap = this.trackedInstances;
        if (identityArrayIntMap == null) {
            identityArrayIntMap = new IdentityArrayIntMap();
            this.trackedInstances = identityArrayIntMap;
        }
        identityArrayIntMap.add(instance, this.currentToken);
        if (instance instanceof DerivedState) {
            IdentityArrayMap<DerivedState<?>, Object> identityArrayMap = this.trackedDependencies;
            if (identityArrayMap == null) {
                identityArrayMap = new IdentityArrayMap<>(0, 1, null);
                this.trackedDependencies = identityArrayMap;
            }
            identityArrayMap.set(instance, ((DerivedState) instance).getCurrentValue());
        }
    }

    public final void rereadTrackedInstances() {
        IdentityArrayIntMap identityArrayIntMap;
        CompositionImpl compositionImpl = this.composition;
        if (compositionImpl == null || (identityArrayIntMap = this.trackedInstances) == null) {
            return;
        }
        setRereading(true);
        try {
            int size = identityArrayIntMap.getSize();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = identityArrayIntMap.getKeys()[i3];
                if (obj != null) {
                    int i16 = identityArrayIntMap.getValues()[i3];
                    compositionImpl.recordReadOf(obj);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                }
            }
        } finally {
            setRereading(false);
        }
    }

    public final void setAnchor(Anchor anchor) {
        this.anchor = anchor;
    }

    public final void start(int token) {
        this.currentToken = token;
        setSkipped(false);
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public void updateScope(Function2<? super Composer, ? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.block = block;
    }

    public final void release() {
        this.composition = null;
        this.trackedInstances = null;
        this.trackedDependencies = null;
    }

    public final void scopeSkipped() {
        setSkipped(true);
    }

    private final void setRereading(boolean z16) {
        if (z16) {
            this.flags |= 32;
        } else {
            this.flags &= -33;
        }
    }

    private final void setSkipped(boolean z16) {
        if (z16) {
            this.flags |= 16;
        } else {
            this.flags &= -17;
        }
    }

    public final void setDefaultsInScope(boolean z16) {
        if (z16) {
            this.flags |= 2;
        } else {
            this.flags &= -3;
        }
    }

    public final void setDefaultsInvalid(boolean z16) {
        if (z16) {
            this.flags |= 4;
        } else {
            this.flags &= -5;
        }
    }

    public final void setRequiresRecompose(boolean z16) {
        if (z16) {
            this.flags |= 8;
        } else {
            this.flags &= -9;
        }
    }

    public final void setUsed(boolean z16) {
        if (z16) {
            this.flags |= 1;
        } else {
            this.flags &= -2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isInvalidFor(IdentityArraySet<Object> instances) {
        IdentityArrayMap<DerivedState<?>, Object> identityArrayMap;
        boolean z16;
        if (instances != null && (identityArrayMap = this.trackedDependencies) != 0 && instances.isNotEmpty()) {
            if (!instances.isEmpty()) {
                for (Object obj : instances) {
                    if (!((obj instanceof DerivedState) && Intrinsics.areEqual(identityArrayMap.get(obj), ((DerivedState) obj).getCurrentValue()))) {
                        z16 = false;
                        break;
                    }
                }
            }
            z16 = true;
            if (z16) {
                return false;
            }
        }
        return true;
    }
}
