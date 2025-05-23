package com.tencent.mobileqq.mini.utils;

import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppWnsConfig {
    public static final int DEFAULT_KEY_MINI_APP_ENABLE_PRELOAD = 1;
    public static final int DEFAULT_KEY_MINI_APP_MIN_TBS_VERSION = 0;
    public static final String DEFAULT_KEY_MINI_APP_SHOW_TEENAGER_MODEL_DESCRIPTION = "\u672a\u6210\u5e74\u4eba\u6a21\u5f0f\u4e0b\u90e8\u5206\u5185\u5bb9\u65e0\u6cd5\u5c55\u793a\u6216\u641c\u7d22";
    public static final String DEFAULT_KEY_MINI_APP_SHOW_TEENAGER_MODEL_IMAGE = "https://pub.idqqimg.com/pc/misc/files/20210831/c6a9f3b036904173a5e7413c4b3cd80b.png";
    public static final int DEFAULT_KEY_MINI_APP_TEENAGER_MODEL_CLOSED = 0;
    public static final String DEFAULT_KEY_MINI_APP_URL_DIRECT_OPEN = "1109259897";
    public static final String SECONDARY_KEY_MINI_APP_ENABLE_PRELOAD = "miniappenablepreload";
    public static final String SECONDARY_KEY_MINI_APP_MIN_TBS_VERSION = "miniappmintbsversion";
    public static final String SECONDARY_KEY_MINI_APP_SHOW_TEENAGER_MODEL_DESCRIPTION = "miniappshowteenagermodeldescription";
    public static final String SECONDARY_KEY_MINI_APP_SHOW_TEENAGER_MODEL_IMAGE = "miniappshowteenagermodelimage";
    public static final String SECONDARY_KEY_MINI_APP_TEENAGER_MODEL_CLOSED = "miniappshowteenagermodelclosed";
    public static final String SECONDARY_KEY_MINI_APP_URL_DIRECT_OPEN = "urlDirectOpenMiniAppWhiteList";

    public static boolean enableMiniAppPreload() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", SECONDARY_KEY_MINI_APP_ENABLE_PRELOAD, 1) > 0;
    }

    public static int getMiniAppMinTbsVersion() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", SECONDARY_KEY_MINI_APP_MIN_TBS_VERSION, 0);
    }

    public static String getMiniDesktopTeenModelDesc() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", SECONDARY_KEY_MINI_APP_SHOW_TEENAGER_MODEL_DESCRIPTION, DEFAULT_KEY_MINI_APP_SHOW_TEENAGER_MODEL_DESCRIPTION);
    }

    public static String getMiniDesktopTeenModelEmptyImage() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", SECONDARY_KEY_MINI_APP_SHOW_TEENAGER_MODEL_IMAGE, DEFAULT_KEY_MINI_APP_SHOW_TEENAGER_MODEL_IMAGE);
    }

    public static boolean isMiniDesktopTeenModelClosed() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", SECONDARY_KEY_MINI_APP_TEENAGER_MODEL_CLOSED, 0) > 0;
    }

    public static String urlDirectOpenMiniAppWhiteList() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", SECONDARY_KEY_MINI_APP_URL_DIRECT_OPEN, DEFAULT_KEY_MINI_APP_URL_DIRECT_OPEN);
    }
}
