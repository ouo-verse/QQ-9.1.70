package com.tencent.mobileqq.troop.findTroop.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0001J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0001R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\rR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/findTroop/util/c;", "", "Lcom/tencent/mobileqq/troop/findTroop/util/b;", "node", "", "a", "e", "b", "", "nodeId", "event", "c", "d", "Lcom/tencent/mobileqq/troop/findTroop/util/b;", "currentNode", "", "Ljava/util/Map;", "childNodes", "parentNode", "<init>", "(Lcom/tencent/mobileqq/troop/findTroop/util/b;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b currentNode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, b> childNodes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b parentNode;

    public c(@NotNull b currentNode) {
        Intrinsics.checkNotNullParameter(currentNode, "currentNode");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) currentNode);
        } else {
            this.currentNode = currentNode;
            this.childNodes = new LinkedHashMap();
        }
    }

    public final void a(@NotNull b node) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) node);
            return;
        }
        Intrinsics.checkNotNullParameter(node, "node");
        this.childNodes.put(node.af(), node);
        c F5 = node.F5();
        if (F5 != null) {
            F5.parentNode = this.currentNode;
        }
    }

    public final void b() {
        c F5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        b bVar = this.parentNode;
        if (bVar != null && (F5 = bVar.F5()) != null) {
            F5.e(this.currentNode);
        }
        Iterator<T> it = this.childNodes.values().iterator();
        while (it.hasNext()) {
            c F52 = ((b) it.next()).F5();
            if (F52 != null) {
                F52.parentNode = null;
            }
        }
        this.childNodes.clear();
    }

    public final void c(@NotNull String nodeId, @NotNull Object event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) nodeId, event);
            return;
        }
        Intrinsics.checkNotNullParameter(nodeId, "nodeId");
        Intrinsics.checkNotNullParameter(event, "event");
        b bVar = this.childNodes.get(nodeId);
        if (bVar != null) {
            bVar.R2(event);
        }
    }

    public final void d(@NotNull Object event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        b bVar = this.parentNode;
        if (bVar != null) {
            bVar.R2(event);
        }
    }

    public final void e(@NotNull b node) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) node);
            return;
        }
        Intrinsics.checkNotNullParameter(node, "node");
        if (!this.childNodes.containsKey(node.af())) {
            return;
        }
        this.childNodes.remove(node.af());
        c F5 = node.F5();
        if (F5 != null) {
            F5.parentNode = null;
        }
    }
}
