package com.tencent.mobileqq.mini.out.nativePlugins.foundation;

import com.tencent.mobileqq.mini.out.nativePlugins.DeviceInfoPlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.GroupCheckInUploadPlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.GroupPlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.NowLiveNativePlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.QQPublicAccountNativePlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.QzonePublishPlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.TenDocChannelPlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.TimTeamPlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.WebSsoJsPlugin;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes33.dex */
public class NativePluginManager {
    private static Set<PluginInfo> pluginList;

    /* loaded from: classes33.dex */
    public static class PluginInfo {
        private String api_name;
        private String handlerClass;

        public PluginInfo(String str, String str2) {
            this.api_name = str;
            this.handlerClass = str2;
        }

        public String getApi_name() {
            return this.api_name;
        }

        public String getHandlerClass() {
            return this.handlerClass;
        }

        public void setApi_name(String str) {
            this.api_name = str;
        }

        public void setHandlerClass(String str) {
            this.handlerClass = str;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        pluginList = hashSet;
        hashSet.add(new PluginInfo("uploadAvatar", "com.tencent.mobileqq.mini.out.nativePlugins.SetAvatarNativePlugin"));
        pluginList.add(new PluginInfo("weiyunDownload", "com.tencent.mobileqq.mini.out.nativePlugins.WeiyunDownloadFilePlugin"));
        pluginList.add(new PluginInfo("refreshQzoneFeed", "com.tencent.mobileqq.mini.out.nativePlugins.RefreshQzoneFeedPlugin"));
        pluginList.add(new PluginInfo(GroupPlugin.GROUP_GETMULTIMEMLIST, "com.tencent.mobileqq.mini.out.nativePlugins.GroupPlugin"));
        pluginList.add(new PluginInfo(WebSsoJsPlugin.EVENT_QUERY_WEBSSO, "com.tencent.mobileqq.mini.out.nativePlugins.WebSsoJsPlugin"));
        pluginList.add(new PluginInfo(QzonePublishPlugin.API_NAVIGATE_TO_PUBLISH_PROGRAM, "com.tencent.mobileqq.mini.out.nativePlugins.QzonePublishPlugin"));
        pluginList.add(new PluginInfo(GroupCheckInUploadPlugin.PLUGIN_NAME, "com.tencent.mobileqq.mini.out.nativePlugins.GroupCheckInUploadPlugin"));
        initTroopAlbumPlugin();
        pluginList.add(new PluginInfo(TenDocChannelPlugin.PLUGIN_NAME, "com.tencent.mobileqq.mini.out.nativePlugins.TenDocChannelPlugin"));
        pluginList.add(new PluginInfo(TenpayPlugin.PLUGIN_NAME, "com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin"));
        pluginList.add(new PluginInfo(TenpayPlugin.PLUGIN_NAME_QWALLETBRIDGE, "com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin"));
        initQQPublicAccountPlugin();
        pluginList.add(new PluginInfo(TimTeamPlugin.PLUGIN_NAME, "com.tencent.mobileqq.mini.out.nativePlugins.TimTeamPlugin"));
        pluginList.add(new PluginInfo(DeviceInfoPlugin.API_GET_GUID, "com.tencent.mobileqq.mini.out.nativePlugins.DeviceInfoPlugin"));
        pluginList.add(new PluginInfo(SmsPlugin.API_SEND_SMS, "com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin"));
        pluginList.add(new PluginInfo(NowLiveNativePlugin.PLUGIN_NAME, "com.tencent.mobileqq.mini.out.nativePlugins.NowLiveNativePlugin"));
        pluginList.add(new PluginInfo("freeTrafficCardModel", "com.tencent.mobileqq.mini.out.nativePlugins.TreasureCardMiniJsPlugin"));
    }

    public static Set<PluginInfo> getPluginInfo() {
        return pluginList;
    }

    private static void initQQPublicAccountPlugin() {
        pluginList.add(new PluginInfo(QQPublicAccountNativePlugin.API_QSUBSCRIBE_OPEN_DISCOVER, "com.tencent.mobileqq.mini.out.nativePlugins.QQPublicAccountNativePlugin"));
        pluginList.add(new PluginInfo(QQPublicAccountNativePlugin.API_QSUBSCRIBE_OPEN_DETAIL, "com.tencent.mobileqq.mini.out.nativePlugins.QQPublicAccountNativePlugin"));
        pluginList.add(new PluginInfo(QQPublicAccountNativePlugin.API_QSUBSCRIBE_OPEN_HOMEPAGE, "com.tencent.mobileqq.mini.out.nativePlugins.QQPublicAccountNativePlugin"));
        pluginList.add(new PluginInfo(QQPublicAccountNativePlugin.API_OSUBSCRIBE_GET_DEVICE_INFO, "com.tencent.mobileqq.mini.out.nativePlugins.QQPublicAccountNativePlugin"));
    }

    private static void initTroopAlbumPlugin() {
        pluginList.add(new PluginInfo(TroopAlbumPlugin.GROUP_UPLOAD_PHOTO, "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
        pluginList.add(new PluginInfo(TroopAlbumPlugin.OPEN_USER_QZONE_HOME, "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
        pluginList.add(new PluginInfo(TroopAlbumPlugin.IMPORT_GROUP_AIO, "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
        pluginList.add(new PluginInfo(TroopAlbumPlugin.SHOW_GROUP_PHOTO_BROWSER, "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
        pluginList.add(new PluginInfo(TroopAlbumPlugin.JUMP_GROUP_ALBUM_SEND_BOX, "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
        pluginList.add(new PluginInfo(TroopAlbumPlugin.DOWNLOAD_GROUP_ALBUM_PHOTO, "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
        pluginList.add(new PluginInfo(TroopAlbumPlugin.JUMP_CATEGORY_ALBUM, "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
        pluginList.add(new PluginInfo(TroopAlbumPlugin.PICK_QZONE_ALBUM, "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
        pluginList.add(new PluginInfo(TroopAlbumPlugin.QZONE_ALBUM_START, "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
    }
}
