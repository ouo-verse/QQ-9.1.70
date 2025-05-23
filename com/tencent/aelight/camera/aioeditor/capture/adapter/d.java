package com.tencent.aelight.camera.aioeditor.capture.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private Context f66626d;

    /* renamed from: e, reason: collision with root package name */
    MusicProviderView f66627e;

    /* renamed from: f, reason: collision with root package name */
    List<MusicItemInfo> f66628f;

    /* renamed from: h, reason: collision with root package name */
    int f66629h;

    /* renamed from: i, reason: collision with root package name */
    int f66630i;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        TextView f66631a;

        /* renamed from: b, reason: collision with root package name */
        TextView f66632b;

        /* renamed from: c, reason: collision with root package name */
        QIMCommonLoadingView f66633c;

        /* renamed from: d, reason: collision with root package name */
        ImageView f66634d;

        /* renamed from: e, reason: collision with root package name */
        MusicItemInfo f66635e;

        /* renamed from: f, reason: collision with root package name */
        TextView f66636f;

        /* renamed from: g, reason: collision with root package name */
        ImageView f66637g;

        /* renamed from: h, reason: collision with root package name */
        ImageView f66638h;

        /* renamed from: i, reason: collision with root package name */
        ImageView f66639i;

        /* renamed from: j, reason: collision with root package name */
        int f66640j;

        public a() {
        }
    }

    public d(Context context, MusicProviderView musicProviderView) {
        this.f66626d = context;
        this.f66627e = musicProviderView;
    }

    private void d(a aVar) {
        int i3;
        int i16;
        int i17;
        MusicItemInfo musicItemInfo = aVar.f66635e;
        int i18 = musicItemInfo.mType;
        MusicItemInfo m3 = ((com.tencent.aelight.camera.aioeditor.capture.music.g) fr.f.d().g(8)).m();
        if (m3 == null) {
            m3 = ((QIMMusicConfigManager) fr.f.c(2)).A(-1, -1);
        }
        boolean equals = musicItemInfo.equals(m3);
        if (i18 != 1 && i18 != 5) {
            aVar.f66633c.a(null);
            aVar.f66633c.setVisibility(8);
            aVar.f66639i.setVisibility(8);
            aVar.f66631a.setVisibility(8);
            aVar.f66632b.setVisibility(8);
            aVar.f66636f.setVisibility(0);
            aVar.f66638h.setVisibility(8);
            String qqStr = HardCodeUtil.qqStr(R.string.oco);
            if (i18 == 3) {
                qqStr = HardCodeUtil.qqStr(R.string.ocl);
                i16 = R.drawable.egi;
                i17 = R.drawable.egj;
            } else if (i18 == 4) {
                qqStr = HardCodeUtil.qqStr(R.string.ocj);
                i16 = R.drawable.egd;
                i17 = R.drawable.ege;
            } else if (i18 == 10) {
                qqStr = HardCodeUtil.qqStr(R.string.ocp);
                aVar.f66639i.setVisibility(0);
                i16 = R.drawable.egl;
                i17 = R.drawable.egl;
            } else {
                i16 = R.drawable.egk;
                i17 = R.drawable.egh;
            }
            if (equals) {
                aVar.f66634d.setImageResource(i17);
            } else {
                aVar.f66634d.setImageResource(i16);
            }
            aVar.f66637g.setVisibility(8);
            aVar.f66636f.setText(qqStr);
            return;
        }
        aVar.f66631a.setVisibility(0);
        aVar.f66632b.setVisibility(8);
        aVar.f66636f.setVisibility(8);
        aVar.f66639i.setVisibility(8);
        aVar.f66631a.setText(musicItemInfo.mMusicName);
        aVar.f66632b.setText(musicItemInfo.mSingername);
        if (equals && !musicItemInfo.isDownloading()) {
            if (musicItemInfo.isMyMusicInfo()) {
                aVar.f66636f.setText(HardCodeUtil.qqStr(R.string.oci));
                aVar.f66636f.setVisibility(0);
                i3 = R.drawable.egg;
            } else {
                aVar.f66636f.setVisibility(8);
                i3 = R.drawable.efo;
            }
            aVar.f66638h.setImageResource(i3);
            aVar.f66638h.setVisibility(0);
        } else {
            aVar.f66638h.setVisibility(8);
            aVar.f66636f.setVisibility(8);
        }
        aVar.f66633c.setVisibility(0);
        com.tencent.aelight.camera.aioeditor.capture.view.c c16 = com.tencent.aelight.camera.aioeditor.capture.view.c.c(musicItemInfo);
        aVar.f66633c.a(c16);
        if (musicItemInfo.isDownloading() && c16.f67350a == 2) {
            aVar.f66637g.setVisibility(8);
        } else if (!musicItemInfo.isFileExist()) {
            aVar.f66637g.setVisibility(0);
        } else {
            aVar.f66637g.setVisibility(8);
        }
        b(aVar, musicItemInfo);
    }

    public View a() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f66626d);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f66626d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int dpToPx = ViewUtils.dpToPx(5.0f);
        layoutParams.setMargins(dpToPx, dpToPx, dpToPx, dpToPx);
        relativeLayout.addView(relativeLayout2, layoutParams);
        ImageView imageView = new ImageView(this.f66626d);
        imageView.setId(R.id.f3h);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout2.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
        TextView textView = new TextView(this.f66626d);
        textView.setId(R.id.f3i);
        textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), ViewUtils.dpToPx(10.0f));
        textView.setMaxLines(4);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(Color.parseColor("#ffffffff"));
        textView.setTextSize(2, 12.0f);
        textView.setShadowLayer(4.0f, 0.0f, 2.0f, Color.parseColor("#80000000"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        int dpToPx2 = ViewUtils.dpToPx(5.0f);
        layoutParams2.topMargin = ViewUtils.dpToPx(8.0f);
        layoutParams2.leftMargin = dpToPx2;
        layoutParams2.rightMargin = dpToPx2;
        layoutParams2.addRule(10, -1);
        layoutParams2.addRule(9, -1);
        relativeLayout2.addView(textView, layoutParams2);
        TextView textView2 = new TextView(this.f66626d);
        textView2.setId(R.id.f3g);
        textView2.setTextColor(Color.parseColor("#9fffffff"));
        textView2.setTextSize(2, 9.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(12, -1);
        layoutParams3.addRule(9, -1);
        int dpToPx3 = ViewUtils.dpToPx(5.0f);
        layoutParams3.leftMargin = dpToPx3;
        layoutParams3.rightMargin = dpToPx3;
        layoutParams3.bottomMargin = ViewUtils.dpToPx(4.0f);
        relativeLayout2.addView(textView2, layoutParams3);
        ImageView imageView2 = new ImageView(this.f66626d);
        imageView2.setId(R.id.f3j);
        imageView2.setImageResource(R.drawable.efo);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout2.addView(imageView2, new RelativeLayout.LayoutParams(-1, -1));
        TextView textView3 = new TextView(this.f66626d);
        textView3.setId(R.id.f166608gm0);
        textView3.setTextSize(2, 12.0f);
        textView3.setTextColor(Color.parseColor("#ffffffff"));
        textView3.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.bottomMargin = ViewUtils.dpToPx(5.0f);
        layoutParams4.addRule(12, -1);
        layoutParams4.addRule(14, -1);
        relativeLayout2.addView(textView3, layoutParams4);
        QIMCommonLoadingView qIMCommonLoadingView = new QIMCommonLoadingView(this.f66626d);
        qIMCommonLoadingView.setId(R.id.f3x);
        qIMCommonLoadingView.setVisibility(8);
        relativeLayout2.addView(qIMCommonLoadingView, new RelativeLayout.LayoutParams(-1, -1));
        ImageView imageView3 = new ImageView(this.f66626d);
        imageView3.setId(R.id.f3b);
        imageView3.setVisibility(8);
        imageView3.setImageResource(R.drawable.f6q);
        int dpToPx4 = ViewUtils.dpToPx(18.0f);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(dpToPx4, dpToPx4);
        layoutParams5.addRule(11, -1);
        layoutParams5.addRule(10, -1);
        relativeLayout.addView(imageView3, layoutParams5);
        ImageView imageView4 = new ImageView(this.f66626d);
        imageView4.setId(R.id.l5d);
        imageView4.setImageResource(R.drawable.f6x);
        imageView4.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(11, -1);
        layoutParams6.addRule(10, -1);
        relativeLayout.addView(imageView4, layoutParams6);
        return relativeLayout;
    }

    public void b(a aVar, MusicItemInfo musicItemInfo) {
        if (TextUtils.isEmpty(musicItemInfo.mAlbumUrl)) {
            aVar.f66634d.setImageResource(R.drawable.egf);
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        int f16 = BaseAIOUtils.f(80.0f, aVar.f66634d.getResources());
        obtain.mRequestWidth = f16;
        obtain.mRequestHeight = f16;
        obtain.mRetryCount = 3;
        obtain.mFailedDrawable = this.f66626d.getResources().getDrawable(R.drawable.egf);
        obtain.mLoadingDrawable = this.f66626d.getResources().getDrawable(R.drawable.egf);
        URLDrawable drawable = URLDrawable.getDrawable(musicItemInfo.mAlbumUrl, obtain);
        if (drawable.getStatus() == 2) {
            drawable.restartDownload();
        }
        drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306342v);
        aVar.f66634d.setImageDrawable(drawable);
    }

    public void c(View view) {
        a aVar = (a) view.getTag();
        if (aVar != null) {
            d(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f66628f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f66628f.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (this.f66629h <= 0 && viewGroup != null) {
            this.f66629h = viewGroup.getMeasuredWidth();
            this.f66630i = (int) (((((r0 - (e.D * 3)) - viewGroup.getPaddingLeft()) - viewGroup.getPaddingRight()) / 4) + 0.5f);
        }
        MusicItemInfo musicItemInfo = (MusicItemInfo) getItem(i3);
        if (view == null) {
            aVar = new a();
            View a16 = a();
            aVar.f66631a = (TextView) a16.findViewById(R.id.f3i);
            aVar.f66632b = (TextView) a16.findViewById(R.id.f3g);
            aVar.f66633c = (QIMCommonLoadingView) a16.findViewById(R.id.f3x);
            aVar.f66634d = (ImageView) a16.findViewById(R.id.f3h);
            aVar.f66636f = (TextView) a16.findViewById(R.id.f166608gm0);
            aVar.f66638h = (ImageView) a16.findViewById(R.id.f3j);
            aVar.f66637g = (ImageView) a16.findViewById(R.id.f3b);
            aVar.f66639i = (ImageView) a16.findViewById(R.id.l5d);
            a16.setTag(aVar);
            view2 = a16;
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        aVar.f66633c.setVisibility(0);
        aVar.f66635e = musicItemInfo;
        aVar.f66640j = i3;
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view2.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -1);
            view2.setLayoutParams(layoutParams);
        }
        ((ViewGroup.LayoutParams) layoutParams).height = this.f66630i;
        d(aVar);
        if (musicItemInfo.isWsBanner()) {
            l.f(musicItemInfo);
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view2;
    }

    public void setData(List<MusicItemInfo> list) {
        this.f66628f = list;
    }
}
