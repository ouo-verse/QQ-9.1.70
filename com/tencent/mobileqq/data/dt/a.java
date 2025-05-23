package com.tencent.mobileqq.data.dt;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.cf;
import com.tencent.mobileqq.data.dt.QQDtConfigHelper;
import com.tencent.mobileqq.msf.sdk.MSFSharedPreUtils;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements IDTParamProvider {

    /* renamed from: d, reason: collision with root package name */
    private static a f203141d;

    /* renamed from: a, reason: collision with root package name */
    private String f203142a;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArraySet<InterfaceC7479a> f203143b = new CopyOnWriteArraySet<>();

    /* renamed from: c, reason: collision with root package name */
    private QQDtConfigHelper f203144c = null;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.data.dt.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC7479a {
        void a(@NotNull Map<String, Object> map);
    }

    private void a(Map<String, Object> map) {
        if (map != null) {
            String a16 = cf.a();
            String valueOf = String.valueOf(AppSetting.f());
            map.put("client_page_name", a16);
            map.put("client_process_name", MobileQQ.processName);
            map.put("qq_appid", valueOf);
            map.put("callfrom_type", d().p());
            QQDtConfigHelper.Companion companion = QQDtConfigHelper.INSTANCE;
            map.put("message_box", companion.h());
            map.put("tianshu_id", d().x());
            map.put("red_pot", companion.i());
        }
    }

    private void c(Map<String, Object> map) {
        if (map != null) {
            Iterator<InterfaceC7479a> it = this.f203143b.iterator();
            while (it.hasNext()) {
                it.next().a(map);
            }
        }
    }

    private QQDtConfigHelper d() {
        if (this.f203144c == null) {
            this.f203144c = new QQDtConfigHelper();
        }
        return this.f203144c;
    }

    public static a e() {
        if (f203141d == null) {
            synchronized (a.class) {
                if (f203141d == null) {
                    f203141d = new a();
                }
            }
        }
        return f203141d;
    }

    public void b(@NotNull InterfaceC7479a interfaceC7479a) {
        this.f203143b.add(interfaceC7479a);
    }

    public void f(@NotNull InterfaceC7479a interfaceC7479a) {
        this.f203143b.remove(interfaceC7479a);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider, com.tencent.qqlive.module.videoreport.dtreport.api.IDTUserInfoProvider
    public String getAccountID() {
        AppRuntime appRuntime;
        String account;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            appRuntime = application.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null || (account = appRuntime.getAccount()) == null) {
            return "0";
        }
        return account;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider, com.tencent.qqlive.module.videoreport.dtreport.api.IDTVisitProvider
    public String getActiveInfo() {
        return null;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider, com.tencent.qqlive.module.videoreport.dtreport.api.IDTAppInfoProvider
    public String getAdCode() {
        return null;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider, com.tencent.qqlive.module.videoreport.dtreport.api.IDTVisitProvider
    public String getCallFrom() {
        return String.valueOf(d().o());
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider, com.tencent.qqlive.module.videoreport.dtreport.api.IDTVisitProvider
    public String getCallScheme() {
        return d().q();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider, com.tencent.qqlive.module.videoreport.dtreport.api.IDTAppInfoProvider
    public String getFactoryChannelId() {
        return null;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider, com.tencent.qqlive.module.videoreport.dtreport.api.IDTAppInfoProvider
    public String getGuid() {
        if (TextUtils.isEmpty(this.f203142a)) {
            this.f203142a = MSFSharedPreUtils.getGuid();
        }
        return this.f203142a;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider, com.tencent.qqlive.module.videoreport.dtreport.api.IDTUserInfoProvider
    public String getMainLogin() {
        return null;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider, com.tencent.qqlive.module.videoreport.dtreport.api.IDTAppInfoProvider
    public String getModifyChannelId() {
        return null;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider, com.tencent.qqlive.module.videoreport.dtreport.api.IDTAppInfoProvider
    public String getOaid() {
        return null;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider, com.tencent.qqlive.module.videoreport.dtreport.api.IDTAppInfoProvider
    public String getOmgbzid() {
        return null;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider, com.tencent.qqlive.module.videoreport.dtreport.api.IDTUserInfoProvider
    public String getQQ() {
        AppRuntime appRuntime;
        String account;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            appRuntime = application.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null || (account = appRuntime.getAccount()) == null) {
            return "0";
        }
        return account;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider, com.tencent.qqlive.module.videoreport.dtreport.api.IDTUserInfoProvider
    public String getQQOpenID() {
        return null;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider, com.tencent.qqlive.module.videoreport.dtreport.api.IDTAppInfoProvider
    public String getSIMType() {
        int i3;
        AppRuntime peekAppRuntime;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null && (peekAppRuntime = application.peekAppRuntime()) != null) {
            i3 = com.tencent.mobileqq.vip.e.b(peekAppRuntime.getAccount());
        } else {
            i3 = -1;
        }
        if (i3 == 1) {
            return "1";
        }
        return "3";
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider, com.tencent.qqlive.module.videoreport.dtreport.api.IDTVisitProvider
    public int getStartType() {
        return d().s();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider, com.tencent.qqlive.module.videoreport.dtreport.api.IDTAppInfoProvider
    public String getTid() {
        return null;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider, com.tencent.qqlive.module.videoreport.dtreport.api.IDTUserInfoProvider
    public String getWbOpenID() {
        return null;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider, com.tencent.qqlive.module.videoreport.dtreport.api.IDTUserInfoProvider
    public String getWxOpenID() {
        return null;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider, com.tencent.qqlive.module.videoreport.dtreport.api.IDTUserInfoProvider
    public String getWxUnionID() {
        return null;
    }

    @Override // com.tencent.qqlive.module.videoreport.IEventDynamicParams
    public void setEventDynamicParams(String str, Map<String, Object> map) {
        if (EventKey.APP_IN.equals(str) && map != null) {
            map.put("mainprocess", d().r());
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.IEventDynamicParams
    public void setRealtimePublicDynamicParams(Map<String, Object> map) {
        a(map);
        c(map);
    }

    @Override // com.tencent.qqlive.module.videoreport.IEventDynamicParams
    public void setNonRealtimePublicDynamicParams(Map<String, Object> map) {
    }
}
