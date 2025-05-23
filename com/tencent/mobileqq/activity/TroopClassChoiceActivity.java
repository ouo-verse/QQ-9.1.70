package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TroopClassChoiceActivity extends IphoneTitleBarActivity implements AdapterView.OnItemClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.troop.troopcatalog.a> f177315a0;

    /* renamed from: b0, reason: collision with root package name */
    private com.tencent.mobileqq.troop.troopcatalog.a f177316b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f177317c0;

    /* renamed from: d0, reason: collision with root package name */
    private XListView f177318d0;

    /* renamed from: e0, reason: collision with root package name */
    private a f177319e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f177320f0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends BaseAdapter {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopClassChoiceActivity.this);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            if (TroopClassChoiceActivity.this.f177315a0 != null) {
                return TroopClassChoiceActivity.this.f177315a0.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return Integer.valueOf(i3);
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
            com.tencent.mobileqq.troop.troopcatalog.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view2 = TroopClassChoiceActivity.this.getLayoutInflater().inflate(R.layout.c1f, (ViewGroup) null);
                } else {
                    view2 = view;
                }
                TextView textView = (TextView) view2.findViewById(R.id.jxl);
                TextView textView2 = (TextView) view2.findViewById(R.id.jxk);
                ImageView imageView = (ImageView) view2.findViewById(R.id.fdm);
                com.tencent.mobileqq.troop.troopcatalog.a aVar2 = (com.tencent.mobileqq.troop.troopcatalog.a) TroopClassChoiceActivity.this.f177315a0.get(i3);
                if (TroopClassChoiceActivity.this.f177316b0 != null && aVar2.f299959a < TroopClassChoiceActivity.this.f177316b0.f299959a) {
                    com.tencent.mobileqq.troop.troopcatalog.a aVar3 = TroopClassChoiceActivity.this.f177316b0;
                    com.tencent.mobileqq.troop.troopcatalog.a aVar4 = aVar3.f299963e;
                    while (true) {
                        com.tencent.mobileqq.troop.troopcatalog.a aVar5 = aVar4;
                        aVar = aVar3;
                        aVar3 = aVar5;
                        if (aVar3 == null || aVar3.f299959a < aVar2.f299959a) {
                            break;
                        }
                        if (aVar2.f299961c.equals(aVar3.f299961c)) {
                            break;
                        }
                        aVar4 = aVar3.f299963e;
                    }
                    z16 = false;
                    if (z16) {
                        textView2.setVisibility(0);
                        textView2.setText(aVar.f299960b);
                        textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.f162605b73, 0);
                    } else {
                        textView2.setVisibility(4);
                    }
                } else if (TroopClassChoiceActivity.this.f177316b0 != null && aVar2.f299961c.equals(TroopClassChoiceActivity.this.f177316b0.f299961c)) {
                    textView2.setVisibility(0);
                    textView2.setText("");
                    textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.f162605b73, 0);
                } else {
                    textView2.setVisibility(4);
                }
                textView.setText(aVar2.f299960b);
                ArrayList<com.tencent.mobileqq.troop.troopcatalog.a> arrayList = aVar2.f299962d;
                if (arrayList != null && arrayList.size() > 0) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(4);
                }
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    public TroopClassChoiceActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void I2() {
        com.tencent.mobileqq.troop.troopcatalog.a aVar;
        if (TextUtils.isEmpty(this.f177317c0)) {
            this.f177315a0 = J2();
            return;
        }
        ArrayList<com.tencent.mobileqq.troop.troopcatalog.a> K2 = K2();
        this.f177315a0 = K2;
        if (K2.size() > 0 && (aVar = this.f177315a0.get(0).f299963e) != null) {
            setTitle(aVar.f299960b);
        }
    }

    private ArrayList<com.tencent.mobileqq.troop.troopcatalog.a> J2() {
        ArrayList<com.tencent.mobileqq.troop.troopcatalog.a> arrayList = new ArrayList<>();
        ArrayList<com.tencent.mobileqq.troop.troopcatalog.a> f16 = com.tencent.mobileqq.troop.troopcatalog.b.g().f();
        for (int i3 = 0; i3 < f16.size(); i3++) {
            com.tencent.mobileqq.troop.troopcatalog.a aVar = f16.get(i3);
            if (!aVar.f299964f || aVar.f299961c.equals(this.f177320f0) || aVar.b(this.f177320f0)) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    private ArrayList<com.tencent.mobileqq.troop.troopcatalog.a> K2() {
        ArrayList<com.tencent.mobileqq.troop.troopcatalog.a> arrayList = new ArrayList<>();
        ArrayList<com.tencent.mobileqq.troop.troopcatalog.a> d16 = com.tencent.mobileqq.troop.troopcatalog.b.g().d(this.f177317c0);
        for (int i3 = 0; i3 < d16.size(); i3++) {
            com.tencent.mobileqq.troop.troopcatalog.a aVar = d16.get(i3);
            if (!aVar.f299964f || aVar.f299961c.equals(this.f177320f0)) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    private void initData() {
        Intent intent = getIntent();
        this.f177320f0 = String.valueOf(intent.getStringExtra("troopGroupClassExt"));
        com.tencent.mobileqq.troop.troopcatalog.a h16 = com.tencent.mobileqq.troop.troopcatalog.b.g().h();
        if (h16 != null && this.f177320f0.equals(h16.f299961c)) {
            this.f177316b0 = h16;
        } else {
            this.f177316b0 = com.tencent.mobileqq.troop.troopcatalog.b.g().c(this.f177320f0);
        }
        this.f177317c0 = intent.getStringExtra("id");
        I2();
    }

    private void initViews() {
        setContentBackgroundResource(R.drawable.bg_texture);
        XListView xListView = (XListView) findViewById(R.id.jw_);
        this.f177318d0 = xListView;
        xListView.setOnItemClickListener(this);
        a aVar = new a();
        this.f177319e0 = aVar;
        this.f177318d0.setAdapter((ListAdapter) aVar);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i16 == -1) {
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        super.setContentView(R.layout.c1e);
        setTitle(R.string.i5u);
        initData();
        initViews();
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        com.tencent.mobileqq.troop.troopcatalog.a aVar = this.f177315a0.get(i3);
        ArrayList<com.tencent.mobileqq.troop.troopcatalog.a> arrayList = aVar.f299962d;
        if (arrayList != null && arrayList.size() > 0) {
            Intent intent = new Intent(this, (Class<?>) TroopClassChoiceActivity.class);
            intent.putExtra("id", aVar.f299961c);
            intent.putExtra("troopGroupClassExt", this.f177320f0);
            startActivityForResult(intent, 11);
            return;
        }
        com.tencent.mobileqq.troop.troopcatalog.b.g().j(aVar);
        Intent intent2 = new Intent();
        intent2.putExtra("id", aVar.f299961c);
        setResult(-1, intent2);
        finish();
    }
}
