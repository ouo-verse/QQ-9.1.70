package com.tencent.mobileqq.config;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.PluginConfigProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceReqInfoV2;
import protocol.KQQConfig.GetResourceRespInfoV2;
import protocol.KQQConfig.GetResourceRespV2;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AboutConfig {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f202192a;

    /* renamed from: d, reason: collision with root package name */
    private boolean f202195d = true;

    /* renamed from: e, reason: collision with root package name */
    private boolean f202196e = false;

    /* renamed from: f, reason: collision with root package name */
    private ServerConfigObserver f202197f = new a();

    /* renamed from: c, reason: collision with root package name */
    private List<ResourcePluginListener> f202194c = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private Hashtable<String, ResourcePluginInfo> f202193b = new Hashtable<>();

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends ServerConfigObserver {
        a() {
        }

        @Override // mqq.observer.ServerConfigObserver
        public void onGetPluginConfig(boolean z16, int i3, GetResourceRespV2 getResourceRespV2) {
            boolean z17;
            short s16;
            short s17;
            short s18;
            if ((i3 & 32) == 0) {
                return;
            }
            int i16 = 0;
            if (z16 && getResourceRespV2 != null) {
                EntityManager createEntityManager = AboutConfig.this.f202192a.getEntityManagerFactory().createEntityManager();
                Iterator<GetResourceRespInfoV2> it = getResourceRespV2.vecAddedResInfo.iterator();
                boolean z18 = false;
                loop0: while (true) {
                    z17 = z18;
                    while (it.hasNext()) {
                        GetResourceRespInfoV2 next = it.next();
                        if (next.iPluginType == 32 && ((s18 = next.sResSubType) == 0 || s18 == 2)) {
                            if (g.e(createEntityManager, AboutConfig.this.f202195d, next).cDefaultState == 0) {
                                break;
                            }
                            z18 = true;
                            z17 = true;
                        }
                    }
                    z18 = true;
                }
                Iterator<GetResourceRespInfoV2> it5 = getResourceRespV2.vecDeletedResInfo.iterator();
                while (it5.hasNext()) {
                    GetResourceRespInfoV2 next2 = it5.next();
                    if (next2.iPluginType == 32 && ((s17 = next2.sResSubType) == 0 || s17 == 2)) {
                        ResourcePluginInfo.remove(createEntityManager, next2.strPkgName);
                        z18 = true;
                    }
                }
                Iterator<GetResourceRespInfoV2> it6 = getResourceRespV2.vecUpdatedResInfo.iterator();
                while (it6.hasNext()) {
                    GetResourceRespInfoV2 next3 = it6.next();
                    if (next3.iPluginType == 32 && ((s16 = next3.sResSubType) == 0 || s16 == 2)) {
                        g.e(createEntityManager, AboutConfig.this.f202195d, next3);
                        z18 = true;
                    }
                }
                createEntityManager.close();
                AboutConfig.this.n(true, false);
                if (z18) {
                    for (ResourcePluginListener resourcePluginListener : new ArrayList(AboutConfig.this.f202194c)) {
                        if (z17) {
                            ResourcePluginListener.a(resourcePluginListener, (byte) 3, 2);
                            if (z17) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("AboutConfig", 2, "inform STATE_NEW_OPEN_PLUGIN");
                                }
                                ResourcePluginListener.a(resourcePluginListener, (byte) 4, 2);
                            }
                        } else {
                            ResourcePluginListener.a(resourcePluginListener, (byte) 2, 2);
                        }
                    }
                    return;
                }
                while (i16 < AboutConfig.this.f202194c.size()) {
                    try {
                        ResourcePluginListener.a((ResourcePluginListener) AboutConfig.this.f202194c.get(i16), (byte) 1, 2);
                    } catch (Exception unused) {
                    }
                    i16++;
                }
                return;
            }
            while (i16 < AboutConfig.this.f202194c.size()) {
                try {
                    ResourcePluginListener.a((ResourcePluginListener) AboutConfig.this.f202194c.get(i16), (byte) -1, 2);
                } catch (Exception unused2) {
                }
                i16++;
            }
        }
    }

    public AboutConfig(QQAppInterface qQAppInterface) {
        this.f202192a = qQAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(List<ResourcePluginInfo> list) {
        if (this.f202193b != null && list != null && list.size() > 0) {
            for (ResourcePluginInfo resourcePluginInfo : list) {
                this.f202193b.put(resourcePluginInfo.strPkgName, resourcePluginInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Hashtable<String, ResourcePluginInfo> hashtable = this.f202193b;
        if (hashtable != null) {
            hashtable.clear();
        }
    }

    private Hashtable<String, ResourcePluginInfo> l() {
        Hashtable<String, ResourcePluginInfo> hashtable = new Hashtable<>();
        ResourcePluginInfo resourcePluginInfo = new ResourcePluginInfo();
        resourcePluginInfo.strPkgName = "com.tencent.help_5_8";
        resourcePluginInfo.strResName = this.f202192a.getApp().getString(R.string.bpd);
        resourcePluginInfo.strResDesc = "";
        resourcePluginInfo.strResURL = "";
        resourcePluginInfo.sResSubType = (short) 2;
        resourcePluginInfo.cCanChangeState = (byte) 0;
        resourcePluginInfo.cDefaultState = (byte) 0;
        resourcePluginInfo.cLocalState = (byte) 1;
        resourcePluginInfo.cDataType = (byte) 1;
        resourcePluginInfo.isNew = (byte) 1;
        resourcePluginInfo.sLanType = (short) 1;
        resourcePluginInfo.sPriority = (short) 0;
        resourcePluginInfo.uiResId = 0L;
        resourcePluginInfo.strGotoUrl = "https://kf.qq.com/touch/scene_product.html?scene_id=kf180";
        resourcePluginInfo.iPluginType = 32;
        hashtable.put(resourcePluginInfo.strPkgName, resourcePluginInfo);
        ResourcePluginInfo resourcePluginInfo2 = new ResourcePluginInfo();
        resourcePluginInfo2.strPkgName = "com.tencent.Feedback_5_8";
        resourcePluginInfo2.strResName = this.f202192a.getApp().getString(R.string.b5c);
        resourcePluginInfo2.strResDesc = "";
        resourcePluginInfo2.strResURL = "";
        resourcePluginInfo2.sResSubType = (short) 2;
        resourcePluginInfo2.cCanChangeState = (byte) 0;
        resourcePluginInfo2.cDefaultState = (byte) 0;
        resourcePluginInfo2.cLocalState = (byte) 1;
        resourcePluginInfo2.cDataType = (byte) 1;
        resourcePluginInfo2.isNew = (byte) 1;
        resourcePluginInfo2.sLanType = (short) 1;
        resourcePluginInfo2.sPriority = (short) 0;
        resourcePluginInfo2.uiResId = 0L;
        resourcePluginInfo2.strGotoUrl = "https://mma.qq.com/feedback/index.html";
        resourcePluginInfo2.iPluginType = 32;
        hashtable.put(resourcePluginInfo2.strPkgName, resourcePluginInfo2);
        return hashtable;
    }

    public static void o(QQAppInterface qQAppInterface, Context context, final ResourcePluginInfo resourcePluginInfo) {
        String str;
        String str2;
        String str3;
        AboutConfig aboutConfig = qQAppInterface.getAboutConfig();
        String str4 = resourcePluginInfo.strGotoUrl;
        String str5 = "version=" + AppSetting.f99554n + "&appid=" + AppSetting.f() + "&QUA=" + QZoneHelper.getQUA();
        if (resourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8") || resourcePluginInfo.strPkgName.equals("com.tencent.help_5_8")) {
            str5 = str5 + "&adtag=" + AppSetting.f99542b;
        }
        if (resourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8")) {
            if (str4.endsWith("#_rc=mqq_faq_feedback")) {
                str4 = str4.substring(0, str4.length() - 21);
            }
            str = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str5;
        } else {
            str = ContainerUtils.FIELD_DELIMITER + str5;
        }
        String str6 = str4 + str;
        if (resourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8") || resourcePluginInfo.strPkgName.equals("com.tencent.help_5_8")) {
            if (QLog.isColorLevel()) {
                if (resourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8")) {
                    QLog.i("About-Feedback", 2, "feedfack before: url = " + str6);
                } else if (resourcePluginInfo.strPkgName.equals("com.tencent.help_5_8")) {
                    QLog.i("About-Help", 2, "help before: url = " + str6);
                }
            }
            String model = DeviceInfoMonitor.getModel();
            if (model == null) {
                str2 = "";
            } else {
                str2 = model.replaceAll(" ", "_");
            }
            int qzonePatchTag = StatisticCollector.getQzonePatchTag();
            if (qzonePatchTag > 0) {
                str2 = str2 + "_qzpatch" + qzonePatchTag;
            }
            String str7 = Build.MANUFACTURER;
            if (str7 == null) {
                str3 = "";
            } else {
                str3 = str7.replaceAll(" ", "_");
            }
            str6 = str6 + "&model=" + str2 + "&manufacture=" + str3 + "&cpunum=" + com.tencent.mobileqq.utils.ah.n() + "&cpurate=" + com.tencent.mobileqq.utils.ah.l() + "&mem=" + ((com.tencent.mobileqq.utils.m.c() / 1024) / 1024) + "&amem=" + ((com.tencent.mobileqq.utils.ah.X() / 1024) / 1024) + "&w=" + com.tencent.mobileqq.utils.ah.x() + "&h=" + com.tencent.mobileqq.utils.ah.w() + "&pss=" + ((sy3.b.d(Process.myPid()) / 1024) / 1024) + "&heapmax=" + ((Runtime.getRuntime().maxMemory() / 1024) / 1024) + "&heapsize=" + (((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024) / 1024) + "&sysver=" + Build.VERSION.RELEASE + "&user_tag=" + QLog.getReportLevel(QLog.getUIN_REPORTLOG_LEVEL());
            if (resourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8")) {
                str6 = str6 + "#_rc=mqq_faq_feedback";
                if (4 != QLog.getUIN_REPORTLOG_LEVEL()) {
                    QLog.setUIN_REPORTLOG_LEVEL(4);
                    NativeConfigStore nativeConfigStore = MsfStore.getNativeConfigStore();
                    if (nativeConfigStore != null) {
                        nativeConfigStore.setConfig(QLog.logLevelHead, "4");
                        nativeConfigStore.setConfig(QLog.logLevelTime, "" + System.currentTimeMillis());
                    }
                }
            }
            if (QLog.isColorLevel()) {
                if (resourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8")) {
                    QLog.i("About-Feedback", 2, "feedfack after: url = " + str6);
                } else if (resourcePluginInfo.strPkgName.equals("com.tencent.help_5_8")) {
                    QLog.i("About-Help", 2, "help after: url = " + str6);
                }
            }
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("portraitOnly", true);
        intent.putExtra("url", str6).putExtra("bFormatUrl", false);
        intent.putExtra("uin", qQAppInterface.getCurrentAccountUin());
        if (resourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8") || resourcePluginInfo.strPkgName.equals("com.tencent.help_5_8")) {
            intent.putExtra("reportMsfLog", true);
        }
        try {
            context.startActivity(intent);
        } catch (SecurityException unused) {
        }
        if (resourcePluginInfo.isNew == 0) {
            resourcePluginInfo.isNew = (byte) 1;
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.config.AboutConfig.3
                @Override // java.lang.Runnable
                public void run() {
                    AboutConfig.this.s(resourcePluginInfo);
                    AboutConfig.this.p();
                }
            }, 8, null, false);
        }
    }

    public void h(ResourcePluginListener resourcePluginListener) {
        if (!this.f202194c.contains(resourcePluginListener)) {
            this.f202194c.add(resourcePluginListener);
        }
    }

    public ResourcePluginInfo k(String str) {
        return this.f202193b.get(str);
    }

    public void m() {
        boolean z16;
        if (this.f202192a.getApp().getResources().getDisplayMetrics().widthPixels >= 480) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f202195d = z16;
        n(false, true);
        for (int i3 = 0; i3 < this.f202194c.size(); i3++) {
            ResourcePluginListener.a(this.f202194c.get(i3), (byte) 1, 2);
        }
    }

    public void n(boolean z16, final boolean z17) {
        Hashtable<String, ResourcePluginInfo> hashtable;
        if (QLog.isColorLevel()) {
            QLog.d("AboutConfig", 2, "loadAboutConfig, isfore=" + z16 + ",asynchronous=" + z17);
        }
        if (!this.f202192a.isLogin()) {
            if (QLog.isColorLevel()) {
                QLog.d("AboutConfig", 2, "error happens: loadAboutConfig while current account is null, which means there is no logined account now");
            }
        } else if (!z16 && (hashtable = this.f202193b) != null && hashtable.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("AboutConfig", 2, "there has about data in memory cache, do not need load from DB");
            }
        } else {
            this.f202193b = l();
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.config.AboutConfig.1
                @Override // java.lang.Runnable
                public void run() {
                    EntityManager createEntityManager = AboutConfig.this.f202192a.getEntityManagerFactory().createEntityManager();
                    int i3 = 0;
                    List<ResourcePluginInfo> all = ResourcePluginInfo.getAll(createEntityManager, 32, false);
                    createEntityManager.close();
                    if (all != null && (i3 = all.size()) > 0) {
                        synchronized (AboutConfig.this.f202193b) {
                            AboutConfig.this.j();
                            AboutConfig.this.i(all);
                        }
                        AboutConfig.this.p();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("AboutConfig", 2, "Load about config from DB = " + AboutConfig.this.f202193b + ",asynchronous=" + z17 + ",size=" + i3);
                    }
                    AboutConfig.this.f202196e = true;
                }
            };
            if (z17) {
                ThreadManagerV2.post(runnable, 5, null, false);
            } else {
                runnable.run();
            }
        }
    }

    public void p() {
        Iterator it = new ArrayList(this.f202194c).iterator();
        while (it.hasNext()) {
            ResourcePluginListener.a((ResourcePluginListener) it.next(), (byte) 5, 2);
        }
    }

    public void q(ResourcePluginListener resourcePluginListener) {
        this.f202194c.remove(resourcePluginListener);
    }

    public void r(PluginConfigProxy pluginConfigProxy) {
        if (!this.f202196e) {
            n(true, false);
        }
        ArrayList arrayList = new ArrayList();
        Hashtable<String, ResourcePluginInfo> hashtable = this.f202193b;
        if (hashtable != null) {
            for (ResourcePluginInfo resourcePluginInfo : ((Hashtable) hashtable.clone()).values()) {
                if (resourcePluginInfo.cDataType == 0) {
                    GetResourceReqInfoV2 getResourceReqInfoV2 = new GetResourceReqInfoV2();
                    getResourceReqInfoV2.cState = (byte) 0;
                    getResourceReqInfoV2.sLanType = resourcePluginInfo.sLanType;
                    getResourceReqInfoV2.sResSubType = (short) 0;
                    getResourceReqInfoV2.strPkgName = resourcePluginInfo.strPkgName;
                    getResourceReqInfoV2.uiCurVer = resourcePluginInfo.uiCurVer;
                    getResourceReqInfoV2.iPluginType = resourcePluginInfo.iPluginType;
                    arrayList.add(getResourceReqInfoV2);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQInitHandler", 2, "sendAboutConfig" + arrayList.size() + ",hasLoadFromDB=" + this.f202196e);
        }
        pluginConfigProxy.a(32, arrayList, this.f202197f);
    }

    public void s(ResourcePluginInfo resourcePluginInfo) {
        Hashtable<String, ResourcePluginInfo> hashtable = this.f202193b;
        if (hashtable != null && resourcePluginInfo != null && hashtable.containsKey(resourcePluginInfo.strPkgName)) {
            ResourcePluginInfo resourcePluginInfo2 = this.f202193b.get(resourcePluginInfo.strPkgName);
            resourcePluginInfo2.cLocalState = resourcePluginInfo.cLocalState;
            resourcePluginInfo2.isNew = resourcePluginInfo.isNew;
            EntityManager createEntityManager = this.f202192a.getEntityManagerFactory().createEntityManager();
            try {
                ResourcePluginInfo.persistOrReplace(createEntityManager, resourcePluginInfo2);
                if (createEntityManager == null) {
                    return;
                }
            } catch (Exception unused) {
                if (createEntityManager == null) {
                    return;
                }
            } catch (Throwable th5) {
                if (createEntityManager != null) {
                    createEntityManager.close();
                }
                throw th5;
            }
            createEntityManager.close();
        }
    }
}
