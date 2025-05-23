package com.tencent.ecommerce.biz.comment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ktx.ImageViewKt;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.repo.comment.ECQShopOrderReviewCommentInfo;
import com.tencent.ecommerce.repo.comment.TextData;
import com.tencent.ecommerce.repo.comment.h;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 T2\u00020\u0001:\u0003UVWB\u0007\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016R\u0014\u0010\u001b\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0014\u0010!\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00100\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010+R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0016\u00108\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00103R\u0016\u0010:\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010#R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001b\u0010D\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010JR\u0016\u0010O\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010JR\u0016\u0010Q\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010J\u00a8\u0006X"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECQShopReviewCommentFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "initArguments", "Landroid/view/View;", "view", "initView", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Sh", "Rh", "Lcom/tencent/ecommerce/repo/comment/c;", "info", "Th", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getContentLayoutId", "", "getBusinessDescription", "", "Eh", "Dh", "Bh", "P", "I", "ROW_SPACE", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "MAX_ITEM_WIDTH", BdhLogUtil.LogTag.Tag_Req, "COLUMN_SPACE", ExifInterface.LATITUDE_SOUTH, "PADDING_HORIZONTAL", "T", "Landroid/view/View;", "contentContainer", "Landroid/widget/ImageView;", "U", "Landroid/widget/ImageView;", "avatarImageView", "Landroid/widget/TextView;", "V", "Landroid/widget/TextView;", "nameTextView", "W", "dateTextView", "X", "commentTextView", "Landroid/widget/RatingBar;", "Y", "Landroid/widget/RatingBar;", "productQualityRatingBar", "Z", "logisticsServiceRatingBar", "a0", "shopServiceRatingBar", "b0", "networkErrContainer", "Ljava/text/SimpleDateFormat;", "c0", "Ljava/text/SimpleDateFormat;", "dateFormat", "Lcom/tencent/ecommerce/biz/comment/ECQShopReviewCommentViewModel;", "d0", "Lkotlin/Lazy;", "Qh", "()Lcom/tencent/ecommerce/biz/comment/ECQShopReviewCommentViewModel;", "viewModel", "Lcom/tencent/ecommerce/biz/comment/ECQShopReviewCommentFragment$ECQShopReviewCommentAdapter;", "e0", "Lcom/tencent/ecommerce/biz/comment/ECQShopReviewCommentFragment$ECQShopReviewCommentAdapter;", "adapter", "f0", "Ljava/lang/String;", WSAutoShowCommentParams.KEY_COMMENT_ID, "g0", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "h0", "skuId", "i0", "spuId", "<init>", "()V", "j0", "a", "ECQShopReviewCommentAdapter", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECQShopReviewCommentFragment extends ECBaseFragment {

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private View contentContainer;

    /* renamed from: U, reason: from kotlin metadata */
    private ImageView avatarImageView;

    /* renamed from: V, reason: from kotlin metadata */
    private TextView nameTextView;

    /* renamed from: W, reason: from kotlin metadata */
    private TextView dateTextView;

    /* renamed from: X, reason: from kotlin metadata */
    private TextView commentTextView;

    /* renamed from: Y, reason: from kotlin metadata */
    private RatingBar productQualityRatingBar;

    /* renamed from: Z, reason: from kotlin metadata */
    private RatingBar logisticsServiceRatingBar;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private RatingBar shopServiceRatingBar;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private View networkErrContainer;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private ECQShopReviewCommentAdapter adapter;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private String commentId;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private String orderId;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private String skuId;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private String spuId;

    /* renamed from: P, reason: from kotlin metadata */
    private final int ROW_SPACE = com.tencent.ecommerce.biz.util.e.c(8.0f);

    /* renamed from: Q, reason: from kotlin metadata */
    private final int MAX_ITEM_WIDTH = com.tencent.ecommerce.biz.util.e.c(110.0f);

    /* renamed from: R, reason: from kotlin metadata */
    private final int COLUMN_SPACE = com.tencent.ecommerce.biz.util.e.c(8.0f);

    /* renamed from: S, reason: from kotlin metadata */
    private final int PADDING_HORIZONTAL = com.tencent.ecommerce.biz.util.e.c(16.0f);

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final SimpleDateFormat dateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.CHINA);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\"#B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0014\u0010\u0010\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECQShopReviewCommentFragment$ECQShopReviewCommentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/comment/ECQShopReviewCommentFragment$ECQShopReviewCommentAdapter$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "", "j0", "getItemCount", "", "", CoverDBCacheData.URLS, "setData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "data", "Lcom/tencent/ecommerce/biz/comment/ECQShopReviewCommentFragment$ECQShopReviewCommentAdapter$ItemClickListener;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/biz/comment/ECQShopReviewCommentFragment$ECQShopReviewCommentAdapter$ItemClickListener;", "i0", "()Lcom/tencent/ecommerce/biz/comment/ECQShopReviewCommentFragment$ECQShopReviewCommentAdapter$ItemClickListener;", "l0", "(Lcom/tencent/ecommerce/biz/comment/ECQShopReviewCommentFragment$ECQShopReviewCommentAdapter$ItemClickListener;)V", "itemClickListener", "D", "I", "itemHeight", "<init>", "(I)V", "a", "ItemClickListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class ECQShopReviewCommentAdapter extends RecyclerView.Adapter<a> {

        /* renamed from: C, reason: from kotlin metadata */
        private ItemClickListener itemClickListener;

        /* renamed from: D, reason: from kotlin metadata */
        private final int itemHeight;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final List<String> data = new ArrayList();

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECQShopReviewCommentFragment$ECQShopReviewCommentAdapter$ItemClickListener;", "", "onItemClick", "", "position", "", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public interface ItemClickListener {
            void onItemClick(int position);
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECQShopReviewCommentFragment$ECQShopReviewCommentAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "url", "", "l", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/ImageView;", "imageView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a extends RecyclerView.ViewHolder {

            /* renamed from: E, reason: from kotlin metadata */
            private final ImageView imageView;

            public a(View view) {
                super(view);
                this.imageView = (ImageView) view.findViewById(R.id.o0z);
            }

            public final void l(String url) {
                ImageViewKt.b(this.imageView, url, 0, 0, 0, 14, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class b implements View.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f101400e;

            b(int i3) {
                this.f101400e = i3;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ItemClickListener itemClickListener = ECQShopReviewCommentAdapter.this.getItemClickListener();
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(this.f101400e);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public ECQShopReviewCommentAdapter(int i3) {
            this.itemHeight = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.data.size();
        }

        /* renamed from: i0, reason: from getter */
        public final ItemClickListener getItemClickListener() {
            return this.itemClickListener;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a holder, int position) {
            holder.l(this.data.get(position));
            holder.itemView.setOnClickListener(new b(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.ctg, parent, false);
            inflate.getLayoutParams().height = this.itemHeight;
            return new a(inflate);
        }

        public final void l0(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        public final void setData(List<String> urls) {
            this.data.clear();
            this.data.addAll(urls);
            notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J(\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECQShopReviewCommentFragment$a;", "", "Landroid/content/Context;", "context", "", WSAutoShowCommentParams.KEY_COMMENT_ID, "", "a", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "skuId", "spuId", "b", "COMMENT_ID", "Ljava/lang/String;", "", "MIN_RECYCLE_VIEW_COLUMN", "I", "ORDER_ID", "SKU_ID", "SPU_ID", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.comment.ECQShopReviewCommentFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final void a(Context context, String commentId) throws IllegalArgumentException {
            if (!(commentId.length() == 0)) {
                Bundle bundle = new Bundle();
                bundle.putString("comment_id", commentId);
                yi0.a.q(context, ECQShopReviewCommentFragment.class, bundle, 0, null, 24, null);
                return;
            }
            throw new IllegalArgumentException("must have params comment_id");
        }

        public final void b(Context context, String orderId, String skuId, String spuId) throws IllegalArgumentException {
            if (!(orderId.length() == 0)) {
                if (!(skuId.length() == 0)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("order_id", orderId);
                    bundle.putString("sku_id", skuId);
                    bundle.putString("spu_id", spuId);
                    yi0.a.q(context, ECQShopReviewCommentFragment.class, bundle, 0, null, 24, null);
                    return;
                }
            }
            throw new IllegalArgumentException("must have params orderId or skuId");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\f\u00a2\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECQShopReviewCommentFragment$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "rowSpace", "e", "columnSpace", "f", "spanCount", "<init>", "(III)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int rowSpace;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int columnSpace;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int spanCount;

        public b(int i3, int i16, int i17) {
            this.rowSpace = i3;
            this.columnSpace = i16;
            this.spanCount = i17;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            int i3 = this.spanCount;
            int i16 = childAdapterPosition % i3;
            int i17 = this.columnSpace;
            outRect.left = (i16 * i17) / i3;
            outRect.right = i17 - (((i16 + 1) * i17) / i3);
            if (childAdapterPosition >= i3) {
                outRect.top = this.rowSpace;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/comment/ECQShopReviewCommentFragment$initView$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView f101406e;

        d(RecyclerView recyclerView) {
            this.f101406e = recyclerView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECQShopReviewCommentFragment.this.Qh().N1(ECQShopReviewCommentFragment.this.commentId);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "onItemClick"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements ECQShopReviewCommentAdapter.ItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ECQShopOrderReviewCommentInfo f101407a;

        e(ECQShopOrderReviewCommentInfo eCQShopOrderReviewCommentInfo) {
            this.f101407a = eCQShopOrderReviewCommentInfo;
        }

        @Override // com.tencent.ecommerce.biz.comment.ECQShopReviewCommentFragment.ECQShopReviewCommentAdapter.ItemClickListener
        public final void onItemClick(int i3) {
            lg0.a.b(lg0.a.f414523b, this.f101407a.b(), i3, null, 4, null);
        }
    }

    public ECQShopReviewCommentFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.comment.ECQShopReviewCommentFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECQShopReviewCommentViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.comment.ECQShopReviewCommentFragment$$special$$inlined$viewModels$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.commentId = "";
        this.orderId = "";
        this.skuId = "";
        this.spuId = "";
    }

    public static final /* synthetic */ View Mh(ECQShopReviewCommentFragment eCQShopReviewCommentFragment) {
        View view = eCQShopReviewCommentFragment.contentContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        }
        return view;
    }

    public static final /* synthetic */ View Nh(ECQShopReviewCommentFragment eCQShopReviewCommentFragment) {
        View view = eCQShopReviewCommentFragment.networkErrContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkErrContainer");
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECQShopReviewCommentViewModel Qh() {
        return (ECQShopReviewCommentViewModel) this.viewModel.getValue();
    }

    private final void Rh() {
        Qh().M1().observe(getViewLifecycleOwner(), new c());
        if (this.commentId.length() > 0) {
            Qh().N1(this.commentId);
        } else {
            Qh().O1(this.orderId, this.skuId, this.spuId);
        }
    }

    private final void Sh(RecyclerView recyclerView) {
        int screenWidthPx = (int) PTSDeviceUtil.getScreenWidthPx();
        int i3 = this.PADDING_HORIZONTAL;
        int i16 = this.MAX_ITEM_WIDTH;
        int i17 = this.COLUMN_SPACE;
        int i18 = (screenWidthPx - i3) / (i16 + i17);
        if (i18 < 3) {
            i18 = 3;
        }
        ECQShopReviewCommentAdapter eCQShopReviewCommentAdapter = new ECQShopReviewCommentAdapter(((screenWidthPx - i3) - ((i18 - 1) * this.ROW_SPACE)) / i18);
        this.adapter = eCQShopReviewCommentAdapter;
        recyclerView.setAdapter(eCQShopReviewCommentAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), i18));
        recyclerView.setOverScrollMode(2);
        recyclerView.addItemDecoration(new b(this.ROW_SPACE, i17, i18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th(ECQShopOrderReviewCommentInfo info) {
        boolean isBlank;
        ImageView imageView = this.avatarImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarImageView");
        }
        ImageViewKt.b(imageView, info.userIconUrl, 0, 0, 0, 14, null);
        TextView textView = this.nameTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nameTextView");
        }
        textView.setText(info.nickName);
        TextView textView2 = this.dateTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dateTextView");
        }
        textView2.setText(this.dateFormat.format(new Date(info.createTimeMs)));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (h hVar : info.a()) {
            if (hVar instanceof TextData) {
                spannableStringBuilder.append((CharSequence) ((TextData) hVar).text);
            }
        }
        String spannableStringBuilder2 = spannableStringBuilder.toString();
        TextView textView3 = this.commentTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentTextView");
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(spannableStringBuilder2);
        if (isBlank) {
            spannableStringBuilder2 = getResources().getString(R.string.wqb);
        }
        textView3.setText(spannableStringBuilder2);
        RatingBar ratingBar = this.productQualityRatingBar;
        if (ratingBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productQualityRatingBar");
        }
        ratingBar.setRating(info.productQualityScore);
        RatingBar ratingBar2 = this.logisticsServiceRatingBar;
        if (ratingBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logisticsServiceRatingBar");
        }
        ratingBar2.setRating(info.logisticsQualityScore);
        RatingBar ratingBar3 = this.shopServiceRatingBar;
        if (ratingBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopServiceRatingBar");
        }
        ratingBar3.setRating(info.getShopQualityScore());
        ECQShopReviewCommentAdapter eCQShopReviewCommentAdapter = this.adapter;
        if (eCQShopReviewCommentAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        eCQShopReviewCommentAdapter.l0(new e(info));
        ECQShopReviewCommentAdapter eCQShopReviewCommentAdapter2 = this.adapter;
        if (eCQShopReviewCommentAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        eCQShopReviewCommentAdapter2.setData(info.d());
        com.tencent.ecommerce.biz.comment.d.f101425a.f(info.orderId, info.spuId, info.skuId, this.commentId, info.productQualityScore, info.logisticsQualityScore, info.getShopQualityScore());
    }

    private final void initArguments() {
        String str;
        String str2;
        String str3;
        String string;
        Bundle arguments = getArguments();
        String str4 = "";
        if (arguments == null || (str = arguments.getString("comment_id")) == null) {
            str = "";
        }
        this.commentId = str;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString("order_id")) == null) {
            str2 = "";
        }
        this.orderId = str2;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str3 = arguments3.getString("spu_id")) == null) {
            str3 = "";
        }
        this.spuId = str3;
        Bundle arguments4 = getArguments();
        if (arguments4 != null && (string = arguments4.getString("sku_id")) != null) {
            str4 = string;
        }
        this.skuId = str4;
        if (this.commentId.length() == 0) {
            if (!(this.orderId.length() == 0)) {
                if (!(this.skuId.length() == 0)) {
                    return;
                }
            }
            if (!ok0.a.f423033a) {
                requireActivity().finish();
                return;
            }
            throw new IllegalArgumentException("must have params comment_id");
        }
    }

    private final void initView(View view) {
        setTitle(getResources().getString(R.string.wrq));
        this.contentContainer = view.findViewById(R.id.nup);
        this.networkErrContainer = view.findViewById(R.id.f163071o51);
        view.findViewById(R.id.f163072o52).setOnClickListener(new d(null));
        this.avatarImageView = (ImageView) view.findViewById(R.id.nq_);
        this.nameTextView = (TextView) view.findViewById(R.id.o4z);
        this.dateTextView = (TextView) view.findViewById(R.id.nuz);
        this.commentTextView = (TextView) view.findViewById(R.id.ntw);
        this.productQualityRatingBar = (RatingBar) view.findViewById(R.id.ntl);
        this.logisticsServiceRatingBar = (RatingBar) view.findViewById(R.id.ntn);
        this.shopServiceRatingBar = (RatingBar) view.findViewById(R.id.nto);
        Sh((RecyclerView) view.findViewById(R.id.o8n));
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Bh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Dh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECQShopReviewCommentFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.ctf;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initArguments();
        initView(view);
        Rh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/ecommerce/repo/comment/c;", "it", "", "a", "(Lcom/tencent/ecommerce/repo/comment/c;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c<T> implements Observer<ECQShopOrderReviewCommentInfo> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ECQShopOrderReviewCommentInfo eCQShopOrderReviewCommentInfo) {
            if (eCQShopOrderReviewCommentInfo == null) {
                ECQShopReviewCommentFragment.Mh(ECQShopReviewCommentFragment.this).setVisibility(8);
                ECQShopReviewCommentFragment.Nh(ECQShopReviewCommentFragment.this).setVisibility(0);
                i.f101155b.c(R.string.wo_, ECToastIcon.ICON_ERROR, 0);
            } else {
                ECQShopReviewCommentFragment.Mh(ECQShopReviewCommentFragment.this).setVisibility(0);
                ECQShopReviewCommentFragment.Nh(ECQShopReviewCommentFragment.this).setVisibility(8);
                ECQShopReviewCommentFragment.this.Th(eCQShopOrderReviewCommentInfo);
            }
        }
    }
}
