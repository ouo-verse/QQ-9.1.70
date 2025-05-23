package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.EmoticonTabSortConfProcessor;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoticonUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String EMO_AI_ITEM_BANNER_IMAGE_URL = "emo_ai_item_banner_image_url";
    private static final String EMO_AI_ITEM_BANNER_PAGE_URL = "emo_ai_item_banner_page_url";
    private static final String EMO_AI_ITEM_BANNER_RED_DOT_URL = "emo_ai_item_banner_red_dot_url";
    private static final String EMO_TAB_SET_AI_ENTRY_BOTTOM = "emo_tab_set_ai_entry_bottom";
    private static final String KEY_CAMERA_EMOTICON_SWITCH = "camera_emoticon_switch";
    private static final String KEY_CMSHOW_EMOTICON_SWITCH = "cmshow_emoticon_switch";
    private static final String KEY_FIRST_CAMERA_EMOTICON_SWITCH = "first_camera_emoticon_switch";
    private static final String LOG_TAG = "EmoticonUtils";

    public EmoticonUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean aniStickerTabEnable() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101580", false);
        if (QLog.isDevelopLevel()) {
            QLog.d(LOG_TAG, 4, "aniStickerTabEnable = ", Boolean.valueOf(isSwitchOn));
        }
        return isSwitchOn;
    }

    public static void downloadNormalEmotion(QQEmoticonMainPanelApp qQEmoticonMainPanelApp, EmoticonPackage emoticonPackage, int i3) {
        if (qQEmoticonMainPanelApp != null && emoticonPackage != null) {
            EmojiManagerServiceProxy emojiManagerServiceProxy = (EmojiManagerServiceProxy) qQEmoticonMainPanelApp.getRuntimeService(IEmojiManagerService.class);
            if (emojiManagerServiceProxy.getEmoticonPackageLoadingProgress(emoticonPackage.epId) < 0.0f && com.tencent.mobileqq.core.util.a.j()) {
                if (QLog.isColorLevel()) {
                    QLog.d(LOG_TAG, 2, "downloadNormalEmotion wifi auto download emotion , epid = " + emoticonPackage.epId);
                }
                emojiManagerServiceProxy.pullEmoticonPackage(emoticonPackage, false, false, i3);
            }
        }
    }

    public static List<EmotionPanelInfo> getAllEmotionPanelData(QQEmoticonMainPanelApp qQEmoticonMainPanelApp, com.tencent.mobileqq.i iVar, int i3, boolean z16) {
        List arrayList;
        boolean z17;
        int i16;
        EmotionPanelInfo emotionPanelInfo;
        long currentTimeMillis = System.currentTimeMillis();
        List<EmotionPanelInfo> synchronizedList = Collections.synchronizedList(new ArrayList());
        List<EmoticonPackage> syncGetTabEmoticonPackages = ((EmoticonManagerServiceProxy) qQEmoticonMainPanelApp.getRuntimeService(IEmoticonManagerService.class)).syncGetTabEmoticonPackages(i3);
        com.tencent.mobileqq.config.business.m g16 = EmoticonTabSortConfProcessor.g();
        if (g16 != null && !g16.f202674f.isEmpty()) {
            arrayList = g16.f202674f;
        } else {
            arrayList = new ArrayList();
            arrayList.add("sysface");
            arrayList.add("favorite");
            arrayList.add("hotpic");
            arrayList.add("camera");
            arrayList.add("cmshow");
            arrayList.add("recommend");
        }
        synchronizedList.addAll(sortEmoticonTabs(qQEmoticonMainPanelApp, iVar, arrayList, null, i3, z16));
        if (syncGetTabEmoticonPackages != null) {
            boolean z18 = false;
            for (EmoticonPackage emoticonPackage : syncGetTabEmoticonPackages) {
                if (emoticonPackage.type != 1 && 3 != (i16 = emoticonPackage.jobType) && 1 != i16 && 5 != i16) {
                    if (i16 == 4) {
                        emotionPanelInfo = new EmotionPanelInfo(10, 7, emoticonPackage);
                    } else if (i16 == 0 && !z16) {
                        emotionPanelInfo = new EmotionPanelInfo(6, 4, emoticonPackage);
                    } else {
                        emotionPanelInfo = null;
                    }
                    if (emotionPanelInfo != null) {
                        synchronizedList.add(emotionPanelInfo);
                    }
                } else {
                    int i17 = emoticonPackage.jobType;
                    if ((3 == i17 || 5 == i17) && !z18 && !isMagicEmotionTakeDown(qQEmoticonMainPanelApp.getAppRuntime())) {
                        synchronizedList.add(new EmotionPanelInfo(9, 4, emoticonPackage));
                        z18 = true;
                    }
                }
                String str = emoticonPackage.epId;
                if (emoticonPackage.status == 2) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                EmoticonTabAdapter.generateTabUrl(str, z17);
            }
        }
        if (isEmoAIEntrySetBottom() && arrayList.contains("ai_emoticon")) {
            int size = synchronizedList.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                EmotionPanelInfo emotionPanelInfo2 = synchronizedList.get(size);
                if (emotionPanelInfo2.type == 20) {
                    synchronizedList.remove(size);
                    synchronizedList.add(emotionPanelInfo2);
                    break;
                }
                size--;
            }
        }
        QLog.i(LOG_TAG, 1, "prepare data cost time:" + (System.currentTimeMillis() - currentTimeMillis) + ", data=" + synchronizedList.size());
        return synchronizedList;
    }

    public static boolean getCameraEmoticonSwitch(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            return ((Boolean) com.tencent.mobileqq.utils.p.b(context, str, KEY_CAMERA_EMOTICON_SWITCH, Boolean.TRUE)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i(LOG_TAG, 2, "getCameraEmoticonSwitch err, return true");
            return true;
        }
        return true;
    }

    public static boolean getCmshowEmoticonSwitch(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            return ((Boolean) com.tencent.mobileqq.utils.p.b(context, str, KEY_CMSHOW_EMOTICON_SWITCH, Boolean.TRUE)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i(LOG_TAG, 1, "getCmshowEmoticonSwitch err, return true");
        }
        return true;
    }

    public static String getEmoAIItemBannerImageUrl() {
        return QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getString(EMO_AI_ITEM_BANNER_IMAGE_URL, "");
    }

    public static String getEmoAIItemBannerPageUrl() {
        return QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getString(EMO_AI_ITEM_BANNER_PAGE_URL, "");
    }

    public static String getEmoAIItemBannerRedDotUrl() {
        return QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getString(EMO_AI_ITEM_BANNER_RED_DOT_URL, "");
    }

    public static boolean getFirstCameraEmoticonSwitch(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (((Integer) com.tencent.mobileqq.utils.p.b(context, str, KEY_FIRST_CAMERA_EMOTICON_SWITCH, 0)).intValue() != 0) {
                return false;
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i(LOG_TAG, 2, "getFirstCameraEmoticonSwitch err, return true");
        }
        return false;
    }

    public static List<EmotionPanelInfo> getNonBigEmotionPanelData(QQEmoticonMainPanelApp qQEmoticonMainPanelApp, com.tencent.mobileqq.i iVar) {
        ArrayList arrayList = new ArrayList();
        com.tencent.mobileqq.config.business.m g16 = EmoticonTabSortConfProcessor.g();
        if (g16 != null && !g16.f202674f.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("sysface");
            arrayList2.add("ani_sticker");
            arrayList2.add("favorite");
            arrayList2.add("hotpic");
            arrayList2.add("camera");
            arrayList.addAll(sortEmoticonTabs(qQEmoticonMainPanelApp, iVar, g16.f202674f, arrayList2, 0, false));
        } else {
            arrayList.add(new EmotionPanelInfo(7, EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI, null));
            if (qQEmoticonMainPanelApp.getQQAppInterface() != null) {
                arrayList.add(new EmotionPanelInfo(4, 4, null));
                arrayList.add(new EmotionPanelInfo(12, 4, null));
                arrayList.add(new EmotionPanelInfo(11, 4, null));
            }
        }
        return arrayList;
    }

    public static String getSystemAndEmojiEmoticonName(EmoticonInfo emoticonInfo) {
        String str;
        if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
            SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emoticonInfo;
            int i3 = systemAndEmojiEmoticonInfo.emotionType;
            if (i3 == 1) {
                str = QQSysFaceUtil.getFaceDescription(systemAndEmojiEmoticonInfo.code);
            } else if (i3 == 2) {
                str = QQEmojiUtil.getEmojiDescription(systemAndEmojiEmoticonInfo.code);
            } else {
                str = null;
            }
            if (str != null && str.length() > 1 && str.startsWith("/")) {
                return str.substring(1);
            }
            return str;
        }
        return "";
    }

    public static boolean isEmoAIEntrySetBottom() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(EMO_TAB_SET_AI_ENTRY_BOTTOM, false);
    }

    public static boolean isMagicEmotionTakeDown(AppRuntime appRuntime) {
        return ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("rich_magic_emoji_take_down");
    }

    public static boolean isShowEmoTitleInPreview(Object obj, EmoticonInfo emoticonInfo, boolean z16) {
        if (emoticonInfo == null) {
            return false;
        }
        if ((obj == null && !z16) || emoticonInfo.type != 7) {
            return false;
        }
        return true;
    }

    public static void report(String str, int i3) {
        report(str, str, i3);
    }

    public static void setCameraEmoticonSwitch(Context context, String str, boolean z16) {
        if (context != null && !TextUtils.isEmpty(str)) {
            com.tencent.mobileqq.utils.p.g(context, str, true, KEY_CAMERA_EMOTICON_SWITCH, Boolean.valueOf(z16));
        } else {
            QLog.d(LOG_TAG, 1, "setCameraEmoticonSwitch err!");
        }
    }

    public static void setCmshowEmoticonSwitch(Context context, String str, boolean z16) {
        if (context != null && !TextUtils.isEmpty(str)) {
            com.tencent.mobileqq.utils.p.g(context, str, true, KEY_CMSHOW_EMOTICON_SWITCH, Boolean.valueOf(z16));
        } else {
            QLog.d(LOG_TAG, 1, "setCmshowEmoticonSwitch err!");
        }
    }

    public static void setEmoAIEntryBottom(boolean z16) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(EMO_TAB_SET_AI_ENTRY_BOTTOM, z16);
    }

    public static void setEmoAIItemBannerImageUrl(String str) {
        QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").putString(EMO_AI_ITEM_BANNER_IMAGE_URL, str);
    }

    public static void setEmoAIItemBannerPageUrl(String str) {
        QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").putString(EMO_AI_ITEM_BANNER_PAGE_URL, str);
    }

    public static void setEmoAIItemBannerRedDotUrl(String str) {
        QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").putString(EMO_AI_ITEM_BANNER_RED_DOT_URL, str);
    }

    public static void setFirstCameraEmoticonSwitchClose(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Integer num = (Integer) com.tencent.mobileqq.utils.p.b(context, str, KEY_FIRST_CAMERA_EMOTICON_SWITCH, 0);
            if (num.intValue() == 0) {
                com.tencent.mobileqq.utils.p.g(context, str, true, KEY_FIRST_CAMERA_EMOTICON_SWITCH, Integer.valueOf(num.intValue() + 1));
                return;
            }
            return;
        }
        QLog.d(LOG_TAG, 1, "setFirstCameraEmoticonSwitch err!");
    }

    public static List<EmotionPanelInfo> sortEmoticonTabs(QQEmoticonMainPanelApp qQEmoticonMainPanelApp, com.tencent.mobileqq.i iVar, List<String> list, List<String> list2, int i3, boolean z16) {
        boolean z17;
        EmotionInjectionInfo c16;
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        ArrayList<Integer> extAniStickerOrderList = QQSysFaceUtil.getExtAniStickerOrderList();
        if (extAniStickerOrderList != null && extAniStickerOrderList.size() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        for (String str : list) {
            if (list2 == null || list2.contains(str)) {
                if ("sysface".equals(str)) {
                    arrayList.add(new EmotionPanelInfo(7, EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI, null));
                } else if ("ani_sticker".equals(str) && com.tencent.mobileqq.emoticon.u.f204891a.a(z17)) {
                    arrayList.add(new EmotionPanelInfo(19, 5, null));
                } else if ("favorite".equals(str)) {
                    if (i3 == 0 && qQEmoticonMainPanelApp.getQQAppInterface() != null) {
                        arrayList.add(new EmotionPanelInfo(4, 4, null));
                    }
                } else if ("hotpic".equals(str)) {
                    if (i3 == 0 && qQEmoticonMainPanelApp.getQQAppInterface() != null) {
                        arrayList.add(new EmotionPanelInfo(12, 4, null));
                    }
                } else if ("camera".equals(str)) {
                    CameraEmoRoamingManagerServiceProxy cameraEmoRoamingManagerServiceProxy = (CameraEmoRoamingManagerServiceProxy) qQEmoticonMainPanelApp.getRuntimeService(ICameraEmoRoamingManagerService.class);
                    if (getCameraEmoticonSwitch(qQEmoticonMainPanelApp.getApp(), qQEmoticonMainPanelApp.getCurrentAccountUin()) && cameraEmoRoamingManagerServiceProxy != null && cameraEmoRoamingManagerServiceProxy.isShowCameraEmoInApp() && qQEmoticonMainPanelApp.getQQAppInterface() != null && !com.tencent.mobileqq.config.business.h.INSTANCE.f(qQEmoticonMainPanelApp.getQQAppInterface())) {
                        arrayList.add(new EmotionPanelInfo(11, 4, null));
                    }
                } else if ("recommend".equals(str)) {
                    List<PromotionEmoticonPkg> proEmoticonPkgs = ((EmoticonManagerServiceProxy) qQEmoticonMainPanelApp.getRuntimeService(IEmoticonManagerService.class)).getProEmoticonPkgs(false, i3, z16);
                    if (proEmoticonPkgs != null && proEmoticonPkgs.size() > 0) {
                        arrayList.add(new EmotionPanelInfo(8, 3, null));
                    }
                } else if ("ai_emoticon".equals(str)) {
                    arrayList.add(new EmotionPanelInfo(20, 5, null));
                } else if (!"cmshow".equals(str) || getCmshowEmoticonSwitch(qQEmoticonMainPanelApp.getApp(), qQEmoticonMainPanelApp.getCurrentAccountUin())) {
                    if (iVar != null && (c16 = iVar.c(str)) != null) {
                        arrayList.add(new EmotionPanelInfo(c16.emotionType, c16.columnNum, null));
                    }
                }
            }
        }
        return arrayList;
    }

    public static void report(String str, String str2, int i3) {
        ReportController.o(null, "dc00898", "", "", str, str2, i3, 0, "", "0", "0", "");
    }
}
