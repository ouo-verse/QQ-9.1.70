package com.tencent.mobileqq.troop.deletemember.inject.items;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.selectmember.bean.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/deletemember/inject/items/a;", "Lcom/tencent/mobileqq/troop/selectmember/bean/c;", "", "kotlin.jvm.PlatformType", "e", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "j", "", "b", "a", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "data", "Lcom/tencent/mobileqq/troop/deletemember/inject/items/b;", "Lcom/tencent/mobileqq/troop/deletemember/inject/items/b;", "i", "()Lcom/tencent/mobileqq/troop/deletemember/inject/items/b;", "groupBean", "c", "Z", "canSelect", "<init>", "(Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;Lcom/tencent/mobileqq/troop/deletemember/inject/items/b;Z)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a implements com.tencent.mobileqq.troop.selectmember.bean.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopMemberInfo data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b groupBean;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean canSelect;

    public a(@NotNull TroopMemberInfo data, @NotNull b groupBean, boolean z16) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(groupBean, "groupBean");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, data, groupBean, Boolean.valueOf(z16));
            return;
        }
        this.data = data;
        this.groupBean = groupBean;
        this.canSelect = z16;
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.c
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.canSelect;
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.a
    public boolean d(@NotNull com.tencent.mobileqq.troop.selectmember.bean.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar)).booleanValue();
        }
        return c.a.a(this, aVar);
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.c
    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.data.memberuin;
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.a
    public boolean f(@NotNull com.tencent.mobileqq.troop.selectmember.bean.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar)).booleanValue();
        }
        return c.a.b(this, aVar);
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.c
    public boolean h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, z16)).booleanValue();
        }
        return c.a.c(this, z16);
    }

    @NotNull
    public final b i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.groupBean;
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.a
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public TroopMemberInfo getItemData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.data;
    }
}
