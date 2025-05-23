package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.ae;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanageraux.widget.DocQBBottomView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.u;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.tbs.reader.TbsReaderView;
import com.tencent.util.pm.PackageUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SimpleFileViewer extends com.tencent.mobileqq.filemanager.fileviewer.viewer.a {
    private TextView H;
    private View I;
    private View J;
    private TbsReaderView K;
    private RelativeLayout L;
    private LinearLayout M;
    private LinearLayout N;
    private TextView P;
    private TextView Q;
    private TextView R;
    private TextView S;
    private TextView T;
    private TextView U;
    private TextView V;
    private AsyncImageView W;
    private View X;
    private DocQBBottomView Y;
    private QQProgressDialog Z;

    /* renamed from: a0, reason: collision with root package name */
    private View f208546a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f208547b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f208548c0;

    /* renamed from: d0, reason: collision with root package name */
    protected String f208549d0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer$3, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TeamWorkFileImportInfo f208551d;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer$3$a */
        /* loaded from: classes12.dex */
        class a implements ITencentDocConvertABTestUtil.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f208552a;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer$3$a$a, reason: collision with other inner class name */
            /* loaded from: classes12.dex */
            class C7578a implements u.e {
                C7578a() {
                }

                @Override // com.tencent.mobileqq.teamwork.u.e
                public void a(QQProgressDialog qQProgressDialog) {
                    SimpleFileViewer.this.Z = qQProgressDialog;
                }
            }

            a(QQAppInterface qQAppInterface) {
                this.f208552a = qQAppInterface;
            }

            @Override // com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil.a
            public void a(int i3) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        SimpleFileViewer.this.g0(this.f208552a, anonymousClass3.f208551d);
                        return;
                    }
                    return;
                }
                QQAppInterface qQAppInterface = this.f208552a;
                AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                u.r(qQAppInterface, SimpleFileViewer.this.f208607f, "SimpleFileViewer", anonymousClass32.f208551d, new C7578a());
            }

            @Override // com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil.a
            public void b(ImageView imageView) {
                SimpleFileViewer.this.f208546a0 = imageView;
            }
        }

        AnonymousClass3(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            this.f208551d = teamWorkFileImportInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SimpleFileViewer.this.X != null) {
                SimpleFileViewer.this.X.setVisibility(0);
                return;
            }
            if (SimpleFileViewer.this.L != null && SimpleFileViewer.this.J != null && (BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
                LayoutInflater layoutInflater = (LayoutInflater) BaseApplication.getContext().getSystemService("layout_inflater");
                if (layoutInflater != null) {
                    SimpleFileViewer simpleFileViewer = SimpleFileViewer.this;
                    simpleFileViewer.X = layoutInflater.inflate(R.layout.amg, (ViewGroup) simpleFileViewer.L, false);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ((ITencentDocConvertABTestUtil) QRoute.api(ITencentDocConvertABTestUtil.class)).calcHeightLayoutParam(qQAppInterface));
                    layoutParams.addRule(12);
                    SimpleFileViewer.this.X.setLayoutParams(layoutParams);
                    SimpleFileViewer.this.L.addView(SimpleFileViewer.this.X);
                    ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009064", "0X8009064", 0, 0, "", "", "", "");
                    ITencentDocConvertABTestUtil iTencentDocConvertABTestUtil = (ITencentDocConvertABTestUtil) QRoute.api(ITencentDocConvertABTestUtil.class);
                    SimpleFileViewer simpleFileViewer2 = SimpleFileViewer.this;
                    iTencentDocConvertABTestUtil.configureABTest(qQAppInterface, simpleFileViewer2.f208607f, simpleFileViewer2.X, this.f208551d, new a(qQAppInterface));
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer$4, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ SimpleFileViewer this$0;

        @Override // java.lang.Runnable
        public void run() {
            SimpleFileViewer simpleFileViewer = this.this$0;
            if (simpleFileViewer.f208606e != simpleFileViewer.I) {
                SimpleFileViewer simpleFileViewer2 = this.this$0;
                simpleFileViewer2.f208606e = simpleFileViewer2.I;
            }
            if (this.this$0.L != null) {
                this.this$0.L.removeAllViews();
                this.this$0.L = null;
            }
            this.this$0.J = null;
            this.this$0.K = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class GestureRelativeLayout extends RelativeLayout {

        /* renamed from: d, reason: collision with root package name */
        private GestureDetector f208561d;

        public GestureRelativeLayout(SimpleFileViewer simpleFileViewer, Context context) {
            this(context, null);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            GestureDetector gestureDetector = this.f208561d;
            if (gestureDetector != null) {
                gestureDetector.onTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        public GestureRelativeLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f208561d = new GestureDetector(context, new a());
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        private class a implements GestureDetector.OnGestureListener {
            a() {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                if (Math.abs(f17) > Math.abs(f16)) {
                    View J = SimpleFileViewer.this.J();
                    if (f17 > 0.0f) {
                        if (J != null) {
                            J.setVisibility(8);
                        }
                    } else if (f17 < 0.0f && J != null) {
                        J.setVisibility(0);
                    }
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements DocQBBottomView.a {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanageraux.widget.DocQBBottomView.a
        public void a() {
            SimpleFileViewer.this.L();
        }

        @Override // com.tencent.mobileqq.filemanageraux.widget.DocQBBottomView.a
        public void b(String str) {
            SimpleFileViewer.this.k0(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f208565d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TeamWorkFileImportInfo f208566e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f208567f;

        b(QQAppInterface qQAppInterface, TeamWorkFileImportInfo teamWorkFileImportInfo, ActionSheet actionSheet) {
            this.f208565d = qQAppInterface;
            this.f208566e = teamWorkFileImportInfo;
            this.f208567f = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                u.j(this.f208565d, SimpleFileViewer.this.f208607f, "SimpleFileViewer", this.f208566e);
                this.f208567f.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements ae.b {
        c() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.ae.b
        public void a(Exception exc) {
            SimpleFileViewer.this.Q.setVisibility(8);
        }

        @Override // com.tencent.mobileqq.filemanager.util.ae.b
        public void b(String str, String str2) {
            SimpleFileViewer.this.Q.setText(SimpleFileViewer.this.f208607f.getString(R.string.f170948zz1, str, str2));
        }
    }

    public SimpleFileViewer(Activity activity) {
        super(activity);
        this.f208547b0 = true;
        this.f208549d0 = "";
    }

    private void F() {
        ViewGroup viewGroup;
        View view = this.f208606e;
        if (view == null || (viewGroup = (ViewGroup) view.findViewById(R.id.f27540gi)) == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
        layoutParams.bottomMargin = ViewUtils.dpToPx(71.0f);
        viewGroup.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        ViewGroup viewGroup = (ViewGroup) this.f208606e.getParent();
        if (viewGroup != null && this.L != null) {
            viewGroup.removeAllViews();
            viewGroup.addView(this.L, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    private void b0(boolean z16, boolean z17) {
        LinearLayout linearLayout;
        if (!com.tencent.mobileqq.tbstool.gray.b.f291450a.g(this.f208549d0)) {
            QLog.i("SimpleFileViewer", 1, "setQQBrowserApkInfoViewState not need set new view!");
            return;
        }
        if (this.M != null && (linearLayout = this.N) != null) {
            if (z16 && linearLayout.getVisibility() != 0) {
                this.N.setVisibility(0);
            } else if (!z16 && this.N.getVisibility() == 0) {
                this.N.setVisibility(8);
            }
            if (z17 && this.M.getVisibility() != 0) {
                this.M.setVisibility(0);
                return;
            } else {
                if (!z16 && this.M.getVisibility() == 0) {
                    this.M.setVisibility(8);
                    return;
                }
                return;
            }
        }
        QLog.i("SimpleFileViewer", 1, "mQQBrowserApkInfoLl or mQQBrowserApkDescLl is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c0(View view, View view2, boolean z16) {
        int indexOfChild;
        RelativeLayout relativeLayout;
        if (view == null) {
            this.J = view2;
            if (this.L == null && view2 != null) {
                if (view2.getParent() != null) {
                    ((ViewGroup) view2.getParent()).removeAllViews();
                }
                if (z16) {
                    relativeLayout = new GestureRelativeLayout(this, this.f208607f);
                } else {
                    relativeLayout = new RelativeLayout(this.f208607f);
                }
                this.L = relativeLayout;
                this.L.addView(view2, 0, new RelativeLayout.LayoutParams(-1, -1));
                return true;
            }
        } else if (this.L != null && view2 != null && view.hashCode() != view2.hashCode() && (indexOfChild = this.L.indexOfChild(view)) >= 0) {
            this.L.removeView(view);
            this.L.addView(view2, indexOfChild, new RelativeLayout.LayoutParams(-1, -1));
            this.J = view2;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(QQAppInterface qQAppInterface, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        String string = this.f208607f.getString(R.string.awg);
        String string2 = this.f208607f.getString(R.string.aw_);
        List<ta1.h> wordingConfig = ((ITencentDocConvertABTestUtil) QRoute.api(ITencentDocConvertABTestUtil.class)).getWordingConfig();
        if (wordingConfig != null && wordingConfig.size() == 2) {
            if (this.f208547b0) {
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
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.f208607f, null);
        actionSheet.setMainTitle(string);
        actionSheet.addButton(string2, 5);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new b(qQAppInterface, teamWorkFileImportInfo, actionSheet));
        actionSheet.show();
    }

    public TextView G() {
        return this.E;
    }

    public View H(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        if (this.Y == null) {
            DocQBBottomView docQBBottomView = new DocQBBottomView(this.f208607f, new a());
            this.Y = docQBBottomView;
            docQBBottomView.setTeamWorkFileImportInfo(teamWorkFileImportInfo);
            this.Y.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        return this.Y;
    }

    public TextView I() {
        return this.V;
    }

    public View J() {
        return this.X;
    }

    public void K() {
        View view = this.X;
        if (view != null && view.getVisibility() == 0) {
            this.X.setVisibility(8);
        }
    }

    public void L() {
        QQProgressDialog qQProgressDialog = this.Z;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.Z.dismiss();
        }
    }

    public void M(String str, boolean z16) {
        int i3;
        if (this.T == null) {
            this.T = (TextView) this.f208606e.findViewById(R.id.azh);
        }
        TextView textView = this.T;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
        this.T.setText(str);
        b0(false, false);
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.f208548c0 == null) {
            this.f208548c0 = (TextView) this.f208606e.findViewById(R.id.lk7);
        }
        this.f208548c0.setVisibility(0);
        this.f208548c0.setOnClickListener(onClickListener);
        b0(false, false);
    }

    public void O() {
        if (this.Q != null && this.P != null) {
            SpannableString spannableString = new SpannableString(this.f208607f.getString(R.string.f170950zz3));
            ae.q(this.f208607f, spannableString, "https://upage.imtt.qq.com/m_imtt/app_authority_page/real/app_authority_page.html", spannableString.length() - 8, spannableString.length() - 6);
            ae.q(this.f208607f, spannableString, "https://privacy.tencent.com/document/priview/2491347092a64d7fa00cbc2bf68fbbbb?addressbar=hide", spannableString.length() - 5, spannableString.length() - 3);
            ae.q(this.f208607f, spannableString, "https://rule.tencent.com/rule/preview/d7b6c1cb-d5b7-4c31-916a-35b4e48ec40f", spannableString.length() - 2, spannableString.length());
            this.P.setText(spannableString);
            this.P.setMovementMethod(LinkMovementMethod.getInstance());
            ae.p(this.f208607f, new c());
            return;
        }
        QLog.i("SimpleFileViewer", 1, "initQQBrowserDeveloperDesc mAppDescTv or mDeveloperDescTv is null!");
    }

    public boolean P() {
        View view;
        if (this.L != null && this.J != null && (view = this.X) != null && view.getVisibility() == 0 && this.L.getVisibility() == 0 && this.X.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void Q(boolean z16) {
        this.f208547b0 = z16;
    }

    public void S(int i3, int i16) {
        TbsReaderView tbsReaderView = this.K;
        if (tbsReaderView != null) {
            tbsReaderView.onSizeChanged(i3, i16);
        }
    }

    public void T(String str) {
        this.W.setApkIconAsyncImage(str);
    }

    public void U(int i3) {
        this.W.setImageResource(i3);
    }

    public void V(String str) {
        this.S.setText(str);
    }

    public void W(int i3) {
        this.W.setImageResource(i3);
    }

    public void X(String str) {
        this.W.setUrlIconAsyncImage(str);
    }

    public void Y(final String str) {
        if (this.R.getMeasuredWidth() <= 0) {
            this.R.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.1
                @Override // java.lang.Runnable
                public void run() {
                    SimpleFileViewer.this.R.setText(FileManagerUtil.handleLongFileName(str, false, SimpleFileViewer.this.R.getMeasuredWidth(), SimpleFileViewer.this.R.getPaint(), 2));
                }
            });
        } else {
            TextView textView = this.R;
            textView.setText(FileManagerUtil.handleLongFileName(str, false, textView.getMeasuredWidth(), this.R.getPaint(), 2));
        }
    }

    public void Z(String str, View.OnClickListener onClickListener) {
        TextView textView = this.V;
        if (textView != null) {
            textView.setText(str);
            this.V.setOnClickListener(onClickListener);
            i0(true);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.a
    public View a() {
        if (this.L != null && this.J != null) {
            QLog.e("SimpleFileViewer", 2, "getInnerFileView : tbs not null");
            this.f208606e = this.L;
        }
        return this.f208606e;
    }

    public void a0(final String str, final long j3, final LocalTbsViewManager.e eVar) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.5
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.tbstool.adapter.b e16 = com.tencent.mobileqq.tbstool.gray.b.f291450a.e(SimpleFileViewer.this.f208549d0);
                SimpleFileViewer simpleFileViewer = SimpleFileViewer.this;
                simpleFileViewer.K = e16.f(simpleFileViewer.f208607f, str, j3, eVar);
                QLog.d("SimpleFileViewer", 1, "setLocalTbsInfo curview:" + SimpleFileViewer.this.K);
                SimpleFileViewer simpleFileViewer2 = SimpleFileViewer.this;
                simpleFileViewer2.c0(null, simpleFileViewer2.K, true);
                SimpleFileViewer.this.R();
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.a
    public void d(String str, int i3, View.OnClickListener onClickListener) {
        super.e(str, onClickListener);
        if (!com.tencent.mobileqq.tbstool.gray.b.f291450a.g(this.f208549d0)) {
            QLog.i("SimpleFileViewer", 1, "initActionButton not need show new view!");
            return;
        }
        if (i3 != 2) {
            b0(false, false);
            QLog.d("SimpleFileViewer", 1, "initActionButton transStatus is flag exist!");
        } else if (PackageUtil.isPackageInstalled(BaseApplication.getContext(), TbsConfig.APP_QB)) {
            b0(true, false);
        } else {
            b0(true, true);
            O();
        }
    }

    public void d0(boolean z16, String str, int i3, View.OnClickListener onClickListener) {
        int i16;
        if (this.U == null) {
            this.U = (TextView) this.f208606e.findViewById(R.id.f793149f);
        }
        TextView textView = this.U;
        if (z16) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        textView.setVisibility(i16);
        this.U.setText(str);
        if (i3 != 0) {
            this.U.setTextColor(this.f208607f.getResources().getColor(i3));
        }
        this.U.setOnClickListener(onClickListener);
        b0(false, false);
    }

    @SuppressLint({"ResourceAsColor"})
    public void e0(SpannableString spannableString) {
        this.H.setMovementMethod(LinkMovementMethod.getInstance());
        this.H.setText(spannableString);
        this.H.setHighlightColor(17170445);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.a
    public void f() {
        int i3;
        QLog.i("SimpleFileViewer", 1, "FileBrowserViewBase: SimpleFileViewer initFileView");
        if (this.f208606e == null) {
            com.tencent.mobileqq.tbstool.gray.b bVar = com.tencent.mobileqq.tbstool.gray.b.f291450a;
            if (bVar.g(this.f208549d0)) {
                i3 = R.layout.f168653g74;
            } else {
                i3 = R.layout.amn;
            }
            View inflate = this.f208607f.getLayoutInflater().inflate(i3, (ViewGroup) null, false);
            this.f208606e = inflate;
            this.H = (TextView) inflate.findViewById(R.id.c_m);
            this.W = (AsyncImageView) this.f208606e.findViewById(R.id.ap5);
            this.R = (TextView) this.f208606e.findViewById(R.id.c_g);
            this.S = (TextView) this.f208606e.findViewById(R.id.c_c);
            this.E = (TextView) this.f208606e.findViewById(R.id.fdn);
            this.V = (TextView) this.f208606e.findViewById(R.id.s8z);
            if (bVar.g(this.f208549d0)) {
                this.M = (LinearLayout) this.f208606e.findViewById(R.id.f59182s1);
                this.N = (LinearLayout) this.f208606e.findViewById(R.id.f59172s0);
                this.P = (TextView) this.f208606e.findViewById(R.id.f59202s3);
                this.Q = (TextView) this.f208606e.findViewById(R.id.f59192s2);
            }
            this.I = this.f208606e;
        }
    }

    public void f0(String str) {
        this.H.setText(str);
    }

    public void h0(boolean z16) {
        int i3;
        TextView textView = this.S;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
    }

    public void i0(boolean z16) {
        TextView textView = this.V;
        if (textView != null) {
            RelativeLayout relativeLayout = this.f208608h;
            int i3 = 8;
            if (relativeLayout != null) {
                if (z16 && relativeLayout.getVisibility() != 0) {
                    this.V.setVisibility(0);
                } else {
                    this.V.setVisibility(8);
                }
            } else {
                if (z16) {
                    i3 = 0;
                }
                textView.setVisibility(i3);
            }
            if (this.V.getVisibility() == 0) {
                b0(false, false);
                F();
            }
        }
    }

    public void j0(boolean z16) {
        int i3;
        TextView textView = this.f208548c0;
        if (textView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
    }

    public void k0(String str) {
        if (this.Z == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this.f208607f);
            this.Z = qQProgressDialog;
            qQProgressDialog.setCancelable(false);
        }
        if (!this.Z.isShowing() && !this.f208607f.isFinishing()) {
            this.Z.setMessage(str);
            this.Z.show();
        }
    }

    public void l0(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        if (teamWorkFileImportInfo == null) {
            return;
        }
        teamWorkFileImportInfo.J = 3;
        ThreadManager.getUIHandler().post(new AnonymousClass3(teamWorkFileImportInfo));
    }

    public void m0(boolean z16) {
        if (z16 && !TextUtils.isEmpty(this.H.getText())) {
            this.H.setVisibility(0);
        } else {
            this.H.setVisibility(8);
        }
    }

    public void n0() {
        TbsReaderView tbsReaderView = this.K;
        if (tbsReaderView != null) {
            tbsReaderView.onStop();
        }
        DocQBBottomView docQBBottomView = this.Y;
        if (docQBBottomView != null) {
            docQBBottomView.k();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.a
    public void o(boolean z16) {
        super.o(z16);
        if (z16) {
            i0(false);
        }
    }

    public void o0(int i3) {
        DocQBBottomView docQBBottomView = this.Y;
        if (docQBBottomView != null) {
            docQBBottomView.q(i3);
        }
    }

    public void p0(String str, Object obj) {
        DocQBBottomView docQBBottomView = this.Y;
        if (docQBBottomView != null) {
            docQBBottomView.r(str, obj);
        }
    }

    public void q0(final String str, final long j3, final LocalTbsViewManager.e eVar) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.6
            @Override // java.lang.Runnable
            public void run() {
                TbsReaderView f16 = com.tencent.mobileqq.tbstool.gray.b.f291450a.e(SimpleFileViewer.this.f208549d0).f(SimpleFileViewer.this.f208607f, str, j3, eVar);
                QLog.d("SimpleFileViewer", 1, "updateTbsView oldview:" + SimpleFileViewer.this.K + ", newview:" + f16);
                if (SimpleFileViewer.this.K != null) {
                    SimpleFileViewer simpleFileViewer = SimpleFileViewer.this;
                    if (simpleFileViewer.c0(simpleFileViewer.K, f16, true)) {
                        SimpleFileViewer.this.K = f16;
                    }
                }
            }
        });
    }

    public void r0(int i3) {
        int i16;
        View view = this.f208546a0;
        if (view != null) {
            if (i3 > 0) {
                i16 = 0;
            } else {
                i16 = 4;
            }
            view.setVisibility(i16);
        }
    }

    public SimpleFileViewer(Activity activity, String str) {
        super(activity);
        this.f208547b0 = true;
        this.f208549d0 = str;
    }
}
