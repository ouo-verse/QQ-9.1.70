package com.tencent.mobileqq.data;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Date;
import tencent.im.troop.findtroop.TabRecommendPB$ContactTopCard;

@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "dataSource,type")
/* loaded from: classes10.dex */
public class PYMKBizEntryInfo extends Entity {
    public static final long CARTON_SHOW_INTERVAL = 86400;
    public static final String TAG = "PYMKBizEntryInfo";
    public long type = 0;
    public String title = "";
    public String subTitle = "";
    public String iconLightUrl = "";
    public String iconDarkUrl = "";
    public String backgroundLightUrl = "";
    public String backgroundDarkUrl = "";
    public String cardJumpUrl = "";
    public String buttonText = "";
    public String buttonJumpUrl = "";
    public String horiBarTitle = "";
    public String horiBarIconLightUrl = "";
    public String horiBarIconDarkUrl = "";
    public long closeDelayTime = 0;
    public int orderNum = 0;
    public int dataSource = 1;
    public long lastCloseTime = 0;
    public long lastCartonShowTime = 0;

    public static PYMKBizEntryInfo convertDataFromContactTopCard(TabRecommendPB$ContactTopCard tabRecommendPB$ContactTopCard, int i3, int i16) {
        PYMKBizEntryInfo pYMKBizEntryInfo = new PYMKBizEntryInfo();
        pYMKBizEntryInfo.type = tabRecommendPB$ContactTopCard.type.get();
        pYMKBizEntryInfo.title = tabRecommendPB$ContactTopCard.title.get();
        pYMKBizEntryInfo.subTitle = tabRecommendPB$ContactTopCard.sub_title.get();
        pYMKBizEntryInfo.iconLightUrl = tabRecommendPB$ContactTopCard.icon_light_url.get();
        pYMKBizEntryInfo.iconDarkUrl = tabRecommendPB$ContactTopCard.icon_dark_url.get();
        pYMKBizEntryInfo.backgroundLightUrl = tabRecommendPB$ContactTopCard.background_light_url.get();
        pYMKBizEntryInfo.backgroundDarkUrl = tabRecommendPB$ContactTopCard.background_dark_url.get();
        pYMKBizEntryInfo.cardJumpUrl = tabRecommendPB$ContactTopCard.card_jump_url.get();
        pYMKBizEntryInfo.buttonText = tabRecommendPB$ContactTopCard.button_text.get();
        pYMKBizEntryInfo.buttonJumpUrl = tabRecommendPB$ContactTopCard.button_jump_url.get();
        pYMKBizEntryInfo.closeDelayTime = tabRecommendPB$ContactTopCard.close_delay_time.get();
        pYMKBizEntryInfo.horiBarTitle = tabRecommendPB$ContactTopCard.hori_bar_title.get();
        pYMKBizEntryInfo.horiBarIconLightUrl = tabRecommendPB$ContactTopCard.hori_bar_icon_light_url.get();
        pYMKBizEntryInfo.horiBarIconDarkUrl = tabRecommendPB$ContactTopCard.hori_bar_icon_dark_url.get();
        pYMKBizEntryInfo.orderNum = i3;
        pYMKBizEntryInfo.dataSource = i16;
        return pYMKBizEntryInfo;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PYMKBizEntryInfo)) {
            return false;
        }
        PYMKBizEntryInfo pYMKBizEntryInfo = (PYMKBizEntryInfo) obj;
        if (pYMKBizEntryInfo.type != this.type || pYMKBizEntryInfo.dataSource != this.dataSource) {
            return false;
        }
        return true;
    }

    public boolean isAbelToShowCarton() {
        if (new Date().getTime() / 1000 >= this.lastCartonShowTime + 86400) {
            return true;
        }
        return false;
    }

    public boolean isAbleToShow() {
        boolean z16;
        if (new Date().getTime() / 1000 >= this.lastCloseTime + this.closeDelayTime) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.i(TAG, 1, "datasource" + this.dataSource + " entry " + this.type + " is valid " + z16 + " lastCloseTime " + this.lastCloseTime + " closeDelayTime " + this.closeDelayTime);
            return false;
        }
        if (((int) this.type) == 1) {
            boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
            boolean isNowElderMode = SimpleUIUtil.isNowElderMode();
            QLog.i(TAG, 1, "PYMK_TOP4_ENTRY_STRANGER datasource" + this.dataSource + " entry " + this.type + " is valid  closeDelayTime " + this.closeDelayTime + z16 + "isStudyMode" + studyModeSwitch + " isElder " + isNowElderMode);
            if (studyModeSwitch || isNowElderMode) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    public String toString() {
        return "dataSource " + this.dataSource + " type " + this.type + " orderNum " + this.orderNum + " iconLightUrl " + this.iconLightUrl + " iconDarkUrl " + this.iconDarkUrl + " backgroundLightUrl " + this.backgroundLightUrl + " backgroundDarkUrl " + this.backgroundDarkUrl + " cardJumpUrl " + this.cardJumpUrl + " buttonJumpUrl " + this.buttonJumpUrl + " horiBarIconLightUrl " + this.horiBarIconLightUrl + " horiBarIconDarkUrl " + this.horiBarIconDarkUrl;
    }
}
