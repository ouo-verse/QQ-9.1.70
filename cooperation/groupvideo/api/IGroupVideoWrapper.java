package cooperation.groupvideo.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface IGroupVideoWrapper extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface a {
        void a(IGroupVideoWrapper iGroupVideoWrapper);
    }

    Object getProxy();

    int getPstnUserNumberInMAV(long j3, int i3);

    void init(AppInterface appInterface);

    void initialize(a aVar);

    void onUpdateTroopList();

    void processS2C(byte[] bArr);

    void uninitialize();
}
