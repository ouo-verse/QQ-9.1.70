package com.tencent.qqnt.contacts.data.item;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/contacts/data/item/a;", "Lcom/tencent/qqnt/contacts/widget/adapter/node/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "title", "", "Lcom/tencent/qqnt/contacts/data/item/b;", "Ljava/util/List;", "getBuddyList", "()Ljava/util/List;", "buddyList", "Lcom/tencent/qqnt/contacts/widget/adapter/node/b;", "a", "childNode", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final /* data */ class a extends com.tencent.qqnt.contacts.widget.adapter.node.a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<b> buddyList;

    @Override // com.tencent.qqnt.contacts.widget.adapter.node.b
    @NotNull
    public List<com.tencent.qqnt.contacts.widget.adapter.node.b> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        List<b> list = this.buddyList;
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.qqnt.contacts.widget.adapter.node.BaseNode>");
        return TypeIntrinsics.asMutableList(list);
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.title;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.title, aVar.title) && Intrinsics.areEqual(this.buddyList, aVar.buddyList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return (this.title.hashCode() * 31) + this.buddyList.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "BuddyGroupItem(title=" + this.title + ", buddyList=" + this.buddyList + ")";
    }
}
