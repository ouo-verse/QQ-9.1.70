package com.tencent.mobileqq.activity.aio;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AppGuideTipsManager implements Manager {
    public static String D = "AppGuideTipsManager";

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f178032d;

    /* renamed from: e, reason: collision with root package name */
    private EntityManager f178033e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f178034f = false;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, AppGuideTipsConfig> f178035h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    private int f178036i = 0;

    /* renamed from: m, reason: collision with root package name */
    private AppGuideTipsConfig f178037m = null;
    private boolean C = true;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.aio.AppGuideTipsManager$2, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ AppGuideTipsManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            AppGuideTipsManager appGuideTipsManager = this.this$0;
            appGuideTipsManager.C = PackageUtil.isAppInstalled(appGuideTipsManager.f178032d.getApp(), AppConstants.TIM_PACKAGE_NAME);
        }
    }

    public AppGuideTipsManager(QQAppInterface qQAppInterface) {
        this.f178032d = qQAppInterface;
        this.f178033e = qQAppInterface.getEntityManagerFactory().createEntityManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.f178036i = this.f178032d.getPreferences().getInt("tim_is_office_user", 0);
    }

    public void g() {
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, "clearTimAIOGrayTipsBarConfig");
        }
        BaseApplicationImpl.getApplication().getSharedPreferences("tim_office_user_tips_bar_" + this.f178032d.getCurrentAccountUin(), 0).edit().clear().apply();
    }

    public void h() {
        if (this.f178034f) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.AppGuideTipsManager.1
            @Override // java.lang.Runnable
            public void run() {
                String[] split;
                AppGuideTipsManager.this.i();
                AppGuideTipsManager.this.j();
                AppGuideTipsManager.this.f178035h.clear();
                ArrayList arrayList = (ArrayList) AppGuideTipsManager.this.f178033e.query(AppGuideTipsConfig.class, AppGuideTipsConfig.class.getSimpleName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
                if (arrayList != null && arrayList.size() > 0) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        AppGuideTipsConfig appGuideTipsConfig = (AppGuideTipsConfig) arrayList.get(i3);
                        if (appGuideTipsConfig != null && !TextUtils.isEmpty(appGuideTipsConfig.tipsType)) {
                            if (!TextUtils.isEmpty(appGuideTipsConfig.msgTypeStr) && (split = appGuideTipsConfig.msgTypeStr.split("\\|")) != null) {
                                for (String str : split) {
                                    try {
                                        appGuideTipsConfig.msgTypeMap.put(Integer.valueOf(Integer.valueOf(str).intValue()), Boolean.TRUE);
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                            AppGuideTipsManager.this.f178035h.put(appGuideTipsConfig.tipsType, appGuideTipsConfig);
                        }
                    }
                    AppGuideTipsManager.this.f178034f = true;
                    AppGuideTipsManager.this.n();
                    if (QLog.isColorLevel()) {
                        QLog.d(AppGuideTipsManager.D, 2, "loadConfig, mTipsMap size=" + AppGuideTipsManager.this.f178035h.size());
                    }
                }
            }
        }, 5, null, false);
    }

    public void j() {
        String[] split;
        String[] split2;
        AppGuideTipsConfig appGuideTipsConfig = new AppGuideTipsConfig();
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("tim_office_user_tips_bar_" + this.f178032d.getCurrentAccountUin(), 0);
        appGuideTipsConfig.switchKey = sharedPreferences.getString("tim_gray_tips_switch", "0");
        appGuideTipsConfig.maxCount = sharedPreferences.getInt("tim_gray_tips_total", 0);
        appGuideTipsConfig.duration = sharedPreferences.getLong("tim_gray_tips_duration", 0L);
        appGuideTipsConfig.tipsUrl = sharedPreferences.getString("tim_gray_tips_url", "");
        appGuideTipsConfig.tipsMsg = sharedPreferences.getString("tim_gray_tips_txt", "");
        appGuideTipsConfig.msgTypeStr = sharedPreferences.getString("tim_gray_tips_types", "");
        appGuideTipsConfig.aioTypeStr = sharedPreferences.getString("tim_tips_bar_aio_types", "");
        appGuideTipsConfig.addCount = sharedPreferences.getInt("tim_gray_tips_count", 0);
        appGuideTipsConfig.lastAddTime = sharedPreferences.getLong("tim_gray_tips_time", 0L);
        if (!TextUtils.isEmpty(appGuideTipsConfig.msgTypeStr) && (split2 = appGuideTipsConfig.msgTypeStr.split("\\|")) != null) {
            for (String str : split2) {
                try {
                    appGuideTipsConfig.msgTypeMap.put(Integer.valueOf(Integer.valueOf(str).intValue()), Boolean.TRUE);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
        if (!TextUtils.isEmpty(appGuideTipsConfig.aioTypeStr) && (split = appGuideTipsConfig.aioTypeStr.split("\\|")) != null) {
            for (String str2 : split) {
                try {
                    appGuideTipsConfig.aioTypes.add(Integer.valueOf(Integer.valueOf(str2).intValue()));
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
        }
        this.f178037m = appGuideTipsConfig;
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, "loadTimAIOTipsBarConfig, switch: ", appGuideTipsConfig.switchKey);
        }
    }

    public void k(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(D, 1, "saveOfficeUserFlag: " + i3);
        }
        if (i3 == this.f178036i) {
            return;
        }
        this.f178036i = i3;
        this.f178032d.getPreferences().edit().putInt("tim_is_office_user", i3).apply();
    }

    public void l(AppGuideTipsConfig appGuideTipsConfig) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("tim_office_user_tips_bar_" + this.f178032d.getCurrentAccountUin(), 0).edit();
        try {
            edit.putString("tim_gray_tips_switch", appGuideTipsConfig.switchKey);
            edit.putInt("tim_gray_tips_total", appGuideTipsConfig.maxCount);
            edit.putLong("tim_gray_tips_duration", appGuideTipsConfig.duration);
            edit.putString("tim_gray_tips_url", appGuideTipsConfig.tipsUrl);
            edit.putString("tim_gray_tips_txt", appGuideTipsConfig.tipsMsg);
            edit.putString("tim_gray_tips_types", appGuideTipsConfig.msgTypeStr);
            edit.putString("tim_tips_bar_aio_types", appGuideTipsConfig.aioTypeStr);
            edit.apply();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void m(List<AppGuideTipsConfig> list) {
        AppGuideTipsConfig appGuideTipsConfig;
        if (list != null && list.size() != 0) {
            EntityTransaction entityTransaction = null;
            try {
                try {
                    entityTransaction = this.f178033e.getTransaction();
                    entityTransaction.begin();
                    this.f178035h.clear();
                    this.f178034f = false;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        AppGuideTipsConfig appGuideTipsConfig2 = list.get(i3);
                        if (appGuideTipsConfig2 != null && (appGuideTipsConfig = (AppGuideTipsConfig) DBMethodProxy.find(this.f178033e, (Class<? extends Entity>) AppGuideTipsConfig.class, appGuideTipsConfig2.tipsType)) != null) {
                            appGuideTipsConfig2.addCount = appGuideTipsConfig.addCount;
                            appGuideTipsConfig2.lastAddTime = appGuideTipsConfig.lastAddTime;
                        }
                    }
                    AppGuideTipsConfig appGuideTipsConfig3 = new AppGuideTipsConfig();
                    appGuideTipsConfig3.setStatus(1001);
                    this.f178033e.remove(appGuideTipsConfig3, "_id>?", new String[]{"0"});
                    for (int i16 = 0; i16 < list.size(); i16++) {
                        AppGuideTipsConfig appGuideTipsConfig4 = list.get(i16);
                        if (appGuideTipsConfig4 != null) {
                            o(appGuideTipsConfig4);
                        }
                    }
                    entityTransaction.commit();
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.w(D, 2, "insert write exception: " + e16.getMessage());
                    }
                    if (entityTransaction == null) {
                        return;
                    }
                }
                entityTransaction.end();
            } catch (Throwable th5) {
                if (entityTransaction != null) {
                    entityTransaction.end();
                }
                throw th5;
            }
        }
    }

    public void n() {
        if (!this.f178034f) {
            h();
        }
        Map<String, AppGuideTipsConfig> map = this.f178035h;
        if (map != null && map.size() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            for (AppGuideTipsConfig appGuideTipsConfig : this.f178035h.values()) {
                if (appGuideTipsConfig != null) {
                    if (!"0".equals(appGuideTipsConfig.switchKey) && currentTimeMillis - appGuideTipsConfig.lastAddTime > appGuideTipsConfig.duration * 1000 && appGuideTipsConfig.addCount < appGuideTipsConfig.maxCount) {
                        appGuideTipsConfig.allow = true;
                    } else {
                        appGuideTipsConfig.allow = false;
                    }
                }
            }
        }
    }

    public boolean o(Entity entity) {
        if (!this.f178033e.isOpen()) {
            return false;
        }
        if (entity.getStatus() == 1000) {
            this.f178033e.persistOrReplace(entity);
            if (entity.getStatus() != 1001) {
                return false;
            }
            return true;
        }
        if (entity.getStatus() != 1001 && entity.getStatus() != 1002) {
            return false;
        }
        return this.f178033e.update(entity);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
