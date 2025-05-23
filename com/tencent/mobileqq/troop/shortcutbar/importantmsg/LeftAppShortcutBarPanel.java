package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.InflateException;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.utils.r;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

/* loaded from: classes19.dex */
public class LeftAppShortcutBarPanel extends com.tencent.mobileqq.troop.shortcutbar.importantmsg.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a f298680a;

    /* renamed from: b, reason: collision with root package name */
    private AppShortcutBarScrollView f298681b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f298682c;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f298683d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f298684e;

    /* renamed from: f, reason: collision with root package name */
    private TroopAppShortcutBarHelper f298685f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f298686g;

    /* renamed from: h, reason: collision with root package name */
    private View f298687h;

    /* renamed from: i, reason: collision with root package name */
    private f f298688i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.mobileqq.troop.shortcutbar.importantmsg.b f298689j;

    /* renamed from: k, reason: collision with root package name */
    protected ArrayList<ShortcutBarInfo> f298690k;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f298691l;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f298692m;

    /* renamed from: n, reason: collision with root package name */
    protected AppRuntime f298693n;

    /* renamed from: o, reason: collision with root package name */
    protected Context f298694o;

    /* renamed from: p, reason: collision with root package name */
    protected View.OnClickListener f298695p;

    /* renamed from: q, reason: collision with root package name */
    protected View.OnClickListener f298696q;

    /* renamed from: r, reason: collision with root package name */
    protected PopupWindow.OnDismissListener f298697r;

    /* renamed from: s, reason: collision with root package name */
    protected ViewTreeObserver.OnGlobalLayoutListener f298698s;

    /* loaded from: classes19.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LeftAppShortcutBarPanel.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int dip2px;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (view != null) {
                if (LeftAppShortcutBarPanel.this.f298685f == null) {
                    QLog.e("LeftAppShortcutBarPanel", 1, "[onClick] mHelper is null");
                } else if (view == LeftAppShortcutBarPanel.this.f298687h && LeftAppShortcutBarPanel.this.f298693n != null) {
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    ImageView imageView = (ImageView) view.findViewById(R.id.f84874nf);
                    if (LeftAppShortcutBarPanel.this.f298688i != null) {
                        if (!LeftAppShortcutBarPanel.this.f298688i.o()) {
                            if (LeftAppShortcutBarPanel.this.f298688i.j() > 5) {
                                dip2px = ViewUtils.dip2px(247.0f);
                            } else {
                                dip2px = ViewUtils.dip2px((LeftAppShortcutBarPanel.this.f298688i.j() * 40) + 7);
                            }
                            LeftAppShortcutBarPanel.this.f298688i.t(view, view.getWidth(), 0, iArr[0] - (ViewUtils.dip2px(175.0f) / 2), iArr[1] - dip2px);
                            imageView.setImageResource(R.drawable.nic);
                            TextView textView = (TextView) LeftAppShortcutBarPanel.this.f298687h.findViewById(R.id.f84794n8);
                            if (textView != null) {
                                textView.setVisibility(4);
                            }
                        } else {
                            LeftAppShortcutBarPanel.this.f298688i.i();
                        }
                    }
                } else {
                    LeftAppShortcutBarPanel.this.f298685f.onClick(view);
                    if (LeftAppShortcutBarPanel.this.f298689j != null) {
                        LeftAppShortcutBarPanel.this.f298689j.f(view, 0);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes19.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LeftAppShortcutBarPanel.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (LeftAppShortcutBarPanel.this.f298685f != null) {
                LeftAppShortcutBarPanel.this.f298685f.F(view);
                if (LeftAppShortcutBarPanel.this.f298689j != null) {
                    LeftAppShortcutBarPanel.this.f298689j.e(view, 0);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes19.dex */
    class c implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LeftAppShortcutBarPanel.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            LeftAppShortcutBarPanel leftAppShortcutBarPanel = LeftAppShortcutBarPanel.this;
            leftAppShortcutBarPanel.k(leftAppShortcutBarPanel.f298690k);
            if (LeftAppShortcutBarPanel.this.f298687h != null && LeftAppShortcutBarPanel.this.f298687h.getViewTreeObserver() != null) {
                LeftAppShortcutBarPanel leftAppShortcutBarPanel2 = LeftAppShortcutBarPanel.this;
                if (leftAppShortcutBarPanel2.f298698s != null) {
                    leftAppShortcutBarPanel2.f298687h.getViewTreeObserver().removeOnGlobalLayoutListener(LeftAppShortcutBarPanel.this.f298698s);
                }
            }
        }
    }

    public LeftAppShortcutBarPanel(com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aVar, AppShortcutBarScrollView appShortcutBarScrollView, TroopAppShortcutBarHelper troopAppShortcutBarHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, appShortcutBarScrollView, troopAppShortcutBarHelper);
            return;
        }
        this.f298686g = false;
        this.f298691l = false;
        this.f298692m = false;
        this.f298695p = new a();
        this.f298696q = new b();
        this.f298697r = new PopupWindow.OnDismissListener() { // from class: com.tencent.mobileqq.troop.shortcutbar.importantmsg.LeftAppShortcutBarPanel.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LeftAppShortcutBarPanel.this);
                }
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (LeftAppShortcutBarPanel.this.f298687h != null && LeftAppShortcutBarPanel.this.f298688i != null) {
                    ImageView imageView = (ImageView) LeftAppShortcutBarPanel.this.f298687h.findViewById(R.id.f84874nf);
                    if (imageView != null) {
                        imageView.setImageResource(R.drawable.nid);
                        TextView textView = (TextView) LeftAppShortcutBarPanel.this.f298687h.findViewById(R.id.f84794n8);
                        if (textView != null) {
                            textView.setVisibility(0);
                        }
                    }
                    LeftAppShortcutBarPanel.this.f298688i.r();
                    ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.shortcutbar.importantmsg.LeftAppShortcutBarPanel.3.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else if (LeftAppShortcutBarPanel.this.f298689j != null) {
                                LeftAppShortcutBarPanel.this.f298689j.k();
                            }
                        }
                    }, 100L);
                }
            }
        };
        this.f298698s = new c();
        this.f298680a = aVar;
        this.f298693n = aVar.d();
        this.f298694o = aVar.e();
        this.f298681b = appShortcutBarScrollView;
        LinearLayout linearLayout = (LinearLayout) appShortcutBarScrollView.findViewById(R.id.f223403g);
        this.f298682c = linearLayout;
        this.f298683d = (LinearLayout) linearLayout.findViewById(R.id.f166477h53);
        this.f298684e = (LinearLayout) this.f298682c.findViewById(R.id.f223203e);
        this.f298685f = troopAppShortcutBarHelper;
        this.f298689j = new com.tencent.mobileqq.troop.shortcutbar.importantmsg.b(this, aVar, troopAppShortcutBarHelper);
        this.f298691l = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ArrayList<ShortcutBarInfo> arrayList) {
        View view;
        int dip2px;
        if (!this.f298692m && this.f298685f != null && this.f298697r != null) {
            f fVar = this.f298688i;
            if (fVar == null || (fVar != null && !fVar.o())) {
                f fVar2 = new f(this.f298680a, this.f298685f, this.f298697r, this.f298689j);
                this.f298688i = fVar2;
                fVar2.p();
            }
            this.f298688i.s(arrayList);
            if (this.f298688i.o() && (view = this.f298687h) != null) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                if (this.f298688i.j() > 5) {
                    dip2px = ViewUtils.dip2px(247.0f);
                } else {
                    dip2px = ViewUtils.dip2px((this.f298688i.j() * 40) + 7);
                }
                this.f298688i.u(this.f298687h, iArr[0] - (ViewUtils.dip2px(175.0f) / 2), (iArr[1] - r8) - 5, ViewUtils.dip2px(175.0f), dip2px);
            }
        }
    }

    private void l(ArrayList<ShortcutBarInfo> arrayList) {
        LinearLayout linearLayout = this.f298684e;
        if (linearLayout != null && this.f298683d != null) {
            linearLayout.removeAllViews();
            if (arrayList == null) {
                return;
            }
            Iterator<ShortcutBarInfo> it = arrayList.iterator();
            boolean z16 = true;
            boolean z17 = false;
            while (it.hasNext()) {
                ShortcutBarInfo next = it.next();
                try {
                    com.tencent.mobileqq.troop.shortcutbar.importantmsg.b bVar = this.f298689j;
                    if (bVar != null) {
                        bVar.c(Long.valueOf(next.getMsgSeq()), Long.valueOf(next.getAppId()));
                    }
                    View inflate = View.inflate(this.f298680a.e(), R.layout.h6l, null);
                    p(next, inflate);
                    this.f298684e.addView(inflate);
                    if (z16) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
                        layoutParams.setMargins(ViewUtils.dip2px(16.0f), 0, 0, 0);
                        inflate.setLayoutParams(layoutParams);
                        z16 = false;
                    }
                    z17 = true;
                } catch (InflateException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("LeftAppShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got InflateException, e:" + e16.getMessage());
                    }
                    System.gc();
                    return;
                } catch (OutOfMemoryError e17) {
                    if (QLog.isColorLevel()) {
                        QLog.e("LeftAppShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got OOM, e:" + e17.getMessage());
                    }
                    System.gc();
                    return;
                }
            }
            this.f298686g = z17;
            if (z17) {
                this.f298685f.H();
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("LeftAppShortcutBarPanel", 2, "updateMessageShortcutPanel. messageShortcutPanel is null.");
        }
    }

    private void m(ImportantMsgInfo importantMsgInfo, ArrayList<ShortcutBarInfo> arrayList) {
        if (importantMsgInfo == null) {
            return;
        }
        this.f298690k = arrayList;
        try {
            View inflate = View.inflate(this.f298694o, R.layout.h6m, null);
            o(inflate, importantMsgInfo, arrayList);
            this.f298687h = inflate;
            this.f298684e.addView(inflate);
            if (this.f298687h != null && this.f298691l) {
                this.f298691l = false;
                this.f298689j.h();
            }
            View view = this.f298687h;
            if (view != null) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(this.f298698s);
            }
        } catch (InflateException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("LeftAppShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got InflateException, e:" + e16.getMessage());
            }
            System.gc();
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.e("LeftAppShortcutBarPanel", 2, "ShortcutBarAioHelper.updateMessageShortcutPanel got OOM, e:" + e17.getMessage());
            }
            System.gc();
        }
    }

    private void o(View view, ImportantMsgInfo importantMsgInfo, ArrayList<ShortcutBarInfo> arrayList) {
        boolean z16;
        view.setTag(importantMsgInfo);
        view.setOnClickListener(this.f298695p);
        view.setLongClickable(false);
        AppRuntime appRuntime = this.f298693n;
        if (appRuntime != null && ThemeUtil.isInNightMode(appRuntime)) {
            z16 = true;
        } else {
            z16 = false;
        }
        TextView textView = (TextView) view.findViewById(R.id.f84894nh);
        if (z16) {
            textView.setTextColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
        } else {
            textView.setTextColor(Color.parseColor("#1C1D1E"));
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f84864ne);
        if (z16) {
            linearLayout.setBackgroundDrawable(this.f298694o.getResources().getDrawable(R.drawable.a9v));
        } else {
            linearLayout.setBackgroundDrawable(this.f298694o.getResources().getDrawable(R.drawable.a9n));
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.f84874nf);
        if (z16) {
            imageView.setColorFilter(1996488704);
        } else {
            imageView.setColorFilter(0);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.f84794n8);
        textView2.setVisibility(0);
        textView2.setText(String.valueOf(arrayList.size()));
        textView2.setBackgroundResource(R.drawable.kzc);
    }

    private void p(ShortcutBarInfo shortcutBarInfo, View view) {
        boolean z16;
        view.setTag(shortcutBarInfo);
        view.setOnClickListener(this.f298695p);
        AppRuntime appRuntime = this.f298693n;
        boolean z17 = true;
        if (appRuntime != null && ThemeUtil.isInNightMode(appRuntime)) {
            z16 = true;
        } else {
            z16 = false;
        }
        TextView textView = (TextView) view.findViewById(R.id.f84834nb);
        textView.setText(shortcutBarInfo.getMsgSummary());
        textView.setContentDescription(shortcutBarInfo.getMsgSummary());
        if (z16) {
            textView.setTextColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
        } else {
            textView.setTextColor(Color.parseColor("#1C1D1E"));
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f84814n_);
        if (z16) {
            linearLayout.setBackgroundDrawable(this.f298694o.getResources().getDrawable(R.drawable.a9v));
        } else {
            linearLayout.setBackgroundDrawable(this.f298694o.getResources().getDrawable(R.drawable.a9n));
        }
        URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.f84824na);
        if (z16) {
            uRLImageView.setColorFilter(1996488704);
        } else {
            uRLImageView.setColorFilter(0);
        }
        Context context = this.f298694o;
        String iconUrl = shortcutBarInfo.getIconUrl();
        if (shortcutBarInfo.getShowFrame() != 1) {
            z17 = false;
        }
        r.l(context, uRLImageView, iconUrl, 19.0f, z17);
        ImageView imageView = (ImageView) view.findViewById(R.id.f84804n9);
        if (!shortcutBarInfo.getShowDel()) {
            imageView.setVisibility(8);
            return;
        }
        if (z16) {
            imageView.setColorFilter(1996488704);
        } else {
            imageView.setColorFilter(0);
        }
        imageView.setTag(shortcutBarInfo);
        imageView.setOnClickListener(this.f298696q);
        imageView.setContentDescription("\u5173\u95ed");
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.importantmsg.a
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f298686g;
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.importantmsg.a
    public void b() {
        AppRuntime appRuntime;
        ImportantMsgInfo importantMsgInfo;
        com.tencent.mobileqq.troop.shortcutbar.importantmsg.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.f298684e == null || this.f298681b == null || (appRuntime = this.f298693n) == null || this.f298685f == null || ((TroopManager) appRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).k(this.f298685f.p()) == null) {
            return;
        }
        Rect rect = new Rect();
        this.f298681b.getHitRect(rect);
        for (int i3 = 0; i3 < this.f298684e.getChildCount(); i3++) {
            View childAt = this.f298684e.getChildAt(i3);
            if (childAt != null && childAt.getLocalVisibleRect(rect)) {
                Object tag = childAt.getTag();
                if ((tag instanceof ImportantMsgInfo) && (importantMsgInfo = (ImportantMsgInfo) tag) != null && (bVar = this.f298689j) != null) {
                    bVar.b(Long.valueOf(importantMsgInfo.getMsgSeq()), Long.valueOf(importantMsgInfo.getAppId()));
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.b
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.shortcutbar.importantmsg.b bVar = this.f298689j;
        if (bVar != null) {
            bVar.j();
            this.f298689j.g();
        }
        this.f298680a = null;
        this.f298687h = null;
        this.f298686g = false;
        this.f298685f = null;
        this.f298683d = null;
        this.f298681b = null;
        this.f298682c = null;
        this.f298684e = null;
        this.f298698s = null;
        this.f298697r = null;
        this.f298693n = null;
        this.f298692m = true;
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        f fVar = this.f298688i;
        if (fVar != null) {
            fVar.q();
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.importantmsg.a
    public void e(ArrayList<ShortcutBarInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
            return;
        }
        if (this.f298680a != null && this.f298681b != null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                this.f298686g = false;
                if (arrayList.size() > 3 && this.f298683d.getChildCount() > 0) {
                    ArrayList<ShortcutBarInfo> arrayList2 = new ArrayList<>();
                    ArrayList<ShortcutBarInfo> arrayList3 = new ArrayList<>();
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (i3 < 2) {
                            arrayList2.add(arrayList.get(i3));
                        } else {
                            arrayList3.add(arrayList.get(i3));
                        }
                    }
                    l(arrayList2);
                    m(new ImportantMsgInfo(0L, 0L, "\u66f4\u591a", "", "", 0L, 0), arrayList3);
                    return;
                }
                f fVar = this.f298688i;
                if (fVar != null && fVar.o()) {
                    this.f298688i.i();
                }
                l(arrayList);
                return;
            }
            this.f298684e.removeAllViews();
            if (this.f298683d.getChildCount() == 0) {
                this.f298685f.t();
            }
            this.f298686g = false;
        }
    }

    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (this.f298683d == null || this.f298681b.getChildCount() <= 0) {
            return 2;
        }
        return 1;
    }
}
