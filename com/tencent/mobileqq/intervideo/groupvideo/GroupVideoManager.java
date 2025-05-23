package com.tencent.mobileqq.intervideo.groupvideo;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import com.google.gson.JsonObject;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.av.utils.s;
import com.tencent.intervideo.nowproxy.InitData;
import com.tencent.intervideo.nowproxy.NowEntryData;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.QQKandianInterface;
import com.tencent.intervideo.nowproxy.WebCallHandler;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedChannel;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDns;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDownloader;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLoading;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLog;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedRecord;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedReport;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedWebView;
import com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback;
import com.tencent.intervideo.nowproxy.qqshare.CustomizedShareForQQ;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.GVideoHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.app.cj;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Content;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.intervideo.IPluginEnterManager;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl;
import com.tencent.mobileqq.intervideo.od.ODLoadingActivity;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.a;
import com.tencent.mobileqq.qroute.module.d;
import com.tencent.mobileqq.troop.utils.bh;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportKey;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mtt.hippy.views.hippypager.HippyPagerPageChangeListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.CommonCallback;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import cooperation.plugin.patch.PatchReporter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GroupVideoManager implements Manager, com.tencent.mobileqq.intervideo.yiqikan.a, com.tencent.mobileqq.intervideo.groupvideo.h {

    /* renamed from: m, reason: collision with root package name */
    private static final Map<String, Long> f238162m = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private Handler f238163d = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    private QQProgressDialog f238164e;

    /* renamed from: f, reason: collision with root package name */
    private int f238165f;

    /* renamed from: h, reason: collision with root package name */
    private final com.tencent.mobileqq.intervideo.groupvideo.a f238166h;

    /* renamed from: i, reason: collision with root package name */
    private INetEventHandler f238167i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements com.tencent.mobileqq.intervideo.groupvideo.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f238169a;

        a(QQAppInterface qQAppInterface) {
            this.f238169a = qQAppInterface;
        }

        @Override // com.tencent.mobileqq.intervideo.groupvideo.b
        public void a(List<com.tencent.mobileqq.intervideo.groupvideo.j> list) {
            HashMap hashMap = new HashMap(this.f238169a.getAVNotifyCenter().f73769o);
            cj gAudioHandler = this.f238169a.getGAudioHandler();
            for (com.tencent.mobileqq.intervideo.groupvideo.j jVar : list) {
                int size = jVar.f238223f.size();
                long[] jArr = new long[size];
                for (int i3 = 0; i3 < size; i3++) {
                    jArr[i3] = jVar.f238223f.get(i3).longValue();
                }
                ((bh) this.f238169a.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER)).c(jVar.f238218a);
                gAudioHandler.r(1, String.valueOf(jVar.f238218a), jVar.f238219b, jArr, 14, jVar.f238221d, jVar.f238222e, jVar.f238224g);
                hashMap.remove(String.valueOf(jVar.f238218a));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                if (((Integer) entry.getValue()).intValue() == 14) {
                    gAudioHandler.r(1, (String) entry.getKey(), 0, null, 14, 0, 0, -1);
                }
            }
            MqqHandler handler = this.f238169a.getHandler(Conversation.class);
            if (handler != null) {
                handler.sendEmptyMessage(1009);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements INetEventHandler {
        b() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
        public void onNetChangeEvent(boolean z16) {
            QQAppInterface r16 = GroupVideoManager.this.r();
            if (r16 == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GroupVideoManager", 2, "onNetChangeEvent connect:" + z16 + " isMSFConnect:" + r16.isMSFConnect());
            }
            if (z16) {
                GroupVideoManager.this.y(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class c implements CustomizedChannel {
        c() {
        }

        @Override // com.tencent.intervideo.nowproxy.customized_interface.CustomizedChannel
        public void onSendTask(Bundle bundle, CommonCallback<Bundle> commonCallback) {
            PluginManagerInterfaceImpl.i().p(bundle, commonCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class d implements CustomizedDns {
        d() {
        }

        @Override // com.tencent.intervideo.nowproxy.customized_interface.CustomizedDns
        public String getip(String str) {
            return PluginManagerInterfaceImpl.i().o(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class e extends CustomizedDownloader {
        e() {
        }

        @Override // com.tencent.intervideo.nowproxy.customized_interface.CustomizedDownloader
        public void onDownload(boolean z16, String str, String str2, Bundle bundle, DownloadCallback downloadCallback) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("url", str);
            bundle2.putString("path", str2);
            PluginManagerInterfaceImpl.i().d(bundle2, downloadCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class g implements CustomizedLog {
        g() {
        }

        @Override // com.tencent.intervideo.nowproxy.customized_interface.CustomizedLog
        public void onLog(int i3, String str, String str2) {
            QLog.i(str, 1, str2);
        }

        @Override // com.tencent.intervideo.nowproxy.customized_interface.CustomizedLog
        public void onFlushLogs() {
        }

        @Override // com.tencent.intervideo.nowproxy.customized_interface.CustomizedLog
        public void onUploadLogs() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class h implements CustomizedRecord {
        h() {
        }

        @Override // com.tencent.intervideo.nowproxy.customized_interface.CustomizedRecord
        public void getRecordInfo(Bundle bundle, CommonCallback<Bundle> commonCallback) {
            PluginManagerInterfaceImpl.i().j(bundle, commonCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class j implements CustomizedShareForQQ {
        j() {
        }

        @Override // com.tencent.intervideo.nowproxy.qqshare.CustomizedShareForQQ
        public void shareToQQ(Bundle bundle) {
            PluginManagerInterfaceImpl.i().q(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class k implements CustomizedWebView {
        k() {
        }

        @Override // com.tencent.intervideo.nowproxy.customized_interface.CustomizedWebView
        public void onJumpWeb(String str, Bundle bundle, WebCallHandler webCallHandler) {
            PluginManagerInterfaceImpl.i().n(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class l implements QQKandianInterface {
        l() {
        }

        @Override // com.tencent.intervideo.nowproxy.QQKandianInterface
        public void jumpToKandianBiu(Bundle bundle) {
            PluginManagerInterfaceImpl.i().m(bundle);
        }
    }

    public GroupVideoManager(QQAppInterface qQAppInterface) {
        com.tencent.mobileqq.intervideo.groupvideo.a aVar = new com.tencent.mobileqq.intervideo.groupvideo.a();
        this.f238166h = aVar;
        this.f238167i = new b();
        AppNetConnInfo.registerNetChangeReceiver(qQAppInterface.getApp(), this.f238167i);
        t(qQAppInterface);
        PluginManagerInterfaceImpl.i().l(qQAppInterface);
        aVar.i(qQAppInterface);
    }

    private void n(Bundle bundle, com.tencent.mobileqq.intervideo.yiqikan.b bVar) {
        this.f238166h.j(bundle, bVar);
    }

    private void o() {
        QQProgressDialog qQProgressDialog = this.f238164e;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
            Context context = this.f238164e.getContext();
            if (context instanceof ContextWrapper) {
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (context instanceof JumpActivity) {
                ((Activity) context).finish();
            }
            this.f238164e = null;
        }
    }

    private void p(String str, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putInt("roomCodeType", 1);
        if (!StringUtil.isEmpty(str)) {
            bundle.putLong("roomid", Long.valueOf(str).longValue());
        }
        bundle.putBoolean("fullDownLoad", z16);
        bundle.putString("bizType", "GVideo");
        bundle.putString("plugin_id", "Od");
        bundle.putString("appid", "1104763709");
        QQAppInterface r16 = r();
        if (r16 != null) {
            bundle.putString("uin", r16.getCurrentUin());
        }
        bundle.putBoolean("preload", true);
        q(bundle);
    }

    private void q(final Bundle bundle) {
        String str;
        final com.tencent.mobileqq.qroute.module.a plugin = QRoute.plugin("GroupVideo.apk");
        if (!plugin.i()) {
            QLog.e("GroupVideoManager", 1, "doPreDownloadByQShadow, plugin not exist!!");
            return;
        }
        String lastBizType = ((IPluginEnterManager) QRoute.api(IPluginEnterManager.class)).getLastBizType();
        boolean isEmpty = TextUtils.isEmpty(lastBizType);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doPreDownloadByQShadow lastBizType:");
        sb5.append(lastBizType);
        sb5.append(", pps status is ");
        if (isEmpty) {
            str = HippyPagerPageChangeListener.IDLE;
        } else {
            str = "busy";
        }
        sb5.append(str);
        QLog.i("GroupVideoManager", 1, sb5.toString());
        if (isEmpty) {
            final Long valueOf = Long.valueOf(SystemClock.elapsedRealtime());
            ThreadManagerExecutor.getExecutorService(192).submit(new Runnable() { // from class: com.tencent.mobileqq.intervideo.groupvideo.e
                @Override // java.lang.Runnable
                public final void run() {
                    GroupVideoManager.w(bundle, valueOf, plugin);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQAppInterface r() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    private static int s(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("prefs_key_gvideo_entry_" + str, 0);
    }

    private void t(QQAppInterface qQAppInterface) {
        InitData initData = new InitData();
        initData.mAppID = "2";
        initData.mSourceVersion = String.valueOf(com.tencent.mobileqq.utils.f.a(BaseApplication.getContext()));
        initData.mSourceUid = qQAppInterface.getCurrentAccountUin();
        initData.mIsCpu64bit = true;
        NowLive.setShadowImp(new com.tencent.mobileqq.intervideo.now.dynamic.d());
        NowLive.start(BaseApplication.getContext(), initData);
        NowLive.setCustomizedLog(new g());
        NowLive.setCustomChannel(new c());
        NowLive.setCustomizedLoading(new f());
        NowLive.setCustomizeReport(new i());
        NowLive.setCustomizedDownloader(new e());
        NowLive.setCustomizedRecord(new h());
        NowLive.setCustomizedShareForQQ(new j());
        NowLive.setQQKandianInterface(new l());
        NowLive.setCustomizedWebView(new k());
        NowLive.setCustomizedDns(new d());
    }

    private synchronized boolean u(String str) {
        Map<String, Long> map = f238162m;
        if (map.get(str) == null) {
            map.put(str, 0L);
        }
        if (SystemClock.elapsedRealtime() - map.get(str).longValue() < 5000) {
            QLog.w("GroupVideoManager", 2, str + " time less than 5 minutes, return");
            return true;
        }
        map.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(Long l3, boolean z16) {
        QLog.i("GroupVideoManager", 1, "doPreDownloadByQShadow result:" + z16);
        PatchReporter.f390339a.c(SystemClock.elapsedRealtime() - l3.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(Bundle bundle, final Long l3, com.tencent.mobileqq.qroute.module.a aVar) {
        try {
            aVar.f(new d.b(BaseApplication.getContext()).g("GroupVideo-main").b("com.tencent.od.app.newloginprocess.LoginActivity").d(new Intent().putExtras(bundle).putExtras(new com.tencent.mobileqq.intervideo.od.a().a("Od", "1104763709", "qvideo.qq.com"))).e(new a.InterfaceC8440a() { // from class: com.tencent.mobileqq.intervideo.groupvideo.f
                @Override // com.tencent.mobileqq.qroute.module.a.InterfaceC8440a
                public final void a(boolean z16) {
                    GroupVideoManager.v(l3, z16);
                }
            }).a());
        } catch (Exception e16) {
            QLog.e("GroupVideoManager", 1, "doPreDownloadByQShadow error:" + e16.getMessage());
        }
    }

    private void x(Context context, String str, String str2, String str3, String str4, int i3, String str5, Bundle bundle) {
        if (u(VRReportDefine$ReportKey.INSTALL)) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) HuayangLoadbackgroudActivity.class);
        intent.putExtra("isPreload", true);
        intent.setFlags(268435456);
        context.startActivity(intent);
        boolean z16 = context instanceof Activity;
        if (z16) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
        Intent intent2 = new Intent(context, (Class<?>) ODLoadingActivity.class);
        intent2.putExtra("bizType", "GVideo");
        intent2.putExtra("plugin_id", "Od");
        intent2.putExtra("appid", "1104763709");
        intent2.putExtra("isGroupCode", i3);
        intent2.putExtra("roomCodeType", i3);
        intent2.putExtra("uin", str);
        intent2.putExtra("roomid", Long.valueOf(str2));
        intent2.putExtra("fromId", str3);
        intent2.putExtra("extra", str5);
        intent2.putExtra("ts_click_millisecond", System.currentTimeMillis());
        intent2.putExtra("openType", str4);
        intent2.putExtra("show_status_bar", true);
        intent2.putExtras(bundle);
        intent2.setFlags(268435456);
        try {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString("prefs_key_gvideo_roominfo_entry_" + str, intent2.toUri(4)).commit();
        } catch (Exception e16) {
            QLog.e("GroupVideoManager", 2, e16.getMessage());
        }
        context.startActivity(intent2);
        if (z16) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.intervideo.yiqikan.a
    public com.tencent.mobileqq.intervideo.yiqikan.c a() {
        return this.f238166h.h();
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.h
    public void b(Context context, String str, String str2, String str3, String str4) {
        i(context, str, str2, str3, str4, new Bundle());
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.h
    public void c(Bundle bundle) {
        QQAppInterface r16 = r();
        if (r16 != null && NetworkUtil.isWifiEnabled(r16.getApp())) {
            QLog.e("GroupVideoManager", 2, "preload in wifi");
            p("", true);
        }
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.h
    public void e(Context context, String str, String str2, int i3, String str3, String str4, String str5, String str6, String str7) {
        QQAppInterface r16 = r();
        if (r16 != null) {
            if (r16.getAVNotifyCenter().i(context, i3 == 1 ? str : "0")) {
                QLog.i("GroupVideoManager", 1, "openNewGroupVideoLoadPage, blocked, roomCode[" + str + "]");
                return;
            }
        }
        if (u(VRReportDefine$ReportKey.INSTALL)) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) HuayangLoadbackgroudActivity.class);
        intent.putExtra("isPreload", true);
        intent.setFlags(268435456);
        context.startActivity(intent);
        boolean z16 = context instanceof Activity;
        if (z16) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
        Intent intent2 = new Intent(context, (Class<?>) ODLoadingActivity.class);
        intent2.putExtra("bizType", "GVideo");
        intent2.putExtra("plugin_id", "Od");
        intent2.putExtra("appid", "1104763709");
        intent2.putExtra("roomCodeType", i3);
        intent2.putExtra("uin", str2);
        intent2.putExtra("roomid", Long.valueOf(str));
        intent2.putExtra("fromId", str4);
        intent2.putExtra("openType", str6);
        intent2.putExtra("action", str3);
        intent2.putExtra("backType", str5);
        intent2.putExtra("extra", str7);
        intent2.putExtra("ts_click_millisecond", System.currentTimeMillis());
        intent2.putExtra("show_status_bar", true);
        intent2.setFlags(268435456);
        try {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString("prefs_key_gvideo_roominfo_entry_" + str2, intent2.toUri(4)).commit();
        } catch (Exception e16) {
            QLog.e("GroupVideoManager", 2, e16.getMessage());
        }
        context.startActivity(intent2);
        if (z16) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.h
    public void f(ConfigurationService$Config configurationService$Config) {
        String stringUtf8;
        QQAppInterface r16 = r();
        if (configurationService$Config == null || r16 == null) {
            return;
        }
        List<ConfigurationService$Content> list = configurationService$Config.msg_content_list.get();
        int i3 = configurationService$Config.version.get();
        int s16 = s(BaseApplication.getContext(), r16.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
            QLog.i("GroupVideoManager", 2, "handleDynamicConfig, version=" + i3 + ", oldversion=" + s16);
        }
        if (i3 > s16) {
            for (ConfigurationService$Content configurationService$Content : list) {
                if (configurationService$Content.compress.get() == 1) {
                    byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                    if (d16 != null) {
                        try {
                            stringUtf8 = new String(d16, "UTF-8");
                        } catch (UnsupportedEncodingException e16) {
                            QLog.e("GroupVideoManager", 1, "handleDynamicConfig new String error, e=" + e16.toString());
                        }
                    }
                    stringUtf8 = "";
                } else {
                    stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                }
                if (QLog.isColorLevel()) {
                    QLog.i("GroupVideoManager", 2, "handleDynamicConfig, contentStr=" + stringUtf8);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.h
    public void g(String str, int i3) {
        QQAppInterface r16 = r();
        if (r16 == null) {
            QLog.i("GroupVideoManager", 1, "preDownloadPlugin app is null");
            return;
        }
        PluginInfo queryPlugin = MobileQQ.sProcessId == 1 ? ((IPluginManager) MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.MGR_PLUGIN)).queryPlugin("GroupVideo.apk") : null;
        if (cooperation.plugin.e.e(queryPlugin, r().getApplicationContext())) {
            QLog.i("GroupVideoManager", 1, "preDownloadPlugin Plugin is Running");
            return;
        }
        if (u("preload")) {
            QLog.i("GroupVideoManager", 1, "preDownloadPlugin too frequently");
            return;
        }
        PatchReporter patchReporter = PatchReporter.f390339a;
        patchReporter.a(i3, queryPlugin);
        if (!GroupVideoConfig.c().b()) {
            QLog.i("GroupVideoManager", 1, "can not preDownloadPlugin");
            patchReporter.a(2, null);
            return;
        }
        if (cooperation.plugin.patch.g.a(r16.getApplicationContext(), queryPlugin, true, null)) {
            QLog.i("GroupVideoManager", 1, "can pre Patch");
            p(str, false);
            patchReporter.a(3, queryPlugin);
        } else {
            if (NetworkUtil.isWifiEnabled(r16.getApp()) && GroupVideoConfig.c().c()) {
                QLog.i("GroupVideoManager", 1, "can pre download full");
                p(str, true);
                patchReporter.a(4, queryPlugin);
            }
            QLog.i("GroupVideoManager", 1, "preDownloadPlugin not pre download");
        }
    }

    @Override // com.tencent.mobileqq.intervideo.yiqikan.a
    public void h(NewTogetherRoomMessageData newTogetherRoomMessageData, Bundle bundle, com.tencent.mobileqq.intervideo.yiqikan.b bVar) {
        n(bundle, bVar);
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.h
    public void i(Context context, String str, String str2, String str3, String str4, Bundle bundle) {
        x(context, str, str2, str3, str4, 1, new JsonObject().toString(), bundle);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("GroupVideoManager", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        o();
        AppNetConnInfo.unregisterNetEventHandler(this.f238167i);
        this.f238163d.removeCallbacksAndMessages(null);
        s.g().f();
        this.f238166h.o();
        PluginManagerInterfaceImpl.c();
        NowLive.setCustomizedLog(null);
        NowLive.setCustomChannel(null);
        NowLive.setCustomizedLoading(null);
        NowLive.setCustomizeReport(null);
        NowLive.setCustomizedDownloader(null);
        NowLive.setCustomizedRecord(null);
        NowLive.setCustomizedShareForQQ(null);
        NowLive.setQQKandianInterface(null);
        NowLive.setCustomizedWebView(null);
        NowLive.setCustomizedDns(null);
    }

    public void y(final boolean z16) {
        RecentUserProxy m3;
        List<RecentUser> recentList;
        QQAppInterface r16 = r();
        if (r16 == null || (m3 = r16.getProxyManager().m()) == null || (recentList = m3.getRecentList(false)) == null || recentList.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : recentList) {
            if (recentUser.getType() == 1) {
                try {
                    arrayList.add(Long.valueOf(Long.parseLong(recentUser.uin)));
                } catch (NumberFormatException unused) {
                }
            }
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.1
            @Override // java.lang.Runnable
            public void run() {
                GroupVideoManager.this.y(z16);
            }
        };
        if (arrayList.size() > 0) {
            this.f238163d.removeCallbacks(runnable);
            this.f238165f = 0;
            GVideoHandler gVideoHandler = (GVideoHandler) r16.getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
            if (gVideoHandler != null) {
                gVideoHandler.P2(arrayList, new a(r16));
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GroupVideoManager", 2, "updateGroupVideoStateList try count:" + this.f238165f);
        }
        int i3 = this.f238165f;
        if (i3 < 8 && z16) {
            this.f238165f = i3 + 1;
            this.f238163d.postDelayed(runnable, 1000L);
        } else {
            this.f238165f = 0;
        }
    }

    @Override // com.tencent.mobileqq.intervideo.yiqikan.a
    public void d(NewTogetherRoomMessageData newTogetherRoomMessageData) {
        QLog.i("GroupVideoManager", 1, "preload from watch together is err return");
    }

    @Override // com.tencent.mobileqq.intervideo.yiqikan.a
    public void j(NewTogetherRoomMessageData newTogetherRoomMessageData, Bundle bundle, com.tencent.mobileqq.intervideo.yiqikan.b bVar) {
        QLog.i("GroupVideoManager", 1, "openRoom from watch together is err return");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class i extends CustomizedReport {
        i() {
        }

        @Override // com.tencent.intervideo.nowproxy.customized_interface.CustomizedReport
        public void onReport(Bundle bundle) {
            com.tencent.mobileqq.intervideo.now.a h16 = PluginManagerInterfaceImpl.i().h();
            if (h16 != null) {
                h16.e(bundle);
            }
        }

        @Override // com.tencent.intervideo.nowproxy.customized_interface.CustomizedReport
        public void setNowEntryData(NowEntryData nowEntryData) {
        }

        @Override // com.tencent.intervideo.nowproxy.customized_interface.CustomizedReport
        public void onNowEntry(Bundle bundle, NowEntryData nowEntryData) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class f implements CustomizedLoading {
        f() {
        }

        @Override // com.tencent.intervideo.nowproxy.customized_interface.CustomizedLoading
        public void onShowLoading(Context context, Bundle bundle, View view) {
        }
    }
}
