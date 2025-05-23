package com.tencent.mobileqq.guild.feed.partpanel.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.partpanel.ui.GuildPartPanelTouchController;
import com.tencent.mobileqq.guild.feed.partpanel.ui.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.VError;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes13.dex */
public class e extends PopupWindow implements GuildPartPanelTouchController.a {
    private static int H;
    protected PopupWindow.OnDismissListener C;
    private int D;
    private boolean E;
    private boolean F;
    private final Rect G;

    /* renamed from: d, reason: collision with root package name */
    private final d f222685d;

    /* renamed from: e, reason: collision with root package name */
    private final qp0.a f222686e;

    /* renamed from: f, reason: collision with root package name */
    private View f222687f;

    /* renamed from: h, reason: collision with root package name */
    private final View f222688h;

    /* renamed from: i, reason: collision with root package name */
    private final GuildPartPanelTouchController f222689i;

    /* renamed from: m, reason: collision with root package name */
    protected ViewTreeObserver.OnGlobalLayoutListener f222690m;

    public e(GuildPartPanelTouchController guildPartPanelTouchController, int i3, int i16, d dVar, qp0.a aVar) {
        super(guildPartPanelTouchController, i3, i16);
        this.D = 1;
        this.E = false;
        this.F = true;
        this.G = new Rect();
        this.f222689i = guildPartPanelTouchController;
        this.f222688h = guildPartPanelTouchController.getChildAt(0);
        guildPartPanelTouchController.setPanelScrollListener(this);
        guildPartPanelTouchController.setSupportVertScrollListener(dVar);
        this.f222685d = dVar;
        guildPartPanelTouchController.setTargetView(dVar.i());
        H = dVar.h().f222654a.f222664c;
        this.f222686e = aVar;
        setBackgroundDrawable(new ColorDrawable(Color.argb(104, 0, 0, 0)));
    }

    public static e f(Context context, int i3, int i16, boolean z16, qp0.a aVar) {
        e g16 = g(context, i3, i16, z16, aVar);
        GuildPartPanelTouchController guildPartPanelTouchController = (GuildPartPanelTouchController) g16.getContentView();
        h(g16);
        t(guildPartPanelTouchController, g16);
        if (AppSetting.f99565y) {
            s(g16);
        }
        return g16;
    }

    private static e g(Context context, int i3, int i16, boolean z16, qp0.a aVar) {
        d dVar = new d(context);
        dVar.h().a(context, z16);
        View a16 = dVar.g().a(context, dVar.h());
        View p16 = p(a16);
        GuildPartPanelTouchController guildPartPanelTouchController = new GuildPartPanelTouchController(a16.getContext(), p16);
        guildPartPanelTouchController.addView(p16);
        return new e(guildPartPanelTouchController, i3, i16, dVar, aVar);
    }

