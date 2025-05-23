package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.DocExportFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.TDocFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi;
import com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import rx.functions.Action1;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileBrowserManager {

    /* renamed from: a, reason: collision with root package name */
    private Activity f208141a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.filemanager.fileviewer.viewer.a f208142b;

    /* renamed from: c, reason: collision with root package name */
    private FileBrowserPresenterBase f208143c;

    /* renamed from: d, reason: collision with root package name */
    private FileBrowserModelBase f208144d;

    /* renamed from: e, reason: collision with root package name */
    private g f208145e;

    /* renamed from: f, reason: collision with root package name */
    protected h f208146f;

    /* renamed from: g, reason: collision with root package name */
    private e f208147g;

    /* renamed from: h, reason: collision with root package name */
    private Bundle f208148h;

    /* renamed from: j, reason: collision with root package name */
    private ShareActionSheet f208150j;

    /* renamed from: i, reason: collision with root package name */
    private int f208149i = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f208151k = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ImmersiveUtils.isSupporImmersive();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements Action1<ArrayList<ShareActionSheetBuilder.ActionSheetItem>[]> {
        b() {
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] arrayListArr) {
            FileBrowserManager.this.q(arrayListArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements ShareActionSheet.OnItemClickListener {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            if (actionSheetItem == null) {
                return;
            }
            FileBrowserManager.this.f208150j.dismiss();
            View.OnClickListener onClickListener = actionSheetItem.listener;
            if (onClickListener != null) {
                onClickListener.onClick(null);
            } else if (FileBrowserManager.this.f208144d != null) {
                FileBrowserManager.this.f208144d.k0(actionSheetItem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements Action1<ArrayList<ShareActionSheetBuilder.ActionSheetItem>[]> {
        d() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void call(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] arrayListArr) {
            ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList;
            ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = null;
            if (arrayListArr != null) {
                if (arrayListArr.length == 1) {
                    arrayList2 = arrayListArr[0];
                    arrayList = null;
                } else if (arrayListArr.length == 2) {
                    arrayList2 = arrayListArr[0];
                    arrayList = arrayListArr[1];
                }
                if ((arrayList2 != null && !arrayList2.isEmpty()) || (arrayList != null && !arrayList.isEmpty())) {
                    FileBrowserManager.this.f208150j.setActionSheetItems(arrayList2, arrayList);
                }
                if (FileBrowserManager.this.f208150j.isShowing()) {
                    FileBrowserManager.this.f208150j.refresh();
                    return;
                }
                return;
            }
            arrayList = null;
            if (arrayList2 != null) {
                FileBrowserManager.this.f208150j.setActionSheetItems(arrayList2, arrayList);
                if (FileBrowserManager.this.f208150j.isShowing()) {
                }
            }
            FileBrowserManager.this.f208150j.setActionSheetItems(arrayList2, arrayList);
            if (FileBrowserManager.this.f208150j.isShowing()) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface e {
        FileBrowserModelBase a();
    }

    public FileBrowserManager(Activity activity, g gVar, e eVar) {
        this.f208141a = activity;
        this.f208145e = gVar;
        this.f208147g = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(long j3, Intent intent, FileManagerEntity fileManagerEntity) {
        com.tencent.mobileqq.tbstool.a.f291409a.c(j3);
        this.f208144d.C0(fileManagerEntity);
        intent.putExtra("fileinfo", ForwardFileOption.U(fileManagerEntity));
    }

    private void F(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] arrayListArr) {
        if (arrayListArr != null && arrayListArr.length > 0) {
            for (ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList : arrayListArr) {
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator<ShareActionSheetBuilder.ActionSheetItem> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().action == 26) {
                            ReportController.o(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
                        }
                    }
                }
            }
        }
    }

    private void G() {
        int docsTypeOfIntValue = ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getDocsTypeOfIntValue(((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getFileDocsType(this.f208144d.N()));
        String lowerCase = FileUtils.getExtension(this.f208144d.N()).toLowerCase();
        QLog.i("FileBrowserManager<FileAssistant>", 1, "reportTDocPreviewFallback fileExt: " + lowerCase + " docsType:" + docsTypeOfIntValue);
        ((ITDocAttaReporterApi) QRoute.api(ITDocAttaReporterApi.class)).fileBrowserReport("show", 4, 0L, "", this.f208144d.Q(), docsTypeOfIntValue, lowerCase, 0, "", "");
    }

    private void e(final Action1<ArrayList<ShareActionSheetBuilder.ActionSheetItem>[]> action1) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.FileBrowserManager.6
            @Override // java.lang.Runnable
            public void run() {
                final ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] s16 = FileBrowserManager.this.s();
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.FileBrowserManager.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        action1.call(s16);
                    }
                });
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] arrayListArr) {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList;
        if (this.f208144d == null) {
            return;
        }
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = null;
        if (arrayListArr != null) {
            if (arrayListArr.length == 1) {
                arrayList = null;
                arrayList2 = arrayListArr[0];
            } else if (arrayListArr.length == 2) {
                arrayList2 = arrayListArr[0];
                arrayList = arrayListArr[1];
            }
            if ((arrayList2 == null && !arrayList2.isEmpty()) || (arrayList != null && !arrayList.isEmpty())) {
                F(arrayListArr);
                this.f208150j.setActionSheetTitle("\u5206\u4eab\u5230");
                Intent X = this.f208144d.X();
                String x16 = this.f208144d.x();
                this.f208141a.getIntent().putExtra("big_brother_source_key", x16);
                if (X != null && !TextUtils.isEmpty(x16)) {
                    this.f208150j.setIntentForStartForwardRecentActivity(X);
                } else {
                    this.f208150j.setRowVisibility(8, 0, 0);
                }
                this.f208150j.setActionSheetItems(arrayList2, arrayList);
                this.f208150j.setItemClickListenerV2(new c());
                this.f208150j.show();
                return;
            }
            return;
        }
        arrayList = null;
        if (arrayList2 == null) {
        }
    }

    private boolean z() {
        boolean z16 = this.f208148h.getBoolean("tdoc_enable", false);
        String lowerCase = FileUtils.getExtension(this.f208144d.N()).toLowerCase();
        if (!((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).checkFileExist(this.f208144d.N()) || !z16 || !((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).isTDocPreviewEnable(lowerCase)) {
            return false;
        }
        return true;
    }

    public boolean B(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, boolean z16) {
        boolean E = E(z16);
        if (E && viewGroup != null && layoutParams != null) {
            viewGroup.removeAllViews();
            viewGroup.addView(this.f208142b.a(), layoutParams);
        }
        return E;
    }

    public void C(int i3, int i16, Intent intent) {
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f208143c;
        if (fileBrowserPresenterBase != null) {
            fileBrowserPresenterBase.N(i3, i16, intent);
        }
    }

    public void D(Configuration configuration) {
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f208143c;
        if (fileBrowserPresenterBase != null) {
            fileBrowserPresenterBase.O(configuration);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected boolean E(boolean z16) {
        FileBrowserModelBase fileBrowserModelBase = this.f208144d;
        if (fileBrowserModelBase != null) {
            int A = fileBrowserModelBase.A();
            this.f208144d.N();
            if (QLog.isColorLevel()) {
                QLog.i("FileBrowserManager<FileAssistant>", 1, "refreshFileView. currentType[" + this.f208149i + "] fileType[" + A + "]");
            }
            if (this.f208149i == A && !z16) {
                this.f208143c.K();
            } else {
                FileBrowserPresenterBase fileBrowserPresenterBase = this.f208143c;
                if (fileBrowserPresenterBase != null) {
                    fileBrowserPresenterBase.x();
                }
                String N = this.f208144d.N();
                if (N != null && N.contains("/chatpic/chatimg/")) {
                    A = 6;
                }
                switch (A) {
                    case 1:
                        if (z()) {
                            this.f208143c = new TDocFilePresenter(this.f208144d, this.f208141a);
                            break;
                        } else {
                            G();
                            this.f208143c = new SimpleFilePresenter(this.f208144d, this.f208141a);
                            break;
                        }
                    case 2:
                        Bundle bundle = this.f208148h;
                        if (bundle != null && bundle.getBoolean("qfile_param_no_view_preview", false)) {
                            this.f208143c = new com.tencent.mobileqq.filemanager.fileviewer.presenter.e(this.f208144d, this.f208141a);
                            break;
                        } else {
                            this.f208143c = new VideoFilePresenter(this.f208144d, this.f208141a);
                            break;
                        }
                    case 3:
                        this.f208143c = new com.tencent.mobileqq.filemanager.fileviewer.presenter.b(this.f208144d, this.f208141a);
                        break;
                    case 4:
                        this.f208143c = new MusicFilePresenter(this.f208144d, this.f208141a);
                        break;
                    case 5:
                        this.f208143c = new ZipFilePresenter(this.f208144d, this.f208141a);
                        break;
                    case 6:
                        this.f208143c = new com.tencent.mobileqq.filemanager.fileviewer.presenter.f(this.f208144d, this.f208141a);
                        break;
                    case 7:
                        this.f208143c = new com.tencent.mobileqq.filemanager.fileviewer.presenter.g(this.f208144d, this.f208141a);
                        break;
                    case 8:
                        this.f208143c = new com.tencent.mobileqq.filemanager.fileviewer.presenter.h(this.f208144d, this.f208141a);
                        break;
                    case 9:
                        this.f208143c = new com.tencent.mobileqq.filemanager.fileviewer.presenter.e(this.f208144d, this.f208141a);
                        break;
                    case 10:
                        this.f208143c = new DocExportFilePresenter(this.f208144d, this.f208141a);
                        break;
                    case 11:
                        this.f208143c = new com.tencent.mobileqq.filemanager.fileviewer.presenter.a(this.f208144d, this.f208141a);
                        break;
                    default:
                        this.f208143c = new SimpleFilePresenter(this.f208144d, this.f208141a);
                        break;
                }
                Bundle bundle2 = this.f208148h;
                if (bundle2 != null) {
                    bundle2.putInt("file_enter_file_browser_type", this.f208151k);
                }
                this.f208143c.R(this.f208145e);
                this.f208143c.Q(this.f208148h);
                this.f208143c.T(this.f208146f);
                this.f208143c.K();
                this.f208142b = this.f208143c.F();
                this.f208149i = A;
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FileBrowserManager<FileAssistant>", 2, "initFileViewer error : model is null");
        }
        return false;
    }

    public void H(int i3) {
        this.f208151k = i3;
    }

    public void I(h hVar) {
        this.f208146f = hVar;
    }

    public void J(final Action1<Boolean> action1) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.FileBrowserManager.1
            @Override // java.lang.Runnable
            public void run() {
                final boolean K = FileBrowserManager.this.K();
                QLog.d("FileBrowserManager<FileAssistant>", 1, "shouldShowFileBrowserMenuPanelEntrance with callback shouldShowMenu: " + K);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.FileBrowserManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        action1.call(Boolean.valueOf(K));
                    }
                });
            }
        }, 16, null, true);
    }

    public boolean K() {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList;
        FileBrowserModelBase fileBrowserModelBase = this.f208144d;
        if (fileBrowserModelBase != null && !fileBrowserModelBase.t0()) {
            return false;
        }
        ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] s16 = s();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = null;
        if (s16 != null) {
            if (s16.length == 1) {
                arrayList2 = s16[0];
                arrayList = null;
            } else if (s16.length == 2) {
                arrayList2 = s16[0];
                arrayList = s16[1];
            }
            if ((arrayList2 != null || arrayList2.isEmpty()) && (arrayList == null || arrayList.isEmpty())) {
                return false;
            }
            return true;
        }
        arrayList = null;
        if (arrayList2 != null) {
        }
        return false;
    }

    public void L() {
        if (this.f208150j == null) {
            ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
            param.context = this.f208141a;
            this.f208150j = ShareActionSheetFactory.create(param);
        }
        this.f208150j.setRowVisibility(0, 0, 0);
        this.f208150j.setOnDismissListener(new a());
        e(new b());
    }

    public void M() {
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f208143c;
        if (fileBrowserPresenterBase != null && (fileBrowserPresenterBase instanceof VideoFilePresenter)) {
            fileBrowserPresenterBase.U();
        } else if (this.f208150j != null) {
            e(new d());
        }
    }

    public boolean f() {
        int V = this.f208144d.V();
        if (V != 3 && V != 9 && V != 7 && V != 10 && V != 6) {
            return false;
        }
        return true;
    }

    public boolean g() {
        FileBrowserModelBase fileBrowserModelBase = this.f208144d;
        if (fileBrowserModelBase != null && fileBrowserModelBase.y() != 0) {
            return true;
        }
        return false;
    }

    public boolean h(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i3, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.i("FileBrowserManager<FileAssistant>", 1, "FileBrowserManager init.");
        }
        this.f208148h = bundle;
        if (bundle == null) {
            this.f208148h = new Bundle();
        }
        if (this.f208144d == null) {
            FileBrowserModelBase a16 = this.f208147g.a();
            this.f208144d = a16;
            if (a16 == null) {
                QLog.e("FileBrowserManager<FileAssistant>", 1, "create FileBrowser failed, mFileModel = null");
                return false;
            }
            a16.I0(this.f208145e);
            this.f208144d.J0(i3);
            this.f208144d.H0(bundle);
        }
        boolean E = E(false);
        if (this.f208142b != null && this.f208143c != null) {
            if (viewGroup != null && layoutParams != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(this.f208142b.a(), layoutParams);
            }
            return E;
        }
        if (!QLog.isColorLevel()) {
            return false;
        }
        QLog.i("FileBrowserManager<FileAssistant>", 2, "create file view error");
        return false;
    }

    public void i() {
        FileBrowserModelBase fileBrowserModelBase = this.f208144d;
        if (fileBrowserModelBase != null) {
            fileBrowserModelBase.l();
        }
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f208143c;
        if (fileBrowserPresenterBase != null) {
            fileBrowserPresenterBase.v();
        }
    }

    public void j(final Intent intent) {
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f208143c;
        if (fileBrowserPresenterBase != null) {
            fileBrowserPresenterBase.w();
        }
        final long P = this.f208144d.P();
        com.tencent.mobileqq.tbstool.a.f291409a.b(P, new com.tencent.mobileqq.tbstool.fileview.b() { // from class: com.tencent.mobileqq.filemanager.fileviewer.a
            @Override // com.tencent.mobileqq.tbstool.fileview.b
            public final void execute(Object obj) {
                FileBrowserManager.this.A(P, intent, (FileManagerEntity) obj);
            }
        });
    }

    public void k() {
        if (QLog.isDevelopLevel()) {
            QLog.i("FileBrowserManager<FileAssistant><FileAssistant>", 1, "FileBrowserManager Finish");
        }
        FileBrowserModelBase fileBrowserModelBase = this.f208144d;
        if (fileBrowserModelBase != null) {
            com.tencent.mobileqq.tbstool.a.f291409a.c(fileBrowserModelBase.P());
            this.f208144d.m();
            this.f208144d = null;
        }
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f208143c;
        if (fileBrowserPresenterBase != null) {
            fileBrowserPresenterBase.x();
            this.f208143c = null;
        }
        if (this.f208142b != null) {
            this.f208142b = null;
        }
    }

    public void l() {
        FileBrowserModelBase fileBrowserModelBase = this.f208144d;
        if (fileBrowserModelBase != null) {
            fileBrowserModelBase.n();
        }
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f208143c;
        if (fileBrowserPresenterBase != null) {
            fileBrowserPresenterBase.y();
        }
    }

    public void m() {
        FileBrowserModelBase fileBrowserModelBase = this.f208144d;
        if (fileBrowserModelBase != null) {
            fileBrowserModelBase.o();
        }
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f208143c;
        if (fileBrowserPresenterBase != null) {
            fileBrowserPresenterBase.z();
        }
    }

    public void n() {
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f208143c;
        if (fileBrowserPresenterBase != null) {
            fileBrowserPresenterBase.A();
        }
    }

    public void o() {
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f208143c;
        if (fileBrowserPresenterBase != null) {
            fileBrowserPresenterBase.B();
        }
    }

    public void p() {
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f208143c;
        if (fileBrowserPresenterBase != null) {
            fileBrowserPresenterBase.C();
        }
    }

    public com.tencent.mobileqq.colornote.f r() {
        FileBrowserModelBase fileBrowserModelBase = this.f208144d;
        if (fileBrowserModelBase != null) {
            return fileBrowserModelBase.H();
        }
        return null;
    }

    public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] s() {
        FileBrowserModelBase fileBrowserModelBase = this.f208144d;
        if (fileBrowserModelBase != null && fileBrowserModelBase.t0()) {
            return this.f208144d.Y();
        }
        return null;
    }

    public String t() {
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f208143c;
        if (fileBrowserPresenterBase != null) {
            return fileBrowserPresenterBase.E();
        }
        return "";
    }

    public int u() {
        FileBrowserModelBase fileBrowserModelBase = this.f208144d;
        if (fileBrowserModelBase != null) {
            return fileBrowserModelBase.V();
        }
        return -1;
    }

    public boolean v() {
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f208143c;
        if (fileBrowserPresenterBase != null) {
            return fileBrowserPresenterBase.G();
        }
        return false;
    }

    public long w() {
        FileBrowserModelBase fileBrowserModelBase = this.f208144d;
        if (fileBrowserModelBase != null) {
            return fileBrowserModelBase.P();
        }
        return 0L;
    }

    public boolean x() {
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f208143c;
        if (fileBrowserPresenterBase != null) {
            return fileBrowserPresenterBase.H();
        }
        return false;
    }

    public boolean y() {
        FileBrowserModelBase fileBrowserModelBase = this.f208144d;
        if (fileBrowserModelBase != null && fileBrowserModelBase.p0()) {
            return true;
        }
        return false;
    }
}
