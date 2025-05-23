package com.tencent.biz.qqstory.takevideo.slideshow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.troopgift.GridListAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.BaseURLDrawableHelper;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SlideShowAdapter extends RecyclerView.Adapter<c> implements com.tencent.biz.qqstory.takevideo.slideshow.a {
    private e C;

    /* renamed from: d, reason: collision with root package name */
    private Context f94295d;

    /* renamed from: e, reason: collision with root package name */
    private List<SlideItemInfo> f94296e = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f94297f = null;

    /* renamed from: h, reason: collision with root package name */
    private int f94298h = -1;

    /* renamed from: i, reason: collision with root package name */
    private d f94299i;

    /* renamed from: m, reason: collision with root package name */
    private View.OnClickListener f94300m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f94302d;

        a(c cVar) {
            this.f94302d = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (SlideShowAdapter.this.C != null) {
                SlideShowAdapter.this.C.i((SlideItemInfo) this.f94302d.f94311m.getTag());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f94304d;

        b(int i3) {
            this.f94304d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (SlideShowAdapter.this.f94299i != null) {
                SlideShowAdapter.this.f94299i.a(this.f94304d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class c extends RecyclerView.ViewHolder {
        public boolean C;

        /* renamed from: d, reason: collision with root package name */
        public RelativeLayout f94306d;

        /* renamed from: e, reason: collision with root package name */
        public RoundCornerImageView f94307e;

        /* renamed from: f, reason: collision with root package name */
        public TextView f94308f;

        /* renamed from: h, reason: collision with root package name */
        public TextView f94309h;

        /* renamed from: i, reason: collision with root package name */
        public RelativeLayout f94310i;

        /* renamed from: m, reason: collision with root package name */
        public ImageView f94311m;

        public c(View view) {
            super(view);
            this.f94306d = (RelativeLayout) view.findViewById(R.id.ixt);
            this.f94307e = (RoundCornerImageView) view.findViewById(R.id.ixp);
            this.f94308f = (TextView) view.findViewById(R.id.a6j);
            this.f94310i = (RelativeLayout) view.findViewById(R.id.ixq);
            this.f94309h = (TextView) view.findViewById(R.id.ixs);
            this.f94311m = (ImageView) view.findViewById(R.id.ixr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface d {
        void a(int i3);
    }

    public SlideShowAdapter(Context context, View.OnClickListener onClickListener, e eVar) {
        this.f94295d = context;
        this.f94300m = onClickListener;
        this.C = eVar;
    }

    private void x(int i3, boolean z16) {
        if (i3 >= 0 && i3 < this.f94296e.size()) {
            if (z16 && this.f94298h != i3) {
                this.f94298h = i3;
            } else {
                this.f94298h = -1;
            }
            notifyItemChanged(i3, 0);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f94296e.size();
    }

    @Override // com.tencent.biz.qqstory.takevideo.slideshow.a
    public void onItemMove(int i3, int i16) {
        SlideItemInfo slideItemInfo;
        int i17;
        if (i3 >= 0 && i16 >= 0 && i3 < this.f94296e.size() && i16 < this.f94296e.size()) {
            Collections.swap(this.f94296e, i3, i16);
        }
        notifyItemMoved(i3, i16);
        int i18 = this.f94298h;
        if (i18 == i3 || i18 == i16) {
            if (i18 == i3) {
                this.f94298h = i16;
            } else {
                this.f94298h = i3;
            }
            notifyItemChanged(i3, 0);
            notifyItemChanged(i16, 0);
        }
        e eVar = this.C;
        if (eVar != null) {
            eVar.n(i3, i16);
        }
        if (i3 < this.f94296e.size() && i3 >= 0 && (slideItemInfo = this.f94296e.get(i3)) != null) {
            int i19 = 1;
            if (SlideShowPhotoListManager.n().l() == 11) {
                i17 = 0;
            } else {
                i17 = 1;
            }
            String[] strArr = new String[1];
            StringBuilder sb5 = new StringBuilder();
            if (slideItemInfo.f94290h == 0) {
                i19 = 0;
            }
            sb5.append(i19);
            sb5.append("");
            strArr[0] = sb5.toString();
            id0.a.n("pic_choose_slides", "edit_seq", i17, 0, strArr);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final c cVar, int i3) {
        SlideItemInfo slideItemInfo = this.f94296e.get(i3);
        cVar.f94306d.setTag(slideItemInfo);
        cVar.f94311m.setTag(slideItemInfo);
        if (slideItemInfo != null) {
            if (slideItemInfo.f94292m != null) {
                Drawable drawable = cVar.f94307e.getDrawable();
                if (!(drawable instanceof URLDrawable) || !slideItemInfo.f94292m.equals(((URLDrawable) drawable).getURL())) {
                    URLDrawable drawable2 = URLDrawableHelper.getDrawable(slideItemInfo.f94292m, URLDrawableHelper.getLoadingDrawable(), BaseURLDrawableHelper.getFailedDrawable());
                    drawable2.setTag(slideItemInfo.f94287d);
                    cVar.f94307e.setImageDrawable(drawable2);
                    cVar.f94307e.setTag(slideItemInfo);
                }
            }
            int i16 = slideItemInfo.f94290h;
            if (i16 != 0) {
                if (i16 == 1) {
                    cVar.f94310i.setVisibility(0);
                    if (slideItemInfo.C > 0) {
                        cVar.f94309h.setText(h.c(slideItemInfo.E - slideItemInfo.D));
                    }
                    cVar.f94310i.setOnClickListener(new b(i3));
                }
            } else {
                cVar.f94310i.setVisibility(8);
                cVar.f94309h.setText(h.c(slideItemInfo.C));
            }
        }
        if (i3 == this.f94298h && !cVar.C) {
            cVar.f94306d.setScaleX(0.94f);
            cVar.f94306d.setScaleY(0.94f);
            cVar.f94306d.setAlpha(1.0f);
            cVar.f94308f.post(new Runnable() { // from class: com.tencent.biz.qqstory.takevideo.slideshow.SlideShowAdapter.3
                @Override // java.lang.Runnable
                public void run() {
                    int width = cVar.f94308f.getWidth();
                    int height = cVar.f94308f.getHeight();
                    if (width != 0 && height != 0) {
                        if (SlideShowAdapter.this.f94297f == null) {
                            int c16 = x.c(SlideShowAdapter.this.f94295d, 1.0f);
                            new Paint().setTextSize(x.c(SlideShowAdapter.this.f94295d, 11.0f));
                            SlideShowAdapter.this.f94297f = GridListAdapter.a(width, height, c16, 0.0f, x.c(SlideShowAdapter.this.f94295d, 2.0f), Color.parseColor("#12B7F5"));
                        }
                        cVar.f94308f.setBackgroundDrawable(new BitmapDrawable(SlideShowAdapter.this.f94295d.getResources(), SlideShowAdapter.this.f94297f));
                    }
                }
            });
        } else if (cVar.C) {
            cVar.f94306d.setScaleX(1.13f);
            cVar.f94306d.setScaleY(1.13f);
            cVar.f94306d.setAlpha(0.65f);
            cVar.f94308f.setBackgroundDrawable(null);
        } else {
            cVar.f94306d.setScaleX(1.0f);
            cVar.f94306d.setScaleY(1.0f);
            cVar.f94306d.setAlpha(1.0f);
            cVar.f94308f.setBackgroundDrawable(null);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(cVar, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i3) {
        c cVar = new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f168927b81, viewGroup, false));
        cVar.f94307e.setCorner(4);
        cVar.f94307e.setBorder(true);
        cVar.f94307e.setOnClickListener(this.f94300m);
        cVar.f94311m.setOnClickListener(new a(cVar));
        return cVar;
    }

    public void w(d dVar) {
        this.f94299i = dVar;
    }

    public void y(List<SlideItemInfo> list) {
        this.f94296e.clear();
        this.f94296e.addAll(list);
        notifyDataSetChanged();
    }

    public void z(int i3) {
        if (i3 >= 0) {
            int i16 = this.f94298h;
            if (i16 < 0) {
                x(i3, true);
                return;
            } else {
                x(i16, false);
                x(i3, true);
                return;
            }
        }
        int i17 = this.f94298h;
        if (i17 >= 0) {
            x(i17, false);
        }
    }
}
