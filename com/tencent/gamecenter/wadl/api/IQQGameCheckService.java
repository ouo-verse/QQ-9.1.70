package com.tencent.gamecenter.wadl.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;
import tencent.im.qqgame.QQGameAutoDownloadTask$PreDownloadInfo;
import tencent.im.qqgame.QQGameAutoUpdateTask$PreUpdateInfo;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes6.dex */
public interface IQQGameCheckService extends IRuntimeService {
    public static final int CHECK_GAMECENTER_NETWORK_STATUS_CHANGE = 2;
    public static final int CHECK_GAMECENTER_NORMAL = 0;
    public static final int CHECK_GAMECENTER_PUSH = 4;
    public static final int CHECK_GAMECENTER_QQ_FOREGROUND = 5;
    public static final int CHECK_GAMECENTER_SCREEN_STATUS_CHANGE = 1;
    public static final int CHECK_GAMECENTER_TGPA_PUSH = 3;

    void checkGameCenter(int i3);

    void handleKeepLivePush(String str);

    void handlePreDownloadList(List<QQGameAutoDownloadTask$PreDownloadInfo> list);

    void handlePreDownloadPush(String str, String str2);

    void handlePreImitatePush(String str);

    void handlePreUpdateList(List<QQGameAutoUpdateTask$PreUpdateInfo> list);

    void handlePreUpdatePush(String str, String str2);

    void handlePreloadPush(String str);

    boolean hasAppointTask();

    void onSendDownloadRequest(WadlParams wadlParams);
}
