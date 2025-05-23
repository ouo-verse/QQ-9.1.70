package com.tencent.mobileqq.springhb.entry;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import com.tencent.mobileqq.springhb.entry.model.DragonCardConfigData;
import com.tencent.mobileqq.springhb.entry.model.EntryConfigBean;
import com.tencent.mobileqq.springhb.preload.SpringHbPreloadManager;
import com.tencent.mobileqq.springhb.preload.SpringHbZipMappingBean;
import com.tencent.mobileqq.springhb.preload.i;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.Serializable;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes18.dex */
public class SpringHbIPCModule extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static SpringHbIPCModule f289079d;

    public SpringHbIPCModule() {
        super("SpringHbIPCModule");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static EIPCResult b(AppRuntime appRuntime) {
        boolean z16;
        try {
            if (appRuntime instanceof QQAppInterface) {
                z16 = ((QQAppInterface) appRuntime).isVideoChatting();
            } else {
                QLog.e("SpringHbIPCModule", 1, "doGetIsVideoChatting appRuntime is not QQAppInterface");
                z16 = false;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("isVideoChatting", z16);
            return EIPCResult.createSuccessResult(bundle);
        } catch (Exception unused) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("isVideoChatting", false);
            return EIPCResult.createSuccessResult(bundle2);
        }
    }

    public static SpringHbIPCModule c() {
        if (f289079d == null) {
            synchronized (SpringHbIPCModule.class) {
                if (f289079d == null) {
                    f289079d = new SpringHbIPCModule();
                }
            }
        }
        return f289079d;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("SpringHbIPCModule", 2, "action = " + str + ", params = " + bundle);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str2 = null;
        EntryConfigBean entryConfigBean = null;
        if (peekAppRuntime != null && MobileQQ.sProcessId == 1) {
            if ("ReportData".equals(str)) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).report(bundle.getSerializable("key1"), 2);
            } else if (!"GetDomain".equals(str) && !"GetEmergencyInfo".equals(str) && !"GetHtmlOffline".equals(str)) {
                if ("GetCfgInfo".equals(str)) {
                    com.tencent.mobileqq.springhb.config.g gVar = (com.tencent.mobileqq.springhb.config.g) peekAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER);
                    if (gVar != null) {
                        entryConfigBean = gVar.n();
                    }
                    EIPCResult eIPCResult = new EIPCResult();
                    Bundle bundle2 = new Bundle();
                    if (entryConfigBean != null) {
                        bundle2.putInt("task_id", entryConfigBean.taskId);
                        bundle2.putInt("cfg_version", entryConfigBean.version);
                        bundle2.putSerializable("cfg_data", entryConfigBean);
                        eIPCResult.data = bundle2;
                    } else {
                        eIPCResult.data = bundle2;
                        eIPCResult.code = -102;
                    }
                    return eIPCResult;
                }
                if ("GetGameCenterPreloadDomain".equals(str)) {
                    i i16 = ((SpringHbPreloadManager) peekAppRuntime.getManager(QQManagerFactory.SPRING_HB_PRELOAD_MANAGER)).i();
                    List<IPreloadResource> i17 = i16.i();
                    List<SpringHbZipMappingBean> k3 = i16.k();
                    EIPCResult eIPCResult2 = new EIPCResult();
                    Bundle bundle3 = new Bundle();
                    if (i17 != null && k3 != null) {
                        bundle3.putSerializable("res_list", (Serializable) i17);
                        bundle3.putSerializable("mapping_list", (Serializable) k3);
                        eIPCResult2.data = bundle3;
                    } else {
                        eIPCResult2.data = bundle3;
                        eIPCResult2.code = -102;
                    }
                    return eIPCResult2;
                }
                if ("GetSpringHbPreloadDomain".equals(str)) {
                    i m3 = ((SpringHbPreloadManager) peekAppRuntime.getManager(QQManagerFactory.SPRING_HB_PRELOAD_MANAGER)).m();
                    List<IPreloadResource> i18 = m3.i();
                    List<SpringHbZipMappingBean> k16 = m3.k();
                    EIPCResult eIPCResult3 = new EIPCResult();
                    Bundle bundle4 = new Bundle();
                    if (i18 != null && k16 != null) {
                        bundle4.putSerializable("res_list", (Serializable) i18);
                        bundle4.putSerializable("mapping_list", (Serializable) k16);
                        eIPCResult3.data = bundle4;
                    } else {
                        eIPCResult3.data = bundle4;
                        eIPCResult3.code = -102;
                    }
                    return eIPCResult3;
                }
                if ("GetPreloadFilePath".equals(str)) {
                    String string = bundle.getString("url", "");
                    c cVar = (c) peekAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
                    if (cVar != null) {
                        str2 = cVar.a(string);
                    }
                    EIPCResult eIPCResult4 = new EIPCResult();
                    Bundle bundle5 = new Bundle();
                    if (!TextUtils.isEmpty(str2)) {
                        bundle5.putString("file_path", str2);
                        eIPCResult4.data = bundle5;
                    } else {
                        eIPCResult4.data = bundle5;
                        eIPCResult4.code = -102;
                    }
                    return eIPCResult4;
                }
                if ("removeEntryLoadingAnimationView".equals(str)) {
                    QLog.i("SpringHbIPCModule", 1, "webview ACTION_REMOVE_ENTRY_LOADING_ANIMATION_VIEW");
                    ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.springhb.entry.SpringHbIPCModule.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SpringHbIPCModule.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    }, 1000L);
                    return EIPCResult.createSuccessResult(new Bundle());
                }
                if ("getAllowPlayZplan".equals(str)) {
                    boolean isZPlanAccessible = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(2001L, peekAppRuntime.getLongAccountUin());
                    QLog.d("SpringHbIPCModule", 1, "getAllowPlayZplan, isZplan = " + isZPlanAccessible);
                    EIPCResult eIPCResult5 = new EIPCResult();
                    Bundle bundle6 = new Bundle();
                    bundle6.putBoolean("resultAllowPlayZplan", isZPlanAccessible);
                    eIPCResult5.data = bundle6;
                    return eIPCResult5;
                }
                if ("GetServerTime".equals(str)) {
                    return new EIPCResult();
                }
                if ("getIsVideoChatting".equals(str)) {
                    return b(peekAppRuntime);
                }
                if ("getAward".equals(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("SpringHbIPCModule", 2, "onCall ACTION_GET_AWARD = getAward");
                    }
                    com.tencent.mobileqq.springhb.entry.model.b L = ((SpringFestivalEntryManager) peekAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).L();
                    EIPCResult eIPCResult6 = new EIPCResult();
                    if (L != null) {
                        Bundle bundle7 = new Bundle();
                        bundle7.putInt("k_c_time", L.f289100d);
                        bundle7.putInt("key_mtime", L.f289105i);
                        bundle7.putInt("k_money", L.f289101e);
                        bundle7.putInt("key_award_type", L.f289099c);
                        bundle7.putInt("key_promotion_id", L.f289108l);
                        bundle7.putInt("key_business_id", L.f289102f);
                        bundle7.putInt("k_state", L.f289098b);
                        bundle7.putString("key_signature", L.f289103g);
                        bundle7.putString("key_req_id", L.f289109m);
                        bundle7.putString("k_pack_id", L.f289097a);
                        bundle7.putString("key_wishing", L.f289107k);
                        bundle7.putString("key_order", L.f289106j);
                        bundle7.putString("key_url", L.f289104h);
                        bundle7.putString("key_business_name", L.f289110n);
                        bundle7.putString("key_business_logo", L.f289111o);
                        bundle7.putString("key_business_cover", L.f289113q);
                        bundle7.putString("key_business_video", L.f289112p);
                        bundle7.putString("key_business_video_cover", L.f289114r);
                        eIPCResult6.data = bundle7;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("SpringHbIPCModule", 2, "onCall result.data = " + eIPCResult6.data.toString());
                    }
                    callbackResult(i3, eIPCResult6);
                } else if ("GetDragonCardConfig".equals(str)) {
                    DragonCardConfigData dragonCardConfigFromCache = ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).getDragonCardConfigFromCache(peekAppRuntime);
                    Bundle bundle8 = new Bundle(1);
                    if (dragonCardConfigFromCache != null) {
                        bundle8.putSerializable("resultDragonCardConfig", dragonCardConfigFromCache);
                        return EIPCResult.createSuccessResult(bundle8);
                    }
                    return EIPCResult.createResult(-102, bundle8);
                }
            }
        }
        return null;
    }
}
