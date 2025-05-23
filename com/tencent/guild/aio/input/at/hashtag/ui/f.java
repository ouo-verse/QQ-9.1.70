package com.tencent.guild.aio.input.at.hashtag.ui;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.tencent.common.config.AppSetting;
import com.tencent.guild.aio.input.at.hashtag.ui.GuildHashtagPanelTouchController;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.VError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes6.dex */
public class f extends PopupWindow implements GuildHashtagPanelTouchController.a {
    private static int H;
    protected ViewTreeObserver.OnGlobalLayoutListener C;
    private int D;
    private boolean E;
    private boolean F;
    private final Rect G;

    /* renamed from: d, reason: collision with root package name */
    private final Activity f110918d;

    /* renamed from: e, reason: collision with root package name */
    private final i f110919e;

    /* renamed from: f, reason: collision with root package name */
    private qp0.a f110920f;

    /* renamed from: h, reason: collision with root package name */
    private View f110921h;

    /* renamed from: i, reason: collision with root package name */
    private View f110922i;

    /* renamed from: m, reason: collision with root package name */
    private GuildHashtagPanelTouchController f110923m;

    public f(Activity activity, GuildHashtagPanelTouchController guildHashtagPanelTouchController, int i3, int i16, i iVar, qp0.a aVar) {
        super(guildHashtagPanelTouchController, i3, i16);
        this.D = 1;
        this.E = false;
        this.F = true;
        this.G = new Rect();
        this.f110918d = activity;
        this.f110923m = guildHashtagPanelTouchController;
        this.f110922i = guildHashtagPanelTouchController.getChildAt(0);
        this.f110923m.setPanelScrollListener(this);
        this.f110923m.setSupportVertScrollListener(iVar);
        this.f110919e = iVar;
        this.f110923m.setTargetView(iVar.i());
        H = iVar.h().f110931a.f110943e;
        this.f110920f = aVar;
        setBackgroundDrawable(new ColorDrawable(Color.argb(104, 0, 0, 0)));
    }

    public static f f(Activity activity, int i3, int i16, boolean z16, int i17, qp0.a aVar) {
        f g16 = g(activity, i3, i16, z16, i17, aVar);
        GuildHashtagPanelTouchController guildHashtagPanelTouchController = (GuildHashtagPanelTouchController) g16.getContentView();
        h(g16);
        u(guildHashtagPanelTouchController, g16);
        if (AppSetting.f99565y) {
            t(g16);
        }
        return g16;
    }

    private static f g(Activity activity, int i3, int i16, boolean z16, int i17, qp0.a aVar) {
        i iVar;
        if (i17 == 1) {
            iVar = new a(activity);
        } else {
            iVar = new i(activity);
        }
        i iVar2 = iVar;
        iVar2.h().a(activity, z16);
        View a16 = iVar2.g().a(activity, iVar2.h());
        View q16 = q(a16);
        GuildHashtagPanelTouchController guildHashtagPanelTouchController = new GuildHashtagPanelTouchController(a16.getContext(), q16);
        guildHashtagPanelTouchController.addView(q16);
        return new f(activity, guildHashtagPanelTouchController, i3, i16, iVar2, aVar);
    }

