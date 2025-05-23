package com.tencent.mobileqq.qwallet.transaction.impl;

import Wallet.PfaFriend;
import Wallet.PfaFriendRqt;
import Wallet.PfaFriendRsp;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.biz.eqq.api.ICrmApi;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.transaction.IToPayManager;
import com.tencent.mobileqq.qwallet.utils.j;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class ToPayManagerImpl implements IToPayManager {
    private static final String TAG = "TopayManager";
    public static WeakReference<IToPayManager.a> gWeakListener = null;
    protected static WeakReference<QWalletPayProgressDialog> gWeakProgress = null;
    protected static int mBusinessSubType = 0;
    protected static int mBusinessType = 0;
    public static PfaFriendRsp mData = null;
    public static int mLoadedFromFileState = -1;
    protected static Handler mHandler = new a(Looper.getMainLooper());
    protected static BusinessObserver mRecentListObserver = null;

    /* loaded from: classes16.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            PfaFriendRsp pfaFriendRsp;
            boolean z16;
            if (message.what == ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getGetRecentListType()) {
                Object obj = message.obj;
                if (obj != null && (obj instanceof PfaFriendRsp)) {
                    pfaFriendRsp = (PfaFriendRsp) obj;
                } else {
                    pfaFriendRsp = null;
                }
                boolean z17 = false;
                if (message.arg1 == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (message.arg2 == 1) {
                    z17 = true;
                }
                ToPayManagerImpl.onGetRecomendList(z16, pfaFriendRsp, z17);
            }
        }
    }

    /* loaded from: classes16.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference f279220d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f279221e;

        b(WeakReference weakReference, ArrayList arrayList) {
            this.f279220d = weakReference;
            this.f279221e = arrayList;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ArrayList<PfaFriend> arrayList;
            String str;
            if ((dialogInterface instanceof QQCustomDialog) && i3 == 1) {
                ToPayManagerImpl.sendTopay((AppActivity) this.f279220d.get(), this.f279221e, (QQCustomDialog) dialogInterface);
                PfaFriendRsp pfaFriendRsp = ToPayManagerImpl.mData;
                if (pfaFriendRsp != null && (arrayList = pfaFriendRsp.vecRec) != null && arrayList.size() > 0) {
                    for (int i16 = 0; i16 < this.f279221e.size(); i16++) {
                        int i17 = 0;
                        while (true) {
                            if (i17 < ToPayManagerImpl.mData.vecRec.size()) {
                                if (((ResultRecord) this.f279221e.get(i16)).uin.equals(ToPayManagerImpl.mData.vecRec.get(i17).uin)) {
                                    str = "friendpay.selectpage.recommendfriclick";
                                    break;
                                }
                                i17++;
                            } else {
                                str = "friendpay.selectpage.unrecomchoosefriclick";
                                break;
                            }
                        }
                        com.tencent.mobileqq.qwallet.c.e(str, "", "", "", "");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f279223d;

        c(Activity activity) {
            this.f279223d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f279223d.setResult(-1);
            this.f279223d.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f279224d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f279225e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f279226f;

        d(Activity activity, List list, List list2) {
            this.f279224d = activity;
            this.f279225e = list;
            this.f279226f = list2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ToPayManagerImpl.gotoAio(this.f279224d, this.f279225e, this.f279226f);
        }
    }

    public static ArrayList<PfaFriend> getRecentList() {
        RecentUserProxy recentUserCache;
        List<RecentUser> recentList;
        BaseQQAppInterface n3 = com.tencent.mobileqq.qwallet.impl.d.n();
        if (n3 == null || (recentUserCache = ((IRecentUserProxyService) n3.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache()) == null || (recentList = recentUserCache.getRecentList(true)) == null) {
            return null;
        }
        ArrayList<PfaFriend> arrayList = new ArrayList<>();
        ICrmApi iCrmApi = (ICrmApi) n3.getRuntimeService(ICrmApi.class, "");
        for (RecentUser recentUser : recentList) {
            if (recentUser != null && !Utils.J(recentUser.uin) && recentUser.getType() != 1020 && recentUser.getType() != 1008 && recentUser.getType() != 1005 && recentUser.getType() != 1006 && recentUser.getType() != 1009 && recentUser.getType() != 1021 && recentUser.getType() != 1001 && recentUser.getType() != 10002 && recentUser.getType() != 10004 && recentUser.getType() != 1022 && recentUser.getType() != 7000 && recentUser.getType() != 9501 && recentUser.getType() != 1 && (recentUser.getType() != 0 || !iCrmApi.isQiye(recentUser.uin, recentUser.getType()))) {
                if (recentUser.getType() != 1004 && recentUser.getType() != 1000) {
                    PfaFriend pfaFriend = new PfaFriend();
                    pfaFriend.uin = recentUser.uin;
                    arrayList.add(pfaFriend);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gotoAio(Activity activity, List<String> list, List<String> list2) {
        if (list.size() == 1) {
            Intent m3 = BaseAIOUtils.m(new Intent(), null);
            m3.putExtra("uin", list.get(0));
            m3.putExtra("uintype", 0);
            m3.putExtra("uinname", list2.get(0));
            m3.setFlags(335544320);
            RouteUtils.startActivity(activity, m3, RouterConstants.UI_ROUTER_SPLASH);
        } else if (list.size() > 1) {
            Intent intent = new Intent();
            intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            intent.setFlags(67108864);
            RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTER_SPLASH);
        }
        activity.setResult(-1);
        activity.finish();
    }

    protected static void notifyUi(boolean z16) {
        IToPayManager.a aVar;
        WeakReference<IToPayManager.a> weakReference = gWeakListener;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            aVar.onRefreshTopayList(z16);
        }
    }

    protected static void onGetRecomendList(boolean z16, PfaFriendRsp pfaFriendRsp, boolean z17) {
        ArrayList<String> arrayList;
        if (!z17 && (!z16 || pfaFriendRsp == null || pfaFriendRsp.ret != 0)) {
            return;
        }
        if (!z17 && mData != null && pfaFriendRsp != null && ((arrayList = pfaFriendRsp.vecPfaMsg) == null || arrayList.size() <= 0)) {
            PfaFriendRsp pfaFriendRsp2 = mData;
            pfaFriendRsp2.vecRec = pfaFriendRsp.vecRec;
            pfaFriendRsp2.use_default = pfaFriendRsp.use_default;
            pfaFriendRsp2.vecSpfaRec = pfaFriendRsp.vecSpfaRec;
        } else {
            mData = pfaFriendRsp;
        }
        notifyUi(!z17);
        if (!z17 && mData != null) {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.transaction.impl.ToPayManagerImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    String currentAccountUin;
                    int i3;
                    if (ToPayManagerImpl.mData == null) {
                        return;
                    }
                    BaseQQAppInterface n3 = com.tencent.mobileqq.qwallet.impl.d.n();
                    if (n3 != null) {
                        try {
                            currentAccountUin = n3.getCurrentAccountUin();
                        } catch (Exception e16) {
                            QLog.e(ToPayManagerImpl.TAG, 1, "error msg in qqpay-impl module: ", e16);
                            return;
                        }
                    } else {
                        currentAccountUin = "";
                    }
                    String str = j.f279286e + currentAccountUin;
                    if (ToPayManagerImpl.mBusinessType == 1 && (i3 = ToPayManagerImpl.mBusinessSubType) > 0 && i3 < 3) {
                        str = str + "_" + ToPayManagerImpl.mBusinessType + "_" + ToPayManagerImpl.mBusinessSubType;
                    }
                    File file = new File(str);
                    if (file.exists()) {
                        file.delete();
                    }
                    JceOutputStream jceOutputStream = new JceOutputStream();
                    jceOutputStream.setServerEncoding("utf-8");
                    ToPayManagerImpl.mData.writeTo(jceOutputStream);
                    FileUtils.writeFile(jceOutputStream.toByteArray(), str);
                }
            });
        }
    }

    protected static void refreshFromNet(int i3, int i16) {
        BaseQQAppInterface n3 = com.tencent.mobileqq.qwallet.impl.d.n();
        if (n3 == null) {
            return;
        }
        if (mRecentListObserver == null) {
            mRecentListObserver = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getQWalletAuthObserver(mHandler);
        }
        n3.addObserver(mRecentListObserver);
        PfaFriendRqt pfaFriendRqt = new PfaFriendRqt();
        pfaFriendRqt.mqq_version = ah.Q(MobileQQ.sMobileQQ);
        PfaFriendRsp pfaFriendRsp = mData;
        if (pfaFriendRsp != null) {
            pfaFriendRqt.pfa_msg_edition = pfaFriendRsp.pfa_msg_edition;
        } else {
            pfaFriendRqt.pfa_msg_edition = "0";
        }
        pfaFriendRqt.pfa_sub_type = 0;
        if (i3 == 1) {
            if (i16 == 1) {
                pfaFriendRqt.pfa_sub_type = 1;
            } else if (i16 == 2) {
                pfaFriendRqt.pfa_sub_type = 2;
            }
        }
        ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).sendGetRecentList(n3, pfaFriendRqt);
    }

    public static void sendTopay(AppActivity appActivity, ArrayList<ResultRecord> arrayList, QQCustomDialog qQCustomDialog) {
        final ResultReceiver resultReceiver;
        if (appActivity == null || appActivity.isFinishing() || appActivity.getIntent() == null || appActivity.getIntent().getExtras() == null || arrayList == null || arrayList.size() <= 0 || (resultReceiver = (ResultReceiver) appActivity.getIntent().getParcelableExtra(ISelectMemberActivityConstants.PARAM_AAPAY_RESULT_RECEIVER)) == null) {
            return;
        }
        final ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        final ArrayList<String> arrayList4 = new ArrayList<>();
        Iterator<ResultRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            ResultRecord next = it.next();
            arrayList2.add(next.uin);
            String str = next.phone;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            arrayList3.add(str);
            String str3 = next.name;
            if (str3 != null) {
                str2 = str3;
            }
            arrayList4.add(str2);
        }
        if (arrayList2.size() <= 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("choose_friend_uins", arrayList2);
        bundle.putStringArrayList("choose_friend_phones", arrayList3);
        bundle.putStringArrayList("choose_friend_names", arrayList4);
        if (qQCustomDialog != null) {
            bundle.putString("choose_friend_feedback", qQCustomDialog.getInputValue());
        }
        final WeakReference weakReference = new WeakReference(appActivity);
        ResultReceiver resultReceiver2 = new ResultReceiver(null) { // from class: com.tencent.mobileqq.qwallet.transaction.impl.ToPayManagerImpl.5
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(final int i3, final Bundle bundle2) {
                final AppActivity appActivity2;
                if (i3 != 99999 && (appActivity2 = (AppActivity) weakReference.get()) != null && !appActivity2.isFinishing()) {
                    appActivity2.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qwallet.transaction.impl.ToPayManagerImpl.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String str4;
                            AppActivity appActivity3 = (AppActivity) weakReference.get();
                            if (appActivity3 != null && !appActivity3.isFinishing()) {
                                ToPayManagerImpl.showProgress(appActivity3, false);
                                if (i3 == 0) {
                                    resultReceiver.send(1, new Bundle());
                                    com.tencent.mobileqq.qwallet.c.e("friendpay.aio.send", "", "", "", "");
                                    int intExtra = appActivity3.getIntent().getIntExtra("iPayFrom", -1);
                                    if (QLog.isColorLevel()) {
                                        QLog.e(ToPayManagerImpl.TAG, 2, "iPayFrom : " + intExtra);
                                    }
                                    if (intExtra == 1) {
                                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                        ToPayManagerImpl.showBackDialogTip(appActivity3, arrayList2, arrayList4);
                                        return;
                                    } else {
                                        AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                                        ToPayManagerImpl.gotoAio(appActivity3, arrayList2, arrayList4);
                                        return;
                                    }
                                }
                                Bundle bundle3 = bundle2;
                                if (bundle3 != null) {
                                    str4 = bundle3.getString("retmsg");
                                } else {
                                    str4 = null;
                                }
                                if (TextUtils.isEmpty(str4)) {
                                    str4 = appActivity3.getResources().getString(R.string.f171155cp4);
                                }
                                try {
                                    String optString = new JSONObject(str4).optString("err_msg");
                                    if (!TextUtils.isEmpty(optString)) {
                                        QQToast.makeText(appActivity2, 1, optString, 0).show();
                                    }
                                } catch (Throwable th5) {
                                    QLog.e(ToPayManagerImpl.TAG, 1, "parse Exception=" + th5.getMessage());
                                }
                            }
                        }
                    });
                }
            }
        };
        showProgress(appActivity, true);
        Parcel obtain = Parcel.obtain();
        resultReceiver2.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        ResultReceiver resultReceiver3 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
        OaidMonitor.parcelRecycle(obtain);
        bundle.putParcelable("callback", resultReceiver3);
        resultReceiver.send(0, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showBackDialogTip(Activity activity, List<String> list, List<String> list2) {
        c cVar = new c(activity);
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, (String) null, HardCodeUtil.qqStr(R.string.u7j), HardCodeUtil.qqStr(R.string.u7h), "\u7559\u5728QQ", new d(activity, list, list2), cVar);
        createCustomDialog.setCancelable(false);
        createCustomDialog.setCanceledOnTouchOutside(false);
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showProgress(AppActivity appActivity, boolean z16) {
        QWalletPayProgressDialog qWalletPayProgressDialog;
        if (appActivity != null && !appActivity.isFinishing()) {
            if (z16) {
                QWalletPayProgressDialog qWalletPayProgressDialog2 = new QWalletPayProgressDialog(appActivity);
                gWeakProgress = new WeakReference<>(qWalletPayProgressDialog2);
                qWalletPayProgressDialog2.show();
                return;
            }
            WeakReference<QWalletPayProgressDialog> weakReference = gWeakProgress;
            if (weakReference != null) {
                qWalletPayProgressDialog = weakReference.get();
            } else {
                qWalletPayProgressDialog = null;
            }
            if (qWalletPayProgressDialog != null && qWalletPayProgressDialog.isShowing()) {
                qWalletPayProgressDialog.dismiss();
            }
        }
    }

    @Override // com.tencent.mobileqq.qwallet.transaction.IToPayManager
    public HashMap<String, Object> getTopayList(IToPayManager.a aVar, final boolean z16, final int i3, final int i16) {
        gWeakListener = new WeakReference<>(aVar);
        if (i3 != mBusinessType || i16 != mBusinessSubType) {
            mData = null;
            mLoadedFromFileState = -1;
            mBusinessType = i3;
            mBusinessSubType = i16;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        PfaFriendRsp pfaFriendRsp = mData;
        if (pfaFriendRsp == null) {
            hashMap.put("recommend", getRecentList());
            if (mLoadedFromFileState == -1) {
                mLoadedFromFileState = 1;
                ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.transaction.impl.ToPayManagerImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String currentAccountUin;
                        Exception e16;
                        byte[] readFile;
                        int i17;
                        BaseQQAppInterface n3 = com.tencent.mobileqq.qwallet.impl.d.n();
                        final PfaFriendRsp pfaFriendRsp2 = null;
                        if (n3 != null) {
                            try {
                                currentAccountUin = n3.getCurrentAccountUin();
                            } catch (Exception e17) {
                                e16 = e17;
                                QLog.e(ToPayManagerImpl.TAG, 1, "error msg in qqpay-impl module: ", e16);
                                ToPayManagerImpl.mLoadedFromFileState = 0;
                                ToPayManagerImpl.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.transaction.impl.ToPayManagerImpl.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        boolean z17;
                                        PfaFriendRsp pfaFriendRsp3 = pfaFriendRsp2;
                                        if (pfaFriendRsp3 != null) {
                                            z17 = true;
                                        } else {
                                            z17 = false;
                                        }
                                        ToPayManagerImpl.onGetRecomendList(z17, pfaFriendRsp3, true);
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        if (z16) {
                                            ToPayManagerImpl.refreshFromNet(i3, i16);
                                        }
                                    }
                                });
                            }
                        } else {
                            currentAccountUin = "";
                        }
                        String str = j.f279286e + currentAccountUin;
                        if (i3 == 1 && (i17 = i16) > 0 && i17 < 3) {
                            str = str + "_" + i3 + "_" + i16;
                        }
                        if (new File(str).exists() && (readFile = FileUtils.readFile(str)) != null && readFile.length > 0) {
                            JceInputStream jceInputStream = new JceInputStream(readFile);
                            jceInputStream.setServerEncoding("utf-8");
                            PfaFriendRsp pfaFriendRsp3 = new PfaFriendRsp();
                            try {
                                pfaFriendRsp3.readFrom(jceInputStream);
                                pfaFriendRsp2 = pfaFriendRsp3;
                            } catch (Exception e18) {
                                pfaFriendRsp2 = pfaFriendRsp3;
                                e16 = e18;
                                QLog.e(ToPayManagerImpl.TAG, 1, "error msg in qqpay-impl module: ", e16);
                                ToPayManagerImpl.mLoadedFromFileState = 0;
                                ToPayManagerImpl.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.transaction.impl.ToPayManagerImpl.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        boolean z17;
                                        PfaFriendRsp pfaFriendRsp32 = pfaFriendRsp2;
                                        if (pfaFriendRsp32 != null) {
                                            z17 = true;
                                        } else {
                                            z17 = false;
                                        }
                                        ToPayManagerImpl.onGetRecomendList(z17, pfaFriendRsp32, true);
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        if (z16) {
                                            ToPayManagerImpl.refreshFromNet(i3, i16);
                                        }
                                    }
                                });
                            }
                        }
                        ToPayManagerImpl.mLoadedFromFileState = 0;
                        ToPayManagerImpl.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.transaction.impl.ToPayManagerImpl.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                boolean z17;
                                PfaFriendRsp pfaFriendRsp32 = pfaFriendRsp2;
                                if (pfaFriendRsp32 != null) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                ToPayManagerImpl.onGetRecomendList(z17, pfaFriendRsp32, true);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                if (z16) {
                                    ToPayManagerImpl.refreshFromNet(i3, i16);
                                }
                            }
                        });
                    }
                });
                return hashMap;
            }
        } else {
            if (pfaFriendRsp.use_default == 1) {
                hashMap.put("recommend", getRecentList());
            } else {
                hashMap.put("recommend", pfaFriendRsp.vecRec);
            }
            hashMap.put("tips", mData.vecPfaMsg);
        }
        if (z16) {
            refreshFromNet(i3, i16);
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.qwallet.transaction.IToPayManager
    public void onReceivePayerNotify(BaseQQAppInterface baseQQAppInterface, String str, long j3) {
        if (!TextUtils.isEmpty(str) && j3 >= 1) {
            Intent intent = new Intent(IToPayManager.BROADCAST_PAYER_NOTIFY);
            intent.putExtra("sendUin", j3);
            intent.putExtra("tokenId", str);
            baseQQAppInterface.getApp().sendBroadcast(intent);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.transaction.IToPayManager
    public void removeObserver(AppRuntime appRuntime) {
        mLoadedFromFileState = -1;
        mData = null;
        WeakReference<IToPayManager.a> weakReference = gWeakListener;
        if (weakReference != null) {
            weakReference.clear();
            gWeakListener = null;
        }
        WeakReference<QWalletPayProgressDialog> weakReference2 = gWeakProgress;
        if (weakReference2 != null) {
            weakReference2.clear();
            gWeakProgress = null;
        }
        if (appRuntime instanceof AppInterface) {
            ((AppInterface) appRuntime).removeObserver(mRecentListObserver);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.transaction.IToPayManager
    public void topay(AppActivity appActivity, ArrayList<ResultRecord> arrayList) {
        if (appActivity != null && !appActivity.isFinishing() && appActivity.getIntent() != null && appActivity.getIntent().getExtras() != null) {
            ArrayList arrayList2 = new ArrayList();
            String qqStr = HardCodeUtil.qqStr(R.string.u7i);
            if (arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    ResultRecord resultRecord = arrayList.get(i3);
                    if (resultRecord != null && resultRecord.type == 0 && resultRecord.uin != null) {
                        arrayList2.add(resultRecord);
                        if (!TextUtils.isEmpty(resultRecord.name)) {
                            qqStr = qqStr + resultRecord.name;
                        } else {
                            qqStr = qqStr + resultRecord.uin;
                        }
                        if (i3 < arrayList.size() - 1) {
                            qqStr = qqStr + "\u3001";
                        }
                    }
                }
            }
            if (arrayList2.size() <= 0) {
                QQToast.makeText(appActivity, appActivity.getString(R.string.i3l), 0).show();
                return;
            }
            b bVar = new b(new WeakReference(appActivity), arrayList2);
            if (((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).isSelectMemberActivityInstance(appActivity)) {
                ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).showQQCustomDialogWithInputAndChoose(appActivity, qqStr, bVar);
            }
        }
    }
}
