package com.tencent.could.huiyansdk.api;

import com.tencent.could.huiyansdk.entity.RiskDemoImage;
import com.tencent.could.huiyansdk.enums.RiskCameraType;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface HuiYanExtraCallBack {
    void onBuriedPointCallBack(String str, String str2, String str3);

    void onCameraInfoStr(int i3, boolean z16);

    void onCameraRiskData(Map<RiskCameraType, RiskDemoImage> map, int i3);

    void onLiveDataCallBackInfo(String str, String str2);

    void onOperateTimeEvent(String str, int i3, boolean z16, String str2);

    void onPrepare(HuiYanOperationConfigCallBack huiYanOperationConfigCallBack);

    void onStreamRiskDataSuccess(String str);

    void onTuringFaceDataSuccess(String str);

    void updateOperateInfo(String str, int i3, long j3, String str2);
}
