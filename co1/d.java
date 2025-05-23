package co1;

import androidx.core.util.Predicate;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J,\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u0007J\u0018\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b2\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0018\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b2\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u0010*\u0006\u0012\u0002\b\u00030\tR\u0014\u0010\u0014\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\n \u0015*\u0004\u0018\u00010\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lco1/d;", "", "", "guildId", "channelId", "sectionType", "contextHash", "d", "Landroidx/core/util/Predicate;", "Lcom/tencent/richframework/data/idata/IDataDisplaySurface;", "j", "k", "customPrefixKey", tl.h.F, "surfaceKey", DomainData.DOMAIN_NAME, "", "g", "e", "()Ljava/lang/String;", "mainFeedListSurfaceKeyPrefix", "kotlin.jvm.PlatformType", "f", "separator", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f31167a = new d();

    d() {
    }

    private final String e() {
        return "main_feed_list";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(String customPrefixKey, IDataDisplaySurface it) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(customPrefixKey, "$customPrefixKey");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        String a16 = e.a(it);
        if (a16 != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(a16, customPrefixKey, f31167a.e().length() + 1, false, 4, null);
            if (!startsWith$default) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(String guildId, IDataDisplaySurface it) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        String a16 = e.a(it);
        if (a16 != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(a16, guildId, f31167a.e().length() + 1, false, 4, null);
            if (!startsWith$default) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(String guildId, String channelId, IDataDisplaySurface it) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        String a16 = e.a(it);
        if (a16 == null) {
            return false;
        }
        d dVar = f31167a;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(a16, guildId + dVar.f() + channelId, dVar.e().length() + 1, false, 4, null);
        if (!startsWith$default) {
            return false;
        }
        return true;
    }

    @JvmOverloads
    @NotNull
    public final String d(@NotNull String guildId, @NotNull String channelId, @NotNull String sectionType, @NotNull String contextHash) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(sectionType, "sectionType");
        Intrinsics.checkNotNullParameter(contextHash, "contextHash");
        return e() + f() + guildId + f() + channelId + f() + sectionType + f() + contextHash;
    }

    public final String f() {
        return File.separator;
    }

    public final boolean g(@NotNull IDataDisplaySurface<?> iDataDisplaySurface) {
        Intrinsics.checkNotNullParameter(iDataDisplaySurface, "<this>");
        return iDataDisplaySurface instanceof f;
    }

    @NotNull
    public final Predicate<IDataDisplaySurface<?>> h(@NotNull final String customPrefixKey) {
        Intrinsics.checkNotNullParameter(customPrefixKey, "customPrefixKey");
        return new Predicate() { // from class: co1.a
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                boolean i3;
                i3 = d.i(customPrefixKey, (IDataDisplaySurface) obj);
                return i3;
            }
        };
    }

    @NotNull
    public final Predicate<IDataDisplaySurface<?>> j(@NotNull final String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return new Predicate() { // from class: co1.b
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                boolean l3;
                l3 = d.l(guildId, (IDataDisplaySurface) obj);
                return l3;
            }
        };
    }

    @NotNull
    public final Predicate<IDataDisplaySurface<?>> k(@NotNull final String guildId, @NotNull final String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return new Predicate() { // from class: co1.c
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                boolean m3;
                m3 = d.m(guildId, channelId, (IDataDisplaySurface) obj);
                return m3;
            }
        };
    }

    @NotNull
    public final String n(@NotNull String surfaceKey) {
        String removePrefix;
        Intrinsics.checkNotNullParameter(surfaceKey, "surfaceKey");
        removePrefix = StringsKt__StringsKt.removePrefix(surfaceKey, (CharSequence) (e() + f()));
        return removePrefix;
    }
}
