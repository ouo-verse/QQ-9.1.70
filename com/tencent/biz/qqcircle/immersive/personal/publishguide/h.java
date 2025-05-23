package com.tencent.biz.qqcircle.immersive.personal.publishguide;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\fR$\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/h;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "b", "holder", "", "a", "", "c", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/f;", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/f;", "listener", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/g;", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/g;", "getPublishGuideData", "()Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/g;", "d", "(Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/g;)V", "publishGuideData", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/f;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f listener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PublishGuideData publishGuideData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView.ViewHolder viewHolder;

    public h(@NotNull f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void a(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PublishGuideData publishGuideData = this.publishGuideData;
        if (publishGuideData != null && publishGuideData.getBannerStyle() == BannerStyle.SIDESLIP && (holder instanceof j)) {
            ((j) holder).n(publishGuideData.a());
        }
    }

    @NotNull
    public final RecyclerView.ViewHolder b(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        j a16 = j.INSTANCE.a(parent, this.listener);
        this.viewHolder = a16;
        return a16;
    }

    public final boolean c() {
        List<BannerInfo> a16;
        PublishGuideData publishGuideData = this.publishGuideData;
        if (publishGuideData == null || (a16 = publishGuideData.a()) == null || !(!a16.isEmpty())) {
            return false;
        }
        return true;
    }

    public final void d(@Nullable PublishGuideData publishGuideData) {
        this.publishGuideData = publishGuideData;
    }
}
