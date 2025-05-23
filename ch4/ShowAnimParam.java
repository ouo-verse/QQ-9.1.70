package ch4;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lch4/y;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "keyWord", "", "J", "()J", "currentState", "Lch4/k;", "c", "Lch4/k;", "d", "()Lch4/k;", "searchBarStart", "e", "searchBarTarget", "searchBarHintPos", "<init>", "(Ljava/lang/String;JLch4/k;Lch4/k;Lch4/k;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ch4.y, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class ShowAnimParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String keyWord;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long currentState;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final RefViewPos searchBarStart;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final RefViewPos searchBarTarget;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final RefViewPos searchBarHintPos;

    public ShowAnimParam() {
        this(null, 0L, null, null, null, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getCurrentState() {
        return this.currentState;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getKeyWord() {
        return this.keyWord;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final RefViewPos getSearchBarHintPos() {
        return this.searchBarHintPos;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final RefViewPos getSearchBarStart() {
        return this.searchBarStart;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final RefViewPos getSearchBarTarget() {
        return this.searchBarTarget;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShowAnimParam)) {
            return false;
        }
        ShowAnimParam showAnimParam = (ShowAnimParam) other;
        if (Intrinsics.areEqual(this.keyWord, showAnimParam.keyWord) && this.currentState == showAnimParam.currentState && Intrinsics.areEqual(this.searchBarStart, showAnimParam.searchBarStart) && Intrinsics.areEqual(this.searchBarTarget, showAnimParam.searchBarTarget) && Intrinsics.areEqual(this.searchBarHintPos, showAnimParam.searchBarHintPos)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.keyWord.hashCode() * 31) + androidx.fragment.app.a.a(this.currentState)) * 31) + this.searchBarStart.hashCode()) * 31) + this.searchBarTarget.hashCode()) * 31) + this.searchBarHintPos.hashCode();
    }

    @NotNull
    public String toString() {
        return "ShowAnimParam(keyWord=" + this.keyWord + ", currentState=" + this.currentState + ", searchBarStart=" + this.searchBarStart + ", searchBarTarget=" + this.searchBarTarget + ", searchBarHintPos=" + this.searchBarHintPos + ")";
    }

    public ShowAnimParam(@NotNull String keyWord, long j3, @NotNull RefViewPos searchBarStart, @NotNull RefViewPos searchBarTarget, @NotNull RefViewPos searchBarHintPos) {
        Intrinsics.checkNotNullParameter(keyWord, "keyWord");
        Intrinsics.checkNotNullParameter(searchBarStart, "searchBarStart");
        Intrinsics.checkNotNullParameter(searchBarTarget, "searchBarTarget");
        Intrinsics.checkNotNullParameter(searchBarHintPos, "searchBarHintPos");
        this.keyWord = keyWord;
        this.currentState = j3;
        this.searchBarStart = searchBarStart;
        this.searchBarTarget = searchBarTarget;
        this.searchBarHintPos = searchBarHintPos;
    }

    public /* synthetic */ ShowAnimParam(String str, long j3, RefViewPos refViewPos, RefViewPos refViewPos2, RefViewPos refViewPos3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 1L : j3, (i3 & 4) != 0 ? new RefViewPos(0, 0, 0, 0, 15, null) : refViewPos, (i3 & 8) != 0 ? new RefViewPos(0, 0, 0, 0, 15, null) : refViewPos2, (i3 & 16) != 0 ? new RefViewPos(0, 0, 0, 0, 15, null) : refViewPos3);
    }
}
