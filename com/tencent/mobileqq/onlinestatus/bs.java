package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.DiyStatusEmoInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusAvatarSwitchService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.protocol.c;
import com.tencent.mobileqq.onlinestatus.tencentvideo.TencentVideoNameHandler;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.relation.api.IFriendsUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.OnlineBatteryProducer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.onlinestatus.OnlineStatusExtInfo$CustomStatus;
import tencent.im.onlinestatus.OnlineStatusExtInfo$MainStatusExtData;
import tencent.im.onlinestatus.OnlineStatusExtInfo$SynchVideoBizInfo;
import tencent.im.onlinestatus.OnlineStatusExtInfo$WeatherBizInfo;
import tencent.im.onlinestatus.OnlineStatusExtInfo$ZodiacBizInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class bs {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f255654a = {"", "\u6c34\u74f6\u5ea7", "\u53cc\u9c7c\u5ea7", "\u767d\u7f8a\u5ea7", "\u91d1\u725b\u5ea7", "\u53cc\u5b50\u5ea7", "\u5de8\u87f9\u5ea7", "\u72ee\u5b50\u5ea7", "\u5904\u5973\u5ea7", "\u5929\u79e4\u5ea7", "\u5929\u874e\u5ea7", "\u5c04\u624b\u5ea7", "\u6469\u7faf\u5ea7"};

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        private View f255655d;

        public a(View view) {
            this.f255655d = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    this.f255655d.setVisibility(8);
                }
            } else {
                this.f255655d.setVisibility(0);
            }
            return false;
        }
    }

    @Nullable
    public static com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c A(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        if (TextUtils.isEmpty(uidFromUin)) {
            return null;
        }
        return ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(uidFromUin, "OnlineStatusUtil_" + str2);
    }

    public static void A0(int i3, final ec2.a aVar) {
        final int i16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            if (i3 == 1) {
                i16 = 3;
            } else if (i3 == 2) {
                i16 = 1;
            } else {
                QLog.e("OnlineStatusUtil", 1, "[saveAvatarAtShareSheetFlag]: status invalid");
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.bl
                    @Override // java.lang.Runnable
                    public final void run() {
                        ec2.a.this.a(false);
                    }
                });
                return;
            }
            com.tencent.mobileqq.onlinestatus.protocol.c a16 = com.tencent.mobileqq.onlinestatus.protocol.c.INSTANCE.a();
            com.tencent.mobileqq.onlinestatus.model.f k3 = a16.k(peekAppRuntime.getCurrentAccountUin());
            if (k3 != null && k3.getPanelSwitch() == i16) {
                QLog.i("OnlineStatusUtil", 1, "[saveAvatarAtShareSheetFlag]: remoteflag is already setTo " + i16);
                return;
            }
            a16.n(peekAppRuntime, i16, new Function1() { // from class: com.tencent.mobileqq.onlinestatus.bm
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit p06;
                    p06 = bs.p0(ec2.a.this, i16, (Boolean) obj);
                    return p06;
                }
            });
        }
    }

    @NonNull
    public static au B(String str) {
        return C(str, false);
    }

    public static void B0() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        from.encodeBool("AVATAR_FIRST_SHOW_GUIDE_PANEL", false);
        from.commitSync();
    }

    @NonNull
    public static au C(String str, boolean z16) {
        if (((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()) != null && !TextUtils.isEmpty(str)) {
            com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c A = A(str, "getOnlineStatusItem");
            if (A == null) {
                return new au(AppRuntime.Status.online);
            }
            AppRuntime.Status c16 = com.tencent.mobileqq.onlinestatus.utils.ae.c(A);
            if (z16 && c16 == AppRuntime.Status.offline) {
                return new au(c16);
            }
            return af.C().I(c16, A.e0());
        }
        return new au(AppRuntime.Status.online);
    }

    public static void C0(String str) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(str + "avatar_already_dress_up", true);
    }

    public static String D(long j3, long j16) {
        long j17 = j3 - j16;
        if (j17 <= 600) {
            return "";
        }
        if (j17 < 3600) {
            return (j17 / 60) + "\u5206\u949f\u524d";
        }
        if (j17 < 86400) {
            return (j17 / 3600) + "\u5c0f\u65f6\u524d";
        }
        if (j17 < 2592000) {
            return (j17 / 86400) + "\u5929\u524d";
        }
        if (j17 >= 31104000) {
            return "";
        }
        return (j17 / 2592000) + "\u6708\u524d";
    }

    public static void D0(String str) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeLong(str + "avatar_last_check_dress_up_time", System.currentTimeMillis());
    }

    public static final String E(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        if (cVar.q0() > 0) {
            String D = D(NetConnInfoCenter.getServerTime(), cVar.q0());
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusUtil", 2, "getWeatherDisplayInfo passTimeTip=", D);
                return D;
            }
            return D;
        }
        return "";
    }

    public static void E0(ImageView imageView, String str) {
        URLDrawable drawable;
        if (imageView == null || TextUtils.isEmpty(str) || (drawable = URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain())) == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
        imageView.setVisibility(0);
    }

    public static int F(String str) {
        com.tencent.mobileqq.onlinestatus.model.f k3 = com.tencent.mobileqq.onlinestatus.protocol.c.INSTANCE.a().k(str);
        if (k3 != null) {
            return k3.getPanelSwitch();
        }
        return 0;
    }

    public static void F0(String str, @Nullable TextView textView, @Nullable ImageView imageView, boolean z16) {
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c A;
        if (!TextUtils.isEmpty(str)) {
            if (textView != null || imageView != null) {
                au C = C(str, z16);
                AppRuntime.Status status = C.f255494g;
                if (status == AppRuntime.Status.online && C.f255489b == 2000) {
                    if (MobileQQ.sMobileQQ.peekAppRuntime() == null || (A = A(str, "setOnlineStatusTextAndIcon")) == null) {
                        return;
                    }
                    if (imageView != null) {
                        imageView.setImageDrawable(af.C().z(C, 0, 3, A));
                        imageView.setVisibility(0);
                    }
                    if (textView != null) {
                        textView.setText(af.C().y(A, C.f255490c));
                        return;
                    }
                    return;
                }
                if (z16 && C.f255493f == 2 && status == AppRuntime.Status.offline) {
                    if (imageView != null) {
                        imageView.setImageDrawable(imageView.getContext().getResources().getDrawable(R.drawable.ofk));
                        imageView.setVisibility(0);
                    }
                    if (textView != null) {
                        textView.setText(textView.getContext().getString(R.string.hps));
                        return;
                    }
                    return;
                }
                if (imageView != null) {
                    if (C.f255493f == 2) {
                        imageView.setImageDrawable(ar.c(status));
                        imageView.setVisibility(0);
                    } else {
                        E0(imageView, C.f255491d);
                    }
                }
                if (textView != null) {
                    textView.setText(C.f255490c);
                }
            }
        }
    }

    public static int G() {
        int i3 = 0;
        int decodeInt = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt("AVATAR_AT_SHARE_SHEET_FLAG", 0);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && !TextUtils.isEmpty(peekAppRuntime.getCurrentAccountUin())) {
            int F = F(peekAppRuntime.getCurrentAccountUin());
            if (F == 3) {
                i3 = 1;
            } else if (F == 1) {
                i3 = 2;
            }
        }
        if (i3 > 0) {
            return i3;
        }
        return decodeInt;
    }

    public static void G0() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i("OnlineStatusUtil", 1, "[setRemoteGraySwitch]: appruntime is null");
            return;
        }
        if (TextUtils.isEmpty(peekAppRuntime.getCurrentAccountUin())) {
            QLog.i("OnlineStatusUtil", 1, "[setRemoteGraySwitch]: uin is empty");
            return;
        }
        c.Companion companion = com.tencent.mobileqq.onlinestatus.protocol.c.INSTANCE;
        com.tencent.mobileqq.onlinestatus.model.f k3 = companion.a().k(peekAppRuntime.getCurrentAccountUin());
        if (k3 == null || !k3.getGrayWhiteSwitch()) {
            QLog.i("OnlineStatusUtil", 1, "[setRemoteGraySwitch]: setRemoteGray to true");
            companion.a().m(peekAppRuntime, true, new Function1() { // from class: com.tencent.mobileqq.onlinestatus.bj
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit q06;
                    q06 = bs.q0((Boolean) obj);
                    return q06;
                }
            });
        }
    }

    @Nullable
    public static com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H(String str) {
        String str2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str2 = peekAppRuntime.getCurrentAccountUin();
        } else {
            str2 = null;
        }
        return A(str2, str);
    }

    public static void H0(HashMap<String, Long> hashMap) {
        long j3;
        ArrayList arrayList = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList, new Comparator() { // from class: com.tencent.mobileqq.onlinestatus.bk
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int r06;
                r06 = bs.r0((Map.Entry) obj, (Map.Entry) obj2);
                return r06;
            }
        });
        HashSet hashSet = new HashSet();
        Iterator it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            hashSet.add((String) ((Map.Entry) it.next()).getKey());
            i3++;
            if (i3 > 3) {
                break;
            }
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        long currentTimeMillis = System.currentTimeMillis();
        long decodeLong = from.decodeLong(IOnLineStatueHelperApi.UPDATE_FRIEND_UIN_KEY_TIME, 0L);
        from.encodeLong(IOnLineStatueHelperApi.UPDATE_FRIEND_UIN_KEY_TIME, currentTimeMillis).commitSync();
        long j16 = currentTimeMillis - decodeLong;
        if (j16 < 1000) {
            QLog.d("OnlineStatusUtil", 1, "sortAndSaveMap: " + j16);
            return;
        }
        int size = arrayList.size();
        if (size > 0) {
            j3 = ((Long) ((Map.Entry) arrayList.get(size - 1)).getValue()).longValue();
        } else {
            j3 = -1;
        }
        from.encodeStringSet(IOnLineStatueHelperApi.FIRST_FRIENDS_UIN_KEY, hashSet);
        from.encodeInt(IOnLineStatueHelperApi.FRIENDS_UPDATE_ONLINE_STATUS_NUMS_KEY, hashMap.size());
        from.encodeLong(IOnLineStatueHelperApi.FRIENDS_UPDATE_ONLINE_STATUS_MIN_TIME_KEY, j3);
        from.commitSync();
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusUtil", 1, "sortAndSaveMap map.size: " + arrayList.size());
        }
    }

    public static Drawable I(au auVar, int i3, boolean z16) {
        if (auVar.f255493f == 2) {
            return ar.c(auVar.f255494g);
        }
        if (z16 && af.C().e0(auVar)) {
            return new OnlineBatteryProducer().createBatteryDrawable(af.D(), 1);
        }
        if (auVar.f255489b == 1080 && af.C().f0()) {
            return af.C().G(auVar, i3, 3);
        }
        return URLDrawable.getDrawable(auVar.f255491d, URLDrawable.URLDrawableOptions.obtain());
    }

    private static Boolean I0(String str) {
        boolean z16 = true;
        if (TextUtils.isEmpty(str)) {
            QLog.d("OnlineStatusUtil", 1, "fetchAvatarAtShareSheetOpened uin exception: " + str);
            return Boolean.FALSE;
        }
        int G = G();
        if (G != 0) {
            QLog.d("OnlineStatusUtil", 1, "fetchAvatarAtShareSheetOpened flag=" + G);
            if (G != 1) {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }
        if (be.a(str)) {
            QLog.d("OnlineStatusUtil", 1, "fetchAvatarAtShareSheetOpened AutoWhite");
            return Boolean.TRUE;
        }
        if (!be.h()) {
            QLog.d("OnlineStatusUtil", 1, "fetchAvatarAtShareSheetOpened not GraySwitch");
            return Boolean.FALSE;
        }
        if (S(str)) {
            QLog.d("OnlineStatusUtil", 1, "fetchAvatarAtShareSheetOpened DressUp");
            G0();
            return Boolean.TRUE;
        }
        if (!X(str)) {
            QLog.d("OnlineStatusUtil", 1, "fetchAvatarAtShareSheetOpened isLastCheckDressUpOutdated=false");
            return Boolean.FALSE;
        }
        return null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:6|(9:8|(2:10|(1:14))(2:33|(1:35))|15|16|17|(1:20)|21|(1:23)|(1:30)(2:28|29))|36|15|16|17|(1:20)|21|(0)|(1:26)|30) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a0, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
    
        com.tencent.qphone.base.util.QLog.e("OnlineStatusUtil", 1, "statusDescForAccountPanel t:", r8);
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0096 A[Catch: all -> 0x00a0, TRY_LEAVE, TryCatch #0 {all -> 0x00a0, blocks: (B:17:0x0084, B:20:0x008c, B:21:0x0090, B:23:0x0096), top: B:16:0x0084 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String J(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        String str;
        String ownerOnlineStatus;
        if (cVar == null) {
            QLog.e("OnlineStatusUtil", 1, "getStatusNameForAccountPanel simpleInfo is null");
            return "";
        }
        int a16 = com.tencent.mobileqq.friend.status.b.a(cVar.u(), cVar.z());
        if (a16 == 4) {
            if (cVar.f0().equals(MobileQQ.sMobileQQ.peekAppRuntime().getAccount())) {
                if (((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).isSelfNetworkStatusVisible(cVar) && !b0(cVar)) {
                    str = com.tencent.mobileqq.friend.status.b.c();
                }
            } else if (!com.tencent.mobileqq.friend.status.b.e(cVar)) {
                str = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getStatusNamePlusNetWorkType(((IFriendsUtils) QRoute.api(IFriendsUtils.class)).getNetworkType(cVar.E(), cVar.z(), cVar.C()));
            }
            ownerOnlineStatus = ((ICustomOnlineStatusManager) QRoute.api(ICustomOnlineStatusManager.class)).getOwnerOnlineStatus();
            if (TextUtils.isEmpty(ownerOnlineStatus) && a16 == 4) {
                ownerOnlineStatus = cVar.c0();
            }
            if (TextUtils.isEmpty(ownerOnlineStatus)) {
                ownerOnlineStatus = MobileQQ.sMobileQQ.getString(R.string.hpt);
            }
            if (str == null && !TextUtils.isEmpty(ownerOnlineStatus)) {
                return ownerOnlineStatus + str;
            }
            return ownerOnlineStatus;
        }
        str = null;
        ownerOnlineStatus = ((ICustomOnlineStatusManager) QRoute.api(ICustomOnlineStatusManager.class)).getOwnerOnlineStatus();
        if (TextUtils.isEmpty(ownerOnlineStatus)) {
            ownerOnlineStatus = cVar.c0();
        }
        if (TextUtils.isEmpty(ownerOnlineStatus)) {
        }
        if (str == null) {
        }
        return ownerOnlineStatus;
    }

    public static boolean J0() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d("OnlineStatusUtil", 1, "fetchAvatarAtShareSheetOpened runtime is null");
            return false;
        }
        Boolean I0 = I0(peekAppRuntime.getCurrentAccountUin());
        if (I0 == null) {
            return false;
        }
        return I0.booleanValue();
    }

    public static String K(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return "";
                        }
                        return " - 5G";
                    }
                    return " - 4G";
                }
                return " - 3G";
            }
            return " - 2G";
        }
        return " - WiFi";
    }

    public static int L() {
        int i3;
        if (W()) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("", 2, "HPush_Huawei Push pushType : " + i3);
        }
        return i3;
    }

    public static String M(AppRuntime appRuntime, @NonNull com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, boolean z16) {
        String f16;
        String e16;
        String o06;
        String str;
        String str2 = "";
        if (!d0(cVar)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        if (TextUtils.isEmpty(cVar.f())) {
            f16 = "";
        } else {
            f16 = cVar.f();
        }
        sb5.append(f16);
        if (TextUtils.isEmpty(cVar.e())) {
            e16 = "";
        } else {
            e16 = cVar.e();
        }
        sb5.append(e16);
        String sb6 = sb5.toString();
        if (TextUtils.isEmpty(cVar.o0())) {
            o06 = "";
        } else {
            o06 = cVar.o0();
        }
        StringBuilder sb7 = new StringBuilder();
        sb7.append(o06);
        if (TextUtils.isEmpty(cVar.d0())) {
            str = "";
        } else {
            str = cVar.d0() + "\u2103";
        }
        sb7.append(str);
        String sb8 = sb7.toString();
        if (!TextUtils.isEmpty(sb6)) {
            str2 = sb6 + APLogFileUtil.SEPARATOR_LOG + sb8;
        }
        if (z16) {
            return str2 + E(cVar);
        }
        return str2;
    }

    public static String N(AppRuntime appRuntime, TextView textView, @NonNull com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, int i3) {
        String string;
        boolean z16;
        if (appRuntime == null) {
            string = "";
        } else {
            string = appRuntime.getApplicationContext().getString(R.string.f197244jh);
        }
        if (OnlineStatusToggleUtils.B() && !TextUtils.isEmpty(cVar.m0())) {
            return cVar.m0();
        }
        if (!d0(cVar)) {
            return string;
        }
        if (appRuntime != null && cVar.f0() != null && cVar.f0().equals(appRuntime.getAccount())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            boolean b16 = com.tencent.mobileqq.weather.util.i.b(appRuntime.getApplicationContext(), QQPermissionConstants.Business.SCENE.QQ_ONLINE_STATUS_WEATHER_SCENE);
            QLog.i("OnlineStatusUtil", 1, "getWeatherDisplayInfo isSelfUin granted=" + b16);
            if (!b16) {
                return appRuntime.getApplicationContext().getString(R.string.f197244jh);
            }
        }
        String M = M(appRuntime, cVar, false);
        if (i3 == 2 && textView != null) {
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusUtil", 2, "getWeatherDisplayInfo fromContacts");
            }
            M = n(textView.getPaint(), M, ViewUtils.dip2px(200.0f));
        }
        return M + "";
    }

    @Deprecated
    private static void O(Friends friends, byte[] bArr) {
        try {
            OnlineStatusExtInfo$SynchVideoBizInfo onlineStatusExtInfo$SynchVideoBizInfo = new OnlineStatusExtInfo$SynchVideoBizInfo();
            onlineStatusExtInfo$SynchVideoBizInfo.mergeFrom(bArr);
            if (onlineStatusExtInfo$SynchVideoBizInfo.synch_type.get() == 1) {
                friends.videoId = null;
                friends.videoUrl = null;
                friends.videoName = null;
                return;
            }
            String str = onlineStatusExtInfo$SynchVideoBizInfo.string_cid.get();
            String str2 = onlineStatusExtInfo$SynchVideoBizInfo.string_tvURL.get();
            if (onlineStatusExtInfo$SynchVideoBizInfo.synch_type.get() == 2 && !str.equals(friends.videoId)) {
                friends.videoId = str;
                friends.videoUrl = str2;
                ((TencentVideoNameHandler) ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getBusinessHandler(TencentVideoNameHandler.class.getName())).D2(1, friends.videoId, friends.uin);
            }
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusUtil", 2, "handleParseSyncStatusInfo: invoked. ", " friend.videoId: ", friends.videoId, " friend.videoUrl: " + friends.videoUrl);
            }
        } catch (Exception e16) {
            QLog.e("OnlineStatusUtil", 1, "handleParseSyncStatusInfo fail", e16);
        }
    }

    public static boolean P(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        if (!TextUtils.isEmpty(cVar.i0()) && !TextUtils.isEmpty(cVar.g0()) && !TextUtils.isEmpty(cVar.h0())) {
            return true;
        }
        return false;
    }

    public static void Q() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z16 = true;
        if (peekAppRuntime == null) {
            QLog.i("OnlineStatusUtil", 1, "[setAvatarRemoteGraySwitch]: app is null");
            return;
        }
        final MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        boolean decodeBool = from.decodeBool("AVATAR_ACCOUNT_WHITE", false);
        boolean d16 = be.d(peekAppRuntime.getCurrentAccountUin());
        final int decodeInt = from.decodeInt("AVATAR_AT_SHARE_SHEET_FLAG", 0);
        IOnlineStatusAvatarSwitchService iOnlineStatusAvatarSwitchService = (IOnlineStatusAvatarSwitchService) peekAppRuntime.getRuntimeService(IOnlineStatusAvatarSwitchService.class, "all");
        com.tencent.mobileqq.onlinestatus.model.f switchStatus = iOnlineStatusAvatarSwitchService.getSwitchStatus(peekAppRuntime.getCurrentAccountUin());
        QLog.i("OnlineStatusUtil", 1, "[immigrateMMkvAndRemoteData]: local white is " + decodeBool + " localGray is " + d16 + " local operateflag is " + decodeInt);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[immigrateMMkvAndRemoteData]: remote switch is ");
        sb5.append(switchStatus);
        QLog.i("OnlineStatusUtil", 1, sb5.toString());
        if (decodeBool) {
            if (switchStatus != null && switchStatus.getAutoWhiteSwitch()) {
                QLog.i("OnlineStatusUtil", 1, "[immigrateMMkvAndRemoteData]: remote already white");
                from.removeKey("AVATAR_ACCOUNT_WHITE");
            } else {
                QLog.i("OnlineStatusUtil", 1, "[immigrateMMkvAndRemoteData]: local isWhite, need to setRemote");
                iOnlineStatusAvatarSwitchService.setSelfAutoWhitelistOn(new Function1() { // from class: com.tencent.mobileqq.onlinestatus.br
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit h06;
                        h06 = bs.h0(MMKVOptionEntity.this, (Boolean) obj);
                        return h06;
                    }
                });
            }
        }
        if (decodeInt != 0) {
            if (switchStatus != null && switchStatus.getPanelSwitch() != 0) {
                QLog.i("OnlineStatusUtil", 1, "[immigrateMMkvAndRemoteData]: remote already set operateFlag");
                from.removeKey("AVATAR_AT_SHARE_SHEET_FLAG");
                return;
            }
            QLog.i("OnlineStatusUtil", 1, "[immigrateMMkvAndRemoteData]: userOperateFlag is ," + decodeInt + " need to setRemote");
            if (decodeInt != 1) {
                z16 = false;
            }
            iOnlineStatusAvatarSwitchService.setSelfPanelSwitch(z16, new Function1() { // from class: com.tencent.mobileqq.onlinestatus.bg
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit i06;
                    i06 = bs.i0(decodeInt, from, (Boolean) obj);
                    return i06;
                }
            });
        }
    }

    public static boolean R(String str) {
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && TextUtils.equals(str, peekAppRuntime.getCurrentAccountUin())) {
            z16 = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("AVATAR_ACCOUNT_WHITE", false);
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.onlinestatus.model.f k3 = com.tencent.mobileqq.onlinestatus.protocol.c.INSTANCE.a().k(str);
        if ((k3 == null || !k3.getAutoWhiteSwitch()) && !z16) {
            return false;
        }
        return true;
    }

    public static boolean S(String str) {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(str + "avatar_already_dress_up", false);
    }

    public static boolean T() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("AVATAR_FIRST_SHOW_GUIDE_PANEL", true);
    }

    public static boolean U() {
        if (QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt("AVATAR_FIRST_SHOW_GOTO_SHARE_TIPS", 0) >= 3) {
            return false;
        }
        return true;
    }

    public static boolean V(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        if (cVar == null) {
            return false;
        }
        String u16 = kc2.c.u(cVar);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusUtil", 2, "isConstellationInfoValid: invoked. ", " suitableTrend: ", u16);
        }
        if (TextUtils.isEmpty(u16) || TextUtils.isEmpty(cVar.m())) {
            return false;
        }
        return true;
    }

    public static boolean W() {
        if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) {
            return true;
        }
        return false;
    }

    public static boolean X(String str) {
        long decodeLong = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeLong(str + "avatar_last_check_dress_up_time", 0L);
        long c16 = (long) be.c();
        QLog.d("OnlineStatusSuperShowSwitch", 1, "isLastCheckDressUpOutdated gap=" + c16);
        if (Math.abs(System.currentTimeMillis() - decodeLong) > c16 * 60 * 60 * 1000 * 1000) {
            return true;
        }
        return false;
    }

    public static boolean Y(@Nullable AppRuntime appRuntime) {
        if (appRuntime == null || ((IProfileDataService) appRuntime.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(appRuntime.getCurrentUin(), false).shGender == 0) {
            return true;
        }
        return false;
    }

    public static boolean Z(AppRuntime appRuntime) {
        if (appRuntime == null) {
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusUtil", 1, "showFriendStatusBar meet app null!");
            }
            return false;
        }
        if (!y(appRuntime)) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusUtil", 1, "showFriendStatusBar OnlineStatusUtil.getIsEmptyOnlySelf true");
        }
        return false;
    }

    public static boolean a0(int i3) {
        if (i3 == 1000) {
            return true;
        }
        return false;
    }

    private static boolean b0(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        if (!TextUtils.isEmpty(cVar.c0()) && cVar.c0().equals(BaseApplication.getContext().getString(R.string.f172482qk))) {
            return true;
        }
        return false;
    }

    public static boolean c0(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        if (!TextUtils.isEmpty(cVar.v()) && cVar.x() > 0 && cVar.w() > 0) {
            return true;
        }
        return false;
    }

    public static boolean d0(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        if (e0(cVar) && cVar.k0() == 0) {
            return true;
        }
        return false;
    }

    public static boolean e0(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.o0()) || TextUtils.isEmpty(cVar.d0()) || TextUtils.isEmpty(cVar.p0())) {
            return false;
        }
        return !TextUtils.isEmpty(cVar.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f0(boolean z16, boolean z17, String str, u uVar) {
        if (z16 && z17) {
            C0(str);
            uVar.a(true);
            G0();
            return;
        }
        uVar.a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g0(final String str, final u uVar, final boolean z16, final boolean z17) {
        QLog.d("OnlineStatusUtil", 1, "fetchAvatarAtShareSheetOpened success=" + z16 + ", result=" + z17);
        D0(str);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.bi
            @Override // java.lang.Runnable
            public final void run() {
                bs.f0(z16, z17, str, uVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit h0(MMKVOptionEntity mMKVOptionEntity, Boolean bool) {
        QLog.i("OnlineStatusUtil", 1, "[immigrateMMkvAndRemoteData]: set remote white, result is " + bool);
        if (bool.booleanValue()) {
            mMKVOptionEntity.removeKey("AVATAR_ACCOUNT_WHITE");
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit i0(int i3, MMKVOptionEntity mMKVOptionEntity, Boolean bool) {
        QLog.i("OnlineStatusUtil", 1, "[immigrateMMkvAndRemoteData]: set remote userOperateFlag to " + i3 + ", result is " + bool);
        if (bool.booleanValue()) {
            mMKVOptionEntity.removeKey("AVATAR_AT_SHARE_SHEET_FLAG");
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l0(ec2.a aVar, Boolean bool) {
        aVar.a(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit m0(final ec2.a aVar, final Boolean bool) {
        QLog.i("OnlineStatusUtil", 1, "[saveAvatarAccountAutoWhite]: result is " + bool);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.bh
            @Override // java.lang.Runnable
            public final void run() {
                bs.l0(ec2.a.this, bool);
            }
        });
        return null;
    }

    public static final String n(Paint paint, String str, int i3) {
        float measureText = paint.measureText(str);
        float measureText2 = paint.measureText("\u2026");
        if (measureText2 > measureText) {
            return str;
        }
        float f16 = i3;
        if (measureText2 > f16) {
            return "\u2026";
        }
        if (measureText > f16) {
            int length = str.length();
            float[] fArr = new float[length];
            paint.getTextWidths(str, fArr);
            float f17 = f16 - measureText2;
            float f18 = 0.0f;
            for (int i16 = 0; i16 < length; i16++) {
                f18 += fArr[i16];
                if (f18 > f17) {
                    return str.substring(0, i16) + "\u2026";
                }
            }
            return str;
        }
        return str;
    }

    public static void o(final u uVar) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d("OnlineStatusUtil", 1, "fetchAvatarAtShareSheetOpened runtime is null");
            uVar.a(false);
            return;
        }
        final String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        Boolean I0 = I0(currentAccountUin);
        if (I0 != null) {
            uVar.a(I0.booleanValue());
        } else {
            ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).checkAppearanceEverChanged(peekAppRuntime.getLongAccountUin(), 20, new ji3.a() { // from class: com.tencent.mobileqq.onlinestatus.bf
                @Override // ji3.a
                public final void a(boolean z16, boolean z17) {
                    bs.g0(currentAccountUin, uVar, z16, z17);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o0(ec2.a aVar, Boolean bool, int i3) {
        int i16;
        aVar.a(bool.booleanValue());
        if (!bool.booleanValue()) {
            if (i3 == 3) {
                i16 = R.string.f172392qb;
            } else {
                i16 = R.string.f172262pz;
            }
            QQToast.makeText(MobileQQ.sMobileQQ, i16, 0).show();
        }
    }

    public static int p(au auVar) {
        if (auVar == null) {
            return -1;
        }
        return r(auVar.f255494g, auVar.f255489b).f256383a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit p0(final ec2.a aVar, final int i3, final Boolean bool) {
        QLog.i("OnlineStatusUtil", 1, "[saveAvatarAtShareSheetFlag]: set remotePanelSwitch result is " + bool);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.bn
            @Override // java.lang.Runnable
            public final void run() {
                bs.o0(ec2.a.this, bool, i3);
            }
        });
        return null;
    }

    public static v q(AppRuntime appRuntime, String str) {
        if (appRuntime != null && !TextUtils.isEmpty(str)) {
            com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c A = A(str, "getAvatarStatusId");
            if (A == null) {
                return new v(-1, "", -1);
            }
            AppRuntime.Status c16 = com.tencent.mobileqq.onlinestatus.utils.ae.c(A);
            AppRuntime.Status status = AppRuntime.Status.online;
            if (c16 != status) {
                return new v(c16.getValue(), ar.f(c16), -1);
            }
            if (A.e0() <= 0) {
                return new v(status.getValue(), ar.f(c16), -1);
            }
            return new v((int) A.e0(), af.C().I(c16, A.e0()).f255490c, t(A, (int) A.e0()));
        }
        return new v(-1, "", -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit q0(Boolean bool) {
        QLog.i("OnlineStatusUtil", 1, "[setRemoteGraySwitch]: set remote graySwitch result is " + bool);
        return null;
    }

    public static v r(AppRuntime.Status status, long j3) {
        if (status == null) {
            AppRuntime.Status status2 = AppRuntime.Status.offline;
            return new v(status2.getValue(), ar.f(status2), -1);
        }
        AppRuntime.Status status3 = AppRuntime.Status.online;
        if (status != status3) {
            return new v(status.getValue(), ar.f(status), -1);
        }
        if (j3 <= 0) {
            return new v(status3.getValue(), ar.f(status), -1);
        }
        au I = af.C().I(status, j3);
        if (I.e().booleanValue()) {
            QLog.d("OnlineStatusUtil", 1, "Status not found! id from: " + j3 + " to " + I.f255494g.getValue());
            j3 = (long) I.f255494g.getValue();
        }
        return new v((int) j3, I.f255490c, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int r0(Map.Entry entry, Map.Entry entry2) {
        return ((Long) entry2.getValue()).compareTo((Long) entry.getValue());
    }

    public static v s(int i3, int i16) {
        for (AppRuntime.Status status : AppRuntime.Status.values()) {
            if (i3 == status.getValue()) {
                return new v(i3, ar.f(status), i16);
            }
        }
        return new v(i3, af.C().I(AppRuntime.Status.online, i3).f255490c, i16);
    }

    public static void s0(String str, Activity activity) {
        if (activity == null) {
            QLog.e("OnlineStatusUtil", 1, "openJumpUrl activity = null");
            return;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str)) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity, str, 2016, null);
                return;
            }
            Intent intent = new Intent(activity, (Class<?>) JumpActivity.class);
            intent.setData(Uri.parse(str));
            activity.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("url", str);
        RouteUtils.startActivity(activity, intent2, RouterConstants.UI_ROUTE_BROWSER);
    }

    public static int t(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, int i3) {
        if (i3 != 1000) {
            return -1;
        }
        if (cVar != null && !TextUtils.isEmpty(cVar.f0())) {
            return af.C().s(cVar);
        }
        QLog.d("OnlineStatusUtil", 1, "getBatteryActionIndex simpleInfo == null");
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void t0(Friends friends, byte[] bArr) {
        String str;
        AppRuntime peekAppRuntime;
        int i3 = -1;
        long j3 = -1;
        if (bArr == null || bArr.length <= 0) {
            str = "";
        } else {
            try {
                OnlineStatusExtInfo$CustomStatus onlineStatusExtInfo$CustomStatus = new OnlineStatusExtInfo$CustomStatus();
                onlineStatusExtInfo$CustomStatus.mergeFrom(bArr);
                i3 = (int) onlineStatusExtInfo$CustomStatus.ufaceType.get();
                str = onlineStatusExtInfo$CustomStatus.sWording.get();
                try {
                    j3 = onlineStatusExtInfo$CustomStatus.ufaceIndex.get();
                } catch (Exception e16) {
                    e = e16;
                    QLog.e("OnlineStatusUtil", 1, "parseExtOnlineBusinessInfo fail", e);
                    friends.diyEmoType = i3;
                    friends.diyEmoSeverId = j3;
                    friends.diyDesc = str;
                    peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null) {
                        ((IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).setDiyInfo(new DiyStatusEmoInfo(friends.diyEmoType, friends.diyEmoSeverId, friends.diyDesc));
                        com.tencent.mobileqq.onlinestatus.utils.aa.i(friends.diyEmoSeverId, friends.diyEmoType, friends.diyDesc, peekAppRuntime);
                    }
                    if (!QLog.isColorLevel()) {
                    }
                }
            } catch (Exception e17) {
                e = e17;
                str = "";
            }
        }
        friends.diyEmoType = i3;
        friends.diyEmoSeverId = j3;
        friends.diyDesc = str;
        peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && TextUtils.equals(friends.uin, peekAppRuntime.getCurrentUin())) {
            ((IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).setDiyInfo(new DiyStatusEmoInfo(friends.diyEmoType, friends.diyEmoSeverId, friends.diyDesc));
            com.tencent.mobileqq.onlinestatus.utils.aa.i(friends.diyEmoSeverId, friends.diyEmoType, friends.diyDesc, peekAppRuntime);
        }
        if (!QLog.isColorLevel()) {
            QLog.d("OnlineStatusUtil", 2, "parseExtOnlineBusinessInfo: invoked. ", " friend.diyEmoType", Integer.valueOf(friends.diyEmoType), "  friend.diyDesc", friends.diyDesc, " friend.diyEmoSeverId", Long.valueOf(friends.diyEmoSeverId));
        }
    }

    public static final String u(int i3) {
        if (i3 >= 1 && i3 <= 12) {
            return f255654a[i3];
        }
        return "";
    }

    @Deprecated
    private static void u0(Friends friends, byte[] bArr, @Nullable Friends friends2) {
        Object obj;
        long j3;
        long j16 = friends.uExtOnlineStatus;
        if (j16 == 2000) {
            t0(friends, bArr);
            return;
        }
        if (bArr != null && bArr.length != 0) {
            if (j16 == 1040) {
                try {
                    OnlineStatusExtInfo$ZodiacBizInfo onlineStatusExtInfo$ZodiacBizInfo = new OnlineStatusExtInfo$ZodiacBizInfo();
                    onlineStatusExtInfo$ZodiacBizInfo.mergeFrom(bArr);
                    friends.constellationTodayTrend = onlineStatusExtInfo$ZodiacBizInfo.string_today_trend.get();
                    friends.constellationTomorrowTrend = onlineStatusExtInfo$ZodiacBizInfo.string_tomorrow_trend.get();
                    friends.constellationDateStr = onlineStatusExtInfo$ZodiacBizInfo.string_today_date.get();
                    friends.constellationJumpUrl = onlineStatusExtInfo$ZodiacBizInfo.string_miniapp.get();
                    if (onlineStatusExtInfo$ZodiacBizInfo.string_lucky_color.has()) {
                        friends.constellationLuckyNumber = String.valueOf(onlineStatusExtInfo$ZodiacBizInfo.string_lucky_number.get());
                    }
                    if (onlineStatusExtInfo$ZodiacBizInfo.string_lucky_number.has()) {
                        friends.constellationLuckyColor = String.valueOf(onlineStatusExtInfo$ZodiacBizInfo.string_lucky_color.get());
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("OnlineStatusUtil", 2, "parseExtOnlineBusinessInfo: invoked. ", kc2.c.b(friends));
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    QLog.e("OnlineStatusUtil", 1, "parseExtOnlineBusinessInfo fail", e16);
                    return;
                }
            }
            if (j16 == 1030) {
                try {
                    OnlineStatusExtInfo$WeatherBizInfo onlineStatusExtInfo$WeatherBizInfo = new OnlineStatusExtInfo$WeatherBizInfo();
                    onlineStatusExtInfo$WeatherBizInfo.mergeFrom(bArr);
                    long j17 = onlineStatusExtInfo$WeatherBizInfo.uint64_update_time.get();
                    if (QLog.isColorLevel()) {
                        Object[] objArr = new Object[4];
                        objArr[0] = "parseExtOnlineBusinessInfo: invoked. server time";
                        objArr[1] = Long.valueOf(j17);
                        objArr[2] = " local time: ";
                        if (friends2 == null) {
                            j3 = friends.weatherUpdateTime;
                        } else {
                            j3 = friends2.weatherUpdateTime;
                        }
                        objArr[3] = Long.valueOf(j3);
                        QLog.d("OnlineStatusUtil", 2, objArr);
                    }
                    if (friends2 != null) {
                        obj = " friend.weatherDecs: ";
                        long j18 = friends2.weatherUpdateTime;
                        if (j18 > j17) {
                            friends.weatherTypeId = friends2.weatherTypeId;
                            friends.weatherType = friends2.weatherType;
                            friends.temper = friends2.temper;
                            friends.city = friends2.city;
                            friends.area = friends2.area;
                            friends.adCode = friends2.adCode;
                            friends.weatherFlag = friends2.weatherFlag;
                            friends.weatherUpdateTime = j18;
                            if (onlineStatusExtInfo$WeatherBizInfo.string_weather_desc.has()) {
                                friends.weatherDecs = onlineStatusExtInfo$WeatherBizInfo.string_weather_desc.get();
                            }
                            if (OnlineStatusToggleUtils.B()) {
                                friends.weatherPrompt = friends2.weatherPrompt;
                                friends.weatherIconKey = friends2.weatherIconKey;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("OnlineStatusUtil", 2, "parseExtOnlineBusinessInfo: origin invoked. ", " friend.weatherFlag: ", Integer.valueOf(friends.weatherFlag), " friend.weatherIconKey: ", friends.weatherIconKey, " friend.weatherPrompt: ", friends.weatherPrompt, obj, friends.weatherDecs);
                                return;
                            }
                            return;
                        }
                    } else {
                        obj = " friend.weatherDecs: ";
                    }
                    if (j17 > friends.weatherUpdateTime) {
                        friends.weatherTypeId = onlineStatusExtInfo$WeatherBizInfo.string_weather_type_id.get();
                        friends.weatherType = onlineStatusExtInfo$WeatherBizInfo.string_weather_type.get();
                        friends.temper = onlineStatusExtInfo$WeatherBizInfo.string_temper.get();
                        friends.city = onlineStatusExtInfo$WeatherBizInfo.string_city.get();
                        friends.area = onlineStatusExtInfo$WeatherBizInfo.string_area.get();
                        friends.adCode = onlineStatusExtInfo$WeatherBizInfo.uint32_adcode.get() + "";
                        friends.weatherFlag = onlineStatusExtInfo$WeatherBizInfo.uint32_flag.get();
                        friends.weatherUpdateTime = j17;
                        if (onlineStatusExtInfo$WeatherBizInfo.string_weather_desc.has()) {
                            friends.weatherDecs = onlineStatusExtInfo$WeatherBizInfo.string_weather_desc.get();
                        }
                        if (OnlineStatusToggleUtils.B()) {
                            friends.weatherIconKey = onlineStatusExtInfo$WeatherBizInfo.icon_key.get();
                            friends.weatherPrompt = onlineStatusExtInfo$WeatherBizInfo.prompt.get();
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("OnlineStatusUtil", 2, "parseExtOnlineBusinessInfo: invoked. ", " friend.weatherFlag: ", Integer.valueOf(friends.weatherFlag), " friend.weatherIconKey: ", friends.weatherIconKey, " friend.weatherPrompt: ", friends.weatherPrompt, obj, friends.weatherDecs);
                        return;
                    }
                    return;
                } catch (Exception e17) {
                    QLog.e("OnlineStatusUtil", 1, "parseExtOnlineBusinessInfo fail", e17);
                    return;
                }
            }
            if (j16 == 1021) {
                O(friends, bArr);
            }
        }
    }

    public static String v(int i3) {
        return String.format(Locale.getDefault(), "%d+", Integer.valueOf(i3));
    }

    @Deprecated
    public static void v0(Friends friends, byte[] bArr, String str) {
        w0(friends, bArr, str, null);
    }

    public static boolean w(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int F = F(str);
        if (F != 0) {
            QLog.i("OnlineStatusUtil", 1, "[getFriendAvatarOpened]: remoteOperateFlag is " + F);
            if (F != 3) {
                return false;
            }
            return true;
        }
        return be.n(str);
    }

    @Deprecated
    public static void w0(Friends friends, byte[] bArr, String str, @Nullable Friends friends2) {
        u0(friends, bArr, friends2);
    }

    public static String x(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        if (TextUtils.isEmpty(uidFromUin)) {
            return str;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "OnlineStatusUtil_getFriendName");
        if (friendsSimpleInfoWithUid != null) {
            return friendsSimpleInfoWithUid.m();
        }
        return str;
    }

    @Deprecated
    public static void x0(Friends friends, byte[] bArr, long j3, HashMap<String, Long> hashMap) {
        String str;
        if (bArr != null && bArr.length != 0) {
            try {
                OnlineStatusExtInfo$MainStatusExtData onlineStatusExtInfo$MainStatusExtData = new OnlineStatusExtInfo$MainStatusExtData();
                onlineStatusExtInfo$MainStatusExtData.mergeFrom(bArr);
                friends.onlineStatusUpdateTime = onlineStatusExtInfo$MainStatusExtData.uint64_status_set_time.get();
            } catch (Exception e16) {
                QLog.e("OnlineStatusUtil", 1, "parseVecExtInfo fail", e16);
            }
            AppRuntime.Status b16 = com.tencent.mobileqq.onlinestatus.utils.ae.b(friends.detalStatusFlag);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentUin();
            } else {
                str = "";
            }
            if (hashMap != null && j3 != friends.onlineStatusUpdateTime && !str.equals(friends.uin) && !Utils.G(friends.uin)) {
                if (friends.uExtOnlineStatus != 0 || b16 != AppRuntime.Status.online) {
                    hashMap.put(friends.uin, Long.valueOf(friends.onlineStatusUpdateTime));
                    x.a(friends.uin, friends.onlineStatusUpdateTime);
                }
            }
        }
    }

    private static boolean y(@NonNull AppRuntime appRuntime) {
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        int friendCount = iFriendsInfoService.getFriendCount("OnlineStatusUtil");
        if (friendCount > 1) {
            return false;
        }
        if (friendCount != 1) {
            return true;
        }
        String currentUid = appRuntime.getCurrentUid();
        if (TextUtils.isEmpty(currentUid) || iFriendsInfoService.getFriendsSimpleInfoWithUid(currentUid, "OnlineStatusUtil") == null) {
            return false;
        }
        return true;
    }

    public static void y0() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        from.encodeInt("AVATAR_FIRST_SHOW_GOTO_SHARE_TIPS", from.decodeInt("AVATAR_FIRST_SHOW_GOTO_SHARE_TIPS", 0) + 1);
    }

    public static AppRuntime.Status z(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        int a16 = com.tencent.mobileqq.friend.status.b.a(cVar.u(), cVar.z());
        AppRuntime.Status status = AppRuntime.Status.online;
        if (a16 != 1) {
            if (a16 != 2) {
                if (a16 != 3) {
                    if (a16 != 4) {
                        if (a16 != 7) {
                            QLog.d("OnlineStatusUtil", 1, "getOldStatus err, newStatus is " + a16);
                            return status;
                        }
                        return AppRuntime.Status.dnd;
                    }
                    return status;
                }
                return AppRuntime.Status.qme;
            }
            return AppRuntime.Status.busy;
        }
        return AppRuntime.Status.away;
    }

    public static void z0(final ec2.a aVar) {
        QLog.d("OnlineStatusSuperShowSwitch", 1, "setAvatarAccountWhite");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i("OnlineStatusUtil", 1, "[saveAvatarAccountAutoWhite]: app is null");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.bo
                @Override // java.lang.Runnable
                public final void run() {
                    ec2.a.this.a(false);
                }
            });
            return;
        }
        IOnlineStatusAvatarSwitchService iOnlineStatusAvatarSwitchService = (IOnlineStatusAvatarSwitchService) peekAppRuntime.getRuntimeService(IOnlineStatusAvatarSwitchService.class, "");
        com.tencent.mobileqq.onlinestatus.model.f switchStatus = iOnlineStatusAvatarSwitchService.getSwitchStatus(peekAppRuntime.getCurrentAccountUin());
        if (switchStatus != null && switchStatus.getAutoWhiteSwitch()) {
            QLog.i("OnlineStatusUtil", 1, "[saveAvatarAccountAutoWhite]: remote already set");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.bp
                @Override // java.lang.Runnable
                public final void run() {
                    ec2.a.this.a(false);
                }
            });
        } else {
            iOnlineStatusAvatarSwitchService.setSelfAutoWhitelistOn(new Function1() { // from class: com.tencent.mobileqq.onlinestatus.bq
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit m06;
                    m06 = bs.m0(ec2.a.this, (Boolean) obj);
                    return m06;
                }
            });
        }
    }
}
