package com.tencent.qqnt.doutu.api;

import androidx.annotation.IdRes;
import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.doutu.c;
import com.tencent.qqnt.doutu.d;
import com.tencent.qqnt.doutu.g;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import mqq.os.MqqHandler;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes24.dex */
public interface IDoutuService extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public interface a {
        void a(boolean z16);
    }

    boolean allowPreDownloadAfterLogin();

    void bindAIOContext(com.tencent.aio.api.runtime.a aVar, @IdRes int i3);

    void bindDoutuListener(g gVar);

    boolean checkLocalResFiles();

    void clearComboViews();

    void doOnChatDestory();

    void doOnChatOnResume();

    void doOnLogin(boolean z16);

    MqqHandler getDoutuAnimationHandler();

    MqqHandler getDoutuMainHandler();

    void handleCombo(List<d> list, int i3);

    void handleDownRes();

    int handleDui(List<d> list);

    void handleGetDoutuList(boolean z16, List<DoutuData> list);

    void handleGetRecommendPicList(boolean z16, List<DoutuData> list, long j3);

    void handleGetRecommendPicTimeOut(long j3);

    boolean hasInitedChatSession();

    void hideDoutuEmotionLayout();

    void initChatSessionInfo(String str, String str2);

    void interruptAnimation();

    boolean isCurrentAIOContact(String str, String str2);

    boolean isDoutuConfigOpen();

    boolean isDoutuSettingOpen();

    void refreshDoutuEmoData();

    void removeDoutuEmoLayout();

    @Deprecated
    void setApp(AppRuntime appRuntime);

    void setComboShowSwitch(boolean z16);

    void setOnShowStateListener(a aVar);

    void showDoutuEmotionLayout(MqqHandler mqqHandler, c cVar, int i3);

    void updataDoutuConfig(boolean z16, boolean z17, long j3, long j16, long j17, boolean z18, int i3);

    void updateDoutuSetting(boolean z16);
}
