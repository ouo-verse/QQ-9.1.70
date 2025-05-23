package kk1;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001R0\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\rj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lkk1/d;", "", "Lcom/tencent/mobileqq/guild/feed/gallery/presenter/b;", "presenter", "", "d", "", "b", "c", "", "action", "msg", "a", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "mPresenterMap", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedHashMap<String, com.tencent.mobileqq.guild.feed.gallery.presenter.b> mPresenterMap = new LinkedHashMap<>();

    public final void a(@NotNull String action, @Nullable Object msg2) {
        Intrinsics.checkNotNullParameter(action, "action");
        hj1.b.b("Guild_Feed_GAL_GuildFeedGalleryPresenterManager", "broadcastMessage: action=" + action);
        if (this.mPresenterMap.size() == 0) {
            hj1.b.b("Guild_Feed_GAL_GuildFeedGalleryPresenterManager", "broadcastMessage: hash[" + hashCode() + "] presenter is empty");
        }
        Iterator<String> it = this.mPresenterMap.keySet().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.guild.feed.gallery.presenter.b bVar = this.mPresenterMap.get(it.next());
            if (bVar != null) {
                bVar.g(action, msg2);
            }
        }
    }

    public final boolean b(@NotNull com.tencent.mobileqq.guild.feed.gallery.presenter.b presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        return this.mPresenterMap.containsKey(presenter.getClass().getName());
    }

    public final void c() {
        hj1.b.b("Guild_Feed_GAL_GuildFeedGalleryPresenterManager", "clear: hash[" + hashCode() + "]");
        this.mPresenterMap.clear();
    }

    public final void d(@NotNull com.tencent.mobileqq.guild.feed.gallery.presenter.b presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        if (this.mPresenterMap.get(presenter.getClass().getName()) != null && RFWApplication.isDebug()) {
            throw new RuntimeException("you can not register Same Class Presenter");
        }
        LinkedHashMap<String, com.tencent.mobileqq.guild.feed.gallery.presenter.b> linkedHashMap = this.mPresenterMap;
        String name = presenter.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "presenter.javaClass.name");
        linkedHashMap.put(name, presenter);
    }
}
