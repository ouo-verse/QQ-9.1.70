package aw1;

import com.tencent.mobileqq.qqguildsdk.data.eu;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0012"}, d2 = {"Law1/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "medalUrl", "medalDesc", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: aw1.m, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class MedalItem {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String medalUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String medalDesc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ&\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007\u00a8\u0006\u000b"}, d2 = {"Law1/m$a;", "", "", "Lcom/tencent/mobileqq/qqguildsdk/data/eu;", "medalList", "Ljava/util/ArrayList;", "Law1/m;", "Lkotlin/collections/ArrayList;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: aw1.m$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final ArrayList<MedalItem> a(@NotNull List<? extends eu> medalList) {
            Intrinsics.checkNotNullParameter(medalList, "medalList");
            ArrayList<MedalItem> arrayList = new ArrayList<>();
            for (eu euVar : medalList) {
                String url = euVar.getUrl();
                Intrinsics.checkNotNullExpressionValue(url, "it.url");
                String desc = euVar.getDesc();
                Intrinsics.checkNotNullExpressionValue(desc, "it.desc");
                arrayList.add(new MedalItem(url, desc));
            }
            return arrayList;
        }

        Companion() {
        }
    }

    public MedalItem(@NotNull String medalUrl, @NotNull String medalDesc) {
        Intrinsics.checkNotNullParameter(medalUrl, "medalUrl");
        Intrinsics.checkNotNullParameter(medalDesc, "medalDesc");
        this.medalUrl = medalUrl;
        this.medalDesc = medalDesc;
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<MedalItem> c(@NotNull List<? extends eu> list) {
        return INSTANCE.a(list);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getMedalDesc() {
        return this.medalDesc;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getMedalUrl() {
        return this.medalUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MedalItem)) {
            return false;
        }
        MedalItem medalItem = (MedalItem) other;
        if (Intrinsics.areEqual(this.medalUrl, medalItem.medalUrl) && Intrinsics.areEqual(this.medalDesc, medalItem.medalDesc)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.medalUrl.hashCode() * 31) + this.medalDesc.hashCode();
    }

    @NotNull
    public String toString() {
        return "MedalItem(medalUrl=" + this.medalUrl + ", medalDesc=" + this.medalDesc + ")";
    }
}
