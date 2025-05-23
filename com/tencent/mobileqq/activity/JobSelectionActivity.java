package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.widget.InterestLabelTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class JobSelectionActivity extends IphoneTitleBarActivity implements AdapterView.OnItemClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private ListView f176273a0;

    /* renamed from: b0, reason: collision with root package name */
    private a f176274b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f176275c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f176276d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f176277e0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private class a extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private String[] f176278d;

        /* renamed from: e, reason: collision with root package name */
        private String[] f176279e;

        /* renamed from: f, reason: collision with root package name */
        private int[] f176280f;

        a() {
            String[] strArr;
            String[] strArr2;
            int[] iArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) JobSelectionActivity.this);
                return;
            }
            if (JobSelectionActivity.this.f176277e0) {
                strArr = ConditionSearchManager.f194488p0;
            } else {
                strArr = NearbyProfileUtil.f306396e;
            }
            this.f176278d = strArr;
            if (JobSelectionActivity.this.f176277e0) {
                strArr2 = ConditionSearchManager.f194489q0;
            } else {
                strArr2 = NearbyProfileUtil.f306397f;
            }
            this.f176279e = strArr2;
            if (JobSelectionActivity.this.f176277e0) {
                iArr = ConditionSearchManager.f194490r0;
            } else {
                iArr = NearbyProfileUtil.f306398g;
            }
            this.f176280f = iArr;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            if (JobSelectionActivity.this.f176276d0) {
                return this.f176278d.length - 2;
            }
            return this.f176278d.length - 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return this.f176278d[JobSelectionActivity.this.K2(i3)];
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return 0L;
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
                    view = JobSelectionActivity.this.getLayoutInflater().inflate(R.layout.avi, viewGroup, false);
                    b bVar = new b();
                    bVar.f176282a = (InterestLabelTextView) view.findViewById(R.id.f166942ja3);
                    bVar.f176283b = (TextView) view.findViewById(R.id.f5e);
                    bVar.f176284c = (ImageView) view.findViewById(R.id.ax4);
                    view.setTag(bVar);
                }
                b bVar2 = (b) view.getTag();
                int K2 = JobSelectionActivity.this.K2(i3);
                Drawable drawable = JobSelectionActivity.this.getResources().getDrawable(this.f176280f[K2]);
                ProfileCardUtils.setNightModeFilterForDrawable(JobSelectionActivity.this.app, drawable);
                bVar2.f176282a.setText(this.f176279e[K2]);
                bVar2.f176282a.setBackgroundDrawable(drawable);
                int f16 = BaseAIOUtils.f(4.0f, ((IphoneTitleBarActivity) JobSelectionActivity.this).mContentView.getResources());
                bVar2.f176282a.setPadding(f16, 0, f16, 0);
                if (K2 < this.f176278d.length - 1) {
                    bVar2.f176282a.setVisibility(0);
                } else {
                    bVar2.f176282a.setVisibility(4);
                }
                if (JobSelectionActivity.this.f176276d0 && K2 == 0) {
                    bVar2.f176282a.setVisibility(4);
                }
                bVar2.f176283b.setText(this.f176278d[K2]);
                if (JobSelectionActivity.this.f176275c0 == K2) {
                    bVar2.f176284c.setVisibility(0);
                } else {
                    bVar2.f176284c.setVisibility(4);
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public InterestLabelTextView f176282a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f176283b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f176284c;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public JobSelectionActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f176276d0 = false;
        }
    }

    int K2(int i3) {
        if (this.f176276d0) {
            if (i3 >= ConditionSearchManager.f194492t0[0]) {
                return i3 + 2;
            }
            return i3;
        }
        return i3 + 1;
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.avj);
        setTitle(R.string.bzz);
        setLeftViewName(R.string.f170549u3);
        this.f176275c0 = getIntent().getIntExtra("param_id", -1);
        this.f176276d0 = getIntent().getBooleanExtra("param_need_no_limit", false);
        this.f176277e0 = getIntent().getBooleanExtra("param_from_consearch", false);
        ListView listView = (ListView) findViewById(R.id.ebs);
        this.f176273a0 = listView;
        listView.setOnItemClickListener(this);
        a aVar = new a();
        this.f176274b0 = aVar;
        this.f176273a0.setAdapter((ListAdapter) aVar);
        return true;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            this.f176275c0 = K2(i3);
            this.f176274b0.notifyDataSetChanged();
            if (this.f176277e0) {
                ReportController.o(this.app, "CliOper", "", "", "0X8006F0A", "0X8006F0A", 0, 0, this.f176275c0 + "", "", "", "");
            }
            Intent intent = new Intent();
            intent.putExtra("param_id", this.f176275c0);
            if (!this.f176277e0) {
                intent.putExtra("param_tag", NearbyProfileUtil.f306397f[this.f176275c0]);
                intent.putExtra("param_name", NearbyProfileUtil.f306396e[this.f176275c0]);
                intent.putExtra("param_tag_bg", NearbyProfileUtil.f306398g[this.f176275c0]);
            }
            setResult(-1, intent);
            finish();
        }
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }
}
