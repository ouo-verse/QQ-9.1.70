package com.tencent.open.agent;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import gp3.e;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class RecommendListManager extends LinearLayout implements View.OnClickListener, ViewStub.OnInflateListener, e.b {

    /* renamed from: d, reason: collision with root package name */
    protected gp3.b f340016d;

    /* renamed from: e, reason: collision with root package name */
    protected FriendChooser f340017e;

    /* renamed from: f, reason: collision with root package name */
    protected HashMap<String, View> f340018f;

    /* renamed from: h, reason: collision with root package name */
    protected Handler f340019h;

    public RecommendListManager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f340016d = gp3.b.g();
        this.f340018f = new HashMap<>();
    }

    public void a() {
        int h16 = this.f340016d.h();
        com.tencent.open.base.f.a("RecommendListManager", "-->notifyDataSetChanged() count = " + h16);
        if (h16 > 5) {
            h16 = 5;
        }
        for (int i3 = 0; i3 < h16; i3++) {
            View childAt = super.getChildAt(i3);
            if (childAt instanceof ViewStub) {
                childAt.setVisibility(0);
            } else {
                CheckBox checkBox = (CheckBox) childAt.findViewById(R.id.axa);
                if (this.f340016d.n(this.f340016d.i(i3).f340346d)) {
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(false);
                }
            }
        }
    }

    public void b() {
        this.f340019h = new Handler();
        int childCount = super.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ViewStub viewStub = (ViewStub) super.getChildAt(i3);
            viewStub.setOnInflateListener(this);
            viewStub.setOnClickListener(this);
        }
        com.tencent.open.base.f.a("RecommendListManager", "-->onCreate()");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.i2s) {
            i3 = 0;
        } else if (id5 == R.id.i2t) {
            i3 = 1;
        } else if (id5 == R.id.i2u) {
            i3 = 2;
        } else if (id5 == R.id.i2v) {
            i3 = 3;
        } else if (id5 == R.id.i2w) {
            i3 = 4;
        } else {
            i3 = -1;
        }
        com.tencent.open.base.f.a("RecommendListManager", "-->onClick() position = " + i3 + " v.getId() = " + view.getId());
        if (i3 != -1 && i3 < this.f340016d.h()) {
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.axa);
            Friend i16 = this.f340016d.i(i3);
            this.f340017e.J2(i16);
            if (this.f340016d.n(i16.f340346d)) {
                checkBox.setChecked(true);
            } else {
                checkBox.setChecked(false);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // gp3.e.b
    public void onImageLoaded(final String str, final Bitmap bitmap, String str2) {
        this.f340019h.post(new Runnable() { // from class: com.tencent.open.agent.RecommendListManager.1
            @Override // java.lang.Runnable
            public void run() {
                ((ImageView) RecommendListManager.this.f340018f.get(str).findViewById(R.id.icon)).setImageBitmap(bitmap);
            }
        });
    }

    @Override // android.view.ViewStub.OnInflateListener
    public void onInflate(ViewStub viewStub, View view) {
        int i3;
        int id5 = view.getId();
        if (id5 == R.id.i2s) {
            i3 = 0;
        } else if (id5 == R.id.i2t) {
            i3 = 1;
        } else if (id5 == R.id.i2u) {
            i3 = 2;
        } else if (id5 == R.id.i2v) {
            i3 = 3;
        } else if (id5 == R.id.i2w) {
            i3 = 4;
        } else {
            i3 = -1;
        }
        com.tencent.open.base.f.a("RecommendListManager", "-->onInflate() position = " + i3);
        view.setOnClickListener(this);
        Friend i16 = this.f340016d.i(i3);
        String str = i16.f340349h;
        if (str == null || "".equals(str)) {
            i16.f340349h = gp3.f.a(this.f340017e.F2(), i16.f340346d);
        }
        this.f340018f.put(i16.f340349h, view);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.axa);
        ImageView imageView = (ImageView) view.findViewById(R.id.icon);
        TextView textView = (TextView) view.findViewById(R.id.f5e);
        if (this.f340016d.n(i16.f340346d)) {
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }
        Bitmap b16 = gp3.e.a().b(i16.f340349h);
        if (b16 == null) {
            imageView.setImageResource(R.drawable.f160830com);
            gp3.e.a().c(i16.f340349h, this);
        } else {
            imageView.setImageBitmap(b16);
        }
        String str2 = i16.f340348f;
        if (str2 != null && !"".equals(str2)) {
            textView.setText(i16.f340348f);
        } else {
            textView.setText(i16.f340347e);
        }
    }

    public void setActivity(FriendChooser friendChooser) {
        this.f340017e = friendChooser;
    }
}
