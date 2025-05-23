package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientIdentityBytes;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProIdentity;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProIdentityWithClientId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes17.dex */
public class GProClientIdentityByteInfo implements IGProClientIdentityByteInfo {
    private final GProClientIdentityBytes mGProClientIdentityBytes;
    private final List<IGProIdentityInfo> mGProIdentityList = new ArrayList();
    private final List<IGProIdentityInfoWithClientId> mGProDefaultIdentityList = new ArrayList();

    public GProClientIdentityByteInfo(GProClientIdentityBytes gProClientIdentityBytes) {
        this.mGProClientIdentityBytes = gProClientIdentityBytes;
        if (gProClientIdentityBytes != null) {
            Iterator<GProIdentity> it = gProClientIdentityBytes.getIdentitys().iterator();
            while (it.hasNext()) {
                this.mGProIdentityList.add(new GProIdentityInfo(it.next()));
            }
            Iterator<GProIdentityWithClientId> it5 = this.mGProClientIdentityBytes.getDefaultIdentitys().iterator();
            while (it5.hasNext()) {
                this.mGProDefaultIdentityList.add(new GProIdentityInfoWithClientId(it5.next()));
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityByteInfo
    public int getClientId() {
        return this.mGProClientIdentityBytes.getClientId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityByteInfo
    public List<IGProIdentityInfoWithClientId> getDefaultIdentityList() {
        return this.mGProDefaultIdentityList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityByteInfo
    public List<IGProIdentityInfo> getIdentityList() {
        return this.mGProIdentityList;
    }
}
