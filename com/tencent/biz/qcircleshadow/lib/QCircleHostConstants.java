package com.tencent.biz.qcircleshadow.lib;

import com.heytap.databaseengine.type.DataTableNameType;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.chat.api.IChatActivityApi;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.forward.api.IForwardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxapi.api.IWXShareHelper;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleHostConstants {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class AppConstants {

        /* compiled from: P */
        /* loaded from: classes4.dex */
        public static class Key {
            public static String FORWARD_ARK_APP_BIZSRC() {
                return "forward_ark_biz_src";
            }

            public static String FORWARD_ARK_APP_CONFIG() {
                return AppConstants.Key.FORWARD_ARK_APP_CONFIG;
            }

            public static String FORWARD_ARK_APP_DESC() {
                return AppConstants.Key.FORWARD_ARK_APP_DESC;
            }

            public static String FORWARD_ARK_APP_META() {
                return "forward_ark_app_meta";
            }

            public static String FORWARD_ARK_APP_NAME() {
                return "forward_ark_app_name";
            }

            public static String FORWARD_ARK_APP_PROMPT() {
                return "forward_ark_app_prompt";
            }

            public static String FORWARD_ARK_APP_VER() {
                return "forward_ark_app_ver";
            }

            public static String FORWARD_ARK_APP_VIEW() {
                return "forward_ark_app_view";
            }

            public static String FORWARD_DISPLAY_ARK() {
                return "is_ark_display_share";
            }

            public static String FORWARD_TYPE() {
                return "forward_type";
            }

            public static String SHARE_REQ_DEFAULT_COMMENT() {
                return AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT;
            }

            public static String SHARE_REQ_DESC() {
                return "desc";
            }

            public static String SHARE_REQ_DETAIL_URL() {
                return "detail_url";
            }

            public static String SHARE_REQ_ID() {
                return "req_share_id";
            }

            public static String SHARE_REQ_IMAGE_URL() {
                return "image_url";
            }

            public static String SHARE_REQ_SHARE_QZONE_INFO() {
                return "share_qzone_info";
            }

            public static String SHARE_REQ_TITLE() {
                return "title";
            }

            public static String SHARE_REQ_TYPE() {
                return AppConstants.Key.SHARE_REQ_TYPE;
            }

            public static String TROOP_INFO_FROM_TROOPSETTING() {
                return "troop_info_from_troopsetting";
            }

            public static String UIN() {
                return "uin";
            }

            public static String UIN_NAME() {
                return "uinname";
            }

            public static String UIN_TYPE() {
                return "uintype";
            }
        }

        /* compiled from: P */
        /* loaded from: classes4.dex */
        public static class Value {
            public static int SHARE_REQ_TYPE_JOIN_GUILD() {
                return 6;
            }

            public static int UIN_TYPE_FRIEND() {
                return 0;
            }

            public static int UIN_TYPE_TEMP_CIRCLE() {
                return 10008;
            }
        }

        public static String APP_NAME() {
            return "mobileQQ";
        }

        public static String SDCARD_IMG_SAVE() {
            return com.tencent.mobileqq.app.AppConstants.SDCARD_IMG_SAVE;
        }

        public static String SDCARD_ROOT() {
            return com.tencent.mobileqq.app.AppConstants.SDCARD_ROOT;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class ForwardType {
        public static int FILE() {
            return 0;
        }

        public static int SEND_QCIRCLE_ARK() {
            return DataTableNameType.TABLE_SNORE_OSA_MODEL;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class _AppSetting {
        public static String buildNum() {
            return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).buildNum();
        }

        public static boolean enableTalkBack() {
            return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).enableTalkBack();
        }

        public static String getSubVersion() {
            return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getSubVersion();
        }

        public static String getVersion() {
            return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getVersion();
        }

        public static boolean isAllowLandScape() {
            return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isAllowLandscape();
        }

        public static boolean isDebugVersion() {
            return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion();
        }

        public static boolean isGrayVersion() {
            return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isGrayVersion();
        }

        public static boolean isPublicVersion() {
            return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion();
        }

        public static String reportVersionName() {
            return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getReportVersionName();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class _BaseResp {

        /* compiled from: P */
        /* loaded from: classes4.dex */
        public static class ErrCode {
            public static int ERR_AUTH_DENIED() {
                return ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).ERR_AUTH_DENIED();
            }

            public static int ERR_OK() {
                return ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).ERR_OK();
            }

            public static int ERR_USER_CANCEL() {
                return ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).ERR_USER_CANCEL();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class _BigBrotherSource {
        public static String KEY() {
            return "big_brother_source_key";
        }

        public static String SRC_JC_WEZONE() {
            return "biz_src_jc_wezone";
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class _ChatActivityConstants {
        public static int FORWARD_REQUEST() {
            return ((IChatActivityApi) QRoute.api(IChatActivityApi.class)).FORWARD_REQUEST();
        }

        public static String KEY_AIO_MSG_SOURCE() {
            return ((IChatActivityApi) QRoute.api(IChatActivityApi.class)).KEY_AIO_MSG_SOURCE();
        }

        public static String OPEN_CHAT_FRAGMENT() {
            return ((IChatActivityApi) QRoute.api(IChatActivityApi.class)).OPEN_CHAT_FRAGMENT();
        }

        public static int TYPE_DETAIL_MSG_REMIND() {
            return ((IChatActivityApi) QRoute.api(IChatActivityApi.class)).TYPE_DETAIL_MSG_REMIND();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class _ForwardRecentActivity {
        public static String KEY_DIRECT_SHOW_UIN() {
            return ((IForwardApi) QRoute.api(IForwardApi.class)).KEY_DIRECT_SHOW_UIN();
        }

        public static String KEY_DIRECT_SHOW_UIN_TYPE() {
            return ((IForwardApi) QRoute.api(IForwardApi.class)).KEY_DIRECT_SHOW_UIN_TYPE();
        }

        public static String KEY_FORWARD_TITLE() {
            return ((IForwardApi) QRoute.api(IForwardApi.class)).keyForwardTitle();
        }

        public static String KEY_IS_SHOW_RECENT_CHAT_LIST() {
            return ((IForwardApi) QRoute.api(IForwardApi.class)).keyIsShowRecentChatList();
        }

        public static String KEY_IS_SHOW_RECENT_FORWARD_LIST() {
            return ((IForwardApi) QRoute.api(IForwardApi.class)).keyIsShowRecentForwardList();
        }

        public static String KEY_REQ() {
            return ((IForwardApi) QRoute.api(IForwardApi.class)).KEY_REQ();
        }

        public static String KEY_SELECTION_MODE() {
            return ((IForwardApi) QRoute.api(IForwardApi.class)).SELECTION_MODE();
        }

        public static int REQ_DIRECT_SHOW_DIALOG() {
            return ((IForwardApi) QRoute.api(IForwardApi.class)).REQ_DIRECT_SHOW_DIALOG();
        }

        public static int SELECTION_MODE_MULTI() {
            return ((IForwardApi) QRoute.api(IForwardApi.class)).SELECTION_MODE_MULTI();
        }

        public static String keyDirectShowMsg() {
            return ((IForwardApi) QRoute.api(IForwardApi.class)).keyDirectShowMsg();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class _InvitationWebViewPlugin {
        public static String AUTHORITY_ACTION() {
            return "com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify";
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class _SceneID {
        public static int QQ_CIRCLE_VIDEO() {
            return 126;
        }

        public static int TENCENT_VIDEO_PLAYER() {
            return 137;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class _SendMessageToWX {

        /* compiled from: P */
        /* loaded from: classes4.dex */
        public static class Req {
            public static int WXSceneSession() {
                return ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).WXSceneSession();
            }

            public static int WXSceneTimeline() {
                return ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).WXSceneTimeline();
            }
        }
    }
}
