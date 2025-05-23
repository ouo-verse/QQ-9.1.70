package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CommonTabEmojiInfo;
import com.tencent.shadow.dynamic.host.Constant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017J\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010!\u001a\u00020\u001fJ\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010#\u001a\u00020\u001fR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\r\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/EmoticonTabNtUtils;", "", "()V", "DEFAULT_OFFICIAL_EMOJI_TAB_ID_ARRAY", "", "", "[Ljava/lang/Integer;", "EXP_MERGE_HOT_PIC_INTO_SEARCH", "", "EXP_QQ_EMOJI_TAB_ORDER_V1", "EXP_QQ_EMOJI_TAB_ORDER_V1_A", "EXP_QQ_EMOJI_TAB_ORDER_V1_B", "MARKET_FACE_TAB_TYPE_ARRAY", "TAG", "convertCommonEmojiInfoToEmoticonPackage", "Lcom/tencent/mobileqq/data/EmoticonPackage;", "commonTabEmojiInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonTabEmojiInfo;", "convertEmoticonPackageCommonEmojiInfo", "ep", "convertEmoticonPanelTypeToNTOfficialTabType", "emoticonPanelType", "getAllEmotionPanelData", "", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelInfo;", "panelController", "Lcom/tencent/mobileqq/emoticonview/EmoticonPanelController;", "getDefaultNTOfficialTabEmojiInfoList", "getDefaultOfficialEmojiTabName", "officialTabId", "isMarketFace", "", "isMarketMaicFace", "isMergeHotPicExperiment", "isOfficialFixTab", "isReverseOrderOfRedHeartAndSuperEmoji", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class EmoticonTabNtUtils {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final Integer[] DEFAULT_OFFICIAL_EMOJI_TAB_ID_ARRAY;

    @NotNull
    private static final String EXP_MERGE_HOT_PIC_INTO_SEARCH = "exp_qqemoji_gif_search_tab_merge_v2";

    @NotNull
    private static final String EXP_QQ_EMOJI_TAB_ORDER_V1 = "exp_qqemoji_emojitab_v1";

    @NotNull
    private static final String EXP_QQ_EMOJI_TAB_ORDER_V1_A = "exp_qqemoji_emojitab_v1_A";

    @NotNull
    private static final String EXP_QQ_EMOJI_TAB_ORDER_V1_B = "exp_qqemoji_emojitab_v1_B";

    @NotNull
    public static final EmoticonTabNtUtils INSTANCE;

    @NotNull
    private static final Integer[] MARKET_FACE_TAB_TYPE_ARRAY;

    @NotNull
    private static final String TAG = "EmoticonTabNtUtils";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19553);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        INSTANCE = new EmoticonTabNtUtils();
        MARKET_FACE_TAB_TYPE_ARRAY = new Integer[]{1, 2, 3, 4, 5};
        DEFAULT_OFFICIAL_EMOJI_TAB_ID_ARRAY = new Integer[]{1, 2, 3, 4, 5, 6, 7};
    }

    EmoticonTabNtUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final EmoticonPackage convertCommonEmojiInfoToEmoticonPackage(@NotNull CommonTabEmojiInfo commonTabEmojiInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (EmoticonPackage) iPatchRedirector.redirect((short) 10, (Object) this, (Object) commonTabEmojiInfo);
        }
        Intrinsics.checkNotNullParameter(commonTabEmojiInfo, "commonTabEmojiInfo");
        EmoticonPackage emoticonPackage = new EmoticonPackage();
        emoticonPackage.epId = String.valueOf(commonTabEmojiInfo.epId);
        emoticonPackage.expiretime = commonTabEmojiInfo.expireTime;
        int i3 = 0;
        if (commonTabEmojiInfo.flags == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        emoticonPackage.valid = z16;
        emoticonPackage.wordingId = commonTabEmojiInfo.wordingId;
        emoticonPackage.name = commonTabEmojiInfo.tabName;
        int i16 = commonTabEmojiInfo.bottomEmojitabType;
        if (i16 != 1) {
            if (i16 != 4) {
                if (i16 == 5) {
                    i3 = 4;
                }
            } else {
                i3 = 5;
            }
        } else {
            i3 = 3;
        }
        emoticonPackage.jobType = i3;
        emoticonPackage.aio = true;
        return emoticonPackage;
    }

    @NotNull
    public final CommonTabEmojiInfo convertEmoticonPackageCommonEmojiInfo(@NotNull EmoticonPackage ep5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (CommonTabEmojiInfo) iPatchRedirector.redirect((short) 11, (Object) this, (Object) ep5);
        }
        Intrinsics.checkNotNullParameter(ep5, "ep");
        CommonTabEmojiInfo commonTabEmojiInfo = new CommonTabEmojiInfo();
        int i3 = 1;
        try {
            String str = ep5.epId;
            Intrinsics.checkNotNullExpressionValue(str, "ep.epId");
            commonTabEmojiInfo.epId = Integer.parseInt(str);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "convertEmoticonPackageCommonEmojiInfo error.", th5);
        }
        commonTabEmojiInfo.expireTime = (int) ep5.expiretime;
        commonTabEmojiInfo.flags = ep5.valid ? 1 : 0;
        commonTabEmojiInfo.wordingId = (int) ep5.wordingId;
        commonTabEmojiInfo.tabName = ep5.name;
        int i16 = ep5.jobType;
        if (i16 != 3) {
            i3 = 5;
            if (i16 != 4) {
                if (i16 != 5) {
                    i3 = 3;
                } else {
                    i3 = 4;
                }
            }
        }
        commonTabEmojiInfo.bottomEmojitabType = i3;
        return commonTabEmojiInfo;
    }

    public final int convertEmoticonPanelTypeToNTOfficialTabType(int emoticonPanelType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, emoticonPanelType)).intValue();
        }
        if (emoticonPanelType == 4) {
            return 4;
        }
        if (emoticonPanelType != 7) {
            if (emoticonPanelType != 12) {
                switch (emoticonPanelType) {
                    case 17:
                        return 7;
                    case 18:
                        return 1;
                    case 19:
                        return 3;
                    case 20:
                        return 6;
                    default:
                        return -1;
                }
            }
            return 5;
        }
        return 2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:41:0x00b4. Please report as an issue. */
    @NotNull
    public final List<EmotionPanelInfo> getAllEmotionPanelData(@NotNull EmoticonPanelController panelController) {
        AppRuntime appRuntime;
        boolean z16;
        int i3;
        boolean z17;
        EmotionPanelInfo emotionPanelInfo;
        boolean z18;
        EmotionInjectionInfo emotionInjectionInfo;
        boolean z19;
        boolean z26;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 5;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) panelController);
        }
        Intrinsics.checkNotNullParameter(panelController, "panelController");
        List<EmotionPanelInfo> emotionPanelInfoList = Collections.synchronizedList(new ArrayList());
        QQEmoticonMainPanelApp qQEmoticonMainPanelApp = panelController.app;
        if (qQEmoticonMainPanelApp != null) {
            appRuntime = qQEmoticonMainPanelApp.getAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            Intrinsics.checkNotNullExpressionValue(emotionPanelInfoList, "emotionPanelInfoList");
            return emotionPanelInfoList;
        }
        IRuntimeService runtimeService = appRuntime.getRuntimeService(IEmoticonManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ssConstant.MAIN\n        )");
        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) runtimeService;
        List<CommonTabEmojiInfo> ntCommonTabEmojiInfoList = iEmoticonManagerService.getNtCommonTabEmojiInfoList();
        if (ntCommonTabEmojiInfoList != null && !ntCommonTabEmojiInfoList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w(TAG, 1, "[getAllEmotionPanelData] return, ");
            Intrinsics.checkNotNullExpressionValue(emotionPanelInfoList, "emotionPanelInfoList");
            return emotionPanelInfoList;
        }
        QLog.d(TAG, 1, "[getAllEmotionPanelData] size=" + iEmoticonManagerService.getNtCommonTabEmojiInfoList().size());
        for (CommonTabEmojiInfo commonTabEmojiInfo : iEmoticonManagerService.getNtCommonTabEmojiInfoList()) {
            if (!commonTabEmojiInfo.isHide) {
                int i17 = commonTabEmojiInfo.bottomEmojitabType;
                if (i17 != 2 && i17 != 3 && i17 != i16) {
                    if (i17 == 6) {
                        switch (commonTabEmojiInfo.epId) {
                            case 2:
                                i3 = i16;
                                z17 = true;
                                emotionPanelInfoList.add(new EmotionPanelInfo(7, EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI, null));
                                break;
                            case 3:
                                z17 = true;
                                ArrayList<Integer> extAniStickerOrderList = QQSysFaceUtil.getExtAniStickerOrderList();
                                if (extAniStickerOrderList != null && extAniStickerOrderList.size() > 0) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                if (com.tencent.mobileqq.emoticon.u.f204891a.a(z19)) {
                                    i3 = 5;
                                    emotionPanelInfoList.add(new EmotionPanelInfo(19, 5, null));
                                    break;
                                }
                                i3 = 5;
                                break;
                            case 4:
                                z26 = true;
                                if (panelController.getBusinessType() == 0 && qQEmoticonMainPanelApp.getQQAppInterface() != null) {
                                    emotionPanelInfoList.add(new EmotionPanelInfo(4, 4, null));
                                }
                                i16 = 5;
                                break;
                            case 5:
                                boolean isMergeHotPicExperiment = isMergeHotPicExperiment();
                                z26 = true;
                                QLog.i(TAG, 1, "getDefaultPageData  isExperiment:" + isMergeHotPicExperiment);
                                if (panelController.getBusinessType() == 0 && qQEmoticonMainPanelApp.getQQAppInterface() != null && !isMergeHotPicExperiment) {
                                    emotionPanelInfoList.add(new EmotionPanelInfo(12, 4, null));
                                }
                                i16 = 5;
                                break;
                            case 6:
                                emotionPanelInfoList.add(new EmotionPanelInfo(20, 5, null));
                                i16 = 5;
                                break;
                            case 7:
                                if (((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(Constant.FROM_ID_START_ACTIVITY, appRuntime.getLongAccountUin())) {
                                    com.tencent.mobileqq.i emotionPanelManager = panelController.getEmotionPanelManager();
                                    if (emotionPanelManager != null) {
                                        emotionInjectionInfo = emotionPanelManager.c("zplan");
                                    } else {
                                        emotionInjectionInfo = null;
                                    }
                                    if (emotionInjectionInfo != null) {
                                        emotionPanelInfoList.add(new EmotionPanelInfo(emotionInjectionInfo.emotionType, emotionInjectionInfo.columnNum, null));
                                        z17 = true;
                                        i3 = 5;
                                        break;
                                    }
                                }
                                i16 = 5;
                                break;
                        }
                    }
                    i3 = i16;
                    z17 = true;
                } else {
                    i3 = i16;
                    z17 = true;
                    EmoticonPackage syncFindEmoticonPackageById = iEmoticonManagerService.syncFindEmoticonPackageById(String.valueOf(commonTabEmojiInfo.epId), -1);
                    if (syncFindEmoticonPackageById != null) {
                        if (syncFindEmoticonPackageById.jobType == 4) {
                            emotionPanelInfo = new EmotionPanelInfo(10, 7, syncFindEmoticonPackageById);
                        } else {
                            emotionPanelInfo = new EmotionPanelInfo(6, 4, syncFindEmoticonPackageById);
                        }
                        emotionPanelInfoList.add(emotionPanelInfo);
                        String str = syncFindEmoticonPackageById.epId;
                        if (syncFindEmoticonPackageById.status == 2) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        EmoticonTabAdapter.generateTabUrl(str, z18);
                    }
                }
                i16 = i3;
            }
        }
        Intrinsics.checkNotNullExpressionValue(emotionPanelInfoList, "emotionPanelInfoList");
        return emotionPanelInfoList;
    }

    @NotNull
    public final List<CommonTabEmojiInfo> getDefaultNTOfficialTabEmojiInfoList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : DEFAULT_OFFICIAL_EMOJI_TAB_ID_ARRAY) {
            int intValue = num.intValue();
            CommonTabEmojiInfo commonTabEmojiInfo = new CommonTabEmojiInfo();
            commonTabEmojiInfo.bottomEmojitabType = 6;
            commonTabEmojiInfo.epId = intValue;
            commonTabEmojiInfo.tabName = INSTANCE.getDefaultOfficialEmojiTabName(intValue);
            arrayList.add(commonTabEmojiInfo);
        }
        return arrayList;
    }

    @NotNull
    public final String getDefaultOfficialEmojiTabName(int officialTabId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, officialTabId);
        }
        switch (officialTabId) {
            case 1:
                String qqStr = HardCodeUtil.qqStr(R.string.f170218yq3);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.aio_emoticon_hotpic_search)");
                return qqStr;
            case 2:
                String qqStr2 = HardCodeUtil.qqStr(R.string.f230276yp);
                Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(com.tencent.mobile\u2026panel_small_face_emotion)");
                return qqStr2;
            case 3:
                String qqStr3 = HardCodeUtil.qqStr(R.string.ypw);
                Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.aio_emoticon_anisticker)");
                return qqStr3;
            case 4:
                String qqStr4 = HardCodeUtil.qqStr(R.string.m7j);
                Intrinsics.checkNotNullExpressionValue(qqStr4, "qqStr(R.string.qqstr_emoticon_8380f4e3)");
                return qqStr4;
            case 5:
                String qqStr5 = HardCodeUtil.qqStr(R.string.f170216yq1);
                Intrinsics.checkNotNullExpressionValue(qqStr5, "qqStr(R.string.aio_emoticon_hotpic_gif)");
                return qqStr5;
            case 6:
                String qqStr6 = HardCodeUtil.qqStr(R.string.yqe);
                Intrinsics.checkNotNullExpressionValue(qqStr6, "qqStr(R.string.aio_emoticon_lab)");
                return qqStr6;
            case 7:
                String qqStr7 = HardCodeUtil.qqStr(R.string.f242987w2);
                Intrinsics.checkNotNullExpressionValue(qqStr7, "qqStr(com.tencent.mobile\u2026ring.zplan_emoticon_name)");
                return qqStr7;
            default:
                return "unknown";
        }
    }

    public final boolean isMarketFace(@NotNull CommonTabEmojiInfo commonTabEmojiInfo) {
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) commonTabEmojiInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(commonTabEmojiInfo, "commonTabEmojiInfo");
        contains = ArraysKt___ArraysKt.contains(MARKET_FACE_TAB_TYPE_ARRAY, Integer.valueOf(commonTabEmojiInfo.bottomEmojitabType));
        return contains;
    }

    public final boolean isMarketMaicFace(@NotNull CommonTabEmojiInfo commonTabEmojiInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) commonTabEmojiInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(commonTabEmojiInfo, "commonTabEmojiInfo");
        int i3 = commonTabEmojiInfo.bottomEmojitabType;
        if (i3 == 1 || i3 == 4) {
            return true;
        }
        return false;
    }

    public final boolean isMergeHotPicExperiment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("emoticon_merge_hot_pic_into_search_121045051", true);
        QLog.i(TAG, 1, "emoticon_merge_hot_pic_into_search_121045051:" + isSwitchOn);
        if (!isSwitchOn) {
            return false;
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(EXP_MERGE_HOT_PIC_INTO_SEARCH);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEnti\u2026ERGE_HOT_PIC_INTO_SEARCH)");
        boolean isExperiment = expEntity.isExperiment();
        QLog.i(TAG, 1, "EXP_MERGE_HOT_PIC_INTO_SEARCH  isExperiment:" + isExperiment);
        return isExperiment;
    }

    public final boolean isOfficialFixTab(@NotNull CommonTabEmojiInfo commonTabEmojiInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) commonTabEmojiInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(commonTabEmojiInfo, "commonTabEmojiInfo");
        if (commonTabEmojiInfo.bottomEmojitabType != 6) {
            return false;
        }
        int i3 = commonTabEmojiInfo.epId;
        if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
            return false;
        }
        return true;
    }

    public final boolean isReverseOrderOfRedHeartAndSuperEmoji() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(EXP_QQ_EMOJI_TAB_ORDER_V1);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance()\n          \u2026XP_QQ_EMOJI_TAB_ORDER_V1)");
        boolean isExperiment = expEntity.isExperiment(EXP_QQ_EMOJI_TAB_ORDER_V1_B);
        expEntity.reportExpExposure();
        QLog.d(TAG, 1, "expId: exp_qqemoji_emojitab_v1_B, expStatus: " + isExperiment);
        return isExperiment;
    }
}
