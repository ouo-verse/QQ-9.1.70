package com.tencent.mobileqq.guild.base.extension;

import android.os.Bundle;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.guild.api.ILocalFocusService;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cr0.GuildActiveInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a7\u0010\u0007\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\b\u001a\n\u0010\n\u001a\u00020\t*\u00020\u0004\u001a\n\u0010\f\u001a\u00020\u000b*\u00020\u0004\u001a\f\u0010\u000e\u001a\u00020\r*\u0004\u0018\u00010\u0004\u001a\u001f\u0010\u0012\u001a\u00020\u0011\"\f\b\u0000\u0010\u0001*\u00020\u000f*\u00020\u0010*\u00028\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a'\u0010\u0017\u001a\u00020\u0011\"\f\b\u0000\u0010\u0001*\u00020\u0014*\u00020\u0015*\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a/\u0010\u001a\u001a\u00020\u0011\"\f\b\u0000\u0010\u0001*\u00020\u0014*\u00020\u0015*\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001a\n\u0010\u001e\u001a\u00020\u001d*\u00020\u001c\u001a\n\u0010 \u001a\u00020\u0004*\u00020\u001f\u001a\u001c\u0010$\u001a\u00020\u0011*\u00020!2\u0006\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u0004\u001a\u0016\u0010&\u001a\u00020\u0004*\u0004\u0018\u00010\u00042\b\b\u0002\u0010%\u001a\u00020\u000b\u00a8\u0006'"}, d2 = {"Lmqq/app/api/IRuntimeService;", "T", "Ljava/lang/Class;", "clazz", "", "logTag", "process", "c", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;", "", "l", "", "k", "", "f", "Lmqq/app/IAccountCallback;", "Landroidx/fragment/app/Fragment;", "", "b", "(Landroidx/fragment/app/Fragment;)V", "Lcom/tencent/mobileqq/guild/homev2/misc/d;", "Landroidx/lifecycle/LifecycleOwner;", "pageId", "e", "(Lcom/tencent/mobileqq/guild/homev2/misc/d;Ljava/lang/String;)V", "oldGuildId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/guild/homev2/misc/d;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "j", "Landroidx/core/view/WindowInsetsCompat;", "a", "Landroid/os/Bundle;", "key", "value", "g", "maxLength", tl.h.F, "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class MiscKt {
    @NotNull
    public static final String a(@NotNull WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "<this>");
        return "WindowInsetsCompat{systemWindow={" + windowInsetsCompat.getSystemWindowInsets() + "}, displayCutout={" + windowInsetsCompat.getDisplayCutout() + "}, stableInsets={" + windowInsetsCompat.getStableInsets() + "}, tappableElementInsets={" + windowInsetsCompat.getTappableElementInsets() + "}, systemGestureInsets={" + windowInsetsCompat.getSystemGestureInsets() + "}, mandatorySystemGestureInsets={" + windowInsetsCompat.getMandatorySystemGestureInsets() + "}";
    }

    public static final <T extends Fragment & IAccountCallback> void b(@NotNull final T t16) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        if (!GuildSplitViewUtils.f235370a.n(t16.getActivity())) {
            return;
        }
        t16.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.base.extension.MiscKt$ensureAccountCallbackIfSplitView$1

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes12.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f214732a;

                static {
                    int[] iArr = new int[Lifecycle.Event.values().length];
                    try {
                        iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f214732a = iArr;
                }
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                ActivityResultCaller activityResultCaller = Fragment.this;
                int i3 = a.f214732a[event.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        MobileQQ.sMobileQQ.unregisterAccountCallback((IAccountCallback) activityResultCaller);
                        source.getLifecycle().removeObserver(this);
                        return;
                    }
                    return;
                }
                MobileQQ.sMobileQQ.registerAccountCallback((IAccountCallback) activityResultCaller);
            }
        });
    }

    @NotNull
    public static final <T extends IRuntimeService> T c(@NotNull Class<T> clazz, @NotNull String logTag, @NotNull String process) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        Intrinsics.checkNotNullParameter(process, "process");
        T t16 = (T) ch.S0(clazz, process);
        Intrinsics.checkNotNullExpressionValue(t16, "runtimeService(clazz, process)");
        return t16;
    }

    public static /* synthetic */ IRuntimeService d(Class cls, String str, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        return c(cls, str, str2);
    }

    public static final <T extends com.tencent.mobileqq.guild.homev2.misc.d & LifecycleOwner> void e(@NotNull final T t16, @NotNull final String pageId) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        t16.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.base.extension.MiscKt$installGuildFocusReport$1

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes12.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f214735a;

                static {
                    int[] iArr = new int[Lifecycle.Event.values().length];
                    try {
                        iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f214735a = iArr;
                }
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                boolean z16;
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                int i3 = a.f214735a[event.ordinal()];
                String str = "0";
                boolean z17 = false;
                boolean z18 = true;
                if (i3 != 1) {
                    if (i3 == 2) {
                        ILocalFocusService iLocalFocusService = (ILocalFocusService) ch.R0(ILocalFocusService.class);
                        String guildId = com.tencent.mobileqq.guild.homev2.misc.d.this.getGuildId();
                        if (guildId.length() != 0) {
                            z18 = false;
                        }
                        if (!z18) {
                            str = guildId;
                        }
                        iLocalFocusService.setActiveGuild(new GuildActiveInfo(new GuildActiveInfo.UniqueKey(str, pageId), 2, false));
                        source.getLifecycle().removeObserver(this);
                        return;
                    }
                    return;
                }
                ILocalFocusService iLocalFocusService2 = (ILocalFocusService) ch.R0(ILocalFocusService.class);
                String guildId2 = com.tencent.mobileqq.guild.homev2.misc.d.this.getGuildId();
                if (guildId2.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    str = guildId2;
                }
                GuildActiveInfo.UniqueKey uniqueKey = new GuildActiveInfo.UniqueKey(str, pageId);
                if (com.tencent.mobileqq.guild.homev2.misc.d.this.getGuildId().length() > 0) {
                    z17 = true;
                }
                iLocalFocusService2.setActiveGuild(new GuildActiveInfo(uniqueKey, 2, z17));
            }
        });
    }

    public static final boolean f(@Nullable String str) {
        boolean isBlank;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                return false;
            }
        }
        return true;
    }

    public static final void g(@NotNull Bundle bundle, @NotNull String key, @Nullable String str) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!f(str)) {
            bundle.putString(key, str);
        }
    }

    @NotNull
    public static final String h(@Nullable String str, int i3) {
        if (str != null) {
            if (str.length() > i3) {
                String substring = str.substring(0, i3);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                str = substring + "...(" + (str.length() - i3) + " more)";
            }
            if (str != null) {
                return str;
            }
        }
        return "";
    }

    public static /* synthetic */ String i(String str, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 10;
        }
        return h(str, i3);
    }

    @NotNull
    public static final FacadeArgsData j(@NotNull JumpGuildParam jumpGuildParam) {
        Intrinsics.checkNotNullParameter(jumpGuildParam, "<this>");
        return zr1.e.INSTANCE.a(jumpGuildParam, null);
    }

    public static final int k(@NotNull String str) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(str, "<this>");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        return 0;
    }

    public static final long l(@NotNull String str) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(str, "<this>");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return 0L;
    }

    public static final <T extends com.tencent.mobileqq.guild.homev2.misc.d & LifecycleOwner> void m(@NotNull T t16, @NotNull String oldGuildId, @NotNull String pageId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(oldGuildId, "oldGuildId");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        if (t16.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
            boolean z17 = false;
            ((ILocalFocusService) ch.R0(ILocalFocusService.class)).setActiveGuild(new GuildActiveInfo(new GuildActiveInfo.UniqueKey(oldGuildId, pageId), 2, false));
            ILocalFocusService iLocalFocusService = (ILocalFocusService) ch.R0(ILocalFocusService.class);
            String guildId = t16.getGuildId();
            if (guildId.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                guildId = "0";
            }
            GuildActiveInfo.UniqueKey uniqueKey = new GuildActiveInfo.UniqueKey(guildId, pageId);
            if (t16.getGuildId().length() > 0) {
                z17 = true;
            }
            iLocalFocusService.setActiveGuild(new GuildActiveInfo(uniqueKey, 2, z17));
        }
    }
}
