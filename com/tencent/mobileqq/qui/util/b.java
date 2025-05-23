package com.tencent.mobileqq.qui.util;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.graphics.ColorUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0007J\u001e\u0010\u0007\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0007J\u001e\u0010\b\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR,\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00120\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0013R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qui/util/b;", "", "", "", "colorMap", "", "b", "c", "a", "msg", "d", "", "color", "e", "", "Ljava/util/List;", "sNeedAddPressedToken", "sNeedAddSelectorToken", "Landroid/util/Pair;", "Ljava/util/Map;", "sExtraToken", "sButtonTextToken", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f276941a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> sNeedAddPressedToken;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> sNeedAddSelectorToken;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Pair<String, String>> sExtraToken;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> sButtonTextToken;

    static {
        List<String> listOf;
        List<String> listOf2;
        Map<String, Pair<String, String>> mutableMapOf;
        List<String> listOf3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37123);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f276941a = new b();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qui_common_text_nav_primary.xml", "qui_common_text_nav_secondary.xml", "qui_common_text_primary.xml", "qui_common_text_primary_light.xml", "qui_common_text_secondary.xml", "qui_common_text_tertiary.xml", "qui_common_text_link.xml", "qui_common_icon_nav_primary.xml"});
        sNeedAddPressedToken = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qui_common_text_primary.xml", "qui_common_text_primary_light.xml", "qui_common_text_secondary.xml", "qui_common_text_tertiary.xml", "qui_common_text_link.xml", "qui_common_text_nav_primary.xml", "qui_common_text_nav_secondary.xml"});
        sNeedAddSelectorToken = listOf2;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("qui_common_bg_top_light_pressed.xml", new Pair("qui_common_bg_top_light.xml", "qui_common_overlay_standard_primary.xml")), TuplesKt.to("qui_common_fill_light_secondary_pressed.xml", new Pair("qui_common_fill_light_secondary.xml", "qui_common_overlay_standard_primary.xml")), TuplesKt.to("qui_common_fill_light_primary_stick.xml", new Pair("qui_common_fill_light_primary.xml", "qui_common_overlay_light.xml")), TuplesKt.to("qui_common_fill_light_primary_pressed.xml", new Pair("qui_common_fill_light_primary.xml", "qui_common_overlay_standard_primary.xml")));
        sExtraToken = mutableMapOf;
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qui_button_text_primary.xml", "qui_button_text_secondary.xml", "qui_button_text_error.xml", "qui_button_text_ghost.xml"});
        sButtonTextToken = listOf3;
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@Nullable Map<String, String> colorMap) {
        String replace$default;
        String replace$default2;
        String replace$default3;
        if (colorMap == null) {
            return;
        }
        for (String str : sButtonTextToken) {
            replace$default = StringsKt__StringsJVMKt.replace$default(str, ".xml", "_default.xml", false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(str, ".xml", "_pressed.xml", false, 4, (Object) null);
            replace$default3 = StringsKt__StringsJVMKt.replace$default(str, ".xml", "_disable.xml", false, 4, (Object) null);
            if (colorMap.containsKey(replace$default) && colorMap.containsKey(replace$default2) && colorMap.containsKey(replace$default3)) {
                String str2 = colorMap.get(replace$default2) + ',' + colorMap.get(replace$default2) + ',' + colorMap.get(replace$default3) + ',' + colorMap.get(replace$default);
                if (!TextUtils.isEmpty(str2)) {
                    colorMap.put(str, str2);
                    f276941a.d("addButtonTextToken, targetToken=" + str);
                }
            }
        }
    }

    @JvmStatic
    public static final void b(@Nullable Map<String, String> colorMap) {
        if (colorMap == null) {
            return;
        }
        for (Map.Entry<String, Pair<String, String>> entry : sExtraToken.entrySet()) {
            String key = entry.getKey();
            Pair<String, String> value = entry.getValue();
            String str = (String) value.first;
            String str2 = (String) value.second;
            if (colorMap.containsKey(str) && colorMap.containsKey(str2)) {
                int a16 = com.tencent.biz.qui.quicommon.a.a(Color.parseColor(colorMap.get(str)), Color.parseColor(colorMap.get(str2)));
                b bVar = f276941a;
                colorMap.put(key, bVar.e(a16));
                bVar.d("addExtraColor, targetColorToken=" + key + ", newColor=" + bVar.e(a16));
            }
        }
    }

    @JvmStatic
    public static final void c(@Nullable Map<String, String> colorMap) {
        String replace$default;
        String str;
        String replace$default2;
        if (colorMap == null) {
            return;
        }
        for (String str2 : sNeedAddPressedToken) {
            if (colorMap.containsKey(str2)) {
                int parseColor = Color.parseColor(colorMap.get(str2));
                replace$default2 = StringsKt__StringsJVMKt.replace$default(str2, ".xml", "_pressed.xml", false, 4, (Object) null);
                b bVar = f276941a;
                colorMap.put(replace$default2, bVar.e(ColorUtils.setAlphaComponent(parseColor, 128)));
                bVar.d("AddPressedToken, targetColorToken=" + replace$default2);
            }
        }
        for (String str3 : sNeedAddSelectorToken) {
            if (colorMap.containsKey(str3)) {
                String str4 = colorMap.get(str3);
                int parseColor2 = Color.parseColor(str4);
                replace$default = StringsKt__StringsJVMKt.replace$default(str3, ".xml", "_selector.xml", false, 4, (Object) null);
                b bVar2 = f276941a;
                String e16 = bVar2.e(ColorUtils.setAlphaComponent(parseColor2, 128));
                if (Intrinsics.areEqual("qui_common_text_link.xml", str3)) {
                    str = bVar2.e(ColorUtils.setAlphaComponent(parseColor2, 77)) + ',' + e16 + ',' + str4;
                } else {
                    str = e16 + ',' + str4;
                }
                if (!TextUtils.isEmpty(str)) {
                    colorMap.put(replace$default, str);
                    bVar2.d("AddSelectorToken, targetToken=" + replace$default);
                }
            }
        }
    }

    private final void d(String msg2) {
        if (QLog.isDevelopLevel()) {
            QLog.i("QUITokenMapUtil", 1, msg2);
        }
    }

    @NotNull
    public final String e(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, color);
        }
        StringBuilder sb5 = new StringBuilder();
        String hexString = Integer.toHexString(Color.alpha(color));
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(Color.alpha(color))");
        String hexString2 = Integer.toHexString(Color.red(color));
        Intrinsics.checkNotNullExpressionValue(hexString2, "toHexString(Color.red(color))");
        String hexString3 = Integer.toHexString(Color.green(color));
        Intrinsics.checkNotNullExpressionValue(hexString3, "toHexString(Color.green(color))");
        String hexString4 = Integer.toHexString(Color.blue(color));
        Intrinsics.checkNotNullExpressionValue(hexString4, "toHexString(Color.blue(color))");
        if (hexString.length() == 1) {
            hexString = '0' + hexString;
        }
        if (hexString2.length() == 1) {
            hexString2 = '0' + hexString2;
        }
        if (hexString3.length() == 1) {
            hexString3 = '0' + hexString3;
        }
        if (hexString4.length() == 1) {
            hexString4 = '0' + hexString4;
        }
        sb5.append("#");
        if (!Intrinsics.areEqual(hexString, "FF")) {
            sb5.append(hexString);
        }
        sb5.append(hexString2);
        sb5.append(hexString3);
        sb5.append(hexString4);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }
}
