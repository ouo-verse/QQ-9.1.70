package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event;

import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/PanelEventHandler;", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/e;", "observer", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/d;", "", "eventFilter", "", "b", "event", "a", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/PanelEventHandler$a;", "Ljava/util/List;", "eventObservers", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PanelEventHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ObserverWrapper> eventObservers = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/PanelEventHandler$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/d;", "a", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "eventFilter", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/e;", "b", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/e;", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/e;", "observer", "<init>", "(Lkotlin/jvm/functions/Function1;Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/e;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.PanelEventHandler$a, reason: from toString */
    /* loaded from: classes17.dex */
    public static final /* data */ class ObserverWrapper {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Function1<d, Boolean> eventFilter;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final e observer;

        /* JADX WARN: Multi-variable type inference failed */
        public ObserverWrapper(@NotNull Function1<? super d, Boolean> eventFilter, @NotNull e observer) {
            Intrinsics.checkNotNullParameter(eventFilter, "eventFilter");
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.eventFilter = eventFilter;
            this.observer = observer;
        }

        @NotNull
        public final Function1<d, Boolean> a() {
            return this.eventFilter;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final e getObserver() {
            return this.observer;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ObserverWrapper)) {
                return false;
            }
            ObserverWrapper observerWrapper = (ObserverWrapper) other;
            if (Intrinsics.areEqual(this.eventFilter, observerWrapper.eventFilter) && Intrinsics.areEqual(this.observer, observerWrapper.observer)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.eventFilter.hashCode() * 31) + this.observer.hashCode();
        }

        @NotNull
        public String toString() {
            return "ObserverWrapper(eventFilter=" + this.eventFilter + ", observer=" + this.observer + ")";
        }
    }

    public final void a(@NotNull d event) {
        Intrinsics.checkNotNullParameter(event, "event");
        List<ObserverWrapper> list = this.eventObservers;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ObserverWrapper) obj).a().invoke(event).booleanValue()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ObserverWrapper) it.next()).getObserver().N8(event);
        }
    }

    public final void b(@NotNull final e observer, @NotNull Function1<? super d, Boolean> eventFilter) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(eventFilter, "eventFilter");
        List<ObserverWrapper> list = this.eventObservers;
        CollectionsKt__MutableCollectionsKt.removeAll((List) list, (Function1) new Function1<ObserverWrapper, Boolean>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.PanelEventHandler$registerObserver$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull PanelEventHandler.ObserverWrapper it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getObserver() == e.this);
            }
        });
        list.add(new ObserverWrapper(eventFilter, observer));
    }
}
