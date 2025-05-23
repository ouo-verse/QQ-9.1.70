package com.tencent.biz.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.common.util.j;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CustomMenuBar extends LinearLayout {
    protected boolean C;
    protected int D;
    private int E;
    Handler F;
    Runnable G;

    /* renamed from: d, reason: collision with root package name */
    protected ImageView f96962d;

    /* renamed from: e, reason: collision with root package name */
    protected LinearLayout f96963e;

    /* renamed from: f, reason: collision with root package name */
    protected List<com.tencent.biz.ui.c> f96964f;

    /* renamed from: h, reason: collision with root package name */
    protected e f96965h;

    /* renamed from: i, reason: collision with root package name */
    protected com.tencent.biz.ui.d f96966i;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f96967m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements PopupWindow.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f96968d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TextView f96969e;

        a(ImageView imageView, TextView textView) {
            this.f96968d = imageView;
            this.f96969e = textView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            this.f96968d.setImageResource(R.drawable.k_v);
            this.f96969e.setTextColor(CustomMenuBar.this.getResources().getColorStateList(R.color.c_g, null));
            CustomMenuBar customMenuBar = CustomMenuBar.this;
            customMenuBar.f96967m = false;
            customMenuBar.C = true;
            customMenuBar.F.removeCallbacks(customMenuBar.G);
            CustomMenuBar customMenuBar2 = CustomMenuBar.this;
            customMenuBar2.F.postDelayed(customMenuBar2.G, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f96971d;

        b(ImageView imageView) {
            this.f96971d = imageView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                CustomMenuBar customMenuBar = CustomMenuBar.this;
                if (customMenuBar.C) {
                    customMenuBar.F.removeCallbacks(customMenuBar.G);
                    this.f96971d.setImageResource(R.drawable.k_v);
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f96973d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TextView f96974e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ PopupMenu f96975f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f96976h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f96977i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f96978m;

        c(ImageView imageView, TextView textView, PopupMenu popupMenu, String str, int i3, String str2) {
            this.f96973d = imageView;
            this.f96974e = textView;
            this.f96975f = popupMenu;
            this.f96976h = str;
            this.f96977i = i3;
            this.f96978m = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            synchronized (this) {
                CustomMenuBar customMenuBar = CustomMenuBar.this;
                com.tencent.biz.ui.d dVar = customMenuBar.f96966i;
                if (dVar == null) {
                    if (!customMenuBar.f96967m) {
                        customMenuBar.f96967m = true;
                        this.f96973d.setImageResource(R.drawable.k_u);
                        this.f96974e.setTextColor(CustomMenuBar.this.getResources().getColor(R.color.qui_common_icon_aio_toolbar_active, null));
                        CustomMenuBar customMenuBar2 = CustomMenuBar.this;
                        customMenuBar2.C = false;
                        customMenuBar2.F.removeCallbacks(customMenuBar2.G);
                        this.f96975f.i(view);
                        CustomMenuBar.this.f96966i = this.f96975f;
                        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, this.f96976h, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(1), String.valueOf(this.f96977i), this.f96978m, String.valueOf(0), false);
                    }
                } else if (dVar == this.f96975f) {
                    if (!customMenuBar.C) {
                        if (!customMenuBar.f96967m) {
                            customMenuBar.f96967m = true;
                            this.f96973d.setImageResource(R.drawable.k_u);
                            this.f96974e.setTextColor(CustomMenuBar.this.getResources().getColor(R.color.qui_common_icon_aio_toolbar_active, null));
                            CustomMenuBar customMenuBar3 = CustomMenuBar.this;
                            customMenuBar3.C = false;
                            customMenuBar3.F.removeCallbacks(customMenuBar3.G);
                            this.f96975f.i(view);
                            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, this.f96976h, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(1), String.valueOf(this.f96977i), this.f96978m, String.valueOf(0), false);
                        }
                    } else {
                        customMenuBar.C = false;
                    }
                } else if (!customMenuBar.f96967m) {
                    customMenuBar.f96967m = true;
                    this.f96973d.setImageResource(R.drawable.k_u);
                    this.f96974e.setTextColor(CustomMenuBar.this.getResources().getColor(R.color.qui_common_icon_aio_toolbar_active, null));
                    CustomMenuBar customMenuBar4 = CustomMenuBar.this;
                    customMenuBar4.C = false;
                    customMenuBar4.F.removeCallbacks(customMenuBar4.G);
                    this.f96975f.i(view);
                    CustomMenuBar.this.f96966i = this.f96975f;
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, this.f96976h, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(1), String.valueOf(this.f96977i), this.f96978m, String.valueOf(0), false);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f96979d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f96980e;

        d(String str, int i3) {
            this.f96979d = str;
            this.f96980e = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            e eVar = CustomMenuBar.this.f96965h;
            if (eVar != null) {
                eVar.a(this.f96979d, this.f96980e, 1);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface e {
        void a(String str, int i3, int i16);
    }

    @SuppressLint({"NewApi"})
    public CustomMenuBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f96964f = new ArrayList();
        this.f96966i = null;
        this.f96967m = false;
        this.C = false;
        this.D = 0;
        this.F = new Handler(Looper.getMainLooper());
        this.G = new Runnable() { // from class: com.tencent.biz.ui.CustomMenuBar.5
            @Override // java.lang.Runnable
            public void run() {
                CustomMenuBar.this.C = false;
            }
        };
        super.setFocusable(true);
        super.setOrientation(0);
        super.setGravity(16);
        ImageView imageView = new ImageView(context);
        this.f96962d = imageView;
        imageView.setImageResource(R.drawable.skin_aio_keyboard_arrow_normal);
        this.f96962d.setClickable(true);
        this.f96962d.setContentDescription(context.getText(R.string.dyt));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = x.c(context, 7.0f);
        layoutParams.gravity = 16;
        this.f96962d.setLayoutParams(layoutParams);
        super.addView(this.f96962d);
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.f167937nh, (ViewGroup) null);
        horizontalScrollView.setOverScrollMode(2);
        horizontalScrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        super.addView(horizontalScrollView);
        LinearLayout linearLayout = (LinearLayout) horizontalScrollView.findViewById(R.id.cb5);
        this.f96963e = linearLayout;
        linearLayout.setGravity(16);
    }

    public void a(com.tencent.biz.ui.c cVar, String str) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0f);
        layoutParams.gravity = 17;
        View d16 = d(cVar, str);
        this.f96964f.add(cVar);
        d16.setFocusable(true);
        d16.setClickable(true);
        d16.setLayoutParams(layoutParams);
        this.f96963e.addView(d16);
    }

    public void b(List<com.tencent.biz.ui.c> list, String str) {
        Iterator<com.tencent.biz.ui.c> it = list.iterator();
        while (it.hasNext()) {
            a(it.next(), str);
        }
    }

    public void c() {
        this.E = 0;
        this.f96963e.removeAllViews();
        this.f96964f.clear();
    }

    View d(com.tencent.biz.ui.c cVar, String str) {
        String i3 = cVar.i();
        Drawable b16 = cVar.b();
        View inflate = ((LayoutInflater) super.getContext().getSystemService("layout_inflater")).inflate(R.layout.f167938ni, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.eq5);
        TextView textView = (TextView) inflate.findViewById(R.id.eqi);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.j6m);
        if (b16 != null) {
            imageView.setImageDrawable(b16);
        } else {
            imageView.setVisibility(8);
        }
        if (i3 != null) {
            if (j.c(i3) > 10) {
                textView.setText(j.a(i3, 10, MiniBoxNoticeInfo.APPNAME_SUFFIX));
            } else {
                textView.setText(i3);
            }
        } else {
            textView.setVisibility(8);
        }
        String d16 = cVar.d();
        int e16 = cVar.e();
        if (cVar.j()) {
            imageView2.setVisibility(0);
            imageView2.setImageResource(R.drawable.k_v);
            PopupMenu popupMenu = new PopupMenu(super.getContext());
            for (int i16 = 0; i16 < cVar.g(); i16++) {
                popupMenu.e(cVar.f(i16));
            }
            popupMenu.d(new a(imageView2, textView));
            popupMenu.g(this.f96965h);
            inflate.setOnTouchListener(new b(imageView2));
            inflate.setOnClickListener(new c(imageView2, textView, popupMenu, str, e16, i3));
        } else {
            inflate.setOnClickListener(new d(d16, e16));
        }
        int i17 = this.E;
        this.E = i17 + 1;
        if (i17 == 0) {
            inflate.findViewById(R.id.eqp).setVisibility(8);
        }
        return inflate;
    }

    public void e() {
        com.tencent.biz.ui.d dVar = this.f96966i;
        if (dVar == null) {
            return;
        }
        dVar.a();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        com.tencent.biz.ui.d dVar = this.f96966i;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void setMenuType(int i3) {
        this.D = i3;
    }

    public void setOnBackClickListner(View.OnClickListener onClickListener) {
        this.f96962d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.f96965h = eVar;
    }

    public void setSwitchIconDrawable(Drawable drawable) {
        this.f96962d.setImageDrawable(drawable);
    }

    public void setCoverView(View view) {
    }

    public CustomMenuBar(Context context) {
        this(context, null);
    }
}
