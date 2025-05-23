package com.tencent.mobileqq.search.business.contact.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.business.contact.ContactSearchEngine;
import com.tencent.mobileqq.search.business.contact.NtBuddySearchEngine;
import com.tencent.mobileqq.search.business.contact.NtTroopSearchEngine;
import com.tencent.mobileqq.search.business.contact.j;
import com.tencent.mobileqq.search.business.contact.p;
import com.tencent.mobileqq.search.business.contact.q;
import com.tencent.mobileqq.search.business.contact.r;
import com.tencent.mobileqq.search.business.contact.s;
import com.tencent.mobileqq.search.k;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.d;
import com.tencent.mobileqq.search.view.e;
import com.tencent.mobileqq.search.view.f;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.troop.BlockTroopForwardConfig;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import wn2.h;
import wn2.i;
import wn2.n;
import xn2.g;

/* compiled from: P */
@Deprecated
/* loaded from: classes18.dex */
public class ContactSearchFragment extends BaseSearchFragment<y> implements f {
    protected int C;
    protected int D;
    protected String E;
    protected Set<String> G;
    private IPerformanceReportTask V;
    private boolean F = false;
    private boolean H = false;
    private boolean I = false;
    private final ArrayList<String> J = new ArrayList<>();
    private long K = -1;
    private String L = "";
    private ArrayList<String> M = null;
    public boolean N = false;
    private Set<String> P = new HashSet();
    private Set<String> Q = new HashSet();
    private List<PhoneContact> R = new ArrayList();
    protected d S = null;
    private int T = 0;
    private boolean U = false;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ((InputMethodManager) MobileQQ.sMobileQQ.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b extends mn2.b<y, sn2.c> {
        b(ListView listView, IFaceDecoder iFaceDecoder) {
            super(listView, iFaceDecoder);
        }

        private void h(View view) {
            if (view != null && ContactSearchFragment.this.D == 23) {
                y yVar = (y) view.getTag(R.id.kxb);
                QUIButton qUIButton = (QUIButton) view.findViewById(R.id.i8s);
                if (yVar != null && qUIButton != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("qq_num", yVar.getUin());
                    hashMap.put("search_query", yVar.getKeywords());
                    com.tencent.mobileqq.troop.dtreport.a.f(view, "em_single_result", hashMap);
                    com.tencent.mobileqq.troop.dtreport.a.f(qUIButton, "em_group_member_add", hashMap);
                }
            }
        }

        @Override // mn2.a
        protected qn2.d<y, sn2.c> e(int i3) {
            if (ContactSearchFragment.this.wh()) {
                IFaceDecoder iFaceDecoder = this.f417042e;
                ContactSearchFragment contactSearchFragment = ContactSearchFragment.this;
                return new xn2.d(iFaceDecoder, contactSearchFragment.S, contactSearchFragment.P, ContactSearchFragment.this.Q);
            }
            ContactSearchFragment contactSearchFragment2 = ContactSearchFragment.this;
            int i16 = contactSearchFragment2.D;
            if (i16 == 17) {
                return new xn2.b(this.f417042e, contactSearchFragment2.S);
            }
            if (i16 == 19) {
                return new xn2.a(this.f417042e, contactSearchFragment2.S, contactSearchFragment2.R);
            }
            if (i16 == 23) {
                return new g(this.f417042e, null);
            }
            if (i16 == 24) {
                return new xn2.f(this.f417042e, contactSearchFragment2.S, contactSearchFragment2.P);
            }
            return new xn2.c(this.f417042e, contactSearchFragment2.S, contactSearchFragment2.P);
        }

        @Override // mn2.a
        protected sn2.d f(int i3, ViewGroup viewGroup) {
            ContactSearchFragment contactSearchFragment;
            int i16;
            int i17;
            if (!SearchUtils.F0(ContactSearchFragment.this.D) && (i16 = (contactSearchFragment = ContactSearchFragment.this).D) != 5 && i16 != 8 && i16 != 28) {
                if (!contactSearchFragment.wh() && (i17 = ContactSearchFragment.this.D) != 19 && i17 != 24) {
                    if (i17 == 17) {
                        return new yn2.b(viewGroup, R.layout.atc);
                    }
                    if (i17 == 23) {
                        return new zo2.a(viewGroup, R.layout.atc);
                    }
                    return new yn2.c(viewGroup, R.layout.bxm);
                }
                return new yn2.c(viewGroup, R.layout.bxn);
            }
            return new yn2.c(viewGroup, R.layout.bxo);
        }

        @Override // mn2.a, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i3, view, viewGroup);
            h(view2);
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ah() {
        ListView listView = this.listView;
        if (listView != null && this.adapter != null) {
            int lastVisiblePosition = this.listView.getLastVisiblePosition();
            for (int firstVisiblePosition = listView.getFirstVisiblePosition(); firstVisiblePosition <= lastVisiblePosition; firstVisiblePosition++) {
                v item = this.adapter.getItem(firstVisiblePosition);
                if (item != null && (item instanceof h)) {
                    SearchUtils.V0("Sgrp", "search_result2", "exp", 0, 0, String.valueOf(((h) item).G()));
                }
            }
        }
    }

    private void Bh() {
        ListView listView = this.listView;
        if (listView != null) {
            listView.post(new Runnable() { // from class: com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    ContactSearchFragment.this.Ah();
                }
            });
            this.listView.setOnScrollListener(new c());
        }
    }

    private ArrayList<RobotCoreInfo> uh() {
        int size;
        ac robotService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getRobotService();
        if (robotService == null) {
            return null;
        }
        ArrayList<RobotCoreInfo> allRobotFriendsFromCache = robotService.getAllRobotFriendsFromCache();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getRobotCoreInfo: size=");
        if (allRobotFriendsFromCache == null) {
            size = 0;
        } else {
            size = allRobotFriendsFromCache.size();
        }
        sb5.append(size);
        QLog.i("ContactSearchFragment", 1, sb5.toString());
        return allRobotFriendsFromCache;
    }

    private void vh() {
        ArrayList<RobotCoreInfo> uh5 = uh();
        if (uh5 != null && this.I) {
            Iterator<RobotCoreInfo> it = uh5.iterator();
            while (it.hasNext()) {
                RobotCoreInfo next = it.next();
                if (!next.allowAddGroup) {
                    this.J.add(String.valueOf(next.robotUin));
                }
            }
            QLog.i("ContactSearchFragment", 1, "initFilterGroupRobotUinList: " + this.J.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wh() {
        int i3 = this.D;
        if (i3 != -1 && i3 != 29) {
            return false;
        }
        return true;
    }

    public static f xh(int i3, int i16, String str, List<String> list, d dVar, int i17, long j3, boolean z16, k kVar) {
        return yh(i3, i16, str, list, dVar, i17, j3, false, z16, kVar);
    }

    @Deprecated
    public static f yh(int i3, int i16, String str, List<String> list, d dVar, int i17, long j3, boolean z16, boolean z17, k kVar) {
        if (z16) {
            QLog.e("ContactSearchFragment", 2, "using original fragment\u3002\u3002\u3002\u3002 ", new Throwable());
        }
        if (!z16) {
            return ContactsSearchNTFragment.INSTANCE.a(i3, i16, str, list, dVar, i17, j3, !z17, z17, kVar);
        }
        ContactSearchFragment contactSearchFragment = new ContactSearchFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(IProfileCardConst.KEY_FROM_TYPE, i3);
        bundle.putInt("contactSearchSource", i16);
        bundle.putString("specifiedTroopUin", str);
        bundle.putInt("ContactCombineType", i17);
        if (list != null) {
            bundle.putStringArray("hiddenUinSet", (String[]) list.toArray(new String[list.size()]));
        }
        if (dVar != null) {
            bundle.putLong("contactSearchOnActionListener", rn2.b.b().a(dVar));
        }
        if (j3 > 0) {
            bundle.putLong("contactSearchResultFilterType", j3);
        }
        contactSearchFragment.setArguments(bundle);
        return contactSearchFragment;
    }

    public static f zh(int i3, int i16, String str, List<String> list, d dVar, boolean z16, k kVar) {
        return xh(i3, i16, str, list, dVar, 0, -1L, z16, kVar);
    }

    @Override // com.tencent.mobileqq.search.view.f
    public void B5(List<String> list, List<String> list2) {
        this.P.clear();
        this.Q.clear();
        if (list != null && list.size() > 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.P.add(it.next());
            }
        }
        if (list2 != null && list2.size() > 0) {
            Iterator<String> it5 = list2.iterator();
            while (it5.hasNext()) {
                this.Q.add(it5.next());
            }
        }
    }

    public void Ch(List<PhoneContact> list) {
        this.R.clear();
        if (list != null && list.size() > 0) {
            this.R.addAll(list);
        }
    }

    @Override // com.tencent.mobileqq.search.view.f
    public boolean K9() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.view.f
    public boolean L5() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.view.f
    public void e2(boolean z16) {
        this.I = z16;
        QLog.i("ContactSearchFragment", 2, "setFilterGroupRobot: " + z16);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected String getHeaderText() {
        int i3 = this.T;
        if (i3 == 2) {
            return HardCodeUtil.qqStr(R.string.l2u);
        }
        if (i3 == 3) {
            return BaseApplication.getContext().getResources().getString(R.string.f210055h3);
        }
        return HardCodeUtil.qqStr(R.string.l2x);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected String getRightTvText() {
        if (this.T == 2) {
            return HardCodeUtil.qqStr(R.string.l2u);
        }
        return HardCodeUtil.qqStr(R.string.jzo);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected int getSearchModule() {
        return 20;
    }

    @Override // com.tencent.mobileqq.search.view.f
    public boolean lf(boolean z16) {
        return true;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected boolean needShowHeader() {
        return SearchUtils.F0(this.D);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected mn2.a newAdapter() {
        return new b(this.listView, this.faceDecoder);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected on2.b newSearchEngine() {
        if (this.U) {
            int i3 = this.T;
            if (i3 == 1) {
                return new NtBuddySearchEngine(this.D, 100860733);
            }
            if (i3 == 2) {
                return new NtTroopSearchEngine(this.D);
            }
            throw new IllegalArgumentException("No valid Search Engine implement(combineType=" + this.T + ")");
        }
        int i16 = this.C;
        if (i16 == 524288) {
            if (this.D == 19) {
                return new q(this.appInterface, this.D, this.C, this.E, this.G);
            }
            return new p(this.appInterface, this.D, this.C, this.E, this.G);
        }
        if (i16 == 1048576) {
            if (this.D == 23) {
                return new s(this.appInterface, this.D, this.C, this.E, this.G);
            }
            return new r(this.appInterface, this.D, this.C, this.E, this.G);
        }
        return new ContactSearchEngine(this.appInterface, this.D, this.C, this.E, this.G);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.C = arguments.getInt("contactSearchSource", 100860733);
            this.D = arguments.getInt(IProfileCardConst.KEY_FROM_TYPE, -1);
            this.K = arguments.getLong("contactSearchResultFilterType", -1L);
            this.U = arguments.getBoolean("BUNDLE_KEY_USE_NT_SEARCH_ENGINE", false);
            this.M = arguments.getStringArrayList(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_FILTER_TROOP_UIN_LIST);
            this.N = arguments.getBoolean(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_FILTER_BLOCK_GROUP, false);
            this.L = arguments.getString(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_UIN, "");
            if (QLog.isColorLevel()) {
                QLog.d("ContactSearchFragment", 2, "onCreate searchSource = " + this.C + ",fromType = " + this.D + ",filterType = " + this.K + ",masterGroupUin = " + this.L);
            }
            this.T = arguments.getInt("ContactCombineType", 0);
            this.E = arguments.getString("specifiedTroopUin");
            String[] stringArray = arguments.getStringArray("hiddenUinSet");
            if (stringArray != null && stringArray.length > 0) {
                this.G = new HashSet();
                for (String str : stringArray) {
                    this.G.add(str);
                }
            }
            long j3 = arguments.getLong("contactSearchOnActionListener", -1L);
            if (j3 != -1) {
                this.S = (d) rn2.b.b().c(j3);
            }
            if (this.C == 1048576) {
                z7(true);
            }
        }
        vh();
        super.onCreate(bundle);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, on2.d
    public void onFinish(List list, pn2.b bVar) {
        if (QLog.isColorLevel()) {
            QLog.d("ContactSearchFragment", 2, "onFinish with respData:", bVar.toString());
        }
        if (bVar.a(this.keyword)) {
            onFinish(list, bVar.f426500c);
        } else if (QLog.isColorLevel()) {
            QLog.d("ContactSearchFragment", 2, "onFinish not match keyword1:", bVar.f426498a, " keyword2:", this.keyword);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    public void onSearchFinished(List<y> list) {
        super.onSearchFinished(list);
        if (SearchUtils.F0(this.D) && list != null && !this.isReported) {
            this.isReported = true;
            SearchUtils.W0("contact", "exp_page", "" + this.keyword, "" + list.size());
        }
        if (list != null) {
            j.a(list.size());
            j.b(true);
        }
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!SearchUtils.F0(this.D)) {
            if (wh()) {
                this.fragmentView.setBackgroundResource(R.color.ajr);
            } else {
                this.fragmentView.setBackgroundResource(R.color.f156905eu);
            }
            this.F = false;
            this.listView.setOnTouchListener(new a());
        }
        IPerformanceReportTask f16 = qw1.b.f(getArguments(), "_extra_param_report_task");
        this.V = f16;
        qw1.b.i(f16, this.listView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    public void startSearch(String str, int i3) {
        super.startSearch(str, i3);
        j.c(str, false);
        if ((!SearchUtils.F0(this.D) || wh()) && this.fragmentView != null) {
            if (TextUtils.isEmpty(str)) {
                this.F = false;
                if (wh()) {
                    this.fragmentView.setBackgroundResource(R.color.ajr);
                    return;
                } else {
                    this.fragmentView.setBackgroundResource(R.color.f156905eu);
                    return;
                }
            }
            this.F = true;
            this.fragmentView.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        }
    }

    @Override // com.tencent.mobileqq.search.view.f
    public /* synthetic */ void tb() {
        e.b(this);
    }

    @Override // com.tencent.mobileqq.search.view.f
    public /* synthetic */ void y8() {
        e.a(this);
    }

    @Override // com.tencent.mobileqq.search.view.f
    public void z7(boolean z16) {
        this.H = z16;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, on2.d
    public void onFinish(List list, int i3) {
        TroopInfo a16;
        if (QLog.isColorLevel()) {
            QLog.d("ContactSearchFragment", 2, "onFinish with status:", Integer.valueOf(i3));
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb5 = new StringBuilder(2048);
        if (list != null && list.size() > 0) {
            for (Object obj : list) {
                if (QLog.isColorLevel() && (obj instanceof com.tencent.mobileqq.search.model.k)) {
                    com.tencent.mobileqq.search.model.k kVar = (com.tencent.mobileqq.search.model.k) obj;
                    sb5.append("model name:");
                    sb5.append(kVar.getTitle());
                    sb5.append(" clss:");
                    sb5.append(kVar.getClass().getSimpleName());
                    sb5.append(" degree:");
                    sb5.append(kVar.I());
                    sb5.append(" second:");
                    sb5.append(kVar.J());
                    sb5.append("\n");
                }
                if (obj instanceof y) {
                    y yVar = (y) obj;
                    if (!this.H || !((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isQQAppInterface(this.appInterface) || !rn2.k.d(this.appInterface, yVar.getUin())) {
                        if (!this.I || !this.J.contains(yVar.getUin())) {
                            long j3 = this.K;
                            if (j3 > 0 && (j3 & 1) != 0 && (yVar instanceof n)) {
                                n nVar = (n) yVar;
                                if (nVar.M() == 1000 || nVar.M() == 1004 || nVar.M() == 1003 || nVar.M() == 1006 || nVar.M() == 2016) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("ContactSearchFragment", 2, "onFinish filter a result ,uintype = " + nVar.M());
                                    }
                                }
                            }
                            long j16 = this.K;
                            if (j16 > 0 && (j16 & 2) != 0) {
                                if (yVar instanceof i) {
                                    i iVar = (i) yVar;
                                    boolean X = iVar.X(this.appInterface.getCurrentUin());
                                    boolean equals = iVar.X.equals(this.L);
                                    ArrayList<String> arrayList2 = this.M;
                                    boolean z16 = arrayList2 != null && arrayList2.contains(iVar.X);
                                    boolean z17 = this.N && iVar.a().isTroopBlocked;
                                    if (X && !equals && !z16 && !z17) {
                                    }
                                } else if (yVar instanceof wn2.f) {
                                    wn2.f fVar = (wn2.f) yVar;
                                    boolean X2 = fVar.X(this.appInterface.getCurrentUin());
                                    boolean equals2 = fVar.X.equals(this.L);
                                    ArrayList<String> arrayList3 = this.M;
                                    boolean z18 = arrayList3 != null && arrayList3.contains(fVar.X);
                                    boolean z19 = this.N && fVar.T().isTroopBlocked;
                                    if (X2 && !equals2 && !z18 && !z19) {
                                    }
                                } else if (yVar instanceof wn2.q) {
                                    wn2.q qVar = (wn2.q) yVar;
                                    String obj2 = qVar.G().toString();
                                    boolean T = qVar.T(this.appInterface.getCurrentUin());
                                    boolean equals3 = obj2.equals(this.L);
                                    ArrayList<String> arrayList4 = this.M;
                                    boolean z26 = arrayList4 != null && arrayList4.contains(obj2);
                                    boolean z27 = this.N && qVar.a().isTroopBlocked;
                                    if (T && !equals3 && !z26 && !z27) {
                                    }
                                }
                            }
                            if (this.D == 7 && BlockTroopForwardConfig.a() && this.N) {
                                if (yVar instanceof i) {
                                    a16 = ((i) yVar).a();
                                } else if (yVar instanceof wn2.f) {
                                    a16 = ((wn2.f) yVar).T();
                                } else {
                                    a16 = yVar instanceof wn2.q ? ((wn2.q) yVar).a() : null;
                                }
                                if (a16 != null && a16.isTroopBlocked) {
                                }
                            }
                            if (this.T == 2 && SearchUtils.M0(yVar)) {
                                arrayList.add(yVar);
                            } else if (this.T == 1 && !SearchUtils.M0(yVar) && !SearchUtils.G0(yVar)) {
                                arrayList.add(yVar);
                            } else if (this.T == 0) {
                                arrayList.add(yVar);
                            }
                        }
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactSearchFragment", 2, sb5.toString());
        }
        super.onFinish(arrayList, i3);
        if (SearchUtils.F0(this.D) && !this.isReported) {
            this.isReported = true;
            String[] strArr = new String[2];
            strArr[0] = "" + this.keyword;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("");
            sb6.append(list != null ? list.size() : 0);
            strArr[1] = sb6.toString();
            SearchUtils.W0("contact", "exp_page", strArr);
        }
        if (this.T == 3) {
            Bh();
        }
    }

    @Override // com.tencent.mobileqq.search.view.f
    @NonNull
    public Fragment getFragment() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements AbsListView.OnScrollListener {
        c() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (i3 == 0) {
                ContactSearchFragment.this.Ah();
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        }
    }
}
