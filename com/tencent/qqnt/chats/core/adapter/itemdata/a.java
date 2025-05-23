package com.tencent.qqnt.chats.core.adapter.itemdata;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.core.adapter.itemdata.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "newItem", "", "c", "d", "", "id", "Landroid/view/View;", "Landroid/view/View;", "f", "()Landroid/view/View;", "banner", "Z", "g", "()Z", "i", "(Z)V", "isTop", "e", "isChanged", tl.h.F, "", "()I", "itemViewType", "<init>", "(Landroid/view/View;)V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View banner;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isTop;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isChanged;

    public a(@NotNull View banner) {
        Intrinsics.checkNotNullParameter(banner, "banner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) banner);
        } else {
            this.banner = banner;
            this.isChanged = true;
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.itemdata.b
    @NotNull
    public List<com.tencent.qqnt.chats.core.adapter.menu.a> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return b.C9570b.b(this);
    }

    @Override // com.tencent.qqnt.chats.core.adapter.itemdata.b
    @Nullable
    public Object b(@NotNull b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return iPatchRedirector.redirect((short) 12, (Object) this, (Object) bVar);
        }
        return b.C9570b.a(this, bVar);
    }

    @Override // com.tencent.qqnt.chats.core.adapter.itemdata.b
    public boolean c(@NotNull b newItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) newItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (newItem instanceof a) {
            return Intrinsics.areEqual(this.banner, ((a) newItem).banner);
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.core.adapter.itemdata.b
    public boolean d(@NotNull b newItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) newItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof a)) {
            return false;
        }
        a aVar = (a) newItem;
        if (!Intrinsics.areEqual(this.banner, aVar.banner) || aVar.isChanged) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.base.adapter.b
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return -2;
    }

    @NotNull
    public final View f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.banner;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isTop;
    }

    public final void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.isChanged = z16;
        }
    }

    public final void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.isTop = z16;
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.itemdata.b
    public long id() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.banner.hashCode();
    }
}
