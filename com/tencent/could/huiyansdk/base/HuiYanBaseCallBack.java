package com.tencent.could.huiyansdk.base;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface HuiYanBaseCallBack {
    void getCompareResultData(String str);

    void getConfigDataSuccess(String str);

    void isHaveReflectionMode(boolean z16);

    void onActionEventChange(int i3, boolean z16, boolean z17);

    void onFail(int i3, String str);

    void onGetBotBestFaceImage();

    void onLiveDataCallBackInfo(String str, String str2);

    void onOperateTimeEvent(String str, int i3, boolean z16, String str2);

    void onTipEvent(HashMap<String, Object> hashMap);

    void onYouTuConfigLoadSuccess();

    void updateOperateInfo(String str, int i3, long j3, String str2);
}
