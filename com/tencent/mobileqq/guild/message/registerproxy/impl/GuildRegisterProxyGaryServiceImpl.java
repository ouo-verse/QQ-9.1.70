package com.tencent.mobileqq.guild.message.registerproxy.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.home.aj;
import com.tencent.mobileqq.activity.home.al;
import com.tencent.mobileqq.activity.home.t;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.message.registerproxy.IGuildRegisterProxyGaryService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msg.api.IMsgService;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

/* loaded from: classes14.dex */
public class GuildRegisterProxyGaryServiceImpl implements IGuildRegisterProxyGaryService {
    private static final String TAG = "GuildRegisterProxyGaryServiceImpl";
    private WeakReference<AppInterface> appRef;
    private boolean lastShowGuildTab;
    private SharedPreferences tabDataSharedPreferences;
    private final SharedPreferences.OnSharedPreferenceChangeListener tabDataListener = new a();
    public com.tencent.mobileqq.logic.a mTabDataObserver = new b();
    private final aj frameAddCallback = new c();
    private final oo1.a guildObserver = new d();

    /* loaded from: classes14.dex */
    class a implements SharedPreferences.OnSharedPreferenceChangeListener {
        a() {
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (!TextUtils.isEmpty(str) && str.contains("GUILD")) {
                if (QLog.isColorLevel()) {
                    QLog.d(GuildRegisterProxyGaryServiceImpl.TAG, 2, "onSharedPreferenceChanged.");
                }
                GuildRegisterProxyGaryServiceImpl.this.handleUpdate(false);
            }
        }
    }

    /* loaded from: classes14.dex */
    class b extends com.tencent.mobileqq.logic.a {
        b() {
        }

        @Override // com.tencent.mobileqq.logic.a
        public void onReceive(int i3, boolean z16, Object obj) {
            GuildRegisterProxyGaryServiceImpl.this.handleUpdate(false);
        }
    }

    /* loaded from: classes14.dex */
    class c implements aj {
        c() {
        }

        @Override // com.tencent.mobileqq.activity.home.aj
        public void a(al alVar) {
            if (alVar == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(GuildRegisterProxyGaryServiceImpl.TAG, 2, "onTabFrameAdd. tabId: " + alVar.f182853a + ", tabStatus: " + alVar.f182854b);
            }
            if (alVar.f182853a == 2) {
                GuildRegisterProxyGaryServiceImpl.this.handleUpdate(false);
            }
        }
    }

    /* loaded from: classes14.dex */
    class d extends oo1.a {
        d() {
        }

        @Override // oo1.a
        public void e() {
            QLog.i(GuildRegisterProxyGaryServiceImpl.TAG, 1, "onDebugShowTabUpdate");
            GuildRegisterProxyGaryServiceImpl.this.handleUpdate(false);
        }

        @Override // oo1.a
        public void l() {
            QLog.i(GuildRegisterProxyGaryServiceImpl.TAG, 1, "onMemoryShowTabUpdate");
            GuildRegisterProxyGaryServiceImpl.this.handleUpdate(false);
        }

        @Override // oo1.a
        public void q(Object obj, int i3) {
            boolean z16;
            if (QLog.isColorLevel()) {
                QLog.i(GuildRegisterProxyGaryServiceImpl.TAG, 2, "onUserTypeUpdate from:" + i3);
            }
            GuildRegisterProxyGaryServiceImpl guildRegisterProxyGaryServiceImpl = GuildRegisterProxyGaryServiceImpl.this;
            if (i3 == 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            guildRegisterProxyGaryServiceImpl.handleUpdate(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void handleUpdate(boolean z16) {
        boolean isShowGuildTab = ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "handleUpdate lastShowGuildTab:" + this.lastShowGuildTab + " curShowGuildTab:" + isShowGuildTab);
        }
        if (this.lastShowGuildTab != isShowGuildTab) {
            this.lastShowGuildTab = isShowGuildTab;
            if (!z16 && isShowGuildTab) {
                ((IMsgService) QRoute.api(IMsgService.class)).setGuildTabUserFlag(1);
                ((IMsgService) QRoute.api(IMsgService.class)).startGuildMsgSync();
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.registerproxy.IGuildRegisterProxyGaryService
    public synchronized boolean getShowGuildTab() {
        return this.lastShowGuildTab;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        AppInterface appInterface = (AppInterface) appRuntime;
        this.appRef = new WeakReference<>(appInterface);
        this.lastShowGuildTab = ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab();
        if (appInterface.isRunning()) {
            appInterface.addObserver(this.guildObserver);
            t.c().b(this.frameAddCallback);
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(TabDataHelper.K_TAB_DATA_HELPER_SP, 4);
            this.tabDataSharedPreferences = sharedPreferences;
            if (sharedPreferences != null) {
                sharedPreferences.registerOnSharedPreferenceChangeListener(this.tabDataListener);
            } else {
                QLog.e(TAG, 1, "tabDataSharedPreferences is null!");
            }
            appInterface.addObserver(this.mTabDataObserver);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        AppInterface appInterface = this.appRef.get();
        if (appInterface != null) {
            appInterface.removeObserver(this.guildObserver);
            t.c().d(this.frameAddCallback);
            SharedPreferences sharedPreferences = this.tabDataSharedPreferences;
            if (sharedPreferences != null) {
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(this.tabDataListener);
            }
            appInterface.removeObserver(this.mTabDataObserver);
        }
    }
}
