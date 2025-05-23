package com.dataline.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.util.file.DLFileInfo;
import com.dataline.util.widget.AsyncImageView;
import com.dataline.util.widget.WaitTextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private DataLineMsgSet f32352d;

    /* renamed from: e, reason: collision with root package name */
    private LayoutInflater f32353e;

    /* renamed from: f, reason: collision with root package name */
    private Context f32354f;

    /* renamed from: h, reason: collision with root package name */
    private DLFilesViewerActivity f32355h;

    /* renamed from: i, reason: collision with root package name */
    private QQAppInterface f32356i;

    /* renamed from: m, reason: collision with root package name */
    private final int f32357m = 2;
    private View.OnClickListener C = new a();
    public View.OnClickListener D = new b();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            C0222c c0222c = (C0222c) view.getTag();
            DLFileInfo dLFileInfo = c0222c.f32363d;
            if (dLFileInfo != null) {
                DataLineMsgRecord d16 = c.this.f32356i.getMessageFacade().t1(DataLineMsgRecord.getDevTypeBySeId(dLFileInfo.f32371d)).d(c0222c.f32363d.f32371d);
                if (d16 != null) {
                    FileManagerEntity newEntityByDataLineFileInfo = FileManagerUtil.newEntityByDataLineFileInfo(d16);
                    ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
                    forwardFileInfo.N(10009);
                    forwardFileInfo.w(6);
                    forwardFileInfo.E(newEntityByDataLineFileInfo.nSessionId);
                    forwardFileInfo.y(d16.filename);
                    forwardFileInfo.V(d16.sessionid);
                    forwardFileInfo.z(d16.filesize);
                    forwardFileInfo.C(d16.path);
                    Intent intent = new Intent(c.this.f32354f.getApplicationContext(), (Class<?>) FileBrowserActivity.class);
                    int i3 = newEntityByDataLineFileInfo.nFileType;
                    if (i3 == 0 || i3 == 1) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(String.valueOf(newEntityByDataLineFileInfo.nSessionId));
                        intent.putStringArrayListExtra("Aio_SessionId_ImageList", arrayList);
                    }
                    intent.putExtra("fileinfo", forwardFileInfo);
                    c.this.f32355h.startActivityForResult(intent, 102);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: com.dataline.util.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0222c implements Cloneable {
        public TextView C;
        public TextView D;
        public ProgressBar E;
        public RelativeLayout F;
        public Button G;

        /* renamed from: d, reason: collision with root package name */
        public DLFileInfo f32363d;

        /* renamed from: e, reason: collision with root package name */
        int f32364e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f32365f;

        /* renamed from: h, reason: collision with root package name */
        public WaitTextView f32366h;

        /* renamed from: i, reason: collision with root package name */
        public AsyncImageView f32367i;

        /* renamed from: m, reason: collision with root package name */
        public TextView f32368m;

        public C0222c() {
        }

        public Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("DatalineFilesAdapter", 2, "ItemHolder clone failed." + e16.toString());
                }
                return this;
            }
        }
    }

    public c(Context context, DataLineMsgSet dataLineMsgSet, DLFilesViewerActivity dLFilesViewerActivity, QQAppInterface qQAppInterface) {
        this.f32354f = context;
        this.f32352d = dataLineMsgSet;
        this.f32355h = dLFilesViewerActivity;
        this.f32356i = qQAppInterface;
        this.f32353e = LayoutInflater.from(context);
    }

    public static DLFileInfo g(DataLineMsgRecord dataLineMsgRecord) {
        DLFileInfo dLFileInfo = new DLFileInfo();
        dLFileInfo.f32374h = dataLineMsgRecord.filename;
        dLFileInfo.f32375i = dataLineMsgRecord.filesize;
        dLFileInfo.f32373f = dataLineMsgRecord.path;
        dLFileInfo.f32371d = dataLineMsgRecord.sessionid;
        long j3 = dataLineMsgRecord.fileMsgStatus;
        if (j3 == 0) {
            if (!dataLineMsgRecord.issuc) {
                if (dataLineMsgRecord.isSendFromLocal()) {
                    dLFileInfo.f32372e = 1;
                } else {
                    dLFileInfo.f32372e = 4;
                }
            } else if (dataLineMsgRecord.progress != 1.0f) {
                if (dataLineMsgRecord.isSendFromLocal()) {
                    dLFileInfo.f32372e = 0;
                } else {
                    dLFileInfo.f32372e = 3;
                }
            } else {
                dLFileInfo.f32372e = 5;
            }
        } else if (j3 == 2) {
            if (dataLineMsgRecord.isSendFromLocal()) {
                dLFileInfo.f32372e = 1;
            } else {
                dLFileInfo.f32372e = 4;
            }
        } else {
            dLFileInfo.f32372e = 2;
        }
        return dLFileInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(DataLineMsgRecord dataLineMsgRecord) {
        if (dataLineMsgRecord.strMoloKey != null) {
            DataLineHandler dataLineHandler = (DataLineHandler) this.f32356i.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
            if (dataLineMsgRecord.bIsApkFile && dataLineMsgRecord.nAppStatus != 1) {
                dataLineHandler.H3(dataLineMsgRecord.strMoloKey);
                return;
            }
            int T3 = dataLineHandler.T3(dataLineMsgRecord.strMoloKey);
            if (T3 == 2) {
                com.tencent.mobileqq.filemanager.util.d.e(R.string.bet);
                return;
            } else {
                if (T3 != 0) {
                    com.tencent.mobileqq.filemanager.util.d.e(R.string.c3d);
                    return;
                }
                return;
            }
        }
        FileManagerUtil.openWithOtherApp(this.f32355h, dataLineMsgRecord.path);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(C0222c c0222c, DataLineMsgRecord dataLineMsgRecord) {
        DataLineHandler dataLineHandler = (DataLineHandler) this.f32356i.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        if (dataLineMsgRecord.strMoloKey != null) {
            dataLineHandler.x4(111);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(dataLineMsgRecord.sessionid));
        if (dataLineHandler.c4(arrayList)) {
            c0222c.f32363d.f32372e = 3;
            dataLineMsgRecord.fileMsgStatus = 0L;
            this.f32356i.getMessageFacade().t1(DataLineMsgRecord.getDevTypeBySeId(dataLineMsgRecord.sessionid)).j(dataLineMsgRecord.msgId);
            dataLineMsgRecord.issuc = true;
            return;
        }
        com.tencent.mobileqq.filemanager.util.d.e(R.string.c4x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(C0222c c0222c, DataLineMsgRecord dataLineMsgRecord) {
        DataLineHandler dataLineHandler = (DataLineHandler) this.f32356i.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        if (c0222c.f32364e == 0) {
            dataLineHandler.n4(dataLineMsgRecord.path, dataLineMsgRecord.thumbPath, 1, dataLineMsgRecord.sessionid, dataLineMsgRecord.groupId, dataLineMsgRecord.groupSize, dataLineMsgRecord.groupIndex, true);
        } else {
            dataLineHandler.n4(dataLineMsgRecord.path, dataLineMsgRecord.thumbPath, 0, dataLineMsgRecord.sessionid, dataLineMsgRecord.groupId, dataLineMsgRecord.groupSize, dataLineMsgRecord.groupIndex, true);
        }
        c0222c.f32363d.f32372e = 0;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f32352d.getComeCount() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        boolean z16 = true;
        if (i3 != getCount() - 1) {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        return this.f32352d.values().get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        boolean z16;
        if (i3 == getCount() - 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 1;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    @TargetApi(8)
    public View getView(int i3, View view, ViewGroup viewGroup) {
        boolean z16;
        DataLineMsgRecord dataLineMsgRecord;
        C0222c c0222c;
        View view2;
        View inflate;
        if (i3 == getCount() - 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            dataLineMsgRecord = (DataLineMsgRecord) getItem(i3);
        } else {
            dataLineMsgRecord = null;
        }
        if (view == null) {
            c0222c = new C0222c();
            if (z16) {
                inflate = this.f32353e.inflate(R.layout.f167877ke, (ViewGroup) null);
                c0222c.f32365f = (ImageView) inflate.findViewById(R.id.f165106by4);
                c0222c.f32366h = (WaitTextView) inflate.findViewById(R.id.by6);
            } else {
                inflate = this.f32353e.inflate(R.layout.f167876kd, (ViewGroup) null);
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.c_w);
                c0222c.F = relativeLayout;
                relativeLayout.setOnClickListener(this.C);
                c0222c.F.setTag(c0222c);
                AsyncImageView asyncImageView = (AsyncImageView) inflate.findViewById(R.id.c_6);
                c0222c.f32367i = asyncImageView;
                asyncImageView.setDefaultImage(R.drawable.e8l);
                c0222c.f32367i.setIsDrawRound(false);
                c0222c.f32368m = (TextView) inflate.findViewById(R.id.ca5);
                c0222c.C = (TextView) inflate.findViewById(R.id.ca9);
                c0222c.D = (TextView) inflate.findViewById(R.id.ca_);
                c0222c.E = (ProgressBar) inflate.findViewById(R.id.c_h);
                Button button = (Button) inflate.findViewById(R.id.by);
                c0222c.G = button;
                button.setTag(c0222c);
                c0222c.G.setOnClickListener(this.D);
            }
            inflate.setTag(c0222c);
            view2 = inflate;
        } else {
            c0222c = (C0222c) view.getTag();
            view2 = view;
        }
        if (z16) {
            if (this.f32352d.getComeCount() == this.f32352d.getTotalCount()) {
                view2.setVisibility(4);
                c0222c.f32366h.f();
            } else if (!this.f32352d.isTimeOut()) {
                c0222c.f32365f.setVisibility(8);
                c0222c.f32366h.setVisibility(0);
                c0222c.f32366h.setWaitText(String.format(this.f32356i.getApp().getString(R.string.c4o), Integer.valueOf(this.f32352d.getTotalCount() - this.f32352d.getComeCount())));
                c0222c.f32366h.e();
            } else {
                c0222c.f32366h.f();
                c0222c.f32365f.setVisibility(0);
                c0222c.f32366h.setVisibility(0);
                int comeCount = this.f32352d.getComeCount();
                c0222c.f32366h.setWaitText(String.format(this.f32356i.getApp().getString(R.string.c4m), Integer.valueOf(comeCount), Integer.valueOf(this.f32352d.getTotalCount() - comeCount)));
            }
        } else if (dataLineMsgRecord == null) {
            c0222c.E.setVisibility(4);
            c0222c.G.setVisibility(4);
        } else {
            c0222c.E.setVisibility(0);
            c0222c.G.setVisibility(0);
            c0222c.f32363d = g(dataLineMsgRecord);
            c0222c.f32364e = dataLineMsgRecord.msgtype;
            if (dataLineMsgRecord.strMoloKey != null && dataLineMsgRecord.bIsApkFile) {
                c0222c.f32367i.setDefaultImage(R.drawable.e8l);
                c0222c.f32367i.setAsyncImage(dataLineMsgRecord.strMoloIconUrl);
            } else {
                FileManagerUtil.setFileIcon(c0222c.f32367i, dataLineMsgRecord);
            }
            c0222c.f32368m.setText(dataLineMsgRecord.filename);
            c0222c.C.setText(n0.a.h(dataLineMsgRecord.filesize));
            if (dataLineMsgRecord.progress != 1.0f && dataLineMsgRecord.issuc) {
                long j3 = dataLineMsgRecord.fileMsgStatus;
                if (j3 != 1 && j3 != 2) {
                    c0222c.E.setVisibility(0);
                    c0222c.D.setVisibility(0);
                    int i16 = (int) (dataLineMsgRecord.progress * 100.0f);
                    c0222c.E.setProgress(i16);
                    c0222c.D.setText(String.valueOf(i16) + "%");
                    c0222c.G.setText(R.string.c4p);
                }
            }
            c0222c.E.setVisibility(4);
            c0222c.D.setVisibility(4);
            if (dataLineMsgRecord.issuc) {
                long j16 = dataLineMsgRecord.fileMsgStatus;
                if (j16 != 1 && j16 != 2) {
                    if (dataLineMsgRecord.progress == 1.0f) {
                        if (dataLineMsgRecord.strMoloKey != null && dataLineMsgRecord.bIsApkFile && dataLineMsgRecord.nAppStatus != 1) {
                            c0222c.G.setText(R.string.f171082c44);
                        } else {
                            c0222c.G.setText(R.string.c4l);
                        }
                    }
                }
            }
            c0222c.G.setText(R.string.c4y);
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void k(long j3, ListView listView, float f16) {
        DataLineMsgRecord itemBySessionId;
        DataLineMsgRecord next;
        if (listView != null && j3 != 0) {
            Iterator<DataLineMsgRecord> it = this.f32352d.values().iterator();
            int i3 = 0;
            while (it.hasNext() && ((next = it.next()) == null || next.sessionid != j3)) {
                i3++;
            }
            View childAt = listView.getChildAt(i3 - listView.getFirstVisiblePosition());
            if (childAt == null || i3 >= this.f32352d.getTotalCount() || (itemBySessionId = this.f32352d.getItemBySessionId(j3)) == null) {
                return;
            }
            float f17 = itemBySessionId.progress;
            if (f16 < f17) {
                f16 = f17;
            }
            ProgressBar progressBar = (ProgressBar) childAt.findViewById(R.id.c_h);
            if (progressBar != null) {
                progressBar.setProgress((int) (f16 * 100.0f));
            }
            TextView textView = (TextView) childAt.findViewById(R.id.ca_);
            if (textView != null) {
                textView.setText(String.valueOf((int) (f16 * 100.0f)) + "%");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            C0222c c0222c = (C0222c) view.getTag();
            DataLineMsgRecord d16 = c.this.f32356i.getMessageFacade().t1(DataLineMsgRecord.getDevTypeBySeId(c0222c.f32363d.f32371d)).d(c0222c.f32363d.f32371d);
            if (d16 != null) {
                DLFileInfo dLFileInfo = c0222c.f32363d;
                int i3 = dLFileInfo.f32372e;
                boolean z16 = false;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 == 5) {
                                    c.this.h(d16);
                                }
                            }
                        }
                    }
                    if (NetworkUtil.isNetSupport(c.this.f32355h)) {
                        if (FileManagerUtil.is2GOr3G() && dLFileInfo.f32375i > 3145728) {
                            if (dLFileInfo.f32372e == 1) {
                                z16 = true;
                            }
                            FileManagerUtil.showFlowDialog(z16, c.this.f32355h, new a(d16, c0222c));
                        } else {
                            DataLineMsgSet v3 = c.this.f32356i.getDataLineMsgProxy(DataLineMsgRecord.getDevTypeBySeId(d16.sessionid)).v(d16.sessionid);
                            if (v3 != null) {
                                v3.setPaused(false);
                            }
                            if (dLFileInfo.f32372e == 1) {
                                c.this.j(c0222c, d16);
                            } else {
                                if (d16.fileMsgStatus == 1 && d16.strMoloKey != null) {
                                    com.dataline.util.b.e(c.this.f32356i);
                                }
                                c.this.i(c0222c, d16);
                            }
                        }
                    } else {
                        com.tencent.mobileqq.filemanager.util.d.e(R.string.cjm);
                    }
                }
                DataLineHandler dataLineHandler = (DataLineHandler) c.this.f32356i.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
                if (d16.strMoloKey != null && !d16.isReportPause) {
                    d16.isReportPause = true;
                    com.dataline.util.b.i(c.this.f32356i);
                }
                dataLineHandler.j3(d16.groupId, d16.sessionid, false);
                if (d16.isSendFromLocal()) {
                    dLFileInfo.f32372e = 1;
                } else {
                    dLFileInfo.f32372e = 4;
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements FMDialogUtil.c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ DataLineMsgRecord f32360a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ C0222c f32361b;

            a(DataLineMsgRecord dataLineMsgRecord, C0222c c0222c) {
                this.f32360a = dataLineMsgRecord;
                this.f32361b = c0222c;
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                DataLineMsgSet v3 = c.this.f32356i.getDataLineMsgProxy(DataLineMsgRecord.getDevTypeBySeId(this.f32360a.sessionid)).v(this.f32360a.sessionid);
                if (v3 != null) {
                    v3.setPaused(false);
                }
                C0222c c0222c = this.f32361b;
                if (c0222c.f32363d.f32372e == 1) {
                    c.this.j(c0222c, this.f32360a);
                    return;
                }
                DataLineMsgRecord dataLineMsgRecord = this.f32360a;
                if (dataLineMsgRecord.fileMsgStatus == 1 && dataLineMsgRecord.strMoloKey != null) {
                    com.dataline.util.b.e(c.this.f32356i);
                }
                c.this.i(this.f32361b, this.f32360a);
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
            }
        }
    }
}
