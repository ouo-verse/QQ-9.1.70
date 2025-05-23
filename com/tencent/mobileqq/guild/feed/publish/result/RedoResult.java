package com.tencent.mobileqq.guild.feed.publish.result;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.feed.publish.result.AbsResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class RedoResult extends AbsResult {

    /* renamed from: b, reason: collision with root package name */
    private final RedoData f223167b;

    /* compiled from: P */
    @Keep
    /* loaded from: classes13.dex */
    private static class RedoData {

        @SerializedName("redo")
        public boolean redo;

        public RedoData(boolean z16) {
            this.redo = z16;
        }
    }

    public RedoResult(boolean z16) {
        this.f223167b = new RedoData(z16);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected String a() {
        return this.f223160a.toJson(this.f223167b);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected AbsResult.Type b() {
        return AbsResult.Type.REDO;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    public /* bridge */ /* synthetic */ String c() {
        return super.c();
    }
}
