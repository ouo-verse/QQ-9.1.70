package com.dataline.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PrinterStatusHandler;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.d;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.MyCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import l0.c;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9$MsgBody;

/* loaded from: classes.dex */
public class PrinterOptionActivity extends IphoneTitleBarActivity implements View.OnClickListener {

    /* renamed from: a0, reason: collision with root package name */
    private TextView f32259a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f32260b0;

    /* renamed from: c0, reason: collision with root package name */
    private Button f32261c0;

    /* renamed from: d0, reason: collision with root package name */
    private TextView f32262d0;

    /* renamed from: e0, reason: collision with root package name */
    private View f32263e0;

    /* renamed from: f0, reason: collision with root package name */
    private View f32264f0;

    /* renamed from: g0, reason: collision with root package name */
    private TextView f32265g0;

    /* renamed from: h0, reason: collision with root package name */
    private TextView f32266h0;

    /* renamed from: i0, reason: collision with root package name */
    private LinearLayout f32267i0;

    /* renamed from: j0, reason: collision with root package name */
    private MyCheckBox f32268j0;

    /* renamed from: l0, reason: collision with root package name */
    public ViewGroup f32270l0;

    /* renamed from: m0, reason: collision with root package name */
    private ArrayList<FileInfo> f32271m0;

    /* renamed from: k0, reason: collision with root package name */
    private int f32269k0 = 1;

    /* renamed from: n0, reason: collision with root package name */
    private DataLineHandler f32272n0 = null;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f32273o0 = false;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f32274p0 = true;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f32275q0 = false;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f32276r0 = false;

    /* renamed from: s0, reason: collision with root package name */
    private c.b f32277s0 = new a();

    /* loaded from: classes.dex */
    class a implements c.b {
        a() {
        }

        @Override // l0.c.b
        public void a(int i3) {
            PrinterOptionActivity.this.N2();
        }
    }

