package com.tencent.mobileqq.filebrowser;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.DefaultActivityModuleProvider;
import com.tencent.mobileqq.app.activitymodule.IActivityModule;
import com.tencent.mobileqq.app.activitymodule.IActivityModuleProvider;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.filebrowser.e;
import com.tencent.mobileqq.filebrowser.presenter.DocExportFilePresenter;
import com.tencent.mobileqq.filebrowser.presenter.DocFilePresenter;
import com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase;
import com.tencent.mobileqq.filebrowser.presenter.MusicFilePresenter;
import com.tencent.mobileqq.filebrowser.presenter.TDocFilePresenter;
import com.tencent.mobileqq.filebrowser.presenter.ZipFilePresenter;
import com.tencent.mobileqq.filebrowser.presenter.m;
import com.tencent.mobileqq.filebrowser.presenter.n;
import com.tencent.mobileqq.filebrowser.presenter.o;
import com.tencent.mobileqq.filebrowser.view.FileBrowserViewBase;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi;
import com.tencent.mobileqq.filemanager.util.FileDTReporter;
import com.tencent.mobileqq.filemanager.util.ae;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.bc;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tbstool.FileImporter;
import com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi;
import com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ca;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.studymode.api.IStudyModeApi;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.TokenResUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import rx.functions.Action1;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileBrowserActivity extends QIphoneTitleBarActivity implements View.OnClickListener, com.tencent.mobileqq.filebrowser.d, e.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private final Observer f205871a0;

    /* renamed from: b0, reason: collision with root package name */
    private BaseQQAppInterface f205872b0;

    /* renamed from: c0, reason: collision with root package name */
    com.tencent.mobileqq.filebrowser.e f205873c0;

    /* renamed from: d0, reason: collision with root package name */
    com.tencent.mobileqq.filebrowser.c f205874d0;

    /* renamed from: e0, reason: collision with root package name */
    FileBrowserPresenterBase f205875e0;

    /* renamed from: f0, reason: collision with root package name */
    private FileBrowserViewBase f205876f0;

    /* renamed from: g0, reason: collision with root package name */
    private Bundle f205877g0;

    /* renamed from: h0, reason: collision with root package name */
    private String f205878h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f205879i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f205880j0;

    /* renamed from: k0, reason: collision with root package name */
    private ImageView f205881k0;

    /* renamed from: l0, reason: collision with root package name */
    private ImageView f205882l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f205883m0;

    /* renamed from: n0, reason: collision with root package name */
    private IColorNoteController f205884n0;

    /* renamed from: o0, reason: collision with root package name */
    private ShareActionSheet f205885o0;

    /* renamed from: p0, reason: collision with root package name */
    private final u f205886p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f205887q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f205888r0;

    /* renamed from: s0, reason: collision with root package name */
    private com.tencent.mobileqq.widget.tip.a f205889s0;

    /* renamed from: t0, reason: collision with root package name */
    private View f205890t0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f205900d;

        a(int i3) {
            this.f205900d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserActivity.this, i3);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            FileBrowserPresenterBase fileBrowserPresenterBase;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            if (motionEvent != null && motionEvent2 != null) {
                float x16 = motionEvent.getX() - motionEvent2.getX();
                float abs = Math.abs((motionEvent.getY() - motionEvent2.getY()) / x16);
                if (x16 <= (-this.f205900d) && abs < 0.5f && (fileBrowserPresenterBase = FileBrowserActivity.this.f205875e0) != null && fileBrowserPresenterBase.B()) {
                    return FileBrowserActivity.this.onBackEvent();
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements ha1.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserActivity.this);
            }
        }

        @Override // ha1.a
        public void onColorNoteAnimFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                FileBrowserActivity.super.finish();
                FileBrowserActivity.this.overridePendingTransition(0, 0);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f205903d;

        c(int i3) {
            this.f205903d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserActivity.this, i3);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                int i3 = this.f205903d;
                if (i3 == 1) {
                    ReportController.o(null, "dc00898", "", "", "0X800A745", "0X800A745", ae.f(FileBrowserActivity.this.f205874d0.getFileType()), 0, "", "", "", "");
                    if (FileBrowserActivity.this.s()) {
                        FileBrowserActivity.this.finish();
                    }
                } else if (i3 == 2) {
                    FileBrowserActivity.this.t2();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements Action1<ArrayList<ShareActionSheetBuilder.ActionSheetItem>[]> {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserActivity.this);
            }
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] arrayListArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayListArr);
            } else if (!FileBrowserActivity.this.f205888r0) {
                FileBrowserActivity.this.Z2(arrayListArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e implements ShareActionSheet.OnItemClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) actionSheetItem, (Object) shareActionSheet);
                return;
            }
            if (actionSheetItem == null) {
                return;
            }
            if (actionSheetItem.uinType == 10014) {
                QQToast.makeText(FileBrowserActivity.this.getApplicationContext(), R.string.zzd, 0).show();
                return;
            }
            shareActionSheet.dismiss();
            View.OnClickListener onClickListener = actionSheetItem.listener;
            if (onClickListener != null) {
                onClickListener.onClick(null);
            } else {
                FileBrowserActivity.this.f205873c0.w(actionSheetItem);
            }
            try {
                ae.n(actionSheetItem, FileBrowserActivity.this.f205883m0, FileBrowserActivity.this.f205873c0.h(), FileBrowserActivity.this.f205873c0.J());
            } catch (Exception e16) {
                QLog.i("GeneralFileBrowserActivity", 1, "reportShareActionSheetClick", e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class f implements Observer {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserActivity.this);
            }
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) observable, obj);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class g extends DefaultActivityModuleProvider {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a extends SystemBarActivityModule {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
                }
            }

            @Override // com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule, com.tencent.mobileqq.app.activitymodule.ISystemBar
            public void initNavigationBarColor() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    com.tencent.mobileqq.theme.a.e(FileBrowserActivity.this.getWindow(), -16777216);
                }
            }
        }

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.activitymodule.DefaultActivityModuleProvider
        protected IActivityModule getSystemBarModule() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (IActivityModule) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class h implements Action1<Boolean> {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserActivity.this);
            }
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                return;
            }
            if (FileBrowserActivity.this.f205888r0) {
                return;
            }
            if (bool.booleanValue()) {
                FileBrowserActivity.this.f205882l0.setVisibility(0);
                if (com.tencent.mobileqq.tbstool.gray.b.f291450a.g(FileBrowserActivity.this.f205874d0.getFileName())) {
                    return;
                }
                FileBrowserActivity fileBrowserActivity = FileBrowserActivity.this;
                fileBrowserActivity.n3(fileBrowserActivity.f205882l0);
                return;
            }
            FileBrowserActivity.this.f205882l0.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class i implements a.b {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public /* bridge */ /* synthetic */ void onClick(View view) {
            l53.d.a(this, view);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                l53.d.b(this);
                FileBrowserActivity.this.f205889s0 = null;
            }
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.mobileqq.filemanager.fileviewer.onlineprint.h.f208453a.b("btn_more");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class j implements Action1<Boolean> {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserActivity.this);
            }
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Boolean bool) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                return;
            }
            if (!FileBrowserActivity.this.f205888r0) {
                ImageView imageView = FileBrowserActivity.this.f205882l0;
                if (bool.booleanValue()) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                imageView.setVisibility(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class k implements Action1<Boolean> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f205913d;

        k(View view) {
            this.f205913d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserActivity.this, (Object) view);
            }
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
            } else if (!FileBrowserActivity.this.f205888r0 && bool.booleanValue()) {
                FileBrowserActivity.this.v3(this.f205913d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class l implements com.tencent.mobileqq.tbstool.fileview.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f205915a;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    com.tencent.mobileqq.filemanager.fileviewer.onlineprint.h.f208453a.c("btn_more");
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        l(View view) {
            this.f205915a = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserActivity.this, (Object) view);
            }
        }

        @Override // com.tencent.mobileqq.tbstool.fileview.a
        public void invoke() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                FileBrowserActivity.this.n3(this.f205915a);
                ClickProxy.f205870a.a(this.f205915a, new a());
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    public FileBrowserActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f205871a0 = new f();
        this.f205880j0 = 0;
        this.f205886p0 = new u();
        this.f205888r0 = false;
        this.f205889s0 = null;
        this.f205890t0 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A3(boolean z16) {
        com.tencent.mobileqq.filebrowser.e eVar = this.f205873c0;
        if (eVar == null) {
            QLog.i("GeneralFileBrowserActivity", 1, "refreshFileView error: fileModel is null");
            return;
        }
        int M = eVar.M();
        if (QLog.isColorLevel()) {
            QLog.i("GeneralFileBrowserActivity", 1, "refreshFileView. currentType[" + this.f205880j0 + "] fileType[" + M + "] force[" + z16 + "]");
        }
        if (this.f205880j0 == M && !z16) {
            this.f205875e0.H();
        } else {
            FileBrowserPresenterBase fileBrowserPresenterBase = this.f205875e0;
            if (fileBrowserPresenterBase != null) {
                fileBrowserPresenterBase.t();
            }
            W2(M);
            FileBrowserPresenterBase fileBrowserPresenterBase2 = this.f205875e0;
            if (fileBrowserPresenterBase2 != null) {
                this.f205876f0 = fileBrowserPresenterBase2.A();
            }
            this.f205880j0 = M;
        }
        RelativeLayout e36 = e3();
        if (e36 != null) {
            e36.removeAllViews();
            e36.addView(this.f205876f0.c(), new ViewGroup.LayoutParams(-1, -1));
        }
        G3();
        w3(new j());
    }

    private void B3() {
        int docsTypeOfIntValue = ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getDocsTypeOfIntValue(((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getFileDocsType(this.f205874d0.getFilePath()));
        String lowerCase = FileUtils.getExtension(this.f205874d0.getFilePath()).toLowerCase();
        QLog.i("GeneralFileBrowserActivity", 1, "reportTDocPreviewFallback fileExt: " + lowerCase + " docsType:" + docsTypeOfIntValue);
        ((ITDocAttaReporterApi) QRoute.api(ITDocAttaReporterApi.class)).fileBrowserReport("show", 4, 0L, "", this.f205874d0.getFileSize(), docsTypeOfIntValue, lowerCase, 0, "", "");
    }

    private void C3() {
        l3();
        this.f205872b0 = (BaseQQAppInterface) getAppRuntime();
        Intent intent = getIntent();
        Bundle bundleExtra = intent.getBundleExtra("file_browser_extra_params");
        this.f205877g0 = bundleExtra;
        if (bundleExtra == null) {
            this.f205877g0 = new Bundle();
        }
        this.f205878h0 = intent.getStringExtra("file_browser_extra_params_uin");
        this.f205879i0 = intent.getIntExtra("file_enter_file_browser_type", 0);
        this.f205883m0 = intent.getIntExtra(IFileBrowserService.FILE_BROWSER_PARAMS_ENTRANCE, 0);
        setContentViewNoTitle(R.layout.amo);
        com.tencent.mobileqq.filebrowser.e eVar = this.f205873c0;
        if (eVar == null) {
            finish();
            return;
        }
        int M = eVar.M();
        this.f205880j0 = M;
        W2(M);
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f205875e0;
        if (fileBrowserPresenterBase == null) {
            finish();
            return;
        }
        this.f205876f0 = fileBrowserPresenterBase.A();
        reportEnter();
        e3().addView(this.f205876f0.c(), new RelativeLayout.LayoutParams(-1, -1));
        initTitleBar();
        i3();
        G3();
        D();
        if (!ah.X0()) {
            Intent intent2 = new Intent(this, (Class<?>) WebProcessReceiver.class);
            intent2.setAction(com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.ACTION_DOWNLOAD_TBS);
            sendBroadcast(intent2, "com.tencent.msg.permission.pushnotify");
        }
        init(intent);
        if (!com.tencent.mobileqq.tbstool.gray.b.f291450a.g(this.f205874d0.getFileName())) {
            return;
        }
        FileBrowserPresenterBase fileBrowserPresenterBase2 = this.f205875e0;
        if (fileBrowserPresenterBase2 != null) {
            fileBrowserPresenterBase2.s();
        }
        final long j3 = this.f205873c0.I().nSessionId;
        com.tencent.mobileqq.tbstool.a.f291409a.b(j3, new com.tencent.mobileqq.tbstool.fileview.b() { // from class: com.tencent.mobileqq.filebrowser.b
            @Override // com.tencent.mobileqq.tbstool.fileview.b
            public final void execute(Object obj) {
                FileBrowserActivity.this.u3(j3, (FileManagerEntity) obj);
            }
        });
        ((ITBSToolApi) QRoute.api(ITBSToolApi.class)).startWatchTopActivity(this);
    }

    private void D3(ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList) {
        if (arrayList == null || arrayList.isEmpty() || arrayList.get(0).action == 229) {
            return;
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (arrayList.get(i3).action == 229) {
                ShareActionSheetBuilder.ActionSheetItem actionSheetItem = arrayList.get(i3);
                arrayList.set(i3, arrayList.get(0));
                arrayList.set(0, actionSheetItem);
            }
        }
    }

    private void F3(FileManagerEntity fileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (canAddMenu(fileManagerEntity, actionSheetItem.action)) {
            arrayList.add(actionSheetItem);
        }
    }

    private void U2(Action1<ArrayList<ShareActionSheetBuilder.ActionSheetItem>[]> action1) {
        ThreadManagerV2.excute(new Runnable(action1) { // from class: com.tencent.mobileqq.filebrowser.FileBrowserActivity.15
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Action1 f205894d;

            {
                this.f205894d = action1;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserActivity.this, (Object) action1);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                FileBrowserActivity fileBrowserActivity = FileBrowserActivity.this;
                com.tencent.mobileqq.filebrowser.e eVar = fileBrowserActivity.f205873c0;
                if (!fileBrowserActivity.f205888r0 && eVar != null) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(eVar.U()) { // from class: com.tencent.mobileqq.filebrowser.FileBrowserActivity.15.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ ArrayList[] f205895d;

                        {
                            this.f205895d = r5;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass15.this, (Object) r5);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                AnonymousClass15.this.f205894d.call(this.f205895d);
                            }
                        }
                    });
                }
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z2(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] arrayListArr) {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList;
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = null;
        if (arrayListArr != null) {
            if (arrayListArr.length == 1) {
                arrayList = arrayListArr[0];
            } else if (arrayListArr.length == 2) {
                ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList3 = arrayListArr[0];
                arrayList2 = arrayListArr[1];
                arrayList = arrayList3;
            }
            V2(arrayList2);
            D3(arrayList2);
            if ((arrayList == null && !arrayList.isEmpty()) || (arrayList2 != null && !arrayList2.isEmpty())) {
                this.f205885o0.setActionSheetTitle(this.f205875e0.z() + "(" + q.g(this.f205874d0.getFileSize()) + ")");
                Intent t16 = this.f205873c0.t();
                getIntent().putExtra("big_brother_source_key", f3());
                if (t16 == null) {
                    this.f205885o0.setRowVisibility(8, 0, 0);
                } else {
                    this.f205885o0.setIntentForStartForwardRecentActivity(t16);
                }
                this.f205885o0.setActionSheetItems(arrayList, arrayList2);
                this.f205885o0.setItemClickListenerV2(new e());
                this.f205885o0.show();
                return;
            }
            return;
        }
        arrayList = null;
        V2(arrayList2);
        D3(arrayList2);
        if (arrayList == null) {
        }
    }

    private void b3() {
        com.tencent.mobileqq.filebrowser.e fileModel;
        int intExtra = getIntent().getIntExtra(IFileBrowserService.STRING_BROWSE_ID, 0);
        QLog.d("GeneralFileBrowserActivity", 1, "fixRegisterPhotoCallback browseId: " + intExtra);
        if (intExtra == 0 || (fileModel = ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).getFileModel(intExtra)) == null) {
            return;
        }
        QLog.d("GeneralFileBrowserActivity", 1, "fixRegisterPhotoCallback fileModel: " + fileModel);
        FileManagerEntity I = fileModel.I();
        if (I == null) {
            QLog.d("GeneralFileBrowserActivity", 1, "fixRegisterPhotoCallback entity null");
        } else {
            if (!com.tencent.mobileqq.tbstool.gray.b.f291450a.g(I.fileName)) {
                return;
            }
            FileImporter.f291396a.h(this);
        }
    }

    private boolean canAddMenu(FileManagerEntity fileManagerEntity, int i3) {
        if (fileManagerEntity.nOpType != 58) {
            return true;
        }
        return ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).canAddMenu(fileManagerEntity, i3);
    }

    private int d3() {
        FileManagerEntity I = this.f205873c0.I();
        if (I == null) {
            return -1;
        }
        if (FileUtils.fileExistsAndNotEmpty(I.getFilePath())) {
            return 0;
        }
        if (getString(R.string.mip).equals(ah.j1(I.srvTime, I.peerType))) {
            return 2;
        }
        return 1;
    }

    private String f3() {
        FileManagerEntity I;
        com.tencent.mobileqq.filebrowser.e eVar = this.f205873c0;
        if (eVar == null || (I = eVar.I()) == null || I.nOpType != 58) {
            return "biz_src_jc_file";
        }
        return "biz_src_jc_flash_transfer";
    }

    private int h3() {
        com.tencent.mobileqq.filebrowser.c cVar = this.f205874d0;
        if (cVar != null && com.tencent.mobileqq.tbstool.gray.b.f291450a.g(cVar.getFileName())) {
            return 1;
        }
        return 0;
    }

    private void j3(Intent intent) {
        this.f205887q0 = intent.getIntExtra(IFileBrowserService.STRING_BROWSE_ID, 0);
        QLog.d("GeneralFileBrowserActivity", 1, "initFileModel browseId: " + this.f205887q0);
        if (this.f205887q0 == 0) {
            return;
        }
        com.tencent.mobileqq.filebrowser.e fileModel = ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).getFileModel(this.f205887q0);
        this.f205873c0 = fileModel;
        if (fileModel == null) {
            return;
        }
        fileModel.setActivity(this);
        this.f205873c0.X(this);
        this.f205873c0.I().entrance = this.f205883m0;
        this.f205874d0 = this.f205873c0.d0();
        QLog.d("GeneralFileBrowserActivity", 1, "initFileModel fileModel: " + this.f205873c0 + ", fileAdapter: " + this.f205874d0);
    }

    private void l3() {
        new GestureDetector((Context) null, new a(getResources().getDisplayMetrics().widthPixels / 6)).setIsLongpressEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3(View view) {
        com.tencent.mobileqq.filebrowser.e eVar = this.f205873c0;
        if (eVar == null) {
            return;
        }
        FileManagerEntity I = eVar.I();
        if (!((IPrintApi) QRoute.api(IPrintApi.class)).isSupportOnlinePrint(I.fileName, false) || I.cloudType == 0 || !com.tencent.mobileqq.filemanager.fileviewer.onlineprint.h.f208453a.e("btn_more") || ((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isStudyMode() || ae.h(this.f205873c0.I()) || this.f205889s0 != null) {
            return;
        }
        com.tencent.mobileqq.widget.tip.a f16 = QUIDefaultBubbleTip.r(this).S(view).i0(0.0f, 6.0f).o0(getString(R.string.f174962x_)).k0(1).R(2).m0(1).f(new i());
        this.f205889s0 = f16;
        f16.s0();
    }

    private void p3() {
        com.tencent.mobileqq.filebrowser.c cVar;
        if (this.f205873c0 == null || (cVar = this.f205874d0) == null || !com.tencent.mobileqq.tbstool.gray.b.f291450a.g(cVar.getFileName())) {
            return;
        }
        setTheme(android.R.style.Theme.Black);
    }

    private void r3() {
        this.f205881k0 = (ImageView) findViewById(R.id.d3q);
        ae.g(this.f205879i0);
        ((RelativeLayout) findViewById(R.id.f165675d35)).setVisibility(8);
    }

    private void reportEnter() {
        int intExtra = getIntent().getIntExtra(IFileBrowserService.FILE_BROWSER_PAGE_FROM, 0);
        HashMap hashMap = new HashMap();
        hashMap.put("file_type", Integer.valueOf(this.f205874d0.getFileType()));
        hashMap.put("file_size", Long.valueOf(this.f205874d0.getFileSize()));
        hashMap.put("file_status", this.f205873c0.b0());
        hashMap.put("aio_type", Integer.valueOf(this.f205873c0.i()));
        hashMap.put("viewer_type", Integer.valueOf(h3()));
        hashMap.put(IFileBrowserService.FILE_BROWSER_PAGE_FROM, Integer.valueOf(intExtra));
        hashMap.put("source_appid", Integer.valueOf(d3()));
        hashMap.put("file_name", this.f205874d0.getFileName());
        FileDTReporter.a aVar = new FileDTReporter.a();
        aVar.c(this.f205873c0.y());
        aVar.d(this.f205873c0.A());
        FileDTReporter.a(e3(), aVar, hashMap);
    }

    private void reportExit() {
        if (this.f205873c0 == null) {
            return;
        }
        int intExtra = getIntent().getIntExtra(IFileBrowserService.FILE_BROWSER_PAGE_FROM, 0);
        HashMap hashMap = new HashMap();
        hashMap.put("file_type", Integer.valueOf(this.f205874d0.getFileType()));
        hashMap.put("file_size", Long.valueOf(this.f205874d0.getFileSize()));
        hashMap.put("file_status", this.f205873c0.b0());
        hashMap.put("aio_type", Integer.valueOf(this.f205873c0.i()));
        hashMap.put("viewer_type", Integer.valueOf(h3()));
        hashMap.put(IFileBrowserService.FILE_BROWSER_PAGE_FROM, Integer.valueOf(intExtra));
        hashMap.put("source_appid", Integer.valueOf(d3()));
        hashMap.put("file_name", this.f205874d0.getFileName());
        FileDTReporter.c(e3(), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s() {
        IColorNoteController iColorNoteController = this.f205884n0;
        if (iColorNoteController != null && !iColorNoteController.isColorNoteExist()) {
            if (this.f205884n0.canAddColorNote()) {
                this.f205884n0.insertColorNote();
                return true;
            }
            this.f205884n0.onCannotAdd();
        }
        return false;
    }

    private void s3() {
        TextView textView = (TextView) findViewById(R.id.ivTitleName);
        if (textView == null) {
            return;
        }
        textView.setTextSize(1, 19.0f);
        textView.setOnClickListener(this);
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f205875e0;
        if (fileBrowserPresenterBase == null) {
            return;
        }
        String z16 = fileBrowserPresenterBase.z();
        if (TextUtils.isEmpty(z16)) {
            QLog.i("GeneralFileBrowserActivity", 1, "initTitleText:file name is empty.");
        } else {
            textView.post(new Runnable(textView, z16) { // from class: com.tencent.mobileqq.filebrowser.FileBrowserActivity.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ TextView f205898d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f205899e;

                {
                    this.f205898d = textView;
                    this.f205899e = z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, FileBrowserActivity.this, textView, z16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    this.f205898d.setText(TextUtils.ellipsize(this.f205899e, this.f205898d.getPaint(), this.f205898d.getMeasuredWidth() - 15, TextUtils.TruncateAt.END));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t2() {
        IColorNoteController iColorNoteController = this.f205884n0;
        if (iColorNoteController != null && iColorNoteController.isColorNoteExist()) {
            this.f205884n0.deleteColorNote();
        }
    }

    private boolean t3() {
        boolean z16 = this.f205877g0.getBoolean("tdoc_enable", false);
        String lowerCase = FileUtils.getExtension(this.f205874d0.getFilePath()).toLowerCase();
        if (!((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).checkFileExist(this.f205874d0.getFilePath()) || !z16 || !((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).isTDocPreviewEnable(lowerCase)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u3(long j3, FileManagerEntity fileManagerEntity) {
        com.tencent.mobileqq.tbstool.a.f291409a.c(j3);
        fileManagerEntity.entrance = this.f205883m0;
        com.tencent.mobileqq.filebrowser.e eVar = this.f205873c0;
        if (eVar != null) {
            eVar.d(fileManagerEntity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v3(View view) {
        bc.f209377a.a(view, new l(view));
        com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f205874d0.getFileName()).d(this);
    }

    private void w3(Action1<Boolean> action1) {
        ThreadManagerV2.excute(new Runnable(action1) { // from class: com.tencent.mobileqq.filebrowser.FileBrowserActivity.13
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Action1 f205891d;

            {
                this.f205891d = action1;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserActivity.this, (Object) action1);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(FileBrowserActivity.this.x3()) { // from class: com.tencent.mobileqq.filebrowser.FileBrowserActivity.13.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f205892d;

                        {
                            this.f205892d = r6;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass13.this, Boolean.valueOf(r6));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                AnonymousClass13.this.f205891d.call(Boolean.valueOf(this.f205892d));
                            }
                        }
                    });
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x3() {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList;
        if (getIntent().getIntExtra("key_source", 0) == 1 || this.f205883m0 == 21) {
            return false;
        }
        com.tencent.mobileqq.filebrowser.e eVar = this.f205873c0;
        if (this.f205888r0 || eVar == null) {
            return false;
        }
        FileManagerEntity I = eVar.I();
        if (I != null && I.nOpType == 58 && !FileUtils.fileExists(I.strFilePath)) {
            return false;
        }
        ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] U = eVar.U();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = null;
        if (U != null) {
            if (U.length == 1) {
                arrayList2 = U[0];
                arrayList = null;
            } else if (U.length == 2) {
                arrayList2 = U[0];
                arrayList = U[1];
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

    private void y3(boolean z16) {
        if (com.tencent.mobileqq.tbstool.gray.b.f291450a.g(this.f205874d0.getFileName())) {
            return;
        }
        RelativeLayout g36 = g3();
        if (z16) {
            g36.setVisibility(4);
        } else {
            g36.setVisibility(0);
        }
    }

    private void z3() {
        int g16 = ae.g(this.f205879i0);
        if (g16 == -1) {
            return;
        }
        ImageView imageView = this.f205881k0;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.f205873c0.q(this, g16, this.f205878h0);
    }

    @Override // com.tencent.mobileqq.filebrowser.d, com.tencent.mobileqq.filebrowser.e.c
    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            b1(false);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.d
    public void C0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (com.tencent.mobileqq.tbstool.gray.b.f291450a.g(this.f205874d0.getFileName())) {
            View view = this.f205890t0;
            if (view != null) {
                n3(view);
                return;
            }
            return;
        }
        n3(findViewById(R.id.ivTitleBtnRightImage));
    }

    @Override // com.tencent.mobileqq.filebrowser.d
    @TargetApi(14)
    public void D() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            String configuration = getResources().getConfiguration().toString();
            if (!configuration.contains("hwMultiwindow-magic") && !configuration.contains("hw-magic-windows")) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.iep);
                relativeLayout.setFitsSystemWindows(true);
                relativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
            }
        }
    }

    void E3() {
        if (this.f205873c0 == null) {
            return;
        }
        if (this.f205885o0 == null) {
            ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
            param.context = this;
            FileManagerEntity I = this.f205873c0.I();
            if (I != null && I.nOpType == 58 && FileUtils.fileExists(I.strFilePath)) {
                param.deReportParams = new HashMap();
            }
            this.f205885o0 = ShareActionSheetFactory.create(param);
        }
        this.f205885o0.setRowVisibility(0, 0, 0);
        U2(new d());
    }

    void G3() {
        this.f205884n0.setServiceInfo(this.f205873c0.z());
        if (c3() != 0) {
            this.f205884n0.enablePostTable();
        } else {
            this.f205884n0.disablePostTable();
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.d
    public void S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            E3();
        }
    }

    void V2(ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList) {
        int i3;
        FileManagerEntity fileManagerEntity;
        if (arrayList == null) {
            QLog.e("GeneralFileBrowserActivity", 1, "checkAddColorMenuItem menusList is null!");
            return;
        }
        int c36 = c3();
        if (c36 != 0 && shouldDisplayColorNote()) {
            if (c36 == 2) {
                i3 = 82;
            } else {
                i3 = 70;
            }
            ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(i3);
            build.iconNeedBg = true;
            build.argus = "";
            build.listener = new c(c36);
            com.tencent.mobileqq.filebrowser.e eVar = this.f205873c0;
            if (eVar != null) {
                fileManagerEntity = eVar.I();
            } else {
                fileManagerEntity = null;
            }
            F3(fileManagerEntity, arrayList, build);
        }
    }

    public void W2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
            return;
        }
        switch (i3) {
            case 1:
                if (t3()) {
                    this.f205875e0 = new TDocFilePresenter(this.f205873c0, this);
                    break;
                } else {
                    B3();
                }
            case 2:
            case 6:
            default:
                this.f205875e0 = new DocFilePresenter(this.f205873c0, this);
                break;
            case 3:
                this.f205875e0 = new com.tencent.mobileqq.filebrowser.presenter.a(this.f205873c0, this);
                break;
            case 4:
                this.f205875e0 = new MusicFilePresenter(this.f205873c0, this);
                break;
            case 5:
                this.f205875e0 = new ZipFilePresenter(this.f205873c0, this);
                break;
            case 7:
                this.f205875e0 = new n(this.f205873c0, this);
                break;
            case 8:
                this.f205875e0 = new o(this.f205873c0, this);
                break;
            case 9:
                this.f205875e0 = new m(this.f205873c0, this);
                break;
            case 10:
                this.f205875e0 = new DocExportFilePresenter(this.f205873c0, this);
                break;
            case 11:
                this.f205875e0 = new com.tencent.mobileqq.filebrowser.presenter.b(this.f205873c0, this);
                break;
        }
        this.f205875e0.N(this.f205877g0);
        this.f205875e0.O(this);
        this.f205875e0.H();
    }

    public void Y2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        com.tencent.mobileqq.widget.tip.a aVar = this.f205889s0;
        if (aVar != null) {
            aVar.o();
        }
        this.f205889s0 = null;
    }

    @Override // com.tencent.mobileqq.filebrowser.d
    public void b(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
            return;
        }
        RelativeLayout g36 = g3();
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        g36.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.filebrowser.d
    public void b1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            if (isFinishing()) {
                return;
            }
            ThreadManager.getUIHandler().post(new Runnable(z16) { // from class: com.tencent.mobileqq.filebrowser.FileBrowserActivity.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f205897d;

                {
                    this.f205897d = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FileBrowserActivity.this, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        FileBrowserActivity.this.A3(this.f205897d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    int c3() {
        int c16;
        int fileType = this.f205874d0.getFileType();
        if (fileType == 0 || fileType == 2 || fileType == 13 || (c16 = this.f205874d0.c()) == 16) {
            return 0;
        }
        if ((this.f205874d0.a() == 0 || this.f205874d0.a() == 52) && (c16 == 0 || c16 == 3 || c16 == 2)) {
            return 0;
        }
        if (q.f(this.f205874d0.getFilePath())) {
            if (g2()) {
                return 2;
            }
            return 1;
        }
        if (TextUtils.isEmpty(this.f205874d0.getUuid()) && TextUtils.isEmpty(this.f205874d0.getFileId())) {
            return 0;
        }
        if (g2()) {
            return 2;
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.filebrowser.d
    public void d(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) view);
            return;
        }
        this.f205890t0 = view;
        com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f205874d0.getFileName()).h(this, this.f205874d0.getSessionId());
        w3(new k(view));
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f205875e0;
        if (fileBrowserPresenterBase != null) {
            fileBrowserPresenterBase.K(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) configuration);
            return;
        }
        super.doOnConfigurationChanged(configuration);
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f205875e0;
        if (fileBrowserPresenterBase == null) {
            return;
        }
        fileBrowserPresenterBase.L(configuration);
        Y2();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle)).booleanValue();
        }
        QLog.d("GeneralFileBrowserActivity", 1, "doOnCreate");
        getWindow().setSoftInputMode(48);
        j3(getIntent());
        p3();
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = true;
        LiuHaiUtils.initLiuHaiProperty(this);
        LiuHaiUtils.enableNotch(this);
        ca.a(this);
        super.doOnCreate(bundle);
        C3();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.doOnDestroy();
        QLog.d("GeneralFileBrowserActivity", 1, "doOnDestroy");
        this.f205888r0 = true;
        Y2();
        reportExit();
        if (QLog.isColorLevel() && !isFinishing()) {
            QLog.i("GeneralFileBrowserActivity", 2, "FileBrowserActivity is called doOnDestroy But not finished!");
        }
        if (this.f205884n0 != null) {
            if (c3() != 0) {
                this.f205884n0.addHistoryNote();
            }
            this.f205884n0.onDestroy();
        }
        com.tencent.mobileqq.filebrowser.e eVar = this.f205873c0;
        if (eVar != null) {
            com.tencent.mobileqq.tbstool.a.f291409a.c(eVar.I().nSessionId);
            this.f205873c0.doOnDestroy();
            this.f205873c0 = null;
            ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).onDestroy(this.f205887q0);
        }
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f205875e0;
        if (fileBrowserPresenterBase != null) {
            fileBrowserPresenterBase.t();
            this.f205875e0 = null;
        }
        if (this.f205876f0 != null) {
            this.f205876f0 = null;
        }
        FileImporter.f291396a.i();
        ((ITBSToolApi) QRoute.api(ITBSToolApi.class)).stopWatchTopActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        AbstractGifImage.pauseAll();
        ApngImage.pauseAll();
        com.tencent.mobileqq.filebrowser.e eVar = this.f205873c0;
        if (eVar != null) {
            eVar.doOnPause();
        }
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f205875e0;
        if (fileBrowserPresenterBase != null) {
            fileBrowserPresenterBase.u();
        }
        BaseQQAppInterface baseQQAppInterface = this.f205872b0;
        if (baseQQAppInterface != null) {
            ((IMessageFacade) baseQQAppInterface.getRuntimeService(IMessageFacade.class)).deleteObserver(this.f205871a0);
        }
        IColorNoteController iColorNoteController = this.f205884n0;
        if (iColorNoteController != null) {
            iColorNoteController.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        AbstractGifImage.resumeAll();
        ApngImage.playByTag(0);
        com.tencent.mobileqq.filebrowser.e eVar = this.f205873c0;
        if (eVar != null) {
            eVar.doOnResume();
        }
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f205875e0;
        if (fileBrowserPresenterBase != null) {
            fileBrowserPresenterBase.v();
        }
        BaseQQAppInterface baseQQAppInterface = this.f205872b0;
        if (baseQQAppInterface != null) {
            ((IMessageFacade) baseQQAppInterface.getRuntimeService(IMessageFacade.class)).addObserver(this.f205871a0);
        }
        IColorNoteController iColorNoteController = this.f205884n0;
        if (iColorNoteController != null) {
            iColorNoteController.onResume();
        }
        super.doOnResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.doOnStart();
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f205875e0;
        if (fileBrowserPresenterBase != null) {
            fileBrowserPresenterBase.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnStop();
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f205875e0;
        if (fileBrowserPresenterBase != null) {
            fileBrowserPresenterBase.x();
        }
    }

    public RelativeLayout e3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return (RelativeLayout) findViewById(R.id.c_o);
    }

    @Override // com.tencent.mobileqq.filebrowser.d
    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
            return;
        }
        y3(z16);
        RelativeLayout e36 = e3();
        if (z16) {
            if (ImmersiveUtils.isSupporImmersive() == 1 && SystemBarActivityModule.getSystemBarComp(this) != null) {
                SystemBarActivityModule.getSystemBarComp(this).setStatusColor(0);
                SystemBarActivityModule.getSystemBarComp(this).setStatusBarColor(0);
                if (ThemeUtil.isDefaultOrDIYTheme(false)) {
                    SystemBarActivityModule.getSystemBarComp(this).setStatusBarDrawable(null);
                }
            }
            e36.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            LiuHaiUtils.resetFullScreen(this);
            getWindow().setFlags(1024, 1024);
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) e36.getLayoutParams();
        layoutParams.addRule(3, R.id.ibf);
        e36.setLayoutParams(layoutParams);
        if (ImmersiveUtils.isSupporImmersive() == 1 && SystemBarActivityModule.getSystemBarComp(this) != null) {
            int color = getResources().getColor(R.color.qui_common_bg_nav_secondary);
            SystemBarActivityModule.getSystemBarComp(this).setStatusColor(color);
            SystemBarActivityModule.getSystemBarComp(this).setStatusBarColor(color);
            if (ThemeUtil.isDefaultOrDIYTheme(false)) {
                SystemBarActivityModule.getSystemBarComp(this).setStatusBarDrawable(getResources().getDrawable(R.drawable.qui_bg_nav_secondary));
            }
        }
        LiuHaiUtils.closeFullScreen(this);
        getWindow().setFlags(0, 1024);
    }

    boolean g2() {
        IColorNoteController iColorNoteController = this.f205884n0;
        if (iColorNoteController != null) {
            return iColorNoteController.isColorNoteExist();
        }
        return false;
    }

    RelativeLayout g3() {
        return (RelativeLayout) findViewById(R.id.ibf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public IActivityModuleProvider getActivityModuleProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IActivityModuleProvider) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new g();
    }

    void i3() {
        IColorNoteController iColorNoteController = (IColorNoteController) QRoute.api(IColorNoteController.class);
        this.f205884n0 = iColorNoteController;
        iColorNoteController.init(this, !com.tencent.mobileqq.tbstool.gray.b.f291450a.g(this.f205874d0.getFileName()), true);
        this.f205884n0.setServiceInfo(this.f205873c0.z());
        this.f205884n0.attachToActivity(this);
        this.f205884n0.setOnColorNoteAnimFinishListener(new b());
    }

    public void initTitleBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        ((TextView) findViewById(R.id.dto)).setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R.id.ivTitleBtnRightImage);
        this.f205882l0 = imageView;
        imageView.setImageResource(R.drawable.header_btn_more);
        this.f205882l0.setVisibility(8);
        this.f205882l0.setContentDescription(getString(R.string.zz6));
        this.f205882l0.setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        textView.setOnClickListener(this);
        if (TokenResUtils.useTokenRes3()) {
            textView.setBackgroundResource(R.drawable.qui_chevron_left_icon_navigation_01_selector);
            int dip2px = ViewUtils.dip2px(24.0f);
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            textView.setMinWidth(dip2px);
            layoutParams.width = dip2px;
            layoutParams.height = dip2px;
            this.f205882l0.setImageResource(R.drawable.qui_more_icon_navigation_01_selector);
        }
        s3();
        r3();
        w3(new h());
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f205875e0;
        if (fileBrowserPresenterBase != null) {
            fileBrowserPresenterBase.r();
            if (com.tencent.mobileqq.tbstool.gray.b.f291450a.g(this.f205874d0.getFileName()) && this.f205875e0.q(this)) {
                return true;
            }
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ivTitleBtnRightImage) {
                if (this.f205886p0.c(1000L)) {
                    QLog.d("GeneralFileBrowserActivity", 1, "show menu fast click forbid");
                } else {
                    E3();
                    com.tencent.mobileqq.filemanager.fileviewer.onlineprint.h.f208453a.c("btn_more");
                }
            } else if (id5 == R.id.ivTitleBtnLeft) {
                onBackEvent();
            } else if (id5 == R.id.head) {
                z3();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        QLog.d("GeneralFileBrowserActivity", 1, "onCreate ");
        b3();
    }

    @Override // com.tencent.mobileqq.filebrowser.e.c
    public void onFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            finish();
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        FileBrowserPresenterBase fileBrowserPresenterBase = this.f205875e0;
        if (fileBrowserPresenterBase != null) {
            fileBrowserPresenterBase.y();
        }
    }

    boolean shouldDisplayColorNote() {
        IColorNoteController iColorNoteController = this.f205884n0;
        if (iColorNoteController != null) {
            return iColorNoteController.shouldDisplayColorNote();
        }
        return false;
    }
}
