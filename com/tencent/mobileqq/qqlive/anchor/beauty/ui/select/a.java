package com.tencent.mobileqq.qqlive.anchor.beauty.ui.select;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.beauty.ui.select.SelectPanelClickListener;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a extends com.tencent.mobileqq.qqlive.room.multichat.audience.a implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private View f270531e;

    /* renamed from: f, reason: collision with root package name */
    private SelectPanelClickListener f270532f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.room.multichat.utils.a f270533h;

    /* renamed from: i, reason: collision with root package name */
    private RelativeLayout f270534i;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f270535m;

    public a(Activity activity, long j3) {
        super(activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, Long.valueOf(j3));
            return;
        }
        this.f270531e = null;
        g(activity);
        f(j3);
    }

    private void f(long j3) {
        ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).bindPageInfo(j3);
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("em_qqlive_ornament_selection", "1");
        ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).bindElementWithStaticParams(this.f270534i, "em_qqlive_ornament_selection", concurrentHashMap);
        ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).reportClickForCustomWindow(this.f270534i, concurrentHashMap);
        ConcurrentHashMap<String, String> concurrentHashMap2 = new ConcurrentHashMap<>();
        concurrentHashMap2.put("em_qqlive_ornament_selection", "2");
        ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).bindElementWithStaticParams(this.f270535m, "em_qqlive_ornament_selection", concurrentHashMap2);
        ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).reportClickForCustomWindow(this.f270535m, concurrentHashMap2);
    }

    private void g(Context context) {
        View inflate = View.inflate(context, R.layout.hbe, null);
        this.f270531e = inflate;
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.t5w);
        this.f270534i = relativeLayout;
        relativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.f270531e.findViewById(R.id.udg);
        this.f270535m = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.room.multichat.utils.a aVar = this.f270533h;
        if (aVar == null) {
            return;
        }
        aVar.a();
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f270531e = null;
        this.f270532f = null;
        this.f270533h = null;
    }

    public void i(SelectPanelClickListener selectPanelClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) selectPanelClickListener);
        } else {
            this.f270532f = selectPanelClickListener;
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f270533h == null) {
            this.f270533h = new com.tencent.mobileqq.qqlive.room.multichat.utils.a(this.f271659d, this.f270531e, c(170.0f), true);
        }
        this.f270533h.b(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            e();
            if (this.f270532f != null) {
                if (view.getId() == R.id.t5w) {
                    this.f270532f.a(this.f271659d, SelectPanelClickListener.SelectAction.CLICK_BEAUTY);
                } else if (view.getId() == R.id.udg) {
                    this.f270532f.a(this.f271659d, SelectPanelClickListener.SelectAction.CLICK_PROP);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
