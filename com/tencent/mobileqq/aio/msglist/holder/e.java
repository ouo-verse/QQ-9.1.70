package com.tencent.mobileqq.aio.msglist.holder;

import android.view.View;
import com.tencent.mobileqq.aio.msglist.holder.template.n;
import com.tencent.mobileqq.aio.msglist.x;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u0004\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\n\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b\u0010\u0010\u001bR\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/aio/msglist/holder/template/n;", "a", "Lcom/tencent/mobileqq/aio/msglist/holder/template/n;", "c", "()Lcom/tencent/mobileqq/aio/msglist/holder/template/n;", "template", "Landroid/view/View;", "b", "Landroid/view/View;", "d", "()Landroid/view/View;", "templateView", "Lcom/tencent/mobileqq/aio/msglist/holder/g;", "Lcom/tencent/mobileqq/aio/msglist/holder/g;", "()Lcom/tencent/mobileqq/aio/msglist/holder/g;", "componentProvider", "Lcom/tencent/mobileqq/aio/msglist/x;", "Lcom/tencent/mobileqq/aio/msglist/x;", "()Lcom/tencent/mobileqq/aio/msglist/x;", "factoryProvider", "e", "I", "()I", "viewType", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/template/n;Landroid/view/View;Lcom/tencent/mobileqq/aio/msglist/holder/g;Lcom/tencent/mobileqq/aio/msglist/x;I)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final /* data */ class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final n template;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View templateView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g componentProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final x factoryProvider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int viewType;

    public e(@NotNull n template, @NotNull View templateView, @NotNull g componentProvider, @NotNull x factoryProvider, int i3) {
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(templateView, "templateView");
        Intrinsics.checkNotNullParameter(componentProvider, "componentProvider");
        Intrinsics.checkNotNullParameter(factoryProvider, "factoryProvider");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, template, templateView, componentProvider, factoryProvider, Integer.valueOf(i3));
            return;
        }
        this.template = template;
        this.templateView = templateView;
        this.componentProvider = componentProvider;
        this.factoryProvider = factoryProvider;
        this.viewType = i3;
    }

    @NotNull
    public final g a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (g) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.componentProvider;
    }

    @NotNull
    public final x b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (x) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.factoryProvider;
    }

    @NotNull
    public final n c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (n) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.template;
    }

    @NotNull
    public final View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.templateView;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.viewType;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        if (Intrinsics.areEqual(this.template, eVar.template) && Intrinsics.areEqual(this.templateView, eVar.templateView) && Intrinsics.areEqual(this.componentProvider, eVar.componentProvider) && Intrinsics.areEqual(this.factoryProvider, eVar.factoryProvider) && this.viewType == eVar.viewType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return (((((((this.template.hashCode() * 31) + this.templateView.hashCode()) * 31) + this.componentProvider.hashCode()) * 31) + this.factoryProvider.hashCode()) * 31) + this.viewType;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "BubbleMsgItemVBArgs(template=" + this.template + ", templateView=" + this.templateView + ", componentProvider=" + this.componentProvider + ", factoryProvider=" + this.factoryProvider + ", viewType=" + this.viewType + ")";
    }
}
