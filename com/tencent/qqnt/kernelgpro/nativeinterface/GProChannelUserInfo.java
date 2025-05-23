package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProChannelUserInfo implements Serializable {
    public int memberType;
    public int roleType;
    long serialVersionUID = 1;
    public GProBaseClientIdentity clientIdentity = new GProBaseClientIdentity();
    public GProChannelUserPermission permission = new GProChannelUserPermission();
    public ArrayList<GProRoleGroupInfo> roleGroups = new ArrayList<>();
    public byte[] clientIdentityBytesBinary = new byte[0];
    public byte[] clientIdentityBytesJson = new byte[0];
    public GProVoiceLiveInfo voiceLiveInfo = new GProVoiceLiveInfo();
    public GProClientIdentityBytes clientIdentityBytes = new GProClientIdentityBytes();

    public GProBaseClientIdentity getClientIdentity() {
        return this.clientIdentity;
    }

    public GProClientIdentityBytes getClientIdentityBytes() {
        return this.clientIdentityBytes;
    }

    public byte[] getClientIdentityBytesBinary() {
        return this.clientIdentityBytesBinary;
    }

    public byte[] getClientIdentityBytesJson() {
        return this.clientIdentityBytesJson;
    }

    public int getMemberType() {
        return this.memberType;
    }

    public GProChannelUserPermission getPermission() {
        return this.permission;
    }

    public ArrayList<GProRoleGroupInfo> getRoleGroups() {
        return this.roleGroups;
    }

    public int getRoleType() {
        return this.roleType;
    }

    public GProVoiceLiveInfo getVoiceLiveInfo() {
        return this.voiceLiveInfo;
    }

    public String toString() {
        return "GProChannelUserInfo{clientIdentity=" + this.clientIdentity + ",memberType=" + this.memberType + ",permission=" + this.permission + ",roleGroups=" + this.roleGroups + ",clientIdentityBytesBinary=" + this.clientIdentityBytesBinary + ",roleType=" + this.roleType + ",clientIdentityBytesJson=" + this.clientIdentityBytesJson + ",voiceLiveInfo=" + this.voiceLiveInfo + ",clientIdentityBytes=" + this.clientIdentityBytes + ",}";
    }
}
