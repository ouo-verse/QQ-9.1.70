package com.tencent.qqnt.chathistory.ui.menu.data.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u00048\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/menu/data/model/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;", "g", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;", "searchMsgItem", "d", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "keyword", "e", "I", "()I", "itemViewType", "", "Ljava/lang/CharSequence;", h.F, "()Ljava/lang/CharSequence;", "i", "(Ljava/lang/CharSequence;)V", "summaryString", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;Ljava/lang/String;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class b implements com.tencent.qqnt.base.adapter.b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SearchMsgItem searchMsgItem;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String keyword;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int itemViewType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CharSequence summaryString;

    public b(@NotNull SearchMsgItem searchMsgItem, @Nullable String str) {
        Intrinsics.checkNotNullParameter(searchMsgItem, "searchMsgItem");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) searchMsgItem, (Object) str);
        } else {
            this.searchMsgItem = searchMsgItem;
            this.keyword = str;
        }
    }

    @Override // com.tencent.qqnt.base.adapter.b
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.itemViewType;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (Intrinsics.areEqual(this.searchMsgItem, bVar.searchMsgItem) && Intrinsics.areEqual(this.keyword, bVar.keyword)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.keyword;
    }

    @NotNull
    public final SearchMsgItem g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SearchMsgItem) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.searchMsgItem;
    }

    @Nullable
    public final CharSequence h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CharSequence) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.summaryString;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        int hashCode2 = this.searchMsgItem.hashCode() * 31;
        String str = this.keyword;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public final void i(@Nullable CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) charSequence);
        } else {
            this.summaryString = charSequence;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "SearchMsgWithKeywordsItemWrap(searchMsgItem=" + this.searchMsgItem + ", keyword=" + this.keyword + ")";
    }
}
