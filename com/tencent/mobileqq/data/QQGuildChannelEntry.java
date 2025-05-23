package com.tencent.mobileqq.data;

import android.annotation.SuppressLint;
import android.database.Cursor;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.cy;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QQGuildChannelEntry extends Entity implements Cloneable {
    public String guildId;
    public String name;
    public int type;

    @unique
    public String uin;

    public QQGuildChannelEntry() {
    }

    public static QQGuildChannelEntry ofGuildChannel(String str, IGProChannelInfo iGProChannelInfo) {
        return new QQGuildChannelEntry(iGProChannelInfo.getChannelUin(), str, 10014, iGProChannelInfo.getChannelName());
    }

    public static QQGuildChannelEntry ofGuildGroup(String str, cy cyVar) {
        return new QQGuildChannelEntry(String.valueOf(cyVar.getCategoryId()), str, 10016, cyVar.getCategoryName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    @SuppressLint({"Range"})
    public boolean entityByCursor(Cursor cursor) {
        this.uin = cursor.getString(cursor.getColumnIndex("uin"));
        this.guildId = cursor.getString(cursor.getColumnIndex("guildId"));
        this.type = cursor.getInt(cursor.getColumnIndex("type"));
        this.name = cursor.getString(cursor.getColumnIndex("name"));
        return true;
    }

    public String toString() {
        return "QQGuildChannelEntry{uin='" + this.uin + "', guildId='" + this.guildId + "', type=" + this.type + ", name='" + this.name + "'}";
    }

    public QQGuildChannelEntry(String str, String str2, int i3, String str3) {
        this.uin = str;
        this.guildId = str2;
        this.type = i3;
        this.name = str3;
    }
}
