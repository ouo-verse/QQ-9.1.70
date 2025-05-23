package com.tencent.mobileqq.pic.api;

import com.tencent.mobileqq.pic.c;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process = {""})
/* loaded from: classes16.dex */
public interface IPicTransFile extends IRuntimeService {
    public static final int C2C_PIC_DOWNLOAD = 1004;
    public static final String C2C_PIC_DOWNLOAD_DOMAIN = "c2cpicdw.qpic.cn";
    public static final String C2C_PIC_DOWNLOAD_QUIC_DOMAIN = "c2cpicdw.quic.qpic.cn";
    public static final int FLAG_NOT_UPLOAD = 3;
    public static final int FLAG_UPLOADINFO_ERROR = 4;
    public static final int GROUP_PIC_DOWNLOAD = 1000;
    public static final String GROUP_PIC_DOWNLOAD_DOMAIN = "gchat.qpic.cn";
    public static final String GROUP_PIC_DOWNLOAD_QUIC_DOMAIN = "gchat.quic.qpic.cn";
    public static final String GUILD_PIC_DOWNLOAD_DOMAIN = "gchat.qpic.cn/qmeetpic";
    public static final boolean NEW_STORE_FLAG = true;

    /* loaded from: classes16.dex */
    public interface a {
        void addDownCallback(c cVar);

        void removeDownCallBack(c cVar);
    }

    /* loaded from: classes16.dex */
    public interface b {
        boolean isUploadSuccess();
    }

    Class getC2CPicDownloadProClass();

    Class getC2CUploadProClass();

    Class getGroupDownloadProClass();

    Class getGroupUploadProClass();

    Class getGuildDownloadProClass();

    Class getGuildUploadProClass();

    byte[] getSessionKey();

    Class getZPlanUploadProClass();

    boolean isSwitchOpenHttps();

    void setSig(byte[] bArr, byte[] bArr2);
}
