package com.tencent.hippykotlin.demo.pages.base.ktx;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ISkinColor;
import com.tencent.hippykotlin.demo.pages.base.SkinColorImpl;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.base.module.CalendarModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.kuikly.core.base.p;
import com.tencent.kuikly.core.base.r;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class IPagerIdKtxKt {
    public static final r notifyModule$delegate;
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {IPagerIdKtxKt$$ExternalSyntheticOutline0.m(IPagerIdKtxKt.class, "skinColor", "getSkinColor(Lcom/tencent/kuikly/core/base/IPagerId;)Lcom/tencent/hippykotlin/demo/pages/base/ISkinColor;", 1), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(IPagerIdKtxKt.class, "bridgeModule", "getBridgeModule(Lcom/tencent/kuikly/core/base/IPagerId;)Lcom/tencent/hippykotlin/demo/pages/base/BridgeModule;", 1), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(IPagerIdKtxKt.class, "calendarModule", "getCalendarModule(Lcom/tencent/kuikly/core/base/IPagerId;)Lcom/tencent/hippykotlin/demo/pages/base/module/CalendarModule;", 1), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(IPagerIdKtxKt.class, "cacheModule", "getCacheModule(Lcom/tencent/kuikly/core/base/IPagerId;)Lcom/tencent/hippykotlin/demo/pages/foundation/module/CacheModule;", 1), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(IPagerIdKtxKt.class, "notifyModule", "getNotifyModule(Lcom/tencent/kuikly/core/base/IPagerId;)Lcom/tencent/kuikly/core/module/NotifyModule;", 1)};
    public static final r skinColor$delegate = new r(new Function1<String, SkinColorImpl>() { // from class: com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$skinColor$2
        @Override // kotlin.jvm.functions.Function1
        public final SkinColorImpl invoke(String str) {
            return new SkinColorImpl(str);
        }
    });
    public static final r bridgeModule$delegate = new r(new Function1<String, BridgeModule>() { // from class: com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$bridgeModule$2
        @Override // kotlin.jvm.functions.Function1
        public final BridgeModule invoke(String str) {
            return Utils.INSTANCE.bridgeModule(str);
        }
    });
    public static final r calendarModule$delegate = new r(new Function1<String, CalendarModule>() { // from class: com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$calendarModule$2
        @Override // kotlin.jvm.functions.Function1
        public final CalendarModule invoke(String str) {
            return Utils.INSTANCE.calendarModule(str);
        }
    });

    public static final void callbackResult(b bVar, e eVar) {
        long n3 = PageDataExtKt.getUserData(bVar.getPageData()).n("callbackId");
        if (n3 == 0) {
            Utils.INSTANCE.logToNative("this page has no callbackId");
        } else {
            k.d((k) bVar.acquireModule("KRNotifyModule"), String.valueOf(n3), eVar, false, 4, null);
        }
    }

    public static final BridgeModule getBridgeModule(p pVar) {
        return (BridgeModule) bridgeModule$delegate.getValue(pVar, $$delegatedProperties[1]);
    }

    public static final CalendarModule getCalendarModule(p pVar) {
        return (CalendarModule) calendarModule$delegate.getValue(pVar, $$delegatedProperties[2]);
    }

    public static final k getNotifyModule(p pVar) {
        return (k) notifyModule$delegate.getValue(pVar, $$delegatedProperties[4]);
    }

    public static final ISkinColor getSkinColor(p pVar) {
        return (ISkinColor) skinColor$delegate.getValue(pVar, $$delegatedProperties[0]);
    }

    static {
        new r(new Function1<String, CacheModule>() { // from class: com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$cacheModule$2
            @Override // kotlin.jvm.functions.Function1
            public final CacheModule invoke(String str) {
                return Utils.INSTANCE.cacheModule(str);
            }
        });
        notifyModule$delegate = new r(new Function1<String, k>() { // from class: com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$notifyModule$2
            @Override // kotlin.jvm.functions.Function1
            public final k invoke(String str) {
                return Utils.INSTANCE.notifyModule(str);
            }
        });
    }

    public static void openPageForResult$default(b bVar, String str, e eVar, Function1 function1, int i3) {
        e eVar2 = (i3 & 4) != 0 ? new e() : eVar;
        Function1 function12 = (i3 & 8) != 0 ? null : function1;
        BridgeModule bridgeModule = (BridgeModule) bVar.acquireModule("HRBridgeModule");
        k kVar = (k) bVar.acquireModule("KRNotifyModule");
        if (function12 == null) {
            BridgeModule.openPage$default(bridgeModule, str, false, null, null, 28);
            return;
        }
        long currentTimeStamp = bridgeModule.currentTimeStamp();
        eVar2.u("callbackId", currentTimeStamp);
        BridgeModule.openPage$default(bridgeModule, str, false, eVar2, null, 24);
        k.b(kVar, String.valueOf(currentTimeStamp), false, function12, 2, null);
    }
}
