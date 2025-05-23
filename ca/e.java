package ca;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import ca.e;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWUploadRecommendInfo;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mk.g;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB,\u0012#\u0010\u0017\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00060\u0011\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nH\u0016R1\u0010\u0017\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00060\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lca/e;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;", "videoList", "", "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "getItemCount", "holder", "position", "onBindViewHolder", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "onItemClicked", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "mVideoList", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class e extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    private List<RFWUploadRecommendInfo> mVideoList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Function1<RFWUploadRecommendInfo, Unit> onItemClicked;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u001c\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\n \u000b*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\n \u000b*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\n \u000b*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u001c\u0010\u001c\u001a\n \u000b*\u0004\u0018\u00010\u00190\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lca/e$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "resId", "Landroid/graphics/drawable/Drawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;", "data", "", DomainData.DOMAIN_NAME, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "kotlin.jvm.PlatformType", "E", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "mContainer", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "mCoverIv", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "mTitleTv", "H", "mDateTv", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "I", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mMakeBtn", "J", "Landroid/graphics/drawable/Drawable;", "mLoadingDrawable", "K", "mFailedDrawable", "", "L", "Ljava/lang/String;", "mPicUrl", "Landroid/view/View;", "itemView", "<init>", "(Lca/e;Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    private final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final RoundCorneredFrameLayout mContainer;

        /* renamed from: F, reason: from kotlin metadata */
        private final ImageView mCoverIv;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView mTitleTv;

        /* renamed from: H, reason: from kotlin metadata */
        private final TextView mDateTv;

        /* renamed from: I, reason: from kotlin metadata */
        private final QUIButton mMakeBtn;

        /* renamed from: J, reason: from kotlin metadata */
        private final Drawable mLoadingDrawable;

        /* renamed from: K, reason: from kotlin metadata */
        private final Drawable mFailedDrawable;

        /* renamed from: L, reason: from kotlin metadata */
        private String mPicUrl;
        final /* synthetic */ e M;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.M = eVar;
            this.mContainer = (RoundCorneredFrameLayout) itemView.findViewById(R.id.moo);
            this.mCoverIv = (ImageView) itemView.findViewById(R.id.f162798mp1);
            this.mTitleTv = (TextView) itemView.findViewById(R.id.mov);
            this.mDateTv = (TextView) itemView.findViewById(R.id.mom);
            this.mMakeBtn = (QUIButton) itemView.findViewById(R.id.mop);
            this.mLoadingDrawable = m(R.drawable.at8);
            this.mFailedDrawable = m(R.drawable.at_);
        }

        private final Drawable m(int resId) {
            return ResourcesCompat.getDrawable(this.itemView.getResources(), resId, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(e this$0, RFWUploadRecommendInfo rFWUploadRecommendInfo, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onItemClicked.invoke(rFWUploadRecommendInfo);
        }

        public final void n(final RFWUploadRecommendInfo data) {
            Object last;
            g gVar = g.f416876a;
            RoundCorneredFrameLayout mContainer = this.mContainer;
            Intrinsics.checkNotNullExpressionValue(mContainer, "mContainer");
            gVar.a(mContainer, Color.parseColor("#AFAFAF"), DisplayUtil.dip2px(this.mContainer.getContext(), 4.0f), false);
            this.mContainer.setRadius(DisplayUtil.dip2px(this.itemView.getContext(), 8.0f));
            ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
            if (layoutParams != null) {
                int o16 = pl.a.f426446a.o(this.mContainer.getContext()) - DisplayUtil.dip2px(this.itemView.getContext(), 46.0f);
                layoutParams.width = o16;
                layoutParams.height = (int) (o16 * 1.5f);
            }
            QUIButton qUIButton = this.mMakeBtn;
            final e eVar = this.M;
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: ca.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.a.o(e.this, data, view);
                }
            });
            if (data != null) {
                this.mTitleTv.setText(data.getDisplayName());
                TextView textView = this.mDateTv;
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) data.getMediaList());
                textView.setText(((RFWMediaInfo) last).getMFullDate());
                String str = this.mPicUrl;
                RFWMediaInfo firstMediaInfo = data.getFirstMediaInfo();
                if (TextUtils.equals(str, firstMediaInfo != null ? firstMediaInfo.getMPath() : null)) {
                    return;
                }
                RFWMediaInfo firstMediaInfo2 = data.getFirstMediaInfo();
                this.mPicUrl = firstMediaInfo2 != null ? firstMediaInfo2.getMPath() : null;
                RFWMediaInfo firstMediaInfo3 = data.getFirstMediaInfo();
                Option e16 = com.tencent.mobileqq.qzone.picload.c.e(firstMediaInfo3 != null ? firstMediaInfo3.getMPath() : null);
                e16.setTargetView(this.mCoverIv);
                e16.setRequestWidth(this.mContainer.getLayoutParams().width);
                e16.setRequestHeight(this.mContainer.getLayoutParams().height);
                e16.setLoadingDrawable(this.mLoadingDrawable);
                e16.setFailedDrawable(this.mFailedDrawable);
                com.tencent.mobileqq.qzone.picload.c.a().h(e16);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Function1<? super RFWUploadRecommendInfo, Unit> onItemClicked) {
        List<RFWUploadRecommendInfo> emptyList;
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.onItemClicked = onItemClicked;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mVideoList = emptyList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mVideoList.size();
    }

    public final void j0(List<RFWUploadRecommendInfo> videoList) {
        Intrinsics.checkNotNullParameter(videoList, "videoList");
        this.mVideoList = videoList;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Object orNull;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof a) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.mVideoList, position);
            ((a) holder).n((RFWUploadRecommendInfo) orNull);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.f1290652, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new a(this, view);
    }
}
