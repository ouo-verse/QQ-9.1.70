package com.tencent.mobileqq.guild.feed.publish.result;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.feed.publish.result.AbsResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class SwitchResult extends AbsResult {

    /* renamed from: b, reason: collision with root package name */
    private final SwitchData f223171b;

    /* compiled from: P */
    @Keep
    /* loaded from: classes13.dex */
    private class SwitchData {

        @SerializedName("feedJson")
        public String feedJson;

        public SwitchData(String str) {
            this.feedJson = str;
        }
    }

    public SwitchResult(String str) {
        this.f223171b = new SwitchData(str);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected String a() {
        return this.f223160a.toJson(this.f223171b);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected AbsResult.Type b() {
        return AbsResult.Type.SWITCH_H5_EDITOR;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    public /* bridge */ /* synthetic */ String c() {
        return super.c();
    }
}
