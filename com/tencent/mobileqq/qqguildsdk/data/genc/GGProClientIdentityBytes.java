package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientIdentityBytes;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProIdentity;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProIdentityWithClientId;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProClientIdentityBytes implements IGProClientIdentityBytes {
    public final GProClientIdentityBytes mInfo;

    public GGProClientIdentityBytes(GProClientIdentityBytes gProClientIdentityBytes) {
        this.mInfo = gProClientIdentityBytes;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProClientIdentityBytes
    public int getClientId() {
        return this.mInfo.getClientId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProClientIdentityBytes
    public ArrayList<IGProIdentityWithClientId> getDefaultIdentitys() {
        ArrayList<GProIdentityWithClientId> defaultIdentitys = this.mInfo.getDefaultIdentitys();
        ArrayList<IGProIdentityWithClientId> arrayList = new ArrayList<>();
        Iterator<GProIdentityWithClientId> it = defaultIdentitys.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProIdentityWithClientId(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProClientIdentityBytes
    public ArrayList<IGProIdentity> getIdentitys() {
        ArrayList<GProIdentity> identitys = this.mInfo.getIdentitys();
        ArrayList<IGProIdentity> arrayList = new ArrayList<>();
        Iterator<GProIdentity> it = identitys.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProIdentity(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProClientIdentityBytes
    public String toString() {
        return this.mInfo.toString();
    }
}
