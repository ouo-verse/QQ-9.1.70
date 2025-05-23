package com.tencent.guild.aio.msglist.holder.component.nick;

import com.tencent.qqnt.kernel.nativeinterface.GuildClientIdentity;
import com.tencent.qqnt.kernel.nativeinterface.GuildClientIdentityBytes;
import com.tencent.qqnt.kernel.nativeinterface.GuildIdentity;
import com.tencent.qqnt.kernel.nativeinterface.GuildIdentityWithClientId;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientIdentity;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientIdentityBytes;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProIdentity;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProIdentityWithClientId;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0003\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/GuildIdentity;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProIdentity;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/GuildClientIdentity;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProClientIdentity;", "a", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class p {
    @NotNull
    public static final GProClientIdentity a(@NotNull GuildClientIdentity guildClientIdentity) {
        Intrinsics.checkNotNullParameter(guildClientIdentity, "<this>");
        GProClientIdentityBytes gProClientIdentityBytes = new GProClientIdentityBytes();
        GuildClientIdentityBytes guildClientIdentityBytes = guildClientIdentity.identityBytes;
        gProClientIdentityBytes.clientId = guildClientIdentityBytes.clientId;
        ArrayList<GuildIdentity> arrayList = guildClientIdentityBytes.identitys;
        Intrinsics.checkNotNullExpressionValue(arrayList, "identityBytes.identitys");
        for (GuildIdentity it : arrayList) {
            ArrayList<GProIdentity> arrayList2 = gProClientIdentityBytes.identitys;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList2.add(b(it));
        }
        ArrayList<GuildIdentityWithClientId> arrayList3 = guildClientIdentity.identityBytes.defaultIdentities;
        Intrinsics.checkNotNullExpressionValue(arrayList3, "identityBytes.defaultIdentities");
        for (GuildIdentityWithClientId guildIdentityWithClientId : arrayList3) {
            GProIdentityWithClientId gProIdentityWithClientId = new GProIdentityWithClientId();
            gProIdentityWithClientId.clientId = guildIdentityWithClientId.clientId;
            GuildIdentity guildIdentity = guildIdentityWithClientId.identities;
            Intrinsics.checkNotNullExpressionValue(guildIdentity, "it.identities");
            gProIdentityWithClientId.identitys = b(guildIdentity);
        }
        return new GProClientIdentity(guildClientIdentity.clientId, guildClientIdentity.desc, gProClientIdentityBytes);
    }

    @NotNull
    public static final GProIdentity b(@NotNull GuildIdentity guildIdentity) {
        Intrinsics.checkNotNullParameter(guildIdentity, "<this>");
        GProIdentity gProIdentity = new GProIdentity();
        gProIdentity.type = guildIdentity.type;
        gProIdentity.value = guildIdentity.value;
        gProIdentity.identityType = guildIdentity.identityType;
        gProIdentity.thirdPartyData = guildIdentity.thirdPartyData;
        return gProIdentity;
    }
}
