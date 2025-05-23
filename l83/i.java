package l83;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioHistoryImageModel;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001>BU\u0012\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0012\u0012\u001e\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0016\u0012\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u001a\u00a2\u0006\u0004\b<\u0010=J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R&\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R,\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR*\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00101\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010;\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:\u00a8\u0006?"}, d2 = {"Ll83/i;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ln83/a;", "viewHolder", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioHistoryImageModel;", "itemInfo", "", "position", "", "l0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "r0", "getItemCount", "p0", "holder", "q0", "Lkotlin/Function2;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function2;", "onHistoryItemClick", "Lkotlin/Function3;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function3;", "onHistoryItemDeleteClick", "Lkotlin/Function1;", "D", "Lkotlin/jvm/functions/Function1;", "onHistoryItemLongClick", "", "E", "Ljava/util/List;", "getHistoryData", "()Ljava/util/List;", "s0", "(Ljava/util/List;)V", "historyData", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "getPicStyleModel", "()Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "v0", "(Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;)V", "picStyleModel", "", "G", "Z", "isInDeletingMode", "()Z", "t0", "(Z)V", "H", "I", "getPic2picItemPosition", "()I", "u0", "(I)V", "pic2picItemPosition", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;)V", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class i extends RecyclerView.Adapter<n83.a> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function3<Integer, MagicStudioHistoryImageModel, Integer, Unit> onHistoryItemDeleteClick;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Function1<Integer, Unit> onHistoryItemLongClick;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private List<MagicStudioHistoryImageModel> historyData;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private MagicStudioPicStyle picStyleModel;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isInDeletingMode;

    /* renamed from: H, reason: from kotlin metadata */
    private int pic2picItemPosition;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<Integer, MagicStudioHistoryImageModel, Unit> onHistoryItemClick;

    /* JADX WARN: Multi-variable type inference failed */
    public i(@NotNull Function2<? super Integer, ? super MagicStudioHistoryImageModel, Unit> onHistoryItemClick, @NotNull Function3<? super Integer, ? super MagicStudioHistoryImageModel, ? super Integer, Unit> onHistoryItemDeleteClick, @NotNull Function1<? super Integer, Unit> onHistoryItemLongClick) {
        Intrinsics.checkNotNullParameter(onHistoryItemClick, "onHistoryItemClick");
        Intrinsics.checkNotNullParameter(onHistoryItemDeleteClick, "onHistoryItemDeleteClick");
        Intrinsics.checkNotNullParameter(onHistoryItemLongClick, "onHistoryItemLongClick");
        this.onHistoryItemClick = onHistoryItemClick;
        this.onHistoryItemDeleteClick = onHistoryItemDeleteClick;
        this.onHistoryItemLongClick = onHistoryItemLongClick;
    }

    private final void l0(final n83.a viewHolder, final MagicStudioHistoryImageModel itemInfo, final int position) {
        String str;
        int i3;
        w53.b.a("WinkQZonePic2PicHistoryAdapter", "bind");
        m83.b bVar = m83.b.f416442a;
        ImageView itemImageView = viewHolder.getItemImageView();
        Intrinsics.checkNotNullExpressionValue(itemImageView, "itemImageView");
        MagicStudioPicStyle magicStudioPicStyle = this.picStyleModel;
        String str2 = null;
        if (magicStudioPicStyle != null) {
            str = magicStudioPicStyle.getStyleId();
        } else {
            str = null;
        }
        bVar.k(itemImageView, str);
        viewHolder.getItemImageView().setImageDrawable(URLDrawable.getFileDrawable(itemInfo.getImagePath(), ViewUtilsKt.d()));
        viewHolder.getItemImageView().setOnClickListener(new View.OnClickListener() { // from class: l83.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.m0(i.this, itemInfo, viewHolder, view);
            }
        });
        viewHolder.getItemImageView().setOnLongClickListener(new View.OnLongClickListener() { // from class: l83.g
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean n06;
                n06 = i.n0(i.this, view);
                return n06;
            }
        });
        ImageView itemRemoveView = viewHolder.getItemRemoveView();
        if (this.isInDeletingMode) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        itemRemoveView.setVisibility(i3);
        if (this.isInDeletingMode) {
            ImageView itemRemoveView2 = viewHolder.getItemRemoveView();
            Intrinsics.checkNotNullExpressionValue(itemRemoveView2, "itemRemoveView");
            MagicStudioPicStyle magicStudioPicStyle2 = this.picStyleModel;
            if (magicStudioPicStyle2 != null) {
                str2 = magicStudioPicStyle2.getStyleId();
            }
            bVar.j(itemRemoveView2, str2);
        }
        viewHolder.getItemRemoveView().setOnClickListener(new View.OnClickListener() { // from class: l83.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.o0(i.this, position, itemInfo, viewHolder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(i this$0, MagicStudioHistoryImageModel itemInfo, n83.a this_apply, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemInfo, "$itemInfo");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.onHistoryItemClick.invoke(Integer.valueOf(this$0.pic2picItemPosition), itemInfo);
        m83.b bVar = m83.b.f416442a;
        ImageView itemImageView = this_apply.getItemImageView();
        Intrinsics.checkNotNullExpressionValue(itemImageView, "itemImageView");
        MagicStudioPicStyle magicStudioPicStyle = this$0.picStyleModel;
        if (magicStudioPicStyle != null) {
            str = magicStudioPicStyle.getStyleId();
        } else {
            str = null;
        }
        bVar.h(itemImageView, str);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n0(i this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onHistoryItemLongClick.invoke(Integer.valueOf(this$0.pic2picItemPosition));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(i this$0, int i3, MagicStudioHistoryImageModel itemInfo, n83.a this_apply, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemInfo, "$itemInfo");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.onHistoryItemDeleteClick.invoke(Integer.valueOf(i3), itemInfo, Integer.valueOf(this$0.getNUM_BACKGOURND_ICON() - 1));
        m83.b bVar = m83.b.f416442a;
        ImageView itemRemoveView = this_apply.getItemRemoveView();
        Intrinsics.checkNotNullExpressionValue(itemRemoveView, "itemRemoveView");
        MagicStudioPicStyle magicStudioPicStyle = this$0.picStyleModel;
        if (magicStudioPicStyle != null) {
            str = magicStudioPicStyle.getStyleId();
        } else {
            str = null;
        }
        bVar.i(itemRemoveView, str);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<MagicStudioHistoryImageModel> list = this.historyData;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Nullable
    public final MagicStudioHistoryImageModel p0(int position) {
        Object orNull;
        List<MagicStudioHistoryImageModel> list = this.historyData;
        if (list != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(list, position);
            return (MagicStudioHistoryImageModel) orNull;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull n83.a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        w53.b.a("WinkQZonePic2PicHistoryAdapter", "onBindViewHolder\uff0cposition = " + position);
        MagicStudioHistoryImageModel p06 = p0(position);
        if (p06 != null) {
            l0(holder, p06, position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public n83.a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        w53.b.a("WinkQZonePic2PicHistoryAdapter", "onCreateViewHolder");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.i7a, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new n83.a(itemView);
    }

    public final void s0(@Nullable List<MagicStudioHistoryImageModel> list) {
        this.historyData = list;
    }

    public final void t0(boolean z16) {
        this.isInDeletingMode = z16;
    }

    public final void u0(int i3) {
        this.pic2picItemPosition = i3;
    }

    public final void v0(@Nullable MagicStudioPicStyle magicStudioPicStyle) {
        this.picStyleModel = magicStudioPicStyle;
    }
}
