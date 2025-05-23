package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StComment {
    public String clientKey;
    public ArrayList<StRichMsg> content;

    /* renamed from: id, reason: collision with root package name */
    public String f359223id;
    public ArrayList<StMedia> mediaItems;
    public long replyNum;
    public ArrayList<StReply> replys;
    public long time;
    public StUser user;

    public StComment() {
        this.f359223id = "";
        this.user = new StUser();
        this.content = new ArrayList<>();
        this.replys = new ArrayList<>();
        this.clientKey = "";
        this.mediaItems = new ArrayList<>();
    }

    public String getClientKey() {
        return this.clientKey;
    }

    public ArrayList<StRichMsg> getContent() {
        return this.content;
    }

    public String getId() {
        return this.f359223id;
    }

    public ArrayList<StMedia> getMediaItems() {
        return this.mediaItems;
    }

    public long getReplyNum() {
        return this.replyNum;
    }

    public ArrayList<StReply> getReplys() {
        return this.replys;
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
        this.f359223id = str;
    }

    public void setMediaItems(ArrayList<StMedia> arrayList) {
        this.mediaItems = arrayList;
    }

    public void setReplyNum(long j3) {
        this.replyNum = j3;
    }

    public void setReplys(ArrayList<StReply> arrayList) {
        this.replys = arrayList;
    }

    public void setTime(long j3) {
        this.time = j3;
    }

    public void setUser(StUser stUser) {
        this.user = stUser;
    }

    public StComment(String str, StUser stUser, ArrayList<StRichMsg> arrayList, long j3, ArrayList<StReply> arrayList2, long j16, String str2, ArrayList<StMedia> arrayList3) {
        this.f359223id = "";
        this.user = new StUser();
        this.content = new ArrayList<>();
        this.replys = new ArrayList<>();
        this.clientKey = "";
        new ArrayList();
        this.f359223id = str;
        this.user = stUser;
        this.content = arrayList;
        this.time = j3;
        this.replys = arrayList2;
        this.replyNum = j16;
        this.clientKey = str2;
        this.mediaItems = arrayList3;
    }
}
