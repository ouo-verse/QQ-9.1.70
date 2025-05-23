package com.tencent.mobileqq.guild.mainframe.manager;

import android.content.Intent;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.mainframe.GuildMainFragment;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007J\b\u0010\f\u001a\u00020\u0007H\u0007J\b\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007J\b\u0010\u0014\u001a\u00020\u0013H\u0007J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0007J\u001c\u0010\u001d\u001a\u00020\u00042\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00040\u001aH\u0002J1\u0010 \u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u001f\u001a\u00028\u00002\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00028\u00000\u001aH\u0002\u00a2\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u001bR\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/manager/GuildMainFrameManager;", "", "Lrr1/a;", "gestureListener", "", "a", "l", "", "i", "Lcom/tencent/mobileqq/guild/api/LaunchGuildChatPieParam;", "params", "j", h.F, "b", "Landroid/content/Intent;", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/mainframe/centerpanel/GuildCenterPanelController;", "f", "Lcom/tencent/mobileqq/guild/mainframe/manager/PanelState;", "g", "", "guildId", "k", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "e", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/mainframe/GuildMainFragment;", "block", "d", "T", RemoteHandleConst.PARAM_DEFAULT_VALUE, "c", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "fragment", DomainData.DOMAIN_NAME, "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "guildMainFragmentRef", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMainFrameManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildMainFrameManager f227469a = new GuildMainFrameManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<GuildMainFragment> guildMainFragmentRef;

    GuildMainFrameManager() {
    }

    @JvmStatic
    public static final void a(@NotNull final rr1.a gestureListener) {
        Intrinsics.checkNotNullParameter(gestureListener, "gestureListener");
        f227469a.d(new Function1<GuildMainFragment, Unit>() { // from class: com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameManager$addGestureListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildMainFragment guildMainFragment) {
                invoke2(guildMainFragment);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuildMainFragment fragment) {
                Intrinsics.checkNotNullParameter(fragment, "fragment");
                fragment.N().addGestureListener(rr1.a.this);
            }
        });
    }

    private final <T> T c(T defaultValue, Function1<? super GuildMainFragment, ? extends T> block) {
        GuildMainFragment guildMainFragment;
        WeakReference<GuildMainFragment> weakReference = guildMainFragmentRef;
        if (weakReference != null) {
            guildMainFragment = weakReference.get();
        } else {
            guildMainFragment = null;
        }
        if (guildMainFragment != null && !guildMainFragment.isDetached()) {
            return block.invoke(guildMainFragment);
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("guild fragment has been destroyed");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.MF.GuildMainFrameManager", 1, (String) it.next(), null);
        }
        return defaultValue;
    }

    private final void d(Function1<? super GuildMainFragment, Unit> block) {
        GuildMainFragment guildMainFragment;
        WeakReference<GuildMainFragment> weakReference = guildMainFragmentRef;
        if (weakReference != null) {
            guildMainFragment = weakReference.get();
        } else {
            guildMainFragment = null;
        }
        if (guildMainFragment != null && !guildMainFragment.isDetached()) {
            block.invoke(guildMainFragment);
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("guild fragment has been destroyed");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.MF.GuildMainFrameManager", 1, (String) it.next(), null);
        }
    }

    @JvmStatic
    @Nullable
    public static final DragFrameLayout e() {
        return (DragFrameLayout) f227469a.c(null, new Function1<GuildMainFragment, DragFrameLayout>() { // from class: com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameManager$getDragFrameLayout$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final DragFrameLayout invoke(@NotNull GuildMainFragment fragment) {
                Intrinsics.checkNotNullParameter(fragment, "fragment");
                return fragment.jh();
            }
        });
    }

    @JvmStatic
    @Nullable
    public static final GuildCenterPanelController f() {
        return (GuildCenterPanelController) f227469a.c(null, new Function1<GuildMainFragment, GuildCenterPanelController>() { // from class: com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameManager$getGuildCenterPanel$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final GuildCenterPanelController invoke(@NotNull GuildMainFragment fragment) {
                Intrinsics.checkNotNullParameter(fragment, "fragment");
                return fragment.Z0();
            }
        });
    }

    @JvmStatic
    @NotNull
    public static final PanelState g() {
        return (PanelState) f227469a.c(PanelState.NONE, new Function1<GuildMainFragment, PanelState>() { // from class: com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameManager$getPanelState$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final PanelState invoke(@NotNull GuildMainFragment fragment) {
                Intrinsics.checkNotNullParameter(fragment, "fragment");
                if (fragment.N().j()) {
                    return PanelState.MAIN_FRAME;
                }
                if (fragment.N().l()) {
                    return PanelState.AIO_SHOWING;
                }
                if (fragment.N().f()) {
                    return PanelState.THIRD_PANEL;
                }
                return PanelState.NONE;
            }
        });
    }

    @JvmStatic
    public static final boolean h() {
        return false;
    }

    @JvmStatic
    public static final boolean i() {
        return ((Boolean) f227469a.c(Boolean.FALSE, new Function1<GuildMainFragment, Boolean>() { // from class: com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameManager$isPanelAnimMoving$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull GuildMainFragment fragment) {
                Intrinsics.checkNotNullParameter(fragment, "fragment");
                return Boolean.valueOf(fragment.N().a());
            }
        })).booleanValue();
    }

    @JvmStatic
    public static final void j(@NotNull final LaunchGuildChatPieParam params) {
        Intrinsics.checkNotNullParameter(params, "params");
        f227469a.d(new Function1<GuildMainFragment, Unit>() { // from class: com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameManager$openChatCenterPanel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildMainFragment guildMainFragment) {
                invoke2(guildMainFragment);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuildMainFragment fragment) {
                Intrinsics.checkNotNullParameter(fragment, "fragment");
                fragment.Hh().c(LaunchGuildChatPieParam.this);
            }
        });
    }

    @JvmStatic
    public static final void k(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
    }

    @JvmStatic
    public static final void l(@NotNull final rr1.a gestureListener) {
        Intrinsics.checkNotNullParameter(gestureListener, "gestureListener");
        f227469a.d(new Function1<GuildMainFragment, Unit>() { // from class: com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameManager$removeGestureListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildMainFragment guildMainFragment) {
                invoke2(guildMainFragment);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuildMainFragment fragment) {
                Intrinsics.checkNotNullParameter(fragment, "fragment");
                fragment.N().removeGestureListener(rr1.a.this);
            }
        });
    }

    @JvmStatic
    public static final void m(@NotNull final Intent data) {
        Intrinsics.checkNotNullParameter(data, "data");
        f227469a.d(new Function1<GuildMainFragment, Unit>() { // from class: com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameManager$updateEnableEndPageSwitch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildMainFragment guildMainFragment) {
                invoke2(guildMainFragment);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuildMainFragment fragment) {
                Intrinsics.checkNotNullParameter(fragment, "fragment");
                fragment.d1().t(data);
            }
        });
    }

    public final void n(@Nullable GuildMainFragment fragment) {
        guildMainFragmentRef = new WeakReference<>(fragment);
    }

    @JvmStatic
    public static final void b() {
    }
}
