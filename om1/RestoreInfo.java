package om1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R!\u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013\"\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lom1/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "a", "Lcom/tencent/base/api/runtime/a;", "()Lcom/tencent/base/api/runtime/a;", "mContext", "b", "Z", "c", "()Z", "e", "(Z)V", "isFilterIllegalStateTopic", "d", "isFilterGuildRelativeSpan", "<init>", "(Lcom/tencent/base/api/runtime/a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: om1.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class RestoreInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final com.tencent.base.api.runtime.a<zl1.a> mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isFilterIllegalStateTopic;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isFilterGuildRelativeSpan;

    public RestoreInfo(@NotNull com.tencent.base.api.runtime.a<zl1.a> mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
    }

    @NotNull
    public final com.tencent.base.api.runtime.a<zl1.a> a() {
        return this.mContext;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsFilterGuildRelativeSpan() {
        return this.isFilterGuildRelativeSpan;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsFilterIllegalStateTopic() {
        return this.isFilterIllegalStateTopic;
    }

    public final void d(boolean z16) {
        this.isFilterGuildRelativeSpan = z16;
    }

    public final void e(boolean z16) {
        this.isFilterIllegalStateTopic = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof RestoreInfo) && Intrinsics.areEqual(this.mContext, ((RestoreInfo) other).mContext)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.mContext.hashCode();
    }

    @NotNull
    public String toString() {
        return "RestoreInfo(mContext=" + this.mContext + ")";
    }
}
