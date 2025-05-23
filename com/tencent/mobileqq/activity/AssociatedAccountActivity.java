package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.adapter.b;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.login.api.IDirectLoginService;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.logintempapi.IPwdSetUtilApi;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.api.ISubAccountServlet;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountServiceImpl;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.api.IContactUtils;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SubAccountPullRefreshHeader;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
@RoutePage(desc = "\u5c0f\u53f7\u52a9\u624b-\u5173\u8054\u8d26\u53f7", path = RouterConstants.UI_ROUTE_SUB_ACCOUNT_ASSOCIATED_ACCOUNT)
/* loaded from: classes9.dex */
public class AssociatedAccountActivity extends SubAccountBaseActivity implements Observer {
    static IPatchRedirector $redirector_ = null;
    public static final int LOGIN_REQUEST_CHANGE = 1011;
    public static final int MANAGE_ASSOCIATED_ACCOUNT_REQUEST_CODE = 1012;
    public static final long MIN_REFRESH_GAP = 30000;
    private static final String TAG = "AssociatedAccountActivity";
    public SubAccountInfo curSubAccountInfo;
    private int fromWhereExactly;
    public com.tencent.mobileqq.adapter.b mAdapter;
    public SlideDetectListView mAssociatedqqList;
    private com.tencent.mobileqq.avatar.observer.a mAvatarObserver;
    public boolean mClick2Switch;
    public String mCurrentSwitchUin;
    private BusinessObserver mFriendObserver;
    public MqqHandler mHandler;
    public boolean mIsDisplayThirdFuc;
    public boolean mIsDisplayThirdQQChecked;
    public boolean mIsFirstResume;
    public boolean mIsFromAccountManage;
    public boolean mIsFromPull;
    public boolean mIsPullReqSuccess;
    public boolean mIsStartRefreshList;
    public ArrayList<com.tencent.mobileqq.subaccount.b> mItemDataList;
    public long mLastRefreshTime;
    private BusinessObserver mMsgObserver;
    public int mNeed2ConfirmMsgNum;
    private View.OnClickListener mOnItemClickListener;
    public int mPullReqNeedBackNum;
    private OverScrollViewListener mScrollViewListener;
    private com.tencent.mobileqq.app.dc mSubAccountBindObserver;
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> mSubAccountConfig;
    public ArrayList<SubAccountInfo> mSubAccountList;
    private QUISingleLineListItem mSubAccountNotifyListItem;
    public ArrayList<SimpleAccount> mThirdAccountList;
    public SubAccountPullRefreshHeader mTopRefreshTop;
    public com.tencent.mobileqq.adapter.b thirdAccountsAdapter;
    public ArrayList<com.tencent.mobileqq.subaccount.b> thirdAccountsDataList;
    public HorizontalListView thirdAccountsListView;
    public View thirdRootLayout;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountActivity.this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x0201  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x021f  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x025d  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            b.C7222b c7222b;
            com.tencent.mobileqq.subaccount.b bVar;
            com.tencent.mobileqq.subaccount.b bVar2;
            String str;
            String str2;
            String str3;
            boolean z16;
            int i3;
            boolean z17;
            String str4;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                if (appInterface == null) {
                    QLog.d(AssociatedAccountActivity.TAG, 1, "app is null");
                } else if (view != null && view.getId() == R.id.f164031hn) {
                    QLog.d(AssociatedAccountActivity.TAG, 2, "addAccount onClick");
                    AssociatedAccountActivity.this.fromWhereExactly = 1;
                    ReportController.o(appInterface, "dc00898", "", "", "0X800C479", "0X800C479", 0, 0, "", "", "", "");
                    AssociatedAccountActivity.this.bindNewSubAccount();
                } else if (view != null && (view.getTag() instanceof b.C7222b) && (c7222b = (b.C7222b) view.getTag()) != null && (bVar = c7222b.f187149g) != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(AssociatedAccountActivity.TAG, 2, "onItemClick type = " + bVar.f291092a);
                    }
                    int i16 = bVar.f291092a;
                    String str5 = null;
                    if (i16 != 1 && i16 != 2) {
                        if (i16 != 3) {
                            if (i16 == 4) {
                                AssociatedAccountActivity.this.fromWhereExactly = 1;
                                AssociatedAccountActivity.this.bindNewSubAccount();
                                QLog.d(AssociatedAccountActivity.TAG, 2, "add subaccount");
                                ReportController.y(appInterface, "0X800C479");
                            } else {
                                if (i16 != 6) {
                                    if (i16 != 7) {
                                        str3 = null;
                                        bVar2 = bVar;
                                        str = AssociatedAccountActivity.TAG;
                                    }
                                } else {
                                    Object obj = bVar.f291103l;
                                    if (obj != null && (obj instanceof SimpleAccount)) {
                                        str5 = ((SimpleAccount) obj).getUin();
                                    }
                                    String str6 = str5;
                                    QLog.d(AssociatedAccountActivity.TAG, 2, "switch login user");
                                    ReportController.o(appInterface, "dc00898", "", "", "0X800C47C", "0X800C47C", 0, 0, str6, "", "", "");
                                    str3 = str6;
                                    bVar2 = bVar;
                                    str = AssociatedAccountActivity.TAG;
                                }
                                if (!TextUtils.isEmpty(str3) && !((IPwdSetUtilApi) QRoute.api(IPwdSetUtilApi.class)).checkHasNotSetPwd(AssociatedAccountActivity.this) && AssociatedAccountActivity.this.isNetConnToast()) {
                                    z16 = bVar2.f291100i;
                                    if (z16) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d(str, 2, "onItemClick goto SubAccountUgActivity");
                                        }
                                        AssociatedAccountActivity associatedAccountActivity = AssociatedAccountActivity.this;
                                        associatedAccountActivity.mCurrentSwitchUin = str3;
                                        associatedAccountActivity.mClick2Switch = true;
                                        AssociatedAccountActivity.this.sendBroadcast(new Intent("before_account_change"));
                                        Intent intent = new Intent(AssociatedAccountActivity.this, (Class<?>) SubAccountUgActivity.class);
                                        intent.putExtra("subAccount", str3);
                                        intent.putExtra("from_associated_activity", true);
                                        AssociatedAccountActivity.this.startActivity(intent);
                                    } else if (z16 && bVar2.f291092a == 2) {
                                        Object obj2 = bVar2.f291103l;
                                        if (obj2 != null && (obj2 instanceof SubAccountInfo) && AssociatedAccountActivity.this.curSubAccountInfo != null) {
                                            SubAccountInfo subAccountInfo = (SubAccountInfo) obj2;
                                            if (!TextUtils.isEmpty(subAccountInfo.subuin) && !subAccountInfo.subuin.equals(AssociatedAccountActivity.this.curSubAccountInfo.subuin)) {
                                                AssociatedAccountActivity associatedAccountActivity2 = AssociatedAccountActivity.this;
                                                associatedAccountActivity2.curSubAccountInfo = subAccountInfo;
                                                associatedAccountActivity2.refreshAllData(true);
                                            }
                                        }
                                    } else {
                                        AssociatedAccountActivity.this.showJuhua(R.string.cpf);
                                        if (QLog.isColorLevel()) {
                                            QLog.d(str, 2, "onItemClick mNeed2ConfirmMsgNum = " + AssociatedAccountActivity.this.mNeed2ConfirmMsgNum + "  toUin=" + str3);
                                        }
                                        AssociatedAccountActivity associatedAccountActivity3 = AssociatedAccountActivity.this;
                                        if (associatedAccountActivity3.mNeed2ConfirmMsgNum > 0) {
                                            associatedAccountActivity3.mCurrentSwitchUin = str3;
                                            SubAccountServiceImpl subAccountServiceImpl = (SubAccountServiceImpl) appInterface.getRuntimeService(ISubAccountService.class, "");
                                            Iterator<SubAccountInfo> it = AssociatedAccountActivity.this.mSubAccountList.iterator();
                                            int i17 = 0;
                                            while (it.hasNext()) {
                                                SubAccountInfo next = it.next();
                                                if (next != null && !TextUtils.isEmpty(next.subuin) && subAccountServiceImpl.getUnreadAllMsgNum(next.subuin) > 0) {
                                                    i17++;
                                                    com.tencent.mobileqq.app.message.a processor = ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getProcessor(appInterface);
                                                    if (processor != null) {
                                                        processor.Y0(next.subuin, "sub.account.switchAccount");
                                                    }
                                                }
                                            }
                                            i3 = i17;
                                        } else {
                                            i3 = 0;
                                        }
                                        int i18 = bVar2.f291092a;
                                        if (i18 != 5 && i18 != 6) {
                                            z17 = false;
                                            str4 = str3;
                                        } else {
                                            z17 = false;
                                            str4 = str3;
                                            ReportController.o(appInterface, "dc00898", "", "", "0X800BDE6", "0X800BDE6", 0, 0, "", "", "", "");
                                        }
                                        if (i3 <= 0) {
                                            AssociatedAccountActivity.this.cleanMessagesUnreadAsync(z17, str4);
                                        } else {
                                            AssociatedAccountActivity.this.mNeed2ConfirmMsgNum = i3;
                                        }
                                    }
                                }
                            }
                        } else {
                            Object obj3 = bVar.f291103l;
                            if (obj3 != null && (obj3 instanceof SubAccountMessage)) {
                                str5 = ((SubAccountMessage) obj3).subUin;
                            }
                            str2 = str5;
                            QLog.d(AssociatedAccountActivity.TAG, 2, "subaccount message1");
                            bVar2 = bVar;
                            str = AssociatedAccountActivity.TAG;
                            ReportController.o(appInterface, "dc00898", "", "", "0X800C478", "0X800C478", 0, 0, str2, "", "", "");
                            str3 = str2;
                            if (!TextUtils.isEmpty(str3)) {
                                z16 = bVar2.f291100i;
                                if (z16) {
                                }
                            }
                        }
                    }
                    bVar2 = bVar;
                    str = AssociatedAccountActivity.TAG;
                    Object obj4 = bVar2.f291103l;
                    if (obj4 != null && (obj4 instanceof SubAccountInfo)) {
                        str5 = ((SubAccountInfo) obj4).subuin;
                    }
                    str2 = str5;
                    if (i16 == 2) {
                        QLog.d(str, 2, "subaccount avatar");
                        ReportController.o(appInterface, "dc00898", "", "", "0X800BDDF", "0X800BDDF", 0, 0, "", "", "", "");
                        Object obj5 = bVar2.f291103l;
                        if (obj5 != null && (obj5 instanceof SubAccountInfo)) {
                            ReportController.o(appInterface, "dc00898", "", "", "0X800BDE0", "0X800BDE0", 0, 0, String.valueOf(((SubAccountInfo) obj5).unreadMsgNum), "", "", "");
                        }
                    } else {
                        QLog.d(str, 2, "subaccount message2");
                        ReportController.o(appInterface, "dc00898", "", "", "0X800C478", "0X800C478", 0, 0, str2, "", "", "");
                    }
                    str3 = str2;
                    if (!TextUtils.isEmpty(str3)) {
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z18 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            if (z16 && !TextUtils.isEmpty(str)) {
                ArrayList<SubAccountInfo> arrayList = AssociatedAccountActivity.this.mSubAccountList;
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator<SubAccountInfo> it = AssociatedAccountActivity.this.mSubAccountList.iterator();
                    z17 = false;
                    while (it.hasNext()) {
                        if (TextUtils.equals(str, it.next().subuin)) {
                            z17 = true;
                        }
                    }
                } else {
                    z17 = false;
                }
                ArrayList<SimpleAccount> arrayList2 = AssociatedAccountActivity.this.mThirdAccountList;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    Iterator<SimpleAccount> it5 = AssociatedAccountActivity.this.mThirdAccountList.iterator();
                    while (it5.hasNext()) {
                        if (TextUtils.equals(str, it5.next().getUin())) {
                            z18 = true;
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(AssociatedAccountActivity.TAG, 2, "onUpdateCustomHead uin = " + str + " needUpdate=" + z17);
                }
                if (z17) {
                    AssociatedAccountActivity.this.mAdapter.notifyDataSetInvalidated();
                }
                if (z18) {
                    AssociatedAccountActivity.this.thirdAccountsAdapter.notifyDataSetInvalidated();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c implements ISubAccountApi.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountActivity.this);
            }
        }

        private void b(String str, ArrayList<com.tencent.mobileqq.subaccount.b> arrayList, com.tencent.mobileqq.adapter.b bVar) {
            Object obj;
            Object obj2;
            if (QLog.isColorLevel()) {
                QLog.d(AssociatedAccountActivity.TAG, 2, "updateAssociatedAccountInfo  uin = " + str);
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Iterator<com.tencent.mobileqq.subaccount.b> it = arrayList.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                com.tencent.mobileqq.subaccount.b next = it.next();
                int i3 = next.f291092a;
                if (i3 == 2 && (obj2 = next.f291103l) != null && (obj2 instanceof ArrayList)) {
                    Iterator it5 = ((ArrayList) obj2).iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        if (str.equals(((SubAccountInfo) ((com.tencent.mobileqq.subaccount.b) it5.next()).f291103l).subuin)) {
                            String buddyNickName = ((IContactUtils) QRoute.api(IContactUtils.class)).getBuddyNickName(peekAppRuntime, str, true);
                            if (TextUtils.isEmpty(buddyNickName)) {
                                buddyNickName = str;
                            }
                            if (!buddyNickName.equals(next.f291093b)) {
                                next.f291093b = buddyNickName;
                            }
                        }
                    }
                } else if (i3 == 6 && (obj = next.f291103l) != null && (obj instanceof SimpleAccount)) {
                    SimpleAccount simpleAccount = (SimpleAccount) obj;
                    if (str.equals(simpleAccount.getUin())) {
                        String u16 = com.tencent.mobileqq.subaccount.h.u((AppInterface) peekAppRuntime, simpleAccount);
                        if (!u16.equals(next.f291093b)) {
                            next.f291093b = u16;
                            z16 = true;
                        }
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(AssociatedAccountActivity.TAG, 2, "updateAssociatedAccountInfo needUpdate = " + z16);
            }
            if (z16) {
                bVar.notifyDataSetInvalidated();
            }
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.b
        public void a(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
                return;
            }
            if (z16 && !TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d(AssociatedAccountActivity.TAG, 2, "onUpdateFriendInfo  uin = " + str + " isSuccess = " + z16);
                }
                AssociatedAccountActivity associatedAccountActivity = AssociatedAccountActivity.this;
                b(str, associatedAccountActivity.mItemDataList, associatedAccountActivity.mAdapter);
                AssociatedAccountActivity associatedAccountActivity2 = AssociatedAccountActivity.this;
                b(str, associatedAccountActivity2.thirdAccountsDataList, associatedAccountActivity2.thirdAccountsAdapter);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d extends com.tencent.mobileqq.app.dc {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.dc
        protected void a(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), aVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AssociatedAccountActivity.TAG, 2, "onBindSubAccount() isSuccess=" + z16);
                if (aVar != null) {
                    QLog.d(AssociatedAccountActivity.TAG, 2, "onBindSubAccount() mainAccount=" + aVar.f291123c + " subAccount=" + aVar.f291124d + " errType=" + aVar.f291121a + " errMsg=" + aVar.f291122b);
                }
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (aVar != null && TextUtils.equals(aVar.f291123c, peekAppRuntime.getCurrentUin()) && z16) {
                AssociatedAccountActivity.this.refreshAllData(false);
            }
        }

        @Override // com.tencent.mobileqq.app.dc
        protected void b(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar) {
            ArrayList<String> f16;
            ArrayList<SubAccountInfo> arrayList;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z18 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), aVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AssociatedAccountActivity.TAG, 2, "onGetBindSubAccount() isSuccess=" + z16);
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (aVar != null && TextUtils.equals(aVar.f291123c, peekAppRuntime.getCurrentUin()) && z16 && (f16 = aVar.f()) != null && (arrayList = AssociatedAccountActivity.this.mSubAccountList) != null) {
                Iterator<SubAccountInfo> it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!f16.contains(it.next().subuin)) {
                            z17 = true;
                            break;
                        }
                    } else {
                        z17 = false;
                        break;
                    }
                }
                if (f16.size() == AssociatedAccountActivity.this.mSubAccountList.size()) {
                    z18 = z17;
                }
                if (z18) {
                    AssociatedAccountActivity.this.refreshAllData(false);
                }
            }
        }

        @Override // com.tencent.mobileqq.app.dc
        protected void c(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), aVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AssociatedAccountActivity.TAG, 2, "onUnBindSubAccount() isSuccess=" + z16);
                if (aVar != null) {
                    QLog.d(AssociatedAccountActivity.TAG, 2, "onUnBindSubAccount() mainAccount=" + aVar.f291123c + " subAccount=" + aVar.f291124d + " errType=" + aVar.f291121a + " errMsg=" + aVar.f291122b);
                }
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (aVar != null && TextUtils.equals(aVar.f291123c, peekAppRuntime.getCurrentUin()) && z16) {
                AssociatedAccountActivity.this.refreshAllData(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class e implements ISubAccountApi.c {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.c
        public void a(boolean z16, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onSubAccountMsgNumConfirm isSuccess=");
                sb5.append(z16);
                sb5.append(" subUin=");
                sb5.append(str);
                sb5.append(" set need2ConfirmMsgNum=");
                sb5.append(!z16);
                sb5.append(" nextAction=");
                sb5.append(str2);
                sb5.append(" mNeed2ConfirmMsgNum=");
                sb5.append(AssociatedAccountActivity.this.mNeed2ConfirmMsgNum);
                QLog.d(AssociatedAccountActivity.TAG, 2, sb5.toString());
            }
            if ("sub.account.switchAccount".equals(str2)) {
                AssociatedAccountActivity associatedAccountActivity = AssociatedAccountActivity.this;
                int i3 = associatedAccountActivity.mNeed2ConfirmMsgNum - 1;
                associatedAccountActivity.mNeed2ConfirmMsgNum = i3;
                if (i3 <= 0) {
                    associatedAccountActivity.cleanMessagesUnreadAsync(false, associatedAccountActivity.mCurrentSwitchUin);
                }
                AssociatedAccountActivity associatedAccountActivity2 = AssociatedAccountActivity.this;
                if (associatedAccountActivity2.mNeed2ConfirmMsgNum < 0) {
                    associatedAccountActivity2.mNeed2ConfirmMsgNum = 0;
                }
            }
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.c
        public void b(boolean z16, String str, com.tencent.mobileqq.subaccount.logic.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, aVar);
                return;
            }
            if (AssociatedAccountActivity.this.checkParamsInValid(str, aVar)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AssociatedAccountActivity.TAG, 2, "onPushSubAccountMsg subUin" + str);
            }
            if (z16) {
                AssociatedAccountActivity.this.refreshAllData(false);
            }
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.c
        public void c(boolean z16, String str, com.tencent.mobileqq.subaccount.logic.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, bVar);
                return;
            }
            if (AssociatedAccountActivity.this.checkSubAccountParamsInValid(str, bVar)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AssociatedAccountActivity.TAG, 2, "onSubAccountThirdQQUnreadMsgNum mIsFromPull=" + AssociatedAccountActivity.this.mIsFromPull + "  mPullReqNeedBackNum=" + AssociatedAccountActivity.this.mPullReqNeedBackNum + " isSuccess=" + z16 + "  mainAccount=" + str + "  data=" + bVar);
            }
            AssociatedAccountActivity associatedAccountActivity = AssociatedAccountActivity.this;
            if (associatedAccountActivity.mIsFromPull) {
                associatedAccountActivity.onRefreshRequestBack(z16, false);
                return;
            }
            associatedAccountActivity.mPullReqNeedBackNum = 0;
            associatedAccountActivity.mIsPullReqSuccess = false;
            if (z16) {
                associatedAccountActivity.updateThirdQQUnread(bVar);
            }
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.c
        public void d(boolean z16, String str, com.tencent.mobileqq.subaccount.logic.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, aVar);
                return;
            }
            if (AssociatedAccountActivity.this.checkParamsInValid(str, aVar)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AssociatedAccountActivity.TAG, 2, "onGetSubAccountMsg subAccount=" + str + " mIsFromPull=" + AssociatedAccountActivity.this.mIsFromPull + " isSuccess=" + z16 + "  mPullReqNeedBackNum=" + AssociatedAccountActivity.this.mPullReqNeedBackNum);
            }
            AssociatedAccountActivity associatedAccountActivity = AssociatedAccountActivity.this;
            if (associatedAccountActivity.mIsFromPull) {
                associatedAccountActivity.onRefreshRequestBack(z16, true);
                return;
            }
            associatedAccountActivity.mPullReqNeedBackNum = 0;
            associatedAccountActivity.mIsPullReqSuccess = false;
            if (z16 && aVar.f291132l) {
                associatedAccountActivity.loadItemDataList();
            } else if (z16) {
                associatedAccountActivity.updateSubAccountStatus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f174913d;

        f(ActionSheet actionSheet) {
            this.f174913d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountActivity.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (view.getId() == R.id.m_5) {
                this.f174913d.cancel();
                AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                if (appInterface == null) {
                    QLog.d(AssociatedAccountActivity.TAG, 1, "app is null");
                    return;
                }
                AssociatedAccountActivity associatedAccountActivity = AssociatedAccountActivity.this;
                associatedAccountActivity.handleCleanAllMessage(appInterface, associatedAccountActivity.getString(R.string.a3d));
                ReportController.y(appInterface, "0X800C482");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountActivity.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            String str;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                if (appInterface == null) {
                    QLog.d(AssociatedAccountActivity.TAG, 1, "app is null");
                } else {
                    SettingCloneUtil.writeValue(AssociatedAccountActivity.this, appInterface.getCurrentAccountUin(), (String) null, AppConstants.QQSETTING_SUBACCOUNT_NOTIFY, z16);
                    ((SubAccountServiceImpl) appInterface.getRuntimeService(ISubAccountService.class, "")).updateNotifySwitch(appInterface);
                    String str2 = "1";
                    if (z16) {
                        str = "1";
                    } else {
                        str = "2";
                    }
                    ReportController.o(appInterface, "dc00898", "", "", "0X800C47B", "0X800C47B", 0, 0, "", str, "", "");
                    QUISingleLineListItem qUISingleLineListItem = AssociatedAccountActivity.this.mSubAccountNotifyListItem;
                    if (!((x.c.f) AssociatedAccountActivity.this.mSubAccountConfig.O()).getIsChecked()) {
                        str2 = "2";
                    }
                    VideoReport.setElementParam(qUISingleLineListItem, "switch_current_state", str2);
                    if (z16) {
                        AssociatedAccountActivity.this.getDataList(false, false);
                    }
                    AssociatedAccountActivity.this.loadItemDataList();
                }
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AssociatedAccountActivity.TAG, 2, "switchFail -> to LoginActivity which=" + i3);
            }
            Intent intent = new Intent();
            intent.setPackage(AssociatedAccountActivity.this.getPackageName());
            intent.putExtra("is_change_account", true);
            String str = AssociatedAccountActivity.this.mCurrentSwitchUin;
            if (str != null) {
                intent.putExtra("uin", str);
            }
            intent.putExtra("befault_uin", MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin());
            intent.putExtra("switch_account_fail", true);
            RouteUtils.startActivityForResult(AssociatedAccountActivity.this, intent, RouterConstants.UI_ROUTER_LOGIN, 1011);
            AssociatedAccountActivity.this.mCurrentSwitchUin = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i implements IOperateCallback {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountActivity.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            QLog.d(AssociatedAccountActivity.TAG, 2, "setMsgRead onResult: $" + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class j implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f174918d;

        j(ActionSheet actionSheet) {
            this.f174918d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountActivity.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            this.f174918d.cancel();
            if (view == null) {
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            int id5 = view.getId();
            if (id5 == R.id.f164008sd1) {
                QLog.d(AssociatedAccountActivity.TAG, 2, "addAssociatedAccount onClick");
                AssociatedAccountActivity.this.fromWhereExactly = 2;
                AssociatedAccountActivity.this.bindNewSubAccount();
                ReportController.y(peekAppRuntime, "0X800C47E");
                return;
            }
            if (id5 == R.id.txp) {
                AssociatedAccountActivity.this.showConfirmDialog();
                ReportController.y(peekAppRuntime, "0X800C47F");
            } else if (id5 == R.id.ywp) {
                AssociatedAccountActivity.this.gotoManageAssociatedAccount();
                ReportController.y(peekAppRuntime, "0X800C480");
            }
        }
    }

    public AssociatedAccountActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsStartRefreshList = false;
        this.mIsFromPull = false;
        this.mPullReqNeedBackNum = 0;
        this.mIsPullReqSuccess = false;
        this.mLastRefreshTime = 0L;
        this.mNeed2ConfirmMsgNum = 0;
        this.mClick2Switch = false;
        this.mHandler = new MqqHandler();
        this.mIsDisplayThirdFuc = true;
        this.mIsDisplayThirdQQChecked = true;
        this.mIsFromAccountManage = false;
        this.mIsFirstResume = true;
        this.mOnItemClickListener = new a();
        this.mAvatarObserver = new b();
        this.mFriendObserver = ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getFriendListObserver(new c());
        this.mSubAccountBindObserver = new d();
        this.mMsgObserver = ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getMessageObserver(new e());
        this.mScrollViewListener = new OverScrollViewListener() { // from class: com.tencent.mobileqq.activity.AssociatedAccountActivity.15
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssociatedAccountActivity.this);
                }
            }

            @Override // com.tencent.widget.OverScrollViewListener
            public void onNotCompleteVisable(int i3, View view, ListView listView) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, this, Integer.valueOf(i3), view, listView);
                    return;
                }
                AssociatedAccountActivity associatedAccountActivity = AssociatedAccountActivity.this;
                if (associatedAccountActivity.mIsStartRefreshList) {
                    associatedAccountActivity.mTopRefreshTop.g();
                } else {
                    associatedAccountActivity.mTopRefreshTop.i(0L);
                }
            }

            @Override // com.tencent.widget.OverScrollViewListener
            public void onViewCompleteVisable(int i3, View view, ListView listView) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Integer.valueOf(i3), view, listView);
                    return;
                }
                AssociatedAccountActivity associatedAccountActivity = AssociatedAccountActivity.this;
                if (associatedAccountActivity.mIsStartRefreshList) {
                    return;
                }
                associatedAccountActivity.mTopRefreshTop.d(0L);
            }

            @Override // com.tencent.widget.OverScrollViewListener
            public boolean onViewCompleteVisableAndReleased(int i3, View view, ListView listView) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 3, this, Integer.valueOf(i3), view, listView)).booleanValue();
                }
                if (AssociatedAccountActivity.this.mIsStartRefreshList) {
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(AssociatedAccountActivity.TAG, 2, "onViewCompleteVisableAndReleased begin refresh");
                }
                if (AssociatedAccountActivity.this.isNetConnToast()) {
                    AssociatedAccountActivity.this.mTopRefreshTop.h(0L);
                    AssociatedAccountActivity associatedAccountActivity = AssociatedAccountActivity.this;
                    associatedAccountActivity.mIsFromPull = true;
                    associatedAccountActivity.getDataList(false, true);
                } else {
                    AssociatedAccountActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.AssociatedAccountActivity.15.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass15.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            AssociatedAccountActivity associatedAccountActivity2 = AssociatedAccountActivity.this;
                            if (associatedAccountActivity2.mAssociatedqqList != null) {
                                associatedAccountActivity2.mTopRefreshTop.l(1);
                                AssociatedAccountActivity.this.mAssociatedqqList.springBackOverScrollHeaderView();
                            }
                        }
                    }, 800L);
                }
                return true;
            }

            @Override // com.tencent.widget.OverScrollViewListener
            public void onViewNotCompleteVisableAndReleased(int i3, View view, ListView listView) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), view, listView);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindNewSubAccount() {
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "bindNewSubAccount currentUin=" + peekAppRuntime.getCurrentUin());
        }
        ArrayList arrayList = new ArrayList();
        SubAccountServiceImpl subAccountServiceImpl = (SubAccountServiceImpl) peekAppRuntime.getRuntimeService(ISubAccountService.class, "");
        if (subAccountServiceImpl != null) {
            arrayList.addAll(subAccountServiceImpl.getAllSubUin());
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "bindNewSubAccount binded = " + arrayList.size());
        }
        if (arrayList.size() < 2) {
            ArrayList arrayList2 = new ArrayList();
            List<SimpleAccount> allAccounts = peekAppRuntime.getApplication().getAllAccounts();
            if (allAccounts != null && allAccounts.size() > 0) {
                arrayList2.addAll(allAccounts);
            }
            Iterator it = arrayList2.iterator();
            while (true) {
                if (it.hasNext()) {
                    SimpleAccount simpleAccount = (SimpleAccount) it.next();
                    if (simpleAccount != null && !TextUtils.equals(simpleAccount.getUin(), peekAppRuntime.getCurrentUin()) && !arrayList.contains(simpleAccount.getUin())) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            Intent intent = new Intent();
            String str = this.fromWhere;
            if (TextUtils.isEmpty(str)) {
                str = AssociatedAccountActivity.class.getSimpleName();
            }
            if (z16) {
                intent.setClass(this, SubAccountBindActivity.class);
                intent.putExtra("fromWhere", str);
                intent.putExtra("fromWhereForDt", getFromWhereForDt());
                intent.putExtra("fromWhereExactly", this.fromWhereExactly);
                startActivity(intent);
                return;
            }
            intent.putExtra("is_sub_account_login", true);
            intent.putExtra("loginFragmentType", 5);
            intent.putExtra("key_login_page_entrance", 2);
            intent.putExtra("key_login_page_title", getString(R.string.hrx));
            intent.putExtra("sub_login_bind", true);
            intent.putExtra("sub_login_from_where", str);
            RouteUtils.startActivity(this, intent, RouterConstants.UI_ROUTER_LOGIN);
            return;
        }
        com.tencent.mobileqq.subaccount.h.O(peekAppRuntime, this);
    }

    private void checkNeed2ConfirmMsgNum() {
        this.mNeed2ConfirmMsgNum = 0;
        SubAccountServiceImpl subAccountServiceImpl = (SubAccountServiceImpl) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ISubAccountService.class, "");
        Iterator<SubAccountInfo> it = this.mSubAccountList.iterator();
        while (it.hasNext()) {
            if (subAccountServiceImpl.getUnreadAllMsgNum(it.next().subuin) > 0) {
                this.mNeed2ConfirmMsgNum++;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkNeed2ConfirmMsgNum mNeed2ConfirmMsgNum = " + this.mNeed2ConfirmMsgNum);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkParamsInValid(String str, com.tencent.mobileqq.subaccount.logic.a aVar) {
        if (!TextUtils.isEmpty(str) && !isFinishing() && aVar != null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSubAccountParamsInValid(String str, com.tencent.mobileqq.subaccount.logic.b bVar) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!isFinishing() && bVar != null && TextUtils.equals(str, peekAppRuntime.getCurrentUin())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanMessagesUnreadAsync(boolean z16, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "cleanMessagesUnreadAsync");
        }
        ThreadManagerV2.post(new Runnable(z16, str) { // from class: com.tencent.mobileqq.activity.AssociatedAccountActivity.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f174906d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f174907e;

            {
                this.f174906d = z16;
                this.f174907e = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, AssociatedAccountActivity.this, Boolean.valueOf(z16), str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    AssociatedAccountActivity.this.cleanOneSubAccountMessagesUnread(this.f174906d, this.f174907e);
                    AssociatedAccountActivity.this.switchAccount(this.f174907e);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 8, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanOneSubAccountMessagesUnread(boolean z16, String str) {
        boolean z17;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "cleanOneSubAccountMessagesUnread");
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ((IMessageFacade) peekAppRuntime.getRuntimeService(IMessageFacade.class, "")).setReaded(str, 7000);
        ArrayList<SimpleAccount> arrayList = this.mThirdAccountList;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<SimpleAccount> it = this.mThirdAccountList.iterator();
            while (it.hasNext()) {
                SimpleAccount next = it.next();
                if (str.equals(next.getUin())) {
                    com.tencent.mobileqq.subaccount.h.i((AppInterface) peekAppRuntime, next);
                    return;
                }
            }
        }
        ArrayList<SubAccountInfo> arrayList2 = this.mSubAccountList;
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<SubAccountInfo> it5 = this.mSubAccountList.iterator();
            while (it5.hasNext()) {
                if (str.equals(it5.next().subuin)) {
                    AppInterface appInterface = (AppInterface) peekAppRuntime;
                    if (!z16 && this.mNeed2ConfirmMsgNum <= 0) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    com.tencent.mobileqq.subaccount.h.g(appInterface, z17, null, str);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDataList(boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getDataList needChangeReaded = " + z16 + " isRefresh = " + z17);
        }
        if (z17) {
            this.mIsStartRefreshList = true;
        }
        if (this.mIsFromPull) {
            this.mPullReqNeedBackNum = 0;
            this.mIsPullReqSuccess = false;
        }
        getSubAccountDataList(z16);
        ArrayList<SimpleAccount> arrayList = this.mThirdAccountList;
        if (arrayList != null && arrayList.size() > 0) {
            if (System.currentTimeMillis() - this.mLastRefreshTime < 30000 && z17) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.AssociatedAccountActivity.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        SlideDetectListView slideDetectListView = AssociatedAccountActivity.this.mAssociatedqqList;
                        if (slideDetectListView != null) {
                            slideDetectListView.springBackOverScrollHeaderView();
                        }
                    }
                }, 800L);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getDataList current-last<30000ms, startGetThirdQQUnreadNum be ignored.");
                }
            } else {
                AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                if (appInterface == null) {
                    QLog.d(TAG, 1, "app is null");
                    return;
                }
                boolean P = com.tencent.mobileqq.subaccount.h.P(appInterface, false);
                if (this.mIsFromPull && P) {
                    this.mPullReqNeedBackNum++;
                }
                if (z17) {
                    this.mLastRefreshTime = System.currentTimeMillis();
                }
            }
        }
        if (this.mIsFromPull && this.mPullReqNeedBackNum == 0) {
            this.mIsStartRefreshList = false;
            this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.AssociatedAccountActivity.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    AssociatedAccountActivity associatedAccountActivity = AssociatedAccountActivity.this;
                    if (associatedAccountActivity.mAssociatedqqList != null) {
                        associatedAccountActivity.mTopRefreshTop.l(0);
                        AssociatedAccountActivity.this.mAssociatedqqList.springBackOverScrollHeaderView();
                    }
                }
            }, 800L);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getDataList mPullReqNeedBackNum = " + this.mPullReqNeedBackNum);
        }
    }

    private String getFromWhereForDt() {
        int i3 = this.fromWhereExactly;
        if (i3 == 2) {
            if (this.mIsFromAccountManage) {
                return "4";
            }
            return "3";
        }
        if (i3 == 1) {
            if (this.mIsFromAccountManage) {
                return "2";
            }
            return "1";
        }
        return "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoManageAssociatedAccount() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "gotoManageAssociatedAccount");
        }
        Intent intent = new Intent();
        intent.setClass(this, AssociatedAccountManageActivity.class);
        if (this.mIsFromAccountManage) {
            intent.putExtra("fromWhere", ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getAccountManagerName());
        }
        startActivityForResult(intent, 1012);
        overridePendingTransition(R.anim.f154454a3, R.anim.f154442w);
    }

    private void initData() {
        this.mItemDataList = new ArrayList<>();
        com.tencent.mobileqq.adapter.b bVar = new com.tencent.mobileqq.adapter.b(this, this.mItemDataList, this.mOnItemClickListener);
        this.mAdapter = bVar;
        this.mAssociatedqqList.setAdapter((ListAdapter) bVar);
        this.thirdAccountsDataList = new ArrayList<>();
        com.tencent.mobileqq.adapter.b bVar2 = new com.tencent.mobileqq.adapter.b(this, this.thirdAccountsDataList, this.mOnItemClickListener);
        this.thirdAccountsAdapter = bVar2;
        this.thirdAccountsListView.setAdapter((ListAdapter) bVar2);
        loadAccountList();
        loadItemDataList();
    }

    private void initUI() {
        String str;
        setTitle(R.string.z6k);
        this.quiSecNavBar.setRightType(1);
        this.quiSecNavBar.setRightText(getString(R.string.hr5));
        this.quiSecNavBar.setOnBaseTitleBarClickListener(new Function2() { // from class: com.tencent.mobileqq.activity.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit lambda$initUI$0;
                lambda$initUI$0 = AssociatedAccountActivity.this.lambda$initUI$0((View) obj, (BaseAction) obj2);
                return lambda$initUI$0;
            }
        });
        this.quiSecNavBar.setBaseViewDescription(BaseAction.ACTION_LEFT_BUTTON, HardCodeUtil.qqStr(R.string.f170549u3));
        MobileQQ.sMobileQQ.peekAppRuntime();
        QUISingleLineListItem qUISingleLineListItem = (QUISingleLineListItem) findViewById(R.id.yjm);
        this.mSubAccountNotifyListItem = qUISingleLineListItem;
        qUISingleLineListItem.setVisibility(0);
        this.mSubAccountNotifyListItem.setBackgroundType(QUIListItemBackgroundType.AllRound);
        this.mSubAccountNotifyListItem.setStyle(QUIListItemStyle.Card);
        this.mSubAccountConfig = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(getString(R.string.f229616wx)), new x.c.f(false, null));
        updateSubAccountNotifySwitch();
        this.mSubAccountConfig.O().h(new g());
        this.mSubAccountNotifyListItem.setConfig(this.mSubAccountConfig.K(), this.mSubAccountConfig.O());
        this.mAssociatedqqList = (SlideDetectListView) findViewById(R.id.j67);
        this.thirdRootLayout = findViewById(R.id.f96485ht);
        HorizontalListView horizontalListView = (HorizontalListView) findViewById(R.id.f96475hs);
        this.thirdAccountsListView = horizontalListView;
        horizontalListView.setDividerWidth(ViewUtils.dip2px(22.0f));
        SubAccountPullRefreshHeader subAccountPullRefreshHeader = new SubAccountPullRefreshHeader(this);
        this.mTopRefreshTop = subAccountPullRefreshHeader;
        this.mAssociatedqqList.setOverScrollHeader(subAccountPullRefreshHeader);
        this.mTopRefreshTop.getLayoutParams().height = ViewUtils.dpToPx(50.0f);
        this.mTopRefreshTop.getLayoutParams().width = -1;
        this.mAssociatedqqList.setOverScrollListener(this.mScrollViewListener);
        VideoReport.setElementId(this.mSubAccountNotifyListItem, "em_bas_associate_account_switch");
        QUISingleLineListItem qUISingleLineListItem2 = this.mSubAccountNotifyListItem;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        VideoReport.setElementEndExposePolicy(qUISingleLineListItem2, endExposurePolicy);
        QUISingleLineListItem qUISingleLineListItem3 = this.mSubAccountNotifyListItem;
        if (this.mSubAccountConfig.O().getIsChecked()) {
            str = "1";
        } else {
            str = "2";
        }
        VideoReport.setElementParam(qUISingleLineListItem3, "switch_current_state", str);
        View g16 = this.quiSecNavBar.g(BaseAction.ACTION_RIGHT_TEXT);
        VideoReport.setElementId(g16, "em_bas_associate_account_management_button");
        VideoReport.setElementEndExposePolicy(g16, endExposurePolicy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$initUI$0(View view, BaseAction baseAction) {
        boolean z16;
        if (baseAction == BaseAction.ACTION_RIGHT_TEXT) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            ReportController.y(peekAppRuntime, "0X800C47A");
            if (((SubAccountServiceImpl) peekAppRuntime.getRuntimeService(ISubAccountService.class, "")).getBindedNumber() >= 2) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "click top right manage btn underTwo = " + z16);
            }
            showSettingDialog(z16);
            return null;
        }
        if (baseAction == BaseAction.ACTION_LEFT_BUTTON) {
            onBackEvent();
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRefreshRequestBack(boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "onRefreshRequestBack() mPullReqNeedBackNum = " + this.mPullReqNeedBackNum);
        }
        int i3 = this.mPullReqNeedBackNum - 1;
        this.mPullReqNeedBackNum = i3;
        if (z16 && !this.mIsPullReqSuccess) {
            this.mIsPullReqSuccess = true;
        }
        if (i3 <= 0) {
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "onRefreshRequestBack() end");
            }
            this.mIsStartRefreshList = false;
            this.mPullReqNeedBackNum = 0;
            this.mIsFromPull = false;
            this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.AssociatedAccountActivity.9
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    int i16 = 2;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    AssociatedAccountActivity associatedAccountActivity = AssociatedAccountActivity.this;
                    if (associatedAccountActivity.mAssociatedqqList != null) {
                        SubAccountPullRefreshHeader subAccountPullRefreshHeader = associatedAccountActivity.mTopRefreshTop;
                        if (associatedAccountActivity.mIsPullReqSuccess) {
                            i16 = 0;
                        }
                        subAccountPullRefreshHeader.l(i16);
                        AssociatedAccountActivity.this.mAssociatedqqList.springBackOverScrollHeaderView();
                    }
                }
            }, 800L);
            if (this.mIsPullReqSuccess) {
                loadItemDataList();
            }
            this.mIsPullReqSuccess = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshAllData(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "refreshAllData direct=" + z16);
        }
        if (isFinishing()) {
            return;
        }
        if (z16) {
            loadAccountList();
            loadItemDataList();
        } else {
            this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.AssociatedAccountActivity.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssociatedAccountActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(AssociatedAccountActivity.TAG, 2, "refreshAllData isFinishing() = " + AssociatedAccountActivity.this.isFinishing());
                    }
                    if (AssociatedAccountActivity.this.isFinishing()) {
                        return;
                    }
                    AssociatedAccountActivity.this.loadAccountList();
                    AssociatedAccountActivity.this.loadItemDataList();
                }
            });
        }
    }

    private void reportNotificationClick() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null && extras.getBoolean(AppConstants.Key.KEY_NOTIFICATION_CLICK_ACTION, false)) {
            ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C1C0", "0X800C1C0", 0, 2, "4", "", "", "");
        }
    }

    private void setCommonPageInfo(Map<String, Object> map) {
        String str;
        String str2;
        map.put("muin", MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin());
        SubAccountInfo subAccountInfo = this.curSubAccountInfo;
        if (subAccountInfo == null) {
            str = "";
        } else {
            str = subAccountInfo.subuin;
        }
        map.put("correlation_uin", str);
        if (this.mIsFromAccountManage) {
            str2 = "2";
        } else {
            str2 = "1";
        }
        map.put("correlation_page_source", str2);
    }

    private void setPageInfo() {
        String str;
        VideoReport.addToDetectionWhitelist(this);
        VideoReport.setPageId(this.titleRoot, "pg_bas_myassociated_QQ_account");
        HashMap hashMap = new HashMap();
        setCommonPageInfo(hashMap);
        if (this.mSubAccountConfig.O().getIsChecked()) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("is_message_reminder_switch", str);
        VideoReport.setPageParams(this.titleRoot, new PageParams(hashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showConfirmDialog() {
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(getActivity(), null);
        actionSheet.setMainTitle(R.string.i_n);
        actionSheet.addButton(R.string.f171151ok, 3, R.id.m_5);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new f(actionSheet));
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        actionSheet.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.activity.c
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ReportController.y(AppRuntime.this, "0X800C483");
            }
        });
        actionSheet.show();
        VideoReport.setPageId(actionSheet, "pg_bas_clear_the_message_float");
        HashMap hashMap = new HashMap();
        setCommonPageInfo(hashMap);
        VideoReport.setPageParams(actionSheet, new PageParams(hashMap));
        VideoReport.setElementId(actionSheet.findViewById(R.id.m_5), "em_bas_clear_message");
        View findViewById = actionSheet.findViewById(R.id.m_5);
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        VideoReport.setElementEndExposePolicy(findViewById, endExposurePolicy);
        VideoReport.setElementId(actionSheet.findViewById(R.id.action_sheet_btnCancel), "em_bas_cancel_clear_message");
        VideoReport.setElementEndExposePolicy(actionSheet.findViewById(R.id.action_sheet_btnCancel), endExposurePolicy);
    }

    private void showSettingDialog(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "showSettingDialog underTwo = " + z16);
        }
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
        if (z16) {
            actionSheet.addButton(getResources().getString(R.string.f173173hr2), 5, R.id.f164008sd1);
        }
        actionSheet.addButton(getResources().getString(R.string.i_m), 5, R.id.txp);
        actionSheet.addButton(getResources().getString(R.string.hr6), 5, R.id.ywp);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new j(actionSheet));
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        actionSheet.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.activity.d
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ReportController.y(AppRuntime.this, "0X800C481");
            }
        });
        actionSheet.show();
        VideoReport.setPageId(actionSheet, "pg_bas_management_float");
        HashMap hashMap = new HashMap();
        setCommonPageInfo(hashMap);
        VideoReport.setPageParams(actionSheet, new PageParams(hashMap));
        VideoReport.setElementId(actionSheet.findViewById(R.id.f164008sd1), "em_bas_add_associated_qq_account");
        View findViewById = actionSheet.findViewById(R.id.f164008sd1);
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        VideoReport.setElementEndExposePolicy(findViewById, endExposurePolicy);
        VideoReport.setElementId(actionSheet.findViewById(R.id.txp), "em_bas_clear_message");
        VideoReport.setElementEndExposePolicy(actionSheet.findViewById(R.id.txp), endExposurePolicy);
        VideoReport.setElementId(actionSheet.findViewById(R.id.ywp), "em_bas_manage_qq");
        VideoReport.setElementEndExposePolicy(actionSheet.findViewById(R.id.ywp), endExposurePolicy);
        VideoReport.setElementId(actionSheet.findViewById(R.id.action_sheet_btnCancel), "em_bas_cancel_float");
        VideoReport.setElementEndExposePolicy(actionSheet.findViewById(R.id.action_sheet_btnCancel), endExposurePolicy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchAccount(String str) {
        SimpleAccount simpleAccount;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "switchAccount to Uin = " + str);
        }
        if (str == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        List<SimpleAccount> allAccounts = peekAppRuntime.getApplication().getAllAccounts();
        if (allAccounts != null && allAccounts.size() > 0) {
            arrayList.addAll(allAccounts);
        }
        if (arrayList.size() < 1) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                simpleAccount = (SimpleAccount) it.next();
                if (simpleAccount.getUin().equalsIgnoreCase(str)) {
                    break;
                }
            } else {
                simpleAccount = null;
                break;
            }
        }
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        if (simpleAccount != null && !TextUtils.equals(currentUin, simpleAccount.getUin())) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "switchAccount change ");
            }
            this.mCurrentSwitchUin = str;
            this.mClick2Switch = true;
            if (simpleAccount.isLogined()) {
                ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginStart(2, 8, simpleAccount.getUin());
            }
            sendBroadcast(new Intent("before_account_change"));
            ((IDirectLoginService) QRoute.api(IDirectLoginService.class)).switchAccount(simpleAccount.getUin(), null);
            ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).setLoginType(simpleAccount.getUin(), (byte) 0);
            com.tencent.mobileqq.subaccount.f.f(peekAppRuntime, this);
            com.tencent.mobileqq.subaccount.a.a();
            return;
        }
        hideJuhua();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "switchAccount no change ");
        }
    }

    private void switchFail() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "switchFail");
        }
        if (TextUtils.isEmpty(this.mCurrentSwitchUin)) {
            return;
        }
        dimissDialog();
        QQCustomDialog message = DialogUtil.createCustomDialog(this, 230).setTitle(getString(R.string.f173179hs4)).setMessage(getString(R.string.f173178hs3));
        message.setPositiveButton(R.string.f171151ok, new h());
        message.setCancelable(true);
        message.show();
    }

    private void updateDataList() {
        if (this.thirdRootLayout != null && this.thirdAccountsAdapter != null && this.mAdapter != null) {
            if (this.mThirdAccountList.size() > 0) {
                this.thirdRootLayout.setVisibility(0);
                this.thirdAccountsAdapter.notifyDataSetChanged();
            } else {
                this.thirdRootLayout.setVisibility(8);
            }
            this.mAdapter.notifyDataSetChanged();
            checkNeed2ConfirmMsgNum();
        }
    }

    private void updateRightTextView(boolean z16) {
        this.quiSecNavBar.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, z16);
    }

    private void updateSubAccountNotifySwitch() {
        this.mSubAccountConfig.O().f(SettingCloneUtil.readValue((Context) this, MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), (String) null, AppConstants.QQSETTING_SUBACCOUNT_NOTIFY, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateThirdQQUnread(com.tencent.mobileqq.subaccount.logic.b bVar) {
        Object obj;
        ArrayList<com.tencent.mobileqq.subaccount.b> arrayList = this.thirdAccountsDataList;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<com.tencent.mobileqq.subaccount.b> it = this.thirdAccountsDataList.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                com.tencent.mobileqq.subaccount.b next = it.next();
                if (next != null && next.f291092a == 6 && (obj = next.f291103l) != null) {
                    SimpleAccount simpleAccount = (SimpleAccount) obj;
                    AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                    if (appInterface == null) {
                        QLog.d(TAG, 1, "app is null");
                        return;
                    }
                    int s16 = com.tencent.mobileqq.subaccount.h.s(appInterface, simpleAccount.getUin());
                    if (next.f291098g != s16) {
                        next.f291098g = s16;
                        z16 = true;
                    }
                }
            }
            if (z16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "updateThirdQQUnread changed");
                }
                this.thirdAccountsAdapter.notifyDataSetChanged();
            }
        }
    }

    public void cleanMessagesUnread(boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "cleanMessagesUnread");
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ArrayList<SimpleAccount> arrayList = this.mThirdAccountList;
        if ((arrayList != null && arrayList.size() > 0) || this.mIsFromAccountManage) {
            com.tencent.mobileqq.subaccount.h.f((AppInterface) peekAppRuntime);
        }
        ArrayList<SubAccountInfo> arrayList2 = this.mSubAccountList;
        if (arrayList2 != null && arrayList2.size() > 0) {
            ((IMessageFacade) peekAppRuntime.getRuntimeService(IMessageFacade.class, "")).setReaded(AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000);
            AppInterface appInterface = (AppInterface) peekAppRuntime;
            if (!z16 && this.mNeed2ConfirmMsgNum <= 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            com.tencent.mobileqq.subaccount.h.e(appInterface, z17, null);
        }
    }

    @Override // com.tencent.mobileqq.activity.SubAccountBaseActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnActivityResult requestCode = " + i3 + " resultCode=" + i16);
        }
        if (i3 != 1011) {
            if (i3 == 1012) {
                boolean q16 = com.tencent.mobileqq.subaccount.h.q((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime());
                if (i16 == -1 || this.mIsDisplayThirdQQChecked != q16) {
                    this.mIsDisplayThirdQQChecked = q16;
                    refreshAllData(true);
                    return;
                }
                return;
            }
            return;
        }
        if (i16 == -1) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.SubAccountBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        this.mNeedStatusTrans = false;
        super.doOnCreate(bundle);
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        super.setContentView(R.layout.bzr);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        this.mIsDisplayThirdFuc = com.tencent.mobileqq.subaccount.h.E(appInterface, true);
        this.mIsDisplayThirdQQChecked = com.tencent.mobileqq.subaccount.h.q(appInterface);
        if (getIntent() != null && TextUtils.equals(getIntent().getStringExtra("fromWhere"), ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getAccountManagerName())) {
            this.mIsFromAccountManage = true;
        }
        initUI();
        initData();
        addObserver(this.mFriendObserver);
        addObserver(this.mAvatarObserver);
        addObserver(this.mSubAccountBindObserver);
        addObserver(this.mMsgObserver);
        appInterface.setHandler(getClass(), this.mHandler);
        ((IMessageFacade) peekAppRuntime.getRuntimeService(IMessageFacade.class, "")).addObserver(this);
        sendBroadcast(new Intent("before_account_change"));
        com.tencent.mobileqq.subaccount.f.b(peekAppRuntime);
        com.tencent.mobileqq.subaccount.f.d(peekAppRuntime);
        if (isNetConn()) {
            getDataList(false, false);
        }
        this.mTopRefreshTop.h(0L);
        setPageInfo();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.SubAccountBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnDestroy();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnDestroy");
        }
        removeObserver(this.mFriendObserver);
        removeObserver(this.mAvatarObserver);
        removeObserver(this.mSubAccountBindObserver);
        removeObserver(this.mMsgObserver);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ((AppInterface) peekAppRuntime).removeHandler(getClass());
        ((IMessageFacade) peekAppRuntime.getRuntimeService(IMessageFacade.class, "")).deleteObserver(this);
        this.mHandler.removeCallbacksAndMessages(null);
        hideJuhua();
        SlideDetectListView slideDetectListView = this.mAssociatedqqList;
        if (slideDetectListView != null) {
            slideDetectListView.setOverscrollHeader(null);
            this.mAssociatedqqList.setOverScrollListener(null);
            this.mAssociatedqqList.setAdapter((ListAdapter) null);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.doOnPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ReportController.y(MobileQQ.sMobileQQ.peekAppRuntime(), "0X800C477");
        reportNotificationClick();
        super.doOnResume();
        hideJuhua();
        if (!this.mIsFirstResume) {
            updateSubAccountStatus();
        }
        this.mIsFirstResume = false;
    }

    public void getSubAccountDataList(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface == null) {
            QLog.d(TAG, 1, "app is null");
            return;
        }
        ISubAccountService iSubAccountService = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "");
        Iterator<SubAccountInfo> it = this.mSubAccountList.iterator();
        while (it.hasNext()) {
            SubAccountInfo next = it.next();
            if (iSubAccountService != null) {
                if (z16) {
                    iSubAccountService.setAllMessageReaded(next.subuin);
                }
                iSubAccountService.cancelHintIsNew(next.subuin);
            }
            com.tencent.mobileqq.subaccount.h.G(appInterface, next.subuin, false);
            if (this.mIsFromPull) {
                this.mPullReqNeedBackNum++;
            }
            if (!((ISubAccountConfigApi) QRoute.api(ISubAccountConfigApi.class)).getIsHideSubAccountTroopMsg()) {
                ((ISubAccountServlet) QRoute.api(ISubAccountServlet.class)).fetchOneTroopNewMsg(appInterface, next.subuin);
            }
        }
    }

    public void handleCleanAllMessage(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) appInterface, (Object) str);
            return;
        }
        SubAccountServiceImpl subAccountServiceImpl = (SubAccountServiceImpl) appInterface.getRuntimeService(ISubAccountService.class, "");
        Iterator<SubAccountInfo> it = this.mSubAccountList.iterator();
        while (it.hasNext()) {
            subAccountServiceImpl.removeAllMessage(it.next().subuin);
        }
        cleanMessagesUnread(true);
        showQQToastSuccess(str);
        loadItemDataList();
    }

    public void initCurSubAccountInfo() {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            str = intent.getStringExtra("subAccount");
            intent.removeExtra("subAccount");
        } else {
            str = null;
        }
        SubAccountInfo subAccountInfo = this.curSubAccountInfo;
        if (subAccountInfo != null) {
            str = subAccountInfo.subuin;
        }
        if (this.mSubAccountList.size() > 0) {
            if (!TextUtils.isEmpty(str)) {
                Iterator<SubAccountInfo> it = this.mSubAccountList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        SubAccountInfo next = it.next();
                        if (!TextUtils.isEmpty(next.subuin) && next.subuin.equals(str)) {
                            this.curSubAccountInfo = next;
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    this.curSubAccountInfo = null;
                }
            }
            if (this.curSubAccountInfo == null) {
                this.curSubAccountInfo = this.mSubAccountList.get(0);
                return;
            }
            return;
        }
        this.curSubAccountInfo = null;
    }

    public void initThirdAccount(List<SimpleAccount> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) list);
            return;
        }
        ArrayList<SimpleAccount> arrayList = this.mThirdAccountList;
        if (arrayList == null) {
            this.mThirdAccountList = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "loadAccountList mThirdAccountList.mIsDisplayThirdFuc = ", Boolean.valueOf(this.mIsDisplayThirdFuc), " mIsFromAccountManage=", Boolean.valueOf(this.mIsFromAccountManage), " mIsDisplayThirdQQChecked=", Boolean.valueOf(this.mIsDisplayThirdQQChecked));
        }
        if (this.mIsDisplayThirdFuc && !this.mIsFromAccountManage && this.mIsDisplayThirdQQChecked) {
            ArrayList<SimpleAccount> arrayList2 = new ArrayList();
            if (list != null && list.size() > 0) {
                arrayList2.addAll(list);
            }
            if (arrayList2.size() > 0) {
                String account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
                for (SimpleAccount simpleAccount : arrayList2) {
                    if (simpleAccount != null && !account.equals(simpleAccount.getUin())) {
                        Iterator<SubAccountInfo> it = this.mSubAccountList.iterator();
                        boolean z16 = false;
                        while (it.hasNext()) {
                            SubAccountInfo next = it.next();
                            if (next != null && simpleAccount.getUin().equals(next.subuin)) {
                                z16 = true;
                            }
                        }
                        if (!z16) {
                            this.mThirdAccountList.add(simpleAccount);
                        }
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "loadAccountList mThirdAccountList.size() = " + this.mThirdAccountList.size());
            }
        }
    }

    public void loadAccountList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "loadAccountList");
        }
        ArrayList<SubAccountInfo> arrayList = this.mSubAccountList;
        if (arrayList == null) {
            this.mSubAccountList = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        this.mSubAccountList.addAll(((SubAccountServiceImpl) peekAppRuntime.getRuntimeService(ISubAccountService.class, "")).getAllSubAccountInfo());
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "loadAccountList mSubAccountList.size() = " + this.mSubAccountList.size());
        }
        List<SimpleAccount> allAccounts = peekAppRuntime.getApplication().getAllAccounts();
        initThirdAccount(allAccounts);
        if (this.mSubAccountList.size() <= 0 && this.mThirdAccountList.size() <= 0 && (this.mIsDisplayThirdQQChecked || allAccounts == null || allAccounts.size() <= 1)) {
            updateRightTextView(false);
        } else {
            updateRightTextView(true);
        }
        initCurSubAccountInfo();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadItemDataList() {
        int i3;
        boolean z16;
        String str;
        String str2;
        int i16;
        int i17;
        boolean z17;
        Iterator it;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        int i18 = 2;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "loadItemDataList");
        }
        ArrayList arrayList = new ArrayList();
        if (this.mSubAccountList.size() > 0) {
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            if (appInterface == null) {
                QLog.d(TAG, 1, "app is null");
                return;
            }
            SubAccountServiceImpl subAccountServiceImpl = (SubAccountServiceImpl) appInterface.getRuntimeService(ISubAccountService.class, "");
            int size = this.mSubAccountList.size();
            ArrayList arrayList2 = new ArrayList();
            List<SimpleAccount> allAccounts = appInterface.getApplication().getAllAccounts();
            if (allAccounts != null && allAccounts.size() > 0) {
                arrayList2.addAll(allAccounts);
            }
            ArrayList arrayList3 = new ArrayList(size);
            int i19 = 0;
            boolean z18 = false;
            while (i19 < size) {
                SubAccountInfo subAccountInfo = this.mSubAccountList.get(i19);
                if (subAccountInfo != null && !TextUtils.isEmpty(subAccountInfo.subuin)) {
                    com.tencent.mobileqq.subaccount.b bVar = new com.tencent.mobileqq.subaccount.b();
                    bVar.f291092a = i18;
                    IFriendDataService iFriendDataService = (IFriendDataService) appInterface.getRuntimeService(IFriendDataService.class, "");
                    if (iFriendDataService != null) {
                        Friends friendFromMemoryCache = iFriendDataService.getFriendFromMemoryCache(subAccountInfo.subuin);
                        if (friendFromMemoryCache != null) {
                            str = friendFromMemoryCache.name;
                            if (TextUtils.isEmpty(str)) {
                                str = subAccountInfo.subuin;
                            }
                            bVar.f291093b = str;
                            str2 = subAccountInfo.subuin;
                            bVar.f291096e = str2;
                            bVar.f291103l = subAccountInfo;
                            bVar.f291094c = "";
                            if (!str2.equals(this.curSubAccountInfo.subuin)) {
                                i16 = 1;
                                bVar.f291102k = true;
                            } else {
                                i16 = 1;
                                bVar.f291102k = false;
                            }
                            if (subAccountInfo.status == i16) {
                                bVar.f291101j = i16;
                                Iterator it5 = arrayList2.iterator();
                                while (true) {
                                    if (it5.hasNext()) {
                                        SimpleAccount simpleAccount = (SimpleAccount) it5.next();
                                        if (simpleAccount != null) {
                                            it = it5;
                                            if (TextUtils.equals(subAccountInfo.subuin, simpleAccount.getUin()) && simpleAccount.isLogined()) {
                                                z17 = true;
                                                break;
                                            }
                                        } else {
                                            it = it5;
                                        }
                                        it5 = it;
                                    } else {
                                        z17 = false;
                                        break;
                                    }
                                }
                                if (z17) {
                                    i16 = 1;
                                    bVar.f291100i = true;
                                    i17 = 0;
                                } else {
                                    i16 = 1;
                                    i17 = 0;
                                    bVar.f291100i = false;
                                }
                            } else {
                                i17 = 0;
                                bVar.f291101j = 0;
                            }
                            bVar.f291095d = i17;
                            if (AppSetting.f99565y) {
                                Object[] objArr = new Object[i16];
                                objArr[i17] = bVar.f291093b;
                                bVar.f291099h = getString(R.string.hre, objArr);
                            }
                            if (subAccountInfo.subuin.equals(this.curSubAccountInfo.subuin)) {
                                z18 = bVar.f291100i;
                            }
                            arrayList3.add(bVar);
                        } else {
                            iFriendDataService.getFriend(subAccountInfo.subuin, (uc1.b<Friends>) null);
                        }
                    }
                    str = "";
                    if (TextUtils.isEmpty(str)) {
                    }
                    bVar.f291093b = str;
                    str2 = subAccountInfo.subuin;
                    bVar.f291096e = str2;
                    bVar.f291103l = subAccountInfo;
                    bVar.f291094c = "";
                    if (!str2.equals(this.curSubAccountInfo.subuin)) {
                    }
                    if (subAccountInfo.status == i16) {
                    }
                    bVar.f291095d = i17;
                    if (AppSetting.f99565y) {
                    }
                    if (subAccountInfo.subuin.equals(this.curSubAccountInfo.subuin)) {
                    }
                    arrayList3.add(bVar);
                }
                i19++;
                i18 = 2;
            }
            com.tencent.mobileqq.subaccount.b bVar2 = new com.tencent.mobileqq.subaccount.b();
            bVar2.f291092a = 2;
            bVar2.f291103l = arrayList3;
            bVar2.f291094c = "";
            bVar2.f291100i = z18;
            arrayList.add(bVar2);
            List<SubAccountMessage> allMessage = subAccountServiceImpl.getAllMessage(this.curSubAccountInfo.subuin);
            if (allMessage != null && allMessage.size() > 0) {
                int size2 = allMessage.size();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "loadItemDataList subaccount msg msgSize = " + size2);
                }
                if (size2 > 0) {
                    ArrayList<String> v3 = com.tencent.mobileqq.subaccount.h.v(appInterface, this.curSubAccountInfo.subuin);
                    for (int i26 = 0; i26 < size2; i26++) {
                        SubAccountMessage subAccountMessage = allMessage.get(i26);
                        com.tencent.mobileqq.subaccount.b bVar3 = new com.tencent.mobileqq.subaccount.b();
                        bVar3.f291092a = 3;
                        if (i26 == size2 - 1) {
                            i3 = 2;
                            bVar3.f291095d = 2;
                            z16 = true;
                        } else {
                            i3 = 2;
                            z16 = true;
                            bVar3.f291095d = 1;
                        }
                        if (v3 != null && v3.contains(subAccountMessage.senderuin)) {
                            bVar3.f291097f = i3;
                        }
                        if (i26 == 0) {
                            bVar3.f291102k = z16;
                        }
                        bVar3.f291103l = subAccountMessage;
                        bVar3.f291100i = z18;
                        arrayList.add(bVar3);
                    }
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "loadItemDataList subaccount no msg");
                }
                com.tencent.mobileqq.subaccount.b bVar4 = new com.tencent.mobileqq.subaccount.b();
                bVar4.f291092a = 7;
                bVar4.f291102k = true;
                bVar4.f291095d = 3;
                bVar4.f291103l = this.curSubAccountInfo;
                bVar4.f291100i = z18;
                arrayList.add(bVar4);
            }
        } else {
            com.tencent.mobileqq.subaccount.b bVar5 = new com.tencent.mobileqq.subaccount.b();
            bVar5.f291092a = 4;
            bVar5.f291095d = 3;
            bVar5.f291093b = getResources().getString(R.string.f173173hr2);
            bVar5.f291096e = getResources().getString(R.string.f173174hr3);
            if (AppSetting.f99565y) {
                bVar5.f291099h = bVar5.f291093b + "," + bVar5.f291096e;
            }
            arrayList.add(bVar5);
        }
        this.mItemDataList.clear();
        this.mItemDataList.addAll(arrayList);
        loadThirdAccountsDataList();
        updateDataList();
    }

    public void loadThirdAccountsDataList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (this.mThirdAccountList.size() > 0) {
            ArrayList arrayList = new ArrayList(this.mThirdAccountList.size());
            int size = this.mThirdAccountList.size();
            for (int i3 = 0; i3 < size; i3++) {
                SimpleAccount simpleAccount = this.mThirdAccountList.get(i3);
                com.tencent.mobileqq.subaccount.b bVar = new com.tencent.mobileqq.subaccount.b();
                bVar.f291092a = 6;
                AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                if (appInterface == null) {
                    QLog.d(TAG, 1, "app is null");
                    return;
                }
                bVar.f291093b = com.tencent.mobileqq.subaccount.h.u(appInterface, simpleAccount);
                bVar.f291098g = com.tencent.mobileqq.subaccount.h.s(appInterface, simpleAccount.getUin());
                bVar.f291103l = simpleAccount;
                if (AppSetting.f99565y) {
                    bVar.f291099h = bVar.f291093b;
                }
                arrayList.add(bVar);
            }
            this.thirdAccountsDataList.clear();
            this.thirdAccountsDataList.addAll(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.SubAccountBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onAccountChanged() mClick2Switch=" + this.mClick2Switch);
        }
        super.onAccountChanged();
        removeObserver(this.mFriendObserver);
        removeObserver(this.mAvatarObserver);
        removeObserver(this.mMsgObserver);
        removeObserver(this.mSubAccountBindObserver);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((IMessageFacade) peekAppRuntime.getRuntimeService(IMessageFacade.class, "")).deleteObserver(this);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (peekAppRuntime != null) {
            ((AppInterface) peekAppRuntime).removeHandler(getClass());
        }
        com.tencent.mobileqq.subaccount.f.g((AppInterface) peekAppRuntime, this);
        hideJuhua();
        if (!TextUtils.isEmpty(this.mCurrentSwitchUin)) {
            ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginFinish(true, "");
        }
        this.mCurrentSwitchUin = null;
        Intent intent = new Intent();
        intent.putExtra(((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getTabIndex(), com.tencent.mobileqq.activity.home.impl.a.f183038a);
        intent.setFlags(67108864);
        RouteUtils.startActivity(this, intent, RouterConstants.UI_ROUTER_SPLASH);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void onAccoutChangeFailed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onAccoutChangeFailed");
        }
        hideJuhua();
        switchFail();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ArrayList<SimpleAccount> arrayList = this.mThirdAccountList;
        if (arrayList != null && arrayList.size() > 0 && !this.mIsFromAccountManage) {
            com.tencent.mobileqq.subaccount.h.f((AppInterface) peekAppRuntime);
        }
        if (peekAppRuntime != null) {
            Contact contact = new Contact(131, AppConstants.SUBACCOUNT_ASSISTANT_UIN, "");
            com.tencent.qqnt.kernel.api.w msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getMsgService();
            if (msgService != null) {
                msgService.setMsgRead(contact, new i());
            }
        }
        if (!this.mIsFromAccountManage) {
            Intent intent = new Intent();
            intent.putExtra(((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getTabIndex(), com.tencent.mobileqq.activity.home.impl.a.f183038a);
            RouteUtils.startActivity(this, intent, RouterConstants.UI_ROUTER_SPLASH);
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.activity.SubAccountBaseActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) observable, obj);
            return;
        }
        if (obj instanceof String[]) {
            String[] strArr = (String[]) obj;
            if (strArr.length == 2 && AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(strArr[0])) {
                runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.AssociatedAccountActivity.17
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssociatedAccountActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            AssociatedAccountActivity.this.loadItemDataList();
                        }
                    }
                });
            }
        }
    }

    public boolean updateSubAccountStatus() {
        ArrayList<SubAccountInfo> arrayList;
        com.tencent.mobileqq.adapter.b bVar;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        ArrayList<com.tencent.mobileqq.subaccount.b> arrayList2 = this.mItemDataList;
        if (arrayList2 == null || arrayList2.size() <= 0 || (arrayList = this.mSubAccountList) == null || arrayList.size() <= 0) {
            return false;
        }
        SubAccountServiceImpl subAccountServiceImpl = null;
        boolean z16 = false;
        for (int i3 = 0; i3 < this.mItemDataList.size(); i3++) {
            com.tencent.mobileqq.subaccount.b bVar2 = this.mItemDataList.get(i3);
            if (bVar2.f291092a == 2 && (obj = bVar2.f291103l) != null && (obj instanceof ArrayList)) {
                if (subAccountServiceImpl == null) {
                    subAccountServiceImpl = (SubAccountServiceImpl) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ISubAccountService.class, "");
                }
                if (subAccountServiceImpl != null) {
                    Iterator it = ((ArrayList) bVar2.f291103l).iterator();
                    while (it.hasNext()) {
                        com.tencent.mobileqq.subaccount.b bVar3 = (com.tencent.mobileqq.subaccount.b) it.next();
                        int status = subAccountServiceImpl.getStatus(((SubAccountInfo) bVar3.f291103l).subuin);
                        if ((status == 1 && bVar3.f291101j != 0) || (status != 1 && bVar3.f291101j == 0)) {
                            if (status == 1) {
                                bVar3.f291101j = 0;
                            } else {
                                bVar3.f291101j = 1;
                            }
                            z16 = true;
                        }
                    }
                }
            }
        }
        if (z16 && (bVar = this.mAdapter) != null) {
            bVar.notifyDataSetChanged();
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }
}
