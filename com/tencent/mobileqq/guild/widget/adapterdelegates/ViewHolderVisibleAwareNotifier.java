package com.tencent.mobileqq.guild.widget.adapterdelegates;

import androidx.annotation.UiThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007R$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/adapterdelegates/ViewHolderVisibleAwareNotifier;", "", "", "newVisible", "", "f", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "", "from", "b", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "d", "e", "Ljava/util/LinkedHashSet;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/n;", "Lkotlin/collections/LinkedHashSet;", "a", "Ljava/util/LinkedHashSet;", "viewHolders", "Z", NodeProps.VISIBLE, "<init>", "()V", "c", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ViewHolderVisibleAwareNotifier {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedHashSet<n> viewHolders = new LinkedHashSet<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean visible;

    public static /* synthetic */ void c(ViewHolderVisibleAwareNotifier viewHolderVisibleAwareNotifier, LifecycleOwner lifecycleOwner, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "undefined";
        }
        viewHolderVisibleAwareNotifier.b(lifecycleOwner, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void f(boolean newVisible) {
        if (this.visible == newVisible) {
            return;
        }
        for (n nVar : this.viewHolders) {
            Logger logger = Logger.f235387a;
            nVar.onVisibleChanged(newVisible);
        }
        this.visible = newVisible;
    }

    @UiThread
    public final void b(@NotNull final LifecycleOwner viewLifecycleOwner, @NotNull String from) {
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(from, "from");
        Logger.f235387a.d().i("Guild.comm.ViewHolderVisibleAwareNotifier", 1, '[' + hashCode() + "] install, viewLifecycleOwner: " + viewLifecycleOwner + ", from: " + from);
        viewLifecycleOwner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.widget.adapterdelegates.ViewHolderVisibleAwareNotifier$install$2
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                Logger.f235387a.d().i("Guild.comm.ViewHolderVisibleAwareNotifier", 1, '[' + hashCode() + "] onStateChanged: " + event);
                if (event == Lifecycle.Event.ON_RESUME) {
                    ViewHolderVisibleAwareNotifier.this.f(true);
                } else if (event == Lifecycle.Event.ON_PAUSE) {
                    ViewHolderVisibleAwareNotifier.this.f(false);
                }
                if (event == Lifecycle.Event.ON_DESTROY) {
                    viewLifecycleOwner.getLifecycle().removeObserver(this);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @UiThread
    public final void d(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (!(viewHolder instanceof n)) {
            return;
        }
        this.viewHolders.add(viewHolder);
        if (this.visible) {
            Logger logger = Logger.f235387a;
            ((n) viewHolder).onVisibleChanged(true);
        } else {
            Logger logger2 = Logger.f235387a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @UiThread
    public final void e(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (!(viewHolder instanceof n)) {
            return;
        }
        this.viewHolders.remove(viewHolder);
        Logger logger = Logger.f235387a;
        ((n) viewHolder).onVisibleChanged(false);
    }
}