    private static void h(e eVar) {
        Boolean bool;
        eVar.setFocusable(false);
        eVar.setInputMethodMode(32);
        eVar.setInputMethodMode(1);
        eVar.setClippingEnabled(false);
        eVar.setOutsideTouchable(false);
        if (Build.VERSION.SDK_INT >= 29 && (bool = new qo0.e().f429116f) != null && bool.booleanValue()) {
            eVar.setIsLaidOutInScreen(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        d dVar;
        QLog.d("GuildPartSelectionDialog", 4, "onGlobalLayout");
        View view = this.f222687f;
        if (view != null && (dVar = this.f222685d) != null) {
            Rect j3 = dVar.j(view);
            if (!j3.equals(this.G)) {
                w(j3);
                QLog.d("GuildPartSelectionDialog", 4, "updatePanelLayout window height has change");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o(e eVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!view.equals(eVar.k()) && view.getId() != R.id.whv) {
            eVar.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private static View p(View view) {
        LinearLayout linearLayout = new LinearLayout(view.getContext());
        linearLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
        return linearLayout;
    }

    protected static void s(PopupWindow popupWindow) {
        if (!AppSetting.f99565y) {
            return;
        }
        for (Method method : PopupWindow.class.getMethods()) {
            if (method.getName().equals("setTouchModal")) {
                try {
                    method.invoke(popupWindow, Boolean.FALSE);
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
        }
    }

    private static void t(GuildPartPanelTouchController guildPartPanelTouchController, final e eVar) {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: bn1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.o(e.this, view);
            }
        };
        v(guildPartPanelTouchController, R.id.whv, onClickListener);
        guildPartPanelTouchController.setOnClickListener(onClickListener);
        guildPartPanelTouchController.e().setOnClickListener(onClickListener);
    }

    private static void v(ViewGroup viewGroup, int i3, View.OnClickListener onClickListener) {
        View findViewById = viewGroup.findViewById(i3);
        if (findViewById != null) {
            findViewById.setOnClickListener(onClickListener);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.partpanel.ui.GuildPartPanelTouchController.a
    public void b(int i3) {
        dismiss();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        View view;
        if (this.f222690m != null && (view = this.f222687f) != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f222690m);
        }
        this.f222687f = null;
        this.F = true;
        if (isShowing()) {
            super.dismiss();
            return;
        }
        PopupWindow.OnDismissListener onDismissListener = this.C;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void e() {
        if (this.D == 1) {
            this.f222685d.l(true);
            i(true);
            this.f222685d.f222676a = false;
        }
    }

    protected void i(boolean z16) {
        ViewGroup.LayoutParams layoutParams = this.f222688h.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, this.f222688h.getHeight());
        }
        layoutParams.height = this.f222685d.e(z16);
        int height = getHeight();
        d dVar = this.f222685d;
        int c16 = dVar.c(z16, dVar.d(z16, height), height);
        this.f222688h.setLayoutParams(layoutParams);
        this.f222688h.setTranslationY(c16);
        QLog.i("GuildPartSelectionDialog", 1, "mainViewHeight: " + layoutParams.height + " translationY: " + c16 + " windowHeight=" + height + " isHalfStatus=" + z16);
    }

    protected void j() {
        if (this.F) {
            this.f222689i.t(0, 500);
            this.F = false;
        } else {
            this.f222689i.scrollTo(0, 0);
        }
    }

    public View k() {
        return this.f222688h;
    }

    protected ViewTreeObserver.OnGlobalLayoutListener l() {
        if (this.f222690m == null) {
            this.f222690m = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: bn1.b
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    e.this.n();
                }
            };
        }
        return this.f222690m;
    }

    public d m() {
        return this.f222685d;
    }

    protected void q(int i3) {
        boolean z16;
        boolean z17 = false;
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 != this.D) {
            z17 = true;
        }
        if (z17) {
        }
        i(z16);
        j();
        this.D = i3;
        this.f222689i.setPanelStatus(i3);
        this.f222689i.setParams(H);
    }

    public void r() {
        GuildPartPanelTouchController guildPartPanelTouchController = this.f222689i;
        if (guildPartPanelTouchController != null) {
            guildPartPanelTouchController.scrollTo(0, VError.ERROR_STICKER_CREATE_FAIL);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.partpanel.ui.GuildPartPanelTouchController.a
    public void scrollToTop() {
        this.f222685d.k();
        qp0.a aVar = this.f222686e;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.widget.PopupWindow
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.C = onDismissListener;
        super.setOnDismissListener(onDismissListener);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i3, int i16, int i17) {
        this.f222687f = view;
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(l());
            super.showAtLocation(view, i3, i16, i17);
        }
    }

    public void u(View view) {
        if (view == null) {
            return;
        }
        r();
        Rect j3 = this.f222685d.j(view);
        showAtLocation(view, 0, j3.left, j3.top);
        w(j3);
    }

    public void w(Rect rect) {
        if (this.f222687f == null) {
            return;
        }
        this.G.set(rect);
        this.f222685d.l(true);
        Rect rect2 = this.G;
        update(rect2.left, rect2.top, rect2.width(), this.G.height());
        q(this.f222685d.b(this.f222687f, getHeight()));
        this.f222685d.f222676a = false;
    }

    @Override // com.tencent.mobileqq.guild.feed.partpanel.ui.GuildPartPanelTouchController.a
    public void a(boolean z16) {
    }
}
