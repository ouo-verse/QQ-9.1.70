package com.tencent.mobileqq.troop.flame.detail.view;

import android.graphics.Typeface;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.l;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J \u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J \u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J \u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R,\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012R,\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0012R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0012R,\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0012R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/detail/view/b;", "", "", "level", "number", "", "needShowNumber", "", "a", "c", "b", "d", "Landroid/widget/TextView;", "tv", "", "f", "e", "", "Ljava/util/Map;", "FLAME_VIEW_BG_URL_MAP", "FLAME_VIEW_BG_URL_MAP_WITHOUT_NUMBER", "FLAME_VIEW_PAG_URL_MAP", "FLAME_VIEW_PAG_URL_MAP_WITHOUT_NUMBER", "FLAME_VIEW_LOTTIE_URL_MAP", "g", "FLAME_VIEW_LOTTIE_URL_MAP_WITHOUT_NUMBER", "", "", h.F, "Ljava/util/List;", "FLAME_VIEW_WIDTH_DP", "Landroid/graphics/Typeface;", "i", "Landroid/graphics/Typeface;", TextComponent.SpanStyle.TYPEFACE, "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f296107a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Map<Integer, String>> FLAME_VIEW_BG_URL_MAP;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, String> FLAME_VIEW_BG_URL_MAP_WITHOUT_NUMBER;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Map<Integer, String>> FLAME_VIEW_PAG_URL_MAP;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, String> FLAME_VIEW_PAG_URL_MAP_WITHOUT_NUMBER;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Map<Integer, String>> FLAME_VIEW_LOTTIE_URL_MAP;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, String> FLAME_VIEW_LOTTIE_URL_MAP_WITHOUT_NUMBER;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Float> FLAME_VIEW_WIDTH_DP;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Typeface typeface;

    static {
        Map mutableMapOf;
        Map mutableMapOf2;
        Map mutableMapOf3;
        Map<Integer, Map<Integer, String>> mutableMapOf4;
        Map<Integer, String> mutableMapOf5;
        Map mutableMapOf6;
        Map mutableMapOf7;
        Map mutableMapOf8;
        Map<Integer, Map<Integer, String>> mutableMapOf9;
        Map<Integer, String> mutableMapOf10;
        Map mutableMapOf11;
        Map mutableMapOf12;
        Map mutableMapOf13;
        Map<Integer, Map<Integer, String>> mutableMapOf14;
        Map<Integer, String> mutableMapOf15;
        List<Float> listOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36267);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f296107a = new b();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(1, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_tag_v1_1.png"), TuplesKt.to(2, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_tag_v1_2.png"), TuplesKt.to(3, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_tag_v1_3.png"), TuplesKt.to(4, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_tag_v1_4.png"));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(1, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_tag_v2_1.png"), TuplesKt.to(2, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_tag_v2_2.png"), TuplesKt.to(3, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_tag_v2_3.png"), TuplesKt.to(4, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_tag_v2_4.png"));
        mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(1, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_tag_v3_1.png"), TuplesKt.to(2, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_tag_v3_2.png"), TuplesKt.to(3, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_tag_v3_3.png"), TuplesKt.to(4, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_tag_v3_4.png"));
        mutableMapOf4 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(1, mutableMapOf), TuplesKt.to(2, mutableMapOf2), TuplesKt.to(3, mutableMapOf3));
        FLAME_VIEW_BG_URL_MAP = mutableMapOf4;
        mutableMapOf5 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(1, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_icon_v1.png"), TuplesKt.to(2, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_icon_v2.png"), TuplesKt.to(3, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_icon_v3.png"), TuplesKt.to(999, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_icon_out.png"));
        FLAME_VIEW_BG_URL_MAP_WITHOUT_NUMBER = mutableMapOf5;
        mutableMapOf6 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(1, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/tag/qecommerce_group_flame_tag_v1_1.pag"), TuplesKt.to(2, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/tag/qecommerce_group_flame_tag_v1_2.pag"), TuplesKt.to(3, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/tag/qecommerce_group_flame_tag_v1_3.pag"), TuplesKt.to(4, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/tag/qecommerce_group_flame_tag_v1_4.pag"));
        mutableMapOf7 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(1, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/tag/qecommerce_group_flame_tag_v2_1.pag"), TuplesKt.to(2, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/tag/qecommerce_group_flame_tag_v2_2.pag"), TuplesKt.to(3, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/tag/qecommerce_group_flame_tag_v2_3.pag"), TuplesKt.to(4, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/tag/qecommerce_group_flame_tag_v2_4.pag"));
        mutableMapOf8 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(1, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/tag/qecommerce_group_flame_tag_v3_1.pag"), TuplesKt.to(2, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/tag/qecommerce_group_flame_tag_v3_2.pag"), TuplesKt.to(3, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/tag/qecommerce_group_flame_tag_v3_3.pag"), TuplesKt.to(4, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/tag/qecommerce_group_flame_tag_v3_4.pag"));
        mutableMapOf9 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(1, mutableMapOf6), TuplesKt.to(2, mutableMapOf7), TuplesKt.to(3, mutableMapOf8));
        FLAME_VIEW_PAG_URL_MAP = mutableMapOf9;
        mutableMapOf10 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(1, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_icon_v1.pag"), TuplesKt.to(2, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_icon_v2.pag"), TuplesKt.to(3, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_icon_v3.pag"), TuplesKt.to(999, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_icon_out.pag"));
        FLAME_VIEW_PAG_URL_MAP_WITHOUT_NUMBER = mutableMapOf10;
        mutableMapOf11 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(1, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/tag/qecommerce_group_flame_tag_v1_1.json"), TuplesKt.to(2, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/tag/qecommerce_group_flame_tag_v1_2.json"), TuplesKt.to(3, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/tag/qecommerce_group_flame_tag_v1_3.json"), TuplesKt.to(4, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/tag/qecommerce_group_flame_tag_v1_4.json"));
        mutableMapOf12 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(1, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/tag/qecommerce_group_flame_tag_v2_1.json"), TuplesKt.to(2, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/tag/qecommerce_group_flame_tag_v2_2.json"), TuplesKt.to(3, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/tag/qecommerce_group_flame_tag_v2_3.json"), TuplesKt.to(4, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/tag/qecommerce_group_flame_tag_v2_4.json"));
        mutableMapOf13 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(1, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/tag/qecommerce_group_flame_tag_v3_1.json"), TuplesKt.to(2, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/tag/qecommerce_group_flame_tag_v3_2.json"), TuplesKt.to(3, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/tag/qecommerce_group_flame_tag_v3_3.json"), TuplesKt.to(4, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/tag/qecommerce_group_flame_tag_v3_4.json"));
        mutableMapOf14 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(1, mutableMapOf11), TuplesKt.to(2, mutableMapOf12), TuplesKt.to(3, mutableMapOf13));
        FLAME_VIEW_LOTTIE_URL_MAP = mutableMapOf14;
        mutableMapOf15 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(1, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/qecommerce_group_flame_icon_v1.json"), TuplesKt.to(2, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/qecommerce_group_flame_icon_v2.json"), TuplesKt.to(3, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/qecommerce_group_flame_icon_v3.json"), TuplesKt.to(999, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/qecommerce_group_flame_icon_out.json"));
        FLAME_VIEW_LOTTIE_URL_MAP_WITHOUT_NUMBER = mutableMapOf15;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(30.48f), Float.valueOf(33.52f), Float.valueOf(38.1f), Float.valueOf(42.67f)});
        FLAME_VIEW_WIDTH_DP = listOf;
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final String a(int level, int number, boolean needShowNumber) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(level), Integer.valueOf(number), Boolean.valueOf(needShowNumber));
        }
        int length = String.valueOf(number).length();
        if (level != 999 && needShowNumber) {
            Map<Integer, String> map = FLAME_VIEW_BG_URL_MAP.get(Integer.valueOf(level));
            if (map != null) {
                return map.get(Integer.valueOf(length));
            }
            return null;
        }
        return FLAME_VIEW_BG_URL_MAP_WITHOUT_NUMBER.get(Integer.valueOf(level));
    }

    @Nullable
    public final String b(int level, int number, boolean needShowNumber) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(level), Integer.valueOf(number), Boolean.valueOf(needShowNumber));
        }
        int length = String.valueOf(number).length();
        if (level != 999 && needShowNumber) {
            Map<Integer, String> map = FLAME_VIEW_LOTTIE_URL_MAP.get(Integer.valueOf(level));
            if (map != null) {
                return map.get(Integer.valueOf(length));
            }
            return null;
        }
        return FLAME_VIEW_LOTTIE_URL_MAP_WITHOUT_NUMBER.get(Integer.valueOf(level));
    }

    @Nullable
    public final String c(int level, int number, boolean needShowNumber) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(level), Integer.valueOf(number), Boolean.valueOf(needShowNumber));
        }
        int length = String.valueOf(number).length();
        if (level != 999 && needShowNumber) {
            Map<Integer, String> map = FLAME_VIEW_PAG_URL_MAP.get(Integer.valueOf(level));
            if (map != null) {
                return map.get(Integer.valueOf(length));
            }
            return null;
        }
        return FLAME_VIEW_PAG_URL_MAP_WITHOUT_NUMBER.get(Integer.valueOf(level));
    }

    public final int d(int level, int number, boolean needShowNumber) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(level), Integer.valueOf(number), Boolean.valueOf(needShowNumber))).intValue();
        }
        if (level != 999 && needShowNumber) {
            return ViewUtils.dip2px(FLAME_VIEW_WIDTH_DP.get(String.valueOf(e(number)).length() - 1).floatValue());
        }
        return l.b(16);
    }

    public final int e(int number) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, number)).intValue();
        }
        if (number > 9999) {
            return 9999;
        }
        return number;
    }

    public final void f(@NotNull TextView tv5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) tv5);
            return;
        }
        Intrinsics.checkNotNullParameter(tv5, "tv");
        try {
            if (typeface == null) {
                typeface = Typeface.createFromAsset(tv5.getContext().getAssets(), "fonts/DIN-NextLT-Pro-QQ.ttf");
            }
            if (typeface != tv5.getTypeface()) {
                tv5.setTypeface(typeface);
            }
        } catch (Exception e16) {
            QLog.e("TroopFlameViewHelper", 1, "setTypeFace wrong: " + e16);
            tv5.setTypeface(Typeface.DEFAULT_BOLD);
        }
    }
}
