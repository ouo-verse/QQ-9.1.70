package com.tencent.mobileqq.troop.selectmember.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.selectmember.bean.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016J\u0016\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016J\u0014\u0010\r\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\bR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/bean/e;", "Lcom/tencent/mobileqq/troop/selectmember/bean/b;", "", "k", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/selectmember/bean/c;", "Lkotlin/collections/ArrayList;", "j", "", "list", "", "g", "childs", "i", "a", "Ljava/lang/String;", "showText", "b", "Ljava/util/ArrayList;", "curChildList", "<init>", "(Ljava/lang/String;)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String showText;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<c> curChildList;

    public e(@NotNull String showText) {
        Intrinsics.checkNotNullParameter(showText, "showText");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) showText);
        } else {
            this.showText = showText;
            this.curChildList = new ArrayList<>();
        }
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.b
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return b.a.d(this);
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.b
    public boolean canShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return b.a.c(this);
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.a
    public boolean d(@NotNull a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar)).booleanValue();
        }
        return b.a.a(this, aVar);
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.a
    public boolean f(@NotNull a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) aVar)).booleanValue();
        }
        return b.a.b(this, aVar);
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.b
    public void g(@NotNull List<? extends c> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        } else {
            Intrinsics.checkNotNullParameter(list, "list");
            this.curChildList.removeAll(list);
        }
    }

    public final void i(@NotNull List<? extends c> childs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) childs);
        } else {
            Intrinsics.checkNotNullParameter(childs, "childs");
            this.curChildList.addAll(childs);
        }
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.b
    public boolean isExpanded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return b.a.f(this);
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.b
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public ArrayList<c> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.curChildList;
    }

    @Override // com.tencent.mobileqq.troop.selectmember.bean.a
    @NotNull
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public String getItemData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.showText;
    }
}
