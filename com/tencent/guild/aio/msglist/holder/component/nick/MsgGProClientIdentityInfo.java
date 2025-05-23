package com.tencent.guild.aio.msglist.holder.component.nick;

import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityByteInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientIdentity;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientIdentityBytes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/MsgGProClientIdentityInfo;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProClientIdentityInfo;", "clientIdentityInfo", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProClientIdentity;", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProClientIdentity;)V", "getClientId", "", "getDesc", "getIdentityBytes", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProClientIdentityByteInfo;", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgGProClientIdentityInfo implements IGProClientIdentityInfo {

    @NotNull
    private final GProClientIdentity clientIdentityInfo;

    public MsgGProClientIdentityInfo(@NotNull GProClientIdentity clientIdentityInfo) {
        Intrinsics.checkNotNullParameter(clientIdentityInfo, "clientIdentityInfo");
        this.clientIdentityInfo = clientIdentityInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo
    @NotNull
    public String getClientId() {
        return String.valueOf(this.clientIdentityInfo.clientId);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo
    @NotNull
    public String getDesc() {
        String str = this.clientIdentityInfo.desc;
        Intrinsics.checkNotNullExpressionValue(str, "clientIdentityInfo.desc");
        return str;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo
    @Nullable
    public IGProClientIdentityByteInfo getIdentityBytes() {
        GProClientIdentityBytes gProClientIdentityBytes = this.clientIdentityInfo.identityBytes;
        if (gProClientIdentityBytes != null) {
            Intrinsics.checkNotNullExpressionValue(gProClientIdentityBytes, "clientIdentityInfo.identityBytes");
            return new MsgGProClientIdentityByteInfo(gProClientIdentityBytes);
        }
        return null;
    }
}
