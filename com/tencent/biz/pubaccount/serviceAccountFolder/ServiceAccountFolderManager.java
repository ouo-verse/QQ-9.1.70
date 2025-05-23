package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.studymode.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ServiceAccountFolderManager {

    /* renamed from: c, reason: collision with root package name */
    private static ServiceAccountFolderManager f79956c = new ServiceAccountFolderManager();

    /* renamed from: d, reason: collision with root package name */
    private static Set<String> f79957d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    private static Set<String> f79958e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private static Set<String> f79959f = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    private static boolean f79960g = false;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f79961h = false;

    /* renamed from: a, reason: collision with root package name */
    private String f79962a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, Integer> f79963b = new HashMap<>();

    static {
        f79957d.add(new String("2171946401"));
    }

    private void A(IFeatureRuntimeService iFeatureRuntimeService, boolean z16) {
        JSONObject jSONObject;
        v(z16);
        if (!z16 || (jSONObject = iFeatureRuntimeService.getJSONObject("pa_WhiteList_in_studyMode_860178803", "")) == null) {
            return;
        }
        try {
            x(f(jSONObject, "studymode"));
        } catch (JSONException e16) {
            QLog.e("ServiceAccountFolderManager", 1, "Parsing WhitList From DataSet of Toggle is failed , ", e16);
        }
    }

    private int B(String str, int i3, int i16) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountBelongInfo->empty puin!");
            }
            return 0;
        }
        synchronized (this.f79963b) {
            Integer valueOf = Integer.valueOf((i3 << 2) + i16);
            if (this.f79963b.containsKey(str)) {
                if (this.f79963b.get(str) != null && valueOf.equals(this.f79963b.get(str))) {
                    return 0;
                }
                this.f79963b.put(str, valueOf);
                return 2;
            }
            this.f79963b.put(str, valueOf);
            return 1;
        }
    }

    private static boolean a(AppRuntime appRuntime, String str, FriendsManager friendsManager) {
        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ServiceAccountFolderManager")) {
            return true;
        }
        return false;
    }

    public static int b() {
        return R.drawable.icon_recent_service_account_folder;
    }

    public static Drawable c() {
        Drawable drawable = BaseApplicationImpl.sApplication.getResources().getDrawable(b());
        if (!TextUtils.isEmpty(((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderIcon())) {
            return URLDrawable.getDrawable(((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderIcon(), drawable, drawable);
        }
        return drawable;
    }

    public static ServiceAccountFolderManager d() {
        if (f79956c == null) {
            synchronized (ServiceAccountFolderManager.class) {
                f79956c = new ServiceAccountFolderManager();
            }
        }
        return f79956c;
    }

    private static int e(AppRuntime appRuntime, String str, boolean z16) {
        IPublicAccountDataManager iPublicAccountDataManager;
        IPublicAccountDetail iPublicAccountDetail;
        long accountFlag2;
        int i3;
        int accountFlag;
        int i16 = 0;
        if (appRuntime != null && !TextUtils.isEmpty(str)) {
            PublicAccountInfo publicAccountInfo = null;
            IPublicAccountDetail iPublicAccountDetail2 = null;
            try {
                iPublicAccountDataManager = (IPublicAccountDataManager) appRuntime.getRuntimeService(IPublicAccountDataManager.class, "all");
            } catch (Throwable th5) {
                th5.printStackTrace();
                iPublicAccountDataManager = null;
            }
            if (iPublicAccountDataManager != null) {
                PublicAccountInfo publicAccountInfo2 = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfoCache(str);
                if (publicAccountInfo2 == null) {
                    iPublicAccountDetail2 = iPublicAccountDataManager.findAccountDetailInfoCache(str);
                }
                iPublicAccountDetail = iPublicAccountDetail2;
                publicAccountInfo = publicAccountInfo2;
            } else {
                iPublicAccountDetail = null;
            }
            if (publicAccountInfo == null && iPublicAccountDetail == null) {
                if (o(str) || a(appRuntime, str, (FriendsManager) appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER))) {
                    return 0;
                }
                Message lastMessage = ((IMessageFacade) appRuntime.getRuntimeService(IMessageFacade.class, "")).getLastMessage(str, 1008);
                if (lastMessage != null) {
                    if (lastMessage.istroop != 1008 || yx.a.a(lastMessage)) {
                        return 0;
                    }
                    String extInfoFromExtStr = lastMessage.getExtInfoFromExtStr("inter_num");
                    if (!TextUtils.isEmpty(extInfoFromExtStr) && extInfoFromExtStr.equals("1")) {
                        int B = d().B(str, 2, 2);
                        if (B > 0) {
                            StringBuilder sb5 = new StringBuilder(128);
                            sb5.append("updateServiceAccountBelongInfo(");
                            sb5.append(B);
                            sb5.append(")->getPublicAccountFolderType->puin:");
                            sb5.append(str);
                            sb5.append(", folder type:");
                            sb5.append(2);
                            sb5.append(", inter_num:1");
                            QLog.d("ServiceAccountFolderManager", 1, sb5.toString());
                        }
                        return 2;
                    }
                    if (!TextUtils.isEmpty(extInfoFromExtStr) && extInfoFromExtStr.equals("2")) {
                        int B2 = d().B(str, 3, 2);
                        if (B2 > 0) {
                            StringBuilder sb6 = new StringBuilder(128);
                            sb6.append("updateServiceAccountBelongInfo(");
                            sb6.append(B2);
                            sb6.append(")->getPublicAccountFolderType->puin:");
                            sb6.append(str);
                            sb6.append(", folder type:");
                            sb6.append(3);
                            sb6.append(", inter_num:2");
                            QLog.d("ServiceAccountFolderManager", 1, sb6.toString());
                        }
                        return 3;
                    }
                }
                int B3 = d().B(str, 1, 2);
                if (B3 > 0) {
                    StringBuilder sb7 = new StringBuilder(150);
                    sb7.append("updateServiceAccountBelongInfo(");
                    sb7.append(B3);
                    sb7.append(")->getPublicAccountFolderType->puin:");
                    sb7.append(str);
                    sb7.append(", folder type:");
                    sb7.append(1);
                    sb7.append(", no info to judge, default service folder!");
                    QLog.d("ServiceAccountFolderManager", 1, sb7.toString());
                }
                return 1;
            }
            if (publicAccountInfo != null) {
                accountFlag2 = publicAccountInfo.accountFlag2;
            } else {
                accountFlag2 = iPublicAccountDetail.getAccountFlag2();
            }
            int i17 = (int) ((30720 & accountFlag2) >> 11);
            if (i17 != 1) {
                if (i17 != 2) {
                    i3 = 3;
                    if (i17 != 3) {
                        if (i17 != 4) {
                            i16 = -1;
                        } else {
                            i16 = 3;
                        }
                    }
                } else {
                    i3 = 3;
                    i16 = 1;
                }
            } else {
                i3 = 3;
                i16 = 2;
            }
            if (publicAccountInfo != null) {
                accountFlag = publicAccountInfo.accountFlag;
            } else {
                accountFlag = iPublicAccountDetail.getAccountFlag();
            }
            int accountType = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType(accountFlag);
            if (((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isSubscript(accountFlag, accountFlag2)) {
                i3 = 2;
            } else if (accountType != -5) {
                i3 = 1;
            }
            if ((i16 == 0 && i3 == 2) || (i16 == 2 && i3 == 1)) {
                i16 = 1;
            } else if (i16 == -1) {
                i16 = i3;
            }
            int B4 = d().B(str, i16, 1);
            if (B4 > 0) {
                StringBuilder sb8 = new StringBuilder(256);
                sb8.append("updateServiceAccountBelongInfo(");
                sb8.append(B4);
                sb8.append(")->getPublicAccountFolderType->puin:");
                sb8.append(str);
                sb8.append(", folder type:");
                sb8.append(i16);
                if (publicAccountInfo != null) {
                    sb8.append(", info accountFlag:");
                    sb8.append(publicAccountInfo.accountFlag);
                    sb8.append(", info accountFlag2:");
                    sb8.append(publicAccountInfo.accountFlag2);
                }
                if (iPublicAccountDetail != null) {
                    sb8.append(", detail accountFlag:");
                    sb8.append(iPublicAccountDetail.getAccountData());
                    sb8.append(", detail accountFlag2:");
                    sb8.append(iPublicAccountDetail.getAccountFlag2());
                }
                QLog.d("ServiceAccountFolderManager", 1, sb8.toString());
            }
            return i16;
        }
        int B5 = d().B(str, 1, 0);
        if (B5 > 0) {
            StringBuilder sb9 = new StringBuilder(150);
            sb9.append("updateServiceAccountBelongInfo(");
            sb9.append(B5);
            sb9.append(")->getPublicAccountFolderType->");
            sb9.append(", folder type:");
            sb9.append(1);
            sb9.append(", error param, default service folder!");
            QLog.d("ServiceAccountFolderManager", 1, sb9.toString());
        }
        return 1;
    }

    private Set<String> f(JSONObject jSONObject, String str) throws JSONException {
        HashSet hashSet = new HashSet();
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return hashSet;
        }
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            hashSet.add(optJSONArray.getString(i3));
        }
        return hashSet;
    }

    public static Set<String> g() {
        return f79959f;
    }

    public static Set<String> h() {
        return f79958e;
    }

    public static boolean j(QQAppInterface qQAppInterface, String str) {
        int e16 = e(qQAppInterface, str, false);
        if (QLog.isColorLevel()) {
            QLog.d("EcShopAssistantManager", 2, "isBelongEcShopFolder->puin:" + str + ", type:" + e16);
        }
        if (e16 != 3) {
            return false;
        }
        return true;
    }

    public static boolean k(QQAppInterface qQAppInterface, String str) {
        if (e(qQAppInterface, str, true) == 0) {
            return true;
        }
        return false;
    }

    public static boolean l(QQAppInterface qQAppInterface, String str) {
        if (o(str) || e(qQAppInterface, str, true) != 1) {
            return false;
        }
        return true;
    }

    public static boolean m(AppRuntime appRuntime, String str) {
        if (o(str) || e(appRuntime, str, false) != 1) {
            return false;
        }
        return true;
    }

    public static boolean n(AppInterface appInterface, String str) {
        if (e(appInterface, str, false) != 2) {
            return false;
        }
        return true;
    }

    public static boolean o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return f79957d.contains(str);
    }

    public static boolean p() {
        return SimpleUIUtil.getSimpleUISwitch();
    }

    public static boolean q() {
        return ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
    }

    public static boolean r() {
        return f79961h;
    }

    public static boolean s() {
        return f79960g;
    }

    public static void t(boolean z16) {
        f79961h = z16;
    }

    public static String u(int i3) {
        String valueOf = String.valueOf(i3);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("folder_status", valueOf);
            return jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static void v(boolean z16) {
        f79960g = z16;
    }

    public static void w(Set<String> set) {
        f79959f = set;
    }

    public static void x(Set<String> set) {
        f79958e = set;
    }

    private void z(IFeatureRuntimeService iFeatureRuntimeService, boolean z16) {
        JSONObject jSONObject;
        t(z16);
        if (!z16 || (jSONObject = iFeatureRuntimeService.getJSONObject("pa_WhiteList_in_ConciseMode_867012523", "")) == null) {
            return;
        }
        try {
            w(f(jSONObject, "concisemode"));
        } catch (JSONException e16) {
            QLog.e("ServiceAccountFolderManager", 1, "Parsing WhitList From DataSet of Toggle is failed , ", e16);
        }
    }

    public void i(final QQAppInterface qQAppInterface) {
        if (TextUtils.isEmpty(this.f79962a) || !this.f79962a.equals(qQAppInterface.getAccount())) {
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + qQAppInterface.getCurrentAccountUin(), 0);
            if (sharedPreferences != null) {
                ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).setServiceFolderRedCleanAfterEnter(sharedPreferences.getBoolean("service_folder_redclean_after_enter", false));
            }
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (QLog.isColorLevel()) {
                        QLog.d("ServiceAccountFolderManager", 2, "initToggle:pa_WhiteList_in_ConciseMode_867012523pa_WhiteList_in_studyMode_860178803");
                    }
                    ServiceAccountFolderManager.this.y("pa_WhiteList_in_ConciseMode_867012523", qQAppInterface);
                    ServiceAccountFolderManager.this.y("pa_WhiteList_in_studyMode_860178803", qQAppInterface);
                    ((IChatsUtil) QRoute.api(IChatsUtil.class)).triggerChatsNtFilter(g.a());
                }
            });
            this.f79962a = qQAppInterface.getAccount();
            if (QLog.isColorLevel()) {
                QLog.d("ServiceAccountFolderManager", 2, "initManager->cuin:" + this.f79962a);
            }
        }
    }

    public void y(String str, AppRuntime appRuntime) {
        if (appRuntime == null) {
            return;
        }
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        boolean isFeatureSwitchEnable = iFeatureRuntimeService.isFeatureSwitchEnable(str);
        if ("pa_WhiteList_in_studyMode_860178803".equals(str)) {
            A(iFeatureRuntimeService, isFeatureSwitchEnable);
        } else if ("pa_WhiteList_in_ConciseMode_867012523".equals(str)) {
            z(iFeatureRuntimeService, isFeatureSwitchEnable);
        }
    }
}
