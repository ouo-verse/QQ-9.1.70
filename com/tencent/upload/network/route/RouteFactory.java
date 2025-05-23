package com.tencent.upload.network.route;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.route.ServerRouteTable;
import com.tencent.upload.uinterface.UploadSdkConst;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.UploadLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RouteFactory {
    static IPatchRedirector $redirector_ = null;
    private static final IRouteIPProvider LOG_IP_PROVIDER;
    public static final ServerRouteTable LOG_ROUTE_TABLE;
    private static final IRouteIPProvider OTHER_IP_PROVIDER;
    public static final ServerRouteTable OTHER_ROUTE_EPOLL_TABLE;
    public static final ServerRouteTable OTHER_ROUTE_TABLE;
    public static final ServerRouteTable PICTURE_ROUTE_EPOLL_TABLE;
    public static final ServerRouteTable PICTURE_ROUTE_TABLE;
    private static final IRouteIPProvider PIC_IP_PROVIDER;
    private static final String TAG = "RouteFactory";
    private static final IRouteIPProvider VIDEO_IP_PROVIDER;
    public static final ServerRouteTable VIDEO_ROUTE_EPOLL_TABLE;
    public static final ServerRouteTable VIDEO_ROUTE_TABLE;
    private static DebugServerRoute sDebugServerRoute;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11603);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        IRouteIPProvider iRouteIPProvider = new IRouteIPProvider() { // from class: com.tencent.upload.network.route.RouteFactory.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getBakIps() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (String) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                return UploadGlobalConfig.getConfig().getPhotoBakUrl();
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getHostUrl() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return UploadGlobalConfig.getConfig().getPhotoHostUrl();
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getOptIps() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return UploadGlobalConfig.getConfig().getPhotoOptUrl();
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public ServerRouteTable.PriorityPolicy getPriorityPolicy() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return (ServerRouteTable.PriorityPolicy) iPatchRedirector.redirect((short) 7, (Object) this);
                }
                return ServerRouteTable.PriorityPolicy.IPV6_FIRST;
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getV6HostUrl() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (String) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                return UploadGlobalConfig.getConfig().getPhotoHostUrlV6();
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getV6OptIps() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return (String) iPatchRedirector.redirect((short) 6, (Object) this);
                }
                return UploadGlobalConfig.getConfig().getPhotoOptUrlV6();
            }
        };
        PIC_IP_PROVIDER = iRouteIPProvider;
        IRouteIPProvider iRouteIPProvider2 = new IRouteIPProvider() { // from class: com.tencent.upload.network.route.RouteFactory.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getBakIps() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (String) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                return UploadGlobalConfig.getConfig().getVideoBakUrl();
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getHostUrl() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return UploadGlobalConfig.getConfig().getVideoHostUrl();
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getOptIps() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return UploadGlobalConfig.getConfig().getVideoOptUrl();
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public ServerRouteTable.PriorityPolicy getPriorityPolicy() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return (ServerRouteTable.PriorityPolicy) iPatchRedirector.redirect((short) 7, (Object) this);
                }
                return ServerRouteTable.PriorityPolicy.IPV6_FIRST;
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getV6HostUrl() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (String) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                return UploadGlobalConfig.getConfig().getVideoHostUrlV6();
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getV6OptIps() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return (String) iPatchRedirector.redirect((short) 6, (Object) this);
                }
                return UploadGlobalConfig.getConfig().getVideoOptUrlV6();
            }
        };
        VIDEO_IP_PROVIDER = iRouteIPProvider2;
        IRouteIPProvider iRouteIPProvider3 = new IRouteIPProvider() { // from class: com.tencent.upload.network.route.RouteFactory.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getBakIps() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (String) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                return UploadGlobalConfig.getConfig().getOtherBakUrl();
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getHostUrl() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return UploadGlobalConfig.getConfig().getOtherHostUrl();
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getOptIps() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return UploadGlobalConfig.getConfig().getOtherOptUrl();
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public ServerRouteTable.PriorityPolicy getPriorityPolicy() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return (ServerRouteTable.PriorityPolicy) iPatchRedirector.redirect((short) 7, (Object) this);
                }
                return ServerRouteTable.PriorityPolicy.IPV6_FIRST;
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getV6HostUrl() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (String) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                return UploadSdkConst.DEFAULT_V6_OTHER_HOST;
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getV6OptIps() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return (String) iPatchRedirector.redirect((short) 6, (Object) this);
                }
                return UploadGlobalConfig.getConfig().getOtherOptUrlV6();
            }
        };
        OTHER_IP_PROVIDER = iRouteIPProvider3;
        IRouteIPProvider iRouteIPProvider4 = new IRouteIPProvider() { // from class: com.tencent.upload.network.route.RouteFactory.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getBakIps() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (String) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                return UploadGlobalConfig.getConfig().getPhotoBakUrl();
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getHostUrl() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return UploadSdkConst.DEFAULT_LOG_HOST;
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getOptIps() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return UploadGlobalConfig.getConfig().getMobileLogUrl();
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public ServerRouteTable.PriorityPolicy getPriorityPolicy() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return (ServerRouteTable.PriorityPolicy) iPatchRedirector.redirect((short) 7, (Object) this);
                }
                return ServerRouteTable.PriorityPolicy.IPV6_FIRST;
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getV6HostUrl() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (String) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                return UploadSdkConst.DEFAULT_V6_LOG_HOST;
            }

            @Override // com.tencent.upload.network.route.IRouteIPProvider
            public String getV6OptIps() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return (String) iPatchRedirector.redirect((short) 6, (Object) this);
                }
                return UploadGlobalConfig.getConfig().getMobileLogUrlV6();
            }
        };
        LOG_IP_PROVIDER = iRouteIPProvider4;
        Const.FileType fileType = Const.FileType.Photo;
        Const.BusinessType businessType = Const.BusinessType.DefaultPhoto;
        Const.ConnectType connectType = Const.ConnectType.Epoll;
        PICTURE_ROUTE_TABLE = new ServerRouteTable(fileType, businessType, connectType, iRouteIPProvider, UploadSdkConst.DEFAULT_PIC_HOST, UploadSdkConst.DEFAULT_PIC_BK_HOST);
        Const.FileType fileType2 = Const.FileType.Video;
        Const.BusinessType businessType2 = Const.BusinessType.DefaultVideo;
        VIDEO_ROUTE_TABLE = new ServerRouteTable(fileType2, businessType2, connectType, iRouteIPProvider2, UploadSdkConst.DEFAULT_VIDEO_HOST, UploadSdkConst.DEFAULT_VIDEO_BK_HOST);
        Const.FileType fileType3 = Const.FileType.Other;
        Const.BusinessType businessType3 = Const.BusinessType.DefaultOther;
        Const.ConnectType connectType2 = Const.ConnectType.Select;
        OTHER_ROUTE_TABLE = new ServerRouteTable(fileType3, businessType3, connectType2, iRouteIPProvider3, UploadSdkConst.DEFAULT_OTHER_HOST, UploadSdkConst.DEFAULT_OTHER_BK_HOST, 1);
        LOG_ROUTE_TABLE = new ServerRouteTable(Const.FileType.Log, Const.BusinessType.DefaultLog, connectType2, iRouteIPProvider4, UploadSdkConst.DEFAULT_LOG_HOST, UploadSdkConst.DEFAULT_LOG_BK_HOST, 1);
        PICTURE_ROUTE_EPOLL_TABLE = new ServerRouteTable(fileType, businessType, connectType, iRouteIPProvider, UploadSdkConst.DEFAULT_PIC_HOST, UploadSdkConst.DEFAULT_PIC_BK_HOST);
        VIDEO_ROUTE_EPOLL_TABLE = new ServerRouteTable(fileType2, businessType2, connectType, iRouteIPProvider2, UploadSdkConst.DEFAULT_VIDEO_HOST, UploadSdkConst.DEFAULT_VIDEO_BK_HOST);
        OTHER_ROUTE_EPOLL_TABLE = new ServerRouteTable(fileType3, businessType3, connectType, iRouteIPProvider3, UploadSdkConst.DEFAULT_OTHER_HOST, UploadSdkConst.DEFAULT_OTHER_BK_HOST, 1);
        sDebugServerRoute = null;
    }

    public RouteFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final IUploadRouteStrategy createRouteStrategy(ServerRouteTable serverRouteTable) {
        if (!UploadGlobalConfig.getConfig().loadAsString(Const.SwitchConfigKey.QQCIRCLE_CHANGE_TEST_SERVER_IP, "").equals("")) {
            String[] split = UploadGlobalConfig.getConfig().loadAsString(Const.SwitchConfigKey.QQCIRCLE_CHANGE_TEST_SERVER_IP, "").split("/");
            DebugServerRoute debugServerRoute = DebugServerRoute.CUSTOM;
            debugServerRoute.setServerIp(split[0]);
            debugServerRoute.setServerPort(Integer.parseInt(split[1]));
            UploadLog.d(TAG, "createRouteStrategy... setDebugServer ip:" + split[0] + " port:" + split[1]);
            setDebugRoute(debugServerRoute);
            return new DebugRouteStrategy();
        }
        if (isDebugEnable()) {
            return new DebugRouteStrategy();
        }
        return new RouteStrategy(serverRouteTable);
    }

    public static UploadRoute getDebugRoute() {
        DebugServerRoute debugServerRoute = sDebugServerRoute;
        if (debugServerRoute == null) {
            return null;
        }
        return debugServerRoute.getUploadRoute();
    }

    public static final List<Integer> getUploadRoutePorts() {
        String[] strArr;
        String uploadPort = UploadGlobalConfig.getConfig().getUploadPort();
        if (uploadPort == null) {
            return UploadConfiguration.DEF_PORTS;
        }
        try {
            strArr = uploadPort.split(",");
        } catch (Exception e16) {
            UploadLog.w(TAG, e16.toString());
            strArr = null;
        }
        if (strArr == null) {
            return UploadConfiguration.DEF_PORTS;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        try {
            for (String str : strArr) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str)));
            }
            return arrayList;
        } catch (Exception e17) {
            UploadLog.w(TAG, e17.toString());
            return UploadConfiguration.DEF_PORTS;
        }
    }

    public static boolean isDebugEnable() {
        if (sDebugServerRoute != null) {
            return true;
        }
        return false;
    }

    public static void setDebugRoute(DebugServerRoute debugServerRoute) {
        sDebugServerRoute = debugServerRoute;
    }
}
