package com.tencent.mobileqq.filemanager.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IFileDeleteListener;
import com.tencent.mobileqq.filemanager.api.IFileSandboxPathUtilApi;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.util.t;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.u;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qui.quiblurview.QQBlurView;
import com.tencent.util.LoadingUtil;
import com.tencent.util.TokenResUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ListView;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SendBottomBar extends RelativeLayout {
    private TextView C;
    private TextView D;
    private TextView E;
    private CheckBox F;
    private BaseFileAssistantActivity G;
    private t H;
    private com.tencent.mobileqq.filemanager.activity.fileassistant.a I;
    private boolean J;
    private boolean K;
    private FrameLayout L;
    private TextView M;
    private boolean N;
    private View P;
    private boolean Q;
    private QQBlurView R;
    private long S;
    private int T;
    private long U;
    private Dialog V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f209487a0;

    /* renamed from: b0, reason: collision with root package name */
    private long f209488b0;

    /* renamed from: c0, reason: collision with root package name */
    private View.OnClickListener f209489c0;

    /* renamed from: d, reason: collision with root package name */
    public QQProgressDialog f209490d;

    /* renamed from: d0, reason: collision with root package name */
    private View.OnClickListener f209491d0;

    /* renamed from: e, reason: collision with root package name */
    ActionSheet f209492e;

    /* renamed from: e0, reason: collision with root package name */
    private View.OnClickListener f209493e0;

    /* renamed from: f, reason: collision with root package name */
    QQCustomDialog f209494f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f209495f0;

    /* renamed from: g0, reason: collision with root package name */
    private View.OnClickListener f209496g0;

    /* renamed from: h, reason: collision with root package name */
    private BaseQQAppInterface f209497h;

    /* renamed from: i, reason: collision with root package name */
    private Context f209498i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f209499m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                SendBottomBar.this.m0();
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c extends DialogUtil.DialogOnClickAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f209507d;

        c(int i3) {
            this.f209507d = i3;
        }

        @Override // com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter, android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            SendBottomBar.this.O(this.f209507d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SendBottomBar.this.t0();
            if (SendBottomBar.this.G.S2() == 10014) {
                SendBottomBar.this.n0();
            } else {
                SendBottomBar.this.o0();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (SendBottomBar.this.H != null) {
                SendBottomBar.this.H.f();
            }
            if (SendBottomBar.this.g0()) {
                ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).previewFavImageFile(SendBottomBar.this.G);
            } else {
                ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).previewImage(SendBottomBar.this.G, SendBottomBar.this.N(), SendBottomBar.this.G.u3());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (SendBottomBar.this.F.isChecked()) {
                SendBottomBar.this.J = true;
                FileManagerReporter.addData("0X800942B");
            } else {
                SendBottomBar.this.N = false;
                SendBottomBar.this.J = false;
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (SendBottomBar.this.F.isChecked()) {
                SendBottomBar.this.I.e();
                SendBottomBar.this.F.setText(HardCodeUtil.qqStr(R.string.f186773s7));
            } else {
                SendBottomBar.this.I.b();
                SendBottomBar.this.F.setText(HardCodeUtil.qqStr(R.string.f187183ta));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class j implements View.OnClickListener {

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                SendBottomBar.this.J();
            }
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class b implements DialogInterface.OnClickListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (SendBottomBar.this.f209494f.isShowing()) {
                    SendBottomBar.this.f209494f.dismiss();
                }
            }
        }

        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            EventCollector.getInstance().onViewClickedBefore(view);
            String str4 = HardCodeUtil.qqStr(R.string.f187083t1) + com.tencent.mobileqq.filemanager.data.f.s() + HardCodeUtil.qqStr(R.string.f187093t2);
            String qqStr = HardCodeUtil.qqStr(R.string.f186873sg);
            if (SendBottomBar.this.G.Y2() != -1) {
                str = HardCodeUtil.qqStr(R.string.f186883sh);
                str3 = HardCodeUtil.qqStr(R.string.f186903sj);
                str2 = HardCodeUtil.qqStr(R.string.f186893si);
            } else {
                str = str4;
                str2 = qqStr;
                str3 = null;
            }
            SendBottomBar sendBottomBar = SendBottomBar.this;
            sendBottomBar.f209494f = DialogUtil.createCustomDialog(sendBottomBar.G, 230, str3, str, HardCodeUtil.qqStr(R.string.cancel), str2, new a(), new b());
            SendBottomBar.this.f209494f.show();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!SendBottomBar.this.f209492e.isShowing()) {
                SendBottomBar.this.f209492e.show();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class l implements ActionSheet.OnButtonClickListenerV2 {
        l() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListenerV2
        public void OnClick(View view, int i3, String str) {
            if (str.equals(HardCodeUtil.qqStr(R.string.zyr))) {
                SendBottomBar.this.E.setText(R.string.zyr);
                if (SendBottomBar.this.G.Y2() == 0) {
                    return;
                } else {
                    SendBottomBar.this.G.T3(0);
                }
            } else if (str.equals(HardCodeUtil.qqStr(R.string.zyq))) {
                SendBottomBar.this.E.setText(R.string.zyq);
                if (SendBottomBar.this.G.Y2() == 1) {
                    return;
                } else {
                    SendBottomBar.this.G.T3(1);
                }
            } else if (str.equals(HardCodeUtil.qqStr(R.string.zys))) {
                SendBottomBar.this.E.setText(R.string.zys);
                if (SendBottomBar.this.G.Y2() == 2) {
                    return;
                } else {
                    SendBottomBar.this.G.T3(2);
                }
            }
            SendBottomBar.this.f209492e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SendBottomBar.this.X(false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SendBottomBar.this.m0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public SendBottomBar(Context context) {
        super(context, null);
        this.f209492e = null;
        this.f209494f = null;
        this.f209497h = null;
        this.f209499m = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.I = null;
        this.J = false;
        this.K = false;
        this.L = null;
        this.M = null;
        this.N = false;
        this.Q = true;
        this.R = null;
        this.S = 0L;
        this.U = 0L;
        this.f209489c0 = new g();
        this.f209491d0 = new i();
        this.f209493e0 = new j();
        this.f209495f0 = false;
        this.f209496g0 = new View.OnClickListener() { // from class: com.tencent.mobileqq.filemanager.widget.SendBottomBar.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean z16;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (!SendBottomBar.this.f209495f0) {
                    SendBottomBar.this.f209495f0 = true;
                    new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.widget.SendBottomBar.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SendBottomBar.this.f209495f0 = false;
                        }
                    }, 800L);
                    SendBottomBar.this.S();
                    int P2 = SendBottomBar.this.G.P2();
                    if (P2 == 1) {
                        SendBottomBar.this.Y();
                    } else if (P2 != 5) {
                        switch (P2) {
                            case 7:
                                SendBottomBar.this.T();
                                break;
                            case 8:
                                SendBottomBar.this.U();
                                break;
                            case 9:
                                SendBottomBar.this.Q();
                                break;
                            case 10:
                                SendBottomBar.this.W();
                                break;
                            case 11:
                                SendBottomBar.this.P();
                                break;
                            default:
                                if (!AppNetConnInfo.isNetSupport()) {
                                    com.tencent.mobileqq.filemanager.util.d.e(R.string.f187123t5);
                                    break;
                                } else {
                                    int S2 = SendBottomBar.this.G.S2();
                                    if (S2 == 1) {
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                    if (S2 == 5) {
                                        SendBottomBar.this.m0();
                                        break;
                                    } else if (SendBottomBar.this.G.A0) {
                                        SendBottomBar.this.X(false);
                                        break;
                                    } else if (z16) {
                                        SendBottomBar.this.X(true);
                                        break;
                                    } else {
                                        SendBottomBar.this.R();
                                        break;
                                    }
                                }
                        }
                    } else {
                        SendBottomBar.this.V();
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.alz, this);
        this.f209498i = context;
        f0();
    }

    private boolean I(String str) {
        String str2;
        if (!this.K || this.F.getVisibility() != 0) {
            return false;
        }
        long s16 = com.tencent.mobileqq.filemanager.data.f.s();
        String valueOf = String.valueOf(s16);
        this.f209499m.setEnabled(true);
        this.E.setVisibility(0);
        if (s16 > 99) {
            str2 = HardCodeUtil.qqStr(R.string.f186923sl);
        } else if (s16 == 0) {
            str2 = HardCodeUtil.qqStr(R.string.f186873sg);
            this.E.setVisibility(8);
            this.f209499m.setEnabled(false);
        } else {
            str2 = HardCodeUtil.qqStr(R.string.f186933sm) + valueOf + ")";
        }
        if (a0()) {
            this.f209499m.setText(HardCodeUtil.qqStr(R.string.f186873sg));
            ColorStateList colorStateList = this.f209498i.getResources().getColorStateList(R.color.f156783bk);
            this.f209499m.setBackgroundDrawable(null);
            this.f209499m.setTextColor(colorStateList);
            this.f209499m.setTextSize(1, 17.0f);
            this.F.setCompoundDrawables(null, null, null, null);
            this.F.setTextColor(getResources().getColor(R.color.skin_black_theme_version2));
            this.F.setTextSize(1, 17.0f);
            this.E.setTextColor(getResources().getColor(R.color.skin_black_theme_version2));
            this.E.setTextSize(1, 14.0f);
            if (s16 > 0) {
                this.M.setText(str);
                this.M.setVisibility(0);
                this.M.setGravity(17);
                this.L.setVisibility(0);
            } else {
                this.L.setVisibility(8);
            }
        } else {
            this.f209499m.setText(str2);
            this.E.setText(str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (this.f209497h == null) {
            this.f209497h = (BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        }
        ((IFileDeleteListener) QRoute.api(IFileDeleteListener.class)).onFileDelete(this.f209497h.getCurrentAccountUin(), this.G.getIntent().getIntExtra("message_clean_request_code", -1000));
        FileManagerReporter.addData("0x80087C5");
        s0();
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.widget.SendBottomBar.7

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.filemanager.widget.SendBottomBar$7$a */
            /* loaded from: classes12.dex */
            class a extends AsyncTask<Object, Object, Integer> {
                a() {
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Integer doInBackground(Object... objArr) {
                    Set<FileInfo> n3 = com.tencent.mobileqq.filemanager.data.f.n();
                    ArrayList arrayList = new ArrayList();
                    Iterator<FileInfo> it = n3.iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        FileInfo next = it.next();
                        if (next.o()) {
                            SendBottomBar sendBottomBar = SendBottomBar.this;
                            SendBottomBar.l(sendBottomBar, sendBottomBar.f209488b0);
                            break;
                        }
                        if (!((IQQFileEngine) SendBottomBar.this.f209497h.getRuntimeService(IQQFileEngine.class)).isFileInUploaderQueue(next.k())) {
                            try {
                                File file = new File(next.k());
                                String sandboxPath = ((IFileSandboxPathUtilApi) QRoute.api(IFileSandboxPathUtilApi.class)).getSandboxPath(Environment.getExternalStorageDirectory().getAbsolutePath());
                                if (file.exists() && next.k().startsWith(sandboxPath)) {
                                    file.delete();
                                    QLog.d("delDownloadFiles<FileAssistant>", 1, "del file info:path: " + next.k() + ", size: " + next.l() + ", date: " + next.e());
                                    arrayList.add(next.k());
                                    SendBottomBar.l(SendBottomBar.this, next.l());
                                    i3++;
                                }
                                QLog.e("delDownloadFiles<FileAssistant>", 1, "local file can scan, is not existed or not private? file:" + next.k());
                            } catch (Exception e16) {
                                QLog.e("delDownloadFiles<FileAssistant>", 1, "del file error:" + e16.toString());
                            }
                        }
                    }
                    SendBottomBar.this.G.L2(n3);
                    ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).setStorageRptNeedScan(true);
                    return Integer.valueOf(i3);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public void onPostExecute(Integer num) {
                    super.onPostExecute(num);
                    Intent intent = new Intent();
                    intent.putExtra("extra_delete_total_file_size", SendBottomBar.this.S);
                    SendBottomBar.this.G.setResult(-1, intent);
                    QLog.d("delDownloadFiles<FileAssistant>", 1, "mTotalDelSize:" + SendBottomBar.this.S);
                    com.tencent.mobileqq.filemanager.data.f.k();
                    SendBottomBar.this.H();
                    SendBottomBar.this.setSelectAllOrCancelAll(true);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                new a().execute(new Object[0]);
            }
        }, 100L);
    }

    private FileInfo L(String str) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.z(str);
        fileInfo.y(FileUtils.getFileName(str));
        fileInfo.A(q.m(str));
        return fileInfo;
    }

    private String M() {
        String str;
        long t16 = com.tencent.mobileqq.filemanager.data.f.t();
        this.f209488b0 = t16;
        if (t16 > 0) {
            str = this.f209498i.getString(R.string.f170943b71) + FileCategoryUtil.f(this.f209488b0);
            this.E.setOnClickListener(null);
        } else {
            str = "";
        }
        if (com.tencent.mobileqq.filemanager.data.f.r() > 0 && !ah.a1(this.f209498i)) {
            str = str + this.f209498i.getString(R.string.f170944b72) + FileCategoryUtil.f(com.tencent.mobileqq.filemanager.data.f.r());
        }
        if (ah.a1(this.f209498i)) {
            return this.f209498i.getString(R.string.f170943b71) + com.tencent.mobileqq.filemanager.data.f.s() + HardCodeUtil.qqStr(R.string.f186863sf);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FileManagerEntity N() {
        ArrayList<FileManagerEntity> q16 = com.tencent.mobileqq.filemanager.data.f.q();
        Set<FileInfo> n3 = com.tencent.mobileqq.filemanager.data.f.n();
        ArrayList<WeiYunFileInfo> v3 = com.tencent.mobileqq.filemanager.data.f.v();
        if (q16 != null && q16.size() > 0) {
            Iterator<FileManagerEntity> it = q16.iterator();
            while (it.hasNext()) {
                FileManagerEntity next = it.next();
                if (next.nFileType == 0) {
                    return next;
                }
            }
        }
        if (n3 != null && n3.size() > 0) {
            for (FileInfo fileInfo : n3) {
                if (fileInfo.getType() == 0) {
                    return ah.k1(fileInfo);
                }
            }
        }
        if (v3 != null && v3.size() > 0) {
            Iterator<WeiYunFileInfo> it5 = v3.iterator();
            while (it5.hasNext()) {
                WeiYunFileInfo next2 = it5.next();
                if (ah.o0(next2.f209605f) == 0) {
                    return ah.m1(next2);
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        if (this.G.p3()) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.addAll(com.tencent.mobileqq.filemanager.data.f.n());
            Iterator it = new ArrayList(com.tencent.mobileqq.filemanager.data.f.q()).iterator();
            int i3 = 0;
            while (it.hasNext()) {
                FileManagerEntity fileManagerEntity = (FileManagerEntity) it.next();
                if (q.f(fileManagerEntity.getFilePath())) {
                    try {
                        FileInfo fileInfo = new FileInfo(fileManagerEntity.getFilePath());
                        fileInfo.B(ah.o0(fileInfo.j()));
                        arrayList.add(fileInfo);
                    } catch (FileNotFoundException unused) {
                    }
                } else {
                    i3++;
                }
            }
            if (i3 > 0) {
                QQToast.makeText(this.G, 1, i3 + "\u4e2a\u6587\u4ef6\u672a\u4e0b\u8f7d\uff0c\u65e0\u6cd5\u5206\u4eab", 0).show();
            }
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("reslut_select_file_info_list", arrayList);
            intent.putExtra("approval_attachment_customid", this.G.N2());
            this.G.setResult(-1, intent);
        }
        this.G.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        boolean z16;
        boolean z17;
        int S2 = this.G.S2();
        if (this.G.j3()) {
            Set<FileInfo> n3 = com.tencent.mobileqq.filemanager.data.f.n();
            ArrayList<FileManagerEntity> q16 = com.tencent.mobileqq.filemanager.data.f.q();
            Iterator<FileInfo> it = n3.iterator();
            while (true) {
                z16 = true;
                if (it.hasNext()) {
                    FileInfo next = it.next();
                    if (next.l() > QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT && com.tencent.mobileqq.filemanager.data.f.z(next)) {
                        z17 = true;
                        break;
                    }
                } else {
                    z17 = false;
                    break;
                }
            }
            if (!z17) {
                Iterator<FileManagerEntity> it5 = q16.iterator();
                while (it5.hasNext()) {
                    FileManagerEntity next2 = it5.next();
                    if (next2.fileSize > QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT && com.tencent.mobileqq.filemanager.data.f.A(next2)) {
                        break;
                    }
                }
            }
            z16 = z17;
            if (z16) {
                FileManagerReporter.addData("0X800942E");
                QQCustomDialog createNoTitleDialog = DialogUtil.createNoTitleDialog(this.G, R.string.f0h);
                createNoTitleDialog.setPositiveButton(R.string.i5e, new c(S2));
                createNoTitleDialog.show();
                return;
            }
            O(S2);
            return;
        }
        O(S2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        int i3 = 1;
        if (this.G.S2() == 1) {
            i3 = 2;
        } else if (this.G.S2() != 0) {
            i3 = 4;
        }
        String d36 = this.G.d3();
        if (!TextUtils.isEmpty(d36) && d36.equals(AppConstants.DATALINE_PC_UIN)) {
            i3 = 3;
        }
        ReportController.o(null, "dc00898", "", "", "0X800AA92", "0X800AA92", i3, 0, "" + com.tencent.mobileqq.filemanager.data.f.s(), "0", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        if (this.G.p3()) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.addAll(com.tencent.mobileqq.filemanager.data.f.n());
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("reslut_select_file_info_list", arrayList);
            intent.putExtra("approval_attachment_customid", this.G.N2());
            this.G.setResult(-1, intent);
        }
        this.G.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        Intent intent = this.G.getIntent();
        if (intent != null) {
            if (intent.getStringExtra("posturl") != null) {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                arrayList.addAll(com.tencent.mobileqq.filemanager.data.f.n());
                intent.putParcelableArrayListExtra("fileinfo", arrayList);
                this.G.setResult(-1, intent);
                this.G.finish();
                return;
            }
            this.G.setResult(-1, intent);
            this.G.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (ah.X0() && com.tencent.mobileqq.filemanager.data.f.u() > ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize()) {
            FMDialogUtil.a(this.G, R.string.f187033sw, R.string.f170958ba0, new b());
            return;
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        arrayList.addAll(com.tencent.mobileqq.filemanager.data.f.n());
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("sFilesSelected", arrayList);
        this.G.setResult(-1, intent);
        this.G.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        ContentValues favUtilhandleFileEntry;
        ReportController.o(null, "dc00898", "", "", "0X800B378", "0X800B378", 0, 0, "", "", "", "");
        if (this.G.p3()) {
            ArrayList<FileManagerEntity> q16 = com.tencent.mobileqq.filemanager.data.f.q();
            ArrayList<WeiYunFileInfo> v3 = com.tencent.mobileqq.filemanager.data.f.v();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(com.tencent.mobileqq.filemanager.data.f.n());
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                FileInfo fileInfo = (FileInfo) it.next();
                if (fileInfo != null && (favUtilhandleFileEntry = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).favUtilhandleFileEntry(this.f209497h, null, fileInfo.k(), true)) != null) {
                    arrayList.add(favUtilhandleFileEntry);
                }
            }
            if (q16 != null) {
                Iterator<FileManagerEntity> it5 = q16.iterator();
                while (it5.hasNext()) {
                    ContentValues favUtilhandleFileEntry2 = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).favUtilhandleFileEntry(this.f209497h, it5.next(), "", false);
                    if (favUtilhandleFileEntry2 != null) {
                        arrayList.add(favUtilhandleFileEntry2);
                    }
                }
            }
            if (v3 != null) {
                Iterator<WeiYunFileInfo> it6 = v3.iterator();
                while (it6.hasNext()) {
                    ContentValues favUtilhandleWeiyunFile = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).favUtilhandleWeiyunFile(it6.next());
                    if (favUtilhandleWeiyunFile != null) {
                        arrayList.add(favUtilhandleWeiyunFile);
                    }
                }
            }
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("reslut_select_file_info_list_for_fav", arrayList);
            intent.putExtra("approval_attachment_customid", this.G.N2());
            this.G.setResult(-1, intent);
        }
        this.G.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(boolean z16) {
        boolean z17;
        if (z16) {
            boolean z18 = false;
            if (com.tencent.mobileqq.filemanager.data.f.u() > GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 || this.G.f206172f0) {
                if (!this.G.f206172f0) {
                    z18 = z17;
                }
                IQQFileTempUtils iQQFileTempUtils = (IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class);
                BaseFileAssistantActivity baseFileAssistantActivity = this.G;
                if (iQQFileTempUtils.handleVipForTroopFile(baseFileAssistantActivity, baseFileAssistantActivity.f206171e0, z18, new m())) {
                    return;
                }
            }
        }
        if (!NetworkUtil.isNetSupport(this.G)) {
            com.tencent.mobileqq.filemanager.util.d.e(R.string.f187123t5);
            m0();
            return;
        }
        if (ah.X0()) {
            if (((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).uploadToWyForFreeWifi((Activity) this.f209498i, new n())) {
                a aVar = new a();
                String string = this.f209498i.getString(R.string.f187213td);
                Context context = this.f209498i;
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, context.getString(R.string.f187113t4), string, R.string.cancel, R.string.f187263ti, aVar, aVar);
                ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).changeKingCardWording(createCustomDialog, this.f209498i, string);
                createCustomDialog.show();
                return;
            }
            return;
        }
        m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        int T2 = this.G.T2();
        boolean M2 = this.G.M2();
        if (1 == T2 && !M2) {
            FMDialogUtil.a(this.G, R.string.f171471f53, R.string.f171470f52, new d());
        } else {
            q0();
        }
    }

    private boolean a0() {
        String qqStr;
        int Y2 = this.G.Y2();
        if (Y2 == -1 || !e0()) {
            return false;
        }
        this.E.setOnClickListener(new k());
        if (Y2 != 0) {
            if (Y2 != 1) {
                if (Y2 != 2) {
                    qqStr = "";
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.zys);
                }
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.zyq);
            }
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.zyr);
        }
        this.E.setText(qqStr);
        Drawable drawable = this.f209498i.getDrawable(R.drawable.qui_chevron_up);
        drawable.setBounds(0, 0, ViewUtils.dpToPx(14.0f), ViewUtils.dpToPx(14.0f));
        this.E.setCompoundDrawables(null, null, drawable, null);
        this.E.setVisibility(0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b0(String str) {
        ScannerResult decodeQQCodeFromFile = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(Uri.parse("file://" + new File(str).getAbsolutePath()), (Context) BaseApplication.getContext(), 3, false);
        if (decodeQQCodeFromFile == null || (!decodeQQCodeFromFile.l() && !decodeQQCodeFromFile.j())) {
            return false;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.widget.SendBottomBar.18
            @Override // java.lang.Runnable
            public void run() {
                SendBottomBar.this.G();
                ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).showInterceptQrCodeSendToast();
            }
        });
        return true;
    }

    private boolean e0() {
        int[] b36 = this.G.b3();
        if (b36 == null) {
            this.f209492e = null;
            return false;
        }
        int Y2 = this.G.Y2();
        this.f209492e = ActionSheet.create(this.G);
        int length = b36.length;
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (i3 < length) {
                int i16 = b36[i3];
                if (i16 != 0) {
                    if (i16 != 1) {
                        if (i16 == 2) {
                            ActionSheet actionSheet = this.f209492e;
                            String qqStr = HardCodeUtil.qqStr(R.string.zys);
                            if (Y2 != i16) {
                                z16 = false;
                            }
                            actionSheet.addRadioButton(qqStr, z16);
                        }
                    } else {
                        ActionSheet actionSheet2 = this.f209492e;
                        String qqStr2 = HardCodeUtil.qqStr(R.string.zyq);
                        if (Y2 != i16) {
                            z16 = false;
                        }
                        actionSheet2.addRadioButton(qqStr2, z16);
                    }
                } else {
                    ActionSheet actionSheet3 = this.f209492e;
                    String qqStr3 = HardCodeUtil.qqStr(R.string.zyr);
                    if (Y2 != i16) {
                        z16 = false;
                    }
                    actionSheet3.addRadioButton(qqStr3, z16);
                }
                i3++;
            } else {
                this.f209492e.addCancelButton(HardCodeUtil.qqStr(R.string.b5j));
                this.f209492e.setOnButtonClickListenerV2(new l());
                return true;
            }
        }
    }

    private void f0() {
        this.G = (BaseFileAssistantActivity) this.f209498i;
        this.D = (TextView) findViewById(R.id.fyf);
        this.E = (TextView) findViewById(R.id.fa_);
        this.F = (CheckBox) findViewById(R.id.aws);
        TextView textView = (TextView) findViewById(R.id.imy);
        this.f209499m = textView;
        textView.setOnClickListener(this.f209496g0);
        TextView textView2 = (TextView) findViewById(R.id.fyc);
        this.C = textView2;
        textView2.setOnClickListener(this.f209489c0);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.bny);
        this.L = frameLayout;
        frameLayout.setVisibility(8);
        TextView textView3 = (TextView) findViewById(R.id.bnz);
        this.M = textView3;
        textView3.setVisibility(8);
        View findViewById = findViewById(R.id.ima);
        this.P = findViewById;
        findViewById.setVisibility(8);
        if (1 == this.G.P2() || 10 == this.G.P2()) {
            this.f209499m.setText(HardCodeUtil.qqStr(R.string.f186853se));
        }
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) this.G.getAppRuntime();
        this.f209497h = baseQQAppInterface;
        if (baseQQAppInterface != null) {
            this.Q = baseQQAppInterface.getPreferences().getBoolean("_fm_select_showd", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g0() {
        BaseFileAssistantActivity baseFileAssistantActivity = this.G;
        if (baseFileAssistantActivity == null || !(baseFileAssistantActivity instanceof FMActivity) || ((FMActivity) baseFileAssistantActivity).lc() != 1201) {
            return false;
        }
        return true;
    }

    private boolean h0() {
        ArrayList<FavFileInfo> l3 = com.tencent.mobileqq.filemanager.data.f.l();
        if (l3 != null && l3.size() > 0) {
            Iterator<FavFileInfo> it = l3.iterator();
            while (it.hasNext()) {
                if (ah.o0(it.next().f207675h) == 0) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        Intent intent;
        if (this.G.T0 != -1) {
            intent = new Intent();
            intent.putExtra("qrlogin_appid", this.G.T0);
        } else {
            intent = null;
        }
        this.G.setResult(-1, intent);
        this.G.finish();
    }

    static /* synthetic */ long l(SendBottomBar sendBottomBar, long j3) {
        long j16 = sendBottomBar.S + j3;
        sendBottomBar.S = j16;
        return j16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(BaseQQAppInterface baseQQAppInterface, String str, String str2) {
        p0(baseQQAppInterface, str, str2, com.tencent.mobileqq.filemanager.data.f.n());
        r0(baseQQAppInterface, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        if (!((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).isNeedInterceptQrCode(this.G.Z2(), this.G.d3())) {
            o0();
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.widget.SendBottomBar.16
                @Override // java.lang.Runnable
                public void run() {
                    for (FileInfo fileInfo : com.tencent.mobileqq.filemanager.data.f.n()) {
                        if (fileInfo.getType() == 0 && SendBottomBar.this.b0(fileInfo.k())) {
                            return;
                        }
                    }
                    for (FileManagerEntity fileManagerEntity : com.tencent.mobileqq.filemanager.data.f.q()) {
                        if (fileManagerEntity.nFileType == 0) {
                            if (SendBottomBar.this.b0(fileManagerEntity.getFilePath())) {
                                return;
                            }
                        }
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.widget.SendBottomBar.16.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SendBottomBar.this.o0();
                        }
                    });
                }
            }, 64, null, true);
        }
    }

    private void p0(BaseQQAppInterface baseQQAppInterface, String str, String str2, Set<FileInfo> set) {
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).sendLocalFileToGuild(baseQQAppInterface, str, str2, set);
        QLog.i("sendLocalFileToGuild", 4, "sendLocalFileToGuild guildID=" + str + " channelId=" + str2 + " size=" + set.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        String d36 = this.G.d3();
        Set<FileInfo> n3 = com.tencent.mobileqq.filemanager.data.f.n();
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<FileInfo> it = n3.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().k());
        }
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).sendQlinkFiles(this.G, d36, arrayList, this.G.T2());
        this.G.finish();
    }

    private void r0(BaseQQAppInterface baseQQAppInterface, String str, String str2) {
        ArrayList<FileManagerEntity> q16 = com.tencent.mobileqq.filemanager.data.f.q();
        if (q16 != null && !q16.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (FileManagerEntity fileManagerEntity : q16) {
                if (fileManagerEntity != null && !TextUtils.isEmpty(fileManagerEntity.strFilePath) && FileUtils.fileExistsAndNotEmpty(fileManagerEntity.strFilePath)) {
                    hashSet.add(L(fileManagerEntity.strFilePath));
                }
            }
            if (!hashSet.isEmpty()) {
                p0(baseQQAppInterface, str, str2, hashSet);
            }
        }
    }

    public void F() {
        Dialog dialog = this.V;
        if (dialog != null && dialog.isShowing() && !this.G.isDestroyed()) {
            this.V.dismiss();
        }
    }

    void G() {
        try {
            QQProgressDialog qQProgressDialog = this.f209490d;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                this.f209490d.cancel();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void H() {
        boolean z16;
        d0();
        int S2 = this.G.S2();
        String W2 = this.G.W2();
        if (W2 == null) {
            if (S2 == 5) {
                W2 = this.f209498i.getResources().getString(R.string.f187253th) + this.f209498i.getString(R.string.b_3) + com.tencent.mobileqq.filemanager.data.f.s() + this.f209498i.getString(R.string.b_4);
            } else if (S2 == 6001) {
                W2 = this.f209498i.getResources().getString(R.string.f186753s5) + this.f209498i.getString(R.string.b_3) + com.tencent.mobileqq.filemanager.data.f.s() + this.f209498i.getString(R.string.b_4);
            } else if (S2 == 10006) {
                W2 = this.f209498i.getResources().getString(R.string.f171151ok);
            } else if (10 == this.G.P2()) {
                W2 = this.f209498i.getResources().getString(R.string.f171151ok);
                if (this.U < com.tencent.mobileqq.filemanager.data.f.s()) {
                    ReportController.o(null, "dc00898", "", "", "0X800B377", "0X800B377", 0, 0, "", "", "", "");
                }
                this.U = com.tencent.mobileqq.filemanager.data.f.s();
            } else {
                W2 = this.f209498i.getString(R.string.f187203tc) + this.f209498i.getString(R.string.b_3) + com.tencent.mobileqq.filemanager.data.f.s() + this.f209498i.getString(R.string.b_4);
            }
        } else if (!TextUtils.isEmpty(W2) && this.G.x3()) {
            long s16 = com.tencent.mobileqq.filemanager.data.f.s();
            if (s16 > 0) {
                W2 = W2 + this.f209498i.getString(R.string.b_3) + s16 + this.f209498i.getString(R.string.b_4);
            }
        }
        String M = M();
        if (I(M)) {
            return;
        }
        boolean z17 = true;
        if (this.N && !ah.a1(this.f209498i)) {
            String str = HardCodeUtil.qqStr(R.string.f187233tf) + com.tencent.mobileqq.filemanager.data.f.s() + ")";
            this.E.setVisibility(8);
            this.L.setVisibility(0);
            this.M.setVisibility(0);
            this.M.setText(M);
            this.F.setEnabled(true);
            TextView textView = this.f209499m;
            if (com.tencent.mobileqq.filemanager.data.f.s() <= 0) {
                z17 = false;
            }
            textView.setEnabled(z17);
            this.f209499m.setText(str);
            return;
        }
        this.L.setVisibility(8);
        this.M.setVisibility(8);
        this.F.setVisibility(8);
        if (this.G.P2() != 1) {
            int visibility = this.C.getVisibility();
            if (visibility != 4 && visibility != 8) {
                this.D.setVisibility(0);
                this.E.setVisibility(8);
                this.D.setText(M);
            } else {
                this.E.setVisibility(0);
                this.D.setVisibility(8);
                if (ah.a1(this.f209498i)) {
                    if (com.tencent.mobileqq.filemanager.data.f.s() == 0) {
                        this.E.setVisibility(8);
                    } else {
                        this.E.setVisibility(0);
                        this.E.setText(M);
                    }
                } else {
                    this.E.setText(M);
                }
            }
        } else {
            int visibility2 = this.C.getVisibility();
            if (visibility2 != 4 && visibility2 != 8) {
                this.D.setVisibility(0);
                this.E.setVisibility(8);
                this.D.setText(R.string.f187553ua);
            } else {
                this.E.setVisibility(0);
                this.D.setVisibility(8);
                this.E.setText(R.string.f187553ua);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
                layoutParams.addRule(9);
                this.E.setLayoutParams(layoutParams);
            }
        }
        if (N() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (g0()) {
            z16 = h0();
        }
        this.f209499m.setText(W2);
        if (1 == this.G.P2()) {
            this.f209499m.setText(HardCodeUtil.qqStr(R.string.f186853se));
        }
        TextView textView2 = this.f209499m;
        if (com.tencent.mobileqq.filemanager.data.f.s() <= 0) {
            z17 = false;
        }
        textView2.setEnabled(z17);
        this.C.setEnabled(z16);
    }

    public void K(boolean z16) {
        float f16;
        float f17;
        if (this.G.Y2() != -1) {
            return;
        }
        if (z16) {
            if (this.L.getVisibility() == 0) {
                return;
            } else {
                this.L.setVisibility(0);
            }
        } else if (this.L.getVisibility() != 0) {
            return;
        }
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        if (z16) {
            f17 = 0.0f;
        } else {
            f17 = 1.0f;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, f16, 1, f17);
        translateAnimation.setDuration(500L);
        translateAnimation.setFillAfter(true);
        this.L.startAnimation(translateAnimation);
        if (!z16) {
            this.L.setVisibility(8);
            new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.widget.SendBottomBar.21
                @Override // java.lang.Runnable
                public void run() {
                    SendBottomBar.this.K(true);
                }
            }, 1500L);
        }
    }

    public void O(int i3) {
        if (!AppNetConnInfo.isNetSupport()) {
            com.tencent.mobileqq.filemanager.util.d.e(R.string.f187123t5);
        } else if (ah.X0() && com.tencent.mobileqq.filemanager.data.f.u() > ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize()) {
            ah.R1(true, this.f209498i, new e(), i3);
        } else {
            m0();
        }
    }

    public void Q() {
        boolean z16;
        FileInfo fileInfo;
        Set<FileInfo> n3 = com.tencent.mobileqq.filemanager.data.f.n();
        ArrayList<FileManagerEntity> q16 = com.tencent.mobileqq.filemanager.data.f.q();
        TeamWorkFileImportInfo teamWorkFileImportInfo = new TeamWorkFileImportInfo();
        int i3 = 0;
        Activity activity = null;
        if (n3 != null && n3.size() > 0) {
            if (n3.iterator().hasNext()) {
                fileInfo = n3.iterator().next();
            } else {
                fileInfo = new FileInfo();
            }
            teamWorkFileImportInfo.f292077h = fileInfo.k();
            teamWorkFileImportInfo.f292074f = fileInfo.j();
            teamWorkFileImportInfo.R = ah.o0(fileInfo.j());
            teamWorkFileImportInfo.J = 10;
            teamWorkFileImportInfo.f292078h0 = fileInfo.l();
            Context context = this.f209498i;
            if (context != null && (context instanceof FMActivity)) {
                activity = (FMActivity) context;
                teamWorkFileImportInfo.S = ((FMActivity) context).P0;
            } else if (context != null && (context instanceof FMLocalFileActivity)) {
                activity = (FMLocalFileActivity) context;
                teamWorkFileImportInfo.S = ((FMLocalFileActivity) context).P0;
            } else if (context != null && (context instanceof LocalFileBrowserActivity)) {
                activity = (LocalFileBrowserActivity) context;
                teamWorkFileImportInfo.S = ((LocalFileBrowserActivity) context).P0;
            }
            z16 = true;
        } else {
            z16 = false;
        }
        if (q16 != null && q16.size() > 0 && !z16) {
            FileManagerEntity fileManagerEntity = q16.get(0);
            teamWorkFileImportInfo.f292077h = fileManagerEntity.getFilePath();
            teamWorkFileImportInfo.f292074f = fileManagerEntity.fileName;
            teamWorkFileImportInfo.R = fileManagerEntity.nFileType;
            teamWorkFileImportInfo.f292078h0 = fileManagerEntity.fileSize;
            teamWorkFileImportInfo.J = 10;
            teamWorkFileImportInfo.f292072e = fileManagerEntity.peerUin;
            teamWorkFileImportInfo.f292079i = fileManagerEntity.uniseq;
            teamWorkFileImportInfo.f292070d = fileManagerEntity.peerType;
            teamWorkFileImportInfo.f292084m = fileManagerEntity.nSessionId;
            teamWorkFileImportInfo.I = true;
            Context context2 = this.f209498i;
            if (context2 != null && (context2 instanceof FMActivity)) {
                activity = (FMActivity) context2;
                teamWorkFileImportInfo.S = ((FMActivity) context2).P0;
            } else if (context2 != null && (context2 instanceof FMLocalFileActivity)) {
                activity = (FMLocalFileActivity) context2;
                teamWorkFileImportInfo.S = ((FMLocalFileActivity) context2).P0;
            } else if (context2 != null && (context2 instanceof LocalFileBrowserActivity)) {
                activity = (LocalFileBrowserActivity) context2;
                teamWorkFileImportInfo.S = ((LocalFileBrowserActivity) context2).P0;
            }
        }
        Context context3 = this.f209498i;
        if (context3 instanceof BaseFileAssistantActivity) {
            i3 = ((BaseFileAssistantActivity) context3).Q2();
        }
        u.e(teamWorkFileImportInfo, this.f209498i, this.f209497h, i3);
        if (activity != null) {
            activity.finish();
        }
    }

    public boolean Z() {
        return this.J;
    }

    public void c0() {
        View view;
        if (this.G != null && (view = this.P) != null && view.getVisibility() == 0) {
            this.Q = true;
            this.P.setVisibility(8);
        }
    }

    @TargetApi(19)
    protected void d0() {
        boolean z16;
        QQBlurView qQBlurView = this.R;
        if (qQBlurView != null) {
            qQBlurView.onDestroy();
            this.R = null;
        }
        ListView listView = this.G.getListView();
        if (listView == null) {
            return;
        }
        QQBlurView qQBlurView2 = (QQBlurView) findViewById(R.id.kmg);
        this.R = qQBlurView2;
        qQBlurView2.setVisibility(0);
        this.R.j(listView);
        QQBlurView qQBlurView3 = this.R;
        qQBlurView3.m(qQBlurView3);
        this.R.p(-1);
        if (Build.VERSION.SDK_INT >= 24) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (TokenResUtils.useTokenRes4()) {
            int color = getResources().getColor(R.color.qui_common_bg_bottom_standard);
            this.R.z(new ColorDrawable(Color.argb(229, Color.red(color), Color.green(color), Color.blue(color))));
        }
        this.R.setEnableBlur(z16);
        this.R.k(0);
        this.R.A(8.0f);
        this.R.l(8);
        this.R.x();
        this.R.onResume();
    }

    public void j0() {
        QQBlurView qQBlurView = this.R;
        if (qQBlurView != null) {
            qQBlurView.onDestroy();
        }
    }

    public void m0() {
        ArrayList<FileManagerEntity> q16 = com.tencent.mobileqq.filemanager.data.f.q();
        Set<FileInfo> n3 = com.tencent.mobileqq.filemanager.data.f.n();
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).showDeviceChoose(this.f209498i, ((BaseFileAssistantActivity) this.f209498i).d3(), q16, n3, new f());
    }

    public void o0() {
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.widget.SendBottomBar.17

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.filemanager.widget.SendBottomBar$17$a */
            /* loaded from: classes12.dex */
            class a extends AsyncTask<Void, Void, Void> {
                a() {
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Void doInBackground(Void... voidArr) {
                    String d36 = SendBottomBar.this.G.d3();
                    String c36 = SendBottomBar.this.G.c3();
                    int S2 = SendBottomBar.this.G.S2();
                    String Z2 = SendBottomBar.this.G.Z2();
                    if (S2 == 5) {
                        return null;
                    }
                    if (S2 == 10014) {
                        SendBottomBar sendBottomBar = SendBottomBar.this;
                        sendBottomBar.l0(sendBottomBar.f209497h, Z2, d36);
                        return null;
                    }
                    if (S2 == 6002) {
                        ArrayList<FileInfo> arrayList = new ArrayList<>();
                        arrayList.addAll(com.tencent.mobileqq.filemanager.data.f.n());
                        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).sendFilesWithService(arrayList, null, null, Long.parseLong(d36));
                    } else {
                        boolean j3 = SendBottomBar.this.G.j3();
                        boolean z16 = true;
                        QLog.d("SendBottomBar", 1, "sendAllSelectedFiles strDiscUin: " + Z2 + " ,uin: " + d36 + " ,peerUid: " + c36 + " ,peerType: " + S2);
                        ((IQQFileEngine) SendBottomBar.this.f209497h.getRuntimeService(IQQFileEngine.class)).sendAllSelectedFiles(j3, Z2, d36, c36, S2);
                        Iterator<FileManagerEntity> it = com.tencent.mobileqq.filemanager.data.f.q().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (it.next().nFileType == 13) {
                                    break;
                                }
                            } else {
                                z16 = false;
                                break;
                            }
                        }
                        if (z16) {
                            if (SendBottomBar.this.T == 3) {
                                ReportController.o(SendBottomBar.this.G.D0, "dc00898", "", "", "0X800A088", "0X800A088", 0, 0, "", "", "", "");
                            } else if (SendBottomBar.this.T == 21) {
                                ReportController.o(SendBottomBar.this.G.D0, "dc00898", "", "", "0X800A08D", "0X800A08D", 0, 0, "", "", "", "");
                            }
                        }
                    }
                    return null;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public void onPostExecute(Void r16) {
                    super.onPostExecute(r16);
                    SendBottomBar.this.G();
                    com.tencent.mobileqq.filemanager.data.f.k();
                    SendBottomBar.this.i0();
                }
            }

            @Override // java.lang.Runnable
            @SuppressLint({"StaticFieldLeak"})
            public void run() {
                new a().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }, 100L);
    }

    public void s0() {
        if (this.V == null) {
            this.V = LoadingUtil.showLoadingDialog(getContext(), HardCodeUtil.qqStr(R.string.oxy), false);
        }
        if (!this.V.isShowing()) {
            this.V.show();
        }
    }

    public void setAttribution(int i3) {
        this.T = i3;
    }

    public void setCheckAllEnable(boolean z16) {
        CheckBox checkBox = this.F;
        if (checkBox != null) {
            checkBox.setEnabled(z16);
        }
    }

    public void setClickListener(t tVar) {
        this.H = tVar;
    }

    public void setDocsCheck(boolean z16) {
        boolean z17;
        if (z16 && (this.J || com.tencent.mobileqq.filemanager.data.f.K())) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.N = z17;
        if (QLog.isDebugVersion()) {
            QLog.i("TeamWorkSender", 1, "docsCheck[" + z16 + "],bCheckSendToDocs[" + this.J + "], selectAllDocs[" + com.tencent.mobileqq.filemanager.data.f.K() + "] ,hasSelectDocsFile[" + com.tencent.mobileqq.filemanager.data.f.x() + "]");
        }
        if (com.tencent.mobileqq.filemanager.data.f.s() == 0) {
            this.F.setChecked(false);
            this.J = false;
            this.N = false;
        } else if (com.tencent.mobileqq.filemanager.data.f.s() > 0 && !com.tencent.mobileqq.filemanager.data.f.x()) {
            this.F.setChecked(false);
            this.J = false;
            this.N = false;
        }
        if (this.N && !this.Q) {
            this.P.setVisibility(0);
            new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.widget.SendBottomBar.19
                @Override // java.lang.Runnable
                public void run() {
                    SendBottomBar.this.c0();
                }
            }, 3000L);
        }
        BaseQQAppInterface baseQQAppInterface = this.f209497h;
        if (baseQQAppInterface != null) {
            baseQQAppInterface.getPreferences().edit().putBoolean("_fm_select_showd", true).apply();
        }
        if (this.N) {
            this.F.setVisibility(0);
            this.F.setEnabled(true);
            this.F.setText(HardCodeUtil.qqStr(R.string.f187223te));
            this.F.setOnClickListener(new h());
            this.E.setVisibility(8);
            this.L.setVisibility(0);
            this.M.setVisibility(0);
            FileManagerReporter.addData("0X800942A");
            return;
        }
        this.F.setVisibility(8);
        this.L.setVisibility(8);
        this.M.setVisibility(8);
    }

    public void setEditBtnVisible(boolean z16) {
        int i3;
        TextView textView = this.C;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
        H();
    }

    public void setOnlyDocsChecked() {
        this.J = true;
        this.F.setChecked(true);
    }

    public void setRefreshTabCount(int i3) {
        this.W = i3;
        this.f209487a0 = 0;
    }

    public void setSelectAllOrCancelAll(boolean z16) {
        this.F.setChecked(!z16);
        if (z16) {
            this.F.setText(HardCodeUtil.qqStr(R.string.f187183ta));
        } else {
            this.F.setText(HardCodeUtil.qqStr(R.string.f186773s7));
        }
    }

    public void setSelectEvent(com.tencent.mobileqq.filemanager.activity.fileassistant.a aVar) {
        this.I = aVar;
    }

    public void setSelectedAllMode() {
        this.K = true;
        this.F.setVisibility(0);
        this.C.setVisibility(8);
        this.D.setVisibility(8);
        this.F.setOnClickListener(this.f209491d0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
        layoutParams.addRule(9, 0);
        layoutParams.addRule(0, 0);
        layoutParams.addRule(13);
        this.E.setGravity(1);
        this.E.setLayoutParams(layoutParams);
        this.E.setVisibility(0);
        this.f209499m.setVisibility(0);
        this.f209499m.setText(HardCodeUtil.qqStr(R.string.b_d));
        this.f209499m.setOnClickListener(this.f209493e0);
    }

    public void setSendBtnPadding(int i3) {
        if (QQTheme.isNowSimpleUI()) {
            int dip2px = ViewUtils.dip2px(i3);
            this.f209499m.setPadding(dip2px, 0, dip2px, 0);
        }
    }

    void t0() {
        if (this.f209490d != null) {
            G();
        } else {
            Context context = this.f209498i;
            QQProgressDialog qQProgressDialog = new QQProgressDialog(context, context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            this.f209490d = qQProgressDialog;
            qQProgressDialog.setCancelable(false);
            this.f209490d.setMessage(HardCodeUtil.qqStr(R.string.f187273tj));
            this.f209490d.show();
        }
        if (!this.f209490d.isShowing()) {
            this.f209490d.show();
        }
    }

    public void u0() {
        this.f209487a0++;
        QLog.d("NTScanSpaceManager", 1, "updateRefreshTabCount mCurRefreshTabCount is " + this.f209487a0 + "mTotalRefreshTabCount is " + this.W);
        if (this.f209487a0 == this.W) {
            QLog.d("NTScanSpaceManager", 1, "updateRefreshTabCount cancelLoadingDialog");
            F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements FMDialogUtil.c {
        b() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.addAll(com.tencent.mobileqq.filemanager.data.f.n());
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("sFilesSelected", arrayList);
            SendBottomBar.this.G.setResult(-1, intent);
            SendBottomBar.this.G.finish();
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements FMDialogUtil.c {
        d() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            SendBottomBar.this.q0();
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e implements FMDialogUtil.c {
        e() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            SendBottomBar.this.m0();
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }

    public void k0() {
    }

    public SendBottomBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f209492e = null;
        this.f209494f = null;
        this.f209497h = null;
        this.f209499m = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.I = null;
        this.J = false;
        this.K = false;
        this.L = null;
        this.M = null;
        this.N = false;
        this.Q = true;
        this.R = null;
        this.S = 0L;
        this.U = 0L;
        this.f209489c0 = new g();
        this.f209491d0 = new i();
        this.f209493e0 = new j();
        this.f209495f0 = false;
        this.f209496g0 = new View.OnClickListener() { // from class: com.tencent.mobileqq.filemanager.widget.SendBottomBar.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean z16;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (!SendBottomBar.this.f209495f0) {
                    SendBottomBar.this.f209495f0 = true;
                    new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.widget.SendBottomBar.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SendBottomBar.this.f209495f0 = false;
                        }
                    }, 800L);
                    SendBottomBar.this.S();
                    int P2 = SendBottomBar.this.G.P2();
                    if (P2 == 1) {
                        SendBottomBar.this.Y();
                    } else if (P2 != 5) {
                        switch (P2) {
                            case 7:
                                SendBottomBar.this.T();
                                break;
                            case 8:
                                SendBottomBar.this.U();
                                break;
                            case 9:
                                SendBottomBar.this.Q();
                                break;
                            case 10:
                                SendBottomBar.this.W();
                                break;
                            case 11:
                                SendBottomBar.this.P();
                                break;
                            default:
                                if (!AppNetConnInfo.isNetSupport()) {
                                    com.tencent.mobileqq.filemanager.util.d.e(R.string.f187123t5);
                                    break;
                                } else {
                                    int S2 = SendBottomBar.this.G.S2();
                                    if (S2 == 1) {
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                    if (S2 == 5) {
                                        SendBottomBar.this.m0();
                                        break;
                                    } else if (SendBottomBar.this.G.A0) {
                                        SendBottomBar.this.X(false);
                                        break;
                                    } else if (z16) {
                                        SendBottomBar.this.X(true);
                                        break;
                                    } else {
                                        SendBottomBar.this.R();
                                        break;
                                    }
                                }
                        }
                    } else {
                        SendBottomBar.this.V();
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.alz, (ViewGroup) this, true);
        this.f209498i = context;
        f0();
    }
}
