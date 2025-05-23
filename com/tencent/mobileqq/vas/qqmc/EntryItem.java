package com.tencent.mobileqq.vas.qqmc;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/qqmc/EntryItem;", "", "tip", "", "keyWord", WadlProxyConsts.KEY_JUMP_URL, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getJumpUrl", "()Ljava/lang/String;", "getKeyWord", "getTip", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final /* data */ class EntryItem {

    @NotNull
    private final String jumpUrl;

    @NotNull
    private final String keyWord;

    @NotNull
    private final String tip;

    public EntryItem(@NotNull String tip, @NotNull String keyWord, @NotNull String jumpUrl) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        Intrinsics.checkNotNullParameter(keyWord, "keyWord");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        this.tip = tip;
        this.keyWord = keyWord;
        this.jumpUrl = jumpUrl;
    }

    public static /* synthetic */ EntryItem copy$default(EntryItem entryItem, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = entryItem.tip;
        }
        if ((i3 & 2) != 0) {
            str2 = entryItem.keyWord;
        }
        if ((i3 & 4) != 0) {
            str3 = entryItem.jumpUrl;
        }
        return entryItem.copy(str, str2, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getTip() {
        return this.tip;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getKeyWord() {
        return this.keyWord;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    public final EntryItem copy(@NotNull String tip, @NotNull String keyWord, @NotNull String jumpUrl) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        Intrinsics.checkNotNullParameter(keyWord, "keyWord");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        return new EntryItem(tip, keyWord, jumpUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntryItem)) {
            return false;
        }
        EntryItem entryItem = (EntryItem) other;
        if (Intrinsics.areEqual(this.tip, entryItem.tip) && Intrinsics.areEqual(this.keyWord, entryItem.keyWord) && Intrinsics.areEqual(this.jumpUrl, entryItem.jumpUrl)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    public final String getKeyWord() {
        return this.keyWord;
    }

    @NotNull
    public final String getTip() {
        return this.tip;
    }

    public int hashCode() {
        return (((this.tip.hashCode() * 31) + this.keyWord.hashCode()) * 31) + this.jumpUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "EntryItem(tip=" + this.tip + ", keyWord=" + this.keyWord + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
