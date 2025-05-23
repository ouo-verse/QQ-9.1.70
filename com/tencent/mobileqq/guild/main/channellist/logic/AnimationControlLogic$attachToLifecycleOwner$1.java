package com.tencent.mobileqq.guild.main.channellist.logic;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import ar1.b;
import com.tencent.mobileqq.guild.main.GuildPageStateManager;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/main/channellist/logic/AnimationControlLogic$attachToLifecycleOwner$1", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "onStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class AnimationControlLogic$attachToLifecycleOwner$1 implements LifecycleEventObserver {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ b f227119d;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f227120a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f227120a = iArr;
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        GuildPageStateManager guildPageStateManager;
        GuildPageStateManager guildPageStateManager2;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        Logger.f235387a.d().d("Guild.CLST.AnimationControlLogic", 1, "onStateChanged " + source + ", " + event);
        int i3 = a.f227120a[event.ordinal()];
        if (i3 == 1) {
            this.f227119d.f();
            this.f227119d.g(3000L);
            return;
        }
        if (i3 == 2) {
            guildPageStateManager = this.f227119d.pageStateManager;
            guildPageStateManager.g(true);
        } else if (i3 == 3) {
            guildPageStateManager2 = this.f227119d.pageStateManager;
            guildPageStateManager2.g(false);
        } else if (i3 == 4) {
            this.f227119d.i();
            source.getLifecycle().removeObserver(this);
        }
    }
}
