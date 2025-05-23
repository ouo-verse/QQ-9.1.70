package com.tencent.smtt.sdk.network;

import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;

/* compiled from: P */
/* loaded from: classes23.dex */
public class InterceptConfig {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f369442a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f369443b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f369444c = false;

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f369445d = {"http://111.30.132.147:8080", "http://119.29.29.29/d?dn=*", "http://14.17.33.103:8080", "http://14.17.41.197:18000", "http://61.172.204.175:18000", "http://android.bugly.qq.com/rqd/async", "http://appchannel.html5.qq.com/directdown?app=*", "http://cfg.imtt.qq.com/tbs?v=2&mk=*", "http://cfg.sparta.html5.qq.com/miniqb?v=2&mk=*", "http://connect.rom.miui.com/generate_204", "http://dev.jsapi.qq.com/get?api=*", "http://dev.open.html5.qq.com", "http://dnet.mb.qq.com/rsp204", "http://fbtest.sparta.html5.qq.com/mobilefb", "http://game.html5.qq.com/h5Detail.html?gameId=*", "http://info.3g.qq.com", "http://jrlt.beacon.qq.com/analytics/upload", "http://jsapi.qq.com/get?api=*", "http://jsonproxy.cs0309.imtt.qq.com", "http://log.tbs.qq.com/ajax?c=*", "http://lstest.map.qq.com/stat*", "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=*", "http://mdc.html5.qq.com/mh?channel_id=50079&u=*", "http://mdc.icom.tencent.tbs.common.MTT.qq.com/skin/skinjson", "http://mini.html5.qq.com/bubble/index/", "http://minibubble.cs0309.html5.qq.com/bubble/index", "http://mqqad.html5.qq.com/*", "http://oth.eve.mdt.qq.com:8080/analytics/upload", "http://oth.str.mdt.qq.com:8080/analytics/upload", "http://pms.mb.qq.com/rsp204", "http://recmd.html5.qq.com/node/ajax?action=getadnew", "http://res.imtt.qq.com/*", "http://rqd.uu.qq.com/rqd/sync", "http://skin.cs0309.icom.tencent.tbs.common.MTT.qq.com/skin/skinjson", "http://soft.tbs.imtt.qq.com/17421/tbs_res_imtt_tbs_DebugPlugin_DebugPlugin.tbs", "http://tesly.qq.com/tesly/bug/sdk/upload", "http://tools.3g.qq.com/j/llqhz", "http://tr.cs0309.imtt.qq.com/ajax?c=dl&k=*", "http://ue.indoorloc.map.qq.com", "http://v.html5.qq.com*", "http://vp.html5.qq.com/#p=preco&param=*", "http://wap.eqxiu.com/mall.html?s=101#/index", "http://wup.imtt.qq.com:8080", "http://wupsocket.html5.qq.com", "http://yeyou.cs0309.imtt.qq.com/?ch=003503&qbid=*", "http://yeyou.qq.com/?ch=003503&qbid=*", "http://zixun.html5.qq.com/taglist/exploreList?url=*", "http://zxcv.3g.qq.com/sdk/beacon.jsp?type=real&size=*", "https://appchannel.html5.qq.com/directdown?app=*", "https://cfg.imtt.qq.com/*", "https://dev.jsapi.qq.com/get?*", "https://jsapi.qq.com/get?*", "https://lbs.map.qq.com/loc?*", "https://log.tbs.qq.com/ajax?c=*", "https://mdc.html5.qq.com/d/directdown.jsp*", "https://open.html5.qq.com", "https://qprostat.imtt.qq.com*", "https://res.imtt.qq.com/*", "https://mqb.translator.qq.com/translate", "https://cfg.imtt.qq.com/tbs?v=2&mk=*", "https://tbsrecovery.imtt.qq.com/getconfig", "https://tbs.imtt.qq.com/plugin/DebugPlugin_v2.tbs"};

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f369446e = {".mp4", DefaultHlsExtractorFactory.MP3_FILE_EXTENSION, ".ogg"};

    InterceptConfig() {
    }

    public static String[] getExcludeInterceptURLPostfix() {
        return f369446e;
    }

    public static boolean getInterceptAllForTest() {
        return f369442a;
    }

    public static String[] getInterceptURL() {
        return f369445d;
    }

    public static boolean getPrintImplicitInterceptInfoForTest() {
        return f369443b;
    }

    public static boolean getPrintInterceptExceptionStackTrace() {
        return f369444c;
    }

    public static void setInterceptAllForTest(boolean z16) {
        f369442a = z16;
    }

    public static void setPrintImplicitInterceptInfoForTest(boolean z16) {
        f369443b = z16;
    }

    public static void setPrintInterceptExceptionStackTrace(boolean z16) {
        f369444c = z16;
    }
}
