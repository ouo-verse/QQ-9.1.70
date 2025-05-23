package com.tencent.mobileqq.wink.publish.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.publish.widget.WinkTopBannerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkTopBannerView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private String f326093d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f326094e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f326095f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f326096h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f326097i;

    public WinkTopBannerView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.i8a, this);
        b();
    }

    private void b() {
        this.f326094e = (ImageView) findViewById(R.id.f645436i);
        this.f326095f = (TextView) findViewById(R.id.f645536j);
        this.f326096h = (TextView) findViewById(R.id.f645336h);
        TextView textView = (TextView) findViewById(R.id.f645136f);
        this.f326097i = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: q93.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkTopBannerView.this.c(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!TextUtils.isEmpty(this.f326093d) && view.getContext() != null) {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.setData(Uri.parse(this.f326093d));
            view.getContext().startActivity(intent);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setBtnSchema(String str) {
        this.f326093d = str;
    }

    public void setBtnText(String str) {
        int i3;
        this.f326097i.setText(str);
        TextView textView = this.f326097i;
        if (TextUtils.isEmpty(str)) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        textView.setVisibility(i3);
    }

    public void setContent(String str) {
        int i3;
        this.f326096h.setText(str);
        TextView textView = this.f326096h;
        if (TextUtils.isEmpty(str)) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        textView.setVisibility(i3);
    }

    public void setIcon(Drawable drawable) {
        this.f326094e.setBackgroundDrawable(drawable);
    }

    public void setTitle(String str) {
        int i3;
        this.f326095f.setText(str);
        TextView textView = this.f326095f;
        if (TextUtils.isEmpty(str)) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        textView.setVisibility(i3);
    }

    public WinkTopBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.i8a, this);
        b();
    }
}
