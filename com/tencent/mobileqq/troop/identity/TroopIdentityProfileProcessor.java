package com.tencent.mobileqq.troop.identity;

import android.os.Bundle;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u000e\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001a\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/identity/TroopIdentityProfileProcessor;", "Lcom/tencent/mobileqq/profilecommon/processor/AbsProfileCommonProcessor;", "", "getProcessorKey", "Ltencent/im/oidb/cmd0x5eb/oidb_0x5eb$ReqBody;", "reqBody", "", "onGetProfileDetailRequestForLogin", "Landroid/os/Bundle;", Const.BUNDLE_KEY_REQUEST, "success", "Ltencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData;", "udcUinData", "", "onGetProfileDetailResponse", "", "type", "interceptProfileModifyPush", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "bytesValue", "onProcessProfileModifyPush", "Lmqq/app/AppRuntime;", "app", "<init>", "(Lmqq/app/AppRuntime;)V", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopIdentityProfileProcessor extends AbsProfileCommonProcessor {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopIdentityProfileProcessor(AppRuntime app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public String getProcessorKey() {
        return "TroopIdentityProfileProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean interceptProfileModifyPush(int type) {
        if (type == 47223) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onGetProfileDetailResponse(Bundle request, boolean success, oidb_0x5eb$UdcUinData udcUinData) {
        boolean z16;
        if (udcUinData == null) {
            return;
        }
        boolean has = udcUinData.uint32_groupbadge_flag.has();
        if (has) {
            z16 = udcUinData.uint32_groupbadge_flag.get() == 0 || udcUinData.uint32_groupbadge_flag.get() == 1;
            ((ITroopIdentityApi) QRoute.api(ITroopIdentityApi.class)).onGetGlobalSwitch(z16);
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopIdentityProfileProcessor", 1, "[onGetProfileDetailResponse] hasIdentityGlobalSwitch = " + has + " identityGlobalSwitchOpen = " + z16);
        }
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb$ReqBody reqBody) {
        if (reqBody == null) {
            return false;
        }
        PBUInt32Field pBUInt32Field = reqBody.uint32_req_groupbadge_flag;
        if (pBUInt32Field != null) {
            pBUInt32Field.set(1);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPush(int type, ByteStringMicro bytesValue) {
        boolean z16;
        if (type != 47223 || bytesValue == null) {
            return;
        }
        try {
            short s16 = ByteBuffer.wrap(bytesValue.toByteArray()).asShortBuffer().get();
            if (s16 != 0 && s16 != 1) {
                z16 = false;
                ((ITroopIdentityApi) QRoute.api(ITroopIdentityApi.class)).onGetGlobalSwitch(z16);
            }
            z16 = true;
            ((ITroopIdentityApi) QRoute.api(ITroopIdentityApi.class)).onGetGlobalSwitch(z16);
        } catch (Exception e16) {
            QLog.e("TroopIdentityProfileProcessor", 1, "[onProcessProfileModifyPush] e = " + e16);
        }
    }
}
