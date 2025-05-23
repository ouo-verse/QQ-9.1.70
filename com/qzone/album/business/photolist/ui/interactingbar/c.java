package com.qzone.album.business.photolist.ui.interactingbar;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.album.business.photolist.controller.BasePhotoModelController;
import com.qzone.album.business.photolist.ui.interactingbar.a;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c extends com.qzone.album.business.photolist.ui.interactingbar.b {

    /* renamed from: f, reason: collision with root package name */
    public TextView f43581f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f43582g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f43583h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f43584i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f43585j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView f43586k;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f43587l;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.InterfaceC0344a interfaceC0344a = c.this.f43580d;
            if (interfaceC0344a != null) {
                interfaceC0344a.a(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.InterfaceC0344a interfaceC0344a = c.this.f43580d;
            if (interfaceC0344a != null) {
                interfaceC0344a.d(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.album.business.photolist.ui.interactingbar.c$c, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class ViewOnClickListenerC0345c implements View.OnClickListener {
        ViewOnClickListenerC0345c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.InterfaceC0344a interfaceC0344a = c.this.f43580d;
            if (interfaceC0344a != null) {
                interfaceC0344a.d(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.InterfaceC0344a interfaceC0344a = c.this.f43580d;
            if (interfaceC0344a != null) {
                interfaceC0344a.e(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.InterfaceC0344a interfaceC0344a = c.this.f43580d;
            if (interfaceC0344a != null) {
                interfaceC0344a.e(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.InterfaceC0344a interfaceC0344a = c.this.f43580d;
            if (interfaceC0344a != null) {
                interfaceC0344a.b(view, true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.InterfaceC0344a interfaceC0344a = c.this.f43580d;
            if (interfaceC0344a != null) {
                interfaceC0344a.g(view, true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public c(Activity activity, BasePhotoModelController basePhotoModelController, a.InterfaceC0344a interfaceC0344a) {
        super(activity, basePhotoModelController, interfaceC0344a);
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public int a() {
        return 0;
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public ImageView b() {
        return this.f43583h;
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public void d() {
        Activity activity = this.f43578b;
        if (activity == null || this.f43579c == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) activity.findViewById(R.id.e4s);
        this.f43577a = linearLayout;
        if (linearLayout == null) {
            return;
        }
        TextView textView = (TextView) this.f43578b.findViewById(R.id.foz);
        this.f43581f = textView;
        textView.setOnClickListener(new a());
        TextView textView2 = (TextView) this.f43578b.findViewById(R.id.f166724hn1);
        this.f43582g = textView2;
        textView2.setOnClickListener(new b());
        ImageView imageView = (ImageView) this.f43578b.findViewById(R.id.f166506fp0);
        this.f43583h = imageView;
        imageView.setOnClickListener(new ViewOnClickListenerC0345c());
        TextView textView3 = (TextView) this.f43578b.findViewById(R.id.hmz);
        this.f43584i = textView3;
        textView3.setOnClickListener(new d());
        ImageView imageView2 = (ImageView) this.f43578b.findViewById(R.id.fow);
        this.f43585j = imageView2;
        imageView2.setOnClickListener(new e());
        ImageView imageView3 = (ImageView) this.f43578b.findViewById(R.id.fox);
        this.f43586k = imageView3;
        imageView3.setOnClickListener(new f());
        ImageView imageView4 = (ImageView) this.f43578b.findViewById(R.id.hcb);
        this.f43587l = imageView4;
        imageView4.setOnClickListener(new g());
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public boolean e() {
        return false;
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public void g(int i3) {
        TextView textView;
        if (this.f43577a == null || (textView = this.f43584i) == null) {
            return;
        }
        if (i3 <= 0) {
            textView.setText("");
        } else if (i3 <= 99) {
            textView.setText(Integer.toString(i3));
        } else {
            textView.setText("99+");
        }
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public void h(boolean z16, int i3) {
        ImageView imageView;
        if (this.f43577a == null || (imageView = this.f43583h) == null || this.f43582g == null) {
            return;
        }
        imageView.setSelected(z16);
        if (i3 <= 0) {
            this.f43582g.setText("");
        } else if (i3 <= 99) {
            this.f43582g.setText(Integer.toString(i3));
        } else {
            this.f43582g.setText("99+");
        }
    }

    @Override // com.qzone.album.business.photolist.ui.interactingbar.b
    public void f() {
    }
}
