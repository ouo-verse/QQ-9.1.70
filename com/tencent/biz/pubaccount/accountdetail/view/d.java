package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.impl.PublicAccountConfigAttrImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.widget.BubbleViewLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.GridView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends b {

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends BaseAdapter {

        /* compiled from: P */
        /* renamed from: com.tencent.biz.pubaccount.accountdetail.view.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes32.dex */
        class C0804a {

            /* renamed from: a, reason: collision with root package name */
            URLImageView f79265a;

            /* renamed from: b, reason: collision with root package name */
            TextView f79266b;

            C0804a() {
            }
        }

        public a() {
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IPublicAccountConfigAttr.a getItem(int i3) {
            return d.this.f79255a.get(i3);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return d.this.f79255a.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            C0804a c0804a;
            Resources resources = d.this.f79256b.getResources();
            int f16 = BaseAIOUtils.f(200.0f, resources);
            int f17 = BaseAIOUtils.f(140.0f, resources);
            int f18 = BaseAIOUtils.f(12.0f, resources);
            if (view == null) {
                c0804a = new C0804a();
                BubbleViewLayout bubbleViewLayout = new BubbleViewLayout(d.this.f79256b);
                bubbleViewLayout.setRadius(6.0f);
                bubbleViewLayout.e(false);
                bubbleViewLayout.setLayoutParams(new AbsListView.LayoutParams(f17, f16));
                URLImageView uRLImageView = new URLImageView(d.this.f79256b);
                uRLImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                uRLImageView.setImageDrawable(new ColorDrawable(Color.parseColor(GameCenterVideoViewController.GRAY_MASK)));
                uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bubbleViewLayout.addView(uRLImageView);
                c0804a.f79265a = uRLImageView;
                TextView textView = new TextView(d.this.f79256b);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(12, -1);
                layoutParams.addRule(14, -1);
                layoutParams.setMargins(f18, 0, f18, f18);
                textView.setLayoutParams(layoutParams);
                textView.setTextColor(-1);
                textView.setTextSize(2, 16.0f);
                textView.setMaxLines(2);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                bubbleViewLayout.addView(textView);
                c0804a.f79266b = textView;
                bubbleViewLayout.setTag(c0804a);
                view2 = bubbleViewLayout;
            } else {
                view2 = view;
                c0804a = (C0804a) view.getTag();
            }
            IPublicAccountConfigAttr.a item = getItem(i3);
            c0804a.f79265a.setBackgroundDrawable(URLDrawable.getDrawable(item.f79339k, (Drawable) null, (Drawable) null, true));
            c0804a.f79266b.setText(item.f79330b);
            return view2;
        }
    }

    public d(Context context, ArrayList<IPublicAccountConfigAttr.a> arrayList, ay.a aVar, String str, String str2) {
        super(context, arrayList, aVar, str, str2);
    }

    private void d(LinearLayout linearLayout) {
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailWindowViewWrapper", 2, "buildView!");
        }
        Resources resources = this.f79256b.getResources();
        int f16 = BaseAIOUtils.f(140.0f, resources);
        int f17 = BaseAIOUtils.f(10.0f, resources);
        ((HorizontalScrollView) linearLayout.findViewById(R.id.l47)).setOverScrollMode(2);
        GridView gridView = (GridView) linearLayout.findViewById(R.id.l3y);
        gridView.setClickable(true);
        gridView.setColumnWidth(f16);
        gridView.setStretchMode(0);
        gridView.setHorizontalSpacing(f17);
        int size = this.f79255a.size();
        gridView.setLayoutParams(new LinearLayout.LayoutParams(((f16 + f17) * size) - f17, -2));
        gridView.setNumColumns(size);
        gridView.setOnItemClickListener(this.f79261g);
        gridView.setOverScrollMode(2);
        gridView.setAdapter((ListAdapter) new a());
        linearLayout.setClickable(false);
        linearLayout.setOnClickListener(null);
    }

    public static View e(Context context, View view, ViewGroup viewGroup, PublicAccountConfigAttrImpl publicAccountConfigAttrImpl, int i3, ay.a aVar, String str, String str2) {
        LinearLayout linearLayout;
        Object tag;
        ArrayList<IPublicAccountConfigAttr.a> b16 = b.b(publicAccountConfigAttrImpl, i3);
        if (b16.isEmpty()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AccountDetailWindowViewWrapper", 2, "createView return convertView!");
            }
            return view;
        }
        if (view != null && (view instanceof LinearLayout) && (tag = (linearLayout = (LinearLayout) view).getTag()) != null && (tag instanceof d) && ((d) tag).a(b16)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AccountDetailWindowViewWrapper", 2, "createView reuse!");
            }
            return linearLayout;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("AccountDetailWindowViewWrapper", 2, "createView new create!");
        }
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.f167519j, viewGroup, false);
        linearLayout2.setPadding(0, BaseAIOUtils.f(20.0f, viewGroup.getResources()), 0, 0);
        d dVar = new d(context, b16, aVar, str, str2);
        linearLayout2.setTag(dVar);
        dVar.d(linearLayout2);
        return linearLayout2;
    }
}
