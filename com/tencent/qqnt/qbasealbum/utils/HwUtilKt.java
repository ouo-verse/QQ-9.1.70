package com.tencent.qqnt.qbasealbum.utils;

import android.os.SystemProperties;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000\u00a8\u0006\u0004"}, d2 = {"", "b", "", "a", "nt_album_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class HwUtilKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v8, types: [T, java.lang.String] */
    @Nullable
    public static final String a() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            Object invoke = SystemProperties.class.getDeclaredMethod("get", String.class).invoke(SystemProperties.class, "hw_sc.build.platform.version");
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.String");
            objectRef.element = (String) invoke;
        } catch (ClassNotFoundException e16) {
            ox3.a.f("HwUtil", new Function0<String>(e16) { // from class: com.tencent.qqnt.qbasealbum.utils.HwUtilKt$getHarmonyVersion$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ClassNotFoundException $e;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$e = e16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) e16);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "getHarmonyVersion e: " + this.$e;
                }
            });
        } catch (IllegalAccessException e17) {
            ox3.a.f("HwUtil", new Function0<String>(e17) { // from class: com.tencent.qqnt.qbasealbum.utils.HwUtilKt$getHarmonyVersion$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ IllegalAccessException $e;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$e = e17;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) e17);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "getHarmonyVersion e: " + this.$e;
                }
            });
        } catch (NoSuchMethodException e18) {
            ox3.a.f("HwUtil", new Function0<String>(e18) { // from class: com.tencent.qqnt.qbasealbum.utils.HwUtilKt$getHarmonyVersion$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ NoSuchMethodException $e;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$e = e18;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) e18);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "getHarmonyVersion e: " + this.$e;
                }
            });
        } catch (InvocationTargetException e19) {
            ox3.a.f("HwUtil", new Function0<String>(e19) { // from class: com.tencent.qqnt.qbasealbum.utils.HwUtilKt$getHarmonyVersion$4
                static IPatchRedirector $redirector_;
                final /* synthetic */ InvocationTargetException $e;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$e = e19;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) e19);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "getHarmonyVersion e: " + this.$e;
                }
            });
        }
        String str = (String) objectRef.element;
        ox3.a.c("HwUtil", new Function0<String>(objectRef) { // from class: com.tencent.qqnt.qbasealbum.utils.HwUtilKt$getHarmonyVersion$5$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Ref.ObjectRef<String> $harmonyVersion;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$harmonyVersion = objectRef;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) objectRef);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "getHarmonyVersion " + ((Object) this.$harmonyVersion.element);
            }
        });
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x003a, code lost:
    
        if (r3 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean b() {
        String str;
        String str2;
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Object invoke = cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
            if (invoke != null) {
                str = invoke.toString();
            } else {
                str = null;
            }
            Locale locale = Locale.ROOT;
            String lowerCase = "Harmony".toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (str != null) {
                str2 = str.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            str2 = "";
            final boolean equals = TextUtils.equals(lowerCase, str2);
            ox3.a.c("HwUtil", new Function0<String>(equals) { // from class: com.tencent.qqnt.qbasealbum.utils.HwUtilKt$isHarmonyOS$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $this_apply;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$this_apply = equals;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, equals);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "isHarmonyOS " + this.$this_apply;
                }
            });
            return equals;
        } catch (ClassNotFoundException e16) {
            ox3.a.f("HwUtil", new Function0<String>(e16) { // from class: com.tencent.qqnt.qbasealbum.utils.HwUtilKt$isHarmonyOS$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ ClassNotFoundException $e;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$e = e16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) e16);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "isHarmonyOS e: " + this.$e;
                }
            });
            return false;
        } catch (IllegalAccessException e17) {
            ox3.a.f("HwUtil", new Function0<String>(e17) { // from class: com.tencent.qqnt.qbasealbum.utils.HwUtilKt$isHarmonyOS$4
                static IPatchRedirector $redirector_;
                final /* synthetic */ IllegalAccessException $e;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$e = e17;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) e17);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "isHarmonyOS e: " + this.$e;
                }
            });
            return false;
        } catch (NoSuchMethodException e18) {
            ox3.a.f("HwUtil", new Function0<String>(e18) { // from class: com.tencent.qqnt.qbasealbum.utils.HwUtilKt$isHarmonyOS$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ NoSuchMethodException $e;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$e = e18;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) e18);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "isHarmonyOS e: " + this.$e;
                }
            });
            return false;
        } catch (InvocationTargetException e19) {
            ox3.a.f("HwUtil", new Function0<String>(e19) { // from class: com.tencent.qqnt.qbasealbum.utils.HwUtilKt$isHarmonyOS$5
                static IPatchRedirector $redirector_;
                final /* synthetic */ InvocationTargetException $e;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$e = e19;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) e19);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "isHarmonyOS e: " + this.$e;
                }
            });
            return false;
        }
    }
}
