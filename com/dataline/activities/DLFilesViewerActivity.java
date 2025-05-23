package com.dataline.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.dataline.util.b;
import com.dataline.util.c;
import com.dataline.util.file.DLFileInfo;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.k;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.d;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes.dex */
public class DLFilesViewerActivity extends IphoneTitleBarActivity implements Observer {

    /* renamed from: a0, reason: collision with root package name */
    private XListView f32023a0;

    /* renamed from: b0, reason: collision with root package name */
    private DataLineMsgSet f32024b0 = null;

    /* renamed from: c0, reason: collision with root package name */
    private c f32025c0 = null;

    /* renamed from: d0, reason: collision with root package name */
    private k f32026d0 = new k() { // from class: com.dataline.activities.DLFilesViewerActivity.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void b(long j3, String str, int i3, boolean z16, boolean z17, long j16) {
            super.b(j3, str, i3, z16, z17, j16);
            DLFilesViewerActivity.this.f32025c0.notifyDataSetChanged();
            DLFilesViewerActivity.this.L2();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void c(long j3, String str, int i3, boolean z16, boolean z17, long j16) {
            super.c(j3, str, i3, z16, z17, j16);
            DLFilesViewerActivity.this.f32025c0.notifyDataSetChanged();
            DLFilesViewerActivity.this.L2();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void e(String str) {
            super.e(str);
            Iterator<DataLineMsgRecord> it = DLFilesViewerActivity.this.f32024b0.values().iterator();
            while (it.hasNext()) {
                DataLineMsgRecord next = it.next();
                if (str.equals(next.strMoloKey)) {
                    next.nAppStatus = 1;
                    DLFilesViewerActivity.this.f32025c0.notifyDataSetChanged();
                }
            }
            DLFilesViewerActivity.this.L2();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void h(final long j3, final float f16) {
            super.h(j3, f16);
            DLFilesViewerActivity.this.runOnUiThread(new Runnable() { // from class: com.dataline.activities.DLFilesViewerActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    DLFilesViewerActivity.this.f32025c0.k(j3, DLFilesViewerActivity.this.f32023a0, f16);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void j(boolean z16, long j3, String str) {
            super.j(z16, j3, str);
            DLFilesViewerActivity.this.f32025c0.notifyDataSetChanged();
            DLFilesViewerActivity.this.L2();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void l(boolean z16, long j3, String str) {
            super.j(z16, j3, str);
            DLFilesViewerActivity.this.f32025c0.notifyDataSetChanged();
            DLFilesViewerActivity.this.L2();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void L2() {
        Iterator<DataLineMsgRecord> it = this.f32024b0.values().iterator();
        byte b16 = false;
        byte b17 = true;
        while (it.hasNext()) {
            DataLineMsgRecord next = it.next();
            DLFileInfo g16 = c.g(next);
            int i3 = g16.f32372e;
            if ((i3 == 0 || i3 == 3) && b16 == false) {
                b16 = true;
            }
            if (i3 == 5 && next.strMoloKey != null) {
                DataLineHandler dataLineHandler = (DataLineHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
                if (next.bIsApkFile) {
                    next.nAppStatus = dataLineHandler.J3(next.strMoloKey) ? 1 : 0;
                } else {
                    next.nAppStatus = 1;
                }
            }
            if (g16.f32372e != 5 && b17 != false) {
                b17 = false;
            }
        }
        if (b17 == false) {
            this.rightViewText.setVisibility(0);
            if (b16 != false) {
                this.rightViewText.setText(getString(R.string.c37));
                return;
            } else {
                this.rightViewText.setText(getString(R.string.c36));
                return;
            }
        }
        this.rightViewText.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initTitleBar() {
        DataLineMsgRecord firstItem = this.f32024b0.getFirstItem();
        if (this.f32024b0.getGroupType() == -2335 && firstItem.bIsApkFile) {
            setTitle(R.string.c38);
        } else {
            setTitle(R.string.c3v);
        }
        this.leftView.setVisibility(0);
        this.leftView.setText(getString(R.string.c5f));
        L2();
        this.rightViewText.setOnClickListener(new a());
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
        int intExtra = getIntent().getIntExtra("dl_files_groupid", 0);
        DataLineMsgSet u16 = this.app.getProxyManager().g(0).u(intExtra);
        this.f32024b0 = u16;
        if (u16 == null) {
            this.f32024b0 = this.app.getProxyManager().g(1).u(intExtra);
        }
        if (this.f32024b0 == null) {
            finish();
            return false;
        }
        getWindow().setBackgroundDrawableResource(R.color.f156897em);
        setContentView(R.layout.f167875kc);
        getWindow().setBackgroundDrawable(null);
        initTitleBar();
        findViewById(R.id.ca8);
        XListView xListView = (XListView) findViewById(R.id.ca7);
        this.f32023a0 = xListView;
        xListView.setStackFromBottom(true);
        c cVar = new c(this, this.f32024b0, this, this.app);
        this.f32025c0 = cVar;
        this.f32023a0.setAdapter((ListAdapter) cVar);
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.f167787hh, (ViewGroup) null);
        this.f32023a0.setOverscrollHeader(getActivity().getResources().getDrawable(R.drawable.els));
        this.f32023a0.setOverScrollHeader(inflate);
        addObserver(this.f32026d0);
        QQMessageFacade messageFacade = this.app.getMessageFacade();
        if (messageFacade != null) {
            messageFacade.addObserver(this);
        }
        this.f32023a0.setSelection(this.f32024b0.getTotalCount() - 1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        k kVar = this.f32026d0;
        if (kVar != null) {
            removeObserver(kVar);
        }
        if (this.app.getMessageFacade() != null) {
            this.app.getMessageFacade().deleteObserver(this);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        L2();
        this.f32025c0.notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (obj instanceof DataLineMsgRecord) {
            this.f32025c0.notifyDataSetChanged();
            L2();
            return;
        }
        if (obj instanceof Message) {
            if (((Message) obj).frienduin.endsWith(String.valueOf(AppConstants.DATALINE_PC_UIN))) {
                this.f32025c0.notifyDataSetChanged();
                L2();
                return;
            }
            return;
        }
        if ((obj instanceof RecentUser) && ((RecentUser) obj).uin.endsWith(String.valueOf(AppConstants.DATALINE_PC_UIN))) {
            this.f32025c0.notifyDataSetChanged();
            L2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewClickedBefore(view);
            Iterator<DataLineMsgRecord> it = DLFilesViewerActivity.this.f32024b0.values().iterator();
            while (it.hasNext()) {
                int i3 = c.g(it.next()).f32372e;
                if (i3 == 0 || i3 == 3) {
                    z16 = true;
                    break;
                }
            }
            z16 = false;
            DataLineHandler dataLineHandler = (DataLineHandler) DLFilesViewerActivity.this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
            if (z16) {
                if (!DLFilesViewerActivity.this.f32024b0.isReportPause && DLFilesViewerActivity.this.f32024b0.getGroupType() == -2335) {
                    DLFilesViewerActivity.this.f32024b0.isReportPause = true;
                    b.i(DLFilesViewerActivity.this.app);
                }
                DLFilesViewerActivity.this.f32024b0.setPaused(true);
                if (!DLFilesViewerActivity.this.f32024b0.isSingle() && DLFilesViewerActivity.this.f32024b0.getGroupType() != -2335) {
                    dataLineHandler.j3(DLFilesViewerActivity.this.f32024b0.getGroupId(), 0L, false);
                } else {
                    Iterator<DataLineMsgRecord> it5 = DLFilesViewerActivity.this.f32024b0.values().iterator();
                    while (it5.hasNext()) {
                        DataLineMsgRecord next = it5.next();
                        int i16 = c.g(next).f32372e;
                        if (i16 == 0 || i16 == 3) {
                            dataLineHandler.j3(next.groupId, next.sessionid, false);
                        }
                    }
                }
                DLFilesViewerActivity.this.f32025c0.notifyDataSetChanged();
            } else if (NetworkUtil.isNetSupport(DLFilesViewerActivity.this)) {
                if (FileManagerUtil.is2GOr3G() && DLFilesViewerActivity.this.f32024b0.getFileTotalSize() > 3145728) {
                    DataLineMsgRecord firstItem = DLFilesViewerActivity.this.f32024b0.getFirstItem();
                    FileManagerUtil.showFlowDialog(firstItem.isSendFromLocal(), DLFilesViewerActivity.this, new C0218a(firstItem, dataLineHandler));
                } else {
                    DataLineMsgRecord firstItem2 = DLFilesViewerActivity.this.f32024b0.getFirstItem();
                    if (firstItem2 != null && !firstItem2.isSendFromLocal() && firstItem2.strMoloKey != null) {
                        dataLineHandler.x4(112);
                    }
                    DLFilesViewerActivity.this.f32024b0.setPaused(false);
                    Iterator<DataLineMsgRecord> it6 = DLFilesViewerActivity.this.f32024b0.values().iterator();
                    ArrayList<DataLineMsgRecord> arrayList = null;
                    ArrayList arrayList2 = null;
                    while (it6.hasNext()) {
                        DataLineMsgRecord next2 = it6.next();
                        int i17 = c.g(next2).f32372e;
                        if (i17 == 1) {
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                            }
                            arrayList.add(next2);
                        } else if (i17 == 4 || i17 == 2) {
                            if (next2.fileMsgStatus == 1 && next2.strMoloKey != null) {
                                b.e(DLFilesViewerActivity.this.app);
                            }
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList2.add(Long.valueOf(next2.sessionid));
                            next2.fileMsgStatus = 0L;
                            DLFilesViewerActivity.this.app.getMessageFacade().t1(DataLineMsgRecord.getDevTypeBySeId(next2.sessionid)).j(next2.msgId);
                        }
                    }
                    if (arrayList != null && arrayList.size() > 0) {
                        dataLineHandler.r4(arrayList, true);
                    }
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        dataLineHandler.c4(arrayList2);
                    }
                    DLFilesViewerActivity.this.f32025c0.notifyDataSetChanged();
                }
            } else {
                d.e(R.string.cjm);
            }
            DLFilesViewerActivity.this.initTitleBar();
            EventCollector.getInstance().onViewClicked(view);
        }

        /* compiled from: P */
        /* renamed from: com.dataline.activities.DLFilesViewerActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0218a implements FMDialogUtil.c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ DataLineMsgRecord f32032a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ DataLineHandler f32033b;

            C0218a(DataLineMsgRecord dataLineMsgRecord, DataLineHandler dataLineHandler) {
                this.f32032a = dataLineMsgRecord;
                this.f32033b = dataLineHandler;
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                DataLineMsgRecord dataLineMsgRecord = this.f32032a;
                if (dataLineMsgRecord != null && !dataLineMsgRecord.isSendFromLocal() && this.f32032a.strMoloKey != null) {
                    this.f32033b.x4(112);
                }
                DLFilesViewerActivity.this.f32024b0.setPaused(false);
                Iterator<DataLineMsgRecord> it = DLFilesViewerActivity.this.f32024b0.values().iterator();
                ArrayList<DataLineMsgRecord> arrayList = null;
                ArrayList arrayList2 = null;
                while (it.hasNext()) {
                    DataLineMsgRecord next = it.next();
                    int i3 = c.g(next).f32372e;
                    if (i3 == 1) {
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                        }
                        arrayList.add(next);
                    } else if (i3 == 4 || i3 == 2) {
                        if (next.fileMsgStatus == 1 && next.strMoloKey != null) {
                            b.e(DLFilesViewerActivity.this.app);
                        }
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(Long.valueOf(next.sessionid));
                        next.fileMsgStatus = 0L;
                        DLFilesViewerActivity.this.app.getMessageFacade().t1(DataLineMsgRecord.getDevTypeBySeId(next.sessionid)).j(next.msgId);
                    }
                }
                if (arrayList != null && arrayList.size() > 0) {
                    this.f32033b.r4(arrayList, true);
                }
                if (arrayList2 != null && arrayList2.size() > 0) {
                    this.f32033b.c4(arrayList2);
                }
                DLFilesViewerActivity.this.f32025c0.notifyDataSetChanged();
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
            }
        }
    }
}
