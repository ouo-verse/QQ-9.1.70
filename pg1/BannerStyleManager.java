package pg1;

import android.view.View;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.cache.api.Business;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0010J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0016R\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\u001a\u0010$\u001a\u00020 8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010,\u00a8\u00060"}, d2 = {"Lpg1/e;", "", "", "e", "Lpg1/d;", "style", "", "a", "g", "f", "loop", "l", "auto", "i", "k", tl.h.F, "", WidgetCacheConstellationData.INTERVAL, "j", NodeProps.ENABLED, "b", "duration", DomainData.DOMAIN_NAME, "", "margin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "", "toString", "Landroidx/viewpager2/widget/ViewPager2;", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "c", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "Ljava/util/List;", "styles", "Lpg1/c;", "Lpg1/c;", "autoPagerBannerStyle", "Lpg1/k;", "Lpg1/k;", "loopBannerStyle", "<init>", "(Landroidx/viewpager2/widget/ViewPager2;)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: pg1.e, reason: from toString */
/* loaded from: classes12.dex */
public final class BannerStyleManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewPager2 viewPager2;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView recyclerView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<d> styles;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c autoPagerBannerStyle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k loopBannerStyle;

    public BannerStyleManager(@NotNull ViewPager2 viewPager2) {
        DefaultConstructorMarker defaultConstructorMarker;
        View view;
        Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
        this.viewPager2 = viewPager2;
        Iterator<View> it = ViewGroupKt.getChildren(viewPager2).iterator();
        while (true) {
            defaultConstructorMarker = null;
            if (it.hasNext()) {
                view = it.next();
                if (view instanceof RecyclerView) {
                    break;
                }
            } else {
                view = null;
                break;
            }
        }
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) view;
        this.recyclerView = recyclerView;
        this.styles = new ArrayList();
        this.autoPagerBannerStyle = new c(0L, 1, defaultConstructorMarker);
        this.loopBannerStyle = new k();
        recyclerView.setRecycledViewPool(new com.tencent.cache.api.collection.b(Business.Guild, "guild-component"));
    }

    private final boolean e() {
        Object obj;
        boolean z16;
        Iterator<T> it = this.styles.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((d) obj) == this.loopBannerStyle) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((d) obj) != null) {
            return true;
        }
        return false;
    }

    public final void a(@NotNull d style) {
        Intrinsics.checkNotNullParameter(style, "style");
        style.a(this.viewPager2, this.recyclerView);
        this.styles.add(style);
    }

    public final void b(boolean enabled) {
        Object obj;
        Iterator<T> it = this.styles.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((d) obj) instanceof f) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        d dVar = (d) obj;
        if (enabled) {
            if (dVar != null) {
                f(dVar);
            }
        } else if (dVar == null) {
            a(new f());
        }
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final boolean d() {
        Object obj;
        boolean z16;
        Iterator<T> it = this.styles.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((d) obj) == this.autoPagerBannerStyle) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((d) obj) != null && !this.autoPagerBannerStyle.getStoped()) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull d style) {
        Intrinsics.checkNotNullParameter(style, "style");
        if (this.styles.remove(style)) {
            style.b(this.viewPager2, this.recyclerView);
        }
    }

    public final void g(@NotNull d style) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(style, "style");
        Iterator<T> it = this.styles.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (style.getClass() == ((d) obj).getClass()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        d dVar = (d) obj;
        if (dVar != null) {
            f(dVar);
        }
        a(style);
    }

    public final void h() {
        this.autoPagerBannerStyle.j();
    }

    public final void i(boolean auto) {
        Object obj;
        boolean z16;
        if (auto) {
            l(true);
            Iterator<T> it = this.styles.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((d) obj) == this.autoPagerBannerStyle) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (((d) obj) == null) {
                a(this.autoPagerBannerStyle);
                return;
            }
            return;
        }
        f(this.autoPagerBannerStyle);
    }

    public final void j(long interval) {
        this.autoPagerBannerStyle.k(interval);
    }

    public final void k(boolean auto) {
        Object obj;
        boolean z16;
        Iterator<T> it = this.styles.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((d) obj) == this.autoPagerBannerStyle) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        d dVar = (d) obj;
        if (auto) {
            if (dVar == null) {
                a(this.autoPagerBannerStyle);
                return;
            } else {
                this.autoPagerBannerStyle.j();
                return;
            }
        }
        if (dVar != null) {
            f(dVar);
        }
    }

    public final void l(boolean loop) {
        Object obj;
        boolean z16;
        if (loop) {
            Iterator<T> it = this.styles.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((d) obj) == this.loopBannerStyle) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (((d) obj) == null) {
                a(this.loopBannerStyle);
                return;
            }
            return;
        }
        f(this.loopBannerStyle);
    }

    public final void m(int margin) {
        g(new l(margin));
    }

    public final void n(long duration) {
        g(new o(duration));
    }

    @NotNull
    public String toString() {
        return "BannerStyleManager(hash: " + hashCode() + ", ViewPager hash: " + this.viewPager2.hashCode() + ", loop: " + e() + ", autoScroll: " + d() + ")";
    }
}
