package com.tencent.ecommerce.biz.consulthistory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.ktx.ImageViewKt;
import com.tencent.ecommerce.base.photobrowser.api.IECPhotoBrowser;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.util.DateFormat;
import com.tencent.ecommerce.biz.util.d;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import uj0.ECConsultHistory;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\u0012\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016R'\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/consulthistory/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/consulthistory/a$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "", "i0", "getItemCount", "Ljava/util/ArrayList;", "Luj0/a;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "dataList", "<init>", "(Ljava/util/ArrayList;)V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a extends RecyclerView.Adapter<C1048a> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<ECConsultHistory> dataList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010)\u001a\u00020\u0014\u00a2\u0006\u0004\b*\u0010+R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/ecommerce/biz/consulthistory/a$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "avator", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/TextView;", "titleTextView", "G", "getTimeTextView", "timeTextView", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "contentTextView", "Landroid/view/View;", "I", "Landroid/view/View;", "p", "()Landroid/view/View;", "imageLayoutView", "J", "getImage1", "image1", "K", "getImage2", "image2", "L", "getImage3", "image3", "", "M", "[Landroid/widget/ImageView;", "o", "()[Landroid/widget/ImageView;", "imageArray", "itemView", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.consulthistory.a$a, reason: collision with other inner class name */
    /* loaded from: classes31.dex */
    public static final class C1048a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final ImageView avator;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView titleTextView;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView timeTextView;

        /* renamed from: H, reason: from kotlin metadata */
        private final TextView contentTextView;

        /* renamed from: I, reason: from kotlin metadata */
        private final View imageLayoutView;

        /* renamed from: J, reason: from kotlin metadata */
        private final ImageView image1;

        /* renamed from: K, reason: from kotlin metadata */
        private final ImageView image2;

        /* renamed from: L, reason: from kotlin metadata */
        private final ImageView image3;

        /* renamed from: M, reason: from kotlin metadata */
        private final ImageView[] imageArray;

        public C1048a(View view) {
            super(view);
            this.avator = (ImageView) view.findViewById(R.id.nu7);
            this.titleTextView = (TextView) view.findViewById(R.id.nud);
            this.timeTextView = (TextView) view.findViewById(R.id.nuc);
            this.contentTextView = (TextView) view.findViewById(R.id.nub);
            this.imageLayoutView = view.findViewById(R.id.nua);
            ImageView imageView = (ImageView) view.findViewById(R.id.nu8);
            this.image1 = imageView;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.nu9);
            this.image2 = imageView2;
            ImageView imageView3 = (ImageView) view.findViewById(R.id.nu_);
            this.image3 = imageView3;
            this.imageArray = new ImageView[]{imageView, imageView2, imageView3};
        }

        public final TextView getTimeTextView() {
            return this.timeTextView;
        }

        /* renamed from: l, reason: from getter */
        public final ImageView getAvator() {
            return this.avator;
        }

        /* renamed from: m, reason: from getter */
        public final TextView getContentTextView() {
            return this.contentTextView;
        }

        /* renamed from: o, reason: from getter */
        public final ImageView[] getImageArray() {
            return this.imageArray;
        }

        /* renamed from: p, reason: from getter */
        public final View getImageLayoutView() {
            return this.imageLayoutView;
        }

        /* renamed from: q, reason: from getter */
        public final TextView getTitleTextView() {
            return this.titleTextView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ECConsultHistory f101573d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f101574e;

        b(ECConsultHistory eCConsultHistory, int i3) {
            this.f101573d = eCConsultHistory;
            this.f101574e = i3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IECPhotoBrowser photoBrowser = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPhotoBrowser();
            if (photoBrowser != null) {
                IECPhotoBrowser.a.a(photoBrowser, this.f101573d.a(), this.f101574e, null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public a(ArrayList<ECConsultHistory> arrayList) {
        this.dataList = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public C1048a onCreateViewHolder(ViewGroup parent, int viewType) {
        return new C1048a(LayoutInflater.from(parent.getContext()).inflate(R.layout.cpr, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C1048a holder, int position) {
        ECConsultHistory eCConsultHistory = this.dataList.get(position);
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(holder.itemView.getContext(), eCConsultHistory.picUrl, holder.getAvator(), new IECImageLoader.ImageLoaderOption((int) e.d(holder.getAvator().getLayoutParams().width), (int) e.d(holder.getAvator().getLayoutParams().height), 0, null, null, ECSkin.INSTANCE.getDrawable("qecommerce_skin_avatar_nodata"), false, false, null, com.tencent.luggage.wxa.j2.c.CTRL_INDEX, null));
        holder.getTitleTextView().setText(eCConsultHistory.title);
        holder.getContentTextView().setText(eCConsultHistory.content);
        if (eCConsultHistory.time > 0) {
            ViewGroup.LayoutParams layoutParams = holder.getTitleTextView().getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = 0;
            }
            holder.getTimeTextView().setVisibility(0);
            holder.getTimeTextView().setText(d.f104866a.a(eCConsultHistory.time * 1000, DateFormat.YMD_HM));
        } else {
            ViewGroup.LayoutParams layoutParams2 = holder.getTitleTextView().getLayoutParams();
            if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams2 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.topMargin = e.e(12.0f);
            }
            holder.getTimeTextView().setVisibility(8);
            holder.getTimeTextView().setText((CharSequence) null);
        }
        if (eCConsultHistory.a().size() > 0) {
            holder.getImageLayoutView().setVisibility(0);
            int length = holder.getImageArray().length;
            int i3 = 0;
            while (i3 < length) {
                ImageView imageView = holder.getImageArray()[i3];
                String str = eCConsultHistory.a().size() > i3 ? eCConsultHistory.a().get(i3) : null;
                if (str != null) {
                    if (str.length() > 0) {
                        imageView.setVisibility(0);
                        ImageViewKt.b(imageView, str, (int) e.d(imageView.getLayoutParams().width), (int) e.d(imageView.getLayoutParams().height), 0, 8, null);
                        imageView.setOnClickListener(new b(eCConsultHistory, i3));
                        i3++;
                    }
                }
                imageView.setOnClickListener(null);
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
                i3++;
            }
            return;
        }
        holder.getImageLayoutView().setVisibility(8);
        for (ImageView imageView2 : holder.getImageArray()) {
            imageView2.setVisibility(8);
            imageView2.setImageDrawable(null);
        }
    }
}
