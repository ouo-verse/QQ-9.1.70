package com.tencent.mobileqq.guild.feed.publish.result;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.feed.publish.result.AbsResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class DraftResult extends AbsResult {

    /* renamed from: b, reason: collision with root package name */
    private final DraftData f223162b;

    /* compiled from: P */
    @Keep
    /* loaded from: classes13.dex */
    private class DraftData {

        @SerializedName("feedJson")
        public String feedJson;

        public DraftData(String str) {
            this.feedJson = str;
        }
    }

    public DraftResult(String str) {
        this.f223162b = new DraftData(str);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected String a() {
        return this.f223160a.toJson(this.f223162b);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected AbsResult.Type b() {
        return AbsResult.Type.EDIT_DRAFT;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    public /* bridge */ /* synthetic */ String c() {
        return super.c();
    }
}
