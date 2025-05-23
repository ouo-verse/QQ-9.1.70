package com.tencent.qqnt.audio.injector;

import com.tencent.mobileqq.injector.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R8\u0010\f\u001a&\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\b0\u0007j\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\b`\t8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0005\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/audio/injector/a;", "", "Lcom/tencent/qqnt/audio/injector/b;", "a", "b", "Lcom/tencent/qqnt/audio/injector/b;", "DEFAULT_PROVIDER", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "configProvider", "d", "provider", "<init>", "()V", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f352538a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b DEFAULT_PROVIDER;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Component/AudioKit/Inject_audio_kit.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<? extends b>> configProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static b provider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/audio/injector/a$a", "Lcom/tencent/qqnt/audio/injector/b;", "", "a", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.audio.injector.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static final class C9500a implements b {
        static IPatchRedirector $redirector_;

        C9500a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.audio.injector.b
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36327);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f352538a = new a();
        b c9500a = new C9500a();
        DEFAULT_PROVIDER = c9500a;
        ArrayList<Class<? extends b>> arrayList = new ArrayList<>();
        configProvider = arrayList;
        arrayList.add(g.class);
        try {
            if (!arrayList.isEmpty()) {
                b newInstance = arrayList.get(0).newInstance();
                if (newInstance != null) {
                    c9500a = newInstance;
                }
            }
        } catch (Throwable unused) {
            c9500a = DEFAULT_PROVIDER;
        }
        provider = c9500a;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return provider;
    }
}
