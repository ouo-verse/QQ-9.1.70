package com.tencent.mobileqq.filemanager.api;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFMConfig extends QRouteApi {
    String getConfigValue(Context context, String str);

    String getConfigValue(Context context, String str, String str2, String str3);

    long getFlowDialogSize();

    long getFlowDialogTime();

    long getMaxCreateThumbFileSize();

    String getPreviewConfig(Context context, String str, String str2);

    String getTAG();

    boolean getUserFtnSpeedTest();

    boolean getUserHarCodeIp();

    boolean isEnableHttpsDownload4C2C(BaseQQAppInterface baseQQAppInterface);

    boolean isEnableHttpsDownload4C2C_ZipInner(BaseQQAppInterface baseQQAppInterface);

    boolean isEnableHttpsDownload4Disc(BaseQQAppInterface baseQQAppInterface);

    boolean isEnableHttpsDownload4Disc_ZipInner(BaseQQAppInterface baseQQAppInterface);

    boolean isEnableHttpsThumb4C2C(BaseQQAppInterface baseQQAppInterface);

    boolean isEnableHttpsThumb4Disc(BaseQQAppInterface baseQQAppInterface);

    boolean isEnableHttpsUpload4C2C(BaseQQAppInterface baseQQAppInterface);

    boolean isEnableHttpsUpload4Disc(BaseQQAppInterface baseQQAppInterface);

    boolean preDownloadThumb();

    void setEnableHttpsDownload4C2C(BaseQQAppInterface baseQQAppInterface, boolean z16);

    void setEnableHttpsDownload4C2C_ZipInner(BaseQQAppInterface baseQQAppInterface, boolean z16);

    void setEnableHttpsDownload4Disc(BaseQQAppInterface baseQQAppInterface, boolean z16);

    void setEnableHttpsDownload4Disc_ZipInner(BaseQQAppInterface baseQQAppInterface, boolean z16);

    void setEnableHttpsThumb4C2C(BaseQQAppInterface baseQQAppInterface, boolean z16);

    void setEnableHttpsThumb4Disc(BaseQQAppInterface baseQQAppInterface, boolean z16);

    void setEnableHttpsUpload4C2C(BaseQQAppInterface baseQQAppInterface, boolean z16);

    void setEnableHttpsUpload4Disc(BaseQQAppInterface baseQQAppInterface, boolean z16);

    int timAIOGaryTipsCount();

    String timGuideUrl();

    void updatePreviewList(BaseQQAppInterface baseQQAppInterface, String str, long j3);
}
