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
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.data.j;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private Context f66614d;

    /* renamed from: e, reason: collision with root package name */
    List<QIMFilterCategoryItem> f66615e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    int f66616f;

    /* renamed from: h, reason: collision with root package name */
    int f66617h;

    /* renamed from: i, reason: collision with root package name */
    int f66618i;

    /* renamed from: m, reason: collision with root package name */
    int f66619m;

    public b(Context context, int i3) {
        this.f66614d = context;
        this.f66618i = i3;
    }

    private View a() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f66614d);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f66614d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int dpToPx = ViewUtils.dpToPx(5.0f);
        layoutParams.setMargins(dpToPx, dpToPx, dpToPx, dpToPx);
        relativeLayout.addView(relativeLayout2, layoutParams);
        URLImageView uRLImageView = new URLImageView(this.f66614d);
        uRLImageView.setId(R.id.icon);
        uRLImageView.setImageResource(R.drawable.efp);
        relativeLayout2.addView(uRLImageView, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout relativeLayout3 = new RelativeLayout(this.f66614d);
        relativeLayout3.setBackgroundResource(R.drawable.efm);
        relativeLayout3.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = ViewUtils.dpToPx(16.0f);
        layoutParams2.addRule(14, -1);
        relativeLayout2.addView(relativeLayout3, layoutParams2);
        TextView textView = new TextView(this.f66614d);
        textView.setCompoundDrawables(null, null, this.f66614d.getResources().getDrawable(R.drawable.efn), null);
        textView.setCompoundDrawablePadding(ViewUtils.dpToPx(4.0f));
        textView.setText(HardCodeUtil.qqStr(R.string.mkt));
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(this.f66614d.getResources().getColor(R.color.f158017al3));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13, -1);
        relativeLayout3.addView(textView, layoutParams3);
        TextView textView2 = new TextView(this.f66614d);
        textView2.setId(R.id.cah);
        textView2.setTextSize(2, 12.0f);
        textView2.setTextColor(this.f66614d.getResources().getColor(R.color.f158017al3));
        textView2.setMaxLines(1);
        textView2.setLines(1);
        textView2.setShadowLayer(3.0f, 0.0f, 0.0f, Color.parseColor("#7F000000"));
        textView2.setBackgroundResource(R.drawable.hfn);
        textView2.setGravity(17);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, ViewUtils.dpToPx(31.0f));
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(12, -1);
        relativeLayout2.addView(textView2, layoutParams4);
        ImageView imageView = new ImageView(this.f66614d);
        imageView.setId(R.id.f165790dj0);
        imageView.setVisibility(8);
        imageView.setImageResource(R.drawable.efo);
        relativeLayout2.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
        View qIMCommonLoadingView = new QIMCommonLoadingView(this.f66614d);
        qIMCommonLoadingView.setId(R.id.cak);
        qIMCommonLoadingView.setVisibility(8);
        relativeLayout2.addView(qIMCommonLoadingView, new RelativeLayout.LayoutParams(-1, -1));
        ImageView imageView2 = new ImageView(this.f66614d);
        imageView2.setId(R.id.bab);
        imageView2.setImageResource(R.drawable.f6q);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(11, -1);
        layoutParams5.addRule(10, -1);
        relativeLayout.addView(imageView2, layoutParams5);
        ImageView imageView3 = new ImageView(this.f66614d);
        imageView3.setId(R.id.l5d);
        imageView3.setImageResource(R.drawable.f6x);
        imageView3.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(11, -1);
        layoutParams6.addRule(10, -1);
        relativeLayout.addView(imageView3, layoutParams6);
        return relativeLayout;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f66615e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f66615e.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    public void setData(List<QIMFilterCategoryItem> list) {
        this.f66615e.clear();
        this.f66615e.addAll(list);
        if (m.n().E()) {
            return;
        }
        m.f(this.f66615e);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x01b4, code lost:
    
        if (r3 != 3) goto L56;
     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (this.f66616f <= 0 && viewGroup != null) {
            this.f66616f = viewGroup.getMeasuredWidth();
            int paddingLeft = (int) (((((r1 - (c.C * 3)) - viewGroup.getPaddingLeft()) - viewGroup.getPaddingRight()) / 4) + 0.5f);
            this.f66617h = paddingLeft;
            this.f66619m = (paddingLeft * 12) / 160;
        }
        View a16 = view == null ? a() : view;
        TextView textView = (TextView) a16.findViewById(R.id.cah);
        ImageView imageView = (ImageView) a16.findViewById(R.id.f165790dj0);
        ImageView imageView2 = (ImageView) a16.findViewById(R.id.icon);
        ImageView imageView3 = (ImageView) a16.findViewById(R.id.bab);
        QIMCommonLoadingView qIMCommonLoadingView = (QIMCommonLoadingView) a16.findViewById(R.id.cak);
        QIMFilterCategoryItem qIMFilterCategoryItem = this.f66615e.get(i3);
        QIMFilterCategoryItem i16 = m.n().i(this.f66618i);
        boolean equals = i16 != null ? TextUtils.equals(i16.f66697d, qIMFilterCategoryItem.f66697d) : false;
        if (!equals) {
            equals = (i16 == null || i16.l()) && qIMFilterCategoryItem.l();
        }
        a16.setTag(qIMFilterCategoryItem);
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) a16.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -1);
            a16.setLayoutParams(layoutParams);
        }
        ((ViewGroup.LayoutParams) layoutParams).height = this.f66617h;
        if (qIMFilterCategoryItem.l()) {
            imageView.setVisibility(8);
            if (equals) {
                imageView.setVisibility(0);
                imageView2.setImageDrawable(this.f66614d.getResources().getDrawable(R.drawable.efq));
            } else {
                imageView2.setImageDrawable(this.f66614d.getResources().getDrawable(R.drawable.efq));
            }
            imageView3.setVisibility(8);
            textView.setText(HardCodeUtil.qqStr(R.string.mku));
        } else {
            j s16 = ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).s(qIMFilterCategoryItem);
            if (equals) {
                imageView.setVisibility(0);
                textView.setShadowLayer(0.0f, 0.0f, 0.0f, this.f66614d.getResources().getColor(R.color.acv));
            } else {
                imageView.setVisibility(8);
                textView.setShadowLayer(3.0f, 0.0f, 0.0f, this.f66614d.getResources().getColor(R.color.acv));
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = this.f66614d.getResources().getDrawable(R.drawable.ee_);
            obtain.mFailedDrawable = this.f66614d.getResources().getDrawable(R.drawable.ee_);
            qIMCommonLoadingView.setMax(10000);
            if (s16.f66706e == 1) {
                qIMCommonLoadingView.setVisibility(0);
            } else {
                qIMCommonLoadingView.setVisibility(8);
            }
            URLDrawable drawable = URLDrawable.getDrawable(qIMFilterCategoryItem.f66700h, obtain);
            if (drawable.getStatus() == 2) {
                drawable.restartDownload();
            }
            imageView2.setImageDrawable(drawable);
            textView.setText(qIMFilterCategoryItem.f66698e);
            if (qIMFilterCategoryItem.n()) {
                imageView3.setVisibility(8);
                ImageView imageView4 = (ImageView) a16.findViewById(R.id.l5d);
                imageView4.setImageResource(R.drawable.f6x);
                imageView4.setVisibility(0);
            } else {
                m.n();
                boolean F = m.F(3, qIMFilterCategoryItem.f66701i, qIMFilterCategoryItem.f66697d);
                int v3 = s16.v();
                qIMCommonLoadingView.setVisibility(0);
                qIMCommonLoadingView.setBgCorner(this.f66619m);
                qIMCommonLoadingView.a(com.tencent.aelight.camera.aioeditor.capture.view.c.c(s16));
                imageView3.setVisibility(0);
                if (F) {
                    imageView3.setImageResource(R.drawable.f6r);
                } else {
                    if (v3 != 1) {
                        if (v3 == 2) {
                            imageView3.setImageResource(R.drawable.f6q);
                        }
                    }
                    imageView3.setVisibility(8);
                }
            }
        }
        EventCollector.getInstance().onListGetView(i3, a16, viewGroup, getItemId(i3));
        return a16;
    }
}
