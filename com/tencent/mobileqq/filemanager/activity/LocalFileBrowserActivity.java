package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.filemanager.api.IFileSandboxPathUtilApi;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.h;
import com.tencent.mobileqq.filemanager.data.l;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.BubblePopupWindow;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class LocalFileBrowserActivity extends BaseFileAssistantActivity {

    /* renamed from: t1, reason: collision with root package name */
    public static String f206295t1 = "LocalFileBrowserActivity<FileAssistant>";
    TextView X0;
    TextView Y0;

    /* renamed from: e1, reason: collision with root package name */
    String f206300e1;

    /* renamed from: j1, reason: collision with root package name */
    String f206305j1;

    /* renamed from: k1, reason: collision with root package name */
    QBaseActivity f206306k1;

    /* renamed from: o1, reason: collision with root package name */
    boolean f206310o1;
    EditText Z0 = null;

    /* renamed from: a1, reason: collision with root package name */
    NoFileRelativeLayout f206296a1 = null;

    /* renamed from: b1, reason: collision with root package name */
    SlideDetectListView f206297b1 = null;

    /* renamed from: c1, reason: collision with root package name */
    LinearLayout f206298c1 = null;

    /* renamed from: d1, reason: collision with root package name */
    l f206299d1 = null;

    /* renamed from: f1, reason: collision with root package name */
    ArrayList<FileInfo> f206301f1 = new ArrayList<>();

    /* renamed from: g1, reason: collision with root package name */
    int f206302g1 = -1;

    /* renamed from: h1, reason: collision with root package name */
    int f206303h1 = 0;

    /* renamed from: i1, reason: collision with root package name */
    boolean f206304i1 = false;

    /* renamed from: l1, reason: collision with root package name */
    BubblePopupWindow f206307l1 = null;

    /* renamed from: m1, reason: collision with root package name */
    Map<String, Integer> f206308m1 = new HashMap();

    /* renamed from: n1, reason: collision with root package name */
    private AsyncTask f206309n1 = null;

    /* renamed from: p1, reason: collision with root package name */
    boolean f206311p1 = true;

    /* renamed from: q1, reason: collision with root package name */
    public View.OnLongClickListener f206312q1 = new b();

    /* renamed from: r1, reason: collision with root package name */
    public View.OnClickListener f206313r1 = new c();

    /* renamed from: s1, reason: collision with root package name */
    protected AdapterView.OnItemClickListener f206314s1 = new e();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements AbsListView.OnScrollListener {
        a() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            boolean z16 = true;
            if (i3 > 0 && i3 + i16 < i17 - 1) {
                z16 = false;
            }
            if (z16) {
                URLDrawable.resume();
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("SelectPhotoTrace", 2, LocalFileBrowserActivity.f206295t1 + ",onScrollStateChanged() is called,scrollState is:" + i3 + ",time is:" + System.currentTimeMillis());
            }
            if (i3 == 0) {
                URLDrawable.resume();
            } else {
                URLDrawable.pause();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements View.OnLongClickListener {

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f206318d;

            a(View view) {
                this.f206318d = view;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x006c  */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                l.a aVar = (l.a) this.f206318d.getTag();
                LocalFileBrowserActivity localFileBrowserActivity = LocalFileBrowserActivity.this;
                int i3 = aVar.G;
                localFileBrowserActivity.f206302g1 = i3;
                FileInfo fileInfo = localFileBrowserActivity.f206301f1.get(i3);
                boolean z16 = true;
                boolean z17 = !FileUtils.fileExistsAndNotEmpty(fileInfo.k());
                if (!z17) {
                    if (!fileInfo.k().startsWith(((IFileSandboxPathUtilApi) QRoute.api(IFileSandboxPathUtilApi.class)).getSandboxPath(Environment.getExternalStorageDirectory().getAbsolutePath()))) {
                        com.tencent.mobileqq.filemanager.util.d.e(R.string.zye);
                    } else {
                        if (!((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).deleteFile(fileInfo.k())) {
                            com.tencent.mobileqq.filemanager.util.d.e(R.string.b5v);
                        }
                        if (z16) {
                            ah.F(fileInfo.k());
                            LocalFileBrowserActivity localFileBrowserActivity2 = LocalFileBrowserActivity.this;
                            localFileBrowserActivity2.f206301f1.remove(localFileBrowserActivity2.f206302g1);
                            LocalFileBrowserActivity.this.i4();
                        }
                        EventCollector.getInstance().onViewClicked(view);
                    }
                }
                z16 = z17;
                if (z16) {
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity$b$b, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class C7525b implements BubblePopupWindow.OnDismissListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f206320d;

            C7525b(View view) {
                this.f206320d = view;
            }

            @Override // com.tencent.widget.BubblePopupWindow.OnDismissListener
            public void onDismiss() {
                this.f206320d.setSelected(false);
            }
        }

        b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            boolean z16 = false;
            if (view != null) {
                if (!LocalFileBrowserActivity.this.l3()) {
                    LocalFileBrowserActivity.this.f206299d1.a(null);
                    LocalFileBrowserActivity.this.f206297b1.j0();
                } else {
                    z16 = true;
                    view.setSelected(true);
                    com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
                    aVar.a(R.id.bf5, view.getContext().getString(R.string.b_d));
                    LocalFileBrowserActivity.this.f206307l1 = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).showAsDropDown(view, aVar, new a(view), new C7525b(view));
                }
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewClickedBefore(view);
            l.a aVar = (l.a) view.getTag();
            FileInfo fileInfo = aVar.F;
            if (view.getId() == R.id.c_5) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (fileInfo.m()) {
                LocalFileBrowserActivity.this.l4(fileInfo.k(), true);
            } else if (LocalFileBrowserActivity.this.r3() && !z16) {
                if (LocalFileBrowserActivity.this.j3() && !com.tencent.mobileqq.filemanager.data.f.w(com.tencent.mobileqq.filemanager.data.f.f207766l)) {
                    QQCustomDialog createNoTitleDialog = DialogUtil.createNoTitleDialog(LocalFileBrowserActivity.this, R.string.f0g);
                    createNoTitleDialog.setPositiveButton(R.string.f171151ok, new DialogUtil.DialogOnClickAdapter());
                    createNoTitleDialog.show();
                } else {
                    if (com.tencent.mobileqq.filemanager.data.f.C(fileInfo)) {
                        com.tencent.mobileqq.filemanager.data.f.G(fileInfo);
                    } else {
                        if (LocalFileBrowserActivity.this.M0) {
                            com.tencent.mobileqq.filemanager.data.f.k();
                        }
                        if (fileInfo.getType() == -1) {
                            fileInfo.B(ah.o0(fileInfo.k()));
                        }
                        com.tencent.mobileqq.filemanager.data.f.c(fileInfo);
                        LocalFileBrowserActivity localFileBrowserActivity = LocalFileBrowserActivity.this;
                        if (localFileBrowserActivity.M0) {
                            localFileBrowserActivity.i4();
                        }
                    }
                    LocalFileBrowserActivity.this.I2();
                    if (LocalFileBrowserActivity.this.r3()) {
                        aVar.f207819e.setVisibility(0);
                        aVar.f207819e.setChecked(com.tencent.mobileqq.filemanager.data.f.C(fileInfo));
                    } else {
                        aVar.f207819e.setVisibility(8);
                    }
                }
            } else if (!LocalFileBrowserActivity.this.w3()) {
                if (QLog.isColorLevel()) {
                    QLog.i(LocalFileBrowserActivity.f206295t1, 2, "click too fast , wait a minute.");
                }
            } else {
                if (LocalFileBrowserActivity.this.r3()) {
                    ReportController.o(LocalFileBrowserActivity.this.D0, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
                }
                LocalFileBrowserActivity.this.Q3();
                if (fileInfo.getType() == -1) {
                    fileInfo.B(ah.o0(fileInfo.k()));
                }
                ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).openFileBrowserByFileInfo(LocalFileBrowserActivity.this.getActivity(), fileInfo, fileInfo.getType(), fileInfo.k(), view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            LocalFileBrowserActivity.this.h4();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class e implements AdapterView.OnItemClickListener {
        e() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            FileInfo fileInfo = LocalFileBrowserActivity.this.f206301f1.get(i3);
            if (fileInfo.m()) {
                LocalFileBrowserActivity.this.l4(fileInfo.k(), true);
                return;
            }
            if (LocalFileBrowserActivity.this.r3()) {
                if (com.tencent.mobileqq.filemanager.data.f.C(fileInfo)) {
                    com.tencent.mobileqq.filemanager.data.f.G(fileInfo);
                } else {
                    if (LocalFileBrowserActivity.this.M0) {
                        com.tencent.mobileqq.filemanager.data.f.k();
                    }
                    com.tencent.mobileqq.filemanager.data.f.c(fileInfo);
                }
                LocalFileBrowserActivity.this.I2();
                LocalFileBrowserActivity.this.i4();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f extends AsyncTask<String, String, List<FileInfo>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f206325a;

        f(boolean z16) {
            this.f206325a = z16;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<FileInfo> doInBackground(String... strArr) {
            ArrayList<FileInfo> files;
            int i3 = 0;
            if (LocalFileBrowserActivity.this.f206303h1 == 6) {
                if (AppConstants.SDCARD_FILE_SAVE_PATH.equalsIgnoreCase(strArr[0])) {
                    files = ah.T(false, 0);
                } else {
                    files = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getFiles(strArr[0], false, 0);
                }
            } else {
                files = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getFiles(strArr[0], false, 1);
            }
            if (files == null) {
                QLog.e(LocalFileBrowserActivity.f206295t1, 1, "tmp is null! mCategory:" + LocalFileBrowserActivity.this.f206303h1);
                return null;
            }
            if (LocalFileBrowserActivity.this.f206304i1) {
                ArrayList<FileInfo> files2 = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getFiles(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/QQ/").getAbsolutePath(), false, 0);
                if (files2 != null) {
                    files.addAll(files2);
                }
            }
            String[] stringArrayExtra = LocalFileBrowserActivity.this.getIntent().getStringArrayExtra("STRING_Show_Within_Suffixs");
            if (stringArrayExtra != null) {
                while (i3 < files.size()) {
                    FileInfo fileInfo = files.get(i3);
                    if (!fileInfo.m() && (fileInfo.l() == 0 || !((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).checkEnds(fileInfo.j().toLowerCase(), stringArrayExtra))) {
                        files.remove(i3);
                        i3--;
                    }
                    i3++;
                }
            }
            return files;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(List<FileInfo> list) {
            LocalFileBrowserActivity.this.f206301f1.clear();
            if (list != null) {
                LocalFileBrowserActivity.this.f206301f1.addAll(list);
                list.clear();
            }
            if (this.f206325a) {
                if (LocalFileBrowserActivity.this.f206299d1.getCount() != 0) {
                    if (!LocalFileBrowserActivity.this.f206297b1.isStackFromBottom()) {
                        LocalFileBrowserActivity.this.f206297b1.setStackFromBottom(true);
                    }
                    LocalFileBrowserActivity.this.f206297b1.setStackFromBottom(false);
                }
                LocalFileBrowserActivity.this.i4();
            } else {
                LocalFileBrowserActivity localFileBrowserActivity = LocalFileBrowserActivity.this;
                if (localFileBrowserActivity.f206308m1.containsKey(localFileBrowserActivity.f206300e1)) {
                    LocalFileBrowserActivity localFileBrowserActivity2 = LocalFileBrowserActivity.this;
                    int intValue = localFileBrowserActivity2.f206308m1.get(localFileBrowserActivity2.f206300e1).intValue();
                    if (LocalFileBrowserActivity.this.f206299d1.getCount() > intValue) {
                        LocalFileBrowserActivity.this.k4(intValue);
                    }
                }
            }
            ah.T1(LocalFileBrowserActivity.this.centerView);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            LocalFileBrowserActivity.this.f206296a1.setVisible(true);
            LocalFileBrowserActivity localFileBrowserActivity = LocalFileBrowserActivity.this;
            ah.S1(localFileBrowserActivity.f206306k1, localFileBrowserActivity.centerView);
        }
    }

    private void e4() {
        String str = AppConstants.SDCARD_FILE_SAVE_PATH;
        String str2 = AppConstants.SDCARD_FILE_SAVE_TMP_PATH;
        File file = new File(str);
        if (!FileUtils.fileExists(str)) {
            file.mkdirs();
        }
        File file2 = new File(str2);
        if (!FileUtils.fileExists(str2)) {
            file2.mkdirs();
        }
    }

    private void f4(boolean z16, String str) {
        this.f206309n1 = new f(z16).execute(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (r0 != 23) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g4() {
        int i3 = this.f206303h1;
        if (i3 != 6) {
            if (i3 != 7) {
                if (i3 != 8) {
                    if (i3 == 11) {
                        File file = ah.U(this).get(FileManagerUtil.EXTERNAL_SD_CARD);
                        if (file == null) {
                            this.f206300e1 = "/";
                        } else {
                            this.f206300e1 = file.getPath();
                        }
                    }
                } else {
                    this.f206300e1 = AppConstants.SDCARD_ROOT;
                }
            } else {
                this.f206300e1 = "/";
            }
            this.f206305j1 = this.f206300e1;
        }
        this.f206300e1 = AppConstants.SDCARD_FILE_SAVE_PATH;
        this.f206305j1 = this.f206300e1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h4() {
        int i3 = this.f206303h1;
        if ((i3 == 8 || i3 == 11) && this.f206300e1.equals(this.f206305j1)) {
            return super.onBackEvent();
        }
        int i16 = this.f206303h1;
        if (i16 == 6) {
            return super.onBackEvent();
        }
        if (i16 == 23) {
            finish();
            return false;
        }
        String parent = new File(this.f206300e1).getParent();
        if (parent != null) {
            l4(parent, false);
            return false;
        }
        return super.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i4() {
        if (this.f206301f1.size() == 0) {
            this.f206296a1.setGone();
        } else {
            this.f206296a1.setVisible(true);
        }
        this.f206299d1.notifyDataSetChanged();
    }

    private void initListView() {
        this.f206297b1 = (SlideDetectListView) findViewById(R.id.ec9);
        this.f206296a1 = (NoFileRelativeLayout) findViewById(R.id.f_l);
        this.f206297b1.setOnItemClickListener(this.f206314s1);
        this.f206297b1.setEmptyView(this.f206296a1);
        this.f206296a1.setGone();
        int i3 = this.f206303h1;
        if (i3 != 7 && i3 != 8 && i3 != 11) {
            this.f206299d1.b(this.f206297b1);
        } else {
            I3(false);
        }
    }

    private void initTitleBar() {
        String string = getString(h.a(this.f206303h1));
        this.f206185s0 = string;
        setTitle(string);
        if (this.X0 == null) {
            this.X0 = (TextView) findViewById(R.id.ivTitleName);
        }
        TextView textView = this.leftView;
        this.Y0 = textView;
        if (textView != null) {
            textView.setOnClickListener(new d());
        }
        this.Y0 = this.leftView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k4(final int i3) {
        i4();
        this.f206297b1.setSelected(true);
        this.f206297b1.setSelection(i3);
        this.f206297b1.setSelected(true);
        this.f206297b1.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity.10
            @Override // java.lang.Runnable
            public void run() {
                LocalFileBrowserActivity.this.f206297b1.setSelected(true);
                LocalFileBrowserActivity.this.f206297b1.setSelection(i3);
                LocalFileBrowserActivity.this.f206297b1.setSelected(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l4(String str, boolean z16) {
        if (str == null || str.length() == 0) {
            return;
        }
        do {
            File file = new File(str);
            if (file.exists()) {
                break;
            } else {
                str = file.getParent();
            }
        } while (str != null);
        if (str == null) {
            return;
        }
        if (z16) {
            this.f206308m1.put(this.f206300e1, Integer.valueOf(this.f206297b1.getFirstVisiblePosition()));
        } else if (this.f206308m1.containsKey(this.f206300e1)) {
            this.f206308m1.remove(this.f206300e1);
        }
        this.f206300e1 = str;
        this.Z0.setText(str);
        int i3 = this.f206303h1;
        if (i3 == 7 || i3 == 8 || i3 == 11) {
            if (this.f206300e1.equalsIgnoreCase(this.f206305j1)) {
                this.Y0.setText(R.string.b7n);
            } else {
                this.Y0.setText(R.string.bao);
            }
        }
        AsyncTask asyncTask = this.f206309n1;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
        f4(z16, str);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        setContentView(R.layout.alo);
        Intent intent = getIntent();
        this.f206303h1 = intent.getBundleExtra("bundle").getInt("category");
        this.f206304i1 = intent.getBooleanExtra("open_with_qq_images", false);
        this.f206306k1 = this;
        g4();
        e4();
        initTitleBar();
        this.Z0 = (EditText) findViewById(R.id.bcl);
        this.f206298c1 = (LinearLayout) findViewById(R.id.ea6);
        this.f206299d1 = new l(this, this.f206301f1, this);
        initListView();
        this.f206297b1.setAdapter((ListAdapter) this.f206299d1);
        this.f206297b1.setOnItemClickListener(this.f206314s1);
        this.f206297b1.setOnScrollToTopListener(new a());
        l4(this.f206300e1, true);
        if (this.f206303h1 == 6) {
            this.f206298c1.setVisibility(8);
        }
        if (intent.getIntExtra("localSdCardfile", -1) != -1) {
            this.f206167a0.setEditBtnVisible(false);
            e3();
        }
        boolean booleanExtra = intent.getBooleanExtra("select_file_only_docs_file", false);
        this.f206310o1 = booleanExtra;
        this.f206167a0.setDocsCheck(booleanExtra);
        if (this.f206310o1) {
            this.f206167a0.setOnlyDocsChecked();
        }
        I2();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        AsyncTask asyncTask = this.f206309n1;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
        this.f206309n1 = null;
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return false;
    }

    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        h4();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
    public void refreshUI() {
        i4();
    }
}
