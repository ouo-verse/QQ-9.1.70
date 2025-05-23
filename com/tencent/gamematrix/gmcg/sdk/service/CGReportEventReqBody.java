package com.tencent.gamematrix.gmcg.sdk.service;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cooperation.qzone.remote.ServiceConst;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGReportEventReqBody {

    @SerializedName("caid")
    public String caid;

    @SerializedName("int_ext1")
    public Integer intExt1;

    @SerializedName("int_ext2")
    public Integer intExt2;

    @SerializedName("int_ext3")
    public Integer intExt3;

    @SerializedName("int_ext4")
    public Integer intExt4;

    @SerializedName("int_ext5")
    public Integer intExt5;

    @SerializedName("net_detail")
    public String netDetail;

    @SerializedName(QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID)
    public String pBizId;

    @SerializedName("brand")
    public String pBrand;

    @SerializedName("cgdevice_area")
    public String pCGDeviceArea;

    @SerializedName("cgdevice_fps")
    public Integer pCGDeviceFps;

    @SerializedName("device_id")
    public String pCGDeviceId;

    @SerializedName("cgdevice_resolution")
    public String pCGDeviceResolution;

    @SerializedName("cluster")
    public String pCluster;

    @SerializedName("event_name")
    public String pEventName;

    @SerializedName("event_timestamp")
    public long pEventTimestamp;

    @SerializedName("game_id")
    public String pGameId;

    @SerializedName("identity")
    public String pIdentity;

    @SerializedName("model")
    public String pModel;

    @SerializedName("os_version")
    public String pOSVersion;

    @SerializedName("oaid")
    public String pOaid;

    @SerializedName("platform")
    public Integer pPlatform;

    @SerializedName("sdk_version")
    public String pSdkVersion;

    @SerializedName(ServiceConst.PARA_SESSION_ID)
    public String pSessionId;

    @SerializedName("soc")
    public String pSoc;

    @SerializedName("ua")
    public String pUA;

    @SerializedName("xid")
    public String pXid;

    @SerializedName("str_ext1")
    public String strExt1;

    @SerializedName("str_ext2")
    public String strExt2;

    @SerializedName("str_ext3")
    public String strExt3;

    @SerializedName("str_ext4")
    public String strExt4;

    @SerializedName("str_ext5")
    public String strExt5;

    @SerializedName("os_name")
    public String pOSName = "Android";

    @SerializedName("server_env")
    public int pServerEnv = 0;

    @SerializedName(HianalyticsBaseData.SDK_TYPE)
    public String pSdkType = "AndroidNative";

    @SerializedName("net_type")
    public int netType = -1;

    @SerializedName("is_reconnecting")
    public int isReconnecting = 0;

    public void fillIntExts(int[] iArr) {
        if (iArr != null) {
            int min = Math.min(iArr.length, 5);
            for (int i3 = 0; i3 < min; i3++) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    this.intExt5 = Integer.valueOf(iArr[i3]);
                                }
                            } else {
                                this.intExt4 = Integer.valueOf(iArr[i3]);
                            }
                        } else {
                            this.intExt3 = Integer.valueOf(iArr[i3]);
                        }
                    } else {
                        this.intExt2 = Integer.valueOf(iArr[i3]);
                    }
                } else {
                    this.intExt1 = Integer.valueOf(iArr[i3]);
                }
            }
        }
    }

    public void fillStrExts(String[] strArr) {
        if (strArr != null) {
            int min = Math.min(strArr.length, 5);
            for (int i3 = 0; i3 < min; i3++) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    this.strExt5 = strArr[i3];
                                }
                            } else {
                                this.strExt4 = strArr[i3];
                            }
                        } else {
                            this.strExt3 = strArr[i3];
                        }
                    } else {
                        this.strExt2 = strArr[i3];
                    }
                } else {
                    this.strExt1 = strArr[i3];
                }
            }
        }
    }
}
