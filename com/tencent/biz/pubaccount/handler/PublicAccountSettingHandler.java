package com.tencent.biz.pubaccount.handler;

import com.tencent.biz.pubaccount.pb.PublicAccountSettingPB$AppSetReq;
import com.tencent.biz.pubaccount.pb.PublicAccountSettingPB$AppSetRsp;
import com.tencent.common.app.AppInterface;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import ey.a;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0011\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J&\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000bH\u0014J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\"\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\"\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/pubaccount/handler/PublicAccountSettingHandler;", "Lcom/tencent/biz/pubaccount/handler/BaseRequestBusinessHandler;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "", "J2", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "", "", "getCommandList", "", "uin", c.G, "Ley/a;", "callback", "L2", "", "mute", "K2", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "f", "a", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class PublicAccountSettingHandler extends BaseRequestBusinessHandler {
    public PublicAccountSettingHandler(AppInterface appInterface) {
        super(appInterface);
    }

    private final void J2(ToServiceMsg req, FromServiceMsg res, Object data) {
        if (data == null) {
            QLog.d("PublicAccountSettingHandler", 1, "handleSendFriendUins data null");
            E2(req, false, -1, "", null);
            return;
        }
        try {
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(res, data, new MessageMicro<PublicAccountSettingPB$AppSetRsp>() { // from class: com.tencent.biz.pubaccount.pb.PublicAccountSettingPB$AppSetRsp
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], PublicAccountSettingPB$AppSetRsp.class);
            });
            String errorMsg = res.extraData.getString("str_error_msg", res.getBusinessFailMsg());
            boolean z16 = res.isSuccess() && (parseOIDBPkg == 1000 || parseOIDBPkg == 0);
            QLog.d("PublicAccountSettingHandler", 1, "handleSetPublicAccountPos isSuccess = " + z16 + " code = " + parseOIDBPkg + " msg = " + errorMsg);
            Intrinsics.checkNotNullExpressionValue(errorMsg, "errorMsg");
            E2(req, z16, parseOIDBPkg, errorMsg, null);
        } catch (Exception e16) {
            QLog.e("PublicAccountSettingHandler", 1, "receive: ", e16);
        }
    }

    public final String K2(long uin, int mute, a callback) {
        QLog.d("PublicAccountSettingHandler", 1, "setPublicAccountPos uin: " + uin + " pos: " + mute);
        PublicAccountSettingPB$AppSetReq publicAccountSettingPB$AppSetReq = new PublicAccountSettingPB$AppSetReq();
        publicAccountSettingPB$AppSetReq.puin.set(uin);
        publicAccountSettingPB$AppSetReq.app_settings.setHasFlag(true);
        publicAccountSettingPB$AppSetReq.app_settings.official_account_mute.set(mute);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvcTrpcTcp.0xc76_50", 3190, 50, publicAccountSettingPB$AppSetReq.toByteArray());
        makeOIDBPkg.setSendTimeout(5000L);
        String I2 = I2(makeOIDBPkg, callback);
        sendPbReq(makeOIDBPkg);
        return I2;
    }

    public final String L2(long uin, long pos, a callback) {
        QLog.d("PublicAccountSettingHandler", 1, "setPublicAccountPos uin: " + uin + " pos: " + pos);
        PublicAccountSettingPB$AppSetReq publicAccountSettingPB$AppSetReq = new PublicAccountSettingPB$AppSetReq();
        publicAccountSettingPB$AppSetReq.puin.set(uin);
        publicAccountSettingPB$AppSetReq.app_settings.setHasFlag(true);
        publicAccountSettingPB$AppSetReq.app_settings.official_account_pos.set(pos);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvcTrpcTcp.0xc76_50", 3190, 50, publicAccountSettingPB$AppSetReq.toByteArray());
        makeOIDBPkg.setSendTimeout(5000L);
        String I2 = I2(makeOIDBPkg, callback);
        sendPbReq(makeOIDBPkg);
        return I2;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        Set<String> mutableSetOf;
        mutableSetOf = SetsKt__SetsKt.mutableSetOf("OidbSvcTrpcTcp.0xc76_50");
        return mutableSetOf;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg req, FromServiceMsg res, Object data) {
        if (req != null && res != null) {
            if (Intrinsics.areEqual("OidbSvcTrpcTcp.0xc76_50", res.getServiceCmd())) {
                J2(req, res, data);
                return;
            }
            return;
        }
        QLog.e("PublicAccountSettingHandler", 1, "onReceive failed req null or res null");
    }
}
