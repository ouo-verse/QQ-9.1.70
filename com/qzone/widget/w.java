package com.qzone.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.qzone.feed.business.model.RapidCommentDataManager;
import com.qzone.widget.AsyncImageable;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class w extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private Context f61160d;

    /* renamed from: e, reason: collision with root package name */
    ImageLoader f61161e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<Long> f61162f;

    /* renamed from: h, reason: collision with root package name */
    u f61163h;

    /* renamed from: i, reason: collision with root package name */
    boolean f61164i;

    /* renamed from: m, reason: collision with root package name */
    View.OnClickListener f61165m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        AsyncImageView f61168a;

        /* renamed from: b, reason: collision with root package name */
        int f61169b;

        /* renamed from: c, reason: collision with root package name */
        String f61170c;

        b() {
        }
    }

    public w(Context context) {
        this.f61160d = context;
        this.f61161e = ImageLoader.getInstance(context);
    }

    public void a(int i3, ArrayList<Long> arrayList) {
        this.f61162f = arrayList;
        u u16 = RapidCommentDataManager.n().u(RapidCommentDataManager.n().t(i3));
        this.f61163h = u16;
        if (u16 != null) {
            this.f61164i = RapidCommentDataManager.n().C(this.f61163h.rcTabId);
        } else {
            this.f61164i = false;
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.f61165m = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<Long> arrayList = this.f61162f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        ArrayList<Long> arrayList = this.f61162f;
        if (arrayList == null || i3 >= arrayList.size()) {
            return null;
        }
        return this.f61162f.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        b bVar;
        AsyncImageView asyncImageView;
        View view2;
        RapidCommentExpressionInfo rapidCommentExpressionInfo;
        if (view == null) {
            LinearLayout linearLayout = new LinearLayout(this.f61160d);
            linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            asyncImageView = new AsyncSquareImageView(this.f61160d);
            asyncImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            asyncImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            linearLayout.addView(asyncImageView);
            bVar = new b();
            bVar.f61168a = asyncImageView;
            linearLayout.setTag(bVar);
            view2 = linearLayout;
        } else {
            bVar = (b) view.getTag();
            asyncImageView = bVar.f61168a;
            view2 = view;
        }
        bVar.f61169b = i3;
        Long l3 = (Long) getItem(i3);
        if (l3 == null || this.f61163h == null) {
            rapidCommentExpressionInfo = null;
        } else {
            rapidCommentExpressionInfo = RapidCommentDataManager.n().r(this.f61163h, l3.longValue());
            if (rapidCommentExpressionInfo != null) {
                if (this.f61164i) {
                    bVar.f61170c = rapidCommentExpressionInfo.f60641f;
                    asyncImageView.setAsyncImageListener(new a(i3, bVar));
                    asyncImageView.setAsyncImage(rapidCommentExpressionInfo.f60643i);
                } else {
                    if (QZLog.isColorLevel()) {
                        QZLog.d("RapidCommentViewAdapter", 2, "image not downloaded, url=" + rapidCommentExpressionInfo.f60641f);
                    }
                    asyncImageView.setAsyncImage(rapidCommentExpressionInfo.f60641f);
                }
            }
        }
        asyncImageView.setTag(rapidCommentExpressionInfo);
        asyncImageView.setOnClickListener(this.f61165m);
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private static class a implements AsyncImageable.AsyncImageListener {

        /* renamed from: d, reason: collision with root package name */
        private int f61166d;

        /* renamed from: e, reason: collision with root package name */
        private b f61167e;

        public a(int i3, b bVar) {
            this.f61166d = i3;
            this.f61167e = bVar;
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageFailed(AsyncImageable asyncImageable) {
            b bVar = this.f61167e;
            if (bVar.f61169b != this.f61166d || bVar.f61168a == null) {
                return;
            }
            if (QZLog.isColorLevel()) {
                QZLog.d("RapidCommentViewAdapter", 2, "image local load failed, url=" + this.f61167e.f61170c);
            }
            this.f61167e.f61168a.setAsyncImageListener(null);
            b bVar2 = this.f61167e;
            bVar2.f61168a.setAsyncImage(bVar2.f61170c);
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageLoaded(AsyncImageable asyncImageable) {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageStarted(AsyncImageable asyncImageable) {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageProgress(AsyncImageable asyncImageable, float f16) {
        }
    }
}
