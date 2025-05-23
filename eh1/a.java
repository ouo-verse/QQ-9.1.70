package eh1;

import com.tencent.mobileqq.guild.discovery.DiscoveryConstants$PageFrom;
import com.tencent.mobileqq.guild.discovery.startpanel.childs.DiscoverTabType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Leh1/a;", "", "", "pageFrom", "Lcom/tencent/mobileqq/guild/discovery/startpanel/childs/DiscoverTabType;", "tabType", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f396283a = new a();

    a() {
    }

    @NotNull
    public final String a(int pageFrom, @NotNull DiscoverTabType tabType) {
        Intrinsics.checkNotNullParameter(tabType, "tabType");
        if (pageFrom == 10) {
            return "discover_livestream_all";
        }
        if (pageFrom == 6 || DiscoveryConstants$PageFrom.INSTANCE.a(pageFrom) || tabType.getTabType() == 3) {
            return "discover_hot_activity";
        }
        return mh1.a.f416777a.d(tabType);
    }
}
