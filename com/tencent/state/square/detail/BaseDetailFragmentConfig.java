package com.tencent.state.square.detail;

import android.os.Bundle;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\b&\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0019\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/square/detail/BaseDetailFragmentConfig;", "", "()V", "backgroundUrl", "", "getBackgroundUrl", "()Ljava/lang/String;", "setBackgroundUrl", "(Ljava/lang/String;)V", "enterWithScaleAnim", "", "getEnterWithScaleAnim", "()Z", "setEnterWithScaleAnim", "(Z)V", "playPagLikeType", "", "getPlayPagLikeType", "()Ljava/lang/Integer;", "setPlayPagLikeType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "userDefaultBg", "getUserDefaultBg", "setUserDefaultBg", "convertFromScheme", "bundle", "Landroid/os/Bundle;", "schemeOnceKey", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class BaseDetailFragmentConfig {
    public static final String ENTER_WITH_SCALE = "enterWithScale";
    public static final String LIKE_TYPE = "like_type";
    private String backgroundUrl = "";
    private boolean enterWithScaleAnim;
    private Integer playPagLikeType;
    private boolean userDefaultBg;

    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    public final boolean getEnterWithScaleAnim() {
        return this.enterWithScaleAnim;
    }

    public final Integer getPlayPagLikeType() {
        return this.playPagLikeType;
    }

    public final boolean getUserDefaultBg() {
        return this.userDefaultBg;
    }

    public Set<String> schemeOnceKey() {
        Set<String> mutableSetOf;
        mutableSetOf = SetsKt__SetsKt.mutableSetOf(LIKE_TYPE);
        return mutableSetOf;
    }

    public final void setBackgroundUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backgroundUrl = str;
    }

    public final void setEnterWithScaleAnim(boolean z16) {
        this.enterWithScaleAnim = z16;
    }

    public final void setPlayPagLikeType(Integer num) {
        this.playPagLikeType = num;
    }

    public final void setUserDefaultBg(boolean z16) {
        this.userDefaultBg = z16;
    }

    public BaseDetailFragmentConfig convertFromScheme(Bundle bundle) {
        if (bundle != null && bundle.containsKey(LIKE_TYPE)) {
            String string = bundle.getString(LIKE_TYPE);
            this.playPagLikeType = string != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(string) : null;
        }
        if (bundle != null && bundle.containsKey(ENTER_WITH_SCALE)) {
            this.enterWithScaleAnim = Intrinsics.areEqual(bundle.getString(ENTER_WITH_SCALE), "1");
        }
        return this;
    }
}
