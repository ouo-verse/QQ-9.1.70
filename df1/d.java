package df1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.GuildQUIProfileFragmentUtilsKt;
import com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback;
import com.tencent.mobileqq.guild.base.extension.k;
import com.tencent.mobileqq.guild.quiprofile.GuildActivityWrapper;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.argus.ContextWrapperFactory;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Ldf1/d;", "Lcom/tencent/mobileqq/app/lifecycle/DefaultBaseActivityLifecycleCallback;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "doOnActivityStopped", "onPostThemeChanged", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnActivityPreCreated", "doOnActivityCreate", "savedInstance", "doOnActivityPostCreated", "doOnActivityDestroyed", "outState", "onSaveInstanceState", "", "d", "Z", "contextWrapperPreCreate", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d extends DefaultBaseActivityLifecycleCallback {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean contextWrapperPreCreate;

    public d() {
        this.contextWrapperPreCreate = true;
        MobileQQ.sMobileQQ.registerActivityLifecycleCallbacks(e.f393672d);
        this.contextWrapperPreCreate = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("GUILD_CONTEXT_WRAPPER_PRE_CREATE", true);
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        boolean z16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger logger = Logger.f235387a;
        logger.d().i("Guild.QActivityLifecycleCallback", 1, "doOnActivityCreate " + activity);
        super.doOnActivityCreate(activity, savedInstanceState);
        logger.d().i("Guild.QActivityLifecycleCallback", 1, "doOnActivityCreate " + activity);
        if (this.contextWrapperPreCreate) {
            try {
                Result.Companion companion = Result.INSTANCE;
                ContextWrapperFactory contextWrapperFactory = ContextWrapperFactory.INSTANCE;
                contextWrapperFactory.getContextWrapper(GuildActivityWrapper.class, activity);
                Result.m476constructorimpl(contextWrapperFactory.getContextWrapper(GuildActivityWrapper.SupportVasThemeActivityWrapper.class, activity));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
        }
        a.INSTANCE.a(activity);
        b.f393668a.f(activity, savedInstanceState);
        Intent intent = activity.getIntent();
        boolean z17 = false;
        if (intent != null && k.a(intent)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
                z17 = true;
            }
            if (!z17) {
                Logger.a d16 = Logger.f235387a.d();
                String stringExtra = activity.getIntent().getStringExtra("public_fragment_class");
                if (stringExtra == null) {
                    stringExtra = activity.getLocalClassName();
                }
                Intrinsics.checkNotNullExpressionValue(stringExtra, "activity.intent.getStrin\u2026: activity.localClassName");
                d16.i("Guild.QActivityLifecycleCallback", 1, "doOnActivityCreate not-login, will finished: " + stringExtra);
                ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).clearSplash(activity);
                activity.finish();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityDestroyed(@Nullable Activity activity) {
        Logger.f235387a.d().i("Guild.QActivityLifecycleCallback", 1, "doOnActivityCreate " + activity);
        super.doOnActivityDestroyed(activity);
        a.INSTANCE.c(activity);
        if (activity != null) {
            b.f393668a.c(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPostCreated(@Nullable Activity activity, @Nullable Bundle savedInstance) {
        super.doOnActivityPostCreated(activity, savedInstance);
        Logger.f235387a.d().i("Guild.QActivityLifecycleCallback", 1, "doOnActivityPostCreated " + activity);
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPreCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.doOnActivityPreCreated(activity, savedInstanceState);
        Logger.f235387a.d().i("Guild.QActivityLifecycleCallback", 1, "doOnActivityPreCreated " + activity);
        if (activity instanceof FragmentActivity) {
            GuildQUIProfileFragmentUtilsKt.profileGuildThemeIfNeed((FragmentActivity) activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onPostThemeChanged(@Nullable Activity activity) {
        Logger.f235387a.d().i("Guild.QActivityLifecycleCallback", 1, "onPostThemeChanged");
        GuildThemeManager.f235286a.f();
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onSaveInstanceState(@Nullable Activity activity, @Nullable Bundle outState) {
        super.onSaveInstanceState(activity, outState);
        b.f393668a.g(activity, outState);
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityStopped(@Nullable Activity activity) {
    }
}
