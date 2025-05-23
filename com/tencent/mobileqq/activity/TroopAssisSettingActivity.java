package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.PrivacySetting;
import com.tencent.qqnt.kernel.nativeinterface.SettingKeyForNum;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ListView;
import com.tencent.widget.Switch;
import com.tencent.widget.XExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

/* compiled from: P */
@RoutePage(desc = "\u7fa4\u52a9\u624b\u8bbe\u7f6e", path = RouterConstants.UI_ROUTER_TROOP_HELPER_SETTING)
/* loaded from: classes9.dex */
public class TroopAssisSettingActivity extends IphoneTitleBarActivity implements Observer {
    static IPatchRedirector $redirector_ = null;
    public static final int BTN_INDEX_ASSISTANT = 2;
    public static final int BTN_INDEX_RECEIVE_AND_NOTIFY = 0;
    public static final int BTN_INDEX_RECEIVE_NOT_NOTIFY = 1;
    public static final int BTN_INDEX_SHIELD = 3;
    private IKernelSettingListener listener;
    private long listenerId;
    com.tencent.mobileqq.adapter.al mAdapter;
    String mFrom;
    protected XExpandableListView mListView;
    protected com.tencent.mobileqq.troop.roamsetting.b mRoamSettingObserver;
    protected CompoundButton.OnCheckedChangeListener mTogCheckListener;
    private Switch showToggle;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements IKernelSettingListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAssisSettingActivity.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onBufferSettingChanged(HashMap hashMap) {
            com.tencent.qqnt.kernel.nativeinterface.bp.a(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onCleanCacheProgressChanged(int i3, int i16) {
            com.tencent.qqnt.kernel.nativeinterface.bp.b(this, i3, i16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public void onNumSettingChanged(HashMap<SettingKeyForNum, Integer> hashMap) {
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) hashMap);
                return;
            }
            SettingKeyForNum settingKeyForNum = SettingKeyForNum.KGROUPASSISTANT;
            if (hashMap.containsKey(settingKeyForNum) && (num = hashMap.get(settingKeyForNum)) != null) {
                TroopAssisSettingActivity.this.updateToggle(num.intValue());
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onPrivacySettingChanged(PrivacySetting privacySetting) {
            com.tencent.qqnt.kernel.nativeinterface.bp.d(this, privacySetting);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onStrSettingChanged(HashMap hashMap) {
            com.tencent.qqnt.kernel.nativeinterface.bp.e(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onVerifyInfoChange(int i3) {
            com.tencent.qqnt.kernel.nativeinterface.bp.f(this, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAssisSettingActivity.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else if (compoundButton.getId() == R.id.f166871it1) {
                TroopAssisSettingActivity.this.setIsTroopAssistEnable(z16);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements ListView.OnScrollChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ XExpandableListView f177305a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f177306b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f177307c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f177308d;

        c(XExpandableListView xExpandableListView, int i3, int i16, boolean z16) {
            this.f177305a = xExpandableListView;
            this.f177306b = i3;
            this.f177307c = i16;
            this.f177308d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopAssisSettingActivity.this, xExpandableListView, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.widget.ListView.OnScrollChangeListener
        public void onScrollChanged(int i3, int i16, int i17) {
            float f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            int max = Math.max(this.f177305a.getScrollY(), this.f177305a.getListViewScrollY() + this.f177306b);
            if (max <= 0) {
                f16 = 0.0f;
            } else {
                int i18 = this.f177307c;
                if (max < i18) {
                    f16 = (max * 1.0f) / i18;
                } else {
                    f16 = 1.0f;
                }
            }
            if (this.f177308d) {
                TroopAssisSettingActivity.this.quiSecNavBar.setTitleBlurAlpha(f16);
            } else {
                TroopAssisSettingActivity.this.quiSecNavBar.setTitleAlpha(f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements IOperateCallback {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAssisSettingActivity.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            } else {
                QLog.d("IphoneTitleBarActivity", 1, "setIsTroopAssistEnable, result: ", Integer.valueOf(i3), " errMsg: ", str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements IOperateCallback {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAssisSettingActivity.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            QLog.i("IphoneTitleBarActivity", 1, "result: " + i3 + " errMsg: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements ExpandableListView.OnGroupClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAssisSettingActivity.this);
            }
        }

        @Override // com.tencent.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return true;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, expandableListView, view, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements ExpandableListView.OnChildClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAssisSettingActivity.this);
            }
        }

        @Override // com.tencent.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i3, int i16, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, expandableListView, view, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3))).booleanValue();
            }
            if (((com.tencent.mobileqq.adapter.al) expandableListView.getExpandableListAdapter()).getChildType(i3, i16) == 1) {
                return true;
            }
            com.tencent.mobileqq.statistics.u.b(TroopAssisSettingActivity.this.getActivity(), TroopAssisSettingActivity.this.app.getCurrentAccountUin());
            TroopAssisSettingActivity.this.showTroopSettingChoice((TroopInfo) expandableListView.getExpandableListAdapter().getChild(i3, i16));
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class h extends com.tencent.mobileqq.troop.roamsetting.b {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAssisSettingActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.roamsetting.b
        protected void d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            com.tencent.mobileqq.adapter.al alVar = TroopAssisSettingActivity.this.mAdapter;
            if (alVar == null) {
                return;
            }
            alVar.notifyDataSetChanged();
            TroopAssisSettingActivity.this.expandAllGroup();
        }
    }

    public TroopAssisSettingActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.listener = new a();
        this.listenerId = 0L;
        this.mTogCheckListener = new b();
        this.mRoamSettingObserver = new h();
    }

    private IKernelSettingService getSettingService() {
        IKernelSettingService settingService = ((IKernelService) this.app.getRuntimeService(IKernelService.class, "")).getSettingService();
        if (settingService == null) {
            QLog.d("IphoneTitleBarActivity", 1, "setIsTroopAssistEnable but settingService is null");
            return null;
        }
        return settingService;
    }

    private void initBlur() {
        XExpandableListView xExpandableListView;
        if (!needBlur() || this.quiSecNavBar == null) {
            return;
        }
        XExpandableListView xExpandableListView2 = this.mListView;
        int b16 = com.tencent.biz.qui.quisecnavbar.e.b(xExpandableListView2.getContext());
        xExpandableListView2.setPadding(0, b16, 0, 0);
        xExpandableListView2.setClipToPadding(false);
        boolean isSettingPageNavNeedBlur = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedBlur();
        boolean isSettingPageNavNeedAlpha = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedAlpha();
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        if (isSettingPageNavNeedBlur) {
            xExpandableListView = xExpandableListView2;
        } else {
            xExpandableListView = null;
        }
        qUISecNavBar.setBlur(isSettingPageNavNeedBlur, xExpandableListView);
        if (!isSettingPageNavNeedAlpha) {
            return;
        }
        if (isSettingPageNavNeedBlur) {
            this.quiSecNavBar.setTitleBlurAlpha(0.0f);
        } else {
            this.quiSecNavBar.setTitleAlpha(0.0f);
        }
        xExpandableListView2.setOnScrollChangeListener(new c(xExpandableListView2, b16, b16 / 2, isSettingPageNavNeedBlur));
    }

    private View initHeaderView() {
        View inflate = View.inflate(this, R.layout.f168242pz, null);
        View findViewById = inflate.findViewById(R.id.f166872it2);
        findViewById.setFocusable(true);
        com.tencent.mobileqq.widget.o.m(findViewById, 0, false);
        Switch r16 = (Switch) inflate.findViewById(R.id.f166871it1);
        this.showToggle = r16;
        r16.setOnCheckedChangeListener(this.mTogCheckListener);
        initToggleStatus();
        return inflate;
    }

    @TargetApi(8)
    private void initList() {
        this.mListView.setDivider(null);
        this.mListView.setChildDivider(null);
        this.mListView.setCacheColorHint(0);
        this.mListView.setGroupIndicator(null);
        this.mListView.setOnItemClickListener(null);
        this.mListView.setOnGroupClickListener(new f());
        this.mListView.setOnChildClickListener(new g());
    }

    private void initToggleStatus() {
        IKernelSettingService settingService = getSettingService();
        if (settingService != null) {
            ArrayList<SettingKeyForNum> arrayList = new ArrayList<>();
            arrayList.add(SettingKeyForNum.KGROUPASSISTANT);
            settingService.getSettingForNum(arrayList, new e());
        }
    }

    private View initTroopMessageSetting() {
        View initHeaderView = initHeaderView();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.f167783hc, (ViewGroup) null);
        XExpandableListView xExpandableListView = (XExpandableListView) View.inflate(this, R.layout.f168243q0, null);
        this.mListView = xExpandableListView;
        xExpandableListView.addHeaderView(initHeaderView);
        this.mListView.addFooterView(inflate);
        List<TroopInfo> joinedTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getJoinedTroopInfoFromCache();
        RecentUserProxy m3 = this.app.getProxyManager().m();
        for (TroopInfo troopInfo : joinedTroopInfoFromCache) {
            if (troopInfo.troopmask == GroupMsgMask.ASSISTANT) {
                troopInfo.lastMsgTime = this.app.getMessageFacade().getLastMessage(troopInfo.troopuin, 1).time;
            } else {
                long j3 = m3.findRecentUserByUin(troopInfo.troopuin, 1).lastmsgtime;
                if (j3 != 0) {
                    troopInfo.lastMsgTime = j3;
                }
            }
        }
        com.tencent.mobileqq.adapter.al alVar = new com.tencent.mobileqq.adapter.al(this, this.app);
        this.mAdapter = alVar;
        this.mListView.setAdapter(alVar);
        initList();
        this.mListView.setFooterDividersEnabled(true);
        this.mAdapter.notifyDataSetChanged();
        expandAllGroup();
        return this.mListView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showTroopSettingChoice$1(TroopInfo troopInfo, GroupMsgMask groupMsgMask, boolean z16, int i3, String str) {
        onSetGenralSettings(z16, troopInfo.troopuin, groupMsgMask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showTroopSettingChoice$2(TroopInfo troopInfo, final TroopInfo troopInfo2, ActionSheet actionSheet, View view, int i3) {
        final GroupMsgMask groupMsgMask;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        groupMsgMask = null;
                    } else {
                        groupMsgMask = GroupMsgMask.SHIELD;
                    }
                } else {
                    groupMsgMask = GroupMsgMask.ASSISTANT;
                }
            } else {
                groupMsgMask = GroupMsgMask.RECEIVE;
            }
        } else {
            groupMsgMask = GroupMsgMask.NOTIFY;
        }
        if (groupMsgMask != null && groupMsgMask != troopInfo.troopmask) {
            if (NetworkUtil.isNetSupport(getActivity())) {
                ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).setGroupMsgMask(troopInfo2.troopuin, groupMsgMask, this, new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.activity.fp
                    @Override // com.tencent.qqnt.troop.e
                    public final void onResult(boolean z16, int i16, String str) {
                        TroopAssisSettingActivity.this.lambda$showTroopSettingChoice$1(troopInfo2, groupMsgMask, z16, i16, str);
                    }
                });
                this.mAdapter.notifyDataSetChanged();
                expandAllGroup();
                ReportController.o(this.app, "P_CliOper", "Grp_msg", "", "set_page", "Clk_setmsg", 0, 0, troopInfo2.troopuin, String.valueOf(groupMsgMask.ordinal() - 1), "", "");
            } else {
                QQToast.makeText(getActivity(), R.string.f171139ci4, 0).show(getTitleBarHeight());
            }
        }
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateToggle$0(int i3) {
        boolean z16;
        Switch r06 = this.showToggle;
        if (i3 != 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        r06.setChecked(z16);
    }

    private void notifyUpdatePage() {
        MqqHandler handler;
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null && (handler = qQAppInterface.getHandler(Conversation.class)) != null) {
            handler.sendEmptyMessage(1009);
        }
    }

    private void onSetGenralSettings(boolean z16, String str, GroupMsgMask groupMsgMask) {
        com.tencent.mobileqq.adapter.al alVar = this.mAdapter;
        if (alVar == null) {
            return;
        }
        if (z16) {
            alVar.notifyDataSetChanged();
            expandAllGroup();
        } else {
            alVar.notifyDataSetChanged();
            expandAllGroup();
            QQToast.makeText(this.app.getApp(), 1, getString(R.string.i8h), 0).show(getTitleBarHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsTroopAssistEnable(boolean z16) {
        IQQNTWrapperSession wrapperSession = ((IKernelService) this.app.getRuntimeService(IKernelService.class, "")).getWrapperSession();
        int i3 = 1;
        if (wrapperSession == null) {
            QLog.d("IphoneTitleBarActivity", 1, "setIsTroopAssistEnable but session is null");
            return;
        }
        IKernelSettingService settingService = wrapperSession.getSettingService();
        if (settingService == null) {
            QLog.d("IphoneTitleBarActivity", 1, "setIsTroopAssistEnable but settingService is null");
            return;
        }
        HashMap<SettingKeyForNum, Integer> hashMap = new HashMap<>();
        SettingKeyForNum settingKeyForNum = SettingKeyForNum.KGROUPASSISTANT;
        if (!z16) {
            i3 = 2;
        }
        hashMap.put(settingKeyForNum, Integer.valueOf(i3));
        settingService.setSettingForNum(hashMap, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateToggle(final int i3) {
        boolean z16;
        if (i3 != 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 != this.showToggle.isChecked()) {
            this.showToggle.post(new Runnable() { // from class: com.tencent.mobileqq.activity.fq
                @Override // java.lang.Runnable
                public final void run() {
                    TroopAssisSettingActivity.this.lambda$updateToggle$0(i3);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        IKernelSettingService settingService = getSettingService();
        if (settingService != null) {
            this.listenerId = settingService.addKernelSettingListener(this.listener);
        }
        com.tencent.mobileqq.utils.ca.a(this);
        super.setContentView(initTroopMessageSetting());
        setContentBackgroundResource(R.drawable.bg_texture);
        setTitle(R.string.f1384209i);
        addObserver(this.mRoamSettingObserver);
        this.app.getMessageFacade().addObserver(this);
        String stringExtra = getIntent().getStringExtra("from");
        this.mFrom = stringExtra;
        if (stringExtra != null && stringExtra.equals("conversation")) {
            updateUnreadNumOnTitleBar();
        }
        initBlur();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnDestroy();
        IKernelSettingService settingService = getSettingService();
        if (settingService != null) {
            settingService.removeKernelSettingListener(this.listenerId);
        }
        removeObserver(this.mRoamSettingObserver);
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null && qQAppInterface.getMessageFacade() != null) {
            this.app.getMessageFacade().deleteObserver(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            notifyUpdatePage();
            super.doOnPause();
        }
    }

    void expandAllGroup() {
        for (int i3 = 0; i3 < this.mAdapter.getGroupCount(); i3++) {
            this.mListView.expandGroup(i3);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.finish();
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public boolean needBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    void showTroopSettingChoice(final TroopInfo troopInfo) {
        String troopDisplayName;
        boolean z16;
        boolean z17;
        boolean z18;
        if (troopInfo != null) {
            final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
            GroupMsgMask groupMsgMask = troopInfo.troopmask;
            if (TextUtils.isEmpty(troopInfo.getTroopDisplayName())) {
                troopDisplayName = troopInfo.troopuin;
            } else {
                troopDisplayName = troopInfo.getTroopDisplayName();
            }
            boolean z19 = true;
            actionSheet.setMainTitle(getString(R.string.hwy, troopDisplayName));
            if (groupMsgMask == GroupMsgMask.NOTIFY) {
                z16 = true;
            } else {
                z16 = false;
            }
            actionSheet.addRadioButton(R.string.esm, z16);
            if (groupMsgMask == GroupMsgMask.RECEIVE) {
                z17 = true;
            } else {
                z17 = false;
            }
            actionSheet.addRadioButton(R.string.esr, z17);
            if (groupMsgMask == GroupMsgMask.ASSISTANT) {
                z18 = true;
            } else {
                z18 = false;
            }
            actionSheet.addRadioButton(R.string.esn, z18);
            if (groupMsgMask != GroupMsgMask.SHIELD) {
                z19 = false;
            }
            actionSheet.addRadioButton(R.string.esj, z19);
            actionSheet.addCancelButton(getString(R.string.cancel));
            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.activity.fr
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i3) {
                    TroopAssisSettingActivity.this.lambda$showTroopSettingChoice$2(troopInfo, troopInfo, actionSheet, view, i3);
                }
            });
            actionSheet.show();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) observable, obj);
        } else if ((obj instanceof MessageRecord) && !((MessageRecord) obj).isSendFromLocal()) {
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.TroopAssisSettingActivity.9
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAssisSettingActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    String str = TroopAssisSettingActivity.this.mFrom;
                    if (str != null && str.equals("conversation")) {
                        TroopAssisSettingActivity.this.updateUnreadNumOnTitleBar();
                    }
                }
            });
        }
    }

    void updateUnreadNumOnTitleBar() {
        QQMessageFacade messageFacade;
        if (this.leftView != null && (messageFacade = this.app.getMessageFacade()) != null) {
            int H1 = messageFacade.H1();
            if (H1 > 0) {
                if (H1 > 99) {
                    this.leftView.setText(getString(R.string.hvn) + "(99+)");
                    return;
                }
                this.leftView.setText(getString(R.string.hvn) + "(" + H1 + ")");
                return;
            }
            this.leftView.setText(getString(R.string.hvn));
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }
}
