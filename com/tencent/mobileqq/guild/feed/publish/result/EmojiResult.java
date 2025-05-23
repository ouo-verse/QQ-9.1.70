package com.tencent.mobileqq.guild.feed.publish.result;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.feed.publish.result.AbsResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class EmojiResult extends AbsResult {

    /* renamed from: b, reason: collision with root package name */
    private final EmojiData f223163b;

    /* compiled from: P */
    @Keep
    /* loaded from: classes13.dex */
    public static class EmojiData {

        /* renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        public int f223164id;

        @SerializedName("type")
        public int type;

        @SerializedName("url")
        public String url;

        public EmojiData(int i3, int i16, String str) {
            this.type = i3;
            this.f223164id = i16;
            this.url = str;
        }
    }

    public EmojiResult(int i3, int i16, String str) {
        this.f223163b = new EmojiData(i3, i16, str);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected String a() {
        return this.f223160a.toJson(this.f223163b);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected AbsResult.Type b() {
        return AbsResult.Type.EMOJI;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    public /* bridge */ /* synthetic */ String c() {
        return super.c();
    }
}
