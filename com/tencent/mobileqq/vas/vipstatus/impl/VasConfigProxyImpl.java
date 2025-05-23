package com.tencent.mobileqq.vas.vipstatus.impl;

import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vas.vipstatus.IVasConfigProxy;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/vas/vipstatus/impl/VasConfigProxyImpl;", "Lcom/tencent/mobileqq/vas/vipstatus/IVasConfigProxy;", "()V", "getVipPerceptionVoiceS", "", "vas_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasConfigProxyImpl implements IVasConfigProxy {
    @Override // com.tencent.mobileqq.vas.vipstatus.IVasConfigProxy
    public int getVipPerceptionVoiceS() {
        UnitedProxy unitedProxy = VasNtToggle.VAS_VIP_PERCEPTION_CONFIG;
        if (!unitedProxy.isEnable(true)) {
            return 30;
        }
        return unitedProxy.getJson().optInt("voice_to_text_num", 30);
    }
}
