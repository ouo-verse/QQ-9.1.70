package com.qzone.album.business.photolist.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.qzone.album.business.photolist.ui.listitem.BigPhotoView;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.widget.FeedDate;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.AbsListView;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class h extends com.qzone.album.business.photolist.adapter.a {

    /* renamed from: c0, reason: collision with root package name */
    protected ArrayList<WeakReference<d>> f42687c0 = new ArrayList<>(5);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements AbsListView.RecyclerListener {
        a() {
        }

        @Override // com.tencent.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            com.qzone.proxy.feedcomponent.b.a("kaedelin", "Big onMovedToScrapHeap");
            ((d) view.getTag()).f42695a.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PhotoCacheData f42689d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f42690e;

        b(PhotoCacheData photoCacheData, int i3) {
            this.f42689d = photoCacheData;
            this.f42690e = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (com.qzone.album.env.common.a.m().C()) {
                h.this.f42651d.t(this.f42689d, this.f42690e);
            } else {
                com.qzone.album.env.common.a.m().V(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkUnconnected", "\u7f51\u7edc\u672a\u8fde\u63a5,\u8bf7\u8fde\u63a5\u7f51\u7edc\u540e\u91cd\u8bd5"));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PhotoCacheData f42692d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f42693e;

        c(PhotoCacheData photoCacheData, int i3) {
            this.f42692d = photoCacheData;
            this.f42693e = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (com.qzone.album.env.common.a.m().C()) {
                h.this.f42651d.e(this.f42692d, this.f42693e);
            } else {
                com.qzone.album.env.common.a.m().V(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkUnconnected", "\u7f51\u7edc\u672a\u8fde\u63a5,\u8bf7\u8fde\u63a5\u7f51\u7edc\u540e\u91cd\u8bd5"));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public BigPhotoView f42695a;

        /* renamed from: b, reason: collision with root package name */
        CellTextView f42696b;

        /* renamed from: c, reason: collision with root package name */
        ViewGroup f42697c;

        /* renamed from: d, reason: collision with root package name */
        FeedDate f42698d;
    }

    public h(x4.a aVar, View.OnClickListener onClickListener) {
        this.f42651d = aVar;
        J();
        L(aVar);
    }

    public void L(x4.a aVar) {
        if (aVar.getListView() != null) {
            com.qzone.proxy.feedcomponent.b.a("BigPhotoListAdapter", "setRecyclerListener");
            aVar.getListView().setRecyclerListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(PhotoCacheData photoCacheData, d dVar, int i3) {
        dVar.f42695a.g(photoCacheData, new c(photoCacheData, i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N(PhotoCacheData photoCacheData, d dVar, int i3) {
        dVar.f42695a.h(this.f42651d, photoCacheData, new b(photoCacheData, i3));
    }

    @Override // com.qzone.album.business.photolist.adapter.a
    public void u() {
        com.qzone.proxy.feedcomponent.b.a("BigPhotoListAdapter", "BigPhoto recycleView holderlist size:" + this.f42687c0.size());
        Iterator<WeakReference<d>> it = this.f42687c0.iterator();
        while (it.hasNext()) {
            WeakReference<d> next = it.next();
            if (next.get() != null) {
                next.get().f42695a.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J() {
        this.f42652e = 1;
        this.f42655i = this.f42651d.getResources().getDisplayMetrics().widthPixels;
        this.f42656m = this.f42651d.getResources().getDisplayMetrics().heightPixels;
        this.f42653f = this.f42655i;
        this.f42654h = 640;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(d dVar, View view) {
        BigPhotoView bigPhotoView = (BigPhotoView) view.findViewById(R.id.hak);
        dVar.f42695a = bigPhotoView;
        bigPhotoView.c(this.f42651d.k(), this.f42653f, this.f42654h, this.C);
    }
}
