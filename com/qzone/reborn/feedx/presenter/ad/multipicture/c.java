package com.qzone.reborn.feedx.presenter.ad.multipicture;

import android.app.Activity;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.qzone.util.ar;
import com.qzone.widget.AsyncImageView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000489:;B\u000f\u0012\u0006\u00105\u001a\u00020 \u00a2\u0006\u0004\b6\u00107J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\u0019\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0018\u00104\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006<"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/multipicture/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/qzone/reborn/feedx/presenter/ad/multipicture/c$b;", "holder", "", "position", "", "k0", "m0", "o0", "p0", "", "q0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "s0", "getItemCount", "r0", "getItemViewType", "", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$BasicInfo$MaterialInfo;", "infos", "Lcom/tencent/gdtad/aditem/GdtAd;", "ad", "t0", "Lcom/qzone/reborn/feedx/presenter/ad/multipicture/c$d;", "styleRule", "v0", "Lcom/qzone/reborn/feedx/presenter/ad/multipicture/c$c;", "onClickListener", "u0", "Landroid/app/Activity;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Activity;", "mActivity", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "mMDPAInfos", "D", "I", "mStyle", "E", "Lcom/qzone/reborn/feedx/presenter/ad/multipicture/c$c;", "mMDPAItemClickListener", UserInfo.SEX_FEMALE, "Z", "mHideAllPrice", "G", "mHideOriginalPrice", "H", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "a", "b", "c", "d", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class c extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    private List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo> mMDPAInfos;

    /* renamed from: D, reason: from kotlin metadata */
    private int mStyle;

    /* renamed from: E, reason: from kotlin metadata */
    private InterfaceC0467c mMDPAItemClickListener;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mHideAllPrice;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mHideOriginalPrice;

    /* renamed from: H, reason: from kotlin metadata */
    private GdtAd mAd;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Activity mActivity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/multipicture/c$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/qzone/widget/AsyncImageView;", "E", "Lcom/qzone/widget/AsyncImageView;", "l", "()Lcom/qzone/widget/AsyncImageView;", "img", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/TextView;", "title", "G", "p", "price", "H", "o", "originalPrice", "Landroid/widget/FrameLayout;", "I", "Landroid/widget/FrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/FrameLayout;", FeedManager.LOAD_MORE, "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final AsyncImageView img;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView title;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView price;

        /* renamed from: H, reason: from kotlin metadata */
        private final TextView originalPrice;

        /* renamed from: I, reason: from kotlin metadata */
        private final FrameLayout loadMore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.my6);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026.qzone_feedx_ad_mdpa_img)");
            this.img = (AsyncImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.my5);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026ne_feedx_ad_mdpa_content)");
            this.title = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.my9);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026zone_feedx_ad_mdpa_price)");
            this.price = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.my8);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.\u2026x_ad_mdpa_original_price)");
            this.originalPrice = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.my7);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.\u2026_feedx_ad_mdpa_load_more)");
            this.loadMore = (FrameLayout) findViewById5;
        }

        /* renamed from: l, reason: from getter */
        public final AsyncImageView getImg() {
            return this.img;
        }

        /* renamed from: m, reason: from getter */
        public final FrameLayout getLoadMore() {
            return this.loadMore;
        }

        /* renamed from: o, reason: from getter */
        public final TextView getOriginalPrice() {
            return this.originalPrice;
        }

        /* renamed from: p, reason: from getter */
        public final TextView getPrice() {
            return this.price;
        }

        /* renamed from: q, reason: from getter */
        public final TextView getTitle() {
            return this.title;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/multipicture/c$c;", "", "", "itemViewType", "Landroid/view/View;", "view", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedx.presenter.ad.multipicture.c$c, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public interface InterfaceC0467c {
        void a(int itemViewType, View view);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/multipicture/c$d;", "", "", "a", "I", "()I", "setStyle", "(I)V", "style", "", "b", "Z", "()Z", "setHideAllPrice", "(Z)V", "isHideAllPrice", "c", "setHideOriginalPrice", "isHideOriginalPrice", "<init>", "(IZZ)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int style;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean isHideAllPrice;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean isHideOriginalPrice;

        public d(int i3, boolean z16, boolean z17) {
            this.style = i3;
            this.isHideAllPrice = z16;
            this.isHideOriginalPrice = z17;
        }

        /* renamed from: a, reason: from getter */
        public final int getStyle() {
            return this.style;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsHideAllPrice() {
            return this.isHideAllPrice;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsHideOriginalPrice() {
            return this.isHideOriginalPrice;
        }
    }

    public c(Activity activity) {
        List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo> emptyList;
        Intrinsics.checkNotNullParameter(activity, "activity");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mMDPAInfos = emptyList;
        this.mStyle = 1;
        this.mActivity = activity;
    }

    private final void k0(b holder, int position) {
        Object orNull;
        int e16;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mMDPAInfos, position);
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo materialInfo = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo) orNull;
        if (materialInfo == null) {
            holder.itemView.setVisibility(8);
            return;
        }
        holder.itemView.setVisibility(0);
        holder.getLoadMore().setVisibility(8);
        holder.getImg().setAsyncImage(materialInfo.image_url.get());
        holder.getImg().setCornerRadius(ar.d(2.5f));
        holder.getTitle().setText(materialInfo.title.get());
        SpannableString spannableString = new SpannableString("\u00a5" + materialInfo.price.get());
        spannableString.setSpan(new AbsoluteSizeSpan(ar.d(8.0f)), 0, 1, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(ar.d(12.0f)), 1, spannableString.length(), 33);
        SpannableString spannableString2 = new SpannableString("\u00a5" + materialInfo.original_price.get());
        spannableString2.setSpan(new AbsoluteSizeSpan(ar.d(7.0f)), 0, 1, 33);
        spannableString2.setSpan(new AbsoluteSizeSpan(ar.d(10.0f)), 1, spannableString2.length(), 33);
        holder.getPrice().setText(spannableString);
        holder.getOriginalPrice().setText(spannableString2);
        int i3 = this.mStyle;
        if (i3 == 1) {
            o0(holder);
        } else if (i3 == 2) {
            p0(holder);
        }
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        if (position == 0) {
            e16 = ar.e(13.0f);
        } else {
            e16 = ar.e(8.0f);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            int i16 = layoutParams2 != null ? layoutParams2.width : -2;
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i16, layoutParams3 != null ? layoutParams3.height : -2);
        }
        if (e16 != marginLayoutParams.leftMargin) {
            marginLayoutParams.leftMargin = e16;
            view.setLayoutParams(marginLayoutParams);
        }
        holder.itemView.setTag(2131296418, Integer.valueOf(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.ad.multipicture.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.l0(c.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(c this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC0467c interfaceC0467c = this$0.mMDPAItemClickListener;
        if (interfaceC0467c != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            interfaceC0467c.a(0, it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void m0(b holder) {
        holder.getImg().setVisibility(8);
        holder.getPrice().setVisibility(8);
        holder.getOriginalPrice().setVisibility(8);
        holder.getTitle().setVisibility(8);
        holder.getLoadMore().setVisibility(0);
        ViewGroup.LayoutParams layoutParams = holder.getLoadMore().getLayoutParams();
        int i3 = this.mStyle;
        if (i3 == 1) {
            layoutParams.width = ar.e(32.0f);
            layoutParams.height = ar.e(70.0f);
        } else if (i3 == 2) {
            layoutParams.width = ar.e(40.0f);
            layoutParams.height = ar.e(148.0f);
        }
        holder.getLoadMore().setLayoutParams(layoutParams);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.ad.multipicture.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.n0(c.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(c this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC0467c interfaceC0467c = this$0.mMDPAItemClickListener;
        if (interfaceC0467c != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            interfaceC0467c.a(1, it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void o0(b holder) {
        holder.getImg().setVisibility(0);
        ViewGroup.LayoutParams layoutParams = holder.getImg().getLayoutParams();
        layoutParams.width = ar.e(70.0f);
        holder.getImg().setLayoutParams(layoutParams);
        holder.getPrice().setVisibility(8);
        holder.getOriginalPrice().setVisibility(8);
        holder.getTitle().setVisibility(8);
    }

    private final void p0(b holder) {
        holder.getImg().setVisibility(0);
        ViewGroup.LayoutParams layoutParams = holder.getImg().getLayoutParams();
        layoutParams.width = ar.e(148.0f);
        holder.getImg().setLayoutParams(layoutParams);
        int i3 = 8;
        holder.getPrice().setVisibility(this.mHideAllPrice ? 8 : 0);
        holder.getOriginalPrice().setPaintFlags(holder.getOriginalPrice().getPaintFlags() | 16);
        TextView originalPrice = holder.getOriginalPrice();
        if (!this.mHideAllPrice && !this.mHideOriginalPrice) {
            i3 = 0;
        }
        originalPrice.setVisibility(i3);
        holder.getTitle().setVisibility(0);
    }

    private final boolean q0() {
        if (this.mStyle != 1 || this.mMDPAInfos.size() > 5) {
            return this.mStyle == 2 && this.mMDPAInfos.size() <= 3;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (q0()) {
            return this.mMDPAInfos.size();
        }
        return this.mMDPAInfos.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return (!q0() && position == getItemCount() - 1) ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0) {
            k0(holder, position);
        } else if (itemViewType != 1) {
            holder.itemView.setVisibility(8);
        } else {
            m0(holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.f1305593, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new b(view);
    }

    public final void t0(List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo> infos, GdtAd ad5) {
        Intrinsics.checkNotNullParameter(infos, "infos");
        Intrinsics.checkNotNullParameter(ad5, "ad");
        this.mMDPAInfos = infos;
        this.mAd = ad5;
    }

    public final void u0(InterfaceC0467c onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.mMDPAItemClickListener = onClickListener;
    }

    public final void v0(d styleRule) {
        Intrinsics.checkNotNullParameter(styleRule, "styleRule");
        this.mStyle = styleRule.getStyle();
        this.mHideAllPrice = styleRule.getIsHideAllPrice();
        this.mHideOriginalPrice = styleRule.getIsHideOriginalPrice();
    }
}
