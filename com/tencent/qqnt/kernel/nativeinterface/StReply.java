package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StReply {
    public String clientKey;
    public ArrayList<StRichMsg> content;

    /* renamed from: id, reason: collision with root package name */
    public String f359225id;
    public StUser targetUser;
    public long time;
    public StUser user;

    public StReply() {
        this.f359225id = "";
        this.user = new StUser();
        this.content = new ArrayList<>();
        this.clientKey = "";
        this.targetUser = new StUser();
    }

    public String getClientKey() {
        return this.clientKey;
    }

    public ArrayList<StRichMsg> getContent() {
        return this.content;
    }

    public String getId() {
        return this.f359225id;
    }

    public StUser getTargetUser() {
        return this.targetUser;
    }

    public long getTime() {
        return this.time;
    }

    public StUser getUser() {
        return this.user;
    }

    public void setClientKey(String str) {
        this.clientKey = str;
    }

    public void setContent(ArrayList<StRichMsg> arrayList) {
        this.content = arrayList;
    }

    public void setId(String str) {
        this.f359225id = str;
    }

    public void setTargetUser(StUser stUser) {
        this.targetUser = stUser;
    }

    public void setTime(long j3) {
        this.time = j3;
    }

    public void setUser(StUser stUser) {
        this.user = stUser;
    }

    public StReply(String str, StUser stUser, ArrayList<StRichMsg> arrayList, long j3, String str2, StUser stUser2) {
        this.f359225id = "";
        this.user = new StUser();
        this.content = new ArrayList<>();
        this.clientKey = "";
        new StUser();
        this.f359225id = str;
        this.user = stUser;
        this.content = arrayList;
        this.time = j3;
        this.clientKey = str2;
        this.targetUser = stUser2;
    }
}
