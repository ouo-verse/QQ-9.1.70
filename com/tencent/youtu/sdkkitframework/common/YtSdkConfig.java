package com.tencent.youtu.sdkkitframework.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YtSdkConfig {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ActionDetectConfig {
        static IPatchRedirector $redirector_;
        public static String actionSeqData;

        public ActionDetectConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class CommonConfig {
        static IPatchRedirector $redirector_;
        public static int screenOrientation;
        public static int threadPriority;

        public CommonConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class FaceDetectConfig {
        static IPatchRedirector $redirector_;

        public FaceDetectConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class FaceQualityConfig {
        static IPatchRedirector $redirector_;

        public FaceQualityConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class NetFetch {
        static IPatchRedirector $redirector_ = null;
        public static String appId = null;
        public static int backendProtoType = 0;
        public static int changePointNum = 2;
        public static String configUrl;
        public static String controlConfig;
        public static String extraConfig;
        public static boolean needActionlLocalConfig;
        public static boolean needBuglyShared;
        public static boolean needLocalConfig;
        public static int netRequestTimeoutMS;
        public static String resourceDownloadPath;
        public static boolean resourceOnline;
        public static JSONObject selectData;

        public NetFetch() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ReflectConfig {
        static IPatchRedirector $redirector_;
        public static String colorData;

        public ReflectConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public YtSdkConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public int updateSDKConfig(YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) ytSDKKitFrameworkWorkMode, (Object) jSONObject)).intValue();
        }
        try {
            if (jSONObject.has("app_id")) {
                NetFetch.appId = jSONObject.getString("app_id");
            }
            if (jSONObject.has("config_api_url")) {
                NetFetch.configUrl = jSONObject.getString("config_api_url");
            }
            if (jSONObject.has("color_data")) {
                ReflectConfig.colorData = jSONObject.getString("color_data");
            }
            if (jSONObject.has("local_config_flag")) {
                NetFetch.needLocalConfig = jSONObject.getBoolean("local_config_flag");
            }
            if (jSONObject.has("action_default_seq")) {
                JSONArray jSONArray = jSONObject.getJSONArray("action_default_seq");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    ActionDetectConfig.actionSeqData += jSONArray.getString(i3);
                    if (i3 < jSONArray.length() - 1) {
                        ActionDetectConfig.actionSeqData += ",";
                    }
                }
            } else {
                ActionDetectConfig.actionSeqData = "0";
            }
            if (jSONObject.has("extra_config")) {
                NetFetch.extraConfig = jSONObject.getString("extra_config");
            } else {
                NetFetch.extraConfig = " version 2";
            }
            if (jSONObject.has("control_config")) {
                NetFetch.controlConfig = jSONObject.getString("control_config");
            }
            if (jSONObject.has("change_point_num")) {
                NetFetch.changePointNum = jSONObject.getInt("change_point_num");
            }
            if (jSONObject.has("select_data")) {
                NetFetch.selectData = jSONObject.getJSONObject("select_data");
            }
            if (jSONObject.has("backend_proto_type")) {
                NetFetch.backendProtoType = jSONObject.getInt("backend_proto_type");
            }
            if (jSONObject.has("net_request_timeout_ms")) {
                NetFetch.netRequestTimeoutMS = jSONObject.getInt("net_request_timeout_ms");
            }
            if (jSONObject.has("net_request_timeout_ms")) {
                NetFetch.needActionlLocalConfig = jSONObject.getBoolean("action_local_config_flag");
            }
            if (jSONObject.has("resource_online")) {
                NetFetch.resourceOnline = jSONObject.getBoolean("resource_online");
            }
            if (jSONObject.has("resource_download_path")) {
                NetFetch.resourceDownloadPath = jSONObject.getString("resource_download_path");
            }
            if (jSONObject.has("need_bugly_shared")) {
                NetFetch.needBuglyShared = jSONObject.getBoolean("need_bugly_shared");
            }
            if (jSONObject.has("screen_orientation")) {
                CommonConfig.screenOrientation = jSONObject.getInt("screen_orientation");
            }
            if (jSONObject.has("thread_priority")) {
                CommonConfig.threadPriority = jSONObject.getInt("thread_priority");
            }
            return 0;
        } catch (Exception unused) {
            return -1;
        }
    }
}
