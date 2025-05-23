package com.tencent.mobileqq.ecshop;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.ecshop.api.QQShopModule;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopOtherApi;
import com.tencent.mobileqq.ecshop.utils.c;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f203933d;

    public a(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static a b() {
        if (f203933d == null) {
            synchronized (a.class) {
                if (f203933d == null) {
                    f203933d = new a("EcshopIPCModule");
                }
            }
        }
        return f203933d;
    }

    private boolean c(BaseQQAppInterface baseQQAppInterface, String str) {
        RecentUserProxy recentUserCache = ((IRecentUserProxyService) baseQQAppInterface.getRuntimeService(IRecentUserProxyService.class)).getRecentUserCache();
        int uinType = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getUinType(baseQQAppInterface, str);
        RecentUser findRecentUser = recentUserCache.findRecentUser(str, uinType);
        if (findRecentUser == null) {
            QLog.d("EcshopIPCModule", 1, "isPublicAccountMsgTabSetTop pUin = " + str + " userType = " + uinType + " not in the msg list");
            findRecentUser = new RecentUser(str, uinType);
        }
        if (findRecentUser.showUpTime != 0) {
            return true;
        }
        return false;
    }

    private int d(BaseQQAppInterface baseQQAppInterface, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("EcshopIPCModule", 1, "ActionSheet setOrCancelSetTop");
        }
        int uinType = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getUinType(baseQQAppInterface, str);
        if (uinType == 1024) {
            QLog.d("EcshopIPCModule", 1, "setOrCancelTop pUin = " + str + " userType = " + uinType + " is UIN_TYPE_BUSINESS_CMR_TMP");
        }
        RecentUserProxy recentUserCache = ((IRecentUserProxyService) baseQQAppInterface.getRuntimeService(IRecentUserProxyService.class)).getRecentUserCache();
        RecentUser findRecentUser = recentUserCache.findRecentUser(str, uinType);
        if (findRecentUser == null) {
            QLog.d("EcshopIPCModule", 1, "setOrCancelTop pUin = " + str + " userType = " + uinType + " not in the msg list");
            findRecentUser = new RecentUser(str, uinType);
        }
        if (c(baseQQAppInterface, str)) {
            findRecentUser.showUpTime = 0L;
        } else {
            findRecentUser.showUpTime = System.currentTimeMillis() / 1000;
        }
        recentUserCache.saveRecentUser(findRecentUser);
        ((IEcshopOtherApi) QRoute.api(IEcshopOtherApi.class)).updateRecentList(baseQQAppInterface);
        return 0;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        AppRuntime a16;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        try {
            a16 = com.tencent.mobileqq.ecshop.utils.a.a();
        } catch (Throwable th5) {
            QLog.e("EcshopIPCModule", 1, th5, new Object[0]);
        }
        if (!(a16 instanceof BaseQQAppInterface)) {
            return null;
        }
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) a16;
        if ("reportToBeacon".equals(str)) {
            com.tencent.mobileqq.qqshop.report.beacon.b.f274709a.c(bundle.getString("key_report_event"), (HashMap) bundle.getSerializable("key_report_params"));
        } else if ("setPublicAccountTop".equals(str)) {
            int i17 = bundle.getInt("isTop");
            boolean c16 = c(baseQQAppInterface, IPublicAccountUtil.UIN_FOR_SHOP);
            com.tencent.mobileqq.qqshop.report.a.f274706a.d(String.valueOf(i17));
            if (i17 == 1) {
                if (!c16) {
                    return EIPCResult.createResult(d(baseQQAppInterface, IPublicAccountUtil.UIN_FOR_SHOP), null);
                }
                return EIPCResult.createResult(0, null);
            }
            if (i17 == 0) {
                if (!c16) {
                    return EIPCResult.createResult(0, null);
                }
                return EIPCResult.createResult(d(baseQQAppInterface, IPublicAccountUtil.UIN_FOR_SHOP), null);
            }
        } else {
            if ("queryPublicAccountTop".equals(str)) {
                if (c(baseQQAppInterface, IPublicAccountUtil.UIN_FOR_SHOP)) {
                    i16 = 1;
                } else {
                    i16 = 0;
                }
                return EIPCResult.createResult(i16, null);
            }
            if ("startQQShopPublicAccount".equals(str)) {
                boolean a17 = c.f203952a.a();
                int i18 = bundle.getInt("shouldOpenCard");
                String string = bundle.getString("qggExt");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                if (!a17 && i18 != 0) {
                    ActivityURIRequest activityURIRequest = new ActivityURIRequest(BaseApplication.getContext(), IPublicAccountDetailActivity.ROUTE_NAME);
                    activityURIRequest.extra().putString("uin", IPublicAccountUtil.UIN_FOR_SHOP);
                    activityURIRequest.extra().putInt("source", 5);
                    QRoute.startUri(activityURIRequest, (o) null);
                    return EIPCResult.createResult(0, null);
                }
                QQShopModule.f203940a.j(BaseApplication.getContext(), 6, false, string);
                return EIPCResult.createResult(0, null);
            }
        }
        return null;
    }
}
