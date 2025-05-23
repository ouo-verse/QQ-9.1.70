package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.List;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyRedInfo extends QRouteApi {
    void addFaceUrl(String str, boolean z16);

    void addFaceUrl(List<String> list, boolean z16);

    void addRedNum(int i3);

    void addRedNum(String str);

    String getCornerInfo();

    int getRedAppIdType();

    int getRedNum();

    int getRedPointReportType();

    int getRedType();

    List<String> getRedUrl();

    String getTipTextInfo();

    void setCornerInfo(String str);

    void setRedAppIdType(int i3);

    void setRedPointReportType(int i3);

    void setRedType(int i3);

    void setTipTextInfo(String str);

    String toString();
}
