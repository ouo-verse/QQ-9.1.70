package com.tencent.mobileqq.data;

import android.annotation.SuppressLint;
import android.database.Cursor;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QQGuildGuildEntry extends Entity {
    public String avatarUrl;

    @unique
    public String guildId;
    public String guildName;
    public int userType;

    public QQGuildGuildEntry() {
    }

    public static QQGuildGuildEntry fromGuildInfo(IGProGuildInfo iGProGuildInfo) {
        QQGuildGuildEntry qQGuildGuildEntry = new QQGuildGuildEntry();
        qQGuildGuildEntry.guildId = iGProGuildInfo.getGuildID();
        qQGuildGuildEntry.guildName = iGProGuildInfo.getGuildName();
        qQGuildGuildEntry.userType = iGProGuildInfo.getUserType();
        qQGuildGuildEntry.avatarUrl = iGProGuildInfo.getAvatarUrl(100);
        return qQGuildGuildEntry;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    @SuppressLint({"Range"})
    public boolean entityByCursor(Cursor cursor) {
        this.guildName = cursor.getString(cursor.getColumnIndex("guildName"));
        this.guildId = cursor.getString(cursor.getColumnIndex("guildId"));
        this.userType = cursor.getInt(cursor.getColumnIndex(MessageRoamJsPlugin.USERTYPE));
        this.avatarUrl = cursor.getString(cursor.getColumnIndex(PhotoCategorySummaryInfo.AVATAR_URL));
        return true;
    }

    public String toString() {
        return "QQGuildGuildEntry{guildName='" + this.guildName + "', guildId='" + this.guildId + "', userType=" + this.userType + ", avatarUrl='" + this.avatarUrl + "'}";
    }

    public QQGuildGuildEntry(String str, String str2, int i3, String str3) {
        this.guildId = str;
        this.guildName = str2;
        this.userType = i3;
        this.avatarUrl = str3;
    }
}
