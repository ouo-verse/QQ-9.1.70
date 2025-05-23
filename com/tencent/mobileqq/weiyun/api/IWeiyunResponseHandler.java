package com.tencent.mobileqq.weiyun.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IWeiyunResponseHandler extends QRouteApi {
    public static final int ERROR_DISK_SERVER_CODE_FLOW_LIMIT = 1127;
    public static final int ERROR_DISK_SERVER_CODE_FLOW_LIMIT_VIP = 22000;
    public static final int ERROR_DISK_SERVER_CODE_FLOW_LIMIT_VIP_SUPER = 22121;
    public static final int ERR_DISK_OFFLINE_2_WEIYUN_CAPACITY = -20001;
    public static final int ERR_DISK_SERVER_LIMIT_EXCEED_MAX_CAPACITY = 1053;
    public static final int ERR_DISK_SERVER_LIMIT_EXCEED_MAX_CAPACITY_VIP = 22081;
    public static final int ERR_DISK_SERVER_LIMIT_EXCEED_MAX_CAPACITY_VIP_SUPER = 22121;

    boolean endSave2Weiyun(int i3);

    String getErrorMsg(Context context);

    boolean isAllRequestFinished();

    boolean isFlowOverErrorCode(int i3);

    boolean isSpaceOverErrorCode(int i3);

    boolean needShowGrayTips();

    boolean needShowGrayTips(int i3);

    void setRequestData(String str, String str2, int i3);

    void showGrayTips(AppInterface appInterface);

    void startSave2Weiyun();
}
