package com.qzone.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.qzone.feed.business.model.RapidCommentDataManager;
import com.qzone.widget.AsyncImageable;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class t extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    Context f61072d;

    /* renamed from: e, reason: collision with root package name */
    boolean f61073e;

    /* renamed from: f, reason: collision with root package name */
    LayoutInflater f61074f;

    /* renamed from: h, reason: collision with root package name */
    ImageLoader f61075h;

    /* renamed from: i, reason: collision with root package name */
    ArrayList<u> f61076i;

    /* renamed from: m, reason: collision with root package name */
    View.OnClickListener f61077m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public AsyncImageView f61080a;

        /* renamed from: b, reason: collision with root package name */
        public int f61081b;

        /* renamed from: c, reason: collision with root package name */
        public String f61082c;
    }

    public t(Context context, boolean z16) {
        this.f61072d = context;
        this.f61073e = z16;
        this.f61074f = LayoutInflater.from(context);
        this.f61075h = ImageLoader.getInstance(context);
    }

    public void a(ArrayList<u> arrayList) {
        this.f61076i = arrayList;
    }

    public void b(View.OnClickListener onClickListener) {
        this.f61077m = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<u> arrayList = this.f61076i;
        if (arrayList != null) {
            return arrayList.size() + RapidCommentDataManager.E;
        }
        return RapidCommentDataManager.E;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        ArrayList<u> arrayList;
        int i16 = RapidCommentDataManager.E;
        if (i3 < i16 || (arrayList = this.f61076i) == null) {
            return null;
        }
        return arrayList.get(i3 - i16);
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
        if (view == null) {
            view2 = this.f61074f.inflate(R.layout.bqo, (ViewGroup) null);
            asyncImageView = (AsyncImageView) view2.findViewById(R.id.j_e);
            bVar = new b();
            bVar.f61080a = asyncImageView;
            view2.setTag(bVar);
            view2.setOnClickListener(this.f61077m);
            View findViewById = view2.findViewById(R.id.bms);
            if (!this.f61073e) {
                findViewById.setBackgroundColor(this.f61072d.getResources().getColor(R.color.qzone_skin_comment_divide_color));
            } else {
                findViewById.setBackgroundColor(this.f61072d.getResources().getColor(R.color.qui_common_border_light));
            }
        } else {
            bVar = (b) view.getTag();
            asyncImageView = bVar.f61080a;
            view2 = view;
        }
        bVar.f61081b = i3;
        u uVar = (u) getItem(i3);
        RapidCommentDataManager n3 = RapidCommentDataManager.n();
        if (uVar != null) {
            long j3 = uVar.rcTabId;
            if (n3.C(j3)) {
                bVar.f61082c = uVar.rcTabIconUrl;
                a aVar = new a(i3, bVar);
                String m3 = n3.m(j3);
                asyncImageView.setAsyncImageListener(aVar);
                asyncImageView.setAsyncImage(m3);
            } else {
                if (QZLog.isColorLevel()) {
                    QZLog.d("RapidCommentTabAdapter", 2, "tab icon not downloaded, url=" + uVar.rcTabIconUrl);
                }
                asyncImageView.setAsyncImage(uVar.rcTabIconUrl);
            }
        } else if (i3 == 0) {
            asyncImageView.setImageResource(R.drawable.c0p);
        } else {
            asyncImageView.setImageResource(R.drawable.bep);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private static class a implements AsyncImageable.AsyncImageListener {

        /* renamed from: d, reason: collision with root package name */
        private int f61078d;

        /* renamed from: e, reason: collision with root package name */
        private b f61079e;

        public a(int i3, b bVar) {
            this.f61078d = i3;
            this.f61079e = bVar;
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageFailed(AsyncImageable asyncImageable) {
            b bVar = this.f61079e;
            if (bVar.f61081b != this.f61078d || bVar.f61080a == null) {
                return;
            }
            if (QZLog.isColorLevel()) {
                QZLog.d("RapidCommentTabAdapter", 2, "tab icon local load failed, url=" + this.f61079e.f61082c);
            }
            this.f61079e.f61080a.setAsyncImageListener(null);
            b bVar2 = this.f61079e;
            bVar2.f61080a.setAsyncImage(bVar2.f61082c);
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
