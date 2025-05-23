package df1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Ldf1/a;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final List<WeakReference<Activity>> f393667b = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Ldf1/a$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "a", "c", "Landroid/content/Intent;", "intent", "d", "", "b", "", "GUILD_ACTIVITY_LOGIN_GUARD", "Ljava/lang/String;", "", "Lmqq/util/WeakReference;", "activityTaskList", "Ljava/util/List;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: df1.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Activity activity) {
            if (activity != null) {
                a.f393667b.add(new WeakReference(activity));
            }
        }

        public final boolean b(@NotNull Intent intent) {
            Object m476constructorimpl;
            Object obj;
            boolean z16;
            Intrinsics.checkNotNullParameter(intent, "intent");
            try {
                Result.Companion companion = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(Boolean.valueOf(intent.getBooleanExtra("GUIDE_ACTIVITY_LOGIN_GUARD", false)));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            Object obj2 = null;
            if (m479exceptionOrNullimpl != null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "containsLoginGuardFlag getBooleanExtra error: " + intent + " contains error";
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.QActivityLifecycleCallback", 1, (String) it.next(), m479exceptionOrNullimpl);
                }
                s.e("Guild.QActivityLifecycleCallback", "containsLoginGuardFlag getBooleanExtra error", m479exceptionOrNullimpl);
                m476constructorimpl = null;
            }
            Boolean bool = (Boolean) m476constructorimpl;
            if (bool == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        z16 = extras.getBoolean("GUIDE_ACTIVITY_LOGIN_GUARD", false);
                    } else {
                        z16 = false;
                    }
                    obj = Result.m476constructorimpl(Boolean.valueOf(z16));
                } catch (Throwable th6) {
                    Result.Companion companion4 = Result.INSTANCE;
                    obj = Result.m476constructorimpl(ResultKt.createFailure(th6));
                }
                Throwable m479exceptionOrNullimpl2 = Result.m479exceptionOrNullimpl(obj);
                if (m479exceptionOrNullimpl2 == null) {
                    obj2 = obj;
                } else {
                    Logger logger2 = Logger.f235387a;
                    Logger.b bVar2 = new Logger.b();
                    String str2 = "containsLoginGuardFlag extras error: " + intent + " contains error";
                    if (str2 instanceof String) {
                        bVar2.a().add(str2);
                    }
                    Iterator<T> it5 = bVar2.a().iterator();
                    while (it5.hasNext()) {
                        Logger.f235387a.d().e("Guild.QActivityLifecycleCallback", 1, (String) it5.next(), m479exceptionOrNullimpl2);
                    }
                    s.e("Guild.QActivityLifecycleCallback", "containsLoginGuardFlag extras error", m479exceptionOrNullimpl2);
                }
                bool = (Boolean) obj2;
            }
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }

        public final void c(@Nullable Activity activity) {
            if (activity != null) {
                a.f393667b.remove(new WeakReference(activity));
            }
        }

        @NotNull
        public final Intent d(@NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            intent.putExtra("GUIDE_ACTIVITY_LOGIN_GUARD", true);
            return intent;
        }

        Companion() {
        }
    }
}
