package com.qzone.proxy.feedcomponent.handler;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.IResult;
import com.qzone.adapter.feedcomponent.IServiceCallback;
import com.qzone.util.ToastUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.api.impl.PbProtocolSSoImpl;
import com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery;
import com.tencent.mobileqq.vas.ipc.remote.LiveDelivery;
import com.tencent.trpcprotocol.tianxuan.birthday.feed.feeds$DressReply;
import com.tencent.trpcprotocol.tianxuan.birthday.feed.feeds$DressRequest;
import cooperation.qzone.util.ProcessUtils;
import cooperation.qzone.util.QZLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes39.dex */
public class DressBirthdayGiftHandler {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChannelCallback f50159d;

        a(ChannelCallback channelCallback) {
            this.f50159d = channelCallback;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            this.f50159d.onRecv(eIPCResult.data.getByteArray(PbProtocolSSoImpl.RESP_KEY_IS_DATA));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f50160d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f50161e;

        b(String str, Context context) {
            this.f50160d = str;
            this.f50161e = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            yo.d.d(this.f50160d, this.f50161e, null);
        }
    }

    public static void b(String str, String str2, boolean z16, final String str3, final IServiceCallback iServiceCallback) {
        c(str, str2, z16, new ChannelCallback() { // from class: com.qzone.proxy.feedcomponent.handler.DressBirthdayGiftHandler.1
            @Override // com.tencent.falco.base.libapi.channel.ChannelCallback
            public void onRecv(byte[] bArr) {
                try {
                    feeds$DressReply feeds_dressreply = new feeds$DressReply();
                    feeds_dressreply.mergeFrom(bArr);
                    d dVar = new d();
                    int i3 = 0;
                    if (feeds_dressreply.code.get() == 0) {
                        ToastUtil.s("\u88c5\u626e\u6210\u529f", 5);
                    } else {
                        if (feeds_dressreply.code.get() == 1) {
                            ToastUtil.s("\u88c5\u626e\u5931\u8d25", 1);
                        } else if (feeds_dressreply.code.get() == 2) {
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.handler.DressBirthdayGiftHandler.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    DressBirthdayGiftHandler.d(str3, ProcessUtils.getTopActivity());
                                }
                            });
                        }
                        i3 = 1;
                    }
                    dVar.setReturnCode(i3);
                    iServiceCallback.onResult(dVar);
                } catch (Exception e16) {
                    ToastUtil.s("\u88c5\u626e\u5931\u8d25", 1);
                    QZLog.w(e16);
                }
            }

            @Override // com.tencent.falco.base.libapi.channel.ChannelCallback
            public void onError(boolean z17, int i3, String str4) {
            }
        });
    }

    public static void c(String str, String str2, boolean z16, ChannelCallback channelCallback) {
        try {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime != null && !TextUtils.isEmpty(runtime.getCurrentUin())) {
                feeds$DressRequest feeds_dressrequest = new feeds$DressRequest();
                feeds_dressrequest.act_id.set(str);
                feeds_dressrequest.rule_id.set(str2);
                feeds_dressrequest.qzone_share.set(z16);
                ((ILiveDelivery) RemoteProxy.getProxy(LiveDelivery.class)).requestPbMsfSSO("trpc.tianxuan.birthday.feed.Dress", new String(feeds_dressrequest.toByteArray(), "ISO8859_1"), null, -1, new a(channelCallback));
            }
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, Context context) {
        if (context == null) {
            return;
        }
        try {
            DialogUtil.createCustomDialog(context, 230, "\u6e29\u99a8\u63d0\u793a", "\u4f60\u5df2\u7ecf\u9886\u53d6\u8fc7\u751f\u65e5\u88c5\u626e\u4e86\u54e6\uff5e\n", "\u9000\u51fa", "\u66f4\u591a\u88c5\u626e", new b(str, context), new c()).show();
        } catch (Throwable th5) {
            QZLog.w(th5);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class d implements IResult {

        /* renamed from: d, reason: collision with root package name */
        int f50162d = -1;

        @Override // com.qzone.adapter.feedcomponent.IResult
        public Bundle getBundle() {
            return null;
        }

        @Override // com.qzone.adapter.feedcomponent.IResult
        public Object getData() {
            return null;
        }

        @Override // com.qzone.adapter.feedcomponent.IResult
        public boolean getHasMore() {
            return false;
        }

        @Override // com.qzone.adapter.feedcomponent.IResult
        public String getMessage() {
            return null;
        }

        @Override // com.qzone.adapter.feedcomponent.IResult
        public long getNewCnt() {
            return 0L;
        }

        @Override // com.qzone.adapter.feedcomponent.IResult
        public Object getObjectData() {
            return null;
        }

        @Override // com.qzone.adapter.feedcomponent.IResult
        public int getReturnCode() {
            return this.f50162d;
        }

        @Override // com.qzone.adapter.feedcomponent.IResult
        public boolean getSucceed() {
            return false;
        }

        @Override // com.qzone.adapter.feedcomponent.IResult
        public int getWhat() {
            return 0;
        }

        @Override // com.qzone.adapter.feedcomponent.IResult
        public void setReturnCode(int i3) {
            this.f50162d = i3;
        }

        @Override // com.qzone.adapter.feedcomponent.IResult
        public void sendToHandler(Handler handler) {
        }

        @Override // com.qzone.adapter.feedcomponent.IResult
        public void setData(Object obj) {
        }

        @Override // com.qzone.adapter.feedcomponent.IResult
        public void setFailReason(String str) {
        }

        @Override // com.qzone.adapter.feedcomponent.IResult
        public void setHasMore(boolean z16) {
        }

        @Override // com.qzone.adapter.feedcomponent.IResult
        public void setNewCnt(long j3) {
        }

        @Override // com.qzone.adapter.feedcomponent.IResult
        public void setObjectData(Object obj) {
        }

        @Override // com.qzone.adapter.feedcomponent.IResult
        public void setSucceed(boolean z16) {
        }

        @Override // com.qzone.adapter.feedcomponent.IResult
        public void setWhat(int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
