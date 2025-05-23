package com.tencent.qqnt.contacts.widget.adapter.provider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.contacts.widget.adapter.BaseProviderMultiAdapter;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b+\u0010,J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\u001f\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00028\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\rH\u0016R\"\u0010$\u001a\u00020\u001e8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010'\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010&R\u0014\u0010*\u001a\u00020\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/contacts/widget/adapter/provider/a;", "T", "", "Lcom/tencent/qqnt/contacts/widget/adapter/BaseProviderMultiAdapter;", "adapter", "", "k", "(Lcom/tencent/qqnt/contacts/widget/adapter/BaseProviderMultiAdapter;)V", "d", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "c", "Lcom/tencent/qqnt/contacts/widget/adapter/a;", "helper", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "a", "(Lcom/tencent/qqnt/contacts/widget/adapter/a;Ljava/lang/Object;)V", "", "payloads", "b", "(Lcom/tencent/qqnt/contacts/widget/adapter/a;Ljava/lang/Object;Ljava/util/List;)V", "", "viewType", "g", "viewHolder", "j", "holder", h.F, "i", "Landroid/content/Context;", "Landroid/content/Context;", "e", "()Landroid/content/Context;", "l", "(Landroid/content/Context;)V", "context", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "weakAdapter", "f", "()I", "itemViewType", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class a<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<BaseProviderMultiAdapter<T>> weakAdapter;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(@NotNull com.tencent.qqnt.contacts.widget.adapter.a helper, T item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) helper, (Object) item);
        } else {
            Intrinsics.checkNotNullParameter(helper, "helper");
        }
    }

    public void b(@NotNull com.tencent.qqnt.contacts.widget.adapter.a helper, T item, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, helper, item, payloads);
        } else {
            Intrinsics.checkNotNullParameter(helper, "helper");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
        }
    }

    @NotNull
    public abstract View c(@NotNull ViewGroup parent);

    @Nullable
    public BaseProviderMultiAdapter<T> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BaseProviderMultiAdapter) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        WeakReference<BaseProviderMultiAdapter<T>> weakReference = this.weakAdapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @NotNull
    public final Context e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Context context = this.context;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    public abstract int f();

    @NotNull
    public com.tencent.qqnt.contacts.widget.adapter.a g(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.qqnt.contacts.widget.adapter.a) iPatchRedirector.redirect((short) 8, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new com.tencent.qqnt.contacts.widget.adapter.a(c(parent));
    }

    public void h(@NotNull com.tencent.qqnt.contacts.widget.adapter.a holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) holder);
        } else {
            Intrinsics.checkNotNullParameter(holder, "holder");
        }
    }

    public void i(@NotNull com.tencent.qqnt.contacts.widget.adapter.a holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) holder);
        } else {
            Intrinsics.checkNotNullParameter(holder, "holder");
        }
    }

    public void j(@NotNull com.tencent.qqnt.contacts.widget.adapter.a viewHolder, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) viewHolder, viewType);
        } else {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }
    }

    public final void k(@NotNull BaseProviderMultiAdapter<T> adapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) adapter);
        } else {
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.weakAdapter = new WeakReference<>(adapter);
        }
    }

    public final void l(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.context = context;
        }
    }
}
