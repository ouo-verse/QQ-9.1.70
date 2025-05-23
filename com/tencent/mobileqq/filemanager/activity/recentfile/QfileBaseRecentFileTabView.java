package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.n;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanager.widget.HeaderScrollView;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.guild.api.IGuildFileApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.bp;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ListView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import ob1.h;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class QfileBaseRecentFileTabView extends QfileBaseTabView {

    /* renamed from: f0, reason: collision with root package name */
    static String f206699f0 = "<FileAssistant>";
    String E;
    private int F;
    LinkedHashMap<String, List<FileManagerEntity>> G;
    NoFileRelativeLayout H;
    View I;
    View J;
    TextView K;
    QfilePinnedHeaderExpandableListView L;
    long M;
    LayoutInflater N;
    List<FileManagerEntity> P;
    ob1.d Q;
    final String R;
    int S;
    volatile boolean T;
    boolean U;
    Comparator<FileManagerEntity> V;
    BubblePopupWindow W;

    /* renamed from: a0, reason: collision with root package name */
    public View.OnClickListener f206700a0;

    /* renamed from: b0, reason: collision with root package name */
    public View.OnLongClickListener f206701b0;

    /* renamed from: c0, reason: collision with root package name */
    public View.OnClickListener f206702c0;

    /* renamed from: d0, reason: collision with root package name */
    public View.OnClickListener f206703d0;

    /* renamed from: e0, reason: collision with root package name */
    private FMObserver f206704e0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView$10, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass10 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f206705d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f206706e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long[] f206707f;

        AnonymousClass10(int i3, int i16, long[] jArr) {
            this.f206705d = i3;
            this.f206706e = i16;
            this.f206707f = jArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            QfileBaseRecentFileTabView qfileBaseRecentFileTabView = QfileBaseRecentFileTabView.this;
            qfileBaseRecentFileTabView.f206603d.U3(qfileBaseRecentFileTabView);
            QfileBaseRecentFileTabView qfileBaseRecentFileTabView2 = QfileBaseRecentFileTabView.this;
            if (qfileBaseRecentFileTabView2.L != null && ((QfileBaseTabView) qfileBaseRecentFileTabView2).f206606h) {
                final int dimensionPixelSize = QfileBaseRecentFileTabView.this.f206603d.getResources().getDimensionPixelSize(R.dimen.j3);
                QLog.e(QfileBaseRecentFileTabView.f206699f0, 1, "setSelect[" + this.f206705d + "] success mFileListView offset\uff1a" + dimensionPixelSize);
                QfileBaseRecentFileTabView.this.L.expandGroup(this.f206705d);
                QfileBaseRecentFileTabView.this.L.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                        int flatListPosition = QfileBaseRecentFileTabView.this.L.getFlatListPosition(ExpandableListView.getPackedPositionForChild(anonymousClass10.f206705d, anonymousClass10.f206706e));
                        QLog.e(QfileBaseRecentFileTabView.f206699f0, 1, "flatPosition[" + flatListPosition + "] group\uff1a" + AnonymousClass10.this.f206705d + "\uff0citemIndex\uff1a" + AnonymousClass10.this.f206706e);
                        if (flatListPosition >= QfileBaseRecentFileTabView.this.L.getFirstVisiblePosition() && flatListPosition <= QfileBaseRecentFileTabView.this.L.getLastVisiblePosition()) {
                            View childAt = QfileBaseRecentFileTabView.this.L.getChildAt(flatListPosition - QfileBaseRecentFileTabView.this.L.getFirstVisiblePosition());
                            int top = childAt.getTop() - dimensionPixelSize;
                            QLog.e(QfileBaseRecentFileTabView.f206699f0, 1, "post distance:" + top + ", view top:" + childAt.getTop());
                            if (top == 0) {
                                AnonymousClass10 anonymousClass102 = AnonymousClass10.this;
                                QfileBaseRecentFileTabView.this.A0(anonymousClass102.f206707f);
                                return;
                            }
                        }
                        QfileBaseRecentFileTabView.this.L.smoothScrollToPositionFromTop(flatListPosition, dimensionPixelSize);
                        QfileBaseRecentFileTabView.this.L.addOnScrollListener(new a(flatListPosition));
                    }

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView$10$1$a */
                    /* loaded from: classes12.dex */
                    class a implements AbsListView.OnScrollListener {

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f206710d;

                        a(int i3) {
                            this.f206710d = i3;
                        }

                        @Override // com.tencent.widget.AbsListView.OnScrollListener
                        public void onScrollStateChanged(AbsListView absListView, int i3) {
                            QfileBaseRecentFileTabView qfileBaseRecentFileTabView;
                            HeaderScrollView x06;
                            if (i3 == 0) {
                                int firstVisiblePosition = QfileBaseRecentFileTabView.this.L.getFirstVisiblePosition();
                                int lastVisiblePosition = QfileBaseRecentFileTabView.this.L.getLastVisiblePosition();
                                QLog.d(QfileBaseRecentFileTabView.f206699f0, 1, "onScrollStateChanged flatPosition:" + this.f206710d + ", firstVisible:" + firstVisiblePosition + ", lastVisible:" + lastVisiblePosition);
                                int i16 = this.f206710d;
                                if (i16 >= firstVisiblePosition && i16 <= lastVisiblePosition) {
                                    View childAt = QfileBaseRecentFileTabView.this.L.getChildAt(i16 - firstVisiblePosition);
                                    QLog.d(QfileBaseRecentFileTabView.f206699f0, 1, "onScrollStateChanged top:" + childAt.getTop() + ", bottom:" + childAt.getBottom() + ", height:" + QfileBaseRecentFileTabView.this.L.getHeight());
                                    if (childAt.getTop() >= dimensionPixelSize && childAt.getBottom() <= QfileBaseRecentFileTabView.this.L.getHeight()) {
                                        Rect rect = new Rect();
                                        childAt.getGlobalVisibleRect(rect);
                                        if (rect.bottom > QfileBaseRecentFileTabView.this.getResources().getDisplayMetrics().heightPixels && (x06 = (qfileBaseRecentFileTabView = QfileBaseRecentFileTabView.this).x0(qfileBaseRecentFileTabView)) != null) {
                                            x06.scrollTo(0, Integer.MAX_VALUE);
                                        }
                                        AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                                        QfileBaseRecentFileTabView.this.A0(anonymousClass10.f206707f);
                                        QfileBaseRecentFileTabView.this.L.removeOnScrollListener(this);
                                        return;
                                    }
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    QfileBaseRecentFileTabView.this.L.smoothScrollToPositionFromTop(this.f206710d, dimensionPixelSize);
                                    return;
                                }
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                QfileBaseRecentFileTabView.this.L.smoothScrollToPositionFromTop(i16, dimensionPixelSize);
                            }
                        }

                        @Override // com.tencent.widget.AbsListView.OnScrollListener
                        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
                        }
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements Comparator<FileManagerEntity> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(FileManagerEntity fileManagerEntity, FileManagerEntity fileManagerEntity2) {
            long j3 = fileManagerEntity2.srvTime;
            long j16 = fileManagerEntity.srvTime;
            if (j3 > j16) {
                return 1;
            }
            if (j3 < j16) {
                return -1;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QfileBaseRecentFileTabView.this.J.setVisibility(8);
            TencentDocImportFileInfoProcessor.c().g("");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(QfileBaseRecentFileTabView.f206699f0, 2, "qfilebaserecenttabview del error, tag is null");
                }
            } else {
                FileManagerEntity fileManagerEntity = (FileManagerEntity) view.getTag();
                if (fileManagerEntity != null) {
                    ob1.d dVar = QfileBaseRecentFileTabView.this.Q;
                    if (dVar != null) {
                        dVar.e(null);
                    }
                    QfileBaseRecentFileTabView qfileBaseRecentFileTabView = QfileBaseRecentFileTabView.this;
                    qfileBaseRecentFileTabView.M = fileManagerEntity.nSessionId;
                    if (((IQQFileEngine) ((QfileBaseTabView) qfileBaseRecentFileTabView).f206604e.getRuntimeService(IQQFileEngine.class)).delete(QfileBaseRecentFileTabView.this.M)) {
                        QfileBaseRecentFileTabView.this.r0(fileManagerEntity);
                    }
                }
                ob1.d dVar2 = QfileBaseRecentFileTabView.this.Q;
                if (dVar2 != null) {
                    dVar2.e(-1);
                }
                view.setVisibility(4);
                QfileBaseRecentFileTabView.this.I0();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d implements View.OnClickListener {
        d() {
        }

        private boolean a(FileManagerEntity fileManagerEntity) {
            int i3 = fileManagerEntity.status;
            if (i3 == 1 || i3 == 0 || i3 == 2 || i3 == 3) {
                return true;
            }
            if (!TextUtils.isEmpty(fileManagerEntity.getFilePath()) && new File(fileManagerEntity.getFilePath()).exists()) {
                return true;
            }
            return false;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AsyncImageView asyncImageView;
            FileManagerEntity fileManagerEntity;
            boolean z16;
            Object obj;
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            Object tag = view.getTag();
            if (tag instanceof h) {
                h hVar = (h) view.getTag();
                asyncImageView = hVar.f422361m;
                fileManagerEntity = (FileManagerEntity) hVar.E;
            } else if (tag instanceof ob1.c) {
                ob1.c cVar = (ob1.c) view.getTag();
                asyncImageView = cVar.f422326a;
                fileManagerEntity = (FileManagerEntity) cVar.f422335j;
            } else {
                asyncImageView = null;
                fileManagerEntity = null;
            }
            if (view.getId() == R.id.c_5 && QfileBaseRecentFileTabView.this.v()) {
                ReportController.o(((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
            }
            if (fileManagerEntity != null) {
                QfileBaseRecentFileTabView qfileBaseRecentFileTabView = QfileBaseRecentFileTabView.this;
                if (view.getId() == R.id.c_5) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                qfileBaseRecentFileTabView.M0(fileManagerEntity, asyncImageView, z16);
                HashMap hashMap = new HashMap();
                hashMap.put("dt_pgid", "pg_bas_my_file");
                hashMap.put("dt_eid", "em_bas_file_entry");
                hashMap.put("file_size", Long.valueOf(fileManagerEntity.fileSize));
                hashMap.put("filetype", q.j(fileManagerEntity.fileName));
                String str2 = "0";
                if (!a(fileManagerEntity)) {
                    obj = "0";
                } else {
                    obj = "1";
                }
                hashMap.put("is_downloaded", obj);
                if (!ah.g1(fileManagerEntity)) {
                    str = "1";
                } else {
                    str = "2";
                }
                hashMap.put("source_appid", str);
                if (QfileBaseRecentFileTabView.this.f206603d.getString(R.string.mip).equals(ah.j1(fileManagerEntity.srvTime, fileManagerEntity.peerType))) {
                    str2 = "1";
                }
                hashMap.put("is_expired", str2);
                VideoReport.reportEvent("clck", hashMap);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class f implements View.OnLongClickListener {

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f206731d;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView$f$a$a, reason: collision with other inner class name */
            /* loaded from: classes12.dex */
            class C7542a implements ActionSheet.OnButtonClickListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FileManagerEntity f206733d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ ActionSheet f206734e;

                C7542a(FileManagerEntity fileManagerEntity, ActionSheet actionSheet) {
                    this.f206733d = fileManagerEntity;
                    this.f206734e = actionSheet;
                }

                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public void onClick(View view, int i3) {
                    ((IQQFileEngine) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileEngine.class)).delete(this.f206733d.nSessionId);
                    QfileBaseRecentFileTabView.this.r0(this.f206733d);
                    if (!TextUtils.isEmpty(this.f206733d.Uuid) && 3000 != this.f206733d.peerType) {
                        IQQFileEngine iQQFileEngine = (IQQFileEngine) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileEngine.class);
                        String valueOf = String.valueOf(this.f206733d.peerUin);
                        FileManagerEntity fileManagerEntity = this.f206733d;
                        iQQFileEngine.deleteOfflineFile(valueOf, fileManagerEntity.fileName, fileManagerEntity.Uuid, fileManagerEntity.fileIdCrc, fileManagerEntity.bSend);
                    }
                    this.f206733d.bDelInFM = true;
                    ((IQQFileDataCenter) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileDataCenter.class, "")).updateFileEntity(this.f206733d);
                    QfileBaseRecentFileTabView.this.I0();
                    if (this.f206734e.isShowing()) {
                        this.f206734e.dismiss();
                    }
                }
            }

            a(View view) {
                this.f206731d = view;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FileManagerEntity fileManagerEntity;
                EventCollector.getInstance().onViewClickedBefore(view);
                Object tag = this.f206731d.getTag();
                if (tag instanceof ob1.c) {
                    fileManagerEntity = (FileManagerEntity) ((ob1.c) tag).f422335j;
                } else {
                    fileManagerEntity = (FileManagerEntity) ((h) tag).E;
                }
                if (view.getId() == R.id.bf5) {
                    ActionSheet create = ActionSheet.create(QfileBaseRecentFileTabView.this.f206603d);
                    create.setMainTitle(HardCodeUtil.qqStr(R.string.f186913sk));
                    create.addButton(HardCodeUtil.qqStr(R.string.f186873sg), 3);
                    create.addCancelButton(HardCodeUtil.qqStr(R.string.b5j));
                    create.setOnButtonClickListener(new C7542a(fileManagerEntity, create));
                    create.show();
                } else if (view.getId() == R.id.cju) {
                    boolean z16 = fileManagerEntity.fromFile;
                    fileManagerEntity.fromFile = true;
                    QfileBaseRecentFileTabView.this.w0(fileManagerEntity);
                    fileManagerEntity.fromFile = z16;
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class b implements BubblePopupWindow.OnDismissListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f206736d;

            b(View view) {
                this.f206736d = view;
            }

            @Override // com.tencent.widget.BubblePopupWindow.OnDismissListener
            public void onDismiss() {
                this.f206736d.setSelected(false);
            }
        }

        f() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            if (view != null && !QfileBaseRecentFileTabView.this.v()) {
                z16 = true;
                view.setSelected(true);
                com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
                aVar.a(R.id.cju, view.getContext().getString(R.string.b_f));
                aVar.a(R.id.bf5, view.getContext().getString(R.string.b_d));
                QfileBaseRecentFileTabView.this.W = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).showAsDropDown(view, aVar, new a(view), new b(view));
            } else {
                z16 = false;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    public QfileBaseRecentFileTabView(Context context) {
        super(context);
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.M = -1L;
        this.N = null;
        this.P = null;
        this.Q = null;
        this.R = "LastRequestTime";
        this.S = 0;
        this.T = false;
        this.U = false;
        this.V = new a();
        this.W = null;
        this.f206700a0 = new c();
        this.f206701b0 = new f();
        this.f206702c0 = new d();
        this.f206703d0 = new e();
        this.f206704e0 = new FMObserver() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void B0(n nVar) {
                if (nVar == null) {
                    return;
                }
                Object obj = nVar.f207832c;
                if (obj instanceof FileManagerEntity) {
                    FileManagerEntity fileManagerEntity = (FileManagerEntity) obj;
                    String str = nVar.f207833d;
                    if (str != null && str.length() > 0) {
                        fileManagerEntity.strThumbPath = nVar.f207833d;
                        ((IQQFileDataCenter) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileDataCenter.class, "")).updateFileEntity(fileManagerEntity);
                        QfileBaseRecentFileTabView.this.C();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void P(long j3, long j16, String str, int i3) {
                FileManagerEntity queryFileEntity = ((IQQFileDataCenter) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileDataCenter.class)).queryFileEntity(j3, str, i3, j16);
                if (queryFileEntity == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e(QfileBaseRecentFileTabView.f206699f0, 2, "OnFileCome,but query FileEntity null,uniseq[" + j3 + "], nSessionId[" + j16 + "], strUin[" + str + "], peerType[" + i3 + "]");
                        return;
                    }
                    return;
                }
                QfileBaseRecentFileTabView.this.K0(queryFileEntity);
                ((IQQFileDataCenter) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileDataCenter.class, "")).updateFileEntity(queryFileEntity);
                QfileBaseRecentFileTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.7.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QfileBaseRecentFileTabView.this.I0();
                    }
                });
            }

            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            protected void S(boolean z16, long j3, long j16, String str, int i3, int i16, String str2) {
                FileManagerEntity queryFileEntity = ((IQQFileDataCenter) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileDataCenter.class)).queryFileEntity(j3, str, i3, j16);
                if (queryFileEntity == null) {
                    QLog.e(QfileBaseRecentFileTabView.f206699f0, 1, "OnFileCome,but query FileEntity null,uniseq[" + j3 + "], nSessionId[" + j16 + "], strUin[" + str + "], peerType[" + i3 + "]");
                    return;
                }
                if (!z16) {
                    queryFileEntity.bDelInFM = false;
                    ah.C(j16, i16, str2);
                    ((IOpenWeiyunVipHelper) QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(QfileBaseRecentFileTabView.this.f206603d, i16);
                } else {
                    int i17 = queryFileEntity.nOpType;
                    if (i17 == 4 || i17 == 20 || i17 == 6) {
                        ah.D(j16);
                    }
                }
                String str3 = QfileBaseRecentFileTabView.this.E;
                if (str3 == null || str3.trim().length() == 0 || queryFileEntity.getCloudType() != 2) {
                    QfileBaseRecentFileTabView.this.K0(queryFileEntity);
                }
                ((IQQFileDataCenter) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileDataCenter.class, "")).updateFileEntity(queryFileEntity);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void T(boolean z16, long j3, long j16, String str, int i3) {
                QfileBaseRecentFileTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QfileBaseRecentFileTabView.this.I0();
                    }
                });
            }

            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            protected void T0(Integer num, long j3, String str) {
                QfileBaseRecentFileTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.7.3
                    @Override // java.lang.Runnable
                    public void run() {
                        QfileBaseRecentFileTabView.this.I0();
                    }
                });
                ah.C(j3, num.intValue(), str);
                ((IOpenWeiyunVipHelper) QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(QfileBaseRecentFileTabView.this.f206603d, num.intValue());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void j0(int i3, long j3, String str) {
                super.j0(i3, j3, str);
                ah.C(j3, i3, str);
                ((IOpenWeiyunVipHelper) QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(QfileBaseRecentFileTabView.this.f206603d, i3);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void k0(long j3, String str, int i3, String str2) {
                super.k0(j3, str, i3, str2);
                QfileBaseRecentFileTabView.this.G0();
                ah.D(j3);
                QfileBaseRecentFileTabView.this.C();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void s0() {
                super.s0();
                QfileBaseRecentFileTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.7.4
                    @Override // java.lang.Runnable
                    public void run() {
                        QfileBaseRecentFileTabView.this.I0();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void x0(FileManagerEntity fileManagerEntity, boolean z16) {
                super.x0(fileManagerEntity, z16);
                if (!z16) {
                    QfileBaseRecentFileTabView.this.t0(fileManagerEntity);
                }
                QfileBaseRecentFileTabView.this.K0(fileManagerEntity);
                QfileBaseRecentFileTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.7.5
                    @Override // java.lang.Runnable
                    public void run() {
                        QfileBaseRecentFileTabView.this.I0();
                    }
                });
            }

            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            protected void P0(Boolean bool, List<OfflineFileInfo> list) {
            }
        };
        this.G = new LinkedHashMap<>();
        this.P = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(long[] jArr) {
        int childCount = this.L.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.L.getChildAt(i3);
            Object tag = childAt.getTag();
            if (tag instanceof h) {
                Object obj = ((h) tag).E;
                if ((obj instanceof FileManagerEntity) && q0(jArr, ((FileManagerEntity) obj).nSessionId)) {
                    B0(childAt);
                }
            }
        }
    }

    private void B0(View view) {
        int i3;
        if (view == null) {
            return;
        }
        int color = ResourcesCompat.getColor(view.getResources(), R.color.qui_common_fill_light_secondary, view.getContext().getTheme());
        int color2 = ResourcesCompat.getColor(view.getResources(), R.color.qui_common_brand_standard, view.getContext().getTheme());
        if (QQTheme.isNowThemeIsNight()) {
            i3 = 51;
        } else {
            i3 = 25;
        }
        int m3 = xy2.b.m(color2, i3);
        ObjectAnimator duration = ObjectAnimator.ofInt(view, "backgroundColor", color, m3).setDuration(16L);
        duration.setEvaluator(new ArgbEvaluator());
        ObjectAnimator duration2 = ObjectAnimator.ofInt(view, "backgroundColor", m3, m3).setDuration(1000L);
        duration2.setEvaluator(new ArgbEvaluator());
        ObjectAnimator duration3 = ObjectAnimator.ofInt(view, "backgroundColor", m3, color).setDuration(100L);
        duration3.setEvaluator(new ArgbEvaluator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(duration, duration2, duration3);
        animatorSet.start();
    }

    private boolean C0() {
        LinkedHashMap<String, List<FileManagerEntity>> linkedHashMap;
        boolean z16;
        if (ah.a1(getContext()) && (linkedHashMap = this.G) != null && linkedHashMap.size() > 0) {
            Iterator<String> it = this.G.keySet().iterator();
            while (it.hasNext()) {
                for (FileManagerEntity fileManagerEntity : this.G.get(it.next())) {
                    if (fileManagerEntity.fileSize > com.tencent.mobileqq.filemanager.data.f.o()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    boolean M = ah.M(fileManagerEntity.fileName, bp.b().f292115a);
                    if (z16 || !M) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void E0() {
        try {
            this.H = new NoFileRelativeLayout(o());
            View inflate = this.f206603d.getLayoutInflater().inflate(R.layout.c0e, (ViewGroup) null, false);
            this.I = inflate;
            this.J = inflate.findViewById(R.id.jna);
            this.K = (TextView) this.I.findViewById(R.id.jgg);
            ((ImageView) this.I.findViewById(R.id.e7j)).setColorFilter(-15550475, PorterDuff.Mode.MULTIPLY);
            ((ImageView) this.I.findViewById(R.id.close)).setOnClickListener(new b());
            this.L.addHeaderView(this.I);
            this.J.setVisibility(8);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void F0() {
        QfilePinnedHeaderExpandableListView qfilePinnedHeaderExpandableListView = (QfilePinnedHeaderExpandableListView) findViewById(R.id.c_r);
        this.L = qfilePinnedHeaderExpandableListView;
        qfilePinnedHeaderExpandableListView.setSelection(0);
        AccessibilityUtil.n(this.L, false);
        this.L.setFocusable(false);
    }

    private void N0(FileManagerEntity fileManagerEntity) {
        if (com.tencent.mobileqq.filemanager.data.f.D(fileManagerEntity)) {
            com.tencent.mobileqq.filemanager.data.f.H(fileManagerEntity);
        } else {
            com.tencent.mobileqq.filemanager.data.f.d(fileManagerEntity);
            if (this.f206603d.j3() && !com.tencent.mobileqq.filemanager.data.f.w(com.tencent.mobileqq.filemanager.data.f.f207765k) && !com.tencent.mobileqq.filemanager.data.f.A(fileManagerEntity)) {
                QQCustomDialog createNoTitleDialog = DialogUtil.createNoTitleDialog(this.f206603d, R.string.f0g);
                createNoTitleDialog.setPositiveButton(R.string.i5e, new DialogUtil.DialogOnClickAdapter());
                createNoTitleDialog.show();
                com.tencent.mobileqq.filemanager.data.f.L(com.tencent.mobileqq.filemanager.data.f.f207765k);
                FileManagerReporter.addData("0X800942D");
            }
        }
        if ((this instanceof QfileRecentDocFileTabView) || (this instanceof QfileRecentAllFileTabView)) {
            this.f206603d.G3(true);
        }
        if (this.f206603d.f206192z0 && fileManagerEntity.cloudType == 3 && !FileUtils.fileExistsAndNotEmpty(fileManagerEntity.getFilePath())) {
            com.tencent.mobileqq.filemanager.util.d.f(ah.y(fileManagerEntity.fileName) + HardCodeUtil.qqStr(R.string.f187013su));
            com.tencent.mobileqq.filemanager.data.f.H(fileManagerEntity);
        } else if (this.f206603d.A0 && !((IGuildFileApi) QRoute.api(IGuildFileApi.class)).isLegalForSelectedFileName(fileManagerEntity.fileName)) {
            com.tencent.mobileqq.filemanager.util.d.f(HardCodeUtil.qqStr(R.string.f187133t6));
            com.tencent.mobileqq.filemanager.data.f.H(fileManagerEntity);
        }
        k();
        I0();
    }

    private boolean q0(long[] jArr, long j3) {
        for (long j16 : jArr) {
            if (j16 == j3) {
                return true;
            }
        }
        return false;
    }

    private void u0(boolean z16, FileManagerEntity fileManagerEntity) {
        String str;
        if (this.f206603d.t3() && !z16) {
            if (this instanceof QfileRecentAllFileTabView) {
                if (fileManagerEntity.nFileType == 13 && this.F == 1) {
                    ReportController.o(this.f206604e, "dc00898", "", "", "0X800A072", "0X800A072", 0, 0, "", "", "", "");
                }
                str = "0X8009E3F";
            } else if (this instanceof QfileRecentAppFileTabView) {
                str = "0X8009E76";
            } else if (this instanceof QfileRecentDocFileTabView) {
                str = "0X8009E40";
            } else if (this instanceof QfileRecentMediaFileTabView) {
                str = "0X8009E75";
            } else if (this instanceof QfileRecentPicFileTabView) {
                str = "0X8009E41";
            } else {
                if (this instanceof QfileRecentTencentDocFileTabView) {
                    str = "0X800A07A";
                }
                str = "";
            }
        } else {
            if (!this.f206603d.t3()) {
                if (this instanceof QfileRecentAllFileTabView) {
                    if (fileManagerEntity.nFileType == 13 && this.F == 2) {
                        ReportController.o(this.f206604e, "dc00898", "", "", "0X800A087", "0X800A087", 0, 0, "", "", "", "");
                    }
                    str = "0X8009E51";
                } else if (this instanceof QfileRecentAppFileTabView) {
                    str = "0X8009E6D";
                } else if (this instanceof QfileRecentDocFileTabView) {
                    str = "0X8009E52";
                } else if (this instanceof QfileRecentMediaFileTabView) {
                    str = "0X8009E6C";
                } else if (this instanceof QfileRecentPicFileTabView) {
                    str = "0X8009E53";
                } else if ((this instanceof QfileRecentTencentDocFileTabView) && this.F == 2) {
                    str = "0X800A08C";
                }
            }
            str = "";
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            ReportController.o(this.f206604e, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(List<FileManagerEntity> list) {
        if (list == null) {
            return;
        }
        Iterator<FileManagerEntity> it = list.iterator();
        while (it.hasNext()) {
            FileManagerEntity next = it.next();
            if (next.nOpType == 58 && !FileUtils.fileExists(next.strFilePath)) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HeaderScrollView x0(View view) {
        Object parent = view.getParent();
        if (parent instanceof HeaderScrollView) {
            return (HeaderScrollView) parent;
        }
        if (parent instanceof View) {
            return x0((View) parent);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        BaseFileAssistantActivity baseFileAssistantActivity = this.f206603d;
        baseFileAssistantActivity.H2(baseFileAssistantActivity.r3());
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void C() {
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.8
            @Override // java.lang.Runnable
            public void run() {
                LinkedHashMap<String, List<FileManagerEntity>> linkedHashMap = QfileBaseRecentFileTabView.this.G;
                if (linkedHashMap != null && linkedHashMap.size() > 0) {
                    Iterator<String> it = QfileBaseRecentFileTabView.this.G.keySet().iterator();
                    while (it.hasNext()) {
                        Iterator<FileManagerEntity> it5 = QfileBaseRecentFileTabView.this.G.get(it.next()).iterator();
                        while (it5.hasNext()) {
                            FileManagerEntity next = it5.next();
                            if (next.fileSize <= 0 && next.nOpType == 55) {
                                it5.remove();
                            }
                        }
                    }
                }
                QfileBaseRecentFileTabView.this.I0();
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void D() {
        List<FileManagerEntity> list = this.P;
        if (list != null && list.size() > 0) {
            z0();
            if (QLog.isDevelopLevel()) {
                QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " resetData -> getRecentFileRecords ");
            }
        }
    }

    protected void D0(List<FileManagerEntity> list) {
        if (list == null) {
            return;
        }
        List<FileManagerEntity> list2 = this.P;
        if (list2 != null) {
            list2.clear();
        }
        if (this.P == null) {
            this.P = new ArrayList();
        }
        BaseFileAssistantActivity baseFileAssistantActivity = this.f206603d;
        if (baseFileAssistantActivity != null && baseFileAssistantActivity.p3() && this.f206603d.s3()) {
            for (FileManagerEntity fileManagerEntity : list) {
                if (!((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).isUndownloadDatalineEntity(fileManagerEntity)) {
                    this.P.add(fileManagerEntity);
                }
            }
            return;
        }
        this.P.addAll(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void G0() {
        if (this.U) {
            return;
        }
        this.U = true;
        if (QLog.isColorLevel()) {
            QLog.i(f206699f0, 2, "queryFileEntitiesFromDB");
        }
        if (QLog.isDevelopLevel()) {
            QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " queryFileEntitiesFromDB");
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.2
            @Override // java.lang.Runnable
            public void run() {
                final List<FileManagerEntity> queryMaxRecentReocrds;
                if (QLog.isColorLevel()) {
                    QLog.i(QfileBaseRecentFileTabView.f206699f0, 2, "queryFileEntitiesFromDB thread start");
                }
                String str = QfileBaseRecentFileTabView.this.E;
                if (str != null && str.trim().length() != 0) {
                    queryMaxRecentReocrds = ((IQQFileDataCenter) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileDataCenter.class)).queryMaxRecentReocrdsWithUin(QfileBaseRecentFileTabView.this.E);
                } else {
                    queryMaxRecentReocrds = ((IQQFileDataCenter) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileDataCenter.class)).queryMaxRecentReocrds();
                }
                QfileBaseRecentFileTabView.this.v0(queryMaxRecentReocrds);
                Collections.sort(queryMaxRecentReocrds, QfileBaseRecentFileTabView.this.V);
                if (queryMaxRecentReocrds != null) {
                    QfileBaseRecentFileTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (QLog.isDevelopLevel()) {
                                QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " queryFileEntitiesFromDB addAll");
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i(QfileBaseRecentFileTabView.f206699f0, 2, "queryFileEntitiesFromDB end size[" + queryMaxRecentReocrds.size() + "]");
                            }
                            QfileBaseRecentFileTabView.this.D0(queryMaxRecentReocrds);
                            if (QLog.isColorLevel()) {
                                QLog.i(QfileBaseRecentFileTabView.f206699f0, 2, "initFileEntities size[" + QfileBaseRecentFileTabView.this.P.size() + "]");
                            }
                            QfileBaseRecentFileTabView.this.z0();
                            SharedPreferences sharedPreferences = ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getApplication().getSharedPreferences("OfflineFileMerge" + ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getCurrentUin(), 0);
                            long j3 = sharedPreferences.getLong("LastRequestTime", 0L);
                            long currentTimeMillis = System.currentTimeMillis();
                            if (Math.abs(currentTimeMillis - j3) > 86400000) {
                                QLog.i(QfileBaseRecentFileTabView.f206699f0, 1, "updata offlineList");
                                QfileBaseRecentFileTabView.this.H0();
                            } else {
                                sharedPreferences.edit().putLong("LastRequestTime", currentTimeMillis).commit();
                                QLog.i(QfileBaseRecentFileTabView.f206699f0, 1, "updata last process time");
                            }
                            if (QLog.isDevelopLevel()) {
                                QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " queryFileEntitiesFromDB -> getRecentFileRecords ");
                            }
                        }
                    });
                }
            }
        }, 8, null, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I0() {
        LinkedHashMap<String, List<FileManagerEntity>> linkedHashMap = this.G;
        if (linkedHashMap != null && linkedHashMap.size() != 0) {
            NoFileRelativeLayout noFileRelativeLayout = this.H;
            if (noFileRelativeLayout != null) {
                if (noFileRelativeLayout.getParent() != null) {
                    removeView(this.H);
                }
                this.L.setEnabled(true);
                if (C0()) {
                    String d16 = TencentDocImportFileInfoProcessor.c().d();
                    if (TextUtils.isEmpty(d16)) {
                        this.J.setVisibility(8);
                    } else {
                        this.J.setVisibility(0);
                        this.K.setText(d16);
                    }
                } else {
                    this.J.setVisibility(8);
                }
            }
        } else {
            if (this.H.getParent() == null) {
                addView(this.H, new RelativeLayout.LayoutParams(-1, -1));
            }
            if (this instanceof QfileRecentTencentDocFileTabView) {
                this.H.b();
                ReportController.o(this.f206604e, "dc00898", "", "", "0X800A225", "0X800A225", 0, 0, "", "", "", "");
            } else if (this instanceof QfileRecentTDocFileTabView) {
                this.H.b();
                ReportController.o(this.f206604e, "dc00898", "", "", "0X800A08B", "0X800A08B", 0, 0, "", "", "", "");
            } else {
                this.H.a();
            }
            this.H.setVisible(true);
            this.L.setEnabled(false);
            this.J.setVisibility(8);
        }
        L0();
        this.Q.notifyDataSetChanged();
    }

    abstract void K0(FileManagerEntity fileManagerEntity);

    protected void L0() {
        int measuredHeight = this.L.getMeasuredHeight();
        NoFileRelativeLayout noFileRelativeLayout = this.H;
        if (noFileRelativeLayout != null) {
            noFileRelativeLayout.setLayoutParams(this.L.getWidth(), measuredHeight);
            if (this.f206603d.t3()) {
                this.H.setTopViewHeight(0.2f);
            } else {
                this.H.setTopViewHeight(1.0f);
            }
        }
    }

    public void M0(FileManagerEntity fileManagerEntity, View view, boolean z16) {
        if (v() && !z16) {
            N0(fileManagerEntity);
        } else {
            if (!w()) {
                if (QLog.isColorLevel()) {
                    QLog.i(f206699f0, 2, "click too fast , wait a minute.");
                    return;
                }
                return;
            }
            G();
            ah.e(fileManagerEntity);
            FileManagerReporter.a aVar = new FileManagerReporter.a();
            aVar.f209157b = "file_viewer_in";
            aVar.f209158c = 73;
            if (fileManagerEntity.nFileType == 13) {
                aVar.f209159d = "tencentdoc_ext";
            } else {
                aVar.f209159d = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getExtension(fileManagerEntity.fileName);
            }
            aVar.f209160e = fileManagerEntity.fileSize;
            FileManagerReporter.addData(this.f206604e.getCurrentAccountUin(), aVar);
            FileManagerReporter.addData("0X8004AE4");
            IQQFileTempUtils iQQFileTempUtils = (IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class);
            BaseQQAppInterface baseQQAppInterface = this.f206604e;
            BaseFileAssistantActivity baseFileAssistantActivity = this.f206603d;
            iQQFileTempUtils.openRencentFileBrowserOnItemClick(baseQQAppInterface, baseFileAssistantActivity, fileManagerEntity, baseFileAssistantActivity.u3(), this.E, view, this instanceof QfileRecentAllFileTabView, this instanceof QfileRecentTencentDocFileTabView, 2);
        }
        u0(v(), fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, com.tencent.mobileqq.filemanager.widget.c.a
    public View getScrollableView() {
        return this.L;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void i(ArrayList<FileManagerEntity> arrayList) {
        if (arrayList == null) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            K0(arrayList.get(i3));
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.a
    public void onPause() {
        super.onPause();
        this.Q.g(false);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.a
    public void onResume() {
        this.Q.g(true);
        G0();
        BaseFileAssistantActivity baseFileAssistantActivity = this.f206603d;
        baseFileAssistantActivity.H2(baseFileAssistantActivity.r3());
        C();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public int p() {
        return 0;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public ListView q() {
        return this.L;
    }

    public boolean r0(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            return false;
        }
        return s0(fileManagerEntity);
    }

    protected boolean s0(FileManagerEntity fileManagerEntity) {
        synchronized (this.P) {
            if (QLog.isDevelopLevel()) {
                QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " delRecent");
            }
            Iterator<FileManagerEntity> it = this.P.iterator();
            while (it.hasNext()) {
                if (fileManagerEntity == it.next()) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public void setAttribution(int i3) {
        this.F = i3;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void setSelect(final int i3) {
        if (this.Q.getGroupCount() <= i3) {
            QLog.e(f206699f0, 1, "setSelect[" + i3 + "] faild,becouse GroupCount[" + this.Q.getGroupCount() + "]");
            return;
        }
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.9
            @Override // java.lang.Runnable
            public void run() {
                QfileBaseRecentFileTabView qfileBaseRecentFileTabView = QfileBaseRecentFileTabView.this;
                qfileBaseRecentFileTabView.f206603d.U3(qfileBaseRecentFileTabView);
                QfileBaseRecentFileTabView qfileBaseRecentFileTabView2 = QfileBaseRecentFileTabView.this;
                if (qfileBaseRecentFileTabView2.L != null && ((QfileBaseTabView) qfileBaseRecentFileTabView2).f206606h) {
                    QLog.e(QfileBaseRecentFileTabView.f206699f0, 1, "setSelect[" + i3 + "] success mFileListView");
                    QfileBaseRecentFileTabView.this.L.expandGroup(i3);
                }
            }
        });
    }

    protected void t0(FileManagerEntity fileManagerEntity) {
        synchronized (this.P) {
            if (QLog.isDevelopLevel()) {
                QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " delRecent");
            }
            Iterator<FileManagerEntity> it = this.P.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (fileManagerEntity.nSessionId == it.next().nSessionId) {
                    it.remove();
                    break;
                }
            }
        }
        synchronized (this.G) {
            Iterator<List<FileManagerEntity>> it5 = this.G.values().iterator();
            while (it5.hasNext()) {
                Iterator<FileManagerEntity> it6 = it5.next().iterator();
                while (it6.hasNext()) {
                    if (fileManagerEntity.nSessionId == it6.next().nSessionId) {
                        it6.remove();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w0(FileManagerEntity fileManagerEntity) {
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).forwardFile(this.f206603d, fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void y() {
        F(R.layout.alw);
        this.N = LayoutInflater.from(o());
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).addObserver(this.f206704e0);
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).addDatalineObserver();
        F0();
        ob1.d y06 = y0();
        this.Q = y06;
        y06.f(this.L);
        E0();
        this.L.setSelector(R.color.ajr);
        int i3 = 0;
        if (this.Q instanceof ob1.f) {
            this.L.setSelector(R.color.ajr);
            this.L.setWhetherImageTab(true);
            this.L.setGridSize(((ob1.f) this.Q).k());
            this.L.setAdapter(this.Q);
            this.L.setTranscriptMode(0);
            while (i3 < this.Q.getGroupCount()) {
                this.L.expandGroup(i3);
                i3++;
            }
            return;
        }
        this.L.setSelector(R.color.ajr);
        this.L.setWhetherImageTab(false);
        this.L.setAdapter(this.Q);
        this.L.setTranscriptMode(0);
        while (i3 < this.Q.getGroupCount()) {
            this.L.expandGroup(i3);
            i3++;
        }
    }

    protected abstract ob1.d y0();

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void z() {
        if (QLog.isDevelopLevel()) {
            QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " onDestroy");
        }
        this.P.clear();
        this.G.clear();
        H();
        if (this.f206704e0 != null) {
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.f206704e0);
        }
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).removeDatalineObserver();
    }

    abstract void z0();

    public void setSelect(int i3, int i16, long[] jArr) {
        if (this.Q.getGroupCount() <= i3) {
            QLog.e(f206699f0, 1, "setSelect[" + i3 + "] faild,becouse GroupCount[" + this.Q.getGroupCount() + "]");
            return;
        }
        E(new AnonymousClass10(i3, i16, jArr));
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            h hVar = (h) view.getTag();
            FileManagerEntity fileManagerEntity = (FileManagerEntity) hVar.E;
            if (5 != fileManagerEntity.cloudType) {
                ah.e(fileManagerEntity);
            }
            int i3 = hVar.f422359h;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            QfileBaseRecentFileTabView.this.f206603d.U2().j0();
                            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                                com.tencent.mobileqq.filemanager.util.d.e(R.string.b_o);
                            } else if (fileManagerEntity.status == 16) {
                                com.tencent.mobileqq.filemanager.util.d.e(R.string.bet);
                            } else {
                                ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).doWithWifiChecked(fileManagerEntity, fileManagerEntity.isSend(), QfileBaseRecentFileTabView.this.f206603d, new b(fileManagerEntity));
                            }
                        }
                    } else {
                        QfileBaseRecentFileTabView.this.f206603d.U2().e();
                        if (fileManagerEntity.getCloudType() == 0) {
                            ((IQQFileEngine) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileEngine.class)).pauseOnlineTrans(fileManagerEntity.nSessionId);
                        } else if (fileManagerEntity.getCloudType() == 6) {
                            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).cancelDatalineFile(fileManagerEntity);
                        } else if (fileManagerEntity.getCloudType() == 14) {
                            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).pauseAdFileDownload(fileManagerEntity);
                        } else {
                            ((IQQFileEngine) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileEngine.class)).pause(fileManagerEntity.nSessionId);
                        }
                    }
                } else {
                    QfileBaseRecentFileTabView.this.f206603d.U2().a();
                    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                        com.tencent.mobileqq.filemanager.util.d.e(R.string.b_o);
                    } else if (fileManagerEntity.status == 16) {
                        com.tencent.mobileqq.filemanager.util.d.e(R.string.bet);
                    } else {
                        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).doWithWifiChecked(fileManagerEntity, false, QfileBaseRecentFileTabView.this.getContext(), new a(fileManagerEntity));
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
            QfileBaseRecentFileTabView.this.f206603d.U2().onPreviewClick();
            QfileBaseRecentFileTabView.this.M0(fileManagerEntity, hVar.f422361m, false);
            QfileBaseRecentFileTabView.this.C();
            EventCollector.getInstance().onViewClicked(view);
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements FMDialogUtil.c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ FileManagerEntity f206726a;

            a(FileManagerEntity fileManagerEntity) {
                this.f206726a = fileManagerEntity;
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                QfileBaseRecentFileTabView.this.f206603d.U2().a();
                if (this.f206726a.getCloudType() == 0) {
                    ((IQQFileEngine) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileEngine.class)).recvOnLineFile(this.f206726a.nSessionId);
                    return;
                }
                if (this.f206726a.getCloudType() == 6) {
                    ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).downloadDatalineFile(this.f206726a);
                    return;
                }
                if (this.f206726a.getCloudType() == 14) {
                    ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).startAdFileDownload(this.f206726a);
                    return;
                }
                FileManagerEntity fileManagerEntity = this.f206726a;
                if (fileManagerEntity.nFileType == 2) {
                    fileManagerEntity.videoDownloadForceThroughNT = true;
                }
                ((IQQFileEngine) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileEngine.class)).reviceFile(this.f206726a);
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
            }
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class b implements FMDialogUtil.c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ FileManagerEntity f206728a;

            b(FileManagerEntity fileManagerEntity) {
                this.f206728a = fileManagerEntity;
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                if (this.f206728a.getCloudType() == 0) {
                    ((IQQFileEngine) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileEngine.class)).resumeOnlineTrans(this.f206728a.nSessionId);
                    return;
                }
                if (this.f206728a.getCloudType() == 6) {
                    ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).downloadDatalineFile(this.f206728a);
                } else if (this.f206728a.getCloudType() == 14) {
                    ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).startAdFileDownload(this.f206728a);
                } else {
                    ((IQQFileEngine) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileEngine.class)).resume(this.f206728a.nSessionId);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
            }
        }
    }

    public QfileBaseRecentFileTabView(Context context, String str) {
        super(context);
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.M = -1L;
        this.N = null;
        this.P = null;
        this.Q = null;
        this.R = "LastRequestTime";
        this.S = 0;
        this.T = false;
        this.U = false;
        this.V = new a();
        this.W = null;
        this.f206700a0 = new c();
        this.f206701b0 = new f();
        this.f206702c0 = new d();
        this.f206703d0 = new e();
        this.f206704e0 = new FMObserver() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void B0(n nVar) {
                if (nVar == null) {
                    return;
                }
                Object obj = nVar.f207832c;
                if (obj instanceof FileManagerEntity) {
                    FileManagerEntity fileManagerEntity = (FileManagerEntity) obj;
                    String str2 = nVar.f207833d;
                    if (str2 != null && str2.length() > 0) {
                        fileManagerEntity.strThumbPath = nVar.f207833d;
                        ((IQQFileDataCenter) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileDataCenter.class, "")).updateFileEntity(fileManagerEntity);
                        QfileBaseRecentFileTabView.this.C();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void P(long j3, long j16, String str2, int i3) {
                FileManagerEntity queryFileEntity = ((IQQFileDataCenter) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileDataCenter.class)).queryFileEntity(j3, str2, i3, j16);
                if (queryFileEntity == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e(QfileBaseRecentFileTabView.f206699f0, 2, "OnFileCome,but query FileEntity null,uniseq[" + j3 + "], nSessionId[" + j16 + "], strUin[" + str2 + "], peerType[" + i3 + "]");
                        return;
                    }
                    return;
                }
                QfileBaseRecentFileTabView.this.K0(queryFileEntity);
                ((IQQFileDataCenter) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileDataCenter.class, "")).updateFileEntity(queryFileEntity);
                QfileBaseRecentFileTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.7.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QfileBaseRecentFileTabView.this.I0();
                    }
                });
            }

            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            protected void S(boolean z16, long j3, long j16, String str2, int i3, int i16, String str22) {
                FileManagerEntity queryFileEntity = ((IQQFileDataCenter) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileDataCenter.class)).queryFileEntity(j3, str2, i3, j16);
                if (queryFileEntity == null) {
                    QLog.e(QfileBaseRecentFileTabView.f206699f0, 1, "OnFileCome,but query FileEntity null,uniseq[" + j3 + "], nSessionId[" + j16 + "], strUin[" + str2 + "], peerType[" + i3 + "]");
                    return;
                }
                if (!z16) {
                    queryFileEntity.bDelInFM = false;
                    ah.C(j16, i16, str22);
                    ((IOpenWeiyunVipHelper) QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(QfileBaseRecentFileTabView.this.f206603d, i16);
                } else {
                    int i17 = queryFileEntity.nOpType;
                    if (i17 == 4 || i17 == 20 || i17 == 6) {
                        ah.D(j16);
                    }
                }
                String str3 = QfileBaseRecentFileTabView.this.E;
                if (str3 == null || str3.trim().length() == 0 || queryFileEntity.getCloudType() != 2) {
                    QfileBaseRecentFileTabView.this.K0(queryFileEntity);
                }
                ((IQQFileDataCenter) ((QfileBaseTabView) QfileBaseRecentFileTabView.this).f206604e.getRuntimeService(IQQFileDataCenter.class, "")).updateFileEntity(queryFileEntity);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void T(boolean z16, long j3, long j16, String str2, int i3) {
                QfileBaseRecentFileTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QfileBaseRecentFileTabView.this.I0();
                    }
                });
            }

            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            protected void T0(Integer num, long j3, String str2) {
                QfileBaseRecentFileTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.7.3
                    @Override // java.lang.Runnable
                    public void run() {
                        QfileBaseRecentFileTabView.this.I0();
                    }
                });
                ah.C(j3, num.intValue(), str2);
                ((IOpenWeiyunVipHelper) QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(QfileBaseRecentFileTabView.this.f206603d, num.intValue());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void j0(int i3, long j3, String str2) {
                super.j0(i3, j3, str2);
                ah.C(j3, i3, str2);
                ((IOpenWeiyunVipHelper) QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(QfileBaseRecentFileTabView.this.f206603d, i3);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void k0(long j3, String str2, int i3, String str22) {
                super.k0(j3, str2, i3, str22);
                QfileBaseRecentFileTabView.this.G0();
                ah.D(j3);
                QfileBaseRecentFileTabView.this.C();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void s0() {
                super.s0();
                QfileBaseRecentFileTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.7.4
                    @Override // java.lang.Runnable
                    public void run() {
                        QfileBaseRecentFileTabView.this.I0();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void x0(FileManagerEntity fileManagerEntity, boolean z16) {
                super.x0(fileManagerEntity, z16);
                if (!z16) {
                    QfileBaseRecentFileTabView.this.t0(fileManagerEntity);
                }
                QfileBaseRecentFileTabView.this.K0(fileManagerEntity);
                QfileBaseRecentFileTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.7.5
                    @Override // java.lang.Runnable
                    public void run() {
                        QfileBaseRecentFileTabView.this.I0();
                    }
                });
            }

            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            protected void P0(Boolean bool, List<OfflineFileInfo> list) {
            }
        };
        this.E = str;
        this.G = new LinkedHashMap<>();
        this.P = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
    }

    public void J0(boolean z16) {
    }
}
