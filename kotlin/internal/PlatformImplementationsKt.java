package kotlin.internal;

import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0083\b\u00a2\u0006\u0002\u0010\f\u001a\b\u0010\r\u001a\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class PlatformImplementationsKt {

    @JvmField
    @NotNull
    public static final PlatformImplementations IMPLEMENTATIONS;

    static {
        PlatformImplementations platformImplementations;
        Object newInstance;
        Object newInstance2;
        int javaVersion = getJavaVersion();
        if (javaVersion >= 65544 || javaVersion < 65536) {
            try {
                try {
                    newInstance = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                    Intrinsics.checkNotNullExpressionValue(newInstance, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                    try {
                    } catch (ClassCastException e16) {
                        ClassLoader classLoader = newInstance.getClass().getClassLoader();
                        ClassLoader classLoader2 = PlatformImplementations.class.getClassLoader();
                        if (!Intrinsics.areEqual(classLoader, classLoader2)) {
                            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e16);
                        }
                        throw e16;
                    }
                } catch (ClassNotFoundException unused) {
                }
            } catch (ClassNotFoundException unused2) {
                Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                Intrinsics.checkNotNullExpressionValue(newInstance3, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                try {
                    if (newInstance3 != null) {
                        platformImplementations = (PlatformImplementations) newInstance3;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                } catch (ClassCastException e17) {
                    ClassLoader classLoader3 = newInstance3.getClass().getClassLoader();
                    ClassLoader classLoader4 = PlatformImplementations.class.getClassLoader();
                    if (!Intrinsics.areEqual(classLoader3, classLoader4)) {
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e17);
                    }
                    throw e17;
                }
            }
            if (newInstance != null) {
                platformImplementations = (PlatformImplementations) newInstance;
                IMPLEMENTATIONS = platformImplementations;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
        }
        if (javaVersion >= 65543 || javaVersion < 65536) {
            try {
                newInstance2 = Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();
                Intrinsics.checkNotNullExpressionValue(newInstance2, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                try {
                } catch (ClassCastException e18) {
                    ClassLoader classLoader5 = newInstance2.getClass().getClassLoader();
                    ClassLoader classLoader6 = PlatformImplementations.class.getClassLoader();
                    if (!Intrinsics.areEqual(classLoader5, classLoader6)) {
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e18);
                    }
                    throw e18;
                }
            } catch (ClassNotFoundException unused3) {
                Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                Intrinsics.checkNotNullExpressionValue(newInstance4, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                try {
                    if (newInstance4 != null) {
                        platformImplementations = (PlatformImplementations) newInstance4;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                } catch (ClassCastException e19) {
                    ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                    ClassLoader classLoader8 = PlatformImplementations.class.getClassLoader();
                    if (!Intrinsics.areEqual(classLoader7, classLoader8)) {
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e19);
                    }
                    throw e19;
                }
            }
            if (newInstance2 != null) {
                platformImplementations = (PlatformImplementations) newInstance2;
                IMPLEMENTATIONS = platformImplementations;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
        }
        platformImplementations = new PlatformImplementations();
        IMPLEMENTATIONS = platformImplementations;
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @PublishedApi
    public static final boolean apiVersionIsAtLeast(int i3, int i16, int i17) {
        return KotlinVersion.CURRENT.isAtLeast(i3, i16, i17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final /* synthetic */ <T> T castToBaseType(Object obj) {
        try {
            Intrinsics.reifiedOperationMarker(1, "T");
            return obj;
        } catch (ClassCastException e16) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            Intrinsics.reifiedOperationMarker(4, "T");
            ClassLoader classLoader2 = Object.class.getClassLoader();
            if (!Intrinsics.areEqual(classLoader, classLoader2)) {
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e16);
            }
            throw e16;
        }
    }

    private static final int getJavaVersion() {
        int indexOf$default;
        int indexOf$default2;
        String property = System.getProperty("java.specification.version");
        if (property != null) {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) property, '.', 0, false, 6, (Object) null);
            if (indexOf$default < 0) {
                try {
                    return Integer.parseInt(property) * 65536;
                } catch (NumberFormatException unused) {
                    return 65542;
                }
            }
            int i3 = indexOf$default + 1;
            indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) property, '.', i3, false, 4, (Object) null);
            if (indexOf$default2 < 0) {
                indexOf$default2 = property.length();
            }
            String substring = property.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String substring2 = property.substring(i3, indexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            try {
                return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
            } catch (NumberFormatException unused2) {
                return 65542;
            }
        }
        return 65542;
    }
}
