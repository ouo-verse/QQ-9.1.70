package com.tencent.mobileqq.conditionsearch;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.widget.CountrySelect.CountrySelectView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.selectorview.model.BaseAddress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.relation.common.utils.f;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CountrySelectActivity extends IphoneTitleBarActivity implements View.OnClickListener, IndexView.b {
    static IPatchRedirector $redirector_;

    /* renamed from: i0, reason: collision with root package name */
    static final boolean f201938i0;

    /* renamed from: j0, reason: collision with root package name */
    private static final String[] f201939j0;

    /* renamed from: a0, reason: collision with root package name */
    PinnedDividerListView f201940a0;

    /* renamed from: b0, reason: collision with root package name */
    a f201941b0;

    /* renamed from: c0, reason: collision with root package name */
    IndexView f201942c0;

    /* renamed from: d0, reason: collision with root package name */
    List<Object> f201943d0;

    /* renamed from: e0, reason: collision with root package name */
    LinkedHashMap<String, Integer> f201944e0;

    /* renamed from: f0, reason: collision with root package name */
    String f201945f0;

    /* renamed from: g0, reason: collision with root package name */
    boolean f201946g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f201947h0;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class a extends PinnedDividerListView.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CountrySelectActivity.this);
            }
        }

        private void b(c cVar, View view) {
            if (CountrySelectActivity.this.isDarkModeAdapter()) {
                cVar.f201950a.setTextColor(CountrySelectActivity.this.getResources().getColor(R.color.f158017al3));
                int color = CountrySelectActivity.this.getResources().getColor(R.color.cq9);
                if (view == null) {
                    return;
                }
                view.setBackgroundColor(color);
            }
        }

        private void c(TextView textView) {
            if (CountrySelectActivity.this.isDarkModeAdapter()) {
                textView.setTextColor(CountrySelectActivity.this.getResources().getColor(R.color.f157797zn));
                textView.setBackgroundColor(CountrySelectActivity.this.getResources().getColor(R.color.cih));
            }
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public void configDividerView(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, i3);
                return;
            }
            TextView textView = (TextView) view;
            Object item = getItem(i3);
            if (item instanceof b) {
                textView.setText(((b) item).f201949a);
            } else if (item instanceof BaseAddress) {
                textView.setText(((BaseAddress) item).pinyinFirst);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return CountrySelectActivity.this.f201943d0.size();
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public int getDividerLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return R.layout.f168366u3;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            return CountrySelectActivity.this.f201943d0.get(i3);
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
            return !(CountrySelectActivity.this.f201943d0.get(i3) instanceof b) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                view2 = view;
                view = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                if (getItemViewType(i3) == 0) {
                    if (view == null) {
                        view = CountrySelectActivity.this.getLayoutInflater().inflate(getDividerLayout(), (ViewGroup) null);
                    }
                    TextView textView = (TextView) view;
                    textView.setText(((b) getItem(i3)).f201949a);
                    c(textView);
                } else {
                    if (view == null) {
                        view = CountrySelectActivity.this.getLayoutInflater().inflate(R.layout.f168367u4, (ViewGroup) null);
                        c cVar = new c();
                        cVar.f201950a = (TextView) view.findViewById(R.id.bar);
                        cVar.f201951b = (ImageView) view.findViewById(R.id.ax5);
                        view.findViewById(R.id.baq).setVisibility(8);
                        view.setTag(cVar);
                        view.setOnClickListener(CountrySelectActivity.this);
                        b(cVar, view);
                    }
                    c cVar2 = (c) view.getTag();
                    BaseAddress baseAddress = (BaseAddress) getItem(i3);
                    cVar2.f201950a.setText(baseAddress.name);
                    if (!TextUtils.isEmpty(CountrySelectActivity.this.f201945f0) && CountrySelectActivity.this.f201945f0.equals(baseAddress.code)) {
                        cVar2.f201951b.setVisibility(0);
                    } else {
                        cVar2.f201951b.setVisibility(8);
                    }
                    cVar2.f201952c = baseAddress.code;
                    if (CountrySelectActivity.f201938i0) {
                        if (cVar2.f201951b.getVisibility() == 0) {
                            view.setContentDescription(baseAddress.name + HardCodeUtil.qqStr(R.string.l4w));
                        } else {
                            view.setContentDescription(baseAddress.name);
                        }
                    }
                }
                view2 = view;
            }
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view;
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
            if (getItemViewType(i3) == 0) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f201949a;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public TextView f201950a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f201951b;

        /* renamed from: c, reason: collision with root package name */
        public String f201952c;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71260);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f201938i0 = AppSetting.f99565y;
            f201939j0 = new String[]{"#", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z"};
        }
    }

    public CountrySelectActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f201946g0 = true;
        }
    }

    private void H2() {
        if (!isDarkModeAdapter()) {
            return;
        }
        this.f201940a0.setFloatingView(getResources().getColor(R.color.f158017al3), getResources().getColor(R.color.cih));
    }

    private void I2(View view) {
        if (!isDarkModeAdapter()) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.rlCommenTitle);
        this.f194786vg = viewGroup;
        viewGroup.setBackgroundColor(getResources().getColor(R.color.black));
        ((TextView) view.findViewById(R.id.bar)).setTextColor(getResources().getColor(R.color.f158017al3));
        view.setBackgroundColor(getResources().getColor(R.color.black));
        PinnedDividerListView pinnedDividerListView = this.f201940a0;
        if (pinnedDividerListView == null) {
            return;
        }
        pinnedDividerListView.setBackgroundColor(getResources().getColor(R.color.black));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDarkModeAdapter() {
        if (this.f201947h0 == 1 && f.b()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        setContentView(R.layout.f168365u2);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("source_from")) {
            this.f201947h0 = intent.getIntExtra("source_from", 0);
        }
        this.f201940a0 = (PinnedDividerListView) findViewById(R.id.bas);
        this.f201942c0 = (IndexView) findViewById(R.id.djg);
        setTitle(HardCodeUtil.qqStr(R.string.l4x));
        List<BaseAddress> x16 = ((ConditionSearchManager) this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).x();
        this.f201944e0 = new LinkedHashMap<>();
        this.f201943d0 = new ArrayList(x16.size() + 26);
        String stringExtra = getIntent().getStringExtra("key_country_code");
        this.f201945f0 = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.f201945f0 = "0";
        }
        boolean booleanExtra = getIntent().getBooleanExtra("key_no_limit_allow", false);
        this.f201946g0 = booleanExtra;
        if (booleanExtra) {
            View inflate = getLayoutInflater().inflate(R.layout.f168367u4, (ViewGroup) null);
            c cVar = new c();
            ((TextView) inflate.findViewById(R.id.bar)).setText(IProfileCardConst.NAME_NO_LIMIT);
            View findViewById = inflate.findViewById(R.id.ax5);
            if (this.f201945f0.equals("0")) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            findViewById.setVisibility(i16);
            inflate.findViewById(R.id.baq).setVisibility(8);
            cVar.f201952c = "0";
            inflate.setTag(cVar);
            inflate.setOnClickListener(this);
            if (f201938i0) {
                inflate.setContentDescription(IProfileCardConst.NAME_NO_LIMIT);
            }
            this.f201940a0.addHeaderView(inflate);
        }
        View inflate2 = getLayoutInflater().inflate(R.layout.f168367u4, (ViewGroup) null);
        c cVar2 = new c();
        ((TextView) inflate2.findViewById(R.id.bar)).setText(CountrySelectView.NAME_CHINA);
        View findViewById2 = inflate2.findViewById(R.id.ax5);
        if (this.f201945f0.equals("1")) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById2.setVisibility(i3);
        inflate2.findViewById(R.id.baq).setVisibility(8);
        cVar2.f201952c = "1";
        inflate2.setTag(cVar2);
        inflate2.setOnClickListener(this);
        I2(inflate2);
        if (f201938i0) {
            inflate2.setContentDescription(CountrySelectView.NAME_CHINA);
        }
        this.f201940a0.addHeaderView(inflate2);
        String str = "#";
        this.f201944e0.put("#", 0);
        int i17 = 0;
        for (BaseAddress baseAddress : x16) {
            if (!baseAddress.code.equals("0") && !baseAddress.code.equals("1")) {
                if (!baseAddress.pinyinFirst.equals(str)) {
                    str = baseAddress.pinyinFirst;
                    int indexOf = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(str);
                    while (i17 <= indexOf) {
                        int i18 = i17 + 1;
                        this.f201944e0.put("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(i17, i18), Integer.valueOf(this.f201943d0.size() + this.f201940a0.getHeaderViewsCount()));
                        i17 = i18;
                    }
                    this.f201944e0.put(str, Integer.valueOf(this.f201943d0.size() + this.f201940a0.getHeaderViewsCount()));
                    b bVar = new b();
                    bVar.f201949a = str;
                    this.f201943d0.add(bVar);
                }
                this.f201943d0.add(baseAddress);
            }
        }
        while (i17 < 26) {
            int i19 = i17 + 1;
            this.f201944e0.put("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(i17, i19), Integer.valueOf(this.f201943d0.size() + this.f201940a0.getHeaderViewsCount()));
            i17 = i19;
        }
        a aVar = new a();
        this.f201941b0 = aVar;
        this.f201940a0.setAdapter((ListAdapter) aVar);
        this.f201942c0.setIndex(f201939j0, false);
        this.f201942c0.setOnIndexChangedListener(this);
        H2();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.doOnDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.doOnResume();
        if (isDarkModeAdapter()) {
            cc2.b.c(this, getResources().getColor(R.color.black));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            Object tag = view.getTag();
            if (tag instanceof c) {
                Intent intent = new Intent();
                intent.putExtra("key_country_code", ((c) tag).f201952c);
                setResult(-1, intent);
                finish();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        Integer num = this.f201944e0.get(str);
        if (QLog.isColorLevel()) {
            QLog.d("CountrySelectActivity", 2, "onIndexChanged | c = " + str + " | i = " + num);
        }
        this.f201940a0.setSelection(num.intValue());
    }
}
