package mh1;

import com.tencent.mobileqq.guild.discovery.DiscoveryConstants$PageFrom;
import com.tencent.mobileqq.guild.discovery.startpanel.childs.DiscoverTabType;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\r"}, d2 = {"Lmh1/a;", "", "", "pageFrom", "Lcom/tencent/mobileqq/guild/discovery/startpanel/childs/DiscoverTabType;", "tabType", "", "a", "mainSource", "b", "d", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f416777a = new a();

    a() {
    }

    public static /* synthetic */ String c(a aVar, int i3, String str, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str = "";
        }
        return aVar.b(i3, str);
    }

    @NotNull
    public final String a(int pageFrom, @NotNull DiscoverTabType tabType) {
        Intrinsics.checkNotNullParameter(tabType, "tabType");
        if (DiscoveryConstants$PageFrom.INSTANCE.a(pageFrom)) {
            if (tabType == DiscoverTabType.RECOMMEND) {
                return "oa_recommend";
            }
            return "oa_content";
        }
        if (tabType == DiscoverTabType.RECOMMEND) {
            return "discover_recommend";
        }
        return "discover_content";
    }

    @NotNull
    public final String b(int pageFrom, @NotNull String mainSource) {
        Intrinsics.checkNotNullParameter(mainSource, "mainSource");
        return ch1.a.f30839a.a(pageFrom, mainSource);
    }

    @Deprecated(message = "", replaceWith = @ReplaceWith(expression = "DiscoverySubSource.getSubSource()", imports = {}))
    @NotNull
    public final String d(@NotNull DiscoverTabType tabType) {
        Intrinsics.checkNotNullParameter(tabType, "tabType");
        int tabType2 = tabType.getTabType();
        if (tabType2 != 1) {
            if (tabType2 != 2) {
                return "";
            }
            return "discover_hot";
        }
        return "discover_mine";
    }
}
