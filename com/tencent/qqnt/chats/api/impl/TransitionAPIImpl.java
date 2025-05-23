package com.tencent.qqnt.chats.api.impl;

import android.view.View;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.api.ITransitionAPI;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u001e\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u0005H\u0016R6\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/TransitionAPIImpl;", "Lcom/tencent/qqnt/chats/api/ITransitionAPI;", "()V", "cache", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "Lkotlin/collections/HashMap;", "addViewToTransitionPool", "", "view", "tag", "getViewToTransitionPool", "Landroidx/core/util/Pair;", "chats_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class TransitionAPIImpl implements ITransitionAPI {
    static IPatchRedirector $redirector_;

    @NotNull
    private final HashMap<String, WeakReference<View>> cache;

    public TransitionAPIImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.cache = new HashMap<>();
        }
    }

    @Override // com.tencent.qqnt.chats.api.ITransitionAPI
    public void addViewToTransitionPool(@NotNull View view, @NotNull String tag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) tag);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.cache.put(tag, new WeakReference<>(view));
        ViewCompat.setTransitionName(view, tag);
    }

    @Override // com.tencent.qqnt.chats.api.ITransitionAPI
    @Nullable
    public Pair<View, String> getViewToTransitionPool(@NotNull String tag) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, (Object) this, (Object) tag);
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        WeakReference<View> weakReference = this.cache.get(tag);
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view == null) {
            return null;
        }
        return new Pair<>(weakReference.get(), tag);
    }
}
