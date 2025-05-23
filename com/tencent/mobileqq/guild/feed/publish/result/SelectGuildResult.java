package com.tencent.mobileqq.guild.feed.publish.result;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.feed.publish.result.AbsResult;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class SelectGuildResult extends AbsResult {

    /* renamed from: b, reason: collision with root package name */
    private final a f223168b;

    /* compiled from: P */
    @Keep
    /* loaded from: classes13.dex */
    private static class GuildHashtagBean {

        @SerializedName("channelId")
        public String channelId;

        @SerializedName("channelName")
        public String channelName;

        @SerializedName("guildId")
        public String guildId;

        @SerializedName("isSquare")
        public boolean isSquare;

        public GuildHashtagBean(String str, String str2, String str3, boolean z16) {
            this.guildId = str;
            this.channelId = str2;
            this.channelName = str3;
            this.isSquare = z16;
        }
    }

    public SelectGuildResult(String str, String str2, String str3, boolean z16) {
        this.f223168b = new a(str, str2, str3, z16);
    }

    public static String d() {
        return new Gson().toJson(new a());
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected String a() {
        return this.f223160a.toJson(this.f223168b);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected AbsResult.Type b() {
        return AbsResult.Type.SELECT_GUILD;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    public /* bridge */ /* synthetic */ String c() {
        return super.c();
    }

    public String e() {
        return this.f223160a.toJson(this.f223168b);
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    private static class a {

        @SerializedName("data")
        public List<GuildHashtagBean> data;

        public a() {
            this.data = new ArrayList();
        }

        public a(String str, String str2, String str3, boolean z16) {
            GuildHashtagBean guildHashtagBean = new GuildHashtagBean(str, str2, str3, z16);
            ArrayList arrayList = new ArrayList();
            this.data = arrayList;
            arrayList.add(guildHashtagBean);
        }
    }
}
