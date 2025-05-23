package com.tencent.mobileqq.leba.feed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.feed.k;
import com.tencent.mobileqq.leba.l;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* loaded from: classes15.dex */
public class LebaPluginsFeedView extends GridLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public List<n> f240555d;

    /* renamed from: e, reason: collision with root package name */
    public List<k> f240556e;

    /* renamed from: f, reason: collision with root package name */
    public LayoutInflater f240557f;

    /* renamed from: h, reason: collision with root package name */
    public LebaRedTouchBase f240558h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.leba.entity.h f240559i;

    /* loaded from: classes15.dex */
    public static class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    LebaPluginsFeedView.setViewAlpha(view, 1.0f);
                    return false;
                }
                return false;
            }
            LebaPluginsFeedView.setViewAlpha(view, 0.5f);
            return false;
        }
    }

    public LebaPluginsFeedView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void a(int i3, int i16, int i17) {
        try {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            k kVar = new k(getContext(), this.f240557f, linearLayout, i16);
            this.f240556e.add(kVar);
            View view = kVar.f240589c;
            view.setTag(Integer.valueOf(i3));
            view.setOnClickListener(this);
            view.setOnTouchListener(new a());
            linearLayout.addView(view);
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
            layoutParams.setGravity(17);
            layoutParams.rowSpec = GridLayout.spec(i3 / i17, 1.0f);
            layoutParams.columnSpec = GridLayout.spec(i3 % i17, 1.0f);
            layoutParams.height = -2;
            layoutParams.width = -2;
            addView(linearLayout, layoutParams);
        } catch (Exception e16) {
            QLog.i("LebaPluginsFeedView", 1, "addTableItem", e16);
        }
    }

    private void b() {
        for (int i3 = 0; i3 < this.f240555d.size(); i3++) {
            n nVar = this.f240555d.get(i3);
            if (i3 >= this.f240556e.size()) {
                QLog.e("LebaPluginsFeedView", 1, "bindDataToItem size not equal!");
                return;
            }
            k kVar = this.f240556e.get(i3);
            k.a aVar = new k.a();
            aVar.f240592a = nVar;
            aVar.f240593b = getContext();
            aVar.f240594c = this.f240558h;
            kVar.a(aVar);
        }
    }

    private void d() {
        int i3;
        int i16 = 1;
        QLog.i("LebaPluginsFeedView", 1, "refreshFeedView mDataList=" + this.f240555d.size() + ",childCount=" + getChildCount());
        if (this.f240555d.size() != getChildCount()) {
            removeAllViews();
            this.f240556e.clear();
            int i17 = 4;
            if (this.f240555d.size() < 4) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            int size = this.f240555d.size();
            if (size <= 5) {
                i17 = size;
            } else if (size <= 8) {
                i16 = 2;
            } else {
                i16 = 2;
                i17 = 5;
            }
            setColumnCount(i17);
            setRowCount(i16);
            for (int i18 = 0; i18 < this.f240555d.size(); i18++) {
                a(i18, i3, i17);
            }
        }
    }

    public static void setViewAlpha(View view, float f16) {
        view.setAlpha(f16);
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.i("LebaPluginsFeedView", 1, "notifyDataSetChanged");
        List<n> list = this.f240555d;
        if (list != null && !list.isEmpty()) {
            d();
            b();
        } else {
            removeAllViews();
            this.f240556e.clear();
        }
    }

    void e() {
        if (this.f240555d != null && this.f240556e != null) {
            for (int i3 = 0; i3 < this.f240555d.size(); i3++) {
                if (i3 >= this.f240556e.size()) {
                    QLog.e("LebaPluginsFeedView", 1, "bindDataToItem size not equal!");
                    return;
                }
                com.tencent.mobileqq.leba.report.d.h(this.f240556e.get(i3).f240589c);
            }
        }
    }

    void f(View view, int i3) {
        k kVar;
        if (view == null || i3 >= this.f240556e.size() || (kVar = this.f240556e.get(i3)) == null) {
            return;
        }
        TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
        if (companion.j()) {
            String valueOf = String.valueOf(kVar.f240587a.f240592a.f240504a);
            com.tencent.mobileqq.leba.report.d.u(view, String.valueOf(companion.g(valueOf)), companion.f(valueOf));
        } else {
            com.tencent.mobileqq.leba.report.d.t(view, l.b(kVar.f240588b));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        n nVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else if (this.f240555d == null) {
            QLog.i("LebaPluginsFeedView", 1, "onClick mDataList == null");
        } else {
            int i3 = 0;
            try {
                i3 = ((Integer) view.getTag()).intValue();
                nVar = this.f240555d.get(i3);
            } catch (Exception e16) {
                QLog.i("LebaPluginsFeedView", 1, NodeProps.ON_CLICK, e16);
                nVar = null;
            }
            if (nVar == null) {
                QLog.i("LebaPluginsFeedView", 1, "onClick item == null");
            } else {
                ((IGameCenterRedPointConfigApi) QRoute.api(IGameCenterRedPointConfigApi.class)).onItemClick(nVar.f240504a);
                f(view, i3);
                com.tencent.mobileqq.leba.entity.h hVar = this.f240559i;
                if (hVar != null) {
                    if (nVar.f240507d == 2) {
                        hVar.b(view, nVar);
                    } else {
                        hVar.c(view, nVar, i3);
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setData(List<n> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, list, Boolean.valueOf(z16));
            return;
        }
        this.f240555d = list;
        c();
        if (z16) {
            e();
        }
    }

    public LebaPluginsFeedView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public LebaPluginsFeedView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
