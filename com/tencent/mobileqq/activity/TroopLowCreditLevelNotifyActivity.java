package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.file.api.ITroopFileApi;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import cooperation.qzone.QZoneHelper;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xe83.oidb_0xe83$AppInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83$RspBody;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TroopLowCreditLevelNotifyActivity extends IphoneTitleBarActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    public View[] f177355a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean[] f177356b0;

    /* renamed from: c0, reason: collision with root package name */
    protected Context f177357c0;

    /* renamed from: d0, reason: collision with root package name */
    protected ImageView f177358d0;

    /* renamed from: e0, reason: collision with root package name */
    protected TextView f177359e0;

    /* renamed from: f0, reason: collision with root package name */
    protected TextView f177360f0;

    /* renamed from: g0, reason: collision with root package name */
    protected TextView f177361g0;

    /* renamed from: h0, reason: collision with root package name */
    protected TextView f177362h0;

    /* renamed from: i0, reason: collision with root package name */
    protected LinearLayout f177363i0;

    /* renamed from: j0, reason: collision with root package name */
    protected Button f177364j0;

    /* renamed from: k0, reason: collision with root package name */
    protected String f177365k0;

    /* renamed from: l0, reason: collision with root package name */
    protected String f177366l0;

    /* renamed from: m0, reason: collision with root package name */
    protected com.tencent.mobileqq.troop.troopapps.api.b f177367m0;

    /* renamed from: n0, reason: collision with root package name */
    protected QQProgressDialog f177368n0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Function2<Boolean, TroopInfo, Unit> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopLowCreditLevelNotifyActivity.this);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool, TroopInfo troopInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopLowCreditLevelNotifyActivity.this.L2(bool, troopInfo);
                return null;
            }
            return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool, (Object) troopInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopLowCreditLevelNotifyActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                TroopLowCreditLevelNotifyActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends com.tencent.mobileqq.troop.troopapps.api.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopLowCreditLevelNotifyActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopapps.api.b
        protected void c(oidb_0xe83$RspBody oidb_0xe83_rspbody, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) oidb_0xe83_rspbody, i3);
                return;
            }
            if (oidb_0xe83_rspbody.group_id.has()) {
                String valueOf = String.valueOf(oidb_0xe83_rspbody.group_id.get());
                if (!TextUtils.equals(TroopLowCreditLevelNotifyActivity.this.f177365k0, valueOf)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "onGetNewTroopAppList troopUin not match. rsp uin=" + valueOf + ", current uin=" + TroopLowCreditLevelNotifyActivity.this.f177365k0);
                        return;
                    }
                    return;
                }
            } else if (QLog.isColorLevel()) {
                QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "onGetNewTroopAppList group_id lost. current uin=" + TroopLowCreditLevelNotifyActivity.this.f177365k0);
            }
            TroopLowCreditLevelNotifyActivity.this.hideProgressDialog();
            oidb_0xe83$AppInfo I2 = TroopLowCreditLevelNotifyActivity.this.I2(1101236949L);
            if (I2 != null) {
                TroopLowCreditLevelNotifyActivity.this.M2(I2);
            }
        }
    }

    public TroopLowCreditLevelNotifyActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f177355a0 = new View[4];
        this.f177356b0 = new boolean[4];
        this.f177365k0 = "";
        this.f177366l0 = "";
        this.f177367m0 = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L2(Boolean bool, TroopInfo troopInfo) {
        long j3 = troopInfo.troopCreditLevel;
        QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 1, "[onFetchTroopCredit] isSus:" + bool + ", level:" + j3);
        hideProgressDialog();
        if (!bool.booleanValue() || j3 == 2) {
            return;
        }
        if (j3 == 1) {
            Q2(HardCodeUtil.qqStr(R.string.uis));
        } else {
            Q2(HardCodeUtil.qqStr(R.string.uit));
        }
    }

    private String N2(String str, long j3) {
        String str2;
        TroopInfo k3;
        String currentAccountUin = this.app.getCurrentAccountUin();
        TroopManager troopManager = (TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null && (k3 = troopManager.k(this.f177365k0)) != null) {
            if (k3.isOwner()) {
                str2 = "0";
            } else if (k3.isAdmin()) {
                str2 = "1";
            }
            return str.replace("$GCODE$", this.f177365k0).replace("$CLIENTVER$", "android" + AppSetting.f99551k).replace("$UIN$", currentAccountUin).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(j3)).replace("$ROLE$", str2).replace("$ENTERSOURCE$", "1") + "&credit=1";
        }
        str2 = "2";
        return str.replace("$GCODE$", this.f177365k0).replace("$CLIENTVER$", "android" + AppSetting.f99551k).replace("$UIN$", currentAccountUin).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(j3)).replace("$ROLE$", str2).replace("$ENTERSOURCE$", "1") + "&credit=1";
    }

    private void Q2(String str) {
        QQCustomDialog message = DialogUtil.createCustomDialog(this.f177357c0, 230).setTitle(getString(R.string.f173206i10)).setMessage(str);
        message.setPositiveButton(R.string.eqb, new b());
        message.setNegativeButton("", (DialogInterface.OnClickListener) null);
        message.setCancelable(false);
        message.show();
    }

    private void initViews() {
        this.f177357c0 = this;
        this.f177358d0 = (ImageView) findViewById(R.id.jy6);
        this.f177359e0 = (TextView) findViewById(R.id.k0i);
        this.f177360f0 = (TextView) findViewById(R.id.k1s);
        this.f177361g0 = (TextView) findViewById(R.id.eht);
        this.f177362h0 = (TextView) findViewById(R.id.eyl);
        this.f177363i0 = (LinearLayout) findViewById(R.id.dpq);
        Button button = (Button) findViewById(R.id.j6p);
        this.f177364j0 = button;
        button.setOnClickListener(this);
        setTitle(R.string.eq_);
        this.f177361g0.setText(R.string.eqh);
        this.f177362h0.setText(R.string.eqg);
        this.f177359e0.setText(this.f177366l0);
        this.f177360f0.setText(this.f177365k0);
        H2(R.string.erk, R.string.ep5, this.f177356b0[0], 0);
        H2(R.string.erg, R.string.ep5, this.f177356b0[1], 1);
        H2(R.string.erh, R.string.f171396ep3, this.f177356b0[2], 2);
        H2(R.string.erj, R.string.f171397ep4, this.f177356b0[3], 3);
        Bitmap troopFaceBitmap = this.app.getTroopFaceBitmap(this.f177365k0, (byte) 3, false, false);
        if (troopFaceBitmap != null) {
            this.f177358d0.setImageBitmap(troopFaceBitmap);
        } else {
            this.f177358d0.setImageBitmap(BaseImageUtil.getDefaultFaceBitmap());
        }
        if (K2()) {
            this.f177364j0.setEnabled(true);
        } else {
            this.f177364j0.setEnabled(false);
        }
    }

    public void H2(int i3, int i16, boolean z16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17));
            return;
        }
        View inflate = LayoutInflater.from(this.f177357c0).inflate(R.layout.c1o, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.dr7);
        TextView textView2 = (TextView) inflate.findViewById(R.id.dq6);
        TextView textView3 = (TextView) inflate.findViewById(R.id.f165875dr2);
        textView.setText(i3);
        textView2.setText(i16);
        if (z16) {
            textView3.setVisibility(0);
        } else {
            textView3.setVisibility(8);
        }
        inflate.setOnClickListener(this);
        this.f177355a0[i17] = inflate;
        this.f177363i0.addView(inflate);
    }

    public oidb_0xe83$AppInfo I2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (oidb_0xe83$AppInfo) iPatchRedirector.redirect((short) 6, (Object) this, j3);
        }
        byte[] troopAppListData = ((ITroopAppService) this.app.getRuntimeService(ITroopAppService.class, "all")).getTroopAppListData(this.f177365k0);
        if (troopAppListData != null) {
            try {
                oidb_0xe83$RspBody oidb_0xe83_rspbody = new oidb_0xe83$RspBody();
                oidb_0xe83_rspbody.mergeFrom(troopAppListData);
                List<oidb_0xe83$AppInfo> list = oidb_0xe83_rspbody.infos.get();
                if (list != null && list.size() != 0) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        oidb_0xe83$AppInfo oidb_0xe83_appinfo = list.get(i3);
                        if (oidb_0xe83_appinfo.appid.get() == j3) {
                            return oidb_0xe83_appinfo;
                        }
                    }
                }
                return null;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "getAppInfo: " + j3 + ", " + e16.toString());
                }
            }
        }
        return null;
    }

    public boolean J2() {
        TroopManager troopManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        String stringExtra = getIntent().getStringExtra("troopUin");
        this.f177365k0 = stringExtra;
        if (TextUtils.isEmpty(stringExtra) || (troopManager = (TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER)) == null) {
            return false;
        }
        TroopInfo k3 = troopManager.k(this.f177365k0);
        if (k3 != null) {
            String troopDisplayName = k3.getTroopDisplayName();
            this.f177366l0 = troopDisplayName;
            if (TextUtils.isEmpty(troopDisplayName)) {
                this.f177366l0 = this.f177365k0;
            }
        }
        String string = getSharedPreferences("sp_tp_credit_md_stat_" + this.app.getCurrentAccountUin(), 0).getString(this.f177365k0, "");
        try {
            if (QLog.isColorLevel()) {
                QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "initParams, modifyStatusJson:" + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            this.f177356b0[0] = jSONObject.optBoolean("TROOP_INFO_ITEM");
            this.f177356b0[1] = jSONObject.optBoolean("TROOP_ANNOUNCE_ITEM");
            this.f177356b0[2] = jSONObject.optBoolean("TROOP_FILE_ITEM");
            this.f177356b0[3] = jSONObject.optBoolean("TROOP_ALBUM_ITEM");
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "initParams:" + e16.toString());
            }
        }
        return true;
    }

    public boolean K2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        int i3 = 0;
        while (true) {
            boolean[] zArr = this.f177356b0;
            if (i3 < zArr.length) {
                if (!zArr[i3]) {
                    return false;
                }
                i3++;
            } else {
                return true;
            }
        }
    }

    public void M2(oidb_0xe83$AppInfo oidb_0xe83_appinfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) oidb_0xe83_appinfo);
            return;
        }
        Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
        String N2 = N2(oidb_0xe83_appinfo.url.get(), oidb_0xe83_appinfo.appid.get());
        intent.putExtra("url", N2);
        intent.putExtra("webStyle", "noBottomBar");
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        startActivityForResult(intent, 1001);
        if (QLog.isColorLevel()) {
            QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "openTroopAnnounce:" + N2);
        }
    }

    public void P2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            SharedPreferences.Editor edit = getSharedPreferences("sp_tp_credit_md_stat_" + this.app.getCurrentAccountUin(), 0).edit();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("TROOP_INFO_ITEM", this.f177356b0[0]);
            jSONObject.put("TROOP_ANNOUNCE_ITEM", this.f177356b0[1]);
            jSONObject.put("TROOP_FILE_ITEM", this.f177356b0[2]);
            jSONObject.put("TROOP_ALBUM_ITEM", this.f177356b0[3]);
            edit.putString(this.f177365k0, jSONObject.toString());
            edit.commit();
            if (QLog.isColorLevel()) {
                QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "saveStatus:" + jSONObject.toString());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "saveStatus:" + e16.toString());
            }
        }
    }

    public void R2() {
        boolean z16;
        boolean z17;
        TroopInfo k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        TroopManager troopManager = (TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null && (k3 = troopManager.k(this.f177365k0)) != null) {
            z16 = k3.isOwner();
            z17 = k3.isAdmin();
        } else {
            z16 = false;
            z17 = false;
        }
        if (!z16 && !z17) {
            Q2(HardCodeUtil.qqStr(R.string.uiu));
        } else {
            ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopCredit(this.f177365k0, "troop.credit.TroopLowCreditLevelNotifyActivity", this, new a());
            showProgressDialog();
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
        char c16 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i16 == -1) {
            switch (i3) {
                case 1000:
                    c16 = 0;
                    break;
                case 1001:
                    c16 = 1;
                    break;
                case 1002:
                    c16 = 2;
                    break;
                case 1003:
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            if (c16 >= 0) {
                this.f177355a0[c16].findViewById(R.id.f165875dr2).setVisibility(0);
                this.f177356b0[c16] = true;
            }
            if (K2()) {
                this.f177364j0.setEnabled(true);
            } else {
                this.f177364j0.setEnabled(false);
            }
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
        if (QLog.isColorLevel()) {
            QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "doOnCreate:" + this.f177365k0 + "," + this.f177366l0);
        }
        if (!J2()) {
            finish();
            return false;
        }
        super.setContentView(R.layout.c1p);
        initViews();
        addObserver(this.f177367m0);
        R2();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnDestroy();
        removeObserver(this.f177367m0);
        P2();
    }

    protected void hideProgressDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.f177368n0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f177368n0.dismiss();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TroopInfo troopInfo;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else if (view.getId() == R.id.j6p) {
            String str = "https://qqweb.qq.com/m/business/qunlevel/index.html?gc=" + this.f177365k0 + "&from=0&_wv=1027";
            Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            intent.putExtra("url", str);
            startActivity(intent);
        } else {
            View[] viewArr = this.f177355a0;
            if (view == viewArr[0]) {
                TroopManager troopManager = (TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER);
                if (troopManager != null) {
                    troopInfo = troopManager.k(this.f177365k0);
                } else {
                    troopInfo = null;
                }
                if (troopInfo != null) {
                    Bundle c16 = com.tencent.mobileqq.troop.utils.aq.c(this.f177365k0, 28, troopInfo.troopLat, troopInfo.troopLon, 0, "");
                    c16.putInt(AppConstants.Key.TROOP_INFO_TROOP_TYPE_EX, troopInfo.troopTypeExt);
                    ((ITroopInfoActivityApi) QRoute.api(ITroopInfoActivityApi.class)).openTroopProfileForResult(this, c16, 1000);
                }
            } else {
                int i3 = 1;
                if (view == viewArr[1]) {
                    oidb_0xe83$AppInfo I2 = I2(1101236949L);
                    if (I2 != null) {
                        M2(I2);
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "onClick, appInfo for announce is null, req from server");
                        }
                        showProgressDialog();
                        com.tencent.mobileqq.troop.troopapps.api.a aVar = (com.tencent.mobileqq.troop.troopapps.api.a) this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_APP_HANDLER);
                        if (aVar != null) {
                            String str2 = this.f177365k0;
                            if (!StudyModeManager.t()) {
                                i3 = -1;
                            }
                            aVar.x1(str2, false, 0, 0, i3);
                        }
                    }
                } else if (view == viewArr[2]) {
                    Intent intent2 = new Intent();
                    intent2.putExtra(QZoneHelper.Constants.KEY_QUN_ID, this.f177365k0);
                    intent2.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 1000);
                    ((ITroopFileApi) QRoute.api(ITroopFileApi.class)).openTroopFileMainPage(this, intent2, 1002);
                } else if (view == viewArr[3]) {
                    QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                    userInfo.qzone_uin = this.app.getCurrentAccountUin();
                    userInfo.nickname = this.app.getCurrentNickname();
                    QZoneHelper.forwardToQunAlbumList(this, userInfo, this.f177365k0, this.f177366l0, 3, 1003, "qunnotice");
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

    protected void showProgressDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (this.f177368n0 == null) {
            this.f177368n0 = new QQProgressDialog(this);
        }
        this.f177368n0.setMessage(R.string.eqf);
        this.f177368n0.setOffsetY(getTitleBarHeight());
        this.f177368n0.show();
    }
}
