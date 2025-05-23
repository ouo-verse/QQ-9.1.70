package df1;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tR0\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0012j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014R4\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0012j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Ldf1/b;", "", "", "activityCode", "Ldf1/c;", "callback", "", "b", "e", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", "outState", "g", Constants.FILE_INSTANCE_STATE, "f", "d", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "callbacks", "savedInstanceStateMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f393668a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, c> callbacks = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, Bundle> savedInstanceStateMap = new HashMap<>();

    b() {
    }

    public final void b(int activityCode, @NotNull c callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callbacks.put(Integer.valueOf(activityCode), callback);
    }

    public final void c(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        savedInstanceStateMap.remove(Integer.valueOf(System.identityHashCode(activity)));
    }

    @Nullable
    public final Bundle d(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return savedInstanceStateMap.get(Integer.valueOf(System.identityHashCode(activity)));
    }

    public final void e(int activityCode) {
        callbacks.remove(Integer.valueOf(activityCode));
    }

    public final void f(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        String str;
        if (activity != null && savedInstanceState != null) {
            savedInstanceStateMap.put(Integer.valueOf(System.identityHashCode(activity)), savedInstanceState.getBundle("GUILD_CUSTOM_STATE_KEY"));
            Logger.f235387a.d().i("Guild.GuildSaveInstanceStateStore", 1, "reStoreState " + savedInstanceStateMap);
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        if (activity != null) {
            str = activity.getLocalClassName();
        } else {
            str = null;
        }
        String str2 = "restoreState error " + str;
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.GuildSaveInstanceStateStore", 1, (String) it.next(), null);
        }
    }

    public final void g(@Nullable Activity activity, @Nullable Bundle outState) {
        String str;
        Bundle bundle = null;
        if (activity != null && outState != null) {
            c cVar = callbacks.get(Integer.valueOf(System.identityHashCode(activity)));
            if (cVar != null) {
                bundle = cVar.a(activity);
            }
            if (bundle != null) {
                outState.putBundle("GUILD_CUSTOM_STATE_KEY", bundle);
            }
            Logger.f235387a.d().i("Guild.GuildSaveInstanceStateStore", 1, "saveState " + bundle);
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        if (activity != null) {
            str = activity.getLocalClassName();
        } else {
            str = null;
        }
        String str2 = "saveState error " + str;
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.GuildSaveInstanceStateStore", 1, (String) it.next(), null);
        }
    }
}
