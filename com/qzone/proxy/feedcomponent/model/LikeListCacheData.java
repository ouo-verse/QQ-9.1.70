package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_EXTRA.s_likeman;
import NS_MOBILE_EXTRA.s_user;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class LikeListCacheData implements SmartParcelable {
    public static final String STORE_KEY = "LikeListCacheDataStoreKey";
    long cruUin;

    @NeedParcel
    long friend_num;

    @NeedParcel
    int hasmore;

    @NeedParcel
    long total_num;
    String feedID = "";

    @NeedParcel
    ArrayList<LikeItem> list = new ArrayList<>();

    @NeedParcel
    String attach_info = "";

    public void addItem(long j3, String str) {
        LikeItem likeItem = new LikeItem(j3, str);
        ArrayList<LikeItem> arrayList = this.list;
        if (arrayList != null) {
            arrayList.add(likeItem);
            return;
        }
        ArrayList<LikeItem> arrayList2 = new ArrayList<>();
        this.list = arrayList2;
        arrayList2.add(likeItem);
    }

    public void appendList(ArrayList<s_likeman> arrayList) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        Iterator<s_likeman> it = arrayList.iterator();
        while (it.hasNext()) {
            s_likeman next = it.next();
            ArrayList<LikeItem> arrayList2 = this.list;
            s_user s_userVar = next.user;
            arrayList2.add(new LikeItem(s_userVar.uin, s_userVar.nickname));
        }
    }

    public String getAttach_info() {
        return this.attach_info;
    }

    public long getCruUin() {
        return this.cruUin;
    }

    public String getFeedID() {
        return this.feedID;
    }

    public long getFriend_num() {
        return this.friend_num;
    }

    public int getHasmore() {
        return this.hasmore;
    }

    public ArrayList<LikeItem> getList() {
        return this.list;
    }

    public long getTotal_num() {
        return this.total_num;
    }

    public void setAttach_info(String str) {
        this.attach_info = str;
    }

    public void setCruUin(long j3) {
        this.cruUin = j3;
    }

    public void setFeedID(String str) {
        this.feedID = str;
    }

    public void setFriend_num(long j3) {
        this.friend_num = j3;
    }

    public void setHasmore(int i3) {
        this.hasmore = i3;
    }

    public void setList(ArrayList<s_likeman> arrayList) {
        this.list.clear();
        Iterator<s_likeman> it = arrayList.iterator();
        while (it.hasNext()) {
            s_likeman next = it.next();
            ArrayList<LikeItem> arrayList2 = this.list;
            s_user s_userVar = next.user;
            arrayList2.add(new LikeItem(this, s_userVar.uin, s_userVar.nickname, s_userVar.isSuperLike));
        }
    }

    public void setTotal_num(long j3) {
        this.total_num = j3;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class LikeItem implements SmartParcelable {

        @NeedParcel
        public boolean isSuperLike;

        @NeedParcel
        public String nickname;

        @NeedParcel
        public long uin;

        public LikeItem() {
            this.nickname = "";
        }

        public LikeItem(long j3, String str) {
            this.uin = j3;
            this.nickname = str;
        }

        public LikeItem(LikeListCacheData likeListCacheData, long j3, String str, boolean z16) {
            this(j3, str);
            this.isSuperLike = z16;
        }
    }

    public void appendFrom(LikeListCacheData likeListCacheData) {
        if (likeListCacheData == null) {
            return;
        }
        this.hasmore = likeListCacheData.hasmore;
        this.friend_num += likeListCacheData.friend_num;
        this.total_num = likeListCacheData.total_num;
        this.attach_info = likeListCacheData.attach_info;
        this.list.addAll(likeListCacheData.list);
    }

    public void copyFrom(LikeListCacheData likeListCacheData) {
        if (likeListCacheData == null) {
            return;
        }
        this.hasmore = likeListCacheData.hasmore;
        this.friend_num = likeListCacheData.friend_num;
        this.total_num = likeListCacheData.total_num;
        this.attach_info = likeListCacheData.attach_info;
        this.list.clear();
        this.list.addAll(likeListCacheData.list);
    }
}
