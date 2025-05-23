package com.tencent.gamecenter.wadl.api;

import android.os.Message;
import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.GameNoticeInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes6.dex */
public interface IQQGameNoticeService extends IRuntimeService {
    public static final int EVENT_DO_STEP = 3;
    public static final int EVENT_NET_CHANGE = 2;
    public static final int EVENT_SCREEN_OFF = 4;
    public static final int EVENT_SCREEN_ON = 1;
    public static final int MSG_GAMECENTER_BAR_HIDE = 1134072;
    public static final int MSG_GAMECENTER_BAR_SHOW = 1134071;

    void checkBannerFromResume();

    ArrayList<WadlResult> getNotificationTask();

    boolean hasApkDownloadComplete(String str);

    boolean isShowKeepView();

    void onBindService();

    void onEvent(int i3);

    void onInstallStart(WadlResult wadlResult);

    void onNoticeAdd(GameNoticeInfo gameNoticeInfo);

    void onNoticeDelete(String str);

    void onRequestInstall(String str);

    void onUserCleanNotification();

    void removeFloatWnd();

    void setFloatWndToggle(int i3);

    void showKeepLiveView(long j3);

    void updateGameCenterBar(View view, Message message);
}
