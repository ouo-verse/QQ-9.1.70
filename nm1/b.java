package nm1;

import android.text.Editable;
import android.util.SparseArray;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import fm1.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B;\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u0004\u0012\u0006\u0010\r\u001a\u00020\t\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001d\u0010\u001eR%\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lnm1/b;", "", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "a", "Lcom/tencent/base/api/runtime/a;", "()Lcom/tencent/base/api/runtime/a;", "baseContext", "Landroid/text/Editable;", "b", "Landroid/text/Editable;", "()Landroid/text/Editable;", "editable", "", "Lfm1/i;", "c", "Ljava/util/List;", "()Ljava/util/List;", "mediaList", "", "d", "I", "()I", "unmodifiableMediaSize", "Landroid/util/SparseArray;", "e", "Landroid/util/SparseArray;", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "<init>", "(Lcom/tencent/base/api/runtime/a;Landroid/text/Editable;Ljava/util/List;I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.base.api.runtime.a<zl1.a> baseContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Editable editable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<i> mediaList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int unmodifiableMediaSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SparseArray<Object> elements;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@Nullable com.tencent.base.api.runtime.a<zl1.a> aVar, @NotNull Editable editable, @NotNull List<? extends i> mediaList, int i3) {
        Intrinsics.checkNotNullParameter(editable, "editable");
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        this.baseContext = aVar;
        this.editable = editable;
        this.mediaList = mediaList;
        this.unmodifiableMediaSize = i3;
        this.elements = new SparseArray<>();
    }

    @Nullable
    public final com.tencent.base.api.runtime.a<zl1.a> a() {
        return this.baseContext;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final Editable getEditable() {
        return this.editable;
    }

    @NotNull
    public final List<i> c() {
        return this.mediaList;
    }

    /* renamed from: d, reason: from getter */
    public final int getUnmodifiableMediaSize() {
        return this.unmodifiableMediaSize;
    }
}