    /* loaded from: classes.dex */
    class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (z16) {
                PrinterOptionActivity.this.f32265g0.setVisibility(0);
                PrinterOptionActivity.this.f32265g0.setText(R.string.agl);
            } else if (PrinterOptionActivity.this.f32276r0) {
                PrinterOptionActivity.this.f32265g0.setVisibility(0);
                PrinterOptionActivity.this.f32265g0.setText(R.string.f170815ag2);
            } else {
                PrinterOptionActivity.this.f32265g0.setVisibility(4);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x014b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean J2() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        DataLineHandler dataLineHandler = this.f32272n0;
        l0.b bVar = dataLineHandler.T.f413558d;
        boolean z27 = true;
        if (bVar != null) {
            int i3 = bVar.f413550b;
            int i16 = 9;
            if (i3 == 2) {
                Iterator<FileInfo> it = this.f32271m0.iterator();
                while (it.hasNext()) {
                    FileInfo next = it.next();
                    String lowerCase = next.j().toLowerCase();
                    int fileType = FileManagerUtil.getFileType(lowerCase);
                    if (fileType != 9 && fileType != 0) {
                        this.f32276r0 = true;
                    }
                    if (!((IPrintApi) QRoute.api(IPrintApi.class)).checkOnlinePrintSupportFileType(lowerCase)) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("IphoneTitleBarActivity", 1, "printer unsupport file printer : " + bVar.f413549a + " file : " + next.j());
                        }
                    }
                }
                z16 = true;
                z17 = z27;
            } else if (i3 == 1) {
                if (dataLineHandler.D.b() != null) {
                    Iterator<FileInfo> it5 = this.f32271m0.iterator();
                    boolean z28 = false;
                    boolean z29 = true;
                    z17 = true;
                    while (true) {
                        if (it5.hasNext()) {
                            FileInfo next2 = it5.next();
                            String lowerCase2 = next2.j().toLowerCase();
                            int fileType2 = FileManagerUtil.getFileType(lowerCase2);
                            if (fileType2 != i16 && fileType2 != 0) {
                                this.f32276r0 = true;
                            }
                            Iterator<C2CType0x211_SubC2CType0x9$MsgBody.SupportFileInfo> it6 = this.f32272n0.D.f194909f.iterator();
                            while (true) {
                                if (it6.hasNext()) {
                                    C2CType0x211_SubC2CType0x9$MsgBody.SupportFileInfo next3 = it6.next();
                                    if (lowerCase2.endsWith("." + next3.str_file_suffix.get())) {
                                        if (next3.uint32_copies.get() == 1) {
                                            z19 = true;
                                        } else {
                                            z19 = false;
                                        }
                                        z29 &= z19;
                                        if (next3.uint32_duplex.get() == 1) {
                                            z26 = true;
                                        } else {
                                            z26 = false;
                                        }
                                        z17 &= z26;
                                        z18 = true;
                                    }
                                } else {
                                    z18 = false;
                                    break;
                                }
                            }
                            if (!z18) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.i("IphoneTitleBarActivity", 1, "printer unsupport file printer : " + bVar.f413549a + " file : " + next2.j());
                                }
                                z27 = z29;
                                z16 = z18;
                            } else {
                                z28 = z18;
                                i16 = 9;
                            }
                        } else {
                            z27 = z29;
                            z16 = z28;
                            break;
                        }
                    }
                }
            } else {
                z16 = false;
                z27 = false;
                z17 = z27;
            }
            if (!z27) {
                this.f32263e0.setVisibility(8);
                this.f32264f0.setVisibility(8);
            }
            if (!z17) {
                this.f32267i0.setVisibility(0);
                this.f32266h0.setVisibility(8);
            } else {
                this.f32266h0.setVisibility(0);
                this.f32267i0.setVisibility(8);
            }
            return z16;
        }
        z16 = false;
        z17 = z27;
        if (!z27) {
        }
        if (!z17) {
        }
        return z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r4 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean K2(boolean z16) {
        String str;
        c cVar = this.f32272n0.T;
        boolean z17 = true;
        if (cVar.f413558d == null) {
            if (z16) {
                l0.b e16 = cVar.e();
                this.f32272n0.T.f413558d = e16;
            }
            z17 = false;
        }
        if (z17) {
            c cVar2 = this.f32272n0.T;
            str = cVar2.f413558d.f413549a;
            cVar2.j(str);
            if (!this.f32275q0) {
                this.f32259a0.setTextColor(-16777216);
            }
        } else {
            str = "";
        }
        this.f32259a0.setText(str);
        return z17;
    }

    private void M2(boolean z16) {
        startActivityForResult(new Intent(this, (Class<?>) PrinterSubOptionActivity.class), 103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N2() {
        RegisterProxySvcPackHandler registerProxySvcPackHandler = (RegisterProxySvcPackHandler) this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
        PrinterStatusHandler printerStatusHandler = (PrinterStatusHandler) this.app.getBusinessHandler(BusinessHandlerFactory.PRINTER_STATUS_HANDLER);
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            if (QLog.isColorLevel()) {
                QLog.d("PrinterOptionActivity", 4, "UpdateStatus : network error");
            }
            this.f32265g0.setText(R.string.afz);
            this.f32265g0.setVisibility(0);
            this.f32261c0.setEnabled(false);
            this.f32260b0.setEnabled(false);
        } else if (!K2(true)) {
            if (QLog.isColorLevel()) {
                QLog.d("PrinterOptionActivity", 4, "UpdateStatus : Null printer has been selected");
            }
            this.f32265g0.setVisibility(4);
            this.f32259a0.setText(R.string.age);
            if (!this.f32275q0) {
                this.f32259a0.setTextColor(Color.parseColor("#808080"));
            }
            this.f32261c0.setEnabled(false);
            this.f32260b0.setEnabled(true);
        } else if (registerProxySvcPackHandler.P2() == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("PrinterOptionActivity", 4, "UpdateStatus : PCQQ is not login");
            }
            this.f32265g0.setText(R.string.f170814ag0);
            this.f32265g0.setVisibility(0);
            this.f32261c0.setEnabled(false);
        } else if (!printerStatusHandler.H2()) {
            if (QLog.isColorLevel()) {
                QLog.d("PrinterOptionActivity", 4, "UpdateStatus : PCQQ is not outdate");
            }
            this.f32265g0.setText(R.string.afy);
            this.f32265g0.setVisibility(0);
            this.f32261c0.setEnabled(false);
        } else if (!J2()) {
            if (QLog.isColorLevel()) {
                QLog.d("PrinterOptionActivity", 4, "UpdateStatus : The file is not support print");
            }
            this.f32265g0.setText(R.string.f170816ag3);
            this.f32265g0.setVisibility(0);
            this.f32261c0.setEnabled(false);
            this.f32260b0.setEnabled(true);
        } else {
            if (this.f32276r0) {
                this.f32265g0.setVisibility(0);
                this.f32265g0.setText(R.string.f170815ag2);
            } else {
                this.f32265g0.setVisibility(4);
            }
            this.f32261c0.setEnabled(true);
            this.f32260b0.setEnabled(true);
            return true;
        }
        return false;
    }

    void L2() {
        boolean z16;
        this.f32262d0.setText(getString(R.string.ag5) + this.f32269k0);
        View view = this.f32263e0;
        boolean z17 = false;
        if (this.f32269k0 > 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        view.setEnabled(z16);
        View view2 = this.f32264f0;
        if (this.f32269k0 < 99) {
            z17 = true;
        }
        view2.setEnabled(z17);
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
        c cVar;
        l0.b bVar;
        super.doOnActivityResult(i3, i16, intent);
        if (i3 == 103 && i16 == -1) {
            String stringExtra = intent.getStringExtra("sPrinterName");
            long longExtra = intent.getLongExtra("sPrintDin", 0L);
            if (stringExtra == null && longExtra == 0) {
                this.f32272n0.T.f413558d = null;
            }
            if (N2() && (bVar = (cVar = this.f32272n0.T).f413558d) != null) {
                cVar.j(bVar.f413549a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        this.f32272n0 = (DataLineHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        this.f32271m0 = super.getIntent().getParcelableArrayListExtra("sFilesSelected");
        this.f32273o0 = super.getIntent().getBooleanExtra("sIsCloudPrinter", false);
        this.f32273o0 = getIntent().getBooleanExtra("sIsCloudPrinter", false);
        super.getWindow().setBackgroundDrawableResource(R.color.f156897em);
        setContentView(R.layout.f167885kn);
        setTitle(R.string.aga);
        super.getWindow().setBackgroundDrawable(null);
        ViewGroup viewGroup = (ViewGroup) super.findViewById(R.id.bdi);
        this.f32270l0 = viewGroup;
        viewGroup.setTag(R.id.f163835o, "n/a");
        View findViewById = super.findViewById(R.id.fz_);
        this.f32260b0 = findViewById;
        findViewById.setOnClickListener(this);
        this.f32259a0 = (TextView) super.findViewById(R.id.fza);
        Button button = (Button) super.findViewById(R.id.by);
        this.f32261c0 = button;
        button.setOnClickListener(this);
        this.f32265g0 = (TextView) super.findViewById(R.id.info);
        this.f32262d0 = (TextView) super.findViewById(R.id.fz5);
        View findViewById2 = super.findViewById(R.id.bel);
        this.f32263e0 = findViewById2;
        findViewById2.setOnClickListener(this);
        View findViewById3 = super.findViewById(R.id.dj8);
        this.f32264f0 = findViewById3;
        findViewById3.setOnClickListener(this);
        this.f32266h0 = (TextView) super.findViewById(R.id.fzb);
        this.f32267i0 = (LinearLayout) super.findViewById(R.id.fz7);
        MyCheckBox myCheckBox = (MyCheckBox) super.findViewById(R.id.j1s);
        this.f32268j0 = myCheckBox;
        myCheckBox.setOnClickListener(this);
        this.f32268j0.setOnCheckedChangeListener(new b());
        if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
            this.f32275q0 = true;
            this.f32264f0.setBackgroundResource(R.drawable.f161197s3);
            this.f32263e0.setBackgroundResource(R.drawable.f161196s2);
            this.f32261c0.setBackgroundResource(R.drawable.f161199s5);
        }
        c cVar = this.f32272n0.T;
        cVar.f413558d = null;
        cVar.i(this.f32277s0);
        if (!K2(true)) {
            this.f32265g0.setText(R.string.age);
            this.f32265g0.setVisibility(0);
        }
        this.f32266h0.setVisibility(8);
        L2();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        this.f32272n0.T.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        LiteActivity.G4(this, this.f32270l0);
        N2();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f32260b0) {
            M2(true);
        } else if (view == this.f32261c0) {
            if (this.f32274p0 && N2()) {
                this.f32274p0 = false;
                Intent intent = new Intent();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("printCopies", this.f32269k0);
                    if (this.f32268j0.isChecked()) {
                        jSONObject.put("duplexMode", 2);
                    } else {
                        jSONObject.put("duplexMode", 1);
                    }
                    jSONObject.put("printerName", this.f32272n0.D.f194904a);
                    String jSONObject2 = jSONObject.toString();
                    if (QLog.isDevelopLevel()) {
                        QLog.i("IphoneTitleBarActivity", 1, "printer params : " + jSONObject2);
                    }
                    intent.putExtra("sPrintParam", jSONObject2);
                    intent.putParcelableArrayListExtra("sFilesSelected", this.f32271m0);
                    String str = d.f307603i;
                    intent.putExtra(str, super.getIntent().getIntExtra(str, 0));
                } catch (JSONException unused) {
                    this.f32274p0 = true;
                }
                setResult(-1, intent);
                finish();
                ReportController.o(this.app, "CliOper", "", "", "0X800405A", "0X800405A", 0, 0, "", "", "", "");
            }
        } else if (view == this.f32263e0) {
            int i3 = this.f32269k0 - 1;
            this.f32269k0 = i3;
            this.f32269k0 = Math.max(1, i3);
            L2();
        } else if (view == this.f32264f0) {
            this.f32269k0++;
            L2();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
