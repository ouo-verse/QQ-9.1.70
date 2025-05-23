package com.tencent.mobileqq.qqexpand.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqexpand.bean.feed.a;
import com.tencent.mobileqq.qqexpand.config.banner.ExpandBannerConfBean$BannerItem;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendBottomBarView;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendCampusVerifyTipsView;
import com.tencent.mobileqq.qqexpand.widget.o;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.qqexpand.widget.search.ExpandSearchBarView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.widget.NearbyZanAnimLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import yg2.i;
import yg2.j;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExtendFriendSquareFragment extends ExtendFriendBaseFragment implements PullToRefreshBase.d<RecyclerView>, ExtendFriendCampusVerifyTipsView.a {
    private WeakReferenceHandler C0;
    private boolean E0;
    private boolean F0;
    private boolean G0;
    private boolean H0;
    private byte[] J0;
    private int K0;
    private long L0;
    private boolean N0;
    private ExpandSearchBarView Q0;
    private ExtendFriendBottomBarView R0;
    private boolean S0;
    private com.tencent.mobileqq.qqexpand.fragment.c T0;
    private int U0;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f263763y0 = false;

    /* renamed from: z0, reason: collision with root package name */
    public int f263764z0 = 0;
    public int A0 = 480;
    public long B0 = -1;
    private final com.tencent.mobileqq.friend.observer.a D0 = new com.tencent.mobileqq.friend.observer.a() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friend.observer.a
        public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSquareFragment", 2, String.format("onUpdateAddFriend isSuccess=%s addSuccess=%s reqestUin=%s", Boolean.valueOf(z16), Boolean.valueOf(z17), str));
            }
            ExtendFriendSquareFragment extendFriendSquareFragment = ExtendFriendSquareFragment.this;
            com.tencent.mobileqq.qqexpand.bean.feed.b u16 = extendFriendSquareFragment.L.u(extendFriendSquareFragment.W);
            if (u16 == null || u16.mAddFriendVerified) {
                return;
            }
            u16.mAddFriendVerified = true;
            ExtendFriendSquareFragment.this.C0.post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment.1.1
                @Override // java.lang.Runnable
                public void run() {
                    ExtendFriendSquareFragment extendFriendSquareFragment2 = ExtendFriendSquareFragment.this;
                    extendFriendSquareFragment2.L.notifyItemChanged(extendFriendSquareFragment2.W);
                }
            });
        }
    };
    private int I0 = 1;
    private int M0 = -1;
    private final vg2.c O0 = new vg2.c();
    private final yg2.e P0 = new yg2.e();
    private boolean V0 = false;
    private final ExpandObserver W0 = new a();

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends ExpandObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void m(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSquareFragment", 2, "onLimitChatResourceStateUpdate, isReady = " + z16);
            }
            ExtendFriendSquareFragment.this.ji();
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void o(boolean z16, int i3, int i16, vg2.d dVar, int i17) {
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSquareFragment", 2, String.format("onMatchResponse success=%s match_op=%s retCode=%s info=%s", Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), dVar));
            }
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void x(boolean z16, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSquareFragment", 2, String.format("onUpdateCampusCertificateStatus isSuccess=%s scene=%s", Boolean.valueOf(z16), Integer.valueOf(i3)));
            }
            if (z16 && i3 == 1) {
                ExtendFriendSquareFragment.this.pi();
            }
            if (z16) {
                ExtendFriendSquareFragment.this.ji();
            }
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void h(boolean z16, long j3, String str, boolean z17, byte[] bArr, boolean z18, boolean z19, int i3, List<com.tencent.mobileqq.qqexpand.bean.feed.b> list, vg2.c cVar) {
            ExtendFriendSquareFragment extendFriendSquareFragment = ExtendFriendSquareFragment.this;
            if (extendFriendSquareFragment.f263637m0 != j3) {
                return;
            }
            try {
                extendFriendSquareFragment.I0 = 1;
                ExtendFriendSquareFragment.this.ei(z16, str, z17, bArr, z18, z19, i3, list, cVar);
            } catch (Exception e16) {
                QLog.e("ExtendFriendSquareFragment", 1, "onGetSquareStrangerList exception", e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b extends RecyclerView.AdapterDataObserver {
        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            if (ExtendFriendSquareFragment.this.L.v() == 0) {
                ExtendFriendSquareFragment extendFriendSquareFragment = ExtendFriendSquareFragment.this;
                extendFriendSquareFragment.P.removeItemDecoration(extendFriendSquareFragment.R);
            } else {
                ExtendFriendSquareFragment extendFriendSquareFragment2 = ExtendFriendSquareFragment.this;
                extendFriendSquareFragment2.P.removeItemDecoration(extendFriendSquareFragment2.R);
                ExtendFriendSquareFragment extendFriendSquareFragment3 = ExtendFriendSquareFragment.this;
                extendFriendSquareFragment3.P.addItemDecoration(extendFriendSquareFragment3.R);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f263773d;

        c(View view) {
            this.f263773d = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] iArr = new int[2];
            this.f263773d.getLocationInWindow(iArr);
            this.f263773d.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ExtendFriendSquareFragment.this.f263629e0 = iArr[1];
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class d implements ExpandSearchBarView.e {
        d() {
        }

        @Override // com.tencent.mobileqq.qqexpand.widget.search.ExpandSearchBarView.e
        public void a(String str, int i3) {
            boolean z16;
            if (str.equals(ExtendFriendSquareFragment.this.f263636l0)) {
                return;
            }
            ExtendFriendSquareFragment.this.f263636l0 = str;
            if ("\u63a8\u8350".equals(str)) {
                ExtendFriendSquareFragment.this.V0 = false;
                z16 = ExtendFriendSquareFragment.this.hi();
            } else {
                z16 = false;
            }
            boolean ii5 = ExtendFriendSquareFragment.this.ii(false, str);
            long abs = Math.abs(System.currentTimeMillis() - ExtendFriendSquareFragment.this.L0);
            if (!ii5 || abs > 60000 || z16) {
                ExtendFriendSquareFragment.this.N0 = false;
                ExtendFriendSquareFragment.this.L.r();
                ExtendFriendSquareFragment.this.L.notifyDataSetChanged();
                ExtendFriendSquareFragment.this.L.s(false);
                ExtendFriendSquareFragment.this.ki();
                ExtendFriendSquareFragment.this.C0.removeMessages(11);
                ExtendFriendSquareFragment.this.C0.sendEmptyMessageDelayed(11, 500L);
            } else {
                ExtendFriendSquareFragment.this.N0 = true;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("small_tab_id", ExtendFriendSquareFragment.this.f263636l0);
            ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#voice_tab#small_tab", true, -1L, -1L, hashMap, true, true);
        }

        @Override // com.tencent.mobileqq.qqexpand.widget.search.ExpandSearchBarView.e
        public void b() {
            QPublicFragmentActivity.startForResult(ExtendFriendSquareFragment.this.G, (Class<? extends QPublicBaseFragment>) ExtendFriendSearchFragment.class, 3);
            ExtendFriendSquareFragment.this.G.overridePendingTransition(0, R.anim.f155053hw);
            ReportController.o(ExtendFriendSquareFragment.this.H, "dc00898", "", "", "0X8009417", "0X8009417", 0, 0, "", "", "", "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ReportController.o(ExtendFriendSquareFragment.this.H, "dc00898", "", "", "0X8009E2F", "0X8009E2F", 0, 0, "", "", "", "");
            ExtendFriendSquareFragment.this.getClass();
        }
    }

    private void ci() {
        if (!isAdded() || this.L == null || this.N0) {
            return;
        }
        if (NetworkUtil.isNetworkAvailable(this.G)) {
            if (this.M != null) {
                li(1);
                if (this.M.A()) {
                    Eh(false);
                    return;
                } else {
                    this.M.setRefreshing();
                    this.L.B(0, true);
                    return;
                }
            }
            return;
        }
        this.I0 = 0;
        fi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ei(boolean z16, String str, boolean z17, byte[] bArr, boolean z18, boolean z19, int i3, List<com.tencent.mobileqq.qqexpand.bean.feed.b> list, vg2.c cVar) {
        com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a o16;
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendSquareFragment", 2, String.format("handleGetSquareStrangerList success=%s searchKey=%s", Boolean.valueOf(z16), str));
        }
        if (!isAdded() || this.L == null) {
            return;
        }
        Object tag = this.P.getTag(R.id.i4m);
        int intValue = (tag == null || !(tag instanceof Integer)) ? 0 : ((Integer) tag).intValue();
        this.L.z(!z16 ? 1 : 0);
        int i16 = R.string.fjc;
        int i17 = R.string.fjf;
        if (z16 && list != null) {
            this.H0 = z17;
            this.J0 = bArr;
            this.Y = z18;
            this.Z = z19;
            this.K0 = i3;
            vg2.c cVar2 = this.O0;
            cVar2.f441601d = cVar.f441601d;
            cVar2.f441602e = cVar.f441602e;
            cVar2.f441604h = cVar.f441604h;
            cVar2.f441603f.clear();
            this.O0.f441603f.addAll(cVar.f441603f);
            this.R0.g(this.O0.f441603f);
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSquareFragment", 2, String.format("handleGetSquareStrangerList mLoadOver=%s mRequestCookies=%s mProfileComplete=%s mShowCard=%s mMaxLikeCount=%s matchCount=%d limitDuration=%d", Boolean.valueOf(this.H0), this.J0, Boolean.valueOf(this.Y), Boolean.valueOf(this.Z), Integer.valueOf(this.K0), Integer.valueOf(cVar.f441601d), Integer.valueOf(cVar.f441602e)));
            }
            if (!this.G0) {
                this.L.r();
                ji();
            }
            if (this.H0) {
                this.L.B(2, false);
            }
            this.L.q(list);
            PullToRefreshRecyclerView pullToRefreshRecyclerView = this.M;
            if (pullToRefreshRecyclerView != null && (o16 = pullToRefreshRecyclerView.o(true, false)) != null) {
                this.L0 = System.currentTimeMillis();
                this.M0 = Calendar.getInstance().get(6);
                o16.setLastUpdatedLabel(String.format("%s%s", getResources().getString(R.string.hqf), en.p(this.L0, true, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT)));
            }
            ki();
        } else {
            if (this.G0) {
                this.L.B(1, true);
            }
            int i18 = this.I0;
            int i19 = R.string.cqv;
            int i26 = i18 == 0 ? R.string.cqv : R.string.fjf;
            if (intValue == 1) {
                if (i18 != 0) {
                    i19 = R.string.fjc;
                }
                i26 = i19;
            }
            Ch(getString(i26), 1);
        }
        if (this.L.getItemCount() == 0) {
            this.L.s(true);
        }
        this.L.notifyDataSetChanged();
        if (!this.G0 && this.M != null) {
            if (z16) {
                i17 = R.string.fjh;
            }
            if (intValue == 1) {
                if (z16) {
                    i16 = R.string.fjd;
                }
                i17 = i16;
            }
            this.M.o(true, false).setRefreshResultLabel(getResources().getString(i17));
            this.M.F();
            li(0);
        }
        this.F0 = false;
        xh();
        Hh(true);
    }

    private void gi() {
        this.P0.f450269d = new ArrayList<>(5);
        yg2.f fVar = new yg2.f();
        fVar.f450270a = 0;
        fVar.f450272c = getResources().getString(R.string.ixb);
        fVar.f450275f = -20771;
        fVar.f450276g = -31578;
        fVar.f450279j = new ArrayList<>(10);
        this.P0.f450269d.add(fVar);
        ArrayList<ExpandBannerConfBean$BannerItem> bannerConfigList = ((com.tencent.mobileqq.qqexpand.manager.e) this.H.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).getBannerConfigList();
        if (bannerConfigList == null || bannerConfigList.isEmpty()) {
            return;
        }
        Iterator<ExpandBannerConfBean$BannerItem> it = bannerConfigList.iterator();
        while (it.hasNext()) {
            ExpandBannerConfBean$BannerItem next = it.next();
            yg2.f fVar2 = new yg2.f();
            fVar2.f450272c = next.title;
            fVar2.f450271b = next.f263543id;
            fVar2.f450273d = next.subTitle;
            if ("0".equals(next.type)) {
                fVar2.f450270a = 0;
            } else if ("1".equals(next.type)) {
                fVar2.f450270a = 1;
            } else if ("2".equals(next.type)) {
                fVar2.f450270a = 2;
            } else if ("3".equals(next.type)) {
                fVar2.f450270a = 3;
            } else {
                fVar2.f450270a = -1;
            }
            fVar2.f450277h = next.schemeOrUrl;
            fVar2.f450274e = next.iconUrl;
            fVar2.f450278i = next.extra;
            try {
                String str = next.bgBeginColor;
                if (str != null) {
                    fVar2.f450275f = Color.parseColor(str);
                }
                String str2 = next.bgEndColor;
                if (str2 != null) {
                    fVar2.f450276g = Color.parseColor(str2);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ExtendFriendSquareFragment", 2, "parse banner color " + e16);
                }
            }
            this.P0.f450269d.add(fVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hi() {
        return this.M0 >= 0 && Calendar.getInstance().get(6) != this.M0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ii(boolean z16, String str) {
        List<a.C8312a> list;
        a.C8312a c16;
        com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a o16;
        vg2.c cVar;
        vg2.c cVar2;
        List<String> r16 = this.K.r(2);
        com.tencent.mobileqq.qqexpand.bean.feed.a a06 = ((com.tencent.mobileqq.qqexpand.manager.e) this.H.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a0();
        if (a06 == null || (list = a06.f263474a) == null || list.size() <= 0) {
            return false;
        }
        boolean z17 = !z16 ? (c16 = a06.c(str)) == null || c16.f263478a.size() <= 0 : (c16 = a06.d()) == null || c16.f263478a.size() <= 0 || !r16.contains(c16.f263482e);
        if (z17) {
            this.Y = a06.f263475b;
            this.Z = a06.f263476c;
            this.K0 = a06.f263477d;
            this.H0 = c16.f263483f;
            this.J0 = c16.f263481d;
            this.L0 = c16.f263479b;
            this.M0 = c16.f263480c;
            this.f263636l0 = c16.f263482e;
            final int i3 = c16.f263484g;
            final int i16 = c16.f263485h;
            if (c16.f263478a.size() > 0) {
                com.tencent.mobileqq.qqexpand.bean.feed.b bVar = c16.f263478a.get(0);
                if ((bVar instanceof vg2.c) && (cVar2 = this.O0) != (cVar = (vg2.c) bVar)) {
                    cVar2.f441601d = cVar.f441601d;
                    cVar2.f441602e = cVar.f441602e;
                    cVar2.f441604h = cVar.f441604h;
                    cVar2.f441603f.clear();
                    this.O0.f441603f.addAll(cVar.f441603f);
                    this.R0.g(this.O0.f441603f);
                }
            }
            if (z16) {
                this.Q0.setSearchTags((ArrayList) r16, r16.indexOf(this.f263636l0));
            }
            com.tencent.mobileqq.qqexpand.fragment.d dVar = this.L;
            if (dVar != null) {
                if (this.H0) {
                    dVar.B(2, false);
                } else {
                    dVar.B(0, false);
                }
                this.L.r();
                this.L.q(c16.f263478a);
                ji();
                this.L.notifyDataSetChanged();
                if (Math.abs(System.currentTimeMillis() - this.L0) < 60000) {
                    this.P.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment.9
                        @Override // java.lang.Runnable
                        public void run() {
                            ExtendFriendSquareFragment.this.N.scrollToPositionWithOffset(i3, i16);
                        }
                    }, 100L);
                }
                xh();
                Hh(true);
            }
            PullToRefreshRecyclerView pullToRefreshRecyclerView = this.M;
            if (pullToRefreshRecyclerView != null && (o16 = pullToRefreshRecyclerView.o(true, false)) != null) {
                o16.setLastUpdatedLabel(String.format("%s%s", getResources().getString(R.string.hqf), en.p(this.L0, true, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT)));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("ExtendFriendSquareFragment", 2, String.format("loadCacheData result=%b ts=%d tag=%s", Boolean.valueOf(z17), Long.valueOf(this.L0), this.f263636l0));
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ji() {
        boolean z16;
        yg2.e eVar;
        yg2.f fVar;
        if (this.L == null || this.H == null || !"\u63a8\u8350".equals(this.f263636l0)) {
            return;
        }
        boolean z17 = false;
        if (this.C == 0) {
            com.tencent.mobileqq.qqexpand.manager.e eVar2 = (com.tencent.mobileqq.qqexpand.manager.e) this.H.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
            boolean p16 = eVar2.p();
            byte b16 = eVar2.d0() == 0;
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSquareFragment", 2, String.format("refreshFeedBanner limitChatSwitch=%s mTabPos=%s", Boolean.valueOf(p16), Integer.valueOf(this.C)));
            }
            if (p16 && b16 == true) {
                this.S0 = true;
                com.tencent.mobileqq.qqexpand.bean.feed.b u16 = this.L.u(0);
                if (u16 instanceof yg2.e) {
                    eVar = (yg2.e) u16;
                    z16 = false;
                } else {
                    this.L.p(0, this.P0);
                    eVar = this.P0;
                    z16 = true;
                }
                ArrayList<yg2.f> arrayList = eVar.f450269d;
                if (arrayList != null) {
                    Iterator<yg2.f> it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            fVar = null;
                            break;
                        }
                        fVar = it.next();
                        if (fVar.f450270a == 0) {
                            List<String> list = this.O0.f441603f;
                            if (list != null && !list.isEmpty()) {
                                fVar.f450279j = new ArrayList<>(this.O0.f441603f);
                            }
                            if (this.O0.f441604h > 0) {
                                if (eVar.f450269d.size() > 1) {
                                    fVar.f450273d = String.format(getResources().getString(R.string.fj6), Integer.valueOf(this.O0.f441604h));
                                } else {
                                    fVar.f450273d = this.O0.f441604h + getString(R.string.w48);
                                }
                            }
                        }
                    }
                    if (fVar != null) {
                        this.L.w(fVar);
                    }
                }
            } else {
                z16 = false;
            }
            boolean s16 = eVar2.s();
            int N = eVar2.N();
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSquareFragment", 2, String.format("refreshFeedBanner needShowVerifyTips=%s verifyStatus=%s", Boolean.valueOf(s16), Integer.valueOf(N)));
            }
            boolean z18 = this.S0;
            if (this.L.u(z18 ? 1 : 0) instanceof i) {
                this.L.remove(z18 ? 1 : 0);
                z17 = true;
                if (z17) {
                    this.L.notifyDataSetChanged();
                }
                if (!this.S0 || this.V0) {
                    return;
                }
                ReportController.o(this.H, "dc00898", "", "", "0X80096A4", "0X80096A4", 0, 0, "", "", "", "");
                this.V0 = true;
                return;
            }
            z17 = z16;
            if (z17) {
            }
            if (this.S0) {
                return;
            } else {
                return;
            }
        }
        if (this.L.u(0) instanceof yg2.e) {
            this.L.remove(0);
            z17 = true;
        }
        if (z17) {
        }
        if (this.S0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ki() {
        com.tencent.mobileqq.qqexpand.manager.e eVar = (com.tencent.mobileqq.qqexpand.manager.e) this.H.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        com.tencent.mobileqq.qqexpand.bean.feed.a a06 = eVar.a0();
        if (a06 == null) {
            a06 = new com.tencent.mobileqq.qqexpand.bean.feed.a();
        }
        if (this.L != null) {
            a.C8312a c8312a = new a.C8312a();
            c8312a.f263478a.addAll(this.L.getList());
            c8312a.f263479b = this.L0;
            c8312a.f263480c = this.M0;
            c8312a.f263483f = this.H0;
            c8312a.f263481d = this.J0;
            c8312a.f263482e = this.f263636l0;
            int findFirstVisibleItemPosition = this.N.findFirstVisibleItemPosition();
            c8312a.f263484g = findFirstVisibleItemPosition;
            if (findFirstVisibleItemPosition < 0) {
                c8312a.f263484g = 0;
            }
            View findViewByPosition = this.N.findViewByPosition(c8312a.f263484g);
            if (findViewByPosition != null) {
                c8312a.f263485h = findViewByPosition.getTop();
            }
            boolean z16 = this.Y;
            a06.f263475b = z16;
            boolean z17 = this.Z;
            a06.f263476c = z17;
            int i3 = this.K0;
            a06.f263477d = i3;
            a06.b(c8312a, z16, z17, i3);
        }
        eVar.O(a06);
        if (QLog.isColorLevel()) {
            QLog.i("ExtendFriendSquareFragment", 2, String.format("saveCacheData %s", a06.toString()));
        }
    }

    private void li(int i3) {
        this.M.o(true, false).setRefreshingLabel(getResources().getString(i3 == 1 ? R.string.fje : R.string.fjg));
        this.P.setTag(R.id.i4m, Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi(int i3, float f16) {
        if (QLog.isColorLevel()) {
            QLog.i("ExtendFriendSquareFragment", 2, "updateSearchBarState scrollY: " + i3 + "  speed: " + f16);
        }
        ExpandSearchBarView expandSearchBarView = this.Q0;
        if (expandSearchBarView != null) {
            if (i3 < this.A0) {
                if (i3 <= this.U0 / 2) {
                    expandSearchBarView.j();
                } else if (f16 > 0.0f) {
                    expandSearchBarView.e();
                }
            } else if (f16 < -5.0f) {
                expandSearchBarView.j();
            } else if (f16 > 0.5d) {
                expandSearchBarView.e();
            }
        }
        ni(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi() {
        com.tencent.mobileqq.qqexpand.manager.e eVar = this.K;
        List<String> r16 = eVar != null ? eVar.r(2) : null;
        if (r16 != null) {
            this.Q0.setSearchTags((ArrayList) r16, 0);
            this.C0.post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    ExtendFriendSquareFragment.this.Q0.i(ExtendFriendSquareFragment.this.f263636l0);
                }
            });
        }
    }

    private void registerDaTongReport(View view) {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(view, "voice_tab");
        VideoReport.setPageParams(view, new com.tencent.mobileqq.qqexpand.fragment.a().a());
        QLog.i("ExtendFriendSquareFragment", 1, "reportDaTongRegister");
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment
    protected int Ah() {
        return this.K0;
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment
    protected int Bh() {
        return 1031;
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment
    public void Eh(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendSquareFragment", 2, String.format("requestSquareStrangerList loadMore=%s", Boolean.valueOf(z16)));
        }
        this.G0 = z16;
        if (!z16) {
            this.H0 = false;
            this.J0 = null;
        }
        if (this.J != null) {
            this.f263637m0 = System.currentTimeMillis();
            this.J.G0(this.H.getCurrentUin(), this.J0, 20, this.f263636l0, this.f263637m0, "\u63a8\u8350", true);
            this.F0 = true;
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.d
    public void F4(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendSquareFragment", 2, "onPullDownToRefresh  mRecyclerViewScrollY:" + this.f263764z0);
        }
        if (QLog.isColorLevel()) {
            QLog.i("ExtendFriendSquareFragment", 2, "onPullDownToRefresh state:" + pullToRefreshBase.t() + " lastCacheOk:" + this.N0);
        }
        if (this.S.hasMessages(10)) {
            this.S.removeMessages(10);
            Dh();
        }
        ReportController.o(this.H, "dc00898", "", "", "0X80092D4", "0X80092D4", 0, 0, "", "", "", "");
        if (pullToRefreshBase.t() == PullToRefreshBase.State.MANUAL_REFRESHING && this.N0) {
            this.M.F();
        } else if (NetworkUtil.isNetworkAvailable(this.G)) {
            Eh(false);
            Ih();
            this.L.B(0, true);
        } else {
            this.I0 = 0;
            fi();
        }
        oi(this.f263764z0, 0.0f);
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment, yg2.g.c
    public void Kg() {
        super.Kg();
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendSquareFragment", 2, "limitchat enter match");
        }
        if (Fh()) {
            ReportController.o(null, "dc00898", "", "", "kuolie", "0X80097DD", 0, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSquareFragment", 2, "onMatchItemClick, showExtendFriendQuestionDialog");
                return;
            }
            return;
        }
        ReportController.o(this.H, "dc00898", "", "", "0X80096A5", "0X80096A5", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment
    public void Kh(boolean z16, boolean z17) {
        super.Kh(z16, z17);
        if (z16 || z17) {
            ki();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment
    public void Mh() {
        LinearLayoutManager linearLayoutManager = this.N;
        boolean z16 = false;
        ArrayList<String> arrayList = null;
        if (linearLayoutManager != null && this.L != null) {
            int findLastVisibleItemPosition = this.N.findLastVisibleItemPosition();
            for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
                com.tencent.mobileqq.qqexpand.bean.feed.b u16 = this.L.u(findFirstVisibleItemPosition);
                RecyclerView.ViewHolder findViewHolderForPosition = this.P.findViewHolderForPosition(findFirstVisibleItemPosition);
                if (u16 != null && findViewHolderForPosition != null && (findViewHolderForPosition instanceof j)) {
                    j jVar = (j) findViewHolderForPosition;
                    jVar.f450299f.setImageDrawable(K7(u16.mUin, u16.mNickName, jVar.f450299f));
                } else if (u16 instanceof yg2.e) {
                    Iterator<yg2.f> it = ((yg2.e) u16).f450269d.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            yg2.f next = it.next();
                            if (next.f450270a == 0) {
                                arrayList = next.f450279j;
                                z16 = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (this.S0) {
            this.R0.f(z16);
            this.R0.g(arrayList);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.ExtendFriendCampusVerifyTipsView.a
    public void T5(int i3) {
        CampusHelper.i(this.H, false);
        ji();
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.ExtendFriendCampusVerifyTipsView.a
    public void d7(int i3) {
        ExtendFriendCampusVerifyTipsView.a(this.G, this.H);
    }

    public int di() {
        int findFirstVisibleItemPosition;
        View findViewByPosition;
        LinearLayoutManager linearLayoutManager = this.N;
        if (linearLayoutManager == null || (findViewByPosition = this.N.findViewByPosition((findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()))) == null) {
            return 0;
        }
        return (findFirstVisibleItemPosition * findViewByPosition.getHeight()) - (findViewByPosition.getTop() - BaseAIOUtils.f(11.0f, getResources()));
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what != 11) {
            return false;
        }
        ci();
        return false;
    }

    public void ni(boolean z16) {
        PullToRefreshRecyclerView pullToRefreshRecyclerView;
        if (!this.f263763y0 || z16) {
            ExpandSearchBarView expandSearchBarView = this.Q0;
            if (expandSearchBarView != null && (pullToRefreshRecyclerView = this.M) != null) {
                expandSearchBarView.k(pullToRefreshRecyclerView.getHeight());
            }
            this.f263763y0 = true;
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendSquareFragment", 2, String.format("onActivityResult requestCode=%s resultCode=%s", Integer.valueOf(i3), Integer.valueOf(i16)));
        }
        if (i3 == 1031) {
            Jh();
            Kh(true, true);
            if (i16 == 8193) {
                th();
            }
            this.W = -1;
            return;
        }
        if (i3 == 1 && i16 == -1) {
            com.tencent.mobileqq.qqexpand.bean.feed.b u16 = this.L.u(this.V);
            if (u16 == null || u16.mAddFriendVerified) {
                return;
            }
            u16.mAddFriendVerified = true;
            this.L.notifyItemChanged(this.V);
            return;
        }
        if (i3 == 2 && i16 == -1) {
            Kh(false, true);
            return;
        }
        if (i3 == 3 && i16 == -1 && intent != null) {
            if (intent.getBooleanExtra("has_entered_profile", false)) {
                Kh(true, true);
            }
            if (intent.hasExtra("add_frd_list")) {
                mi(intent.getStringArrayListExtra("add_frd_list"));
            }
            if (intent.hasExtra("remain_match_count")) {
                int intExtra = intent.getIntExtra("remain_match_count", 0);
                vg2.c cVar = this.O0;
                if (intExtra != cVar.f441601d) {
                    cVar.f441601d = intExtra;
                    if (QLog.isColorLevel()) {
                        QLog.i("ExtendFriendSquareFragment", 2, String.format("onActivityResult update remainMatchCount=%d", Integer.valueOf(this.O0.f441601d)));
                    }
                }
            }
            if (intent.hasExtra("limit_chat_duration")) {
                int intExtra2 = intent.getIntExtra("limit_chat_duration", 0);
                vg2.c cVar2 = this.O0;
                if (intExtra2 != cVar2.f441602e) {
                    cVar2.f441602e = intExtra2;
                    if (QLog.isColorLevel()) {
                        QLog.i("ExtendFriendSquareFragment", 2, String.format("onActivityResult update limitChatDuration=%d", Integer.valueOf(this.O0.f441602e)));
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendSquareFragment", 2, "onCreate");
        }
        super.onCreate(bundle);
        QQAppInterface qQAppInterface = this.H;
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(this.W0);
            this.H.addObserver(this.D0);
            ((com.tencent.mobileqq.qqexpand.manager.e) this.H.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).k(this.G);
        }
        this.C0 = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.T0 = new com.tencent.mobileqq.qqexpand.fragment.c(this.H);
        gi();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendSquareFragment", 2, "onCreateView");
        }
        this.U0 = BaseAIOUtils.f(35.0f, getResources());
        this.A0 = BaseAIOUtils.f(160.0f, getResources());
        View inflate = layoutInflater.inflate(R.layout.aui, (ViewGroup) null);
        PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView) inflate.findViewById(R.id.g5m);
        this.M = pullToRefreshRecyclerView;
        pullToRefreshRecyclerView.setOnRefreshListener(this);
        this.N = new o(this.G);
        RecyclerView s16 = this.M.s();
        this.P = s16;
        s16.setId(R.id.i4m);
        this.P.setLayoutManager(this.N);
        ((SimpleItemAnimator) this.P.getItemAnimator()).setSupportsChangeAnimations(false);
        this.P.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment.3
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
                if (QLog.isColorLevel()) {
                    QLog.d("ExtendFriendSquareFragment", 2, String.format("onScrollStateChanged state=%s", Integer.valueOf(i3)));
                }
                ExtendFriendSquareFragment extendFriendSquareFragment = ExtendFriendSquareFragment.this;
                IFaceDecoder iFaceDecoder = extendFriendSquareFragment.F;
                if (iFaceDecoder != null) {
                    if (i3 == 0) {
                        extendFriendSquareFragment.f263625a0 = false;
                        iFaceDecoder.resume();
                        ExtendFriendSquareFragment.this.Mh();
                    } else {
                        extendFriendSquareFragment.f263625a0 = true;
                        iFaceDecoder.pause();
                        ExtendFriendSquareFragment.this.F.cancelPendingRequests();
                        synchronized (ExtendFriendBaseFragment.f263622v0) {
                            Map<ImageView, String> map = ExtendFriendSquareFragment.this.D;
                            if (map != null) {
                                map.clear();
                            }
                        }
                    }
                }
                if (i3 == 0) {
                    ExtendFriendSquareFragment.this.ki();
                    ExtendFriendSquareFragment.this.xh();
                    ExtendFriendSquareFragment.this.Hh(false);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
                float f16;
                ExtendFriendSquareFragment extendFriendSquareFragment;
                LinearLayoutManager linearLayoutManager;
                com.tencent.mobileqq.qqexpand.fragment.d dVar;
                ExtendFriendSquareFragment extendFriendSquareFragment2 = ExtendFriendSquareFragment.this;
                extendFriendSquareFragment2.f263764z0 = extendFriendSquareFragment2.di();
                if (ExtendFriendSquareFragment.this.B0 != -1) {
                    long currentTimeMillis = System.currentTimeMillis() - ExtendFriendSquareFragment.this.B0;
                    if (currentTimeMillis > 0 && currentTimeMillis < 2000) {
                        f16 = (i16 * 1.0f) / ((float) currentTimeMillis);
                        ExtendFriendSquareFragment.this.B0 = System.currentTimeMillis();
                        ExtendFriendSquareFragment extendFriendSquareFragment3 = ExtendFriendSquareFragment.this;
                        extendFriendSquareFragment3.oi(extendFriendSquareFragment3.f263764z0, f16);
                        if (!ExtendFriendSquareFragment.this.H0 || ExtendFriendSquareFragment.this.F0 || (linearLayoutManager = (extendFriendSquareFragment = ExtendFriendSquareFragment.this).N) == null || (dVar = extendFriendSquareFragment.L) == null || linearLayoutManager.findViewByPosition(dVar.getItemCount() - 2) == null) {
                            return;
                        }
                        ExtendFriendSquareFragment.this.Eh(true);
                        ExtendFriendSquareFragment.this.C0.post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    ExtendFriendSquareFragment.this.L.B(0, true);
                                } catch (Exception e16) {
                                    QLog.e("ExtendFriendSquareFragment", 1, "onScrolled fail.", e16);
                                }
                            }
                        });
                        ReportController.o(ExtendFriendSquareFragment.this.H, "dc00898", "", "", "0X80092D5", "0X80092D5", 0, 0, "", "", "", "");
                        return;
                    }
                }
                f16 = 0.0f;
                ExtendFriendSquareFragment.this.B0 = System.currentTimeMillis();
                ExtendFriendSquareFragment extendFriendSquareFragment32 = ExtendFriendSquareFragment.this;
                extendFriendSquareFragment32.oi(extendFriendSquareFragment32.f263764z0, f16);
                if (ExtendFriendSquareFragment.this.H0) {
                }
            }
        });
        this.R = new com.tencent.mobileqq.qqexpand.fragment.e(this);
        this.Q = new b();
        com.tencent.mobileqq.qqexpand.fragment.d dVar = new com.tencent.mobileqq.qqexpand.fragment.d(this, this, this, this, this.P, this.G, 0);
        this.L = dVar;
        dVar.A(BaseAIOUtils.f(0.0f, getResources()));
        this.L.registerAdapterDataObserver(this.Q);
        this.L.y(this.T0);
        this.P.setAdapter(this.L);
        this.f263630f0 = (NearbyZanAnimLayout) this.G.findViewById(R.id.f165689d53);
        View findViewById = this.G.findViewById(R.id.b9w);
        if (findViewById != null) {
            findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new c(findViewById));
        }
        ExpandSearchBarView expandSearchBarView = (ExpandSearchBarView) inflate.findViewById(R.id.iir);
        this.Q0 = expandSearchBarView;
        expandSearchBarView.setVisibility(8);
        this.Q0.setItemClickListener(new d());
        ExtendFriendBottomBarView extendFriendBottomBarView = (ExtendFriendBottomBarView) inflate.findViewById(R.id.f164624ac1);
        this.R0 = extendFriendBottomBarView;
        extendFriendBottomBarView.b(this.H, this.M);
        this.R0.setOnClickListener(new e());
        registerDaTongReport(findViewById);
        return inflate;
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendSquareFragment", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        super.onDestroy();
        com.tencent.mobileqq.qqexpand.fragment.c cVar = this.T0;
        if (cVar != null) {
            cVar.c();
            this.T0 = null;
        }
        QQAppInterface qQAppInterface = this.H;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.W0);
            this.H.removeObserver(this.D0);
            this.H = null;
        }
        RecyclerView.AdapterDataObserver adapterDataObserver = this.Q;
        if (adapterDataObserver != null) {
            this.L.unregisterAdapterDataObserver(adapterDataObserver);
        }
        this.L.onDestroy();
        this.G = null;
        this.J = null;
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendSquareFragment", 2, "onResume");
        }
        super.onResume();
        if (!this.E0 && isAdded()) {
            boolean ii5 = ii(true, null);
            long currentTimeMillis = System.currentTimeMillis() - this.L0;
            if (ii5 && currentTimeMillis <= 60000 && !hi()) {
                this.N0 = true;
            } else {
                this.N0 = false;
                this.f263636l0 = "\u63a8\u8350";
                this.Q0.setSearchTags((ArrayList) this.K.r(2), 0);
                this.C0.removeMessages(11);
                this.C0.sendEmptyMessageDelayed(11, 500L);
            }
            this.E0 = true;
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSquareFragment", 2, String.format("onResume loadSuccess=%s interval=%s", Boolean.valueOf(ii5), Long.valueOf(currentTimeMillis)));
            }
            this.C0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment.8
                @Override // java.lang.Runnable
                public void run() {
                    ExtendFriendSquareFragment.this.Q0.i(ExtendFriendSquareFragment.this.f263636l0);
                }
            }, 100L);
        } else if (hi()) {
            this.N0 = false;
            this.C0.removeMessages(11);
            this.C0.sendEmptyMessageDelayed(11, 500L);
        } else {
            ji();
            this.L.notifyDataSetChanged();
        }
        oi(this.f263764z0, 0.0f);
        ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#voice_tab#view", true, -1L, -1L, null, true, true);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.d
    public void s5(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendSquareFragment", 2, "onPullUpToRefresh  mRecyclerViewScrollY:" + this.f263764z0);
        }
    }

    private void fi() {
        ei(false, this.f263636l0, false, null, false, false, 0, null, null);
    }

    private void mi(List<String> list) {
        com.tencent.mobileqq.qqexpand.bean.feed.b u16;
        if (list == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ExtendFriendSquareFragment", 2, String.format("updateAddFrdState count=%d", Integer.valueOf(list.size())));
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            int t16 = this.L.t(it.next());
            if (t16 >= 0 && (u16 = this.L.u(t16)) != null && !u16.mAddFriendVerified) {
                u16.mAddFriendVerified = true;
                this.L.notifyItemChanged(t16);
            }
        }
    }
}
