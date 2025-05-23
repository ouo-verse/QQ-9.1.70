package com.tencent.upload.uinterface;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.upload.network.route.RouteFactory;
import com.tencent.upload.network.route.ServerRouteTable;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TaskTypeConfig {
    static IPatchRedirector $redirector_;
    public static final TaskTypeConfig AirVideoUploadTaskType;
    public static final TaskTypeConfig AudioStreamUploadTaskType;
    public static final TaskTypeConfig AudioUploadTaskType;
    public static final TaskTypeConfig BatchCommitUploadType;
    public static final TaskTypeConfig GuildImageUploadTaskType;
    public static final TaskTypeConfig GuildVideoUploadTaskType;
    public static final TaskTypeConfig HeadUploadTaskType;
    public static final TaskTypeConfig ImageUploadTaskType;
    public static final TaskTypeConfig LiveVideoUploadTaskType;
    public static final TaskTypeConfig LoverImageUploadTaskType;
    public static final TaskTypeConfig MobileLogUploadTaskType;
    public static final TaskTypeConfig NewQunUploadTaskType;
    public static final TaskTypeConfig PhotoWallUploadTaskType;
    public static final TaskTypeConfig QcircleImageUploadTaskType;
    public static final TaskTypeConfig QcircleVideoExportUploadTaskType;
    public static final TaskTypeConfig QcircleVideoUploadTaskType;
    public static final TaskTypeConfig QunUploadTaskType;
    public static final TaskTypeConfig UppUploadTaskType;
    public static final TaskTypeConfig UpsUploadEpollTaskType;
    public static final TaskTypeConfig UpsUploadTaskType;
    public static final TaskTypeConfig VideoUploadTaskType;
    public static final TaskTypeConfig ZipUploadTaskType;
    public final ServerRouteTable serverRouteTable;
    public final int uploadType;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14110);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ServerRouteTable serverRouteTable = RouteFactory.OTHER_ROUTE_TABLE;
        AudioStreamUploadTaskType = new TaskTypeConfig(39, serverRouteTable);
        AudioUploadTaskType = new TaskTypeConfig(2, serverRouteTable);
        ServerRouteTable serverRouteTable2 = RouteFactory.PICTURE_ROUTE_TABLE;
        BatchCommitUploadType = new TaskTypeConfig(0, serverRouteTable2);
        HeadUploadTaskType = new TaskTypeConfig(3, serverRouteTable);
        ImageUploadTaskType = new TaskTypeConfig(0, serverRouteTable2);
        ServerRouteTable serverRouteTable3 = RouteFactory.VIDEO_ROUTE_TABLE;
        LiveVideoUploadTaskType = new TaskTypeConfig(37, serverRouteTable3);
        AirVideoUploadTaskType = new TaskTypeConfig(37, serverRouteTable);
        LoverImageUploadTaskType = new TaskTypeConfig(6, serverRouteTable);
        MobileLogUploadTaskType = new TaskTypeConfig(36, RouteFactory.LOG_ROUTE_TABLE);
        NewQunUploadTaskType = new TaskTypeConfig(22, serverRouteTable2);
        PhotoWallUploadTaskType = new TaskTypeConfig(17, serverRouteTable);
        QunUploadTaskType = new TaskTypeConfig(12, serverRouteTable);
        UppUploadTaskType = new TaskTypeConfig(4, serverRouteTable);
        UpsUploadTaskType = new TaskTypeConfig(13, serverRouteTable);
        VideoUploadTaskType = new TaskTypeConfig(1, serverRouteTable3);
        ZipUploadTaskType = new TaskTypeConfig(32, serverRouteTable);
        ServerRouteTable serverRouteTable4 = RouteFactory.VIDEO_ROUTE_EPOLL_TABLE;
        QcircleVideoUploadTaskType = new TaskTypeConfig(1, serverRouteTable4);
        ServerRouteTable serverRouteTable5 = RouteFactory.PICTURE_ROUTE_EPOLL_TABLE;
        QcircleImageUploadTaskType = new TaskTypeConfig(0, serverRouteTable5);
        GuildVideoUploadTaskType = new TaskTypeConfig(1, serverRouteTable4);
        GuildImageUploadTaskType = new TaskTypeConfig(0, serverRouteTable5);
        QcircleVideoExportUploadTaskType = new TaskTypeConfig(1, serverRouteTable4);
        UpsUploadEpollTaskType = new TaskTypeConfig(13, RouteFactory.OTHER_ROUTE_EPOLL_TABLE);
    }

    public TaskTypeConfig(int i3, ServerRouteTable serverRouteTable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) serverRouteTable);
        } else {
            this.uploadType = i3;
            this.serverRouteTable = serverRouteTable;
        }
    }
}
