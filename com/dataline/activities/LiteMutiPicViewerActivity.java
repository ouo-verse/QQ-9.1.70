package com.dataline.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.util.widget.AsyncImageView;
import com.dataline.util.widget.WaitTextView;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.k;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.d;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class LiteMutiPicViewerActivity extends IphoneTitleBarActivity implements View.OnClickListener, WaitTextView.a {

    /* renamed from: a0, reason: collision with root package name */
    private DataLineMsgSet f32205a0;

    /* renamed from: b0, reason: collision with root package name */
    private GridView f32206b0;

    /* renamed from: c0, reason: collision with root package name */
    private b f32207c0;

    /* renamed from: d0, reason: collision with root package name */
    private WaitTextView f32208d0;

    /* renamed from: e0, reason: collision with root package name */
    private RelativeLayout f32209e0;

    /* renamed from: f0, reason: collision with root package name */
    private TextView f32210f0;

    /* renamed from: g0, reason: collision with root package name */
    private TextView f32211g0;

    /* renamed from: h0, reason: collision with root package name */
    private ProgressBar f32212h0;

    /* renamed from: i0, reason: collision with root package name */
    private Button f32213i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f32214j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f32215k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f32216l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f32217m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f32218n0;

    /* renamed from: o0, reason: collision with root package name */
    private k f32219o0 = new k() { // from class: com.dataline.activities.LiteMutiPicViewerActivity.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void b(long j3, String str, int i3, boolean z16, boolean z17, long j16) {
            super.b(j3, str, i3, z16, z17, j16);
            LiteMutiPicViewerActivity.this.runOnUiThread(new Runnable() { // from class: com.dataline.activities.LiteMutiPicViewerActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    LiteMutiPicViewerActivity.this.P2();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void c(long j3, String str, int i3, boolean z16, boolean z17, long j16) {
            super.c(j3, str, i3, z16, z17, j16);
            LiteMutiPicViewerActivity.this.runOnUiThread(new Runnable() { // from class: com.dataline.activities.LiteMutiPicViewerActivity.2.2
                @Override // java.lang.Runnable
                public void run() {
                    LiteMutiPicViewerActivity.this.P2();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void h(long j3, float f16) {
            super.h(j3, f16);
            LiteMutiPicViewerActivity.this.runOnUiThread(new Runnable() { // from class: com.dataline.activities.LiteMutiPicViewerActivity.2.5
                @Override // java.lang.Runnable
                public void run() {
                    LiteMutiPicViewerActivity.this.R2();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void j(boolean z16, long j3, String str) {
            super.j(z16, j3, str);
            LiteMutiPicViewerActivity.this.runOnUiThread(new Runnable() { // from class: com.dataline.activities.LiteMutiPicViewerActivity.2.4
                @Override // java.lang.Runnable
                public void run() {
                    LiteMutiPicViewerActivity.this.P2();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void l(boolean z16, long j3, String str) {
            super.l(z16, j3, str);
            LiteMutiPicViewerActivity.this.runOnUiThread(new Runnable() { // from class: com.dataline.activities.LiteMutiPicViewerActivity.2.3
                @Override // java.lang.Runnable
                public void run() {
                    LiteMutiPicViewerActivity.this.P2();
                }
            });
        }

        @Override // com.tencent.mobileqq.app.k
        protected void r(long j3) {
            LiteMutiPicViewerActivity.this.runOnUiThread(new Runnable() { // from class: com.dataline.activities.LiteMutiPicViewerActivity.2.6
                @Override // java.lang.Runnable
                public void run() {
                    LiteMutiPicViewerActivity.this.P2();
                }
            });
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BaseAdapter implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private LayoutInflater f32229d;

        b() {
            this.f32229d = LayoutInflater.from(LiteMutiPicViewerActivity.this);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int totalCount = LiteMutiPicViewerActivity.this.f32205a0.getTotalCount();
            int i3 = totalCount % 3;
            if (i3 != 0) {
                totalCount += 3 - i3;
            }
            return totalCount + 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            if (i3 > LiteMutiPicViewerActivity.this.f32205a0.getTotalCount() - 1) {
                return null;
            }
            return LiteMutiPicViewerActivity.this.f32205a0.getAt(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            if (i3 == getCount() - 1) {
                return 0;
            }
            if (i3 > LiteMutiPicViewerActivity.this.f32205a0.getTotalCount() - 1) {
                return 1;
            }
            return 2;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            c cVar;
            View view3;
            View view4;
            if (i3 == getCount() - 1) {
                if (LiteMutiPicViewerActivity.this.f32205a0.getComeCount() != LiteMutiPicViewerActivity.this.f32205a0.getTotalCount() && !LiteMutiPicViewerActivity.this.f32205a0.isSendFromLocal() && !LiteMutiPicViewerActivity.this.f32205a0.hasSendingOrRecving()) {
                    if (!LiteMutiPicViewerActivity.this.f32205a0.isTimeOut()) {
                        int comeCount = LiteMutiPicViewerActivity.this.f32205a0.getComeCount();
                        int totalCount = LiteMutiPicViewerActivity.this.f32205a0.getTotalCount();
                        LiteMutiPicViewerActivity.this.f32208d0.setWaitText(String.format(LiteMutiPicViewerActivity.this.app.getApp().getString(R.string.c4c), Integer.valueOf(totalCount), Integer.valueOf(totalCount - comeCount)));
                        LiteMutiPicViewerActivity.this.f32208d0.e();
                    } else {
                        LiteMutiPicViewerActivity.this.f32208d0.f();
                        int comeCount2 = LiteMutiPicViewerActivity.this.f32205a0.getComeCount();
                        int totalCount2 = LiteMutiPicViewerActivity.this.f32205a0.getTotalCount();
                        LiteMutiPicViewerActivity.this.f32208d0.setWaitText(String.format(LiteMutiPicViewerActivity.this.app.getApp().getString(R.string.c4a), Integer.valueOf(totalCount2), Integer.valueOf(totalCount2 - comeCount2)));
                    }
                } else {
                    LiteMutiPicViewerActivity.this.f32208d0.setWaitText(String.format(LiteMutiPicViewerActivity.this.getString(R.string.c4f), Integer.valueOf(LiteMutiPicViewerActivity.this.f32205a0.getTotalCount())));
                    LiteMutiPicViewerActivity.this.f32208d0.f();
                }
                view3 = LiteMutiPicViewerActivity.this.f32208d0;
                view4 = view;
            } else {
                if (i3 > LiteMutiPicViewerActivity.this.f32205a0.getTotalCount() - 1) {
                    if (view == null) {
                        view = new View(LiteMutiPicViewerActivity.this);
                        view.setLayoutParams(new AbsListView.LayoutParams(LiteMutiPicViewerActivity.this.f32214j0, LiteMutiPicViewerActivity.this.f32215k0));
                        view.setPadding(LiteMutiPicViewerActivity.this.f32218n0, LiteMutiPicViewerActivity.this.f32218n0, LiteMutiPicViewerActivity.this.f32218n0, LiteMutiPicViewerActivity.this.f32218n0);
                    }
                    view3 = view;
                } else {
                    if (view == null) {
                        cVar = new c();
                        view2 = this.f32229d.inflate(R.layout.al_, (ViewGroup) null);
                        cVar.f32231a = (RelativeLayout) view2.findViewById(R.id.cwy);
                        cVar.f32233c = view2.findViewById(R.id.dc7);
                        cVar.f32234d = (ImageView) view2.findViewById(R.id.f163820c);
                        AsyncImageView asyncImageView = (AsyncImageView) view2.findViewById(R.id.image);
                        cVar.f32232b = asyncImageView;
                        asyncImageView.setLayoutParams(new RelativeLayout.LayoutParams(LiteMutiPicViewerActivity.this.f32214j0, LiteMutiPicViewerActivity.this.f32215k0));
                        cVar.f32232b.setAdjustViewBounds(false);
                        cVar.f32232b.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        cVar.f32232b.setDefaultColorDrawable(Color.parseColor("#C8C8C8"));
                        cVar.f32232b.setIsDrawRound(false);
                        cVar.f32232b.setAsyncClipSize(LiteMutiPicViewerActivity.this.f32214j0, LiteMutiPicViewerActivity.this.f32215k0);
                        cVar.f32231a.setOnClickListener(this);
                        cVar.f32231a.setTag(cVar);
                        view2.setTag(cVar);
                    } else {
                        view2 = view;
                        cVar = (c) view.getTag();
                    }
                    DataLineMsgRecord at5 = LiteMutiPicViewerActivity.this.f32205a0.getAt(i3);
                    cVar.f32235e = at5;
                    if (at5 == null || at5.fileMsgStatus == 1) {
                        cVar.f32232b.setImageDrawable(new ColorDrawable(Color.parseColor("#C8C8C8")));
                        cVar.f32233c.setVisibility(8);
                        cVar.f32234d.setVisibility(8);
                    } else {
                        String str = at5.path;
                        if (str != null && new VFSFile(str).exists()) {
                            cVar.f32232b.setAsyncImage(at5.path);
                        } else {
                            String str2 = at5.thumbPath;
                            if (str2 != null) {
                                cVar.f32232b.setAsyncImage(str2);
                            }
                        }
                        if (!LiteMutiPicViewerActivity.this.f32205a0.hasSendingOrRecving() && (!at5.issuc || at5.fileMsgStatus != 0)) {
                            cVar.f32233c.setVisibility(0);
                            cVar.f32234d.setVisibility(0);
                        } else {
                            cVar.f32233c.setVisibility(8);
                            cVar.f32234d.setVisibility(8);
                        }
                    }
                    view3 = view2;
                }
                view4 = view3;
            }
            EventCollector.getInstance().onListGetView(i3, view4, viewGroup, getItemId(i3));
            return view3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0099, code lost:
        
            r5.add(java.lang.String.valueOf(r1.nSessionId));
         */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DataLineMsgRecord dataLineMsgRecord = ((c) view.getTag()).f32235e;
            if (dataLineMsgRecord != null) {
                FileManagerEntity newEntityByDataLineFileInfo = FileManagerUtil.newEntityByDataLineFileInfo(dataLineMsgRecord);
                ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
                forwardFileInfo.N(10009);
                forwardFileInfo.w(6);
                forwardFileInfo.E(newEntityByDataLineFileInfo.nSessionId);
                forwardFileInfo.y(dataLineMsgRecord.filename);
                forwardFileInfo.V(dataLineMsgRecord.sessionid);
                forwardFileInfo.z(dataLineMsgRecord.filesize);
                forwardFileInfo.C(dataLineMsgRecord.path);
                Intent intent = new Intent(LiteMutiPicViewerActivity.this, (Class<?>) FileBrowserActivity.class);
                if (newEntityByDataLineFileInfo.nFileType == 0) {
                    DataLineMsgSet v3 = LiteMutiPicViewerActivity.this.app.getDataLineMsgProxy(DataLineMsgRecord.getDevTypeBySeId(dataLineMsgRecord.sessionid)).v(dataLineMsgRecord.sessionid);
                    if (v3 != null) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        Iterator<DataLineMsgRecord> it = v3.values().iterator();
                        while (it.hasNext()) {
                            DataLineMsgRecord next = it.next();
                            int i3 = next.msgtype;
                            if (i3 == -2000 || ((i3 == -2005 && FileManagerUtil.getFileType(next.filename) == 0) || (next.msgtype == -2335 && next.bIsMoloImage))) {
                                arrayList.add(String.valueOf(FileManagerUtil.newEntityByDataLineFileInfo(next).nSessionId));
                            }
                        }
                        intent.putStringArrayListExtra("Aio_SessionId_ImageList", arrayList);
                    }
                }
                intent.putExtra("fileinfo", forwardFileInfo);
                LiteMutiPicViewerActivity.this.startActivity(intent);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public RelativeLayout f32231a;

        /* renamed from: b, reason: collision with root package name */
        public AsyncImageView f32232b;

        /* renamed from: c, reason: collision with root package name */
        public View f32233c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f32234d;

        /* renamed from: e, reason: collision with root package name */
        public DataLineMsgRecord f32235e;

        public c() {
        }
    }

    private int N2(Activity activity) {
        return activity.getWindowManager().getDefaultDisplay().getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2() {
        if (this.f32205a0.isCanReciveOrResend() && !this.f32205a0.hasSendingOrRecving()) {
            this.f32209e0.setVisibility(0);
            this.f32210f0.setVisibility(0);
            this.f32211g0.setVisibility(4);
            this.f32212h0.setVisibility(4);
            this.f32213i0.setVisibility(4);
            if (this.f32205a0.isSendFromLocal()) {
                this.f32210f0.setText(R.string.bf8);
            } else {
                this.f32210f0.setText(R.string.bf7);
            }
        } else if (this.f32205a0.hasSendingOrRecving()) {
            this.f32209e0.setVisibility(0);
            this.f32210f0.setVisibility(4);
            this.f32211g0.setVisibility(0);
            this.f32212h0.setVisibility(0);
            this.f32213i0.setVisibility(0);
            R2();
        } else {
            this.f32209e0.setVisibility(8);
        }
        this.f32207c0.notifyDataSetChanged();
    }

    private void Q2() {
        this.f32208d0.setText(String.format(getString(R.string.c4f), Integer.valueOf(this.f32205a0.getTotalCount())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R2() {
        int i3;
        this.f32212h0.setProgress((int) (this.f32205a0.getTotalProcess() * 100.0f));
        String str = "(" + this.f32205a0.getCompletedCount() + "/" + this.f32205a0.getTotalCount() + ")";
        StringBuilder sb5 = new StringBuilder();
        if (this.f32205a0.isSendFromLocal()) {
            i3 = R.string.bfl;
        } else {
            i3 = R.string.bej;
        }
        sb5.append(getString(i3));
        sb5.append(str);
        this.f32211g0.setText(sb5.toString());
    }

    private void initConfig() {
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        this.f32218n0 = getResources().getDimensionPixelSize(R.dimen.f159225xv);
        this.f32216l0 = getResources().getDimensionPixelSize(R.dimen.f159227xx);
        this.f32217m0 = getResources().getDimensionPixelSize(R.dimen.f159228xy);
        int width = ((defaultDisplay.getWidth() - (this.f32218n0 * 2)) - (this.f32216l0 * 2)) / 3;
        this.f32214j0 = width;
        this.f32215k0 = width;
    }

    private void initTitleBar() {
        setTitle(R.string.c3x);
        this.rightViewImg.setVisibility(4);
        this.rightViewText.setVisibility(4);
    }

    private void initUI() {
        this.f32206b0 = (GridView) findViewById(R.id.fri);
        this.f32209e0 = (RelativeLayout) findViewById(R.id.dcb);
        this.f32210f0 = (TextView) findViewById(R.id.dcc);
        TextView textView = (TextView) findViewById(R.id.dcd);
        this.f32211g0 = textView;
        textView.setTextColor(getResources().getColor(R.color.skin_black));
        this.f32212h0 = (ProgressBar) findViewById(R.id.dc7);
        this.f32213i0 = (Button) findViewById(R.id.f165750dc0);
        this.f32210f0.setOnClickListener(this);
        this.f32213i0.setOnClickListener(this);
        WaitTextView waitTextView = new WaitTextView(this);
        this.f32208d0 = waitTextView;
        waitTextView.setRefreshListener(this);
        this.f32208d0.setGravity(17);
        this.f32208d0.setTextColor(getResources().getColor(R.color.skin_gray3));
        this.f32208d0.setTextSize(1, 16.0f);
        this.f32208d0.setPadding(0, 0, 0, BaseAIOUtils.f(50.0f, getResources()));
        this.f32208d0.setLayoutParams(new AbsListView.LayoutParams(N2(this), -2));
        this.f32206b0.setNumColumns(3);
        this.f32206b0.setColumnWidth(this.f32214j0);
        this.f32206b0.setVerticalSpacing(this.f32217m0 * 2);
        this.f32206b0.setHorizontalSpacing(this.f32216l0 * 2);
        GridView gridView = this.f32206b0;
        gridView.setPadding(this.f32218n0, gridView.getPaddingTop(), this.f32218n0, this.f32206b0.getPaddingBottom());
        this.f32206b0.setSelector(new ColorDrawable(0));
        b bVar = new b();
        this.f32207c0 = bVar;
        this.f32206b0.setAdapter((ListAdapter) bVar);
        P2();
    }

    @Override // com.dataline.util.widget.WaitTextView.a
    public void E0() {
        b bVar;
        DataLineMsgSet dataLineMsgSet = this.f32205a0;
        if (dataLineMsgSet != null && dataLineMsgSet.isTimeOut() && (bVar = this.f32207c0) != null) {
            bVar.notifyDataSetChanged();
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
        setContentView(R.layout.ala);
        int intExtra = getIntent().getIntExtra("dataline_group_id", -1);
        DataLineMsgSet u16 = this.app.getDataLineMsgProxy(0).u(intExtra);
        this.f32205a0 = u16;
        if (u16 == null) {
            this.f32205a0 = this.app.getDataLineMsgProxy(1).u(intExtra);
        }
        if (this.f32205a0 == null) {
            this.f32205a0 = this.app.getDataLineMsgProxy(2).u(intExtra);
        }
        if (this.f32205a0 == null) {
            QLog.e("IphoneTitleBarActivity", 1, "LiteMutiPicViewerActivity mSet is null, so finish");
            finish();
            return true;
        }
        addObserver(this.f32219o0);
        initConfig();
        initUI();
        initTitleBar();
        Q2();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        k kVar = this.f32219o0;
        if (kVar != null) {
            removeObserver(kVar);
        }
        if (this.app.getFileManagerProxy() != null) {
            this.app.getFileManagerProxy().Z();
        }
        WaitTextView waitTextView = this.f32208d0;
        if (waitTextView != null) {
            waitTextView.f();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        DataLineHandler dataLineHandler = (DataLineHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        int id5 = view.getId();
        if (id5 == R.id.dcc) {
            if (NetworkUtil.isNetSupport(this)) {
                FileManagerUtil.showFlowDialog(this.f32205a0.isSendFromLocal(), this, new a(dataLineHandler));
                this.f32205a0.setPaused(false);
                if (this.f32205a0.getGroupType() == -2000 && !this.f32205a0.isSingle()) {
                    com.dataline.util.b.l(this.app);
                }
                Iterator<DataLineMsgRecord> it = this.f32205a0.values().iterator();
                ArrayList<DataLineMsgRecord> arrayList = null;
                ArrayList arrayList2 = null;
                while (it.hasNext()) {
                    DataLineMsgRecord next = it.next();
                    int i3 = com.dataline.util.c.g(next).f32372e;
                    if (i3 == 1) {
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                        }
                        arrayList.add(next);
                    } else if (i3 == 4 || i3 == 2) {
                        if (next.fileMsgStatus == 1 && next.strMoloKey != null) {
                            if (DataLineMsgSet.isSingle(next)) {
                                com.dataline.util.b.f(this.app);
                            } else {
                                com.dataline.util.b.e(this.app);
                            }
                        }
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(Long.valueOf(next.sessionid));
                        int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(next.sessionid);
                        next.fileMsgStatus = 0L;
                        this.app.getMessageFacade().t1(devTypeBySeId).j(next.msgId);
                    }
                }
                if (arrayList != null && arrayList.size() > 0) {
                    dataLineHandler.r4(arrayList, true);
                }
                if (arrayList2 != null && arrayList2.size() > 0) {
                    dataLineHandler.c4(arrayList2);
                }
                P2();
            } else {
                d.e(R.string.cjm);
            }
        } else if (id5 == R.id.f165750dc0) {
            this.f32205a0.setPaused(true);
            if (this.f32205a0.getGroupType() == -2000 && !this.f32205a0.isSingle()) {
                com.dataline.util.b.k(this.app);
            }
            if (this.f32205a0.getGroupType() == -2335) {
                DataLineMsgSet dataLineMsgSet = this.f32205a0;
                if (!dataLineMsgSet.isReportPause) {
                    dataLineMsgSet.isReportPause = true;
                    if (!dataLineMsgSet.isSingle()) {
                        com.dataline.util.b.i(this.app);
                    } else {
                        com.dataline.util.b.j(this.app);
                    }
                }
            }
            if (!this.f32205a0.isSingle() && this.f32205a0.getGroupType() != -2335) {
                dataLineHandler.j3(this.f32205a0.getGroupId(), 0L, false);
            } else {
                Iterator<DataLineMsgRecord> it5 = this.f32205a0.values().iterator();
                while (it5.hasNext()) {
                    DataLineMsgRecord next2 = it5.next();
                    int i16 = com.dataline.util.c.g(next2).f32372e;
                    if (i16 == 0 || i16 == 3) {
                        dataLineHandler.j3(next2.groupId, next2.sessionid, false);
                    }
                }
            }
            P2();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* loaded from: classes.dex */
    class a implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DataLineHandler f32227a;

        a(DataLineHandler dataLineHandler) {
            this.f32227a = dataLineHandler;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            LiteMutiPicViewerActivity.this.f32205a0.setPaused(false);
            if (LiteMutiPicViewerActivity.this.f32205a0.getGroupType() == -2000 && !LiteMutiPicViewerActivity.this.f32205a0.isSingle()) {
                com.dataline.util.b.l(LiteMutiPicViewerActivity.this.app);
            }
            Iterator<DataLineMsgRecord> it = LiteMutiPicViewerActivity.this.f32205a0.values().iterator();
            ArrayList<DataLineMsgRecord> arrayList = null;
            ArrayList arrayList2 = null;
            while (it.hasNext()) {
                DataLineMsgRecord next = it.next();
                int i3 = com.dataline.util.c.g(next).f32372e;
                if (i3 == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(next);
                } else if (i3 == 4 || i3 == 2) {
                    if (next.fileMsgStatus == 1 && next.strMoloKey != null) {
                        if (DataLineMsgSet.isSingle(next)) {
                            com.dataline.util.b.f(LiteMutiPicViewerActivity.this.app);
                        } else {
                            com.dataline.util.b.e(LiteMutiPicViewerActivity.this.app);
                        }
                    }
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(Long.valueOf(next.sessionid));
                    int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(next.sessionid);
                    next.fileMsgStatus = 0L;
                    LiteMutiPicViewerActivity.this.app.getMessageFacade().t1(devTypeBySeId).j(next.msgId);
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                this.f32227a.r4(arrayList, true);
            }
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.f32227a.c4(arrayList2);
            }
            LiteMutiPicViewerActivity.this.P2();
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }
}
