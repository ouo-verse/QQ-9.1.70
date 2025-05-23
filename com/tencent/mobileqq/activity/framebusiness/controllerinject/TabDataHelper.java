package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.home.al;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.logic.TabDataHandler;
import com.tencent.mobileqq.pb.UserDynamicTab;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TabDataHelper {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_GROUND_TOGGLE_GUILD_INIT = "keyGroundToggleGuildInit";
    public static final String KEY_REAL_TAB_INIT = "KeyRealTabInit";
    public static final String KEY_TAB_CURRENT_MANUAL_TAB = "KeyTabCurrentManualTab";
    public static final String KEY_TAB_DEBUG_GUILD_RECOVER = "KeyTabDebugGuildRecover";
    public static final String KEY_TAB_FIRST_NEW_WORLD_RIJ = "KeyTabFirstNewWorldRIJ";
    public static final String KEY_TAB_FIRST_SHOW = "KeyTabFirstShow";
    public static final String KEY_TAB_FIX_NEW_WORLD_RIJ = "KeyTabFixNewWorldRIJ";
    public static final String KEY_TAB_FULL_ADAPT = "KeyTabFullAdapt";
    public static final String KEY_TAB_INIT = "KeyTabInit";
    public static final String KEY_TAB_JUMP_GUILD_SWITCH = "KeyTabJumpGuildSwitch";
    public static final String KEY_TAB_LOCAL_SWITCH = "KeyTabLocalSwitch";
    public static final String KEY_TAB_RULE = "KeyTabRule";
    public static final String KEY_TAB_SEQUENCE = "KeyTabSequence";
    public static final String KEY_TAB_SHIELD = "KeyTabShield";
    public static final String KEY_TAB_SWITCH = "KeyTabSwitch";
    public static final String K_TAB_DATA_HELPER_SP = "TabDataHelper_Shared_Prefs";
    public static final String SCENE_ASSISTANT_SETTING = "assistant_setting";
    public static final String SCENE_BOTTOM_TAB_SETTING = "bottom_tab_setting";
    public static final String SCENE_GUILD_USER = "guild_user";
    public static final String SCENE_IS_TAB_SHOW = "is_tab_show";
    public static final String SCENE_OPEN_COUNT = "open_count";
    public static final String[] TAB_ARRAY_CONSTANT;
    public static final String[] TAB_CONFIG_ARRAY;
    public static final String[] TAB_CONFIG_ARRAY_8970;
    public static final String[] TAB_CONFIG_ARRAY_OLD;
    public static final String[] TAB_CONFIG_ARRAY_TEEN;
    public static final String TAB_CONTACT = "CONTACT";
    public static final String TAB_CONVERSATION = "CONVERSATION";
    public static final int TAB_COUNT_LIMIT = 5;
    public static final String TAB_FEATURE_GUILD_UPDATE = "tab_feature_guild_update";
    public static final String TAB_GUILD = "GUILD";
    public static final String TAB_LEBA = "LEBA";
    public static final String TAB_META_DREAM = "META_DREAM";
    public static final String TAB_NEW_WORLD = "NEW_WORLD";
    public static final String TAB_QZONE = "QZONE";
    public static final String TAB_RIJ = "RIJ";
    public static final String TAB_SPLIT_KED_CODE = "_";
    public static final String TAB_SPLIT_TAB_CODE = " ";
    public static final String TAG = "FrameUtil.TabDataHelper";
    public static final String VALUE_SETTING_BOTTOM_TAB = "0X800BE84";
    public static final String VALUE_SETTING_ENTRANCE_REPORT = "0X800BF4A";
    public static final String VALUE_SETTING_GUIDE_CLICK = "0X800BE05";
    public static final String VALUE_SETTING_GUIDE_REPORT = "0X800BE04";
    public static final String VALUE_SETTING_META_DREAM_CLICK = "0X800C5D8";
    public static final String VALUE_SETTING_META_DREAM_REPORT = "0X800C5D7";
    public static final String VALUE_SETTING_NEW_WORLD_CLICK = "0X800BE8A";
    public static final String VALUE_SETTING_NEW_WORLD_REPORT = "0X800BE89";
    public static final String VALUE_SETTING_NONE_CLICK = "0X800BE86";
    public static final String VALUE_SETTING_NONE_REPORT = "0X800BE85";
    public static final String VALUE_SETTING_RIJ_CLICK = "0X800BE88";
    public static final String VALUE_SETTING_RIJ_REPORT = "0X800BE87";
    public static final int VALUE_SWITCH_CLOSE = 3;
    public static final int VALUE_SWITCH_HIDE = 1;
    public static final int VALUE_SWITCH_OPEN = 2;
    public static final int VALUE_SWITCH_UNSPECIFIED = 4;
    public static String getTabSwitchLastScene;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35269);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TAB_CONFIG_ARRAY = new String[]{TAB_CONVERSATION, "GUILD", TAB_CONTACT, TAB_RIJ, TAB_LEBA};
        TAB_CONFIG_ARRAY_8970 = new String[]{TAB_CONVERSATION, "GUILD", TAB_META_DREAM, TAB_CONTACT, TAB_RIJ, TAB_LEBA};
        TAB_CONFIG_ARRAY_TEEN = new String[]{TAB_CONVERSATION, TAB_CONTACT, TAB_LEBA};
        TAB_CONFIG_ARRAY_OLD = new String[]{TAB_CONVERSATION, TAB_CONTACT, TAB_LEBA};
        TAB_ARRAY_CONSTANT = new String[]{TAB_CONVERSATION, TAB_CONTACT, TAB_LEBA};
        getTabSwitchLastScene = "";
    }

    public TabDataHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void addTabName(StringBuilder sb5, String str) {
        if (sb5.length() != 0) {
            sb5.append(" ");
        }
        sb5.append(str);
    }

    public static void cleanTabFirstShow(Context context, String str) {
        p pVar = new p(context);
        pVar.f(getTabFirstShowKeyName(str), "");
        pVar.a();
        QLog.d(TAG, 1, "cleanTabFirstShow new uin=" + StringUtil.getSimpleUinForPrint(str));
    }

    public static void clearTabLocalSwitch(Context context, String str, List<String> list) {
        if (list == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            hashMap.put(it.next(), 4);
        }
        updateTabLocalSwitch(context, str, hashMap);
    }

    public static boolean getGroundToggleGuildInit(Context context, String str) {
        boolean a16 = new m(context).a(getGroundToggleGuildInitKeyName(str), false);
        QLog.d(TAG, 1, "getGroundToggleGuildInit  uin=" + StringUtil.getSimpleUinForPrint(str) + ", show=" + a16);
        return a16;
    }

    public static String getGroundToggleGuildInitKeyName(String str) {
        return KEY_GROUND_TOGGLE_GUILD_INIT + str;
    }

    public static int getModelType() {
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return 3;
        }
        if (SimpleUIUtil.isNowElderMode()) {
            return 4;
        }
        if (QQTheme.isNowSimpleUI()) {
            return 2;
        }
        return 1;
    }

    private static int getOpenCount(Context context, String str, int i3) {
        Map<String, Integer> tabSwitch = getTabSwitch(context, str, SCENE_OPEN_COUNT);
        int i16 = 0;
        if (tabSwitch == null) {
            return 0;
        }
        String tabRuleList = getTabRuleList(context, str, i3);
        for (Map.Entry<String, Integer> entry : tabSwitch.entrySet()) {
            Integer value = entry.getValue();
            if (tabRuleList.contains(entry.getKey()) && value != null && value.intValue() == 2) {
                i16++;
            }
        }
        return i16;
    }

    public static long getRealTabInit(Context context, String str) {
        int b16 = new m(context).b(getRealTabInitKeyName(str), 0);
        QLog.i(TAG, 1, "getRealTabInit initTab=" + b16);
        return b16;
    }

    public static String getRealTabInitKeyName(String str) {
        return KEY_REAL_TAB_INIT + str;
    }

    public static long getSequence(Context context, String str) {
        return new m(context).c(getTabSequenceKeyName(str), 0L);
    }

    public static String[] getTabConfigArray() {
        return TAB_CONFIG_ARRAY_8970;
    }

    public static String getTabCurrentManualTab(String str) {
        return "KeyTabCurrentManualTab_" + str;
    }

    public static String getTabCurrentManualTag(Context context, String str) {
        String d16 = new m(context).d(getTabCurrentManualTab(str), "");
        QLog.d(TAG, 1, "getTabCurrentManualTag  uin=" + StringUtil.getSimpleUinForPrint(str) + ", tagClazz=" + d16);
        return d16;
    }

    public static String getTabDebugGuildRecover(String str) {
        return "KeyTabDebugGuildRecover_" + str;
    }

    public static boolean getTabDebugGuildStatus(Context context, String str) {
        boolean a16 = new m(context).a(getTabDebugGuildRecover(str), true);
        QLog.d(TAG, 1, "getTabDebugGuildStatus  uin=" + StringUtil.getSimpleUinForPrint(str) + ", shouldShowRecover=" + a16);
        return a16;
    }

    public static String getTabFirstNewWorldAndRIJ(String str) {
        return "KeyTabFirstNewWorldRIJ_" + str;
    }

    public static boolean getTabFirstNewWorldWithRIJOn(Context context, String str) {
        boolean a16 = new m(context).a(getTabFirstNewWorldAndRIJ(str), false);
        QLog.d(TAG, 1, "getTabFirstNewWorldWithRIJOn  uin=" + StringUtil.getSimpleUinForPrint(str) + ", shouldShowDialog=" + a16);
        return a16;
    }

    public static String getTabFirstShow(Context context, String str) {
        String d16 = new m(context).d(getTabFirstShowKeyName(str), "");
        QLog.d(TAG, 1, "getTabFirstShow uin=" + StringUtil.getSimpleUinForPrint(str) + ", firstShowTab=" + d16);
        return d16;
    }

    public static String getTabFirstShowKeyName(String str) {
        return "KeyTabFirstShow_" + str;
    }

    public static String getTabFixNewWorldAndRIJ(String str) {
        return "KeyTabFixNewWorldRIJ_" + str;
    }

    public static boolean getTabFixNewWorldWithRIJOn(Context context, String str) {
        boolean a16 = new m(context).a(getTabFixNewWorldAndRIJ(str), false);
        QLog.d(TAG, 1, "getTabNewWorld  uin=" + StringUtil.getSimpleUinForPrint(str) + ", showDialog=" + a16);
        return a16;
    }

    public static String getTabFullAdaptName(String str) {
        return "KeyTabFullAdapt_" + str;
    }

    public static int getTabId(String str) {
        if (TAB_NEW_WORLD.equals(str)) {
            return 1;
        }
        if ("GUILD".equals(str)) {
            return 2;
        }
        if (TAB_RIJ.equals(str)) {
            return 3;
        }
        if (TAB_META_DREAM.equals(str)) {
            return 4;
        }
        return 0;
    }

    public static long getTabInit(Context context, String str) {
        int b16 = new m(context).b(getTabInitKeyName(str), 0);
        QLog.i(TAG, 1, "getTabInit initTab=" + b16);
        return b16;
    }

    public static String getTabInitKeyName(String str) {
        return KEY_TAB_INIT + str;
    }

    public static String getTabJumpGuildSwitchKeyName(String str) {
        return "KeyTabJumpGuildSwitch_" + str;
    }

    public static Map<String, Boolean> getTabLocalSwitch(Context context, String str) {
        m mVar = new m(context);
        HashMap hashMap = new HashMap();
        putSingleTabLocalSwitch(mVar, str, "GUILD", hashMap);
        putSingleTabLocalSwitch(mVar, str, TAB_NEW_WORLD, hashMap);
        putSingleTabLocalSwitch(mVar, str, TAB_RIJ, hashMap);
        putSingleTabLocalSwitch(mVar, str, TAB_META_DREAM, hashMap);
        return hashMap;
    }

    public static String getTabLocalSwitchKeyName(String str, String str2) {
        return KEY_TAB_LOCAL_SWITCH + str + "_" + str2;
    }

    public static String getTabName(Integer num) {
        if (num == null) {
            return "";
        }
        if (1 == num.intValue()) {
            return TAB_NEW_WORLD;
        }
        if (2 == num.intValue()) {
            return "GUILD";
        }
        if (3 == num.intValue()) {
            return TAB_RIJ;
        }
        if (4 != num.intValue()) {
            return "";
        }
        return TAB_META_DREAM;
    }

    public static String getTabRuleKeyName(String str, int i3) {
        return KEY_TAB_RULE + i3 + "_" + str;
    }

    public static String getTabRuleList(Context context, String str, int i3) {
        return new m(context).d(getTabRuleKeyName(str, i3), "");
    }

    public static String getTabSequenceKeyName(String str) {
        return KEY_TAB_SEQUENCE + str;
    }

    public static String getTabShield(Context context, String str) {
        String d16 = new m(context).d(getTabShieldKeyName(str), "");
        QLog.d(TAG, 1, "getTabShield uin=" + StringUtil.getSimpleUinForPrint(str) + ", shieldTab=" + d16);
        return d16;
    }

    public static String getTabShieldKeyName(String str) {
        return "KeyTabShield_" + str;
    }

    public static Map<String, Integer> getTabSwitch(Context context, String str, String str2) {
        m mVar = new m(context);
        int b16 = mVar.b(getTabSwitchKeyName(str, "GUILD"), -1);
        int b17 = mVar.b(getTabSwitchKeyName(str, TAB_NEW_WORLD), -1);
        int b18 = mVar.b(getTabSwitchKeyName(str, TAB_RIJ), -1);
        int b19 = mVar.b(getTabSwitchKeyName(str, TAB_META_DREAM), -1);
        StringBuilder sb5 = new StringBuilder("getTabSwitch uin=");
        sb5.append(StringUtil.getSimpleUinForPrint(str));
        sb5.append(",scene=");
        sb5.append(str2);
        sb5.append(",guid=");
        sb5.append(b16);
        sb5.append(",newWold=");
        sb5.append(b17);
        sb5.append(",rij=");
        sb5.append(b18);
        sb5.append(",metaDream=");
        sb5.append(b19);
        if (b16 != -1 && b17 != -1 && b18 != -1) {
            int b26 = mVar.b(getTabLocalSwitchKeyName(str, "GUILD"), 4);
            int b27 = mVar.b(getTabLocalSwitchKeyName(str, TAB_NEW_WORLD), 4);
            int b28 = mVar.b(getTabLocalSwitchKeyName(str, TAB_RIJ), 4);
            int b29 = mVar.b(getTabLocalSwitchKeyName(str, TAB_META_DREAM), 4);
            sb5.append(",guid_L=");
            sb5.append(b26);
            sb5.append(",newWold_L=");
            sb5.append(b27);
            sb5.append(",rij_L=");
            sb5.append(b28);
            sb5.append(",metaDream_L=");
            sb5.append(b29);
            if (QLog.isColorLevel() && !getTabSwitchLastScene.equals(str2)) {
                QLog.i(TAG, 2, sb5.toString());
                getTabSwitchLastScene = str2;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("GUILD", Integer.valueOf(mixSwitch(b16, b26)));
            hashMap.put(TAB_NEW_WORLD, Integer.valueOf(mixSwitch(b17, b27)));
            hashMap.put(TAB_RIJ, Integer.valueOf(mixSwitch(b18, b28)));
            hashMap.put(TAB_META_DREAM, Integer.valueOf(mixSwitch(b19, b29)));
            return hashMap;
        }
        if (!QLog.isColorLevel()) {
            return null;
        }
        QLog.i(TAG, 2, sb5.toString());
        return null;
    }

    public static String getTabSwitchKeyName(String str, String str2) {
        return KEY_TAB_SWITCH + str + "_" + str2;
    }

    public static String getTabSwitchList(Context context, String str, String str2) {
        Map<String, Integer> tabSwitch = getTabSwitch(context, str, str2);
        String tabRuleList = getTabRuleList(context, str, getModelType());
        if (tabSwitch != null && tabRuleList != null) {
            StringBuilder sb5 = new StringBuilder();
            for (Map.Entry<String, Integer> entry : tabSwitch.entrySet()) {
                Integer value = entry.getValue();
                if (value != null && tabRuleList.contains(entry.getKey()) && (value.intValue() == 2 || value.intValue() == 3)) {
                    if (!isTabShield(context, str, entry.getKey())) {
                        addTabName(sb5, entry.getKey());
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[getTabSwitchList] allTabListCacheString: " + tabRuleList + "tabSwitchMap: " + tabSwitch + "tabSwitchList: " + ((Object) sb5));
            }
            return sb5.toString();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[getTabSwitchList] empty with allTabListCacheString: " + tabRuleList + "tabSwitchMap: " + tabSwitch);
            return "";
        }
        return "";
    }

    public static boolean isAutoEnable() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("8975_886335315_auto_enable", true);
    }

    public static boolean isExtendTabShow(Context context, String str, String str2) {
        List asList = Arrays.asList(transferConfigStringToArray(getTabRuleList(context, str, getModelType())));
        Map tabSwitch = getTabSwitch(context, str, "is_tab_show|" + str2);
        boolean z16 = true;
        if (tabSwitch == null) {
            tabSwitch = new HashMap();
            tabSwitch.put("GUILD", 1);
            tabSwitch.put(TAB_NEW_WORLD, 1);
            tabSwitch.put(TAB_RIJ, 1);
            tabSwitch.put(TAB_META_DREAM, 1);
        }
        if (!tabSwitch.keySet().contains(str2) || ((Integer) tabSwitch.get(str2)).intValue() != 2 || !asList.contains(str2)) {
            z16 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "isExtendTabShow uin: " + StringUtil.getSimpleUinForPrint(str) + ", businessType: " + str2 + ", result: " + z16);
        }
        return z16;
    }

    public static boolean isMetaDreamEnable() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("8970_885251635_tab_meta_dream", true);
    }

    public static boolean isOnceFetchFromServer(Context context, String str) {
        if (getSequence(context, str) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isTabFull(Context context, String str) {
        if (getOpenCount(context, str, getModelType()) + TAB_ARRAY_CONSTANT.length >= 5) {
            return true;
        }
        return false;
    }

    public static boolean isTabJumpGuildSwitchOn(Context context, String str) {
        return new m(context).a(getTabJumpGuildSwitchKeyName(str), true);
    }

    public static boolean isTabOverflow(Context context, String str) {
        if (getOpenCount(context, str, getModelType()) + TAB_ARRAY_CONSTANT.length > 5) {
            return true;
        }
        return false;
    }

    public static boolean isTabShield(Context context, String str, String str2) {
        String tabShield = getTabShield(context, str);
        if (!TextUtils.isEmpty(tabShield) && tabShield.contains(str2)) {
            return true;
        }
        return false;
    }

    public static int mixSwitch(int i3, int i16) {
        if ((i3 != 2 && i3 != 3) || (i16 != 2 && i16 != 3)) {
            return i3;
        }
        return i16;
    }

    public static void putGroundToggleGuildInit(Context context, String str, boolean z16) {
        p pVar = new p(context);
        pVar.c(getGroundToggleGuildInitKeyName(str), z16);
        pVar.a();
        QLog.d(TAG, 1, "putGroundToggleGuildInit new uin=" + StringUtil.getSimpleUinForPrint(str) + ", show=" + z16);
    }

    public static void putSingleTabLocalSwitch(m mVar, String str, String str2, Map<String, Boolean> map) {
        boolean z16;
        int b16 = mVar.b(getTabLocalSwitchKeyName(str, str2), 4);
        if (b16 == 2 || b16 == 3) {
            if (b16 == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            map.put(str2, Boolean.valueOf(z16));
        }
    }

    public static void reportTabStatus(int i3) {
        Intent intent = new Intent();
        intent.setAction("com.tencent.mobileqq.kandian.base.utils.REPORT_TAB_STATUS");
        intent.putExtra("com.tencent.mobileqq.kandian.base.utils.KEY_SCENE", i3);
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            context.sendBroadcast(intent);
        }
    }

    public static String[] transferConfigStringToArray(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "transferConfigStringToArray empty");
            int modelType = getModelType();
            if (modelType == 3) {
                return TAB_CONFIG_ARRAY_TEEN;
            }
            if (modelType == 4) {
                return TAB_CONFIG_ARRAY_OLD;
            }
            return TAB_CONFIG_ARRAY;
        }
        String[] tabConfigArray = getTabConfigArray();
        ArrayList arrayList = new ArrayList();
        for (String str2 : tabConfigArray) {
            if (!TAB_CONVERSATION.equals(str2) && !TAB_CONTACT.equals(str2) && !TAB_LEBA.equals(str2)) {
                if (str.contains(str2)) {
                    arrayList.add(str2);
                }
            } else {
                arrayList.add(str2);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static void updateRIJAndQCircleMutual(AppInterface appInterface, String str, Context context) {
        if (isExtendTabShow(context, str, TAB_RIJ) && isExtendTabShow(context, str, TAB_NEW_WORLD)) {
            String tabFirstShow = getTabFirstShow(context, str);
            if (!TextUtils.isEmpty(tabFirstShow) && tabFirstShow.contains(TAB_NEW_WORLD)) {
                QLog.d(TAG, 1, "updateRIJAndQCircleMutual firstShow");
                updateTabFirstNewWorldWithRIJOn(context, str, true);
            } else {
                QLog.d(TAG, 1, "updateRIJAndQCircleMutual fixShow");
                updateTabFixNewWorldWithRIJOn(context, str, true);
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TAB_RIJ, 3);
            updateTabLocalSwitch(BaseApplication.getContext(), appInterface.getCurrentAccountUin(), hashMap);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AppInterface.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        ((TabDataHandler) AppInterface.this.getBusinessHandler(TabDataHandler.class.getName())).K2(TabDataHelper.TAB_RIJ, false);
                    }
                }
            }, 160, null, true);
        }
    }

    public static void updateRealTabInit(Context context, String str, int i3) {
        p pVar = new p(context);
        pVar.d(getRealTabInitKeyName(str), i3);
        pVar.a();
    }

    public static void updateSequence(Context context, String str, long j3) {
        p pVar = new p(context);
        pVar.e(getTabSequenceKeyName(str), j3);
        QLog.i(TAG, 1, "updateSequence sequence=" + j3);
        pVar.a();
    }

    public static void updateTabCurrentManualTag(Context context, String str, String str2) {
        p pVar = new p(context);
        pVar.f(getTabCurrentManualTab(str), str2);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tab_mmkv_9070_123318785", true)) {
            pVar.b();
        } else {
            pVar.a();
        }
        QLog.d(TAG, 1, "updateTabManualTag new uin=" + StringUtil.getSimpleUinForPrint(str) + ", tagClazz=" + str2);
    }

    public static void updateTabDebugGuildStatus(Context context, String str, boolean z16) {
        p pVar = new p(context);
        pVar.c(getTabDebugGuildRecover(str), z16);
        pVar.a();
        QLog.d(TAG, 1, "updateTabDebugGuildStatus new uin=" + StringUtil.getSimpleUinForPrint(str) + ", shouldShowRecover=" + z16);
    }

    public static void updateTabFirstNewWorldWithRIJOn(Context context, String str, boolean z16) {
        p pVar = new p(context);
        pVar.c(getTabFirstNewWorldAndRIJ(str), z16);
        pVar.a();
        QLog.d(TAG, 1, "updateTabFirstNewWorldWithRIJOn new uin=" + StringUtil.getSimpleUinForPrint(str) + ", isShowDialog=" + z16);
    }

    public static void updateTabFixNewWorldWithRIJOn(Context context, String str, boolean z16) {
        p pVar = new p(context);
        pVar.c(getTabFixNewWorldAndRIJ(str), z16);
        pVar.a();
        QLog.d(TAG, 1, "updateTabFixNewWorldWithRIJOn new uin=" + StringUtil.getSimpleUinForPrint(str) + ", isShowDialog=" + z16);
    }

    public static void updateTabInit(Context context, String str, int i3) {
        p pVar = new p(context);
        pVar.d(getTabInitKeyName(str), i3);
        pVar.a();
    }

    public static void updateTabJumpGuildSwitch(Context context, String str, boolean z16) {
        p pVar = new p(context);
        pVar.c(getTabJumpGuildSwitchKeyName(str), z16);
        pVar.a();
    }

    public static void updateTabLocalSwitch(Context context, String str, HashMap<String, Integer> hashMap) {
        if (hashMap != null && !hashMap.isEmpty()) {
            StringBuilder sb5 = new StringBuilder("updateTabLocalSwitch uin=");
            sb5.append(StringUtil.getSimpleUinForPrint(str));
            p pVar = new p(context);
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null) {
                    sb5.append(",tabName=");
                    sb5.append(key);
                    sb5.append(",switchValue=");
                    sb5.append(value);
                    pVar.d(getTabLocalSwitchKeyName(str, key), value.intValue());
                }
            }
            QLog.i(TAG, 1, sb5.toString());
            pVar.a();
            return;
        }
        QLog.i(TAG, 1, "updateTabLocalSwitch uin=" + StringUtil.getSimpleUinForPrint(str) + ",switchMap isEmpty");
    }

    public static void updateTabRuleList(Context context, String str, List<UserDynamicTab.ModelRule> list) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb5 = new StringBuilder("updateTabRuleList uin=");
            sb5.append(StringUtil.getSimpleUinForPrint(str));
            p pVar = new p(context);
            for (UserDynamicTab.ModelRule modelRule : list) {
                int i3 = modelRule.model_type.get();
                sb5.append(",mode=");
                sb5.append(i3);
                List<UserDynamicTab.ModelTabId> list2 = modelRule.tab_id.get();
                StringBuilder sb6 = new StringBuilder();
                if (modelRule.tab_id.isEmpty()) {
                    sb5.append(",tab_id=empty");
                } else {
                    Iterator<UserDynamicTab.ModelTabId> it = list2.iterator();
                    while (it.hasNext()) {
                        String tabName = getTabName(Integer.valueOf(it.next().tab_id.get()));
                        if (!TextUtils.isEmpty(tabName)) {
                            addTabName(sb6, tabName);
                        }
                    }
                    String sb7 = sb6.toString();
                    sb5.append(",tabDataList=");
                    sb5.append(sb6.toString());
                    if (!TextUtils.isEmpty(sb7)) {
                        pVar.f(getTabRuleKeyName(str, i3), sb7);
                    }
                }
            }
            QLog.i(TAG, 1, sb5.toString());
            pVar.a();
            return;
        }
        QLog.i(TAG, 1, "updateTabRuleList uin=" + StringUtil.getSimpleUinForPrint(str) + ", modelRules isEmpty");
    }

    public static void updateTabSwitchByPush(Context context, String str, al alVar) {
        if (alVar == null) {
            QLog.i(TAG, 1, "updateTabSwitchBuPush uin=" + StringUtil.getSimpleUinForPrint(str) + ", tabDataList  == null");
            return;
        }
        StringBuilder sb5 = new StringBuilder("updateTabSwitchBuPush uin=");
        sb5.append(StringUtil.getSimpleUinForPrint(str));
        sb5.append(",id=");
        sb5.append(alVar.f182853a);
        sb5.append(",status=");
        sb5.append(alVar.f182854b);
        sb5.append(",firstShow=");
        sb5.append(alVar.f182855c);
        String tabName = getTabName(Integer.valueOf(alVar.f182853a));
        m mVar = new m(context);
        p pVar = new p(context);
        int i3 = alVar.f182854b;
        int i16 = 2;
        if (i3 != 1) {
            if (i3 == 2) {
                i16 = 3;
            } else {
                i16 = 1;
            }
        }
        pVar.d(getTabSwitchKeyName(str, tabName), i16);
        if (alVar.f182855c) {
            String d16 = mVar.d(getTabFirstShowKeyName(str), "");
            sb5.append(",oldFirstShow=");
            sb5.append(d16);
            if (d16 != null && !d16.isEmpty()) {
                if (d16.contains(tabName)) {
                    tabName = d16;
                } else {
                    tabName = d16 + " " + tabName;
                }
            }
            sb5.append(",newFirstShow=");
            sb5.append(tabName);
            pVar.f(getTabFirstShowKeyName(str), tabName);
        }
        QLog.i(TAG, 1, sb5.toString());
        pVar.a();
        reportTabStatus(3);
    }

    public static void updateTabSwitchFull(Context context, String str, List<UserDynamicTab.TabData> list) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            StringBuilder sb7 = new StringBuilder("updateTabSwitchFull uin=");
            sb7.append(StringUtil.getSimpleUinForPrint(str));
            for (UserDynamicTab.TabData tabData : list) {
                sb7.append(",id=");
                sb7.append(tabData.tab_id.get());
                sb7.append(",status=");
                sb7.append(tabData.tab_status.get());
                sb7.append(",firstShow=");
                sb7.append(tabData.first_show.get());
                sb7.append(",shieldShow=");
                sb7.append(tabData.sheild_in_setpage.get());
                if (tabData.first_show.get()) {
                    addTabName(sb5, getTabName(Integer.valueOf(tabData.tab_id.get())));
                }
                if (tabData.sheild_in_setpage.get()) {
                    addTabName(sb6, getTabName(Integer.valueOf(tabData.tab_id.get())));
                }
            }
            p pVar = new p(context);
            pVar.d(getTabSwitchKeyName(str, "GUILD"), getTabSwitch(2, list));
            pVar.d(getTabSwitchKeyName(str, TAB_NEW_WORLD), getTabSwitch(1, list));
            pVar.d(getTabSwitchKeyName(str, TAB_RIJ), getTabSwitch(3, list));
            pVar.d(getTabSwitchKeyName(str, TAB_META_DREAM), getTabSwitch(4, list));
            if (sb5.length() > 0) {
                pVar.f(getTabFirstShowKeyName(str), sb5.toString());
            }
            pVar.f(getTabShieldKeyName(str), sb6.toString());
            QLog.i(TAG, 1, sb7.toString());
            pVar.a();
            return;
        }
        QLog.i(TAG, 1, "updateTabSwitchFull uin=" + StringUtil.getSimpleUinForPrint(str) + ", tabDataList isEmpty");
    }

    public static void updateTabSwitchIncremental(Context context, String str, HashMap<String, Integer> hashMap) {
        if (hashMap != null && !hashMap.isEmpty()) {
            StringBuilder sb5 = new StringBuilder("updateTabSwitchIncremental uin=");
            sb5.append(StringUtil.getSimpleUinForPrint(str));
            p pVar = new p(context);
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null) {
                    sb5.append(",tabName=");
                    sb5.append(key);
                    sb5.append(",switchValue=");
                    sb5.append(value);
                    pVar.d(getTabSwitchKeyName(str, key), value.intValue());
                }
            }
            QLog.i(TAG, 1, sb5.toString());
            pVar.a();
            return;
        }
        QLog.i(TAG, 1, "updateTabSwitchIncremental uin=" + StringUtil.getSimpleUinForPrint(str) + ", tabSwitchMap isEmpty");
    }

    public static int getTabSwitch(int i3, List<UserDynamicTab.TabData> list) {
        Iterator<UserDynamicTab.TabData> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            UserDynamicTab.TabData next = it.next();
            if (i3 == next.tab_id.get()) {
                int i16 = next.tab_status.get();
                if (i16 == 1) {
                    return 2;
                }
                if (i16 == 2) {
                    return 3;
                }
            }
        }
        return 1;
    }
}
