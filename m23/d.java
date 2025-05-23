package m23;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.api.impl.PbProtocolSSoImpl;
import com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery;
import com.tencent.mobileqq.vas.ipc.remote.LiveDelivery;
import com.tencent.trpcprotocol.sweet.verification.judge.DynamicNickModule;
import com.tencent.trpcprotocol.sweet.verification.judge.SetQzoneDynamicNickReq;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d implements com.tencent.mobileqq.apollo.handler.d {

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChannelCallback f416046d;

        a(ChannelCallback channelCallback) {
            this.f416046d = channelCallback;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            this.f416046d.onRecv(eIPCResult.data.getByteArray(PbProtocolSSoImpl.RESP_KEY_IS_DATA));
        }
    }

    public static void b(Activity activity, int i3, ChannelCallback channelCallback) {
        try {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime != null && !TextUtils.isEmpty(runtime.getCurrentUin())) {
                SetQzoneDynamicNickReq setQzoneDynamicNickReq = new SetQzoneDynamicNickReq();
                setQzoneDynamicNickReq.uin.set(Long.valueOf(runtime.getCurrentUin()).longValue());
                DynamicNickModule dynamicNickModule = new DynamicNickModule();
                dynamicNickModule.style_type.set(i3);
                setQzoneDynamicNickReq.module.set(dynamicNickModule);
                ((ILiveDelivery) RemoteProxy.getProxy(LiveDelivery.class)).requestPbMsfSSO("vapfService.QzoneNick.SetQzoneDynamicNick", new String(setQzoneDynamicNickReq.toByteArray(), "ISO8859_1"), null, -1, new a(channelCallback));
            }
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }
}
