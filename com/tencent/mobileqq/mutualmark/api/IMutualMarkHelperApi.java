package com.tencent.mobileqq.mutualmark.api;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.mutualmark.model.a;
import com.tencent.mobileqq.mutualmark.model.b;
import com.tencent.mobileqq.mutualmark.model.c;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.graytips.action.f;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMutualMarkHelperApi extends QRouteApi {
    public static final String ELEGANT_MUTUAL_MARK = "qq_8928_elegant_mutual_mark";

    void addIntimateElegantPageShowTimes();

    void checkDownloadCartoonResource(AppRuntime appRuntime, String str, String str2);

    f createSpecialCareActionInfo(String str);

    a getBeginnerTipsSetting();

    String getButtonKeyValue(MutualMarkModel mutualMarkModel, MutualMarkModel.Button button);

    b getCardResource(int i3);

    String getCartoonResourcesPath(String str, String str2);

    boolean getDisableInteractiveSwitchLocal();

    String getIconUrlFormat(MutualMarkModel mutualMarkModel);

    HashMap<String, Object> getInteractTagAreaData();

    String getIntimateSpecialCareWording(String str);

    c getLottieDownloadInfo();

    QIPCModule getMutualMarkIpcServer();

    HashMap<String, Object> getPgSwipLeftData();

    HashMap<String, Object> getPgTagDetailData();

    HashMap<String, Object> getPgTagProfileData();

    Class<? extends com.tencent.qqnt.graytips.handler.b> getSpecialCareGrayTipActionHandler();

    int getUnsafeLocalCache(String str);

    boolean isCartoonResourceReady(String str, String str2);

    boolean isElegantVersion();

    boolean isFirstTime();

    boolean isIntimateType(long j3);

    boolean isNewIcon(boolean z16, String str, MutualMarkModel mutualMarkModel);

    boolean isNewerGuideMode();

    void jumpUrl(Context context, String str);

    void launchDataPage(Context context);

    void launchDemoPage(Context context);

    void registerIpcClient();

    void reportImpl(MutualMarkModel mutualMarkModel, String str);

    void reportItemEvent(String str, String str2, String str3, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2);

    void reportPageEvent(String str, String str2, HashMap<String, Object> hashMap);

    void requestIntimateInfo(String str);

    void restoreInteractTagAreaData(HashMap<String, Object> hashMap);

    void restorePgSwipLeftData(HashMap<String, Object> hashMap);

    void restorePgTagDetailData(HashMap<String, Object> hashMap);

    void restoreTagProfile(HashMap<String, Object> hashMap);

    void setDescProgressThresholdTextView(TextView textView, MutualMarkModel mutualMarkModel, int i3);

    void setDescThresholdTextView(TextView textView, MutualMarkModel mutualMarkModel);

    void setIconWithModel(ImageView imageView, MutualMarkModel mutualMarkModel, boolean z16, String str);

    void setProgressIconWithModel(ImageView imageView, MutualMarkModel mutualMarkModel, int i3, String str);

    void setUnsafeLocalCache(String str, int i3);

    void showHalfScreenView(Context context, String str, String str2, String str3, String str4);

    void unregisterIpcClient();

    String upgradeIconUrlToVersion2(String str);

    void writeDisableInteractiveSwitchLocal(boolean z16);
}
