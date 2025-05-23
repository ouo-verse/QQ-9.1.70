package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.adapter.b;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.utils.r;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a f298738a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<ShortcutBarInfo> f298739b;

    /* renamed from: c, reason: collision with root package name */
    private PopupWindow f298740c;

    /* renamed from: d, reason: collision with root package name */
    private OverScrollRecyclerView f298741d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.troop.adapter.a f298742e;

    /* renamed from: f, reason: collision with root package name */
    private View f298743f;

    /* renamed from: g, reason: collision with root package name */
    private TroopAppShortcutBarHelper f298744g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.troop.shortcutbar.importantmsg.b f298745h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f298746i;

    /* renamed from: j, reason: collision with root package name */
    private PopupWindow.OnDismissListener f298747j;

    /* renamed from: k, reason: collision with root package name */
    private WindowManager.LayoutParams f298748k;

    /* renamed from: l, reason: collision with root package name */
    private View f298749l;

    /* renamed from: m, reason: collision with root package name */
    private Activity f298750m;

    /* renamed from: n, reason: collision with root package name */
    private AppRuntime f298751n;

    /* renamed from: o, reason: collision with root package name */
    private Context f298752o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (f.this.f298740c.isShowing()) {
                f.this.i();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, i3);
                return;
            }
            super.onScrollStateChanged(recyclerView, i3);
            if (f.this.f298745h == null) {
                return;
            }
            if (i3 == 0 || i3 == 1) {
                RecyclerView.LayoutManager layoutManager = f.this.f298741d.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                    if (findLastVisibleItemPosition == 0) {
                        if (f.this.f298739b != null) {
                            findLastVisibleItemPosition = f.this.f298739b.size();
                            if (findLastVisibleItemPosition > 6) {
                                findLastVisibleItemPosition = 6;
                            }
                        } else {
                            findLastVisibleItemPosition = 0;
                        }
                    }
                    for (int i16 = 0; i16 < findLastVisibleItemPosition - findFirstVisibleItemPosition; i16++) {
                        if (f.this.f298741d.getChildAt(i16) != null) {
                            View childAt = f.this.f298741d.getChildAt(i16);
                            if (childAt.getTag() != null && (childAt.getTag() instanceof ShortcutBarInfo)) {
                                ShortcutBarInfo shortcutBarInfo = (ShortcutBarInfo) childAt.getTag();
                                f.this.f298745h.b(Long.valueOf(shortcutBarInfo.getMsgSeq()), Long.valueOf(shortcutBarInfo.getAppId()));
                            }
                        }
                    }
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, recyclerView, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                super.onScrolled(recyclerView, i3, i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c extends com.tencent.mobileqq.troop.adapter.a<ShortcutBarInfo> {
        static IPatchRedirector $redirector_;

        c(Context context, int i3) {
            super(context, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, f.this, context, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.troop.adapter.a
        protected com.tencent.mobileqq.troop.adapter.base.c Q(Context context, ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.troop.adapter.base.c) iPatchRedirector.redirect((short) 2, this, context, viewGroup, Integer.valueOf(i3));
            }
            View inflate = LayoutInflater.from(context).inflate(i3, viewGroup, false);
            g gVar = new g(context, inflate);
            gVar.f298757h = (LinearLayout) inflate.findViewById(R.id.f84844nc);
            gVar.f298759m = (ImageView) inflate.findViewById(R.id.f84854nd);
            gVar.f298758i = (URLImageView) inflate.findViewById(R.id.f84884ng);
            gVar.C = (TextView) inflate.findViewById(R.id.f84894nh);
            return gVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.adapter.a
        /* renamed from: R, reason: merged with bridge method [inline-methods] */
        public void P(com.tencent.mobileqq.troop.adapter.base.c cVar, ShortcutBarInfo shortcutBarInfo, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                f.this.h(cVar, shortcutBarInfo, i3);
            } else {
                iPatchRedirector.redirect((short) 3, this, cVar, shortcutBarInfo, Integer.valueOf(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d implements b.d {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.adapter.b.d
        public boolean a(View view, RecyclerView.ViewHolder viewHolder, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, view, viewHolder, Integer.valueOf(i3))).booleanValue();
        }

        @Override // com.tencent.mobileqq.troop.adapter.b.d
        public void b(View view, RecyclerView.ViewHolder viewHolder, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, viewHolder, Integer.valueOf(i3));
            } else if (view != null && viewHolder != null && (view.getTag() instanceof ShortcutBarInfo)) {
                f.this.f298744g.onClick(view);
                f.this.f298745h.f(view, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (view != null && f.this.f298751n != null && f.this.f298744g != null && (view.getTag() instanceof ShortcutBarInfo)) {
                f.this.f298744g.F(view);
                f.this.f298745h.e(view, 1);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public f(com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aVar, TroopAppShortcutBarHelper troopAppShortcutBarHelper, PopupWindow.OnDismissListener onDismissListener, com.tencent.mobileqq.troop.shortcutbar.importantmsg.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, troopAppShortcutBarHelper, onDismissListener, bVar);
            return;
        }
        this.f298738a = aVar;
        this.f298744g = troopAppShortcutBarHelper;
        this.f298747j = onDismissListener;
        this.f298745h = bVar;
        this.f298750m = aVar.c();
        this.f298751n = aVar.d();
        this.f298752o = aVar.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.tencent.mobileqq.troop.adapter.base.c cVar, ShortcutBarInfo shortcutBarInfo, int i3) {
        if (cVar != null && shortcutBarInfo != null) {
            g gVar = (g) cVar;
            gVar.D = shortcutBarInfo;
            com.tencent.mobileqq.troop.shortcutbar.importantmsg.b bVar = this.f298745h;
            if (bVar != null) {
                bVar.a(Long.valueOf(shortcutBarInfo.getMsgSeq()), Long.valueOf(shortcutBarInfo.getAppId()));
            }
            boolean isInNightMode = ThemeUtil.isInNightMode(this.f298751n);
            boolean z16 = true;
            if (i3 == 0) {
                if (isInNightMode) {
                    gVar.f298757h.setBackgroundDrawable(this.f298752o.getResources().getDrawable(R.drawable.jxn));
                } else {
                    gVar.f298757h.setBackgroundDrawable(this.f298752o.getResources().getDrawable(R.drawable.jxm));
                }
            } else if (i3 == this.f298739b.size() - 1) {
                if (isInNightMode) {
                    gVar.f298757h.setBackgroundDrawable(this.f298752o.getResources().getDrawable(R.drawable.jxp));
                } else {
                    gVar.f298757h.setBackgroundDrawable(this.f298752o.getResources().getDrawable(R.drawable.jxo));
                }
            } else if (isInNightMode) {
                gVar.f298757h.setBackgroundDrawable(this.f298752o.getResources().getDrawable(R.drawable.jxr));
            } else {
                gVar.f298757h.setBackgroundDrawable(this.f298752o.getResources().getDrawable(R.drawable.jxq));
            }
            if (isInNightMode) {
                gVar.C.setTextColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
                gVar.f298758i.setColorFilter(1996488704);
                gVar.f298759m.setColorFilter(1996488704);
            } else {
                gVar.C.setTextColor(Color.parseColor("#1C1D1E"));
            }
            gVar.C.setText(shortcutBarInfo.getMsgSummary());
            gVar.f298759m.setTag(shortcutBarInfo);
            gVar.itemView.setTag(shortcutBarInfo);
            gVar.f298759m.setContentDescription("\u5173\u95ed");
            gVar.f298759m.setOnClickListener(new e());
            Context context = this.f298752o;
            URLImageView uRLImageView = gVar.f298758i;
            String iconUrl = shortcutBarInfo.getIconUrl();
            if (shortcutBarInfo.getShowFrame() != 1) {
                z16 = false;
            }
            r.l(context, uRLImageView, iconUrl, 19.0f, z16);
        }
    }

    private void k() {
        c cVar = new c(this.f298750m, R.layout.f169149i00);
        this.f298742e = cVar;
        cVar.N(new d());
    }

    private void l() {
        int height;
        if (this.f298748k == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f298748k = layoutParams;
            layoutParams.type = 1000;
            layoutParams.format = -3;
            layoutParams.flags = 40;
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                this.f298748k.flags |= 67108864;
            }
            int i3 = -1;
            this.f298748k.width = -1;
            if (this.f298750m.getWindow() != null && this.f298750m.getWindow().getDecorView() != null && (height = this.f298750m.getWindow().getDecorView().getHeight()) > 0) {
                i3 = height;
            }
            WindowManager.LayoutParams layoutParams2 = this.f298748k;
            layoutParams2.height = i3;
            layoutParams2.windowAnimations = R.style.f173628ho;
        }
        if (this.f298749l == null) {
            View view = new View(this.f298750m);
            this.f298749l = view;
            view.setBackgroundColor(this.f298750m.getResources().getColor(R.color.f156934fo));
            this.f298749l.setOnClickListener(new a());
        }
    }

    private void m() {
        this.f298741d.setAdapter(this.f298742e);
        ArrayList<ShortcutBarInfo> arrayList = this.f298739b;
        if (arrayList != null && !(arrayList.get(0) instanceof ShortcutBarInfo)) {
            this.f298742e.p(null);
            return;
        }
        this.f298742e.r();
        this.f298742e.p(this.f298739b);
        this.f298742e.notifyDataSetChanged();
    }

    private void n() {
        View inflate = LayoutInflater.from(this.f298752o).inflate(R.layout.dwd, (ViewGroup) null);
        this.f298743f = inflate;
        if (inflate == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.f102655yh);
        this.f298746i = (ImageView) this.f298743f.findViewById(R.id.f102675yj);
        OverScrollRecyclerView overScrollRecyclerView = (OverScrollRecyclerView) this.f298743f.findViewById(R.id.f102665yi);
        this.f298741d = overScrollRecyclerView;
        overScrollRecyclerView.setLayoutManager(new LinearLayoutManager(this.f298750m, 1, false));
        if (ThemeUtil.isInNightMode(this.f298751n)) {
            linearLayout.setBackgroundDrawable(this.f298752o.getResources().getDrawable(R.drawable.a9v));
        } else {
            linearLayout.setBackgroundDrawable(this.f298752o.getResources().getDrawable(R.drawable.a9n));
        }
        PopupWindow popupWindow = new PopupWindow(this.f298743f, ViewUtils.dip2px(175.0f), -2, true);
        this.f298740c = popupWindow;
        PopupWindow.OnDismissListener onDismissListener = this.f298747j;
        if (onDismissListener != null) {
            popupWindow.setOnDismissListener(onDismissListener);
        }
        this.f298741d.addOnScrollListener(new b());
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        try {
            if (LiuHaiUtils.hasNotchInScreenWrapper(this.f298750m)) {
                ((ViewGroup) this.f298750m.getWindow().getDecorView()).removeView(this.f298749l);
            } else {
                this.f298750m.getWindowManager().removeView(this.f298749l);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("PopupMoreListDialog", 2, e16.toString());
            }
        }
        PopupWindow popupWindow = this.f298740c;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        ArrayList<ShortcutBarInfo> arrayList = this.f298739b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        PopupWindow popupWindow = this.f298740c;
        if (popupWindow != null) {
            return popupWindow.isShowing();
        }
        return false;
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        n();
        k();
        m();
        l();
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        PopupWindow popupWindow = this.f298740c;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f298740c.dismiss();
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        try {
            if (LiuHaiUtils.hasNotchInScreenWrapper(this.f298750m)) {
                ((ViewGroup) this.f298750m.getWindow().getDecorView()).removeView(this.f298749l);
            } else {
                this.f298750m.getWindowManager().removeView(this.f298749l);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("PopupMoreListDialog", 2, e16.toString());
            }
        }
    }

    public void s(ArrayList<ShortcutBarInfo> arrayList) {
        OverScrollRecyclerView overScrollRecyclerView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) arrayList);
            return;
        }
        if (this.f298740c != null && (overScrollRecyclerView = this.f298741d) != null) {
            this.f298739b = arrayList;
            ViewGroup.LayoutParams layoutParams = overScrollRecyclerView.getLayoutParams();
            if (arrayList.size() > 5) {
                layoutParams.height = ViewUtils.dip2px(247.0f);
            } else {
                layoutParams.height = -2;
            }
            this.f298741d.setLayoutParams(layoutParams);
            com.tencent.mobileqq.troop.adapter.a aVar = this.f298742e;
            if (aVar != null) {
                aVar.r();
                this.f298742e.p(this.f298739b);
                this.f298742e.notifyDataSetChanged();
            }
        }
    }

    public void t(View view, int i3, int i16, int i17, int i18) {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (this.f298740c != null && this.f298746i != null && view != null) {
            com.tencent.mobileqq.troop.shortcutbar.importantmsg.b bVar = this.f298745h;
            ArrayList<ShortcutBarInfo> arrayList = this.f298739b;
            if (arrayList == null) {
                size = 0;
            } else {
                size = arrayList.size();
            }
            bVar.i(size);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f298746i.getLayoutParams();
            if (layoutParams != null) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                if (i17 > 0) {
                    layoutParams.leftMargin = (iArr[0] - i17) + (ViewUtils.dip2px(73.0f) / 2);
                } else {
                    layoutParams.leftMargin = iArr[0] + (ViewUtils.dip2px(73.0f) / 2);
                }
                this.f298746i.setLayoutParams(layoutParams);
                AppRuntime appRuntime = this.f298751n;
                if (appRuntime != null) {
                    if (ThemeUtil.isInNightMode(appRuntime)) {
                        this.f298746i.setColorFilter(-14934754);
                    } else {
                        this.f298746i.setColorFilter(-1);
                    }
                }
            }
            if (LiuHaiUtils.hasNotchInScreenWrapper(this.f298750m)) {
                ((ViewGroup) this.f298750m.getWindow().getDecorView()).addView(this.f298749l, this.f298748k);
            } else {
                this.f298750m.getWindowManager().addView(this.f298749l, this.f298748k);
            }
            this.f298740c.showAtLocation(view, i16, i17, i18);
            com.tencent.mobileqq.troop.adapter.a aVar = this.f298742e;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        }
    }

    public void u(View view, int i3, int i16, int i17, int i18) {
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (this.f298740c != null && (imageView = this.f298746i) != null && view != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            if (layoutParams != null) {
                view.getLocationOnScreen(new int[2]);
                if (i3 > this.f298740c.getWidth() / 2) {
                    layoutParams.leftMargin = (this.f298740c.getWidth() / 2) + (ViewUtils.dip2px(73.0f) / 2);
                } else {
                    layoutParams.leftMargin = (ViewUtils.dip2px(73.0f) / 2) + i3;
                }
                this.f298746i.setLayoutParams(layoutParams);
                AppRuntime appRuntime = this.f298751n;
                if (appRuntime != null) {
                    if (ThemeUtil.isInNightMode(appRuntime)) {
                        this.f298746i.setColorFilter(-14934754);
                    } else {
                        this.f298746i.setColorFilter(-1);
                    }
                }
            }
            this.f298740c.update(i3, i16, i17, i18);
            com.tencent.mobileqq.troop.adapter.a aVar = this.f298742e;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        }
    }
}
