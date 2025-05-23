package com.tencent.open.appstore.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CommonTitleBar extends RelativeLayout {
    private d C;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f340771d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f340772e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f340773f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f340774h;

    /* renamed from: i, reason: collision with root package name */
    private ProgressBar f340775i;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f340776m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (CommonTitleBar.this.C != null) {
                CommonTitleBar.this.C.onBack();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (CommonTitleBar.this.C != null) {
                CommonTitleBar.this.C.onBack();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (CommonTitleBar.this.C != null) {
                CommonTitleBar.this.C.onSearch();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface d {
        void onBack();

        void onSearch();
    }

    public CommonTitleBar(Context context) {
        this(context, null);
    }

    private void d(Context context) {
        LayoutInflater.from(context).inflate(R.layout.f168447we, this);
        this.f340776m = (RelativeLayout) findViewById(R.id.a5p);
        ImageView imageView = (ImageView) findViewById(R.id.dbo);
        this.f340771d = imageView;
        imageView.setOnClickListener(new a());
        TextView textView = (TextView) findViewById(R.id.kez);
        this.f340772e = textView;
        textView.setOnClickListener(new b());
        this.f340773f = (TextView) findViewById(R.id.kfv);
        ImageView imageView2 = (ImageView) findViewById(R.id.dbp);
        this.f340774h = imageView2;
        imageView2.setOnClickListener(new c());
        this.f340775i = (ProgressBar) findViewById(R.id.g1o);
        e();
    }

    private void e() {
        if (QQTheme.isNowThemeIsNight()) {
            this.f340771d.setImageDrawable(getResources().getDrawable(R.drawable.n6c));
            this.f340773f.setTextColor(getResources().getColor(R.color.f158017al3));
            this.f340772e.setTextColor(getResources().getColor(R.color.f158017al3));
            this.f340776m.setBackground(getResources().getDrawable(R.color.black));
            return;
        }
        this.f340771d.setImageDrawable(getResources().getDrawable(R.drawable.d8z));
        this.f340773f.setTextColor(getResources().getColor(R.color.black));
        this.f340772e.setTextColor(getResources().getColor(R.color.black));
        this.f340776m.setBackground(getResources().getDrawable(R.color.f158017al3));
    }

    public void b() {
        this.f340775i.setVisibility(8);
    }

    public void c() {
        this.f340774h.setVisibility(8);
    }

    public void f() {
        this.f340775i.setVisibility(0);
    }

    public void setBackText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f340772e.setText(str);
        }
    }

    public void setIClickListener(d dVar) {
        this.C = dVar;
    }

    public void setTitleText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f340773f.setText(str);
        }
    }

    public CommonTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonTitleBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        d(context);
    }
}
