package a44;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"La44/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "title", "", "La44/f;", "Ljava/util/List;", "()Ljava/util/List;", "styleDatas", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: a44.g, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class StyleFunction {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<StyleData> styleDatas;

    public StyleFunction(@NotNull String title, @Nullable List<StyleData> list) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        this.styleDatas = list;
    }

    @Nullable
    public final List<StyleData> a() {
        return this.styleDatas;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StyleFunction)) {
            return false;
        }
        StyleFunction styleFunction = (StyleFunction) other;
        if (Intrinsics.areEqual(this.title, styleFunction.title) && Intrinsics.areEqual(this.styleDatas, styleFunction.styleDatas)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.title.hashCode() * 31;
        List<StyleData> list = this.styleDatas;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "StyleFunction(title=" + this.title + ", styleDatas=" + this.styleDatas + ")";
    }
}
