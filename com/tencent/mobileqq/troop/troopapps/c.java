package com.tencent.mobileqq.troop.troopapps;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richstatus.NoScrollGridView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.r;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends com.tencent.mobileqq.troop.troopapps.b {
    static IPatchRedirector $redirector_;
    private int F;
    protected int G;
    protected List<TroopAppShortcutContainer.e> H;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a extends BaseAdapter implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private List<TroopAppShortcutContainer.e> f299408d;

        /* renamed from: e, reason: collision with root package name */
        private c f299409e;

        /* renamed from: f, reason: collision with root package name */
        private LayoutInflater f299410f;

        /* renamed from: h, reason: collision with root package name */
        private int f299411h;

        public a(c cVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, i3);
                return;
            }
            this.f299408d = new ArrayList();
            this.f299411h = 0;
            this.f299409e = cVar;
            this.f299410f = LayoutInflater.from(cVar.f299406i);
            this.f299411h = i3;
        }

        private static void c(View view, TroopAppShortcutContainer.e eVar, int i3) {
            VideoReport.setElementId(view, "em_group_plus_application");
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
            VideoReport.setElementParam(view, "app_name", eVar.f299337e);
            VideoReport.setElementParam(view, "group_app_type", "top");
            VideoReport.setElementParam(view, "rank", String.valueOf(i3));
            VideoReport.setElementParam(view, "appid", String.valueOf(eVar.f299336d));
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TroopAppShortcutContainer.e getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (TroopAppShortcutContainer.e) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            if (i3 >= 0 && i3 < this.f299408d.size()) {
                return this.f299408d.get(i3);
            }
            return null;
        }

        public void b(List<TroopAppShortcutContainer.e> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            } else if (list != null) {
                this.f299408d.clear();
                this.f299408d.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f299408d.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
            }
            TroopAppShortcutContainer.e item = getItem(i3);
            if (item != null) {
                return item.f299334b;
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            b bVar;
            View view3;
            boolean z16;
            View view4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                view4 = view;
                view2 = (View) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                int itemViewType = getItemViewType(i3);
                view2 = null;
                if (view == null) {
                    if (itemViewType == 0) {
                        view3 = this.f299410f.inflate(R.layout.fv5, viewGroup, false);
                        bVar = new b();
                        bVar.f299412a = (ImageView) view3.findViewById(R.id.f101135ud);
                        bVar.f299413b = (ImageView) view3.findViewById(R.id.f101145ue);
                        bVar.f299414c = (TextView) view3.findViewById(R.id.f101155uf);
                        view3.setTag(bVar);
                    } else if (itemViewType == 1) {
                        view3 = this.f299410f.inflate(R.layout.fv6, viewGroup, false);
                        bVar = new b();
                        bVar.f299412a = (ImageView) view3.findViewById(R.id.f101135ud);
                        view3.setTag(bVar);
                    } else {
                        view4 = view;
                    }
                    ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
                    layoutParams.height = this.f299411h - 6;
                    view3.setLayoutParams(layoutParams);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(16.0f);
                    gradientDrawable.setColor(view3.getContext().getColorStateList(R.color.qui_common_fill_light_primary));
                    view3.setBackgroundDrawable(gradientDrawable);
                } else {
                    bVar = (b) view.getTag();
                    view3 = view;
                }
                TroopAppShortcutContainer.e item = getItem(i3);
                if (item == null) {
                    QLog.e("AppsGridViewBuilder", 2, "getItem() == null position:" + i3);
                } else {
                    bVar.f299415d = item;
                    if (itemViewType == 0) {
                        bVar.f299414c.setText(item.f299337e);
                    }
                    if (item.f299334b == 1) {
                        bVar.f299412a.setImageDrawable(this.f299409e.f299406i.getResources().getDrawable(R.drawable.obi));
                        r.o(bVar.f299412a);
                        bVar.f299413b.setVisibility(8);
                    } else {
                        bVar.f299412a.setOnTouchListener(null);
                        Context context = this.f299409e.f299406i;
                        ImageView imageView = bVar.f299412a;
                        String str = item.f299338f;
                        if (item.f299346n == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        r.l(context, imageView, str, 24.0f, z16);
                        if (item.f299344l != 0) {
                            bVar.f299413b.setVisibility(0);
                        } else {
                            bVar.f299413b.setVisibility(8);
                        }
                    }
                    String str2 = "";
                    if (item.f299334b == 0 && item.f299336d == 101914115) {
                        QQGameTroopManager.p(1, this.f299409e.f299402d + "", true);
                    }
                    if (AppSetting.f99565y) {
                        String str3 = item.f299337e;
                        if (str3 != null) {
                            str2 = str3;
                        }
                        view3.setContentDescription(str2);
                    }
                    view3.setClickable(true);
                    view3.setOnClickListener(this);
                    c(view3, item, i3);
                }
                view4 = view3;
                view2 = view4;
            }
            EventCollector.getInstance().onListGetView(i3, view4, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return 2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            ImageView imageView;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
            } else {
                Object tag = view.getTag();
                if (tag != null && (tag instanceof b)) {
                    b bVar = (b) tag;
                    if (bVar.f299415d != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("AppsGridViewBuilder", 2, "onItemClick appInfo:" + bVar.f299415d.toString());
                        }
                        TroopAppShortcutContainer.e eVar = bVar.f299415d;
                        int i3 = eVar.f299334b;
                        if (i3 == 1) {
                            long j3 = this.f299409e.f299402d;
                            QQAppInterface f16 = TroopUtils.f();
                            c cVar = this.f299409e;
                            r.b(1, j3, f16, cVar.f299406i, cVar.f299407m);
                        } else if (i3 == 0) {
                            if (eVar.f299344l != 0 && (imageView = bVar.f299413b) != null) {
                                imageView.setVisibility(8);
                            }
                            QQAppInterface f17 = TroopUtils.f();
                            c cVar2 = this.f299409e;
                            Context context = cVar2.f299406i;
                            Activity activity = cVar2.f299407m;
                            String valueOf = String.valueOf(cVar2.f299402d);
                            TroopAppShortcutContainer.e eVar2 = bVar.f299415d;
                            r.e(f17, context, activity, valueOf, eVar2.f299336d, eVar2.f299339g, 1, eVar2.f299344l, false);
                            String valueOf2 = String.valueOf(this.f299409e.f299402d);
                            String valueOf3 = String.valueOf(this.f299409e.f299403e);
                            String valueOf4 = String.valueOf(bVar.f299415d.f299336d);
                            String valueOf5 = String.valueOf(this.f299409e.E);
                            if (bVar.f299415d.f299335c == 0) {
                                str = "1";
                            } else {
                                str = "2";
                            }
                            ReportController.o(null, "dc00898", "", valueOf2, "0X800AD09", "0X800AD09", 0, 0, valueOf3, valueOf4, valueOf5, str);
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public ImageView f299412a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f299413b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f299414c;

        /* renamed from: d, reason: collision with root package name */
        public TroopAppShortcutContainer.e f299415d;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.troopapps.c$c, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C8787c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public a f299416a;

        public C8787c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public c(Context context, Activity activity, Bundle bundle) {
        super(context, activity, null, bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, activity, bundle);
            return;
        }
        this.F = 4;
        this.G = 0;
        this.H = new ArrayList();
        int screenWidth = DisplayUtil.getScreenWidth();
        if (PadUtil.a(context) == DeviceType.TABLET) {
            int f16 = BaseAIOUtils.f(64.0f, this.f299406i.getResources());
            this.G = f16;
            this.F = screenWidth / (f16 + BaseAIOUtils.f(13.0f, this.f299406i.getResources()));
            QLog.i("AppsGridViewBuilder", 1, "pad, gridColNum:" + this.F);
            return;
        }
        int f17 = (screenWidth - BaseAIOUtils.f(16.0f, this.f299406i.getResources())) - BaseAIOUtils.f(16.0f, this.f299406i.getResources());
        int f18 = BaseAIOUtils.f(13.0f, this.f299406i.getResources());
        int i3 = this.F;
        this.G = (f17 - (f18 * (i3 - 1))) / i3;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.b
    public Object c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.H;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.b
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.b
    public View e(int i3, View view, ViewGroup viewGroup) {
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), view, viewGroup);
        }
        if (view == null) {
            C8787c c8787c = new C8787c();
            NoScrollGridView noScrollGridView = new NoScrollGridView(this.f299406i);
            noScrollGridView.setNumColumns(this.F);
            noScrollGridView.setVerticalSpacing(BaseAIOUtils.f(10.0f, this.f299406i.getResources()));
            noScrollGridView.setHorizontalSpacing(BaseAIOUtils.f(13.0f, this.f299406i.getResources()));
            noScrollGridView.setPadding(BaseAIOUtils.f(16.0f, this.f299406i.getResources()), BaseAIOUtils.f(6.0f, this.f299406i.getResources()), BaseAIOUtils.f(16.0f, this.f299406i.getResources()), BaseAIOUtils.f(20.0f, this.f299406i.getResources()));
            noScrollGridView.setColumnWidth(this.G);
            noScrollGridView.setSelector(new ColorDrawable(0));
            noScrollGridView.setVerticalScrollBarEnabled(false);
            noScrollGridView.setStretchMode(0);
            a aVar = new a(this, this.G);
            c8787c.f299416a = aVar;
            aVar.b(this.H);
            noScrollGridView.setAdapter((ListAdapter) c8787c.f299416a);
            noScrollGridView.setTag(c8787c);
            view2 = noScrollGridView;
        } else {
            ((C8787c) view.getTag()).f299416a.b(this.H);
            view2 = view;
        }
        view2.setClickable(false);
        return view2;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.b
    public void f(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, obj);
        } else if (obj instanceof ArrayList) {
            this.H = (List) obj;
        }
    }
}
