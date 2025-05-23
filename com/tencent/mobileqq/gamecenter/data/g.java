package com.tencent.mobileqq.gamecenter.data;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/g;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "mIconUrl", "c", "mDetailInfo", "<init>", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mIconUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mDetailInfo;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getMDetailInfo() {
        return this.mDetailInfo;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getMIconUrl() {
        return this.mIconUrl;
    }

    public final void c(@Nullable String str) {
        this.mDetailInfo = str;
    }

    public final void d(@Nullable String str) {
        this.mIconUrl = str;
    }
}
