package com.tencent.mobileqq.qqlive.sail.ui.more;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\t\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/e;", "", "", "b", "Lar4/a;", "bubbleTip", "a", "", "d", "c", "I", "maxSize", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "<init>", "(I)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int maxSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<ar4.a> queue;

    public e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.maxSize = i3;
            this.queue = new LinkedList<>();
        }
    }

    public final void a(@NotNull ar4.a bubbleTip) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bubbleTip);
            return;
        }
        Intrinsics.checkNotNullParameter(bubbleTip, "bubbleTip");
        if (this.queue.isEmpty()) {
            this.queue.add(bubbleTip);
            return;
        }
        if (this.queue.size() >= this.maxSize) {
            this.queue.removeLast();
        }
        LinkedList linkedList = new LinkedList();
        boolean z16 = false;
        while (!this.queue.isEmpty()) {
            ar4.a poll = this.queue.poll();
            if (bubbleTip.f26817h < poll.f26817h && !z16) {
                linkedList.add(bubbleTip);
                z16 = true;
            }
            linkedList.add(poll);
        }
        if (!z16) {
            linkedList.add(bubbleTip);
        }
        this.queue.addAll(linkedList);
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.queue.clear();
        }
    }

    @Nullable
    public final ar4.a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ar4.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.queue.isEmpty()) {
            return null;
        }
        return this.queue.pollFirst();
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.queue.size();
    }
}
