package com.tencent.qqnt.rich.part;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.rich.j;
import com.tencent.qqnt.rich.k;
import com.tencent.qqnt.rich.l;
import com.tencent.qqnt.rich.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u001a\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u000f\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/rich/part/a;", "Lcom/tencent/qqnt/rich/a;", "Landroidx/constraintlayout/widget/ConstraintLayout;", ParseCommon.CONTAINER, "Lcom/tencent/qqnt/rich/j;", "richData", "", "a", "", "action", "", "objects", "", "r0", "Landroid/content/Context;", "d", "Landroid/content/Context;", "b", "()Landroid/content/Context;", "context", "Lcom/tencent/qqnt/rich/m;", "e", "Lcom/tencent/qqnt/rich/m;", "c", "()Lcom/tencent/qqnt/rich/m;", "helper", "Lcom/tencent/qqnt/rich/l;", "f", "Lcom/tencent/qqnt/rich/l;", "()Lcom/tencent/qqnt/rich/l;", "richFactory", "Lcom/tencent/qqnt/rich/k;", "extParam", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/rich/m;Lcom/tencent/qqnt/rich/k;Lcom/tencent/qqnt/rich/l;)V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class a implements com.tencent.qqnt.rich.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m helper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final l richFactory;

    public a(@NotNull Context context, @NotNull m helper, @NotNull k extParam, @NotNull l richFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(extParam, "extParam");
        Intrinsics.checkNotNullParameter(richFactory, "richFactory");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, helper, extParam, richFactory);
            return;
        }
        this.context = context;
        this.helper = helper;
        this.richFactory = richFactory;
        helper.a(this);
    }

    public abstract boolean a(@NotNull ConstraintLayout container, @NotNull j richData);

    @NotNull
    public final Context b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    @NotNull
    public final m c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (m) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.helper;
    }

    @NotNull
    public final l d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (l) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.richFactory;
    }

    @Override // com.tencent.qqnt.rich.a
    public void r0(@NotNull String action, @Nullable Object objects) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) action, objects);
        } else {
            Intrinsics.checkNotNullParameter(action, "action");
        }
    }
}
