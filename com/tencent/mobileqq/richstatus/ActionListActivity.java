package com.tencent.mobileqq.richstatus;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.bo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ActionListActivity extends IphoneTitleBarActivity implements e, d, View.OnClickListener, TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: h0, reason: collision with root package name */
    static final boolean f282098h0;

    /* renamed from: a0, reason: collision with root package name */
    private StatusManager f282099a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f282100b0;

    /* renamed from: c0, reason: collision with root package name */
    TabHost f282101c0;

    /* renamed from: d0, reason: collision with root package name */
    TabWidget f282102d0;

    /* renamed from: e0, reason: collision with root package name */
    ViewPager f282103e0;

    /* renamed from: f0, reason: collision with root package name */
    ArrayList<l> f282104f0;

    /* renamed from: g0, reason: collision with root package name */
    private Intent f282105g0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public ImageView f282106a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f282107b;

        /* renamed from: c, reason: collision with root package name */
        public int f282108c;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<Integer> f282109d;

        public b(ArrayList<Integer> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionListActivity.this, (Object) arrayList);
            } else {
                this.f282109d = arrayList;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            ArrayList<Integer> arrayList = this.f282109d;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return this.f282109d.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = ActionListActivity.this.getLayoutInflater().inflate(R.layout.bzm, viewGroup, false);
                    a aVar = new a();
                    aVar.f282106a = (ImageView) view.findViewById(R.id.j5v);
                    aVar.f282107b = (TextView) view.findViewById(R.id.j5w);
                    view.setTag(aVar);
                }
                a aVar2 = (a) view.getTag();
                com.tencent.mobileqq.richstatus.a J = ActionListActivity.this.f282099a0.J(this.f282109d.get(i3).intValue());
                if (J != null) {
                    int i16 = aVar2.f282108c;
                    int i17 = J.f282295b;
                    if (i16 != i17) {
                        aVar2.f282108c = i17;
                        aVar2.f282106a.setImageDrawable(new bo(ActionListActivity.this.getResources(), ActionListActivity.this.f282099a0.K(J.f282295b, 201), false, false));
                        aVar2.f282107b.setText(J.f282298e);
                        if (J.f282300g == 1) {
                            aVar2.f282107b.setCompoundDrawables(null, null, null, null);
                        } else {
                            aVar2.f282107b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ActionListActivity.this.getResources().getDrawable(R.drawable.common_arrow_right_selector), (Drawable) null);
                            aVar2.f282107b.setCompoundDrawablePadding(10);
                        }
                    }
                }
                view.setOnClickListener(ActionListActivity.this);
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c extends PagerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<GridView> f282111d;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionListActivity.this);
            } else {
                this.f282111d = new ArrayList<>();
            }
        }

        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            this.f282111d.clear();
            try {
                Iterator<l> it = ActionListActivity.this.f282104f0.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    GridView gridView = new GridView(ActionListActivity.this.getApplicationContext());
                    gridView.setNumColumns(3);
                    gridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    gridView.setSelector(new ColorDrawable(0));
                    gridView.setScrollingCacheEnabled(false);
                    gridView.setAdapter((ListAdapter) new b(next.f282369b));
                    this.f282111d.add(gridView);
                }
            } catch (OutOfMemoryError unused) {
                System.gc();
            }
            super.notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(View view, int i3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, this, view, Integer.valueOf(i3), obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f282111d.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup, i3);
            }
            GridView gridView = this.f282111d.get(i3);
            viewGroup.addView(gridView);
            return gridView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, obj)).booleanValue();
            }
            if (view == obj) {
                return true;
            }
            return false;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                viewGroup.removeView(this.f282111d.get(i3));
            } else {
                iPatchRedirector.redirect((short) 4, this, viewGroup, Integer.valueOf(i3), obj);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74699);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            f282098h0 = AppSetting.f99565y;
        }
    }

    public ActionListActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f282104f0 = new ArrayList<>();
        }
    }

    private void initData() {
        if (this.f282104f0 == null) {
            this.f282104f0 = new ArrayList<>();
        }
        int P = this.f282099a0.P(this.f282104f0);
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.RICH_STATUS, 2, "ActionListActivity.initData(), state tag size: " + this.f282104f0.size() + " result: " + P);
        }
        if (P != 100) {
            this.f282099a0.i0(P);
            if (this.f282100b0 == -1 && (P == 102 || NetworkUtil.isNetSupport(this))) {
                startTitleProgress();
            }
        }
        int i3 = getResources().getDisplayMetrics().widthPixels;
        ArrayList<l> arrayList = this.f282104f0;
        if (arrayList != null && arrayList.size() > 0) {
            this.f282102d0.removeAllViews();
            LayoutInflater layoutInflater = getLayoutInflater();
            int size = this.f282104f0.size();
            int i16 = i3 / size;
            for (int i17 = 0; i17 < size; i17++) {
                l lVar = this.f282104f0.get(i17);
                TextView textView = (TextView) layoutInflater.inflate(R.layout.avb, (ViewGroup) this.f282102d0, false);
                textView.setText(lVar.f282368a);
                textView.setWidth(i16);
                textView.setGravity(17);
                TabHost tabHost = this.f282101c0;
                tabHost.addTab(tabHost.newTabSpec(lVar.f282368a).setIndicator(textView).setContent(R.id.f163836q));
            }
        }
        ((c) this.f282103e0.getAdapter()).d();
        int childCount = this.f282103e0.getChildCount();
        for (int i18 = 0; i18 < childCount; i18++) {
            ((b) ((GridView) this.f282103e0.getChildAt(i18)).getAdapter()).notifyDataSetChanged();
        }
    }

    void H2(int i3, Bitmap bitmap) {
        int childCount = this.f282103e0.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            GridView gridView = (GridView) this.f282103e0.getChildAt(i16);
            int childCount2 = gridView.getChildCount();
            for (int i17 = 0; i17 < childCount2; i17++) {
                a aVar = (a) gridView.getChildAt(i17).getTag();
                if (aVar != null && aVar.f282108c == i3) {
                    aVar.f282106a.setImageDrawable(new bo(getResources(), bitmap, false, false));
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 0 && i16 == -1) {
            Intent intent2 = this.f282105g0;
            if (intent2 == null) {
                this.f282105g0 = intent;
            } else {
                intent2.putExtras(intent);
            }
            setResult(-1, this.f282105g0);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        setContentView(R.layout.f167537a1);
        TabHost tabHost = (TabHost) findViewById(R.id.j_h);
        this.f282101c0 = tabHost;
        tabHost.setup();
        this.f282101c0.setOnTabChangedListener(this);
        this.f282102d0 = this.f282101c0.getTabWidget();
        MyViewPager myViewPager = (MyViewPager) findViewById(R.id.kwk);
        this.f282103e0 = myViewPager;
        myViewPager.setOnPageChangeListener(this);
        this.f282103e0.setAdapter(new c());
        StatusManager statusManager = (StatusManager) this.app.getManager(QQManagerFactory.STATUS_MANAGER);
        this.f282099a0 = statusManager;
        statusManager.C(this);
        int intExtra = getIntent().getIntExtra("k_action_id", -1);
        this.f282100b0 = intExtra;
        if (intExtra == -1) {
            setTitle(HardCodeUtil.qqStr(R.string.j1m));
            this.leftView.setVisibility(8);
            setRightButton(R.string.close, this);
        } else {
            com.tencent.mobileqq.richstatus.a J = this.f282099a0.J(intExtra);
            if (J != null) {
                setTitle(J.f282298e);
            } else {
                setTitle(HardCodeUtil.qqStr(R.string.j1j));
            }
        }
        if (f282098h0) {
            this.leftView.setContentDescription(((Object) this.leftView.getText()) + HardCodeUtil.qqStr(R.string.j1l));
            this.rightViewText.setContentDescription(getResources().getString(R.string.close) + HardCodeUtil.qqStr(R.string.j1k));
        }
        initData();
        if (this.f282102d0.getChildCount() > 0) {
            this.f282102d0.setCurrentTab(0);
            this.f282102d0.focusCurrentTab(0);
        }
        if (bundle != null) {
            Intent intent = new Intent();
            this.f282105g0 = intent;
            intent.putExtra("k_action_id", bundle.getLong("k_action_id", 0L));
            this.f282105g0.putExtra("k_action_text", bundle.getString("k_action_text"));
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f282099a0.b0(this);
            super.doOnDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnSaveInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bundle);
            return;
        }
        Intent intent = this.f282105g0;
        if (intent != null) {
            bundle.putLong("k_action_id", intent.getLongExtra("k_action_id", 0L));
            bundle.putString("k_action_text", this.f282105g0.getStringExtra("k_action_text"));
        }
        super.doOnSaveInstanceState(bundle);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.finish();
        if (this.f282100b0 == -1) {
            overridePendingTransition(0, R.anim.f154423k);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f5  */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v3, types: [int] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v7 */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        com.tencent.mobileqq.richstatus.a J;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) view);
        } else if (view == this.rightViewText) {
            finish();
        } else {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof a) && (J = this.f282099a0.J(((a) tag).f282108c)) != null) {
                Intent intent = new Intent();
                intent.putExtra("k_action_id", J.f282295b);
                intent.putExtra("k_action_text", J.f282299f);
                ?? r46 = J.f282300g;
                if (r46 == 1) {
                    ReportController.o(this.app, "CliOper", "", "", "0X8006988", "0X8006988", 0, 0, Integer.toString(J.f282295b), "", "", "");
                    setResult(-1, intent);
                    finish();
                } else if (r46 != 0) {
                    Intent intent2 = null;
                    try {
                        try {
                        } catch (Exception e16) {
                            e = e16;
                            intent2 = r46;
                        }
                    } catch (Exception e17) {
                        e = e17;
                    }
                    if (r46 != 3) {
                        if (r46 != 4) {
                            if (r46 == 5) {
                                Intent intent3 = new Intent(this, Class.forName(J.f282305l));
                                try {
                                    intent3.putExtra(PluginStatic.PARAM_PLUGIN_GESTURELOCK, true);
                                    String str = J.f282306m;
                                    if (str != null) {
                                        intent3.putExtra("key_params_qq", this.f282099a0.d0(str, J.f282295b, 0, ""));
                                    }
                                    intent2 = intent3;
                                } catch (Exception e18) {
                                    e = e18;
                                    intent2 = intent3;
                                    QLog.e(LogTag.RICH_STATUS, 1, "", e);
                                    if (intent2 != null) {
                                    }
                                    EventCollector.getInstance().onViewClicked(view);
                                }
                            }
                            if (intent2 != null) {
                                this.f282105g0 = intent;
                                startActivityForResult(intent2, 0);
                            }
                        } else {
                            String replace = J.f282301h.replace("$A", this.app.getCurrentAccountUin());
                            Intent intent4 = new Intent(this, (Class<?>) ActionUrlActivity.class);
                            intent4.putExtra("key_params_qq", replace);
                            r46 = intent4;
                        }
                    } else {
                        Intent intent5 = new Intent(this, (Class<?>) ActionListActivity.class);
                        intent5.putExtra("k_action_id", J.f282295b);
                        r46 = intent5;
                    }
                    intent2 = r46;
                    if (intent2 != null) {
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.richstatus.e
    public void onGetIcon(int i3, int i16, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), bitmap);
        } else if (bitmap != null && i16 == 201) {
            H2(i3, bitmap);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.f282101c0.setCurrentTab(i3);
        }
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        int i3 = 0;
        while (i3 < this.f282104f0.size() && !str.equals(this.f282104f0.get(i3).f282368a)) {
            i3++;
        }
        this.f282103e0.setCurrentItem(i3, false);
    }

    @Override // com.tencent.mobileqq.richstatus.d
    public void v2(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.RICH_STATUS, 2, "ActionListActivity.onGetActions(), result: " + i3 + " message: " + i16);
        }
        if (i3 == 102) {
            initData();
        }
        stopTitleProgress();
    }
}
