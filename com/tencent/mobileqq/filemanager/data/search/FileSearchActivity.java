package com.tencent.mobileqq.filemanager.data.search;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment;
import com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchFragment;
import com.tencent.mobileqq.search.base.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileSearchActivity extends BaseSearchActivity {
    static List<y> B0 = null;
    private static String C0 = "SEARCH_FILE_EXIT_EVENT";

    /* renamed from: n0, reason: collision with root package name */
    private String f207861n0;

    /* renamed from: p0, reason: collision with root package name */
    private String f207863p0;

    /* renamed from: q0, reason: collision with root package name */
    private Bundle f207864q0;

    /* renamed from: r0, reason: collision with root package name */
    List<y> f207865r0;

    /* renamed from: s0, reason: collision with root package name */
    private BaseSearchFragment f207866s0;

    /* renamed from: t0, reason: collision with root package name */
    private SearchTypeFragment f207867t0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f207862o0 = true;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f207868u0 = false;

    /* renamed from: v0, reason: collision with root package name */
    public int f207869v0 = -1;

    /* renamed from: w0, reason: collision with root package name */
    public String f207870w0 = "";

    /* renamed from: x0, reason: collision with root package name */
    protected String f207871x0 = "";

    /* renamed from: y0, reason: collision with root package name */
    protected Bundle f207872y0 = null;

    /* renamed from: z0, reason: collision with root package name */
    private Dialog f207873z0 = null;
    BroadcastReceiver A0 = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (FileSearchActivity.C0.equals(intent.getAction()) && FileSearchActivity.this.U2()) {
                FileSearchActivity.this.finish();
                QLog.d("FileSearchActivity<QFile>", 1, "onReceive SEARCH_FILE_EXIT_EVENT.");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (z16 && FileSearchActivity.this.U2()) {
                FileSearchActivity.this.b3(false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (FileSearchActivity.this.f207873z0 != null) {
                FileSearchActivity.this.finish();
            }
        }
    }

    public static void V2(Context context, int i3, String str) {
        Y2(context, null, null, false, i3, str, null);
    }

    public static void W2(Context context, String str, List<y> list, boolean z16, int i3) {
        Y2(context, str, list, z16, i3, "", null);
    }

    public static void Y2(Context context, String str, List<y> list, boolean z16, int i3, String str2, Bundle bundle) {
        Intent intent = new Intent(context, (Class<?>) FileSearchActivity.class);
        intent.putExtra("keyword", str);
        intent.putExtra("show_Header", z16);
        intent.putExtra("from_type", i3);
        intent.putExtra("qfile_search_param_uin", str2);
        if (bundle != null) {
            QLog.d("FileSearchActivity<QFile>", 1, "NTScanSpaceManager exParams : " + bundle.getInt("key_source"));
            intent.putExtra("qfile_search_param_ex_params", bundle);
        }
        B0 = list;
        if (list == null) {
            B0 = new ArrayList();
        }
        context.startActivity(intent);
    }

    public static void Z2(Activity activity, String str, List<y> list, boolean z16, int i3, String str2, Bundle bundle) {
        Intent intent = new Intent(activity, (Class<?>) FileSearchActivity.class);
        intent.putExtra("keyword", str);
        intent.putExtra("show_Header", z16);
        intent.putExtra("from_type", i3);
        intent.putExtra("qfile_search_param_uin", str2);
        intent.putExtra("file_list_fragment_cls", bundle);
        if (bundle != null) {
            intent.putExtra("qfile_search_param_ex_params", bundle);
        }
        B0 = list;
        if (list == null) {
            B0 = new ArrayList();
        }
        activity.startActivityForResult(intent, 9999);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b3(boolean z16, boolean z17) {
        String str;
        String str2;
        int i3 = 2;
        QLog.d("FileSearchActivity<QFile>", 2, "reportBtn. isCancelBtn: " + z16 + ", isClick: " + z17);
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_bas_file_search_activation");
        if (z16) {
            str = "em_bas_cancel";
        } else {
            str = "em_bas_search";
        }
        hashMap.put("dt_eid", str);
        HashMap hashMap2 = new HashMap();
        if (this.f207869v0 == 22) {
            i3 = 1;
        }
        hashMap2.put("search_hierarchy", Integer.valueOf(i3));
        hashMap.put("cur_pg", hashMap2);
        if (z17) {
            str2 = "clck";
        } else {
            str2 = "imp";
        }
        VideoReport.reportEvent(str2, hashMap);
    }

    private void c3(boolean z16) {
        String str;
        int i3 = 2;
        QLog.d("FileSearchActivity<QFile>", 2, "reportPageExposure. isPageIn: " + z16);
        HashMap hashMap = new HashMap();
        if (this.f207869v0 == 22) {
            i3 = 1;
        }
        hashMap.put("search_hierarchy", Integer.valueOf(i3));
        hashMap.put("dt_pgid", "pg_bas_file_search_activation");
        if (z16) {
            str = "pgin";
        } else {
            str = "pgout";
        }
        VideoReport.reportEvent(str, hashMap);
    }

    private void d3() {
        int i3 = this.f207869v0;
        if (i3 == 2) {
            com.tencent.imcore.message.report.a.g(getAppRuntime(), 5, 1);
        } else if (i3 == 13) {
            com.tencent.imcore.message.report.a.g(getAppRuntime(), 5, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    public void G2() {
        BaseSearchFragment baseSearchFragment;
        if (U2() && (baseSearchFragment = this.f282785d0) != null && (baseSearchFragment instanceof FileSearchFragment)) {
            ((FileSearchFragment) baseSearchFragment).Xh();
            BaseSearchFragment baseSearchFragment2 = this.f282785d0;
            if (((FileSearchFragment) baseSearchFragment2).X) {
                ((FileSearchFragment) baseSearchFragment2).Qh(true);
            } else {
                b3(true, true);
            }
        }
        hideInputMethod();
        super.G2();
        T2();
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    protected void H2() {
        if (U2()) {
            b3(false, true);
        }
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    protected String I2() {
        return String.valueOf(16);
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    protected String J2() {
        this.f282784c0.setFocusable(true);
        if (TextUtils.isEmpty(this.f207861n0)) {
            new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.search.FileSearchActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    ((InputMethodManager) FileSearchActivity.this.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(((BaseSearchActivity) FileSearchActivity.this).f282784c0, 1);
                }
            }, 200L);
        }
        String qqStr = HardCodeUtil.qqStr(R.string.mjx);
        int i3 = this.f207869v0;
        if (i3 == 16) {
            return getString(R.string.w0b);
        }
        if (i3 == 17) {
            return getString(R.string.w0a);
        }
        if (i3 == 4) {
            return getString(R.string.f170725a14);
        }
        if (i3 == 22) {
            return getString(R.string.zyn);
        }
        if (i3 == 23) {
            return String.format(HardCodeUtil.qqStr(R.string.zym), this.f207871x0);
        }
        return qqStr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    protected BaseSearchFragment K2() {
        FileSelectorSearchFragment fileSelectorSearchFragment;
        int i3 = this.f207869v0;
        if (i3 == 8) {
            FileSearchFragment fileSearchFragment = new FileSearchFragment();
            fileSearchFragment.C = B0;
            fileSearchFragment.D = this.f207861n0;
            fileSearchFragment.F = this.f207869v0;
            fileSearchFragment.Yh(this.f207862o0);
            fileSelectorSearchFragment = fileSearchFragment;
        } else if (i3 == 2) {
            ChatFileSearchFragment chatFileSearchFragment = new ChatFileSearchFragment();
            chatFileSearchFragment.f207843b0 = this.f207863p0;
            chatFileSearchFragment.C = B0;
            chatFileSearchFragment.D = this.f207861n0;
            chatFileSearchFragment.f207844c0 = 1;
            chatFileSearchFragment.F = this.f207869v0;
            chatFileSearchFragment.Yh(false);
            this.f207866s0 = chatFileSearchFragment;
            fileSelectorSearchFragment = chatFileSearchFragment;
        } else if (i3 == 13) {
            TroopFileSearchFragment troopFileSearchFragment = new TroopFileSearchFragment();
            troopFileSearchFragment.C = this.f207869v0;
            troopFileSearchFragment.D = Long.parseLong(this.f207863p0);
            this.f207866s0 = troopFileSearchFragment;
            fileSelectorSearchFragment = troopFileSearchFragment;
        } else if (i3 != 15 && i3 != 16 && i3 != 17 && i3 != 18 && i3 != 19) {
            QLog.w("FileSearchActivity<QFile>", 1, "newSearchFragment. can not handle type. type[" + this.f207869v0 + "]");
            FileSearchFragment fileSearchFragment2 = new FileSearchFragment();
            fileSearchFragment2.C = B0;
            fileSearchFragment2.D = this.f207861n0;
            int i16 = this.f207869v0;
            fileSearchFragment2.F = i16;
            fileSearchFragment2.H = this.f207872y0;
            if (i16 == 22) {
                fileSearchFragment2.G = String.format(HardCodeUtil.qqStr(R.string.zyc), getString(R.string.zyk));
            } else if (i16 == 23) {
                fileSearchFragment2.G = String.format(HardCodeUtil.qqStr(R.string.zyc), this.f207871x0);
            }
            fileSearchFragment2.Yh(this.f207862o0);
            FileSearchResultView.w(fileSearchFragment2);
            fileSelectorSearchFragment = fileSearchFragment2;
        } else {
            FileSelectorSearchFragment fileSelectorSearchFragment2 = new FileSelectorSearchFragment();
            fileSelectorSearchFragment2.vh(this.f207869v0);
            fileSelectorSearchFragment2.uh(this.f207864q0);
            this.f207866s0 = fileSelectorSearchFragment2;
            fileSelectorSearchFragment = fileSelectorSearchFragment2;
        }
        com.tencent.mobileqq.search.report.b.e(null, 0, this.f207869v0, "0X8009D58", 0, 0, null, null);
        return fileSelectorSearchFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    public void L2(String str) {
        e3(str, new Bundle());
    }

    public void T2() {
        if (this.f207869v0 == 2) {
            overridePendingTransition(0, 0);
        }
    }

    protected boolean U2() {
        int i3 = this.f207869v0;
        if (i3 != 22 && i3 != 23) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (U2()) {
            return;
        }
        super.afterTextChanged(editable);
        int i3 = this.f207869v0;
        if (i3 != 2 && i3 != 13) {
            return;
        }
        String obj = this.f282784c0.getText().toString();
        if (this.f207866s0 != null && this.f207867t0 != null) {
            if (TextUtils.isEmpty(obj) && !this.f207868u0) {
                FragmentTransaction beginTransaction = super.getSupportFragmentManager().beginTransaction();
                beginTransaction.show(this.f207867t0);
                beginTransaction.hide(this.f207866s0);
                beginTransaction.commit();
                this.f207868u0 = true;
                return;
            }
            if (!TextUtils.isEmpty(obj)) {
                FragmentTransaction beginTransaction2 = super.getSupportFragmentManager().beginTransaction();
                beginTransaction2.show(this.f207866s0);
                beginTransaction2.hide(this.f207867t0);
                beginTransaction2.commit();
                this.f207868u0 = false;
                d3();
            }
        }
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        super.doOnActivityResult(i3, i16, intent);
        if (i3 == 9999 && intent != null && intent.getIntExtra("qfile_send_bottom_bar_finish_result_code", 0) == -1) {
            setResult(i16, new Intent(intent));
            finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        super.doOnBackPressed();
        T2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        Intent intent = getIntent();
        this.f207861n0 = intent.getStringExtra("keyword");
        this.f207862o0 = intent.getBooleanExtra("show_Header", true);
        this.f207869v0 = intent.getIntExtra("from_type", -1);
        this.f207863p0 = intent.getStringExtra("qfile_search_param_uin");
        Bundle bundleExtra = intent.getBundleExtra("qfile_search_param_ex_params");
        this.f207864q0 = bundleExtra;
        if (bundleExtra != null) {
            this.f207870w0 = bundleExtra.getString("search_pc_file_id");
            this.f207871x0 = this.f207864q0.getString("search_pc_cur_dir_name");
        }
        this.f207872y0 = intent.getBundleExtra("file_list_fragment_cls");
        QLog.d("FileSearchActivity<QFile>", 1, "doOnCreate. mKeyWords: " + this.f207861n0 + ", mShowHeader: " + this.f207862o0 + ", mFromType: " + this.f207869v0 + ", mFromUin: " + this.f207863p0 + ", mPCFileId: " + this.f207870w0 + ", mFileListFragmentCls: " + this.f207872y0 + ", mCurDirName: " + this.f207871x0);
        int i3 = this.f207869v0;
        if (i3 == 2 || i3 == 13) {
            overridePendingTransition(0, 0);
        }
        if (isInMultiWindow()) {
            this.mNeedStatusTrans = false;
        }
        super.doOnCreate(bundle);
        int i16 = this.f207869v0;
        if (i16 == 2) {
            this.f207867t0 = new SearchTypeFragment();
            ArrayList arrayList = new ArrayList(Arrays.asList(3, 2, 0, 1, 11));
            SearchTypeFragment searchTypeFragment = this.f207867t0;
            searchTypeFragment.D = arrayList;
            searchTypeFragment.E = 3;
            searchTypeFragment.rh(new ub1.b((QQAppInterface) getAppRuntime(), this, this.f207863p0, arrayList));
        } else if (i16 == 13) {
            SearchTypeFragment searchTypeFragment2 = new SearchTypeFragment();
            this.f207867t0 = searchTypeFragment2;
            searchTypeFragment2.D = Arrays.asList(13, 3, 2, 0, 1, 11);
            this.f207867t0.E = 3;
            Bundle bundle2 = this.f207864q0;
            if (bundle2 != null && bundle2.getInt("key_source") == 1) {
                QLog.d("FileSearchActivity<QFile>", 1, "NTScanSpaceManager FileSearchActivity.doOnCreate source: " + this.f207864q0.getInt("key_source"));
                this.f207867t0.rh(new ub1.c((QQAppInterface) getAppRuntime(), this, this.f207863p0, this.f207864q0.getInt("key_source")));
            } else {
                this.f207867t0.rh(new ub1.c((QQAppInterface) getAppRuntime(), this, this.f207863p0, 0));
            }
        }
        SearchTypeFragment searchTypeFragment3 = this.f207867t0;
        if (searchTypeFragment3 != null) {
            searchTypeFragment3.I = this.f207863p0;
            FragmentTransaction beginTransaction = super.getSupportFragmentManager().beginTransaction();
            beginTransaction.add(R.id.ijj, this.f207867t0);
            beginTransaction.commitAllowingStateLoss();
            if (!TextUtils.isEmpty(this.f282782a0) && this.f207869v0 == 2) {
                beginTransaction.hide(this.f207867t0);
                beginTransaction.show(this.f207866s0);
            }
            this.f207868u0 = true;
        }
        this.f207865r0 = new ArrayList();
        if (B0 == null) {
            B0 = new ArrayList();
        }
        this.f207865r0.addAll(B0);
        B0 = null;
        this.f282783b0.updateStyle(2);
        if (U2()) {
            FileSearchResultView.s(this.f207869v0, this.f207872y0);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(C0);
            getApplicationContext().registerReceiver(this.A0, intentFilter);
            this.f282784c0.setOnFocusChangeListener(new b());
        } else {
            this.f282783b0.getBackView().setVisibility(0);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        if (U2()) {
            QLog.d("FileSearchActivity<QFile>", 1, "doOnDestroy.");
            BaseSearchFragment baseSearchFragment = this.f282785d0;
            if (baseSearchFragment != null && (baseSearchFragment instanceof FileSearchFragment)) {
                ((FileSearchFragment) baseSearchFragment).Nh();
            }
            FileSearchResultView.x();
            getApplicationContext().unregisterReceiver(this.A0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        if (U2()) {
            BaseSearchFragment baseSearchFragment = this.f282785d0;
            if (baseSearchFragment != null && (baseSearchFragment instanceof FileSearchFragment) && ((FileSearchFragment) baseSearchFragment).X) {
                ((FileSearchFragment) baseSearchFragment).Th(false);
            } else {
                c3(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        if (U2()) {
            BaseSearchFragment baseSearchFragment = this.f282785d0;
            if (baseSearchFragment != null && (baseSearchFragment instanceof FileSearchFragment) && ((FileSearchFragment) baseSearchFragment).X) {
                ((FileSearchFragment) baseSearchFragment).Th(true);
                ((FileSearchFragment) this.f282785d0).Qh(false);
            } else {
                c3(true);
                b3(true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        super.doOnStop();
    }

    protected void e3(String str, Bundle bundle) {
        String str2 = this.f282782a0;
        if (str2 != null && str2.equals(str)) {
            return;
        }
        this.f282782a0 = str;
        if (U2()) {
            showProgressDialog();
            bundle = new Bundle();
            bundle.putString("search_pc_file_id", this.f207870w0);
        }
        this.f282785d0.startSearch(new pn2.a(str, bundle), 1);
    }

    public void f3(String str) {
        this.f282782a0 = str;
    }

    public void g3(String str) {
        QUISearchBar qUISearchBar = this.f282783b0;
        if (qUISearchBar != null) {
            qUISearchBar.setEtInputHint(str);
        }
    }

    public void hideProgressDialog() {
        Dialog dialog = this.f207873z0;
        if (dialog != null) {
            dialog.dismiss();
            this.f207873z0.cancel();
            this.f207873z0 = null;
        }
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    public void showProgressDialog() {
        if (this.f207873z0 == null) {
            ReportDialog reportDialog = new ReportDialog(this, R.style.qZoneInputDialog);
            this.f207873z0 = reportDialog;
            reportDialog.setCancelable(true);
            this.f207873z0.setCanceledOnTouchOutside(true);
            this.f207873z0.setContentView(R.layout.f168383uh);
            this.f207873z0.setOnDismissListener(new c());
        }
        TextView textView = (TextView) this.f207873z0.findViewById(R.id.photo_prievew_progress_dialog_text);
        textView.setText(textView.getResources().getString(R.string.f224656ji));
        if (!this.f207873z0.isShowing()) {
            try {
                this.f207873z0.show();
            } catch (Exception e16) {
                QLog.d("searchUtils", 2, "mProgressDialog show failed. " + e16.getMessage());
            }
        }
    }
}
