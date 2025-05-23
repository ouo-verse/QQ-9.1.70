package h;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.api.impl.PbProtocolSSoImpl;
import com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery;
import com.tencent.mobileqq.vas.ipc.remote.LiveDelivery;
import com.tencent.mobileqq.vip.api.IVipPayApi;
import com.tencent.trpcprotocol.tianxuan.commpay.service.QZoneVipPayInfo$BuyItemReq;
import com.tencent.trpcprotocol.tianxuan.commpay.service.QZoneVipPayInfo$ItemInfo;
import com.tencent.trpcprotocol.tianxuan.commpay.service.QZoneVipPayInfo$PageInfo;
import cooperation.qzone.QUA;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: h.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public class C10403a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChannelCallback f403939d;

        C10403a(ChannelCallback channelCallback) {
            this.f403939d = channelCallback;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            this.f403939d.onRecv(eIPCResult.data.getByteArray(PbProtocolSSoImpl.RESP_KEY_IS_DATA));
        }
    }

    public static void a(ChannelCallback channelCallback) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null || TextUtils.isEmpty(runtime.getCurrentUin())) {
            return;
        }
        QZoneVipPayInfo$BuyItemReq qZoneVipPayInfo$BuyItemReq = new QZoneVipPayInfo$BuyItemReq();
        QZoneVipPayInfo$ItemInfo qZoneVipPayInfo$ItemInfo = new QZoneVipPayInfo$ItemInfo();
        qZoneVipPayInfo$ItemInfo.itemExtendInfo.set("");
        qZoneVipPayInfo$ItemInfo.itemId.set("");
        qZoneVipPayInfo$ItemInfo.itemSubId.set("101");
        qZoneVipPayInfo$ItemInfo.businessType.set(1038);
        qZoneVipPayInfo$ItemInfo.buyNum.set(1);
        QZoneVipPayInfo$PageInfo qZoneVipPayInfo$PageInfo = new QZoneVipPayInfo$PageInfo();
        qZoneVipPayInfo$PageInfo.aid.set("yuantuantiao");
        qZoneVipPayInfo$PageInfo.qua.set(QUA.getQUA3());
        qZoneVipPayInfo$BuyItemReq.businessType.set(1038);
        qZoneVipPayInfo$BuyItemReq.clientPlat.set(1);
        qZoneVipPayInfo$BuyItemReq.pageInfo.set(qZoneVipPayInfo$PageInfo);
        qZoneVipPayInfo$BuyItemReq.itemList.add(qZoneVipPayInfo$ItemInfo);
        try {
            ((ILiveDelivery) RemoteProxy.getProxy(LiveDelivery.class)).requestPbMsfSSO(IVipPayApi.CMD, new String(qZoneVipPayInfo$BuyItemReq.toByteArray(), "ISO8859_1"), null, -1, new C10403a(channelCallback));
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }
}
