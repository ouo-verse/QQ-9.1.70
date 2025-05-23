package com.tencent.biz.qqcircle.immersive.search.prompt.tag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import circlesearch.CircleSearchExhibition$PromptTagInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\b\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\u000b\u001a\u00020\n2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/tag/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/tag/d;", "", com.tencent.luggage.wxa.c8.c.G, "", "i0", "", "Lcirclesearch/CircleSearchExhibition$PromptTagInfo;", "list", "", "setData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "k0", "getItemCount", "viewHodler", "position", "j0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "data", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a extends RecyclerView.Adapter<d> {
    private static final float D = ViewUtils.dip2px(8.0f);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<CircleSearchExhibition$PromptTagInfo> data = new ArrayList();

    private final float[] i0(int pos) {
        if (pos >= 0 && pos < this.data.size()) {
            if (pos == 0) {
                float f16 = D;
                return new float[]{f16, f16, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            }
            if (pos == 1) {
                float f17 = D;
                return new float[]{0.0f, 0.0f, f17, f17, 0.0f, 0.0f, 0.0f, 0.0f};
            }
            if (pos == this.data.size() - 2) {
                float f18 = D;
                return new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f18, f18};
            }
            if (pos == this.data.size() - 1) {
                float f19 = D;
                return new float[]{0.0f, 0.0f, 0.0f, 0.0f, f19, f19, 0.0f, 0.0f};
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull d viewHodler, int position) {
        Intrinsics.checkNotNullParameter(viewHodler, "viewHodler");
        viewHodler.q(i0(position));
        viewHodler.m(this.data.get(position), position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public d onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gr_, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new d(itemView);
    }

    public final void setData(@Nullable List<CircleSearchExhibition$PromptTagInfo> list) {
        this.data.clear();
        if (list != null) {
            this.data.addAll(list);
        }
        notifyDataSetChanged();
    }
}
