package com.tencent.mobileqq.nearby.now.protocol;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INowShortVideoProtoManager extends QRouteApi {

    /* loaded from: classes15.dex */
    public interface a {
        void a(int i3, byte[] bArr, Bundle bundle);
    }

    void feedsLike(String str, a aVar, Bundle bundle);

    void feedsUnLike(String str, a aVar, Bundle bundle);

    void follow(long j3, long j16, int i3, int i16, boolean z16, a aVar);

    void getLbsShareInfo(Object obj, a aVar);

    void getMediaDetailInfo(String str, a aVar);

    void getShortLabel(long j3, String str, a aVar);

    INowShortVideoProtoManager init(AppInterface appInterface);

    void reportPlay(String str, a aVar);
}
