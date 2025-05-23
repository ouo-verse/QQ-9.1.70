package com.tencent.mobileqq.wink.pubcover;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002./B\u0007\u00a2\u0006\u0004\b,\u0010-J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tJ\u001a\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\tH\u0017J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0012R\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0014\u0010 \u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\u0014\u0010\"\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b!\u0010\u0015R&\u0010(\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/e;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/pubcover/e$b;", "Lcom/tencent/mobileqq/wink/pubcover/e$a;", "listener", "", "n0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "getItemCount", com.tencent.luggage.wxa.c8.c.G, "o0", "viewHolder", "position", "j0", "Landroid/view/View;", "m0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mCurrentPos", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/pubcover/e$a;", "", "D", "Z", "isHide", "E", "GAUSSIAN_ICON_POSTION", UserInfo.SEX_FEMALE, "BACKGROUND_SWITCH_ICON_POSITION", "G", "NUM_BACKGOURND_ICON", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "COLOR_SELECTOR_SET", "", "Ljava/util/List;", "IMAGE_RES_SET", "<init>", "()V", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    private a listener;

    /* renamed from: E, reason: from kotlin metadata */
    private final int GAUSSIAN_ICON_POSTION;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private ArrayList<String> COLOR_SELECTOR_SET;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private List<Integer> IMAGE_RES_SET;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mCurrentPos;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isHide = true;

    /* renamed from: F, reason: from kotlin metadata */
    private final int BACKGROUND_SWITCH_ICON_POSITION = 9;

    /* renamed from: G, reason: from kotlin metadata */
    private final int NUM_BACKGOURND_ICON = 10;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/e$a;", "", "", "type", "", "color", "", "I3", "Pa", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void I3(int type, @NotNull String color);

        void Pa();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u0017\u0010\u0016\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0019\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/e$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "E", "Landroid/view/View;", "p", "()Landroid/view/View;", "mItemView", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "setMBackground", "(Landroid/widget/ImageView;)V", "mBackground", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setMBackground1", "mBackground1", "H", "o", "mImage", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mOverlay", "<init>", "(Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View mItemView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private ImageView mBackground;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private ImageView mBackground1;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final ImageView mImage;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final ImageView mOverlay;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View mItemView) {
            super(mItemView);
            Intrinsics.checkNotNullParameter(mItemView, "mItemView");
            this.mItemView = mItemView;
            View findViewById = this.itemView.findViewById(R.id.y8x);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.iv_selected_bg)");
            this.mBackground = (ImageView) findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.y8y);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.iv_selected_bg1)");
            this.mBackground1 = (ImageView) findViewById2;
            View findViewById3 = this.itemView.findViewById(R.id.y0s);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.iv_bg_item)");
            this.mImage = (ImageView) findViewById3;
            View findViewById4 = this.itemView.findViewById(R.id.y8z);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.iv_selected_overlay)");
            this.mOverlay = (ImageView) findViewById4;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final ImageView getMBackground() {
            return this.mBackground;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final ImageView getMBackground1() {
            return this.mBackground1;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final ImageView getMImage() {
            return this.mImage;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final View getMItemView() {
            return this.mItemView;
        }

        @NotNull
        /* renamed from: q, reason: from getter */
        public final ImageView getMOverlay() {
            return this.mOverlay;
        }
    }

    public e() {
        ArrayList<String> arrayListOf;
        List<Integer> listOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("#03081A", "#FFFFFF", "#BFBDBE", "#32498F", "#9D5364", "#7C7FAC", "#7B886F", "#F0CE8A");
        this.COLOR_SELECTOR_SET = arrayListOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.m2s), Integer.valueOf(R.drawable.m2t), Integer.valueOf(R.drawable.m2u), Integer.valueOf(R.drawable.m2v), Integer.valueOf(R.drawable.m2w), Integer.valueOf(R.drawable.m2x), Integer.valueOf(R.drawable.m2y), Integer.valueOf(R.drawable.m2z)});
        this.IMAGE_RES_SET = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(int i3, e this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 9) {
            this$0.mCurrentPos = i3;
        }
        a aVar = null;
        if (i3 == this$0.GAUSSIAN_ICON_POSTION) {
            a aVar2 = this$0.listener;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listener");
            } else {
                aVar = aVar2;
            }
            aVar.I3(i3, "");
        } else if (i3 == this$0.BACKGROUND_SWITCH_ICON_POSITION) {
            a aVar3 = this$0.listener;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listener");
            } else {
                aVar = aVar3;
            }
            aVar.Pa();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.m0(it);
        } else {
            a aVar4 = this$0.listener;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listener");
            } else {
                aVar = aVar4;
            }
            String str = this$0.COLOR_SELECTOR_SET.get(i3 - 1);
            Intrinsics.checkNotNullExpressionValue(str, "COLOR_SELECTOR_SET[position - 1]");
            aVar.I3(i3, str);
        }
        this$0.notifyDataSetChanged();
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount, reason: from getter */
    public int getNUM_BACKGOURND_ICON() {
        return this.NUM_BACKGOURND_ICON;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"ResourceType"})
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b viewHolder, @SuppressLint({"RecyclerView"}) final int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (position == this.GAUSSIAN_ICON_POSTION) {
            viewHolder.getMImage().setVisibility(4);
            viewHolder.getMBackground().setVisibility(4);
            viewHolder.getMBackground1().setVisibility(0);
            viewHolder.getMBackground1().setImageResource(R.drawable.l8v);
        } else if (position == this.BACKGROUND_SWITCH_ICON_POSITION) {
            viewHolder.getMImage().setVisibility(4);
            viewHolder.getMBackground().setVisibility(4);
            viewHolder.getMBackground1().setVisibility(0);
            viewHolder.getMBackground1().setImageResource(R.drawable.l8r);
            com.tencent.mobileqq.wink.report.e.f(com.tencent.mobileqq.wink.report.e.f326265a, viewHolder.getMItemView(), WinkDaTongReportConstant.ElementId.EM_XSJ_COVER_COLOR_FILL_BUTTON, null, null, 12, null);
        } else {
            viewHolder.getMImage().setVisibility(0);
            viewHolder.getMBackground1().setVisibility(4);
            viewHolder.getMImage().setImageResource(this.IMAGE_RES_SET.get(position - 1).intValue());
            viewHolder.getMBackground().setBackgroundResource(R.drawable.f162081l92);
        }
        int i3 = this.mCurrentPos;
        if (i3 == position && i3 != 9) {
            viewHolder.getMOverlay().setVisibility(0);
        } else {
            viewHolder.getMOverlay().setVisibility(8);
        }
        viewHolder.getMItemView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.pubcover.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.k0(position, this, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.i59, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026t_bg_item, parent, false)");
        return new b(inflate);
    }

    public final void m0(@NotNull View viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        com.tencent.mobileqq.wink.report.e.k(com.tencent.mobileqq.wink.report.e.f326265a, viewHolder, WinkDaTongReportConstant.ElementId.EM_XSJ_COVER_COLOR_FILL_BUTTON, null, null, 12, null);
    }

    public final void n0(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void o0(int pos) {
        this.mCurrentPos = pos;
        a aVar = null;
        if (pos == this.GAUSSIAN_ICON_POSTION) {
            a aVar2 = this.listener;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listener");
            } else {
                aVar = aVar2;
            }
            aVar.I3(pos, "");
        } else if (pos == this.BACKGROUND_SWITCH_ICON_POSITION) {
            a aVar3 = this.listener;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listener");
            } else {
                aVar = aVar3;
            }
            aVar.Pa();
        } else {
            a aVar4 = this.listener;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listener");
            } else {
                aVar = aVar4;
            }
            String str = this.COLOR_SELECTOR_SET.get(pos - 1);
            Intrinsics.checkNotNullExpressionValue(str, "COLOR_SELECTOR_SET[pos - 1]");
            aVar.I3(pos, str);
        }
        notifyDataSetChanged();
    }
}
