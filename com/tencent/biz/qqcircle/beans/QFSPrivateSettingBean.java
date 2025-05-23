package com.tencent.biz.qqcircle.beans;

import android.view.View;
import com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView;

/* loaded from: classes4.dex */
public class QFSPrivateSettingBean {
    public static final String KEY_SIMPLE_ITEM_AIGC_STATEMENT = "key_simple_item_aigc_statement";
    public static final String KEY_SIMPLE_ITEM_BLACK_LIST = "key_simple_item_black_list";
    public static final String KEY_SIMPLE_ITEM_COMPLAINT_GUIDELINES = "key_simple_item_complaint_guidelines";
    public static final String KEY_SIMPLE_ITEM_CONTRACT_SWITCH = "key_simple_item_contract_switch";
    public static final String KEY_SIMPLE_ITEM_LIKE = "key_simple_item_like";
    public static final String KEY_SIMPLE_ITEM_PERSONALIZE = "key_simple_item_personalize";
    public static final String KEY_SIMPLE_ITEM_PYMK = "key_simple_item_pymk";
    public static final String KEY_SIMPLE_ITEM_RECOM_LIKE_FEED_TO_FRIENDS = "key_simple_item_recom_like_feed_to_friends";
    public static final String KEY_SIMPLE_ITEM_SERVICE_PROTOCOL = "key_simple_item_service_protocol";
    public static final String KEY_SIMPLE_ITEM_TEENAGE_MANAGER = "key_simple_item_teenage_manager";
    public static final String KEY_SIMPLE_ITEM_VISITOR_SWITCH = "key_simple_item_visitor_switch";
    public static final String KEY_SWITCH_BUTTON_ALLOW_GAME_PAGE_ENTRANCE = "key_switch_button_allow_game_page_entrance";
    public static final String KEY_SWITCH_BUTTON_ENABLE_AI_COMMENT = "key_switch_button_enable_ai_comment";
    public static final String KEY_SWITCH_BUTTON_ENABLE_PERSONAL_RECOMMEND = "key_switch_button_enable_personal_recommend";
    public static final String KEY_SWITCH_BUTTON_NEW_MSG = "key_switch_button_new_msg";
    public static final String KEY_SWITCH_BUTTON_ONE_KEY_DEFEND = "key_switch_one_key_defend";
    public static final String KEY_SWITCH_BUTTON_REC_PIC = "key_switch_button_rec_pic";
    public static final String KEY_SWITCH_BUTTON_SHOW_CARD = "key_switch_button_show_card";
    public static final String KEY_SWITCH_BUTTON_SHOW_COLLECT = "key_switch_button_show_collect";
    public static final String KEY_SWITCH_BUTTON_SHOW_FAN = "key_switch_button_show_fan";
    public static final String KEY_SWITCH_BUTTON_SHOW_PRAISED = "key_switch_button_show_praised";
    public static final String KEY_SWITCH_BUTTON_SHOW_PRESENTATION_MFO = "key_switch_button_show_presentation_mfo";
    public static final String KEY_SWITCH_BUTTON_SHOW_PRESENTATION_OFM = "key_switch_button_show_presentation_ofm";
    public static final String KEY_SWITCH_BUTTON_SHOW_PUSHED = "key_switch_button_show_pushed";
    public static final String KEY_SWITCH_BUTTON_VIDEO_VOICE = "key_switch_button_video_voice";
    public static final int KEY_VIEW_TYPE_SIMPLE_ITEM = 2;
    public static final int KEY_VIEW_TYPE_SWITCH_BUTTON = 1;
    private String eid;
    private String head;
    private CharSequence hide;
    private String key;
    private String leftText;
    private QFSSettingSwitchView.b listener;
    private boolean mIsNeedGap;
    private View.OnClickListener onClickListener;
    private String rightText;
    private String title;
    private int viewType = 1;
    private int bgType = 0;
    private boolean checked = false;
    private int drawableId = 0;

    public QFSPrivateSettingBean(String str) {
        this.key = str;
    }

    public int getBgType() {
        return this.bgType;
    }

    public int getDrawableId() {
        return this.drawableId;
    }

    public String getEid() {
        return this.eid;
    }

    public String getHead() {
        return this.head;
    }

    public CharSequence getHide() {
        return this.hide;
    }

    public boolean getIsNeedGap() {
        return this.mIsNeedGap;
    }

    public String getKey() {
        return this.key;
    }

    public String getLeftText() {
        return this.leftText;
    }

    public QFSSettingSwitchView.b getListener() {
        return this.listener;
    }

    public View.OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    public String getRightText() {
        return this.rightText;
    }

    public String getTitle() {
        return this.title;
    }

    public int getViewType() {
        return this.viewType;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setBgType(int i3) {
        this.bgType = i3;
    }

    public void setChecked(boolean z16) {
        this.checked = z16;
    }

    public void setDrawableId(int i3) {
        this.drawableId = i3;
    }

    public void setEid(String str) {
        this.eid = str;
    }

    public void setHead(String str) {
        this.head = str;
    }

    public void setHide(CharSequence charSequence) {
        this.hide = charSequence;
    }

    public void setIsNeedGap(boolean z16) {
        this.mIsNeedGap = z16;
    }

    public void setLeftText(String str) {
        this.leftText = str;
    }

    public void setListener(QFSSettingSwitchView.b bVar) {
        this.listener = bVar;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void setRightText(String str) {
        this.rightText = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setViewType(int i3) {
        this.viewType = i3;
    }
}
