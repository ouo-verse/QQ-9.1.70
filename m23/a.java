package m23;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.api.impl.PbProtocolSSoImpl;
import com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery;
import com.tencent.mobileqq.vas.ipc.remote.LiveDelivery;
import com.tencent.trpcprotocol.sweet.verification.judge.GetQzoneDynamicNickReq;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements com.tencent.mobileqq.apollo.handler.d {

    /* compiled from: P */
    /* renamed from: m23.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10760a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChannelCallback f416040d;

        C10760a(ChannelCallback channelCallback) {
            this.f416040d = channelCallback;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            this.f416040d.onRecv(eIPCResult.data.getByteArray(PbProtocolSSoImpl.RESP_KEY_IS_DATA));
        }
    }

    public static void b(ChannelCallback channelCallback) {
        try {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime != null && !TextUtils.isEmpty(runtime.getCurrentUin())) {
                GetQzoneDynamicNickReq getQzoneDynamicNickReq = new GetQzoneDynamicNickReq();
                getQzoneDynamicNickReq.uin.set(Long.valueOf(runtime.getCurrentUin()).longValue());
                ((ILiveDelivery) RemoteProxy.getProxy(LiveDelivery.class)).requestPbMsfSSO("vapfService.QzoneNick.GetQzoneDynamicNick", new String(getQzoneDynamicNickReq.toByteArray(), "ISO8859_1"), null, -1, new C10760a(channelCallback));
            }
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }
}
