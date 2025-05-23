package com.tencent.mobileqq.vas.ipc.remote;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.mobileqq.vas.api.impl.PbProtocolSSoImpl;
import com.tencent.mobileqq.vip.n;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.webview.a;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import eipc.EIPCModule;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;
import tr2.b;

/* compiled from: P */
/* loaded from: classes20.dex */
public class LiveDelivery implements ILiveDelivery {
    private static final String TAG = "LiveDelivery";

    @Nullable
    private b.h getEntryBannerInfo(TianShuAccess.RspEntry rspEntry) {
        if (rspEntry.value.lst.size() > 0) {
            List<TianShuAccess.MapEntry> list = rspEntry.value.lst.get(0).argList.get();
            HashMap hashMap = new HashMap();
            for (TianShuAccess.MapEntry mapEntry : list) {
                String str = mapEntry.key.get();
                String str2 = mapEntry.value.get();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    hashMap.put(str, str2);
                }
            }
            b.h hVar = new b.h();
            hVar.f437167a = (String) hashMap.get("type");
            hVar.f437169c = (String) hashMap.get("pic");
            hVar.f437168b = (String) hashMap.get("url");
            hVar.f437170d = rspEntry.value.lst.get(0);
            if (!TextUtils.isEmpty(hVar.f437169c)) {
                return hVar;
            }
            return null;
        }
        return null;
    }

    private boolean isResEntrylst(TianShuAccess.RspEntry rspEntry) {
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        if (rspEntry != null && (adPlacementInfo = rspEntry.value) != null && adPlacementInfo.lst.size() != 0 && rspEntry.value.lst.get(0) != null && rspEntry.value.lst.get(0).argList != null && rspEntry.value.lst.get(0).argList.get() != null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery
    public void followUin(String str, final EIPCModule eIPCModule, final int i3, EIPCResultCallback eIPCResultCallback) {
        final QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        IPublicAccountObserver iPublicAccountObserver = (IPublicAccountObserver) QRoute.api(IPublicAccountObserver.class);
        iPublicAccountObserver.setOnCallback(new IPublicAccountObserver.c() { // from class: com.tencent.mobileqq.vas.ipc.remote.LiveDelivery.2
            @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
            public void onFollowPublicAccount(boolean z16, String str2) {
                IPublicAccountHandler iPublicAccountHandler;
                super.onFollowPublicAccount(z16, str2);
                EIPCResult eIPCResult = new EIPCResult();
                Bundle bundle = new Bundle();
                eIPCResult.data = bundle;
                bundle.putBoolean("isSuccess", z16);
                eIPCResult.data.putString("uin", str2);
                eIPCModule.callbackResult(i3, eIPCResult);
                if (z16 && TextUtils.isEmpty(TroopBarAssistantManager.n().o(str2)) && (iPublicAccountHandler = (IPublicAccountHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)) != null) {
                    iPublicAccountHandler.getUserFollowList();
                }
            }
        });
        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).followUin(qQAppInterface, BaseApplication.getContext(), str, iPublicAccountObserver, false, 0, true);
    }

    @Override // com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery
    public long getAccount() {
        return BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    }

    public b.h getAdsInfo(TianShuAccess.GetAdsRsp getAdsRsp, int i3) {
        List<TianShuAccess.RspEntry> list;
        if (getAdsRsp == null) {
            return null;
        }
        if (getAdsRsp.mapAds.has()) {
            list = getAdsRsp.mapAds.get();
        } else {
            list = null;
        }
        if (list == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (TianShuAccess.RspEntry rspEntry : list) {
            if (rspEntry != null && rspEntry.key.has()) {
                hashMap.put(Integer.valueOf(rspEntry.key.get()), rspEntry);
            }
        }
        TianShuAccess.RspEntry rspEntry2 = (TianShuAccess.RspEntry) hashMap.get(Integer.valueOf(i3));
        if (isResEntrylst(rspEntry2)) {
            return null;
        }
        return getEntryBannerInfo(rspEntry2);
    }

    @Override // com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery
    public boolean isFollowUin(String str) {
        return ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isFollowUin((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), str);
    }

    @Override // com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery
    public boolean isWxInstall() {
        return WXShareHelper.b0().e0();
    }

    @Override // com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery
    public void openChargePage() {
        QLog.e(TAG, 1, "openChargePage");
        VasH5PayUtil.openH5PayByURL(BaseApplicationImpl.getApplication(), "https://h5.qzone.qq.com/live/chargedialog?_wv=17301507&from=ugc&_proxy=1&aid=zhiboczban");
    }

    @Override // com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery
    public void openQQBrowser(String str) {
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        BaseApplication.getContext().startActivity(intent);
    }

    @Override // com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery
    public void openSchema(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d(TAG, 2, "openSchema empty");
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (URLUtil.isNetworkUrl(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("big_brother_source_key", "biz_src_jc_vip");
            a.g(BaseApplicationImpl.getApplication().getApplicationContext(), str, bundle, QQBrowserActivity.class, new int[]{268435456}, null, QQLiveSDKConfigHelper.getQQLiveAppId());
            return;
        }
        ax c16 = bi.c(qQAppInterface, BaseApplicationImpl.getApplication().getApplicationContext(), str);
        if (c16 != null) {
            c16.b();
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onEditorAction jumpUrl is illegal");
        }
    }

    @Override // com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery
    public void reportAction(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i3, int i16) {
        MobileReportManager.getInstance().reportActionLive(str, str2, new MobileReportManager.ItemInfoBuilder().setItemId(str3).setBusiInfo(str7).setModuleId(str4).setItemType(str8).addActionInfo(new MobileReportManager.ActionInfoBuilder(System.currentTimeMillis(), i3, i16).build()).build());
    }

    @Override // com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery
    public void reportStatistic(String str, HashMap<String, String> hashMap, long j3) {
        VasStatisticCollector.reportReal(str, hashMap, j3);
    }

    @Override // com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery
    public void reportTianshu(String str, String str2, String str3, int i3, int i16) {
        String str4;
        TianShuReportData tianShuReportData = new TianShuReportData();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
            str4 = runtime.getAccount();
        } else {
            str4 = "";
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mTraceId = str4 + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = i16;
        tianShuReportData.mAppId = str;
        tianShuReportData.mPageId = str2;
        tianShuReportData.mItemId = str3;
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mOperTime = serverTimeMillis;
        TianShuManager.getInstance().report(tianShuReportData);
    }

    @Override // com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery
    public void reqPendantInfo(final int i3, int i16, Serializable serializable, final EIPCModule eIPCModule, final int i17, EIPCResultCallback eIPCResultCallback) {
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = i3;
        tianShuAdPosItemData.mNeedCnt = i16;
        tianShuAdPosItemData.mExtraData = (HashMap) serializable;
        arrayList.add(tianShuAdPosItemData);
        TianShuManager.getInstance().requestAdv(arrayList, new TianShuGetAdvCallback() { // from class: com.tencent.mobileqq.vas.ipc.remote.LiveDelivery.4
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                b.h adsInfo = LiveDelivery.this.getAdsInfo(getAdsRsp, i3);
                if (adsInfo == null) {
                    return;
                }
                EIPCResult eIPCResult = new EIPCResult();
                Bundle bundle = new Bundle();
                eIPCResult.data = bundle;
                bundle.putString("type", adsInfo.f437167a);
                eIPCResult.data.putString("pic", adsInfo.f437169c);
                eIPCResult.data.putString("url", adsInfo.f437168b);
                TianShuAccess.AdItem adItem = adsInfo.f437170d;
                if (adItem != null) {
                    eIPCResult.data.putInt("adId", adItem.iAdId.get());
                }
                eIPCModule.callbackResult(i17, eIPCResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery
    public void requestPbMsfSSO(String str, String str2, final EIPCModule eIPCModule, final int i3, EIPCResultCallback eIPCResultCallback) {
        n.request(str, str2, new BusinessObserver() { // from class: com.tencent.mobileqq.vas.ipc.remote.LiveDelivery.1
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i16, boolean z16, Object obj) {
                EIPCResult eIPCResult = new EIPCResult();
                Bundle bundle = new Bundle();
                eIPCResult.data = bundle;
                if (obj != null) {
                    bundle.putByteArray(PbProtocolSSoImpl.RESP_KEY_IS_DATA, (byte[]) obj);
                }
                eIPCModule.callbackResult(i3, eIPCResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery
    public void unfollowUin(String str, final EIPCModule eIPCModule, final int i3, EIPCResultCallback eIPCResultCallback) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        IPublicAccountObserver iPublicAccountObserver = (IPublicAccountObserver) QRoute.api(IPublicAccountObserver.class);
        iPublicAccountObserver.setOnCallback(new IPublicAccountObserver.c() { // from class: com.tencent.mobileqq.vas.ipc.remote.LiveDelivery.3
            @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
            public void onUnfollowPublicAccount(boolean z16, String str2) {
                super.onFollowPublicAccount(z16, str2);
                EIPCResult eIPCResult = new EIPCResult();
                Bundle bundle = new Bundle();
                eIPCResult.data = bundle;
                bundle.putBoolean("isSuccess", z16);
                eIPCResult.data.putString("uin", str2);
                eIPCModule.callbackResult(i3, eIPCResult);
            }
        });
        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).unfollowUin(qQAppInterface, BaseApplication.getContext(), str, false, iPublicAccountObserver, true);
    }
}
