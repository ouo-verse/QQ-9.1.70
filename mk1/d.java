package mk1;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"Lmk1/d;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "", "a", "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getRecycledView", "scrap", "putRecycledView", "max", "setMaxRecycledViews", "<init>", "()V", "f", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends RecyclerView.RecycledViewPool {
    public d() {
        a();
    }

    private final void a() {
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryCacheRecyclePool", 1, "[initCacheViewPoolSize] ");
        setMaxRecycledViews(1000, 1);
        setMaxRecycledViews(0, 1);
        setMaxRecycledViews(1, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    @Nullable
    public RecyclerView.ViewHolder getRecycledView(int viewType) {
        try {
            return super.getRecycledView(viewType);
        } catch (Throwable th5) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "getRecycledView " + viewType + " error!!!";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild_Feed_GAL_GuildFeedGalleryCacheRecyclePool", 1, (String) it.next(), th5);
            }
            return null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public void putRecycledView(@Nullable RecyclerView.ViewHolder scrap) {
        try {
            super.putRecycledView(scrap);
        } catch (Throwable th5) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "putRecycledView " + scrap + " error!!!";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild_Feed_GAL_GuildFeedGalleryCacheRecyclePool", 1, (String) it.next(), th5);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public void setMaxRecycledViews(int viewType, int max) {
        try {
            super.setMaxRecycledViews(viewType, max);
        } catch (Throwable th5) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "setMaxRecycledViews " + viewType + " error!!!";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild_Feed_GAL_GuildFeedGalleryCacheRecyclePool", 1, (String) it.next(), th5);
            }
        }
    }
}
