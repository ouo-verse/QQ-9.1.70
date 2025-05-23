package ar1;

import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.main.GuildPageStateManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0002\u0010\u0014\u0018\u0000 \u00062\u00020\u0001:\u0001\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0003J\b\u0010\u0007\u001a\u00020\u0004H\u0003R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001c"}, d2 = {"Lar1/b;", "", "", "durationInMillis", "", "g", "f", "i", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/guild/main/GuildPageStateManager;", "b", "Lcom/tencent/mobileqq/guild/main/GuildPageStateManager;", "pageStateManager", "ar1/d", "c", "Lar1/d;", "scrollListener", "ar1/c", "d", "Lar1/c;", "animateEnableListener", "", "e", "Z", "addedListeners", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView recyclerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildPageStateManager pageStateManager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d scrollListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c animateEnableListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean addedListeners;

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void f() {
        if (this.addedListeners) {
            return;
        }
        this.recyclerView.addOnScrollListener(this.scrollListener);
        this.pageStateManager.i(this.animateEnableListener);
        this.addedListeners = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(long durationInMillis) {
        this.pageStateManager.c(false);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: ar1.a
            @Override // java.lang.Runnable
            public final void run() {
                b.h(b.this);
            }
        }, durationInMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.pageStateManager.c(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void i() {
        this.recyclerView.removeOnScrollListener(this.scrollListener);
        this.pageStateManager.j(this.animateEnableListener);
        this.addedListeners = false;
    }
}
