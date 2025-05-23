package com.tencent.mobileqq.qui.profileskin;

import androidx.core.graphics.ColorUtils;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qui.profileskin.c;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b#\u0010$JN\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tH\u0002J\u001c\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u000bH\u0002JF\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u000b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tH\u0002J-\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019JT\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tJ,\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001eR\u0016\u0010!\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010 R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001e\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/qui/profileskin/a;", "", "", "primaryColor", "", "", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/qui/profileskin/c;", "tokenMapConfig", "", DownloaderConstant.KEY_RANGE, "", "Lcom/tencent/mobileqq/qui/profileskin/b;", "f", "colorMap", "", "a", "type", "Lcom/tencent/mobileqq/qui/profileskin/material_color/palettes/a;", "pal", "", "tone", "c", "tokenMapValue", "d", "(Ljava/util/Map;Lcom/tencent/mobileqq/qui/profileskin/c;)Ljava/lang/Integer;", "", "isDark", "e", "b", "Ljava/util/List;", "reverseColorList", "Z", "lightPrimaryColor", "defaultRange", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> reverseColorList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean lightPrimaryColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> defaultRange;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qui/profileskin/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qui.profileskin.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37076);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        List<String> listOf;
        List<Integer> listOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"primary_root", "root_b"});
            this.reverseColorList = listOf;
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 80, 70, 60, 50, 40, 35, 30, 25, 20, 15, 10, 5, 0});
            this.defaultRange = listOf2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void a(Map<String, Integer> colorMap) {
        int i3;
        for (String str : this.reverseColorList) {
            Integer num = colorMap.get(str);
            if (num != null) {
                if (QQTheme.isColorDark(num.intValue())) {
                    i3 = -1;
                } else {
                    i3 = -16777216;
                }
                colorMap.put("on_" + str, Integer.valueOf(i3));
            }
        }
    }

    private final void c(String type, com.tencent.mobileqq.qui.profileskin.material_color.palettes.a pal, double tone, Map<String, Integer> colorMap, List<Integer> range) {
        colorMap.put(type + "_root", Integer.valueOf(pal.c(tone).g()));
        if (range == null) {
            range = this.defaultRange;
        }
        Iterator<Integer> it = range.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            colorMap.put(type + util.base64_pad_url + intValue, Integer.valueOf(pal.c(intValue).g()));
        }
    }

    private final Integer d(Map<String, Integer> colorMap, c tokenMapValue) {
        Integer num;
        if (tokenMapValue instanceof c.a) {
            return Integer.valueOf(((c.a) tokenMapValue).a());
        }
        if (tokenMapValue instanceof c.b) {
            c.b bVar = (c.b) tokenMapValue;
            if (colorMap.containsKey(bVar.b()) && (num = colorMap.get(bVar.b())) != null) {
                return Integer.valueOf(ColorUtils.setAlphaComponent(num.intValue(), (int) (bVar.a() * 255)));
            }
            return null;
        }
        return null;
    }

    private final Map<String, b> f(int primaryColor, Map<String, ? extends Pair<? extends c, ? extends c>> tokenMapConfig, List<Integer> range) {
        boolean startsWith$default;
        int intValue;
        int i3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<String, Integer> b16 = b(primaryColor, range);
        QLog.i("MaterialColorManager", 1, "colorMap=" + b16);
        QLog.i("MaterialColorManager", 1, "colorfulTokenMapping=" + tokenMapConfig);
        for (Map.Entry<String, ? extends Pair<? extends c, ? extends c>> entry : tokenMapConfig.entrySet()) {
            String key = entry.getKey();
            Pair<? extends c, ? extends c> value = entry.getValue();
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(key, "on_brand", false, 2, null);
            if (startsWith$default) {
                if (this.lightPrimaryColor) {
                    Integer d16 = d(b16, value.getFirst());
                    if (d16 != null) {
                        intValue = d16.intValue();
                        i3 = intValue;
                    }
                } else {
                    Integer d17 = d(b16, value.getSecond());
                    if (d17 != null) {
                        intValue = d17.intValue();
                        i3 = intValue;
                    }
                }
                linkedHashMap.put(key, new b(intValue, i3));
            } else {
                Integer d18 = d(b16, value.getFirst());
                if (d18 != null) {
                    int intValue2 = d18.intValue();
                    Integer d19 = d(b16, value.getSecond());
                    if (d19 != null) {
                        i3 = d19.intValue();
                        intValue = intValue2;
                        linkedHashMap.put(key, new b(intValue, i3));
                    }
                }
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public final Map<String, Integer> b(int primaryColor, @Nullable List<Integer> range) {
        boolean z16;
        double coerceIn;
        double coerceIn2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this, primaryColor, (Object) range);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        com.tencent.mobileqq.qui.profileskin.material_color.hct.b b16 = com.tencent.mobileqq.qui.profileskin.material_color.hct.b.b(primaryColor);
        if (b16.e() > 60.0d) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.lightPrimaryColor = z16;
        coerceIn = RangesKt___RangesKt.coerceIn(b16.e(), 5.0d, 80.0d);
        coerceIn2 = RangesKt___RangesKt.coerceIn(b16.e(), 30.0d, 95.0d);
        com.tencent.mobileqq.qui.profileskin.material_color.palettes.a b17 = com.tencent.mobileqq.qui.profileskin.material_color.palettes.a.b(b16.d(), b16.c());
        Intrinsics.checkNotNullExpressionValue(b17, "fromHueAndChroma(hct.hue, hct.chroma)");
        linkedHashMap.put("root_a", Integer.valueOf(b17.c(coerceIn).g()));
        linkedHashMap.put("root_b", Integer.valueOf(b17.c(coerceIn2).g()));
        c("primary", b17, coerceIn, linkedHashMap, range);
        com.tencent.mobileqq.qui.profileskin.material_color.palettes.a secondary = com.tencent.mobileqq.qui.profileskin.material_color.palettes.a.b(b16.d(), b16.c() / 3.0d);
        Intrinsics.checkNotNullExpressionValue(secondary, "secondary");
        c("secondary", secondary, coerceIn, linkedHashMap, range);
        com.tencent.mobileqq.qui.profileskin.material_color.palettes.a neutral = com.tencent.mobileqq.qui.profileskin.material_color.palettes.a.b(b16.d(), b16.c() / 6.0d);
        Intrinsics.checkNotNullExpressionValue(neutral, "neutral");
        c("neutral", neutral, coerceIn, linkedHashMap, range);
        a(linkedHashMap);
        return linkedHashMap;
    }

    @NotNull
    public final Map<String, String> e(int primaryColor, boolean isDark, @NotNull Map<String, ? extends Pair<? extends c, ? extends c>> tokenMapConfig, @Nullable List<Integer> range) {
        boolean contains$default;
        String str;
        int b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(primaryColor), Boolean.valueOf(isDark), tokenMapConfig, range);
        }
        Intrinsics.checkNotNullParameter(tokenMapConfig, "tokenMapConfig");
        Map<String, b> f16 = f(primaryColor, tokenMapConfig, range);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, b> entry : f16.entrySet()) {
            String key = entry.getKey();
            b value = entry.getValue();
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) key, (CharSequence) "button", false, 2, (Object) null);
            if (contains$default) {
                str = "qui_" + key + ".xml";
            } else {
                str = "qui_common_" + key + ".xml";
            }
            com.tencent.mobileqq.qui.util.b bVar = com.tencent.mobileqq.qui.util.b.f276941a;
            if (isDark) {
                b16 = value.a();
            } else {
                b16 = value.b();
            }
            linkedHashMap.put(str, bVar.e(b16));
        }
        return linkedHashMap;
    }
}
