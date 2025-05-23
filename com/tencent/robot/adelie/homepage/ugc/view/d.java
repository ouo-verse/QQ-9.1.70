package com.tencent.robot.adelie.homepage.ugc.view;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010BM\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u0016\u00126\u0010#\u001a2\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u001c\u00a2\u0006\u0004\b.\u0010/J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u000f\u001a\u00020\nJ\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0014\u0010\u0015\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0013R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aRD\u0010#\u001a2\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/d;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "baseViewHolder", "position", "", "onBindViewHolder", "getItemCount", "Lcom/tencent/robot/adelie/homepage/ugc/view/x;", "j0", "l0", "", "styleId", "m0", "", "dataList", "n0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "getItemList", "()Ljava/util/List;", VideoTemplateParser.ITEM_LIST, "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function2;", "onItemClick", "D", "Ljava/lang/String;", "selectedTag", "E", "I", "selectedPosition", "Landroid/graphics/drawable/Drawable;", UserInfo.SEX_FEMALE, "Landroid/graphics/drawable/Drawable;", "placeholder", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function2<View, Integer, Unit> onItemClick;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String selectedTag;

    /* renamed from: E, reason: from kotlin metadata */
    private int selectedPosition;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Drawable placeholder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Item> itemList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/d$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ImageView;", "imageView", UserInfo.SEX_FEMALE, "l", "borderView", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "o", "()Landroid/widget/TextView;", "textView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ImageView imageView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final ImageView borderView;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView textView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.dce);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.imageView)");
            this.imageView = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.t9c);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.borderView)");
            this.borderView = (ImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.jfo);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.textView)");
            this.textView = (TextView) findViewById3;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final ImageView getBorderView() {
            return this.borderView;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final ImageView getImageView() {
            return this.imageView;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final TextView getTextView() {
            return this.textView;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull List<Item> itemList, @NotNull Function2<? super View, ? super Integer, Unit> onItemClick) {
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.itemList = itemList;
        this.onItemClick = onItemClick;
        this.selectedTag = "";
        this.selectedPosition = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(d this$0, Item item, int i3, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.selectedTag = item.getText();
        this$0.selectedPosition = i3;
        Function2<View, Integer, Unit> function2 = this$0.onItemClick;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        function2.invoke(it, Integer.valueOf(i3));
        this$0.notifyDataSetChanged();
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.itemList.size();
    }

    @Nullable
    public final Item j0() {
        if (!this.itemList.isEmpty()) {
            int size = this.itemList.size();
            int i3 = this.selectedPosition;
            if (size > i3 && i3 >= 0) {
                return this.itemList.get(i3);
            }
            return null;
        }
        return null;
    }

    public final void l0() {
        if (!this.itemList.isEmpty()) {
            Item item = this.itemList.get(0);
            this.selectedPosition = 0;
            this.selectedTag = item.getText();
            notifyDataSetChanged();
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final int m0(@NotNull String styleId) {
        Intrinsics.checkNotNullParameter(styleId, "styleId");
        int i3 = 0;
        for (Object obj : this.itemList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Item item = (Item) obj;
            if (Intrinsics.areEqual(item.getStyleId(), styleId)) {
                this.selectedPosition = i3;
                this.selectedTag = item.getText();
                notifyDataSetChanged();
                return this.selectedPosition;
            }
            i3 = i16;
        }
        l0();
        return 0;
    }

    public final void n0(@NotNull List<Item> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        if (dataList.isEmpty()) {
            return;
        }
        this.itemList.clear();
        this.itemList.addAll(dataList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder baseViewHolder, @SuppressLint({"RecyclerView"}) final int position) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "baseViewHolder");
        final Item item = this.itemList.get(position);
        a aVar = (a) baseViewHolder;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        try {
            obtain.mPlayGifImage = true;
            URL url = new URL(item.getThumbUrl());
            Drawable drawable = this.placeholder;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            obtain.mUseAutoScaleParams = false;
            aVar.getImageView().setImageDrawable(URLDrawable.getDrawable(url, obtain));
            aVar.getTextView().setText(item.getText());
            if (Intrinsics.areEqual(this.selectedTag, item.getText())) {
                aVar.getBorderView().setBackgroundResource(R.drawable.j4p);
            } else {
                aVar.getBorderView().setBackgroundResource(0);
            }
            aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.view.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.k0(d.this, item, position, view);
                }
            });
        } catch (MalformedURLException unused) {
            aVar.getImageView().setImageDrawable(this.placeholder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dt6, parent, false);
        this.placeholder = ContextCompat.getDrawable(view.getContext(), R.color.bdf);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new a(view);
    }
}
