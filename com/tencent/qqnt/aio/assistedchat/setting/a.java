package com.tencent.qqnt.aio.assistedchat.setting;

import android.os.Bundle;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitch;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001e\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J8\u0010\u0018\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/setting/a;", "Lcom/tencent/relation/common/handler/c;", "Ltencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData;", "udc", "", "a", "", "getBusinessType", "Landroid/os/Bundle;", "bundle", "Ltencent/im/oidb/cmd0x5eb/oidb_0x5eb$ReqBody;", "mergeReqBody", "get0x5ebReqBody", "getRequestExtraData", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "resp", "", "data", "Ltencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody;", "response", "", "isSuccess", "onReceive", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a implements com.tencent.relation.common.handler.c {
    private final void a(oidb_0x5eb$UdcUinData udc) {
        ArrayList arrayList = new ArrayList();
        for (AssistedChatSwitch assistedChatSwitch : e.f349447a.e()) {
            PBUInt32Field a16 = yu3.a.INSTANCE.a(assistedChatSwitch.a(), assistedChatSwitch.b(), udc);
            if (a16 != null) {
                int i3 = a16.get();
                e.f349447a.t(assistedChatSwitch, i3);
                arrayList.add(assistedChatSwitch.a() + "_" + assistedChatSwitch.b() + "_" + i3);
            }
        }
        QLog.d("I0x5ebHandlerProcessor.AssistedChat5ebHandlerProcessor", 1, "updateSettingSwitch " + arrayList);
    }

    @Override // com.tencent.relation.common.handler.c
    public int getBusinessType() {
        return 8;
    }

    @Override // com.tencent.relation.common.handler.c
    public Bundle getRequestExtraData() {
        return null;
    }

    @Override // com.tencent.relation.common.handler.c
    public void onReceive(ToServiceMsg req, FromServiceMsg resp, Object data, oidb_0x5eb$RspBody response, boolean isSuccess) {
        Object orNull;
        if (isSuccess && response != null) {
            if (response.rpt_msg_uin_data.size() == 0) {
                QLog.w("I0x5ebHandlerProcessor.AssistedChat5ebHandlerProcessor", 1, "onReceive rpt_msg_uin_data size=0");
                return;
            }
            List<oidb_0x5eb$UdcUinData> list = response.rpt_msg_uin_data.get();
            Intrinsics.checkNotNullExpressionValue(list, "response.rpt_msg_uin_data.get()");
            orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
            oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata = (oidb_0x5eb$UdcUinData) orNull;
            if (oidb_0x5eb_udcuindata == null) {
                return;
            }
            a(oidb_0x5eb_udcuindata);
            e.f349447a.s();
            return;
        }
        QLog.w("I0x5ebHandlerProcessor.AssistedChat5ebHandlerProcessor", 1, "onReceive isSuccess=" + isSuccess + " responseIsNull=" + (response == null));
    }

    @Override // com.tencent.relation.common.handler.c
    public oidb_0x5eb$ReqBody get0x5ebReqBody(Bundle bundle, oidb_0x5eb$ReqBody mergeReqBody) {
        if (mergeReqBody == null) {
            return null;
        }
        for (AssistedChatSwitch assistedChatSwitch : e.f349447a.e()) {
            yu3.a.INSTANCE.b(assistedChatSwitch.a(), assistedChatSwitch.b(), mergeReqBody);
        }
        return mergeReqBody;
    }
}
