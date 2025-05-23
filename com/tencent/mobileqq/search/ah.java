package com.tencent.mobileqq.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.mobileqq.app.di;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.business.search.UinSearchConfProcessor;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.mobileqq.search.util.ai;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.text.style.LinkSpan;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQLoadingUtil;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ActionSheet;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import tencent.im.oidb.search.DynamicTabSearch$SubHotWord;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ah implements ActionSheet.OnButtonClickListener, ActionSheet.OnDismissListener, ActionSheet.WatchDismissActions {
    private String C;
    private boolean D;
    private String E;
    private ActionSheet F;
    private ActionSheet.ItemViewHolder G;
    private boolean H;
    private boolean I;
    private long J;
    private long K;
    private ArrayList<com.tencent.mobileqq.search.model.v> L;
    private lo2.c M;
    private lo2.c N;
    private lo2.c P;
    private int Q;
    private int R;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f282724d;

    /* renamed from: e, reason: collision with root package name */
    private UnifySearchHandler f282725e;

    /* renamed from: f, reason: collision with root package name */
    private String f282726f;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<Context> f282728i;

    /* renamed from: m, reason: collision with root package name */
    private int f282729m;

    /* renamed from: h, reason: collision with root package name */
    private long[] f282727h = {1001, Constant.FROM_ID_UNINSTALL_PLUGIN, 8001};
    private boolean S = false;
    private di T = new a();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends di {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        private boolean l(String str, String str2, long[] jArr) {
            if (!n(str, str2, jArr) && !m((Context) ah.this.f282728i.get())) {
                return false;
            }
            return true;
        }

        private boolean m(Context context) {
            if (context != null && ah.this.f282724d != null) {
                if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                    QLog.e("UinSearcher", 1, "isFinish activity is finish");
                    return true;
                }
                return false;
            }
            QLog.e("UinSearcher", 1, "isFinish context or app is null");
            return true;
        }

        private boolean n(String str, String str2, long[] jArr) {
            if (!TextUtils.equals(str2, "" + ah.this.J)) {
                QLog.d("UinSearcher", 1, "Unify handleTabSearchResult. time not match");
                return true;
            }
            if (ActiveEntitySearchFragment.Jh(ah.this.f282727h, jArr) && str.equals(ah.this.f282726f)) {
                return false;
            }
            QLog.d("UinSearcher", 1, "Unify handleTabSearchResult.  reqKeyword=" + str + " keyword=" + ah.this.f282726f);
            return true;
        }

        @Override // com.tencent.mobileqq.app.di
        public void j(String str, boolean z16, String str2, int i3, String str3, long[] jArr, String str4) {
            QLog.d("UinSearcher", 1, "handleTabSearchError  resultCode=" + i3 + " errorMsg=" + str3);
            if (!l(str, str2, jArr)) {
                ah.this.C(false, null, null, null, null);
                QQToast.makeText(BaseApplication.context, 0, R.string.vyw, 0).show();
                ReportController.o(ah.this.f282724d, "dc00898", "", "", "0X800B0C0", "0X800B0C0", ah.t(ah.this.f282729m), 0, "", "", "", "");
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x00f4, code lost:
        
            if (r8.J() != 1002) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0104, code lost:
        
            if (android.text.TextUtils.equals(r13.f282730d.f282726f, r8.getUin()) == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0106, code lost:
        
            if (r6 == null) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0108, code lost:
        
            r13.f282730d.L.add(r6);
            r6 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0112, code lost:
        
            r13.f282730d.L.add(r7);
            r5 = r8;
         */
        @Override // com.tencent.mobileqq.app.di
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void k(String str, boolean z16, String str2, byte[] bArr, boolean z17, List<com.tencent.mobileqq.search.model.x> list, long[] jArr, String str3, List<DynamicTabSearch$SubHotWord> list2, boolean z18, String str4, int i3, String str5) {
            String str6;
            QLog.d("UinSearcher", 1, "handleTabSearchResult");
            if (l(str, str2, jArr)) {
                return;
            }
            if (list == null) {
                ah.this.C(true, null, null, null, null);
                ReportController.o(ah.this.f282724d, "dc00898", "", "", "0X800A923", "0X800A923", LinkSpan.n(ah.this.f282724d, ah.this.D, ah.this.f282729m, ah.this.C), 0, "", "", "", "");
                return;
            }
            List<com.tencent.mobileqq.search.model.v> m3 = SearchUtil.m(list, z16, false);
            ah.this.L = new ArrayList();
            Iterator<com.tencent.mobileqq.search.model.v> it = m3.iterator();
            lo2.c cVar = null;
            lo2.c cVar2 = null;
            lo2.c cVar3 = null;
            com.tencent.mobileqq.search.model.i iVar = null;
            while (it.hasNext()) {
                com.tencent.mobileqq.search.model.v next = it.next();
                if (next instanceof com.tencent.mobileqq.search.model.i) {
                    iVar = (com.tencent.mobileqq.search.model.i) next;
                } else if (next instanceof lo2.c) {
                    lo2.c cVar4 = (lo2.c) next;
                    if (cVar == null && cVar4.J() == 1001 && TextUtils.equals(ah.this.f282726f, cVar4.getUin())) {
                        if (iVar != null) {
                            ah.this.L.add(iVar);
                            iVar = null;
                        }
                        ah.this.L.add(next);
                        cVar = cVar4;
                    } else if (cVar2 == null && cVar4.J() == 8001 && ah.this.f282726f != null && ah.this.f282726f.equals(cVar4.getKeyword())) {
                        cVar2 = cVar4;
                    }
                }
            }
            ah ahVar = ah.this;
            ahVar.C(true, ahVar.L, cVar, cVar3, cVar2);
            UinSearchConfProcessor.a aVar = (UinSearchConfProcessor.a) am.s().x(com.tencent.luggage.wxa.c3.f.CTRL_INDEX);
            String str7 = cVar == null ? cVar3 == null ? "0X800A923" : "0X800A921" : cVar3 == null ? "0X800A920" : "0X800A922";
            if (aVar.c()) {
                str6 = UinSearchConfProcessor.a.f202821b + "";
            } else {
                str6 = UinSearchConfProcessor.a.f202822c + "";
            }
            ReportController.o(ah.this.f282724d, "dc00898", "", "", str7, str7, LinkSpan.n(ah.this.f282724d, ah.this.D, ah.this.f282729m, ah.this.C), 0, str6, "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements ActionSheet.OnButtonClickListener {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            Context context = (Context) ah.this.f282728i.get();
            if (context == null) {
                return;
            }
            int id5 = view.getId();
            if (id5 == R.id.sgw) {
                ah.this.A(context);
                ah.this.F("0X800C044");
            } else if (id5 == R.id.sgu) {
                ah.this.y(context);
                ah.this.F("0X800C043");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f282732d;

        c(ActionSheet actionSheet) {
            this.f282732d = actionSheet;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f282732d.dismiss();
            ah.this.F("0X800C045");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements QQLoadingUtil.a {
        d() {
        }

        @Override // com.tencent.mobileqq.utils.QQLoadingUtil.a
        public void onFail() {
            if (ah.this.I) {
                ah.this.J(R.drawable.common_loading6, null);
            }
        }

        @Override // com.tencent.mobileqq.utils.QQLoadingUtil.a
        public void onLoad(LottieDrawable lottieDrawable) {
            if (ah.this.I) {
                ah.this.K(lottieDrawable, null);
                lottieDrawable.start();
            }
        }
    }

    public ah(QQAppInterface qQAppInterface, Context context, String str) {
        this.f282724d = qQAppInterface;
        this.f282728i = new WeakReference<>(context);
        this.E = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Context context) {
        if (!w() || TextUtils.isEmpty(this.P.f415197o0)) {
            return;
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(context, "1110436437", this.P.f415197o0, null, 2111, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void B(Context context) {
        String str;
        int i3;
        ActionSheet actionSheet;
        if (this.I) {
            return;
        }
        if (this.Q == 0 && !NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(BaseApplication.context, 0, R.string.vyw, 0).show();
            return;
        }
        if (this.S) {
            int i16 = this.Q;
            if (i16 == 5) {
                str = "1";
            } else if (i16 == 3) {
                str = "2";
            } else if (i16 == 0) {
                str = "3";
            }
            ReportController.o(this.f282724d, "dc00898", "", "", "0X800BED2", "0X800BED2", this.R, 0, str, "", "", "");
            i3 = this.Q;
            if (i3 == 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 == 5) {
                                    if (StudyModeManager.w()) {
                                        com.tencent.mobileqq.guild.util.qqui.g.c(0, R.string.f214315sk);
                                    } else {
                                        z(context);
                                    }
                                }
                            } else {
                                E(context);
                            }
                        } else if (StudyModeManager.w()) {
                            com.tencent.mobileqq.guild.util.qqui.g.c(0, R.string.f214315sk);
                        } else {
                            x(this.N, context);
                        }
                    } else {
                        D(context);
                    }
                } else if (StudyModeManager.w()) {
                    com.tencent.mobileqq.guild.util.qqui.g.c(0, R.string.f214315sk);
                } else {
                    r(this.M, context);
                }
            } else if (TextUtils.equals(this.G.titleTv.getText(), u(R.string.f171677k51)) && StudyModeManager.w()) {
                com.tencent.mobileqq.guild.util.qqui.g.c(0, R.string.f214315sk);
            } else {
                z(context);
            }
            actionSheet = this.F;
            if (actionSheet == null && actionSheet.isShowing()) {
                this.F.dismiss();
                return;
            }
        }
        str = "";
        ReportController.o(this.f282724d, "dc00898", "", "", "0X800BED2", "0X800BED2", this.R, 0, str, "", "", "");
        i3 = this.Q;
        if (i3 == 0) {
        }
        actionSheet = this.F;
        if (actionSheet == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z16, ArrayList<com.tencent.mobileqq.search.model.v> arrayList, lo2.c cVar, lo2.c cVar2, lo2.c cVar3) {
        String str;
        boolean z17 = false;
        this.I = false;
        this.K = System.currentTimeMillis();
        this.M = cVar;
        this.N = cVar2;
        this.P = cVar3;
        this.L = arrayList;
        L(cVar, cVar2);
        long j3 = this.K - this.J;
        if (z16 || j3 <= 3000) {
            z17 = true;
        }
        QQAppInterface qQAppInterface = this.f282724d;
        int i3 = this.R;
        if (z17) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800BED3", "0X800BED3", i3, 0, str, String.valueOf(j3), "", "");
    }

    private void D(Context context) {
        AllInOne allInOne = new AllInOne(this.f282726f, 1);
        allInOne.profileEntryType = 124;
        ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).openProfileCard(context, allInOne);
        ReportController.o(this.f282724d, "dc00898", "", "", "0X800AA69", "0X800AA69", this.R, 0, "", "", "", "");
    }

    private void E(Context context) {
        Intent intent = new Intent();
        intent.putExtra(AppConstants.Key.TROOP_CODE, ((TroopManager) this.f282724d.getManager(QQManagerFactory.TROOP_MANAGER)).k(this.f282726f).troopcode);
        intent.putExtra("troop_uin", this.f282726f);
        intent.putExtra("KEY_SOURCE_AIO_APPEAR_FROM", "41");
        TroopUtils.I(context, intent.getExtras(), 2);
        ReportController.o(this.f282724d, "dc00898", "", "", "0X800AA6A", "0X800AA6A", this.R, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str) {
        ReportController.o(this.f282724d, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }

    private void G(Context context) {
        ActionSheet create = ActionSheet.create(context);
        this.F = create;
        create.setMainTitle(String.format(context.getString(R.string.clm), this.f282726f));
        this.F.addButton(R.string.aet, 0, R.id.f164089om);
        this.F.addButton(R.string.ano, 0, R.id.f164088m5);
        this.F.addButton(R.string.f170068ey, 0, R.id.f164086jg);
        this.F.addDivider();
        this.F.addButtonWithLeftIcon(context.getString(R.string.f171677k51), context.getDrawable(R.drawable.qui_search_primary), 0, "", R.id.sgx);
        this.F.addCancelButton(R.string.cancel);
        this.F.setOnButtonClickListener(this);
        this.F.setOnDismissListener(this);
        this.F.registerWatchDisMissActionListener(this);
        this.F.setCustomItemHeight(56.0f);
        this.F.setRoundCornerTop(true);
        this.F.preInitView();
        this.G = this.F.getItemViewById(R.id.sgx);
        I();
        this.H = false;
        this.F.show();
    }

    private void H(Context context) {
        ActionSheet create = ActionSheet.create(context);
        create.setRedStyleMainTitle(this.f282726f + this.P.f415196n0);
        create.addButton(R.string.ant, 0, R.id.sgw);
        create.addButton(R.string.zoi, 0, R.id.sgu);
        create.addDivider();
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new b());
        create.setOnBottomCancelListener(new c(create));
        create.setCustomItemHeight(56.0f);
        create.setRoundCornerTop(true);
        create.preInitView();
        create.show();
        F("0X800C042");
    }

    private void I() {
        if (NetworkUtil.isNetworkAvailable() && this.f282728i.get() != null) {
            K(null, null);
            QQLoadingUtil.a(this.f282728i.get(), "images/lottie/qq_loading_black.json", new d());
            this.f282724d.addObserver(this.T);
            this.J = System.currentTimeMillis();
            this.I = true;
            if (this.f282725e == null) {
                this.f282725e = (UnifySearchHandler) this.f282724d.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER);
            }
            this.f282725e.R2(this.f282726f, this.J + "", 20, SearchUtil.p(this.f282727h), null, null, 0, 0.0d, 0.0d, null, "{ \"search_by_id_only\": 1 }", 3000L, 1);
            return;
        }
        J(R.drawable.qui_search_primary, u(R.string.f171677k51));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i3, String str) {
        Context context = this.f282728i.get();
        if (context == null) {
            return;
        }
        K(context.getResources().getDrawable(i3), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(Drawable drawable, String str) {
        ImageView imageView;
        ActionSheet.ItemViewHolder itemViewHolder = this.G;
        if (itemViewHolder != null && (imageView = itemViewHolder.iconIv) != null && itemViewHolder.titleTv != null) {
            imageView.setImageDrawable(drawable);
            if (TextUtils.isEmpty(str)) {
                ViewGroup.LayoutParams layoutParams = this.G.iconIv.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = 0;
                    this.G.iconIv.setLayoutParams(layoutParams);
                }
                this.G.titleTv.setVisibility(8);
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.G.iconIv.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = this.G.iconIv.getContext().getResources().getDimensionPixelSize(R.dimen.c77);
                this.G.iconIv.setLayoutParams(layoutParams2);
            }
            this.G.titleTv.setVisibility(0);
            this.G.titleTv.setText(str);
        }
    }

    private void L(lo2.c cVar, lo2.c cVar2) {
        int i3;
        String str;
        String u16;
        int i16 = R.drawable.qui_search_primary;
        if (cVar == null) {
            if (cVar2 == null) {
                this.Q = 0;
                this.R = 4;
                J(R.drawable.qui_search_primary, u(R.string.f171677k51));
            } else {
                this.R = 2;
                TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(this.f282726f);
                if (troopInfoFromCache != null && troopInfoFromCache.hadJoinTroop()) {
                    u16 = u(R.string.w2k);
                    this.Q = 4;
                } else {
                    u16 = u(R.string.znm);
                    this.Q = 3;
                    i16 = R.drawable.kwi;
                }
                J(i16, u16 + ProgressTracer.SEPARATOR + cVar2.I);
            }
        } else if (cVar2 == null) {
            this.R = 1;
            if (Boolean.valueOf(((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f282726f), "UinSearcher")).booleanValue()) {
                str = u(R.string.w2j);
                this.Q = 2;
                i3 = R.drawable.mg6;
            } else {
                String u17 = u(R.string.a97);
                this.Q = 1;
                i3 = R.drawable.kwb;
                str = u17;
            }
            J(i3, str + ProgressTracer.SEPARATOR + cVar.I);
        } else {
            this.Q = 5;
            this.R = 3;
            J(R.drawable.qui_search_primary, u(R.string.adp));
        }
        if (w()) {
            String str2 = this.P.f415196n0;
            if (TextUtils.isEmpty(str2)) {
                str2 = u(R.string.zlx);
            }
            this.F.setTitleWithColor(this.f282726f + str2, this.P.f415195m0);
        }
    }

    private void r(lo2.c cVar, Context context) {
        if (cVar.M0 == 2) {
            QQToast.makeText(context, 0, R.string.f170049az, 0).show();
        } else {
            SearchResultItem searchResultItem = new SearchResultItem();
            searchResultItem.f283460d = Long.parseLong(cVar.H);
            try {
                if (QidianManager.O(cVar.B0) || QidianManager.E(cVar.B0)) {
                    searchResultItem.f283460d = Long.parseLong(cVar.C0);
                }
            } catch (Exception unused) {
                QLog.i("UinSearcher", 1, "qidian corp jump error");
            }
            searchResultItem.f283462f = cVar.I;
            AddFriendActivity.startProfileCardActivity((Activity) context, searchResultItem, this.f282724d, false, 1);
        }
        ReportController.o(this.f282724d, "dc00898", "", "", "0X800A928", "0X800A928", this.R, 0, "", "", "", "");
    }

    private void s() {
        this.f282726f = "";
        this.F = null;
        this.G = null;
        QQAppInterface qQAppInterface = this.f282724d;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.T);
        }
        this.I = false;
        this.J = 0L;
        this.K = 0L;
        this.M = null;
        this.N = null;
        this.L = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x002a A[FALL_THROUGH, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int t(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 != 1) {
            if (i3 != 1006) {
                if (i3 != 3000) {
                    if (i3 != 10008 && i3 != 10010 && i3 != 1020 && i3 != 1021) {
                        switch (i3) {
                            default:
                                switch (i3) {
                                    default:
                                        switch (i3) {
                                            case 1023:
                                            case 1024:
                                            case 1025:
                                                break;
                                            default:
                                                return 0;
                                        }
                                    case 1008:
                                    case 1009:
                                    case 1010:
                                    case 1011:
                                        return 4;
                                }
                            case 1000:
                            case 1001:
                            case 1002:
                            case 1003:
                            case 1004:
                                break;
                        }
                    }
                } else {
                    return 3;
                }
            }
            return 4;
        }
        return 2;
    }

    private String u(int i3) {
        Context context = this.f282728i.get();
        if (context == null) {
            return "";
        }
        return context.getString(i3);
    }

    private boolean w() {
        lo2.c cVar = this.P;
        if (cVar != null && cVar.f415194l0 == 54) {
            return true;
        }
        return false;
    }

    private void x(lo2.c cVar, Context context) {
        if (cVar.M0 == 3) {
            QQToast.makeText(context, 0, R.string.i7i, 0).show();
        } else if (cVar.N0 == 1) {
            QQToast.makeText(context, 0, R.string.crl, 0).show();
        } else {
            Bundle d16 = aq.d(cVar.H, cVar.G0, 105);
            d16.putString(AppConstants.Key.TROOP_INFO_NAME, cVar.I);
            d16.putString("trans_info", ai.a(this.f282726f, com.tencent.mobileqq.search.util.x.k(), 1));
            TroopUtils.I(context, d16, 2);
        }
        ReportController.o(this.f282724d, "dc00898", "", "", "0X800A929", "0X800A929", this.R, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Context context) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + this.f282726f));
        intent.putExtra("big_brother_source_key", this.E);
        context.startActivity(intent);
        ReportController.o(this.f282724d, "dc00898", "", "", "0X800A92A", "0X800A92A", this.R, 0, "", "", "", "");
    }

    private void z(Context context) {
        String uri = new Uri.Builder().scheme(SchemaUtils.SCHEMA_MQQAPI).authority("kuikly").path("open").appendQueryParameter(ISchemeApi.KEY_IOS_SRC_TYPE, "internal").appendQueryParameter("version", "1").appendQueryParameter("source", "1").appendQueryParameter("target", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE).appendQueryParameter(WadlProxyConsts.CHANNEL, "2").appendQueryParameter("page_name", "qsearch_detail").appendQueryParameter(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "23").appendQueryParameter("user_source", "10").appendQueryParameter("keyword", this.f282726f).build().toString();
        ax c16 = bi.c(this.f282724d, context, uri);
        if (c16 != null) {
            c16.b();
            QLog.i("UinSearcher", 1, "jump to url:" + uri);
        }
    }

    @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
    public void onClick(View view, int i3) {
        Context context = this.f282728i.get();
        if (context != null && !this.H) {
            int id5 = view.getId();
            if (id5 == R.id.f164089om) {
                ((ClipboardManager) context.getSystemService("clipboard")).setText(this.f282726f);
                ReportController.o(this.f282724d, "dc00898", "", "", "0X800A926", "0X800A926", this.R, 0, "", "", "", "");
            } else if (id5 == R.id.f164088m5) {
                if (w()) {
                    H(context);
                } else {
                    y(context);
                }
            } else if (id5 == R.id.f164086jg) {
                LinkSpan.r(context, this.f282726f);
                ReportController.o(this.f282724d, "dc00898", "", "", "0X800A92B", "0X800A92B", this.R, 0, "", "", "", "");
            } else if (id5 == R.id.sgx) {
                B(context);
                return;
            }
            ActionSheet actionSheet = this.F;
            if (actionSheet != null && actionSheet.isShowing()) {
                this.F.dismiss();
            }
        }
    }

    @Override // com.tencent.widget.ActionSheet.OnDismissListener
    public void onDismiss() {
        ReportController.o(this.f282724d, "dc00898", "", "", "0X800A92E", "0X800A92E", this.R, 0, "", "", "", "");
    }

    @Override // com.tencent.widget.ActionSheet.WatchDismissActions
    public void onDismissOperations() {
        String str;
        if (w()) {
            str = "1";
        } else {
            str = "2";
        }
        QQAppInterface qQAppInterface = this.f282724d;
        int i3 = this.R;
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800BED1", "0X800BED1", i3, 0, "" + LinkSpan.n(this.f282724d, this.D, this.f282729m, this.C), str, "", "");
        if (this.I) {
            ReportController.o(this.f282724d, "dc00898", "", "", "0X800BED4", "0X800BED4", 0, 0, "", String.valueOf(System.currentTimeMillis() - this.J), "", "");
        }
        this.H = true;
        s();
    }

    public void v(String str, boolean z16, int i3, String str2, String str3) {
        Context context = this.f282728i.get();
        if (context == null) {
            return;
        }
        this.f282726f = str;
        if (i3 == 10014) {
            this.S = true;
        }
        this.R = 4;
        this.Q = 0;
        CardHandler cardHandler = (CardHandler) this.f282724d.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (cardHandler != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            cardHandler.m3(str3, str2, 1, 0L, (byte) 1, 0L, 0L, null, "", 8192L, 10004, null, (byte) 0);
        }
        G(context);
        ReportController.o(this.f282724d, "dc00898", "", "", "0X800BEF3", "0X800BEF3", 0, 0, "" + LinkSpan.n(this.f282724d, z16, i3, str2), "", "", "");
    }
}
