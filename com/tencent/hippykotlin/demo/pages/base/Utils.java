package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.module.CalendarModule;
import com.tencent.hippykotlin.demo.pages.base.module.QQSearchModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.ShareModule;
import com.tencent.kuikly.core.base.BaseObject;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Utils extends BaseObject {
    public static final Utils INSTANCE = new Utils();

    public final BridgeModule bridgeModule(String str) {
        return (BridgeModule) c.f117352a.k(str).acquireModule("HRBridgeModule");
    }

    public final CacheModule cacheModule(String str) {
        if (str.length() == 0) {
            str = BridgeManager.f117344a.u();
        }
        return (CacheModule) c.f117352a.k(str).acquireModule("HRCacheModule");
    }

    public final CalendarModule calendarModule(String str) {
        return (CalendarModule) c.f117352a.k(str).acquireModule("CalendarModule");
    }

    public final BridgeModule currentBridgeModule() {
        return (BridgeModule) c.f117352a.k(BridgeManager.f117344a.u()).acquireModule("HRBridgeModule");
    }

    public final QQKuiklyPlatformApi currentQQKuiklyPlatformApi() {
        return (QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi");
    }

    public final void logToNative(String str) {
        bridgeModule(BridgeManager.f117344a.u()).log(str);
    }

    public final k notifyModule(String str) {
        if (str.length() == 0) {
            str = BridgeManager.f117344a.u();
        }
        return (k) c.f117352a.k(str).acquireModule("KRNotifyModule");
    }

    public final QQSearchModule qqSearchModule() {
        return (QQSearchModule) c.f117352a.k(BridgeManager.f117344a.u()).acquireModule("QQSearchModule");
    }

    public final ShareModule shareModule(String str) {
        return (ShareModule) c.f117352a.k(str).acquireModule("HRShareModule");
    }

    public final String formatCountNumber(int i3) {
        if (i3 == 0) {
            return "";
        }
        if (i3 < 10000) {
            return String.valueOf(i3);
        }
        if (10000 <= i3 && i3 < 1000000) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i3 / 10000);
            sb5.append('.');
            sb5.append((i3 / 1000) % 10);
            sb5.append('\u4e07');
            return sb5.toString();
        }
        if (1000000 <= i3 && i3 < 100000000) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(i3 / 10000);
            sb6.append('\u4e07');
            return sb6.toString();
        }
        StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('$');
        m3.append(i3 / 100000000);
        m3.append('\u4ebf');
        return m3.toString();
    }
}
