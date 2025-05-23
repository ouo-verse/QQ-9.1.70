package com.tencent.mobileqq.guild.theme;

import android.content.Context;
import android.os.Looper;
import android.view.Window;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013R%\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\b0\b0\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R%\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u001b0\u001b0\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/theme/GuildThemeManager;", "", "Lcom/tencent/mobileqq/guild/theme/d;", "callback", "", tl.h.F, "g", "j", "", "isDark", "Landroid/view/Window;", "window", "i", "f", "b", "Landroid/content/Context;", "context", "c", "", "Ljava/util/List;", "themeCallbackList", "Le12/a;", "kotlin.jvm.PlatformType", "Le12/a;", "d", "()Le12/a;", "nightThemeLiveData", "", "e", "themeIdLiveData", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildThemeManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildThemeManager f235286a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<d> themeCallbackList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final e12.a<Boolean> nightThemeLiveData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final e12.a<String> themeIdLiveData;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    static final class a implements Observer {

        /* renamed from: d, reason: collision with root package name */
        private final /* synthetic */ Function1 f235293d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f235293d = function;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f235293d.invoke(obj);
        }
    }

    static {
        GuildThemeManager guildThemeManager = new GuildThemeManager();
        f235286a = guildThemeManager;
        themeCallbackList = new ArrayList();
        nightThemeLiveData = new e12.a<>(Boolean.valueOf(guildThemeManager.b()));
        themeIdLiveData = new e12.a<>(QQTheme.getCurrentThemeId());
        Logger.f235387a.d().i("Guild.GuildThemeManager", 1, "init");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            guildThemeManager.d().observeForever(new a(GuildThemeManager$2$1.INSTANCE));
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.theme.GuildThemeManager$special$$inlined$ensureOnMainThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    GuildThemeManager.f235286a.d().observeForever(new GuildThemeManager.a(GuildThemeManager$2$1.INSTANCE));
                }
            });
        }
    }

    GuildThemeManager() {
    }

    @JvmStatic
    public static final void g(@NotNull final d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            themeCallbackList.remove(callback);
            themeCallbackList.add(callback);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.theme.GuildThemeManager$registerThemeCallback$$inlined$ensureOnMainThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    GuildThemeManager.themeCallbackList.remove(d.this);
                    GuildThemeManager.themeCallbackList.add(d.this);
                }
            });
        }
    }

    @JvmStatic
    public static final void h(@NotNull final d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            g(callback);
            callback.onThemeChanged();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.theme.GuildThemeManager$registerThemeCallbackByStick$$inlined$ensureOnMainThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    GuildThemeManager.g(d.this);
                    d.this.onThemeChanged();
                }
            });
        }
    }

    @JvmStatic
    public static final void i(boolean isDark, @NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        if (ImmersiveUtils.isSupporImmersive() != 0 && ImmersiveUtils.couldSetStatusTextColor()) {
            ImmersiveUtils.setStatusTextColorNew(isDark, window);
        }
    }

    @JvmStatic
    public static final void j(@NotNull final d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            themeCallbackList.remove(callback);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.theme.GuildThemeManager$unregisterThemeCallback$$inlined$ensureOnMainThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    GuildThemeManager.themeCallbackList.remove(d.this);
                }
            });
        }
    }

    public final boolean b() {
        return je0.a.a(MobileQQ.sMobileQQ);
    }

    public final boolean c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return je0.a.a(context);
    }

    @NotNull
    public final e12.a<Boolean> d() {
        return nightThemeLiveData;
    }

    @NotNull
    public final e12.a<String> e() {
        return themeIdLiveData;
    }

    public final void f() {
        boolean b16 = b();
        Logger.f235387a.d().i("Guild.GuildThemeManager", 1, "notifyGuildThemeUpdate, isNight: " + b16);
        e12.a<Boolean> aVar = nightThemeLiveData;
        if (!Intrinsics.areEqual(aVar.getValue(), Boolean.valueOf(b16))) {
            aVar.setValue(Boolean.valueOf(b16));
        }
        themeIdLiveData.setValue(QQTheme.getCurrentThemeId());
        if (Looper.getMainLooper() == Looper.myLooper()) {
            Iterator it = new ArrayList(themeCallbackList).iterator();
            while (it.hasNext()) {
                ((d) it.next()).onThemeChanged();
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.theme.GuildThemeManager$notifyGuildThemeUpdate$$inlined$ensureOnMainThread$1
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it5 = new ArrayList(GuildThemeManager.themeCallbackList).iterator();
                while (it5.hasNext()) {
                    ((d) it5.next()).onThemeChanged();
                }
            }
        });
    }
}
