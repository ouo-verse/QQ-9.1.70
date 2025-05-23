package com.tencent.sqshow.zootopia.taskcenter.getreward;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskRewardInfo;
import com.tencent.sqshow.zootopia.utils.ae;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 ,2\u00020\u0001:\u0002-.B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b*\u0010+J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0007H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R*\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006/"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/getreward/a;", "Landroid/widget/BaseAdapter;", "", "Lcom/tencent/sqshow/zootopia/data/w;", "list", "", "setData", "", "getCount", "position", "", "getItem", "", "getItemId", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "e", "Landroid/graphics/drawable/Drawable;", "errorDrawable", "Landroid/view/LayoutInflater;", "f", "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater", h.F, "Ljava/util/List;", "getMData", "()Ljava/util/List;", "setMData", "(Ljava/util/List;)V", "mData", "<init>", "(Landroid/content/Context;)V", "i", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a extends BaseAdapter {

    /* renamed from: m, reason: collision with root package name */
    private static final int f373026m = R.drawable.iic;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Drawable errorDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final LayoutInflater layoutInflater;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private List<ZootopiaTaskRewardInfo> mData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0011\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/getreward/a$b;", "", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "b", "()Landroid/widget/TextView;", "setRewardDesc", "(Landroid/widget/TextView;)V", "rewardDesc", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "c", "()Landroid/widget/ImageView;", "setRewardIcon", "(Landroid/widget/ImageView;)V", "rewardIcon", "setRewardCount", "rewardCount", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private TextView rewardDesc;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private ImageView rewardIcon;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private TextView rewardCount;

        public b(View itemView) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.rewardDesc = (TextView) itemView.findViewById(R.id.qhi);
            this.rewardIcon = (ImageView) itemView.findViewById(R.id.qhk);
            this.rewardCount = (TextView) itemView.findViewById(R.id.qhh);
        }

        /* renamed from: a, reason: from getter */
        public final TextView getRewardCount() {
            return this.rewardCount;
        }

        /* renamed from: b, reason: from getter */
        public final TextView getRewardDesc() {
            return this.rewardDesc;
        }

        /* renamed from: c, reason: from getter */
        public final ImageView getRewardIcon() {
            return this.rewardIcon;
        }
    }

    public a(Context context) {
        List<ZootopiaTaskRewardInfo> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Resources resources = context.getResources();
        Drawable drawable = resources != null ? resources.getDrawable(f373026m) : null;
        Intrinsics.checkNotNull(drawable);
        this.errorDrawable = drawable;
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        this.layoutInflater = from;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mData = emptyList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        if (!this.mData.isEmpty()) {
            return this.mData.get(position);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    public final void setData(List<ZootopiaTaskRewardInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.mData = list;
        QLog.d("ReceiveRewardAdapter", 1, "setData, list:" + list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        b bVar;
        if (convertView == null) {
            convertView = this.layoutInflater.inflate(R.layout.dgn, (ViewGroup) null);
            bVar = new b(convertView);
            convertView.setTag(bVar);
        } else {
            Object tag = convertView.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.taskcenter.getreward.ReceiveRewardAdapter.ViewHolder");
            bVar = (b) tag;
        }
        ZootopiaTaskRewardInfo zootopiaTaskRewardInfo = this.mData.get(position);
        QLog.d("ReceiveRewardAdapter", 1, "getView, position:" + position + ", itemData:" + zootopiaTaskRewardInfo);
        TextView rewardDesc = bVar.getRewardDesc();
        Intrinsics.checkNotNull(rewardDesc);
        rewardDesc.setText(zootopiaTaskRewardInfo != null ? zootopiaTaskRewardInfo.getItemTitle() : null);
        ae.INSTANCE.a(bVar.getRewardIcon(), zootopiaTaskRewardInfo != null ? zootopiaTaskRewardInfo.getItemIcon() : null, this.errorDrawable, f373026m);
        TextView rewardCount = bVar.getRewardCount();
        if (rewardCount != null) {
            Resources resources = this.context.getResources();
            Object[] objArr = new Object[1];
            objArr[0] = String.valueOf(zootopiaTaskRewardInfo != null ? Integer.valueOf(zootopiaTaskRewardInfo.getRewardItemCnt()) : null);
            rewardCount.setText(resources.getString(R.string.xvy, objArr));
        }
        return convertView;
    }
}
