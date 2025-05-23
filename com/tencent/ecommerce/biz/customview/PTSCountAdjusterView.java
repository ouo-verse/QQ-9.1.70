package com.tencent.ecommerce.biz.customview;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.view.IView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes31.dex */
public class PTSCountAdjusterView extends RelativeLayout implements IView {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f101985d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f101986e;

    /* renamed from: f, reason: collision with root package name */
    private EditText f101987f;

    /* renamed from: h, reason: collision with root package name */
    private int f101988h;

    /* renamed from: i, reason: collision with root package name */
    private int f101989i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes31.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PTSCountAdjusterView.this.c("count_adjuster_event_add");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes31.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PTSCountAdjusterView.this.c("count_adjuster_event_minus");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public PTSCountAdjusterView(rh0.a aVar) {
        super(aVar.getContext());
        b(aVar.getContext());
    }

    private void b(Context context) {
        addView(LayoutInflater.from(context).inflate(R.layout.ct7, (ViewGroup) null));
        this.f101985d = (ImageView) findViewById(R.id.o8g);
        this.f101986e = (ImageView) findViewById(R.id.o8f);
        this.f101987f = (EditText) findViewById(R.id.o8e);
        this.f101985d.setOnClickListener(new a());
        this.f101986e.setOnClickListener(new b());
        this.f101987f.addTextChangedListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        setTag(str);
        performClick();
    }

    private void d(int i3) {
        this.f101987f.setText(String.valueOf(i3));
        this.f101987f.setSelection(String.valueOf(i3).length());
        this.f101986e.setActivated(i3 > this.f101989i);
        this.f101985d.setActivated(i3 + 1 <= this.f101988h);
    }

    public void e(int i3, int i16, int i17) {
        this.f101988h = i16;
        this.f101989i = i17;
        d(i3);
    }

    @Override // com.tencent.pts.ui.view.IView
    public void onBindNodeInfo(PTSNodeInfo pTSNodeInfo) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes31.dex */
    public class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            PTSCountAdjusterView.this.c("count_adjuster_event_text_change");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
