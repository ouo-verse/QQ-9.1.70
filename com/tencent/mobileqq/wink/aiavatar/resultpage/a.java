package com.tencent.mobileqq.wink.aiavatar.resultpage;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.aiavatar.resultpage.a;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004)*+,B+\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\r\u0012\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u001c\u00a2\u0006\u0004\b&\u0010'J\u0016\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0016\u0010%\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u0017\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/resultpage/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "materials", "", "p0", "", "materialID", "o0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "getItemCount", "holder", "position", "onBindViewHolder", "getItemViewType", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isCouple", BdhLogUtil.LogTag.Tag_Conn, "I", IProfileCardConst.KEY_FROM_TYPE, "Lkotlin/Function1;", "D", "Lkotlin/jvm/functions/Function1;", "onItemClick", "E", "Ljava/util/List;", UserInfo.SEX_FEMALE, "selectedIndex", "G", "isFromAIAvatarPage", "<init>", "(ZILkotlin/jvm/functions/Function1;)V", "H", "a", "b", "c", "d", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    private final int fromType;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Function1<MetaMaterial, Unit> onItemClick;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private List<MetaMaterial> materials;

    /* renamed from: F, reason: from kotlin metadata */
    private int selectedIndex;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isFromAIAvatarPage;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean isCouple;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/resultpage/a$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/wink/aiavatar/resultpage/a;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.aiavatar.resultpage.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public final class C9007a extends RecyclerView.ViewHolder {
        final /* synthetic */ a E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9007a(@NotNull a aVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = aVar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020\u0014\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/resultpage/a$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/widget/ImageView;", "imageView", "", "imageUrl", "o", "", "size", "p", "", "position", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "E", "Landroid/widget/ImageView;", "firstImageView", UserInfo.SEX_FEMALE, "secondImageView", "Landroid/view/View;", "G", "Landroid/view/View;", "firstImageContainer", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "nameTextView", "I", "selectedBorder", "Landroid/graphics/drawable/ColorDrawable;", "J", "Landroid/graphics/drawable/ColorDrawable;", "loadDrawable", "itemView", "<init>", "(Lcom/tencent/mobileqq/wink/aiavatar/resultpage/a;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private final ImageView firstImageView;

        /* renamed from: F, reason: from kotlin metadata */
        @Nullable
        private final ImageView secondImageView;

        /* renamed from: G, reason: from kotlin metadata */
        @Nullable
        private final View firstImageContainer;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final TextView nameTextView;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final View selectedBorder;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final ColorDrawable loadDrawable;
        final /* synthetic */ a K;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull a aVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.K = aVar;
            this.firstImageView = (ImageView) itemView.findViewById(R.id.y3_);
            this.secondImageView = (ImageView) itemView.findViewById(R.id.y8s);
            this.firstImageContainer = itemView.findViewById(R.id.f97075je);
            View findViewById = itemView.findViewById(R.id.tv_name);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_name)");
            this.nameTextView = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f82054fu);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.select_border_view)");
            this.selectedBorder = findViewById2;
            this.loadDrawable = new ColorDrawable(itemView.getContext().getColor(R.color.qui_common_bg_nav_bottom));
            q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(MetaMaterial material, a this$0, int i3, View it) {
            EventCollector.getInstance().onViewClickedBefore(it);
            Intrinsics.checkNotNullParameter(material, "$material");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!FastClickUtils.isFastDoubleClick("WinkAIAvatarRecommendStyleAdapter_" + material.f30533id, 500L)) {
                w53.b.f("WinkAIAvatarRecommendStyleAdapter", "onItemClick: " + material.f30533id);
                if (this$0.selectedIndex != i3) {
                    this$0.onItemClick.invoke(material);
                }
                if (!this$0.isFromAIAvatarPage) {
                    com.tencent.mobileqq.wink.aiavatar.base.a aVar = com.tencent.mobileqq.wink.aiavatar.base.a.f317690a;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    String str = material.f30533id;
                    Intrinsics.checkNotNullExpressionValue(str, "material.id");
                    aVar.d(it, str);
                } else {
                    com.tencent.mobileqq.wink.aiavatar.base.a aVar2 = com.tencent.mobileqq.wink.aiavatar.base.a.f317690a;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    String str2 = material.f30533id;
                    Intrinsics.checkNotNullExpressionValue(str2, "material.id");
                    aVar2.E(it, str2, this$0.fromType);
                }
            }
            EventCollector.getInstance().onViewClicked(it);
        }

        private final void o(ImageView imageView, String imageUrl) {
            Option obtain = Option.obtain();
            obtain.setLoadingDrawable(this.loadDrawable);
            obtain.setFailedDrawable(this.loadDrawable);
            obtain.setTargetView(imageView);
            obtain.setUrl(imageUrl);
            QQPicLoader.f201806a.d().loadImage(obtain, null);
        }

        private final void p(float size) {
            ViewGroup.LayoutParams layoutParams;
            ViewGroup.LayoutParams layoutParams2;
            ImageView imageView = this.firstImageView;
            if (imageView != null && (layoutParams2 = imageView.getLayoutParams()) != null) {
                layoutParams2.width = ViewUtils.dpToPx(size);
                layoutParams2.height = ViewUtils.dpToPx(size);
            }
            ImageView imageView2 = this.secondImageView;
            if (imageView2 != null && (layoutParams = imageView2.getLayoutParams()) != null) {
                layoutParams.width = ViewUtils.dpToPx(size);
                layoutParams.height = ViewUtils.dpToPx(size);
            }
            ImageView imageView3 = this.secondImageView;
            if (imageView3 != null) {
                imageView3.requestLayout();
            }
            View view = this.firstImageContainer;
            if (view != null) {
                view.requestLayout();
            }
        }

        private final void q() {
            Context context;
            ViewGroup.LayoutParams layoutParams;
            o53.h hVar = o53.h.f422138a;
            View view = this.firstImageContainer;
            Context context2 = null;
            if (view != null) {
                context = view.getContext();
            } else {
                context = null;
            }
            if (hVar.z(context)) {
                View view2 = this.firstImageContainer;
                if (view2 != null) {
                    context2 = view2.getContext();
                }
                if (hVar.B(context2)) {
                    if (this.K.isCouple) {
                        p(112.0f);
                        return;
                    }
                    View view3 = this.firstImageContainer;
                    if (view3 != null && (layoutParams = view3.getLayoutParams()) != null) {
                        layoutParams.width = ViewUtils.dpToPx(116.0f);
                        layoutParams.height = ViewUtils.dpToPx(116.0f);
                    }
                    ImageView imageView = this.firstImageView;
                    if (imageView != null) {
                        imageView.requestLayout();
                        return;
                    }
                    return;
                }
                p(78.0f);
            }
        }

        public final void m(final int position) {
            final MetaMaterial metaMaterial = (MetaMaterial) this.K.materials.get(position);
            this.nameTextView.setText(com.tencent.mobileqq.wink.editor.c.a0(metaMaterial));
            o(this.firstImageView, com.tencent.mobileqq.wink.editor.c.A(metaMaterial));
            if (this.K.isCouple) {
                o(this.secondImageView, com.tencent.mobileqq.wink.editor.c.n0(metaMaterial));
            }
            if (this.K.selectedIndex == position) {
                this.selectedBorder.setVisibility(0);
            } else {
                this.selectedBorder.setVisibility(8);
            }
            View view = this.itemView;
            final a aVar = this.K;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    a.c.n(MetaMaterial.this, aVar, position, view2);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/resultpage/a$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "firstImageView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "nameTextView", "Landroid/view/View;", "G", "Landroid/view/View;", "selectedBorder", "H", "firstImageContainer", "itemView", "<init>", "(Lcom/tencent/mobileqq/wink/aiavatar/resultpage/a;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private final ImageView firstImageView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView nameTextView;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final View selectedBorder;

        /* renamed from: H, reason: from kotlin metadata */
        @Nullable
        private final View firstImageContainer;
        final /* synthetic */ a I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull a aVar, View itemView) {
            super(itemView);
            Context context;
            ViewGroup.LayoutParams layoutParams;
            float f16;
            ViewGroup.LayoutParams layoutParams2;
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.I = aVar;
            ImageView imageView = (ImageView) itemView.findViewById(R.id.y3_);
            this.firstImageView = imageView;
            View findViewById = itemView.findViewById(R.id.tv_name);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_name)");
            TextView textView = (TextView) findViewById;
            this.nameTextView = textView;
            View findViewById2 = itemView.findViewById(R.id.f82054fu);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.select_border_view)");
            this.selectedBorder = findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f97075je);
            this.firstImageContainer = findViewById3;
            textView.setText("\u539f\u56fe");
            findViewById2.setVisibility(8);
            o53.h hVar = o53.h.f422138a;
            if (findViewById3 != null) {
                context = findViewById3.getContext();
            } else {
                context = null;
            }
            if (hVar.z(context)) {
                if (hVar.B(findViewById3 != null ? findViewById3.getContext() : null)) {
                    if (aVar.isCouple) {
                        f16 = 112.0f;
                    } else {
                        f16 = 116.0f;
                    }
                } else {
                    f16 = 78.0f;
                }
                if (findViewById3 != null && (layoutParams2 = findViewById3.getLayoutParams()) != null) {
                    layoutParams2.width = ViewUtils.dpToPx(f16);
                    layoutParams2.height = ViewUtils.dpToPx(f16);
                }
            }
            if (imageView != null && (layoutParams = imageView.getLayoutParams()) != null) {
                layoutParams.width = ViewUtils.dpToPx(24.0f);
                layoutParams.height = ViewUtils.dpToPx(24.0f);
            }
            if (imageView != null) {
                imageView.setImageResource(R.drawable.l6z);
            }
            com.tencent.mobileqq.wink.aiavatar.base.a.f317690a.t(itemView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(MetaMaterial material, a this$0, int i3, View it) {
            EventCollector.getInstance().onViewClickedBefore(it);
            Intrinsics.checkNotNullParameter(material, "$material");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!FastClickUtils.isFastDoubleClick("WinkAIAvatarRecommendStyleAdapter_" + material.f30533id, 500L)) {
                w53.b.f("WinkAIAvatarRecommendStyleAdapter", "onItemClick: " + material.f30533id);
                if (this$0.selectedIndex != i3) {
                    this$0.onItemClick.invoke(material);
                }
                com.tencent.mobileqq.wink.aiavatar.base.a aVar = com.tencent.mobileqq.wink.aiavatar.base.a.f317690a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                aVar.s(it);
            }
            EventCollector.getInstance().onViewClicked(it);
        }

        public final void m(final int position) {
            final MetaMaterial metaMaterial = (MetaMaterial) this.I.materials.get(position);
            View view = this.itemView;
            final a aVar = this.I;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    a.d.n(MetaMaterial.this, aVar, position, view2);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(boolean z16, int i3, @NotNull Function1<? super MetaMaterial, Unit> onItemClick) {
        List<MetaMaterial> emptyList;
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.isCouple = z16;
        this.fromType = i3;
        this.onItemClick = onItemClick;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.materials = emptyList;
        this.selectedIndex = -1;
        this.isFromAIAvatarPage = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.materials.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (!this.materials.isEmpty() && position != this.materials.size()) {
            if (Intrinsics.areEqual(this.materials.get(position).f30533id, "origin_image")) {
                return 1;
            }
            return 0;
        }
        return 4;
    }

    public final void o0(@NotNull String materialID) {
        Intrinsics.checkNotNullParameter(materialID, "materialID");
        Iterator<MetaMaterial> it = this.materials.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().f30533id, materialID)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (this.selectedIndex == i3) {
            return;
        }
        this.selectedIndex = i3;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof c) {
            ((c) holder).m(position);
        } else if (holder instanceof d) {
            ((d) holder).m(position);
        }
        if ((!this.materials.isEmpty()) && position > 0 && position < this.materials.size()) {
            if (!this.isFromAIAvatarPage) {
                com.tencent.mobileqq.wink.aiavatar.base.a aVar = com.tencent.mobileqq.wink.aiavatar.base.a.f317690a;
                View view = holder.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
                String str = this.materials.get(position).f30533id;
                Intrinsics.checkNotNullExpressionValue(str, "materials[position].id");
                aVar.e(view, str, String.valueOf(position));
                return;
            }
            com.tencent.mobileqq.wink.aiavatar.base.a aVar2 = com.tencent.mobileqq.wink.aiavatar.base.a.f317690a;
            View view2 = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
            String str2 = this.materials.get(position).f30533id;
            Intrinsics.checkNotNullExpressionValue(str2, "materials[position].id");
            aVar2.F(view2, str2, String.valueOf(position), this.fromType);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        int i3;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 4) {
            i3 = R.layout.i4t;
        } else if (this.isCouple) {
            i3 = R.layout.i4p;
        } else {
            i3 = R.layout.i4q;
        }
        View itemView = LayoutInflater.from(parent.getContext()).inflate(i3, parent, false);
        if (!FontSettingManager.isFontSizeNormal()) {
            FontSettingManager.resetViewSize2Normal(itemView.getContext(), itemView);
        }
        if (viewType != 0) {
            if (viewType != 4) {
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                return new d(this, itemView);
            }
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new C9007a(this, itemView);
        }
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new c(this, itemView);
    }

    public final void p0(@Nullable List<MetaMaterial> materials) {
        if (materials == null) {
            w53.b.c("WinkAIAvatarRecommendStyleAdapter", "materials is null");
            return;
        }
        this.materials = materials;
        boolean z16 = false;
        if (getItemViewType(0) == 0) {
            z16 = true;
        }
        this.isFromAIAvatarPage = z16;
        notifyDataSetChanged();
    }
}