    private static void h(f fVar) {
        Boolean bool;
        fVar.setFocusable(true);
        fVar.setInputMethodMode(0);
        fVar.setClippingEnabled(false);
        fVar.setOutsideTouchable(false);
        if (Build.VERSION.SDK_INT >= 29 && (bool = new qo0.e().f429116f) != null && bool.booleanValue()) {
            fVar.setIsLaidOutInScreen(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        i iVar;
        QLog.d("GuildHashtagDialog", 4, "onGlobalLayout");
        View view = this.f110921h;
        if (view != null && (iVar = this.f110919e) != null) {
            Rect j3 = iVar.j(view);
            if (!j3.equals(this.G)) {
                x(j3);
                QLog.d("GuildHashtagDialog", 4, "updatePanelLayout window height has change");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p(f fVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!view.equals(fVar.l()) && view.getId() != R.id.whv) {
            fVar.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private static View q(View view) {
        LinearLayout linearLayout = new LinearLayout(view.getContext());
        linearLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
        return linearLayout;
    }

    protected static void t(PopupWindow popupWindow) {
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

    private static void u(GuildHashtagPanelTouchController guildHashtagPanelTouchController, final f fVar) {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.guild.aio.input.at.hashtag.ui.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.p(f.this, view);
            }
        };
        w(guildHashtagPanelTouchController, R.id.whv, onClickListener);
        guildHashtagPanelTouchController.setOnClickListener(onClickListener);
        guildHashtagPanelTouchController.e().setOnClickListener(onClickListener);
    }

    private static void w(ViewGroup viewGroup, int i3, View.OnClickListener onClickListener) {
        View findViewById = viewGroup.findViewById(i3);
        if (findViewById != null) {
            findViewById.setOnClickListener(onClickListener);
        }
    }

    @Override // com.tencent.guild.aio.input.at.hashtag.ui.GuildHashtagPanelTouchController.a
    public void b(int i3) {
        dismiss();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        View view;
        if (this.C != null && (view = this.f110921h) != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.C);
        }
        this.f110921h = null;
        this.F = true;
        super.dismiss();
    }

    public void e() {
        if (this.D == 1) {
            this.f110919e.l(true);
            i(true);
            this.f110919e.f110954a = false;
        }
    }

    protected void i(boolean z16) {
        ViewGroup.LayoutParams layoutParams = this.f110922i.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, this.f110922i.getHeight());
        }
        layoutParams.height = this.f110919e.e(z16);
        int height = getHeight();
        i iVar = this.f110919e;
        int c16 = iVar.c(z16, iVar.d(z16, height), height);
        this.f110922i.setLayoutParams(layoutParams);
        this.f110922i.setTranslationY(c16);
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildHashtagDialog", 4, "mainViewHeight: " + layoutParams.height + " translationY: " + c16);
        }
    }

    protected void j() {
        if (this.F) {
            this.f110923m.t(0, 500);
            this.F = false;
        } else {
            this.f110923m.scrollTo(0, 0);
        }
    }

    protected void k(boolean z16) {
        if (z16 && !this.E) {
            this.E = true;
            ViewParent parent = this.f110923m.getRootView().getParent();
            try {
                try {
                    try {
                        Method declaredMethod = parent.getClass().getDeclaredMethod("doTraversal", new Class[0]);
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(parent, new Object[0]);
                    } catch (IllegalAccessException e16) {
                        QLog.e("GuildHashtagDialog", 1, "doTraversalManually | " + e16.getMessage());
                    } catch (InvocationTargetException e17) {
                        QLog.e("GuildHashtagDialog", 1, "doTraversalManually | " + e17.getMessage());
                    }
                } catch (NoSuchMethodException e18) {
                    QLog.e("GuildHashtagDialog", 1, "doTraversalManually | " + e18.getMessage());
                }
            } finally {
                this.E = false;
            }
        }
    }

    public View l() {
        return this.f110922i;
    }

    protected ViewTreeObserver.OnGlobalLayoutListener m() {
        if (this.C == null) {
            this.C = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.guild.aio.input.at.hashtag.ui.e
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    f.this.o();
                }
            };
        }
        return this.C;
    }

    public i n() {
        return this.f110919e;
    }

    protected void r(int i3) {
        boolean z16;
        boolean z17;
        boolean z18 = false;
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 != this.D) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && i3 == 2) {
            z18 = true;
        }
        i(z16);
        j();
        k(z18);
        this.D = i3;
        this.f110923m.setPanelStatus(i3);
        this.f110923m.setParams(H);
    }

    public void s() {
        GuildHashtagPanelTouchController guildHashtagPanelTouchController = this.f110923m;
        if (guildHashtagPanelTouchController != null) {
            guildHashtagPanelTouchController.scrollTo(0, VError.ERROR_STICKER_CREATE_FAIL);
        }
    }

    @Override // com.tencent.guild.aio.input.at.hashtag.ui.GuildHashtagPanelTouchController.a
    public void scrollToTop() {
        this.f110919e.k();
        qp0.a aVar = this.f110920f;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i3, int i16, int i17) {
        this.f110921h = view;
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(m());
            super.showAtLocation(view, i3, i16, i17);
        }
    }

    public void v(View view) {
        if (view == null) {
            QLog.i("GuildHashtagDialog", 1, "show error");
            return;
        }
        s();
        Rect j3 = this.f110919e.j(view);
        showAtLocation(view, 0, j3.left, j3.top);
        x(j3);
    }

    public void x(Rect rect) {
        if (this.f110921h == null) {
            return;
        }
        this.G.set(rect);
        this.f110919e.l(true);
        Rect rect2 = this.G;
        update(rect2.left, rect2.top, rect2.width(), this.G.height());
        r(this.f110919e.b(this.f110921h, getHeight()));
        this.f110919e.f110954a = false;
    }

    @Override // com.tencent.guild.aio.input.at.hashtag.ui.GuildHashtagPanelTouchController.a
    public void a(boolean z16) {
    }
}
