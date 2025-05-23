package com.tencent.mobileqq.unusedcodecheck;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\f\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001b\u0010\u000b\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0007\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/LoadResult;", "", "", "c", "", "toString", "", "a", "Lkotlin/Lazy;", "b", "()F", "loadRate", "", "Ljava/util/Set;", "d", "()Ljava/util/Set;", "processNames", "", "Lcom/tencent/mobileqq/unusedcodecheck/LoadedClassInfoObject;", "Ljava/util/List;", "()Ljava/util/List;", "setAllPartInfos", "(Ljava/util/List;)V", "allPartInfos", "<init>", "(Ljava/util/Set;Ljava/util/List;)V", "unusedcode-check_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public final class LoadResult {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadRate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> processNames;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends LoadedClassInfoObject> allPartInfos;

    public LoadResult(@NotNull Set<String> processNames, @NotNull List<? extends LoadedClassInfoObject> allPartInfos) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(processNames, "processNames");
        Intrinsics.checkNotNullParameter(allPartInfos, "allPartInfos");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) processNames, (Object) allPartInfos);
            return;
        }
        this.processNames = processNames;
        this.allPartInfos = allPartInfos;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.mobileqq.unusedcodecheck.LoadResult$loadRate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) LoadResult.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return ((Float) iPatchRedirector2.redirect((short) 1, (Object) this)).floatValue();
                }
                if (LoadResult.this.a().isEmpty()) {
                    return 0.0f;
                }
                int i3 = 0;
                int i16 = 0;
                for (LoadedClassInfoObject loadedClassInfoObject : LoadResult.this.a()) {
                    i16 += loadedClassInfoObject.getPartClassCount();
                    i3 += loadedClassInfoObject.getMarker().cardinality();
                }
                float f16 = i3 / i16;
                b.f306127n.n().c("UnusedCodeCheck.Analysis", "checkReportNecessity allLoadedClassCount:" + i3 + " allClassCount:" + i16 + " loadRate:" + f16);
                return f16;
            }
        });
        this.loadRate = lazy;
    }

    @NotNull
    public final List<LoadedClassInfoObject> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.allPartInfos;
    }

    public final float b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Float) iPatchRedirector.redirect((short) 1, (Object) this)).floatValue();
        }
        return ((Number) this.loadRate.getValue()).floatValue();
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.processNames.size();
    }

    @NotNull
    public final Set<String> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.processNames;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "LoadResult(processCount=" + this.processNames.size() + ", partSize=" + this.allPartInfos.size() + ", loadRate=" + b() + ')';
    }
}
