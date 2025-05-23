package com.tencent.guild.aio.msglist.holder.component.nick;

import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityByteInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfoWithClientId;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientIdentityBytes;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProIdentity;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProIdentityWithClientId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/MsgGProClientIdentityByteInfo;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProClientIdentityByteInfo;", "bytes", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProClientIdentityBytes;", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProClientIdentityBytes;)V", "getClientId", "", "getDefaultIdentityList", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProIdentityInfoWithClientId;", "getIdentityList", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProIdentityInfo;", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgGProClientIdentityByteInfo implements IGProClientIdentityByteInfo {

    @NotNull
    private final GProClientIdentityBytes bytes;

    public MsgGProClientIdentityByteInfo(@NotNull GProClientIdentityBytes bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.bytes = bytes;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityByteInfo
    public int getClientId() {
        return this.bytes.clientId;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityByteInfo
    @NotNull
    public List<IGProIdentityInfoWithClientId> getDefaultIdentityList() {
        ArrayList arrayList = new ArrayList();
        ArrayList<GProIdentityWithClientId> arrayList2 = this.bytes.defaultIdentitys;
        if (arrayList2 != null) {
            Iterator<GProIdentityWithClientId> it = arrayList2.iterator();
            while (it.hasNext()) {
                final GProIdentityWithClientId next = it.next();
                arrayList.add(new IGProIdentityInfoWithClientId() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.MsgGProClientIdentityByteInfo$getDefaultIdentityList$1$info$1
                    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfoWithClientId
                    @NotNull
                    public String getClientId() {
                        return String.valueOf(GProIdentityWithClientId.this.clientId);
                    }

                    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfoWithClientId
                    @NotNull
                    public IGProIdentityInfo getIdentity() {
                        GProIdentity gProIdentity = GProIdentityWithClientId.this.identitys;
                        Intrinsics.checkNotNullExpressionValue(gProIdentity, "identityWithClientId.identitys");
                        return new MsgGproIdentityInfo(gProIdentity);
                    }
                });
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityByteInfo
    @NotNull
    public List<IGProIdentityInfo> getIdentityList() {
        ArrayList arrayList = new ArrayList();
        ArrayList<GProIdentity> arrayList2 = this.bytes.identitys;
        if (arrayList2 != null) {
            Iterator<GProIdentity> it = arrayList2.iterator();
            while (it.hasNext()) {
                GProIdentity identity = it.next();
                Intrinsics.checkNotNullExpressionValue(identity, "identity");
                arrayList.add(new MsgGproIdentityInfo(identity));
            }
        }
        return arrayList;
    }
}
