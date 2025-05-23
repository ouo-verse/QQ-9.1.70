package kd0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private b f412037d;

    /* renamed from: e, reason: collision with root package name */
    private Context f412038e;

    /* renamed from: f, reason: collision with root package name */
    private int f412039f;

    /* renamed from: h, reason: collision with root package name */
    private int f412040h;

    /* renamed from: i, reason: collision with root package name */
    private int f412041i;

    /* compiled from: P */
    /* renamed from: kd0.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static class C10647a {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f412042a;

        C10647a() {
        }
    }

    public a(Context context, int i3, int i16, int i17) {
        this.f412038e = context;
        this.f412039f = i3;
        this.f412040h = i16;
        this.f412041i = i17;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap getItem(int i3) {
        return null;
    }

    public void b() {
        this.f412037d = null;
        this.f412038e = null;
    }

    public void c(b bVar) {
        this.f412037d = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f412039f;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        C10647a c10647a;
        View view2;
        if (view == null) {
            ImageView imageView = new ImageView(this.f412038e);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f412040h, (int) (com.tencent.biz.qqstory.takevideo.a.a(this.f412038e.getResources()) * this.f412040h));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(layoutParams);
            c10647a = new C10647a();
            c10647a.f412042a = imageView;
            imageView.setImageDrawable(new ColorDrawable(-12303292));
            imageView.setTag(c10647a);
            view2 = imageView;
        } else {
            c10647a = (C10647a) view.getTag();
            view2 = view;
        }
        this.f412037d.b(c10647a.f412042a, Integer.valueOf(i3));
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view2;
    }
}
