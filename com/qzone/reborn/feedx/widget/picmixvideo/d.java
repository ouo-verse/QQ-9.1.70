package com.qzone.reborn.feedx.widget.picmixvideo;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.reborn.feedx.widget.picmixvideo.QZonePicMixVideoView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class d extends com.qzone.reborn.base.i<a> {
    private BusinessFeedData C;
    private QZonePicMixVideoView.c D;
    private int E;
    private int F;
    private boolean G = true;

    /* renamed from: m, reason: collision with root package name */
    private List<PictureItem> f56494m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class a extends RecyclerView.ViewHolder {
        boolean E;

        public a(View view, boolean z16) {
            super(view);
            this.E = z16;
        }

        public void l(List<PictureItem> list, int i3, BusinessFeedData businessFeedData, int i16, int i17) {
            if (!(this.itemView instanceof QZoneMixBaseWidgetView) || list == null) {
                return;
            }
            CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
            int i18 = pictureInfo != null ? pictureInfo.uploadnum : 0;
            if (this.E && i3 > 0 && list.size() == i3 + 1 && i18 > list.size()) {
                ((QZoneMixBaseWidgetView) this.itemView).u0((i18 - list.size()) + 1);
            } else {
                ((QZoneMixBaseWidgetView) this.itemView).r0();
            }
            ((QZoneMixBaseWidgetView) this.itemView).setItemViewMultiBorderWidth(i17);
            ((QZoneMixBaseWidgetView) this.itemView).setFeedData(businessFeedData);
            ((QZoneMixBaseWidgetView) this.itemView).setFeedPosition(i16);
            ((QZoneMixBaseWidgetView) this.itemView).setPicPosition(i3);
            ((QZoneMixBaseWidgetView) this.itemView).setData(list.get(i3), i3);
        }
    }

    public d() {
        setHasStableIds(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(PictureItem pictureItem, int i3, RecyclerView.ViewHolder viewHolder, View view) {
        QZonePicMixVideoView.c cVar = this.D;
        if (cVar != null) {
            cVar.a(pictureItem, i3, viewHolder.itemView);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<PictureItem> list = this.f56494m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        List<PictureItem> list = this.f56494m;
        return (list == null || list.size() <= i3 || this.f56494m.get(i3).videoflag != 1 || this.f56494m.get(i3).videodata == null) ? 0 : 1;
    }

    public void k0(BusinessFeedData businessFeedData, List<PictureItem> list) {
        this.C = businessFeedData;
        this.f56494m = list;
    }

    public void l0(boolean z16) {
        this.G = z16;
    }

    public void m0(int i3) {
        this.E = i3;
    }

    public void n0(QZonePicMixVideoView.c cVar) {
        this.D = cVar;
    }

    public void o0(int i3) {
        this.F = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int i3) {
        String str;
        if (viewHolder instanceof a) {
            ((a) viewHolder).l(this.f56494m, i3, this.C, this.E, this.F);
            List<PictureItem> list = this.f56494m;
            if (list == null || list.size() < i3) {
                return;
            }
            final PictureItem pictureItem = this.f56494m.get(i3);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.widget.picmixvideo.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.this.j0(pictureItem, i3, viewHolder, view);
                }
            });
            View view = viewHolder.itemView;
            if ((view instanceof QZoneMixBaseWidgetView) && ((QZoneMixBaseWidgetView) view).s0()) {
                AccessibilityUtil.p(viewHolder.itemView, com.qzone.util.l.a(R.string.f2202668n));
                return;
            }
            View view2 = viewHolder.itemView;
            if (getItemViewType(i3) == 0) {
                str = "\u56fe\u7247\u7b2c" + (i3 + 1) + "\u5f20\u5171" + this.f56494m.size() + "\u5f20";
            } else {
                str = "\u89c6\u9891\u7b2c" + (i3 + 1) + "\u4e2a\u5171" + this.f56494m.size() + "\u4e2a";
            }
            AccessibilityUtil.p(view2, str);
        }
    }

    @Override // com.qzone.reborn.base.i
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int i3) {
        if (i3 == 1) {
            return new a(new QZoneVideoItemWidgetView(viewGroup.getContext()), this.G);
        }
        return new a(new QZonePicWidgetView(viewGroup.getContext()), this.G);
    }
}
