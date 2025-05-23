package com.tencent.mobileqq.leba;

import androidx.annotation.IntRange;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ILebaUIStyleSettingApi extends QRouteApi {
    boolean checkModeSupportQzoneFrame();

    @IntRange(from = 0, to = 2)
    int getLebaStyleUserSetting();

    void openStyleSetting(QBaseActivity qBaseActivity);

    void setFrameFragment(FrameFragment frameFragment);

    void setLebaStyleUserSetting(int i3);

    void setNeedShowQZoneFrame(boolean z16);

    void setQZoneFrameClass(String str);
}
