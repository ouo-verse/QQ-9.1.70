package com.tencent.mobileqq.onlinestatus.networkhandler;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.model.CustomShareInfo;
import com.tencent.mobileqq.onlinestatus.observer.OnlineStatusCustomObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.onlinestatus.OnlineStatusShareInfo$GetShareInfoReq;
import tencent.im.onlinestatus.OnlineStatusShareInfo$SetShareInfoReq;
import tencent.im.onlinestatus.OnlineStatusShareInfo$ShareInfoItem;
import tencent.im.onlinestatus.OnlineStatusShareInfo$StatusDesc;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00015B\u000f\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b3\u00104J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t\u0018\u00010\u0006H\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\"\u0010\u0011\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eJ&\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u0019H\u0014JV\u0010 \u001a$\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e2\u0006\u0010\u001c\u001a\u00020\u000e2$\u0010\u001f\u001a \u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u000b0\u001dj\u0002`\u001eJ*\u0010!\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000e2\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t\u0018\u00010\u0006J\u0006\u0010\"\u001a\u00020\u000bJ\u000e\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020#R>\u0010)\u001a,\u0012\u0004\u0012\u00020\u000e\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u000b0\u001dj\u0002`\u001e0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R0\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t0\u00060*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00100\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010/\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/networkhandler/CustomHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "", "uin", "", "isSelfRequest", "Lcom/tencent/mobileqq/onlinestatus/networkhandler/CustomHandler$a;", "Lcom/tencent/mobileqq/onlinestatus/observer/a;", "Ltencent/im/onlinestatus/OnlineStatusShareInfo$ShareInfoItem;", "Lcom/tencent/mobileqq/onlinestatus/observer/CustomInfoGetResPack;", "callback", "", Constants.MMCCID, "", "", "getCommandList", "key", Constants.BASE_IN_PLUGIN_VERSION, "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "cmd", "Lkotlin/Function3;", "Lcom/tencent/mobileqq/onlinestatus/networkhandler/RspHandleFunc;", "handleFunc", "K2", "H2", "F2", "Lcom/tencent/mobileqq/onlinestatus/model/CustomShareInfo;", "shareInfo", "L2", "", "d", "Ljava/util/Map;", "mRspHandleMap", "Ljava/util/concurrent/ConcurrentHashMap;", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "mGetCallbackMap", "E2", "()J", "currentUinLong", "Lcom/tencent/common/app/AppInterface;", "appInterface", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class CustomHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Function3<ToServiceMsg, FromServiceMsg, Object, Unit>> mRspHandleMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, a<com.tencent.mobileqq.onlinestatus.observer.a<OnlineStatusShareInfo$ShareInfoItem>>> mGetCallbackMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\u0007\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/networkhandler/CustomHandler$a;", "T", "", "resPack", "", "onSuccess", "(Ljava/lang/Object;)V", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a<T> {
        void a(@Nullable T resPack);

        void onSuccess(@Nullable T resPack);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomHandler(@NotNull AppInterface appInterface) {
        super(appInterface);
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        this.mRspHandleMap = new LinkedHashMap();
        this.mGetCallbackMap = new ConcurrentHashMap<>();
        CustomHandlerKt.e(this);
    }

    private final long E2() {
        AppInterface appInterface = this.appRuntime;
        if (appInterface != null) {
            return appInterface.getLongAccountUin();
        }
        return 0L;
    }

    private final void G2(long uin, boolean isSelfRequest, a<com.tencent.mobileqq.onlinestatus.observer.a<OnlineStatusShareInfo$ShareInfoItem>> callback) {
        OnlineStatusShareInfo$GetShareInfoReq onlineStatusShareInfo$GetShareInfoReq = new OnlineStatusShareInfo$GetShareInfoReq();
        onlineStatusShareInfo$GetShareInfoReq.uin.add(Long.valueOf(uin));
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "trpc.QQService.CommonLogic.StatusService.SsoGetShareInfo");
        QLog.d("CustomHandler", 1, "getShareInfo " + uin);
        toServiceMsg.putWupBuffer(onlineStatusShareInfo$GetShareInfoReq.toByteArray());
        if (callback != null) {
            String valueOf = String.valueOf(callback.hashCode());
            this.mGetCallbackMap.put(valueOf, callback);
            toServiceMsg.addAttribute("key_callback", valueOf);
        }
        toServiceMsg.addAttribute("key_is_get_self_info", Boolean.valueOf(isSelfRequest));
        sendPbReq(toServiceMsg);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void I2(CustomHandler customHandler, long j3, boolean z16, a aVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            aVar = null;
        }
        customHandler.G2(j3, z16, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void J2(CustomHandler customHandler, String str, a aVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            aVar = null;
        }
        customHandler.H2(str, aVar);
    }

    @Nullable
    public final a<com.tencent.mobileqq.onlinestatus.observer.a<OnlineStatusShareInfo$ShareInfoItem>> D2(@Nullable String key) {
        if (key != null && !Intrinsics.areEqual(key, "")) {
            a<com.tencent.mobileqq.onlinestatus.observer.a<OnlineStatusShareInfo$ShareInfoItem>> aVar = this.mGetCallbackMap.get(key);
            this.mGetCallbackMap.remove(key);
            return aVar;
        }
        return null;
    }

    public final void F2() {
        I2(this, E2(), true, null, 4, null);
    }

    public final void H2(@NotNull String uin, @Nullable a<com.tencent.mobileqq.onlinestatus.observer.a<OnlineStatusShareInfo$ShareInfoItem>> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        G2(Long.parseLong(uin), false, callback);
    }

    @Nullable
    public final Function3<ToServiceMsg, FromServiceMsg, Object, Unit> K2(@NotNull String cmd, @NotNull Function3<? super ToServiceMsg, ? super FromServiceMsg, Object, Unit> handleFunc) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(handleFunc, "handleFunc");
        return this.mRspHandleMap.put(cmd, handleFunc);
    }

    public final void L2(@NotNull CustomShareInfo shareInfo) {
        Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
        long currentTimeMillis = System.currentTimeMillis();
        OnlineStatusShareInfo$SetShareInfoReq onlineStatusShareInfo$SetShareInfoReq = new OnlineStatusShareInfo$SetShareInfoReq();
        OnlineStatusShareInfo$ShareInfoItem onlineStatusShareInfo$ShareInfoItem = new OnlineStatusShareInfo$ShareInfoItem();
        OnlineStatusShareInfo$StatusDesc onlineStatusShareInfo$StatusDesc = new OnlineStatusShareInfo$StatusDesc();
        onlineStatusShareInfo$ShareInfoItem.share_time.set(currentTimeMillis);
        PBBytesField pBBytesField = onlineStatusShareInfo$ShareInfoItem.share_url;
        String url = shareInfo.getUrl();
        Charset charset = Charsets.UTF_8;
        byte[] bytes = url.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        pBBytesField.set(ByteStringMicro.copyFrom(bytes));
        onlineStatusShareInfo$ShareInfoItem.share_type.set(shareInfo.getShareType());
        PBBytesField pBBytesField2 = onlineStatusShareInfo$ShareInfoItem.share_wording;
        byte[] bytes2 = shareInfo.getSubTitle().getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        pBBytesField2.set(ByteStringMicro.copyFrom(bytes2));
        onlineStatusShareInfo$ShareInfoItem.uin.set(E2());
        onlineStatusShareInfo$StatusDesc.status.set(shareInfo.getOriginStatus().getValue());
        onlineStatusShareInfo$StatusDesc.ex_status.set((int) shareInfo.getExtStatus());
        onlineStatusShareInfo$ShareInfoItem.status_desc.set(onlineStatusShareInfo$StatusDesc);
        onlineStatusShareInfo$SetShareInfoReq.item.set(onlineStatusShareInfo$ShareInfoItem);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "trpc.QQService.CommonLogic.StatusService.SsoSetShareInfo");
        toServiceMsg.putWupBuffer(onlineStatusShareInfo$SetShareInfoReq.toByteArray());
        toServiceMsg.addAttribute(IOnlineStatusService.KEY_CUSTOM_SHARE_INFO, shareInfo);
        QLog.d("CustomHandler", 1, "setShareInfo " + shareInfo + " uin: " + E2());
        sendPbReq(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @NotNull
    public Set<String> getCommandList() {
        Set<String> mutableSetOf;
        mutableSetOf = SetsKt__SetsKt.mutableSetOf("trpc.QQService.CommonLogic.StatusService.SsoSetShareInfo", "trpc.QQService.CommonLogic.StatusService.SsoGetShareInfo");
        return mutableSetOf;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @NotNull
    protected Class<? extends BusinessObserver> observerClass() {
        return OnlineStatusCustomObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        boolean z16;
        if (req != null && res != null) {
            Function3<ToServiceMsg, FromServiceMsg, Object, Unit> function3 = this.mRspHandleMap.get(res.getServiceCmd());
            if (function3 != null) {
                function3.invoke(req, res, data);
                return;
            }
            return;
        }
        boolean z17 = false;
        if (req == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (res == null) {
            z17 = true;
        }
        QLog.e("CustomHandler", 1, "onReceive error! req null [" + z16 + "] res null [" + z17 + "]");
    }
}
