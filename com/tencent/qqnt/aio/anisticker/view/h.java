package com.tencent.qqnt.aio.anisticker.view;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.m;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottie;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rlottie.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002&\u000eB\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002R\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020!8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/qqnt/aio/anisticker/view/h;", "", "", NodeProps.ENABLED, "l", tl.h.F, "g", "c", "", "e", "i", "clearLottieCache", "hasCacheChecked", "k", "b", "Z", "lottieCacheEnabled", "lottieSoLoaded", "Lcom/tencent/qqnt/aio/anisticker/view/h$a;", "d", "Lcom/tencent/qqnt/aio/anisticker/view/h$a;", "getReport", "()Lcom/tencent/qqnt/aio/anisticker/view/h$a;", "setReport", "(Lcom/tencent/qqnt/aio/anisticker/view/h$a;)V", "report", "Lcom/tencent/qqnt/aio/anisticker/view/h$b;", "Lcom/tencent/qqnt/aio/anisticker/view/h$b;", "getSharedPreferenceProvider", "()Lcom/tencent/qqnt/aio/anisticker/view/h$b;", "setSharedPreferenceProvider", "(Lcom/tencent/qqnt/aio/anisticker/view/h$b;)V", "sharedPreferenceProvider", "Landroid/content/SharedPreferences;", "()Landroid/content/SharedPreferences;", "sp", "<init>", "()V", "a", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f348873a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean lottieCacheEnabled;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean lottieSoLoaded;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static a report;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static b sharedPreferenceProvider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/anisticker/view/h$a;", "", "", "event", "", "params", "", "report", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface a {
        void report(@NotNull String event, @NotNull Map<String, String> params);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/aio/anisticker/view/h$b;", "", "", "name", "Landroid/content/SharedPreferences;", "getSharedPreference", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface b {
        @NotNull
        SharedPreferences getSharedPreference(@NotNull String name);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/anisticker/view/h$c", "Lcom/tencent/qqnt/aio/anisticker/view/h$a;", "", "event", "", "params", "", "report", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.view.h.a
        public void report(@NotNull String event, @NotNull Map<String, String> params) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event, (Object) params);
                return;
            }
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(params, "params");
            QLog.i(AniStickerLottie.TAG, 1, "[report] log only, event=" + event + ", params=" + params);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/anisticker/view/h$d", "Lcom/tencent/qqnt/aio/anisticker/view/h$b;", "", "name", "Landroid/content/SharedPreferences;", "getSharedPreference", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class d implements b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.view.h.b
        @NotNull
        public SharedPreferences getSharedPreference(@NotNull String name) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SharedPreferences) iPatchRedirector.redirect((short) 2, (Object) this, (Object) name);
            }
            Intrinsics.checkNotNullParameter(name, "name");
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(name, 4);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getContext().getSharedPr\u2026ntext.MODE_MULTI_PROCESS)");
            return sharedPreferences;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34529);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        f348873a = new h();
        lottieCacheEnabled = true;
        report = new c();
        sharedPreferenceProvider = new d();
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final SharedPreferences d() {
        return sharedPreferenceProvider.getSharedPreference("AniStickerLottie.SP");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(long j3, long j16, long j17) {
        HashMap hashMap = new HashMap();
        hashMap.put(MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, String.valueOf(j3));
        hashMap.put("cacheSize", String.valueOf(j16));
        hashMap.put("cacheCount", String.valueOf(j16));
        report.report(AniStickerLottie.CACHE_CLEAR_TAG, hashMap);
    }

    private final boolean h() {
        SharedPreferences d16 = d();
        String o16 = m.o(5);
        String string = d16.getString(AniStickerLottie.LOTTIE_CACHE_MD5, "");
        Intrinsics.checkNotNull(string);
        boolean z16 = true;
        if (QLog.isColorLevel()) {
            QLog.d(AniStickerLottie.TAG, 2, "cacheMd5:", string, " newMd5:", o16);
        }
        if (TextUtils.isEmpty(string) || Intrinsics.areEqual(string, o16)) {
            z16 = false;
        }
        if (TextUtils.isEmpty(string) || z16) {
            d16.edit().putString(AniStickerLottie.LOTTIE_CACHE_MD5, o16).apply();
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(boolean z16, boolean z17) {
        f348873a.k(z16, z17);
    }

    private final boolean l(boolean enabled) {
        lottieCacheEnabled = enabled;
        return enabled;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return lottieCacheEnabled;
    }

    public final synchronized void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (lottieSoLoaded) {
            return;
        }
        boolean d16 = com.tencent.rlottie.a.d(BaseApplication.getContext());
        lottieSoLoaded = d16;
        if (!d16) {
            return;
        }
        com.tencent.rlottie.a.b(null).b(AniStickerLottie.CACHE_SIGNATURE);
        com.tencent.rlottie.a.b(null).a(new b.a() { // from class: com.tencent.qqnt.aio.anisticker.view.f
            @Override // com.tencent.rlottie.b.a
            public final void onClearCache(long j3, long j16, long j17) {
                h.f(j3, j16, j17);
            }
        });
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return lottieSoLoaded;
    }

    public final synchronized void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        l(false);
        com.tencent.rlottie.b b16 = com.tencent.rlottie.a.b(BaseApplication.getContext());
        Intrinsics.checkNotNullExpressionValue(b16, "getLottieCacheManager(MobileQQ.getContext())");
        final boolean h16 = h();
        final boolean j3 = b16.j();
        if (!h16 && j3) {
            l(true);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.anisticker.view.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.j(h16, j3);
                }
            }, 64, null, false);
        }
    }

    public final synchronized void k(boolean clearLottieCache, boolean hasCacheChecked) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(clearLottieCache), Boolean.valueOf(hasCacheChecked));
            return;
        }
        com.tencent.rlottie.a.d(BaseApplication.getContext());
        com.tencent.rlottie.b b16 = com.tencent.rlottie.a.b(BaseApplication.getContext());
        Intrinsics.checkNotNullExpressionValue(b16, "getLottieCacheManager(MobileQQ.getContext())");
        if (clearLottieCache) {
            QLog.d(AniStickerLottie.TAG, 1, "clear cache, emoticon,  isSuccess:", Boolean.valueOf(b16.e(AniStickerLottie.CACHE_SIGNATURE)));
        }
        if (!hasCacheChecked) {
            b16.d();
            QLog.d(AniStickerLottie.TAG, 1, "clear cache, over Limit");
        }
        l(true);
    }
}
