package com.tencent.mobileqq.qqlive.room.multichat.report;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
@QAPI(process = {"tool"})
/* loaded from: classes17.dex */
public interface IMultiAvChatReporter extends QRouteApi {
    public static final String ELEMENT_APPLY_FLOATING_WINDOW = "em_qqlive_lm_apply_floating_window";
    public static final String ELEMENT_BOTTOM_FUNCTION = "em_qqlive_bottom_function";
    public static final String ELEMENT_CAPABILITY_BUTTON = "em_qqlive_lm_capability_button";
    public static final String ELEMENT_GUEST_SEATS = "em_qqlive_lm_guest_seats";
    public static final String ELEMENT_INVITE_FLOATING_WINDOW = "em_qqlive_lm_invite_floating_window";
    public static final String ELEMENT_INVITE_FRIENTS = "em_qqlive_lm_invite_friends";
    public static final String ELEMENT_MANAGE = "em_qqlive_lm_manage";
    public static final String ELEMENT_MANAGEMENT = "em_qqlive_lm_management";
    public static final String ELEMENT_MANAGE_GUEST = "em_qqlive_lm_manage_guests";
    public static final String ELEMENT_MODE = "em_qqlive_lm_mode";
    public static final String ELEMENT_NAME_CANCEL_BUTTON = "em_qqlive_lm_name_cancel_button";
    public static final String ELEMENT_NAME_OK_BUTTON = "em_qqlive_lm_name_ok_button";
    public static final String ELEMENT_PLAY_SELECTION = "em_qqlive_lm_play_selection";
    public static final String ELEMENT_REDPOT = "em_qqlive_lm_hongdian";
    public static final String ELEMENT_REDPOT_NUM = "qqlive_lm_redpot_number";
    public static final String ELEMENT_SETTINGS = "em_qqlive_lm_room_settings";
    public static final String ELEMENT_STATUS_FLOATING_WINDOW = "em_qqlive_lm_status_floating_window";
    public static final String ELEMENT_WHEAT_RENAME = "em_qqlive_lm_wheat_rename";
    public static final String EVENT_ANCHOR_ACCEPT = "ev_qqlive_lm_anchor_accept";
    public static final String EVENT_ANCHOR_REJECT = "ev_qqlive_lm_anchor_reject";
    public static final String EVENT_INVITE_AUDIENCE = "ev_qqlive_lm_inviteaudience";

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public @interface ActionType {
        public static final int APPLY_UPLOAD_MIC = 0;
        public static final int OPEN_PROFILE = 1;
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public @interface ApplyType {
        public static final int APPLY = 0;
        public static final int CANCEL_APPLY = 1;
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public @interface ListType {
        public static final int APPLY_LIST = 0;
        public static final int INVITE_LIST = 1;
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public @interface ManageType {
        public static final int CLOSE_MULTI_AV_CHAT = 1;
        public static final int OPEN_ROOM_CONFIG = 0;
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public @interface MediaControlType {
        public static final int BAN_CAMERA_BY_ANCHOR = 5;
        public static final int BAN_MIC_BY_ANCHOR = 6;
        public static final int BEAUTY = 0;
        public static final int CANCEL_MUTE = 4;
        public static final int CLOSE_CAMERA = 2;
        public static final int DEFAULT = -1;
        public static final int DO_MUTE = 3;
        public static final int OPEN_CAMERA = 1;
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public @interface PageId {
        public static final String ANCHOR_PAGE_ID = "pg_qqlive_anchorlive";
        public static final String AUDIENCE_PAGE_ID = "pg_qqlive_audience";
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public @interface ReplyType {
        public static final int ACCEPT = 0;
        public static final int REFUSE = 1;
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public @interface SeatConfigType {
        public static final int CAMERA = 1;
        public static final int LEAVE_SEAT = 3;
        public static final int MUTE = 0;
        public static final int RENAME = 2;
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public @interface SettingType {
        public static final int ENABLE_CAMERA = 1;
        public static final int ENABLE_GIFT = 2;
        public static final int NEED_REQUEST = 0;
    }

    void addActivityToDTWhiteList(Activity activity);

    void bindElementExcludeClickForCustomWindow(View view, String str, ConcurrentHashMap<String, String> concurrentHashMap);

    void bindElementWithDynamicParams(View view, IDynamicParams iDynamicParams);

    void bindElementWithStaticParams(View view, String str, ConcurrentHashMap<String, String> concurrentHashMap);

    void bindPageInfo(long j3);

    void bindPageInfo(long j3, LiveRoomExtraInfo liveRoomExtraInfo);

    void bindPageParamsToRootView(View view, @PageId String str);

    ConcurrentHashMap<String, String> generateAnchorAcceptEventParam(long j3);

    ConcurrentHashMap<String, String> generateAnchorRejectEventParam(long j3);

    ConcurrentHashMap<String, String> generateApplyFloatingWindowElementParam(int i3);

    ConcurrentHashMap<String, String> generateBottomFunctionElementParam();

    ConcurrentHashMap<String, String> generateCapabilityElementParam(int i3, long j3);

    ConcurrentHashMap<String, String> generateGuestSeatElementParam(int i3);

    ConcurrentHashMap<String, String> generateInviteAudienceEventParam(long j3);

    ConcurrentHashMap<String, String> generateInviteFloatingWindowElementParam(int i3);

    ConcurrentHashMap<String, String> generateManageElementParam(int i3);

    ConcurrentHashMap<String, String> generateManageGuestElementParam(long j3);

    ConcurrentHashMap<String, String> generateManagementElementParam(int i3);

    ConcurrentHashMap<String, String> generatePlaySelectionElementParam();

    ConcurrentHashMap<String, String> generateRedPotElementParam(int i3);

    ConcurrentHashMap<String, String> generateSettingsElementParam(int i3, boolean z16);

    ConcurrentHashMap<String, String> generateStatusFloatingWindowElementParam(int i3);

    ConcurrentHashMap<String, String> generateWheatRenameElementParam();

    ConcurrentHashMap<String, String> getPageInfo();

    void reportClickForCustomWindow(View view, ConcurrentHashMap<String, String> concurrentHashMap);

    void reportCustomEvent(String str, ConcurrentHashMap<String, String> concurrentHashMap);

    void traverseExposure();

    void updatePageInfo(long j3);
}
