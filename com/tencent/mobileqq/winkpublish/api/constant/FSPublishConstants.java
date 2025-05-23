package com.tencent.mobileqq.winkpublish.api.constant;

import com.tencent.mobileqq.qroute.annotation.PluginInterface;

@PluginInterface
/* loaded from: classes21.dex */
public class FSPublishConstants {
    public static final String DISABLE_GROUP_ID = "disableGroupId";
    public static final String DISABLE_GROUP_NAME = "disableGroupName";
    public static final String DISABLE_NICK_NAME = "disableNickName";
    public static final String DISABLE_RIGHT_INFO = "disableRightInfo";
    public static final String DISABLE_UIN_ID = "disableUinId";
    public static final String DISABLE_UIN_NUMBER = "disableUinNumber";
    public static final String PLUGIN_NAME = "qq_winkpublish_impl.apk";
    public static final String PREVIEW_START_POSITION = "previewStartPosition";
    public static final String WINK_PUBLISH_SERVICE_NAME = "com.tencent.mobileqq.winkpublish.service.WinkPublishService";

    /* loaded from: classes21.dex */
    public static class FSPublishBroadcast {
        public static final String ACTION_USER_PUBLISH_DISABLE_INFO = "ACTION_USER_PUBLISH_DISABLE_INFO";

        public FSPublishBroadcast() {
            throw new RuntimeException("stub");
        }
    }

    /* loaded from: classes21.dex */
    public static class FSPublishJsBridge {
        public static final String JSON_OBJECT_KEY_GROUP_ID = "groupid";
        public static final String JSON_OBJECT_KEY_GROUP_NAME = "groupname";
        public static final String JSON_OBJECT_KEY_NICK_NAME = "nickname";
        public static final String JSON_OBJECT_KEY_UIN_LIST = "uinlist";
        public static final String JSON_OBJECT_KEY_UIN_NUMBER = "uinnumber";
        public static final String JS_PLUGIN_ACTION_GET_RIGHT_INFO = "getRightInfo";
        public static final String JS_PLUGIN_ACTION_SET_RIGHT_INFO = "setRightInfo";
    }
}
