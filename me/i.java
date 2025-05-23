package me;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedpro.utils.aq;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicUrl;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u001e\u0010\u0012\u001a\u00020\n2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0010R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lme/i;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lme/i$b;", "Landroid/view/ViewGroup;", "p0", "", "p1", "j0", "holder", "position", "", "i0", "getItemCount", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "mediaList", "Lme/i$a;", "listener", "k0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "mMediaList", BdhLogUtil.LogTag.Tag_Conn, "Lme/i$a;", "mItemClickListener", "<init>", "()V", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class i extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    private a mItemClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<CommonMedia> mMediaList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lme/i$a;", "", "", "onItemClick", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public interface a {
        void onItemClick();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ(\u0010\n\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a8\u0006\u000f"}, d2 = {"Lme/i$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "pictureItemList", "", "position", "Lme/i$a;", "onItemClickListener", "", "l", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"me/i$b$a", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes38.dex */
        public static final class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f416588d;

            a(a aVar) {
                this.f416588d = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                EventCollector.getInstance().onViewClickedBefore(v3);
                a aVar = this.f416588d;
                if (aVar != null) {
                    aVar.onItemClick();
                }
                EventCollector.getInstance().onViewClicked(v3);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        public final void l(List<CommonMedia> pictureItemList, int position, a onItemClickListener) {
            String str;
            CommonPicUrl defaultUrl;
            View view = this.itemView;
            ImageView imageView = view instanceof ImageView ? (ImageView) view : null;
            if (imageView == null || pictureItemList == null || position >= pictureItemList.size()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
            aq.f54314a.e(pl.a.f426446a.k(this.itemView.getContext()), pictureItemList.size(), layoutParams);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            CommonImage image = pictureItemList.get(position).getImage();
            if (image == null || (defaultUrl = image.getDefaultUrl()) == null || (str = defaultUrl.getUrl()) == null) {
                str = "";
            }
            String vaildImageUrl = GdtUIUtils.getVaildImageUrl(str);
            com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
            Option obtain = Option.obtain();
            View view2 = this.itemView;
            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.widget.ImageView");
            a16.h(obtain.setTargetView((ImageView) view2).setRequestWidth(layoutParams.width).setRequestHeight(layoutParams.height).setNeedShowLoadingDrawable(true).setNeedShowFailedDrawable(true).setUrl(vaildImageUrl));
            imageView.setOnClickListener(new a(onItemClickListener));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<CommonMedia> list = this.mMediaList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        List<CommonMedia> list;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder == null || (list = this.mMediaList) == null) {
            return;
        }
        holder.l(list, position, this.mItemClickListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup p06, int p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        return new b(new ImageView(p06.getContext()));
    }

    public final void k0(List<CommonMedia> mediaList, a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mMediaList = mediaList;
        this.mItemClickListener = listener;
    }
}
