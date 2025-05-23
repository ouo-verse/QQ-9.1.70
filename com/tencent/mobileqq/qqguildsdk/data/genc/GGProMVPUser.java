package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPRoleGroup;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPUser;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProMVPUser implements IGProMVPUser {
    public final GProMVPUser mInfo;

    public GGProMVPUser(GProMVPUser gProMVPUser) {
        this.mInfo = gProMVPUser;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPUser
    public String getAvatar() {
        return this.mInfo.getAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPUser
    public String getNick() {
        return this.mInfo.getNick();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPUser
    public ArrayList<IGProMVPRoleGroup> getRoleGroups() {
        ArrayList<GProMVPRoleGroup> roleGroups = this.mInfo.getRoleGroups();
        ArrayList<IGProMVPRoleGroup> arrayList = new ArrayList<>();
        Iterator<GProMVPRoleGroup> it = roleGroups.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProMVPRoleGroup(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPUser
    public long getTinyid() {
        return this.mInfo.getTinyid();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPUser
    public long getUin() {
        return this.mInfo.getUin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPUser
    public String toString() {
        return this.mInfo.toString();
    }
}
