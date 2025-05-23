package com.tencent.mobileqq.guild.main;

import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0004J\b\u0010\u0019\u001a\u00020\u0018H\u0016R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u001ej\b\u0012\u0004\u0012\u00020\u000b`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010 R$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/main/GuildPageStateManager;", "", "Lcom/tencent/mobileqq/guild/main/PageState;", "state", "", "stateValue", "", "k", "e", "enableAnimate", "d", "Lcom/tencent/mobileqq/guild/main/a;", "listener", "i", "j", "b", "enable", "c", "isVisible", h.F, "isActive", "g", "isScrolling", "f", "", "toString", "Ljava/util/EnumMap;", "a", "Ljava/util/EnumMap;", "states", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "animateEnableListeners", "Lcom/tencent/mobileqq/guild/main/e;", "pageStateChangedListener", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildPageStateManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EnumMap<PageState, Boolean> states = new EnumMap<>(PageState.class);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<a> animateEnableListeners = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<e> pageStateChangedListener = new ArrayList<>();

    private final void d(boolean enableAnimate) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.MF.Rt.GuildPageStateManager", "notifyAnimateEnableChanged: " + enableAnimate + ", " + this);
        }
        Iterator<T> it = this.animateEnableListeners.iterator();
        while (it.hasNext()) {
            ((a) it.next()).d(enableAnimate);
        }
    }

    private final void e(PageState state, boolean stateValue) {
        if (!Intrinsics.areEqual(this.states.get(state), Boolean.valueOf(stateValue))) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.MF.Rt.GuildPageStateManager", "notifyPageStateChanged: " + state + ", " + stateValue);
            }
            Iterator<T> it = this.pageStateChangedListener.iterator();
            while (it.hasNext()) {
                ((e) it.next()).a(state, stateValue);
            }
        }
    }

    private final void k(PageState state, boolean stateValue) {
        e(state, stateValue);
        boolean b16 = b();
        this.states.put((EnumMap<PageState, Boolean>) state, (PageState) Boolean.valueOf(stateValue));
        boolean b17 = b();
        if (b16 != b17) {
            d(b17);
        }
    }

    public boolean b() {
        boolean booleanValue;
        boolean booleanValue2;
        boolean booleanValue3;
        if (DeviceInfoUtils.isLowPerfDevice()) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.MF.Rt.GuildPageStateManager", "isLowPerfDevice animate disable");
            }
            return false;
        }
        Boolean bool = this.states.get(PageState.ANIMATION_SWITCH);
        if (bool == null) {
            booleanValue = true;
        } else {
            booleanValue = bool.booleanValue();
        }
        if (!booleanValue) {
            return false;
        }
        Boolean bool2 = this.states.get(PageState.PAGE_VISIBILITY);
        if (bool2 == null) {
            booleanValue2 = true;
        } else {
            booleanValue2 = bool2.booleanValue();
        }
        if (!booleanValue2) {
            return false;
        }
        Boolean bool3 = this.states.get(PageState.PAGE_LIFECYCLE_ACTIVE);
        if (bool3 == null) {
            booleanValue3 = true;
        } else {
            booleanValue3 = bool3.booleanValue();
        }
        if (!booleanValue3) {
            return false;
        }
        Boolean bool4 = this.states.get(PageState.LIST_SCROLL_STATUE);
        if (bool4 == null) {
            bool4 = Boolean.FALSE;
        }
        if (bool4.booleanValue()) {
            return false;
        }
        return true;
    }

    public final void c(boolean enable) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.MF.Rt.GuildPageStateManager", "enableAnimation: " + enable + ", " + this);
        }
        k(PageState.ANIMATION_SWITCH, enable);
    }

    public final void f(boolean isScrolling) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.MF.Rt.GuildPageStateManager", "onListScrollStateChanged: " + isScrolling + ", " + this);
        }
        k(PageState.LIST_SCROLL_STATUE, isScrolling);
    }

    public final void g(boolean isActive) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.MF.Rt.GuildPageStateManager", "onPageActiveChanged: " + isActive + ", " + this);
        }
        k(PageState.PAGE_LIFECYCLE_ACTIVE, isActive);
    }

    public final void h(boolean isVisible) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.MF.Rt.GuildPageStateManager", "onPageVisibleChanged: " + isVisible + ", " + this);
        }
        k(PageState.PAGE_VISIBILITY, isVisible);
    }

    public final void i(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.animateEnableListeners.contains(listener)) {
            this.animateEnableListeners.add(listener);
        }
    }

    public final void j(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.animateEnableListeners.contains(listener)) {
            this.animateEnableListeners.remove(listener);
        }
    }

    @NotNull
    public String toString() {
        String joinToString$default;
        joinToString$default = ArraysKt___ArraysKt.joinToString$default(PageState.values(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<PageState, CharSequence>() { // from class: com.tencent.mobileqq.guild.main.GuildPageStateManager$toString$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull PageState it) {
                EnumMap enumMap;
                Intrinsics.checkNotNullParameter(it, "it");
                String name = it.name();
                enumMap = GuildPageStateManager.this.states;
                return name + ContainerUtils.KEY_VALUE_DELIMITER + enumMap.get(it);
            }
        }, 31, (Object) null);
        return joinToString$default;
    }
}
