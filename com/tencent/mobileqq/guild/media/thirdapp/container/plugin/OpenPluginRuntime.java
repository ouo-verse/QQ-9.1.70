package com.tencent.mobileqq.guild.media.thirdapp.container.plugin;

import android.app.Activity;
import com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\n\u0010\u0014R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0011\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "a", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "c", "()Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "startParams", "Ljava/lang/ref/WeakReference;", "Lmqq/app/AppRuntime;", "b", "Ljava/lang/ref/WeakReference;", "getAppRef", "()Ljava/lang/ref/WeakReference;", "appRef", "Landroid/app/Activity;", "activityRef", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/d;", "d", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/d;", "()Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/d;", "hostProvider", "<init>", "(Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/d;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.media.thirdapp.container.plugin.e, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class OpenPluginRuntime {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GuildOpenContainerLauncher.StartParams startParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final WeakReference<AppRuntime> appRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final WeakReference<Activity> activityRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final d hostProvider;

    public OpenPluginRuntime(@NotNull GuildOpenContainerLauncher.StartParams startParams, @Nullable WeakReference<AppRuntime> weakReference, @Nullable WeakReference<Activity> weakReference2, @NotNull d hostProvider) {
        Intrinsics.checkNotNullParameter(startParams, "startParams");
        Intrinsics.checkNotNullParameter(hostProvider, "hostProvider");
        this.startParams = startParams;
        this.appRef = weakReference;
        this.activityRef = weakReference2;
        this.hostProvider = hostProvider;
    }

    @Nullable
    public final WeakReference<Activity> a() {
        return this.activityRef;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final d getHostProvider() {
        return this.hostProvider;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final GuildOpenContainerLauncher.StartParams getStartParams() {
        return this.startParams;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenPluginRuntime)) {
            return false;
        }
        OpenPluginRuntime openPluginRuntime = (OpenPluginRuntime) other;
        if (Intrinsics.areEqual(this.startParams, openPluginRuntime.startParams) && Intrinsics.areEqual(this.appRef, openPluginRuntime.appRef) && Intrinsics.areEqual(this.activityRef, openPluginRuntime.activityRef) && Intrinsics.areEqual(this.hostProvider, openPluginRuntime.hostProvider)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.startParams.hashCode() * 31;
        WeakReference<AppRuntime> weakReference = this.appRef;
        int i3 = 0;
        if (weakReference == null) {
            hashCode = 0;
        } else {
            hashCode = weakReference.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        WeakReference<Activity> weakReference2 = this.activityRef;
        if (weakReference2 != null) {
            i3 = weakReference2.hashCode();
        }
        return ((i16 + i3) * 31) + this.hostProvider.hashCode();
    }

    @NotNull
    public String toString() {
        return "OpenPluginRuntime(startParams=" + this.startParams + ", appRef=" + this.appRef + ", activityRef=" + this.activityRef + ", hostProvider=" + this.hostProvider + ")";
    }
}
