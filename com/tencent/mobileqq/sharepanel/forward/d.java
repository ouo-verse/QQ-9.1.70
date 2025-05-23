package com.tencent.mobileqq.sharepanel.forward;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u001e\u0010\u001fR2\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0005\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\r\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/sharepanel/forward/d;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "setTargetList", "(Ljava/util/ArrayList;)V", "targetList", "Lcom/tencent/mobileqq/sharepanel/forward/f;", "b", "Lcom/tencent/mobileqq/sharepanel/forward/f;", "d", "()Lcom/tencent/mobileqq/sharepanel/forward/f;", "uiControl", "Lcom/tencent/mobileqq/sharepanel/forward/a;", "Lcom/tencent/mobileqq/sharepanel/forward/a;", "()Lcom/tencent/mobileqq/sharepanel/forward/a;", "e", "(Lcom/tencent/mobileqq/sharepanel/forward/a;)V", "eventListener", "Lcom/tencent/mobileqq/sharepanel/forward/e;", "Lcom/tencent/mobileqq/sharepanel/forward/e;", "()Lcom/tencent/mobileqq/sharepanel/forward/e;", "f", "(Lcom/tencent/mobileqq/sharepanel/forward/e;)V", "reportDelegate", "<init>", "(Ljava/util/ArrayList;Lcom/tencent/mobileqq/sharepanel/forward/f;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<SharePanelContactItem> targetList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f uiControl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a eventListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e reportDelegate;

    public d(@NotNull ArrayList<SharePanelContactItem> targetList, @NotNull f uiControl) {
        Intrinsics.checkNotNullParameter(targetList, "targetList");
        Intrinsics.checkNotNullParameter(uiControl, "uiControl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) targetList, (Object) uiControl);
        } else {
            this.targetList = targetList;
            this.uiControl = uiControl;
        }
    }

    @Nullable
    public final a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.eventListener;
    }

    @Nullable
    public final e b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (e) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.reportDelegate;
    }

    @NotNull
    public final ArrayList<SharePanelContactItem> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.targetList;
    }

    @NotNull
    public final f d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.uiControl;
    }

    public final void e(@Nullable a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        } else {
            this.eventListener = aVar;
        }
    }

    public final void f(@Nullable e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) eVar);
        } else {
            this.reportDelegate = eVar;
        }
    }
}
