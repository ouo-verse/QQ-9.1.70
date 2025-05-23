package bk1;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartLifecycleCallbacks;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.j;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vi1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u001b\u001c\u001dJ\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016R\u0014\u0010\u0010\u001a\u00020\r8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u001a\u001a\u0012\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00170\u00160\u00158&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lbk1/a;", "Lak1/b;", "Lcom/tencent/biz/richframework/part/PartLifecycleCallbacks;", "Lcom/tencent/biz/richframework/part/Part;", "part", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "sectionContext", "", "q7", "Lak1/a;", "partApi", "M2", h.F, "", "getTag", "()Ljava/lang/String;", "tag", "Lbk1/a$d;", "v5", "()Lbk1/a$d;", "feedViewInitializer", "", "Lbk1/a$a;", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()[Lbk1/a$a;", "workers", "a", "b", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface a extends ak1.b, PartLifecycleCallbacks {

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0001*\u0004\b\u0001\u0010\u00032\u00020\u0004B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0016\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0005J\u0015\u0010\u000b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\rH\u0016J\u0017\u0010\u000f\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH&\u00a2\u0006\u0004\b\u000f\u0010\fJ\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0017J\b\u0010\u0013\u001a\u00020\u0007H\u0017R$\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00008\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R*\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u00058\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lbk1/a$a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Adapter", "SessionLowerType", "Lqz0/a;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "sectionContext", "", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/j;", DownloadInfo.spKey_Config, "a", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/j;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lbk1/a$b;", "c", "f", "Lvi1/e;", "listUIOperationApi", h.F, "destroy", "<set-?>", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "b", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "d", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "g", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;)V", "context", "Lbk1/a$b;", "workDelegate", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bk1.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static abstract class AbstractC0131a<Adapter extends RecyclerView.Adapter<?>, SessionLowerType> implements qz0.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private Adapter adapter;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<? extends SessionLowerType> context;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final b<Adapter, SessionLowerType> workDelegate = c();

        @NotNull
        public final Adapter a(@NotNull j config) {
            Intrinsics.checkNotNullParameter(config, "config");
            Adapter f16 = f(config);
            this.adapter = f16;
            b<Adapter, SessionLowerType> bVar = this.workDelegate;
            if (bVar != null) {
                bVar.g(f16);
            }
            return f16;
        }

        @NotNull
        public final Adapter b() {
            Adapter adapter = this.adapter;
            if (adapter != null) {
                return adapter;
            }
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            return null;
        }

        @Nullable
        public b<Adapter, SessionLowerType> c() {
            return null;
        }

        @NotNull
        public final com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<? extends SessionLowerType> d() {
            com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<? extends SessionLowerType> bVar = this.context;
            if (bVar != null) {
                return bVar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("context");
            return null;
        }

        @Override // qz0.a
        @CallSuper
        public void destroy() {
            b<Adapter, SessionLowerType> bVar = this.workDelegate;
            if (bVar != null) {
                bVar.destroy();
            }
        }

        public final void e(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<? extends SessionLowerType> sectionContext) {
            Intrinsics.checkNotNullParameter(sectionContext, "sectionContext");
            g(sectionContext);
            b<Adapter, SessionLowerType> bVar = this.workDelegate;
            if (bVar != null) {
                bVar.f(sectionContext);
            }
        }

        @NotNull
        public abstract Adapter f(@NotNull j config);

        public final void g(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<? extends SessionLowerType> bVar) {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.context = bVar;
        }

        @CallSuper
        public void h(@NotNull e listUIOperationApi) {
            Intrinsics.checkNotNullParameter(listUIOperationApi, "listUIOperationApi");
            b<Adapter, SessionLowerType> bVar = this.workDelegate;
            if (bVar != null) {
                bVar.i(listUIOperationApi);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0001*\u0004\b\u0001\u0010\u00032\u00020\u0004B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0005J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&R*\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u00058\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\u00028\u00008\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lbk1/a$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Adapter", "SessionLowerType", "Lqz0/a;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "sectionContext", "", "f", "Lvi1/e;", "listUIOperationApi", "i", "a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "e", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", h.F, "(Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;)V", "context", "b", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "d", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "g", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "adapter", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static abstract class b<Adapter extends RecyclerView.Adapter<?>, SessionLowerType> implements qz0.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<? extends SessionLowerType> context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public Adapter adapter;

        @NotNull
        public final Adapter d() {
            Adapter adapter = this.adapter;
            if (adapter != null) {
                return adapter;
            }
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            return null;
        }

        @NotNull
        public final com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<? extends SessionLowerType> e() {
            com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<? extends SessionLowerType> bVar = this.context;
            if (bVar != null) {
                return bVar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("context");
            return null;
        }

        public final void f(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<? extends SessionLowerType> sectionContext) {
            Intrinsics.checkNotNullParameter(sectionContext, "sectionContext");
            h(sectionContext);
        }

        public final void g(@NotNull Adapter adapter) {
            Intrinsics.checkNotNullParameter(adapter, "<set-?>");
            this.adapter = adapter;
        }

        public final void h(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<? extends SessionLowerType> bVar) {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.context = bVar;
        }

        public abstract void i(@NotNull e listUIOperationApi);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lbk1/a$d;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/j;", DownloadInfo.spKey_Config, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface d {
        @NotNull
        RecyclerView a(@Nullable RecyclerView recyclerView, @NotNull View rootView, @NotNull j config);
    }

    void M2(@NotNull Part part, @NotNull ak1.a partApi);

    @NotNull
    AbstractC0131a<?, Object>[] a2();

    @NotNull
    String getTag();

    void h();

    void q7(@NotNull Part part, @NotNull com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<?> sectionContext);

    @NotNull
    d v5();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class c {
        public static void a(@NotNull a aVar) {
        }
    }
}
