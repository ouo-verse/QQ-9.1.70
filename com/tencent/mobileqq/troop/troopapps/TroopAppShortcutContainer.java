package com.tencent.mobileqq.troop.troopapps;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarHandler;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager;
import com.tencent.mobileqq.troop.troopapps.a;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.mobileqq.troop.utils.r;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0xe2e.oidb_0xe2e$App;
import tencent.im.oidb.cmd0xe2e.oidb_0xe2e$PlayingUser;
import tencent.im.oidb.cmd0xe2e.oidb_0xe2e$RspBody;
import tencent.im.oidb.cmd0xe2e.oidb_0xe2e$Tag;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAppShortcutContainer extends BroadcastReceiver implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    protected ListView C;
    private long D;
    private long E;
    private View F;
    private Long G;
    private boolean H;
    private d I;
    private Bundle J;
    private int K;
    private int L;
    protected com.tencent.mobileqq.troop.troopapps.api.b M;
    private i N;
    private long P;
    private long Q;
    private com.tencent.mobileqq.troop.shortcutbar.f R;

    /* renamed from: d, reason: collision with root package name */
    public Activity f299317d;

    /* renamed from: e, reason: collision with root package name */
    public SessionInfo f299318e;

    /* renamed from: f, reason: collision with root package name */
    protected int f299319f;

    /* renamed from: h, reason: collision with root package name */
    protected int f299320h;

    /* renamed from: i, reason: collision with root package name */
    protected int f299321i;

    /* renamed from: m, reason: collision with root package name */
    protected AppsListViewAdapter f299322m;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class AppsListViewAdapter extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private LinkedHashMap<Integer, ArrayList<com.tencent.mobileqq.troop.troopapps.b>> f299323d;

        /* renamed from: e, reason: collision with root package name */
        private Context f299324e;

        /* renamed from: f, reason: collision with root package name */
        private int f299325f;

        public AppsListViewAdapter(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                return;
            }
            this.f299323d = new LinkedHashMap<Integer, ArrayList<com.tencent.mobileqq.troop.troopapps.b>>() { // from class: com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer.AppsListViewAdapter.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AppsListViewAdapter.this);
                        return;
                    }
                    put(0, new ArrayList());
                    put(1, new ArrayList());
                    put(2, new ArrayList());
                    put(3, new ArrayList());
                }
            };
            this.f299325f = 0;
            this.f299324e = context;
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return this.f299325f;
        }

        @Override // android.widget.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.tencent.mobileqq.troop.troopapps.b getItem(int i3) {
            int size;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (com.tencent.mobileqq.troop.troopapps.b) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            int i16 = 0;
            for (Map.Entry<Integer, ArrayList<com.tencent.mobileqq.troop.troopapps.b>> entry : this.f299323d.entrySet()) {
                i16 += entry.getValue().size();
                if (i3 < i16 && (size = i3 - (i16 - entry.getValue().size())) >= 0 && size < entry.getValue().size()) {
                    return entry.getValue().get(size);
                }
            }
            return null;
        }

        public void c(int i3, com.tencent.mobileqq.troop.troopapps.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bVar);
            } else if (this.f299323d.containsKey(Integer.valueOf(i3))) {
                this.f299323d.get(Integer.valueOf(i3)).clear();
                this.f299323d.get(Integer.valueOf(i3)).add(bVar);
                notifyDataSetChanged();
            }
        }

        public void d(int i3, List<com.tencent.mobileqq.troop.troopapps.b> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) list);
            } else if (this.f299323d.containsKey(Integer.valueOf(i3))) {
                this.f299323d.get(Integer.valueOf(i3)).clear();
                this.f299323d.get(Integer.valueOf(i3)).addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            Iterator<Map.Entry<Integer, ArrayList<com.tencent.mobileqq.troop.troopapps.b>>> it = this.f299323d.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                i3 += it.next().getValue().size();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Long) iPatchRedirector.redirect((short) 8, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, i3)).intValue();
            }
            com.tencent.mobileqq.troop.troopapps.b item = getItem(i3);
            if (item != null) {
                return item.d();
            }
            return -1;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                view2 = (View) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mobileqq.troop.troopapps.b item = getItem(i3);
                if (item != null) {
                    View e16 = item.e(i3, view, viewGroup);
                    this.f299325f = (int) (this.f299325f + (System.currentTimeMillis() - currentTimeMillis));
                    view2 = e16;
                } else {
                    view2 = null;
                }
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return 4;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends com.tencent.mobileqq.troop.troopapps.api.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAppShortcutContainer.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopapps.api.b
        public void d(boolean z16, Object obj, Object obj2, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopAppShortcutContainer.this.n(z16, obj, obj2, i3);
            } else {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj, obj2, Integer.valueOf(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements AbsListView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f299326d;

        /* renamed from: e, reason: collision with root package name */
        int f299327e;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAppShortcutContainer.this);
            } else {
                this.f299326d = 0;
                this.f299327e = 0;
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            int i18 = (i3 + i16) - 1;
            this.f299326d = i18;
            this.f299327e = i17;
            TroopAppShortcutContainer.this.M(i18);
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) absListView, i3);
                return;
            }
            if (i3 != 0 || this.f299326d != this.f299327e - 1 || !TroopAppShortcutContainer.this.I.b()) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopAppShortcutContainer", 2, "needLoad mCurPage:" + TroopAppShortcutContainer.this.I.a());
            }
            TroopAppShortcutContainer troopAppShortcutContainer = TroopAppShortcutContainer.this;
            troopAppShortcutContainer.O(troopAppShortcutContainer.I.a() + 1, 30, 2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class c extends com.tencent.mobileqq.troop.shortcutbar.f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAppShortcutContainer.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.shortcutbar.f
        protected void e(long j3, boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("TroopAppShortcutContainer", 2, "onSetTotalSwitch:" + String.valueOf(j3) + "isSuccess" + z16 + "disabled" + i3);
            }
            TroopAppShortcutContainer troopAppShortcutContainer = TroopAppShortcutContainer.this;
            Activity activity = troopAppShortcutContainer.f299317d;
            com.tencent.mobileqq.troop.troopapps.b aVar = new com.tencent.mobileqq.troop.troopapps.a(activity, activity, troopAppShortcutContainer.m(), TroopAppShortcutContainer.this.J);
            a.C8785a c8785a = new a.C8785a();
            TroopShortcutBarInfo m3 = ((TroopShortcutBarManager) TroopAppShortcutContainer.this.j().getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).m(Long.valueOf(TroopAppShortcutContainer.this.D));
            if (m3 != null) {
                c8785a.f299356e = m3;
            }
            c8785a.f299353b = r.h(TroopAppShortcutContainer.this.j(), TroopAppShortcutContainer.this.D);
            if (!z16) {
                if (i3 == 0) {
                    z17 = false;
                }
                c8785a.f299352a = z17;
            } else {
                if (i3 != 0) {
                    z17 = false;
                }
                c8785a.f299352a = z17;
            }
            r.j(TroopAppShortcutContainer.this.j(), c8785a, TroopAppShortcutContainer.this.D);
            aVar.f(c8785a);
            TroopAppShortcutContainer.this.f299322m.c(0, aVar);
        }

        @Override // com.tencent.mobileqq.troop.shortcutbar.f
        protected void f(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
                return;
            }
            if (j3 != TroopAppShortcutContainer.this.D) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("TroopAppShortcutContainer", 2, "onShortcutBarItemUpdated troopCode:" + j3);
            }
            TroopAppShortcutContainer.this.O(1, 0, 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f299330a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f299331b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f299332c;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                c();
            }
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.f299330a;
        }

        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (!this.f299332c && !this.f299331b && this.f299330a != 0) {
                return true;
            }
            return false;
        }

        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f299330a = 0;
            this.f299331b = false;
            this.f299332c = true;
        }

        public d d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (d) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            this.f299330a = i3;
            return this;
        }

        public d e(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (d) iPatchRedirector.redirect((short) 7, (Object) this, z16);
            }
            this.f299332c = z16;
            return this;
        }

        public d f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (d) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            this.f299331b = true;
            return this;
        }

        public d g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (d) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            this.f299331b = false;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f299333a;

        /* renamed from: b, reason: collision with root package name */
        public int f299334b;

        /* renamed from: c, reason: collision with root package name */
        public long f299335c;

        /* renamed from: d, reason: collision with root package name */
        public long f299336d;

        /* renamed from: e, reason: collision with root package name */
        public String f299337e;

        /* renamed from: f, reason: collision with root package name */
        public String f299338f;

        /* renamed from: g, reason: collision with root package name */
        public String f299339g;

        /* renamed from: h, reason: collision with root package name */
        public int f299340h;

        /* renamed from: i, reason: collision with root package name */
        public int f299341i;

        /* renamed from: j, reason: collision with root package name */
        public String f299342j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f299343k;

        /* renamed from: l, reason: collision with root package name */
        public int f299344l;

        /* renamed from: m, reason: collision with root package name */
        public String f299345m;

        /* renamed from: n, reason: collision with root package name */
        public int f299346n;

        /* renamed from: o, reason: collision with root package name */
        public int f299347o;

        /* renamed from: p, reason: collision with root package name */
        public int f299348p;

        /* renamed from: q, reason: collision with root package name */
        public int f299349q;

        /* renamed from: r, reason: collision with root package name */
        public List<String> f299350r;

        /* renamed from: s, reason: collision with root package name */
        public List<String> f299351s;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f299333a = 0;
            this.f299334b = 0;
            this.f299336d = 0L;
            this.f299340h = 0;
            this.f299341i = 0;
            this.f299337e = "";
            this.f299338f = "";
            this.f299339g = "";
            this.f299342j = "";
            this.f299343k = false;
            this.f299344l = 0;
            this.f299345m = "";
            this.f299346n = 0;
            this.f299347o = 0;
            this.f299348p = 0;
            this.f299349q = 0;
            this.f299350r = new ArrayList();
            this.f299351s = new ArrayList();
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
            }
            if (obj == null || !(obj instanceof e) || ((e) obj).f299336d != this.f299336d) {
                return false;
            }
            return true;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("TroopAppInfo{app_showtype='" + this.f299334b + "', app_type='" + this.f299335c + "', app_appid='" + this.f299336d + "', app_removable='" + this.f299340h + "', app_source='" + this.f299341i + "', app_name='" + this.f299337e + "', app_icon='" + this.f299338f + "', app_url='" + this.f299339g + "', app_desc='" + this.f299342j + "', app_added='" + this.f299343k + "', app_redpoint='" + this.f299344l + "', app_trace='" + this.f299345m + "', app_showframe='" + this.f299346n + "', app_playingnum='" + this.f299347o + "', app_friend_playingnum='" + this.f299348p + "', app_total_playingnum='" + this.f299349q + '\'');
            if (this.f299350r != null) {
                sb5.append(", app_playing_users='");
                int size = this.f299350r.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (i3 == size - 1) {
                        sb5.append(this.f299350r.get(i3) + "'");
                    } else {
                        sb5.append(this.f299350r.get(i3) + "\u3001 ");
                    }
                }
            }
            if (this.f299351s != null) {
                sb5.append(", app_recommend_tags='");
                int size2 = this.f299351s.size();
                for (int i16 = 0; i16 < size2; i16++) {
                    if (i16 == size2 - 1) {
                        sb5.append(this.f299351s.get(i16) + "'");
                    } else {
                        sb5.append(this.f299351s.get(i16) + "\u3001 ");
                    }
                }
            }
            sb5.append("}");
            return sb5.toString();
        }
    }

    public TroopAppShortcutContainer(Activity activity, SessionInfo sessionInfo, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, sessionInfo, str, Integer.valueOf(i3));
            return;
        }
        this.D = 0L;
        this.H = false;
        this.I = new d();
        this.J = new Bundle();
        this.K = 0;
        this.L = Integer.MAX_VALUE;
        this.M = new a();
        this.N = null;
        this.R = new c();
        this.f299317d = activity;
        this.f299318e = sessionInfo;
        this.f299319f = i3;
        this.f299320h = 1;
        this.f299321i = 1;
        try {
            this.D = Long.valueOf(str).longValue();
        } catch (Exception unused) {
            this.D = 0L;
            QLog.e("TroopAppShortcutContainer", 2, "TroopAppShortcutContainer troopuinerror:" + str);
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.f168548fv3, (ViewGroup) null);
        this.F = inflate;
        com.tencent.mobileqq.qui.b.f276860a.a((RelativeLayout) inflate.findViewById(R.id.if5), RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
        View findViewById = this.F.findViewById(R.id.jqb);
        ImageView imageView = (ImageView) this.F.findViewById(R.id.a47);
        TextView textView = (TextView) this.F.findViewById(R.id.f112046mv);
        imageView.setOnClickListener(this);
        r.o(imageView);
        if (AppSetting.f99565y) {
            textView.setFocusableInTouchMode(true);
            textView.setContentDescription(activity.getString(R.string.f2324374j));
            imageView.setClickable(true);
            imageView.setContentDescription(HardCodeUtil.qqStr(R.string.f171898lr0));
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(activity);
            layoutParams.setMargins(0, v() ? statusBarHeight - BaseAIOUtils.f(10.0f, findViewById.getResources()) : statusBarHeight, 0, 0);
            findViewById.setLayoutParams(layoutParams);
            ImmersiveUtils.setStatusBarDarkMode(activity.getWindow(), true);
        }
        this.I.c();
        u();
        s();
        T();
    }

    private void F() {
        if (this.H) {
            return;
        }
        this.H = true;
        j().addObserver(this.M);
        j().addObserver(this.R);
        J();
        t();
    }

    private void G() {
        ArrayList<e> c16;
        if (!this.H) {
            return;
        }
        this.H = false;
        j jVar = (j) j().getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
        if (jVar != null && (c16 = jVar.c(this.D)) != null && c16.size() > 10) {
            ArrayList<e> arrayList = new ArrayList<>();
            arrayList.addAll(c16.subList(0, 10));
            jVar.f(this.D, arrayList);
        }
        r();
        S();
        j().removeObserver(this.M);
        j().removeObserver(this.R);
        this.Q = System.currentTimeMillis();
        K();
        N();
    }

    private ArrayList<e> H(ArrayList<oidb_0xe2e$App> arrayList) {
        if (arrayList != null) {
            ArrayList<e> arrayList2 = new ArrayList<>();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                oidb_0xe2e$App oidb_0xe2e_app = arrayList.get(i3);
                if (oidb_0xe2e_app.appid.has() && oidb_0xe2e_app.icon.has() && oidb_0xe2e_app.name.has() && oidb_0xe2e_app.url.has()) {
                    e eVar = new e();
                    eVar.f299336d = oidb_0xe2e_app.appid.get();
                    eVar.f299337e = oidb_0xe2e_app.name.get();
                    eVar.f299339g = oidb_0xe2e_app.url.get();
                    eVar.f299338f = oidb_0xe2e_app.icon.get();
                    if (oidb_0xe2e_app.type.has()) {
                        eVar.f299335c = oidb_0xe2e_app.type.get();
                    }
                    if (oidb_0xe2e_app.removable.has()) {
                        eVar.f299340h = oidb_0xe2e_app.removable.get();
                    }
                    if (oidb_0xe2e_app.source.has()) {
                        eVar.f299341i = oidb_0xe2e_app.source.get();
                    }
                    if (oidb_0xe2e_app.desc.has()) {
                        eVar.f299342j = oidb_0xe2e_app.desc.get();
                    }
                    if (oidb_0xe2e_app.added.has()) {
                        boolean z16 = true;
                        if (oidb_0xe2e_app.added.get() != 1) {
                            z16 = false;
                        }
                        eVar.f299343k = z16;
                    }
                    if (oidb_0xe2e_app.redpoint.has()) {
                        eVar.f299344l = oidb_0xe2e_app.redpoint.get();
                    }
                    if (oidb_0xe2e_app.cmd_trace.has()) {
                        eVar.f299345m = oidb_0xe2e_app.cmd_trace.get();
                    }
                    if (oidb_0xe2e_app.show_frame.has()) {
                        eVar.f299346n = oidb_0xe2e_app.show_frame.get();
                    }
                    if (oidb_0xe2e_app.playing_num.has()) {
                        eVar.f299347o = oidb_0xe2e_app.playing_num.get();
                    }
                    if (oidb_0xe2e_app.qq_friend_playing_num.has()) {
                        eVar.f299348p = oidb_0xe2e_app.qq_friend_playing_num.get();
                    }
                    if (oidb_0xe2e_app.total_playing_num.has()) {
                        eVar.f299349q = oidb_0xe2e_app.total_playing_num.get();
                    }
                    if (oidb_0xe2e_app.playing_users.has()) {
                        if (eVar.f299350r == null) {
                            eVar.f299350r = new ArrayList();
                        }
                        for (int i16 = 0; i16 < oidb_0xe2e_app.playing_users.size(); i16++) {
                            oidb_0xe2e$PlayingUser oidb_0xe2e_playinguser = oidb_0xe2e_app.playing_users.get(i16);
                            if (oidb_0xe2e_playinguser.uin.has()) {
                                eVar.f299350r.add(String.valueOf(oidb_0xe2e_playinguser.uin.get()));
                            }
                        }
                    }
                    if (oidb_0xe2e_app.tags.has()) {
                        if (eVar.f299351s == null) {
                            eVar.f299351s = new ArrayList();
                        }
                        for (int i17 = 0; i17 < oidb_0xe2e_app.tags.size(); i17++) {
                            oidb_0xe2e$Tag oidb_0xe2e_tag = oidb_0xe2e_app.tags.get(i17);
                            if (oidb_0xe2e_tag.name.has() && !oidb_0xe2e_tag.name.get().isEmpty()) {
                                eVar.f299351s.add(oidb_0xe2e_tag.name.get());
                            }
                        }
                    }
                    eVar.f299334b = 0;
                    arrayList2.add(eVar);
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopAppShortcutContainer", 2, "info:" + eVar.toString());
                    }
                } else {
                    QLog.e("TroopAppShortcutContainer", 2, "get appinfo error:" + oidb_0xe2e_app.toString());
                }
            }
            return arrayList2;
        }
        return null;
    }

    private void J() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.addgroupapplication");
            this.f299317d.registerReceiver(this, intentFilter);
        } catch (Exception unused) {
            QLog.e("TroopAppShortcutContainer", 1, "registerMiniAppAdd exception.");
        }
    }

    private void K() {
        HashMap hashMap = new HashMap();
        hashMap.put("troopUin", Long.valueOf(this.D));
        hashMap.put("costTime", Integer.valueOf(this.f299322m.a()));
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("troop_apps_page_view_cost_time", hashMap);
    }

    private void L(ArrayList<e> arrayList) {
        String str;
        if (arrayList == null) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String valueOf = String.valueOf(this.D);
            String valueOf2 = String.valueOf(this.E);
            String valueOf3 = String.valueOf(arrayList.get(i3).f299336d);
            String valueOf4 = String.valueOf(this.f299319f);
            if (arrayList.get(i3).f299335c == 0) {
                str = "1";
            } else {
                str = "2";
            }
            ReportController.o(null, "dc00898", "", valueOf, "0X800AFBA", "0X800AFBA", 0, 0, valueOf2, valueOf3, valueOf4, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i3) {
        int i16 = this.L;
        if (i3 <= i16 || this.f299322m == null) {
            return;
        }
        while (i16 < i3) {
            com.tencent.mobileqq.troop.troopapps.b item = this.f299322m.getItem(i16);
            if (item != null && (item instanceof com.tencent.mobileqq.troop.troopapps.d)) {
                Object c16 = item.c();
                if (c16 != null && (c16 instanceof e)) {
                    e eVar = (e) c16;
                    ReportController.o(null, "dc00898", "", String.valueOf(this.D), "0X800AFBC", "0X800AFBC", 0, 0, String.valueOf(this.E), String.valueOf(eVar.f299336d), "", eVar.f299345m);
                } else {
                    return;
                }
            }
            i16++;
        }
        this.L = i3;
    }

    private void N() {
        long j3;
        long j16 = this.Q;
        if (j16 != 0) {
            long j17 = this.P;
            if (j17 != 0 && j16 > j17) {
                ReportController.o(null, "dc00898", "", String.valueOf(this.D), "0X800B23B", "0X800B23B", 0, 0, String.valueOf(this.E), "", String.valueOf(this.f299321i), String.valueOf(this.Q - this.P));
                j3 = 0;
                this.P = j3;
                this.Q = j3;
                this.f299321i = 1;
            }
        }
        j3 = 0;
        this.P = j3;
        this.Q = j3;
        this.f299321i = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(int i3, int i16, int i17) {
        TroopManager troopManager = (TroopManager) j().getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null) {
            TroopInfo k3 = troopManager.k(String.valueOf(this.D));
            if (k3 != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAppShortcutContainer", 2, "reqGetShortcutTroopApps troopuin:" + this.D + " dwGroupClassExt" + k3.dwGroupClassExt + " page:" + i17 + " from:" + i17);
                }
                ((com.tencent.mobileqq.troop.troopapps.api.a) j().getBusinessHandler(BusinessHandlerFactory.TROOP_APP_HANDLER)).N1(this.D, (int) k3.dwGroupClassExt, i3, i16, i17);
                this.I.f();
                return;
            }
            QLog.e("TroopAppShortcutContainer", 2, "get troopClassExt error");
        }
    }

    private void S() {
        try {
            this.f299317d.unregisterReceiver(this);
        } catch (Exception unused) {
            QLog.e("TroopAppShortcutContainer", 1, "unregisterMiniAppAdd exception.");
        }
    }

    private void T() {
        V(TroopAppShortCutUpdateSource.Init);
        W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQAppInterface j() {
        return TroopUtils.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z16, Object obj, Object obj2, int i3) {
        if (obj == null || !(obj instanceof Bundle)) {
            return;
        }
        Bundle bundle = (Bundle) obj;
        oidb_0xe2e$RspBody oidb_0xe2e_rspbody = (oidb_0xe2e$RspBody) obj2;
        long j3 = bundle.getLong("troopuin", 0L);
        int i16 = bundle.getInt("from", -1);
        int i17 = bundle.getInt("page", -1);
        if (j3 != this.D) {
            QLog.d("TroopAppShortcutContainer", 2, "handlerGetShortcutTroopApps troopUin note same mTroopUin:" + this.D + " troopUin:" + j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAppShortcutContainer", 2, "handlerGetShortcutTroopApps troopuin:" + this.D + " page:" + i16 + " from:" + i16);
        }
        if (obj2 == null || !(obj2 instanceof oidb_0xe2e$RspBody)) {
            QLog.d("TroopAppShortcutContainer", 2, "handlerGetShortcutTroopApps infos not instanceof oidb_0xe2e.RspBody");
            z16 = false;
        }
        if (z16) {
            if (i16 == 1) {
                p(oidb_0xe2e_rspbody);
                return;
            } else if (i16 == 2) {
                q(oidb_0xe2e_rspbody, i17);
                return;
            } else {
                if (i16 == 3) {
                    o(oidb_0xe2e_rspbody);
                    return;
                }
                return;
            }
        }
        this.I.g();
        QLog.e("TroopAppShortcutContainer", 2, "reqGetShortcutTroopApps faild troopUin:" + this.D + " errCode:" + i3 + " from:" + i16);
        if (i3 == 1002) {
            Activity activity = this.f299317d;
            QQToast.makeText(activity, 1, activity.getString(R.string.f2069259m), 0).show();
        } else {
            Activity activity2 = this.f299317d;
            QQToast.makeText(activity2, 1, activity2.getString(R.string.f2069359n), 0).show();
        }
    }

    private void o(oidb_0xe2e$RspBody oidb_0xe2e_rspbody) {
        j jVar;
        this.I.g();
        ArrayList<e> H = H((ArrayList) oidb_0xe2e_rspbody.get_apps.get());
        if (H != null && (jVar = (j) j().getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER)) != null) {
            jVar.e(this.D, H);
            ArrayList<e> c16 = jVar.c(this.D);
            boolean z16 = false;
            if (c16 != null) {
                boolean z17 = false;
                for (int i3 = 0; i3 < c16.size(); i3++) {
                    e eVar = c16.get(i3);
                    if (H.contains(eVar)) {
                        if (!eVar.f299343k) {
                            eVar.f299343k = true;
                            z17 = true;
                        }
                    } else if (eVar.f299343k) {
                        eVar.f299343k = false;
                        z17 = true;
                    }
                }
                z16 = z17;
            }
            V(TroopAppShortCutUpdateSource.TroopAppManagerRefresh);
            L(H);
            if (z16) {
                W();
            }
        }
    }

    private void p(oidb_0xe2e$RspBody oidb_0xe2e_rspbody) {
        ArrayList<e> H = H((ArrayList) oidb_0xe2e_rspbody.get_apps.get());
        if (H != null) {
            j jVar = (j) j().getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
            if (jVar != null) {
                jVar.e(this.D, H);
            }
            V(TroopAppShortCutUpdateSource.TroopAppPageRequest);
            L(H);
        }
        if (oidb_0xe2e_rspbody.max_app_num.has()) {
            this.K = oidb_0xe2e_rspbody.max_app_num.get();
        }
        boolean z16 = true;
        if (oidb_0xe2e_rspbody.reach_tail.has()) {
            d d16 = this.I.d(1);
            if (oidb_0xe2e_rspbody.reach_tail.get() != 1) {
                z16 = false;
            }
            d16.e(z16).g();
            if (QLog.isColorLevel()) {
                QLog.d("TroopAppShortcutContainer", 2, "handlerGetShortcutTroopApps_home reach_tail:" + oidb_0xe2e_rspbody.reach_tail.get());
            }
        } else {
            this.I.d(1).e(true).g();
        }
        ArrayList<e> H2 = H((ArrayList) oidb_0xe2e_rspbody.recommend_apps.get());
        if (H2 != null) {
            j jVar2 = (j) j().getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
            if (jVar2 != null) {
                jVar2.f(this.D, H2);
            }
            W();
            if (H2.size() > 0) {
                ReportController.o(null, "dc00898", "", String.valueOf(this.D), "0X800AFBB", "0X800AFBB", 0, 0, String.valueOf(this.E), "", "", "");
                this.L = 0;
            }
        }
    }

    private void q(oidb_0xe2e$RspBody oidb_0xe2e_rspbody, int i3) {
        boolean z16 = true;
        if (oidb_0xe2e_rspbody.reach_tail.has()) {
            d d16 = this.I.d(i3);
            if (oidb_0xe2e_rspbody.reach_tail.get() != 1) {
                z16 = false;
            }
            d16.e(z16).g();
            if (QLog.isColorLevel()) {
                QLog.d("TroopAppShortcutContainer", 2, "handlerGetShortcutTroopApps_moreRecommend reach_tail:" + oidb_0xe2e_rspbody.reach_tail.get());
            }
        } else {
            this.I.d(i3).e(true).g();
        }
        ArrayList<e> H = H((ArrayList) oidb_0xe2e_rspbody.recommend_apps.get());
        if (H != null) {
            j jVar = (j) j().getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
            if (jVar != null) {
                ArrayList<e> c16 = jVar.c(this.D);
                if (c16 == null) {
                    jVar.f(this.D, H);
                } else {
                    c16.addAll(H);
                }
            }
            W();
        }
    }

    private void s() {
        this.C = (ListView) this.F.findViewById(R.id.sut);
        AppsListViewAdapter appsListViewAdapter = new AppsListViewAdapter(this.f299317d);
        this.f299322m = appsListViewAdapter;
        this.C.setAdapter((ListAdapter) appsListViewAdapter);
        this.C.setOnScrollListener(new b());
    }

    private void u() {
        TroopInfo B;
        TroopManager troopManager = (TroopManager) j().getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null && (B = troopManager.B(String.valueOf(this.D))) != null) {
            this.E = B.dwGroupClassExt;
        }
        this.J.clear();
        this.J.putLong("troopUin", this.D);
        this.J.putLong("troopClassExt", this.E);
        this.J.putInt("reportFrom", this.f299320h);
        this.J.putBoolean("isNight", ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null));
        this.J.putBoolean("isAdminOrOwner", r.h(j(), this.D));
        this.J.putParcelable("sessionInfo", this.f299318e);
    }

    private boolean v() {
        if (Build.VERSION.SDK_INT == 28 && CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equals(Build.MANUFACTURER) && "SM-G9750".equals(DeviceInfoMonitor.getModel())) {
            return true;
        }
        return false;
    }

    private boolean x() {
        j jVar = (j) j().getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
        if (jVar != null) {
            return jVar.d();
        }
        return false;
    }

    private void z() {
        ArrayList<e> arrayList;
        y(true);
        j jVar = (j) j().getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
        if (jVar != null) {
            arrayList = jVar.b(this.D);
        } else {
            arrayList = null;
        }
        StringBuilder sb5 = new StringBuilder("");
        if (arrayList != null) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                sb5.append(arrayList.get(i3).f299336d);
                sb5.append("-");
                int i16 = i3 + 1;
                sb5.append(i16);
                if (i3 != size - 1) {
                    sb5.append(";");
                }
                i3 = i16;
            }
        }
        ReportController.o(null, "dc00898", "", String.valueOf(this.D), "0X800AFC9", "0X800AFC9", 0, 0, String.valueOf(this.E), "", sb5.toString(), "");
    }

    public void A(@NonNull Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) configuration);
            return;
        }
        QLog.i("TroopAppShortcutContainer", 1, "[onConfigurationChanged] start");
        s();
        T();
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAppShortcutContainer", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        j jVar = (j) j().getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
        if (jVar != null) {
            jVar.a();
        }
        G();
    }

    public void C() {
        ListView listView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f299320h = 1;
        this.L = Integer.MAX_VALUE;
        if (this.f299319f == 1 && (listView = this.C) != null) {
            listView.smoothScrollToPosition(0);
        }
        G();
    }

    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        U(1);
        ReportController.o(null, "dc00898", "", String.valueOf(this.D), "0X800AD08", "0X800AD08", 0, 0, String.valueOf(this.E), "", String.valueOf(this.f299320h), "");
        this.P = System.currentTimeMillis();
    }

    public void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            F();
        }
    }

    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        O(1, 0, 3);
        this.f299320h = 5;
        ReportController.o(null, "dc00898", "", String.valueOf(this.D), "0X800AD08", "0X800AD08", 0, 0, String.valueOf(this.E), "", String.valueOf(this.f299320h), "");
    }

    public void P(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f299320h = i3;
            this.f299321i = i3;
        }
    }

    public void Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (this.N == null) {
            this.N = new i(this.f299317d);
        }
        this.N.show();
    }

    public void R() {
        TroopInfo k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else if (j() != null && (k3 = ((TroopManager) j().getManager(QQManagerFactory.TROOP_MANAGER)).k(String.valueOf(this.D))) != null && k3.isOwnerOrAdmin(j().getCurrentAccountUin())) {
            ((TroopShortcutBarHandler) j().getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE)).E2(this.D, (int) k3.dwGroupClassExt, null);
        }
    }

    protected void U(int i3) {
        ArrayList<e> arrayList;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        if (this.f299322m != null) {
            j jVar = (j) j().getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
            if (jVar != null) {
                arrayList = jVar.b(this.D);
            } else {
                arrayList = null;
            }
            if (arrayList != null && arrayList.size() > 0) {
                Activity activity = this.f299317d;
                com.tencent.mobileqq.troop.troopapps.b aVar = new com.tencent.mobileqq.troop.troopapps.a(activity, activity, this, this.J);
                a.C8785a c8785a = new a.C8785a();
                TroopShortcutBarInfo m3 = ((TroopShortcutBarManager) j().getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).m(Long.valueOf(this.D));
                if (m3 != null) {
                    c8785a.f299356e = m3;
                    boolean h16 = r.h(j(), this.D);
                    c8785a.f299353b = h16;
                    if (h16) {
                        if (m3.getGroupDisabled() == 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        c8785a.f299352a = z17;
                    } else {
                        if (m3.getDisabled() == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        c8785a.f299352a = z16;
                    }
                    r.j(j(), c8785a, this.D);
                    if (QLog.isColorLevel()) {
                        QLog.e("TroopAppShortcutContainer", 2, "updateUI_aioShortCut", "info.bAdmin :" + c8785a.f299353b + "info.bSwith :" + c8785a.f299352a + "info.bAdminShowSwitch :" + c8785a.f299354c + "info.bMemberShowSwitch :" + c8785a.f299355d + "TroopUin: " + String.valueOf(this.D));
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.e("TroopAppShortcutContainer", 2, "updateUI_aioShortCut. troopShortcutBarInfo is null, TroopUin: " + String.valueOf(this.D));
                }
                aVar.f(c8785a);
                this.f299322m.c(0, aVar);
                if (i3 == 1 && !c8785a.f299353b && c8785a.f299355d && c8785a.f299356e.getGroupDisabled() == 0) {
                    ReportController.o(null, "dc00898", "", String.valueOf(this.D), "0X800AFC0", "0X800AFC0", 0, 0, String.valueOf(this.E), "", "", "");
                    return;
                }
                return;
            }
            this.f299322m.d(0, new ArrayList());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V(TroopAppShortCutUpdateSource troopAppShortCutUpdateSource) {
        TroopShortcutBarInfo m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) troopAppShortCutUpdateSource);
            return;
        }
        ArrayList<e> arrayList = null;
        if ((troopAppShortCutUpdateSource == TroopAppShortCutUpdateSource.TroopAppManagerRefresh || troopAppShortCutUpdateSource == TroopAppShortCutUpdateSource.AddTroopRecommendApp) && (m3 = ((TroopShortcutBarManager) j().getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).m(Long.valueOf(this.D))) != null && m3.getDisabled() == 0) {
            ((TroopShortcutBarHandler) j().getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE)).E2(this.D, (int) this.E, null);
        }
        U(2);
        j jVar = (j) j().getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
        if (jVar != null) {
            arrayList = jVar.b(this.D);
        }
        if (this.f299322m != null) {
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(arrayList);
                Activity activity = this.f299317d;
                com.tencent.mobileqq.troop.troopapps.c cVar = new com.tencent.mobileqq.troop.troopapps.c(activity, activity, this.J);
                cVar.f(arrayList2);
                this.f299322m.c(1, cVar);
                return;
            }
            this.f299322m.d(1, new ArrayList());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W() {
        ArrayList<e> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (!x()) {
            AppsListViewAdapter appsListViewAdapter = this.f299322m;
            if (appsListViewAdapter != null) {
                appsListViewAdapter.d(2, new ArrayList());
                this.f299322m.d(3, new ArrayList());
                return;
            }
            return;
        }
        j jVar = (j) j().getManager(QQManagerFactory.TROOPAPP_SHORTCUT_MANAGER);
        if (jVar != null) {
            arrayList = jVar.c(this.D);
        } else {
            arrayList = null;
        }
        if (this.f299322m != null) {
            if (arrayList != null && arrayList.size() > 0) {
                Activity activity = this.f299317d;
                this.f299322m.c(2, new com.tencent.mobileqq.troop.troopapps.e(activity, activity, this.J));
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    Activity activity2 = this.f299317d;
                    com.tencent.mobileqq.troop.troopapps.d dVar = new com.tencent.mobileqq.troop.troopapps.d(activity2, activity2, this, this.J);
                    dVar.f(arrayList.get(i3));
                    arrayList2.add(dVar);
                }
                this.f299322m.d(3, arrayList2);
                return;
            }
            this.f299322m.d(2, new ArrayList());
            this.f299322m.d(3, new ArrayList());
        }
    }

    public void i(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 20006 || i3 == 20007) {
            O(1, 0, 3);
        }
        this.f299320h = 5;
        ReportController.o(null, "dc00898", "", String.valueOf(this.D), "0X800AD08", "0X800AD08", 0, 0, String.valueOf(this.E), "", String.valueOf(this.f299320h), "");
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.K;
    }

    public View l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.F;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) view);
        } else {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Long l3 = this.G;
            if (l3 == null || elapsedRealtime - l3.longValue() >= 500) {
                this.G = Long.valueOf(elapsedRealtime);
                if (view.getId() == R.id.a47) {
                    z();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if ("com.tencent.mobileqq.addgroupapplication".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("groupUin");
            String stringExtra2 = intent.getStringExtra("appId");
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || !stringExtra.equals(String.valueOf(this.D))) {
                return;
            }
            O(1, 0, 3);
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        i iVar = this.N;
        if (iVar != null) {
            iVar.dismiss();
            this.N = null;
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.I.c();
        u();
        if (x()) {
            O(1, 30, 1);
        } else {
            O(1, 0, 1);
        }
    }

    public boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.H;
    }

    public void y(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TroopAppShortcutContainer m() {
        return this;
    }
}
