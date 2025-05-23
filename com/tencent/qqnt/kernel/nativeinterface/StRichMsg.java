package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StRichMsg {
    public String content;
    public ArrayList<StMedia> mediaItems;
    public String name;
    public int type;
    public String uid;
    public String uin;
    public String url;
    public int who;

    public StRichMsg() {
        this.content = "";
        this.uid = "";
        this.name = "";
        this.url = "";
        this.uin = "";
        this.mediaItems = new ArrayList<>();
    }

    public String getContent() {
        return this.content;
    }

    public ArrayList<StMedia> getMediaItems() {
        return this.mediaItems;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUin() {
        return this.uin;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWho() {
        return this.who;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setMediaItems(ArrayList<StMedia> arrayList) {
        this.mediaItems = arrayList;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(int i3) {
        this.type = i3;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUin(String str) {
        this.uin = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setWho(int i3) {
        this.who = i3;
    }

    public StRichMsg(int i3, String str, String str2, String str3, int i16, String str4, String str5, ArrayList<StMedia> arrayList) {
        this.content = "";
        this.uid = "";
        this.name = "";
        this.url = "";
        this.uin = "";
        new ArrayList();
        this.type = i3;
        this.content = str;
        this.uid = str2;
        this.name = str3;
        this.who = i16;
        this.url = str4;
        this.uin = str5;
        this.mediaItems = arrayList;
    }
}
