package com.dataline.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PrinterStatusHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import l0.c;

/* loaded from: classes.dex */
public class PrinterSubOptionActivity extends IphoneTitleBarActivity implements View.OnClickListener {

    /* renamed from: a0, reason: collision with root package name */
    XListView f32280a0;

    /* renamed from: b0, reason: collision with root package name */
    c f32281b0;

    /* renamed from: e0, reason: collision with root package name */
    String f32284e0;

    /* renamed from: c0, reason: collision with root package name */
    DataLineHandler f32282c0 = null;

    /* renamed from: d0, reason: collision with root package name */
    LayoutInflater f32283d0 = null;

    /* renamed from: f0, reason: collision with root package name */
    List<String> f32285f0 = new ArrayList();

    /* renamed from: g0, reason: collision with root package name */
    boolean f32286g0 = false;

    /* renamed from: h0, reason: collision with root package name */
    List<b> f32287h0 = new ArrayList();

    /* renamed from: i0, reason: collision with root package name */
    private c.b f32288i0 = new a();

    /* loaded from: classes.dex */
    class a implements c.b {
        a() {
        }

        @Override // l0.c.b
        public void a(int i3) {
            l0.c cVar = PrinterSubOptionActivity.this.f32282c0.T;
            if (cVar != null) {
                List<l0.b> d16 = cVar.d();
                if (d16 == null || d16.size() > 0) {
                    PrinterSubOptionActivity.this.H2();
                } else {
                    PrinterSubOptionActivity.this.findViewById(R.id.bwl).setVisibility(0);
                    PrinterSubOptionActivity.this.f32280a0.setVisibility(8);
                }
                PrinterSubOptionActivity.this.f32282c0.T.k();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public long f32290a;

        /* renamed from: b, reason: collision with root package name */
        public String f32291b;

        /* renamed from: c, reason: collision with root package name */
        public int f32292c;

        b(int i3, long j3, String str) {
            this.f32292c = i3;
            this.f32290a = j3;
            this.f32291b = str;
        }
    }

    /* loaded from: classes.dex */
    public class c extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private View.OnClickListener f32294d = new a();

        /* loaded from: classes.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l0.b g16;
                EventCollector.getInstance().onViewClickedBefore(view);
                TextView textView = (TextView) view.findViewById(R.id.arm);
                if (textView != null) {
                    b bVar = PrinterSubOptionActivity.this.f32287h0.get(((Integer) textView.getTag()).intValue());
                    long j3 = bVar.f32290a;
                    if (j3 != 0) {
                        g16 = PrinterSubOptionActivity.this.f32282c0.T.f(j3);
                    } else {
                        g16 = PrinterSubOptionActivity.this.f32282c0.T.g(bVar.f32291b);
                    }
                    PrinterSubOptionActivity.this.f32282c0.T.f413558d = g16;
                    Intent intent = new Intent();
                    intent.putExtra("sPrinterName", bVar.f32291b);
                    intent.putExtra("sPrintDin", bVar.f32290a);
                    PrinterSubOptionActivity.this.setResult(-1, intent);
                    PrinterSubOptionActivity.this.finish();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public c() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<b> list = PrinterSubOptionActivity.this.f32287h0;
            if (list != null && list.size() > 0) {
                return PrinterSubOptionActivity.this.f32287h0.size();
            }
            return 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            List<b> list = PrinterSubOptionActivity.this.f32287h0;
            if (list != null && i3 < list.size()) {
                return PrinterSubOptionActivity.this.f32287h0.get(i3);
            }
            PrinterSubOptionActivity printerSubOptionActivity = PrinterSubOptionActivity.this;
            return new b(1, 0L, printerSubOptionActivity.f32284e0);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            List<b> list = PrinterSubOptionActivity.this.f32287h0;
            if (list != null && list.size() > 0) {
                return 0;
            }
            return 1;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            String str = ((b) getItem(i3)).f32291b;
            TextView textView = null;
            if (getItemViewType(i3) == 0) {
                int i16 = ((b) getItem(i3)).f32292c;
                if (i16 == 1) {
                    view = PrinterSubOptionActivity.this.f32283d0.inflate(R.layout.f168387uo, (ViewGroup) null);
                    textView = (TextView) view.findViewById(R.id.jfo);
                } else if (i16 == 2) {
                    view = PrinterSubOptionActivity.this.f32283d0.inflate(R.layout.f168388up, (ViewGroup) null);
                    View findViewById = view.findViewById(R.id.arl);
                    textView = (TextView) view.findViewById(R.id.arm);
                    findViewById.setClickable(true);
                    findViewById.setEnabled(true);
                    findViewById.setOnClickListener(this.f32294d);
                }
            } else {
                view = PrinterSubOptionActivity.this.f32283d0.inflate(R.layout.f167893l2, (ViewGroup) null);
                view.findViewById(R.id.ecb).setVisibility(8);
                textView = (TextView) view.findViewById(R.id.ecc);
                textView.setTextSize(19.0f);
                textView.setTextColor(-16777216);
            }
            if (textView != null) {
                textView.setText(str);
                textView.setTag(Integer.valueOf(i3));
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H2() {
        if (this.f32282c0.T != null) {
            this.f32287h0.clear();
            List<l0.b> d16 = this.f32282c0.T.d();
            int size = d16.size();
            boolean z16 = false;
            boolean z17 = false;
            for (int i3 = 0; i3 < size; i3++) {
                l0.b bVar = d16.get(i3);
                int i16 = bVar.f413550b;
                if (i16 == 1 && !z16) {
                    this.f32287h0.add(new b(1, 0L, "PC\u7ed1\u5b9a\u7684\u6253\u5370\u673a"));
                    z16 = true;
                } else if (i16 == 2 && !z17) {
                    this.f32287h0.add(new b(1, 0L, "QQ\u7269\u8054\u6253\u5370\u673a"));
                    z17 = true;
                }
                this.f32287h0.add(new b(2, bVar.f413551c, bVar.f413549a));
            }
            this.f32281b0.notifyDataSetChanged();
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
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        this.f32283d0 = LayoutInflater.from(this);
        DataLineHandler dataLineHandler = (DataLineHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        this.f32282c0 = dataLineHandler;
        dataLineHandler.D.f194906c = null;
        getWindow().setBackgroundDrawableResource(R.color.f156897em);
        setContentView(R.layout.f167886ko);
        setTitle(R.string.agk);
        getWindow().setBackgroundDrawable(null);
        this.f32281b0 = new c();
        XListView xListView = (XListView) findViewById(R.id.fz8);
        this.f32280a0 = xListView;
        xListView.setTag(R.id.f163835o, "n/a");
        this.f32280a0.setAdapter((ListAdapter) this.f32281b0);
        if (!this.f32282c0.T.b()) {
            View findViewById = findViewById(R.id.bwl);
            findViewById.setVisibility(0);
            findViewById.setContentDescription(HardCodeUtil.qqStr(R.string.f172317pd4));
            ((TextView) findViewById(R.id.jty)).setText(getString(R.string.agc));
            ((TextView) findViewById(R.id.ado)).setText(getString(R.string.agb));
            this.f32280a0.setVisibility(8);
        } else {
            H2();
            this.f32282c0.T.i(this.f32288i0);
        }
        setLeftViewName(R.string.button_back);
        this.f32280a0.setTag(R.id.f163835o, "n/a");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        this.f32282c0.T.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        this.f32284e0 = getString(R.string.agd);
        this.f32287h0.clear();
        H2();
        PrinterStatusHandler printerStatusHandler = (PrinterStatusHandler) this.app.getBusinessHandler(BusinessHandlerFactory.PRINTER_STATUS_HANDLER);
        this.f32286g0 = printerStatusHandler.H2();
        printerStatusHandler.J2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        setResult(-1, new Intent());
        finish();
        return true;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
