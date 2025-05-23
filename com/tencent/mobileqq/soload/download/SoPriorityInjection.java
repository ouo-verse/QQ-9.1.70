package com.tencent.mobileqq.soload.download;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/soload/download/SoPriorityInjection;", "", "a", "soloader-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SoPriorityInjection {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, Integer> f288668b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R,\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\b8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/soload/download/SoPriorityInjection$a;", "", "", "soName", "", "c", "", "a", "Ljava/util/HashMap;", "priorityMap", "Ljava/util/HashMap;", "b", "()Ljava/util/HashMap;", "getPriorityMap$annotations", "()V", "PRIORITY_BELOW_MILLION", "I", "PRIORITY_IMMEDIATELY", "PRIORITY_LOWEST", "PRIORITY_OVER_ONE_HUNDRED_MILLION", "PRIORITY_OVER_ONE_MILLION", "PRIORITY_OVER_TEN_MILLION", "<init>", "soloader-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.soload.download.SoPriorityInjection$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        public final int a(@Nullable String soName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) soName)).intValue();
            }
            if (soName != null) {
                Companion companion = SoPriorityInjection.INSTANCE;
                if (companion.b().containsKey(soName)) {
                    Integer num = companion.b().get(soName);
                    Intrinsics.checkNotNull(num);
                    return num.intValue();
                }
                return 1;
            }
            return 1;
        }

        @NotNull
        public final HashMap<String, Integer> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return SoPriorityInjection.f288668b;
            }
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @JvmStatic
        public final boolean c(@Nullable String soName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) soName)).booleanValue();
            }
            if (soName != null) {
                return SoPriorityInjection.INSTANCE.b().containsKey(soName);
            }
            return false;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20924);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
            f288668b = new HashMap<String, Integer>() { // from class: com.tencent.mobileqq.soload.download.SoPriorityInjection$Companion$priorityMap$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    put("flexbox", 99);
                    put("hippy", 99);
                    put("hippy_qq_021306", 99);
                    put("v8_shared", 99);
                    put(SoLoadConstants.SONAME_TRTC, 99);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ boolean containsKey(Object obj) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, obj)).booleanValue();
                    }
                    if (obj instanceof String) {
                        return containsKey((String) obj);
                    }
                    return false;
                }

                public /* bridge */ boolean containsValue(Integer num) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? super.containsValue((Object) num) : ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) num)).booleanValue();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<Map.Entry<String, Integer>> entrySet() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                        return (Set) iPatchRedirector.redirect((short) 15, (Object) this);
                    }
                    return getEntries();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Integer get(Object obj) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                        return (Integer) iPatchRedirector.redirect((short) 11, (Object) this, obj);
                    }
                    if (obj instanceof String) {
                        return get((String) obj);
                    }
                    return null;
                }

                public /* bridge */ Set<Map.Entry<String, Integer>> getEntries() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                        return (Set) iPatchRedirector.redirect((short) 14, (Object) this);
                    }
                    return super.entrySet();
                }

                public /* bridge */ Set<String> getKeys() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                        return (Set) iPatchRedirector.redirect((short) 16, (Object) this);
                    }
                    return super.keySet();
                }

                public final /* bridge */ Integer getOrDefault(Object obj, Integer num) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? !(obj instanceof String) ? num : getOrDefault((String) obj, num) : (Integer) iPatchRedirector.redirect((short) 13, (Object) this, obj, (Object) num);
                }

                public /* bridge */ int getSize() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                        return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
                    }
                    return super.size();
                }

                public /* bridge */ Collection<Integer> getValues() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                        return (Collection) iPatchRedirector.redirect((short) 18, (Object) this);
                    }
                    return super.values();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<String> keySet() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                        return (Set) iPatchRedirector.redirect((short) 17, (Object) this);
                    }
                    return getKeys();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Integer remove(Object obj) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return (Integer) iPatchRedirector.redirect((short) 3, (Object) this, obj);
                    }
                    if (obj instanceof String) {
                        return remove((String) obj);
                    }
                    return null;
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ int size() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                        return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
                    }
                    return getSize();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Collection<Integer> values() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                        return (Collection) iPatchRedirector.redirect((short) 19, (Object) this);
                    }
                    return getValues();
                }

                public /* bridge */ boolean containsKey(String str) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? super.containsKey((Object) str) : ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ boolean containsValue(Object obj) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, obj)).booleanValue();
                    }
                    if (obj instanceof Integer) {
                        return containsValue((Integer) obj);
                    }
                    return false;
                }

                public /* bridge */ Integer get(String str) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? (Integer) super.get((Object) str) : (Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
                }

                public /* bridge */ Integer getOrDefault(String str, Integer num) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? (Integer) super.getOrDefault((Object) str, (String) num) : (Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) num);
                }

                public /* bridge */ Integer remove(String str) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? (Integer) super.remove((Object) str) : (Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object get(Object obj) {
                    if (obj instanceof String) {
                        return get((String) obj);
                    }
                    return null;
                }

                @Override // java.util.HashMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                    return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (Integer) obj2);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                    if (obj instanceof String) {
                        return remove((String) obj);
                    }
                    return null;
                }

                @Override // java.util.HashMap, java.util.Map
                public final /* bridge */ boolean remove(Object obj, Object obj2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, obj, obj2)).booleanValue();
                    }
                    if ((obj instanceof String) && (obj2 instanceof Integer)) {
                        return remove((String) obj, (Integer) obj2);
                    }
                    return false;
                }

                public /* bridge */ boolean remove(String str, Integer num) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? super.remove((Object) str, (Object) num) : ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) num)).booleanValue();
                }
            };
        }
    }

    @JvmStatic
    public static final int b(@Nullable String str) {
        return INSTANCE.a(str);
    }

    @JvmStatic
    public static final boolean c(@Nullable String str) {
        return INSTANCE.c(str);
    }
}
