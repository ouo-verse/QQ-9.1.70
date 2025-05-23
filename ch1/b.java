package ch1;

import com.tencent.mobileqq.guild.discovery.startpanel.childs.DiscoverTabType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lch1/b;", "", "Lcom/tencent/mobileqq/guild/discovery/startpanel/childs/DiscoverTabType;", "tabType", "", "pageFrom", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f30840a = new b();

    b() {
    }

    @NotNull
    public final String a(@NotNull DiscoverTabType tabType, int pageFrom) {
        Intrinsics.checkNotNullParameter(tabType, "tabType");
        if (pageFrom == 1) {
            return "functional_channel_the_public";
        }
        if (pageFrom == 2) {
            return "discover_new";
        }
        int tabType2 = tabType.getTabType();
        if (tabType2 != 2) {
            if (tabType2 != 3) {
                return "discover_channel_homepage";
            }
            return "discover_recommend";
        }
        return "discover_hot";
    }
}
