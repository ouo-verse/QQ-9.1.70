package com.tencent.sqshow.zootopia.taskcenter.header.blindbox;

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
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0002*+B\u000f\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0007H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0014\u0010\u0015\u001a\u00020\u00078\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR*\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006,"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/header/blindbox/a;", "Landroid/widget/BaseAdapter;", "", "Lcom/tencent/sqshow/zootopia/data/w;", "list", "", "setData", "", "getCount", "position", "", "getItem", "", "getItemId", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "d", "I", "STATUS_HOLD", "Landroid/view/LayoutInflater;", "e", "Landroid/view/LayoutInflater;", "layoutInflater", "Landroid/graphics/drawable/Drawable;", "f", "Landroid/graphics/drawable/Drawable;", "errorDrawable", h.F, "Ljava/util/List;", "getMData", "()Ljava/util/List;", "setMData", "(Ljava/util/List;)V", "mData", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "i", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a extends BaseAdapter {

    /* renamed from: m, reason: collision with root package name */
    private static final int f373059m = R.drawable.iic;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int STATUS_HOLD;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final LayoutInflater layoutInflater;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Drawable errorDrawable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private List<ZootopiaTaskRewardInfo> mData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0010\u0010\u0005\"\u0004\b\u0011\u0010\u0007\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/header/blindbox/a$b;", "", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "setRewardDesc", "(Landroid/widget/TextView;)V", "rewardDesc", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setRewardIcon", "(Landroid/widget/ImageView;)V", "rewardIcon", "c", "setTagView", "tagView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private TextView rewardDesc;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private ImageView rewardIcon;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private TextView tagView;

        public b(View itemView) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.rewardDesc = (TextView) itemView.findViewById(R.id.qhi);
            this.rewardIcon = (ImageView) itemView.findViewById(R.id.qhk);
            this.tagView = (TextView) itemView.findViewById(R.id.qhn);
        }

        /* renamed from: a, reason: from getter */
        public final TextView getRewardDesc() {
            return this.rewardDesc;
        }

        /* renamed from: b, reason: from getter */
        public final ImageView getRewardIcon() {
            return this.rewardIcon;
        }

        /* renamed from: c, reason: from getter */
        public final TextView getTagView() {
            return this.tagView;
        }
    }

    public a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.STATUS_HOLD = 1;
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        this.layoutInflater = from;
        Resources resources = context.getResources();
        Drawable drawable = resources != null ? resources.getDrawable(f373059m) : null;
        Intrinsics.checkNotNull(drawable);
        this.errorDrawable = drawable;
        this.mData = new ArrayList();
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
        QLog.d("BlindBoxPreViewAdapter", 1, "setData mData:" + list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        b bVar;
        String str;
        if (convertView == null) {
            convertView = this.layoutInflater.inflate(R.layout.dgj, (ViewGroup) null);
            bVar = new b(convertView);
            convertView.setTag(bVar);
        } else {
            Object tag = convertView.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.taskcenter.header.blindbox.BlindBoxPreViewAdapter.ViewHolder");
            bVar = (b) tag;
        }
        ZootopiaTaskRewardInfo zootopiaTaskRewardInfo = this.mData.get(position);
        QLog.d("BlindBoxPreViewAdapter", 1, "getView, position" + position + ", itemData:" + zootopiaTaskRewardInfo);
        TextView rewardDesc = bVar.getRewardDesc();
        Intrinsics.checkNotNull(rewardDesc);
        String itemTitle = zootopiaTaskRewardInfo != null ? zootopiaTaskRewardInfo.getItemTitle() : null;
        if (!(itemTitle == null || itemTitle.length() == 0)) {
            str = zootopiaTaskRewardInfo != null ? zootopiaTaskRewardInfo.getItemTitle() : null;
        } else {
            str = "\u76f2\u76d2\u5956\u52b1" + (position + 1);
        }
        rewardDesc.setText(str);
        ae.INSTANCE.a(bVar.getRewardIcon(), zootopiaTaskRewardInfo != null ? zootopiaTaskRewardInfo.getItemIcon() : null, this.errorDrawable, f373059m);
        if (zootopiaTaskRewardInfo != null && zootopiaTaskRewardInfo.getBagStatus() == this.STATUS_HOLD) {
            TextView tagView = bVar.getTagView();
            Intrinsics.checkNotNull(tagView);
            tagView.setVisibility(0);
        } else {
            TextView tagView2 = bVar.getTagView();
            Intrinsics.checkNotNull(tagView2);
            tagView2.setVisibility(8);
        }
        return convertView;
    }
}
