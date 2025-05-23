package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildMemberSearchResult {
    public ArrayList<GProUser> members;
    public long nextPos;
    public ArrayList<GProGuildRole> roles;

    public GProGuildMemberSearchResult() {
        this.members = new ArrayList<>();
        this.roles = new ArrayList<>();
    }

    public ArrayList<GProUser> getMembers() {
        return this.members;
    }

    public long getNextPos() {
        return this.nextPos;
    }

    public ArrayList<GProGuildRole> getRoles() {
        return this.roles;
    }

    public String toString() {
        return "GProGuildMemberSearchResult{nextPos=" + this.nextPos + ",members=" + this.members + ",roles=" + this.roles + ",}";
    }

    public GProGuildMemberSearchResult(long j3, ArrayList<GProUser> arrayList, ArrayList<GProGuildRole> arrayList2) {
        this.members = new ArrayList<>();
        new ArrayList();
        this.nextPos = j3;
        this.members = arrayList;
        this.roles = arrayList2;
    }
}
