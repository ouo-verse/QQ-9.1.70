package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StLike {
    public int count;

    /* renamed from: id, reason: collision with root package name */
    public String f359224id;
    public int ownerStatus;
    public StUser postUser;
    public int status;

    public StLike() {
        this.f359224id = "";
        this.postUser = new StUser();
    }

    public int getCount() {
        return this.count;
    }

    public String getId() {
        return this.f359224id;
    }

    public int getOwnerStatus() {
        return this.ownerStatus;
    }

    public StUser getPostUser() {
        return this.postUser;
    }

    public int getStatus() {
        return this.status;
    }

    public void setCount(int i3) {
        this.count = i3;
    }

    public void setId(String str) {
        this.f359224id = str;
    }

    public void setOwnerStatus(int i3) {
        this.ownerStatus = i3;
    }

    public void setPostUser(StUser stUser) {
        this.postUser = stUser;
    }

    public void setStatus(int i3) {
        this.status = i3;
    }

    public StLike(String str, int i3, int i16, StUser stUser, int i17) {
        this.f359224id = "";
        new StUser();
        this.f359224id = str;
        this.count = i3;
        this.status = i16;
        this.postUser = stUser;
        this.ownerStatus = i17;
    }
}
