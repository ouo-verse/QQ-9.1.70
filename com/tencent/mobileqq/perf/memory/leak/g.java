package com.tencent.mobileqq.perf.memory.leak;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ \u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0004R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0016R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/leak/g;", "", "", "j", "", PushClientConstants.TAG_CLASS_NAME, "name", tl.h.F, "methodName", "b", "fieldName", "a", "Ljava/lang/reflect/Method;", "c", "target", "", "throwException", "Ljava/lang/reflect/Field;", "d", "e", "i", "Ljava/util/HashMap;", "Ljava/util/HashMap;", "nameToFieldCache", "nameToMethodCache", "Z", "hasCacheInit", "isCacheInitializing", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f257775a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Field> nameToFieldCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Method> nameToMethodCache;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static volatile boolean hasCacheInit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static boolean isCacheInitializing;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30412);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f257775a = new g();
        nameToFieldCache = new HashMap<>();
        nameToMethodCache = new HashMap<>();
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(String className, String fieldName) {
        Field c16 = h.f257780a.c(className, fieldName, false);
        if (c16 != null) {
            nameToFieldCache.put(f257775a.h(className, fieldName), c16);
        }
    }

    private final void b(String className, String methodName) {
        Method f16 = h.f257780a.f(className, methodName, false);
        if (f16 != null) {
            nameToMethodCache.put(f257775a.h(className, methodName), f16);
        }
    }

    public static /* synthetic */ Field f(g gVar, Object obj, String str, boolean z16, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        return gVar.d(obj, str, z16);
    }

    public static /* synthetic */ Field g(g gVar, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        return gVar.e(str, str2, z16);
    }

    private final String h(String className, String name) {
        return className + util.base64_pad_url + name;
    }

    @JvmStatic
    public static final void j() {
        long currentTimeMillis = System.currentTimeMillis();
        g gVar = f257775a;
        gVar.b("android.hardware.display.DisplayManagerGlobal", "getInstance");
        gVar.a("android.view.inputmethod.InputMethodManager", "mCurRootView");
        gVar.a("android.view.inputmethod.InputMethodManager", "mServedView");
        gVar.a("android.view.inputmethod.InputMethodManager", "mNextServedView");
        gVar.a("android.view.inputmethod.InputMethodManager", "mLastSrvView");
        gVar.a("android.view.Window", "mContext");
        gVar.a("android.view.Window", "mCallback");
        gVar.a("android.view.Window", "mWindowControllerCallback");
        gVar.a("android.view.Window", "mOnWindowDismissedCallback");
        gVar.a("android.view.Window", "mActivityCallback");
        gVar.a("com.android.internal.policy.PhoneWindow", "mContentParent");
        gVar.a("com.android.internal.policy.DecorView", "mDecorCaptionView");
        gVar.a("com.android.internal.widget.DecorCaptionView", "mContent");
        gVar.a("com.android.internal.widget.DecorCaptionView", "mOwner");
        gVar.a("com.android.internal.widget.MiuiDecorCaptionView", "mContent");
        gVar.a("com.android.internal.widget.MiuiDecorCaptionView", "mOwner");
        gVar.a("com.android.internal.widget.MiuiDecorCaptionView", "mBottomCaption");
        gVar.a("com.android.internal.widget.VivoDecorCaptionViewImpl", "mContent");
        gVar.a("com.android.internal.widget.VivoDecorCaptionViewImpl", "mOwner");
        gVar.a("com.android.internal.widget.VivoDecorCaptionViewImpl", "mButtonContainer");
        gVar.a("android.view.ViewGroup", "mFocused");
        gVar.a("android.view.ViewRootImpl", "mView");
        gVar.a("android.view.View", "mContext");
        gVar.a("android.hardware.display.DisplayManagerGlobal", "mDisplayListeners");
        gVar.a("android.hardware.display.DisplayManagerGlobal$DisplayListenerDelegate", "mListener");
        gVar.a("android.hardware.display.DisplayManager$1", "this$0");
        gVar.a("android.hardware.display.DisplayManager", "mContext");
        hasCacheInit = true;
        QLog.d("ReflectCache", 1, "preInitCache complete, cost:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @NotNull
    public final Method c(@NotNull String className, @NotNull String methodName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Method) iPatchRedirector.redirect((short) 2, (Object) this, (Object) className, (Object) methodName);
        }
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        HashMap<String, Method> hashMap = nameToMethodCache;
        String h16 = h(className, methodName);
        Method method = hashMap.get(h16);
        if (method == null) {
            h hVar = h.f257780a;
            Class<?> cls = Class.forName(className);
            Intrinsics.checkNotNullExpressionValue(cls, "forName(className)");
            method = h.g(hVar, cls, methodName, false, 4, null);
            Intrinsics.checkNotNull(method);
            hashMap.put(h16, method);
        }
        return method;
    }

    @NotNull
    public final Field d(@NotNull Object target, @NotNull String fieldName, boolean throwException) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Field) iPatchRedirector.redirect((short) 3, this, target, fieldName, Boolean.valueOf(throwException));
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        HashMap<String, Field> hashMap = nameToFieldCache;
        String name = target.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "target.javaClass.name");
        String h16 = h(name, fieldName);
        Field field = hashMap.get(h16);
        if (field == null) {
            field = h.f257780a.b(target.getClass(), fieldName, throwException);
            Intrinsics.checkNotNull(field);
            hashMap.put(h16, field);
        }
        return field;
    }

    @NotNull
    public final Field e(@NotNull String className, @NotNull String fieldName, boolean throwException) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Field) iPatchRedirector.redirect((short) 4, this, className, fieldName, Boolean.valueOf(throwException));
        }
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        HashMap<String, Field> hashMap = nameToFieldCache;
        String h16 = h(className, fieldName);
        Field field = hashMap.get(h16);
        if (field == null) {
            h hVar = h.f257780a;
            Class<?> cls = Class.forName(className);
            Intrinsics.checkNotNullExpressionValue(cls, "forName(className)");
            field = hVar.b(cls, fieldName, throwException);
            Intrinsics.checkNotNull(field);
            hashMap.put(h16, field);
        }
        return field;
    }

    @Nullable
    public final Object i(@NotNull Object target, @NotNull String fieldName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, target, (Object) fieldName);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        try {
            return h.f257780a.d(target, f(this, target, fieldName, false, 4, null));
        } catch (Exception e16) {
            com.tencent.mobileqq.perf.memory.util.b.b(com.tencent.mobileqq.perf.memory.util.b.f257791a, "ReflectCache", "get field " + fieldName + " fail, " + e16.getMessage(), false, null, 12, null);
            return null;
        }
    }
}
