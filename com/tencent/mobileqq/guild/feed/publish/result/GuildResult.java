package com.tencent.mobileqq.guild.feed.publish.result;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.feed.publish.result.AbsResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildResult extends AbsResult {

    /* renamed from: b, reason: collision with root package name */
    private final GuildData f223165b;

    /* compiled from: P */
    @Keep
    /* loaded from: classes13.dex */
    private static class GuildData {

        @SerializedName("channelId")
        public String channelId;

        @SerializedName("guildId")
        public String guildId;

        @SerializedName("nickName")
        public String nickName;

        @SerializedName("tinyId")
        public String tinyId;

        public GuildData(String str, String str2, String str3, String str4) {
            this.tinyId = str;
            this.nickName = str2;
            this.guildId = str3;
            this.channelId = str4;
        }
    }

    public GuildResult(String str, String str2, String str3, String str4) {
        this.f223165b = new GuildData(str, str2, str3, str4);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected String a() {
        return this.f223160a.toJson(this.f223165b);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected AbsResult.Type b() {
        return AbsResult.Type.GUILD_INFO;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    public /* bridge */ /* synthetic */ String c() {
        return super.c();
    }
}
