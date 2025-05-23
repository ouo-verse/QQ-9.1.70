package com.tencent.qqnt.qbasealbum.utils;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015RG\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fRG\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fRG\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\fRG\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/utils/AccessibilityUtils;", "", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "event", "Landroid/view/View;", "view", "", "b", "Lkotlin/jvm/functions/Function2;", "c", "()Lkotlin/jvm/functions/Function2;", "setViewAccessibilityNoHideDescendants", "setViewAccessibilityNo", "d", "setViewAccessibilityYes", "e", "a", "setViewAccessibilityAuto", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AccessibilityUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AccessibilityUtils f361618a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Function2<Object, View, Unit> setViewAccessibilityNoHideDescendants;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Function2<Object, View, Unit> setViewAccessibilityNo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Function2<Object, View, Unit> setViewAccessibilityYes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Function2<Object, View, Unit> setViewAccessibilityAuto;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012F\u0010\u001a\u001aB\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u00124\u00122\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u00120\u0010\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eRW\u0010\u001a\u001aB\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u00124\u00122\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u00120\u00108\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u000b\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/utils/AccessibilityUtils$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "a", "Ljava/lang/ref/WeakReference;", "b", "()Ljava/lang/ref/WeakReference;", "viewWeakRef", "", "Ljava/lang/Class;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "event", "view", "", "Ljava/util/Map;", "()Ljava/util/Map;", "eventHandlers", "<init>", "(Ljava/lang/ref/WeakReference;Ljava/util/Map;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<View> viewWeakRef;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Map<Class<?>, Function2<Object, View, Unit>> eventHandlers;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull WeakReference<View> viewWeakRef, @NotNull Map<Class<?>, ? extends Function2<Object, ? super View, Unit>> eventHandlers) {
            Intrinsics.checkNotNullParameter(viewWeakRef, "viewWeakRef");
            Intrinsics.checkNotNullParameter(eventHandlers, "eventHandlers");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewWeakRef, (Object) eventHandlers);
            } else {
                this.viewWeakRef = viewWeakRef;
                this.eventHandlers = eventHandlers;
            }
        }

        @NotNull
        public final Map<Class<?>, Function2<Object, View, Unit>> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.eventHandlers;
        }

        @NotNull
        public final WeakReference<View> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (WeakReference) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.viewWeakRef;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (Intrinsics.areEqual(this.viewWeakRef, aVar.viewWeakRef) && Intrinsics.areEqual(this.eventHandlers, aVar.eventHandlers)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return (this.viewWeakRef.hashCode() * 31) + this.eventHandlers.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "AccessibilityViewEventHandler(viewWeakRef=" + this.viewWeakRef + ", eventHandlers=" + this.eventHandlers + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45257);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f361618a = new AccessibilityUtils();
        setViewAccessibilityNoHideDescendants = AccessibilityUtils$setViewAccessibilityNoHideDescendants$1.INSTANCE;
        setViewAccessibilityNo = AccessibilityUtils$setViewAccessibilityNo$1.INSTANCE;
        setViewAccessibilityYes = AccessibilityUtils$setViewAccessibilityYes$1.INSTANCE;
        setViewAccessibilityAuto = AccessibilityUtils$setViewAccessibilityAuto$1.INSTANCE;
    }

    AccessibilityUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Function2<Object, View, Unit> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Function2) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return setViewAccessibilityAuto;
    }

    @NotNull
    public final Function2<Object, View, Unit> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Function2) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return setViewAccessibilityNo;
    }

    @NotNull
    public final Function2<Object, View, Unit> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Function2) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return setViewAccessibilityNoHideDescendants;
    }

    @NotNull
    public final Function2<Object, View, Unit> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Function2) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return setViewAccessibilityYes;
    }
}
