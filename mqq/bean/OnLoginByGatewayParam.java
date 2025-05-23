package mqq.bean;

import com.tencent.qphone.base.remote.ToServiceMsg;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

/* loaded from: classes28.dex */
public class OnLoginByGatewayParam {
    public ErrMsg errMsg;
    public DevlockInfo info;
    public int seq;

    /* renamed from: to, reason: collision with root package name */
    public ToServiceMsg f417208to;
    public String uin;
    public WUserSigInfo userSigInfo;

    public OnLoginByGatewayParam(int i3, DevlockInfo devlockInfo, ToServiceMsg toServiceMsg, WUserSigInfo wUserSigInfo, String str, ErrMsg errMsg) {
        this.seq = i3;
        this.info = devlockInfo;
        this.f417208to = toServiceMsg;
        this.userSigInfo = wUserSigInfo;
        this.uin = str;
        this.errMsg = errMsg;
    }
}
