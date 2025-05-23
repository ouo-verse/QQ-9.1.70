package com.qzone.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.qzone.feed.business.model.QQEmoCommentDataManager;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class l extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    Context f60891d;

    /* renamed from: e, reason: collision with root package name */
    LayoutInflater f60892e;

    /* renamed from: f, reason: collision with root package name */
    ImageLoader f60893f;

    /* renamed from: h, reason: collision with root package name */
    boolean f60894h;

    /* renamed from: i, reason: collision with root package name */
    List<m> f60895i;

    /* renamed from: m, reason: collision with root package name */
    View.OnClickListener f60896m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public AsyncImageView f60897a;

        /* renamed from: b, reason: collision with root package name */
        public int f60898b;

        /* renamed from: c, reason: collision with root package name */
        public String f60899c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f60900d = false;

        /* renamed from: e, reason: collision with root package name */
        public String f60901e;
    }

    public l(Context context, boolean z16) {
        this.f60891d = context;
        this.f60894h = z16;
        this.f60892e = LayoutInflater.from(context);
        this.f60893f = ImageLoader.getInstance(context);
    }

    public void a(List<m> list) {
        this.f60895i = list;
    }

    public void b(View.OnClickListener onClickListener) {
        this.f60896m = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<m> list = this.f60895i;
        if (list != null) {
            return list.size() + QQEmoCommentDataManager.G;
        }
        return QQEmoCommentDataManager.G;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        List<m> list;
        int i16 = QQEmoCommentDataManager.G;
        if (i3 < i16 || (list = this.f60895i) == null) {
            return null;
        }
        return list.get(i3 - i16);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        AsyncImageView asyncImageView;
        View view2;
        if (view == null) {
            view2 = this.f60892e.inflate(R.layout.bqo, (ViewGroup) null);
            asyncImageView = (AsyncImageView) view2.findViewById(R.id.j_e);
            aVar = new a();
            aVar.f60897a = asyncImageView;
            view2.setTag(aVar);
            view2.setOnClickListener(this.f60896m);
            View findViewById = view2.findViewById(R.id.bms);
            if (!this.f60894h) {
                findViewById.setBackgroundColor(this.f60891d.getResources().getColor(R.color.qzone_skin_comment_divide_color));
            } else {
                findViewById.setBackgroundColor(this.f60891d.getResources().getColor(R.color.qui_common_border_light));
            }
        } else {
            aVar = (a) view.getTag();
            asyncImageView = aVar.f60897a;
            view2 = view;
        }
        aVar.f60898b = i3;
        m mVar = (m) getItem(i3);
        QQEmoCommentDataManager C = QQEmoCommentDataManager.C();
        if (mVar != null) {
            String str = mVar.f60902a;
            aVar.f60901e = str;
            if (mVar.f60904c) {
                asyncImageView.setImageResource(R.drawable.fo5);
                aVar.f60900d = true;
            } else if (C.U(str)) {
                aVar.f60899c = mVar.f60903b;
                asyncImageView.setAsyncImage(C.y(str));
            } else {
                if (QZLog.isColorLevel()) {
                    QZLog.d("QQEmoCommentTabAdapter", 2, "tab icon not downloaded, url=" + mVar.f60903b);
                }
                asyncImageView.setAsyncImage(mVar.f60903b);
            }
        } else if (i3 == 0) {
            asyncImageView.setImageResource(R.drawable.c0p);
        } else {
            asyncImageView.setImageResource(R.drawable.bep);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }
}
