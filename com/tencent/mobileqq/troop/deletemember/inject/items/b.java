package com.tencent.mobileqq.troop.deletemember.inject.items;

import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.selectmember.bean.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\r\u001a\u00020\bR\u0016\u0010\u000f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000eR$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0010j\b\u0012\u0004\u0012\u00020\u0003`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/deletemember/inject/items/b;", "Lcom/tencent/mobileqq/troop/selectmember/bean/b;", "", "Lcom/tencent/mobileqq/troop/selectmember/bean/c;", "a", "", "isExpanded", "list", "", "g", "c", "child", "i", "k", "Z", "isExpand", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "innerChildList", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class b implements com.tencent.mobileqq.troop.selectmember.bean.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isExpand;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.troop.selectmember.bean.c> innerChildList;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isExpand = true;
            this.innerChildList = new ArrayList<>();
        }
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.b
    @NotNull
    public List<com.tencent.mobileqq.troop.selectmember.bean.c> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.innerChildList;
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.b
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        this.isExpand = !this.isExpand;
        return true;
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.b
    public boolean canShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return b.a.c(this);
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.a
    public boolean d(@NotNull com.tencent.mobileqq.troop.selectmember.bean.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar)).booleanValue();
        }
        return b.a.a(this, aVar);
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.a
    public boolean f(@NotNull com.tencent.mobileqq.troop.selectmember.bean.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar)).booleanValue();
        }
        return b.a.b(this, aVar);
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.b
    public void g(@NotNull List<? extends com.tencent.mobileqq.troop.selectmember.bean.c> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        } else {
            Intrinsics.checkNotNullParameter(list, "list");
            this.innerChildList.removeAll(list);
        }
    }

    public final void i(@NotNull com.tencent.mobileqq.troop.selectmember.bean.c child) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) child);
        } else {
            Intrinsics.checkNotNullParameter(child, "child");
            this.innerChildList.add(child);
        }
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.b
    public boolean isExpanded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isExpand;
    }

    @Nullable
    public List<com.tencent.mobileqq.troop.selectmember.bean.c> j(@Nullable LiveData<List<com.tencent.mobileqq.troop.selectmember.bean.c>> liveData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this, (Object) liveData);
        }
        return b.a.e(this, liveData);
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (!this.innerChildList.isEmpty()) {
            Collections.sort(this.innerChildList, com.tencent.mobileqq.troop.deletemember.inject.a.f295019d);
        }
    }
}
