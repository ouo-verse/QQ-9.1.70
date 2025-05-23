package com.tencent.mobileqq.leba.logic;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.ILebaUIStyleSettingApi;
import com.tencent.mobileqq.leba.core.CommPluginHandler;
import com.tencent.mobileqq.leba.core.LebaHelper;
import com.tencent.mobileqq.leba.core.b;
import com.tencent.mobileqq.leba.core.e;
import com.tencent.mobileqq.leba.core.f;
import com.tencent.mobileqq.leba.data.LebaUnitedConfigHelper;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.k;
import com.tencent.mobileqq.leba.entity.l;
import com.tencent.mobileqq.leba.entity.m;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.feed.d;
import com.tencent.mobileqq.leba.observer.a;
import com.tencent.mobileqq.leba.pb.UserSetDynamicPlugin$GetListRequest;
import com.tencent.mobileqq.leba.pb.UserSetDynamicPlugin$GetListResponse;
import com.tencent.mobileqq.leba.pb.UserSetDynamicPlugin$SetListRequest;
import com.tencent.mobileqq.leba.pb.UserSetDynamicPlugin$SetListResponse;
import com.tencent.mobileqq.leba.pb.UserSetDynamicPlugin$SetStyleReq;
import com.tencent.mobileqq.leba.pb.UserSetDynamicPlugin$SetStyleRsp;
import com.tencent.mobileqq.leba.utils.LebaMmkvUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* loaded from: classes15.dex */
public class LebaPluginLogic {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static a f240658a;

