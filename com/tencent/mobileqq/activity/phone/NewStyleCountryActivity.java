package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes10.dex */
public class NewStyleCountryActivity extends RegisterNewBaseActivity implements IndexView.b, View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private PinnedDividerListView f183871a0;

    /* renamed from: b0, reason: collision with root package name */
    IndexView f183872b0;

    /* renamed from: c0, reason: collision with root package name */
    private b f183873c0;

    /* renamed from: d0, reason: collision with root package name */
    ArrayList<PhoneCodeUtils.a> f183874d0;

    /* renamed from: e0, reason: collision with root package name */
    LinkedHashMap<String, Integer> f183875e0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewStyleCountryActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                NewStyleCountryActivity.this.onBackEvent();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private class b extends PinnedDividerListView.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewStyleCountryActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public void configDividerView(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, i3);
                return;
            }
            NewStyleCountryActivity newStyleCountryActivity = NewStyleCountryActivity.this;
            ((TextView) view).setText(NewStyleCountryActivity.this.f183874d0.get(newStyleCountryActivity.f183875e0.get(newStyleCountryActivity.f183874d0.get(i3).f307047a).intValue()).f307047a);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return NewStyleCountryActivity.this.f183874d0.size();
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public int getDividerLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return R.layout.fgc;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            return NewStyleCountryActivity.this.f183874d0.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
            }
            return !NewStyleCountryActivity.this.f183874d0.get(i3).f307048b ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                view2 = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                PhoneCodeUtils.a aVar = NewStyleCountryActivity.this.f183874d0.get(i3);
                if (getItemViewType(i3) == 0) {
                    if (view == null) {
                        view = NewStyleCountryActivity.this.getLayoutInflater().inflate(getDividerLayout(), viewGroup, false);
                    }
                    ((TextView) view).setText(aVar.f307047a);
                } else {
                    if (view == null) {
                        NewStyleCountryActivity newStyleCountryActivity = NewStyleCountryActivity.this;
                        view = newStyleCountryActivity.K2(viewGroup, newStyleCountryActivity.getLayoutInflater(), false);
                        view.setOnClickListener(NewStyleCountryActivity.this);
                    }
                    NewStyleCountryActivity newStyleCountryActivity2 = NewStyleCountryActivity.this;
                    newStyleCountryActivity2.I2(view, aVar, newStyleCountryActivity2.J2(i3, newStyleCountryActivity2.f183874d0));
                }
                view.setVisibility(0);
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 2;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public boolean isDividerView(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3)).booleanValue();
            }
            return NewStyleCountryActivity.this.f183874d0.get(i3).f307048b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public RelativeLayout f183878a;

        /* renamed from: b, reason: collision with root package name */
        public RelativeLayout f183879b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f183880c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f183881d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f183882e;

        /* renamed from: f, reason: collision with root package name */
        public PhoneCodeUtils.a f183883f;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public NewStyleCountryActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f183874d0 = new ArrayList<>();
            this.f183875e0 = new LinkedHashMap<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QUIListItemBackgroundType J2(int i3, ArrayList<PhoneCodeUtils.a> arrayList) {
        boolean z16;
        if (i3 >= 0 && i3 < arrayList.size()) {
            int i16 = i3 - 1;
            boolean z17 = false;
            if (i16 >= 0 && !arrayList.get(i16).f307048b) {
                z16 = false;
            } else {
                z16 = true;
            }
            int i17 = i3 + 1;
            if (i17 >= arrayList.size() || arrayList.get(i17).f307048b) {
                z17 = true;
            }
            if (z16 && z17) {
                return QUIListItemBackgroundType.AllRound;
            }
            if (z16) {
                return QUIListItemBackgroundType.TopRound;
            }
            if (z17) {
                return QUIListItemBackgroundType.BottomRound;
            }
            return QUIListItemBackgroundType.NoneRound;
        }
        QLog.e("NewStyleCountryActivity", 4, "wrong position, position=" + i3);
        return QUIListItemBackgroundType.AllRound;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View K2(ViewGroup viewGroup, LayoutInflater layoutInflater, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.bwq, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        layoutParams.height = ViewUtils.dpToPx(56.0f);
        inflate.setLayoutParams(layoutParams);
        inflate.setPadding(0, 0, 0, 0);
        c cVar = new c();
        cVar.f183878a = (RelativeLayout) inflate.findViewById(R.id.dqx);
        cVar.f183879b = (RelativeLayout) inflate.findViewById(R.id.u8h);
        cVar.f183880c = (TextView) inflate.findViewById(R.id.bar);
        cVar.f183881d = (TextView) inflate.findViewById(R.id.baq);
        cVar.f183882e = (ImageView) inflate.findViewById(R.id.ax5);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) cVar.f183880c.getLayoutParams();
        layoutParams2.leftMargin = ViewUtils.dpToPx(16.0f);
        cVar.f183880c.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) cVar.f183881d.getLayoutParams();
        layoutParams3.rightMargin = ViewUtils.dpToPx(16.0f);
        cVar.f183881d.setLayoutParams(layoutParams3);
        cVar.f183881d.setVisibility(0);
        cVar.f183882e.setVisibility(8);
        inflate.setTag(cVar);
        return inflate;
    }

    private void initTitleView() {
        findViewById(R.id.f243408v);
        findViewById(R.id.f243508w).setOnClickListener(new a());
    }

    void I2(View view, PhoneCodeUtils.a aVar, QUIListItemBackgroundType qUIListItemBackgroundType) {
        c cVar = (c) view.getTag();
        cVar.f183880c.setText(aVar.f307049c);
        cVar.f183881d.setText(Marker.ANY_NON_NULL_MARKER + aVar.f307050d);
        cVar.f183879b.setBackground(qUIListItemBackgroundType.getBackground(this, 1000));
        cVar.f183883f = aVar;
    }

    public void L2(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            return;
        }
        c cVar = (c) view.getTag();
        PhoneCodeUtils.a aVar = cVar.f183883f;
        if (aVar != null) {
            this.countryCode = aVar.f307050d;
            Intent intent = new Intent();
            intent.putExtra("k_name", cVar.f183883f.f307049c);
            intent.putExtra("k_code", cVar.f183883f.f307050d);
            intent.putExtra("k_english_name", cVar.f183883f.f307051e);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.tencent.mobileqq.activity.RegisterNewBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.RegisterNewBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        getWindow().clearFlags(1024);
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        setContentView(R.layout.bwo);
        initTitleView();
        this.countryCode = getIntent().getStringExtra("k_code");
        String[] stringArray = getResources().getStringArray(R.array.f155225bb);
        ArrayList<PhoneCodeUtils.a> g16 = PhoneCodeUtils.g(Utils.u(this, "internationalCode.json"));
        if (g16 == null) {
            g16 = this.f183874d0;
        }
        this.f183874d0 = g16;
        LinkedHashMap<String, Integer> e16 = PhoneCodeUtils.e(stringArray, g16);
        if (e16 == null) {
            e16 = this.f183875e0;
        }
        this.f183875e0 = e16;
        PinnedDividerListView pinnedDividerListView = (PinnedDividerListView) findViewById(R.id.bas);
        this.f183871a0 = pinnedDividerListView;
        pinnedDividerListView.setDivider(null);
        b bVar = new b();
        this.f183873c0 = bVar;
        this.f183871a0.setAdapter((ListAdapter) bVar);
        IndexView indexView = (IndexView) findViewById(R.id.djg);
        this.f183872b0 = indexView;
        indexView.setIndex(stringArray, true);
        this.f183872b0.setOnIndexChangedListener(this);
        this.f183872b0.setVisibility(8);
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.finish();
            overridePendingTransition(R.anim.f154548b2, R.anim.f154458a7);
        }
    }

    @Override // com.tencent.mobileqq.activity.RegisterNewBaseActivity
    protected boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            L2(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.RegisterNewBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else if ("$".equals(str)) {
            this.f183871a0.setSelection(0);
        } else {
            PinnedDividerListView pinnedDividerListView = this.f183871a0;
            pinnedDividerListView.setSelection(pinnedDividerListView.getHeaderViewsCount() + this.f183875e0.get(str).intValue());
        }
    }
}
