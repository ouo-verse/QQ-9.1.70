package com.tencent.mobileqq.qqexpand.config;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ExpandConfig {
    public static final int DEFAULT_SAVE_EMPTY_AIO_NODE = 1;
    public static final int DEFAULT_SEND_PIC_AND_VOICE_MESSAGE_LIMIT_COUNT = 2;
    public String addEntranceLine1;
    public String addEntranceTitle;
    public String centerBannerList;
    public String contactEntranceLine1;
    public String contactEntranceLine2;
    public String contactEntranceTitle;
    public int declerationMinLen;
    public String defaultDecleration;
    public String expandExamImg;
    public String flutterHomePageTitle;
    public String flutterMessagePageTitle;
    public String flutterSettingPageTitle;
    public int isExpandEntranceOnTop;
    public int isHasUpgradeIntroduce;
    public String mBeatWarning;
    public String mResourceMD5;
    public String mResourceURL;
    public int mShowGroup;
    public String matchChatGrayTipsLight;
    public String matchChatGrayTipsMsg;
    public int maxPlayers;
    public int maxSlipTimes;
    public int minPlayers;
    public int newUserMoment;
    public int redisplayInterval;
    public String searchHint;
    public int voiceMaxLength;
    public int androidExpandPlugin = 0;
    public int tabIndex = 0;
    public int testId = 0;
    public String testStrId = "";
    public int saveEmptyAIONode = 1;
    public List<String> defaultTags = new ArrayList();
    public List<String> searchTags = new ArrayList();
    public HashMap<String, Object> limitChatResList = new HashMap<>();
    public int bLimitchatOpen = 0;
    public int bNuanSSfirstTab = 0;
    public int bVoiceMatchOpen = 0;
    public int bSignalBombOpen = 0;
    public int exposureTimeLimit = 2;
    public boolean showVipIcon = false;
    public int matchChatGrayTipsCount = 50;
    public int matchChatIceBreakSwitch = 1;
    public int coldPalaceGrayTipPosition = 1;
    public int sendPicAndVoiceMessageLimitCount = 2;

    public String getTestId() {
        if (!TextUtils.isEmpty(this.testStrId)) {
            return this.testStrId;
        }
        return this.testId + "";
    }
}
