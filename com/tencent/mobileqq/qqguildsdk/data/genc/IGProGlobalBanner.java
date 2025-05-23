package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildGameDownloadInfo;
import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProGlobalBanner extends Serializable {
    IGProGuildGameDownloadInfo getBannerGameDownloadeInfo();

    String getBannerId();

    IGProGuildBannerBizId getBizId();

    byte[] getContent();

    String getGuildId();

    long getOperateTime();

    long getOperatorTinyId();

    String toString();
}
