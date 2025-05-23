package com.tencent.common.app;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi;
import com.tencent.mobileqq.intervideo.groupvideo.TroopHomeWorkAppInterface;
import com.tencent.mobileqq.microapp.MiniAppInterface;
import com.tencent.mobileqq.mini.api.QQMiniManager;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.relation.app.QQStrangerAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.weiyun.api.IWeiyunHelper;
import com.tencent.mobileqq.wxmini.api.IWxRuntimeApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxService;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.groupvideo.api.IGroupVideoHelper;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.troop.NearbyVideoChatProxyActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static AppRuntime a(BaseApplicationImpl baseApplicationImpl, String str) {
        AppRuntime appRuntime;
        String str2;
        String packageName = baseApplicationImpl.getPackageName();
        if (QLog.isColorLevel()) {
            QLog.d("AppInterfaceFactory", 2, "getAppRuntime processname=", str, " package=", packageName);
        }
        if (packageName.equals(str)) {
            appRuntime = new QQAppInterface(baseApplicationImpl, str);
        } else {
            if (!str.equals(packageName + ":" + ProcessConstant.MSF)) {
                if (!str.equals(packageName + ":" + ProcessConstant.NOTIFYPUSH)) {
                    if (str.equals(packageName + ":video")) {
                        appRuntime = new VideoAppInterface(baseApplicationImpl, "video");
                    } else {
                        if (str.equals(packageName + ":qzone")) {
                            AppRuntime createQZoneMainRuntime = QZoneHelper.createQZoneMainRuntime(baseApplicationImpl, "qzone");
                            appRuntime = createQZoneMainRuntime;
                            if (createQZoneMainRuntime != null) {
                                createQZoneMainRuntime.setAsToolRuntime();
                                appRuntime = createQZoneMainRuntime;
                            }
                        } else {
                            if (str.equals(packageName + ":picture")) {
                                appRuntime = QZoneHelper.createQZonePictureAppInterface(baseApplicationImpl, "picture");
                            } else {
                                if (str.equals(packageName + ":" + ProcessConstant.OPEN_SDK)) {
                                    appRuntime = new OpenSDKAppInterface(baseApplicationImpl, ProcessConstant.OPEN_SDK);
                                } else {
                                    if (str.equals(packageName + ":" + ProcessConstant.PHOTOEDIT)) {
                                        PluginRuntime pluginRuntime = new PluginRuntime();
                                        ReportController.c(pluginRuntime);
                                        appRuntime = pluginRuntime;
                                    } else {
                                        if (str.equals(packageName + ":" + ProcessConstant.ZEBRA)) {
                                            appRuntime = new PluginRuntime();
                                        } else {
                                            if (str.equals(packageName + ":" + ProcessConstant.DEMOJI)) {
                                                PluginRuntime pluginRuntime2 = new PluginRuntime();
                                                ReportController.c(pluginRuntime2);
                                                appRuntime = pluginRuntime2;
                                            } else {
                                                if (str.equals(packageName + ":map")) {
                                                    appRuntime = new QQMapActivity.MapRuntime();
                                                } else {
                                                    if (str.equals(packageName + ":weiyun")) {
                                                        PluginRuntime createRuntime = ((IWeiyunHelper) QRoute.api(IWeiyunHelper.class)).createRuntime(baseApplicationImpl);
                                                        if (createRuntime != null) {
                                                            ReportController.c(createRuntime);
                                                            appRuntime = createRuntime;
                                                        } else {
                                                            QLog.e("AppInterfaceFactory", 1, "WeiyunHelper.createRuntime return null!");
                                                            appRuntime = createRuntime;
                                                        }
                                                    } else {
                                                        if (str.equals(packageName + ":qwallet")) {
                                                            appRuntime = ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).createQWalletAppInterface(baseApplicationImpl, "qwallet");
                                                        } else {
                                                            if (str.equals(packageName + ":" + ProcessConstant.QQWADL)) {
                                                                appRuntime = ((IQQGameCommApi) QRoute.api(IQQGameCommApi.class)).createAppRuntime(baseApplicationImpl, ProcessConstant.QQWADL);
                                                            } else {
                                                                if (str.equals(packageName + ":" + ProcessConstant.QQFAV)) {
                                                                    appRuntime = QfavHelper.f(baseApplicationImpl);
                                                                } else {
                                                                    if (str.equals(packageName + ":qlink")) {
                                                                        appRuntime = cooperation.qlink.b.a(baseApplicationImpl, "qlink");
                                                                    } else {
                                                                        if (str.equals(packageName + ":miniapp")) {
                                                                            appRuntime = new MiniAppInterface(baseApplicationImpl, "miniapp");
                                                                        } else {
                                                                            StringBuilder sb5 = new StringBuilder();
                                                                            sb5.append(packageName);
                                                                            sb5.append(":");
                                                                            String str3 = "mini";
                                                                            sb5.append("mini");
                                                                            if (!str.equals(sb5.toString())) {
                                                                                if (!str.equals(packageName + ":" + ProcessConstant.MINI_1)) {
                                                                                    if (!str.equals(packageName + ":" + ProcessConstant.MINI_2)) {
                                                                                        if (!str.equals(packageName + ":" + ProcessConstant.MINI_3)) {
                                                                                            if (!str.equals(packageName + ":" + ProcessConstant.MINI_4)) {
                                                                                                if (!str.equals(packageName + ":" + ProcessConstant.MINI_5)) {
                                                                                                    if (!str.equals(packageName + ":" + ProcessConstant.MINI_6)) {
                                                                                                        if (!str.equals(packageName + ":" + ProcessConstant.MINI_7)) {
                                                                                                            if (!str.equals(packageName + ":" + ProcessConstant.UNITY_0)) {
                                                                                                                if (!str.equals(packageName + ":" + ProcessConstant.UNITY_1)) {
                                                                                                                    if (!str.equals(packageName + ":" + ProcessConstant.MINI_INTERNAL)) {
                                                                                                                        StringBuilder sb6 = new StringBuilder();
                                                                                                                        sb6.append(packageName);
                                                                                                                        sb6.append(":");
                                                                                                                        String str4 = ProcessConstant.MINI_BOX_CORE;
                                                                                                                        sb6.append(ProcessConstant.MINI_BOX_CORE);
                                                                                                                        if (!str.equals(sb6.toString())) {
                                                                                                                            if (!str.equals(packageName + ":" + ProcessConstant.MINI_BOX_P00)) {
                                                                                                                                if (!str.equals(packageName + ":" + ProcessConstant.MINI_BOX_P01)) {
                                                                                                                                    if (!str.equals(packageName + ":" + ProcessConstant.MINI_BOX_P02)) {
                                                                                                                                        if (!str.equals(packageName + ":" + ProcessConstant.MINI_BOX_P03)) {
                                                                                                                                            if (!str.equals(packageName + ":" + ProcessConstant.MINI_BOX_P04)) {
                                                                                                                                                if (!str.equals(packageName + ":" + ProcessConstant.MINI_BOX_P05)) {
                                                                                                                                                    if (!str.equals(packageName + ":" + ProcessConstant.WXA_CONTAINER_0)) {
                                                                                                                                                        if (!str.equals(packageName + ":" + ProcessConstant.WXA_CONTAINER_1)) {
                                                                                                                                                            if (!str.equals(packageName + ":" + ProcessConstant.WXA_CONTAINER_2)) {
                                                                                                                                                                if (!str.equals(packageName + ":" + ProcessConstant.WXA_CONTAINER_3)) {
                                                                                                                                                                    if (!str.equals(packageName + ":" + ProcessConstant.WXA_CONTAINER_4)) {
                                                                                                                                                                        if (str.equals(packageName + ":zplan")) {
                                                                                                                                                                            appRuntime = ((IZPlanApi) QRoute.api(IZPlanApi.class)).createZplanAppInterface(baseApplicationImpl, "zplan");
                                                                                                                                                                        } else {
                                                                                                                                                                            if (!str.equals(packageName + ":" + ProcessConstant.QQWIFI)) {
                                                                                                                                                                                if (!str.equals(packageName + ":" + ProcessConstant.QQWIFIDITU)) {
                                                                                                                                                                                    if (str.equals(packageName + ":dataline")) {
                                                                                                                                                                                        appRuntime = cooperation.qqdataline.a.a(baseApplicationImpl, "dataline");
                                                                                                                                                                                    } else {
                                                                                                                                                                                        if (!str.equals(packageName + ":" + ProcessConstant.READINJOY)) {
                                                                                                                                                                                            if (str.equals(packageName + ":" + ProcessConstant.GROUPVIDEO)) {
                                                                                                                                                                                                appRuntime = ((IGroupVideoHelper) QRoute.api(IGroupVideoHelper.class)).createAppInterface(baseApplicationImpl, ProcessConstant.GROUPVIDEO);
                                                                                                                                                                                            } else {
                                                                                                                                                                                                if (str.equals(packageName + ":tool")) {
                                                                                                                                                                                                    ToolAppRuntime toolAppRuntime = new ToolAppRuntime();
                                                                                                                                                                                                    toolAppRuntime.setAsToolRuntime();
                                                                                                                                                                                                    appRuntime = toolAppRuntime;
                                                                                                                                                                                                } else {
                                                                                                                                                                                                    if (str.equals(packageName + ":peak")) {
                                                                                                                                                                                                        ToolRuntimePeak toolRuntimePeak = new ToolRuntimePeak();
                                                                                                                                                                                                        toolRuntimePeak.setAsToolRuntime();
                                                                                                                                                                                                        appRuntime = toolRuntimePeak;
                                                                                                                                                                                                    } else {
                                                                                                                                                                                                        if (str.equals(packageName + ":" + ProcessConstant.NEARBY_VIDEO)) {
                                                                                                                                                                                                            appRuntime = NearbyVideoChatProxyActivity.F2(baseApplicationImpl, ProcessConstant.NEARBY_VIDEO);
                                                                                                                                                                                                        } else {
                                                                                                                                                                                                            if (!str.equals(packageName + ":" + ProcessConstant.AVGAME)) {
                                                                                                                                                                                                                if (str.equals(packageName + ":plugins")) {
                                                                                                                                                                                                                    AppRuntime createAppInterface = ((IYunGameChannelApi) QRoute.api(IYunGameChannelApi.class)).createAppInterface(baseApplicationImpl, "plugins");
                                                                                                                                                                                                                    if (createAppInterface == null) {
                                                                                                                                                                                                                        createAppInterface = new PluginRuntime();
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    AppRuntime appRuntime2 = createAppInterface;
                                                                                                                                                                                                                    appRuntime2.setAsToolRuntime();
                                                                                                                                                                                                                    appRuntime = appRuntime2;
                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                    if (str.equals(packageName + ":qqstranger")) {
                                                                                                                                                                                                                        appRuntime = new QQStrangerAppInterface(baseApplicationImpl, "qqstranger");
                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                        if (str.equals(packageName + ":" + ProcessConstant.TROOPHOMEWORK)) {
                                                                                                                                                                                                                            TroopHomeWorkAppInterface troopHomeWorkAppInterface = new TroopHomeWorkAppInterface();
                                                                                                                                                                                                                            ReportController.c(troopHomeWorkAppInterface);
                                                                                                                                                                                                                            appRuntime = troopHomeWorkAppInterface;
                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                            if (!str.equals(packageName + ":account")) {
                                                                                                                                                                                                                                PluginRuntime pluginRuntime3 = new PluginRuntime();
                                                                                                                                                                                                                                ReportController.c(pluginRuntime3);
                                                                                                                                                                                                                                appRuntime = pluginRuntime3;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    try {
                                                                                                                                                        str2 = str.substring(packageName.length() + 1);
                                                                                                                                                    } catch (Exception e16) {
                                                                                                                                                        QLog.d("AppInterfaceFactory", 1, "handle wxa throw exception,", e16);
                                                                                                                                                        str2 = ProcessConstant.WXA_CONTAINER;
                                                                                                                                                    }
                                                                                                                                                    appRuntime = ((IWxRuntimeApi) QRoute.api(IWxRuntimeApi.class)).createAppInterface(baseApplicationImpl, str2);
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                        try {
                                                                                                                            str4 = str.substring(packageName.length() + 1);
                                                                                                                        } catch (Exception unused) {
                                                                                                                        }
                                                                                                                        appRuntime = ((IMiniBoxService) QRoute.api(IMiniBoxService.class)).createAppInterface(baseApplicationImpl, str4);
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                            try {
                                                                                str3 = str.substring(packageName.length() + 1);
                                                                            } catch (Exception unused2) {
                                                                            }
                                                                            appRuntime = QQMiniManager.createMiniAppInterface(baseApplicationImpl, str3);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            appRuntime = null;
        }
        if (appRuntime != null) {
            String processSuffix = MobileQQ.getProcessSuffix(str, packageName);
            appRuntime.setProcessName(processSuffix);
            if (QLog.isColorLevel()) {
                QLog.d("AppInterfaceFactory", 2, "process ", str, " package ", packageName, " suffix ", processSuffix + " " + appRuntime.getClass().getSimpleName());
            }
        }
        return appRuntime;
    }
}
