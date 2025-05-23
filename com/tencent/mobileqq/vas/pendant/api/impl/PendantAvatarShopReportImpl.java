package com.tencent.mobileqq.vas.pendant.api.impl;

import android.util.Base64;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class PendantAvatarShopReportImpl implements IPendantAvatarShopReport {
    private static final String APP_ID = "DressVip";
    private static final String AVATAR_PAY_AID = "mvip.g.a.txsc";
    private static final String PAGE_ID = "3001170";
    private static final String PENDANT_PAY_AID = "mvip.gxh.android.faceaddon_nati";
    private static final String TYPE_ID_AVATAR = "3001017";
    private static final String TYPE_ID_PENDANT = "3001011";
    private static final String VIP_PAY_AID = "mvip.u.a.h5";
    private static PendantAvatarShopReportImpl instance = new PendantAvatarShopReportImpl();
    private int actionAttr;
    private int actionId;
    private int actionValue;
    private String moduleId = "";
    private String subModuleId = "";
    private String itemId = "";
    private String subItemId = "";
    private String itemType = "";
    private String ruleId = "";
    private String busiInfo = "";
    private String positionId = "";

    private void clear() {
        this.moduleId = "";
        this.subModuleId = "";
        this.itemId = "";
        this.subItemId = "";
        this.itemType = "";
        this.actionId = 0;
        this.actionValue = 0;
        this.actionAttr = 0;
        this.ruleId = "";
        this.busiInfo = "";
    }

    private String getBusiInfo(boolean z16, int i3) {
        String str = VIP_PAY_AID;
        if (!z16) {
            if (i3 != 2 && i3 != 14) {
                str = PENDANT_PAY_AID;
            }
        } else if (i3 != 2 && i3 != 14) {
            str = AVATAR_PAY_AID;
        }
        return "{\"aid\":\"" + str + "\"}";
    }

    public static IPendantAvatarShopReport getInstance() {
        return instance;
    }

    private void reportAction() {
        ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(APP_ID, PAGE_ID, this.moduleId, this.subModuleId, this.itemId, this.subItemId, this.itemType, this.actionId, this.actionValue, this.actionAttr, this.ruleId, this.busiInfo, this.positionId);
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public String getTraceDetail(int i3, int i16, int i17, int i18, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", APP_ID);
            jSONObject.put("page_id", PAGE_ID);
            jSONObject.put("sub_module_id", i17);
            jSONObject.put("item_id", i16);
            jSONObject.put("action_id", 109);
            jSONObject.put("str_ruleid", str);
            if (i3 == 23) {
                jSONObject.put("item_type", str2);
                jSONObject.put("module_id", "9");
                this.busiInfo = getBusiInfo(true, i18);
            } else {
                jSONObject.put("item_type", str2);
                jSONObject.put("module_id", "6");
                this.busiInfo = getBusiInfo(false, i18);
            }
            jSONObject.put("busi_info", this.busiInfo);
            return Base64.encodeToString(jSONObject.toString().getBytes(), 0).trim().replaceAll("\n", "").replaceAll(" ", "");
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        } catch (Exception e17) {
            e17.printStackTrace();
            return "";
        }
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void goSplendidShop() {
        clear();
        this.moduleId = "7";
        this.subItemId = "1";
        this.itemId = "go_splendid";
        this.itemType = "4";
        this.actionId = 102;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onAdItem(int i3, int i16, int i17, String str, String str2) {
        clear();
        this.moduleId = "6";
        this.subItemId = "1";
        this.subModuleId = "" + i17;
        this.itemId = "" + i16;
        this.itemType = str2;
        this.actionId = i3;
        this.ruleId = str;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onAvatarButtonAction(int i3) {
        clear();
        this.actionId = i3;
        this.itemType = "4";
        this.itemId = "dress";
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onCancelButton(int i3) {
        clear();
        this.moduleId = "2";
        this.itemType = "4";
        this.actionId = i3;
        this.itemId = "cancel";
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onDynamicButton(int i3) {
        clear();
        this.moduleId = "3";
        this.itemType = "4";
        this.actionId = i3;
        this.itemId = TabPreloadItem.TAB_NAME_DYNAMIC;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onHeadAvatarItemClick() {
        clear();
        this.moduleId = "1";
        this.itemId = "dress";
        this.actionId = 102;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onHeadQQShowItem(int i3) {
        clear();
        this.moduleId = "1";
        this.itemId = "super_avatar";
        this.actionId = i3;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onHeadSplendidItem(int i3, String str) {
        clear();
        this.moduleId = "1";
        this.itemId = "splendid";
        this.actionId = i3;
        this.positionId = str;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onMineChooseListExpose() {
        clear();
        this.moduleId = "2";
        this.actionId = 111;
        reportAction();
        onMyAvatarButton(101);
        onMyPendantButton(101);
        onCancelButton(101);
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onMineIconClick() {
        clear();
        this.moduleId = "1";
        this.itemId = "mine";
        this.actionId = 102;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onMyAvatarButton(int i3) {
        clear();
        this.moduleId = "2";
        this.actionId = i3;
        this.itemType = "4";
        this.itemId = "touxiang";
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onMyPendantButton(int i3) {
        clear();
        this.moduleId = "2";
        this.itemType = "4";
        this.actionId = i3;
        this.itemId = "guajian";
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onPay(int i3, int i16) {
        clear();
        this.moduleId = "4";
        this.itemType = "4";
        this.actionId = i3;
        this.itemId = "" + i16;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onPayBanner(int i3) {
        clear();
        this.moduleId = "4";
        this.itemType = "4";
        this.actionId = i3;
        this.itemId = OpenConstants.ApiName.PAY;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onPendantButtonAction(int i3) {
        clear();
        this.actionId = i3;
        this.itemType = "4";
        this.itemId = IndividuationUrlHelper.UrlId.PENDANT_HOME;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onPendantItem(int i3, int i16, int i17, String str) {
        clear();
        this.moduleId = "6";
        this.actionId = i3;
        this.subModuleId = "" + i17;
        this.itemId = "" + i16;
        this.ruleId = str;
        this.itemType = TYPE_ID_PENDANT;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onPendantSet(int i3, int i16, String str) {
        clear();
        this.moduleId = "6";
        this.actionId = 113;
        this.subModuleId = "" + i16;
        this.itemId = "" + i3;
        this.ruleId = str;
        this.itemType = TYPE_ID_PENDANT;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onPendantShopExpose() {
        clear();
        this.moduleId = "6";
        this.actionId = 111;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onPendantTab(int i3, int i16) {
        clear();
        this.moduleId = "6";
        this.actionId = i3;
        this.subModuleId = "" + i16;
        this.itemId = "" + i16;
        this.itemType = "4";
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onPendantTabItemExpose(int i3) {
        clear();
        this.subItemId = "" + i3;
        this.moduleId = "6";
        this.actionId = 112;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onPendantTryPay(int i3, int i16, int i17, String str) {
        clear();
        this.moduleId = "6";
        this.actionId = 109;
        this.subModuleId = "" + i16;
        this.itemId = "" + i3;
        this.ruleId = str;
        this.itemType = TYPE_ID_PENDANT;
        this.busiInfo = getBusiInfo(false, i17);
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onPersonalItem(int i3, int i16, int i17, String str) {
        clear();
        this.moduleId = "9";
        this.subItemId = "1";
        this.subModuleId = "" + i17;
        this.itemId = "" + i16;
        this.itemType = TYPE_ID_AVATAR;
        this.actionId = i3;
        this.ruleId = str;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onPersonalSet(int i3, int i16, String str) {
        clear();
        this.moduleId = "9";
        this.subItemId = "1";
        this.subModuleId = "" + i16;
        this.itemId = "" + i3;
        this.ruleId = str;
        this.itemType = TYPE_ID_AVATAR;
        this.actionId = 113;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onPersonalShopExpose() {
        clear();
        this.moduleId = "9";
        this.actionId = 111;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onPersonalTab(int i3, int i16) {
        clear();
        this.moduleId = "9";
        this.actionId = i3;
        this.subModuleId = "" + i16;
        this.itemId = "" + i16;
        this.itemType = "4";
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onPersonalTabItemExpose(int i3) {
        clear();
        this.moduleId = "9";
        this.subModuleId = "" + i3;
        this.actionId = 102;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onPersonalTryPay(int i3, int i16, int i17, String str) {
        clear();
        this.moduleId = "9";
        this.subItemId = "1";
        this.subModuleId = "" + i16;
        this.itemId = "" + i3;
        this.itemType = TYPE_ID_AVATAR;
        this.actionId = 109;
        this.ruleId = str;
        this.busiInfo = getBusiInfo(true, i17);
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onPhotoButton(int i3) {
        clear();
        this.moduleId = "3";
        this.itemType = "4";
        this.actionId = i3;
        this.itemId = "photo";
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onPictureButton(int i3) {
        clear();
        this.moduleId = "3";
        this.itemType = "4";
        this.actionId = i3;
        this.itemId = "picture";
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onPreviewClick() {
        clear();
        this.moduleId = "1";
        this.itemId = "preview";
        this.actionId = 102;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onPreviewListExpose() {
        clear();
        this.moduleId = "3";
        this.actionId = 111;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onQQShowItem(int i3, int i16) {
        clear();
        this.moduleId = "8";
        this.subItemId = "1";
        this.itemId = "" + i16;
        this.itemType = TYPE_ID_AVATAR;
        this.actionId = i3;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onQQShowSet(int i3) {
        clear();
        this.moduleId = "8";
        this.subItemId = "1";
        this.itemId = "" + i3;
        this.itemType = TYPE_ID_AVATAR;
        this.actionId = 113;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onQQShowShopExpose() {
        clear();
        this.moduleId = "8";
        this.actionId = 112;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onSeeHistoryButton(int i3) {
        clear();
        this.moduleId = "3";
        this.itemType = "4";
        this.actionId = i3;
        this.itemId = "history";
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onShopFirstViewExpose() {
        clear();
        this.moduleId = "1";
        this.actionId = 100;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onShopFirstViewExposeNew() {
        int i3;
        int i16;
        Setting settingFromDb;
        clear();
        this.moduleId = "1";
        this.actionId = 101;
        this.itemType = TYPE_ID_AVATAR;
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(MobileQQ.sMobileQQ.peekAppRuntime().getAccount()), "AvatarPendantViewImpl");
        if (vasSimpleInfoWithUid != null) {
            i3 = vasSimpleInfoWithUid.faceId;
        } else {
            i3 = 0;
        }
        this.itemId = String.valueOf(i3);
        if (i3 == 0 && (settingFromDb = ((IQQAvatarDataService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQAvatarDataService.class, "")).getSettingFromDb(MobileQQ.sMobileQQ.peekAppRuntime().getAccount())) != null) {
            if (settingFromDb.bHeadType == 0) {
                i16 = 3;
            } else {
                i16 = 2;
            }
        } else {
            i16 = 1;
        }
        this.busiInfo = "{\"avatar_type\":\"" + i16 + "\"}";
        reportAction();
        onAvatarButtonAction(101);
        onPendantButtonAction(101);
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onShopHeadViewExpose() {
        clear();
        this.moduleId = "1";
        this.actionId = 111;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onSplendidShopExpose(boolean z16) {
        String str;
        clear();
        this.moduleId = "7";
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        this.subItemId = str;
        this.actionId = 112;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onSplendidShopItem(int i3, int i16) {
        clear();
        this.moduleId = "7";
        this.subItemId = "1";
        this.itemId = "" + i16;
        this.itemType = TYPE_ID_AVATAR;
        this.actionId = i3;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void onSplendidShopSet(int i3) {
        clear();
        this.moduleId = "7";
        this.subItemId = "1";
        this.itemId = "" + i3;
        this.itemType = TYPE_ID_AVATAR;
        this.actionId = 113;
        reportAction();
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport
    public void setPositionId(String str) {
        this.positionId = str;
    }
}
