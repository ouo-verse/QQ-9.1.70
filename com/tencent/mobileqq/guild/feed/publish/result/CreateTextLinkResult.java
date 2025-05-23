package com.tencent.mobileqq.guild.feed.publish.result;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.feed.publish.result.AbsResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class CreateTextLinkResult extends AbsResult {

    /* renamed from: b, reason: collision with root package name */
    private final CreateTextLinkData f223161b;

    /* compiled from: P */
    @Keep
    /* loaded from: classes13.dex */
    private static class CreateTextLinkData {

        @SerializedName("desc")
        public String desc;

        @SerializedName("url")
        public String url;

        public CreateTextLinkData(String str, String str2) {
            this.url = str;
            this.desc = str2;
        }
    }

    public CreateTextLinkResult(String str, String str2) {
        this.f223161b = new CreateTextLinkData(str, str2);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected String a() {
        return this.f223160a.toJson(this.f223161b);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected AbsResult.Type b() {
        return AbsResult.Type.CREATE_TEXT_LINK;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    public /* bridge */ /* synthetic */ String c() {
        return super.c();
    }
}