    /* renamed from: b, reason: collision with root package name */
    public static ConcurrentHashMap<Integer, AtomicBoolean> f240659b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21598);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f240659b = new ConcurrentHashMap<Integer, AtomicBoolean>() { // from class: com.tencent.mobileqq.leba.logic.LebaPluginLogic.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    put(0, new AtomicBoolean(true));
                    put(1, new AtomicBoolean(true));
                    put(2, new AtomicBoolean(true));
                }
            };
        }
    }

    public static void A(int i3, int i16) {
        f.E(MobileQQ.sMobileQQ.peekAppRuntime(), i3, i16);
    }

    public static void B(AppRuntime appRuntime, int i3, int i16) {
        if (appRuntime == null) {
            QLog.e("LebaPluginLogic", 1, "setPluginUserStyleSettingNet app == null");
            return;
        }
        if (i16 != 1 && i16 != 2) {
            QLog.e("LebaPluginLogic", 1, "setPluginUserStyleSettingNet leba style error value = " + i16);
            return;
        }
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", currentAccountUin, "trpc.qq_config.user_dynamic_plugin.UserDynamicPluginService.SetStyle");
        UserSetDynamicPlugin$SetStyleReq userSetDynamicPlugin$SetStyleReq = new UserSetDynamicPlugin$SetStyleReq();
        userSetDynamicPlugin$SetStyleReq.platform_type.set(1);
        userSetDynamicPlugin$SetStyleReq.plugin_type.set(b(i3));
        userSetDynamicPlugin$SetStyleReq.style.set(i16);
        toServiceMsg.putWupBuffer(userSetDynamicPlugin$SetStyleReq.toByteArray());
        toServiceMsg.extraData.putString("uin", currentAccountUin);
        toServiceMsg.extraData.putInt("key_current_model", i3);
        toServiceMsg.extraData.putInt("key_current_style", i16);
        toServiceMsg.setTimeout(5000L);
        ((CommPluginHandler) ((AppInterface) appRuntime).getBusinessHandler(com.tencent.mobileqq.leba.core.a.f240363a)).sendPbReq(toServiceMsg);
        QLog.i("LebaPluginLogic", 1, "setPluginUserStyleSettingNet currentModel=" + i3 + ",lebaStyle=" + i16);
    }

    public static m C(AppRuntime appRuntime, List<n> list) {
        m j3;
        if (list != null && !list.isEmpty()) {
            synchronized (list) {
                j3 = j(appRuntime, list, f(f.o(appRuntime)));
            }
            return j3;
        }
        return new m();
    }

    static String D(String str, long j3) {
        k b16 = k.b(str, "handleSetSuccess");
        b16.f240497b = j3;
        return k.d(b16, "updateSequence");
    }

    public static void a(a aVar) {
        f240658a = aVar;
    }

    public static int b(int i3) {
        if (i3 == 1) {
            return 3;
        }
        if (i3 != 2) {
            return 1;
        }
        return 2;
    }

    public static int c(int i3) {
        if (i3 == 1) {
            return 3;
        }
        if (i3 == 2) {
            return 5;
        }
        return 4;
    }

    public static LebaHelper d(AppRuntime appRuntime, String str) {
        if (appRuntime == null) {
            QLog.i("LebaPluginLogic", 1, "getLebaHelper isEmpty appInterface = null");
            return null;
        }
        Object lebaHelper = ((ILebaHelperService) appRuntime.getRuntimeService(ILebaHelperService.class, "")).getLebaHelper();
        if (lebaHelper == null) {
            QLog.i("LebaPluginLogic", 1, "getLebaHelper isEmpty method = " + str);
            return null;
        }
        return (LebaHelper) lebaHelper;
    }

    public static int e() {
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return 1;
        }
        if (QQTheme.isNowSimpleUI()) {
            return 2;
        }
        return 0;
    }

    public static int f(int i3) {
        if (i3 == 4032) {
            return 1;
        }
        if (i3 == 4033) {
            return 2;
        }
        return 0;
    }

    public static k g(AppRuntime appRuntime, int i3) {
        k kVar = new k();
        String str = null;
        try {
            String str2 = "sp_key_dynamic_user_set_info";
            if (!LebaHelper.c(i3)) {
                str2 = "sp_key_dynamic_user_set_info" + i3;
            }
            str = LebaMmkvUtils.f240764a.g(appRuntime, str2, "");
            return k.b(str, "getFromLocal");
        } catch (Exception e16) {
            QLog.i("LebaPluginLogic", 1, "getPluginSettingLocal " + str, e16);
            return kVar;
        }
    }

    public static void h(AppRuntime appRuntime) {
        if (appRuntime == null) {
            QLog.i("LebaPluginLogic", 1, "getPluginSettingNet app == null");
            return;
        }
        int e16 = e();
        k g16 = g(appRuntime, e16);
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        LebaHelper.a d16 = LebaHelper.d();
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", currentAccountUin, "trpc.qq_config.user_dynamic_plugin.UserDynamicPluginService.GetList");
        UserSetDynamicPlugin$GetListRequest userSetDynamicPlugin$GetListRequest = new UserSetDynamicPlugin$GetListRequest();
        userSetDynamicPlugin$GetListRequest.platform_type.set(1);
        if (d16.f240358a) {
            userSetDynamicPlugin$GetListRequest.plugin_type.set(c(e16));
        } else {
            userSetDynamicPlugin$GetListRequest.plugin_type.set(b(e16));
        }
        userSetDynamicPlugin$GetListRequest.sequence.set(g16.f240497b);
        toServiceMsg.putWupBuffer(userSetDynamicPlugin$GetListRequest.toByteArray());
        toServiceMsg.extraData.putString("uin", currentAccountUin);
        toServiceMsg.extraData.putInt("key_current_model", e16);
        ((CommPluginHandler) ((AppInterface) appRuntime).getBusinessHandler(com.tencent.mobileqq.leba.core.a.f240363a)).sendPbReq(toServiceMsg);
        QLog.i("LebaPluginLogic", 1, "getPluginSettingNet currentModel=" + e16 + ",sequence=" + g16.f240497b);
        e.f240372e = e.f240372e | 8;
    }

    public static int i() {
        int e16 = e();
        if (e16 == 1) {
            return 4032;
        }
        if (e16 == 2) {
            return 4033;
        }
        return 4034;
    }

    public static m j(AppRuntime appRuntime, List<n> list, int i3) {
        int i16;
        int i17;
        if (list != null && !list.isEmpty()) {
            k g16 = g(appRuntime, i3);
            int n3 = n(appRuntime, i3);
            if (((ILebaUIStyleSettingApi) QRoute.api(ILebaUIStyleSettingApi.class)).checkModeSupportQzoneFrame() && d.a()) {
                i16 = 4;
                i17 = 9;
            } else {
                i16 = n3;
                i17 = i16;
            }
            if (g16 != null && g16.f() > 0) {
                return m(list, g16.g(), n3, i17);
            }
            return l(list, i16);
        }
        return new m();
    }

    public static m k(AppRuntime appRuntime, List<n> list, int i3, boolean z16) {
        int n3;
        int i16;
        int i17;
        if (list != null && !list.isEmpty()) {
            k g16 = g(appRuntime, i3);
            if (z16) {
                n3 = p();
            } else {
                n3 = n(appRuntime, i3);
            }
            if (z16) {
                i16 = 4;
                i17 = 9;
            } else {
                i16 = n3;
                i17 = i16;
            }
            if (g16 != null && g16.f() > 0) {
                return m(list, g16.g(), n3, i17);
            }
            return l(list, i16);
        }
        return new m();
    }

    protected static m l(List<n> list, int i3) {
        m mVar = new m();
        for (n nVar : list) {
            if (!nVar.f240505b.cShow && nVar.c()) {
                mVar.b(nVar);
            } else {
                mVar.a(nVar, i3);
            }
        }
        return mVar;
    }

    protected static m m(List<n> list, List<l> list2, int i3, int i16) {
        LebaPluginInfo lebaPluginInfo;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (l lVar : list2) {
            if (lVar != null) {
                if (lVar.a()) {
                    hashSet.add(Long.valueOf(lVar.f240499a));
                } else {
                    hashSet2.add(Long.valueOf(lVar.f240499a));
                }
            }
        }
        m mVar = new m();
        for (int i17 = 0; i17 < list.size(); i17++) {
            n nVar = list.get(i17);
            if (nVar != null && (lebaPluginInfo = nVar.f240505b) != null) {
                if (hashSet2.contains(Long.valueOf(lebaPluginInfo.uiResId)) && nVar.c()) {
                    mVar.b(nVar);
                } else if (!hashSet.contains(Long.valueOf(nVar.f240505b.uiResId)) && nVar.c()) {
                    if (hashSet2.contains(Long.valueOf(nVar.f240504a))) {
                        mVar.b(nVar);
                    } else if (i17 < i16 && nVar.f240505b.getShow()) {
                        mVar.a(nVar, i3);
                    } else {
                        mVar.b(nVar);
                    }
                } else {
                    mVar.a(nVar, i3);
                }
            }
        }
        return mVar;
    }

    public static int n(AppRuntime appRuntime, int i3) {
        StringBuilder sb5 = new StringBuilder("getShowNormalPluginMaxSize model=");
        sb5.append(i3);
        if (((ILebaUIStyleSettingApi) QRoute.api(ILebaUIStyleSettingApi.class)).checkModeSupportQzoneFrame() && d.a()) {
            sb5.append(",isShowQzoneFrame");
            QLog.i("LebaPluginLogic", 1, sb5.toString());
            return p();
        }
        int o16 = o(appRuntime, i3);
        sb5.append(",showPluginSize=");
        sb5.append(o16);
        QLog.i("LebaPluginLogic", 1, sb5.toString());
        return o16;
    }

    public static int o(AppRuntime appRuntime, int i3) {
        int i16;
        int i17 = 23;
        try {
            i16 = LebaMmkvUtils.f240764a.e(appRuntime, "sp_key_max_show_plugin_size" + i3, 23);
        } catch (Exception e16) {
            QLog.i("LebaPluginLogic", 1, "getTotalPluginMaxSize", e16);
            i16 = 0;
        }
        if (i16 > 0) {
            i17 = i16;
        }
        QLog.i("LebaPluginLogic", 1, "getTotalPluginMaxSize model=" + i3 + ",totalPluginMaxSize=" + i17);
        return i17;
    }

    public static int p() {
        return 9;
    }

    public static void q(AppRuntime appRuntime, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        UserSetDynamicPlugin$GetListResponse userSetDynamicPlugin$GetListResponse = new UserSetDynamicPlugin$GetListResponse();
        StringBuilder sb5 = new StringBuilder("handleGetPluginSetting ");
        boolean z17 = false;
        if (fromServiceMsg != null && toServiceMsg != null) {
            if (fromServiceMsg.isSuccess()) {
                try {
                    userSetDynamicPlugin$GetListResponse = userSetDynamicPlugin$GetListResponse.mergeFrom((byte[]) obj);
                } catch (Exception e16) {
                    QLog.i("LebaPluginLogic", 1, "handleGetPluginSetting", e16);
                }
                if (userSetDynamicPlugin$GetListResponse.reson_code.get() == 0 && userSetDynamicPlugin$GetListResponse.sequence.get() != 0) {
                    z17 = true;
                }
                sb5.append(",resonCode=");
                sb5.append(userSetDynamicPlugin$GetListResponse.reson_code.get());
                sb5.append(",sequence=");
                sb5.append(userSetDynamicPlugin$GetListResponse.sequence.get());
                sb5.append(",maxDynamicNum=");
                sb5.append(userSetDynamicPlugin$GetListResponse.max_dynamic_num.get());
            } else {
                sb5.append(",resultCode=");
                sb5.append(fromServiceMsg.getResultCode());
                sb5.append(",RequestSsoSeq=");
                sb5.append(fromServiceMsg.getRequestSsoSeq());
            }
            sb5.append(",isSuc=");
            sb5.append(z17);
            if (z17) {
                r(appRuntime, toServiceMsg, userSetDynamicPlugin$GetListResponse);
            }
            w(appRuntime, toServiceMsg, userSetDynamicPlugin$GetListResponse);
            if (LebaUnitedConfigHelper.d()) {
                b.c(6, "user setting server data update");
            } else {
                e.a().h(appRuntime);
            }
            LebaHelper d16 = d(appRuntime, "handleGetPluginSetting");
            if (d16 != null) {
                d16.A(z17);
            }
            s(appRuntime, toServiceMsg, userSetDynamicPlugin$GetListResponse);
            QLog.i("LebaPluginLogic", 1, sb5.toString());
            return;
        }
        sb5.append("res=null? ");
        if (fromServiceMsg == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(", ");
        sb5.append("req=null? ");
        if (toServiceMsg == null) {
            z17 = true;
        }
        sb5.append(z17);
        QLog.e("LebaPluginLogic", 1, sb5.toString());
    }

    public static void r(AppRuntime appRuntime, ToServiceMsg toServiceMsg, UserSetDynamicPlugin$GetListResponse userSetDynamicPlugin$GetListResponse) {
        int i3 = toServiceMsg.extraData.getInt("key_current_model", -1);
        if (i3 == -1) {
            QLog.i("LebaPluginLogic", 1, "handleGetPluginSettingSucc error model=" + i3);
            return;
        }
        if (userSetDynamicPlugin$GetListResponse.sequence.get() != 0 && userSetDynamicPlugin$GetListResponse.plugin_data.size() > 0) {
            y(appRuntime, k.d(k.c(userSetDynamicPlugin$GetListResponse.plugin_data.get(), userSetDynamicPlugin$GetListResponse.sequence.get()), "getFromServer"), i3);
        }
        QLog.i("LebaPluginLogic", 1, "handleGetPluginSettingSucc, model=" + i3 + ", sequence=" + userSetDynamicPlugin$GetListResponse.sequence.get() + ", size=" + userSetDynamicPlugin$GetListResponse.plugin_data.size());
    }

    private static void s(AppRuntime appRuntime, ToServiceMsg toServiceMsg, UserSetDynamicPlugin$GetListResponse userSetDynamicPlugin$GetListResponse) {
        if (userSetDynamicPlugin$GetListResponse.style.has()) {
            int i3 = userSetDynamicPlugin$GetListResponse.style.get();
            int i16 = toServiceMsg.extraData.getInt("key_current_model");
            int p16 = f.p(appRuntime, i16);
            AtomicBoolean atomicBoolean = f240659b.get(Integer.valueOf(i16));
            if (atomicBoolean != null) {
                boolean z16 = false;
                if (atomicBoolean.compareAndSet(true, false)) {
                    if (p16 != i3) {
                        z16 = true;
                    }
                    QLog.i("LebaPluginLogic", 1, "handleGetUserStyleSetting model= " + i16 + " ,style= " + i3 + " ,hasChange= " + z16);
                    if (z16) {
                        A(i16, i3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        QLog.i("LebaPluginLogic", 2, "handleGetUserStyleSetting has style: false");
    }

    public static void t(AppRuntime appRuntime, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        UserSetDynamicPlugin$SetListResponse userSetDynamicPlugin$SetListResponse = new UserSetDynamicPlugin$SetListResponse();
        StringBuilder sb5 = new StringBuilder("handleSetPluginSetting ");
        boolean z16 = false;
        if (fromServiceMsg != null && obj != null) {
            if (!fromServiceMsg.isSuccess()) {
                sb5.append(",resultCode=");
                sb5.append(fromServiceMsg.getResultCode());
                sb5.append(",RequestSsoSeq=");
                sb5.append(fromServiceMsg.getRequestSsoSeq());
            } else {
                try {
                    userSetDynamicPlugin$SetListResponse = userSetDynamicPlugin$SetListResponse.mergeFrom((byte[]) obj);
                } catch (Exception e16) {
                    QLog.i("LebaPluginLogic", 1, "handleSetPluginSetting", e16);
                }
                if (userSetDynamicPlugin$SetListResponse.reson_code.get() == 0) {
                    z16 = true;
                }
                sb5.append("rsp.reson_code=");
                sb5.append(userSetDynamicPlugin$SetListResponse.reson_code.get());
            }
        } else {
            sb5.append("res == null || data == null ");
        }
        sb5.append(",isSuc=");
        sb5.append(z16);
        if (z16) {
            u(appRuntime, toServiceMsg, userSetDynamicPlugin$SetListResponse.sequence.get());
            ((ILebaHelperService) appRuntime.getRuntimeService(ILebaHelperService.class, ProcessConstant.MULTI)).notifyPluginListChanged();
            b.c(6, "setUserPluginSetting success");
        }
        a aVar = f240658a;
        if (aVar != null) {
            aVar.b(z16, true);
        }
        QLog.i("LebaPluginLogic", 1, sb5.toString());
    }

    public static void u(AppRuntime appRuntime, ToServiceMsg toServiceMsg, long j3) {
        int i3 = toServiceMsg.extraData.getInt("key_current_model", -1);
        String D = D(toServiceMsg.extraData.getString("key_setting_json"), j3);
        if (i3 != -1 && !TextUtils.isEmpty(D)) {
            y(appRuntime, D, i3);
        }
        QLog.i("LebaPluginLogic", 1, "handleSetPluginSettingSucc model=" + i3 + ",sequence=" + j3 + ",json=" + D);
    }

    public static void v(AppInterface appInterface, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        UserSetDynamicPlugin$SetStyleRsp userSetDynamicPlugin$SetStyleRsp = new UserSetDynamicPlugin$SetStyleRsp();
        StringBuilder sb5 = new StringBuilder("handleSetPluginUserStyleSetting ");
        boolean z16 = false;
        if (fromServiceMsg != null && obj != null && toServiceMsg != null) {
            if (!fromServiceMsg.isSuccess()) {
                sb5.append(",resultCode=");
                sb5.append(fromServiceMsg.getResultCode());
                sb5.append(",RequestSsoSeq=");
                sb5.append(fromServiceMsg.getRequestSsoSeq());
            } else {
                try {
                    userSetDynamicPlugin$SetStyleRsp = userSetDynamicPlugin$SetStyleRsp.mergeFrom((byte[]) obj);
                } catch (Exception e16) {
                    QLog.i("LebaPluginLogic", 1, "handleSetPluginUserStyleSetting", e16);
                }
                if (userSetDynamicPlugin$SetStyleRsp.reson_code.get() == 0) {
                    z16 = true;
                }
                sb5.append(",resonCode=");
                sb5.append(userSetDynamicPlugin$SetStyleRsp.reson_code.get());
            }
        } else {
            sb5.append("res == null || data == null || req == null");
        }
        sb5.append(",isSuc=");
        sb5.append(z16);
        if (z16) {
            int i3 = userSetDynamicPlugin$SetStyleRsp.style.get();
            sb5.append(",style=");
            sb5.append(i3);
        }
        QLog.i("LebaPluginLogic", 1, sb5.toString());
    }

    public static void w(AppRuntime appRuntime, ToServiceMsg toServiceMsg, UserSetDynamicPlugin$GetListResponse userSetDynamicPlugin$GetListResponse) {
        int i3 = toServiceMsg.extraData.getInt("key_current_model", -1);
        if (i3 == -1) {
            QLog.i("LebaPluginLogic", 1, "handleTotalPluginMaxSize model error model=" + i3);
            return;
        }
        int i16 = userSetDynamicPlugin$GetListResponse.max_dynamic_num.get();
        if (i16 <= 0) {
            QLog.i("LebaPluginLogic", 1, "handleTotalPluginMaxSize maxDynamicNum error model=" + i3 + ",maxDynamicNum=" + i16);
            return;
        }
        QLog.i("LebaPluginLogic", 1, "handleTotalPluginMaxSize model=" + i3 + ",maxDynamicNum=" + i16);
        try {
            LebaMmkvUtils.f240764a.i("sp_key_max_show_plugin_size" + i3, i16);
        } catch (Exception e16) {
            QLog.i("LebaPluginLogic", 1, "saveTotalPluginMaxSize model=", e16);
        }
    }

    public static void x(a aVar) {
        if (f240658a == aVar) {
            f240658a = null;
        } else {
            QLog.e("LebaPluginLogic", 1, "removeObserver observer not same object");
        }
    }

    public static void y(AppRuntime appRuntime, String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String str2 = "sp_key_dynamic_user_set_info";
            if (!LebaHelper.c(i3)) {
                str2 = "sp_key_dynamic_user_set_info" + i3;
            }
            LebaMmkvUtils.f240764a.j(str2, str);
        } catch (Exception e16) {
            QLog.i("LebaPluginLogic", 1, "setPluginSettingLocal", e16);
        }
    }

    public static void z(AppRuntime appRuntime, int i3, k kVar) {
        if (appRuntime == null) {
            QLog.i("LebaPluginLogic", 1, "setPluginSettingNet app == null");
            return;
        }
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        LebaHelper.a d16 = LebaHelper.d();
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", currentAccountUin, "trpc.qq_config.user_dynamic_plugin.UserDynamicPluginService.SetList");
        UserSetDynamicPlugin$SetListRequest userSetDynamicPlugin$SetListRequest = new UserSetDynamicPlugin$SetListRequest();
        userSetDynamicPlugin$SetListRequest.platform_type.set(1);
        if (d16.f240358a) {
            userSetDynamicPlugin$SetListRequest.plugin_type.set(c(i3));
        } else {
            userSetDynamicPlugin$SetListRequest.plugin_type.set(b(i3));
        }
        userSetDynamicPlugin$SetListRequest.plugin_data.addAll(k.e(kVar));
        if (QLog.isDevelopLevel()) {
            kVar.i("setToServer");
        }
        toServiceMsg.putWupBuffer(userSetDynamicPlugin$SetListRequest.toByteArray());
        toServiceMsg.extraData.putString("uin", currentAccountUin);
        toServiceMsg.extraData.putInt("key_current_model", i3);
        String d17 = k.d(kVar, "setToServer");
        toServiceMsg.extraData.putString("key_setting_json", d17);
        toServiceMsg.setTimeout(5000L);
        ((CommPluginHandler) ((AppInterface) appRuntime).getBusinessHandler(com.tencent.mobileqq.leba.core.a.f240363a)).sendPbReq(toServiceMsg);
        QLog.i("LebaPluginLogic", 1, "setPluginSettingNet currentModel=" + i3 + ",settingJson=" + d17);
    }
}
