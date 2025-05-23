package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.relation.widget.RecommendFriendContainerV2;
import com.tencent.mobileqq.search.searchdetail.util.SearchBoxWordsUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.AutoHintLayout;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.gridpage.QQGridContainerView;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AddContactsView extends ContactBaseView implements View.OnClickListener, AutoHintLayout.b {
    static IPatchRedirector $redirector_;
    private static final int S;
    private QUISearchBar C;
    private AutoHintLayout D;
    private ArrayList<String> E;
    boolean F;
    boolean G;
    private RecommendFriendContainerV2 H;
    private IFaceDecoder I;
    private long J;
    private long K;
    private int L;
    private boolean M;
    private boolean N;
    private e P;
    private final String Q;
    private com.tencent.mobileqq.search.searchdetail.content.view.a R;

    /* renamed from: h, reason: collision with root package name */
    private View f180694h;

    /* renamed from: i, reason: collision with root package name */
    private List<String> f180695i;

    /* renamed from: m, reason: collision with root package name */
    private EditText f180696m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements Function1<ArrayList<String>, Unit> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactsView.this);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(ArrayList<String> arrayList) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                AddContactsView.this.C.setClipChildren(false);
                AddContactsView.this.C.getFlSearchExt().setVisibility(8);
                AddContactsView.this.D.setEnableFrondIconRunInAnim(true, AddContactsView.this.C);
                AddContactsView.this.D.setHintList(arrayList);
                AddContactsView.this.D.setReportDataList(arrayList);
                AddContactsView.this.E = arrayList;
            }
            AddContactsView.this.setSearchContainerReportIsShading(z16);
            return null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67792);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            S = ViewUtils.dip2px(24.0f);
        }
    }

    public AddContactsView(ContactBaseView.a aVar, boolean z16, boolean z17) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.L = 0;
        this.Q = HardCodeUtil.qqStr(R.string.j3f);
        this.M = z16;
        this.N = z17;
    }

    private void n() {
        QQAppInterface qQAppInterface;
        Activity activity = this.f180747e;
        if (activity != null && (qQAppInterface = this.f180748f) != null) {
            this.f180695i = com.tencent.mobileqq.activity.contact.addcontact.gridentrance.c.b(activity, qQAppInterface);
        } else {
            QLog.e("AddContactsView", 1, "invalid params. context or app is null");
        }
    }

    private void o() {
        com.tencent.mobileqq.activity.contact.addcontact.gridentrance.c.a((QQGridContainerView) this.f180694h.findViewById(R.id.f165103uw3), this.f180695i, new Function1() { // from class: com.tencent.mobileqq.activity.contact.addcontact.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit v3;
                v3 = AddContactsView.this.v((View) obj);
                return v3;
            }
        });
    }

    private void q() {
        com.tencent.mobileqq.activity.contact.addcontact.gridentrance.b.d(this.f180747e, this.f180748f, this.P.l());
    }

    private void r() {
        long j3;
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.i("AddContactsView", 2, String.format("onClick invite lastTs=%d lastBlank=%d", Long.valueOf(this.J), Long.valueOf(this.K)));
        }
        long j16 = this.J;
        if (j16 <= 0 || currentTimeMillis - j16 > this.K) {
            boolean e16 = com.tencent.mobileqq.hitrate.d.e("com.tencent.mobileqq:tool");
            this.J = currentTimeMillis;
            if (e16) {
                j3 = 1000;
            } else {
                j3 = 2000;
            }
            this.K = j3;
            com.tencent.mobileqq.activity.contact.addcontact.gridentrance.b.f(this.f180747e, this.f180748f);
        }
    }

    private void s() {
        this.P.m();
        if (QLog.isColorLevel()) {
            QLog.d("AddContactsView", 2, "initData  addPageDisplayAsVerticalListItem = " + this.F + "shouldShowMayknowEnty=" + this.G);
        }
        if (StudyModeManager.w()) {
            this.C.setVisibility(8);
        }
        if (this.D != null) {
            if (SearchBoxWordsUtil.f284723a.e() && !StudyModeManager.t()) {
                this.R = new com.tencent.mobileqq.search.searchdetail.content.view.a(this.C, this);
                this.D.setHintHelperGravity(17);
                this.D.setInterval(5000L);
                this.D.setAnimDuration(400);
                this.D.m(this.R);
                SearchBoxWordsUtil.c(4, new a());
                return;
            }
            setSearchContainerReportIsShading(false);
        }
    }

    private void t() {
        VideoReport.addToDetectionWhitelist(this.f180747e);
        VideoReport.setPageId(this, "pg_search_people");
        int intExtra = this.f180747e.getIntent().getIntExtra("entrance_data_report", 0);
        this.L = intExtra;
        int i3 = 1;
        if (intExtra != 1 && intExtra != 3 && intExtra != 4) {
            i3 = 2;
        }
        VideoReport.setPageParams(this, new PageParams(new HashMap<String, Object>(i3) { // from class: com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$dtReportFrom;

            {
                this.val$dtReportFrom = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactsView.this, i3);
                    return;
                }
                put("entry_id", Integer.valueOf(i3));
                put("trace_id", AddContactsView.this.H.w());
                put("trans_info", AddContactsView.this.H.x());
            }
        }));
        VideoReport.setElementId(this.C, "em_search_people_search_column");
        QUISearchBar qUISearchBar = this.C;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(qUISearchBar, clickPolicy);
        VideoReport.setElementExposePolicy(this.C, ExposurePolicy.REPORT_ALL);
        QUISearchBar qUISearchBar2 = this.C;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        VideoReport.setElementEndExposePolicy(qUISearchBar2, endExposurePolicy);
        VideoReport.setElementId(this.f180696m, "em_search_grey_word");
        VideoReport.setElementExposePolicy(this.f180696m, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.f180696m, clickPolicy);
        VideoReport.setElementEndExposePolicy(this.f180696m, endExposurePolicy);
    }

    private void u() {
        this.C = (QUISearchBar) this.f180694h.findViewById(R.id.duk);
        EditText editText = (EditText) this.f180694h.findViewById(R.id.f66003_g);
        this.f180696m = editText;
        editText.setFocusableInTouchMode(false);
        this.f180696m.setCursorVisible(false);
        if (this.N) {
            this.f180696m.setHint(R.string.f170093yl3);
        } else {
            this.f180696m.setHint(R.string.f170092yl2);
        }
        this.f180696m.setOnClickListener(this);
        this.D = this.C.getAutoHintLayout();
        this.f180694h.findViewById(R.id.f65993_f).setOnClickListener(this);
        this.H.setShowInfinite(false);
        this.H.setNeedShowQZoneMediaInfo(this.M);
        this.H.D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit v(View view) {
        onClick(view);
        return null;
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return getResources().getDimensionPixelSize(R.dimen.acq);
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView
    public void b(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 1000000 && QLog.isColorLevel()) {
            QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + i3 + ", src: 14");
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.c();
        super.setContentView(R.layout.f167560aq);
        this.P = new e(this.f180748f, this.f180747e);
        this.H = (RecommendFriendContainerV2) findViewById(R.id.f164013sd4);
        View inflate = LayoutInflater.from(this.f180747e).inflate(R.layout.f167562ar, (ViewGroup) null);
        this.f180694h = inflate;
        this.H.t(inflate);
        this.H.setAdapter(62);
        n();
        o();
        u();
        s();
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView
    public void d() {
        com.tencent.mobileqq.search.searchdetail.content.view.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.d();
        this.P.k();
        RecommendFriendContainerV2 recommendFriendContainerV2 = this.H;
        if (recommendFriendContainerV2 != null) {
            recommendFriendContainerV2.I();
        }
        IFaceDecoder iFaceDecoder = this.I;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
            this.I = null;
        }
        View view = this.f180694h;
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).removeAllViews();
        }
        AutoHintLayout autoHintLayout = this.D;
        if (autoHintLayout != null && (aVar = this.R) != null) {
            autoHintLayout.u(aVar);
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        RecommendFriendContainerV2 recommendFriendContainerV2 = this.H;
        if (recommendFriendContainerV2 != null) {
            recommendFriendContainerV2.J();
        }
        AutoHintLayout autoHintLayout = this.D;
        if (autoHintLayout != null) {
            autoHintLayout.s();
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.f();
        t();
        e eVar = this.P;
        if (eVar != null) {
            eVar.o();
            this.P.i();
        }
        RecommendFriendContainerV2 recommendFriendContainerV2 = this.H;
        if (recommendFriendContainerV2 != null) {
            recommendFriendContainerV2.K();
        }
        int intExtra = this.f180747e.getIntent().getIntExtra("entrance_data_report", 0);
        ReportController.o(this.f180748f, "CliOper", "", "", "0X800760D", "0X800760D", intExtra, 0, "", "", "", "");
        if (intExtra != 0) {
            ReportController.o(this.f180748f, "CliOper", "", "", "0X800760D", "0X800760D", 0, 0, "", "", "", "");
        }
        if (this.f180695i.contains("8")) {
            ReportController.o(this.f180748f, "dc00898", "", "", "0X80096F6", "0X80096F6", 0, 0, "", "", "", "");
        }
        SearchUtils.V0("add_page", "search_people", "exp", 0, 0, "");
        AutoHintLayout autoHintLayout = this.D;
        if (autoHintLayout != null && !autoHintLayout.i().isEmpty()) {
            this.D.q();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("AddContactsView", 2, "onClick id=" + view.getId());
            }
            int id5 = view.getId();
            if (id5 != R.id.f65993_f && id5 != R.id.f66003_g) {
                if (id5 == 1002) {
                    q();
                } else if (id5 == 1001) {
                    com.tencent.mobileqq.activity.contact.addcontact.gridentrance.b.b(this.f180747e, this.f180748f);
                } else if (id5 == 1003) {
                    com.tencent.mobileqq.activity.contact.addcontact.gridentrance.b.h(this.f180747e, this.f180748f);
                } else if (id5 == 1004) {
                    com.tencent.mobileqq.activity.contact.addcontact.gridentrance.b.e(this.f180747e, this.f180748f, this.L);
                } else if (id5 == 1007) {
                    com.tencent.mobileqq.activity.contact.addcontact.gridentrance.b.g(this.f180747e, this.f180748f, view);
                } else if (id5 == 1008) {
                    r();
                } else if (id5 == 1006) {
                    com.tencent.mobileqq.activity.contact.addcontact.gridentrance.b.i(this.f180747e, this.f180748f);
                } else if (id5 == 1010) {
                    com.tencent.mobileqq.activity.contact.addcontact.gridentrance.b.k(this.f180747e);
                } else if (id5 == 1011) {
                    com.tencent.mobileqq.activity.contact.addcontact.gridentrance.b.j(this.f180747e);
                }
            } else {
                this.f180746d.b();
                SearchUtils.V0("add_page", "search", "active_frame", 1, 0, "");
                ReportController.o(this.f180748f, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 1, 0, "", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.search.view.AutoHintLayout.b
    public void onHintChange(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), str, str2);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("literal_text", str);
        VideoReport.setElementParams(this.f180696m, hashMap);
        VideoReport.reportEvent("dt_imp", this.f180696m, hashMap);
    }

    @Nullable
    public ArrayList<String> p() {
        AutoHintLayout autoHintLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (this.E != null && (autoHintLayout = this.D) != null) {
            String i3 = autoHintLayout.i();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(0, i3);
            return arrayList;
        }
        return null;
    }

    public void setSearchContainerReportIsShading(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("is_shading", Integer.valueOf(z16 ? 1 : 0));
        VideoReport.setElementParams(this.C, hashMap);
    }

    public void w() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        ArrayList<String> arrayList = this.E;
        if (arrayList != null && !arrayList.isEmpty()) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("literal_text", this.D.i());
            VideoReport.reportEvent("dt_clck", this.f180696m, hashMap);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("is_shading", Integer.valueOf(i3));
        VideoReport.reportEvent("dt_clck", this.C, hashMap2);
    }
}
