package com.tencent.qqnt.chats.core.adapter.itemdata;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chats.core.adapter.itemdata.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/c;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "newItem", "", "c", "d", "", "id", "Z", "f", "()Z", tl.h.F, "(Z)V", "isTop", "e", "isChanged", "g", "", "()I", "itemViewType", "<init>", "()V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final c f354523c;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isTop;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean isChanged;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40527);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f354523c = new c();
            isChanged = true;
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.itemdata.b
    @NotNull
    public List<com.tencent.qqnt.chats.core.adapter.menu.a> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return b.C9570b.b(this);
    }

    @Override // com.tencent.qqnt.chats.core.adapter.itemdata.b
    @Nullable
    public Object b(@NotNull b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar);
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
        return true;
    }

    @Override // com.tencent.qqnt.chats.core.adapter.itemdata.b
    public boolean d(@NotNull b newItem) {
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) newItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (newItem instanceof c) {
            cVar = (c) newItem;
        } else {
            cVar = null;
        }
        if (cVar == null || isChanged) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.base.adapter.b
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return -4;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return isTop;
    }

    public final void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            isChanged = z16;
        }
    }

    public final void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            isTop = z16;
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.itemdata.b
    public long id() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return -9223372036854775807L;
    }
}
