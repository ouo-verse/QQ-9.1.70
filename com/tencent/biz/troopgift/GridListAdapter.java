package com.tencent.biz.troopgift;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class GridListAdapter extends BaseAdapter {
    protected int C;
    protected TroopGiftPanel D;

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList<Object> f96875d;

    /* renamed from: e, reason: collision with root package name */
    protected Context f96876e;

    /* renamed from: f, reason: collision with root package name */
    protected LayoutInflater f96877f;

    /* renamed from: h, reason: collision with root package name */
    protected int f96878h;

    /* renamed from: i, reason: collision with root package name */
    protected Drawable f96879i;

    /* renamed from: m, reason: collision with root package name */
    protected String f96880m = null;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f96885a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f96886b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f96887c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f96888d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f96889e;

        /* renamed from: f, reason: collision with root package name */
        public TextView f96890f;

        /* renamed from: g, reason: collision with root package name */
        public TextView f96891g;

        /* renamed from: h, reason: collision with root package name */
        public View f96892h;

        /* renamed from: i, reason: collision with root package name */
        public TextView f96893i;

        /* renamed from: j, reason: collision with root package name */
        public LinearLayout f96894j;

        /* renamed from: k, reason: collision with root package name */
        public TextView f96895k;

        /* renamed from: l, reason: collision with root package name */
        public b f96896l = null;

        /* renamed from: m, reason: collision with root package name */
        public ImageView f96897m;
    }

    public GridListAdapter(Context context, TroopGiftPanel troopGiftPanel) {
        this.f96878h = -1;
        this.f96879i = null;
        this.f96876e = context;
        this.f96877f = LayoutInflater.from(context);
        this.f96879i = context.getResources().getDrawable(R.drawable.gjd);
        this.f96878h = -1;
        this.C = BaseAIOUtils.f(9.0f, context.getResources());
        this.D = troopGiftPanel;
    }

    public static Bitmap a(int i3, int i16, int i17, float f16, float f17, int i18) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setColor(i18);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(f17);
            paint.setAntiAlias(true);
            float f18 = f17 / 2.0f;
            float f19 = i3;
            RectF rectF = new RectF(f18, f18, f19 - f18, i16 - f18);
            float f26 = i17;
            canvas.drawRoundRect(rectF, f26, f26, paint);
            Bitmap createBitmap2 = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            Paint paint2 = new Paint();
            canvas2.drawARGB(0, 0, 0, 0);
            float f27 = (f19 - f16) / 2.0f;
            canvas2.drawRect(f27, 0.0f, f19 - f27, f26, paint2);
            paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
            canvas2.drawBitmap(createBitmap, 0.0f, 0.0f, paint2);
            createBitmap.recycle();
            return createBitmap2;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f96880m = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<Object> arrayList = this.f96875d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f96875d.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        URLDrawable drawable;
        final int color;
        View inflate;
        if (view == null) {
            a aVar = new a();
            if (this.D.b() == 20) {
                inflate = this.f96877f.inflate(R.layout.a3f, (ViewGroup) null);
                if (getCount() >= 5) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
                    ((ViewGroup.LayoutParams) layoutParams).width = (ScreenUtil.SCREEN_WIDTH / 5) + 30;
                    inflate.setLayoutParams(layoutParams);
                }
            } else {
                inflate = this.f96877f.inflate(R.layout.aib, (ViewGroup) null);
            }
            aVar.f96886b = (ImageView) inflate.findViewById(R.id.clg);
            aVar.f96885a = (ImageView) inflate.findViewById(R.id.cv9);
            aVar.f96887c = (TextView) inflate.findViewById(R.id.cve);
            aVar.f96888d = (TextView) inflate.findViewById(R.id.cvj);
            aVar.f96895k = (TextView) inflate.findViewById(R.id.clh);
            aVar.f96893i = (TextView) inflate.findViewById(R.id.jld);
            aVar.f96889e = (TextView) inflate.findViewById(R.id.cvk);
            aVar.f96890f = (TextView) inflate.findViewById(R.id.cvb);
            aVar.f96891g = (TextView) inflate.findViewById(R.id.cvd);
            aVar.f96892h = inflate.findViewById(R.id.a6j);
            aVar.f96894j = (LinearLayout) inflate.findViewById(R.id.cv_);
            aVar.f96897m = (ImageView) inflate.findViewById(R.id.cvm);
            inflate.setTag(aVar);
            view = inflate;
        }
        final a aVar2 = (a) view.getTag();
        final b bVar = (b) this.f96875d.get(i3);
        aVar2.f96896l = bVar;
        if (this.D.d()) {
            aVar2.f96887c.setVisibility(0);
            aVar2.f96887c.setText(bVar.f96921a);
            if (this.D.b() == 20) {
                aVar2.f96887c.setTextColor(-1);
            }
        } else {
            aVar2.f96887c.setVisibility(8);
        }
        if (aVar2.f96897m != null) {
            if (bVar.f96931k == 1 && !TextUtils.isEmpty(bVar.f96932l)) {
                aVar2.f96897m.setVisibility(0);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mPlayGifImage = false;
                obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                aVar2.f96897m.setImageDrawable(URLDrawable.getDrawable(bVar.f96932l, obtain));
            } else {
                aVar2.f96897m.setVisibility(8);
            }
        }
        if (bVar.f96928h && this.D.c() > 0) {
            aVar2.f96888d.setVisibility(8);
            aVar2.f96895k.setVisibility(0);
            aVar2.f96895k.setText("\u514d\u8d39x" + this.D.c());
            if (bVar.f96924d == 0) {
                aVar2.f96891g.setVisibility(0);
            } else {
                aVar2.f96891g.setVisibility(8);
            }
            URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
            if (bVar.f96927g) {
                if (this.D.b() == 20) {
                    aVar2.f96892h.setVisibility(4);
                    aVar2.f96889e.setVisibility(4);
                    aVar2.f96894j.post(new Runnable() { // from class: com.tencent.biz.troopgift.GridListAdapter.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int c16 = x.c(GridListAdapter.this.f96876e, 5.0f);
                            new Paint().setTextSize(x.c(GridListAdapter.this.f96876e, 11.0f));
                            int width = aVar2.f96894j.getWidth();
                            int height = aVar2.f96894j.getHeight();
                            if (width != 0 && height != 0) {
                                GradientDrawable gradientDrawable = new GradientDrawable();
                                gradientDrawable.setShape(0);
                                float f16 = c16;
                                gradientDrawable.setCornerRadii(new float[]{f16, f16, f16, f16, f16, f16, f16, f16});
                                gradientDrawable.setColor(Color.argb(35, 0, 0, 0));
                                aVar2.f96894j.setBackgroundDrawable(gradientDrawable);
                            }
                        }
                    });
                } else {
                    if (bVar.f96925e < 0) {
                        color = this.f96876e.getResources().getColor(R.color.f157707xc);
                        aVar2.f96889e.setText(bVar.f96926f);
                        aVar2.f96889e.setTextColor(color);
                    } else {
                        color = this.f96876e.getResources().getColor(R.color.f157706xb);
                        aVar2.f96889e.setText(bVar.f96926f);
                        aVar2.f96889e.setTextColor(color);
                    }
                    aVar2.f96889e.setVisibility(0);
                    aVar2.f96892h.setVisibility(0);
                    aVar2.f96892h.post(new Runnable() { // from class: com.tencent.biz.troopgift.GridListAdapter.2
                        @Override // java.lang.Runnable
                        public void run() {
                            int width = aVar2.f96892h.getWidth();
                            int height = aVar2.f96892h.getHeight();
                            if (width != 0 && height != 0) {
                                int c16 = x.c(GridListAdapter.this.f96876e, 5.0f);
                                Paint paint = new Paint();
                                paint.setTextSize(x.c(GridListAdapter.this.f96876e, 11.0f));
                                aVar2.f96892h.setBackgroundDrawable(new BitmapDrawable(GridListAdapter.this.f96876e.getResources(), GridListAdapter.a(width, height, c16, x.c(GridListAdapter.this.f96876e, 2.0f) + paint.measureText(bVar.f96926f), x.c(GridListAdapter.this.f96876e, 1.0f), color)));
                            }
                        }
                    });
                }
                obtain2.mPlayGifImage = true;
                obtain2.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                drawable = URLDrawable.getDrawable(bVar.f96922b, obtain2);
            } else {
                if (this.D.b() == 20) {
                    aVar2.f96894j.setBackgroundDrawable(null);
                } else {
                    aVar2.f96892h.setVisibility(4);
                    aVar2.f96889e.setVisibility(4);
                }
                obtain2.mPlayGifImage = false;
                obtain2.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                drawable = URLDrawable.getDrawable(bVar.f96923c, obtain2);
            }
            if (bVar.f96928h) {
                if (bVar.f96927g) {
                    aVar2.f96890f.setVisibility(0);
                    aVar2.f96890f.setText(HardCodeUtil.qqStr(R.string.n4k) + bVar.f96929i + HardCodeUtil.qqStr(R.string.n4m));
                } else {
                    aVar2.f96890f.setVisibility(8);
                }
                if (!this.D.a()) {
                    aVar2.f96886b.setVisibility(0);
                } else {
                    aVar2.f96886b.setVisibility(8);
                }
            } else {
                aVar2.f96890f.setVisibility(8);
            }
            aVar2.f96885a.setImageDrawable(drawable);
            if (!this.D.d() && this.D.b() == 20 && !TextUtils.isEmpty(bVar.f96926f)) {
                aVar2.f96893i.setVisibility(0);
                aVar2.f96893i.setText(bVar.f96926f);
            } else {
                aVar2.f96893i.setVisibility(8);
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
        if (bVar.f96930j) {
            TextView textView = aVar2.f96895k;
            if (textView != null) {
                textView.setVisibility(8);
            }
            aVar2.f96888d.setVisibility(0);
            aVar2.f96888d.setTextColor(Color.parseColor("#bbbbbb"));
            this.D.getClass();
            throw null;
        }
        TextView textView2 = aVar2.f96895k;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        aVar2.f96888d.setVisibility(0);
        this.D.getClass();
        throw null;
    }

    public void setData(ArrayList<Object> arrayList) {
        Object valueOf;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("GridListAdapter setData items = ");
            if (arrayList == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(arrayList.size());
            }
            sb5.append(valueOf);
            QLog.d("zivonchen", 2, sb5.toString());
        }
        this.f96878h = -1;
        this.f96875d = arrayList;
    }
}
