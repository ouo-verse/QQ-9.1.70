package com.tencent.mobileqq.leba.feed.impl;

import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.core.f;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.feed.ILebaPluginFeedApi;
import com.tencent.mobileqq.leba.feed.c;
import com.tencent.mobileqq.leba.feed.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

/* loaded from: classes15.dex */
public class LebaPluginFeedApiImpl implements ILebaPluginFeedApi {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "LebaPluginFeedApiImpl";

    public LebaPluginFeedApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.leba.feed.ILebaPluginFeedApi
    public c getLebaPluginFeedController(Context context, AppRuntime appRuntime, QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, this, context, appRuntime, qBaseActivity);
        }
        return new a(context, appRuntime, qBaseActivity);
    }

    @Override // com.tencent.mobileqq.leba.feed.ILebaPluginFeedApi
    public Set<Long> getLebaShowPluginPaths(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
        }
        ILebaHelperService iLebaHelperService = (ILebaHelperService) appRuntime.getRuntimeService(ILebaHelperService.class, "");
        HashSet hashSet = new HashSet();
        List<n> lebaShowList = iLebaHelperService.getLebaShowList();
        if (lebaShowList != null && !lebaShowList.isEmpty()) {
            for (n nVar : lebaShowList) {
                if (nVar != null && nVar.f240505b != null) {
                    hashSet.add(Long.valueOf(nVar.f240504a));
                }
            }
        }
        return hashSet;
    }

    @Override // com.tencent.mobileqq.leba.feed.ILebaPluginFeedApi
    public boolean isNeedShowPluginInTab(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime)).booleanValue();
        }
        boolean z16 = false;
        if (!d.a()) {
            QLog.i(TAG, 1, "isNeedShowPluginInTab no isShowQzoneFrame");
            return false;
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT);
        if (expEntity != null && expEntity.isExperiment(QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT_B)) {
            ILebaHelperService iLebaHelperService = (ILebaHelperService) appRuntime.getRuntimeService(ILebaHelperService.class, "");
            HashSet hashSet = new HashSet();
            List<n> lebaShowList = iLebaHelperService.getLebaShowList();
            if (lebaShowList != null && !lebaShowList.isEmpty()) {
                for (n nVar : lebaShowList) {
                    if (nVar != null && nVar.f240505b != null) {
                        hashSet.add(Long.valueOf(nVar.f240504a));
                    }
                }
                List<BusinessInfoCheckUpdate.AppInfo> requestAppInfoListByAppSet = ((IRedTouchManager) appRuntime.getRuntimeService(IRedTouchManager.class, "")).requestAppInfoListByAppSet(0);
                if (requestAppInfoListByAppSet != null && !requestAppInfoListByAppSet.isEmpty()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("isNeedShowPluginInTab");
                    int i3 = 0;
                    while (true) {
                        if (i3 >= requestAppInfoListByAppSet.size()) {
                            break;
                        }
                        BusinessInfoCheckUpdate.AppInfo appInfo = requestAppInfoListByAppSet.get(i3);
                        if (appInfo == null) {
                            sb5.append(",appInfo == null");
                        } else {
                            int i16 = appInfo.uiAppId.get();
                            sb5.append(",path=");
                            sb5.append(appInfo.path.get());
                            sb5.append(",uiAppId=");
                            sb5.append(i16);
                            if (appInfo.mission_level.get() != 0) {
                                sb5.append(",mission_level=");
                                sb5.append(appInfo.mission_level.get());
                            } else if (appInfo.iNewFlag.get() == 1 && appInfo.exposure_max.get() > 0) {
                                if (!iLebaHelperService.needShowRedDot(appRuntime, appInfo.uiAppId.get(), hashSet)) {
                                    sb5.append(",!needShowRedDot");
                                } else {
                                    if (1130 != i16 && 100510 != i16) {
                                        z16 = true;
                                        break;
                                    }
                                    sb5.append(", biz ");
                                }
                            } else {
                                sb5.append(",isNewFlag=");
                                sb5.append(appInfo.iNewFlag.get());
                                sb5.append(",exposure_max=");
                                sb5.append(appInfo.exposure_max.get());
                            }
                        }
                        i3++;
                    }
                    sb5.append(",isShowRedPoint=");
                    sb5.append(z16);
                    QLog.i(TAG, 1, sb5.toString());
                    return z16;
                }
                QLog.i(TAG, 1, "isNeedShowPluginInTab appInfoList empty");
                return false;
            }
            QLog.i(TAG, 1, "isNeedShowPluginInTab lebaPluginList empty");
            return false;
        }
        QLog.i(TAG, 1, "isNeedShowPluginInTab no exp_shouq_dongtai_jianjie_B");
        return false;
    }

    @Override // com.tencent.mobileqq.leba.feed.ILebaPluginFeedApi
    public boolean needShowRedDot(AppRuntime appRuntime, long j3, Set<Long> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, appRuntime, Long.valueOf(j3), set)).booleanValue();
        }
        return f.v(appRuntime, j3, set);
    }
}
