package com.tencent.mobileqq.wink.magicstudio.view;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.magicstudio.TextCreationFragment;
import com.tencent.mobileqq.wink.magicstudio.view.StyleAdapter;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B*\u0012!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00140\u0018\u00a2\u0006\u0004\b'\u0010(J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u001e\u0010\u000b\u001a\u00020\n2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0014\u0010\u0016\u001a\u00020\u00142\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0006\u0010\u0017\u001a\u00020\u0014R/\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00140\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR6\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006@GX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/view/StyleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/magicstudio/view/StyleAdapter$StyleItem;", "", "", "recommendList", "Lcom/tencent/mobileqq/wink/magicstudio/model/f;", "i0", "filterList", "style", "", "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "getItemCount", "holder", "position", "", "k0", "o0", "m0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", com.tencent.luggage.wxa.c8.c.G, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "onItemClicked", "value", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "getStyles", "()Ljava/util/List;", "n0", "(Ljava/util/List;)V", "styles", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "StyleItem", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class StyleAdapter extends RecyclerView.Adapter<StyleItem> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.wink.magicstudio.model.f> styles;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Integer, Unit> onItemClicked;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b'\u0010(J1\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001e\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/view/StyleAdapter$StyleItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/wink/magicstudio/model/f;", "style", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "adapterPos", "", "onItemClicked", DomainData.DOMAIN_NAME, "Landroid/view/View;", "E", "Landroid/view/View;", "view", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "p", "()Landroid/widget/ImageView;", "cover", "Landroid/widget/TextView;", "G", "r", "()Landroid/widget/TextView;", "styleName", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/view/View;", "shadow", "Lcom/google/android/material/card/MaterialCardView;", "I", "Lcom/google/android/material/card/MaterialCardView;", "cardView", "Landroid/graphics/drawable/GradientDrawable;", "J", "Landroid/graphics/drawable/GradientDrawable;", "shadowGradient", "<init>", "(Landroid/view/View;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class StyleItem extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View view;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final Lazy cover;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final Lazy styleName;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final Lazy shadow;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final MaterialCardView cardView;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final GradientDrawable shadowGradient;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StyleItem(@NotNull View view) {
            super(view);
            Lazy lazy;
            Lazy lazy2;
            Lazy lazy3;
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.magicstudio.view.StyleAdapter$StyleItem$cover$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ImageView invoke() {
                    View view2;
                    view2 = StyleAdapter.StyleItem.this.view;
                    return (ImageView) view2.findViewById(R.id.bat);
                }
            });
            this.cover = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.magicstudio.view.StyleAdapter$StyleItem$styleName$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextView invoke() {
                    View view2;
                    view2 = StyleAdapter.StyleItem.this.view;
                    return (TextView) view2.findViewById(R.id.f897850p);
                }
            });
            this.styleName = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.magicstudio.view.StyleAdapter$StyleItem$shadow$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final View invoke() {
                    View view2;
                    view2 = StyleAdapter.StyleItem.this.view;
                    return view2.findViewById(R.id.iql);
                }
            });
            this.shadow = lazy3;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.google.android.material.card.MaterialCardView");
            MaterialCardView materialCardView = (MaterialCardView) view;
            this.cardView = materialCardView;
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.argb(153, 0, 0, 0), 0});
            this.shadowGradient = gradientDrawable;
            materialCardView.setRippleColor(ColorStateList.valueOf(0));
            int g16 = com.tencent.videocut.utils.o.g();
            TextCreationFragment.Companion companion = TextCreationFragment.INSTANCE;
            int d16 = (int) ((g16 - ViewExKt.d(((companion.a() - 1) * 13) + 16)) / (companion.a() - 0.75d));
            view.setLayoutParams(new RecyclerView.LayoutParams(d16, d16));
            View q16 = q();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, d16 / 3);
            layoutParams.gravity = 80;
            q16.setLayoutParams(layoutParams);
            q().setBackground(gradientDrawable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(Function1 onItemClicked, StyleItem this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(onItemClicked, "$onItemClicked");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            onItemClicked.invoke(Integer.valueOf(this$0.getAdapterPosition()));
            EventCollector.getInstance().onViewClicked(view);
        }

        private final ImageView p() {
            Object value = this.cover.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-cover>(...)");
            return (ImageView) value;
        }

        private final View q() {
            Object value = this.shadow.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-shadow>(...)");
            return (View) value;
        }

        private final TextView r() {
            Object value = this.styleName.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-styleName>(...)");
            return (TextView) value;
        }

        public final void n(@NotNull com.tencent.mobileqq.wink.magicstudio.model.f style, @NotNull final Function1<? super Integer, Unit> onItemClicked) {
            Intrinsics.checkNotNullParameter(style, "style");
            Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
            this.view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.view.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StyleAdapter.StyleItem.o(Function1.this, this, view);
                }
            });
            if (style.getIsRecommend()) {
                this.cardView.setAlpha(1.0f);
                this.cardView.setClickable(true);
            } else {
                this.cardView.setAlpha(0.2f);
                this.cardView.setClickable(false);
            }
            p().setImageDrawable(URLDrawable.getDrawable(style.getImg(), ViewUtilsKt.d()));
            r().setText(style.getStyleName());
            if (style.getSelected()) {
                this.cardView.setStrokeWidth(ViewExKt.d(4));
            } else {
                this.cardView.setStrokeWidth(0);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StyleAdapter(@NotNull Function1<? super Integer, Unit> onItemClicked) {
        List<com.tencent.mobileqq.wink.magicstudio.model.f> emptyList;
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.onItemClicked = onItemClicked;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.styles = emptyList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final com.tencent.mobileqq.wink.magicstudio.model.f i0(List<String> recommendList) {
        com.tencent.mobileqq.wink.magicstudio.model.f fVar;
        Iterator<T> it = recommendList.iterator();
        while (true) {
            fVar = null;
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            Iterator<T> it5 = this.styles.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next = it5.next();
                if (Intrinsics.areEqual(((com.tencent.mobileqq.wink.magicstudio.model.f) next).getStyleModeId(), str)) {
                    fVar = next;
                    break;
                }
            }
            fVar = fVar;
            if (fVar != null) {
                fVar.v(true);
                break;
            }
        }
        return fVar;
    }

    private final boolean j0(List<String> filterList, com.tencent.mobileqq.wink.magicstudio.model.f style) {
        ArrayList arrayList = new ArrayList();
        List<Pair<String, Integer>> h16 = style.h();
        if (h16 != null) {
            Iterator<T> it = h16.iterator();
            while (it.hasNext()) {
                arrayList.add(((Pair) it.next()).getFirst());
            }
        }
        if (arrayList.isEmpty()) {
            return filterList.contains(style.getStyleModeId());
        }
        Iterator it5 = arrayList.iterator();
        int i3 = 0;
        while (it5.hasNext()) {
            if (filterList.contains((String) it5.next())) {
                i3++;
            }
        }
        if (i3 != arrayList.size()) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.styles.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull StyleItem holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.n(this.styles.get(position), this.onItemClicked);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public StyleItem onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.f167581du2, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new StyleItem(view);
    }

    public final void m0() {
        Iterator<com.tencent.mobileqq.wink.magicstudio.model.f> it = this.styles.iterator();
        while (it.hasNext()) {
            it.next().u(true);
        }
        notifyDataSetChanged();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void n0(@NotNull List<com.tencent.mobileqq.wink.magicstudio.model.f> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.styles = value;
        notifyDataSetChanged();
    }

    public final void o0(@NotNull List<String> recommendList) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(recommendList, "recommendList");
        if (this.styles.isEmpty()) {
            return;
        }
        m0();
        if (recommendList.isEmpty()) {
            return;
        }
        int i3 = 0;
        boolean z17 = false;
        for (com.tencent.mobileqq.wink.magicstudio.model.f fVar : this.styles) {
            boolean j06 = j0(recommendList, fVar);
            if (fVar.getSelected() && !j06) {
                fVar.v(false);
                z17 = true;
            }
            fVar.u(j06);
        }
        if (z17) {
            Iterator<T> it = this.styles.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    com.tencent.mobileqq.wink.magicstudio.model.f fVar2 = (com.tencent.mobileqq.wink.magicstudio.model.f) obj;
                    if (fVar2.getIsCollectionStyle() && fVar2.getIsRecommend()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            com.tencent.mobileqq.wink.magicstudio.model.f fVar3 = (com.tencent.mobileqq.wink.magicstudio.model.f) obj;
            if (fVar3 != null) {
                fVar3.v(true);
            } else {
                i0(recommendList);
            }
            Iterator<com.tencent.mobileqq.wink.magicstudio.model.f> it5 = this.styles.iterator();
            while (true) {
                if (it5.hasNext()) {
                    if (it5.next().getSelected()) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            this.onItemClicked.invoke(Integer.valueOf(i3));
        }
        notifyDataSetChanged();
    }
}
