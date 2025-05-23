package com.tencent.mobileqq.highway.iplearning;

import com.tencent.mobileqq.highway.utils.EndPoint;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface IpLearning {
    public static final String TAG = "IpLearning";

    ArrayList<EndPoint> adjustNewIpList(ArrayList<EndPoint> arrayList);

    void onIpConnFail(String str, int i3);

    void onIpConnSucc(String str, int i3, boolean z16);

    void onRecvClearCMD();
}
