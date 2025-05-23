package com.tencent.mobileqq.wink.editor.music.vo;

import com.epicgames.ue4.GameActivity;
import com.tencent.mobileqq.wink.editor.music.fragments.WinkMusicListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/vo/MusicRspResult;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment$MusicRequestType;", "a", "Lcom/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment$MusicRequestType;", "getCategoryInfo", "()Lcom/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment$MusicRequestType;", "categoryInfo", "Lcom/tencent/mobileqq/wink/editor/music/vo/MusicRspResult$Result;", "b", "Lcom/tencent/mobileqq/wink/editor/music/vo/MusicRspResult$Result;", "()Lcom/tencent/mobileqq/wink/editor/music/vo/MusicRspResult$Result;", "result", "<init>", "(Lcom/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment$MusicRequestType;Lcom/tencent/mobileqq/wink/editor/music/vo/MusicRspResult$Result;)V", GameActivity.DOWNLOAD_RETURN_NAME, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class MusicRspResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final WinkMusicListFragment.MusicRequestType categoryInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Result result;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/vo/MusicRspResult$Result;", "", "(Ljava/lang/String;I)V", "SUCCESS", "NO_NET", "LOADING", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum Result {
        SUCCESS,
        NO_NET,
        LOADING
    }

    public MusicRspResult(@NotNull WinkMusicListFragment.MusicRequestType categoryInfo, @NotNull Result result) {
        Intrinsics.checkNotNullParameter(categoryInfo, "categoryInfo");
        Intrinsics.checkNotNullParameter(result, "result");
        this.categoryInfo = categoryInfo;
        this.result = result;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Result getResult() {
        return this.result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MusicRspResult)) {
            return false;
        }
        MusicRspResult musicRspResult = (MusicRspResult) other;
        if (this.categoryInfo == musicRspResult.categoryInfo && this.result == musicRspResult.result) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.categoryInfo.hashCode() * 31) + this.result.hashCode();
    }

    @NotNull
    public String toString() {
        return "MusicRspResult(categoryInfo=" + this.categoryInfo + ", result=" + this.result + ")";
    }
}
