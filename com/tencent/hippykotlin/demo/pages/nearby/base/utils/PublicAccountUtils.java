package com.tencent.hippykotlin.demo.pages.nearby.base.utils;

import com.tencent.component.media.image.ProgressTracer;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.PublicAccountConfig;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes31.dex */
public final class PublicAccountUtils {
    public static final PublicAccountUtils INSTANCE = new PublicAccountUtils();
    public static Map<Integer, PublicAccountConfig> configs = new LinkedHashMap();

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, com.tencent.hippykotlin.demo.pages.nearby.base.utils.PublicAccountConfig>] */
    public final PublicAccountConfig getConfig(int i3) {
        e m3;
        Map<String, Object> x16;
        PublicAccountConfig publicAccountConfig = (PublicAccountConfig) configs.get(Integer.valueOf(i3));
        if (publicAccountConfig != null) {
            return publicAccountConfig;
        }
        PublicAccountConfig.Companion companion = PublicAccountConfig.Companion;
        String stringFromQQCommonConfig = QQNearbyModule.Companion.getInstance().getStringFromQQCommonConfig("103255", "{}");
        KLog.INSTANCE.i("PublicAccountConfig", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("loaded ", i3, ProgressTracer.SEPARATOR, stringFromQQCommonConfig));
        PublicAccountConfig publicAccountConfig2 = null;
        try {
            e eVar = new e(stringFromQQCommonConfig);
            String str = PublicAccountConfig.appIdToConfigKey.get(Integer.valueOf(i3));
            if (str != null && (m3 = eVar.m(str)) != null) {
                String p16 = m3.p("uin");
                String p17 = m3.p("name");
                e m16 = m3.m("follow_modal");
                if (m16 != null) {
                    PublicAccountConfig.FollowModalConfig followModalConfig = new PublicAccountConfig.FollowModalConfig(m16.g("enable", false), m16.p("title"), m16.p("poster_url"), m16.n("show_interval_s"));
                    e m17 = m3.m("follow_bar");
                    if (m17 != null) {
                        boolean g16 = m17.g("enable", false);
                        e m18 = m17.m("show_interval_s");
                        if (m18 != null && (x16 = m18.x()) != null) {
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            for (Map.Entry<String, Object> entry : x16.entrySet()) {
                                linkedHashMap.put(Integer.valueOf(Integer.parseInt(entry.getKey())), Integer.valueOf(Integer.parseInt(entry.getValue().toString())));
                            }
                            publicAccountConfig2 = new PublicAccountConfig(i3, p16, p17, followModalConfig, new PublicAccountConfig.FollowBarConfig(g16, linkedHashMap));
                        }
                    }
                }
            }
        } catch (Exception e16) {
            KLog.INSTANCE.e("PublicAccountConfig", "load failed " + e16);
        }
        if (publicAccountConfig2 != null) {
            configs.put(Integer.valueOf(i3), publicAccountConfig2);
        }
        return publicAccountConfig2;
    }

    public final boolean isFollowed(int i3) {
        String str;
        PublicAccountConfig config = getConfig(i3);
        if (config == null || (str = config.uin) == null) {
            return false;
        }
        return QQNearbyModule.Companion.getInstance().isFollowedPublicAccount(str);
    }
}
