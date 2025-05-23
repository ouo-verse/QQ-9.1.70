package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewExtKt;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.guild.config.GuildQUIProfileConfig;
import com.tencent.mobileqq.guild.quiprofile.c;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableActivityProcesser;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0002\u001a\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\rH\u0002\u001a\f\u0010\u0011\u001a\u00020\t*\u00020\u0012H\u0002\u001a\n\u0010\u0013\u001a\u00020\t*\u00020\u0014\u001a\f\u0010\u0015\u001a\u00020\t*\u00020\u0012H\u0002\u001a\u0014\u0010\u0016\u001a\u00020\t*\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0001H\u0002\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"GUILD_PROFILE_SWITCH_FOR_DEBUG", "", "getGUILD_PROFILE_SWITCH_FOR_DEBUG", "()Z", "setGUILD_PROFILE_SWITCH_FOR_DEBUG", "(Z)V", "TAG", "", "clearRecyclerViewCache", "", "view", "Landroidx/recyclerview/widget/RecyclerView;", "clearRecyclerViewCacheRecursively", "Landroid/view/View;", "refreshThemeAfterThemeChanged", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "onThemeChanged", "Landroidx/fragment/app/Fragment;", "profileGuildThemeIfNeed", "Landroidx/fragment/app/FragmentActivity;", "registerThemeChanged", "replaceSelfHost", "supportVasTheme", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class GuildQUIProfileFragmentUtilsKt {
    private static boolean GUILD_PROFILE_SWITCH_FOR_DEBUG = true;

    @NotNull
    private static final String TAG = "Guild.replaceHost";

    private static final void clearRecyclerViewCache(RecyclerView recyclerView) {
        RecyclerViewExtKt.clearCachedViews(recyclerView);
        recyclerView.getRecycledViewPool().clear();
        recyclerView.invalidateItemDecorations();
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    private static final void clearRecyclerViewCacheRecursively(View view) {
        if (view instanceof ViewGroup) {
            if (view instanceof RecyclerView) {
                clearRecyclerViewCache((RecyclerView) view);
            }
            Iterator<View> it = ViewGroupKt.getChildren((ViewGroup) view).iterator();
            while (it.hasNext()) {
                clearRecyclerViewCacheRecursively(it.next());
            }
        }
    }

    public static final boolean getGUILD_PROFILE_SWITCH_FOR_DEBUG() {
        return GUILD_PROFILE_SWITCH_FOR_DEBUG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onThemeChanged(Fragment fragment) {
        ViewGroup viewGroup;
        Resources resources;
        Boolean bool;
        View view = fragment.getView();
        if (view == null) {
            return;
        }
        Resources resources2 = view.getResources();
        if (!(resources2 instanceof c)) {
            s.e(TAG, "Fragment(" + fragment.getClass().getName() + ")\u7684Resource\u6ca1\u6709\u88ab\u66ff\u6362\u6210\u6210\u529f " + resources2 + " app " + RFWApplication.getApplication().getResources(), new RuntimeException());
            return;
        }
        ViewParent parent = view.getParent();
        Boolean bool2 = null;
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            resources = viewGroup.getResources();
        } else {
            resources = null;
        }
        if (resources instanceof c) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d(TAG, "\u7236View\u7684resources\u4e5f\u662f\u88ab\u66ff\u6362\u8fc7\u4e86\uff0c\u8fd9\u91cc\u4e0d\u9700\u8981\u5237\u65b0UI\uff0c\u7ed9\u7236View\u5237\u65b0\u5373\u53ef");
                return;
            }
            return;
        }
        FragmentActivity activity = fragment.getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            clearRecyclerViewCacheRecursively(view);
            refreshThemeAfterThemeChanged(activity, view);
            return;
        }
        Logger.a d16 = Logger.f235387a.d();
        if (activity != null) {
            bool = Boolean.valueOf(activity.isFinishing());
        } else {
            bool = null;
        }
        if (activity != null) {
            bool2 = Boolean.valueOf(activity.isDestroyed());
        }
        d16.w(TAG, 1, "activity is invalid, finishing: " + bool + " destroyed: " + bool2);
    }

    public static final void profileGuildThemeIfNeed(@NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        final GuildQUIProfileConfig a16 = GuildQUIProfileConfig.INSTANCE.a();
        if (GUILD_PROFILE_SWITCH_FOR_DEBUG && a16.getEnable()) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d(TAG, "profileGuildThemeIfNeed Activity: " + fragmentActivity.getClass().getName());
            }
            fragmentActivity.getSupportFragmentManager().registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() { // from class: androidx.fragment.app.GuildQUIProfileFragmentUtilsKt$profileGuildThemeIfNeed$2
                @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
                public void onFragmentPreAttached(@NotNull FragmentManager fm5, @NotNull Fragment f16, @NotNull Context context) {
                    Bundle bundle;
                    AIOParam aIOParam;
                    AIOSession r16;
                    AIOContact c16;
                    boolean startsWith$default;
                    Intrinsics.checkNotNullParameter(fm5, "fm");
                    Intrinsics.checkNotNullParameter(f16, "f");
                    Intrinsics.checkNotNullParameter(context, "context");
                    super.onFragmentPreAttached(fm5, f16, context);
                    if (GuildQUIProfileFragmentUtilsKt.getGUILD_PROFILE_SWITCH_FOR_DEBUG() && GuildQUIProfileConfig.this.getEnable()) {
                        String name = f16.getClass().getName();
                        Logger logger2 = Logger.f235387a;
                        if (QLog.isDevelopLevel()) {
                            Log.d("Guild.replaceHost", "onFragmentPreAttached: " + name);
                        }
                        FragmentHostCallback<?> fragmentHostCallback = f16.mHost;
                        if (fragmentHostCallback instanceof GuildQUIProfileFragmentHostCallback) {
                            if (GuildQUIProfileConfig.this.blackContains(f16)) {
                                Logger.f235387a.d().i("Guild.replaceHost", 1, "blacklist 1: " + name);
                                f16.mHost = ((GuildQUIProfileFragmentHostCallback) fragmentHostCallback).getOrigin();
                                return;
                            }
                            Logger.f235387a.d().i("Guild.replaceHost", 1, "parent's host is replaced: " + name);
                            return;
                        }
                        if (GuildQUIProfileConfig.this.blackContains(f16)) {
                            Logger.f235387a.d().i("Guild.replaceHost", 1, "blacklist 2: " + name);
                            return;
                        }
                        boolean vasThemeContains = GuildQUIProfileConfig.this.vasThemeContains(f16);
                        Integer num = null;
                        if (!vasThemeContains && !GuildQUIProfileConfig.this.contains(f16)) {
                            Set<String> fragmentPackageNames = GuildQUIProfileConfig.this.getFragmentPackageNames();
                            boolean z16 = false;
                            if (!(fragmentPackageNames instanceof Collection) || !fragmentPackageNames.isEmpty()) {
                                Iterator<T> it = fragmentPackageNames.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(name, (String) it.next(), false, 2, null);
                                    if (startsWith$default) {
                                        z16 = true;
                                        break;
                                    }
                                }
                            }
                            if (!z16) {
                                return;
                            }
                        }
                        if (Intrinsics.areEqual(name, GuildQUIProfileConfig.AIO_CLASS_NAME)) {
                            Bundle arguments = f16.getArguments();
                            if (arguments != null && (bundle = arguments.getBundle("AIOParamKey")) != null && (aIOParam = (AIOParam) bundle.getParcelable("aio_param")) != null && (r16 = aIOParam.r()) != null && (c16 = r16.c()) != null) {
                                num = Integer.valueOf(c16.e());
                            }
                            if (num == null || 4 != num.intValue()) {
                                Logger.f235387a.d().d("Guild.replaceHost", 1, "other aio chatType: " + num + ", : " + name);
                                return;
                            }
                        }
                        Logger.f235387a.d().i("Guild.replaceHost", 1, "hit : " + name);
                        GuildQUIProfileFragmentUtilsKt.replaceSelfHost(f16, vasThemeContains);
                        GuildQUIProfileFragmentUtilsKt.registerThemeChanged(f16);
                    }
                }
            }, true);
        }
    }

    private static final void refreshThemeAfterThemeChanged(Activity activity, View view) {
        mw1.a.e(mw1.a.f417705a, view, false, 2, null);
        new SkinnableActivityProcesser(activity, null).update(new Intent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    public static final void registerThemeChanged(final Fragment fragment) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        GuildThemeManager guildThemeManager = GuildThemeManager.f235286a;
        objectRef.element = guildThemeManager.e().getValue();
        e12.a<String> e16 = guildThemeManager.e();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: androidx.fragment.app.GuildQUIProfileFragmentUtilsKt$registerThemeChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                if (Intrinsics.areEqual(objectRef.element, str)) {
                    return;
                }
                objectRef.element = str;
                GuildQUIProfileFragmentUtilsKt.onThemeChanged(fragment);
            }
        };
        e16.observe(fragment, new Observer() { // from class: androidx.fragment.app.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildQUIProfileFragmentUtilsKt.registerThemeChanged$lambda$1(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerThemeChanged$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void replaceSelfHost(Fragment fragment, boolean z16) {
        FragmentHostCallback<?> fragmentHostCallback;
        Activity activity = fragment.mHost.getActivity();
        if (!(activity instanceof FragmentActivity) || (fragment.mHost instanceof GuildQUIProfileFragmentHostCallback)) {
            return;
        }
        Fragment parentFragment = fragment.getParentFragment();
        if (parentFragment != null) {
            fragmentHostCallback = parentFragment.mHost;
        } else {
            fragmentHostCallback = null;
        }
        if (fragmentHostCallback instanceof GuildQUIProfileFragmentHostCallback) {
            fragment.mHost = fragmentHostCallback;
        } else {
            fragment.mHost = new GuildQUIProfileFragmentHostCallback((FragmentActivity) activity, fragment.mHost, z16);
        }
    }

    public static final void setGUILD_PROFILE_SWITCH_FOR_DEBUG(boolean z16) {
        GUILD_PROFILE_SWITCH_FOR_DEBUG = z16;
    }
}
