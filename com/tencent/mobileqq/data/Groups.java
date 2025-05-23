package com.tencent.mobileqq.data;

import android.annotation.SuppressLint;
import android.database.Cursor;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes10.dex */
public class Groups extends Entity {
    public int group_friend_count;

    @unique
    public int group_id;
    public String group_name;
    public byte seqid;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    @SuppressLint({"Range"})
    public boolean entityByCursor(Cursor cursor) {
        this.group_name = cursor.getString(cursor.getColumnIndex("group_name"));
        this.group_id = cursor.getInt(cursor.getColumnIndex("group_id"));
        this.group_friend_count = cursor.getInt(cursor.getColumnIndex("group_friend_count"));
        this.seqid = (byte) cursor.getShort(cursor.getColumnIndex("seqid"));
        return true;
    }

    public String toString() {
        return "Groups{group_name='" + this.group_name + "', group_id=" + this.group_id + ", group_friend_count=" + this.group_friend_count + ", seqid=" + ((int) this.seqid) + '}';
    }
}
