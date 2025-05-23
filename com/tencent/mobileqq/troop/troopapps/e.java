package com.tencent.mobileqq.troop.troopapps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.r;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends b implements View.OnClickListener, View.OnTouchListener {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public TextView f299431a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f299432b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, Activity activity, Bundle bundle) {
        super(context, activity, null, bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, activity, bundle);
        }
    }

    private void g(View view) {
        ReportController.o(null, "dc00898", "", String.valueOf(this.f299402d), "0X800AFBF", "0X800AFBF", 0, 0, String.valueOf(this.f299403e), "", "", "");
        if (!r.h(TroopUtils.f(), this.f299402d)) {
            return;
        }
        r.c(this.f299402d, TroopUtils.f(), this.f299406i, this.f299407m);
    }

    @Override // com.tencent.mobileqq.troop.troopapps.b
    public Object c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.b
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.b
    public View e(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), view, viewGroup);
        }
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.f299406i).inflate(R.layout.fv7, viewGroup, false);
            aVar.f299431a = (TextView) view.findViewById(R.id.e85);
            aVar.f299432b = (ImageView) view.findViewById(R.id.ija);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.D) {
            aVar.f299432b.setVisibility(0);
            aVar.f299432b.setClickable(true);
            aVar.f299432b.setOnClickListener(this);
        } else {
            aVar.f299432b.setVisibility(8);
        }
        if (AppSetting.f99565y) {
            aVar.f299432b.setContentDescription(this.f299406i.getString(R.string.f2323974f));
        }
        aVar.f299432b.setOnTouchListener(this);
        return view;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.b
    public void f(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, obj);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else if (view.getId() == R.id.ija) {
            g(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                view.setAlpha(1.0f);
                return false;
            }
            return false;
        }
        view.setAlpha(0.5f);
        return false;
    }
}
