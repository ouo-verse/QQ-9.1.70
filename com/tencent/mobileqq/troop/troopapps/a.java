package com.tencent.mobileqq.troop.troopapps;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarHandler;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarInfo;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.r;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends com.tencent.mobileqq.troop.troopapps.b implements CompoundButton.OnCheckedChangeListener {
    static IPatchRedirector $redirector_;
    protected C8785a F;
    private long G;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.troopapps.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C8785a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f299352a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f299353b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f299354c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f299355d;

        /* renamed from: e, reason: collision with root package name */
        public TroopShortcutBarInfo f299356e;

        public C8785a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f299352a = false;
            this.f299353b = false;
            this.f299354c = false;
            this.f299355d = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public View f299357a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f299358b;

        /* renamed from: c, reason: collision with root package name */
        public CheckBox f299359c;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, Activity activity, TroopAppShortcutContainer troopAppShortcutContainer, Bundle bundle) {
        super(context, activity, troopAppShortcutContainer, bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, activity, troopAppShortcutContainer, bundle);
        } else {
            this.G = 0L;
        }
    }

    private String g() {
        return "troopapp_aio_shortcut_bar_guide" + TroopUtils.f().getCurrentAccountUin();
    }

    private boolean h() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f299406i);
        boolean z16 = defaultSharedPreferences.getBoolean(g(), true);
        if (QLog.isColorLevel()) {
            QLog.d("AppsAioShortCutViewBuilder", 2, String.format("needShow guide: %s", String.valueOf(z16)));
        }
        if (z16) {
            SharedPreferences.Editor edit = defaultSharedPreferences.edit();
            edit.putBoolean(g(), false);
            edit.apply();
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.b
    public Object c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.F;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.b
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.b
    public View e(int i3, View view, ViewGroup viewGroup) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), view, viewGroup);
        }
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.f299406i).inflate(R.layout.f168549fv4, viewGroup, false);
            bVar.f299358b = (TextView) view.findViewById(R.id.e85);
            bVar.f299359c = (CheckBox) view.findViewById(R.id.j95);
            bVar.f299357a = view.findViewById(R.id.m_b);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        C8785a c8785a = this.F;
        if (c8785a.f299353b) {
            if (c8785a.f299354c) {
                bVar.f299357a.setVisibility(0);
            } else {
                bVar.f299357a.setVisibility(8);
            }
        } else if (c8785a.f299355d && c8785a.f299356e.getGroupDisabled() == 0) {
            bVar.f299357a.setVisibility(0);
        } else {
            bVar.f299357a.setVisibility(8);
        }
        if (AppSetting.f99565y) {
            bVar.f299357a.setContentDescription(this.f299406i.getString(R.string.f2324274i));
        }
        int i16 = (int) ((this.f299406i.getResources().getDisplayMetrics().density * 5.0f) + 0.5f);
        BaseAIOUtils.h(bVar.f299359c, i16, i16, i16, i16);
        bVar.f299359c.setChecked(this.F.f299352a);
        bVar.f299359c.setOnCheckedChangeListener(this);
        return view;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.b
    public void f(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, obj);
        } else if (obj instanceof C8785a) {
            this.F = (C8785a) obj;
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        TroopAppShortcutContainer troopAppShortcutContainer;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, compoundButton, Boolean.valueOf(z16));
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.G;
            if ((currentTimeMillis - j3 > 0 && currentTimeMillis - j3 < 800) || !compoundButton.isPressed()) {
                if (QLog.isColorLevel()) {
                    QLog.e("AppsAioShortCutViewBuilder", 2, "onSetTotalSwitch Click is Fire");
                }
            } else {
                this.G = currentTimeMillis;
                boolean h16 = r.h(TroopUtils.f(), this.f299402d);
                int i3 = !z16 ? 1 : 0;
                this.F.f299352a = z16;
                ((TroopShortcutBarHandler) TroopUtils.f().getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE)).I2(this.f299402d, i3, h16);
                if (QLog.isColorLevel()) {
                    QLog.e("AppsAioShortCutViewBuilder", 2, "onSetTotalSwitch:" + String.valueOf(this.f299402d) + "isChecked" + z16 + "disabled" + i3 + "isAdminOrOwner" + h16);
                }
                boolean h17 = r.h(TroopUtils.f(), this.f299402d);
                if (z16 && h() && r.h(TroopUtils.f(), this.f299402d) && (troopAppShortcutContainer = this.f299405h) != null) {
                    troopAppShortcutContainer.Q();
                }
                if (h17) {
                    if (z16) {
                        ReportController.o(null, "dc00898", "", String.valueOf(this.f299402d), "0X800AAD9", "0X800AAD9", 0, 0, String.valueOf(this.f299403e), "", "", "");
                    } else {
                        ReportController.o(null, "dc00898", "", String.valueOf(this.f299402d), "0X800AADA", "0X800AADA", 0, 0, String.valueOf(this.f299403e), "", "", "");
                    }
                } else if (z16) {
                    ReportController.o(null, "dc00898", "", String.valueOf(this.f299402d), "0X800AFC1", "0X800AFC1", 0, 0, String.valueOf(this.f299403e), "", "", "");
                } else {
                    ReportController.o(null, "dc00898", "", String.valueOf(this.f299402d), "0X800AFC2", "0X800AFC2", 0, 0, String.valueOf(this.f299403e), "", "", "");
                }
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }
}
