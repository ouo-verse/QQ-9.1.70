package com.tencent.mobileqq.search.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.mobileqq.app.di;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.ai;
import com.tencent.mobileqq.searchlocal.searchengine.PublicAccountSearchEngine;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import lo2.an;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.search.DynamicTabSearch$SubHotWord;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ActiveEntitySearchFragment extends QBaseFragment implements AbsListView.OnScrollListener, an, View.OnClickListener {
    public static String B0 = LogTag.TAG_UNITE_SEARCH + ActiveEntitySearchFragment.class.getSimpleName();
    TextView A0;
    public String C;
    public boolean F;
    public List<v> H;
    protected View I;
    protected XListView J;
    protected jn2.h K;
    protected IFaceDecoder L;
    protected QQAppInterface M;
    protected UnifySearchHandler N;
    public byte[] P;
    protected boolean Q;
    View R;
    private int S;
    View T;
    View U;
    TextView V;
    LinearLayout W;
    View X;
    View Y;
    View Z;

    /* renamed from: a0, reason: collision with root package name */
    View f283125a0;

    /* renamed from: b0, reason: collision with root package name */
    XListView f283126b0;

    /* renamed from: c0, reason: collision with root package name */
    ImageView f283127c0;

    /* renamed from: d0, reason: collision with root package name */
    Bitmap f283128d0;

    /* renamed from: e0, reason: collision with root package name */
    TextView f283129e0;

    /* renamed from: f0, reason: collision with root package name */
    Button f283130f0;

    /* renamed from: i0, reason: collision with root package name */
    private int f283133i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f283134j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f283135k0;

    /* renamed from: l0, reason: collision with root package name */
    public long[] f283136l0;

    /* renamed from: o0, reason: collision with root package name */
    private String f283139o0;

    /* renamed from: p0, reason: collision with root package name */
    private List<DynamicTabSearch$SubHotWord> f283140p0;

    /* renamed from: x0, reason: collision with root package name */
    public String f283148x0;

    /* renamed from: y0, reason: collision with root package name */
    private int f283149y0;

    /* renamed from: z0, reason: collision with root package name */
    TextView f283150z0;
    public boolean D = true;
    public String E = "";
    public boolean G = false;

    /* renamed from: g0, reason: collision with root package name */
    String f283131g0 = "";

    /* renamed from: h0, reason: collision with root package name */
    boolean f283132h0 = false;

    /* renamed from: m0, reason: collision with root package name */
    public List<Long> f283137m0 = new ArrayList();

    /* renamed from: n0, reason: collision with root package name */
    boolean f283138n0 = false;

    /* renamed from: q0, reason: collision with root package name */
    int f283141q0 = 0;

    /* renamed from: r0, reason: collision with root package name */
    int f283142r0 = 0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f283143s0 = true;

    /* renamed from: t0, reason: collision with root package name */
    private long f283144t0 = -1;

    /* renamed from: u0, reason: collision with root package name */
    private final Runnable f283145u0 = new com.tencent.biz.qqcircle.immersive.search.prompt.history.j();

    /* renamed from: v0, reason: collision with root package name */
    private final long f283146v0 = 2000;

    /* renamed from: w0, reason: collision with root package name */
    protected di f283147w0 = new a();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends di {

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment$a$a, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        class ViewOnClickListenerC8531a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f283152d;

            ViewOnClickListenerC8531a(String str) {
                this.f283152d = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                Intent intent = new Intent(ActiveEntitySearchFragment.this.getQBaseActivity(), (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", this.f283152d);
                ActiveEntitySearchFragment.this.startActivity(intent);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes18.dex */
        public class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ActiveEntitySearchFragment activeEntitySearchFragment = ActiveEntitySearchFragment.this;
                activeEntitySearchFragment.Rh(activeEntitySearchFragment.C);
                ActiveEntitySearchFragment.this.Y.setVisibility(0);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes18.dex */
        public class c implements View.OnClickListener {
            c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ActiveEntitySearchFragment activeEntitySearchFragment = ActiveEntitySearchFragment.this;
                activeEntitySearchFragment.Rh(activeEntitySearchFragment.C);
                ActiveEntitySearchFragment.this.Z.setVisibility(8);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        a() {
        }

        @Override // com.tencent.mobileqq.app.di
        public void j(String str, boolean z16, String str2, int i3, String str3, long[] jArr, String str4) {
            if (!ActiveEntitySearchFragment.this.isAdded()) {
                QLog.e(ActiveEntitySearchFragment.B0, 1, "Unify handleTabSearchError, fragment is detached ..., reqKeyword=" + str + " isFirstReq=" + z16 + " reqTime=" + str2 + " resultCode=" + i3 + " errorMsg=" + str3);
                return;
            }
            if (TextUtils.equals(str2, ActiveEntitySearchFragment.this.f283131g0) && ActiveEntitySearchFragment.Jh(ActiveEntitySearchFragment.this.f283136l0, jArr) && ActiveEntitySearchFragment.this.C.equals(str)) {
                ActiveEntitySearchFragment.this.Y.setVisibility(8);
                ActiveEntitySearchFragment activeEntitySearchFragment = ActiveEntitySearchFragment.this;
                activeEntitySearchFragment.f283132h0 = false;
                activeEntitySearchFragment.R.setVisibility(8);
                List<v> list = ActiveEntitySearchFragment.this.H;
                if (list != null && !list.isEmpty()) {
                    ActiveEntitySearchFragment.this.A0.setVisibility(0);
                    ActiveEntitySearchFragment.this.A0.setOnClickListener(new c());
                } else {
                    ActiveEntitySearchFragment.this.J.setVisibility(8);
                    ActiveEntitySearchFragment.this.f283125a0.setVisibility(0);
                    ActiveEntitySearchFragment activeEntitySearchFragment2 = ActiveEntitySearchFragment.this;
                    if (activeEntitySearchFragment2.f283128d0 == null) {
                        try {
                            activeEntitySearchFragment2.f283128d0 = BitmapFactory.decodeResource(activeEntitySearchFragment2.getResources(), R.drawable.dex);
                            ActiveEntitySearchFragment activeEntitySearchFragment3 = ActiveEntitySearchFragment.this;
                            activeEntitySearchFragment3.f283127c0.setImageBitmap(activeEntitySearchFragment3.f283128d0);
                        } catch (OutOfMemoryError e16) {
                            QLog.e(ActiveEntitySearchFragment.B0, 1, e16, new Object[0]);
                        }
                    }
                    ActiveEntitySearchFragment.this.f283129e0.setText(HardCodeUtil.qqStr(R.string.j1x));
                    ActiveEntitySearchFragment.this.f283125a0.setOnClickListener(new b());
                }
                if (QLog.isColorLevel()) {
                    QLog.w(ActiveEntitySearchFragment.B0, 2, "Unify handleTabSearchError code=" + i3 + " mask;" + Arrays.toString(jArr) + " key=" + str + " name=" + ActiveEntitySearchFragment.this.f283148x0);
                }
                ActiveEntitySearchFragment.this.Ch(false, str, str4);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:103:0x0489  */
        /* JADX WARN: Removed duplicated region for block: B:133:0x05d4  */
        /* JADX WARN: Removed duplicated region for block: B:168:0x074d  */
        /* JADX WARN: Removed duplicated region for block: B:173:0x0777  */
        /* JADX WARN: Removed duplicated region for block: B:176:0x07da  */
        /* JADX WARN: Removed duplicated region for block: B:179:0x07dc  */
        /* JADX WARN: Removed duplicated region for block: B:180:0x07ca  */
        /* JADX WARN: Removed duplicated region for block: B:185:0x0770  */
        /* JADX WARN: Removed duplicated region for block: B:188:0x0676  */
        /* JADX WARN: Removed duplicated region for block: B:206:0x0717  */
        /* JADX WARN: Removed duplicated region for block: B:231:0x0438  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x046a  */
        @Override // com.tencent.mobileqq.app.di
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void k(String str, boolean z16, String str2, byte[] bArr, boolean z17, List<x> list, long[] jArr, String str3, List<DynamicTabSearch$SubHotWord> list2, boolean z18, String str4, int i3, String str5) {
            int i16;
            boolean z19;
            String str6;
            String str7;
            JSONObject jSONObject;
            int i17;
            List<v> list3;
            int i18;
            ActiveEntitySearchFragment activeEntitySearchFragment;
            boolean z26;
            String str8;
            int i19;
            int i26;
            if (!ActiveEntitySearchFragment.this.isAdded()) {
                QLog.e(ActiveEntitySearchFragment.B0, 1, "Unify handleTabSearchResult, fragment is detached ..., reqKeyword=" + str + " keyword=" + ActiveEntitySearchFragment.this.C + " reqTime=" + str2 + " lastReqTime=" + ActiveEntitySearchFragment.this.f283131g0 + " isEnd1=" + z17);
                return;
            }
            if (!TextUtils.equals(str2, ActiveEntitySearchFragment.this.f283131g0)) {
                QLog.d(ActiveEntitySearchFragment.B0, 2, "Unify handleTabSearchResult. reqKeyword=" + str + " keyword=" + ActiveEntitySearchFragment.this.C + " reqTime=" + str2 + " lastReqTime=" + ActiveEntitySearchFragment.this.f283131g0 + " isEnd1=" + z17);
                return;
            }
            if (!ActiveEntitySearchFragment.Jh(ActiveEntitySearchFragment.this.f283136l0, jArr) || !str.equals(ActiveEntitySearchFragment.this.C)) {
                QLog.d(ActiveEntitySearchFragment.B0, 2, "Unify handleTabSearchResult. masks=" + ActiveEntitySearchFragment.this.f283136l0 + " reqMasks=" + jArr + " reqKeyword=" + str + " keyword=" + ActiveEntitySearchFragment.this.C + " isEnd1=" + z17);
                return;
            }
            if (list == null) {
                if (QLog.isColorLevel()) {
                    QLog.i(ActiveEntitySearchFragment.B0, 2, "Unify handleTabSearchResult result=" + list);
                }
                j(str, z16, str2, -1, "result = null", jArr, str5);
                return;
            }
            if (i3 == 2) {
                ActiveEntitySearchFragment.this.Y.setVisibility(8);
                ActiveEntitySearchFragment activeEntitySearchFragment2 = ActiveEntitySearchFragment.this;
                activeEntitySearchFragment2.f283132h0 = false;
                activeEntitySearchFragment2.R.setVisibility(8);
                ActiveEntitySearchFragment.this.f283126b0.setVisibility(8);
                ActiveEntitySearchFragment.this.f283130f0.setVisibility(8);
                ActiveEntitySearchFragment.this.f283150z0.setVisibility(8);
                ActiveEntitySearchFragment.this.f283125a0.setVisibility(0);
                try {
                    if (ActiveEntitySearchFragment.this.isAdded()) {
                        ActiveEntitySearchFragment activeEntitySearchFragment3 = ActiveEntitySearchFragment.this;
                        activeEntitySearchFragment3.f283127c0.setImageBitmap(BitmapFactory.decodeResource(activeEntitySearchFragment3.getResources(), R.drawable.n7w));
                    }
                } catch (OutOfMemoryError e16) {
                    QLog.e(ActiveEntitySearchFragment.B0, 1, e16, new Object[0]);
                }
                ActiveEntitySearchFragment.this.f283129e0.setText(2 == i3 ? ActiveEntitySearchFragment.this.getString(R.string.f224616je) : HardCodeUtil.qqStr(R.string.j1u));
                return;
            }
            HashSet hashSet = new HashSet();
            int i27 = 0;
            long j3 = -1;
            long j16 = -1;
            for (x xVar : list) {
                if (xVar.o() != null) {
                    if (xVar instanceof lo2.b) {
                        lo2.b bVar = (lo2.b) xVar;
                        List<y> o16 = bVar.o();
                        for (y yVar : o16) {
                            if (yVar instanceof lo2.c) {
                                lo2.c cVar = (lo2.c) yVar;
                                if (ActiveEntitySearchActivity.G0) {
                                    cVar.L0 = 1;
                                }
                                hashSet.add(Long.valueOf(cVar.J()));
                            }
                        }
                        if (j3 == -1) {
                            j3 = bVar.D;
                        }
                        long j17 = bVar.D;
                        if (o16.size() > 0 && bVar.D == 1001) {
                            ReportController.o(null, "dc00898", "", "", "0X800A339", "0X800A339", 1, 0, "", "", "", "");
                            ActiveEntitySearchFragment.this.Oh("dt_imp");
                        } else if (o16.size() > 0 && bVar.D == Constant.FROM_ID_UNINSTALL_PLUGIN) {
                            ReportController.o(null, "dc00898", "", "", "0X800A339", "0X800A339", 2, 0, "", "", "", "");
                        }
                        j16 = j17;
                    }
                    i27 += xVar.o().size();
                }
            }
            ActiveEntitySearchFragment.this.f283137m0.addAll(hashSet);
            ActiveEntitySearchFragment.this.f283139o0 = str3;
            ActiveEntitySearchFragment.this.f283140p0 = list2;
            String str9 = "";
            if (!z16) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(hashSet);
                SearchUtils.W0("sub_result", "load_result", ActiveEntitySearchFragment.this.C, SearchUtils.d0(arrayList), "", SearchUtils.g0("dynamic_tab_search.1", ActiveEntitySearchFragment.this.f283136l0));
            }
            ActiveEntitySearchFragment activeEntitySearchFragment4 = ActiveEntitySearchFragment.this;
            int i28 = i27;
            com.tencent.mobileqq.search.util.t.h(activeEntitySearchFragment4.H, list, !z16, activeEntitySearchFragment4.f283136l0, activeEntitySearchFragment4.f283148x0, activeEntitySearchFragment4.C);
            com.tencent.mobileqq.search.util.t.e(list, ActiveEntitySearchFragment.this.f283133i0, ActiveEntitySearchFragment.this.C);
            if (i28 == 0) {
                if (ActiveEntitySearchFragment.this.getQBaseActivity() instanceof nn2.b) {
                    int currentPageType = ((nn2.b) ActiveEntitySearchFragment.this.getQBaseActivity()).getCurrentPageType();
                    if (currentPageType == 1) {
                        i16 = 2;
                        ActiveEntitySearchFragment activeEntitySearchFragment5 = ActiveEntitySearchFragment.this;
                        SearchUtils.W0("all_result", "exp_tab_empty", activeEntitySearchFragment5.C, SearchUtils.e0(activeEntitySearchFragment5.f283136l0), "", SearchUtils.g0("dynamic_tab_search.1", jArr));
                    } else if (currentPageType == 3) {
                        ActiveEntitySearchFragment activeEntitySearchFragment6 = ActiveEntitySearchFragment.this;
                        i16 = 2;
                        SearchUtils.W0("sub_result", "no_result", activeEntitySearchFragment6.C, SearchUtils.e0(activeEntitySearchFragment6.f283136l0), "", SearchUtils.g0("dynamic_tab_search.1", jArr));
                    }
                }
                i16 = 2;
            } else {
                i16 = 2;
                ActiveEntitySearchFragment activeEntitySearchFragment7 = ActiveEntitySearchFragment.this;
                if (activeEntitySearchFragment7.P == null && (activeEntitySearchFragment7.getQBaseActivity() instanceof nn2.b)) {
                    nn2.b bVar2 = (nn2.b) ActiveEntitySearchFragment.this.getQBaseActivity();
                    int currentPageType2 = bVar2.getCurrentPageType();
                    if (currentPageType2 == 1) {
                        ActiveEntitySearchFragment activeEntitySearchFragment8 = ActiveEntitySearchFragment.this;
                        SearchUtils.W0("all_result", "exp_tab_page", activeEntitySearchFragment8.C, SearchUtils.d0(activeEntitySearchFragment8.f283137m0), "", SearchUtils.g0("UnifySearch.Unite", bVar2.getCurrentPageMasks()));
                    } else if (currentPageType2 == 3) {
                        SearchUtils.W0("sub_result", "exp_result", bVar2.getSearchKeyword(), SearchUtils.d0(ActiveEntitySearchFragment.this.f283137m0), "", SearchUtils.g0("dynamic_tab_search.1", bVar2.getCurrentPageMasks()));
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i(ActiveEntitySearchFragment.B0, i16, "Unify handleTabSearchResult isFirstReq==" + z16 + " newSearchDataCount:" + ActiveEntitySearchFragment.this.f283142r0 + "   newSearchIndex:" + ActiveEntitySearchFragment.this.f283141q0 + " result.size():" + i28 + " traceId:" + str5);
            }
            ActiveEntitySearchFragment.this.Y.setVisibility(8);
            ActiveEntitySearchFragment.this.Z.setVisibility(8);
            ActiveEntitySearchFragment.this.J.setVisibility(0);
            ActiveEntitySearchFragment.this.R.setVisibility(8);
            ActiveEntitySearchFragment activeEntitySearchFragment9 = ActiveEntitySearchFragment.this;
            activeEntitySearchFragment9.f283132h0 = false;
            activeEntitySearchFragment9.P = bArr;
            activeEntitySearchFragment9.Q = z17;
            if (!TextUtils.isEmpty(str4)) {
                try {
                    jSONObject = new JSONObject(str4);
                    z19 = jSONObject.optBoolean("buttonShow");
                } catch (JSONException e17) {
                    e = e17;
                    z19 = false;
                }
                try {
                    str6 = jSONObject.optString("buttonText");
                } catch (JSONException e18) {
                    e = e18;
                    str6 = "";
                    if (QLog.isColorLevel()) {
                    }
                    str7 = str9;
                    if (z17) {
                    }
                    if (TextUtils.isEmpty(ActiveEntitySearchFragment.this.f283139o0)) {
                    }
                    i17 = i28;
                    ActiveEntitySearchFragment.this.U.setVisibility(8);
                    list3 = ActiveEntitySearchFragment.this.H;
                    if (list3 == null) {
                    }
                    if (list.isEmpty()) {
                    }
                    List<v> m3 = SearchUtil.m(list, z16, ActiveEntitySearchFragment.this.f283138n0);
                    ActiveEntitySearchFragment.this.Vh(m3);
                    ActiveEntitySearchFragment.this.Wh(m3, str5);
                    ActiveEntitySearchFragment activeEntitySearchFragment10 = ActiveEntitySearchFragment.this;
                    activeEntitySearchFragment10.H = m3;
                    activeEntitySearchFragment10.K.g(m3);
                    ActiveEntitySearchFragment.this.Ph();
                    ActiveEntitySearchFragment.this.f283144t0 = j16;
                    activeEntitySearchFragment = ActiveEntitySearchFragment.this;
                    if (activeEntitySearchFragment.Q) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    ActiveEntitySearchActivity.F0 = true;
                    ActiveEntitySearchFragment.this.Uh(true);
                    ActiveEntitySearchFragment.this.Ch(i19 != 0 ? true : z26, str8, str5);
                }
                try {
                    str9 = jSONObject.optString("buttonJmpUrl");
                } catch (JSONException e19) {
                    e = e19;
                    if (QLog.isColorLevel()) {
                        QLog.e(ActiveEntitySearchFragment.B0, i16, "Unify handleTabSearchResult extension parse error! " + QLog.getStackTraceString(e));
                    }
                    str7 = str9;
                    if (z17) {
                    }
                    if (TextUtils.isEmpty(ActiveEntitySearchFragment.this.f283139o0)) {
                    }
                    i17 = i28;
                    ActiveEntitySearchFragment.this.U.setVisibility(8);
                    list3 = ActiveEntitySearchFragment.this.H;
                    if (list3 == null) {
                    }
                    if (list.isEmpty()) {
                    }
                    List<v> m36 = SearchUtil.m(list, z16, ActiveEntitySearchFragment.this.f283138n0);
                    ActiveEntitySearchFragment.this.Vh(m36);
                    ActiveEntitySearchFragment.this.Wh(m36, str5);
                    ActiveEntitySearchFragment activeEntitySearchFragment102 = ActiveEntitySearchFragment.this;
                    activeEntitySearchFragment102.H = m36;
                    activeEntitySearchFragment102.K.g(m36);
                    ActiveEntitySearchFragment.this.Ph();
                    ActiveEntitySearchFragment.this.f283144t0 = j16;
                    activeEntitySearchFragment = ActiveEntitySearchFragment.this;
                    if (activeEntitySearchFragment.Q) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    ActiveEntitySearchActivity.F0 = true;
                    ActiveEntitySearchFragment.this.Uh(true);
                    ActiveEntitySearchFragment.this.Ch(i19 != 0 ? true : z26, str8, str5);
                }
                str7 = str9;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i(ActiveEntitySearchFragment.B0, i16, "Unify handleTabSearchResult extension is null");
                }
                z19 = false;
                str6 = "";
                str7 = str6;
            }
            if (z17) {
                ActiveEntitySearchFragment activeEntitySearchFragment11 = ActiveEntitySearchFragment.this;
                activeEntitySearchFragment11.f283150z0.setVisibility(activeEntitySearchFragment11.Kh() ? 0 : 8);
            }
            if (TextUtils.isEmpty(ActiveEntitySearchFragment.this.f283139o0) && ActiveEntitySearchFragment.this.f283140p0.size() > 0) {
                ActiveEntitySearchFragment activeEntitySearchFragment12 = ActiveEntitySearchFragment.this;
                activeEntitySearchFragment12.V.setText(activeEntitySearchFragment12.f283139o0);
                ActiveEntitySearchFragment.this.W.removeAllViews();
                QBaseActivity qBaseActivity = ActiveEntitySearchFragment.this.getQBaseActivity();
                if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                    int c16 = com.tencent.mobileqq.util.x.c(qBaseActivity, 8.0f);
                    int c17 = com.tencent.mobileqq.util.x.c(qBaseActivity, 10.0f);
                    int c18 = com.tencent.mobileqq.util.x.c(qBaseActivity, 2.0f);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(com.tencent.mobileqq.util.x.c(ActiveEntitySearchFragment.this.getQBaseActivity(), 15.0f));
                    int parseColor = Color.parseColor("#E2E2E2");
                    boolean isInNightMode = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
                    if (isInNightMode) {
                        parseColor = Color.parseColor("#5a86bb");
                    }
                    gradientDrawable.setStroke(1, parseColor);
                    Iterator it = ActiveEntitySearchFragment.this.f283140p0.iterator();
                    while (it.hasNext()) {
                        DynamicTabSearch$SubHotWord dynamicTabSearch$SubHotWord = (DynamicTabSearch$SubHotWord) it.next();
                        Iterator it5 = it;
                        String stringUtf8 = dynamicTabSearch$SubHotWord.show_word.get().toStringUtf8();
                        if (TextUtils.isEmpty(stringUtf8)) {
                            it = it5;
                        } else {
                            TextView textView = new TextView(qBaseActivity);
                            QBaseActivity qBaseActivity2 = qBaseActivity;
                            int i29 = i28;
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.rightMargin = c16;
                            textView.setPadding(c17, c18, c17, c18);
                            int parseColor2 = Color.parseColor("#000000");
                            if (isInNightMode) {
                                parseColor2 = Color.parseColor("#5a86bb");
                            }
                            textView.setTextColor(parseColor2);
                            textView.setBackground(gradientDrawable.mutate());
                            textView.setText(stringUtf8);
                            textView.setGravity(17);
                            textView.setTextSize(1, 14.0f);
                            textView.setContentDescription(stringUtf8);
                            textView.setOnClickListener(ActiveEntitySearchFragment.this);
                            textView.setTag(R.id.d8t, dynamicTabSearch$SubHotWord);
                            ActiveEntitySearchFragment.this.W.addView(textView, layoutParams);
                            it = it5;
                            qBaseActivity = qBaseActivity2;
                            gradientDrawable = gradientDrawable;
                            i28 = i29;
                        }
                    }
                    i17 = i28;
                    if (ActiveEntitySearchFragment.this.W.getChildCount() == 0) {
                        ActiveEntitySearchFragment.this.U.setVisibility(8);
                    } else {
                        List<v> list4 = ActiveEntitySearchFragment.this.H;
                        if ((list4 != null && !list4.isEmpty()) || !list.isEmpty()) {
                            ActiveEntitySearchFragment.this.U.setVisibility(0);
                        }
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(ActiveEntitySearchFragment.B0, 2, "Unify activity is finished. in handleTabSearchResult.");
                        return;
                    }
                    return;
                }
            } else {
                i17 = i28;
                ActiveEntitySearchFragment.this.U.setVisibility(8);
            }
            list3 = ActiveEntitySearchFragment.this.H;
            if (list3 == null && !list3.isEmpty()) {
                List<v> m16 = SearchUtil.m(list, z16, ActiveEntitySearchFragment.this.f283138n0);
                if (!z16 && j3 == ActiveEntitySearchFragment.this.f283144t0 && !z18 && m16 != null && m16.size() > 0) {
                    List<v> list5 = ActiveEntitySearchFragment.this.H;
                    v vVar = list5.get(list5.size() - 1);
                    m16.remove(0);
                    int i36 = 0;
                    int i37 = 0;
                    while (true) {
                        if (i37 >= m16.size()) {
                            i37 = i36;
                            break;
                        } else {
                            if (m16.get(i37) instanceof com.tencent.mobileqq.search.model.i) {
                                break;
                            }
                            int i38 = i37;
                            i37++;
                            i36 = i38;
                        }
                    }
                    if (vVar instanceof y) {
                        y yVar2 = (y) vVar;
                        i26 = yVar2.p();
                        rn2.k.e(yVar2, i26 + i37, i26 - 1);
                    } else {
                        i26 = 0;
                    }
                    for (int i39 = 0; i39 < i37; i39++) {
                        v vVar2 = m16.get(i39);
                        if (vVar2 instanceof y) {
                            rn2.k.e((y) vVar2, i26 + i37, i26 + i39);
                        }
                    }
                }
                ActiveEntitySearchFragment.this.Vh(m16);
                ActiveEntitySearchFragment.this.Wh(m16, str5);
                ActiveEntitySearchFragment.this.H.addAll(m16);
                ActiveEntitySearchFragment activeEntitySearchFragment13 = ActiveEntitySearchFragment.this;
                activeEntitySearchFragment13.K.g(activeEntitySearchFragment13.H);
            } else {
                if (list.isEmpty()) {
                    ActiveEntitySearchFragment.this.f283125a0.setVisibility(0);
                    ActiveEntitySearchFragment.this.f283126b0.setVisibility(8);
                    ActiveEntitySearchFragment activeEntitySearchFragment14 = ActiveEntitySearchFragment.this;
                    if (activeEntitySearchFragment14.f283128d0 == null) {
                        try {
                            if (activeEntitySearchFragment14.isAdded()) {
                                ActiveEntitySearchFragment activeEntitySearchFragment15 = ActiveEntitySearchFragment.this;
                                activeEntitySearchFragment15.f283128d0 = BitmapFactory.decodeResource(activeEntitySearchFragment15.getResources(), R.drawable.dex);
                                ActiveEntitySearchFragment activeEntitySearchFragment16 = ActiveEntitySearchFragment.this;
                                activeEntitySearchFragment16.f283127c0.setImageBitmap(activeEntitySearchFragment16.f283128d0);
                            }
                        } catch (OutOfMemoryError e26) {
                            QLog.e(ActiveEntitySearchFragment.B0, 1, e26, new Object[0]);
                        }
                    }
                    ActiveEntitySearchFragment.this.X.setBackgroundResource(R.drawable.bg_texture);
                    ActiveEntitySearchFragment.this.f283129e0.setText(HardCodeUtil.qqStr(R.string.f213845ra));
                    if (z19) {
                        ActiveEntitySearchFragment.this.f283130f0.setVisibility(0);
                        ActiveEntitySearchFragment.this.f283130f0.setOnClickListener(new ViewOnClickListenerC8531a(str7));
                        if (!TextUtils.isEmpty(str6)) {
                            ActiveEntitySearchFragment.this.f283130f0.setText(str6);
                            TextView textView2 = ActiveEntitySearchFragment.this.f283129e0;
                            textView2.setPadding(0, com.tencent.mobileqq.util.x.c(textView2.getContext(), 15.0f), 0, 0);
                        }
                        i18 = 8;
                    } else {
                        i18 = 8;
                        ActiveEntitySearchFragment.this.f283130f0.setVisibility(8);
                    }
                    ActiveEntitySearchFragment.this.f283150z0.setVisibility(i18);
                } else {
                    ActiveEntitySearchFragment.this.f283125a0.setVisibility(8);
                }
                List<v> m362 = SearchUtil.m(list, z16, ActiveEntitySearchFragment.this.f283138n0);
                ActiveEntitySearchFragment.this.Vh(m362);
                ActiveEntitySearchFragment.this.Wh(m362, str5);
                ActiveEntitySearchFragment activeEntitySearchFragment1022 = ActiveEntitySearchFragment.this;
                activeEntitySearchFragment1022.H = m362;
                activeEntitySearchFragment1022.K.g(m362);
                ActiveEntitySearchFragment.this.Ph();
            }
            ActiveEntitySearchFragment.this.f283144t0 = j16;
            activeEntitySearchFragment = ActiveEntitySearchFragment.this;
            if (activeEntitySearchFragment.Q) {
                z26 = false;
            } else {
                int i46 = activeEntitySearchFragment.f283142r0 + i17;
                activeEntitySearchFragment.f283142r0 = i46;
                int i47 = activeEntitySearchFragment.f283141q0 + 1;
                activeEntitySearchFragment.f283141q0 = i47;
                if (i46 > 10) {
                    z26 = false;
                    activeEntitySearchFragment.f283141q0 = 0;
                    activeEntitySearchFragment.f283142r0 = 0;
                } else {
                    z26 = false;
                    if (i47 >= 3) {
                        activeEntitySearchFragment.Q = true;
                    } else {
                        activeEntitySearchFragment.Rh(activeEntitySearchFragment.C);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                String str10 = ActiveEntitySearchFragment.B0;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Unify handleTabSearchResult isEnd = ");
                sb5.append(z17);
                sb5.append(" mask;");
                sb5.append(Arrays.toString(jArr));
                sb5.append(" key=");
                str8 = str;
                i19 = i17;
                sb5.append(str8);
                sb5.append(" name=");
                sb5.append(ActiveEntitySearchFragment.this.f283148x0);
                sb5.append("  fragmentMask=");
                sb5.append(Arrays.toString(ActiveEntitySearchFragment.this.f283136l0));
                QLog.i(str10, 2, sb5.toString());
            } else {
                str8 = str;
                i19 = i17;
            }
            ActiveEntitySearchActivity.F0 = true;
            ActiveEntitySearchFragment.this.Uh(true);
            ActiveEntitySearchFragment.this.Ch(i19 != 0 ? true : z26, str8, str5);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ((InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ((InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ch(boolean z16, String str, String str2) {
        if (getQBaseActivity() instanceof ActiveEntitySearchActivity) {
            ((ActiveEntitySearchActivity) getQBaseActivity()).M2(z16, str, str2);
        }
    }

    private void Fh(View view) {
        if (this.f283133i0 != 99 && !ActiveEntitySearchActivity.G0) {
            return;
        }
        if (getQBaseActivity() instanceof ActiveEntitySearchActivity) {
            ActiveEntitySearchActivity activeEntitySearchActivity = (ActiveEntitySearchActivity) getQBaseActivity();
            if (!activeEntitySearchActivity.L2(activeEntitySearchActivity.f282654r0, 1001L)) {
                return;
            }
        }
        VideoReport.setElementId(this.J, "em_search_people_result_people");
        VideoReport.setElementClickPolicy(this.J, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.J, ExposurePolicy.REPORT_NONE);
    }

    private boolean Ih() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qui_background_drawable_fallback", false);
        if (isSwitchOn) {
            QLog.i(B0, 1, "isFallbackSwitchOn.");
        }
        return isSwitchOn;
    }

    public static boolean Jh(long[] jArr, long[] jArr2) {
        if (jArr == null || jArr2 == null || jArr.length != jArr2.length) {
            return false;
        }
        for (int i3 = 0; i3 < jArr.length; i3++) {
            if (jArr[i3] != jArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Kh() {
        long[] jArr = this.f283136l0;
        if (jArr == null || jArr.length != 2) {
            return true;
        }
        long j3 = jArr[0];
        if ((j3 != 1001 || jArr[1] != Constant.FROM_ID_UNINSTALL_PLUGIN) && (jArr[1] != 1001 || j3 != Constant.FROM_ID_UNINSTALL_PLUGIN)) {
            return true;
        }
        return false;
    }

    public static ActiveEntitySearchFragment Mh(Bundle bundle) {
        ActiveEntitySearchFragment activeEntitySearchFragment = new ActiveEntitySearchFragment();
        activeEntitySearchFragment.setArguments(bundle);
        return activeEntitySearchFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh(String str) {
        if (this.f283133i0 != 99) {
            return;
        }
        VideoReport.reportEvent(str, this.J, null);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void Th() {
        Drawable drawable;
        if (Ih()) {
            return;
        }
        if (getContext() != null) {
            drawable = getContext().getDrawable(R.drawable.qui_common_bg_bottom_standard_bg);
        } else {
            drawable = null;
        }
        if (drawable == null) {
            drawable = ie0.a.f().k(getContext(), R.color.qui_common_bg_bottom_standard, 0.0f, 1000);
        }
        this.X.setBackground(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uh(boolean z16) {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f283145u0);
        if (z16) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.f283145u0, 2000L);
        } else {
            this.f283145u0.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wh(List<v> list, String str) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            v vVar = list.get(i3);
            if (vVar instanceof com.tencent.mobileqq.search.model.i) {
                com.tencent.mobileqq.search.model.i iVar = (com.tencent.mobileqq.search.model.i) vVar;
                if (iVar.v() instanceof lo2.b) {
                    lo2.b bVar = (lo2.b) iVar.v();
                    if (bVar.D == Constant.FROM_ID_UNINSTALL_PLUGIN) {
                        bVar.F(str);
                    }
                }
            } else if (vVar instanceof lo2.c) {
                lo2.c cVar = (lo2.c) vVar;
                if (cVar.J() == 1002) {
                    cVar.P0 = str;
                }
            }
        }
    }

    public void Bh() {
        List<v> list = this.H;
        if (list != null && this.K != null) {
            list.clear();
            this.f283137m0.clear();
            setFirstClickResultItemFlag(false);
            this.K.g(this.H);
        }
        if (this.G) {
            this.Y.setVisibility(8);
            this.R.setVisibility(8);
            this.f283150z0.setVisibility(8);
            this.Z.setVisibility(8);
            this.f283125a0.setVisibility(8);
            this.U.setVisibility(8);
            this.W.removeAllViews();
        }
    }

    int Dh() {
        List<v> list = this.H;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    protected int Eh(List<v> list) {
        int i3 = 0;
        if (list != null && !list.isEmpty()) {
            Iterator<v> it = list.iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof com.tencent.mobileqq.search.model.i)) {
                    i3++;
                }
            }
        }
        return i3;
    }

    public void Gh(boolean z16) {
        this.F = false;
        if (this.G) {
            this.f283125a0.setVisibility(8);
            this.f283150z0.setVisibility(8);
            if (z16) {
                this.R.setVisibility(0);
            } else {
                this.Y.setVisibility(0);
            }
        }
    }

    protected void Hh() {
        this.N = (UnifySearchHandler) this.M.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER);
        this.M.addObserver(this.f283147w0);
    }

    protected jn2.h Lh() {
        return new jn2.h(this.J, this.L, this, 0);
    }

    protected void Nh() {
        this.M.removeObserver(this.f283147w0);
    }

    protected void Ph() {
        if (this.f283134j0 == 3 && this.J != null) {
            ai.f(this.J, String.valueOf(Eh(this.H)), "1");
        }
    }

    public void Qh(String str, List<v> list) {
        this.C = str;
        this.H = list;
        this.F = false;
        this.Q = true;
        if (this.G) {
            this.K.g(list);
        }
        Wh(list, com.tencent.mobileqq.search.util.x.k());
    }

    public synchronized void Rh(String str) {
        double d16;
        double d17;
        this.A0.setVisibility(8);
        this.R.setVisibility(0);
        if (this.P != null) {
            SearchUtils.W0("all_result", "load_tab", str, SearchUtils.d0(this.f283137m0), "", SearchUtils.g0("UnifySearch.Unite", this.f283136l0));
        }
        if (getQBaseActivity() instanceof com.tencent.mobileqq.search.m) {
            d16 = ((com.tencent.mobileqq.search.m) getQBaseActivity()).getLat();
            d17 = ((com.tencent.mobileqq.search.m) getQBaseActivity()).getLon();
        } else {
            d16 = 0.0d;
            d17 = 0.0d;
        }
        this.f283131g0 = System.currentTimeMillis() + "";
        if (QLog.isColorLevel()) {
            QLog.w(B0, 2, "startNewSearchTAB isEnd = true mask;" + Arrays.toString(this.f283136l0) + " key=" + str + "  name=" + this.f283148x0 + " reqTime=" + this.f283131g0);
        }
        this.f283132h0 = true;
        Bundle bundle = new Bundle();
        bundle.putBoolean(QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, true);
        bundle.putInt(IProfileCardConst.KEY_FROM_TYPE, this.f283133i0);
        Sh(str, getPublicAccountIdList(), this.P, d16, d17, bundle);
        Gh(true);
    }

    protected void Sh(String str, List<Long> list, byte[] bArr, double d16, double d17, Bundle bundle) {
        UnifySearchHandler unifySearchHandler = this.N;
        if (unifySearchHandler != null) {
            unifySearchHandler.Q2(str, this.f283131g0, 20, SearchUtil.p(this.f283136l0), list, bArr, this.S, d16, d17, bundle);
        } else {
            QLog.e(B0, 2, "handler null in frag");
        }
    }

    public void Vh(List<v> list) {
        int i3;
        int i16;
        com.tencent.mobileqq.search.model.i iVar;
        lo2.b bVar;
        Intent intent;
        if (getQBaseActivity() != null && (intent = getQBaseActivity().getIntent()) != null) {
            i3 = intent.getIntExtra("from_type_for_report", 0);
        } else {
            i3 = 0;
        }
        if (i3 != 9 && i3 != 11) {
            if (i3 == 3) {
                i16 = 4;
            } else {
                i16 = 0;
            }
        } else {
            i16 = 5;
        }
        if (i16 > 0) {
            for (int i17 = 0; i17 < list.size(); i17++) {
                if ((list.get(i17) instanceof com.tencent.mobileqq.search.model.i) && (iVar = (com.tencent.mobileqq.search.model.i) list.get(i17)) != null && (iVar.v() instanceof lo2.b) && (bVar = (lo2.b) iVar.v()) != null && bVar.D == Constant.FROM_ID_UNINSTALL_PLUGIN) {
                    bVar.D(i16);
                }
            }
        }
    }

    public List<Long> getPublicAccountIdList() {
        List<up2.b> a16 = new PublicAccountSearchEngine(this.M, this.f283133i0).a(new pn2.a(this.C));
        if (a16 != null && a16.size() != 0) {
            List<Entity> publicAccountList = ((IPublicAccountDataManager) this.M.getRuntimeService(IPublicAccountDataManager.class, "all")).getPublicAccountList();
            ArrayList arrayList = new ArrayList();
            if (publicAccountList != null && !publicAccountList.isEmpty()) {
                for (int i3 = 0; i3 < a16.size(); i3++) {
                    up2.b bVar = a16.get(i3);
                    for (int i16 = 0; i16 < publicAccountList.size(); i16++) {
                        PublicAccountInfo publicAccountInfo = (PublicAccountInfo) publicAccountList.get(i16);
                        if (TextUtils.equals(String.valueOf(publicAccountInfo.uin), String.valueOf(bVar.X.getUinString()))) {
                            arrayList.add(Long.valueOf(publicAccountInfo.uin));
                        }
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(B0, 2, "all publicAccountInfoList is null or empty");
            }
            return arrayList;
        }
        return null;
    }

    @Override // lo2.an
    public boolean isFirstClickResultItem() {
        return this.f283143s0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Object tag = view.getTag(R.id.d8t);
        if (tag instanceof DynamicTabSearch$SubHotWord) {
            DynamicTabSearch$SubHotWord dynamicTabSearch$SubHotWord = (DynamicTabSearch$SubHotWord) tag;
            this.S = dynamicTabSearch$SubHotWord.word_id.get();
            QBaseActivity qBaseActivity = getQBaseActivity();
            if (qBaseActivity instanceof ActiveEntitySearchActivity) {
                SearchUtils.W0("sub_result", "clk_relate", this.C, dynamicTabSearch$SubHotWord.search_word.get().toStringUtf8(), "", "");
                ((ActiveEntitySearchActivity) qBaseActivity).j3(dynamicTabSearch$SubHotWord);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity instanceof UniteSearchActivity) {
            this.f283138n0 = true;
        }
        if (qBaseActivity != null) {
            QQAppInterface qQAppInterface = (QQAppInterface) qBaseActivity.getAppRuntime();
            this.M = qQAppInterface;
            this.L = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.M);
            if (arguments != null) {
                this.f283133i0 = arguments.getInt(IProfileCardConst.KEY_FROM_TYPE, -1);
                this.f283134j0 = arguments.getInt("from_type_for_report", 4);
                this.f283135k0 = arguments.getInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 89);
                long[] longArray = arguments.getLongArray("group_mask_long_array");
                this.f283136l0 = longArray;
                if (longArray != null) {
                    if (longArray.length == 1 && longArray[0] == 0) {
                        this.f283136l0 = UnifySearchHandler.f195168i;
                    }
                    this.f283148x0 = arguments.getString("group_name_string");
                    this.C = arguments.getString("keyword");
                } else {
                    throw new RuntimeException("mask array can not be null in ActiveEntitySearchFragment.");
                }
            }
            Hh();
            super.onCreate(bundle);
            return;
        }
        throw new IllegalStateException("Activity must be instance of QBaseActivity");
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public synchronized View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        View view2;
        double d16;
        double d17;
        super.onCreateView(layoutInflater, viewGroup, bundle);
        int i3 = 0;
        View inflate = layoutInflater.inflate(R.layout.b4g, viewGroup, false);
        this.X = inflate;
        View findViewById = inflate.findViewById(R.id.efs);
        this.Y = findViewById;
        findViewById.setVisibility(0);
        this.Z = this.X.findViewById(R.id.byk);
        this.f283125a0 = this.X.findViewById(R.id.c2a);
        this.f283129e0 = (TextView) this.X.findViewById(R.id.c2c);
        this.f283127c0 = (ImageView) this.X.findViewById(R.id.c2b);
        this.f283130f0 = (Button) this.X.findViewById(R.id.h2_);
        this.T = (RelativeLayout) this.X.findViewById(R.id.result_layout);
        this.f283126b0 = (XListView) this.X.findViewById(R.id.ei5);
        this.f283125a0.setVisibility(8);
        this.Z.setVisibility(8);
        View inflate2 = layoutInflater.inflate(R.layout.aco, (ViewGroup) null, false);
        this.U = inflate2.findViewById(R.id.gdj);
        this.V = (TextView) inflate2.findViewById(R.id.d8u);
        this.W = (LinearLayout) inflate2.findViewById(R.id.d8y);
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
            this.U.setBackgroundResource(R.drawable.f160534jf);
        } else {
            this.U.setBackgroundResource(R.drawable.f160533je);
        }
        this.U.setVisibility(8);
        this.W.removeAllViews();
        View inflate3 = layoutInflater.inflate(R.layout.acp, (ViewGroup) null, false);
        View findViewById2 = inflate3.findViewById(R.id.cih);
        this.R = findViewById2;
        findViewById2.setVisibility(8);
        try {
            view = layoutInflater.inflate(R.layout.awk, (ViewGroup) null, false);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(B0, 2, QLog.getStackTraceString(e16));
            }
            view = null;
        }
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.id.cih);
            this.f283150z0 = textView;
            textView.setText(HardCodeUtil.qqStr(R.string.j1w));
            this.f283150z0.setTextSize(16.0f);
            this.f283150z0.setTextColor(getQBaseActivity().getResources().getColor(R.color.skin_gray3));
            this.f283150z0.setVisibility(8);
            View view3 = this.X;
            this.I = view3;
            XListView xListView = (XListView) view3.findViewById(R.id.eap);
            this.J = xListView;
            xListView.setOnTouchListener(new b());
            this.J.addFooterView(view);
        }
        try {
            view = layoutInflater.inflate(R.layout.awk, (ViewGroup) null, false);
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d(B0, 2, QLog.getStackTraceString(e17));
            }
        }
        if (view != null) {
            TextView textView2 = (TextView) view.findViewById(R.id.cih);
            this.A0 = textView2;
            textView2.setText(HardCodeUtil.qqStr(R.string.f171546j23));
            this.A0.setTextSize(16.0f);
            this.A0.setTextColor(getQBaseActivity().getResources().getColor(R.color.skin_gray3));
            this.A0.setVisibility(8);
            this.J.addFooterView(view);
        }
        jn2.h Lh = Lh();
        this.K = Lh;
        Lh.q(false);
        if (this.f283136l0.length == 1) {
            this.K.q(true);
        }
        this.J.addHeaderView(inflate2);
        this.J.setAdapter((ListAdapter) this.K);
        this.J.addFooterView(inflate3);
        this.G = true;
        if (QLog.isColorLevel()) {
            QLog.w(B0, 2, "hash = " + hashCode() + "  onCreateView shouldRequestDataOnCreate=" + this.F + "  name=" + this.f283148x0 + " mask=" + Arrays.toString(this.f283136l0));
        }
        if (this.F) {
            if (getQBaseActivity() instanceof com.tencent.mobileqq.search.m) {
                d16 = ((com.tencent.mobileqq.search.m) getQBaseActivity()).getLat();
                d17 = ((com.tencent.mobileqq.search.m) getQBaseActivity()).getLon();
            } else {
                d16 = 0.0d;
                d17 = 0.0d;
            }
            this.f283131g0 = System.currentTimeMillis() + "";
            this.C = this.E;
            this.f283132h0 = true;
            Bundle bundle2 = new Bundle();
            if (getQBaseActivity() instanceof ActiveEntitySearchActivity) {
                ActiveEntitySearchActivity activeEntitySearchActivity = (ActiveEntitySearchActivity) getQBaseActivity();
                bundle2.putInt("fromTypeForReport", activeEntitySearchActivity.f282650n0);
                bundle2.putInt("searchAvatarFrom", activeEntitySearchActivity.f282662z0);
            }
            bundle2.putBoolean(QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, false);
            bundle2.putInt(IProfileCardConst.KEY_FROM_TYPE, this.f283133i0);
            Sh(this.C, getPublicAccountIdList(), this.P, d16, d17, bundle2);
            Gh(false);
            this.F = false;
        } else {
            this.K.g(this.H);
            this.Y.setVisibility(8);
            this.Z.setVisibility(8);
            this.J.setVisibility(0);
            List<v> list = this.H;
            if (list != null && !list.isEmpty()) {
                if (this.Q) {
                    TextView textView3 = this.f283150z0;
                    if (!Kh()) {
                        i3 = 8;
                    }
                    textView3.setVisibility(i3);
                }
            }
            if (this.Q) {
                this.f283125a0.setVisibility(0);
                this.f283129e0.setText(HardCodeUtil.qqStr(R.string.j26));
            }
        }
        this.J.setOnScrollListener(this);
        Fh(this.X);
        view2 = this.X;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view2);
        return view2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ActiveEntitySearchActivity.G0 = false;
        this.G = false;
        Nh();
        this.f283132h0 = false;
        IFaceDecoder iFaceDecoder = this.L;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        if (QLog.isColorLevel()) {
            QLog.i(B0, 2, "hash = " + hashCode() + "   onDestroyView mask;" + Arrays.toString(this.f283136l0) + " key=" + this.C + "  name=" + this.f283148x0);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.K.notifyDataSetChanged();
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        jn2.h hVar = this.K;
        if (hVar != null && hVar.getCount() != 0 && this.f283149y0 != 0 && (i17 - i3) - i16 < 10 && !this.f283132h0 && !this.Q) {
            Rh(this.C);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        int i16;
        QLog.d(B0 + " arend ", 4, " onScrollStateChanged" + i3);
        this.f283149y0 = i3;
        jn2.h hVar = this.K;
        if (hVar != null && hVar.getCount() != 0) {
            if (this.f283149y0 == 0) {
                Uh(false);
            }
            jn2.h hVar2 = this.K;
            if (hVar2 != null && hVar2.getCount() != 0 && (i16 = this.f283149y0) != 0 && i16 != 0 && this.G && !this.f283132h0 && !this.Q && Dh() < 20) {
                Rh(this.C);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Th();
        this.J.setOnTouchListener(new c());
    }

    @Override // lo2.an
    public void setFirstClickResultItemFlag(boolean z16) {
        this.f283143s0 = z16;
    }

    public synchronized void startSearch(String str) {
        double d16;
        double d17;
        if (this.P != null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w(B0, 2, "hash = " + hashCode() + "   startSearchTAB isEnd = true mask;" + Arrays.toString(this.f283136l0) + " key=" + str + "  name=" + this.f283148x0 + " isViewCreated" + this.G);
        }
        this.f283142r0 = 0;
        this.f283141q0 = 0;
        this.C = str;
        if (this.G) {
            if (getQBaseActivity() instanceof com.tencent.mobileqq.search.m) {
                d16 = ((com.tencent.mobileqq.search.m) getQBaseActivity()).getLat();
                d17 = ((com.tencent.mobileqq.search.m) getQBaseActivity()).getLon();
            } else {
                d16 = 0.0d;
                d17 = 0.0d;
            }
            this.f283131g0 = System.currentTimeMillis() + "";
            this.f283132h0 = true;
            Bundle bundle = new Bundle();
            if (getQBaseActivity() instanceof ActiveEntitySearchActivity) {
                ActiveEntitySearchActivity activeEntitySearchActivity = (ActiveEntitySearchActivity) getQBaseActivity();
                bundle.putInt("fromTypeForReport", activeEntitySearchActivity.f282650n0);
                bundle.putInt("searchAvatarFrom", activeEntitySearchActivity.f282662z0);
            }
            bundle.putBoolean(QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, false);
            bundle.putInt(IProfileCardConst.KEY_FROM_TYPE, this.f283133i0);
            Sh(str, getPublicAccountIdList(), null, d16, d17, bundle);
            Gh(false);
        } else {
            this.F = true;
            this.E = str;
            if (QLog.isColorLevel()) {
                QLog.i(B0, 2, "startSearch \u89e6\u53d1\u5ef6\u8fdf\u903b\u8f91");
            }
        }
    }
}
