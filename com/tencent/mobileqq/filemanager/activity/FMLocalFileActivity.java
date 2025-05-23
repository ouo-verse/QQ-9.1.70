package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.data.g;
import com.tencent.mobileqq.filemanager.data.h;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.d;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FMLocalFileActivity extends BaseFileAssistantActivity {

    /* renamed from: d1, reason: collision with root package name */
    public static String f206229d1 = "FileAssistantActivity<FileAssistant>";
    XListView Y0;

    /* renamed from: b1, reason: collision with root package name */
    boolean f206231b1;
    List<h> X0 = new ArrayList();
    g Z0 = null;

    /* renamed from: a1, reason: collision with root package name */
    private AsyncTask f206230a1 = null;

    /* renamed from: c1, reason: collision with root package name */
    public View.OnClickListener f206232c1 = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!FMLocalFileActivity.this.w3()) {
                if (QLog.isColorLevel()) {
                    QLog.i(FMLocalFileActivity.f206229d1, 2, "click too fast , wait a minute.");
                }
            } else {
                FMLocalFileActivity.this.Q3();
                int i3 = ((g.a) view.getTag()).C;
                if (i3 != 0) {
                    SharedPreferences.Editor edit = FMLocalFileActivity.this.D0.getApplicationContext().getSharedPreferences("aio_last_select_file", 0).edit();
                    edit.putBoolean("last_select_All", true);
                    edit.commit();
                    FMLocalFileActivity.this.d4(i3);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void c4() {
        QQTheme.isNowSimpleUI();
        ColorStateList colorStateList = getResources().getColorStateList(R.color.qui_common_text_nav_secondary);
        this.centerView.setTextColor(colorStateList);
        this.rightViewImg.setColorFilter(new PorterDuffColorFilter(colorStateList.getDefaultColor(), PorterDuff.Mode.SRC_IN));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d4(int i3) {
        Intent intent;
        if (i3 != 11) {
            if (i3 == 20) {
                U2().E();
                finish();
                overridePendingTransition(R.anim.f154892f3, R.anim.f154893f4);
                return;
            }
            switch (i3) {
                case 6:
                case 7:
                case 8:
                case 9:
                    break;
                default:
                    intent = null;
                    break;
            }
            if (i3 == 7) {
                if (p3()) {
                    U2().j();
                } else {
                    U2().J();
                }
            } else if (i3 == 8) {
                if (p3()) {
                    U2().d();
                } else {
                    U2().X();
                }
            }
            if (intent == null) {
                return;
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("category", i3);
                intent.putExtra("bundle", bundle);
                Intent intent2 = getIntent();
                boolean booleanExtra = intent2.getBooleanExtra("STRING_SingleSelect", false);
                intent.putExtra("localSdCardfile", intent2.getIntExtra("localSdCardfile", -1));
                if (booleanExtra) {
                    intent.putExtra("STRING_SingleSelect", booleanExtra);
                }
                String[] stringArrayExtra = intent2.getStringArrayExtra("STRING_Show_Within_Suffixs");
                if (stringArrayExtra != null) {
                    intent.putExtra("STRING_Show_Within_Suffixs", stringArrayExtra);
                }
                intent.putExtra("select_file_only_docs_file", this.f206167a0.Z());
                intent.putExtra("qrlogin_appid", this.T0);
                startActivityForResult(intent, 100);
                overridePendingTransition(R.anim.f154892f3, R.anim.f154893f4);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        if (Environment.getExternalStorageState().equals("mounted")) {
            intent = new Intent(getApplicationContext(), (Class<?>) LocalFileBrowserActivity.class);
            if (i3 == 7) {
            }
            if (intent == null) {
            }
        } else {
            d.e(R.string.i3c);
            intent = null;
            if (i3 == 7) {
            }
            if (intent == null) {
            }
        }
    }

    private void e4() {
        boolean z16;
        boolean z17;
        this.X0.clear();
        getString(R.string.baf);
        getString(R.string.bad);
        getString(R.string.bah);
        getString(R.string.baa);
        getString(R.string.f187173t_);
        String string = getString(R.string.f1354401g);
        String string2 = getString(R.string.b6z);
        String string3 = getString(R.string.b6y);
        String string4 = getString(R.string.b7l);
        Intent intent = getIntent();
        boolean z18 = true;
        if (intent != null) {
            boolean booleanExtra = intent.getBooleanExtra("STRING_Show_Driver_Category", true);
            boolean booleanExtra2 = intent.getBooleanExtra("STRING_Show_MyFile_Category", false);
            z16 = intent.getBooleanExtra("STRING_Show_First_Space", true);
            z17 = booleanExtra2;
            z18 = booleanExtra;
        } else {
            z16 = true;
            z17 = false;
        }
        if (z18) {
            b4(R.layout.alk, R.drawable.qq_leba_list_seek_folder, 2, null, 0, false, 0, 1);
        }
        if (z17) {
            b4(R.layout.ali, R.drawable.e9n, 0, string4, 0, false, 20, 2);
        }
        if (z16) {
            b4(R.layout.alc, R.drawable.qq_leba_list_seek_folder, 1, null, 0, false, 0, 1);
        }
        b4(R.layout.ali, R.drawable.e9o, 0, string, 0, false, 7, 3);
        if (ah.U(this).containsKey(FileManagerUtil.EXTERNAL_SD_CARD)) {
            b4(R.layout.ali, R.drawable.e9p, 0, string2, 0, false, 8, 3);
            b4(R.layout.ali, R.drawable.e9p, 0, string3, 0, false, 11, 4);
        } else {
            b4(R.layout.ali, R.drawable.e9p, 0, string2, 0, false, 8, 4);
        }
        g gVar = this.Z0;
        if (gVar == null) {
            return;
        }
        gVar.notifyDataSetChanged();
    }

    private void initTitleBar() {
        String string = getString(R.string.b7n);
        this.f206185s0 = string;
        setTitle(string);
    }

    public void b4(int i3, int i16, int i17, String str, int i18, boolean z16, int i19, int i26) {
        h hVar = new h();
        hVar.f207781b = i3;
        hVar.f207782c = i16;
        hVar.f207780a = i17;
        hVar.f207783d = str;
        hVar.f207784e = i18;
        hVar.f207785f = z16;
        hVar.f207786g = i19;
        hVar.f207791l = i26;
        this.X0.add(hVar);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        super.doOnActivityResult(i3, i16, intent);
        if (i16 != 4 && i16 != 5) {
            e4();
        } else if (i16 == 5) {
            U2().m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        setContentView(R.layout.alm);
        this.Y0 = (XListView) findViewById(R.id.efz);
        g gVar = new g(this, this.X0, this.f206232c1);
        this.Z0 = gVar;
        this.Y0.setAdapter((ListAdapter) gVar);
        initTitleBar();
        e4();
        switch (getIntent().getIntExtra("localSdCardfile", -1)) {
            case 1408041716:
                e3();
                this.f206167a0.setEditBtnVisible(false);
                setTitle(R.string.b7n);
                return true;
            case 1408041717:
                this.leftView.setVisibility(8);
                this.f206167a0.setEditBtnVisible(false);
                setTitle(R.string.b7n);
                break;
        }
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("select_file_only_docs_file", false);
        this.f206231b1 = booleanExtra;
        this.f206167a0.setDocsCheck(booleanExtra);
        if (this.f206231b1) {
            this.f206167a0.setOnlyDocsChecked();
        }
        String stringExtra = intent.getStringExtra(IProfileProtocolConst.PARAM_TARGET_UIN);
        if (bundle == null || !AppConstants.DATALINE_PC_UIN.equals(stringExtra)) {
            d4(intent.getIntExtra("category", 0));
        }
        I2();
        c4();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        AsyncTask asyncTask = this.f206230a1;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
        this.f206230a1 = null;
        super.doOnDestroy();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
