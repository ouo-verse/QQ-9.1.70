package com.tencent.comic.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.comic.api.plugin.c;
import com.tencent.comic.jsp.d;
import com.tencent.mobileqq.hitrate.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Observer;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes5.dex */
public interface IQQComicPluginUtil extends QRouteApi {
    public static final String ACTION_PLUGIN_STARTUP_FAILED = "com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED";
    public static final int BUZID_COMIC = 1;
    public static final String COMIC_PLUGIN_ID = "comic_plugin.apk";
    public static final int OP_RECEIVE = 2;
    public static final int OP_SEND = 1;
    public static final String PLUGIN_LAUNCH_ACTION = "launch_plugin_action";
    public static final int PLUGIN_LAUNCH_DONE = 202;
    public static final int PLUGIN_LAUNCH_START = 201;
    public static final int PLUGIN_TYPE_QQCOMIC = 2;
    public static final int PLUGIN_TYPE_QQREADER = 1;
    public static final String PPP_EXT1 = "ext1";
    public static final String PPP_MEM_LIMIT = "mem_limit";
    public static final String PPP_PRELOAD = "preload";
    public static final String PPP_PRELOAD_DATA = "preload_data";
    public static final String PPP_PRELOAD_SWITCH = "preload_switch";
    public static final String PPP_PROFILE = "ppp_profile";
    public static final int PRELOAD_ENTRY_LEBA = 6;
    public static final int PRELOAD_ENTRY_PUBLIC_ACCOUNT = 5;
    public static final int PRELOAD_ENTRY_WEB = 9999;
    public static final int STRATEGY_TYPE_COMMON = 3;
    public static final int STRATEGY_TYPE_LOCAL = 1;
    public static final int STRATEGY_TYPE_SERVER = 2;
    public static final int STRATEGY_TYPE_UNDEF = 0;

    /* loaded from: classes5.dex */
    public static class a {
        static IPatchRedirector $redirector_;
    }

    boolean launchPlugin(Activity activity, Intent intent, String str, b bVar);

    void loadComicModule(Context context);

    void notifyChangedWhenRuntimeCreated();

    boolean preloadPubilcProcess(c cVar, String str, AppRuntime appRuntime, String str2, int i3, long j3, int[] iArr, a aVar);

    void reportHitRate(int i3, int i16, int i17, int i18, String str, String str2);

    void reportPreload(AppRuntime appRuntime, int i3, int i16, long j3);

    void reportProcBeKiiled(AppRuntime appRuntime, int i3, int i16, int i17, long j3);

    void setDownloadObserver(com.tencent.comic.jsp.b bVar);

    void setFirstInObserver(Observer observer);

    void setJsPluginBuilder(d dVar);

    void setPluginReady(boolean z16);
}
