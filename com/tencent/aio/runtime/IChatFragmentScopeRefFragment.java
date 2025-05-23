package com.tencent.aio.runtime;

import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J/\u0010\b\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\u00062\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJ#\u0010\u000f\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\u00062\u0006\u0010\n\u001a\u00020\u0005H\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011R,\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00078\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/aio/runtime/IChatFragmentScopeRefFragment;", "Landroidx/fragment/app/Fragment;", "()V", "internalChaPieScopeRef", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getRef", "T", "token", "creator", "Lkotlin/Function0;", "getRef$sdk_debug", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getRefOrNull", "getRefOrNull$sdk_debug", "(Ljava/lang/String;)Ljava/lang/Object;", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public class IChatFragmentScopeRefFragment extends ReportAndroidXFragment {
    static IPatchRedirector $redirector_;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private final HashMap<String, Object> internalChaPieScopeRef;

    public IChatFragmentScopeRefFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.internalChaPieScopeRef = new HashMap<>();
        }
    }

    @MainThread
    @NotNull
    public final <T> T getRef$sdk_debug(@NotNull String token, @NotNull Function0<? extends T> creator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (T) iPatchRedirector.redirect((short) 1, (Object) this, (Object) token, (Object) creator);
        }
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(creator, "creator");
        if (!this.internalChaPieScopeRef.containsKey(token)) {
            this.internalChaPieScopeRef.put(token, creator.invoke());
        }
        T t16 = (T) this.internalChaPieScopeRef.get(token);
        if (t16 != null) {
            return t16;
        }
        throw new NullPointerException("null cannot be cast to non-null type T");
    }

    @MainThread
    @Nullable
    public final <T> T getRefOrNull$sdk_debug(@NotNull String token) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) token);
        }
        Intrinsics.checkNotNullParameter(token, "token");
        return (T) this.internalChaPieScopeRef.get(token);
    }
}
