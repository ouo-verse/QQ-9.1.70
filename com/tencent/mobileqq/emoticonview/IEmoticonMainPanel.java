package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.data.BaseEmotionPanelBusinessParam;
import java.util.List;

/* loaded from: classes12.dex */
public interface IEmoticonMainPanel {
    public static final int BTN_STATUS_DEL = 2;
    public static final int BTN_STATUS_MORE = 1;
    public static final String FORCE_TO_RECOMMEND_PANEL_SP = "force_to_recommend_panel_sp";
    public static final int MAX_REPORT_COUNT = 10;
    public static final int OPEN_CONDITION_FIRST_IN_AIO = 2;
    public static final int OPEN_CONDITION_FIRST_IN_PROCESS = 1;
    public static final int OPEN_CONDITION_REOPEN_IN_AIO = 3;
    public static final String PERF_REPORT_OPEN_DURATION_TAG1 = "report_AIOEmoticonPanel_OpenFirstTimeInProcess";
    public static final String PERF_REPORT_OPEN_DURATION_TAG2 = "report_AIOEmoticonPanel_OpenFirstTimeInAIO";
    public static final String PERF_REPORT_OPEN_DURATION_TAG3 = "report_AIOEmoticonPanel_ReopenInAIO";
    public static final long REPORT_INTERVAL = 86400000;
    public static final String REPORT_PARAM_PANEL_MODE = "panelMode";
    public static final String REPORT_PARAM_PANEL_OPEN_DURATION = "duration";
    public static final String SP_KEY_EMOTICON_PANEL_LAST_REPORT_TIME = "sp_key_emoticon_panel_last_report_time";
    public static final String SP_KEY_EMOTICON_PANEL_REPORT_COUNT = "sp_key_emoticon_panel_report_count";
    public static final String SP_KEY_MARKET_OPEN_TIME = "sp_key_market_open_time";
    public static final String SP_KEY_SEND_H5_MAGIC_FACE_TIME = "sp_key_send_h5_magic_face_time";
    public static final String SP_USER_FILE_NAME = "emoticon_panel_";

    /* loaded from: classes12.dex */
    public interface DispatchKeyEventListener {
        boolean dispatchKeyEvent(KeyEvent keyEvent);
    }

    /* loaded from: classes12.dex */
    public interface OnPanelTabSelectedCallBack {
        void onPanelTabSelected(int i3);
    }

    void addTabListAdditionalView(boolean z16, View view);

    void deleteEmoticonClick();

    void disableHorizontalScroll();

    void doAutoDownload(int i3);

    void enableHorizontalScroll();

    IEmoticonPanelController getEmoController();

    int getEmoticonTab(String str);

    boolean getGlobalVisibleRect(Rect rect);

    int getLastPosition();

    IPanelInteractionListener getPanelInteractionListener();

    View getStickerMaskLayout();

    @NonNull
    RelativeLayout getView();

    int getVisibility();

    void hideAllTabs();

    void init(BaseQQAppInterface baseQQAppInterface, int i3, Context context, int i16, String str, int i17);

    void init(BaseQQAppInterface baseQQAppInterface, int i3, Context context, int i16, String str, int i17, IPanelInteractionListener iPanelInteractionListener);

    void init(BaseQQAppInterface baseQQAppInterface, int i3, Context context, int i16, String str, int i17, IPanelInteractionListener iPanelInteractionListener, boolean z16, EmoticonListProvider emoticonListProvider);

    void init(BaseQQAppInterface baseQQAppInterface, int i3, Context context, int i16, String str, IPanelInteractionListener iPanelInteractionListener);

    void init(BaseQQAppInterface baseQQAppInterface, int i3, Context context, int i16, String str, IPanelInteractionListener iPanelInteractionListener, boolean z16);

    void init(BaseQQAppInterface baseQQAppInterface, int i3, Context context, int i16, String str, IPanelInteractionListener iPanelInteractionListener, boolean z16, EmoticonListProvider emoticonListProvider);

    void initEmoticonView(int i3);

    void initEmoticonView(String str);

    boolean isHiden();

    boolean isOnlySysAndEmoji();

    boolean isTabVisible();

    void onDestory();

    void onHide(boolean z16);

    void onPanelTabSelected(int i3);

    void onPause();

    void onPullDown();

    void onResume();

    void onShow();

    void preloadWebProcess();

    void refreshEmoticonList(int i3);

    void setCallBack(EmoticonCallback emoticonCallback);

    void setDisableAutoDownload(boolean z16);

    void setDisableGuide(boolean z16);

    void setDisableGuideOneTime(boolean z16);

    void setDisableMoreEmotionButton(boolean z16);

    void setDispatchKeyEventListener(DispatchKeyEventListener dispatchKeyEventListener);

    void setEmoSettingVisibility(int i3);

    void setHasBigEmotion(boolean z16);

    void setIsHiden(boolean z16);

    void setOnlySysAndEmoji(boolean z16);

    void setOnlySysEmotionEnable(boolean z16);

    void setSecondTabInited(boolean z16);

    void setTabListOverScrollMode(int i3);

    void setTabSecondaryEmoticonPadding(int i3, int i16);

    void setTabSelectedCallBack(OnPanelTabSelectedCallBack onPanelTabSelectedCallBack);

    void showAllTabs();

    boolean showStickerGuide();

    void switchSystemEmojiTabLocationPos(int i3, int i16);

    void switchTabMode(int i3);

    void switchToAnonymous(boolean z16);

    void updateDeleteBtnVisibility(CharSequence charSequence);

    void updateFavEmoticonPanel();

    void updateLastEmoticonPanel();

    void updateMagicPanel();

    void updatePanelBusinessParam(int i3, BaseEmotionPanelBusinessParam baseEmotionPanelBusinessParam);

    void updateRecentEmoji(List<EmotionPanelData> list);

    void updateSystemAndEmojiPanel();
}
