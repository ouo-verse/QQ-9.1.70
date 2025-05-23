package com.tencent.mobileqq.filebrowser.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.filemanageraux.widget.DocCooperationBanner;
import com.tencent.mobileqq.filemanageraux.widget.DocQBBottomView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.DocsVipInfoManager;
import com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.u;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.TbsReaderView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class DocFileBrowserView extends SimpleFileBrowserView {
    static IPatchRedirector $redirector_;
    static final /* synthetic */ boolean I;
    private TbsReaderView A;
    RelativeLayout B;
    private View C;
    private DocQBBottomView D;
    private QQProgressDialog E;
    private k F;
    private View G;
    private boolean H;

    /* renamed from: y, reason: collision with root package name */
    public DocCooperationBanner f206057y;

    /* renamed from: z, reason: collision with root package name */
    public com.tencent.mobileqq.filemanageraux.widget.a f206058z;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filebrowser.view.DocFileBrowserView$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ DocFileBrowserView this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                DocFileBrowserView.super.y();
                this.this$0.A = null;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filebrowser.view.DocFileBrowserView$5, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass5 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TeamWorkFileImportInfo f206065d;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filebrowser.view.DocFileBrowserView$5$a */
        /* loaded from: classes12.dex */
        class a implements ITencentDocConvertABTestUtil.a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AppInterface f206066a;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.filebrowser.view.DocFileBrowserView$5$a$a, reason: collision with other inner class name */
            /* loaded from: classes12.dex */
            class C7523a implements u.e {
                static IPatchRedirector $redirector_;

                C7523a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                    }
                }

                @Override // com.tencent.mobileqq.teamwork.u.e
                public void a(QQProgressDialog qQProgressDialog) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        DocFileBrowserView.this.E = qQProgressDialog;
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQProgressDialog);
                    }
                }
            }

            a(AppInterface appInterface) {
                this.f206066a = appInterface;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this, (Object) appInterface);
                }
            }

            @Override // com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil.a
            public void a(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3);
                    return;
                }
                if (i3 != 1) {
                    if (i3 == 2) {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        DocFileBrowserView.this.l0(this.f206066a, anonymousClass5.f206065d);
                        return;
                    }
                    return;
                }
                AppInterface appInterface = this.f206066a;
                AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                u.r(appInterface, DocFileBrowserView.this.f206085b, "SimpleFileBrowserView", anonymousClass52.f206065d, new C7523a());
            }

            @Override // com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil.a
            public void b(ImageView imageView) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    DocFileBrowserView.this.G = imageView;
                } else {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) imageView);
                }
            }
        }

        AnonymousClass5(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            this.f206065d = teamWorkFileImportInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DocFileBrowserView.this, (Object) teamWorkFileImportInfo);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (DocFileBrowserView.this.C != null) {
                DocFileBrowserView.this.C.setVisibility(0);
                return;
            }
            DocFileBrowserView docFileBrowserView = DocFileBrowserView.this;
            RelativeLayout relativeLayout = docFileBrowserView.B;
            if (relativeLayout != null) {
                docFileBrowserView.C = docFileBrowserView.Y(relativeLayout);
                AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
                ReportController.o(null, "dc00898", "", "", "0X8009064", "0X8009064", 0, 0, "", "", "", "");
                ITencentDocConvertABTestUtil iTencentDocConvertABTestUtil = (ITencentDocConvertABTestUtil) QRoute.api(ITencentDocConvertABTestUtil.class);
                DocFileBrowserView docFileBrowserView2 = DocFileBrowserView.this;
                iTencentDocConvertABTestUtil.configureABTest(appInterface, docFileBrowserView2.f206085b, docFileBrowserView2.C, this.f206065d, new a(appInterface));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filebrowser.view.DocFileBrowserView$7, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass7 implements DocsVipInfoManager.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f206069a;

        AnonymousClass7(String str) {
            this.f206069a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DocFileBrowserView.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.DocsVipInfoManager.b
        public void a(Map<String, Object> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
            } else {
                map.put(TagName.FILE_TYPE, this.f206069a);
                DocFileBrowserView.this.f206085b.runOnUiThread(new Runnable(map) { // from class: com.tencent.mobileqq.filebrowser.view.DocFileBrowserView.7.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Map f206071d;

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.filebrowser.view.DocFileBrowserView$7$1$a */
                    /* loaded from: classes12.dex */
                    class a implements k.d {
                        static IPatchRedirector $redirector_;

                        a() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // com.tencent.mobileqq.widget.k.d
                        public void a(String str) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                            } else {
                                DocFileBrowserView.g0(DocFileBrowserView.this.f206085b, str);
                                DocFileBrowserView.this.F.dismiss();
                            }
                        }
                    }

                    {
                        this.f206071d = map;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this, (Object) map);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (DocFileBrowserView.this.F == null) {
                            DocFileBrowserView.this.F = new k(DocFileBrowserView.this.f206085b, this.f206071d, "qqlocalbar");
                            DocFileBrowserView.this.F.setCancelable(false);
                        }
                        DocFileBrowserView.this.F.S(new a());
                        if (!DocFileBrowserView.this.F.isShowing()) {
                            DocFileBrowserView.this.F.show();
                        }
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class GestureRelativeLayout extends RelativeLayout {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final GestureDetector f206074d;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a extends GestureDetector.SimpleOnGestureListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ DocFileBrowserView f206076d;

            a(DocFileBrowserView docFileBrowserView) {
                this.f206076d = docFileBrowserView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GestureRelativeLayout.this, (Object) docFileBrowserView);
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
                }
                if (Math.abs(f17) <= Math.abs(f16)) {
                    return false;
                }
                View a06 = DocFileBrowserView.this.a0();
                if (f17 > 0.0f) {
                    if (a06 != null) {
                        a06.setVisibility(8);
                    }
                    DocCooperationBanner docCooperationBanner = DocFileBrowserView.this.f206057y;
                    if (docCooperationBanner != null) {
                        docCooperationBanner.b(true);
                    }
                    com.tencent.mobileqq.filemanageraux.widget.a aVar = DocFileBrowserView.this.f206058z;
                    if (aVar != null) {
                        aVar.c(true);
                    }
                } else {
                    if (a06 != null) {
                        a06.setVisibility(0);
                    }
                    DocCooperationBanner docCooperationBanner2 = DocFileBrowserView.this.f206057y;
                    if (docCooperationBanner2 != null) {
                        docCooperationBanner2.e(true);
                    }
                    com.tencent.mobileqq.filemanageraux.widget.a aVar2 = DocFileBrowserView.this.f206058z;
                    if (aVar2 != null) {
                        aVar2.g(true);
                    }
                }
                return true;
            }
        }

        public GestureRelativeLayout(DocFileBrowserView docFileBrowserView, Context context) {
            this(context, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) docFileBrowserView, (Object) context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
            }
            GestureDetector gestureDetector = this.f206074d;
            if (gestureDetector != null) {
                gestureDetector.onTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        public GestureRelativeLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f206074d = new GestureDetector(context, new a(DocFileBrowserView.this));
            } else {
                iPatchRedirector.redirect((short) 2, this, DocFileBrowserView.this, context, attributeSet);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f206078d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TeamWorkFileImportInfo f206079e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f206080f;

        a(AppInterface appInterface, TeamWorkFileImportInfo teamWorkFileImportInfo, ActionSheet actionSheet) {
            this.f206078d = appInterface;
            this.f206079e = teamWorkFileImportInfo;
            this.f206080f = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DocFileBrowserView.this, appInterface, teamWorkFileImportInfo, actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
            } else if (i3 == 0) {
                u.j(this.f206078d, DocFileBrowserView.this.f206085b, "SimpleFileBrowserView", this.f206079e);
                this.f206080f.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements DocQBBottomView.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DocFileBrowserView.this);
            }
        }

        @Override // com.tencent.mobileqq.filemanageraux.widget.DocQBBottomView.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                DocFileBrowserView.this.c0();
            }
        }

        @Override // com.tencent.mobileqq.filemanageraux.widget.DocQBBottomView.a
        public void b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                DocFileBrowserView.this.n0(str);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30766);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            I = true;
        }
    }

    public DocFileBrowserView(Activity activity, String str) {
        super(activity, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) str);
        } else {
            this.H = true;
        }
    }

    private void X(View view, int i3) {
        this.B.addView(view, i3, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View Y(ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) this.f206085b.getSystemService("layout_inflater");
        if (layoutInflater == null) {
            return null;
        }
        View inflate = layoutInflater.inflate(R.layout.amg, viewGroup, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ((ITencentDocConvertABTestUtil) QRoute.api(ITencentDocConvertABTestUtil.class)).calcHeightLayoutParam((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)));
        layoutParams.addRule(12);
        inflate.setLayoutParams(layoutParams);
        viewGroup.addView(inflate);
        return inflate;
    }

    public static void g0(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("isShowAd", false);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    private void h0() {
        ViewGroup viewGroup = (ViewGroup) this.f206084a.getParent();
        if (viewGroup != null && this.B != null) {
            viewGroup.removeAllViews();
            viewGroup.addView(this.B, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public View Z(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (View) iPatchRedirector.redirect((short) 14, (Object) this, (Object) teamWorkFileImportInfo);
        }
        if (this.D == null) {
            DocQBBottomView docQBBottomView = new DocQBBottomView(this.f206085b, new b());
            this.D = docQBBottomView;
            docQBBottomView.setTeamWorkFileImportInfo(teamWorkFileImportInfo);
            this.D.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        return this.D;
    }

    public View a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (View) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.C;
    }

    public void b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        View view = this.C;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.E;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.E.dismiss();
        }
    }

    void d0(String str, long j3, LocalTbsViewManager.e eVar) {
        this.A = com.tencent.mobileqq.tbstool.gray.b.f291450a.e(str).f(this.f206085b, str, j3, eVar);
        QLog.d("SimpleFileBrowserView", 1, "initTbsView curview:" + this.A);
        k0(null, this.A);
        h0();
    }

    public boolean e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        RelativeLayout relativeLayout = this.B;
        if (relativeLayout != null && this.C != null && relativeLayout.getVisibility() == 0 && this.C.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void f0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.H = z16;
        }
    }

    public void i0(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        TbsReaderView tbsReaderView = this.A;
        if (tbsReaderView != null) {
            tbsReaderView.onSizeChanged(i3, i16);
        }
    }

    public void j0(String str, long j3, LocalTbsViewManager.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Long.valueOf(j3), eVar);
        } else {
            ThreadManager.getUIHandler().post(new Runnable(str, j3, eVar) { // from class: com.tencent.mobileqq.filebrowser.view.DocFileBrowserView.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f206059d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f206060e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ LocalTbsViewManager.e f206061f;

                {
                    this.f206059d = str;
                    this.f206060e = j3;
                    this.f206061f = eVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DocFileBrowserView.this, str, Long.valueOf(j3), eVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        DocFileBrowserView.this.d0(this.f206059d, this.f206060e, this.f206061f);
                    }
                }
            });
        }
    }

    boolean k0(View view, View view2) {
        int i3 = 0;
        if (view2 == null) {
            return false;
        }
        if (view != null && view.hashCode() == view2.hashCode()) {
            return false;
        }
        if (view2.getParent() != null) {
            ((ViewGroup) view2.getParent()).removeAllViews();
        }
        RelativeLayout relativeLayout = this.B;
        if (relativeLayout == null) {
            if (!I && view != null) {
                throw new AssertionError();
            }
            this.B = new GestureRelativeLayout(this, this.f206085b);
        } else {
            if (view == null) {
                X(view2, 0);
                return false;
            }
            int indexOfChild = relativeLayout.indexOfChild(view);
            if (indexOfChild < 0) {
                X(view2, indexOfChild);
                return false;
            }
            this.B.removeView(view);
            i3 = indexOfChild;
        }
        X(view2, i3);
        return true;
    }

    void l0(AppInterface appInterface, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        String string = this.f206085b.getString(R.string.awg);
        String string2 = this.f206085b.getString(R.string.aw_);
        List<ta1.h> wordingConfig = ((ITencentDocConvertABTestUtil) QRoute.api(ITencentDocConvertABTestUtil.class)).getWordingConfig();
        if (wordingConfig != null && wordingConfig.size() == 2) {
            if (this.H) {
                for (ta1.h hVar : wordingConfig) {
                    if (hVar.i() == 0 && !TextUtils.isEmpty(hVar.g()) && !TextUtils.isEmpty(hVar.h())) {
                        string = hVar.g();
                        string2 = hVar.h();
                    }
                }
            } else {
                for (ta1.h hVar2 : wordingConfig) {
                    if (hVar2.i() == 1 && !TextUtils.isEmpty(hVar2.g()) && !TextUtils.isEmpty(hVar2.h())) {
                        string = hVar2.g();
                        string2 = hVar2.h();
                    }
                }
            }
        }
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.f206085b, null);
        actionSheet.setMainTitle(string);
        actionSheet.addButton(string2, 5);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new a(appInterface, teamWorkFileImportInfo, actionSheet));
        actionSheet.show();
    }

    public void m0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            if (this.f206085b.isFinishing()) {
                return;
            }
            DocsVipInfoManager.c();
            DocsVipInfoManager.f(new AnonymousClass7(str));
        }
    }

    public void n0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
            return;
        }
        if (this.f206085b.isFinishing()) {
            return;
        }
        if (this.E == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this.f206085b);
            this.E = qQProgressDialog;
            qQProgressDialog.setCancelable(false);
        }
        if (!this.E.isShowing()) {
            this.E.setMessage(str);
            this.E.show();
        }
    }

    public void o0(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) teamWorkFileImportInfo);
        } else {
            if (teamWorkFileImportInfo == null) {
                return;
            }
            teamWorkFileImportInfo.J = 3;
            ThreadManager.getUIHandler().post(new AnonymousClass5(teamWorkFileImportInfo));
        }
    }

    public void p0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        TbsReaderView tbsReaderView = this.A;
        if (tbsReaderView != null) {
            tbsReaderView.onStop();
        }
        DocQBBottomView docQBBottomView = this.D;
        if (docQBBottomView != null) {
            docQBBottomView.k();
        }
    }

    public void q0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        DocQBBottomView docQBBottomView = this.D;
        if (docQBBottomView != null) {
            docQBBottomView.q(i3);
        }
    }

    public void r0(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, obj);
            return;
        }
        DocQBBottomView docQBBottomView = this.D;
        if (docQBBottomView != null) {
            docQBBottomView.r(str, obj);
        }
    }

    public void s0(String str, long j3, LocalTbsViewManager.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Long.valueOf(j3), eVar);
        } else {
            ThreadManager.getUIHandler().post(new Runnable(str, j3, eVar) { // from class: com.tencent.mobileqq.filebrowser.view.DocFileBrowserView.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f206062d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f206063e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ LocalTbsViewManager.e f206064f;

                {
                    this.f206062d = str;
                    this.f206063e = j3;
                    this.f206064f = eVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DocFileBrowserView.this, str, Long.valueOf(j3), eVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        DocFileBrowserView.this.t0(this.f206062d, this.f206063e, this.f206064f);
                    }
                }
            });
        }
    }

    void t0(String str, long j3, LocalTbsViewManager.e eVar) {
        TbsReaderView f16 = com.tencent.mobileqq.tbstool.gray.b.f291450a.e(str).f(this.f206085b, str, j3, eVar);
        QLog.d("SimpleFileBrowserView", 1, "updateTbsView oldview:" + this.A + ", newview:" + f16);
        View view = this.A;
        if (view != null && k0(view, f16)) {
            this.A.onStop();
            this.A = f16;
        }
    }

    public void u0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        View view = this.G;
        if (view != null) {
            if (i3 > 0) {
                i16 = 0;
            }
            view.setVisibility(i16);
        }
    }
}
