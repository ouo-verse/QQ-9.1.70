package com.tencent.luggage.wxa.sd;

import com.tencent.luggage.wxa.i8.e;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler;
import com.tencent.mm.plugin.appbrand.jsapi.xwebplugin.map.AppBrandMapPluginHandler;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements com.tencent.luggage.wxa.k8.c {

    /* renamed from: a, reason: collision with root package name */
    public static d f140283a;

    public static d b() {
        if (f140283a == null) {
            f140283a = new d();
        }
        return f140283a;
    }

    @Override // com.tencent.luggage.wxa.k8.c
    public com.tencent.luggage.wxa.k8.b f(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1367751899:
                if (str.equals("camera")) {
                    c16 = 0;
                    break;
                }
                break;
            case 107868:
                if (str.equals("map")) {
                    c16 = 1;
                    break;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    c16 = 2;
                    break;
                }
                break;
            case 1693182669:
                if (str.equals("liveplayer")) {
                    c16 = 3;
                    break;
                }
                break;
            case 1702014259:
                if (str.equals("livepusher")) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return new com.tencent.luggage.wxa.qh.a();
            case 1:
                return new AppBrandMapPluginHandler();
            case 2:
                e eVar = new e();
                eVar.a(new com.tencent.luggage.wxa.ai.c());
                return eVar;
            case 3:
                LivePlayerPluginHandler livePlayerPluginHandler = new LivePlayerPluginHandler();
                livePlayerPluginHandler.initPluginHandler(new com.tencent.luggage.wxa.uh.a());
                return livePlayerPluginHandler;
            case 4:
                LivePusherPluginHandler livePusherPluginHandler = new LivePusherPluginHandler();
                livePusherPluginHandler.initPluginHandler(new com.tencent.luggage.wxa.xh.a());
                return livePusherPluginHandler;
            default:
                return null;
        }
    }
}
