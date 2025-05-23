package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0015\u001a\u0004\b\u0003\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/a;", "", "", "a", "Ljava/lang/String;", "getMPenetrateInfo", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "mPenetrateInfo", "", "b", "Z", "()Z", "d", "(Z)V", "mIsReachUnlockCondition", "c", "e", "mIsRealUnlock", "", "Ljava/util/Map;", "()Ljava/util/Map;", "setMAdExtraMap", "(Ljava/util/Map;)V", "mAdExtraMap", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mPenetrateInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mIsReachUnlockCondition;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mIsRealUnlock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, String> mAdExtraMap = new LinkedHashMap();

    @NotNull
    public final Map<String, String> a() {
        return this.mAdExtraMap;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getMIsReachUnlockCondition() {
        return this.mIsReachUnlockCondition;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getMIsRealUnlock() {
        return this.mIsRealUnlock;
    }

    public final void d(boolean z16) {
        this.mIsReachUnlockCondition = z16;
    }

    public final void e(boolean z16) {
        this.mIsRealUnlock = z16;
    }

    public final void f(@Nullable String str) {
        this.mPenetrateInfo = str;
    }
}
