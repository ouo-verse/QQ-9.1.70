package com.tencent.mobileqq.browser;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.together.ui.TogetherPopupDialog;
import com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d extends PopupWindow implements View.OnClickListener, AtPanelTouchController.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private AtPanelTouchController f200544d;

    /* renamed from: e, reason: collision with root package name */
    private XListView f200545e;

    /* renamed from: f, reason: collision with root package name */
    private Button f200546f;

    /* renamed from: h, reason: collision with root package name */
    private Button f200547h;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements View.OnKeyListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            if (i3 != 4) {
                return false;
            }
            d.this.dismiss();
            return true;
        }
    }

    d(View view, int i3, int i16) {
        super(view, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public static d c(Activity activity, int i3, int i16) {
        d dVar = new d(LayoutInflater.from(activity).inflate(R.layout.gzv, (ViewGroup) null), i3, i16);
        dVar.g(dVar, activity);
        dVar.setFocusable(true);
        dVar.setInputMethodMode(1);
        dVar.setSoftInputMode(16);
        dVar.setClippingEnabled(false);
        dVar.getContentView().setOnKeyListener(new a());
        dVar.setOutsideTouchable(true);
        if (AppSetting.f99565y) {
            h(dVar);
        }
        return dVar;
    }

    private void g(d dVar, Activity activity) {
        View contentView = dVar.getContentView();
        AtPanelTouchController atPanelTouchController = (AtPanelTouchController) contentView.findViewById(R.id.content);
        this.f200544d = atPanelTouchController;
        atPanelTouchController.setDisableMinScrollY(true);
        this.f200544d.setControlLitTongue(true);
        int dpToPx = ViewUtils.dpToPx(24.0f) + TogetherPopupDialog.l(activity);
        contentView.findViewById(R.id.mb7).setOnClickListener(this);
        contentView.findViewById(R.id.yds).setBackgroundColor(contentView.getResources().getColor(R.color.skin_aio_at_white));
        XListView xListView = (XListView) contentView.findViewById(R.id.u8a);
        this.f200545e = xListView;
        xListView.setOverScrollMode(2);
        this.f200544d.setAtPanelTouchListener(dVar);
        this.f200544d.setMode(2);
        View findViewById = contentView.findViewById(R.id.tv_);
        if (findViewById != null) {
            findViewById.setVisibility(0);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), dpToPx);
        }
        this.f200546f = (Button) contentView.findViewById(R.id.smv);
        this.f200547h = (Button) contentView.findViewById(R.id.zwo);
    }

    public static void h(PopupWindow popupWindow) {
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

    @Override // com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController.a
    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController.a
    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            dismiss();
        }
    }

    public Button d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Button) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f200546f;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.dismiss();
        }
    }

    public XListView e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (XListView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f200545e;
    }

    public Button f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Button) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f200547h;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else if (view.getId() == R.id.mb7) {
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController.a
    public void scrollToTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }
}
