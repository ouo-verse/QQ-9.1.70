package com.tencent.guild.aio.msglist.holder.component.nick;

import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProIdentity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/MsgGproIdentityInfo;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProIdentityInfo;", "identity", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProIdentity;", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProIdentity;)V", "getIdentityType", "", "getPlateData", "", "getType", HippyTextInputController.COMMAND_getValue, "", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgGproIdentityInfo implements IGProIdentityInfo {

    @NotNull
    private final GProIdentity identity;

    public MsgGproIdentityInfo(@NotNull GProIdentity identity) {
        Intrinsics.checkNotNullParameter(identity, "identity");
        this.identity = identity;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo
    public int getIdentityType() {
        return this.identity.identityType;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo
    @NotNull
    public byte[] getPlateData() {
        byte[] thirdPartyData = this.identity.getThirdPartyData();
        Intrinsics.checkNotNullExpressionValue(thirdPartyData, "identity.getThirdPartyData()");
        return thirdPartyData;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo
    public int getType() {
        return this.identity.type;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo
    @NotNull
    public String getValue() {
        String str = this.identity.value;
        Intrinsics.checkNotNullExpressionValue(str, "identity.value");
        return str;
    }
}
