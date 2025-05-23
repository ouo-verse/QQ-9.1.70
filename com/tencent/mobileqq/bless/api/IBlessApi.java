package com.tencent.mobileqq.bless.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes11.dex */
public interface IBlessApi extends QRouteApi {
    void clearEditingWordings(AppInterface appInterface);

    void clearUinListToSend(AppInterface appInterface);

    Object createShortVideoUploadInfo(Object obj, Object obj2);

    int getAvailableSendCount(AppInterface appInterface);

    int getAvailableUinCount(AppInterface appInterface);

    int getBlessManager_TYPE_PIC_Value();

    int getBlessManager_TYPE_PTV_Value();

    int getBlessManager_TYPE_TEXT_Value();

    int getBlessManager_TYPE_UNKNOW_Value();

    int getBlessManager_UPDATE_MSGTAB_NUM_Value();

    Object getBlessReportParams(AppInterface appInterface, int i3, int i16);

    void getEncodeQualityParamForSendTask(Intent intent);

    Object getPtvMessage(AppInterface appInterface);

    String getPtvUrlByUuid(AppInterface appInterface, String str, String str2);

    int getSVBusiUtil_BUSI_TYPE_SHORTVIDEO_PTV_Value();

    int getTotalSendLimit(AppInterface appInterface);

    int getTotalUinLimit(AppInterface appInterface);

    ArrayList<String> getUinListToSend(AppInterface appInterface);

    int getWebAvailableSendCount(AppInterface appInterface);

    int getWebAvailableUinCount(AppInterface appInterface);

    int getWebTotalSendLimit(AppInterface appInterface);

    int getWebTotalUinLimit(AppInterface appInterface);

    void gotoSplashActivity(Activity activity, boolean z16);

    boolean isSearchable(AppInterface appInterface);

    boolean isUinBlessed(AppInterface appInterface, String str);

    boolean isUinListToSendChangedOnMem(AppInterface appInterface);

    boolean isVideoSoLibLoaded();

    boolean isWebUinSended(AppInterface appInterface, String str);

    void launchForShortVideoBusiManager(Object obj, AppInterface appInterface);

    void loadShortVideoSo(AppInterface appInterface);

    void openWebBlessActivity(AppInterface appInterface, Context context);

    void preConnect(AppInterface appInterface);

    void realStartEncode(Context context, String str, String str2, String str3, boolean z16, Object obj);

    void reportSendResult(AppInterface appInterface, ArrayList<String> arrayList, int i3);

    void saveSendWording(AppInterface appInterface, String str);

    void saveUinListToSend(AppInterface appInterface, List<String> list);

    void sendBlessMsg(AppInterface appInterface, Object obj, ArrayList<String> arrayList, Object obj2);

    void sendBlessTextMsg(AppInterface appInterface, String str, ArrayList<String> arrayList, Object obj);

    void setCodecParam(int i3, int i16);

    void setPtvMessage(AppInterface appInterface, Object obj);

    void setUinListToSendChangedOnMen(AppInterface appInterface, boolean z16);

    boolean stopSendingShortVideo(AppInterface appInterface, String str, long j3);
}
