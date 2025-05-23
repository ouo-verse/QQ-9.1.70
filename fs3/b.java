package fs3;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lfs3/b;", "", "a", "minibox-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public interface b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f400493a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lfs3/b$a;", "", "", "", "b", "Ljava/util/List;", "a", "()Ljava/util/List;", "GUIDE_URLS", "<init>", "()V", "minibox-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fs3.b$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f400493a = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final List<String> GUIDE_URLS;

        static {
            List<String> listOf;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"https://img.gamecenter.qq.com/xgame/gm/1684467921348_2fd2abeab05d59f03a4d01caaa835059.png", "https://img.gamecenter.qq.com/xgame/gm/1684468025167_5f2ded771d7edef705e445b89a2d097e.png", "https://img.gamecenter.qq.com/xgame/gm/1684467978178_c0f4dfc73af2fa44168a534f30f2278f.png"});
            GUIDE_URLS = listOf;
        }

        Companion() {
        }

        @NotNull
        public final List<String> a() {
            return GUIDE_URLS;
        }
    }
}
