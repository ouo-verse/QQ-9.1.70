package com.tencent.mobileqq.inject;

import android.content.Context;
import com.tencent.mobileqq.inject.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0016\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J,\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u001c\u0010\u0015\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0017R:\u0010\u001f\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020\u00010\u001a0\u0019j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020\u00010\u001a`\u001b8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010$\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/inject/a;", "Lcom/tencent/mobileqq/inject/f;", "Landroid/content/Context;", "context", "", "libName", "", "version", "", "includePrivateLib", "loadNativeLibrary", "b", "enableTalkBack", "isDebugVersion", "getAppId", "getSubVersion", "a", "robotUin", "Lcom/tencent/mobileqq/inject/f$a;", "voiceTypeListener", "", "c", "com/tencent/mobileqq/inject/a$a", "Lcom/tencent/mobileqq/inject/a$a;", "defaultAbility", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getAbilityClass", "()Ljava/util/ArrayList;", "abilityClass", "d", "Lcom/tencent/mobileqq/inject/f;", "getAbility", "()Lcom/tencent/mobileqq/inject/f;", "ability", "<init>", "()V", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f238063a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final C7940a defaultAbility;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Foundation/QQAudio/Inject_ExtendAbility.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<? super f>> abilityClass;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final f ability;

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u001c\u0010\u0015\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/inject/a$a", "Lcom/tencent/mobileqq/inject/f;", "Landroid/content/Context;", "context", "", "libName", "", "version", "", "includePrivateLib", "loadNativeLibrary", "b", "enableTalkBack", "isDebugVersion", "getAppId", "getSubVersion", "a", "robotUin", "Lcom/tencent/mobileqq/inject/f$a;", "voiceTypeListener", "", "c", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.inject.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C7940a implements f {
        static IPatchRedirector $redirector_;

        C7940a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.inject.f
        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return 31;
        }

        @Override // com.tencent.mobileqq.inject.f
        public int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 1000;
        }

        @Override // com.tencent.mobileqq.inject.f
        public void c(@Nullable String robotUin, @Nullable f.a voiceTypeListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) robotUin, (Object) voiceTypeListener);
            } else if (voiceTypeListener != null) {
                voiceTypeListener.a("1");
            }
        }

        @Override // com.tencent.mobileqq.inject.f
        public boolean enableTalkBack() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.inject.f
        public int getAppId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.inject.f
        @NotNull
        public String getSubVersion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "8.8.8";
        }

        @Override // com.tencent.mobileqq.inject.f
        public boolean isDebugVersion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.inject.f
        public boolean loadNativeLibrary(@Nullable Context context, @Nullable String libName, int version, boolean includePrivateLib) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, context, libName, Integer.valueOf(version), Boolean.valueOf(includePrivateLib))).booleanValue();
            }
            if (libName != null) {
                try {
                    System.loadLibrary(libName);
                } catch (Exception unused) {
                    return false;
                }
            }
            return true;
        }
    }

    static {
        f fVar;
        Object first;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36059);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        f238063a = new a();
        defaultAbility = new C7940a();
        ArrayList<Class<? super f>> arrayList = new ArrayList<>();
        abilityClass = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.f.class);
        try {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            Object newInstance = ((Class) first).newInstance();
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.mobileqq.inject.IExtendAbility");
            fVar = (f) newInstance;
        } catch (Exception unused) {
            fVar = null;
        }
        ability = fVar;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.inject.f
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        f fVar = ability;
        if (fVar == null) {
            fVar = defaultAbility;
        }
        return fVar.a();
    }

    @Override // com.tencent.mobileqq.inject.f
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        f fVar = ability;
        if (fVar == null) {
            fVar = defaultAbility;
        }
        return fVar.b();
    }

    @Override // com.tencent.mobileqq.inject.f
    public void c(@Nullable String robotUin, @Nullable f.a voiceTypeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) robotUin, (Object) voiceTypeListener);
            return;
        }
        f fVar = ability;
        if (fVar == null) {
            fVar = defaultAbility;
        }
        fVar.c(robotUin, voiceTypeListener);
    }

    @Override // com.tencent.mobileqq.inject.f
    public boolean enableTalkBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        f fVar = ability;
        if (fVar == null) {
            fVar = defaultAbility;
        }
        return fVar.enableTalkBack();
    }

    @Override // com.tencent.mobileqq.inject.f
    public int getAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        f fVar = ability;
        if (fVar == null) {
            fVar = defaultAbility;
        }
        return fVar.getAppId();
    }

    @Override // com.tencent.mobileqq.inject.f
    @NotNull
    public String getSubVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        f fVar = ability;
        if (fVar == null) {
            fVar = defaultAbility;
        }
        String subVersion = fVar.getSubVersion();
        Intrinsics.checkNotNullExpressionValue(subVersion, "curAbility.subVersion");
        return subVersion;
    }

    @Override // com.tencent.mobileqq.inject.f
    public boolean isDebugVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        f fVar = ability;
        if (fVar == null) {
            fVar = defaultAbility;
        }
        return fVar.isDebugVersion();
    }

    @Override // com.tencent.mobileqq.inject.f
    public boolean loadNativeLibrary(@Nullable Context context, @Nullable String libName, int version, boolean includePrivateLib) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, context, libName, Integer.valueOf(version), Boolean.valueOf(includePrivateLib))).booleanValue();
        }
        f fVar = ability;
        if (fVar == null) {
            return defaultAbility.loadNativeLibrary(context, libName, version, includePrivateLib);
        }
        boolean loadNativeLibrary = fVar.loadNativeLibrary(context, libName, version, includePrivateLib);
        QLog.d("ExtendAbility", 1, "use " + fVar + " load " + libName + ", -> " + loadNativeLibrary);
        if (!loadNativeLibrary) {
            return false;
        }
        return true;
    }
}
