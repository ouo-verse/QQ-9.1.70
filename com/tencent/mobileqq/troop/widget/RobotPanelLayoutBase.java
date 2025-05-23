package com.tencent.mobileqq.troop.widget;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

/* loaded from: classes19.dex */
public class RobotPanelLayoutBase extends RDBaseListLayout<b, a> implements View.OnClickListener, ITroopRobotService.b {
    static IPatchRedirector $redirector_;
    protected String C;
    protected String D;
    protected int E;
    private WeakReference<d> F;
    protected ITroopRobotService G;

    /* renamed from: m, reason: collision with root package name */
    protected String f302398m;

    /* loaded from: classes19.dex */
    public static class a extends d61.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        public View f302399b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f302400c;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* loaded from: classes19.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public c f302401a;

        /* renamed from: b, reason: collision with root package name */
        public c f302402b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f302403c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f302404d;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static b a(String str, String str2, String str3, String str4) {
            b bVar = new b();
            bVar.f302401a = c.a(str4, str3);
            bVar.f302402b = c.a(str2, str);
            bVar.f302403c = false;
            return bVar;
        }

        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return !TextUtils.isEmpty(this.f302402b.f302405a);
        }
    }

    /* loaded from: classes19.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f302405a;

        /* renamed from: b, reason: collision with root package name */
        public String f302406b;

        /* renamed from: c, reason: collision with root package name */
        public String f302407c;

        /* renamed from: d, reason: collision with root package name */
        public int f302408d;

        /* renamed from: e, reason: collision with root package name */
        public int f302409e;

        /* renamed from: f, reason: collision with root package name */
        public int f302410f;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f302405a = "";
            this.f302406b = "";
            this.f302407c = "";
            this.f302408d = -1;
            this.f302409e = -16777216;
            this.f302410f = -7829368;
        }

        public static c a(String str, String str2) {
            c cVar = new c();
            cVar.f302405a = str;
            cVar.f302406b = "";
            cVar.f302407c = str2;
            try {
                cVar.f302408d = 0;
                cVar.f302409e = 0;
                cVar.f302410f = 0;
            } catch (Exception unused) {
            }
            return cVar;
        }
    }

    /* loaded from: classes19.dex */
    public interface d {
        void a(String str);
    }

    public RobotPanelLayoutBase(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        this.E = 0;
        this.F = null;
        k(1);
    }

    public static ITroopRobotService s() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            return (ITroopRobotService) ((QQAppInterface) runtime).getRuntimeService(ITroopRobotService.class, "all");
        }
        return null;
    }

    public void A(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) bVar);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(int i3, b bVar, a aVar) {
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), bVar, aVar);
            return;
        }
        if (bVar.b()) {
            ITroopRobotService s16 = s();
            if (s16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("RobotPanelLayoutBase", 2, "troopRobotManager = null");
                    return;
                }
                return;
            }
            bVar.f302404d = s16.isTalking();
        }
        if (bVar.f302404d) {
            cVar = bVar.f302402b;
        } else {
            cVar = bVar.f302401a;
        }
        aVar.f302400c.setText(cVar.f302405a);
        D(aVar);
    }

    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            q();
        }
    }

    protected void D(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) aVar);
            return;
        }
        int c16 = x.c(getContext(), 0.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(x.c(getContext(), 20.0f));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(x.c(getContext(), 20.0f));
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
            aVar.f302400c.setTextColor(Color.parseColor("#737373"));
            gradientDrawable.setColor(Color.parseColor("#1F1F1F"));
            gradientDrawable.setStroke(c16, Color.parseColor("#1F1F1F"));
            gradientDrawable2.setColor(Color.parseColor("#1F1F1F"));
            gradientDrawable2.setColorFilter(Color.argb(126, 0, 0, 0), PorterDuff.Mode.DARKEN);
            gradientDrawable2.setStroke(c16, Color.parseColor("#1F1F1F"));
        } else {
            aVar.f302400c.setTextColor(Color.parseColor("#03081A"));
            gradientDrawable.setColor(Color.parseColor("#FFFFFF"));
            gradientDrawable.setStroke(c16, Color.parseColor("#D4D8E7"));
            gradientDrawable2.setColor(Color.parseColor("#FFFFFF"));
            gradientDrawable2.setColorFilter(Color.argb(13, 0, 0, 0), PorterDuff.Mode.DARKEN);
            gradientDrawable2.setStroke(c16, Color.parseColor("#D4D8E7"));
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        aVar.f302399b.setBackgroundDrawable(stateListDrawable);
    }

    @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService.b
    public void a(String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, Boolean.valueOf(z16));
        } else {
            C();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout
    public boolean m() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        t();
        setOverScrollMode(0);
        try {
            if (ThemeUtil.isNowThemeIsDefault(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
                i3 = com.tencent.mobileqq.R.drawable.skin_aio_input_bar_bg_theme_version2;
            } else {
                i3 = com.tencent.mobileqq.R.drawable.skin_chat_bottom_quickbar_bg;
            }
            setBackgroundResource(i3);
            return true;
        } catch (Exception unused) {
            QLog.e("RobotPanelLayoutBase", 2, "onInit setBackgroundResource exception");
            return true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) view);
        } else {
            b g16 = g(h(view));
            if (g16 != null) {
                String str = g16.f302401a.f302405a;
                v(g16, str);
                if (!TextUtils.isEmpty(g16.f302402b.f302405a)) {
                    str = w(g16);
                } else if (g16.f302401a.f302407c.startsWith("inputKeyOp://sendToRobot")) {
                    A(g16);
                } else if (g16.f302401a.f302407c.startsWith("inputKeyOp://sendToBackEnd")) {
                    z(g16);
                } else if (g16.f302401a.f302407c.startsWith("http")) {
                    Intent intent = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", g16.f302401a.f302407c);
                    getContext().startActivity(intent);
                }
                u(g16, str);
                r(str);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    protected void r(String str) {
        d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        WeakReference<d> weakReference = this.F;
        if (weakReference != null && (dVar = weakReference.get()) != null) {
            dVar.a(str);
        }
    }

    public void setInputLineCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
        } else {
            this.E = i3;
        }
    }

    public void setListener(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
        } else if (dVar == null) {
            this.F = null;
        } else {
            this.F = new WeakReference<>(dVar);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        super.setVisibility(i3);
        if (i3 != 0) {
            p(false);
            this.f302398m = null;
            this.C = null;
            this.D = null;
        }
        if (QLog.isColorLevel()) {
            QLog.e("RobotPanelLayoutBase", 2, "setVisibility:" + i3);
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        ITroopRobotService s16 = s();
        this.G = s16;
        if (s16 != null) {
            s16.setOnTalkingChangeListener(this);
        } else if (QLog.isColorLevel()) {
            QLog.e("RobotPanelLayoutBase", 2, "mTroopRobotServive = null");
        }
    }

    public void u(b bVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) bVar, (Object) str);
        }
    }

    public void v(b bVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) bVar, (Object) str);
        }
    }

    public String w(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this, (Object) bVar);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public a l(int i3, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (a) iPatchRedirector.redirect((short) 23, (Object) this, i3, (Object) bVar);
        }
        a aVar = new a();
        View inflate = LayoutInflater.from(getContext()).inflate(com.tencent.mobileqq.R.layout.ajw, (ViewGroup) null, false);
        inflate.setOnClickListener(this);
        aVar.b(inflate);
        aVar.f302399b = inflate.findViewById(com.tencent.mobileqq.R.id.dpr);
        aVar.f302400c = (TextView) inflate.findViewById(com.tencent.mobileqq.R.id.textView1);
        inflate.setTag(aVar);
        return aVar;
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void n(int i3, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3, (Object) bVar);
        }
    }

    public void z(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) bVar);
        }
    }

    public RobotPanelLayoutBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.E = 0;
        this.F = null;
        k(1);
    }

    public RobotPanelLayoutBase(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.E = 0;
        this.F = null;
        k(1);
    }
}
