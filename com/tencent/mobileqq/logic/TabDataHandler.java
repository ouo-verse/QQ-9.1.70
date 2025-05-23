package com.tencent.mobileqq.logic;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.e;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.j;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.l;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.UserDynamicTab;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes15.dex */
public class TabDataHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    protected static final String[] f241772h;

    /* renamed from: d, reason: collision with root package name */
    protected AppInterface f241773d;

    /* renamed from: e, reason: collision with root package name */
    private e f241774e;

    /* renamed from: f, reason: collision with root package name */
    private LoadTabDataRunnable f241775f;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class LoadTabDataRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<TabDataHandler> f241776d;

        public LoadTabDataRunnable(TabDataHandler tabDataHandler) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) tabDataHandler);
            } else {
                this.f241776d = new WeakReference<>(tabDataHandler);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            TabDataHandler tabDataHandler = this.f241776d.get();
            if (tabDataHandler == null) {
                QLog.i("FrameUtil.TabDataHandler", 1, "LoadTabDataRunnable handler is null");
                return;
            }
            AppInterface appInterface = tabDataHandler.f241773d;
            if (appInterface == null) {
                QLog.i("FrameUtil.TabDataHandler", 1, "LoadTabDataRunnable app is null");
                return;
            }
            QLog.i("FrameUtil.TabDataHandler", 1, "loadTabData");
            Map<String, Boolean> tabLocalSwitch = TabDataHelper.getTabLocalSwitch(BaseApplication.getContext(), appInterface.getCurrentAccountUin());
            if (tabLocalSwitch != null && !tabLocalSwitch.isEmpty()) {
                tabDataHandler.M2(tabLocalSwitch, true);
            } else {
                tabDataHandler.D2(true);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43644);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            f241772h = new String[]{TabDataHandler.class.getName()};
        }
    }

    protected TabDataHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f241773d = appInterface;
        try {
            this.f241774e = l.f182354a.get(0).newInstance();
        } catch (Exception e16) {
            QLog.i("FrameUtil.TabDataHandler", 1, "TabDataUtil init e:" + e16);
        }
    }

    private void F2(ToServiceMsg toServiceMsg, UserDynamicTab.GetTabListResponse getTabListResponse) {
        int i3;
        int i16;
        String string = toServiceMsg.extraData.getString("uin", "");
        if (TextUtils.isEmpty(string)) {
            QLog.i("FrameUtil.TabDataHandler", 1, "handleGetTabListSucc error uin isEmpty");
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        if (getTabListResponse.model_rule.size() > 0) {
            TabDataHelper.updateTabRuleList(context, string, getTabListResponse.model_rule.get());
        }
        if (getTabListResponse.sequence.get() != 0) {
            if (getTabListResponse.tab_data.size() > 0) {
                TabDataHelper.updateTabSwitchFull(context, string, getTabListResponse.tab_data.get());
            }
            TabDataHelper.updateSequence(context, string, getTabListResponse.sequence.get());
        }
        if (getTabListResponse.entrance.has()) {
            if (getTabListResponse.entrance.init_tab.has()) {
                i3 = getTabListResponse.entrance.init_tab.get();
            } else {
                i3 = 0;
            }
            TabDataHelper.updateTabInit(context, string, i3);
            if (getTabListResponse.entrance.real_init_tab.has()) {
                i16 = getTabListResponse.entrance.real_init_tab.get();
            } else {
                i16 = 0;
            }
            TabDataHelper.updateRealTabInit(context, string, i16);
            j.f(getTabListResponse.entrance.init_tab.get(), getTabListResponse.entrance.real_init_tab.get());
        }
        TabDataHelper.updateRIJAndQCircleMutual(this.f241773d, string, context);
        boolean booleanValue = ((Boolean) toServiceMsg.getAttribute("KeyNeedUIRefresh", Boolean.FALSE)).booleanValue();
        QLog.i("FrameUtil.TabDataHandler", 1, "handleGetTabListSucc needUIRefresh: " + booleanValue);
        if (booleanValue) {
            notifyUI(0, true, null);
        }
        TabDataHelper.reportTabStatus(1);
    }

    private void G2(AppRuntime appRuntime, ToServiceMsg toServiceMsg, UserDynamicTab.SetTabListResponse setTabListResponse, boolean z16) {
        int i3;
        if (appRuntime == null) {
            QLog.i("FrameUtil.TabDataHandler", 1, "handleSetTabList app == null");
            return;
        }
        String string = toServiceMsg.extraData.getString("uin", "");
        boolean z17 = toServiceMsg.extraData.getBoolean("KeyRetry", false);
        ArrayList<String> stringArrayList = toServiceMsg.extraData.getStringArrayList("KeyRetryTabList");
        if (!TextUtils.isEmpty(string) && stringArrayList != null && !stringArrayList.isEmpty()) {
            BaseApplication context = BaseApplication.getContext();
            if (z16) {
                HashMap hashMap = new HashMap();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (toServiceMsg.extraData.getBoolean(next, false)) {
                        i3 = 2;
                    } else {
                        i3 = 3;
                    }
                    hashMap.put(next, Integer.valueOf(i3));
                }
                TabDataHelper.updateTabSwitchIncremental(context, string, hashMap);
                TabDataHelper.clearTabLocalSwitch(context, string, stringArrayList);
            } else if (setTabListResponse.reson_code.get() == 20009) {
                TabDataHelper.clearTabLocalSwitch(context, string, stringArrayList);
            }
            if (z17) {
                D2(true);
                return;
            }
            return;
        }
        QLog.i("FrameUtil.TabDataHandler", 1, "handleSetTabList error");
    }

    private void J2(UserDynamicTab.GetTabListResponse getTabListResponse, StringBuilder sb5) {
        if (!getTabListResponse.entrance.has()) {
            sb5.append(",entrance=null");
            return;
        }
        if (getTabListResponse.entrance.init_tab.has()) {
            sb5.append(",init_tab=");
            sb5.append(getTabListResponse.entrance.init_tab.get());
        } else {
            sb5.append(",init_tab=null");
        }
        if (getTabListResponse.entrance.real_init_tab.has()) {
            sb5.append(",real_init_tab=");
            sb5.append(getTabListResponse.entrance.real_init_tab.get());
        } else {
            sb5.append(",real_init_tab=null");
        }
    }

    public void D2(boolean z16) {
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        AppInterface appInterface = this.f241773d;
        if (appInterface == null) {
            QLog.i("FrameUtil.TabDataHandler", 1, "getPluginSettingNet app == null");
            return;
        }
        String currentAccountUin = appInterface.getCurrentAccountUin();
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", currentAccountUin, "trpc.qq_tab.user_dynamic_tab.UserDynamicTab.GetTabList");
        UserDynamicTab.GetTabListRequest getTabListRequest = new UserDynamicTab.GetTabListRequest();
        long sequence = TabDataHelper.getSequence(BaseApplication.getContext(), currentAccountUin);
        getTabListRequest.sequence.set(sequence);
        StringBuilder sb5 = new StringBuilder("getTabListNet uin=");
        sb5.append(StringUtil.getSimpleUinForPrint(currentAccountUin));
        sb5.append(",sequence=");
        sb5.append(sequence);
        e eVar = this.f241774e;
        if (eVar != null) {
            if (com.tencent.mobileqq.automator.a.f199910a) {
                i3 = 0;
            } else {
                i3 = 2;
            }
            String e16 = eVar.e();
            sb5.append(",kanDianStatus=");
            sb5.append(i3);
            sb5.append(",qua=");
            if (e16 == null) {
                str = "null";
            } else {
                str = e16;
            }
            sb5.append(str);
            UserDynamicTab.TabData tabData = new UserDynamicTab.TabData();
            tabData.tab_id.set(3);
            tabData.tab_status.set(i3);
            getTabListRequest.kandian_data.set(tabData);
            if (e16 != null) {
                getTabListRequest.qua.set(e16);
            }
        }
        try {
            toServiceMsg.putWupBuffer(getTabListRequest.toByteArray());
            toServiceMsg.extraData.putString("uin", currentAccountUin);
            toServiceMsg.addAttribute("KeyNeedUIRefresh", Boolean.valueOf(z16));
            sendPbReq(toServiceMsg);
            QLog.i("FrameUtil.TabDataHandler", 1, sb5.toString());
        } catch (Exception e17) {
            QLog.i("FrameUtil.TabDataHandler", 1, "getTabListNet error:" + e17);
        }
    }

    public void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        UserDynamicTab.GetTabListResponse getTabListResponse = new UserDynamicTab.GetTabListResponse();
        StringBuilder sb5 = new StringBuilder("handleGetTabListNet ");
        boolean z16 = false;
        if (fromServiceMsg != null && obj != null) {
            if (!fromServiceMsg.isSuccess()) {
                sb5.append(",resultCode=");
                sb5.append(fromServiceMsg.getResultCode());
                sb5.append(",RequestSsoSeq=");
                sb5.append(fromServiceMsg.getRequestSsoSeq());
            } else {
                try {
                    getTabListResponse = getTabListResponse.mergeFrom((byte[]) obj);
                } catch (Exception e16) {
                    QLog.i("FrameUtil.TabDataHandler", 1, "handleGetTabListNet", e16);
                }
                if (getTabListResponse.reson_code.get() == 0) {
                    z16 = true;
                }
                sb5.append(",reson_code=");
                sb5.append(getTabListResponse.reson_code.get());
                sb5.append(",sequence=");
                sb5.append(getTabListResponse.sequence.get());
                sb5.append(",tab_data=");
                sb5.append(getTabListResponse.tab_data.size());
                sb5.append(",model_rule=");
                sb5.append(getTabListResponse.model_rule.size());
                J2(getTabListResponse, sb5);
            }
        } else {
            sb5.append("res == null || data == null ");
        }
        sb5.append(",isSuc=");
        sb5.append(z16);
        if (z16) {
            F2(toServiceMsg, getTabListResponse);
        }
        QLog.i("FrameUtil.TabDataHandler", 1, sb5.toString());
    }

    public void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        UserDynamicTab.SetTabListResponse setTabListResponse = new UserDynamicTab.SetTabListResponse();
        StringBuilder sb5 = new StringBuilder("handleSetTabListNet ");
        boolean z16 = false;
        if (fromServiceMsg != null && obj != null) {
            if (!fromServiceMsg.isSuccess()) {
                sb5.append(",resultCode=");
                sb5.append(fromServiceMsg.getResultCode());
                sb5.append(",RequestSsoSeq=");
                sb5.append(fromServiceMsg.getRequestSsoSeq());
            } else {
                try {
                    setTabListResponse = setTabListResponse.mergeFrom((byte[]) obj);
                } catch (Exception e16) {
                    QLog.i("FrameUtil.TabDataHandler", 1, "handleSetTabListNet", e16);
                }
                if (setTabListResponse.reson_code.get() == 0 && setTabListResponse.sequence.get() != 0) {
                    z16 = true;
                }
                sb5.append(",reson_code=");
                sb5.append(setTabListResponse.reson_code.get());
                sb5.append(",sequence=");
                sb5.append(setTabListResponse.sequence.get());
            }
        } else {
            sb5.append("res == null || data == null ");
        }
        sb5.append(",isSuc=");
        sb5.append(z16);
        G2(this.appRuntime, toServiceMsg, setTabListResponse, z16);
        QLog.i("FrameUtil.TabDataHandler", 1, sb5.toString());
    }

    public void I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f241775f == null) {
            this.f241775f = new LoadTabDataRunnable(this);
        }
        ThreadManagerV2.excute(this.f241775f, 160, null, true);
    }

    public void K2(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Boolean.valueOf(z16));
            return;
        }
        if (this.f241773d == null) {
            QLog.i("FrameUtil.TabDataHandler", 1, "setTabList app == null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.i("FrameUtil.TabDataHandler", 1, "setTabList tabName isEmpty");
            return;
        }
        HashMap hashMap = new HashMap();
        if (!z16) {
            i3 = 3;
        }
        hashMap.put(str, Integer.valueOf(i3));
        TabDataHelper.updateTabLocalSwitch(BaseApplication.getContext(), this.f241773d.getCurrentAccountUin(), hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(str, Boolean.valueOf(z16));
        M2(hashMap2, false);
    }

    public void L2(Map<String, Boolean> map) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) map);
            return;
        }
        if (this.f241773d == null) {
            QLog.i("FrameUtil.TabDataHandler", 1, "setTabListBatch app == null");
            return;
        }
        if (map != null && !map.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Boolean> entry : map.entrySet()) {
                String key = entry.getKey();
                Boolean value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null) {
                    if (value.booleanValue()) {
                        i3 = 2;
                    } else {
                        i3 = 3;
                    }
                    hashMap.put(key, Integer.valueOf(i3));
                }
            }
            TabDataHelper.updateTabLocalSwitch(BaseApplication.getContext(), this.f241773d.getCurrentAccountUin(), hashMap);
            M2(map, false);
            return;
        }
        QLog.i("FrameUtil.TabDataHandler", 1, "setTabListBatch tabSwitchMap isEmpty");
    }

    public void M2(Map<String, Boolean> map, boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, map, Boolean.valueOf(z16));
            return;
        }
        if (map != null && !map.isEmpty()) {
            String currentAccountUin = this.f241773d.getCurrentAccountUin();
            StringBuilder sb5 = new StringBuilder("setTabList uin=");
            sb5.append(StringUtil.getSimpleUinForPrint(currentAccountUin));
            sb5.append(",isFromRetry=");
            sb5.append(z16);
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", currentAccountUin, "trpc.qq_tab.user_dynamic_tab.UserDynamicTab.SetTabList");
            UserDynamicTab.SetTabListRequest setTabListRequest = new UserDynamicTab.SetTabListRequest();
            setTabListRequest.from_type.set(1);
            ArrayList arrayList = new ArrayList();
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (Map.Entry<String, Boolean> entry : map.entrySet()) {
                String key = entry.getKey();
                Boolean value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null) {
                    sb5.append(",tabName=");
                    sb5.append(key);
                    sb5.append(",isOpen=");
                    sb5.append(value);
                    UserDynamicTab.TabData tabData = new UserDynamicTab.TabData();
                    tabData.tab_id.set(TabDataHelper.getTabId(key));
                    PBEnumField pBEnumField = tabData.tab_status;
                    if (value.booleanValue()) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    pBEnumField.set(i3);
                    arrayList.add(tabData);
                    arrayList2.add(key);
                    toServiceMsg.extraData.putBoolean(key, value.booleanValue());
                }
            }
            setTabListRequest.tab_data.addAll(arrayList);
            toServiceMsg.putWupBuffer(setTabListRequest.toByteArray());
            toServiceMsg.extraData.putString("uin", currentAccountUin);
            toServiceMsg.extraData.putBoolean("KeyRetry", z16);
            toServiceMsg.extraData.putStringArrayList("KeyRetryTabList", arrayList2);
            sendPbReq(toServiceMsg);
            QLog.i("FrameUtil.TabDataHandler", 1, sb5.toString());
            return;
        }
        QLog.i("FrameUtil.TabDataHandler", 1, "retrySetTabList switchMap isEmpty");
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("trpc.qq_tab.user_dynamic_tab.UserDynamicTab.GetTabList");
            this.allowCmdSet.add("trpc.qq_tab.user_dynamic_tab.UserDynamicTab.SetTabList");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null && !msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if ("trpc.qq_tab.user_dynamic_tab.UserDynamicTab.GetTabList".equals(serviceCmd)) {
                E2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("trpc.qq_tab.user_dynamic_tab.UserDynamicTab.SetTabList".equals(serviceCmd)) {
                    H2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        QLog.i("FrameUtil.TabDataHandler", 1, "req or res is null");
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void sendPbReq(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (toServiceMsg == null) {
            QLog.i("FrameUtil.TabDataHandler", 1, "request is null");
            return;
        }
        String serviceCmd = toServiceMsg.getServiceCmd();
        if (!com.tencent.mobileqq.service.a.c(serviceCmd)) {
            com.tencent.mobileqq.service.a.g(serviceCmd, f241772h);
        }
        super.sendPbReq(toServiceMsg);
    }
}
