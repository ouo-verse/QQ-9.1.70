package com.tencent.weui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public abstract class WeUIPreference extends BaseActivity {
    static IPatchRedirector $redirector_;
    public RelativeLayout O;
    public TextView P;
    public ImageView Q;
    public com.tencent.luggage.wxa.nq.c R;
    public ListView S;
    public SharedPreferences T;
    public boolean U;
    public boolean V;

    /* loaded from: classes27.dex */
    public class a implements Preference.OnPreferenceChangeListener {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WeUIPreference.this);
            }
        }

        @Override // android.preference.Preference.OnPreferenceChangeListener
        public boolean onPreferenceChange(Preference preference, Object obj) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) preference, obj)).booleanValue();
            }
            if (!WeUIPreference.this.V && preference.isEnabled() && preference.isSelectable()) {
                WeUIPreference.this.V = true;
                if (preference instanceof CheckBoxPreference) {
                    CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
                    checkBoxPreference.setChecked(checkBoxPreference.isChecked());
                    if (checkBoxPreference.isPersistent()) {
                        WeUIPreference.this.T.edit().putBoolean(preference.getKey(), checkBoxPreference.isChecked()).commit();
                    }
                    WeUIPreference.this.U = true;
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (preference.getKey() != null) {
                    WeUIPreference weUIPreference = WeUIPreference.this;
                    weUIPreference.onPreferenceTreeClick(weUIPreference.R, preference);
                }
                if (z16) {
                    WeUIPreference.this.R.notifyDataSetChanged();
                }
                WeUIPreference.this.V = false;
                if (z16) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes27.dex */
    public class b implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WeUIPreference.this);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            Preference preference = (Preference) adapterView.getAdapter().getItem(i3);
            if (preference != null && preference.isEnabled() && preference.isSelectable() && !(preference instanceof CheckBoxPreference) && preference.getKey() != null) {
                WeUIPreference weUIPreference = WeUIPreference.this;
                weUIPreference.onPreferenceTreeClick(weUIPreference.R, preference);
            }
        }
    }

    /* loaded from: classes27.dex */
    public class c implements AdapterView.OnItemLongClickListener {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WeUIPreference.this);
            }
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
            }
            if (i3 < WeUIPreference.this.S.getHeaderViewsCount()) {
                return false;
            }
            int headerViewsCount = i3 - WeUIPreference.this.S.getHeaderViewsCount();
            if (headerViewsCount >= WeUIPreference.this.R.getCount()) {
                n.b("MicroMsg.mmui.WeUIPreference", "itemlongclick, outofindex, %d, %d", Integer.valueOf(headerViewsCount), Integer.valueOf(WeUIPreference.this.R.getCount()));
                return false;
            }
            Preference preference = (Preference) WeUIPreference.this.R.getItem(headerViewsCount);
            WeUIPreference weUIPreference = WeUIPreference.this;
            return weUIPreference.onPreferenceTreeLongClick(weUIPreference.R, preference, WeUIPreference.this.S);
        }
    }

    /* loaded from: classes27.dex */
    public class d implements AbsListView.OnScrollListener {
        static IPatchRedirector $redirector_;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WeUIPreference.this);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            View currentFocus;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) absListView, i3);
            } else if (1 == i3 && (currentFocus = WeUIPreference.this.getCurrentFocus()) != null) {
                currentFocus.clearFocus();
            }
        }
    }

    public WeUIPreference() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.U = false;
            this.V = false;
        }
    }

    public com.tencent.luggage.wxa.nq.c createAdapter(SharedPreferences sharedPreferences) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (com.tencent.luggage.wxa.nq.c) iPatchRedirector.redirect((short) 21, (Object) this, (Object) sharedPreferences);
        }
        return new com.tencent.luggage.wxa.nq.c(this, sharedPreferences);
    }

    public void createUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            this.S.setAdapter((ListAdapter) this.R);
        }
    }

    public boolean dirty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.U;
    }

    public View getBottomView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (View) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return null;
    }

    public SharedPreferences getDefaultSharedPreferences() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.T;
    }

    public int getFooterResourceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return -1;
    }

    public View getFooterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (View) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return null;
    }

    public int getHeaderResourceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return -1;
    }

    public View getHeaderView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (View) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mm.ui.BaseActivity
    public int getLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.fkm;
    }

    public ListView getListView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (ListView) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.S;
    }

    public IPreferenceScreen getPreferenceScreen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (IPreferenceScreen) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.R;
    }

    public abstract int getResourceId();

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) menuItem)).booleanValue();
        }
        return super.onContextItemSelected(menuItem);
    }

    @Override // com.tencent.mm.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.T = sharedPreferences;
        this.R = createAdapter(sharedPreferences);
        this.S = (ListView) findViewById(android.R.id.list);
        this.O = (RelativeLayout) findViewById(R.id.f26900es);
        this.P = (TextView) findViewById(R.id.f26890er);
        this.Q = (ImageView) findViewById(R.id.f26880eq);
        k();
        int headerResourceId = getHeaderResourceId();
        View headerView = getHeaderView();
        if (headerResourceId != -1) {
            this.S.addHeaderView(getLayoutInflater().inflate(headerResourceId, (ViewGroup) null));
        } else if (headerView != null) {
            if (headerView.getLayoutParams() != null) {
                headerView.setLayoutParams(new AbsListView.LayoutParams(headerView.getLayoutParams()));
            } else {
                n.b("MicroMsg.mmui.WeUIPreference", "[arthurdan.mmpreference] Notice!!! header.getLayoutParams() is null!!!\n", new Object[0]);
            }
            this.S.addHeaderView(headerView);
        }
        int footerResourceId = getFooterResourceId();
        View footerView = getFooterView();
        if (footerResourceId != -1) {
            this.S.addFooterView(getLayoutInflater().inflate(footerResourceId, (ViewGroup) null));
        } else if (footerView != null) {
            if (footerView.getLayoutParams() != null) {
                footerView.setLayoutParams(new AbsListView.LayoutParams(footerView.getLayoutParams()));
            } else {
                n.b("MicroMsg.mmui.WeUIPreference", "[arthurdan.mmpreference] Notice!!! footer.getLayoutParams() is null!!!\n", new Object[0]);
            }
            this.S.addFooterView(footerView);
        }
        View bottomView = getBottomView();
        if (bottomView != null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.f26830el);
            frameLayout.addView(bottomView);
            frameLayout.setVisibility(0);
        }
        this.R.a(new a());
        int resourceId = getResourceId();
        if (resourceId != -1) {
            this.R.addPreferencesFromResource(resourceId);
        }
        this.S.setAdapter((ListAdapter) this.R);
        this.S.setOnItemClickListener(new b());
        this.S.setOnItemLongClickListener(new c());
        this.S.setOnScrollListener(new d());
    }

    public abstract boolean onPreferenceTreeClick(IPreferenceScreen iPreferenceScreen, Preference preference);

    public boolean onPreferenceTreeLongClick(IPreferenceScreen iPreferenceScreen, Preference preference, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, iPreferenceScreen, preference, view)).booleanValue();
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (j()) {
            this.R.notifyDataSetChanged();
        }
        super.onResume();
    }

    public boolean onSetToTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return true;
    }

    public void releaseUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            this.S.setAdapter((ListAdapter) null);
        }
    }

    public void setSelection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.S.setSelection(i3);
        }
    }
}
