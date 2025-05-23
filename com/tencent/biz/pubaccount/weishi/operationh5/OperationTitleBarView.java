package com.tencent.biz.pubaccount.weishi.operationh5;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class OperationTitleBarView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f81008d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f81009e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f81010f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f81011h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f81012i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f81013m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f81014d;

        a(d dVar) {
            this.f81014d = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f81014d.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f81016d;

        b(d dVar) {
            this.f81016d = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f81016d.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f81018d;

        c(d dVar) {
            this.f81018d = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f81018d.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    interface d {
        void a();

        void b();
    }

    public OperationTitleBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    private void b() {
        this.f81009e = (ImageView) this.f81008d.findViewById(R.id.p56);
        this.f81010f = (ImageView) this.f81008d.findViewById(R.id.p58);
        this.f81011h = (TextView) this.f81008d.findViewById(R.id.p59);
        this.f81012i = (ImageView) this.f81008d.findViewById(R.id.p57);
    }

    private float c() {
        float R = Utils.R(ViewUtils.getStatusBarHeight(getContext()), getResources());
        if (R == 0.0f) {
            R = 25.0f;
        }
        return R + 48.0f;
    }

    private void d() {
        this.f81008d = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.f167390d23, (ViewGroup) this, false);
        addView(this.f81008d, new FrameLayout.LayoutParams(-1, Utils.n(c(), getResources())));
        b();
    }

    public void setOperationTitleClickListener(d dVar) {
        this.f81010f.setOnClickListener(new a(dVar));
        this.f81011h.setOnClickListener(new b(dVar));
        this.f81012i.setOnClickListener(new c(dVar));
    }

    public OperationTitleBarView(Context context) {
        super(context);
        d();
    }

    public void a(int i3) {
        float n3 = Utils.n(100.0f, getResources());
        float f16 = i3;
        if (f16 < n3) {
            this.f81009e.setAlpha(f16 / n3);
            if (this.f81013m) {
                this.f81010f.setImageResource(R.drawable.gm7);
                this.f81011h.setTextColor(getResources().getColor(R.color.f7684x));
                this.f81012i.setImageResource(R.drawable.f159770gj2);
                this.f81013m = false;
                return;
            }
            return;
        }
        if (this.f81013m) {
            return;
        }
        this.f81009e.setAlpha(1.0f);
        this.f81010f.setImageResource(R.drawable.gmg);
        this.f81011h.setTextColor(getResources().getColor(R.color.f7594o));
        this.f81012i.setImageResource(R.drawable.gjs);
        this.f81013m = true;
    }
}
