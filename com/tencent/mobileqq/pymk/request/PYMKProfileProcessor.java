package com.tencent.mobileqq.pymk.request;

import android.os.Bundle;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.pymk.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u000e\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/pymk/request/PYMKProfileProcessor;", "Lcom/tencent/mobileqq/profilecommon/processor/AbsProfileCommonProcessor;", "", "getProcessorKey", "Ltencent/im/oidb/cmd0x5eb/oidb_0x5eb$ReqBody;", "reqBody", "", "onGetProfileDetailRequestForLogin", "Landroid/os/Bundle;", Const.BUNDLE_KEY_REQUEST, "success", "Ltencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData;", "udcUinData", "", "onGetProfileDetailResponse", "Lmqq/app/AppRuntime;", "app", "<init>", "(Lmqq/app/AppRuntime;)V", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PYMKProfileProcessor extends AbsProfileCommonProcessor {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PYMKProfileProcessor(AppRuntime app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public String getProcessorKey() {
        return "PYMKProfileProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb$ReqBody reqBody) {
        PBUInt32Field pBUInt32Field;
        if (reqBody != null && (pBUInt32Field = reqBody.uint32_may_know_person_switch) != null) {
            pBUInt32Field.set(1);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onGetProfileDetailResponse(Bundle request, boolean success, oidb_0x5eb$UdcUinData udcUinData) {
        if (success && udcUinData != null && udcUinData.uint32_may_know_person_switch.has()) {
            k.k(k.f261468a, udcUinData.uint32_may_know_person_switch.get() == 0, this.appRuntime, false, 4, null);
        }
    }
}
