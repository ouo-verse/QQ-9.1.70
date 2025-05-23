package pn1;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B'\b\u0004\u0012\n\u0010\u0016\u001a\u00060\u0002j\u0002`\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u0082\u0001\u0006\u001b\u001c\u001d\u001e\u001f \u00a8\u0006!"}, d2 = {"Lpn1/a;", "Lzg1/b;", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "Lzg1/a;", "newItem", "", "b", "", "getItemId", "Lpn1/b;", "d", "Lpn1/b;", "f", "()Lpn1/b;", "ext", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "e", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "g", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "getRawFeedData", "data", "", "type", "<init>", "(Lqj1/h;Lpn1/b;I)V", "Lpn1/c;", "Lpn1/d;", "Lpn1/e;", "Lpn1/f;", "Lpn1/g;", "Lpn1/h;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a extends zg1.b<qj1.h> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final SearchDataExt ext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProStFeed getRawFeedData;

    public /* synthetic */ a(qj1.h hVar, SearchDataExt searchDataExt, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(hVar, searchDataExt, i3);
    }

    @Override // zg1.a
    public boolean b(@NotNull zg1.a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (newItem instanceof a) {
            a aVar = (a) newItem;
            if (Intrinsics.areEqual(aVar.d().getFeedId(), d().getFeedId()) && Intrinsics.areEqual(aVar.ext, this.ext)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final SearchDataExt getExt() {
        return this.ext;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final GProStFeed getGetRawFeedData() {
        return this.getRawFeedData;
    }

    @Override // zg1.a
    public long getItemId() {
        return d().getFeedId().hashCode();
    }

    a(qj1.h hVar, SearchDataExt searchDataExt, int i3) {
        super(hVar, i3);
        this.ext = searchDataExt;
        Object a16 = hVar.a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
        this.getRawFeedData = (GProStFeed) a16;
    }
}
