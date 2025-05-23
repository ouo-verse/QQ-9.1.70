package com.tencent.mobileqq.troop.troopcard.api.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfoExt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qqnt.troopmemberlist.g;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopGameCardUtilsApiImpl implements ITroopGameCardUtilsApi {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "TroopGameCardUtil";

    public TroopGameCardUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void checkFlagEx3Grocery(String str, String str2, final ITroopGameCardUtilsApi.a aVar, final String str3) {
        if (aVar == null) {
            return;
        }
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfoWithExtInfo(str, str2, false, null, str3, new g() { // from class: com.tencent.mobileqq.troop.troopcard.api.impl.a
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                TroopGameCardUtilsApiImpl.this.lambda$checkFlagEx3Grocery$1(str3, aVar, troopMemberInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkFlagEx3Grocery$1(String str, ITroopGameCardUtilsApi.a aVar, TroopMemberInfo troopMemberInfo) {
        TroopMemberInfoExt troopMemberInfoExt;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("checkFlagEx3Grocery from=");
            sb5.append(str);
            sb5.append(", member=");
            sb5.append(troopMemberInfo);
            sb5.append(", ext=");
            if (troopMemberInfo != null) {
                troopMemberInfoExt = troopMemberInfo.extInfo;
            } else {
                troopMemberInfoExt = null;
            }
            sb5.append(troopMemberInfoExt);
            QLog.d(TAG, 2, sb5.toString());
        }
        boolean[] checkShowMsgGameGradeLevel = checkShowMsgGameGradeLevel(troopMemberInfo);
        aVar.a(checkShowMsgGameGradeLevel[0], checkShowMsgGameGradeLevel[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkShowMsgGameGradeLevel$0(ITroopGameCardUtilsApi.a aVar, TroopMemberInfo troopMemberInfo) {
        TroopMemberInfoExt troopMemberInfoExt;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("checkFlagEx3Grocery from= checkShowMsgGameGradeLevel, member=");
            sb5.append(troopMemberInfo);
            sb5.append(", ext=");
            if (troopMemberInfo != null) {
                troopMemberInfoExt = troopMemberInfo.extInfo;
            } else {
                troopMemberInfoExt = null;
            }
            sb5.append(troopMemberInfoExt);
            QLog.d(TAG, 2, sb5.toString());
        }
        boolean[] checkShowMsgGameGradeLevel = checkShowMsgGameGradeLevel(troopMemberInfo);
        aVar.a(checkShowMsgGameGradeLevel[0], checkShowMsgGameGradeLevel[1]);
    }

    private boolean preconditionOfShowGameLevel(AppRuntime appRuntime, String str, String str2) {
        if (appRuntime != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (SimpleUIUtil.getSimpleUISwitch()) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "preconditionOfShowGameLevel SimpleUI");
                }
                return false;
            }
            if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "preconditionOfShowGameLevel StudyMode");
                }
                return false;
            }
            ITroopInfoService iTroopInfoService = (ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "");
            if (iTroopInfoService == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "preconditionOfShowGameLevel manager is null");
                }
                return false;
            }
            TroopInfo findTroopInfo = iTroopInfoService.findTroopInfo(str);
            if (findTroopInfo == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "preconditionOfShowGameLevel: troopinfo null");
                }
                return false;
            }
            if (findTroopInfo.isTroopGameCardEnabled() && !findTroopInfo.isHomeworkTroop()) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "preconditionOfShowGameLevel: gameCardEnable=" + findTroopInfo.isTroopGameCardEnabled() + ", isHwTroop=" + findTroopInfo.isHomeworkTroop());
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "preconditionOfShowGameLevel | args is null");
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi
    public void ansyCheckShowMsgGameGradeLevel(String str, String str2, ITroopGameCardUtilsApi.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, str2, aVar);
            return;
        }
        if (aVar == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && preconditionOfShowGameLevel(peekAppRuntime, str, str2)) {
            checkFlagEx3Grocery(str, str2, aVar, "ansyCheckShowMsgGameGradeLevel");
        } else {
            aVar.a(false, false);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi
    public boolean[] checkShowMsgGameGradeLevel(String str, String str2, final ITroopGameCardUtilsApi.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (boolean[]) iPatchRedirector.redirect((short) 18, this, str, str2, aVar);
        }
        if (!preconditionOfShowGameLevel(MobileQQ.sMobileQQ.peekAppRuntime(), str, str2)) {
            return new boolean[]{false, false};
        }
        TroopMemberInfo troopMemberWithExtFromCacheOrFetchAsync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberWithExtFromCacheOrFetchAsync(str, str2, null, "checkShowMsgGameGradeLevel", new g() { // from class: com.tencent.mobileqq.troop.troopcard.api.impl.b
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                TroopGameCardUtilsApiImpl.this.lambda$checkShowMsgGameGradeLevel$0(aVar, troopMemberInfo);
            }
        });
        if (troopMemberWithExtFromCacheOrFetchAsync != null) {
            return checkShowMsgGameGradeLevel(troopMemberWithExtFromCacheOrFetchAsync);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi
    @Nullable
    public String getGameGradeIconPathById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        String troopGameCardResDownloadPath = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getTroopGameCardResDownloadPath();
        String str = null;
        if (TextUtils.isEmpty(troopGameCardResDownloadPath)) {
            return null;
        }
        String str2 = troopGameCardResDownloadPath + ITroopGameCardUtilsApi.GAME_GRADE_ICON_FILE_NAME_PREFIX;
        switch (i3 / 100000) {
            case 2:
                str = str2 + "1";
                break;
            case 3:
                str = str2 + "2";
                break;
            case 4:
                str = str2 + "3";
                break;
            case 5:
                str = str2 + "4";
                break;
            case 6:
                str = str2 + "5";
                break;
            case 7:
                str = str2 + "6";
                break;
            case 8:
                if ((i3 % 100000) / 10000 >= 6) {
                    str = str2 + "8";
                    break;
                } else {
                    str = str2 + "7";
                    break;
                }
        }
        if (!TextUtils.isEmpty(str)) {
            return str + ".png";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi
    @Nullable
    public String getGameGradeNumberIconPathById(int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        int i16 = i3 / 100000;
        String troopGameCardResDownloadPath = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getTroopGameCardResDownloadPath();
        if (TextUtils.isEmpty(troopGameCardResDownloadPath)) {
            return null;
        }
        String str2 = troopGameCardResDownloadPath + ITroopGameCardUtilsApi.GAME_GRADE_NUMBER_ICON_FILE_NAME_PREFIX;
        switch (i16) {
            case 2:
                str = str2 + "1_";
                break;
            case 3:
                str = str2 + "2_";
                break;
            case 4:
                str = str2 + "3_";
                break;
            case 5:
                str = str2 + "4_";
                break;
            case 6:
                str = str2 + "5_";
                break;
            case 7:
                str = str2 + "6_";
                break;
            default:
                str = null;
                break;
        }
        if (!TextUtils.isEmpty(str)) {
            switch ((i3 % 100000) / 10000) {
                case 5:
                    return str + "5.png";
                case 6:
                    return str + "4.png";
                case 7:
                    return str + "3.png";
                case 8:
                    return str + "2.png";
                case 9:
                    return str + "1.png";
                default:
                    return null;
            }
        }
        return str;
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi
    @Nullable
    public String getGameGradeStarImagePathById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        int i16 = i3 / 100000;
        String troopGameCardResDownloadPath = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getTroopGameCardResDownloadPath();
        if (TextUtils.isEmpty(troopGameCardResDownloadPath)) {
            return null;
        }
        String str = troopGameCardResDownloadPath + ITroopGameCardUtilsApi.GAME_GRADE_START_IMAGE_FILE_NAME_PREFIX;
        switch (i16) {
            case 2:
            case 3:
                str = str + "_3_";
                break;
            case 4:
            case 5:
                str = str + "_4_";
                break;
            case 6:
            case 7:
                str = str + "_5_";
                break;
            case 8:
                break;
            default:
                str = null;
                break;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i16 != 8) {
            str = str + String.valueOf(i3 % 10000);
        }
        return str + ".png";
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi
    @Nullable
    public String getGameSkilledLevelIconPath(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
        String str = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getTroopGameCardResDownloadPath() + ITroopGameCardUtilsApi.GAME_SKILLED_LEVEL_ICON_FILE_NAME_PREFIX;
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            str2 = str + "5";
                        }
                    } else {
                        str2 = str + "4";
                    }
                } else {
                    str2 = str + "3";
                }
            } else {
                str2 = str + "2";
            }
        } else {
            str2 = str + "1";
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2 + ".png";
        }
        return str2;
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi
    @Nullable
    public String getGradeDescById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        String majorGradeTagById = getMajorGradeTagById(i3);
        if (!TextUtils.isEmpty(majorGradeTagById)) {
            if (i3 / 100000 >= 8) {
                int i16 = i3 % 10000;
                if (i3 >= 860050) {
                    return HardCodeUtil.qqStr(R.string.f160111u5);
                }
                return HardCodeUtil.qqStr(R.string.f160081u2);
            }
            return majorGradeTagById + getSecondaryGradeById(i3) + HardCodeUtil.qqStr(R.string.f160171ua);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi
    @Nullable
    public Bitmap getImageBitmap(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bitmap) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        if (FileUtils.fileExistsAndNotEmpty(str)) {
            try {
                ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
                Bitmap f16 = imageCacheHelper.f(str);
                if (f16 != null) {
                    return f16;
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = false;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                imageCacheHelper.i(str, decodeFile, Business.AIO);
                return decodeFile;
            } catch (Throwable th5) {
                QLog.i(TAG, 1, "getBitmap error " + str + th5.getMessage());
                return null;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getImageBitmap fail: " + str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi
    public String getMajorGradeTagById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        switch (i3 / 100000) {
            case 2:
                return HardCodeUtil.qqStr(R.string.f160091u3);
            case 3:
                return HardCodeUtil.qqStr(R.string.f160151u9);
            case 4:
                return HardCodeUtil.qqStr(R.string.f160121u6);
            case 5:
                return HardCodeUtil.qqStr(R.string.f160141u8);
            case 6:
                return HardCodeUtil.qqStr(R.string.f160101u4);
            case 7:
                return HardCodeUtil.qqStr(R.string.f160161u_);
            case 8:
                return HardCodeUtil.qqStr(R.string.f160131u7);
            default:
                return null;
        }
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi
    public String getMemberGameCardBgImagePath(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this, z16);
        }
        String troopGameCardResDownloadPath = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getTroopGameCardResDownloadPath();
        if (TextUtils.isEmpty(troopGameCardResDownloadPath)) {
            return null;
        }
        if (z16) {
            return troopGameCardResDownloadPath + ITroopGameCardUtilsApi.GAME_MEMBER_GAME_CARD_BG_NIGHT_IMAGE_FILE_NAME;
        }
        return troopGameCardResDownloadPath + ITroopGameCardUtilsApi.GAME_MEMBER_GAME_CARD_BG_IMAGE_FILE_NAME;
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi
    public String getOccupationTypeText(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
        switch (i3) {
            case 1:
                return HardCodeUtil.qqStr(R.string.f160231ug);
            case 2:
                return HardCodeUtil.qqStr(R.string.f160241uh);
            case 3:
                return HardCodeUtil.qqStr(R.string.f160191uc);
            case 4:
                return HardCodeUtil.qqStr(R.string.f160211ue);
            case 5:
                return HardCodeUtil.qqStr(R.string.f160221uf);
            case 6:
                return HardCodeUtil.qqStr(R.string.f160201ud);
            default:
                return null;
        }
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi
    public String getSecondaryGradeById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        if (i3 / 100000 >= 8) {
            return null;
        }
        switch ((i3 % 100000) / 10000) {
            case 5:
                return HardCodeUtil.qqStr(R.string.f160301un);
            case 6:
                return HardCodeUtil.qqStr(R.string.f160291um);
            case 7:
                return HardCodeUtil.qqStr(R.string.f160281ul);
            case 8:
                return HardCodeUtil.qqStr(R.string.f160271uk);
            case 9:
                return HardCodeUtil.qqStr(R.string.f160261uj);
            default:
                return null;
        }
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi
    public String getSelectedEndColorById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        switch (i3 / 100000) {
            case 3:
                return "#B8D4FE";
            case 4:
                return "#FFEF90";
            case 5:
                return "#7AEEFF";
            case 6:
                return "#B6AAFF";
            case 7:
                return "#F7DAED";
            case 8:
                return "#FFDEB1";
            default:
                return "#79F5EE";
        }
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi
    public String getSelectedStartColorById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        switch (i3 / 100000) {
            case 3:
                return "#DBEAFF";
            case 4:
                return "#FFF6C7";
            case 5:
                return "#BBF5FF";
            case 6:
                return "#DAD4FF";
            case 7:
                return "#FAECF5";
            case 8:
                return "#FFEED7";
            default:
                return "#BAFAF6";
        }
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi
    public String getSelectedTextColorById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        switch (i3 / 100000) {
            case 3:
                return "#A1C6FE";
            case 4:
                return "#FFBA6C";
            case 5:
                return "#4FAAFA";
            case 6:
                return "#8E71EE";
            case 7:
                return "#CCB8C6";
            case 8:
                return "#FF8F65";
            default:
                return "#00D6E7";
        }
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi
    public String getUnselectedEndColorById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        switch (i3 / 100000) {
            case 3:
                return "#A1C6FE";
            case 4:
                return "#FFBA6C";
            case 5:
                return "#4FAAFA";
            case 6:
                return "#8E71EE";
            case 7:
                return "#CCB8C6";
            case 8:
                return "#FF8F65";
            default:
                return "#00D6E7";
        }
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi
    public String getUnselectedStartColorById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        switch (i3 / 100000) {
            case 3:
                return "#C5DCFE";
            case 4:
                return "#FFD5A6";
            case 5:
                return "#94CBFB";
            case 6:
                return "#BBA9F4";
            case 7:
                return "#E0D4DC";
            case 8:
                return "#FFBBA2";
            default:
                return "#66E6F0";
        }
    }

    private boolean[] checkShowMsgGameGradeLevel(TroopMemberInfo troopMemberInfo) {
        if (troopMemberInfo == null) {
            return new boolean[]{false, false};
        }
        TroopMemberInfoExt troopMemberInfoExt = troopMemberInfo.extInfo;
        long j3 = troopMemberInfoExt != null ? troopMemberInfoExt.flagEx3 : -1L;
        if (j3 == -1) {
            return new boolean[]{true, false};
        }
        boolean[] zArr = new boolean[2];
        zArr[0] = true;
        zArr[1] = (j3 & 1) == 0;
        return zArr;
    }
}
