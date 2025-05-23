package ch1;

import com.tencent.mobileqq.guild.discovery.startpanel.childs.DiscoverTabType;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lch1/c;", "", "", "pageFrom", "Lcom/tencent/mobileqq/guild/discovery/startpanel/childs/DiscoverTabType;", "tabType", "blockType", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f30841a = new c();

    c() {
    }

    @NotNull
    public final String a(int pageFrom, @NotNull DiscoverTabType tabType, int blockType) {
        Intrinsics.checkNotNullParameter(tabType, "tabType");
        if (pageFrom == 2) {
            if (blockType == 2) {
                return "discover_hot_activity";
            }
            if (blockType != 8) {
                if (blockType != 9) {
                    return "discover_hot";
                }
                return "discover_category_recommend";
            }
            return "discover_person";
        }
        if (pageFrom != 5) {
            if (pageFrom != 6) {
                if (pageFrom != 7) {
                    int tabType2 = tabType.getTabType();
                    if (tabType2 != 1) {
                        if (tabType2 == 2) {
                            return "discover_hot";
                        }
                        if (tabType2 != 3) {
                            Logger logger = Logger.f235387a;
                            Logger.b bVar = new Logger.b();
                            String str = "getSubSource error tabType=" + tabType;
                            if (str instanceof String) {
                                bVar.a().add(str);
                            }
                            Iterator<T> it = bVar.a().iterator();
                            while (it.hasNext()) {
                                Logger.f235387a.d().e("Guild.discovery.DiscoveryConstants", 1, (String) it.next(), null);
                            }
                            return "";
                        }
                        if (blockType == 1) {
                            return "discover_category_recommend";
                        }
                        if (blockType == 2) {
                            return "discover_hot_activity";
                        }
                        if (blockType != 3) {
                            if (blockType != 4) {
                                return "";
                            }
                            return "discover_topic_recommend";
                        }
                        return "discover_hot_talk";
                    }
                    return "discover_mine";
                }
                return "discover_social_recommend";
            }
            return "discover_category_recommend_fix";
        }
        if (tabType == DiscoverTabType.ME) {
            return "discover_mine_nochannel";
        }
        return "discover_mychannel";
    }
}
