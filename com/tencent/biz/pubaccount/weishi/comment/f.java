package com.tencent.biz.pubaccount.weishi.comment;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.view.WSDragLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.widget.immersive.SystemBarTintManager;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f extends PopupWindow implements View.OnClickListener, WSDragLayout.c, View.OnKeyListener {

    /* renamed from: d, reason: collision with root package name */
    private WSDragLayout f80574d;

    /* renamed from: e, reason: collision with root package name */
    private View f80575e;

    /* renamed from: f, reason: collision with root package name */
    private Activity f80576f;

    /* renamed from: h, reason: collision with root package name */
    ListView f80577h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.dismiss();
        }
    }

    f(Activity activity, int i3, int i16) {
        super(LayoutInflater.from(activity).inflate(R.layout.fvp, (ViewGroup) null), i3, i16);
        this.f80576f = activity;
        setAnimationStyle(R.style.att);
        f();
        setFocusable(true);
        setInputMethodMode(1);
        setSoftInputMode(48);
        setClippingEnabled(false);
        getContentView().setOnKeyListener(this);
        setOutsideTouchable(true);
    }

    public static f c(Activity activity, int i3, int i16) {
        return new f(activity, i3, i16);
    }

    private void f() {
        View contentView = getContentView();
        contentView.findViewById(R.id.root_layout).setOnClickListener(new a());
        WSDragLayout wSDragLayout = (WSDragLayout) contentView.findViewById(R.id.content);
        this.f80574d = wSDragLayout;
        wSDragLayout.setDisableMinScrollY(true);
        this.f80574d.setControlLitTongue(false);
        View findViewById = contentView.findViewById(R.id.b3r);
        this.f80575e = findViewById;
        ListView listView = (ListView) findViewById.findViewById(R.id.c4v);
        this.f80577h = listView;
        this.f80574d.setContentView(listView);
        this.f80574d.setTouchListener(this);
        this.f80574d.setMode(1);
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
    public void b(int i3) {
        dismiss();
    }

    public View d() {
        return this.f80575e;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Throwable th5) {
            x.f("DraggablePopup", th5.getLocalizedMessage());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
    public void e(float f16) {
        x.i("DraggablePopup", "progress = " + f16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
    public boolean g() {
        return false;
    }

    public void h() {
        WSDragLayout wSDragLayout = this.f80574d;
        if (wSDragLayout != null) {
            wSDragLayout.n(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.mb7) {
            dismiss();
        }
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i3, int i16, int i17) {
        Activity activity = this.f80576f;
        if (activity == null || !activity.isFinishing()) {
            if (SystemBarTintManager.hasNavBar(this.f80576f) && ScreenUtil.isNavigationBarExist(this.f80576f)) {
                i17 += ScreenUtil.getNavigationBarHeight(this.f80576f);
            }
            try {
                super.showAtLocation(view, i3, i16, i17);
            } catch (Throwable th5) {
                x.f("DraggablePopup", th5.getLocalizedMessage());
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i3, KeyEvent keyEvent) {
        if (i3 != 4) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
    public void scrollToTop() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
    public void a(boolean z16) {
    }
}
