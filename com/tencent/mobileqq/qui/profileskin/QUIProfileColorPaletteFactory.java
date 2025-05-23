package com.tencent.mobileqq.qui.profileskin;

import android.graphics.Color;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015JJ\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u00062\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bH\u0007R\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qui/profileskin/QUIProfileColorPaletteFactory;", "", "", "primaryColor", "", "isDark", "", "", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/qui/profileskin/c;", "configMap", "", DownloaderConstant.KEY_RANGE, "Lae0/a;", "b", "Lcom/tencent/mobileqq/qui/profileskin/a;", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/qui/profileskin/a;", "materialColorManager", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QUIProfileColorPaletteFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QUIProfileColorPaletteFactory f276890a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy materialColorManager;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qui/profileskin/QUIProfileColorPaletteFactory$a", "Lae0/a;", "", "colorToken", "", "getColor", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements ae0.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f276892a;

        a(Map<String, String> map) {
            this.f276892a = map;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) map);
            }
        }

        @Override // ae0.a
        @NotNull
        public int[] getColor(@Nullable String colorToken) {
            boolean z16;
            List list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (int[]) iPatchRedirector.redirect((short) 2, (Object) this, (Object) colorToken);
            }
            boolean z17 = true;
            if (colorToken != null && colorToken.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return new int[0];
            }
            String str = this.f276892a.get(colorToken);
            if (str != null) {
                list = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null);
            } else {
                list = null;
            }
            List list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                z17 = false;
            }
            if (z17) {
                return new int[0];
            }
            try {
                int[] iArr = new int[list.size()];
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    iArr[i3] = Color.parseColor((String) list.get(i3));
                }
                return iArr;
            } catch (Exception unused) {
                return new int[0];
            }
        }
    }

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37095);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f276890a = new QUIProfileColorPaletteFactory();
        lazy = LazyKt__LazyJVMKt.lazy(QUIProfileColorPaletteFactory$materialColorManager$2.INSTANCE);
        materialColorManager = lazy;
    }

    QUIProfileColorPaletteFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.mobileqq.qui.profileskin.a a() {
        return (com.tencent.mobileqq.qui.profileskin.a) materialColorManager.getValue();
    }

    @JvmStatic
    @NotNull
    public static final ae0.a b(int primaryColor, boolean isDark, @NotNull Map<String, ? extends Pair<? extends c, ? extends c>> configMap, @Nullable List<Integer> range) {
        Intrinsics.checkNotNullParameter(configMap, "configMap");
        Map<String, String> e16 = f276890a.a().e(primaryColor, isDark, configMap, range);
        com.tencent.mobileqq.qui.util.b.b(e16);
        com.tencent.mobileqq.qui.util.b.a(e16);
        com.tencent.mobileqq.qui.util.b.c(e16);
        return new a(e16);
    }
}
