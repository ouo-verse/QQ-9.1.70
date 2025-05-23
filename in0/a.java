package in0;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lin0/a;", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, d> f408004b = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J4\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR0\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lin0/a$a;", "", "", "clsName", "Landroid/content/Intent;", "intent", "Landroid/os/Bundle;", "bundle", "Landroidx/fragment/app/FragmentManager;", "fm", "", "containerId", "Lus/a;", "a", "Ljava/util/HashMap;", "Lin0/d;", "Lkotlin/collections/HashMap;", "mCreatorFactoryMap", "Ljava/util/HashMap;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: in0.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final us.a a(@NotNull String clsName, @Nullable Intent intent, @Nullable Bundle bundle, @NotNull FragmentManager fm5, int containerId) {
            Intrinsics.checkNotNullParameter(clsName, "clsName");
            Intrinsics.checkNotNullParameter(fm5, "fm");
            if (TextUtils.isEmpty(clsName)) {
                return null;
            }
            if (a.f408004b.get(clsName) == null) {
                HashMap hashMap = a.f408004b;
                Object newInstance = Class.forName(clsName).newInstance();
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.guild.aio.article.launcher.IChatFragmentCreator");
                hashMap.put(clsName, (d) newInstance);
            }
            d dVar = (d) a.f408004b.get(clsName);
            if (dVar == null) {
                return null;
            }
            return dVar.a(intent, bundle, fm5, containerId);
        }

        Companion() {
        }
    }
}
