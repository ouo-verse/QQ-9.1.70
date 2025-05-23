package com.tencent.now.pkgame.pkgame.scorebar.view;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/now/pkgame/pkgame/scorebar/view/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", LocalPhotoFaceInfo.SCORE, "b", "side", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "c", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.now.pkgame.pkgame.scorebar.view.a, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class AddScoreBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String score;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String side;

    public AddScoreBean(@NotNull String score, @NotNull String side) {
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(side, "side");
        this.score = score;
        this.side = side;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getScore() {
        return this.score;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getSide() {
        return this.side;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddScoreBean)) {
            return false;
        }
        AddScoreBean addScoreBean = (AddScoreBean) other;
        if (Intrinsics.areEqual(this.score, addScoreBean.score) && Intrinsics.areEqual(this.side, addScoreBean.side)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.score.hashCode() * 31) + this.side.hashCode();
    }

    @NotNull
    public String toString() {
        return "AddScoreBean(score=" + this.score + ", side=" + this.side + ")";
    }
}
