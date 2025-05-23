package com.tencent.mobileqq.wink.picker.core.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkMediaPreviewViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u00a2\u0006\u0004\b2\u00103J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0014\u0010\u0014\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00120$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001d\u00101\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaPreviewThumbListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/picker/core/adapter/f;", "", "index", "", "select", "", "p0", "Landroid/view/ViewGroup;", "viewGroup", "viewType", "o0", "holder", "position", "m0", "getItemCount", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "itemInfos", "updateData", "q0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "previewViewModel", "D", "Z", "showAllMedia", "E", "Ljava/util/List;", "dataList", "", UserInfo.SEX_FEMALE, "l0", "()Ljava/util/List;", "thumbPreviewMedia", "G", "I", "curSelectIndex", "Landroid/graphics/drawable/Drawable;", "H", "Lkotlin/Lazy;", "k0", "()Landroid/graphics/drawable/Drawable;", "selectedIndicator", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;ZLjava/util/List;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMediaPreviewThumbListAdapter extends RecyclerView.Adapter<f> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private final WinkMediaPreviewViewModel previewViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private final boolean showAllMedia;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final List<LocalMediaInfo> dataList;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> thumbPreviewMedia;

    /* renamed from: G, reason: from kotlin metadata */
    private int curSelectIndex;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy selectedIndicator;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* JADX WARN: Multi-variable type inference failed */
    public WinkMediaPreviewThumbListAdapter(@NotNull Context context, @Nullable WinkMediaPreviewViewModel winkMediaPreviewViewModel, boolean z16, @Nullable List<? extends LocalMediaInfo> list) {
        Lazy lazy;
        WinkSelectedMediaViewModel selectedMediaViewModel;
        List<LocalMediaInfo> selectedMedia;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.previewViewModel = winkMediaPreviewViewModel;
        this.showAllMedia = z16;
        this.dataList = list;
        this.thumbPreviewMedia = new ArrayList();
        this.curSelectIndex = -1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.mobileqq.wink.picker.core.adapter.WinkMediaPreviewThumbListAdapter$selectedIndicator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Drawable invoke() {
                Context context2;
                context2 = WinkMediaPreviewThumbListAdapter.this.context;
                return ContextCompat.getDrawable(context2, R.drawable.l6a);
            }
        });
        this.selectedIndicator = lazy;
        updateData((winkMediaPreviewViewModel == null || (selectedMediaViewModel = winkMediaPreviewViewModel.getSelectedMediaViewModel()) == null || (selectedMedia = selectedMediaViewModel.getSelectedMedia()) == null) ? CollectionsKt__CollectionsKt.emptyList() : selectedMedia);
    }

    private final Drawable k0() {
        return (Drawable) this.selectedIndicator.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(WinkMediaPreviewThumbListAdapter this$0, LocalMediaInfo info, int i3, View view) {
        List<LocalMediaInfo> list;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        if (this$0.showAllMedia) {
            list = this$0.dataList;
        } else {
            WinkMediaPreviewViewModel winkMediaPreviewViewModel = this$0.previewViewModel;
            if (winkMediaPreviewViewModel != null) {
                list = winkMediaPreviewViewModel.T1();
            } else {
                list = null;
            }
        }
        if (list != null) {
            Iterator<LocalMediaInfo> it = list.iterator();
            boolean z16 = false;
            int i16 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(it.next(), info)) {
                        break;
                    } else {
                        i16++;
                    }
                } else {
                    i16 = -1;
                    break;
                }
            }
            if (i16 != -1) {
                WinkMediaPreviewViewModel winkMediaPreviewViewModel2 = this$0.previewViewModel;
                if (winkMediaPreviewViewModel2 != null && winkMediaPreviewViewModel2.getCurPreviewMediaLayoutPosition() == i3) {
                    z16 = true;
                }
                if (!z16) {
                    com.tencent.mobileqq.wink.picker.report.a.i("1");
                }
                WinkMediaPreviewViewModel winkMediaPreviewViewModel3 = this$0.previewViewModel;
                if (winkMediaPreviewViewModel3 != null) {
                    winkMediaPreviewViewModel3.N1(i16, info);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void p0(int index, boolean select) {
        int i3;
        if (index >= 0 && index < this.thumbPreviewMedia.size()) {
            if (select && this.curSelectIndex != index) {
                i3 = index;
            } else {
                i3 = -1;
            }
            this.curSelectIndex = i3;
            notifyItemChanged(index, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.thumbPreviewMedia.size();
    }

    @NotNull
    public final List<LocalMediaInfo> l0() {
        return this.thumbPreviewMedia;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull f holder, final int position) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final LocalMediaInfo localMediaInfo = this.thumbPreviewMedia.get(position);
        holder.l(localMediaInfo);
        SquareImageView selectedThumbImg = holder.getSelectedThumbImg();
        if (position == this.curSelectIndex) {
            drawable = k0();
        } else {
            drawable = null;
        }
        selectedThumbImg.setForeground(drawable);
        holder.getSelectedThumbImg().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.adapter.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkMediaPreviewThumbListAdapter.n0(WinkMediaPreviewThumbListAdapter.this, localMediaInfo, position, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public f onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.i6g, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new f(itemView);
    }

    public final void q0(int index) {
        if (index >= 0) {
            int i3 = this.curSelectIndex;
            if (i3 < 0) {
                p0(index, true);
                return;
            } else {
                p0(i3, false);
                p0(index, true);
                return;
            }
        }
        int i16 = this.curSelectIndex;
        if (i16 >= 0) {
            p0(i16, false);
        }
    }

    public final void updateData(@NotNull List<? extends LocalMediaInfo> itemInfos) {
        Intrinsics.checkNotNullParameter(itemInfos, "itemInfos");
        this.thumbPreviewMedia.clear();
        this.thumbPreviewMedia.addAll(itemInfos);
        notifyDataSetChanged();
    }
}
