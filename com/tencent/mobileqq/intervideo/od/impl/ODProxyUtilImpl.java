package com.tencent.mobileqq.intervideo.od.impl;

import android.os.Bundle;
import android.text.TextUtils;
import b8.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.od.IODProxyUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import mqq.app.AppRuntime;

/* loaded from: classes33.dex */
public class ODProxyUtilImpl implements IODProxyUtil {
    private static final String TAG = "ODProxyUtilImpl";

    @Override // com.tencent.mobileqq.intervideo.od.IODProxyUtil
    public Bundle getODIntentBundle(IVPluginInfo iVPluginInfo, ILoginKeyHelper iLoginKeyHelper) {
        String str;
        int i3;
        int i16;
        String str2;
        String str3;
        String str4;
        int i17;
        int i18;
        int i19;
        Bundle bundle = new Bundle();
        try {
            AppRuntime waitAppRuntime = ((BaseApplicationImpl) BaseApplication.getContext()).waitAppRuntime(null);
            String account = waitAppRuntime.getAccount();
            d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(account), TAG);
            FriendsManager friendsManager = (FriendsManager) waitAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
            int i26 = 0;
            if (friendsSimpleInfoWithUid == null) {
                str = "";
                i3 = 0;
                i16 = 0;
            } else {
                str = friendsSimpleInfoWithUid.p();
                i16 = friendsSimpleInfoWithUid.v();
                i3 = friendsSimpleInfoWithUid.b();
            }
            Card r16 = friendsManager.r(account);
            if (r16 == null) {
                str2 = "";
                str3 = str2;
                str4 = str3;
                i17 = 0;
            } else {
                i17 = (int) r16.lBirthday;
                str3 = r16.strCountry;
                str4 = r16.strProvince;
                str2 = r16.strCity;
            }
            if (i17 == 0) {
                i19 = 1995;
                i18 = 0;
            } else {
                int i27 = (65280 & i17) >>> 8;
                i18 = i17 & 255;
                i19 = i17 >>> 16;
                i26 = i27;
            }
            bundle.putString("nickname", str);
            bundle.putLong("roomid", iVPluginInfo.f238104h);
            bundle.putInt("authtype", 1);
            bundle.putString("authid", iLoginKeyHelper.getAccountInfo().f238093b);
            bundle.putInt("gender", i16);
            bundle.putInt("vastype", 2);
            bundle.putLong("hostid", Long.parseLong(account));
            bundle.putString("authkey", iLoginKeyHelper.getAccountInfo().f238092a);
            bundle.putString("appid", iVPluginInfo.f238102e);
            bundle.putString("vasname", iVPluginInfo.G);
            bundle.putString("userdata", iVPluginInfo.f238105i);
            bundle.putInt("fromid", Integer.parseInt(iVPluginInfo.f238106m));
            bundle.putInt("age", i3);
            bundle.putInt(a.BIRTHYEAR, i19);
            bundle.putInt(a.BIRTHMONTH, i26);
            bundle.putInt("birthday", i18);
            bundle.putBoolean("loghost", true);
            bundle.putBoolean("reporthost", true);
            bundle.putString("backType", iVPluginInfo.H);
            bundle.putInt("isGroupCode", iVPluginInfo.I);
            bundle.putString("openType", iVPluginInfo.J);
            bundle.putString("extra", iVPluginInfo.K);
            bundle.putString("payToken", iLoginKeyHelper.getAccountInfo().f238094c);
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("addrCountry", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("addrProv", str4);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("addrCity", str2);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return bundle;
    }
}
