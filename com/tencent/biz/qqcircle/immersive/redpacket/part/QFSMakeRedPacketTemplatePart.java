package com.tencent.biz.qqcircle.immersive.redpacket.part;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.redpacket.part.QFSMakeRedPacketTemplatePart;
import com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.QFSMakeRedPacketViewModel;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.RoundFrameLayout;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u000b*\u0001\u0015\u0018\u0000 \u001b2\u00020\u0001:\u0004\u001c\u001d\u001e\bB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketTemplatePart;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "rvTemplateList", "Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketTemplatePart$c;", "e", "Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketTemplatePart$c;", "rvAdapter", "Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/QFSMakeRedPacketViewModel;", "f", "Lkotlin/Lazy;", "D9", "()Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/QFSMakeRedPacketViewModel;", "viewModel", "com/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketTemplatePart$e", tl.h.F, "Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketTemplatePart$e;", "listener", "<init>", "()V", "i", "a", "b", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSMakeRedPacketTemplatePart extends com.tencent.biz.qqcircle.bizparts.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecyclerView rvTemplateList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c rvAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e listener;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketTemplatePart$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.right = ImmersiveUtils.dpToPx(12.0f);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketTemplatePart$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketTemplatePart$d;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "list", "", "setData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "j0", "getItemCount", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "i0", "Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketTemplatePart$c$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketTemplatePart$c$a;", "clickListener", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "dataList", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketTemplatePart$c$a;)V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends RecyclerView.Adapter<d> {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final List<MetaMaterial> dataList;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a clickListener;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketTemplatePart$c$a;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes4.dex */
        public interface a {
            void a(@NotNull MetaMaterial material);
        }

        public c(@NotNull a clickListener) {
            Intrinsics.checkNotNullParameter(clickListener, "clickListener");
            this.clickListener = clickListener;
            this.dataList = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.dataList.size();
        }

        public final void i0(@NotNull MetaMaterial material) {
            Intrinsics.checkNotNullParameter(material, "material");
            this.clickListener.a(material);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull d holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.p(this.dataList.get(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ghw, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new d(itemView, this);
        }

        public final void setData(@NotNull List<MetaCategory> list) {
            boolean z16;
            Intrinsics.checkNotNullParameter(list, "list");
            this.dataList.clear();
            if (!list.isEmpty()) {
                ArrayList<MetaMaterial> arrayList = list.get(0).materials;
                if (arrayList != null && !arrayList.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    List<MetaMaterial> list2 = this.dataList;
                    ArrayList<MetaMaterial> arrayList2 = list.get(0).materials;
                    Intrinsics.checkNotNullExpressionValue(arrayList2, "list[0].materials");
                    list2.addAll(arrayList2);
                    notifyDataSetChanged();
                    return;
                }
            }
            QLog.w("QFSMakeRedPacketTemplatePart", 1, "setData, data is null or empty ");
            notifyDataSetChanged();
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketTemplatePart$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketTemplatePart$c;", "E", "Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketTemplatePart$c;", "adapter", "Lcom/tencent/biz/qqcircle/widgets/RoundFrameLayout;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/widgets/RoundFrameLayout;", "flRound", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "ivCover", "H", "ivRedPacketFg", "I", "ivOpenIcon", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "tvTitle", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketTemplatePart$c;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final c adapter;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final RoundFrameLayout flRound;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final ImageView ivCover;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final ImageView ivRedPacketFg;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final ImageView ivOpenIcon;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final TextView tvTitle;

        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketTemplatePart$d$a", "Lcom/tencent/mobileqq/vas/apng/api/ApngOptions$URLDrawableListenerAdapter;", "Lcom/tencent/image/URLDrawable;", "arg0", "", "onLoadSuccessed", "onLoadCanceled", "", "arg1", "onLoadFialed", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes4.dex */
        public static final class a extends ApngOptions.URLDrawableListenerAdapter {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f89416d;

            a(String str) {
                this.f89416d = str;
            }

            @Override // com.tencent.mobileqq.vas.apng.api.ApngOptions.URLDrawableListenerAdapter, com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(@NotNull URLDrawable arg0) {
                Intrinsics.checkNotNullParameter(arg0, "arg0");
                QLog.d("QFSMakeRedPacketTemplatePart", 1, "bindCover, onLoadCanceled, url:" + this.f89416d);
            }

            @Override // com.tencent.mobileqq.vas.apng.api.ApngOptions.URLDrawableListenerAdapter, com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(@NotNull URLDrawable arg0, @NotNull Throwable arg1) {
                Intrinsics.checkNotNullParameter(arg0, "arg0");
                Intrinsics.checkNotNullParameter(arg1, "arg1");
                QLog.w("QFSMakeRedPacketTemplatePart", 1, "bindCover, onLoadFailed, url:" + this.f89416d, arg1);
            }

            @Override // com.tencent.mobileqq.vas.apng.api.ApngOptions.URLDrawableListenerAdapter, com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(@NotNull URLDrawable arg0) {
                Intrinsics.checkNotNullParameter(arg0, "arg0");
                QLog.d("QFSMakeRedPacketTemplatePart", 1, "bindCover, onLoadSucceed, url:" + this.f89416d);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull View itemView, @NotNull c adapter) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.adapter = adapter;
            View findViewById = itemView.findViewById(R.id.v8m);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.fl_round)");
            this.flRound = (RoundFrameLayout) findViewById;
            View findViewById2 = itemView.findViewById(R.id.duw);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.iv_cover)");
            this.ivCover = (ImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.y7y);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.iv_red_packet_fg)");
            this.ivRedPacketFg = (ImageView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.y6m);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.iv_open_icon)");
            this.ivOpenIcon = (ImageView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.kbs);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.tv_title)");
            this.tvTitle = (TextView) findViewById5;
        }

        private final void m(final MetaMaterial material) {
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSMakeRedPacketTemplatePart.d.n(MetaMaterial.this, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(MetaMaterial material, d this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(material, "$material");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!FastClickUtils.isFastDoubleClick(String.valueOf(material.hashCode()))) {
                this$0.adapter.i0(material);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void o(MetaMaterial material) {
            String str = material.additionalFields.get("staticMotionCoverUrl");
            if (str != null) {
                com.tencent.biz.qqcircle.immersive.redpacket.util.a.b(com.tencent.biz.qqcircle.immersive.redpacket.util.a.f89583a, this.ivCover, str, false, false, 8, null);
            }
            String str2 = material.additionalFields.get("motionCoverUrl");
            if (str2 != null) {
                IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
                ApngOptions apngOptions = new ApngOptions();
                apngOptions.setLoadListener(new a(str2));
                Unit unit = Unit.INSTANCE;
                this.ivCover.setForeground(iVasApngFactory.getApngURLDrawable("QFSMakeRedPacketTemplatePart", str2, apngOptions));
            }
        }

        private final void q() {
            this.flRound.setRadius(cx.a(8.0f));
            com.tencent.biz.qqcircle.immersive.redpacket.util.a aVar = com.tencent.biz.qqcircle.immersive.redpacket.util.a.f89583a;
            com.tencent.biz.qqcircle.immersive.redpacket.util.a.b(aVar, this.ivRedPacketFg, "qvideo_hongbao_close", false, true, 4, null);
            com.tencent.biz.qqcircle.immersive.redpacket.util.a.b(aVar, this.ivOpenIcon, "qvideo_hongbao_icon_open_front", false, false, 12, null);
        }

        private final void r(MetaMaterial material) {
            this.tvTitle.setText(material.additionalFields.get("name"));
        }

        public final void p(@NotNull MetaMaterial material) {
            Intrinsics.checkNotNullParameter(material, "material");
            QLog.d("QFSMakeRedPacketTemplatePart", 1, "bindData, additionalFields:" + material.additionalFields);
            q();
            o(material);
            r(material);
            m(material);
            com.tencent.biz.qqcircle.immersive.redpacket.util.b bVar = com.tencent.biz.qqcircle.immersive.redpacket.util.b.f89584a;
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            String str = material.f30533id;
            Intrinsics.checkNotNullExpressionValue(str, "material.id");
            com.tencent.biz.qqcircle.immersive.redpacket.util.b.h(bVar, itemView, null, str, 2, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketTemplatePart$e", "Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketTemplatePart$c$a;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class e implements c.a {
        e() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.redpacket.part.QFSMakeRedPacketTemplatePart.c.a
        public void a(@NotNull MetaMaterial material) {
            Intrinsics.checkNotNullParameter(material, "material");
            String str = material.additionalFields.get(ZPlanPublishSource.FROM_SCHEME);
            if (str != null) {
                QFSMakeRedPacketTemplatePart qFSMakeRedPacketTemplatePart = QFSMakeRedPacketTemplatePart.this;
                QFSMakeRedPacketViewModel D9 = qFSMakeRedPacketTemplatePart.D9();
                Context context = qFSMakeRedPacketTemplatePart.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                D9.i2(context, str, Intrinsics.areEqual(material.additionalFields.get("recommendType"), "h5-h5"));
            }
        }
    }

    public QFSMakeRedPacketTemplatePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QFSMakeRedPacketViewModel>() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.QFSMakeRedPacketTemplatePart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QFSMakeRedPacketViewModel invoke() {
                return (QFSMakeRedPacketViewModel) QFSMakeRedPacketTemplatePart.this.getViewModel(QFSMakeRedPacketViewModel.class);
            }
        });
        this.viewModel = lazy;
        this.listener = new e();
    }

    private final void B9() {
        LiveData<List<MetaCategory>> c26 = D9().c2();
        Fragment hostFragment = getHostFragment();
        final Function1<List<? extends MetaCategory>, Unit> function1 = new Function1<List<? extends MetaCategory>, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.QFSMakeRedPacketTemplatePart$getRedPacketMaterialList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MetaCategory> list) {
                invoke2((List<MetaCategory>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<MetaCategory> it) {
                QFSMakeRedPacketTemplatePart.c cVar;
                cVar = QFSMakeRedPacketTemplatePart.this.rvAdapter;
                if (cVar != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    cVar.setData(it);
                }
            }
        };
        c26.observe(hostFragment, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSMakeRedPacketTemplatePart.C9(Function1.this, obj);
            }
        });
        D9().d2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QFSMakeRedPacketViewModel D9() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (QFSMakeRedPacketViewModel) value;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        com.tencent.biz.qqcircle.immersive.redpacket.util.a.b(com.tencent.biz.qqcircle.immersive.redpacket.util.a.f89583a, (ImageView) rootView.findViewById(R.id.y9s), "qvideo_hongbao_icon_moban", false, false, 12, null);
        View findViewById = rootView.findViewById(R.id.f7921496);
        RecyclerView recyclerView = (RecyclerView) findViewById;
        c cVar = new c(this.listener);
        this.rvAdapter = cVar;
        recyclerView.setAdapter(cVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.addItemDecoration(new b());
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Re\u2026emDecoration())\n        }");
        this.rvTemplateList = recyclerView;
        B9();
    }
}
