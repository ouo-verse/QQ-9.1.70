package com.tencent.qqnt.contacts.adapter;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.contacts.data.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/contacts/adapter/e;", "Lcom/tencent/qqnt/base/adapter/c;", "Lcom/tencent/qqnt/contacts/data/f;", "oldItem", "newItem", "", "b", "a", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class e extends com.tencent.qqnt.base.adapter.c<com.tencent.qqnt.contacts.data.f> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f355784a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30352);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f355784a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean areContentsTheSame(@NotNull com.tencent.qqnt.contacts.data.f oldItem, @NotNull com.tencent.qqnt.contacts.data.f newItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if ((oldItem instanceof com.tencent.qqnt.contacts.data.a) && (newItem instanceof com.tencent.qqnt.contacts.data.a)) {
            return Intrinsics.areEqual(((com.tencent.qqnt.contacts.data.a) oldItem).f(), ((com.tencent.qqnt.contacts.data.a) newItem).f());
        }
        if ((oldItem instanceof k) && (newItem instanceof k)) {
            return Intrinsics.areEqual(((k) oldItem).f(), ((k) newItem).f());
        }
        if (!(oldItem instanceof com.tencent.qqnt.contacts.data.g) || !(newItem instanceof com.tencent.qqnt.contacts.data.g) || ((com.tencent.qqnt.contacts.data.g) oldItem).f() != ((com.tencent.qqnt.contacts.data.g) newItem).f()) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean areItemsTheSame(@NotNull com.tencent.qqnt.contacts.data.f oldItem, @NotNull com.tencent.qqnt.contacts.data.f newItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (oldItem.e() == newItem.e()) {
            return true;
        }
        return false;
    }
}
