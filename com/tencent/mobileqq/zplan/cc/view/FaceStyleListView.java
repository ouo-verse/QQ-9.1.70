package com.tencent.mobileqq.zplan.cc.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.mobileqq.zplan.cc.request.PtaFace;
import com.tencent.mobileqq.zplan.cc.view.FaceStyleListView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.slf4j.Marker;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 #2\u00020\u0001:\u0005$%&'\fB'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u00a2\u0006\u0004\b!\u0010\"J \u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007J\u001c\u0010\u000b\u001a\u00020\u00072\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0017\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0014\u0010\u0019\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\rR\u0014\u0010\u001b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\r\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/view/FaceStyleListView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "Lcom/tencent/mobileqq/zplan/cc/request/PtaFace;", "faces", "", "select", "", "setFaceData", "Lkotlin/Function1;", "l", "setItemSelectListener", "f", "I", h.F, "Ljava/util/List;", "faceData", "i", "Lkotlin/jvm/functions/Function1;", "itemSelectListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "faceImageItemSize", BdhLogUtil.LogTag.Tag_Conn, "faceItemSize", "D", "faceItemMargin", "E", "imageMargin", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "b", "c", "d", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class FaceStyleListView extends RecyclerView {

    /* renamed from: C, reason: from kotlin metadata */
    private final int faceItemSize;

    /* renamed from: D, reason: from kotlin metadata */
    private final int faceItemMargin;

    /* renamed from: E, reason: from kotlin metadata */
    private final int imageMargin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int select;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private List<PtaFace> faceData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function1<? super Integer, Unit> itemSelectListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int faceImageItemSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/cc/view/FaceStyleListView$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                int i3 = FaceStyleListView.this.select;
                FaceStyleListView faceStyleListView = FaceStyleListView.this;
                RecyclerView.LayoutManager layoutManager = faceStyleListView.getLayoutManager();
                LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                faceStyleListView.select = linearLayoutManager != null ? linearLayoutManager.findFirstVisibleItemPosition() : 0;
                FaceStyleListView.this.select++;
                if (FaceStyleListView.this.select != i3) {
                    RecyclerView.Adapter adapter = recyclerView.getAdapter();
                    if (adapter != null) {
                        adapter.notifyItemChanged(i3);
                    }
                    RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
                    if (adapter2 != null) {
                        adapter2.notifyItemChanged(FaceStyleListView.this.select);
                    }
                    Function1 function1 = FaceStyleListView.this.itemSelectListener;
                    if (function1 != null) {
                        function1.invoke(Integer.valueOf(FaceStyleListView.this.select % FaceStyleListView.this.faceData.size()));
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/view/FaceStyleListView$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/zplan/cc/view/FaceStyleListView$d;", "Lcom/tencent/mobileqq/zplan/cc/view/FaceStyleListView;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "holder", "position", "", "j0", "getItemCount", "<init>", "(Lcom/tencent/mobileqq/zplan/cc/view/FaceStyleListView;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    private final class c extends RecyclerView.Adapter<d> {
        public c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k0(FaceStyleListView this$0, int i3, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.smoothScrollToPosition(i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return 2147483646;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(d holder, final int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.l((PtaFace) FaceStyleListView.this.faceData.get(position % FaceStyleListView.this.faceData.size()));
            View view = holder.itemView;
            final FaceStyleListView faceStyleListView = FaceStyleListView.this;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.cc.view.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FaceStyleListView.c.k0(FaceStyleListView.this, position, view2);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View it = LayoutInflater.from(FaceStyleListView.this.getContext()).inflate(R.layout.f167417d71, parent, false);
            FaceStyleListView faceStyleListView = FaceStyleListView.this;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            return new d(faceStyleListView, it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010-\u001a\u00020!\u00a2\u0006\u0004\b.\u0010/J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010 \u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016R\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010)\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u0014\u001a\u0004\b(\u0010\u0016R\u0017\u0010,\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b*\u0010#\u001a\u0004\b+\u0010%\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/view/FaceStyleListView$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/zplan/cc/request/PtaFace;", PreDetect.FACE_DETECT, "", "l", "Lcom/tencent/mobileqq/widget/RoundCorneredRelativeLayout;", "E", "Lcom/tencent/mobileqq/widget/RoundCorneredRelativeLayout;", "getFaceImageWrapper", "()Lcom/tencent/mobileqq/widget/RoundCorneredRelativeLayout;", "faceImageWrapper", "Lcom/tencent/image/URLImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/image/URLImageView;", "getFaceImage", "()Lcom/tencent/image/URLImageView;", "faceImage", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "getMiddleText", "()Landroid/widget/TextView;", "middleText", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "getGoldImage", "()Landroid/widget/ImageView;", "goldImage", "I", "getGoldText", "goldText", "Landroid/view/View;", "J", "Landroid/view/View;", "getSilverImage", "()Landroid/view/View;", "silverImage", "K", "getSilverText", "silverText", "L", "getTextGroup", "textGroup", "itemView", "<init>", "(Lcom/tencent/mobileqq/zplan/cc/view/FaceStyleListView;Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final RoundCorneredRelativeLayout faceImageWrapper;

        /* renamed from: F, reason: from kotlin metadata */
        private final URLImageView faceImage;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView middleText;

        /* renamed from: H, reason: from kotlin metadata */
        private final ImageView goldImage;

        /* renamed from: I, reason: from kotlin metadata */
        private final TextView goldText;

        /* renamed from: J, reason: from kotlin metadata */
        private final View silverImage;

        /* renamed from: K, reason: from kotlin metadata */
        private final TextView silverText;

        /* renamed from: L, reason: from kotlin metadata */
        private final View textGroup;
        final /* synthetic */ FaceStyleListView M;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FaceStyleListView faceStyleListView, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.M = faceStyleListView;
            View findViewById = itemView.findViewById(R.id.pth);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.face_image_wrapper)");
            RoundCorneredRelativeLayout roundCorneredRelativeLayout = (RoundCorneredRelativeLayout) findViewById;
            this.faceImageWrapper = roundCorneredRelativeLayout;
            View findViewById2 = itemView.findViewById(R.id.ptf);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.face_image)");
            this.faceImage = (URLImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f163541qo4);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.style_middle_text)");
            this.middleText = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.f163539qo2);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.style_gold_image)");
            this.goldImage = (ImageView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.f163540qo3);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.style_gold_text)");
            this.goldText = (TextView) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.qo5);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.style_silver_image)");
            this.silverImage = findViewById6;
            View findViewById7 = itemView.findViewById(R.id.qo6);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.style_silver_text)");
            this.silverText = (TextView) findViewById7;
            View findViewById8 = itemView.findViewById(R.id.qo7);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.style_text_group)");
            this.textGroup = findViewById8;
            ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
            layoutParams.width = faceStyleListView.faceItemSize;
            layoutParams.height = faceStyleListView.faceItemSize;
            roundCorneredRelativeLayout.setRadius(faceStyleListView.faceImageItemSize / 2.0f, faceStyleListView.faceImageItemSize / 2.0f, faceStyleListView.faceImageItemSize / 2.0f, faceStyleListView.faceImageItemSize / 2.0f);
            ViewGroup.LayoutParams layoutParams2 = roundCorneredRelativeLayout.getLayoutParams();
            layoutParams2.width = faceStyleListView.faceImageItemSize;
            layoutParams2.height = faceStyleListView.faceImageItemSize;
        }

        public final void l(PtaFace face2) {
            Intrinsics.checkNotNullParameter(face2, "face");
            String thumbnail = face2.getThumbnail();
            if (!(thumbnail == null || thumbnail.length() == 0)) {
                this.faceImage.setImageDrawable(URLDrawable.getDrawable(thumbnail, URLDrawable.URLDrawableOptions.obtain()));
            }
            switch (face2.getType()) {
                case 1:
                    this.textGroup.setVisibility(0);
                    this.middleText.setVisibility(8);
                    this.silverImage.setVisibility(8);
                    this.silverText.setVisibility(8);
                    this.goldImage.setVisibility(0);
                    ViewGroup.LayoutParams layoutParams = this.goldImage.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.setMargins(this.M.imageMargin, 0, 0, 0);
                    this.goldImage.setLayoutParams(layoutParams2);
                    this.goldImage.setImageResource(R.drawable.i87);
                    this.goldText.setVisibility(0);
                    this.goldText.setText(String.valueOf(face2.getGoldMoney()));
                    return;
                case 2:
                    this.textGroup.setVisibility(0);
                    this.middleText.setVisibility(8);
                    this.silverImage.setVisibility(8);
                    this.silverText.setVisibility(8);
                    this.goldImage.setVisibility(0);
                    ViewGroup.LayoutParams layoutParams3 = this.goldImage.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
                    layoutParams4.setMargins(this.M.imageMargin, 0, 0, 0);
                    this.goldImage.setLayoutParams(layoutParams4);
                    this.goldImage.setImageResource(R.drawable.i88);
                    this.goldText.setVisibility(0);
                    this.goldText.setText(String.valueOf(face2.getSilverMoney()));
                    return;
                case 3:
                    this.textGroup.setVisibility(0);
                    this.middleText.setVisibility(0);
                    this.middleText.setText(Marker.ANY_NON_NULL_MARKER);
                    ViewGroup.LayoutParams layoutParams5 = this.middleText.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    ((RelativeLayout.LayoutParams) layoutParams5).removeRule(14);
                    this.silverImage.setVisibility(0);
                    this.silverText.setVisibility(0);
                    this.silverText.setText(String.valueOf(face2.getSilverMoney()));
                    this.goldImage.setVisibility(0);
                    ViewGroup.LayoutParams layoutParams6 = this.goldImage.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams6, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) layoutParams6;
                    layoutParams7.setMargins(0, 0, 0, 0);
                    this.goldImage.setLayoutParams(layoutParams7);
                    this.goldImage.setImageResource(R.drawable.i87);
                    this.goldText.setVisibility(0);
                    this.goldText.setText(String.valueOf(face2.getGoldMoney()));
                    return;
                case 4:
                    this.textGroup.setVisibility(0);
                    this.middleText.setVisibility(0);
                    this.middleText.setText("\u6216");
                    ViewGroup.LayoutParams layoutParams8 = this.middleText.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams8, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    ((RelativeLayout.LayoutParams) layoutParams8).removeRule(14);
                    this.silverImage.setVisibility(0);
                    this.silverText.setVisibility(0);
                    this.silverText.setText(String.valueOf(face2.getSilverMoney()));
                    this.goldImage.setVisibility(0);
                    ViewGroup.LayoutParams layoutParams9 = this.goldImage.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams9, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) layoutParams9;
                    layoutParams10.setMargins(0, 0, 0, 0);
                    this.goldImage.setLayoutParams(layoutParams10);
                    this.goldImage.setImageResource(R.drawable.i87);
                    this.goldText.setVisibility(0);
                    this.goldText.setText(String.valueOf(face2.getGoldMoney()));
                    return;
                case 5:
                    this.textGroup.setVisibility(0);
                    this.middleText.setVisibility(0);
                    this.middleText.setText("\u5df2\u62e5\u6709");
                    ViewGroup.LayoutParams layoutParams11 = this.middleText.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams11, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    ((RelativeLayout.LayoutParams) layoutParams11).addRule(14);
                    this.goldImage.setVisibility(8);
                    this.goldText.setVisibility(8);
                    this.silverImage.setVisibility(8);
                    this.silverText.setVisibility(8);
                    return;
                case 6:
                    this.textGroup.setVisibility(4);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J(\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0018\u00010\bR\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\f\u001a\u00020\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/view/FaceStyleListView$e;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "onLayoutCompleted", "", "dx", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "scrollHorizontallyBy", "r", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/mobileqq/zplan/cc/view/FaceStyleListView;Landroid/content/Context;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    private final class e extends LinearLayoutManager {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FaceStyleListView f332584d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(FaceStyleListView faceStyleListView, Context context) {
            super(context, 0, false);
            Intrinsics.checkNotNullParameter(context, "context");
            this.f332584d = faceStyleListView;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutCompleted(RecyclerView.State state) {
            super.onLayoutCompleted(state);
            r();
        }

        public final void r() {
            float width = getWidth() / 2.0f;
            float f16 = this.f332584d.faceItemSize;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    float f17 = Math.abs(width - (((float) (getDecoratedLeft(childAt) + getDecoratedRight(childAt))) / 2.0f)) >= f16 ? 1.0f : 1.5f;
                    View findViewById = childAt.findViewById(R.id.ptg);
                    if (f17 > 1.0f) {
                        findViewById.setBackground(this.f332584d.getResources().getDrawable(R.drawable.hag));
                    } else {
                        findViewById.setBackground(null);
                    }
                    childAt.setScaleX(f17);
                    childAt.setScaleY(f17);
                }
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public int scrollHorizontallyBy(int dx5, RecyclerView.Recycler recycler, RecyclerView.State state) {
            int scrollHorizontallyBy = super.scrollHorizontallyBy(dx5, recycler, state);
            r();
            return scrollHorizontallyBy;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u00a2\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/view/FaceStyleListView$f;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "getMargin", "()I", "setMargin", "(I)V", "margin", "<init>", "(Lcom/tencent/mobileqq/zplan/cc/view/FaceStyleListView;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    private final class f extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int margin;

        public f(int i3) {
            this.margin = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int i3 = this.margin;
            outRect.set(i3, 0, i3, 0);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FaceStyleListView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setFaceData(List<PtaFace> faces, int select) {
        Intrinsics.checkNotNullParameter(faces, "faces");
        this.select = select;
        this.faceData = faces;
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        scrollToPosition(LockFreeTaskQueueCore.MAX_CAPACITY_MASK - (LockFreeTaskQueueCore.MAX_CAPACITY_MASK % this.faceData.size()));
    }

    public final void setItemSelectListener(Function1<? super Integer, Unit> l3) {
        this.itemSelectListener = l3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FaceStyleListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ FaceStyleListView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceStyleListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        List<PtaFace> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.faceData = emptyList;
        this.faceImageItemSize = (int) TypedValue.applyDimension(1, 48.0f, context.getResources().getDisplayMetrics());
        this.faceItemSize = (int) TypedValue.applyDimension(1, 85.0f, context.getResources().getDisplayMetrics());
        int applyDimension = (int) TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
        this.faceItemMargin = applyDimension;
        this.imageMargin = (int) TypedValue.applyDimension(1, 30.0f, context.getResources().getDisplayMetrics());
        setLayoutManager(new e(this, context));
        setAdapter(new c());
        addItemDecoration(new f(applyDimension));
        new PagerSnapHelper().attachToRecyclerView(this);
        addOnScrollListener(new a());
    }

    public static /* synthetic */ void setFaceData$default(FaceStyleListView faceStyleListView, List list, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        faceStyleListView.setFaceData(list, i3);
    }
}
