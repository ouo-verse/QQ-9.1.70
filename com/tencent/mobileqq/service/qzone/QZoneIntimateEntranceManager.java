package com.tencent.mobileqq.service.qzone;

import NS_UNDEAL_COUNT.mobile_count_rsp_new;
import NS_UNDEAL_COUNT.stIntimateSpaceInfo;
import NS_UNDEAL_COUNT.stToOpenSpaceUins;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneIntimateEntranceInfoApi;
import com.tencent.qzonehub.api.IQZoneMMKVApi;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.ArrayUtils;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.api.QZoneApiProxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import mqq.app.MobileQQ;
import uq3.k;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QZoneIntimateEntranceManager {
    static IPatchRedirector $redirector_;

    private static void A(String str) {
        String f16 = f(str);
        int intValue = ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getIntValue(f16, 0);
        QLog.i("QZoneIntimateEntranceManager", 1, "uin is " + str + ", has show times is " + intValue);
        ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveInt(f16, intValue + 1);
    }

    private static void B(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        z(System.currentTimeMillis() / 1000);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            A(next);
            arrayList2.add(next);
            QLog.i("QZoneIntimateEntranceManager", 1, "uin chosen from list is " + next);
        }
        ((IQZoneIntimateEntranceInfoApi) QRoute.api(IQZoneIntimateEntranceInfoApi.class)).saveEntranceAvatarUinList(arrayList2);
    }

    private static boolean c() {
        long longValue = ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getLongValue("intimate_entrance_avatar_show_time_interval", 0L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long entranceAvatarShowInterval = ((IQZoneIntimateEntranceInfoApi) QRoute.api(IQZoneIntimateEntranceInfoApi.class)).getEntranceAvatarShowInterval();
        long j3 = currentTimeMillis - longValue;
        QLog.i("QZoneIntimateEntranceManager", 1, "time interval is " + j3);
        if (j3 > entranceAvatarShowInterval) {
            return true;
        }
        return false;
    }

    private static boolean d(String str) {
        if (((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getIntValue(f(str), 0) < ((IQZoneIntimateEntranceInfoApi) QRoute.api(IQZoneIntimateEntranceInfoApi.class)).getEntranceAvatarShowTimes()) {
            return false;
        }
        return true;
    }

    private static ArrayList<String> e(ArrayList<String> arrayList, int i3) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (ArrayUtils.isOutOfArrayIndex(0, arrayList)) {
            return arrayList2;
        }
        ArrayList<String> entranceAvatarUinList = ((IQZoneIntimateEntranceInfoApi) QRoute.api(IQZoneIntimateEntranceInfoApi.class)).getEntranceAvatarUinList();
        if (ArrayUtils.isOutOfArrayIndex(0, entranceAvatarUinList)) {
            if (arrayList.size() > i3) {
                arrayList2.addAll(arrayList.subList(0, i3));
            } else {
                arrayList2.addAll(arrayList);
            }
        } else {
            y(arrayList, arrayList2, entranceAvatarUinList, i3);
        }
        if (ArrayUtils.isOutOfArrayIndex(0, arrayList2)) {
            return arrayList2;
        }
        B(arrayList2, entranceAvatarUinList);
        return arrayList2;
    }

    private static String f(String str) {
        return "intimate_entrance_avatar_show_time_prefix" + str;
    }

    public static ArrayList<String> g(int i3) {
        ArrayList<String> arrayList = new ArrayList<>();
        String stringValue = ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getStringValue("intimate_open_space_uin_string", "");
        if (TextUtils.isEmpty(stringValue)) {
            QLog.i("QZoneIntimateEntranceManager", 1, "openSpaceUinString is empty");
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(Arrays.asList(stringValue.split(",")));
        if (!c()) {
            return arrayList;
        }
        return e(arrayList2, i3);
    }

    public static boolean h() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("INTIMATE_DRAWER_SWITCH_CLOSE", false);
        boolean booleanValue = ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getBooleanValue("drawer_switch", false);
        QLog.i("QZoneIntimateEntranceManager", 1, "isDrawerNeedClose is " + isSwitchOn + ", isDrawerGrayOpen is " + booleanValue);
        if (isSwitchOn || !booleanValue) {
            return false;
        }
        return true;
    }

    public static String i(QZoneCountInfo qZoneCountInfo) {
        if (qZoneCountInfo == null) {
            QLog.e("QZoneIntimateEntranceManager", 1, "[getIntimateEntranceAvatarUin] countInfo is null");
            return "";
        }
        ArrayList<QZoneCountUserInfo> arrayList = qZoneCountInfo.friendList;
        if (bl.b(arrayList)) {
            QLog.e("QZoneIntimateEntranceManager", 1, "[getIntimateEntranceAvatarUin] invalidate uin list");
            return "";
        }
        long j3 = arrayList.get(0).uin;
        if (j3 == 0) {
            return "";
        }
        return j3 + "";
    }

    public static String j() {
        return k.a().h("intimate_entrance_guide", "");
    }

    public static boolean k() {
        return ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getBooleanValue("intimate_entrance_is_show", false);
    }

    public static String l(QZoneCountInfo qZoneCountInfo) {
        if (qZoneCountInfo == null) {
            QLog.e("QZoneIntimateEntranceManager", 1, "[getIntimateEntranceRightText] countInfo is null");
            return "";
        }
        if (TextUtils.isEmpty(qZoneCountInfo.strShowMsg)) {
            QLog.e("QZoneIntimateEntranceManager", 1, "[getIntimateEntranceRightText] strShowMsg is null");
            return "";
        }
        return qZoneCountInfo.strShowMsg;
    }

    public static boolean m() {
        return ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getBooleanValue("msg_tab_switch", false);
    }

    private static ArrayList<String> n(ArrayList<String> arrayList, ArrayList<String> arrayList2, int i3) {
        ArrayList<String> arrayList3 = new ArrayList<>();
        for (int i16 = 0; i16 < arrayList2.size(); i16++) {
            String str = arrayList2.get(i16);
            if (arrayList.contains(str) && !d(str)) {
                arrayList3.add(str);
                if (arrayList3.size() >= i3) {
                    break;
                }
            }
        }
        Iterator<String> it = arrayList3.iterator();
        while (it.hasNext()) {
            arrayList2.remove(it.next());
        }
        return arrayList3;
    }

    private static void o(@NonNull Map<String, String> map) {
        if (map.containsKey("drawer_switch")) {
            String str = map.get("drawer_switch");
            QLog.i("QZoneIntimateEntranceManager", 1, "drawer switch is " + str);
            ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveBoolean("drawer_switch", TextUtils.equals(str, "1"));
            ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveBoolean("intimate_entrance_is_show", TextUtils.equals(str, "1"));
            return;
        }
        QLog.e("QZoneIntimateEntranceManager", 1, "not contain drawer tab switch key");
    }

    public static void p(mobile_count_rsp_new mobile_count_rsp_newVar, String str) {
        if (mobile_count_rsp_newVar != null && !TextUtils.isEmpty(str)) {
            stIntimateSpaceInfo stintimatespaceinfo = mobile_count_rsp_newVar.intimateSpaceInfo;
            if (stintimatespaceinfo == null) {
                QLog.e("QZoneIntimateEntranceManager", 1, "intimateSpaceInfo is empty, return");
                return;
            } else {
                RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.service.qzone.QZoneIntimateEntranceManager.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) stIntimateSpaceInfo.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            QZoneIntimateEntranceManager.w(stIntimateSpaceInfo.this);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }
                });
                return;
            }
        }
        QLog.e("QZoneIntimateEntranceManager", 1, "rsp or uin is null");
    }

    private static void q(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            s(map);
            o(map);
        } else {
            QLog.e("QZoneIntimateEntranceManager", 1, "entrance extra info map is empty");
            ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveBoolean("msg_tab_switch", false);
            ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveBoolean("drawer_switch", false);
        }
    }

    private static void r(stIntimateSpaceInfo stintimatespaceinfo) {
        if (stintimatespaceinfo == null) {
            return;
        }
        Map<Integer, byte[]> map = stintimatespaceinfo.mapOptData;
        if (map != null && !map.isEmpty()) {
            t(map);
        } else {
            QLog.i("QZoneIntimateEntranceManager", 1, "mapOptData is null or empty");
        }
    }

    private static void s(@NonNull Map<String, String> map) {
        if (map.containsKey("msg_tab_switch")) {
            String str = map.get("msg_tab_switch");
            QLog.i("QZoneIntimateEntranceManager", 1, "msg tab switch is " + str);
            ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveBoolean("msg_tab_switch", TextUtils.equals(str, "1"));
            return;
        }
        QLog.e("QZoneIntimateEntranceManager", 1, "not contain msg tab switch key");
    }

    private static void t(@NonNull Map<Integer, byte[]> map) {
        if (!map.containsKey(1)) {
            QLog.i("QZoneIntimateEntranceManager", 1, "not contains _ENUM_TO_OPEN_SPACE_UINS key");
            return;
        }
        byte[] bArr = map.get(1);
        if (bArr == null) {
            QLog.e("QZoneIntimateEntranceManager", 1, "spaceUinBytes is null");
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable(bArr) { // from class: com.tencent.mobileqq.service.qzone.QZoneIntimateEntranceManager.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ byte[] f286386d;

                {
                    this.f286386d = bArr;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) bArr);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        stToOpenSpaceUins sttoopenspaceuins = (stToOpenSpaceUins) cooperation.vip.a.a(stToOpenSpaceUins.class, this.f286386d);
                        if (sttoopenspaceuins == null) {
                            QLog.e("QZoneIntimateEntranceManager", 1, "stToOpenSpaceUinList is null");
                        } else if (!ArrayUtils.isOutOfArrayIndex(0, sttoopenspaceuins.toOpenSpacesUins)) {
                            QZoneIntimateEntranceManager.x(sttoopenspaceuins.toOpenSpacesUins);
                        } else {
                            QLog.i("QZoneIntimateEntranceManager", 1, "toOpenSpacesUinList is null or empty");
                            ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveString("intimate_open_space_uin_string", "");
                        }
                    } catch (Throwable th5) {
                        QLog.e("QZoneIntimateEntranceManager", 1, "throwable is " + th5);
                    }
                }
            });
        }
    }

    public static boolean u() {
        if (!QZoneApiProxy.needShowQzoneFrame(BaseApplication.getContext(), MobileQQ.sMobileQQ.peekAppRuntime())) {
            return true;
        }
        if (!QZoneConfigHelper.F()) {
            QLog.e("QZoneIntimateEntranceManager", 2, "[enableShowMomentBanner] switch close:");
            return false;
        }
        return !v();
    }

    public static boolean v() {
        if (!QZoneConfigHelper.E()) {
            QLog.i("QZoneIntimateEntranceManager", 2, "[isIntimateSwitchOpen] switch close:");
            return false;
        }
        if (SimpleUIUtil.isNowElderMode()) {
            QLog.i("QZoneIntimateEntranceManager", 2, "[isIntimateSwitchOpen] is now elder mode:");
            return false;
        }
        if (QzoneFrame.isShowOldQZoneFrame()) {
            QLog.i("QZoneIntimateEntranceManager", 2, "[isIntimateSwitchOpen] is show old qzone frame:");
            return false;
        }
        boolean k3 = k();
        if (QLog.isColorLevel()) {
            QLog.i("QZoneIntimateEntranceManager", 2, "[isIntimateSwitchOpen] switch open:" + k3);
        }
        return k3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(stIntimateSpaceInfo stintimatespaceinfo) {
        if (stintimatespaceinfo == null) {
            QLog.e("QZoneIntimateEntranceManager", 1, "mapEntranceCfg is empty, return");
            return;
        }
        if (!stintimatespaceinfo.update) {
            QLog.i("QZoneIntimateEntranceManager", 1, "no need to update space info this time");
            return;
        }
        if (!TextUtils.isEmpty(stintimatespaceinfo.text)) {
            k.a().p("intimate_entrance_name", stintimatespaceinfo.text);
        }
        if (!TextUtils.isEmpty(stintimatespaceinfo.iconUrl)) {
            k.a().p("intimate_entrance_icon", stintimatespaceinfo.iconUrl);
        }
        if (!TextUtils.isEmpty(stintimatespaceinfo.rightText)) {
            k.a().p("intimate_entrance_guide", stintimatespaceinfo.rightText);
        }
        if (!TextUtils.isEmpty(stintimatespaceinfo.jumpUrl)) {
            k.a().p("intimate_entrance_jump_url", stintimatespaceinfo.jumpUrl);
        }
        q(stintimatespaceinfo.entranceExtInfo);
        r(stintimatespaceinfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void x(ArrayList<String> arrayList) {
        if (ArrayUtils.isOutOfArrayIndex(0, arrayList)) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            sb5.append(arrayList.get(i3));
            if (i3 != arrayList.size() - 1) {
                sb5.append(",");
            }
        }
        QLog.i("QZoneIntimateEntranceManager", 1, "uin string is " + ((Object) sb5));
        ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveString("intimate_open_space_uin_string", sb5.toString());
    }

    private static void y(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, int i3) {
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            String str = arrayList.get(i16);
            if (!arrayList3.contains(str)) {
                if (arrayList2.size() >= i3) {
                    break;
                } else {
                    arrayList2.add(str);
                }
            }
        }
        if (arrayList2.size() < i3) {
            arrayList2.addAll(n(arrayList, arrayList3, i3 - arrayList2.size()));
        }
    }

    private static void z(long j3) {
        ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveLong("intimate_entrance_avatar_show_time_interval", j3);
    }
}
