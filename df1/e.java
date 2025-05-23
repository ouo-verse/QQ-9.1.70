package df1;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.base.fragments.GProWaitLogicFragment;
import com.tencent.mobileqq.guild.j;
import com.tencent.mobileqq.guild.temp.api.IGuildActivityApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0002H\u0002J\f\u0010\u0007\u001a\u00020\u0005*\u00020\u0002H\u0002J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u001a\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Ldf1/e;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "", "b", "", "a", "d", "Landroid/content/Intent;", "intent", "e", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onActivityPreCreated", "onActivityPostCreated", "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "", "", "", "Ljava/util/Map;", "originFragmentClass", "Lcom/tencent/mobileqq/guild/temp/api/IGuildActivityApi;", "f", "Lcom/tencent/mobileqq/guild/temp/api/IGuildActivityApi;", DTConstants.TAG.API, "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class e implements Application.ActivityLifecycleCallbacks {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final e f393672d = new e();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, String> originFragmentClass = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IGuildActivityApi api;

    static {
        QRouteApi api2 = QRoute.api(IGuildActivityApi.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(IGuildActivityApi::class.java)");
        api = (IGuildActivityApi) api2;
    }

    e() {
    }

    private final void a(Activity activity) {
        Map<Integer, String> map = originFragmentClass;
        Integer valueOf = Integer.valueOf(System.identityHashCode(activity));
        String stringExtra = activity.getIntent().getStringExtra("public_fragment_class");
        if (stringExtra == null) {
            stringExtra = "";
        }
        map.put(valueOf, stringExtra);
        activity.getIntent().putExtra("public_fragment_class", GProWaitLogicFragment.class.getName());
    }

    private final boolean b(Activity activity) {
        String stringExtra = activity.getIntent().getStringExtra("public_fragment_class");
        if (stringExtra == null) {
            return false;
        }
        if (!activity.getIntent().getBooleanExtra("GUILD_ACTIVITY_NEED_WAIT_GPRO_SDK_EXTRA", false) && !j.f226354a.b(stringExtra)) {
            return false;
        }
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGProSession.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        if (((IGProSession) S0).getGProSdkStartCountDownLatch().getCount() <= 0) {
            return false;
        }
        return true;
    }

    private final void d(Activity activity) {
        String remove = originFragmentClass.remove(Integer.valueOf(System.identityHashCode(activity)));
        if (remove != null) {
            activity.getIntent().putExtra("public_fragment_class", remove);
        }
    }

    @NotNull
    public final Intent e(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra("GUILD_ACTIVITY_NEED_WAIT_GPRO_SDK_EXTRA", true);
        return intent;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!api.isSplashActivity(activity) && (activity instanceof QPublicFragmentActivity)) {
            Logger.f235387a.d().i("Guild.WaitForGProSdkStart", 1, "APP:onActivityCreated " + activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!api.isSplashActivity(activity) && (activity instanceof QPublicFragmentActivity)) {
            Logger.f235387a.d().i("Guild.WaitForGProSdkStart", 1, "APP:onActivityPostCreated " + activity);
            d(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!api.isSplashActivity(activity) && (activity instanceof QPublicFragmentActivity)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                boolean b16 = b(activity);
                if (b16) {
                    a(activity);
                }
                Logger.f235387a.d().i("Guild.WaitForGProSdkStart", 1, "APP:onActivityPreCreated needWaitGPro=" + b16 + " " + activity);
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "onActivityPreCreated error: " + activity;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.WaitForGProSdkStart", 1, (String) it.next(), m479exceptionOrNullimpl);
                }
                s.e("Guild.WaitForGProSdkStart", "onActivityPreCreated error", m479exceptionOrNullimpl);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }
}
