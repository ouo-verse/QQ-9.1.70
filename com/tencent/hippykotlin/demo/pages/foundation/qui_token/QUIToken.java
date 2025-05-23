package com.tencent.hippykotlin.demo.pages.foundation.qui_token;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.QQComposeViewExtCreator$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQCommonNApiModule;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.pager.g;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUIToken {
    public static final QUIToken INSTANCE = new QUIToken();
    public static int colorUniqueID;
    public static Boolean lastNightMode;

    public static h color$default(String str) {
        h hVar;
        g pageData;
        e n3;
        QUIToken qUIToken = INSTANCE;
        String trimToken = qUIToken.trimToken(str);
        b g16 = c.f117352a.g();
        Pager pager = g16 instanceof Pager ? (Pager) g16 : null;
        if (((pager == null || (pageData = pager.getPageData()) == null || (n3 = pageData.n()) == null || n3.j("isClearBgColor") != 1) ? false : true) && (Intrinsics.areEqual(str, "bg_bottom_standard") || Intrinsics.areEqual(str, "bg_nav_secondary"))) {
            return h.INSTANCE.j();
        }
        QUITokenThemeMode quiTokenThemeMode = pager != null ? QUITokenKt.quiTokenThemeMode(pager) : null;
        if (quiTokenThemeMode != null) {
            int ordinal = quiTokenThemeMode.ordinal();
            if (ordinal != 1) {
                if (ordinal == 2) {
                    StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("qui_color://", trimToken, "?color_unique_id=");
                    m3.append(colorUniqueID);
                    m3.append("&default_theme=1");
                    hVar = new h(m3.toString());
                } else if (ordinal == 3) {
                    StringBuilder m16 = CacheDiskLru$$ExternalSyntheticOutline0.m("qui_color://", trimToken, "?color_unique_id=");
                    m16.append(colorUniqueID);
                    m16.append("&night_theme=1");
                    hVar = new h(m16.toString());
                }
            } else if (qUIToken.isNightMode()) {
                StringBuilder m17 = CacheDiskLru$$ExternalSyntheticOutline0.m("qui_color://", trimToken, "?color_unique_id=");
                m17.append(colorUniqueID);
                m17.append("&night_theme=1");
                hVar = new h(m17.toString());
            } else {
                StringBuilder m18 = CacheDiskLru$$ExternalSyntheticOutline0.m("qui_color://", trimToken, "?color_unique_id=");
                m18.append(colorUniqueID);
                m18.append("&default_theme=1");
                hVar = new h(m18.toString());
            }
            return hVar;
        }
        if (qUIToken.isNightMode()) {
            StringBuilder m19 = CacheDiskLru$$ExternalSyntheticOutline0.m("qui_color://", trimToken, "?color_unique_id=");
            m19.append(colorUniqueID);
            hVar = new h(m19.toString());
        } else {
            StringBuilder m26 = CacheDiskLru$$ExternalSyntheticOutline0.m("qui_color://", trimToken, "?color_unique_id=");
            m26.append(colorUniqueID);
            hVar = new h(m26.toString());
        }
        return hVar;
    }

    public final String image(String str, h hVar) {
        String str2;
        boolean startsWith$default;
        List split$default;
        Object first;
        String m3 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m("qui_image://", trimToken(str));
        if (hVar != null) {
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("&color=");
            String hVar2 = hVar.toString();
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(hVar2, "qui_color://", false, 2, null);
            if (startsWith$default) {
                String substring = hVar2.substring(12);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                split$default = StringsKt__StringsKt.split$default((CharSequence) substring, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) split$default);
                String str3 = (String) first;
                b g16 = c.f117352a.g();
                Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.kuikly.core.pager.Pager");
                hVar2 = ((Pager) g16).getPageData().n().k("buildVersion", 0) >= 3 ? QQComposeViewExtCreator$$ExternalSyntheticOutline0.m(str3, "c_prefix:", hVar2) : str3;
            }
            m16.append(hVar2);
            str2 = m16.toString();
        } else {
            str2 = "";
        }
        if (isNightMode()) {
            StringBuilder m17 = HotViewKt$$ExternalSyntheticOutline0.m(m3, "?color_unique_id=");
            m17.append(colorUniqueID);
            m17.append(str2);
            return m17.toString();
        }
        StringBuilder m18 = HotViewKt$$ExternalSyntheticOutline0.m(m3, "?color_unique_id=");
        m18.append(colorUniqueID);
        m18.append(str2);
        return m18.toString();
    }

    public final boolean isDarkMode() {
        QQCommonNApiModule.Companion companion = QQCommonNApiModule.Companion;
        return ((QQCommonNApiModule) c.f117352a.g().acquireModule("QQCommonNApiModule")).isDarkTheme();
    }

    public final boolean isNightMode() {
        boolean isNightMode = c.f117352a.g().isNightMode();
        if (!Intrinsics.areEqual(Boolean.valueOf(isNightMode), lastNightMode)) {
            lastNightMode = Boolean.valueOf(isNightMode);
            colorUniqueID++;
        }
        return isNightMode;
    }

    public final String trimToken(String str) {
        boolean startsWith$default;
        boolean startsWith$default2;
        String str2;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "qui_common_", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str, "qui_", false, 2, null);
            if (startsWith$default2) {
                str2 = str.substring(4);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).substring(startIndex)");
            } else {
                str2 = str;
            }
        } else {
            str2 = str.substring(11);
            Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).substring(startIndex)");
        }
        return (Intrinsics.areEqual(str, "token_bg") && com.tencent.kuikly.core.pager.h.a().getPageData().getIsIOS()) ? "common_bg" : str2;
    }
}
