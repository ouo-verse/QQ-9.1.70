package com.tencent.mobileqq.guild.base.view.colorpick;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.UiThread;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.view.colorpick.ColorPickDialogFragment;
import com.tencent.mobileqq.guild.base.view.colorpick.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \"2\u00020\u0001:\u0004#$%&B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016R\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/base/view/colorpick/ColorPickDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "qh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onResume", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroidx/recyclerview/widget/RecyclerView;", "D", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/guild/base/view/colorpick/d;", "E", "Lcom/tencent/mobileqq/guild/base/view/colorpick/d;", "viewModel", "Lcom/tencent/mobileqq/guild/base/view/colorpick/ColorPickDialogFragment$Param;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/base/view/colorpick/ColorPickDialogFragment$Param;", "param", "Lcom/tencent/mobileqq/guild/base/view/colorpick/ColorPickDialogFragment$ColorAdapter;", "G", "Lcom/tencent/mobileqq/guild/base/view/colorpick/ColorPickDialogFragment$ColorAdapter;", "adapter", "<init>", "()V", "H", "ColorAdapter", "a", "b", "Param", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ColorPickDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    private d viewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private Param param;

    /* renamed from: G, reason: from kotlin metadata */
    private ColorAdapter adapter;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000e\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005H\u0007R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R$\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/base/view/colorpick/ColorPickDialogFragment$ColorAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/base/view/colorpick/ColorPickDialogFragment$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "holder", "position", "", "k0", "getItemCount", "color", "m0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", NodeProps.COLORS, "<set-?>", BdhLogUtil.LogTag.Tag_Conn, "I", "j0", "()I", "pickedColor", "i0", SkinConstants.TintConstant.KEY_DEFAULT_COLOR, "<init>", "(ILjava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class ColorAdapter extends RecyclerView.Adapter<a> {

        /* renamed from: C, reason: from kotlin metadata */
        private int pickedColor;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<Integer> colors;

        public ColorAdapter(int i3, @NotNull List<Integer> colors) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            this.colors = colors;
            this.pickedColor = colors.contains(Integer.valueOf(i3)) ? i3 : i0();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.colors.size();
        }

        public final int i0() {
            Object first;
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.colors);
            return ((Number) first).intValue();
        }

        /* renamed from: j0, reason: from getter */
        public final int getPickedColor() {
            return this.pickedColor;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull a holder, int position) {
            boolean z16;
            Intrinsics.checkNotNullParameter(holder, "holder");
            int intValue = this.colors.get(position).intValue();
            if (this.pickedColor == this.colors.get(position).intValue()) {
                z16 = true;
            } else {
                z16 = false;
            }
            holder.m(intValue, z16);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            return new a(parent, new ColorPickDialogFragment$ColorAdapter$onCreateViewHolder$1(this));
        }

        @UiThread
        public final void m0(int color) {
            if (!this.colors.contains(Integer.valueOf(color))) {
                color = i0();
            }
            this.pickedColor = color;
            notifyDataSetChanged();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/base/view/colorpick/ColorPickDialogFragment$Param;", "Ljava/io/Serializable;", "color", "", "defaultColors", "", "(ILjava/util/List;)V", "getColor", "()I", "getDefaultColors", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final /* data */ class Param implements Serializable {
        private final int color;

        @NotNull
        private final List<Integer> defaultColors;

        public Param(int i3, @NotNull List<Integer> defaultColors) {
            Intrinsics.checkNotNullParameter(defaultColors, "defaultColors");
            this.color = i3;
            this.defaultColors = defaultColors;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Param copy$default(Param param, int i3, List list, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = param.color;
            }
            if ((i16 & 2) != 0) {
                list = param.defaultColors;
            }
            return param.copy(i3, list);
        }

        /* renamed from: component1, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        @NotNull
        public final List<Integer> component2() {
            return this.defaultColors;
        }

        @NotNull
        public final Param copy(int color, @NotNull List<Integer> defaultColors) {
            Intrinsics.checkNotNullParameter(defaultColors, "defaultColors");
            return new Param(color, defaultColors);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Param)) {
                return false;
            }
            Param param = (Param) other;
            if (this.color == param.color && Intrinsics.areEqual(this.defaultColors, param.defaultColors)) {
                return true;
            }
            return false;
        }

        public final int getColor() {
            return this.color;
        }

        @NotNull
        public final List<Integer> getDefaultColors() {
            return this.defaultColors;
        }

        public int hashCode() {
            return (this.color * 31) + this.defaultColors.hashCode();
        }

        @NotNull
        public String toString() {
            return "Param(color=" + this.color + ", defaultColors=" + this.defaultColors + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\n \r*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/base/view/colorpick/ColorPickDialogFragment$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "color", "", "selected", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Function1;", "E", "Lkotlin/jvm/functions/Function1;", "onColorPick", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "imageColor", "Landroid/view/View;", "G", "Landroid/view/View;", "imageContainer", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final Function1<Integer, Unit> onColorPick;

        /* renamed from: F, reason: from kotlin metadata */
        private final ImageView imageColor;

        /* renamed from: G, reason: from kotlin metadata */
        private final View imageContainer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull ViewGroup parent, @NotNull Function1<? super Integer, Unit> onColorPick) {
            super(ColorPickDialogFragment.INSTANCE.b(parent));
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(onColorPick, "onColorPick");
            this.onColorPick = onColorPick;
            this.imageColor = (ImageView) this.itemView.findViewById(R.id.f166377zm2);
            this.imageContainer = this.itemView.findViewById(R.id.f165844xs4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(a this$0, int i3, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onColorPick.invoke(Integer.valueOf(i3));
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void m(final int color, boolean selected) {
            this.imageColor.setBackgroundTintList(ColorStateList.valueOf(color));
            this.imageContainer.setSelected(selected);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.base.view.colorpick.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ColorPickDialogFragment.a.n(ColorPickDialogFragment.a.this, color, view);
                }
            });
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0007R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/base/view/colorpick/ColorPickDialogFragment$b;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "kotlin.jvm.PlatformType", "b", "", "color", "", "defaultColors", "Lcom/tencent/mobileqq/guild/base/view/colorpick/ColorPickDialogFragment;", "d", "", "PARAM_FRAGMENT", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.base.view.colorpick.ColorPickDialogFragment$b, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final View b(ViewGroup parent) {
            return LayoutInflater.from(parent.getContext()).inflate(R.layout.f6h, parent, false);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ColorPickDialogFragment e(Companion companion, int i3, List list, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                list = com.tencent.mobileqq.guild.base.view.colorpick.a.a();
            }
            return companion.d(i3, list);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final ColorPickDialogFragment c(int i3) {
            return e(this, i3, null, 2, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final ColorPickDialogFragment d(int color, @NotNull List<Integer> defaultColors) {
            Intrinsics.checkNotNullParameter(defaultColors, "defaultColors");
            ColorPickDialogFragment colorPickDialogFragment = new ColorPickDialogFragment();
            if (!defaultColors.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("PARAM_FRAGMENT", new Param(color, defaultColors));
                colorPickDialogFragment.setArguments(bundle);
                return colorPickDialogFragment;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        Companion() {
        }
    }

    private final void qh() {
        View view = this.rootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById = view.findViewById(R.id.f71823p7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.recycler_choose)");
        this.recyclerView = (RecyclerView) findViewById;
        Param param = this.param;
        if (param == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            param = null;
        }
        int color = param.getColor();
        Param param2 = this.param;
        if (param2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            param2 = null;
        }
        this.adapter = new ColorAdapter(color, param2.getDefaultColors());
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 6));
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        ColorAdapter colorAdapter = this.adapter;
        if (colorAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            colorAdapter = null;
        }
        recyclerView2.setAdapter(colorAdapter);
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view2 = view3;
        }
        view2.findViewById(R.id.wxm).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.base.view.colorpick.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                ColorPickDialogFragment.rh(ColorPickDialogFragment.this, view4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(ColorPickDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        d dVar = this$0.viewModel;
        View view2 = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dVar = null;
        }
        ColorAdapter colorAdapter = this$0.adapter;
        if (colorAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            colorAdapter = null;
        }
        dVar.P1(colorAdapter.getPickedColor());
        View view3 = this$0.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view2 = view3;
        }
        Object parent = view2.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        BottomSheetBehavior.from((View) parent).setState(5);
        EventCollector.getInstance().onViewClicked(view);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final ColorPickDialogFragment sh(int i3) {
        return INSTANCE.c(i3);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f6g, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026agment, container, false)");
        this.rootView = inflate;
        Object obj = requireArguments().get("PARAM_FRAGMENT");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.guild.base.view.colorpick.ColorPickDialogFragment.Param");
        this.param = (Param) obj;
        d.Companion companion = d.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        this.viewModel = companion.a(requireActivity);
        qh();
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setBackgroundColor(0);
    }
}
