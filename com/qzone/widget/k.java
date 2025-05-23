package com.qzone.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.feed.business.model.QQEmoCommentDataManager;
import com.qzone.util.ar;
import com.qzone.widget.AsyncImageable;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class k extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private Context f60879d;

    /* renamed from: e, reason: collision with root package name */
    private ImageLoader f60880e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<Long> f60881f;

    /* renamed from: h, reason: collision with root package name */
    private m f60882h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f60883i;

    /* renamed from: m, reason: collision with root package name */
    private View.OnClickListener f60884m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        AsyncImageView f60887a;

        /* renamed from: b, reason: collision with root package name */
        int f60888b;

        /* renamed from: c, reason: collision with root package name */
        String f60889c;

        /* renamed from: d, reason: collision with root package name */
        TextView f60890d;

        b() {
        }
    }

    public k(Context context) {
        this.f60879d = context;
        this.f60880e = ImageLoader.getInstance(context);
    }

    private boolean a() {
        m mVar = this.f60882h;
        return mVar != null && mVar.f60904c;
    }

    public void b(int i3, ArrayList<Long> arrayList) {
        this.f60881f = arrayList;
        m K = QQEmoCommentDataManager.C().K(QQEmoCommentDataManager.C().J(i3));
        this.f60882h = K;
        if (K != null) {
            this.f60883i = QQEmoCommentDataManager.C().U(this.f60882h.f60902a);
        } else {
            this.f60883i = false;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.f60884m = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<Long> arrayList = this.f60881f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        ArrayList<Long> arrayList = this.f60881f;
        if (arrayList == null || i3 >= arrayList.size()) {
            return null;
        }
        return this.f60881f.get(i3);
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
            LinearLayout linearLayout = new LinearLayout(this.f60879d);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            asyncImageView = new AsyncSquareImageView(this.f60879d);
            asyncImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            int e16 = ar.e(55.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(e16, e16);
            layoutParams.gravity = 17;
            layoutParams.topMargin = ar.e(10.0f);
            if (a()) {
                layoutParams.bottomMargin = ar.e(8.0f);
            }
            asyncImageView.setLayoutParams(layoutParams);
            linearLayout.addView(asyncImageView);
            bVar = new b();
            if (!a()) {
                TextView textView = new TextView(this.f60879d);
                textView.setTextSize(1, 12.0f);
                textView.setTextColor(-4802890);
                textView.setPadding(0, ar.e(8.0f), 0, ar.e(8.0f));
                textView.setGravity(17);
                textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                linearLayout.addView(textView);
                bVar.f60890d = textView;
            }
            bVar.f60887a = asyncImageView;
            linearLayout.setTag(bVar);
            view2 = linearLayout;
        } else {
            bVar = (b) view.getTag();
            asyncImageView = bVar.f60887a;
            view2 = view;
        }
        bVar.f60888b = i3;
        Long l3 = (Long) getItem(i3);
        if (l3 == null || this.f60882h == null) {
            rapidCommentExpressionInfo = null;
        } else {
            rapidCommentExpressionInfo = QQEmoCommentDataManager.C().H(this.f60882h, l3.longValue());
            if (rapidCommentExpressionInfo != null) {
                if (this.f60882h.f60904c) {
                    if (!TextUtils.isEmpty(rapidCommentExpressionInfo.f60644m)) {
                        asyncImageView.setAsyncImage(rapidCommentExpressionInfo.f60643i);
                    }
                } else if (this.f60883i) {
                    bVar.f60889c = rapidCommentExpressionInfo.f60641f;
                    if (bVar.f60890d != null && !TextUtils.isEmpty(rapidCommentExpressionInfo.E)) {
                        bVar.f60890d.setText(rapidCommentExpressionInfo.E);
                    }
                    asyncImageView.setAsyncImageListener(new a(i3, bVar));
                    asyncImageView.setAsyncImage(rapidCommentExpressionInfo.f60643i);
                } else {
                    if (QZLog.isColorLevel()) {
                        QZLog.d("QQEmoCommentGridViewAdapter", 2, "image not downloaded, url=" + rapidCommentExpressionInfo.f60641f);
                    }
                    asyncImageView.setAsyncImage(rapidCommentExpressionInfo.f60641f);
                }
            }
        }
        asyncImageView.setTag(rapidCommentExpressionInfo);
        asyncImageView.setOnClickListener(this.f60884m);
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private static class a implements AsyncImageable.AsyncImageListener {

        /* renamed from: d, reason: collision with root package name */
        private int f60885d;

        /* renamed from: e, reason: collision with root package name */
        private b f60886e;

        public a(int i3, b bVar) {
            this.f60885d = i3;
            this.f60886e = bVar;
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageFailed(AsyncImageable asyncImageable) {
            b bVar = this.f60886e;
            if (bVar.f60888b != this.f60885d || bVar.f60887a == null) {
                return;
            }
            if (QZLog.isColorLevel()) {
                QZLog.d("QQEmoCommentGridViewAdapter", 2, "image local load failed, url=" + this.f60886e.f60889c);
            }
            this.f60886e.f60887a.setAsyncImageListener(null);
            b bVar2 = this.f60886e;
            bVar2.f60887a.setAsyncImage(bVar2.f60889c);
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
